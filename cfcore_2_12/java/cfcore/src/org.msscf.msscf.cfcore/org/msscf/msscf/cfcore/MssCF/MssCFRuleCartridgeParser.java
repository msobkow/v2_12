/*
 *	MSS Code Factory CFCore 2.12
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *
 *	This file is part of MSS Code Factory.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 */

package org.msscf.msscf.cfcore.MssCF;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.MssCF.MssCFRuleSetParser.RootHandler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.xerces.xni.grammars.Grammar;
import org.apache.xerces.xni.grammars.XMLGrammarPool;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.parsers.XMLGrammarPreparser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *	A RuleCartridgeParser is a JAXP 1.3 Validating XML parser
 *	for documents conforming to the MSS Generator Knowledge Base
 *	Rule Cartridge schema.
 *
 *	@see	http://generator.msobkow.com/xsd/genkb-1.0.6-cartridge.
 */
public class MssCFRuleCartridgeParser extends MssCFSaxParser implements ContentHandler {

	/**
	 *	The namespace URI of the supported schema
	 */
	public final static String	SCHEMA_XMLNS = "uri://org.msscf/msscf/2.0.12/xsd/cfgenkb-2.12-cartridge";

	/**
	 *	The source for loading the supported schema
	 */
	public final static String	SCHEMA_URI = "/opt/msscf/2.0.12/xsd/cfgenkb-2.12-cartridge.xsd";
	public final static String	SCHEMA_ROOT_URI = "/xsd/cfgenkb-2.12-cartridge.xsd";

	/**
	 *	The debugLogger is a Log4J reference used to configure and dump
	 *	debug and tracing information.  The parameter logger retained by
	 *	instances of XmlCoreSaxParser is used for processing messages.
	 */
	protected static Logger debugLogger = Logger.getLogger( MssCFRuleCartridgeParser.class );

	/**
	 *	The directories containing XML Rule Cartridges
	 */
	protected static ArrayList cartridgePath = new ArrayList();

	/**
	 *	The RuleCartridge names that were loaded.
	 */
	private static Map ruleCartridgeNames = new HashMap();

	/**
	 *	The ToolSet names in the order they were defined by the cartridges
	 *	loaded by a JVM.
	 */
	private static Vector toolSetNames = new Vector();

	/**
	 *	The ToolSetParser is reused.
	 */
	private MssCFToolSetParser toolSetParser = null;

	/**
	 *	The parent parser performing a UseCartridge
	 */
	private MssCFRuleCartridgeParser parentParser = null;

	protected static Grammar myGrammar = null;

//	Constructors

	public MssCFRuleCartridgeParser( MssCFEngine engine, ICFLibMessageLog log ) {
		super( engine, log );
		// Deprecated by Log4J 2 debugLogger.setLevel( Level.INFO );
		setRootElementHandler( new RootHandler( this ) );
		parentParser = null;
		if( myGrammar == null ) {
			InputStream input;
			File file = new File( SCHEMA_URI );
			if( file.exists() ) {
				try {
					input = new FileInputStream( file );
				}
				catch( Exception e ) {
					input = null;
				}
				if( input != null ) {
					myGrammar = addToGrammarPool( SCHEMA_URI, input );
				}
			}
			else {
				input = getClass().getResourceAsStream( SCHEMA_ROOT_URI );
				if( input != null ) {
					myGrammar = addToGrammarPool( SCHEMA_ROOT_URI, input );
				}
			}
		}
		initParser();
		parentParser = null;
		toolSetParser = new MssCFToolSetParser( getEngine(), getLog() );
	}

	/**
	 *	Construct a sub-parser for handling UseCartridge directives.
	 *
	 *	@param	parser	The invoking RuleCartridge parser.
	 */
	public MssCFRuleCartridgeParser( MssCFRuleCartridgeParser parser ) {
		super( parser.getEngine(), parser.getLog() );
		// Deprecated by Log4J 2 debugLogger.setLevel( Level.INFO );
		setRootElementHandler( new RootHandler( this ) );
		parentParser = parser;
		if( myGrammar == null ) {
			InputStream input;
			File file = new File( SCHEMA_URI );
			if( file.exists() ) {
				try {
					input = new FileInputStream( file );
				}
				catch( Exception e ) {
					input = null;
				}
				if( input != null ) {
					myGrammar = addToGrammarPool( SCHEMA_URI, input );
				}
			}
			else {
				input = getClass().getResourceAsStream( SCHEMA_ROOT_URI );
				if( input != null ) {
					myGrammar = addToGrammarPool( SCHEMA_ROOT_URI, input );
				}
			}
		}
		initParser();

		toolSetParser = new MssCFToolSetParser( getEngine(), getLog() );
	}

//	JVM Config: CartridgePath

