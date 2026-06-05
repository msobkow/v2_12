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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.xerces.xni.grammars.Grammar;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import org.msscf.msscf.cflib.CFLib.*;

/**
 *	A RuleSetParser is a JAXP 1.3 Validating XML parser
 *	for documents conforming to the MSS Generator Knowledge Base
 *	RuleSet schema.
 *
 *	@see	http://generator.msobkow.com/xsd/genkb-1.0.6-ruleset.
 */
public class MssCFRuleSetParser extends MssCFSaxParser implements ContentHandler {

	/**
	 *	The namespace URI of the supported schema
	 */
	public final static String	SCHEMA_XMLNS = "uri://org.msscf/msscf/2.0.12/xsd/cfgenkb-2.12-ruleset";

	/**
	 *	The source for loading the supported schema
	 */
	public final static String	SCHEMA_URI = "/opt/msscf/2.0.12/xsd/cfgenkb-2.12-ruleset.xsd";
	public final static String	SCHEMA_ROOT_URI = "/xsd/cfgenkb-2.12-ruleset.xsd";

	/**
	 *	The default ToolSet name for parsing rules.
	 */
	private String defaultToolSet = null;

	protected static Grammar myGrammar = null;

//	Constructors

	/**
	 *	Construct a default XmlCoreParser logging to the
	 *	specified Log4J Logger.
	 *
	 *	@param	jLogger - Log4J Logger
	 *	@param	toolSet	The name of the ToolSet this RuleSet
	 *					should belong to
	 */
	public MssCFRuleSetParser( MssCFEngine engine, ICFLibMessageLog jLogger ) {
		super( engine, jLogger );
		setRootElementHandler( new RootHandler( this ) );
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
	}

//	Accessors: ToolSet

	/**
	 *	Get the name of the default toolset for this rule set.
	 *
	 *	@return	The name of the default toolset.
	 */
	public String getDefaultToolSet() {
		return( defaultToolSet );
	}

	/**
	 *	Set the name of the defualt toolset.
	 *
	 *	@param	toolSet	The new default toolset value.
	 */
	public void setDefaultToolSet( String toolSet ) {
		defaultToolSet = getInternalToolSetName( toolSet );
	}

//	ContentHandler Interface

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
		public RootHandler( MssCFRuleSetParser coreParser ) {
			super( coreParser );
			addElementHandler( "RuleSet", new RuleSetHandler( coreParser ) );
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


	class RuleSetHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public RuleSetHandler( MssCFRuleSetParser coreParser ) {
			super( coreParser );
			addElementHandler( "GenRule", new GenRuleHandler( coreParser ) );
			addElementHandler( "GenTrunc", new GenTruncHandler( coreParser ) );
			addElementHandler( "GenFile", new GenFileHandler( coreParser ) );
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
			String	attrToolSet = null;
			String	attrName = null;
			String	attrRevision = null;
			String	attrDescr = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "RuleSet" );
			assert getLog() != null : "getLog() returned null";

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Descr" ) ) {
					assert attrDescr == null : "Duplicate attribute \"Descr\" detected";
					attrDescr = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Revision" ) ) {
					assert attrRevision == null : "Duplicate attribute \"Revision\" detected";
					attrRevision = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToolSet" ) ) {
					assert attrToolSet == null : "Duplicate attribute \"ToolSet\" detected";
					attrToolSet = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrToolSet != null ) && ( attrToolSet.length() > 0 ) : "Missing attribute \"ToolSet\"";
			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";
			assert ( attrDescr != null ) && ( attrDescr.length() > 0 ) : "Missing attribute \"Descr\"";

			if( ( attrRevision != null ) && ( attrRevision.length() > 0 ) ) {
				getLog().message( "\t\tLoading " + attrToolSet + " RuleSet \"" + attrName
					+ "\", Revision = \"" + attrRevision
					+ "\", Descr=\"" + attrDescr + "\"\n" );
			}
			else {
				getLog().message( "\t\tLoading " + attrToolSet + " RuleSet \"" + attrName
					+ "\", Descr=\"" + attrDescr + "\"\n" );
			}

