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
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Xml;

namespace CFLib
{
	public abstract class CFLibXmlCoreElementHandler {

		/**
		 *	The XML Core Parser which owns this Element Handler.
		 */
		private CFLibXmlCoreParser parser = null;

		/**
		 *	The Dictionary by Name for resolving sub-element handlers.
		 */
		private Dictionary<String,CFLibXmlCoreElementHandler> elementHandler = new Dictionary<String,CFLibXmlCoreElementHandler>();

//	Constructors

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public CFLibXmlCoreElementHandler( CFLibXmlCoreParser coreParser ) {
            Debug.Assert( coreParser != null );
			setParser( coreParser );
		}

//	Accessors: Logger
		
		/**
		 *	Get the Log4J Logger for processing messages.
		 *
		 *	@return	Logger
		 */
		public ICFLibMessageLog getLog() {
			CFLibXmlCoreContext context = ( parser != null ) ? parser.getCurContext() : null;
			ICFLibMessageLog retval = ( context != null ) ? context.getLog() : null;
			if( retval == null ) {
				if( parser != null ) {
					retval = parser.getLog();
				}
			}
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

//	Accessors: ElementHandler

		/**
		 *	Add an element handler to be invoked when the named sub-element QName
		 *	is encountered.
		 *
		 *	@param	qName	The QName to map to the handler
		 *	@param	handler	The XmlCoreElementHandler to process the element events.
		 */
		public void addElementHandler( String qName, CFLibXmlCoreElementHandler handler ) {
			Debug.Assert( qName != null && qName.Length > 0 );
            Debug.Assert( handler != null );
            Debug.Assert( ! elementHandler.ContainsKey( qName ) );
			elementHandler.Add( qName, handler );
		}

		/**
		 *	Locate the named element handler.
		 *
		 *	@param	qName	The QName used to locate the handler.
		 *	@return	The XmlCoreElementHandler mapped to the specified name or null.
		 */
		public CFLibXmlCoreElementHandler getElementHandler( String qName ) {
			CFLibXmlCoreElementHandler retval = elementHandler[qName];
			return( retval );
		}

        //	Element Event Handlers

        /**
		 *	Receive notification of the beginning of an element.
         */
        public abstract void startElement(XmlReader reader);


        /**
		 *	Receive notification of the end of an element.
		 */
        public abstract void endElement(XmlReader reader);
	}
}
