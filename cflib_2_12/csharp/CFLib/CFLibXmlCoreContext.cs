/*
 *  MSS Code Factory CFLib 2.11
 *
 *	Copyright (c) 2019 Mark Stephen Sobkow
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *		http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Text;

namespace CFLib
{
	public class CFLibXmlCoreContext {

		/**
		 *	Context stack chain.
		 *	<p>
		 *	This had been handled via Java collections, but that
		 *	made the access of stack top - 1 inefficient.
		 */
		private CFLibXmlCoreContext prevContext = null;

		/**
		 *	The StringBuilder to receive character event data.
		 */
		private StringBuilder elementText = new StringBuilder();

		/**
		 *	The XmlCoreElementHandler selected to handle the
		 *	beginElement and endElement events.
		 */
		private CFLibXmlCoreElementHandler elementHandler = null;

		/**
		 *	The Log4J log to receive parser processing messages.
		 *	<p>
		 *	Programmer debug and trace messages should go to <tt>debuglog</tt>.
		 */
		private ICFLibMessageLog log = null;

		/**
		 *	The XML Core Parser which owns this processing Context.
		 */
		private CFLibXmlCoreParser parser = null;

		/**
		 *	The QName of the element being processed.
		 */
		private String elementQName = null;

		/**
		 *	Named attribute map.  Used to retain startElement data for use in endElement.
		 */
		private Dictionary<String,Object> valueMap = new Dictionary<String,Object>();

//	Constructors

		/**
		 *	Copy and link an XML Core Context.
		 *	<p>
		 *	The specified source element becomes the PrevContext.
		 *
		 *	@param	src	The context to copy.
		 *	@param	qName	The QName of the element about to be processed.
		 *	@param	handler	The XmlCoreElementHandler which will be used for processing.
		 */
		public CFLibXmlCoreContext(
			CFLibXmlCoreContext src,
			String qName,
			CFLibXmlCoreElementHandler handler )
		{
			Debug.Assert( src != null );

			prevContext = src;
			setElementHandler( src.getElementHandler() );
			setLog( src.getLog() );
			setParser( src.getParser() );
			setQNameElementHandler( qName, handler );
		}

		/**
		 *	Construct a "root" XML Core Context instance.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 *	@param	jlog	Log4J log to use, if null, use parser's log.
		 *	@param	handler	The XmlCoreElementHandler which will be processing the doc root.
		 */
		public CFLibXmlCoreContext(
			CFLibXmlCoreParser coreParser,
			ICFLibMessageLog jlog,
			CFLibXmlCoreElementHandler elementHandler )
		{
            Debug.Assert( coreParser != null );
            Debug.Assert( elementHandler != null );
			
			prevContext = null;
			
			setParser( coreParser );
			
			if( jlog != null ) {
				setLog( jlog );
			}
			else {
				setLog( coreParser.getLog() );
			}

			setQNameElementHandler( ".", elementHandler );
		}

        //	Accessors: PrevContext

		/**
		 *	Get the previous context in the stack.
		 *
		 *	@return	The previous context or null if this is
		 *			the bottom of the stack.
		 */
		public CFLibXmlCoreContext getPrevContext() {
			return( prevContext );
		}

        //	Accessors: ValueMap

		/**
		 *	Is there a mapping for the named value slot?
		 *
		 *	@param	name	The name of the object
		 *
		 *	@return	True if there is a mapping for the name.
		 */
		public Boolean hasNamedValue( String key ) {
			Boolean retval = valueMap.ContainsKey( key );
			return( retval );
		}
		
		/**
		 *	Get the object for the named value slot.
		 *
		 *	@param	name	The name of the object
		 *	@return	The object associated with the name or null.
		 */
		public Object getNamedValue( String key ) {
			Object retval = valueMap[key];
			return( retval );
		}
		
		/**
		 *	Put a named value.
		 *
		 *	@param	name	The name of the object
		 *	@param	value	The object to store for the name
		 *
		 *	@return	The object previously associated with the name or null
		 */
		public Object putNamedValue( String key, Object value ) {
            Object retval = null;
            if( valueMap.ContainsKey( key ) )
            {
                retval = valueMap[key];
            }

			valueMap.Add( key, value );

			return( retval );
		}

        //	Accessors: Parser

		/**
		 *	Get the XML Core Parser which owns this element handler.
		 *
		 *	@return	The XML Core Parser which owns this element handler.
		 */
		public CFLibXmlCoreParser getParser() {
			return( parser );
		}

		/**
		 *	Set the XML Core Parser which owns this element handler.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		protected void setParser( CFLibXmlCoreParser coreParser ) {
            Debug.Assert( coreParser != null );
			parser = coreParser;
		}

        //	Accessors: log

		/**
		 *	Get the runtime processing log.
		 *
		 *	@return	Log4J log
		 */
		public ICFLibMessageLog getLog() {
			if( log != null ) {
				return( log );
			}
			if( parser != null ) {
				return( parser.getLog() );
			}
			return( null );
		}

		/**
		 *	Set the runtime processing log.
		 *
		 *	@param	jlog	The log to use for runtime processing messages
		 */
		public void setLog( ICFLibMessageLog jlog ) {
			log = jlog;
		}

        //	Accessors: ElementText
		
		/**
		 *	Get the ElementText for the current context.
		 *
		 * 	@return	The element text collected so far.
		 */
		public String getElementText() {
			return( elementText.ToString() );
		}

		/**
		 *	Append a character segment to the element text.
		 */
        public void appendElementText( String str )
        {
            elementText.Append(str);
        }

		public void appendElementText( char[] ch, int start, int length ) {
			elementText.Append( ch, start, length );
		}

        //	Accessors: ElementHandler

		/**
		 *	Retrieve the element handler for this processing context.
		 *
		 *	@return	The element handler selected for processing the current element.
		 */
		public CFLibXmlCoreElementHandler getElementHandler() {
			return( elementHandler );
		}

		/**
		 *	Set the element handler for this processing context.
		 *
		 *	@param	handler	The XmlCoreElementHandler selected to process the element.
		 */
		protected void setElementHandler( CFLibXmlCoreElementHandler handler ) {
            Debug.Assert( handler != null );
			elementHandler = handler;
		}

		/**
		 *	Set the element handler and QName for this processing context.
		 *
		 *	@param	qName	The QName of the element or document being processed.
		 *	@param	handler	The XmlCoreElementHandler selected to process the element.
		 */
		public void setQNameElementHandler( String qName, CFLibXmlCoreElementHandler handler ) {
            Debug.Assert( elementQName == null );
            Debug.Assert( qName != null && qName.Length > 0 );
            Debug.Assert( handler != null );
			elementHandler = handler;
			elementQName = qName;
		}
	}
}