			String defaultToolSet = ((MssCFRuleSetParser)getParser()).getDefaultToolSet();

			String useToolSet;

			if( attrToolSet == null ) {
				useToolSet = defaultToolSet;
			}
			else {
				useToolSet = getInternalToolSetName( attrToolSet );
			}

			if( ( useToolSet != defaultToolSet )
			 && ( ! useToolSet.equals( defaultToolSet ) ) )
			{
				StringBuffer buff = new StringBuffer( "\t\t\tExpected ToolSet " );
				if( defaultToolSet != null ) {
					buff.append( '\"' );
					buff.append( defaultToolSet );
					buff.append( "\", not " );
				}
				else {
					buff.append( "null, not " );
				}

				if( useToolSet != null ) {
					buff.append( '\"' );
					buff.append( useToolSet );
					buff.append( "\"\n" );
				}
				else {
					buff.append( "null\n" );
				}

				getLog().message( "ERROR: " + buff.toString() );

				setDefaultToolSet( useToolSet );
			}

			/*
			 *	MSS WORKING -- Add code to instantiate and populate mapped object.
			 */
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


	class GenRuleHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public GenRuleHandler( MssCFRuleSetParser coreParser ) {
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
			String	attrId = null;
			String	attrName = null;
			String	attrToolSet = null;
			String	attrScopeDef = null;
			String	attrGenDef = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			final String S_ProcName = "startElement";

			assert qName.equals( "GenRule" );
			assert getLog() != null : "getLog() returned null";

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ScopeDef" ) ) {
					assert attrScopeDef == null : "Duplicate attribute \"ScopeDef\" detected";
					attrScopeDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenDef" ) ) {
					assert attrGenDef == null : "Duplicate attribute \"GenDef\" detected";
					attrGenDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToolSet" ) ) {
					assert attrToolSet == null : "Duplicate attribute \"ToolSet\" detected";
					attrToolSet = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Id" ) ) {
					assert attrId == null : "Duplicate attribute \"Id\" detected";
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";
			assert ( attrGenDef != null ) && ( attrGenDef.length() > 0 ) : "Missing attribute \"GenDef\"";

			String defaultToolSet = getDefaultToolSet();
			assert defaultToolSet != null : "defaultToolSet is null!";

			String useToolSet;
			if( attrToolSet == null ) {
				useToolSet = defaultToolSet;
			}
			else {
				useToolSet = getInternalToolSetName( attrToolSet );
			}

			if( useToolSet != null ) {
				if( ( useToolSet != defaultToolSet )
				 && ( ! useToolSet.equals( defaultToolSet ) ) )
				{
					StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
					buff.append( defaultToolSet );
					buff.append( "\", not \"" );
					buff.append( useToolSet );
					buff.append( "\", encountered near " );
					getParser().appendLocatorInformation( buff );
					buff.append( '\n' );
					getLog().message( "ERROR: " +  buff.toString() );
				}
			}
			else if( defaultToolSet != null ) {
				StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
				buff.append( defaultToolSet );
				buff.append( "\", not null, encountered near " );
				getParser().appendLocatorInformation( buff );
				buff.append( '\n' );
				getLog().message( "ERROR: " +  buff.toString() );
			}

			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ToolSet", useToolSet );
			curContext.putNamedValue( "ScopeDef", attrScopeDef );
			curContext.putNamedValue( "GenDef", attrGenDef );

			String xmlFormattedNearLocation = getParser().getFormattedNearLocation();
			curContext.putNamedValue( "XmlFormattedNearLocation", xmlFormattedNearLocation );
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
			CFLibXmlCoreContext curContext = getParser().getCurContext();
//			String attrId = (String)curContext.getNamedValue( "Id" );
			String attrName = (String)curContext.getNamedValue( "Name" );
			String useToolSet = (String)curContext.getNamedValue( "ToolSet" );
			String attrScopeDef = (String)curContext.getNamedValue( "ScopeDef" );
			String attrGenDef = (String)curContext.getNamedValue( "GenDef" );
			String attrText = curContext.getElementText();
			String xmlFormattedNearLocation = (String)curContext.getNamedValue( "XmlFormattedNearLocation" );
			assert xmlFormattedNearLocation != null : "xmlFormattedNearLocation is null";

