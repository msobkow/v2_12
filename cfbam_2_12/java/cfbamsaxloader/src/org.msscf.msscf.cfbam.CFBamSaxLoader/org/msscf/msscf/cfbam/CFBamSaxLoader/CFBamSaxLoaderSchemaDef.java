
// Description: Java 11 XML SAX Element Handler for SchemaDef

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamSaxLoaderSchemaDefParse XML SAX Element Handler implementation
 *	for SchemaDef.
 */
public class CFBamSaxLoaderSchemaDef
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderSchemaDef( CFBamSaxLoader saxLoader ) {
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
			// Scope Attributes
			// Scope References
			ICFBamTenantObj refTenant = null;
			// SchemaDef Attributes
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrCopyrightPeriod = null;
			String	attrCopyrightHolder = null;
			String	attrAuthorEMail = null;
			String	attrProjectURL = null;
			String	attrPublishURI = null;
			String	attrJSchemaObjImport = null;
			String	attrJSchemaObjInterface = null;
			String	attrJSchemaObjMembers = null;
			String	attrJSchemaObjImplementation = null;
			String	attrJDb2LUWSchemaObjMembers = null;
			String	attrJDb2LUWSchemaObjImpl = null;
			String	attrJDb2LUWSchemaObjImport = null;
			String	attrJMSSqlSchemaObjMembers = null;
			String	attrJMSSqlSchemaObjImpl = null;
			String	attrJMSSqlSchemaObjImport = null;
			String	attrJMySqlSchemaObjMembers = null;
			String	attrJMySqlSchemaObjImpl = null;
			String	attrJMySqlSchemaObjImport = null;
			String	attrJOracleSchemaObjMembers = null;
			String	attrJOracleSchemaObjImpl = null;
			String	attrJOracleSchemaObjImport = null;
			String	attrJPgSqlSchemaObjMembers = null;
			String	attrJPgSqlSchemaObjImpl = null;
			String	attrJPgSqlSchemaObjImport = null;
			String	attrJRamSchemaObjMembers = null;
			String	attrJRamSchemaObjImpl = null;
			String	attrJRamSchemaObjImport = null;
			String	attrJXMsgSchemaImport = null;
			String	attrJXMsgSchemaFormatters = null;
			String	attrJXMsgClientSchemaImport = null;
			String	attrJXMsgClientSchemaBody = null;
			String	attrJXMsgRqstSchemaBody = null;
			String	attrJXMsgRqstSchemaImport = null;
			String	attrJXMsgRqstSchemaWireParsers = null;
			String	attrJXMsgRqstSchemaXsdSpec = null;
			String	attrJXMsgRqstSchemaXsdElementList = null;
			String	attrJXMsgRspnSchemaBody = null;
			String	attrJXMsgRspnSchemaImport = null;
			String	attrJXMsgRspnSchemaWireParsers = null;
			String	attrJXMsgRspnSchemaXsdElementList = null;
			String	attrJXMsgRspnSchemaXsdSpec = null;
			String	attrCppSchemaObjInclude = null;
			String	attrCppSchemaObjInterface = null;
			String	attrCppSchemaObjMembers = null;
			String	attrCppSchemaObjImplementation = null;
			String	attrCppDb2LUWSchemaObjMembers = null;
			String	attrCppDb2LUWSchemaObjImpl = null;
			String	attrCppDb2LUWSchemaObjInclude = null;
			String	attrCppMSSqlSchemaObjMembers = null;
			String	attrCppMSSqlSchemaObjImpl = null;
			String	attrCppMSSqlSchemaObjInclude = null;
			String	attrCppMySqlSchemaObjMembers = null;
			String	attrCppMySqlSchemaObjImpl = null;
			String	attrCppMySqlSchemaObjInclude = null;
			String	attrCppOracleSchemaObjMembers = null;
			String	attrCppOracleSchemaObjImpl = null;
			String	attrCppOracleSchemaObjInclude = null;
			String	attrCppPgSqlSchemaObjMembers = null;
			String	attrCppPgSqlSchemaObjImpl = null;
			String	attrCppPgSqlSchemaObjInclude = null;
			String	attrCppRamSchemaObjMembers = null;
			String	attrCppRamSchemaObjImpl = null;
			String	attrCppRamSchemaObjInclude = null;
			String	attrCppXMsgSchemaInclude = null;
			String	attrCppXMsgSchemaFormatters = null;
			String	attrCppXMsgClientSchemaInclude = null;
			String	attrCppXMsgClientSchemaBody = null;
			String	attrCppXMsgRqstSchemaBody = null;
			String	attrCppXMsgRqstSchemaInclude = null;
			String	attrCppXMsgRqstSchemaWireParsers = null;
			String	attrCppXMsgRqstSchemaXsdSpec = null;
			String	attrCppXMsgRqstSchemaXsdElementList = null;
			String	attrCppXMsgRspnSchemaBody = null;
			String	attrCppXMsgRspnSchemaInclude = null;
			String	attrCppXMsgRspnSchemaWireParsers = null;
			String	attrCppXMsgRspnSchemaXsdElementList = null;
			String	attrCppXMsgRspnSchemaXsdSpec = null;
			String	attrHppSchemaObjInclude = null;
			String	attrHppSchemaObjInterface = null;
			String	attrHppSchemaObjMembers = null;
			String	attrHppSchemaObjImplementation = null;
			String	attrHppDb2LUWSchemaObjMembers = null;
			String	attrHppDb2LUWSchemaObjImpl = null;
			String	attrHppDb2LUWSchemaObjInclude = null;
			String	attrHppMSSqlSchemaObjMembers = null;
			String	attrHppMSSqlSchemaObjImpl = null;
			String	attrHppMSSqlSchemaObjInclude = null;
			String	attrHppMySqlSchemaObjMembers = null;
			String	attrHppMySqlSchemaObjImpl = null;
			String	attrHppMySqlSchemaObjInclude = null;
			String	attrHppOracleSchemaObjMembers = null;
			String	attrHppOracleSchemaObjImpl = null;
			String	attrHppOracleSchemaObjInclude = null;
			String	attrHppPgSqlSchemaObjMembers = null;
			String	attrHppPgSqlSchemaObjImpl = null;
			String	attrHppPgSqlSchemaObjInclude = null;
			String	attrHppRamSchemaObjMembers = null;
			String	attrHppRamSchemaObjImpl = null;
			String	attrHppRamSchemaObjInclude = null;
			String	attrHppXMsgSchemaInclude = null;
			String	attrHppXMsgSchemaFormatters = null;
			String	attrHppXMsgClientSchemaInclude = null;
			String	attrHppXMsgClientSchemaBody = null;
			String	attrHppXMsgRqstSchemaBody = null;
			String	attrHppXMsgRqstSchemaInclude = null;
			String	attrHppXMsgRqstSchemaWireParsers = null;
			String	attrHppXMsgRqstSchemaXsdSpec = null;
			String	attrHppXMsgRqstSchemaXsdElementList = null;
			String	attrHppXMsgRspnSchemaBody = null;
			String	attrHppXMsgRspnSchemaInclude = null;
			String	attrHppXMsgRspnSchemaWireParsers = null;
			String	attrHppXMsgRspnSchemaXsdElementList = null;
			String	attrHppXMsgRspnSchemaXsdSpec = null;
			String	attrCsSchemaObjUsing = null;
			String	attrCsSchemaObjInterface = null;
			String	attrCsSchemaObjMembers = null;
			String	attrCsSchemaObjImplementation = null;
			String	attrCsDb2LUWSchemaObjMembers = null;
			String	attrCsDb2LUWSchemaObjImpl = null;
			String	attrCsDb2LUWSchemaObjUsing = null;
			String	attrCsMSSqlSchemaObjMembers = null;
			String	attrCsMSSqlSchemaObjImpl = null;
			String	attrCsMSSqlSchemaObjUsing = null;
			String	attrCsMySqlSchemaObjMembers = null;
			String	attrCsMySqlSchemaObjImpl = null;
			String	attrCsMySqlSchemaObjUsing = null;
			String	attrCsOracleSchemaObjMembers = null;
			String	attrCsOracleSchemaObjImpl = null;
			String	attrCsOracleSchemaObjUsing = null;
			String	attrCsPgSqlSchemaObjMembers = null;
			String	attrCsPgSqlSchemaObjImpl = null;
			String	attrCsPgSqlSchemaObjUsing = null;
			String	attrCsRamSchemaObjMembers = null;
			String	attrCsRamSchemaObjImpl = null;
			String	attrCsRamSchemaObjUsing = null;
			String	attrCsXMsgSchemaUsing = null;
			String	attrCsXMsgSchemaFormatters = null;
			String	attrCsXMsgClientSchemaUsing = null;
			String	attrCsXMsgClientSchemaBody = null;
			String	attrCsXMsgRqstSchemaBody = null;
			String	attrCsXMsgRqstSchemaUsing = null;
			String	attrCsXMsgRqstSchemaWireParsers = null;
			String	attrCsXMsgRqstSchemaXsdSpec = null;
			String	attrCsXMsgRqstSchemaXsdElementList = null;
			String	attrCsXMsgRspnSchemaBody = null;
			String	attrCsXMsgRspnSchemaUsing = null;
			String	attrCsXMsgRspnSchemaWireParsers = null;
			String	attrCsXMsgRspnSchemaXsdElementList = null;
			String	attrCsXMsgRspnSchemaXsdSpec = null;
			String	attrDefaultLicense = null;
			// SchemaDef References
			ICFBamMinorVersionObj refMinorVersion = null;
			ICFBamLicenseObj refDefaultLicense = null;
			ICFBamTenantObj refCTenant = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "SchemaDef" );

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
			ICFBamSchemaDefEditObj editBuff = (ICFBamSchemaDefEditObj)schemaObj.getSchemaDefTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "DbName" ) ) {
					if( attrDbName != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDbName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ShortName" ) ) {
					if( attrShortName != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortName = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "Label" ) ) {
					if( attrLabel != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLabel = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ShortDescription" ) ) {
					if( attrShortDescription != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrShortDescription = attrs.getValue( idxAttr );
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
				else if( attrLocalName.equals( "CopyrightPeriod" ) ) {
					if( attrCopyrightPeriod != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCopyrightPeriod = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CopyrightHolder" ) ) {
					if( attrCopyrightHolder != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCopyrightHolder = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "AuthorEMail" ) ) {
					if( attrAuthorEMail != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrAuthorEMail = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "ProjectURL" ) ) {
					if( attrProjectURL != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrProjectURL = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PublishURI" ) ) {
					if( attrPublishURI != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPublishURI = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjImport" ) ) {
					if( attrJSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjInterface" ) ) {
					if( attrJSchemaObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjMembers" ) ) {
					if( attrJSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSchemaObjImplementation" ) ) {
					if( attrJSchemaObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSchemaObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjMembers" ) ) {
					if( attrJDb2LUWSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjImpl" ) ) {
					if( attrJDb2LUWSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWSchemaObjImport" ) ) {
					if( attrJDb2LUWSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjMembers" ) ) {
					if( attrJMSSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjImpl" ) ) {
					if( attrJMSSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlSchemaObjImport" ) ) {
					if( attrJMSSqlSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjMembers" ) ) {
					if( attrJMySqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjImpl" ) ) {
					if( attrJMySqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlSchemaObjImport" ) ) {
					if( attrJMySqlSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjMembers" ) ) {
					if( attrJOracleSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjImpl" ) ) {
					if( attrJOracleSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleSchemaObjImport" ) ) {
					if( attrJOracleSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjMembers" ) ) {
					if( attrJPgSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjImpl" ) ) {
					if( attrJPgSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlSchemaObjImport" ) ) {
					if( attrJPgSqlSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjMembers" ) ) {
					if( attrJRamSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjImpl" ) ) {
					if( attrJRamSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamSchemaObjImport" ) ) {
					if( attrJRamSchemaObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamSchemaObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgSchemaImport" ) ) {
					if( attrJXMsgSchemaImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgSchemaFormatters" ) ) {
					if( attrJXMsgSchemaFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgSchemaFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientSchemaImport" ) ) {
					if( attrJXMsgClientSchemaImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientSchemaBody" ) ) {
					if( attrJXMsgClientSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaBody" ) ) {
					if( attrJXMsgRqstSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaImport" ) ) {
					if( attrJXMsgRqstSchemaImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaWireParsers" ) ) {
					if( attrJXMsgRqstSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaXsdSpec" ) ) {
					if( attrJXMsgRqstSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstSchemaXsdElementList" ) ) {
					if( attrJXMsgRqstSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaBody" ) ) {
					if( attrJXMsgRspnSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaImport" ) ) {
					if( attrJXMsgRspnSchemaImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaWireParsers" ) ) {
					if( attrJXMsgRspnSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaXsdElementList" ) ) {
					if( attrJXMsgRspnSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnSchemaXsdSpec" ) ) {
					if( attrJXMsgRspnSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSchemaObjInclude" ) ) {
					if( attrCppSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSchemaObjInterface" ) ) {
					if( attrCppSchemaObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSchemaObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSchemaObjMembers" ) ) {
					if( attrCppSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSchemaObjImplementation" ) ) {
					if( attrCppSchemaObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSchemaObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWSchemaObjMembers" ) ) {
					if( attrCppDb2LUWSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWSchemaObjImpl" ) ) {
					if( attrCppDb2LUWSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWSchemaObjInclude" ) ) {
					if( attrCppDb2LUWSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlSchemaObjMembers" ) ) {
					if( attrCppMSSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlSchemaObjImpl" ) ) {
					if( attrCppMSSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlSchemaObjInclude" ) ) {
					if( attrCppMSSqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlSchemaObjMembers" ) ) {
					if( attrCppMySqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlSchemaObjImpl" ) ) {
					if( attrCppMySqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlSchemaObjInclude" ) ) {
					if( attrCppMySqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleSchemaObjMembers" ) ) {
					if( attrCppOracleSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleSchemaObjImpl" ) ) {
					if( attrCppOracleSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleSchemaObjInclude" ) ) {
					if( attrCppOracleSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlSchemaObjMembers" ) ) {
					if( attrCppPgSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlSchemaObjImpl" ) ) {
					if( attrCppPgSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlSchemaObjInclude" ) ) {
					if( attrCppPgSqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamSchemaObjMembers" ) ) {
					if( attrCppRamSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamSchemaObjImpl" ) ) {
					if( attrCppRamSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamSchemaObjInclude" ) ) {
					if( attrCppRamSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgSchemaInclude" ) ) {
					if( attrCppXMsgSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgSchemaFormatters" ) ) {
					if( attrCppXMsgSchemaFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgSchemaFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgClientSchemaInclude" ) ) {
					if( attrCppXMsgClientSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgClientSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgClientSchemaBody" ) ) {
					if( attrCppXMsgClientSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgClientSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstSchemaBody" ) ) {
					if( attrCppXMsgRqstSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstSchemaInclude" ) ) {
					if( attrCppXMsgRqstSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstSchemaWireParsers" ) ) {
					if( attrCppXMsgRqstSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstSchemaXsdSpec" ) ) {
					if( attrCppXMsgRqstSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstSchemaXsdElementList" ) ) {
					if( attrCppXMsgRqstSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnSchemaBody" ) ) {
					if( attrCppXMsgRspnSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnSchemaInclude" ) ) {
					if( attrCppXMsgRspnSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnSchemaWireParsers" ) ) {
					if( attrCppXMsgRspnSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnSchemaXsdElementList" ) ) {
					if( attrCppXMsgRspnSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnSchemaXsdSpec" ) ) {
					if( attrCppXMsgRspnSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSchemaObjInclude" ) ) {
					if( attrHppSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSchemaObjInterface" ) ) {
					if( attrHppSchemaObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSchemaObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSchemaObjMembers" ) ) {
					if( attrHppSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSchemaObjImplementation" ) ) {
					if( attrHppSchemaObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSchemaObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWSchemaObjMembers" ) ) {
					if( attrHppDb2LUWSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWSchemaObjImpl" ) ) {
					if( attrHppDb2LUWSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWSchemaObjInclude" ) ) {
					if( attrHppDb2LUWSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlSchemaObjMembers" ) ) {
					if( attrHppMSSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlSchemaObjImpl" ) ) {
					if( attrHppMSSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlSchemaObjInclude" ) ) {
					if( attrHppMSSqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlSchemaObjMembers" ) ) {
					if( attrHppMySqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlSchemaObjImpl" ) ) {
					if( attrHppMySqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlSchemaObjInclude" ) ) {
					if( attrHppMySqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleSchemaObjMembers" ) ) {
					if( attrHppOracleSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleSchemaObjImpl" ) ) {
					if( attrHppOracleSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleSchemaObjInclude" ) ) {
					if( attrHppOracleSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlSchemaObjMembers" ) ) {
					if( attrHppPgSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlSchemaObjImpl" ) ) {
					if( attrHppPgSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlSchemaObjInclude" ) ) {
					if( attrHppPgSqlSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamSchemaObjMembers" ) ) {
					if( attrHppRamSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamSchemaObjImpl" ) ) {
					if( attrHppRamSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamSchemaObjInclude" ) ) {
					if( attrHppRamSchemaObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamSchemaObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgSchemaInclude" ) ) {
					if( attrHppXMsgSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgSchemaFormatters" ) ) {
					if( attrHppXMsgSchemaFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgSchemaFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgClientSchemaInclude" ) ) {
					if( attrHppXMsgClientSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgClientSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgClientSchemaBody" ) ) {
					if( attrHppXMsgClientSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgClientSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstSchemaBody" ) ) {
					if( attrHppXMsgRqstSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstSchemaInclude" ) ) {
					if( attrHppXMsgRqstSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstSchemaWireParsers" ) ) {
					if( attrHppXMsgRqstSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstSchemaXsdSpec" ) ) {
					if( attrHppXMsgRqstSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstSchemaXsdElementList" ) ) {
					if( attrHppXMsgRqstSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnSchemaBody" ) ) {
					if( attrHppXMsgRspnSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnSchemaInclude" ) ) {
					if( attrHppXMsgRspnSchemaInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnSchemaInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnSchemaWireParsers" ) ) {
					if( attrHppXMsgRspnSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnSchemaXsdElementList" ) ) {
					if( attrHppXMsgRspnSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnSchemaXsdSpec" ) ) {
					if( attrHppXMsgRspnSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSchemaObjUsing" ) ) {
					if( attrCsSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSchemaObjInterface" ) ) {
					if( attrCsSchemaObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSchemaObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSchemaObjMembers" ) ) {
					if( attrCsSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSchemaObjImplementation" ) ) {
					if( attrCsSchemaObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSchemaObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWSchemaObjMembers" ) ) {
					if( attrCsDb2LUWSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWSchemaObjImpl" ) ) {
					if( attrCsDb2LUWSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWSchemaObjUsing" ) ) {
					if( attrCsDb2LUWSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlSchemaObjMembers" ) ) {
					if( attrCsMSSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlSchemaObjImpl" ) ) {
					if( attrCsMSSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlSchemaObjUsing" ) ) {
					if( attrCsMSSqlSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlSchemaObjMembers" ) ) {
					if( attrCsMySqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlSchemaObjImpl" ) ) {
					if( attrCsMySqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlSchemaObjUsing" ) ) {
					if( attrCsMySqlSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleSchemaObjMembers" ) ) {
					if( attrCsOracleSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleSchemaObjImpl" ) ) {
					if( attrCsOracleSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleSchemaObjUsing" ) ) {
					if( attrCsOracleSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlSchemaObjMembers" ) ) {
					if( attrCsPgSqlSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlSchemaObjImpl" ) ) {
					if( attrCsPgSqlSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlSchemaObjUsing" ) ) {
					if( attrCsPgSqlSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamSchemaObjMembers" ) ) {
					if( attrCsRamSchemaObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamSchemaObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamSchemaObjImpl" ) ) {
					if( attrCsRamSchemaObjImpl != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamSchemaObjImpl = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamSchemaObjUsing" ) ) {
					if( attrCsRamSchemaObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamSchemaObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgSchemaUsing" ) ) {
					if( attrCsXMsgSchemaUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgSchemaUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgSchemaFormatters" ) ) {
					if( attrCsXMsgSchemaFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgSchemaFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgClientSchemaUsing" ) ) {
					if( attrCsXMsgClientSchemaUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgClientSchemaUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgClientSchemaBody" ) ) {
					if( attrCsXMsgClientSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgClientSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstSchemaBody" ) ) {
					if( attrCsXMsgRqstSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstSchemaUsing" ) ) {
					if( attrCsXMsgRqstSchemaUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstSchemaUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstSchemaWireParsers" ) ) {
					if( attrCsXMsgRqstSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstSchemaXsdSpec" ) ) {
					if( attrCsXMsgRqstSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstSchemaXsdElementList" ) ) {
					if( attrCsXMsgRqstSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnSchemaBody" ) ) {
					if( attrCsXMsgRspnSchemaBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnSchemaBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnSchemaUsing" ) ) {
					if( attrCsXMsgRspnSchemaUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnSchemaUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnSchemaWireParsers" ) ) {
					if( attrCsXMsgRspnSchemaWireParsers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnSchemaWireParsers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnSchemaXsdElementList" ) ) {
					if( attrCsXMsgRspnSchemaXsdElementList != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnSchemaXsdElementList = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnSchemaXsdSpec" ) ) {
					if( attrCsXMsgRspnSchemaXsdSpec != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnSchemaXsdSpec = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefaultLicense" ) ) {
					if( attrDefaultLicense != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefaultLicense = attrs.getValue( idxAttr );
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
			if( attrCopyrightPeriod == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CopyrightPeriod" );
			}
			if( attrCopyrightHolder == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"CopyrightHolder" );
			}
			if( attrAuthorEMail == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"AuthorEMail" );
			}
			if( attrProjectURL == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"ProjectURL" );
			}
			if( attrPublishURI == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PublishURI" );
			}

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "Name", attrName );
			curContext.putNamedValue( "DbName", attrDbName );
			curContext.putNamedValue( "ShortName", attrShortName );
			curContext.putNamedValue( "Label", attrLabel );
			curContext.putNamedValue( "ShortDescription", attrShortDescription );
			curContext.putNamedValue( "Description", attrDescription );
			curContext.putNamedValue( "CopyrightPeriod", attrCopyrightPeriod );
			curContext.putNamedValue( "CopyrightHolder", attrCopyrightHolder );
			curContext.putNamedValue( "AuthorEMail", attrAuthorEMail );
			curContext.putNamedValue( "ProjectURL", attrProjectURL );
			curContext.putNamedValue( "PublishURI", attrPublishURI );
			curContext.putNamedValue( "JSchemaObjImport", attrJSchemaObjImport );
			curContext.putNamedValue( "JSchemaObjInterface", attrJSchemaObjInterface );
			curContext.putNamedValue( "JSchemaObjMembers", attrJSchemaObjMembers );
			curContext.putNamedValue( "JSchemaObjImplementation", attrJSchemaObjImplementation );
			curContext.putNamedValue( "JDb2LUWSchemaObjMembers", attrJDb2LUWSchemaObjMembers );
			curContext.putNamedValue( "JDb2LUWSchemaObjImpl", attrJDb2LUWSchemaObjImpl );
			curContext.putNamedValue( "JDb2LUWSchemaObjImport", attrJDb2LUWSchemaObjImport );
			curContext.putNamedValue( "JMSSqlSchemaObjMembers", attrJMSSqlSchemaObjMembers );
			curContext.putNamedValue( "JMSSqlSchemaObjImpl", attrJMSSqlSchemaObjImpl );
			curContext.putNamedValue( "JMSSqlSchemaObjImport", attrJMSSqlSchemaObjImport );
			curContext.putNamedValue( "JMySqlSchemaObjMembers", attrJMySqlSchemaObjMembers );
			curContext.putNamedValue( "JMySqlSchemaObjImpl", attrJMySqlSchemaObjImpl );
			curContext.putNamedValue( "JMySqlSchemaObjImport", attrJMySqlSchemaObjImport );
			curContext.putNamedValue( "JOracleSchemaObjMembers", attrJOracleSchemaObjMembers );
			curContext.putNamedValue( "JOracleSchemaObjImpl", attrJOracleSchemaObjImpl );
			curContext.putNamedValue( "JOracleSchemaObjImport", attrJOracleSchemaObjImport );
			curContext.putNamedValue( "JPgSqlSchemaObjMembers", attrJPgSqlSchemaObjMembers );
			curContext.putNamedValue( "JPgSqlSchemaObjImpl", attrJPgSqlSchemaObjImpl );
			curContext.putNamedValue( "JPgSqlSchemaObjImport", attrJPgSqlSchemaObjImport );
			curContext.putNamedValue( "JRamSchemaObjMembers", attrJRamSchemaObjMembers );
			curContext.putNamedValue( "JRamSchemaObjImpl", attrJRamSchemaObjImpl );
			curContext.putNamedValue( "JRamSchemaObjImport", attrJRamSchemaObjImport );
			curContext.putNamedValue( "JXMsgSchemaImport", attrJXMsgSchemaImport );
			curContext.putNamedValue( "JXMsgSchemaFormatters", attrJXMsgSchemaFormatters );
			curContext.putNamedValue( "JXMsgClientSchemaImport", attrJXMsgClientSchemaImport );
			curContext.putNamedValue( "JXMsgClientSchemaBody", attrJXMsgClientSchemaBody );
			curContext.putNamedValue( "JXMsgRqstSchemaBody", attrJXMsgRqstSchemaBody );
			curContext.putNamedValue( "JXMsgRqstSchemaImport", attrJXMsgRqstSchemaImport );
			curContext.putNamedValue( "JXMsgRqstSchemaWireParsers", attrJXMsgRqstSchemaWireParsers );
			curContext.putNamedValue( "JXMsgRqstSchemaXsdSpec", attrJXMsgRqstSchemaXsdSpec );
			curContext.putNamedValue( "JXMsgRqstSchemaXsdElementList", attrJXMsgRqstSchemaXsdElementList );
			curContext.putNamedValue( "JXMsgRspnSchemaBody", attrJXMsgRspnSchemaBody );
			curContext.putNamedValue( "JXMsgRspnSchemaImport", attrJXMsgRspnSchemaImport );
			curContext.putNamedValue( "JXMsgRspnSchemaWireParsers", attrJXMsgRspnSchemaWireParsers );
			curContext.putNamedValue( "JXMsgRspnSchemaXsdElementList", attrJXMsgRspnSchemaXsdElementList );
			curContext.putNamedValue( "JXMsgRspnSchemaXsdSpec", attrJXMsgRspnSchemaXsdSpec );
			curContext.putNamedValue( "CppSchemaObjInclude", attrCppSchemaObjInclude );
			curContext.putNamedValue( "CppSchemaObjInterface", attrCppSchemaObjInterface );
			curContext.putNamedValue( "CppSchemaObjMembers", attrCppSchemaObjMembers );
			curContext.putNamedValue( "CppSchemaObjImplementation", attrCppSchemaObjImplementation );
			curContext.putNamedValue( "CppDb2LUWSchemaObjMembers", attrCppDb2LUWSchemaObjMembers );
			curContext.putNamedValue( "CppDb2LUWSchemaObjImpl", attrCppDb2LUWSchemaObjImpl );
			curContext.putNamedValue( "CppDb2LUWSchemaObjInclude", attrCppDb2LUWSchemaObjInclude );
			curContext.putNamedValue( "CppMSSqlSchemaObjMembers", attrCppMSSqlSchemaObjMembers );
			curContext.putNamedValue( "CppMSSqlSchemaObjImpl", attrCppMSSqlSchemaObjImpl );
			curContext.putNamedValue( "CppMSSqlSchemaObjInclude", attrCppMSSqlSchemaObjInclude );
			curContext.putNamedValue( "CppMySqlSchemaObjMembers", attrCppMySqlSchemaObjMembers );
			curContext.putNamedValue( "CppMySqlSchemaObjImpl", attrCppMySqlSchemaObjImpl );
			curContext.putNamedValue( "CppMySqlSchemaObjInclude", attrCppMySqlSchemaObjInclude );
			curContext.putNamedValue( "CppOracleSchemaObjMembers", attrCppOracleSchemaObjMembers );
			curContext.putNamedValue( "CppOracleSchemaObjImpl", attrCppOracleSchemaObjImpl );
			curContext.putNamedValue( "CppOracleSchemaObjInclude", attrCppOracleSchemaObjInclude );
			curContext.putNamedValue( "CppPgSqlSchemaObjMembers", attrCppPgSqlSchemaObjMembers );
			curContext.putNamedValue( "CppPgSqlSchemaObjImpl", attrCppPgSqlSchemaObjImpl );
			curContext.putNamedValue( "CppPgSqlSchemaObjInclude", attrCppPgSqlSchemaObjInclude );
			curContext.putNamedValue( "CppRamSchemaObjMembers", attrCppRamSchemaObjMembers );
			curContext.putNamedValue( "CppRamSchemaObjImpl", attrCppRamSchemaObjImpl );
			curContext.putNamedValue( "CppRamSchemaObjInclude", attrCppRamSchemaObjInclude );
			curContext.putNamedValue( "CppXMsgSchemaInclude", attrCppXMsgSchemaInclude );
			curContext.putNamedValue( "CppXMsgSchemaFormatters", attrCppXMsgSchemaFormatters );
			curContext.putNamedValue( "CppXMsgClientSchemaInclude", attrCppXMsgClientSchemaInclude );
			curContext.putNamedValue( "CppXMsgClientSchemaBody", attrCppXMsgClientSchemaBody );
			curContext.putNamedValue( "CppXMsgRqstSchemaBody", attrCppXMsgRqstSchemaBody );
			curContext.putNamedValue( "CppXMsgRqstSchemaInclude", attrCppXMsgRqstSchemaInclude );
			curContext.putNamedValue( "CppXMsgRqstSchemaWireParsers", attrCppXMsgRqstSchemaWireParsers );
			curContext.putNamedValue( "CppXMsgRqstSchemaXsdSpec", attrCppXMsgRqstSchemaXsdSpec );
			curContext.putNamedValue( "CppXMsgRqstSchemaXsdElementList", attrCppXMsgRqstSchemaXsdElementList );
			curContext.putNamedValue( "CppXMsgRspnSchemaBody", attrCppXMsgRspnSchemaBody );
			curContext.putNamedValue( "CppXMsgRspnSchemaInclude", attrCppXMsgRspnSchemaInclude );
			curContext.putNamedValue( "CppXMsgRspnSchemaWireParsers", attrCppXMsgRspnSchemaWireParsers );
			curContext.putNamedValue( "CppXMsgRspnSchemaXsdElementList", attrCppXMsgRspnSchemaXsdElementList );
			curContext.putNamedValue( "CppXMsgRspnSchemaXsdSpec", attrCppXMsgRspnSchemaXsdSpec );
			curContext.putNamedValue( "HppSchemaObjInclude", attrHppSchemaObjInclude );
			curContext.putNamedValue( "HppSchemaObjInterface", attrHppSchemaObjInterface );
			curContext.putNamedValue( "HppSchemaObjMembers", attrHppSchemaObjMembers );
			curContext.putNamedValue( "HppSchemaObjImplementation", attrHppSchemaObjImplementation );
			curContext.putNamedValue( "HppDb2LUWSchemaObjMembers", attrHppDb2LUWSchemaObjMembers );
			curContext.putNamedValue( "HppDb2LUWSchemaObjImpl", attrHppDb2LUWSchemaObjImpl );
			curContext.putNamedValue( "HppDb2LUWSchemaObjInclude", attrHppDb2LUWSchemaObjInclude );
			curContext.putNamedValue( "HppMSSqlSchemaObjMembers", attrHppMSSqlSchemaObjMembers );
			curContext.putNamedValue( "HppMSSqlSchemaObjImpl", attrHppMSSqlSchemaObjImpl );
			curContext.putNamedValue( "HppMSSqlSchemaObjInclude", attrHppMSSqlSchemaObjInclude );
			curContext.putNamedValue( "HppMySqlSchemaObjMembers", attrHppMySqlSchemaObjMembers );
			curContext.putNamedValue( "HppMySqlSchemaObjImpl", attrHppMySqlSchemaObjImpl );
			curContext.putNamedValue( "HppMySqlSchemaObjInclude", attrHppMySqlSchemaObjInclude );
			curContext.putNamedValue( "HppOracleSchemaObjMembers", attrHppOracleSchemaObjMembers );
			curContext.putNamedValue( "HppOracleSchemaObjImpl", attrHppOracleSchemaObjImpl );
			curContext.putNamedValue( "HppOracleSchemaObjInclude", attrHppOracleSchemaObjInclude );
			curContext.putNamedValue( "HppPgSqlSchemaObjMembers", attrHppPgSqlSchemaObjMembers );
			curContext.putNamedValue( "HppPgSqlSchemaObjImpl", attrHppPgSqlSchemaObjImpl );
			curContext.putNamedValue( "HppPgSqlSchemaObjInclude", attrHppPgSqlSchemaObjInclude );
			curContext.putNamedValue( "HppRamSchemaObjMembers", attrHppRamSchemaObjMembers );
			curContext.putNamedValue( "HppRamSchemaObjImpl", attrHppRamSchemaObjImpl );
			curContext.putNamedValue( "HppRamSchemaObjInclude", attrHppRamSchemaObjInclude );
			curContext.putNamedValue( "HppXMsgSchemaInclude", attrHppXMsgSchemaInclude );
			curContext.putNamedValue( "HppXMsgSchemaFormatters", attrHppXMsgSchemaFormatters );
			curContext.putNamedValue( "HppXMsgClientSchemaInclude", attrHppXMsgClientSchemaInclude );
			curContext.putNamedValue( "HppXMsgClientSchemaBody", attrHppXMsgClientSchemaBody );
			curContext.putNamedValue( "HppXMsgRqstSchemaBody", attrHppXMsgRqstSchemaBody );
			curContext.putNamedValue( "HppXMsgRqstSchemaInclude", attrHppXMsgRqstSchemaInclude );
			curContext.putNamedValue( "HppXMsgRqstSchemaWireParsers", attrHppXMsgRqstSchemaWireParsers );
			curContext.putNamedValue( "HppXMsgRqstSchemaXsdSpec", attrHppXMsgRqstSchemaXsdSpec );
			curContext.putNamedValue( "HppXMsgRqstSchemaXsdElementList", attrHppXMsgRqstSchemaXsdElementList );
			curContext.putNamedValue( "HppXMsgRspnSchemaBody", attrHppXMsgRspnSchemaBody );
			curContext.putNamedValue( "HppXMsgRspnSchemaInclude", attrHppXMsgRspnSchemaInclude );
			curContext.putNamedValue( "HppXMsgRspnSchemaWireParsers", attrHppXMsgRspnSchemaWireParsers );
			curContext.putNamedValue( "HppXMsgRspnSchemaXsdElementList", attrHppXMsgRspnSchemaXsdElementList );
			curContext.putNamedValue( "HppXMsgRspnSchemaXsdSpec", attrHppXMsgRspnSchemaXsdSpec );
			curContext.putNamedValue( "CsSchemaObjUsing", attrCsSchemaObjUsing );
			curContext.putNamedValue( "CsSchemaObjInterface", attrCsSchemaObjInterface );
			curContext.putNamedValue( "CsSchemaObjMembers", attrCsSchemaObjMembers );
			curContext.putNamedValue( "CsSchemaObjImplementation", attrCsSchemaObjImplementation );
			curContext.putNamedValue( "CsDb2LUWSchemaObjMembers", attrCsDb2LUWSchemaObjMembers );
			curContext.putNamedValue( "CsDb2LUWSchemaObjImpl", attrCsDb2LUWSchemaObjImpl );
			curContext.putNamedValue( "CsDb2LUWSchemaObjUsing", attrCsDb2LUWSchemaObjUsing );
			curContext.putNamedValue( "CsMSSqlSchemaObjMembers", attrCsMSSqlSchemaObjMembers );
			curContext.putNamedValue( "CsMSSqlSchemaObjImpl", attrCsMSSqlSchemaObjImpl );
			curContext.putNamedValue( "CsMSSqlSchemaObjUsing", attrCsMSSqlSchemaObjUsing );
			curContext.putNamedValue( "CsMySqlSchemaObjMembers", attrCsMySqlSchemaObjMembers );
			curContext.putNamedValue( "CsMySqlSchemaObjImpl", attrCsMySqlSchemaObjImpl );
			curContext.putNamedValue( "CsMySqlSchemaObjUsing", attrCsMySqlSchemaObjUsing );
			curContext.putNamedValue( "CsOracleSchemaObjMembers", attrCsOracleSchemaObjMembers );
			curContext.putNamedValue( "CsOracleSchemaObjImpl", attrCsOracleSchemaObjImpl );
			curContext.putNamedValue( "CsOracleSchemaObjUsing", attrCsOracleSchemaObjUsing );
			curContext.putNamedValue( "CsPgSqlSchemaObjMembers", attrCsPgSqlSchemaObjMembers );
			curContext.putNamedValue( "CsPgSqlSchemaObjImpl", attrCsPgSqlSchemaObjImpl );
			curContext.putNamedValue( "CsPgSqlSchemaObjUsing", attrCsPgSqlSchemaObjUsing );
			curContext.putNamedValue( "CsRamSchemaObjMembers", attrCsRamSchemaObjMembers );
			curContext.putNamedValue( "CsRamSchemaObjImpl", attrCsRamSchemaObjImpl );
			curContext.putNamedValue( "CsRamSchemaObjUsing", attrCsRamSchemaObjUsing );
			curContext.putNamedValue( "CsXMsgSchemaUsing", attrCsXMsgSchemaUsing );
			curContext.putNamedValue( "CsXMsgSchemaFormatters", attrCsXMsgSchemaFormatters );
			curContext.putNamedValue( "CsXMsgClientSchemaUsing", attrCsXMsgClientSchemaUsing );
			curContext.putNamedValue( "CsXMsgClientSchemaBody", attrCsXMsgClientSchemaBody );
			curContext.putNamedValue( "CsXMsgRqstSchemaBody", attrCsXMsgRqstSchemaBody );
			curContext.putNamedValue( "CsXMsgRqstSchemaUsing", attrCsXMsgRqstSchemaUsing );
			curContext.putNamedValue( "CsXMsgRqstSchemaWireParsers", attrCsXMsgRqstSchemaWireParsers );
			curContext.putNamedValue( "CsXMsgRqstSchemaXsdSpec", attrCsXMsgRqstSchemaXsdSpec );
			curContext.putNamedValue( "CsXMsgRqstSchemaXsdElementList", attrCsXMsgRqstSchemaXsdElementList );
			curContext.putNamedValue( "CsXMsgRspnSchemaBody", attrCsXMsgRspnSchemaBody );
			curContext.putNamedValue( "CsXMsgRspnSchemaUsing", attrCsXMsgRspnSchemaUsing );
			curContext.putNamedValue( "CsXMsgRspnSchemaWireParsers", attrCsXMsgRspnSchemaWireParsers );
			curContext.putNamedValue( "CsXMsgRspnSchemaXsdElementList", attrCsXMsgRspnSchemaXsdElementList );
			curContext.putNamedValue( "CsXMsgRspnSchemaXsdSpec", attrCsXMsgRspnSchemaXsdSpec );
			curContext.putNamedValue( "DefaultLicense", attrDefaultLicense );

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

			String natDbName = attrDbName;
			editBuff.setOptionalDbName( natDbName );

			String natShortName = attrShortName;
			editBuff.setOptionalShortName( natShortName );

			String natLabel = attrLabel;
			editBuff.setOptionalLabel( natLabel );

			String natShortDescription = attrShortDescription;
			editBuff.setOptionalShortDescription( natShortDescription );

			String natDescription = attrDescription;
			editBuff.setOptionalDescription( natDescription );

			String natCopyrightPeriod = attrCopyrightPeriod;
			editBuff.setRequiredCopyrightPeriod( natCopyrightPeriod );

			String natCopyrightHolder = attrCopyrightHolder;
			editBuff.setRequiredCopyrightHolder( natCopyrightHolder );

			String natAuthorEMail = attrAuthorEMail;
			editBuff.setRequiredAuthorEMail( natAuthorEMail );

			String natProjectURL = attrProjectURL;
			editBuff.setRequiredProjectURL( natProjectURL );

			String natPublishURI = attrPublishURI;
			editBuff.setRequiredPublishURI( natPublishURI );

			String natJSchemaObjImport = attrJSchemaObjImport;
			editBuff.setOptionalJSchemaObjImport( natJSchemaObjImport );

			String natJSchemaObjInterface = attrJSchemaObjInterface;
			editBuff.setOptionalJSchemaObjInterface( natJSchemaObjInterface );

			String natJSchemaObjMembers = attrJSchemaObjMembers;
			editBuff.setOptionalJSchemaObjMembers( natJSchemaObjMembers );

			String natJSchemaObjImplementation = attrJSchemaObjImplementation;
			editBuff.setOptionalJSchemaObjImplementation( natJSchemaObjImplementation );

			String natJDb2LUWSchemaObjMembers = attrJDb2LUWSchemaObjMembers;
			editBuff.setOptionalJDb2LUWSchemaObjMembers( natJDb2LUWSchemaObjMembers );

			String natJDb2LUWSchemaObjImpl = attrJDb2LUWSchemaObjImpl;
			editBuff.setOptionalJDb2LUWSchemaObjImpl( natJDb2LUWSchemaObjImpl );

			String natJDb2LUWSchemaObjImport = attrJDb2LUWSchemaObjImport;
			editBuff.setOptionalJDb2LUWSchemaObjImport( natJDb2LUWSchemaObjImport );

			String natJMSSqlSchemaObjMembers = attrJMSSqlSchemaObjMembers;
			editBuff.setOptionalJMSSqlSchemaObjMembers( natJMSSqlSchemaObjMembers );

			String natJMSSqlSchemaObjImpl = attrJMSSqlSchemaObjImpl;
			editBuff.setOptionalJMSSqlSchemaObjImpl( natJMSSqlSchemaObjImpl );

			String natJMSSqlSchemaObjImport = attrJMSSqlSchemaObjImport;
			editBuff.setOptionalJMSSqlSchemaObjImport( natJMSSqlSchemaObjImport );

			String natJMySqlSchemaObjMembers = attrJMySqlSchemaObjMembers;
			editBuff.setOptionalJMySqlSchemaObjMembers( natJMySqlSchemaObjMembers );

			String natJMySqlSchemaObjImpl = attrJMySqlSchemaObjImpl;
			editBuff.setOptionalJMySqlSchemaObjImpl( natJMySqlSchemaObjImpl );

			String natJMySqlSchemaObjImport = attrJMySqlSchemaObjImport;
			editBuff.setOptionalJMySqlSchemaObjImport( natJMySqlSchemaObjImport );

			String natJOracleSchemaObjMembers = attrJOracleSchemaObjMembers;
			editBuff.setOptionalJOracleSchemaObjMembers( natJOracleSchemaObjMembers );

			String natJOracleSchemaObjImpl = attrJOracleSchemaObjImpl;
			editBuff.setOptionalJOracleSchemaObjImpl( natJOracleSchemaObjImpl );

			String natJOracleSchemaObjImport = attrJOracleSchemaObjImport;
			editBuff.setOptionalJOracleSchemaObjImport( natJOracleSchemaObjImport );

			String natJPgSqlSchemaObjMembers = attrJPgSqlSchemaObjMembers;
			editBuff.setOptionalJPgSqlSchemaObjMembers( natJPgSqlSchemaObjMembers );

			String natJPgSqlSchemaObjImpl = attrJPgSqlSchemaObjImpl;
			editBuff.setOptionalJPgSqlSchemaObjImpl( natJPgSqlSchemaObjImpl );

			String natJPgSqlSchemaObjImport = attrJPgSqlSchemaObjImport;
			editBuff.setOptionalJPgSqlSchemaObjImport( natJPgSqlSchemaObjImport );

			String natJRamSchemaObjMembers = attrJRamSchemaObjMembers;
			editBuff.setOptionalJRamSchemaObjMembers( natJRamSchemaObjMembers );

			String natJRamSchemaObjImpl = attrJRamSchemaObjImpl;
			editBuff.setOptionalJRamSchemaObjImpl( natJRamSchemaObjImpl );

			String natJRamSchemaObjImport = attrJRamSchemaObjImport;
			editBuff.setOptionalJRamSchemaObjImport( natJRamSchemaObjImport );

			String natJXMsgSchemaImport = attrJXMsgSchemaImport;
			editBuff.setOptionalJXMsgSchemaImport( natJXMsgSchemaImport );

			String natJXMsgSchemaFormatters = attrJXMsgSchemaFormatters;
			editBuff.setOptionalJXMsgSchemaFormatters( natJXMsgSchemaFormatters );

			String natJXMsgClientSchemaImport = attrJXMsgClientSchemaImport;
			editBuff.setOptionalJXMsgClientSchemaImport( natJXMsgClientSchemaImport );

			String natJXMsgClientSchemaBody = attrJXMsgClientSchemaBody;
			editBuff.setOptionalJXMsgClientSchemaBody( natJXMsgClientSchemaBody );

			String natJXMsgRqstSchemaBody = attrJXMsgRqstSchemaBody;
			editBuff.setOptionalJXMsgRqstSchemaBody( natJXMsgRqstSchemaBody );

			String natJXMsgRqstSchemaImport = attrJXMsgRqstSchemaImport;
			editBuff.setOptionalJXMsgRqstSchemaImport( natJXMsgRqstSchemaImport );

			String natJXMsgRqstSchemaWireParsers = attrJXMsgRqstSchemaWireParsers;
			editBuff.setOptionalJXMsgRqstSchemaWireParsers( natJXMsgRqstSchemaWireParsers );

			String natJXMsgRqstSchemaXsdSpec = attrJXMsgRqstSchemaXsdSpec;
			editBuff.setOptionalJXMsgRqstSchemaXsdSpec( natJXMsgRqstSchemaXsdSpec );

			String natJXMsgRqstSchemaXsdElementList = attrJXMsgRqstSchemaXsdElementList;
			editBuff.setOptionalJXMsgRqstSchemaXsdElementList( natJXMsgRqstSchemaXsdElementList );

			String natJXMsgRspnSchemaBody = attrJXMsgRspnSchemaBody;
			editBuff.setOptionalJXMsgRspnSchemaBody( natJXMsgRspnSchemaBody );

			String natJXMsgRspnSchemaImport = attrJXMsgRspnSchemaImport;
			editBuff.setOptionalJXMsgRspnSchemaImport( natJXMsgRspnSchemaImport );

			String natJXMsgRspnSchemaWireParsers = attrJXMsgRspnSchemaWireParsers;
			editBuff.setOptionalJXMsgRspnSchemaWireParsers( natJXMsgRspnSchemaWireParsers );

			String natJXMsgRspnSchemaXsdElementList = attrJXMsgRspnSchemaXsdElementList;
			editBuff.setOptionalJXMsgRspnSchemaXsdElementList( natJXMsgRspnSchemaXsdElementList );

			String natJXMsgRspnSchemaXsdSpec = attrJXMsgRspnSchemaXsdSpec;
			editBuff.setOptionalJXMsgRspnSchemaXsdSpec( natJXMsgRspnSchemaXsdSpec );

			String natCppSchemaObjInclude = attrCppSchemaObjInclude;
			editBuff.setOptionalCppSchemaObjInclude( natCppSchemaObjInclude );

			String natCppSchemaObjInterface = attrCppSchemaObjInterface;
			editBuff.setOptionalCppSchemaObjInterface( natCppSchemaObjInterface );

			String natCppSchemaObjMembers = attrCppSchemaObjMembers;
			editBuff.setOptionalCppSchemaObjMembers( natCppSchemaObjMembers );

			String natCppSchemaObjImplementation = attrCppSchemaObjImplementation;
			editBuff.setOptionalCppSchemaObjImplementation( natCppSchemaObjImplementation );

			String natCppDb2LUWSchemaObjMembers = attrCppDb2LUWSchemaObjMembers;
			editBuff.setOptionalCppDb2LUWSchemaObjMembers( natCppDb2LUWSchemaObjMembers );

			String natCppDb2LUWSchemaObjImpl = attrCppDb2LUWSchemaObjImpl;
			editBuff.setOptionalCppDb2LUWSchemaObjImpl( natCppDb2LUWSchemaObjImpl );

			String natCppDb2LUWSchemaObjInclude = attrCppDb2LUWSchemaObjInclude;
			editBuff.setOptionalCppDb2LUWSchemaObjInclude( natCppDb2LUWSchemaObjInclude );

			String natCppMSSqlSchemaObjMembers = attrCppMSSqlSchemaObjMembers;
			editBuff.setOptionalCppMSSqlSchemaObjMembers( natCppMSSqlSchemaObjMembers );

			String natCppMSSqlSchemaObjImpl = attrCppMSSqlSchemaObjImpl;
			editBuff.setOptionalCppMSSqlSchemaObjImpl( natCppMSSqlSchemaObjImpl );

			String natCppMSSqlSchemaObjInclude = attrCppMSSqlSchemaObjInclude;
			editBuff.setOptionalCppMSSqlSchemaObjInclude( natCppMSSqlSchemaObjInclude );

			String natCppMySqlSchemaObjMembers = attrCppMySqlSchemaObjMembers;
			editBuff.setOptionalCppMySqlSchemaObjMembers( natCppMySqlSchemaObjMembers );

			String natCppMySqlSchemaObjImpl = attrCppMySqlSchemaObjImpl;
			editBuff.setOptionalCppMySqlSchemaObjImpl( natCppMySqlSchemaObjImpl );

			String natCppMySqlSchemaObjInclude = attrCppMySqlSchemaObjInclude;
			editBuff.setOptionalCppMySqlSchemaObjInclude( natCppMySqlSchemaObjInclude );

			String natCppOracleSchemaObjMembers = attrCppOracleSchemaObjMembers;
			editBuff.setOptionalCppOracleSchemaObjMembers( natCppOracleSchemaObjMembers );

			String natCppOracleSchemaObjImpl = attrCppOracleSchemaObjImpl;
			editBuff.setOptionalCppOracleSchemaObjImpl( natCppOracleSchemaObjImpl );

			String natCppOracleSchemaObjInclude = attrCppOracleSchemaObjInclude;
			editBuff.setOptionalCppOracleSchemaObjInclude( natCppOracleSchemaObjInclude );

			String natCppPgSqlSchemaObjMembers = attrCppPgSqlSchemaObjMembers;
			editBuff.setOptionalCppPgSqlSchemaObjMembers( natCppPgSqlSchemaObjMembers );

			String natCppPgSqlSchemaObjImpl = attrCppPgSqlSchemaObjImpl;
			editBuff.setOptionalCppPgSqlSchemaObjImpl( natCppPgSqlSchemaObjImpl );

			String natCppPgSqlSchemaObjInclude = attrCppPgSqlSchemaObjInclude;
			editBuff.setOptionalCppPgSqlSchemaObjInclude( natCppPgSqlSchemaObjInclude );

			String natCppRamSchemaObjMembers = attrCppRamSchemaObjMembers;
			editBuff.setOptionalCppRamSchemaObjMembers( natCppRamSchemaObjMembers );

			String natCppRamSchemaObjImpl = attrCppRamSchemaObjImpl;
			editBuff.setOptionalCppRamSchemaObjImpl( natCppRamSchemaObjImpl );

			String natCppRamSchemaObjInclude = attrCppRamSchemaObjInclude;
			editBuff.setOptionalCppRamSchemaObjInclude( natCppRamSchemaObjInclude );

			String natCppXMsgSchemaInclude = attrCppXMsgSchemaInclude;
			editBuff.setOptionalCppXMsgSchemaInclude( natCppXMsgSchemaInclude );

			String natCppXMsgSchemaFormatters = attrCppXMsgSchemaFormatters;
			editBuff.setOptionalCppXMsgSchemaFormatters( natCppXMsgSchemaFormatters );

			String natCppXMsgClientSchemaInclude = attrCppXMsgClientSchemaInclude;
			editBuff.setOptionalCppXMsgClientSchemaInclude( natCppXMsgClientSchemaInclude );

			String natCppXMsgClientSchemaBody = attrCppXMsgClientSchemaBody;
			editBuff.setOptionalCppXMsgClientSchemaBody( natCppXMsgClientSchemaBody );

			String natCppXMsgRqstSchemaBody = attrCppXMsgRqstSchemaBody;
			editBuff.setOptionalCppXMsgRqstSchemaBody( natCppXMsgRqstSchemaBody );

			String natCppXMsgRqstSchemaInclude = attrCppXMsgRqstSchemaInclude;
			editBuff.setOptionalCppXMsgRqstSchemaInclude( natCppXMsgRqstSchemaInclude );

			String natCppXMsgRqstSchemaWireParsers = attrCppXMsgRqstSchemaWireParsers;
			editBuff.setOptionalCppXMsgRqstSchemaWireParsers( natCppXMsgRqstSchemaWireParsers );

			String natCppXMsgRqstSchemaXsdSpec = attrCppXMsgRqstSchemaXsdSpec;
			editBuff.setOptionalCppXMsgRqstSchemaXsdSpec( natCppXMsgRqstSchemaXsdSpec );

			String natCppXMsgRqstSchemaXsdElementList = attrCppXMsgRqstSchemaXsdElementList;
			editBuff.setOptionalCppXMsgRqstSchemaXsdElementList( natCppXMsgRqstSchemaXsdElementList );

			String natCppXMsgRspnSchemaBody = attrCppXMsgRspnSchemaBody;
			editBuff.setOptionalCppXMsgRspnSchemaBody( natCppXMsgRspnSchemaBody );

			String natCppXMsgRspnSchemaInclude = attrCppXMsgRspnSchemaInclude;
			editBuff.setOptionalCppXMsgRspnSchemaInclude( natCppXMsgRspnSchemaInclude );

			String natCppXMsgRspnSchemaWireParsers = attrCppXMsgRspnSchemaWireParsers;
			editBuff.setOptionalCppXMsgRspnSchemaWireParsers( natCppXMsgRspnSchemaWireParsers );

			String natCppXMsgRspnSchemaXsdElementList = attrCppXMsgRspnSchemaXsdElementList;
			editBuff.setOptionalCppXMsgRspnSchemaXsdElementList( natCppXMsgRspnSchemaXsdElementList );

			String natCppXMsgRspnSchemaXsdSpec = attrCppXMsgRspnSchemaXsdSpec;
			editBuff.setOptionalCppXMsgRspnSchemaXsdSpec( natCppXMsgRspnSchemaXsdSpec );

			String natHppSchemaObjInclude = attrHppSchemaObjInclude;
			editBuff.setOptionalHppSchemaObjInclude( natHppSchemaObjInclude );

			String natHppSchemaObjInterface = attrHppSchemaObjInterface;
			editBuff.setOptionalHppSchemaObjInterface( natHppSchemaObjInterface );

			String natHppSchemaObjMembers = attrHppSchemaObjMembers;
			editBuff.setOptionalHppSchemaObjMembers( natHppSchemaObjMembers );

			String natHppSchemaObjImplementation = attrHppSchemaObjImplementation;
			editBuff.setOptionalHppSchemaObjImplementation( natHppSchemaObjImplementation );

			String natHppDb2LUWSchemaObjMembers = attrHppDb2LUWSchemaObjMembers;
			editBuff.setOptionalHppDb2LUWSchemaObjMembers( natHppDb2LUWSchemaObjMembers );

			String natHppDb2LUWSchemaObjImpl = attrHppDb2LUWSchemaObjImpl;
			editBuff.setOptionalHppDb2LUWSchemaObjImpl( natHppDb2LUWSchemaObjImpl );

			String natHppDb2LUWSchemaObjInclude = attrHppDb2LUWSchemaObjInclude;
			editBuff.setOptionalHppDb2LUWSchemaObjInclude( natHppDb2LUWSchemaObjInclude );

			String natHppMSSqlSchemaObjMembers = attrHppMSSqlSchemaObjMembers;
			editBuff.setOptionalHppMSSqlSchemaObjMembers( natHppMSSqlSchemaObjMembers );

			String natHppMSSqlSchemaObjImpl = attrHppMSSqlSchemaObjImpl;
			editBuff.setOptionalHppMSSqlSchemaObjImpl( natHppMSSqlSchemaObjImpl );

			String natHppMSSqlSchemaObjInclude = attrHppMSSqlSchemaObjInclude;
			editBuff.setOptionalHppMSSqlSchemaObjInclude( natHppMSSqlSchemaObjInclude );

			String natHppMySqlSchemaObjMembers = attrHppMySqlSchemaObjMembers;
			editBuff.setOptionalHppMySqlSchemaObjMembers( natHppMySqlSchemaObjMembers );

			String natHppMySqlSchemaObjImpl = attrHppMySqlSchemaObjImpl;
			editBuff.setOptionalHppMySqlSchemaObjImpl( natHppMySqlSchemaObjImpl );

			String natHppMySqlSchemaObjInclude = attrHppMySqlSchemaObjInclude;
			editBuff.setOptionalHppMySqlSchemaObjInclude( natHppMySqlSchemaObjInclude );

			String natHppOracleSchemaObjMembers = attrHppOracleSchemaObjMembers;
			editBuff.setOptionalHppOracleSchemaObjMembers( natHppOracleSchemaObjMembers );

			String natHppOracleSchemaObjImpl = attrHppOracleSchemaObjImpl;
			editBuff.setOptionalHppOracleSchemaObjImpl( natHppOracleSchemaObjImpl );

			String natHppOracleSchemaObjInclude = attrHppOracleSchemaObjInclude;
			editBuff.setOptionalHppOracleSchemaObjInclude( natHppOracleSchemaObjInclude );

			String natHppPgSqlSchemaObjMembers = attrHppPgSqlSchemaObjMembers;
			editBuff.setOptionalHppPgSqlSchemaObjMembers( natHppPgSqlSchemaObjMembers );

			String natHppPgSqlSchemaObjImpl = attrHppPgSqlSchemaObjImpl;
			editBuff.setOptionalHppPgSqlSchemaObjImpl( natHppPgSqlSchemaObjImpl );

			String natHppPgSqlSchemaObjInclude = attrHppPgSqlSchemaObjInclude;
			editBuff.setOptionalHppPgSqlSchemaObjInclude( natHppPgSqlSchemaObjInclude );

			String natHppRamSchemaObjMembers = attrHppRamSchemaObjMembers;
			editBuff.setOptionalHppRamSchemaObjMembers( natHppRamSchemaObjMembers );

			String natHppRamSchemaObjImpl = attrHppRamSchemaObjImpl;
			editBuff.setOptionalHppRamSchemaObjImpl( natHppRamSchemaObjImpl );

			String natHppRamSchemaObjInclude = attrHppRamSchemaObjInclude;
			editBuff.setOptionalHppRamSchemaObjInclude( natHppRamSchemaObjInclude );

			String natHppXMsgSchemaInclude = attrHppXMsgSchemaInclude;
			editBuff.setOptionalHppXMsgSchemaInclude( natHppXMsgSchemaInclude );

			String natHppXMsgSchemaFormatters = attrHppXMsgSchemaFormatters;
			editBuff.setOptionalHppXMsgSchemaFormatters( natHppXMsgSchemaFormatters );

			String natHppXMsgClientSchemaInclude = attrHppXMsgClientSchemaInclude;
			editBuff.setOptionalHppXMsgClientSchemaInclude( natHppXMsgClientSchemaInclude );

			String natHppXMsgClientSchemaBody = attrHppXMsgClientSchemaBody;
			editBuff.setOptionalHppXMsgClientSchemaBody( natHppXMsgClientSchemaBody );

			String natHppXMsgRqstSchemaBody = attrHppXMsgRqstSchemaBody;
			editBuff.setOptionalHppXMsgRqstSchemaBody( natHppXMsgRqstSchemaBody );

			String natHppXMsgRqstSchemaInclude = attrHppXMsgRqstSchemaInclude;
			editBuff.setOptionalHppXMsgRqstSchemaInclude( natHppXMsgRqstSchemaInclude );

			String natHppXMsgRqstSchemaWireParsers = attrHppXMsgRqstSchemaWireParsers;
			editBuff.setOptionalHppXMsgRqstSchemaWireParsers( natHppXMsgRqstSchemaWireParsers );

			String natHppXMsgRqstSchemaXsdSpec = attrHppXMsgRqstSchemaXsdSpec;
			editBuff.setOptionalHppXMsgRqstSchemaXsdSpec( natHppXMsgRqstSchemaXsdSpec );

			String natHppXMsgRqstSchemaXsdElementList = attrHppXMsgRqstSchemaXsdElementList;
			editBuff.setOptionalHppXMsgRqstSchemaXsdElementList( natHppXMsgRqstSchemaXsdElementList );

			String natHppXMsgRspnSchemaBody = attrHppXMsgRspnSchemaBody;
			editBuff.setOptionalHppXMsgRspnSchemaBody( natHppXMsgRspnSchemaBody );

			String natHppXMsgRspnSchemaInclude = attrHppXMsgRspnSchemaInclude;
			editBuff.setOptionalHppXMsgRspnSchemaInclude( natHppXMsgRspnSchemaInclude );

			String natHppXMsgRspnSchemaWireParsers = attrHppXMsgRspnSchemaWireParsers;
			editBuff.setOptionalHppXMsgRspnSchemaWireParsers( natHppXMsgRspnSchemaWireParsers );

			String natHppXMsgRspnSchemaXsdElementList = attrHppXMsgRspnSchemaXsdElementList;
			editBuff.setOptionalHppXMsgRspnSchemaXsdElementList( natHppXMsgRspnSchemaXsdElementList );

			String natHppXMsgRspnSchemaXsdSpec = attrHppXMsgRspnSchemaXsdSpec;
			editBuff.setOptionalHppXMsgRspnSchemaXsdSpec( natHppXMsgRspnSchemaXsdSpec );

			String natCsSchemaObjUsing = attrCsSchemaObjUsing;
			editBuff.setOptionalCsSchemaObjUsing( natCsSchemaObjUsing );

			String natCsSchemaObjInterface = attrCsSchemaObjInterface;
			editBuff.setOptionalCsSchemaObjInterface( natCsSchemaObjInterface );

			String natCsSchemaObjMembers = attrCsSchemaObjMembers;
			editBuff.setOptionalCsSchemaObjMembers( natCsSchemaObjMembers );

			String natCsSchemaObjImplementation = attrCsSchemaObjImplementation;
			editBuff.setOptionalCsSchemaObjImplementation( natCsSchemaObjImplementation );

			String natCsDb2LUWSchemaObjMembers = attrCsDb2LUWSchemaObjMembers;
			editBuff.setOptionalCsDb2LUWSchemaObjMembers( natCsDb2LUWSchemaObjMembers );

			String natCsDb2LUWSchemaObjImpl = attrCsDb2LUWSchemaObjImpl;
			editBuff.setOptionalCsDb2LUWSchemaObjImpl( natCsDb2LUWSchemaObjImpl );

			String natCsDb2LUWSchemaObjUsing = attrCsDb2LUWSchemaObjUsing;
			editBuff.setOptionalCsDb2LUWSchemaObjUsing( natCsDb2LUWSchemaObjUsing );

			String natCsMSSqlSchemaObjMembers = attrCsMSSqlSchemaObjMembers;
			editBuff.setOptionalCsMSSqlSchemaObjMembers( natCsMSSqlSchemaObjMembers );

			String natCsMSSqlSchemaObjImpl = attrCsMSSqlSchemaObjImpl;
			editBuff.setOptionalCsMSSqlSchemaObjImpl( natCsMSSqlSchemaObjImpl );

			String natCsMSSqlSchemaObjUsing = attrCsMSSqlSchemaObjUsing;
			editBuff.setOptionalCsMSSqlSchemaObjUsing( natCsMSSqlSchemaObjUsing );

			String natCsMySqlSchemaObjMembers = attrCsMySqlSchemaObjMembers;
			editBuff.setOptionalCsMySqlSchemaObjMembers( natCsMySqlSchemaObjMembers );

			String natCsMySqlSchemaObjImpl = attrCsMySqlSchemaObjImpl;
			editBuff.setOptionalCsMySqlSchemaObjImpl( natCsMySqlSchemaObjImpl );

			String natCsMySqlSchemaObjUsing = attrCsMySqlSchemaObjUsing;
			editBuff.setOptionalCsMySqlSchemaObjUsing( natCsMySqlSchemaObjUsing );

			String natCsOracleSchemaObjMembers = attrCsOracleSchemaObjMembers;
			editBuff.setOptionalCsOracleSchemaObjMembers( natCsOracleSchemaObjMembers );

			String natCsOracleSchemaObjImpl = attrCsOracleSchemaObjImpl;
			editBuff.setOptionalCsOracleSchemaObjImpl( natCsOracleSchemaObjImpl );

			String natCsOracleSchemaObjUsing = attrCsOracleSchemaObjUsing;
			editBuff.setOptionalCsOracleSchemaObjUsing( natCsOracleSchemaObjUsing );

			String natCsPgSqlSchemaObjMembers = attrCsPgSqlSchemaObjMembers;
			editBuff.setOptionalCsPgSqlSchemaObjMembers( natCsPgSqlSchemaObjMembers );

			String natCsPgSqlSchemaObjImpl = attrCsPgSqlSchemaObjImpl;
			editBuff.setOptionalCsPgSqlSchemaObjImpl( natCsPgSqlSchemaObjImpl );

			String natCsPgSqlSchemaObjUsing = attrCsPgSqlSchemaObjUsing;
			editBuff.setOptionalCsPgSqlSchemaObjUsing( natCsPgSqlSchemaObjUsing );

			String natCsRamSchemaObjMembers = attrCsRamSchemaObjMembers;
			editBuff.setOptionalCsRamSchemaObjMembers( natCsRamSchemaObjMembers );

			String natCsRamSchemaObjImpl = attrCsRamSchemaObjImpl;
			editBuff.setOptionalCsRamSchemaObjImpl( natCsRamSchemaObjImpl );

			String natCsRamSchemaObjUsing = attrCsRamSchemaObjUsing;
			editBuff.setOptionalCsRamSchemaObjUsing( natCsRamSchemaObjUsing );

			String natCsXMsgSchemaUsing = attrCsXMsgSchemaUsing;
			editBuff.setOptionalCsXMsgSchemaUsing( natCsXMsgSchemaUsing );

			String natCsXMsgSchemaFormatters = attrCsXMsgSchemaFormatters;
			editBuff.setOptionalCsXMsgSchemaFormatters( natCsXMsgSchemaFormatters );

			String natCsXMsgClientSchemaUsing = attrCsXMsgClientSchemaUsing;
			editBuff.setOptionalCsXMsgClientSchemaUsing( natCsXMsgClientSchemaUsing );

			String natCsXMsgClientSchemaBody = attrCsXMsgClientSchemaBody;
			editBuff.setOptionalCsXMsgClientSchemaBody( natCsXMsgClientSchemaBody );

			String natCsXMsgRqstSchemaBody = attrCsXMsgRqstSchemaBody;
			editBuff.setOptionalCsXMsgRqstSchemaBody( natCsXMsgRqstSchemaBody );

			String natCsXMsgRqstSchemaUsing = attrCsXMsgRqstSchemaUsing;
			editBuff.setOptionalCsXMsgRqstSchemaUsing( natCsXMsgRqstSchemaUsing );

			String natCsXMsgRqstSchemaWireParsers = attrCsXMsgRqstSchemaWireParsers;
			editBuff.setOptionalCsXMsgRqstSchemaWireParsers( natCsXMsgRqstSchemaWireParsers );

			String natCsXMsgRqstSchemaXsdSpec = attrCsXMsgRqstSchemaXsdSpec;
			editBuff.setOptionalCsXMsgRqstSchemaXsdSpec( natCsXMsgRqstSchemaXsdSpec );

			String natCsXMsgRqstSchemaXsdElementList = attrCsXMsgRqstSchemaXsdElementList;
			editBuff.setOptionalCsXMsgRqstSchemaXsdElementList( natCsXMsgRqstSchemaXsdElementList );

			String natCsXMsgRspnSchemaBody = attrCsXMsgRspnSchemaBody;
			editBuff.setOptionalCsXMsgRspnSchemaBody( natCsXMsgRspnSchemaBody );

			String natCsXMsgRspnSchemaUsing = attrCsXMsgRspnSchemaUsing;
			editBuff.setOptionalCsXMsgRspnSchemaUsing( natCsXMsgRspnSchemaUsing );

			String natCsXMsgRspnSchemaWireParsers = attrCsXMsgRspnSchemaWireParsers;
			editBuff.setOptionalCsXMsgRspnSchemaWireParsers( natCsXMsgRspnSchemaWireParsers );

			String natCsXMsgRspnSchemaXsdElementList = attrCsXMsgRspnSchemaXsdElementList;
			editBuff.setOptionalCsXMsgRspnSchemaXsdElementList( natCsXMsgRspnSchemaXsdElementList );

			String natCsXMsgRspnSchemaXsdSpec = attrCsXMsgRspnSchemaXsdSpec;
			editBuff.setOptionalCsXMsgRspnSchemaXsdSpec( natCsXMsgRspnSchemaXsdSpec );

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
			else if( scopeObj instanceof ICFBamMinorVersionObj ) {
				refMinorVersion = (ICFBamMinorVersionObj) scopeObj;
				editBuff.setRequiredContainerMinorVersion( refMinorVersion );
				refCTenant = (ICFBamTenantObj)editBuff.getRequiredOwnerCTenant();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamMinorVersionObj" );
			}

			// Resolve and apply Owner reference

			if( refCTenant == null ) {
				if( scopeObj instanceof ICFBamTenantObj ) {
					refCTenant = (ICFBamTenantObj) scopeObj;
					editBuff.setRequiredOwnerCTenant( refCTenant );
				}
				else {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<CTenant>" );
				}
			}

			refTenant = refCTenant;
			// Lookup refDefaultLicense by qualified name
			if( ( attrDefaultLicense != null ) && ( attrDefaultLicense.length() > 0 ) ) {
				refDefaultLicense = (ICFBamLicenseObj)(editBuff.getNamedObject( schemaObj.getLicenseTableObj().getObjQualifyingClass(),
					attrDefaultLicense ) );
				if( refDefaultLicense == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DefaultLicense reference qualified name \"" + attrDefaultLicense + "\" to table License" );
				}
			}
			else {
				refDefaultLicense = null;
			}
			editBuff.setOptionalLookupDefaultLicense( refDefaultLicense );

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSchemaDefLoaderBehaviour();
			ICFBamSchemaDefEditObj editSchemaDef = null;
			ICFBamSchemaDefObj origSchemaDef = (ICFBamSchemaDefObj)schemaObj.getSchemaDefTableObj().readSchemaDefByUNameIdx( refMinorVersion.getRequiredTenantId(),
			refMinorVersion.getRequiredId(),
			editBuff.getRequiredName() );
			if( origSchemaDef == null ) {
				editSchemaDef = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSchemaDef = (ICFBamSchemaDefEditObj)origSchemaDef.beginEdit();
						editSchemaDef.setRequiredName( editBuff.getRequiredName() );
						editSchemaDef.setOptionalDbName( editBuff.getOptionalDbName() );
						editSchemaDef.setOptionalShortName( editBuff.getOptionalShortName() );
						editSchemaDef.setOptionalLabel( editBuff.getOptionalLabel() );
						editSchemaDef.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editSchemaDef.setOptionalDescription( editBuff.getOptionalDescription() );
						editSchemaDef.setRequiredCopyrightPeriod( editBuff.getRequiredCopyrightPeriod() );
						editSchemaDef.setRequiredCopyrightHolder( editBuff.getRequiredCopyrightHolder() );
						editSchemaDef.setRequiredAuthorEMail( editBuff.getRequiredAuthorEMail() );
						editSchemaDef.setRequiredProjectURL( editBuff.getRequiredProjectURL() );
						editSchemaDef.setRequiredPublishURI( editBuff.getRequiredPublishURI() );
						editSchemaDef.setOptionalJSchemaObjImport( editBuff.getOptionalJSchemaObjImport() );
						editSchemaDef.setOptionalJSchemaObjInterface( editBuff.getOptionalJSchemaObjInterface() );
						editSchemaDef.setOptionalJSchemaObjMembers( editBuff.getOptionalJSchemaObjMembers() );
						editSchemaDef.setOptionalJSchemaObjImplementation( editBuff.getOptionalJSchemaObjImplementation() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjMembers( editBuff.getOptionalJDb2LUWSchemaObjMembers() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjImpl( editBuff.getOptionalJDb2LUWSchemaObjImpl() );
						editSchemaDef.setOptionalJDb2LUWSchemaObjImport( editBuff.getOptionalJDb2LUWSchemaObjImport() );
						editSchemaDef.setOptionalJMSSqlSchemaObjMembers( editBuff.getOptionalJMSSqlSchemaObjMembers() );
						editSchemaDef.setOptionalJMSSqlSchemaObjImpl( editBuff.getOptionalJMSSqlSchemaObjImpl() );
						editSchemaDef.setOptionalJMSSqlSchemaObjImport( editBuff.getOptionalJMSSqlSchemaObjImport() );
						editSchemaDef.setOptionalJMySqlSchemaObjMembers( editBuff.getOptionalJMySqlSchemaObjMembers() );
						editSchemaDef.setOptionalJMySqlSchemaObjImpl( editBuff.getOptionalJMySqlSchemaObjImpl() );
						editSchemaDef.setOptionalJMySqlSchemaObjImport( editBuff.getOptionalJMySqlSchemaObjImport() );
						editSchemaDef.setOptionalJOracleSchemaObjMembers( editBuff.getOptionalJOracleSchemaObjMembers() );
						editSchemaDef.setOptionalJOracleSchemaObjImpl( editBuff.getOptionalJOracleSchemaObjImpl() );
						editSchemaDef.setOptionalJOracleSchemaObjImport( editBuff.getOptionalJOracleSchemaObjImport() );
						editSchemaDef.setOptionalJPgSqlSchemaObjMembers( editBuff.getOptionalJPgSqlSchemaObjMembers() );
						editSchemaDef.setOptionalJPgSqlSchemaObjImpl( editBuff.getOptionalJPgSqlSchemaObjImpl() );
						editSchemaDef.setOptionalJPgSqlSchemaObjImport( editBuff.getOptionalJPgSqlSchemaObjImport() );
						editSchemaDef.setOptionalJRamSchemaObjMembers( editBuff.getOptionalJRamSchemaObjMembers() );
						editSchemaDef.setOptionalJRamSchemaObjImpl( editBuff.getOptionalJRamSchemaObjImpl() );
						editSchemaDef.setOptionalJRamSchemaObjImport( editBuff.getOptionalJRamSchemaObjImport() );
						editSchemaDef.setOptionalJXMsgSchemaImport( editBuff.getOptionalJXMsgSchemaImport() );
						editSchemaDef.setOptionalJXMsgSchemaFormatters( editBuff.getOptionalJXMsgSchemaFormatters() );
						editSchemaDef.setOptionalJXMsgClientSchemaImport( editBuff.getOptionalJXMsgClientSchemaImport() );
						editSchemaDef.setOptionalJXMsgClientSchemaBody( editBuff.getOptionalJXMsgClientSchemaBody() );
						editSchemaDef.setOptionalJXMsgRqstSchemaBody( editBuff.getOptionalJXMsgRqstSchemaBody() );
						editSchemaDef.setOptionalJXMsgRqstSchemaImport( editBuff.getOptionalJXMsgRqstSchemaImport() );
						editSchemaDef.setOptionalJXMsgRqstSchemaWireParsers( editBuff.getOptionalJXMsgRqstSchemaWireParsers() );
						editSchemaDef.setOptionalJXMsgRqstSchemaXsdSpec( editBuff.getOptionalJXMsgRqstSchemaXsdSpec() );
						editSchemaDef.setOptionalJXMsgRqstSchemaXsdElementList( editBuff.getOptionalJXMsgRqstSchemaXsdElementList() );
						editSchemaDef.setOptionalJXMsgRspnSchemaBody( editBuff.getOptionalJXMsgRspnSchemaBody() );
						editSchemaDef.setOptionalJXMsgRspnSchemaImport( editBuff.getOptionalJXMsgRspnSchemaImport() );
						editSchemaDef.setOptionalJXMsgRspnSchemaWireParsers( editBuff.getOptionalJXMsgRspnSchemaWireParsers() );
						editSchemaDef.setOptionalJXMsgRspnSchemaXsdElementList( editBuff.getOptionalJXMsgRspnSchemaXsdElementList() );
						editSchemaDef.setOptionalJXMsgRspnSchemaXsdSpec( editBuff.getOptionalJXMsgRspnSchemaXsdSpec() );
						editSchemaDef.setOptionalCppSchemaObjInclude( editBuff.getOptionalCppSchemaObjInclude() );
						editSchemaDef.setOptionalCppSchemaObjInterface( editBuff.getOptionalCppSchemaObjInterface() );
						editSchemaDef.setOptionalCppSchemaObjMembers( editBuff.getOptionalCppSchemaObjMembers() );
						editSchemaDef.setOptionalCppSchemaObjImplementation( editBuff.getOptionalCppSchemaObjImplementation() );
						editSchemaDef.setOptionalCppDb2LUWSchemaObjMembers( editBuff.getOptionalCppDb2LUWSchemaObjMembers() );
						editSchemaDef.setOptionalCppDb2LUWSchemaObjImpl( editBuff.getOptionalCppDb2LUWSchemaObjImpl() );
						editSchemaDef.setOptionalCppDb2LUWSchemaObjInclude( editBuff.getOptionalCppDb2LUWSchemaObjInclude() );
						editSchemaDef.setOptionalCppMSSqlSchemaObjMembers( editBuff.getOptionalCppMSSqlSchemaObjMembers() );
						editSchemaDef.setOptionalCppMSSqlSchemaObjImpl( editBuff.getOptionalCppMSSqlSchemaObjImpl() );
						editSchemaDef.setOptionalCppMSSqlSchemaObjInclude( editBuff.getOptionalCppMSSqlSchemaObjInclude() );
						editSchemaDef.setOptionalCppMySqlSchemaObjMembers( editBuff.getOptionalCppMySqlSchemaObjMembers() );
						editSchemaDef.setOptionalCppMySqlSchemaObjImpl( editBuff.getOptionalCppMySqlSchemaObjImpl() );
						editSchemaDef.setOptionalCppMySqlSchemaObjInclude( editBuff.getOptionalCppMySqlSchemaObjInclude() );
						editSchemaDef.setOptionalCppOracleSchemaObjMembers( editBuff.getOptionalCppOracleSchemaObjMembers() );
						editSchemaDef.setOptionalCppOracleSchemaObjImpl( editBuff.getOptionalCppOracleSchemaObjImpl() );
						editSchemaDef.setOptionalCppOracleSchemaObjInclude( editBuff.getOptionalCppOracleSchemaObjInclude() );
						editSchemaDef.setOptionalCppPgSqlSchemaObjMembers( editBuff.getOptionalCppPgSqlSchemaObjMembers() );
						editSchemaDef.setOptionalCppPgSqlSchemaObjImpl( editBuff.getOptionalCppPgSqlSchemaObjImpl() );
						editSchemaDef.setOptionalCppPgSqlSchemaObjInclude( editBuff.getOptionalCppPgSqlSchemaObjInclude() );
						editSchemaDef.setOptionalCppRamSchemaObjMembers( editBuff.getOptionalCppRamSchemaObjMembers() );
						editSchemaDef.setOptionalCppRamSchemaObjImpl( editBuff.getOptionalCppRamSchemaObjImpl() );
						editSchemaDef.setOptionalCppRamSchemaObjInclude( editBuff.getOptionalCppRamSchemaObjInclude() );
						editSchemaDef.setOptionalCppXMsgSchemaInclude( editBuff.getOptionalCppXMsgSchemaInclude() );
						editSchemaDef.setOptionalCppXMsgSchemaFormatters( editBuff.getOptionalCppXMsgSchemaFormatters() );
						editSchemaDef.setOptionalCppXMsgClientSchemaInclude( editBuff.getOptionalCppXMsgClientSchemaInclude() );
						editSchemaDef.setOptionalCppXMsgClientSchemaBody( editBuff.getOptionalCppXMsgClientSchemaBody() );
						editSchemaDef.setOptionalCppXMsgRqstSchemaBody( editBuff.getOptionalCppXMsgRqstSchemaBody() );
						editSchemaDef.setOptionalCppXMsgRqstSchemaInclude( editBuff.getOptionalCppXMsgRqstSchemaInclude() );
						editSchemaDef.setOptionalCppXMsgRqstSchemaWireParsers( editBuff.getOptionalCppXMsgRqstSchemaWireParsers() );
						editSchemaDef.setOptionalCppXMsgRqstSchemaXsdSpec( editBuff.getOptionalCppXMsgRqstSchemaXsdSpec() );
						editSchemaDef.setOptionalCppXMsgRqstSchemaXsdElementList( editBuff.getOptionalCppXMsgRqstSchemaXsdElementList() );
						editSchemaDef.setOptionalCppXMsgRspnSchemaBody( editBuff.getOptionalCppXMsgRspnSchemaBody() );
						editSchemaDef.setOptionalCppXMsgRspnSchemaInclude( editBuff.getOptionalCppXMsgRspnSchemaInclude() );
						editSchemaDef.setOptionalCppXMsgRspnSchemaWireParsers( editBuff.getOptionalCppXMsgRspnSchemaWireParsers() );
						editSchemaDef.setOptionalCppXMsgRspnSchemaXsdElementList( editBuff.getOptionalCppXMsgRspnSchemaXsdElementList() );
						editSchemaDef.setOptionalCppXMsgRspnSchemaXsdSpec( editBuff.getOptionalCppXMsgRspnSchemaXsdSpec() );
						editSchemaDef.setOptionalHppSchemaObjInclude( editBuff.getOptionalHppSchemaObjInclude() );
						editSchemaDef.setOptionalHppSchemaObjInterface( editBuff.getOptionalHppSchemaObjInterface() );
						editSchemaDef.setOptionalHppSchemaObjMembers( editBuff.getOptionalHppSchemaObjMembers() );
						editSchemaDef.setOptionalHppSchemaObjImplementation( editBuff.getOptionalHppSchemaObjImplementation() );
						editSchemaDef.setOptionalHppDb2LUWSchemaObjMembers( editBuff.getOptionalHppDb2LUWSchemaObjMembers() );
						editSchemaDef.setOptionalHppDb2LUWSchemaObjImpl( editBuff.getOptionalHppDb2LUWSchemaObjImpl() );
						editSchemaDef.setOptionalHppDb2LUWSchemaObjInclude( editBuff.getOptionalHppDb2LUWSchemaObjInclude() );
						editSchemaDef.setOptionalHppMSSqlSchemaObjMembers( editBuff.getOptionalHppMSSqlSchemaObjMembers() );
						editSchemaDef.setOptionalHppMSSqlSchemaObjImpl( editBuff.getOptionalHppMSSqlSchemaObjImpl() );
						editSchemaDef.setOptionalHppMSSqlSchemaObjInclude( editBuff.getOptionalHppMSSqlSchemaObjInclude() );
						editSchemaDef.setOptionalHppMySqlSchemaObjMembers( editBuff.getOptionalHppMySqlSchemaObjMembers() );
						editSchemaDef.setOptionalHppMySqlSchemaObjImpl( editBuff.getOptionalHppMySqlSchemaObjImpl() );
						editSchemaDef.setOptionalHppMySqlSchemaObjInclude( editBuff.getOptionalHppMySqlSchemaObjInclude() );
						editSchemaDef.setOptionalHppOracleSchemaObjMembers( editBuff.getOptionalHppOracleSchemaObjMembers() );
						editSchemaDef.setOptionalHppOracleSchemaObjImpl( editBuff.getOptionalHppOracleSchemaObjImpl() );
						editSchemaDef.setOptionalHppOracleSchemaObjInclude( editBuff.getOptionalHppOracleSchemaObjInclude() );
						editSchemaDef.setOptionalHppPgSqlSchemaObjMembers( editBuff.getOptionalHppPgSqlSchemaObjMembers() );
						editSchemaDef.setOptionalHppPgSqlSchemaObjImpl( editBuff.getOptionalHppPgSqlSchemaObjImpl() );
						editSchemaDef.setOptionalHppPgSqlSchemaObjInclude( editBuff.getOptionalHppPgSqlSchemaObjInclude() );
						editSchemaDef.setOptionalHppRamSchemaObjMembers( editBuff.getOptionalHppRamSchemaObjMembers() );
						editSchemaDef.setOptionalHppRamSchemaObjImpl( editBuff.getOptionalHppRamSchemaObjImpl() );
						editSchemaDef.setOptionalHppRamSchemaObjInclude( editBuff.getOptionalHppRamSchemaObjInclude() );
						editSchemaDef.setOptionalHppXMsgSchemaInclude( editBuff.getOptionalHppXMsgSchemaInclude() );
						editSchemaDef.setOptionalHppXMsgSchemaFormatters( editBuff.getOptionalHppXMsgSchemaFormatters() );
						editSchemaDef.setOptionalHppXMsgClientSchemaInclude( editBuff.getOptionalHppXMsgClientSchemaInclude() );
						editSchemaDef.setOptionalHppXMsgClientSchemaBody( editBuff.getOptionalHppXMsgClientSchemaBody() );
						editSchemaDef.setOptionalHppXMsgRqstSchemaBody( editBuff.getOptionalHppXMsgRqstSchemaBody() );
						editSchemaDef.setOptionalHppXMsgRqstSchemaInclude( editBuff.getOptionalHppXMsgRqstSchemaInclude() );
						editSchemaDef.setOptionalHppXMsgRqstSchemaWireParsers( editBuff.getOptionalHppXMsgRqstSchemaWireParsers() );
						editSchemaDef.setOptionalHppXMsgRqstSchemaXsdSpec( editBuff.getOptionalHppXMsgRqstSchemaXsdSpec() );
						editSchemaDef.setOptionalHppXMsgRqstSchemaXsdElementList( editBuff.getOptionalHppXMsgRqstSchemaXsdElementList() );
						editSchemaDef.setOptionalHppXMsgRspnSchemaBody( editBuff.getOptionalHppXMsgRspnSchemaBody() );
						editSchemaDef.setOptionalHppXMsgRspnSchemaInclude( editBuff.getOptionalHppXMsgRspnSchemaInclude() );
						editSchemaDef.setOptionalHppXMsgRspnSchemaWireParsers( editBuff.getOptionalHppXMsgRspnSchemaWireParsers() );
						editSchemaDef.setOptionalHppXMsgRspnSchemaXsdElementList( editBuff.getOptionalHppXMsgRspnSchemaXsdElementList() );
						editSchemaDef.setOptionalHppXMsgRspnSchemaXsdSpec( editBuff.getOptionalHppXMsgRspnSchemaXsdSpec() );
						editSchemaDef.setOptionalCsSchemaObjUsing( editBuff.getOptionalCsSchemaObjUsing() );
						editSchemaDef.setOptionalCsSchemaObjInterface( editBuff.getOptionalCsSchemaObjInterface() );
						editSchemaDef.setOptionalCsSchemaObjMembers( editBuff.getOptionalCsSchemaObjMembers() );
						editSchemaDef.setOptionalCsSchemaObjImplementation( editBuff.getOptionalCsSchemaObjImplementation() );
						editSchemaDef.setOptionalCsDb2LUWSchemaObjMembers( editBuff.getOptionalCsDb2LUWSchemaObjMembers() );
						editSchemaDef.setOptionalCsDb2LUWSchemaObjImpl( editBuff.getOptionalCsDb2LUWSchemaObjImpl() );
						editSchemaDef.setOptionalCsDb2LUWSchemaObjUsing( editBuff.getOptionalCsDb2LUWSchemaObjUsing() );
						editSchemaDef.setOptionalCsMSSqlSchemaObjMembers( editBuff.getOptionalCsMSSqlSchemaObjMembers() );
						editSchemaDef.setOptionalCsMSSqlSchemaObjImpl( editBuff.getOptionalCsMSSqlSchemaObjImpl() );
						editSchemaDef.setOptionalCsMSSqlSchemaObjUsing( editBuff.getOptionalCsMSSqlSchemaObjUsing() );
						editSchemaDef.setOptionalCsMySqlSchemaObjMembers( editBuff.getOptionalCsMySqlSchemaObjMembers() );
						editSchemaDef.setOptionalCsMySqlSchemaObjImpl( editBuff.getOptionalCsMySqlSchemaObjImpl() );
						editSchemaDef.setOptionalCsMySqlSchemaObjUsing( editBuff.getOptionalCsMySqlSchemaObjUsing() );
						editSchemaDef.setOptionalCsOracleSchemaObjMembers( editBuff.getOptionalCsOracleSchemaObjMembers() );
						editSchemaDef.setOptionalCsOracleSchemaObjImpl( editBuff.getOptionalCsOracleSchemaObjImpl() );
						editSchemaDef.setOptionalCsOracleSchemaObjUsing( editBuff.getOptionalCsOracleSchemaObjUsing() );
						editSchemaDef.setOptionalCsPgSqlSchemaObjMembers( editBuff.getOptionalCsPgSqlSchemaObjMembers() );
						editSchemaDef.setOptionalCsPgSqlSchemaObjImpl( editBuff.getOptionalCsPgSqlSchemaObjImpl() );
						editSchemaDef.setOptionalCsPgSqlSchemaObjUsing( editBuff.getOptionalCsPgSqlSchemaObjUsing() );
						editSchemaDef.setOptionalCsRamSchemaObjMembers( editBuff.getOptionalCsRamSchemaObjMembers() );
						editSchemaDef.setOptionalCsRamSchemaObjImpl( editBuff.getOptionalCsRamSchemaObjImpl() );
						editSchemaDef.setOptionalCsRamSchemaObjUsing( editBuff.getOptionalCsRamSchemaObjUsing() );
						editSchemaDef.setOptionalCsXMsgSchemaUsing( editBuff.getOptionalCsXMsgSchemaUsing() );
						editSchemaDef.setOptionalCsXMsgSchemaFormatters( editBuff.getOptionalCsXMsgSchemaFormatters() );
						editSchemaDef.setOptionalCsXMsgClientSchemaUsing( editBuff.getOptionalCsXMsgClientSchemaUsing() );
						editSchemaDef.setOptionalCsXMsgClientSchemaBody( editBuff.getOptionalCsXMsgClientSchemaBody() );
						editSchemaDef.setOptionalCsXMsgRqstSchemaBody( editBuff.getOptionalCsXMsgRqstSchemaBody() );
						editSchemaDef.setOptionalCsXMsgRqstSchemaUsing( editBuff.getOptionalCsXMsgRqstSchemaUsing() );
						editSchemaDef.setOptionalCsXMsgRqstSchemaWireParsers( editBuff.getOptionalCsXMsgRqstSchemaWireParsers() );
						editSchemaDef.setOptionalCsXMsgRqstSchemaXsdSpec( editBuff.getOptionalCsXMsgRqstSchemaXsdSpec() );
						editSchemaDef.setOptionalCsXMsgRqstSchemaXsdElementList( editBuff.getOptionalCsXMsgRqstSchemaXsdElementList() );
						editSchemaDef.setOptionalCsXMsgRspnSchemaBody( editBuff.getOptionalCsXMsgRspnSchemaBody() );
						editSchemaDef.setOptionalCsXMsgRspnSchemaUsing( editBuff.getOptionalCsXMsgRspnSchemaUsing() );
						editSchemaDef.setOptionalCsXMsgRspnSchemaWireParsers( editBuff.getOptionalCsXMsgRspnSchemaWireParsers() );
						editSchemaDef.setOptionalCsXMsgRspnSchemaXsdElementList( editBuff.getOptionalCsXMsgRspnSchemaXsdElementList() );
						editSchemaDef.setOptionalCsXMsgRspnSchemaXsdSpec( editBuff.getOptionalCsXMsgRspnSchemaXsdSpec() );
						editSchemaDef.setOptionalLookupDefaultLicense( editBuff.getOptionalLookupDefaultLicense() );
						break;
					case Replace:
						editSchemaDef = (ICFBamSchemaDefEditObj)origSchemaDef.beginEdit();
						editSchemaDef.deleteInstance();
						editSchemaDef = null;
						origSchemaDef = null;
						editSchemaDef = editBuff;
						break;
				}
			}

			if( editSchemaDef != null ) {
				if( origSchemaDef != null ) {
					editSchemaDef.update();
				}
				else {
					origSchemaDef = (ICFBamSchemaDefObj)editSchemaDef.create();
				}
				editSchemaDef = null;
			}

			curContext.putNamedValue( "Object", origSchemaDef );
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
