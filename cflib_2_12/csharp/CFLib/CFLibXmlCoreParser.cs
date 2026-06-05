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
using System.IO;
using System.Net;
using System.Text;
using System.Xml;
using System.Xml.Schema;

namespace CFLib
{
	public abstract class CFLibXmlCoreParser : ICFLibXmlCoreContextFactory {

//	Constants

		/**
		 *	Constant for requesting the SAX2 parser API.
		 */
		public static String	API_SAX = "sax";

		/**
		 *	Constant for requesting the DOM parser API.
		 */
		public static String	API_DOM = "dom";

        //	Instance Attributes

        private ICFLibMessageLog log = null;
        public ICFLibMessageLog Log
        {
            get
            {
                return (log);
            }

            set
            {
                String S_ProcName = "Log.set";

                if( value == null )
                {
                    throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                        S_ProcName,
                        1,
                        "value");
                }

                log = value;
            }
        }

        /**
         * Satisfy ICFLibXmlCoreContextFactory interface.
         */
         public ICFLibMessageLog getLog()
        {
            return (log);
        }

        /**
         *  The name of the document being processed for messaging purposes.
         */
        private String documentName = "unspecified";
        public String DocumentName
        {
            get
            {
                return (documentName);
            }

            protected set
            {
                if( ( value == null ) || ( value.Length <= 0 ))
                {
                    throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                        "DocumentName.set",
                        1,
                        "value");
                }
                documentName = value;
            }
        }

        /**
         *  The most recent line number detected while processing the document.
         */
        private long documentLine = 0;
        public long DocumentLine
        {
            get
            {
                return (documentLine);
            }

            protected set
            {
                documentLine = value;
            }
        }

        public String NearLocation
        {
            get
            {
                return( "Near " + DocumentName + "[" + DocumentLine + "] " );
            }

            private set
            {
            }
        }

		/**
		 *	The root element handler for processing schema documents.
		 */
		private CFLibXmlCoreElementHandler rootElementHandler = null;

		/**
		 *	The processing of startDocument, endDocument,
		 *	startElement, and stopElement events maintains
		 *	the processing context stack of the parser.
		 */
		private volatile LinkedList<CFLibXmlCoreContext> contextStack = new LinkedList<CFLibXmlCoreContext>();
 
		/**
		 *	The Context factory to use.
		 *	<p>
		 *	If no context factory is ever specified, the default "this"
		 *	factory is used.
		 */
		private ICFLibXmlCoreContextFactory xmlCoreContextFactory = null;

//	Constructors

		/**
		 *	Construct a default parser.
		 */
		public CFLibXmlCoreParser() {
			this.
			log = null;
		}

		/**
		 *	Construct a default XmlCoreParser logging to the
		 *	specified Log4J log.
		 *
		 *	@param	jlog - Log4J log
		 */
		public CFLibXmlCoreParser( ICFLibMessageLog jlog ) {
            Debug.Assert( jlog != null );
			log = jlog;
		}

        //	Accessors: API

		/**
		 *	Get the API implemented.
		 */
		public abstract String getAPI();

        public String API
        {
            get
            {
                return (getAPI());
            }

            private set
            {
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    "API.set",
                    "This method is not to be invoked, as it is hard-coded based on which parsers base you inherit");
            }
        }

        /**
         *  Read a URI into a string.
         */
        public static String readURI(String uri)
        {
            using (var response = WebRequest.Create(uri).GetResponse())
            using (var stream = response.GetResponseStream())
            using (var reader = new StreamReader(stream))
                return (reader.ReadToEnd());
        }

        //	Accessors: RootElementHandler
		
		/**
		 *	Get the element handler for processing the document root.
		 *
		 *	@return	The root element handler
		 */
		public CFLibXmlCoreElementHandler getRootElementHandler() {
			return( rootElementHandler );
		}
		
		/**
		 *	Set the element handler for processing the document root.
		 *
		 *	@param	handler	The root element handler to use.
		 */
		protected void setRootElementHandler( CFLibXmlCoreElementHandler handler ) {
            Debug.Assert( handler != null );
			rootElementHandler = handler;
		}

//	Accessors: CurContext

		/**
		 *	Get the top element handler on the stack, used to locate the
		 *	handler for a sub-element.
		 *
		 *	@return	The top element handler on the stack.
		 */
		public CFLibXmlCoreContext getCurContext() {
			if( contextStack.Count <= 0 ) {
				return( null );
			}
			
			CFLibXmlCoreContext curContext = contextStack.Last.Value;
			return( curContext );
		}

//	Accessors: XmlCoreContextFactory
		
		/**
		 *	Get the context factory to use.
		 *
		 *	@return	The context factory to use.
		 */
		public ICFLibXmlCoreContextFactory getXmlCoreContextFactory() {
			return( xmlCoreContextFactory );
		}

		/**
		 *	Set the context factory to use.
		 *
		 *	@param	factory	The context factory to use.	
		 */
		public void setXmlCoreContextFactory( ICFLibXmlCoreContextFactory factory ) {
            Debug.Assert( factory != null );
			xmlCoreContextFactory = factory;
		}