	/**
	 *	Add an XML rule cartridge directory the cartridge path.
	 */
	@SuppressWarnings("unchecked")
	public static void addCartridgePath( String dirname ) {
		assert ( ( dirname != null ) && ( dirname.length() > 0 ) ) : "dirname (arg 1) is null or empty";
		Iterator iter = cartridgePath.iterator();
		while( iter.hasNext() ) {
			String match = (String)iter.next();
			if( dirname.equals( match ) ) {
				return;
			}
		}
		cartridgePath.add( new String( dirname ) );
	}

	/**
	 *	Get an iteration of the cartridge path directories.
	 *
	 *	@return Iteration of Strings.
	 */
	public static Iterator getCartridgePathIterator() {
		Iterator iter = cartridgePath.iterator();
		return( iter );
	}

//	Runtime: Load a RuleCartridge

	/**
	 *	Load a RuleCartridge.
	 *
	 *	@param	cartridgeName	The name of the cartridge to be loaded
	 */
	public void loadRuleCartridge( String cartridgeName ) {

//		Get the cartridge path to be searched

		String ruleCartridgeFileName = null;
		String ruleCartridgeRootDir = null;
		InputStream ruleCartridgeManifestXml = null;

		Iterator iterPath = getCartridgePathIterator();
		while( ( ruleCartridgeManifestXml == null ) && iterPath.hasNext() ) {

			String cartridgeDir = (String)iterPath.next();
			int cartridgeDirLen = cartridgeDir.length();
			assert cartridgeDirLen > 0 : "CartridgeDir entry is empty";
			char cartridgeDirTail = cartridgeDir.charAt( cartridgeDirLen - 1 );
			if( ( cartridgeDirTail == '/' ) || ( cartridgeDirTail ==  '\\' ) ) {
				ruleCartridgeRootDir = new String( cartridgeDir + cartridgeName + File.separator );
			}
			else {
				ruleCartridgeRootDir = new String( cartridgeDir + File.separator + cartridgeName + File.separator );
			}

			ruleCartridgeFileName = ruleCartridgeRootDir + "rulecartridge.xml";
			if( ruleCartridgeRootDir.startsWith( "jar:" ) ) {
				try {
					URL url = new URL( ruleCartridgeFileName );
					if( url != null ) {
						ruleCartridgeManifestXml = url.openStream();
						if( ruleCartridgeManifestXml == null ) {
							ruleCartridgeFileName = null;
							ruleCartridgeRootDir = null;
						}
					}
				}
				catch( MalformedURLException e ) {
					ruleCartridgeManifestXml = null;
					ruleCartridgeFileName = null;
					ruleCartridgeRootDir = null;
				}
				catch( IOException e ) {
					ruleCartridgeManifestXml = null;
					ruleCartridgeFileName = null;
					ruleCartridgeRootDir = null;
				}

			}
			else {
				try {
					ruleCartridgeManifestXml = new FileInputStream( ruleCartridgeFileName );
				}
				catch( FileNotFoundException e ) {
					ruleCartridgeManifestXml = null;
					ruleCartridgeFileName = null;
					ruleCartridgeRootDir = null;
				}
			}
		}

//		If we didn't find it yet, try a resource search

		if( ruleCartridgeManifestXml == null ) {
			String resName = "/cartridge-1.11/" + cartridgeName + "/rulecartridge.xml";
			URL url = cfEngine.getClass().getResource( resName );
			if( url != null ) {
				String urlString = url.toString();
				int lastSlash = urlString.lastIndexOf( '/' );
				ruleCartridgeRootDir = urlString.substring( 0, lastSlash );
				ruleCartridgeManifestXml = cfEngine.getClass().getResourceAsStream( urlString );
			}
			else {
				resName = "cartridge-1.11/" + cartridgeName + "/rulecartridge.xml";
				url = cfEngine.getClass().getResource( resName );
				if( url != null ) {
					String urlString = url.toString();
					int lastSlash = urlString.lastIndexOf( '/' );
					ruleCartridgeRootDir = urlString.substring( 0, lastSlash );
					ruleCartridgeManifestXml = cfEngine.getClass().getResourceAsStream( urlString );
				}
			}
		}

//		Did we find the cartridge?

		if( ruleCartridgeManifestXml == null ) {
			throw new RuntimeException( new FileNotFoundException( "Could not locate Rule Cartridge \"" + cartridgeName + "\"" ) ); 
		}

//		Parse the cartridge

		try {
			parse( ruleCartridgeManifestXml, ruleCartridgeRootDir );
		}
		finally {
			try {
				ruleCartridgeManifestXml.close();
			}
			catch( Exception e ) {
				throw new RuntimeException( getLocationInfo() + "Could not close Rule Cartridge \"" + cartridgeName + "\"", e ); 
			}
		}
	}

//	Accessors: ToolSetNames

