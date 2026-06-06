/*
 *	MSS Code Factory CFCore 2.12
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 */

package org.msscf.msscf.cfcore.MssCF;

import java.io.File;
import java.io.InputStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import org.msscf.msscf.cflib.CFLib.*;

/**
 *	A RuleCartridgeParser is a JAXP 1.3 Validating XML parser
 *	for documents conforming to the MSS Generator Knowledge Base
 *	Rule Cartridge schema.
 *
 *	@see	http://generator.msobkow.com/xsd/genkb-1.0.6-cartridge.
 */
public abstract class MssCFSaxParser extends CFLibXmlCoreSaxParser implements ContentHandler {

	protected MssCFEngine cfEngine;

	public MssCFEngine getEngine()
	{
		return( cfEngine );
	}

	public void setEngine( MssCFEngine value )
	{
		cfEngine = value;
	}

	/**
	 *	During a cartridge parse, sub-files are automatically resolved and loaded
	 *	from the root directory where the cartridge was found.
	 */
	private String documentRootDir = null;

	/**
	 *	The source URI for locating schemas
	 */
	public final static String	BASE_SCHEMA_URI = "/opt/msscf/2.0.12/xsd/";

	/**
	 *	The source URI for locating schemas
	 */
	public final static String	ROOT_SCHEMA_URI = "/xsd/";

//	Constructors

	public MssCFSaxParser() {
		super();
		cfEngine = null;
	}

	public MssCFSaxParser( MssCFEngine engine ) {
		super();
		cfEngine = engine;
	}

	public MssCFSaxParser( MssCFEngine engine, ICFLibMessageLog log ) {
		super( log );
		cfEngine = engine;
	}

//	Methods

	/**
	 *	Convert an external ToolSet name to an internal ToolSet name.
	 *
	 *	@param	extToolSet	The external ToolSet name.
	 *
	 *	@return	The corresponding internal ToolSet name.
	 */
	public static String getInternalToolSetName( String extToolSet ) {
		String retval;
		if( ( extToolSet == null )
		 || ( extToolSet.length() <= 0 )
		 || extToolSet.equals( "*" )
		 || extToolSet.equals( "Object" )
		 || extToolSet.equals( "object" ) )
		{
			retval = "Object";
		}
		else {
			retval = extToolSet;
		}
		return( retval );
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
		//	Hang on to the system document name

		Locator locator = getDocumentLocator();
		String docName = locator.getSystemId();
		if( ( docName == null ) || ( docName.length() <= 0 ) ) {
			docName = locator.getPublicId();
		}

		//	Hang on to the document root directory

		if( ( docName != null ) && ( docName.length() > 0 ) ) {
			int lastSeparator = docName.lastIndexOf( File.separatorChar );
			if( lastSeparator > 0 ) {
				setDocumentRootDir( docName.substring( 0, lastSeparator ) );
			}
		}

		/*
		 *	MSS WORKING
		 *
		 *	In theory, documents can be nested or referenced by other
		 *	documents, so I really should add a document stack that
		 *	contains the element stack. 
		 */
	}


	/**
	 * Receive notification of the end of a document.
	 *	<p>
	 *	@see org.xml.sax.ContentHandler
	 *
	 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
	 *			wrapping another exception
	 */
	public void endDocument()
	throws SAXException
	{
		// Dump debug information

		// Reset Document Root Directory
		setDocumentRootDir( null );

		/*
		 *	MSS WORKING
		 *
		 *	In theory, documents can be nested or referenced by other
		 *	documents, so I really should add a document stack that
		 *	contains the element stack. 
		 */
	}

//	Attributes: DocumentRootDir

	/**
	 *	Get the document root directory.
	 *	<p>
	 *	The document root directory is only valid between BEGIN/END
	 *	DOCUMENT tags.
	 *
	 *	@return	The directory containing the specified document.
	 */
	public String getDocumentRootDir() {
		return( documentRootDir );
	}

	/**
	 *	Set the document root directory name.
	 *
	 *	@param	parmDirName - The name of the document root directory.
	 */
	protected void setDocumentRootDir( String parmDirName ) {
		if( parmDirName != null ) {
			documentRootDir = new String( parmDirName );
		}
		else {
			documentRootDir = null;
		}
	}

//	Parsing documents

	/**
	 *	Parse the specified file name
	 *
	 *	@param	uri - The resource reference to be parsed
	 *	@param	docRoot - The name of the document root directory
	 */
	public void parse( String uri, String docRoot ) {
		assert docRoot != null && docRoot.length() > 0 : "docRoot (arg 2) is null or empty";
		setDocumentRootDir( docRoot );
		parse( uri );
	}

	/**
	 *	Parse the specified Stream
	 *
	 *	@param	input - The InputStream for the document to parse.
	 *	@param	docRoot - The name of the document root directory
	 */
	public void parse( InputStream inputStream, String docRoot ) {
		assert docRoot != null && docRoot.length() > 0 : "docRoot (arg 2) is null or empty";
		setDocumentRootDir( docRoot );
		parse( inputStream );
	}
}