			String useScopeDef;
			if( ( attrScopeDef == null ) || ( attrScopeDef.length() <= 0 ) ) {
				useScopeDef = null;
			}
			else if( attrScopeDef.equals( "*" ) ) {
				useScopeDef = attrScopeDef;
			}
			else {
				useScopeDef = new String( attrScopeDef );
			}

			String useGenDef;
			if( ( attrGenDef == null ) || ( attrGenDef.length() <= 0 ) ) {
				useGenDef = null;
			}
			else if( attrGenDef.equals( "*" ) ) {
				useGenDef = attrGenDef;
			}
			else {
				useGenDef = new String( attrGenDef );
			}

//			if( true ) {
			if( false ) {
				StringBuffer buff = getParser().appendLocatorInformation( new StringBuffer( "\t\t\t" ) );

				buff.append( " defineRule( DefinedNear=\"" );
				buff.append( xmlFormattedNearLocation );

				buff.append( "\", ToolSet=" );
				if( useToolSet != null ) {
					buff.append( '"' );
					buff.append( useToolSet );
					buff.append( "\", ScopeDef=" );
				}
				else {
					buff.append( "null, ScopeDef=" );
				}

				if( useScopeDef != null ) {
					buff.append( '"' );
					buff.append( useScopeDef );
					buff.append( "\", GenDef=" );
				}
				else {
					buff.append( "null, GenDef=" );
				}

				if( useGenDef != null ) {
					buff.append( '"' );
					buff.append( useGenDef );
					buff.append( "\", Name=" );
				}
				else {
					buff.append( "null, Name=" );
				}

				if( attrName != null ) {
					buff.append( '"' );
					buff.append( attrName );
					buff.append( "\", ExpansionBody=" );
				}
				else {
					buff.append( "null, ExpansionBody=" );
				}

				if( attrText != null ) {
					buff.append( "populated )\n" );
				}
				else {
					buff.append( "null )\n" );
				}

				getLog().message( "DEBUG: " + buff.toString() );
			}

			//MssCFGenRuleObj rule = 
			getEngine().defineRule( xmlFormattedNearLocation,
				useToolSet,
				useScopeDef,
				useGenDef,
				attrName,
				attrText );

			return;
		}
	}

	class GenTruncHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public GenTruncHandler( MssCFRuleSetParser coreParser ) {
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
			String	attrId = null;
			String	attrName = null;
			String	attrToolSet = null;
			String	attrScopeDef = null;
			String	attrGenDef = null;
			String	attrTruncateAt = null;

			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "GenTrunc" );
			assert getLog() != null : "getLog() returned null";

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ScopeDef" ) ) {
					assert attrScopeDef == null : "Duplicate attribute \"ScopeDef\" detected";
					attrScopeDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenDef" ) ) {
					assert attrGenDef == null : "Duplicate attribute \"GenDef\" detected";
					attrGenDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TruncateAt" ) ) {
					assert attrTruncateAt == null : "Duplicate attribute \"TruncateAt\" detected";
					attrTruncateAt = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToolSet" ) ) {
					assert attrToolSet == null : "Duplicate attribute \"ToolSet\" detected";
					attrToolSet = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Id" ) ) {
					assert attrId == null : "Duplicate attribute \"Id\" detected";
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";
			assert ( attrGenDef != null ) && ( attrGenDef.length() > 0 ) : "Missing attribute \"GenDef\"";
			assert ( attrTruncateAt != null ) && ( attrTruncateAt.length() > 0 ) : "Missing attribute \"TruncateAt\"";

			String defaultToolSet = getDefaultToolSet();

			String useToolSet;
			if( attrToolSet == null ) {
				useToolSet = defaultToolSet;
			}
			else {
				useToolSet = getInternalToolSetName( attrToolSet );
			}

			int intTruncateAt = Integer.parseInt( attrTruncateAt );

			if( useToolSet != null ) {
				if( ! useToolSet.equals( defaultToolSet ) ) {
					StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
					buff.append( defaultToolSet );
					buff.append( "\", not \"" );
					buff.append( useToolSet );
					buff.append( "\", encountered near " );
					getParser().appendLocatorInformation( buff );
					buff.append( '\n' );
					getLog().message( "ERROR: " +  buff.toString() );
				}
			}
			else if( defaultToolSet != null ) {
				StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
				buff.append( defaultToolSet );
				buff.append( "\", not null, encountered near " );
				getParser().appendLocatorInformation( buff );
				buff.append( '\n' );
				getLog().message( "ERROR: " +  buff.toString() );
			}

			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ToolSet", useToolSet );
			curContext.putNamedValue( "ScopeDef", attrScopeDef );
			curContext.putNamedValue( "GenDef", attrGenDef );
			curContext.putNamedValue( "TruncateAt", attrTruncateAt );

			String xmlFormattedNearLocation = getParser().getFormattedNearLocation();
			curContext.putNamedValue( "XmlFormattedNearLocation", xmlFormattedNearLocation );
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

			CFLibXmlCoreContext curContext = getParser().getCurContext();