	/**
	 *	Get the list of ToolSet names for the cartridge.
	 *
	 *	@return	String array of ToolSet names
	 */
	public static String[] getToolSetNames() {
		int numElts = toolSetNames.size();
		if( numElts <= 0 ) {
			return null;
		}

		String retval[] = new String[ numElts ];
		for( int idx = 0; idx < numElts; idx ++ ) {
			retval[idx] = new String( (String)toolSetNames.get( idx ) );
		}

		return( retval );
	}

	/**
	 *	Reset the list of ToolSet names.
	 */
	public static void resetToolSetNames() {
		toolSetNames.clear();
	}

	/**
	 *	Add a ToolSet name.
	 *
	 *	@param	name	The name of the ToolSet to add to the list.
	 */
	@SuppressWarnings("unchecked")
	public static String addToolSetName( String name ) {
		assert name != null;
		String ret;
		Iterator iter = toolSetNames.iterator();
		while( iter.hasNext() ) {
			ret = (String)iter.next();
			if( name.equals( ret ) ) {
				return( ret );
			}
		}
		ret = new String( name );
		toolSetNames.add( ret );
		return( ret );
	}

//	Accessors: RuleCartridgeNames

	/**
	 *	Get the list of RuleCartridge names for the cartridge.
	 *
	 *	@return	String array of RuleCartridge names
	 */
	public static String[] getRuleCartridgeNames() {
		int numElts = ruleCartridgeNames.size();
		if( numElts <= 0 ) {
			return null;
		}

		String retval[] = new String[ numElts ];
		for( int idx = 0; idx < numElts; idx ++ ) {
			retval[idx] = new String( (String)ruleCartridgeNames.get( idx ) );
		}

		return( retval );
	}

	/**
	 *	Reset the list of RuleCartridge names.
	 */
	public static void resetRuleCartridgeNames() {
		ruleCartridgeNames.clear();
	}

	/**
	 *	Add a RuleCartridge name.
	 *
	 *	@param	name	The name of the RuleCartridge to add to the list.
	 */
	@SuppressWarnings("unchecked")
	public static String addRuleCartridgeName( String name ) {
		assert name != null;
		String ret;
		Iterator iter = ruleCartridgeNames.keySet().iterator();
		while( iter.hasNext() ) {
			ret = (String)iter.next();
			if( name.equals( ret ) ) {
				return( ret );
			}
		}
		ret = new String( name );
		ruleCartridgeNames.put( ret, ret );
		return( ret );
	}

	/**
	 *	Was the specified RuleCartridge name loaded?
	 *
	 *	@param	name	The name of the RuleCartridge to check for
	 *
	 *	@return	True if the specified name was previously loaded.
	 */
	public static boolean isRuleCartridgeNameLoaded( String name ) {
		if( ruleCartridgeNames.containsKey( name ) ) {
			return( true );
		}
		else {
			return( false );
		}
	}

//	ContentHandler Interface

	/**
	 *	Receive notification of the beginning of a document.
	 *	<p>
	 *	@see org.xml.sax.ContentHandler
	 *
	 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
	 *			wrapping another exception
	 */
	public void startDocument()
	throws SAXException
	{
		super.startDocument();

		String documentRootDir = getDocumentRootDir();
		if( documentRootDir != null ) {
			getLog().message( "Loading Rule Cartridge from document directory \""
				+ documentRootDir
				+ "\"\n" );
		}
		else {
			getLog().message( "ERROR: Rule Cartridge document directory could not be determined\n" );
		}
	}


