
// Description: Java 11 XML SAX Element Handler for ISOCtry

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

package org.msscf.msscf.cfbam.CFBamSaxLoader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamSaxLoaderISOCtryParse XML SAX Element Handler implementation
 *	for ISOCtry.
 */
public class CFBamSaxLoaderISOCtry
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderISOCtry( CFBamSaxLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		try {
			// Common XML Attributes
			String	attrId = null;
			// ISOCtry Attributes
			String	attrISOCode = null;
			String	attrName = null;
			// ISOCtry References
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "ISOCtry" );

			CFBamSaxLoader saxLoader = (CFBamSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ICFBamSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			ICFBamISOCtryEditObj editBuff = (ICFBamISOCtryEditObj)schemaObj.getISOCtryTableObj().newInstance().beginEdit();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ISOCode" ) ) {
					if( attrISOCode != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrISOCode = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Name" ) ) {
					if( attrName != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw new CFLibUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values
			if( attrISOCode == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ISOCode" );
			}
			if( attrName == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "ISOCode", attrISOCode );
			curContext.putNamedValue( "Name", attrName );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natISOCode = attrISOCode;
			editBuff.setRequiredISOCode( natISOCode );

			String natName = attrName;
			editBuff.setRequiredName( natName );

			// Get the scope/container object

			CFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getISOCtryLoaderBehaviour();
			ICFBamISOCtryEditObj editISOCtry = null;
			ICFBamISOCtryObj origISOCtry = (ICFBamISOCtryObj)schemaObj.getISOCtryTableObj().readISOCtryByISOCodeIdx( editBuff.getRequiredISOCode() );
			if( origISOCtry == null ) {
				editISOCtry = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editISOCtry = (ICFBamISOCtryEditObj)origISOCtry.beginEdit();
						editISOCtry.setRequiredISOCode( editBuff.getRequiredISOCode() );
						editISOCtry.setRequiredName( editBuff.getRequiredName() );
						break;
					case Replace:
						editISOCtry = (ICFBamISOCtryEditObj)origISOCtry.beginEdit();
						editISOCtry.deleteInstance();
						editISOCtry = null;
						origISOCtry = null;
						editISOCtry = editBuff;
						break;
				}
			}

			if( editISOCtry != null ) {
				if( origISOCtry != null ) {
					editISOCtry.update();
				}
				else {
					origISOCtry = (ICFBamISOCtryObj)editISOCtry.create();
				}
				editISOCtry = null;
			}

			curContext.putNamedValue( "Object", origISOCtry );
		}
		catch( RuntimeException e ) {
			throw new RuntimeException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
		catch( Error e ) {
			throw new Error( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