//			String attrId = (String)curContext.getNamedValue( "Id" );
			String attrName = (String)curContext.getNamedValue( "Name" );
			String useToolSet = (String)curContext.getNamedValue( "ToolSet" );
			String attrScopeDef = (String)curContext.getNamedValue( "ScopeDef" );
			String attrGenDef = (String)curContext.getNamedValue( "GenDef" );
			String attrTruncateAt = (String)curContext.getNamedValue( "TruncateAt" );
			String attrText = curContext.getElementText();
			String xmlFormattedNearLocation = (String)curContext.getNamedValue( "XmlFormattedNearLocation" );

			String useScopeDef;
			if( ( attrScopeDef == null ) || ( attrScopeDef.length() <= 0 ) ) {
				useScopeDef = null;
			}
			else if( attrScopeDef.equals( "*" ) ) {
				useScopeDef = attrScopeDef;
			}
			else {
				useScopeDef = attrScopeDef;
			}

			String useGenDef;
			if( ( attrGenDef == null ) || ( attrGenDef.length() <= 0 ) ) {
				useGenDef = null;
			}
			else if( attrGenDef.equals( "*" ) ) {
				useGenDef = attrGenDef;
			}
			else {
				useGenDef = attrGenDef;
			}

			int truncateAt = Integer.parseInt( attrTruncateAt );