	class RootHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public RootHandler( MssCFRuleCartridgeParser coreParser ) {
			super( coreParser );
			addElementHandler( "RuleCartridge", new RuleCartridgeHandler( coreParser ) );
		}

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}


		/**
		 *	Receive notification of the end of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void endElement(
			String	uri,
			String	localName,
			String	qName)
		throws SAXException
		{
		}
	}



	class RuleCartridgeHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public RuleCartridgeHandler( MssCFRuleCartridgeParser coreParser ) {
			super( coreParser );
			addElementHandler( "UseCartridge", new UseCartridgeHandler( coreParser ) );
			addElementHandler( "Tool", new ToolHandler( coreParser ) );
			addElementHandler( "ToolSet", new ToolSetHandler( coreParser ) );
		}

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
			String	attrName = null;
			String	attrRevision = null;
			String	attrDescr = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "RuleCartridge" );

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Revision" ) ) {
					assert attrRevision == null : "Duplicate attribute \"Revision\" detected";
					attrRevision = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Descr" ) ) {
					assert attrDescr == null : "Duplicate attribute \"Descr\" detected";
					attrDescr = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";
			assert ( attrRevision != null ) && ( attrRevision.length() > 0 ) : "Missing attribute \"Revision\"";
			assert ( attrDescr != null ) && ( attrDescr.length() > 0 ) : "Missing attribute \"Descr\"";

			getLog().message( "Loading RuleCartridge Name=\"" + attrName
				+ "\", Revision = \"" + attrRevision
				+ "\", Descr=\"" + attrDescr + "\"\n" ); 

			/*
			 *	MSS WORKING -- Add code to instantiate and populate mapped object.
			 */

			addRuleCartridgeName( attrName );
		}


		/**
		 *	Receive notification of the end of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void endElement(
			String	uri,
			String	localName,
			String	qName)
		throws SAXException
		{
		}
	}

	class UseCartridgeHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public UseCartridgeHandler( MssCFRuleCartridgeParser coreParser ) {
			super( coreParser );
		}

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
			String	attrName = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "UseCartridge" );

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";

			if( ! MssCFRuleCartridgeParser.isRuleCartridgeNameLoaded( attrName ) ) {
				MssCFRuleCartridgeParser subParser = new MssCFRuleCartridgeParser( getEngine(), getLog() );
				subParser.loadRuleCartridge( attrName );
			}
		}


		/**
		 *	Receive notification of the end of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void endElement(
			String	uri,
			String	localName,
			String	qName)
		throws SAXException
		{
		}
	}

	class ToolHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public ToolHandler( MssCFRuleCartridgeParser coreParser ) {
			super( coreParser );
		}

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
			String	attrName = null;
			String	attrReplaces = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "Tool" );

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Replaces" ) ) {
					assert attrReplaces == null : "Duplicate attribute \"Replaces\" detected";
					attrReplaces = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";

			StringBuffer buff;

			ICFGenKbToolObj tool = getEngine().getToolTableObj().readToolByNameIdx( attrName );
			if( tool != null ) {
//				tool.setToolIsSupportedValue( true );
				buff = new StringBuffer( "\tEnabled Tool \"" );
			}
			else {
				tool = getEngine().defineTool( attrName );
				buff = new StringBuffer( "\tDefined Tool \"" );
			}

			buff.append( attrName );
			buff.append( '\"' );
			if( ( attrReplaces != null ) && ( attrReplaces.length() > 0 ) ) {
				buff.append( " replaces \"" );
				buff.append( attrReplaces );
				buff.append( "\"\n" );
			}
			else {
				buff.append( '\n' );
			}

			getLog().message( buff.toString() ); 
		}


		/**
		 *	Receive notification of the end of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void endElement(
			String	uri,
			String	localName,
			String	qName)
		throws SAXException
		{
		}
	}

	class ToolSetHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public ToolSetHandler( MssCFRuleCartridgeParser coreParser ) {
			super( coreParser );
		}

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
			String	attrName = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "ToolSet" );

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";

			String toolSetDocRoot = new String( getDocumentRootDir() + attrName + "/" );
			String toolSetManifestName = new String( toolSetDocRoot + "toolset.xml" );
			InputStream toolSetManifestXml = null;

			if( toolSetDocRoot.startsWith( "jar:" ) ) {
				try {
					URL url = new URL( toolSetManifestName );
					if( url != null ) {
						toolSetManifestXml = url.openStream();
						if( toolSetManifestXml == null ) {
							toolSetManifestName = null;
							toolSetDocRoot = null;
						}
					}
				}
				catch( MalformedURLException e ) {
					toolSetManifestXml = null;
					toolSetManifestName = null;
					toolSetDocRoot = null;
				}
				catch( IOException e ) {
					toolSetManifestXml = null;
					toolSetManifestName = null;
					toolSetDocRoot = null;
				}
			}
			else {
				try {
					toolSetManifestXml = new FileInputStream( toolSetManifestName );
				}
				catch( FileNotFoundException e ) {
					toolSetManifestXml = null;
					getLog().message( "ERROR: \tCould not find ToolSet manifest \"" + toolSetManifestName + "\"\n" );
					CFLib.beep();
					return;
				}
			}

			try {
				addToolSetName( getInternalToolSetName( attrName ) );
				toolSetParser.setLog( getLog() );
				toolSetParser.parse( toolSetManifestXml, toolSetDocRoot );
			}
			catch( Exception e ) {
				getLog().message( "ERROR: " + getLocationInfo() + "\tCould not load ToolSet \"" + attrName + "\"\n" );
				CFLib.beep();
			}
			finally {
				if( toolSetManifestXml != null ) {
					try {
						toolSetManifestXml.close();
					}
					catch( Exception e ) {
					}

					toolSetManifestXml = null;
				}
			}
		}


		/**
		 *	Receive notification of the end of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
		public void endElement(
			String	uri,
			String	localName,
			String	qName)
		throws SAXException
		{
		}
	}

	protected void parse( String uri ) {
		assert ( uri != null ) && ( uri.length() > 0 ) : "uri (parm 1) is null or empty";
		assert saxParser != null : "Parser must be initialized first";

        try {
    		saxParser.reset();
    		saxParser.parse( uri, this );
        }
        catch (SAXParseException e) {
            // ignore
        }
        catch (SAXException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "CFLibXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: CFLibXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		CFLib.beep();
        }
		catch( FileNotFoundException e ) {
			if( getLog() != null ) {
				getLog().message( "CFLibXmlCoreSaxParser.parse() Could not find file \"" + uri + "\"\n" );
			}
			else {
				System.err.append( "ERROR: CFLibXmlCoreSaxParser.parse() Could not find file \"" + uri + "\"\n" );
			}
    		CFLib.beep();
		}
		catch (Exception e) {
			if( getLog() != null ) {
				getLog().message( "CFLibXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getSimpleName() + " " + e.getMessage() + "\n" );
			}
			else {
				System.err.append( "ERROR: CFLibXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getSimpleName() + " " + e.getMessage() + "\n" );
			}
    		CFLib.beep();
		}
	}

	protected void parse( InputStream inputStream ) {
		assert inputStream != null : "inputStream (arg 1) is null";
		assert saxParser != null : "Parser must be initialized first";

        try {
    		saxParser.reset();
    		saxParser.parse( inputStream, this );
        }
        catch (SAXParseException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "CFLibXmlCoreSaxParser.parse() Ignored SAXParseException exception " + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: CFLibXmlCoreSaxParser.parse() Ignored SAXParseException exception " + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		CFLib.beep();
        }
        catch (SAXException e) {
        	Exception nested;
    		nested = e.getException();
    		if( nested == null ) {
    			nested = e;
    		}
    		if( getLog() != null ) {
    			getLog().message( "CFLibXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		else {
    			System.err.append( "ERROR: CFLibXmlCoreSaxParser.parse() Ignored exception " + getFormattedNearLocation() + nested.getClass().getSimpleName() + " " + nested.getMessage() + "\n" );
    		}
    		CFLib.beep();
        }
		catch (Exception e) {
			if( getLog() != null ) {
				getLog().message( "CFLibXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getSimpleName() + " " + e.getMessage() + "\n" );
			}
			else {
				System.err.append( "ERROR: CFLibXmlCoreSaxParser.parser() Ignored exception " + getFormattedNearLocation() + e.getClass().getSimpleName() + " " + e.getMessage() + "\n" );
			}
    		CFLib.beep();
		}
	}

}
