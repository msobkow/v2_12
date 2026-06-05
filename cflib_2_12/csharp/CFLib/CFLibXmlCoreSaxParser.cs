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
using System.Diagnostics;
using System.Globalization;
using System.IO;
using System.Text;
using System.Xml;
using System.Xml.Schema;

namespace CFLib
{
    public class CFLibXmlCoreSaxParser : CFLibXmlCoreParser {

        //  Class/Process Attributes

        private static XmlSchemaSet xmlSchemaSet = null;
        public static XmlSchemaSet SchemaSet
        {
            get
            {
                String S_ProcName = "SchemaSet.get";

                if( xmlSchemaSet == null )
                {
                    xmlSchemaSet = new XmlSchemaSet();
                }

                if( xmlSchemaSet == null )
                {
                    throw CFLib.DefaultExceptionFactory.newNullArgumentException(typeof(CFLibXmlCoreSaxParser),
                        S_ProcName,
                        0,
                        "xmlSchemaSet");
                }

                return (xmlSchemaSet);
            }

            private set
            {
                String S_ProcName = "SchemaSet.set";
                throw CFLib.DefaultExceptionFactory.newRuntimeException(typeof(CFLibXmlCoreSaxParser),
                    S_ProcName,
                    "Only one auto-created instance is permitted");
            }
        }

        /**
         *  SAX parsers always define themselves as such.
         */
        public override String getAPI()
        {
            return (API_SAX);
        }

        //	Instance Attributes

        private XmlReaderSettings xmlReaderSettings = null;
        public XmlReaderSettings ReaderSettings
        {
            get
            {

                String S_ProcName = "ReaderSettings.get";

                if (xmlReaderSettings == null)
                {
                    initReaderSettings();
                }

                if (xmlReaderSettings == null)
                {
                    throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                        S_ProcName,
                        0,
                        "xmlReaderSettings");
                }

                return (xmlReaderSettings);
            }

            private set
            {
                String S_ProcName = "ReaderSettings.set";
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    S_ProcName,
                    "Only one auto-created instance is permitted");
            }
        }

        private XmlReader xmlReader = null;
        protected XmlReader Reader
        {
            get
            {
                return (xmlReader);
            }

            set
            {
                String S_ProcName = "Reader.set";

                if(value == null)
                {
                    throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                        S_ProcName,
                        1,
                        "value");
                }
                xmlReader = value;
            }
        }