//			if( true ) {
			if( false ) {
				StringBuffer buff = getParser().appendLocatorInformation( new StringBuffer( "\t\t\t" ) );

				buff.append( " defineTrunc( ToolSet=" );

				if( useToolSet != null ) {
					buff.append( '"' );
					buff.append( useToolSet );
					buff.append( "\", ScopeDef=" );
				}
				else {
					buff.append( "null, ScopeDef=" );
				}

				if( useScopeDef != null ) {
					buff.append( '"' );
					buff.append( useScopeDef );
					buff.append( "\", GenDef=" );
				}
				else {
					buff.append( "null, GenDef=" );
				}

				if( useGenDef != null ) {
					buff.append( '"' );
					buff.append( useGenDef );
					buff.append( "\", Name=" );
				}
				else {
					buff.append( "null, Name=" );
				}

				if( attrName != null ) {
					buff.append( '"' );
					buff.append( attrName );
					buff.append( "\", TruncateAt=" );
				}
				else {
					buff.append( "null, TruncateAt=" );
				}

				buff.append( truncateAt );
				buff.append( ", ExpansionBody=" );

				if( attrText != null ) {
					buff.append( "populated )\n" );
				}
				else {
					buff.append( "null )\n" );
				}

				getLog().message( "DEBUG: " + buff.toString() );
			}

			// MssCFGenTruncObj trunc = 
			getEngine().defineTrunc( xmlFormattedNearLocation,
				useToolSet,
				useScopeDef,
				useGenDef,
				attrName,
				attrText,
				truncateAt );

			return;
		}
	}

	class GenFileHandler extends CFLibXmlCoreElementHandler {

		/**
		 *	Construct an XML Core Element Handler owned by the
		 *	specified parser.
		 *	<p>
		 *	The logger associated with the parser is used for
		 *	processing messages.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 */
		public GenFileHandler( MssCFRuleSetParser coreParser ) {
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
			String	attrId = null;
			String	attrName = null;
			String	attrToolSet = null;
			String	attrScopeDef = null;
			String	attrGenDef = null;
			String	attrSourceBundle = null;
			String	attrGenerateOnce = null;
			String	attrModuleName = null;
			String	attrBasePackageName = null;
			String	attrSubPackageName = null;
			String	attrExpansionClassName = null;
			String	attrExpansionKeyName = null;
			String	attrExpansionFileName = null;
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;

			assert qName.equals( "GenFile" );
			assert getLog() != null : "getLog() returned null";

			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Name" ) ) {
					assert attrName == null : "Duplicate attribute \"Name\" detected";
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ScopeDef" ) ) {
					assert attrScopeDef == null : "Duplicate attribute \"ScopeDef\" detected";
					attrScopeDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenDef" ) ) {
					assert attrGenDef == null : "Duplicate attribute \"GenDef\" detected";
					attrGenDef = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SourceBundle" ) ) {
					assert attrSourceBundle == null : "Duplicate attribute \"SourceBundle\" detected";
					attrSourceBundle = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "BasePackageName" ) ) {
					assert attrBasePackageName == null : "Duplicate attribute \"BasePackageName\" detected";
					attrBasePackageName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "GenerateOnce" ) ) {
					assert attrGenerateOnce == null : "Duplicate attribute \"GenerateOnce\" detected";
					attrGenerateOnce = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ModuleName" ) ) {
					assert attrModuleName == null : "Duplicate attribute \"ModuleName\" detected";
					attrModuleName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SubPackageName" ) ) {
					assert attrSubPackageName == null : "Duplicate attribute \"SubPackageName\" detected";
					attrSubPackageName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ExpansionClassName" ) ) {
					assert attrExpansionClassName == null : "Duplicate attribute \"ExpansionClassName\" detected";
					attrExpansionClassName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ExpansionKeyName" ) ) {
					assert attrExpansionKeyName == null : "Duplicate attribute \"ExpansionKeyName\" detected";
					attrExpansionKeyName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ExpansionFileName" ) ) {
					assert attrExpansionFileName == null : "Duplicate attribute \"ExpansionFileName\" detected";
					attrExpansionFileName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ToolSet" ) ) {
					assert attrToolSet == null : "Duplicate attribute \"ToolSet\" detected";
					attrToolSet = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Id" ) ) {
					assert attrId == null : "Duplicate attribute \"Id\" detected";
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					assert false : "Unrecognized attribute \"" + attrLocalName + "\"";
				}
			}

			assert ( attrName != null ) && ( attrName.length() > 0 ) : "Missing attribute \"Name\"";
			assert ( attrGenDef != null ) && ( attrGenDef.length() > 0 ) : "Missing attribute \"GenDef\"";

			String useToolSet;
			if( attrToolSet != null ) {
				if( attrToolSet.equals("*") || attrToolSet.equals( "object" ) ) {
					useToolSet = "Object";
				}
				else {
					useToolSet = attrToolSet;
				}
			}
			else {
				useToolSet = getDefaultToolSet();
			}

			if( useToolSet != null ) {
				String defaultToolSet = getDefaultToolSet();
				if( ! useToolSet.equals( defaultToolSet ) ) {
					StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
					buff.append( defaultToolSet );
					buff.append( "\", not \"" );
					buff.append( useToolSet );
					buff.append( "\", encountered near " );
					getParser().appendLocatorInformation( buff );
					buff.append( '\n' );
					getLog().message( "ERROR: " +  buff.toString() );
				}
			}

			String defaultToolSet = getDefaultToolSet();
			if( useToolSet != null ) {
				if( ! useToolSet.equals( defaultToolSet ) ) {
					StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
					buff.append( defaultToolSet );
					buff.append( "\", not \"" );
					buff.append( useToolSet );
					buff.append( "\", encountered near " );
					getParser().appendLocatorInformation( buff );
					buff.append( '\n' );
					getLog().message( "ERROR: " +  buff.toString() );
				}
			}
			else if( defaultToolSet != null ) {
				StringBuffer buff = new StringBuffer( "\t\t\t\tExpected ToolSet \"" );
				buff.append( defaultToolSet );
				buff.append( "\", not null, encountered near " );
				getParser().appendLocatorInformation( buff );
				buff.append( '\n' );
				getLog().message( "ERROR: " +  buff.toString() );
			}

			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "ToolSet", attrToolSet );
			curContext.putNamedValue( "ScopeDef", attrScopeDef );
			curContext.putNamedValue( "GenDef", attrGenDef );
			curContext.putNamedValue( "SourceBundle", attrSourceBundle );
			curContext.putNamedValue( "GenerateOnce", attrGenerateOnce );
			curContext.putNamedValue( "ModuleName", attrModuleName );
			curContext.putNamedValue( "BasePackageName", attrBasePackageName );
			curContext.putNamedValue( "SubPackageName", attrSubPackageName );
			curContext.putNamedValue( "ExpansionClassName", attrExpansionClassName );
			curContext.putNamedValue( "ExpansionKeyName", attrExpansionKeyName );
			curContext.putNamedValue( "ExpansionFileName", attrExpansionFileName );

			String xmlFormattedNearLocation = getParser().getFormattedNearLocation();
			curContext.putNamedValue( "XmlFormattedNearLocation", xmlFormattedNearLocation );
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
			CFLibXmlCoreContext curContext = getParser().getCurContext();