//	XmlCoreContextFactory Interface

		/**
		 *	Copy an XML Core Context.
		 *
		 *	@param	src	The context to copy.
		 *	@param	qName	The QName of the element about to be processed.
		 *	@param	handler	The XmlCoreElementHandler which will be used for processing.
		 */
		public CFLibXmlCoreContext newXmlCoreContext(
			CFLibXmlCoreContext src,
			String qName,
			CFLibXmlCoreElementHandler handler )
		{
			CFLibXmlCoreContext retval;
			if( ( xmlCoreContextFactory != null ) && ( xmlCoreContextFactory != this ) ) {
				retval = xmlCoreContextFactory.newXmlCoreContext( src, qName, handler );
			}
			else {
				retval = new CFLibXmlCoreContext( src, qName, handler );
			}
			
			return( retval );
		}

		/**
		 *	Construct a "root" XML Core Context instance.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 *	@param	jlog	Log4J log to use, if null, use parser's log.
		 *	@param	handler	The XmlCoreElementHandler which will be processing the doc root.
		 */
		public CFLibXmlCoreContext newXmlCoreContext(
			CFLibXmlCoreParser coreParser,
			ICFLibMessageLog jlog,
			CFLibXmlCoreElementHandler elementHandler )
		{
			CFLibXmlCoreContext retval;
			if( ( xmlCoreContextFactory != null ) && ( xmlCoreContextFactory != this ) ) {
				retval = xmlCoreContextFactory.newXmlCoreContext( coreParser, jlog, elementHandler );
			}
			else {
				retval = new CFLibXmlCoreContext( coreParser, jlog, elementHandler );
			}
			return( retval );
		}

        /**
		 *	Format the error stack for the specified exception.
		 *
		 *	@param	ex - XmlException to report.
		 *
		 *	@return	The formatted error stack.
		 */
        protected String formatMessage( XmlException ex ) {
			StringBuilder buff = new StringBuilder();

			String systemId = ex.Source;
			if ((systemId != null) && (systemId.Length > 0)) {
				int index = systemId.LastIndexOf('\\');
                if (index != -1)
                {
                    systemId = systemId.Substring(index + 1);
                }
                else
                {
                    index = systemId.LastIndexOf('/');
                    if (index != -1)
                    {
                        systemId = systemId.Substring(index + 1);
                    }
                }
                buff.Append(systemId);
            }

            buff.Append( '[' );
			buff.Append( ex.LineNumber );
			buff.Append( ',');
			buff.Append( ex.LinePosition );
			buff.Append( "]: " );
			buff.Append( ex.Message );
			buff.Append( '\n' );

			return( buff.ToString() );
		}

        //	ContentHandler Interface

        /**
		 *	Receive notification of the beginning of an element.
		 */
        public void startElement(XmlReader reader)
		{
            String S_ProcName = "startElement";

			CFLibXmlCoreContext curContext;
			if( contextStack.Count <= 0 ) {
				CFLibXmlCoreElementHandler rootHandler = getRootElementHandler();
				Debug.Assert( rootHandler != null );
				CFLibXmlCoreContext rootContext = new CFLibXmlCoreContext( this, getLog(), rootHandler );
				contextStack.AddLast( rootContext );
			}

			CFLibXmlCoreContext prev = contextStack.Last.Value;
			if( prev == null ) {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException( this.GetType(),
                    S_ProcName,
                    0,
                    "ContextStack.top" );
			}

			CFLibXmlCoreElementHandler prevHandler = prev.getElementHandler();
			if( prevHandler == null ) {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    0,
                    "ContextStack.top.ElementHandler");
            }

            String qName = reader.Name;

            CFLibXmlCoreElementHandler curHandler = prevHandler.getElementHandler( qName );
			if( curHandler == null ) {
				throw CFLib.DefaultExceptionFactory.newRuntimeException( "ContextStack.top.ElementHandler<"
					+ prevHandler.GetType().Namespace + prevHandler.GetType().Name + ">.getElementHandler( \""
					+ qName + "\" ) has no such mapping" );
			}

			curContext = new CFLibXmlCoreContext( prev, qName, curHandler );

			contextStack.AddLast( curContext );

			curHandler.startElement( reader );
		}


		/**
		 *	Receive notification of the end of an element.
		 */
		public void endElement( XmlReader reader)
		{
			Debug.Assert( contextStack.Count > 0 );

			CFLibXmlCoreContext curContext = contextStack.Last.Value;
			CFLibXmlCoreElementHandler curHandler = curContext.getElementHandler();

			try {
				curHandler.endElement( reader );
			}
			finally {
				contextStack.RemoveLast();
			}
		}

		
		/**
		 *	Receive notification of character data.
		 */
		protected void processText( XmlReader reader )
		{
            // MSS TODO WORKING I'm not sure how to proceed here.  I need to find sample code.
            if( ! reader.HasValue ) {
				return;
			}

			getCurContext().appendElementText( reader.Value );
		}

        //	Protected Methods

        /**
		 *	Append the document locator information to the specified StringBuilder.
		 *
		 *	@param	buff - The StringBuilder to receive document locator information.
		 *
		 *	@return	The specified buffer to enable functional chaining.
		 */
        public StringBuilder appendLocatorInformation(StringBuilder buff) {

            buff.Append(DocumentName);

            long line = DocumentLine;
            if (line >= 0) {
                buff.Append("[" + line + "]");
            }

			return( buff );
		}

		/**
		 *	Initialize the parser schema.
		 *	<p>
		 *	Load the XSDs for documents accepted by the parser.
		 */
		protected void initParser() {
            Debug.Assert( log != null );
            Debug.Assert( rootElementHandler != null );
		}
	}
}