//	Constructors

		/**
		 *	Construct a default parser.
		 */
		public CFLibXmlCoreSaxParser()
        : base()
        {
		}

		/**
		 *	Construct a default XmlCoreParser logging to the
		 *	specified Logger.
		 */
		public CFLibXmlCoreSaxParser( ICFLibMessageLog logger )
        : base( logger )
        {
		}

        /**
         * The user is expected to override this implementation, invoking the
         * base implementation before calling addSchema() to add schema definitions
         * to the schema set to be used by the SAX parser.
         * 
         * If invoked more than once, this method just returns without touching anything.
         */
        protected void initSchemaSet()
        {
            if (xmlSchemaSet != null)
            {
                return;
            }

            xmlSchemaSet = new XmlSchemaSet();
        }

        /**
         *  Add an XSD schema document to the schema set (preferred method.)
         */
        public void addSchema(String targetNamespace, XmlReader schemaDocument)
        {
            String S_ProcName = "addSchema";

            if ((targetNamespace == null) || (targetNamespace.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    1,
                    "targetNamespace");
            }

            if (schemaDocument == null)
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    2,
                    "schemaDocument");
            }

            if (xmlSchemaSet == null)
            {
                initSchemaSet();
            }

            if (xmlSchemaSet == null)
            {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    0,
                    "xmlSchemaSet");
            }

            xmlSchemaSet.Add(targetNamespace, schemaDocument);
        }

        /**
         * Add a schemaURI to the schema set (alternative method.)
         */
        public void addSchema(String targetNamespace, String schemaUri)
        {
            String S_ProcName = "addSchema";

            if ((targetNamespace == null) || (targetNamespace.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    1,
                    "targetNamespace");
            }

            if ((schemaUri == null) || (schemaUri.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    2,
                    "schemaURI");
            }

            if (xmlSchemaSet == null)
            {
                initSchemaSet();
            }

            if (xmlSchemaSet == null)
            {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    0,
                    "xmlSchemaSet");
            }

            xmlSchemaSet.Add(targetNamespace, schemaUri);
        }

        /**
         * You shouldn't be overloading this -- use the member accessors to modify
         * the reader settings after they've been instantiated and initialized.
         */
        protected void initReaderSettings()
        {
            String S_ProcName = "initReaderSettings";

            if (xmlReaderSettings != null)
            {
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    S_ProcName,
                    "xmlReaderSettings is not null");
            }

            initSchemaSet();

            if (xmlReaderSettings != null)
            {
                return;
            }

            xmlReaderSettings = new XmlReaderSettings();
            xmlReaderSettings.IgnoreWhitespace = false;
            xmlReaderSettings.IgnoreComments = false;
            xmlReaderSettings.ValidationFlags = XmlSchemaValidationFlags.ProcessInlineSchema
                | XmlSchemaValidationFlags.ProcessSchemaLocation
                | XmlSchemaValidationFlags.ReportValidationWarnings;
            xmlReaderSettings.ValidationType = ValidationType.Schema;
            xmlReaderSettings.Schemas = SchemaSet;
        }

        protected void releaseReader()
        {
            initSchemaSet();
            initReaderSettings();

            if (xmlReader != null)
            {
                try
                {
                    xmlReader.Close();
                    xmlReader.Dispose();
                }
                catch( Exception )
                {
                }
                xmlReader = null;
            }
		}

        /**
		 *	Parse the specified stream reader.
		 *
		 *	@param	reader - The inputStream for the document to parse.
		 */
        protected void parse(String streamName, StreamReader reader)
        {
            String S_ProcName = "parse-StreamReader";

            if ((streamName == null) || (streamName.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    1,
                    "streamName");
            }

            if( reader == null )
            {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    2,
                    "reader");
            }

            releaseReader();

            DocumentName = streamName;

            if (xmlReader != null)
            {
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    S_ProcName,
                    "xmlReader is not null");
            }

            try
            {
                xmlReader = XmlReader.Create(reader, xmlReaderSettings);
                while( xmlReader.Read())
                {
                    // MSS TODO WORKING Now how to process the parse and analyze the results?

                    switch ( xmlReader.NodeType)
                    {
                        case XmlNodeType.Element:
                            startElement(xmlReader);
                            break;
                        case XmlNodeType.Text:
                            processText(xmlReader);
                            break;
                        case XmlNodeType.EndElement:
                            endElement(xmlReader);
                            break;
                    }
                }
            }
            catch( XmlException e )
            {
                String msg = formatMessage(e);
                if( Log != null )
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
                else
                {
                    System.Console.Write("CFLibXmlCoreSaxParser.parse() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
            }
            catch (CFLibRuntimeException e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message + "\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parse() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            catch (FileNotFoundException)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Could not find file \"" + DocumentName + "\"\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parse() Could not find file \"" + DocumentName + "\"");
                }
            }
            catch (Exception e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parser() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parser() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            releaseReader();
        }

        /**
		 *	Parse the specified URI
		 *
		 *	@param	uri - The URI for the document to parse.
		 */
        protected void parse(String uri)
        {
            String S_ProcName = "parse-URI";

            if ((uri == null) || (uri.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    1,
                    "uri");
            }

            releaseReader();

            if (xmlReader != null)
            {
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    S_ProcName,
                    "xmlReader is not null");
            }

            DocumentName = uri;

            try
            {
                String documentContents = readURI(uri);

                byte[] bytes = Encoding.UTF8.GetBytes(documentContents);

                MemoryStream stream = new MemoryStream(bytes);

                StreamReader streamReader = new StreamReader(stream);

                parse(uri, streamReader);
            }
            catch (XmlException e)
            {
                String msg = formatMessage(e);
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
                else
                {
                    System.Console.Write("CFLibXmlCoreSaxParser.parse() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
            }
            catch (CFLibRuntimeException e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message + "\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parse() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            catch (FileNotFoundException)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parse() Could not find file \"" + DocumentName + "\"\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parse() Could not find file \"" + DocumentName + "\"");
                }
            }
            catch (Exception e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parser() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message );
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parser() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            releaseReader();
        }

        /**
		 *	Parse the specified string contents.
		 *	<p>
		 *	The string passed to this method is typically
		 *	a request or response XML document to be processed
		 *	by an appropriate parser and applied to a storage
		 *	server layer.
		 *
		 *	@param	str The string contents to be parsed.
		 */
        public void parseStringContents(String stringName, String str)
        {
            String S_ProcName = "parseStringContents";

            if ((stringName == null) || (stringName.Length <= 0))
            {
                throw CFLib.DefaultExceptionFactory.newEmptyArgumentException(this.GetType(),
                    S_ProcName,
                    1,
                    "stringName");
            }

            if (str == null)
            {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(this.GetType(),
                    S_ProcName,
                    2,
                    "str");
            }

            DocumentName = stringName;

            releaseReader();

            if (xmlReader != null)
            {
                throw CFLib.DefaultExceptionFactory.newRuntimeException(this.GetType(),
                    S_ProcName,
                    "xmlReader is not null");
            }

            DocumentName = stringName;

            try
            {
                byte[] bytes = Encoding.UTF8.GetBytes(str);

                MemoryStream stream = new MemoryStream(bytes);

                StreamReader streamReader = new StreamReader(stream);

                parse(stringName, streamReader);
            }
            catch (XmlException e)
            {
                String msg = formatMessage(e);
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parseStringContents() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
                else
                {
                    System.Console.Write("CFLibXmlCoreSaxParser.parseStringContents() Ignored XmlException " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + msg);
                }
            }
            catch (CFLibRuntimeException e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parseStringContents() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message + "\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parseStringContents() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            catch (FileNotFoundException)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parseStringContents() Could not find file \"" + DocumentName + "\"\n");
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parse() Could not find file \"" + DocumentName + "\"");
                }
            }
            catch (Exception e)
            {
                if (Log != null)
                {
                    Log.message("CFLibXmlCoreSaxParser.parseStringContents() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
                else
                {
                    System.Console.WriteLine("ERROR: CFLibXmlCoreSaxParser.parseStringContents() Ignored exception " + NearLocation + e.GetType().Namespace + "." + e.GetType().Name + " " + e.Message);
                }
            }
            releaseReader();
        }
    }
}