//			String attrId = (String)curContext.getNamedValue( "Id" );
			String attrName = (String)curContext.getNamedValue( "Name" );
			String attrToolSet = (String)curContext.getNamedValue( "ToolSet" );
			String attrScopeDef = (String)curContext.getNamedValue( "ScopeDef" );
			String attrGenDef = (String)curContext.getNamedValue( "GenDef" );
			String attrSourceBundle = (String)curContext.getNamedValue( "SourceBundle" );
			String attrGenerateOnce = (String)curContext.getNamedValue( "GenerateOnce"  );
			String attrModuleName = (String)curContext.getNamedValue( "ModuleName"  );
			String attrBasePackageName = (String)curContext.getNamedValue( "BasePackageName"  );
			String attrSubPackageName = (String)curContext.getNamedValue( "SubPackageName"  );
			String attrExpansionClassName = (String)curContext.getNamedValue( "ExpansionClassName"  );
			String attrExpansionKeyName = (String)curContext.getNamedValue( "ExpansionKeyName"  );
			String attrExpansionFileName = (String)curContext.getNamedValue( "ExpansionFileName"  );
			String attrText = curContext.getElementText();
			String xmlFormattedNearLocation = (String)curContext.getNamedValue( "XmlFormattedNearLocation" );

			String useToolSet;
			if( attrToolSet != null ) {
				if( attrToolSet.equals("*") || attrToolSet.equals( "object" ) ) {
					useToolSet = "Object";
				}
				else {
					useToolSet = attrToolSet;
				}
			}
			else {
				useToolSet = getDefaultToolSet();
			}

			String useScopeDef;
			if( ( attrScopeDef == null ) || ( attrScopeDef.length() <= 0 ) ) {
				useScopeDef = null;
			}
			else if( attrScopeDef.equals( "*" ) 
					|| attrScopeDef.equals( "Object" )
					|| attrScopeDef.equals( "object" ) ) {
				useScopeDef = attrScopeDef;
			}
			else {
				useScopeDef = attrScopeDef;
			}

			String useGenDef;
			if( ( attrGenDef == null ) || ( attrGenDef.length() <= 0 ) ) {
				useGenDef = null;
			}
			else if( attrGenDef.equals( "*" ) ) {
				useGenDef = attrGenDef;
			}
			else {
				useGenDef = attrGenDef;
			}

