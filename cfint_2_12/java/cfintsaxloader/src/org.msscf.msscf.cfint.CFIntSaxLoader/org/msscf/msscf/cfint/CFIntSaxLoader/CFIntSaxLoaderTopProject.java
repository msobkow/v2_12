
// Description: Java 11 XML SAX Element Handler for TopProject

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntSaxLoader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/*
 *	CFIntSaxLoaderTopProjectParse XML SAX Element Handler implementation
 *	for TopProject.
 */
public class CFIntSaxLoaderTopProject
	extends CFLibXmlCoreElementHandler
{
	public CFIntSaxLoaderTopProject( CFIntSaxLoader saxLoader ) {
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
			// TopProject Attributes
			String	attrName = null;
			String	attrDescription = null;
			// TopProject References
			ICFIntTenantObj refTenant = null;
			ICFIntTopDomainObj refParentSDom = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "TopProject" );

			CFIntSaxLoader saxLoader = (CFIntSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ICFIntSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			ICFIntTopProjectEditObj editBuff = (ICFIntTopProjectEditObj)schemaObj.getTopProjectTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "Name" ) ) {
					if( attrName != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Description" ) ) {
					if( attrDescription != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDescription = attrs.getValue( idxAttr );
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
			if( attrName == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"Name" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "Description", attrDescription );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natName = attrName;
			editBuff.setRequiredName( natName );

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

			// Get the scope/container object

			CFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			// Resolve and apply required Container reference

			if( scopeObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"scopeObj" );
			}
			else if( scopeObj instanceof ICFIntTopDomainObj ) {
				refParentSDom = (ICFIntTopDomainObj) scopeObj;
				editBuff.setRequiredContainerParentSDom( refParentSDom );
				refTenant = (ICFIntTenantObj)editBuff.getRequiredOwnerTenant();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFIntTopDomainObj" );
			}

			// Resolve and apply Owner reference

			if( refTenant == null ) {
				if( scopeObj instanceof ICFIntTenantObj ) {
					refTenant = (ICFIntTenantObj) scopeObj;
					editBuff.setRequiredOwnerTenant( refTenant );
				}
				else {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<Tenant>" );
				}
			}

			CFIntSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTopProjectLoaderBehaviour();
			ICFIntTopProjectEditObj editTopProject = null;
			ICFIntTopProjectObj origTopProject = (ICFIntTopProjectObj)schemaObj.getTopProjectTableObj().readTopProjectByNameIdx( refTenant.getRequiredId(),
			refParentSDom.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTopProject == null ) {
				editTopProject = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTopProject = (ICFIntTopProjectEditObj)origTopProject.beginEdit();
						editTopProject.setRequiredName( editBuff.getRequiredName() );
						editTopProject.setOptionalDescription( editBuff.getOptionalDescription() );
						break;
					case Replace:
						editTopProject = (ICFIntTopProjectEditObj)origTopProject.beginEdit();
						editTopProject.deleteInstance();
						editTopProject = null;
						origTopProject = null;
						editTopProject = editBuff;
						break;
				}
			}

			if( editTopProject != null ) {
				if( origTopProject != null ) {
					editTopProject.update();
				}
				else {
					origTopProject = (ICFIntTopProjectObj)editTopProject.create();
				}
				editTopProject = null;
			}

			curContext.putNamedValue( "Object", origTopProject );
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