//			if( true ) {
			if( false ) {
				StringBuffer buff = getParser().appendLocatorInformation( new StringBuffer( "\t\t\t" ) );

				buff.append( " defineFile( ToolSet=" );

				if( useToolSet != null ) {
					buff.append( '"' );
					buff.append( useToolSet );
					buff.append( "\", ScopeDef=" );
				}
				else {
					buff.append( "null, ScopeDef=" );
				}

				if( useScopeDef != null ) {
					buff.append( '"' );
					buff.append( useScopeDef );
					buff.append( "\", GenDef=" );
				}
				else {
					buff.append( "null, GenDef=" );
				}

				if( useGenDef != null ) {
					buff.append( '"' );
					buff.append( useGenDef );
					buff.append( "\", Name=" );
				}
				else {
					buff.append( "null, Name=" );
				}

				if( attrName != null ) {
					buff.append( '"' );
					buff.append( attrName );
					buff.append( "\", SourceBundle=" );
				}
				else {
					buff.append( "null, SourceBundle=" );
				}

				if( attrSourceBundle != null ) {
					buff.append( '"' );
					buff.append( attrSourceBundle );
					buff.append( "\", GenerateOnce=" );
				}
				else {
					buff.append( "null, GenerateOnce=" );
				}

				if( attrGenerateOnce != null ) {
					buff.append( '"' );
					buff.append( attrGenerateOnce );
					buff.append( "\", ModuleName=" );
				}
				else {
					buff.append( "null, ModuleName=" );
				}

				if( attrModuleName != null ) {
					buff.append( '"' );
					buff.append( attrModuleName );
					buff.append( "\", BasePackageName=" );
				}
				else {
					buff.append( "null, BasePackageName=" );
				}

				if( attrBasePackageName != null ) {
					buff.append( '"' );
					buff.append( attrBasePackageName );
					buff.append( "\", SubPackageName=" );
				}
				else {
					buff.append( "null, SubPackageName=" );
				}

				if( attrSubPackageName != null ) {
					buff.append( '"' );
					buff.append( attrSubPackageName );
					buff.append( "\", ExpansionClassName=" );
				}
				else {
					buff.append( "null, ExpansionClassName=" );
				}

				if( attrExpansionClassName != null ) {
					buff.append( '"' );
					buff.append( attrExpansionClassName );
					buff.append( "\", ExpansionKeyName=" );
				}
				else {
					buff.append( "null, ExpansionKeyName=" );
				}

				if( attrExpansionKeyName != null ) {
					buff.append( '"' );
					buff.append( attrExpansionKeyName );
					buff.append( "\", ExpansionFileName=" );
				}
				else {
					buff.append( "null, ExpansionFileName=" );
				}

				if( attrExpansionFileName != null ) {
					buff.append( '"' );
					buff.append( attrExpansionFileName );
					buff.append( "\", ExpansionBody=" );
				}
				else {
					buff.append( "null, ExpansionBody=" );
				}

				if( attrText != null ) {
					buff.append( '"' );
					buff.append( attrText );
					buff.append( "\" )\n" );
				}
				else {
					buff.append( "null )\n" );
				}

				getLog().message( "DEBUG: " + buff.toString() );
			}

			//MssCFGenFileObj genFile =
			getEngine().defineFile( xmlFormattedNearLocation,
				useToolSet,
				useScopeDef,
				useGenDef,
				attrName,
				attrText,
				attrGenerateOnce,
				attrSourceBundle,
				attrModuleName,
				attrBasePackageName,
				attrSubPackageName,
				attrExpansionClassName,
				attrExpansionKeyName,
				attrExpansionFileName );

			return;
		}
	}

	protected void parse( String uri ) {
		assert ( uri != null ) && ( uri.length() > 0 ) : "uri (parm 1) is null or empty";
		assert saxParser != null : "Parser must be initialized first";
		assert getLog() != null : "getLog() returned null";

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
		assert getLog() != null : "getLog() returned null";

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
