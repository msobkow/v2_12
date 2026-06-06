
// Description: Java 11 XML SAX Element Handler for Table

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
 *	CFBamSaxLoaderTableParse XML SAX Element Handler implementation
 *	for Table.
 */
public class CFBamSaxLoaderTable
	extends CFLibXmlCoreElementHandler
{
	public CFBamSaxLoaderTable( CFBamSaxLoader saxLoader ) {
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
			// Table Attributes
			String	attrName = null;
			String	attrDbName = null;
			String	attrShortName = null;
			String	attrLabel = null;
			String	attrShortDescription = null;
			String	attrDescription = null;
			String	attrPageData = null;
			String	attrTableClassCode = null;
			String	attrIsInstantiable = null;
			String	attrHasHistory = null;
			String	attrHasAuditColumns = null;
			String	attrLoaderBehaviour = null;
			String	attrSecScope = null;
			String	attrJObjMembers = null;
			String	attrJObjInterface = null;
			String	attrJObjImport = null;
			String	attrJObjImplementation = null;
			String	attrJEditObjMembers = null;
			String	attrJEditObjInterface = null;
			String	attrJEditObjImport = null;
			String	attrJEditObjImplementation = null;
			String	attrJTableImport = null;
			String	attrJTableMembers = null;
			String	attrJTableInterface = null;
			String	attrJTableImplementation = null;
			String	attrJTableObjImport = null;
			String	attrJTableObjMembers = null;
			String	attrJTableObjInterface = null;
			String	attrJTableObjImplementation = null;
			String	attrJDb2LUWTableImport = null;
			String	attrJDb2LUWTableMembers = null;
			String	attrJDb2LUWTableImplementation = null;
			String	attrJMSSqlTableImport = null;
			String	attrJMSSqlTableMembers = null;
			String	attrJMSSqlTableImplementation = null;
			String	attrJMySqlTableImport = null;
			String	attrJMySqlTableMembers = null;
			String	attrJMySqlTableImplementation = null;
			String	attrJOracleTableImport = null;
			String	attrJOracleTableMembers = null;
			String	attrJOracleTableImplementation = null;
			String	attrJPgSqlTableImport = null;
			String	attrJPgSqlTableMembers = null;
			String	attrJPgSqlTableImplementation = null;
			String	attrJRamTableImport = null;
			String	attrJRamTableMembers = null;
			String	attrJRamTableImplementation = null;
			String	attrJSaxLoaderImport = null;
			String	attrJSaxLoaderStartElement = null;
			String	attrJSaxLoaderEndElement = null;
			String	attrJXMsgTableImport = null;
			String	attrJXMsgTableFormatters = null;
			String	attrJXMsgRqstTableImport = null;
			String	attrJXMsgRspnTableImport = null;
			String	attrJXMsgClientTableImport = null;
			String	attrJXMsgRqstTableBody = null;
			String	attrJXMsgRspnTableBody = null;
			String	attrJXMsgClientTableBody = null;
			String	attrCppObjMembers = null;
			String	attrCppObjInterface = null;
			String	attrCppObjInclude = null;
			String	attrCppObjImplementation = null;
			String	attrCppEditObjMembers = null;
			String	attrCppEditObjInterface = null;
			String	attrCppEditObjInclude = null;
			String	attrCppEditObjImplementation = null;
			String	attrCppTableInclude = null;
			String	attrCppTableMembers = null;
			String	attrCppTableInterface = null;
			String	attrCppTableImplementation = null;
			String	attrCppTableObjInclude = null;
			String	attrCppTableObjMembers = null;
			String	attrCppTableObjInterface = null;
			String	attrCppTableObjImplementation = null;
			String	attrCppDb2LUWTableInclude = null;
			String	attrCppDb2LUWTableMembers = null;
			String	attrCppDb2LUWTableImplementation = null;
			String	attrCppMSSqlTableInclude = null;
			String	attrCppMSSqlTableMembers = null;
			String	attrCppMSSqlTableImplementation = null;
			String	attrCppMySqlTableInclude = null;
			String	attrCppMySqlTableMembers = null;
			String	attrCppMySqlTableImplementation = null;
			String	attrCppOracleTableInclude = null;
			String	attrCppOracleTableMembers = null;
			String	attrCppOracleTableImplementation = null;
			String	attrCppPgSqlTableInclude = null;
			String	attrCppPgSqlTableMembers = null;
			String	attrCppPgSqlTableImplementation = null;
			String	attrCppRamTableInclude = null;
			String	attrCppRamTableMembers = null;
			String	attrCppRamTableImplementation = null;
			String	attrCppSaxLoaderInclude = null;
			String	attrCppSaxLoaderStartElement = null;
			String	attrCppSaxLoaderEndElement = null;
			String	attrCppXMsgTableInclude = null;
			String	attrCppXMsgTableFormatters = null;
			String	attrCppXMsgRqstTableInclude = null;
			String	attrCppXMsgRspnTableInclude = null;
			String	attrCppXMsgClientTableInclude = null;
			String	attrCppXMsgRqstTableBody = null;
			String	attrCppXMsgRspnTableBody = null;
			String	attrCppXMsgClientTableBody = null;
			String	attrHppObjMembers = null;
			String	attrHppObjInterface = null;
			String	attrHppObjInclude = null;
			String	attrHppObjImplementation = null;
			String	attrHppEditObjMembers = null;
			String	attrHppEditObjInterface = null;
			String	attrHppEditObjInclude = null;
			String	attrHppEditObjImplementation = null;
			String	attrHppTableInclude = null;
			String	attrHppTableMembers = null;
			String	attrHppTableInterface = null;
			String	attrHppTableImplementation = null;
			String	attrHppTableObjInclude = null;
			String	attrHppTableObjMembers = null;
			String	attrHppTableObjInterface = null;
			String	attrHppTableObjImplementation = null;
			String	attrHppDb2LUWTableInclude = null;
			String	attrHppDb2LUWTableMembers = null;
			String	attrHppDb2LUWTableImplementation = null;
			String	attrHppMSSqlTableInclude = null;
			String	attrHppMSSqlTableMembers = null;
			String	attrHppMSSqlTableImplementation = null;
			String	attrHppMySqlTableInclude = null;
			String	attrHppMySqlTableMembers = null;
			String	attrHppMySqlTableImplementation = null;
			String	attrHppOracleTableInclude = null;
			String	attrHppOracleTableMembers = null;
			String	attrHppOracleTableImplementation = null;
			String	attrHppPgSqlTableInclude = null;
			String	attrHppPgSqlTableMembers = null;
			String	attrHppPgSqlTableImplementation = null;
			String	attrHppRamTableInclude = null;
			String	attrHppRamTableMembers = null;
			String	attrHppRamTableImplementation = null;
			String	attrHppSaxLoaderInclude = null;
			String	attrHppSaxLoaderStartElement = null;
			String	attrHppSaxLoaderEndElement = null;
			String	attrHppXMsgTableInclude = null;
			String	attrHppXMsgTableFormatters = null;
			String	attrHppXMsgRqstTableInclude = null;
			String	attrHppXMsgRspnTableInclude = null;
			String	attrHppXMsgClientTableInclude = null;
			String	attrHppXMsgRqstTableBody = null;
			String	attrHppXMsgRspnTableBody = null;
			String	attrHppXMsgClientTableBody = null;
			String	attrCsObjMembers = null;
			String	attrCsObjInterface = null;
			String	attrCsObjUsing = null;
			String	attrCsObjImplementation = null;
			String	attrCsEditObjMembers = null;
			String	attrCsEditObjInterface = null;
			String	attrCsEditObjUsing = null;
			String	attrCsEditObjImplementation = null;
			String	attrCsTableUsing = null;
			String	attrCsTableMembers = null;
			String	attrCsTableInterface = null;
			String	attrCsTableImplementation = null;
			String	attrCsTableObjUsing = null;
			String	attrCsTableObjMembers = null;
			String	attrCsTableObjInterface = null;
			String	attrCsTableObjImplementation = null;
			String	attrCsDb2LUWTableUsing = null;
			String	attrCsDb2LUWTableMembers = null;
			String	attrCsDb2LUWTableImplementation = null;
			String	attrCsMSSqlTableUsing = null;
			String	attrCsMSSqlTableMembers = null;
			String	attrCsMSSqlTableImplementation = null;
			String	attrCsMySqlTableUsing = null;
			String	attrCsMySqlTableMembers = null;
			String	attrCsMySqlTableImplementation = null;
			String	attrCsOracleTableUsing = null;
			String	attrCsOracleTableMembers = null;
			String	attrCsOracleTableImplementation = null;
			String	attrCsPgSqlTableUsing = null;
			String	attrCsPgSqlTableMembers = null;
			String	attrCsPgSqlTableImplementation = null;
			String	attrCsRamTableUsing = null;
			String	attrCsRamTableMembers = null;
			String	attrCsRamTableImplementation = null;
			String	attrCsSaxLoaderUsing = null;
			String	attrCsSaxLoaderStartElement = null;
			String	attrCsSaxLoaderEndElement = null;
			String	attrCsXMsgTableUsing = null;
			String	attrCsXMsgTableFormatters = null;
			String	attrCsXMsgRqstTableUsing = null;
			String	attrCsXMsgRspnTableUsing = null;
			String	attrCsXMsgClientTableUsing = null;
			String	attrCsXMsgRqstTableBody = null;
			String	attrCsXMsgRspnTableBody = null;
			String	attrCsXMsgClientTableBody = null;
			String	attrDefSchema = null;
			String	attrLookupIndex = null;
			String	attrAltIndex = null;
			String	attrQualTable = null;
			String	attrPrimaryIndex = null;
			// Table References
			ICFBamSchemaDefObj refSchemaDef = null;
			ICFBamSchemaDefObj refDefSchema = null;
			ICFBamIndexObj refLookupIndex = null;
			ICFBamIndexObj refAltIndex = null;
			ICFBamTableObj refQualTable = null;
			ICFBamIndexObj refPrimaryIndex = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "Table" );

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
			ICFBamTableEditObj editBuff = (ICFBamTableEditObj)schemaObj.getTableTableObj().newInstance().beginEdit();

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
				else if( attrLocalName.equals( "PageData" ) ) {
					if( attrPageData != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPageData = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "TableClassCode" ) ) {
					if( attrTableClassCode != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrTableClassCode = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "IsInstantiable" ) ) {
					if( attrIsInstantiable != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrIsInstantiable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HasHistory" ) ) {
					if( attrHasHistory != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHasHistory = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HasAuditColumns" ) ) {
					if( attrHasAuditColumns != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHasAuditColumns = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LoaderBehaviour" ) ) {
					if( attrLoaderBehaviour != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLoaderBehaviour = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SecScope" ) ) {
					if( attrSecScope != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSecScope = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjMembers" ) ) {
					if( attrJObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjInterface" ) ) {
					if( attrJObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjImport" ) ) {
					if( attrJObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JObjImplementation" ) ) {
					if( attrJObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjMembers" ) ) {
					if( attrJEditObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjInterface" ) ) {
					if( attrJEditObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjImport" ) ) {
					if( attrJEditObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JEditObjImplementation" ) ) {
					if( attrJEditObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJEditObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableImport" ) ) {
					if( attrJTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableMembers" ) ) {
					if( attrJTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableInterface" ) ) {
					if( attrJTableInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableImplementation" ) ) {
					if( attrJTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjImport" ) ) {
					if( attrJTableObjImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjMembers" ) ) {
					if( attrJTableObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjInterface" ) ) {
					if( attrJTableObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JTableObjImplementation" ) ) {
					if( attrJTableObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJTableObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableImport" ) ) {
					if( attrJDb2LUWTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableMembers" ) ) {
					if( attrJDb2LUWTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JDb2LUWTableImplementation" ) ) {
					if( attrJDb2LUWTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJDb2LUWTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableImport" ) ) {
					if( attrJMSSqlTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableMembers" ) ) {
					if( attrJMSSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMSSqlTableImplementation" ) ) {
					if( attrJMSSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMSSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableImport" ) ) {
					if( attrJMySqlTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableMembers" ) ) {
					if( attrJMySqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JMySqlTableImplementation" ) ) {
					if( attrJMySqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJMySqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableImport" ) ) {
					if( attrJOracleTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableMembers" ) ) {
					if( attrJOracleTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JOracleTableImplementation" ) ) {
					if( attrJOracleTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJOracleTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableImport" ) ) {
					if( attrJPgSqlTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableMembers" ) ) {
					if( attrJPgSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JPgSqlTableImplementation" ) ) {
					if( attrJPgSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJPgSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableImport" ) ) {
					if( attrJRamTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableMembers" ) ) {
					if( attrJRamTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JRamTableImplementation" ) ) {
					if( attrJRamTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJRamTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderImport" ) ) {
					if( attrJSaxLoaderImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderStartElement" ) ) {
					if( attrJSaxLoaderStartElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderStartElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JSaxLoaderEndElement" ) ) {
					if( attrJSaxLoaderEndElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJSaxLoaderEndElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgTableImport" ) ) {
					if( attrJXMsgTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgTableFormatters" ) ) {
					if( attrJXMsgTableFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgTableFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstTableImport" ) ) {
					if( attrJXMsgRqstTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnTableImport" ) ) {
					if( attrJXMsgRspnTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientTableImport" ) ) {
					if( attrJXMsgClientTableImport != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientTableImport = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRqstTableBody" ) ) {
					if( attrJXMsgRqstTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRqstTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgRspnTableBody" ) ) {
					if( attrJXMsgRspnTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgRspnTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "JXMsgClientTableBody" ) ) {
					if( attrJXMsgClientTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrJXMsgClientTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppObjMembers" ) ) {
					if( attrCppObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppObjInterface" ) ) {
					if( attrCppObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppObjInclude" ) ) {
					if( attrCppObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppObjImplementation" ) ) {
					if( attrCppObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppEditObjMembers" ) ) {
					if( attrCppEditObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppEditObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppEditObjInterface" ) ) {
					if( attrCppEditObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppEditObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppEditObjInclude" ) ) {
					if( attrCppEditObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppEditObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppEditObjImplementation" ) ) {
					if( attrCppEditObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppEditObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableInclude" ) ) {
					if( attrCppTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableMembers" ) ) {
					if( attrCppTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableInterface" ) ) {
					if( attrCppTableInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableImplementation" ) ) {
					if( attrCppTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableObjInclude" ) ) {
					if( attrCppTableObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableObjMembers" ) ) {
					if( attrCppTableObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableObjInterface" ) ) {
					if( attrCppTableObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppTableObjImplementation" ) ) {
					if( attrCppTableObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppTableObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWTableInclude" ) ) {
					if( attrCppDb2LUWTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWTableMembers" ) ) {
					if( attrCppDb2LUWTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppDb2LUWTableImplementation" ) ) {
					if( attrCppDb2LUWTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppDb2LUWTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlTableInclude" ) ) {
					if( attrCppMSSqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlTableMembers" ) ) {
					if( attrCppMSSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMSSqlTableImplementation" ) ) {
					if( attrCppMSSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMSSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlTableInclude" ) ) {
					if( attrCppMySqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlTableMembers" ) ) {
					if( attrCppMySqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppMySqlTableImplementation" ) ) {
					if( attrCppMySqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppMySqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleTableInclude" ) ) {
					if( attrCppOracleTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleTableMembers" ) ) {
					if( attrCppOracleTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppOracleTableImplementation" ) ) {
					if( attrCppOracleTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppOracleTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlTableInclude" ) ) {
					if( attrCppPgSqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlTableMembers" ) ) {
					if( attrCppPgSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppPgSqlTableImplementation" ) ) {
					if( attrCppPgSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppPgSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamTableInclude" ) ) {
					if( attrCppRamTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamTableMembers" ) ) {
					if( attrCppRamTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppRamTableImplementation" ) ) {
					if( attrCppRamTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppRamTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSaxLoaderInclude" ) ) {
					if( attrCppSaxLoaderInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSaxLoaderInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSaxLoaderStartElement" ) ) {
					if( attrCppSaxLoaderStartElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSaxLoaderStartElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppSaxLoaderEndElement" ) ) {
					if( attrCppSaxLoaderEndElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppSaxLoaderEndElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgTableInclude" ) ) {
					if( attrCppXMsgTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgTableFormatters" ) ) {
					if( attrCppXMsgTableFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgTableFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstTableInclude" ) ) {
					if( attrCppXMsgRqstTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnTableInclude" ) ) {
					if( attrCppXMsgRspnTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgClientTableInclude" ) ) {
					if( attrCppXMsgClientTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgClientTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRqstTableBody" ) ) {
					if( attrCppXMsgRqstTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRqstTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgRspnTableBody" ) ) {
					if( attrCppXMsgRspnTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgRspnTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CppXMsgClientTableBody" ) ) {
					if( attrCppXMsgClientTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCppXMsgClientTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppObjMembers" ) ) {
					if( attrHppObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppObjInterface" ) ) {
					if( attrHppObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppObjInclude" ) ) {
					if( attrHppObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppObjImplementation" ) ) {
					if( attrHppObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppEditObjMembers" ) ) {
					if( attrHppEditObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppEditObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppEditObjInterface" ) ) {
					if( attrHppEditObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppEditObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppEditObjInclude" ) ) {
					if( attrHppEditObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppEditObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppEditObjImplementation" ) ) {
					if( attrHppEditObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppEditObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableInclude" ) ) {
					if( attrHppTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableMembers" ) ) {
					if( attrHppTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableInterface" ) ) {
					if( attrHppTableInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableImplementation" ) ) {
					if( attrHppTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableObjInclude" ) ) {
					if( attrHppTableObjInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableObjInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableObjMembers" ) ) {
					if( attrHppTableObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableObjInterface" ) ) {
					if( attrHppTableObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppTableObjImplementation" ) ) {
					if( attrHppTableObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppTableObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWTableInclude" ) ) {
					if( attrHppDb2LUWTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWTableMembers" ) ) {
					if( attrHppDb2LUWTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppDb2LUWTableImplementation" ) ) {
					if( attrHppDb2LUWTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppDb2LUWTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlTableInclude" ) ) {
					if( attrHppMSSqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlTableMembers" ) ) {
					if( attrHppMSSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMSSqlTableImplementation" ) ) {
					if( attrHppMSSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMSSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlTableInclude" ) ) {
					if( attrHppMySqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlTableMembers" ) ) {
					if( attrHppMySqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppMySqlTableImplementation" ) ) {
					if( attrHppMySqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppMySqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleTableInclude" ) ) {
					if( attrHppOracleTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleTableMembers" ) ) {
					if( attrHppOracleTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppOracleTableImplementation" ) ) {
					if( attrHppOracleTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppOracleTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlTableInclude" ) ) {
					if( attrHppPgSqlTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlTableMembers" ) ) {
					if( attrHppPgSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppPgSqlTableImplementation" ) ) {
					if( attrHppPgSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppPgSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamTableInclude" ) ) {
					if( attrHppRamTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamTableMembers" ) ) {
					if( attrHppRamTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppRamTableImplementation" ) ) {
					if( attrHppRamTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppRamTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSaxLoaderInclude" ) ) {
					if( attrHppSaxLoaderInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSaxLoaderInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSaxLoaderStartElement" ) ) {
					if( attrHppSaxLoaderStartElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSaxLoaderStartElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppSaxLoaderEndElement" ) ) {
					if( attrHppSaxLoaderEndElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppSaxLoaderEndElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgTableInclude" ) ) {
					if( attrHppXMsgTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgTableFormatters" ) ) {
					if( attrHppXMsgTableFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgTableFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstTableInclude" ) ) {
					if( attrHppXMsgRqstTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnTableInclude" ) ) {
					if( attrHppXMsgRspnTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgClientTableInclude" ) ) {
					if( attrHppXMsgClientTableInclude != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgClientTableInclude = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRqstTableBody" ) ) {
					if( attrHppXMsgRqstTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRqstTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgRspnTableBody" ) ) {
					if( attrHppXMsgRspnTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgRspnTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "HppXMsgClientTableBody" ) ) {
					if( attrHppXMsgClientTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrHppXMsgClientTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsObjMembers" ) ) {
					if( attrCsObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsObjInterface" ) ) {
					if( attrCsObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsObjUsing" ) ) {
					if( attrCsObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsObjImplementation" ) ) {
					if( attrCsObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsEditObjMembers" ) ) {
					if( attrCsEditObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsEditObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsEditObjInterface" ) ) {
					if( attrCsEditObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsEditObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsEditObjUsing" ) ) {
					if( attrCsEditObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsEditObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsEditObjImplementation" ) ) {
					if( attrCsEditObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsEditObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableUsing" ) ) {
					if( attrCsTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableMembers" ) ) {
					if( attrCsTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableInterface" ) ) {
					if( attrCsTableInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableImplementation" ) ) {
					if( attrCsTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableObjUsing" ) ) {
					if( attrCsTableObjUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableObjUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableObjMembers" ) ) {
					if( attrCsTableObjMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableObjMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableObjInterface" ) ) {
					if( attrCsTableObjInterface != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableObjInterface = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsTableObjImplementation" ) ) {
					if( attrCsTableObjImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsTableObjImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWTableUsing" ) ) {
					if( attrCsDb2LUWTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWTableMembers" ) ) {
					if( attrCsDb2LUWTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsDb2LUWTableImplementation" ) ) {
					if( attrCsDb2LUWTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsDb2LUWTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlTableUsing" ) ) {
					if( attrCsMSSqlTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlTableMembers" ) ) {
					if( attrCsMSSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMSSqlTableImplementation" ) ) {
					if( attrCsMSSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMSSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlTableUsing" ) ) {
					if( attrCsMySqlTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlTableMembers" ) ) {
					if( attrCsMySqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsMySqlTableImplementation" ) ) {
					if( attrCsMySqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsMySqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleTableUsing" ) ) {
					if( attrCsOracleTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleTableMembers" ) ) {
					if( attrCsOracleTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsOracleTableImplementation" ) ) {
					if( attrCsOracleTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsOracleTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlTableUsing" ) ) {
					if( attrCsPgSqlTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlTableMembers" ) ) {
					if( attrCsPgSqlTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsPgSqlTableImplementation" ) ) {
					if( attrCsPgSqlTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsPgSqlTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamTableUsing" ) ) {
					if( attrCsRamTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamTableMembers" ) ) {
					if( attrCsRamTableMembers != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamTableMembers = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsRamTableImplementation" ) ) {
					if( attrCsRamTableImplementation != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsRamTableImplementation = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSaxLoaderUsing" ) ) {
					if( attrCsSaxLoaderUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSaxLoaderUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSaxLoaderStartElement" ) ) {
					if( attrCsSaxLoaderStartElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSaxLoaderStartElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsSaxLoaderEndElement" ) ) {
					if( attrCsSaxLoaderEndElement != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsSaxLoaderEndElement = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgTableUsing" ) ) {
					if( attrCsXMsgTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgTableFormatters" ) ) {
					if( attrCsXMsgTableFormatters != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgTableFormatters = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstTableUsing" ) ) {
					if( attrCsXMsgRqstTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnTableUsing" ) ) {
					if( attrCsXMsgRspnTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgClientTableUsing" ) ) {
					if( attrCsXMsgClientTableUsing != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgClientTableUsing = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRqstTableBody" ) ) {
					if( attrCsXMsgRqstTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRqstTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgRspnTableBody" ) ) {
					if( attrCsXMsgRspnTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgRspnTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "CsXMsgClientTableBody" ) ) {
					if( attrCsXMsgClientTableBody != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrCsXMsgClientTableBody = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "DefSchema" ) ) {
					if( attrDefSchema != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrDefSchema = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "LookupIndex" ) ) {
					if( attrLookupIndex != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrLookupIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "AltIndex" ) ) {
					if( attrAltIndex != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrAltIndex = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "QualTable" ) ) {
					if( attrQualTable != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrQualTable = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PrimaryIndex" ) ) {
					if( attrPrimaryIndex != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPrimaryIndex = attrs.getValue( idxAttr );
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
			if( ( attrPageData == null ) || ( attrPageData.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PageData" );
			}
			if( attrTableClassCode == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"TableClassCode" );
			}
			if( ( attrIsInstantiable == null ) || ( attrIsInstantiable.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"IsInstantiable" );
			}
			if( ( attrHasHistory == null ) || ( attrHasHistory.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"HasHistory" );
			}
			if( ( attrHasAuditColumns == null ) || ( attrHasAuditColumns.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"HasAuditColumns" );
			}
			if( ( attrLoaderBehaviour == null ) || ( attrLoaderBehaviour.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"LoaderBehaviour" );
			}
			if( ( attrSecScope == null ) || ( attrSecScope.length() <= 0 ) ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SecScope" );
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
			curContext.putNamedValue( "PageData", attrPageData );
			curContext.putNamedValue( "TableClassCode", attrTableClassCode );
			curContext.putNamedValue( "IsInstantiable", attrIsInstantiable );
			curContext.putNamedValue( "HasHistory", attrHasHistory );
			curContext.putNamedValue( "HasAuditColumns", attrHasAuditColumns );
			curContext.putNamedValue( "LoaderBehaviour", attrLoaderBehaviour );
			curContext.putNamedValue( "SecScope", attrSecScope );
			curContext.putNamedValue( "JObjMembers", attrJObjMembers );
			curContext.putNamedValue( "JObjInterface", attrJObjInterface );
			curContext.putNamedValue( "JObjImport", attrJObjImport );
			curContext.putNamedValue( "JObjImplementation", attrJObjImplementation );
			curContext.putNamedValue( "JEditObjMembers", attrJEditObjMembers );
			curContext.putNamedValue( "JEditObjInterface", attrJEditObjInterface );
			curContext.putNamedValue( "JEditObjImport", attrJEditObjImport );
			curContext.putNamedValue( "JEditObjImplementation", attrJEditObjImplementation );
			curContext.putNamedValue( "JTableImport", attrJTableImport );
			curContext.putNamedValue( "JTableMembers", attrJTableMembers );
			curContext.putNamedValue( "JTableInterface", attrJTableInterface );
			curContext.putNamedValue( "JTableImplementation", attrJTableImplementation );
			curContext.putNamedValue( "JTableObjImport", attrJTableObjImport );
			curContext.putNamedValue( "JTableObjMembers", attrJTableObjMembers );
			curContext.putNamedValue( "JTableObjInterface", attrJTableObjInterface );
			curContext.putNamedValue( "JTableObjImplementation", attrJTableObjImplementation );
			curContext.putNamedValue( "JDb2LUWTableImport", attrJDb2LUWTableImport );
			curContext.putNamedValue( "JDb2LUWTableMembers", attrJDb2LUWTableMembers );
			curContext.putNamedValue( "JDb2LUWTableImplementation", attrJDb2LUWTableImplementation );
			curContext.putNamedValue( "JMSSqlTableImport", attrJMSSqlTableImport );
			curContext.putNamedValue( "JMSSqlTableMembers", attrJMSSqlTableMembers );
			curContext.putNamedValue( "JMSSqlTableImplementation", attrJMSSqlTableImplementation );
			curContext.putNamedValue( "JMySqlTableImport", attrJMySqlTableImport );
			curContext.putNamedValue( "JMySqlTableMembers", attrJMySqlTableMembers );
			curContext.putNamedValue( "JMySqlTableImplementation", attrJMySqlTableImplementation );
			curContext.putNamedValue( "JOracleTableImport", attrJOracleTableImport );
			curContext.putNamedValue( "JOracleTableMembers", attrJOracleTableMembers );
			curContext.putNamedValue( "JOracleTableImplementation", attrJOracleTableImplementation );
			curContext.putNamedValue( "JPgSqlTableImport", attrJPgSqlTableImport );
			curContext.putNamedValue( "JPgSqlTableMembers", attrJPgSqlTableMembers );
			curContext.putNamedValue( "JPgSqlTableImplementation", attrJPgSqlTableImplementation );
			curContext.putNamedValue( "JRamTableImport", attrJRamTableImport );
			curContext.putNamedValue( "JRamTableMembers", attrJRamTableMembers );
			curContext.putNamedValue( "JRamTableImplementation", attrJRamTableImplementation );
			curContext.putNamedValue( "JSaxLoaderImport", attrJSaxLoaderImport );
			curContext.putNamedValue( "JSaxLoaderStartElement", attrJSaxLoaderStartElement );
			curContext.putNamedValue( "JSaxLoaderEndElement", attrJSaxLoaderEndElement );
			curContext.putNamedValue( "JXMsgTableImport", attrJXMsgTableImport );
			curContext.putNamedValue( "JXMsgTableFormatters", attrJXMsgTableFormatters );
			curContext.putNamedValue( "JXMsgRqstTableImport", attrJXMsgRqstTableImport );
			curContext.putNamedValue( "JXMsgRspnTableImport", attrJXMsgRspnTableImport );
			curContext.putNamedValue( "JXMsgClientTableImport", attrJXMsgClientTableImport );
			curContext.putNamedValue( "JXMsgRqstTableBody", attrJXMsgRqstTableBody );
			curContext.putNamedValue( "JXMsgRspnTableBody", attrJXMsgRspnTableBody );
			curContext.putNamedValue( "JXMsgClientTableBody", attrJXMsgClientTableBody );
			curContext.putNamedValue( "CppObjMembers", attrCppObjMembers );
			curContext.putNamedValue( "CppObjInterface", attrCppObjInterface );
			curContext.putNamedValue( "CppObjInclude", attrCppObjInclude );
			curContext.putNamedValue( "CppObjImplementation", attrCppObjImplementation );
			curContext.putNamedValue( "CppEditObjMembers", attrCppEditObjMembers );
			curContext.putNamedValue( "CppEditObjInterface", attrCppEditObjInterface );
			curContext.putNamedValue( "CppEditObjInclude", attrCppEditObjInclude );
			curContext.putNamedValue( "CppEditObjImplementation", attrCppEditObjImplementation );
			curContext.putNamedValue( "CppTableInclude", attrCppTableInclude );
			curContext.putNamedValue( "CppTableMembers", attrCppTableMembers );
			curContext.putNamedValue( "CppTableInterface", attrCppTableInterface );
			curContext.putNamedValue( "CppTableImplementation", attrCppTableImplementation );
			curContext.putNamedValue( "CppTableObjInclude", attrCppTableObjInclude );
			curContext.putNamedValue( "CppTableObjMembers", attrCppTableObjMembers );
			curContext.putNamedValue( "CppTableObjInterface", attrCppTableObjInterface );
			curContext.putNamedValue( "CppTableObjImplementation", attrCppTableObjImplementation );
			curContext.putNamedValue( "CppDb2LUWTableInclude", attrCppDb2LUWTableInclude );
			curContext.putNamedValue( "CppDb2LUWTableMembers", attrCppDb2LUWTableMembers );
			curContext.putNamedValue( "CppDb2LUWTableImplementation", attrCppDb2LUWTableImplementation );
			curContext.putNamedValue( "CppMSSqlTableInclude", attrCppMSSqlTableInclude );
			curContext.putNamedValue( "CppMSSqlTableMembers", attrCppMSSqlTableMembers );
			curContext.putNamedValue( "CppMSSqlTableImplementation", attrCppMSSqlTableImplementation );
			curContext.putNamedValue( "CppMySqlTableInclude", attrCppMySqlTableInclude );
			curContext.putNamedValue( "CppMySqlTableMembers", attrCppMySqlTableMembers );
			curContext.putNamedValue( "CppMySqlTableImplementation", attrCppMySqlTableImplementation );
			curContext.putNamedValue( "CppOracleTableInclude", attrCppOracleTableInclude );
			curContext.putNamedValue( "CppOracleTableMembers", attrCppOracleTableMembers );
			curContext.putNamedValue( "CppOracleTableImplementation", attrCppOracleTableImplementation );
			curContext.putNamedValue( "CppPgSqlTableInclude", attrCppPgSqlTableInclude );
			curContext.putNamedValue( "CppPgSqlTableMembers", attrCppPgSqlTableMembers );
			curContext.putNamedValue( "CppPgSqlTableImplementation", attrCppPgSqlTableImplementation );
			curContext.putNamedValue( "CppRamTableInclude", attrCppRamTableInclude );
			curContext.putNamedValue( "CppRamTableMembers", attrCppRamTableMembers );
			curContext.putNamedValue( "CppRamTableImplementation", attrCppRamTableImplementation );
			curContext.putNamedValue( "CppSaxLoaderInclude", attrCppSaxLoaderInclude );
			curContext.putNamedValue( "CppSaxLoaderStartElement", attrCppSaxLoaderStartElement );
			curContext.putNamedValue( "CppSaxLoaderEndElement", attrCppSaxLoaderEndElement );
			curContext.putNamedValue( "CppXMsgTableInclude", attrCppXMsgTableInclude );
			curContext.putNamedValue( "CppXMsgTableFormatters", attrCppXMsgTableFormatters );
			curContext.putNamedValue( "CppXMsgRqstTableInclude", attrCppXMsgRqstTableInclude );
			curContext.putNamedValue( "CppXMsgRspnTableInclude", attrCppXMsgRspnTableInclude );
			curContext.putNamedValue( "CppXMsgClientTableInclude", attrCppXMsgClientTableInclude );
			curContext.putNamedValue( "CppXMsgRqstTableBody", attrCppXMsgRqstTableBody );
			curContext.putNamedValue( "CppXMsgRspnTableBody", attrCppXMsgRspnTableBody );
			curContext.putNamedValue( "CppXMsgClientTableBody", attrCppXMsgClientTableBody );
			curContext.putNamedValue( "HppObjMembers", attrHppObjMembers );
			curContext.putNamedValue( "HppObjInterface", attrHppObjInterface );
			curContext.putNamedValue( "HppObjInclude", attrHppObjInclude );
			curContext.putNamedValue( "HppObjImplementation", attrHppObjImplementation );
			curContext.putNamedValue( "HppEditObjMembers", attrHppEditObjMembers );
			curContext.putNamedValue( "HppEditObjInterface", attrHppEditObjInterface );
			curContext.putNamedValue( "HppEditObjInclude", attrHppEditObjInclude );
			curContext.putNamedValue( "HppEditObjImplementation", attrHppEditObjImplementation );
			curContext.putNamedValue( "HppTableInclude", attrHppTableInclude );
			curContext.putNamedValue( "HppTableMembers", attrHppTableMembers );
			curContext.putNamedValue( "HppTableInterface", attrHppTableInterface );
			curContext.putNamedValue( "HppTableImplementation", attrHppTableImplementation );
			curContext.putNamedValue( "HppTableObjInclude", attrHppTableObjInclude );
			curContext.putNamedValue( "HppTableObjMembers", attrHppTableObjMembers );
			curContext.putNamedValue( "HppTableObjInterface", attrHppTableObjInterface );
			curContext.putNamedValue( "HppTableObjImplementation", attrHppTableObjImplementation );
			curContext.putNamedValue( "HppDb2LUWTableInclude", attrHppDb2LUWTableInclude );
			curContext.putNamedValue( "HppDb2LUWTableMembers", attrHppDb2LUWTableMembers );
			curContext.putNamedValue( "HppDb2LUWTableImplementation", attrHppDb2LUWTableImplementation );
			curContext.putNamedValue( "HppMSSqlTableInclude", attrHppMSSqlTableInclude );
			curContext.putNamedValue( "HppMSSqlTableMembers", attrHppMSSqlTableMembers );
			curContext.putNamedValue( "HppMSSqlTableImplementation", attrHppMSSqlTableImplementation );
			curContext.putNamedValue( "HppMySqlTableInclude", attrHppMySqlTableInclude );
			curContext.putNamedValue( "HppMySqlTableMembers", attrHppMySqlTableMembers );
			curContext.putNamedValue( "HppMySqlTableImplementation", attrHppMySqlTableImplementation );
			curContext.putNamedValue( "HppOracleTableInclude", attrHppOracleTableInclude );
			curContext.putNamedValue( "HppOracleTableMembers", attrHppOracleTableMembers );
			curContext.putNamedValue( "HppOracleTableImplementation", attrHppOracleTableImplementation );
			curContext.putNamedValue( "HppPgSqlTableInclude", attrHppPgSqlTableInclude );
			curContext.putNamedValue( "HppPgSqlTableMembers", attrHppPgSqlTableMembers );
			curContext.putNamedValue( "HppPgSqlTableImplementation", attrHppPgSqlTableImplementation );
			curContext.putNamedValue( "HppRamTableInclude", attrHppRamTableInclude );
			curContext.putNamedValue( "HppRamTableMembers", attrHppRamTableMembers );
			curContext.putNamedValue( "HppRamTableImplementation", attrHppRamTableImplementation );
			curContext.putNamedValue( "HppSaxLoaderInclude", attrHppSaxLoaderInclude );
			curContext.putNamedValue( "HppSaxLoaderStartElement", attrHppSaxLoaderStartElement );
			curContext.putNamedValue( "HppSaxLoaderEndElement", attrHppSaxLoaderEndElement );
			curContext.putNamedValue( "HppXMsgTableInclude", attrHppXMsgTableInclude );
			curContext.putNamedValue( "HppXMsgTableFormatters", attrHppXMsgTableFormatters );
			curContext.putNamedValue( "HppXMsgRqstTableInclude", attrHppXMsgRqstTableInclude );
			curContext.putNamedValue( "HppXMsgRspnTableInclude", attrHppXMsgRspnTableInclude );
			curContext.putNamedValue( "HppXMsgClientTableInclude", attrHppXMsgClientTableInclude );
			curContext.putNamedValue( "HppXMsgRqstTableBody", attrHppXMsgRqstTableBody );
			curContext.putNamedValue( "HppXMsgRspnTableBody", attrHppXMsgRspnTableBody );
			curContext.putNamedValue( "HppXMsgClientTableBody", attrHppXMsgClientTableBody );
			curContext.putNamedValue( "CsObjMembers", attrCsObjMembers );
			curContext.putNamedValue( "CsObjInterface", attrCsObjInterface );
			curContext.putNamedValue( "CsObjUsing", attrCsObjUsing );
			curContext.putNamedValue( "CsObjImplementation", attrCsObjImplementation );
			curContext.putNamedValue( "CsEditObjMembers", attrCsEditObjMembers );
			curContext.putNamedValue( "CsEditObjInterface", attrCsEditObjInterface );
			curContext.putNamedValue( "CsEditObjUsing", attrCsEditObjUsing );
			curContext.putNamedValue( "CsEditObjImplementation", attrCsEditObjImplementation );
			curContext.putNamedValue( "CsTableUsing", attrCsTableUsing );
			curContext.putNamedValue( "CsTableMembers", attrCsTableMembers );
			curContext.putNamedValue( "CsTableInterface", attrCsTableInterface );
			curContext.putNamedValue( "CsTableImplementation", attrCsTableImplementation );
			curContext.putNamedValue( "CsTableObjUsing", attrCsTableObjUsing );
			curContext.putNamedValue( "CsTableObjMembers", attrCsTableObjMembers );
			curContext.putNamedValue( "CsTableObjInterface", attrCsTableObjInterface );
			curContext.putNamedValue( "CsTableObjImplementation", attrCsTableObjImplementation );
			curContext.putNamedValue( "CsDb2LUWTableUsing", attrCsDb2LUWTableUsing );
			curContext.putNamedValue( "CsDb2LUWTableMembers", attrCsDb2LUWTableMembers );
			curContext.putNamedValue( "CsDb2LUWTableImplementation", attrCsDb2LUWTableImplementation );
			curContext.putNamedValue( "CsMSSqlTableUsing", attrCsMSSqlTableUsing );
			curContext.putNamedValue( "CsMSSqlTableMembers", attrCsMSSqlTableMembers );
			curContext.putNamedValue( "CsMSSqlTableImplementation", attrCsMSSqlTableImplementation );
			curContext.putNamedValue( "CsMySqlTableUsing", attrCsMySqlTableUsing );
			curContext.putNamedValue( "CsMySqlTableMembers", attrCsMySqlTableMembers );
			curContext.putNamedValue( "CsMySqlTableImplementation", attrCsMySqlTableImplementation );
			curContext.putNamedValue( "CsOracleTableUsing", attrCsOracleTableUsing );
			curContext.putNamedValue( "CsOracleTableMembers", attrCsOracleTableMembers );
			curContext.putNamedValue( "CsOracleTableImplementation", attrCsOracleTableImplementation );
			curContext.putNamedValue( "CsPgSqlTableUsing", attrCsPgSqlTableUsing );
			curContext.putNamedValue( "CsPgSqlTableMembers", attrCsPgSqlTableMembers );
			curContext.putNamedValue( "CsPgSqlTableImplementation", attrCsPgSqlTableImplementation );
			curContext.putNamedValue( "CsRamTableUsing", attrCsRamTableUsing );
			curContext.putNamedValue( "CsRamTableMembers", attrCsRamTableMembers );
			curContext.putNamedValue( "CsRamTableImplementation", attrCsRamTableImplementation );
			curContext.putNamedValue( "CsSaxLoaderUsing", attrCsSaxLoaderUsing );
			curContext.putNamedValue( "CsSaxLoaderStartElement", attrCsSaxLoaderStartElement );
			curContext.putNamedValue( "CsSaxLoaderEndElement", attrCsSaxLoaderEndElement );
			curContext.putNamedValue( "CsXMsgTableUsing", attrCsXMsgTableUsing );
			curContext.putNamedValue( "CsXMsgTableFormatters", attrCsXMsgTableFormatters );
			curContext.putNamedValue( "CsXMsgRqstTableUsing", attrCsXMsgRqstTableUsing );
			curContext.putNamedValue( "CsXMsgRspnTableUsing", attrCsXMsgRspnTableUsing );
			curContext.putNamedValue( "CsXMsgClientTableUsing", attrCsXMsgClientTableUsing );
			curContext.putNamedValue( "CsXMsgRqstTableBody", attrCsXMsgRqstTableBody );
			curContext.putNamedValue( "CsXMsgRspnTableBody", attrCsXMsgRspnTableBody );
			curContext.putNamedValue( "CsXMsgClientTableBody", attrCsXMsgClientTableBody );
			curContext.putNamedValue( "DefSchema", attrDefSchema );
			curContext.putNamedValue( "LookupIndex", attrLookupIndex );
			curContext.putNamedValue( "AltIndex", attrAltIndex );
			curContext.putNamedValue( "QualTable", attrQualTable );
			curContext.putNamedValue( "PrimaryIndex", attrPrimaryIndex );

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

			boolean natPageData;
			if( attrPageData.equals( "true" ) || attrPageData.equals( "yes" ) || attrPageData.equals( "1" ) ) {
				natPageData = true;
			}
			else if( attrPageData.equals( "false" ) || attrPageData.equals( "no" ) || attrPageData.equals( "0" ) ) {
				natPageData = false;
			}
			else {
				throw new CFLibUsageException( getClass(),
					S_ProcName,
					"Unexpected PageData value, must be one of true, false, yes, no, 1, or 0, not \"" + attrPageData + "\"" );
			}
			editBuff.setRequiredPageData( natPageData );

			String natTableClassCode = attrTableClassCode;
			editBuff.setRequiredTableClassCode( natTableClassCode );

			boolean natIsInstantiable;
			if( attrIsInstantiable.equals( "true" ) || attrIsInstantiable.equals( "yes" ) || attrIsInstantiable.equals( "1" ) ) {
				natIsInstantiable = true;
			}
			else if( attrIsInstantiable.equals( "false" ) || attrIsInstantiable.equals( "no" ) || attrIsInstantiable.equals( "0" ) ) {
				natIsInstantiable = false;
			}
			else {
				throw new CFLibUsageException( getClass(),
					S_ProcName,
					"Unexpected IsInstantiable value, must be one of true, false, yes, no, 1, or 0, not \"" + attrIsInstantiable + "\"" );
			}
			editBuff.setRequiredIsInstantiable( natIsInstantiable );

			boolean natHasHistory;
			if( attrHasHistory.equals( "true" ) || attrHasHistory.equals( "yes" ) || attrHasHistory.equals( "1" ) ) {
				natHasHistory = true;
			}
			else if( attrHasHistory.equals( "false" ) || attrHasHistory.equals( "no" ) || attrHasHistory.equals( "0" ) ) {
				natHasHistory = false;
			}
			else {
				throw new CFLibUsageException( getClass(),
					S_ProcName,
					"Unexpected HasHistory value, must be one of true, false, yes, no, 1, or 0, not \"" + attrHasHistory + "\"" );
			}
			editBuff.setRequiredHasHistory( natHasHistory );

			boolean natHasAuditColumns;
			if( attrHasAuditColumns.equals( "true" ) || attrHasAuditColumns.equals( "yes" ) || attrHasAuditColumns.equals( "1" ) ) {
				natHasAuditColumns = true;
			}
			else if( attrHasAuditColumns.equals( "false" ) || attrHasAuditColumns.equals( "no" ) || attrHasAuditColumns.equals( "0" ) ) {
				natHasAuditColumns = false;
			}
			else {
				throw new CFLibUsageException( getClass(),
					S_ProcName,
					"Unexpected HasAuditColumns value, must be one of true, false, yes, no, 1, or 0, not \"" + attrHasAuditColumns + "\"" );
			}
			editBuff.setRequiredHasAuditColumns( natHasAuditColumns );

			ICFBamSchema.LoaderBehaviourEnum natLoaderBehaviour = CFBamSchema.parseLoaderBehaviourEnum( attrLoaderBehaviour );
			editBuff.setRequiredLoaderBehaviour( natLoaderBehaviour );

			ICFBamSchema.SecScopeEnum natSecScope = CFBamSchema.parseSecScopeEnum( attrSecScope );
			editBuff.setRequiredSecScope( natSecScope );

			String natJObjMembers = attrJObjMembers;
			editBuff.setOptionalJObjMembers( natJObjMembers );

			String natJObjInterface = attrJObjInterface;
			editBuff.setOptionalJObjInterface( natJObjInterface );

			String natJObjImport = attrJObjImport;
			editBuff.setOptionalJObjImport( natJObjImport );

			String natJObjImplementation = attrJObjImplementation;
			editBuff.setOptionalJObjImplementation( natJObjImplementation );

			String natJEditObjMembers = attrJEditObjMembers;
			editBuff.setOptionalJEditObjMembers( natJEditObjMembers );

			String natJEditObjInterface = attrJEditObjInterface;
			editBuff.setOptionalJEditObjInterface( natJEditObjInterface );

			String natJEditObjImport = attrJEditObjImport;
			editBuff.setOptionalJEditObjImport( natJEditObjImport );

			String natJEditObjImplementation = attrJEditObjImplementation;
			editBuff.setOptionalJEditObjImplementation( natJEditObjImplementation );

			String natJTableImport = attrJTableImport;
			editBuff.setOptionalJTableImport( natJTableImport );

			String natJTableMembers = attrJTableMembers;
			editBuff.setOptionalJTableMembers( natJTableMembers );

			String natJTableInterface = attrJTableInterface;
			editBuff.setOptionalJTableInterface( natJTableInterface );

			String natJTableImplementation = attrJTableImplementation;
			editBuff.setOptionalJTableImplementation( natJTableImplementation );

			String natJTableObjImport = attrJTableObjImport;
			editBuff.setOptionalJTableObjImport( natJTableObjImport );

			String natJTableObjMembers = attrJTableObjMembers;
			editBuff.setOptionalJTableObjMembers( natJTableObjMembers );

			String natJTableObjInterface = attrJTableObjInterface;
			editBuff.setOptionalJTableObjInterface( natJTableObjInterface );

			String natJTableObjImplementation = attrJTableObjImplementation;
			editBuff.setOptionalJTableObjImplementation( natJTableObjImplementation );

			String natJDb2LUWTableImport = attrJDb2LUWTableImport;
			editBuff.setOptionalJDb2LUWTableImport( natJDb2LUWTableImport );

			String natJDb2LUWTableMembers = attrJDb2LUWTableMembers;
			editBuff.setOptionalJDb2LUWTableMembers( natJDb2LUWTableMembers );

			String natJDb2LUWTableImplementation = attrJDb2LUWTableImplementation;
			editBuff.setOptionalJDb2LUWTableImplementation( natJDb2LUWTableImplementation );

			String natJMSSqlTableImport = attrJMSSqlTableImport;
			editBuff.setOptionalJMSSqlTableImport( natJMSSqlTableImport );

			String natJMSSqlTableMembers = attrJMSSqlTableMembers;
			editBuff.setOptionalJMSSqlTableMembers( natJMSSqlTableMembers );

			String natJMSSqlTableImplementation = attrJMSSqlTableImplementation;
			editBuff.setOptionalJMSSqlTableImplementation( natJMSSqlTableImplementation );

			String natJMySqlTableImport = attrJMySqlTableImport;
			editBuff.setOptionalJMySqlTableImport( natJMySqlTableImport );

			String natJMySqlTableMembers = attrJMySqlTableMembers;
			editBuff.setOptionalJMySqlTableMembers( natJMySqlTableMembers );

			String natJMySqlTableImplementation = attrJMySqlTableImplementation;
			editBuff.setOptionalJMySqlTableImplementation( natJMySqlTableImplementation );

			String natJOracleTableImport = attrJOracleTableImport;
			editBuff.setOptionalJOracleTableImport( natJOracleTableImport );

			String natJOracleTableMembers = attrJOracleTableMembers;
			editBuff.setOptionalJOracleTableMembers( natJOracleTableMembers );

			String natJOracleTableImplementation = attrJOracleTableImplementation;
			editBuff.setOptionalJOracleTableImplementation( natJOracleTableImplementation );

			String natJPgSqlTableImport = attrJPgSqlTableImport;
			editBuff.setOptionalJPgSqlTableImport( natJPgSqlTableImport );

			String natJPgSqlTableMembers = attrJPgSqlTableMembers;
			editBuff.setOptionalJPgSqlTableMembers( natJPgSqlTableMembers );

			String natJPgSqlTableImplementation = attrJPgSqlTableImplementation;
			editBuff.setOptionalJPgSqlTableImplementation( natJPgSqlTableImplementation );

			String natJRamTableImport = attrJRamTableImport;
			editBuff.setOptionalJRamTableImport( natJRamTableImport );

			String natJRamTableMembers = attrJRamTableMembers;
			editBuff.setOptionalJRamTableMembers( natJRamTableMembers );

			String natJRamTableImplementation = attrJRamTableImplementation;
			editBuff.setOptionalJRamTableImplementation( natJRamTableImplementation );

			String natJSaxLoaderImport = attrJSaxLoaderImport;
			editBuff.setOptionalJSaxLoaderImport( natJSaxLoaderImport );

			String natJSaxLoaderStartElement = attrJSaxLoaderStartElement;
			editBuff.setOptionalJSaxLoaderStartElement( natJSaxLoaderStartElement );

			String natJSaxLoaderEndElement = attrJSaxLoaderEndElement;
			editBuff.setOptionalJSaxLoaderEndElement( natJSaxLoaderEndElement );

			String natJXMsgTableImport = attrJXMsgTableImport;
			editBuff.setOptionalJXMsgTableImport( natJXMsgTableImport );

			String natJXMsgTableFormatters = attrJXMsgTableFormatters;
			editBuff.setOptionalJXMsgTableFormatters( natJXMsgTableFormatters );

			String natJXMsgRqstTableImport = attrJXMsgRqstTableImport;
			editBuff.setOptionalJXMsgRqstTableImport( natJXMsgRqstTableImport );

			String natJXMsgRspnTableImport = attrJXMsgRspnTableImport;
			editBuff.setOptionalJXMsgRspnTableImport( natJXMsgRspnTableImport );

			String natJXMsgClientTableImport = attrJXMsgClientTableImport;
			editBuff.setOptionalJXMsgClientTableImport( natJXMsgClientTableImport );

			String natJXMsgRqstTableBody = attrJXMsgRqstTableBody;
			editBuff.setOptionalJXMsgRqstTableBody( natJXMsgRqstTableBody );

			String natJXMsgRspnTableBody = attrJXMsgRspnTableBody;
			editBuff.setOptionalJXMsgRspnTableBody( natJXMsgRspnTableBody );

			String natJXMsgClientTableBody = attrJXMsgClientTableBody;
			editBuff.setOptionalJXMsgClientTableBody( natJXMsgClientTableBody );

			String natCppObjMembers = attrCppObjMembers;
			editBuff.setOptionalCppObjMembers( natCppObjMembers );

			String natCppObjInterface = attrCppObjInterface;
			editBuff.setOptionalCppObjInterface( natCppObjInterface );

			String natCppObjInclude = attrCppObjInclude;
			editBuff.setOptionalCppObjInclude( natCppObjInclude );

			String natCppObjImplementation = attrCppObjImplementation;
			editBuff.setOptionalCppObjImplementation( natCppObjImplementation );

			String natCppEditObjMembers = attrCppEditObjMembers;
			editBuff.setOptionalCppEditObjMembers( natCppEditObjMembers );

			String natCppEditObjInterface = attrCppEditObjInterface;
			editBuff.setOptionalCppEditObjInterface( natCppEditObjInterface );

			String natCppEditObjInclude = attrCppEditObjInclude;
			editBuff.setOptionalCppEditObjInclude( natCppEditObjInclude );

			String natCppEditObjImplementation = attrCppEditObjImplementation;
			editBuff.setOptionalCppEditObjImplementation( natCppEditObjImplementation );

			String natCppTableInclude = attrCppTableInclude;
			editBuff.setOptionalCppTableInclude( natCppTableInclude );

			String natCppTableMembers = attrCppTableMembers;
			editBuff.setOptionalCppTableMembers( natCppTableMembers );

			String natCppTableInterface = attrCppTableInterface;
			editBuff.setOptionalCppTableInterface( natCppTableInterface );

			String natCppTableImplementation = attrCppTableImplementation;
			editBuff.setOptionalCppTableImplementation( natCppTableImplementation );

			String natCppTableObjInclude = attrCppTableObjInclude;
			editBuff.setOptionalCppTableObjInclude( natCppTableObjInclude );

			String natCppTableObjMembers = attrCppTableObjMembers;
			editBuff.setOptionalCppTableObjMembers( natCppTableObjMembers );

			String natCppTableObjInterface = attrCppTableObjInterface;
			editBuff.setOptionalCppTableObjInterface( natCppTableObjInterface );

			String natCppTableObjImplementation = attrCppTableObjImplementation;
			editBuff.setOptionalCppTableObjImplementation( natCppTableObjImplementation );

			String natCppDb2LUWTableInclude = attrCppDb2LUWTableInclude;
			editBuff.setOptionalCppDb2LUWTableInclude( natCppDb2LUWTableInclude );

			String natCppDb2LUWTableMembers = attrCppDb2LUWTableMembers;
			editBuff.setOptionalCppDb2LUWTableMembers( natCppDb2LUWTableMembers );

			String natCppDb2LUWTableImplementation = attrCppDb2LUWTableImplementation;
			editBuff.setOptionalCppDb2LUWTableImplementation( natCppDb2LUWTableImplementation );

			String natCppMSSqlTableInclude = attrCppMSSqlTableInclude;
			editBuff.setOptionalCppMSSqlTableInclude( natCppMSSqlTableInclude );

			String natCppMSSqlTableMembers = attrCppMSSqlTableMembers;
			editBuff.setOptionalCppMSSqlTableMembers( natCppMSSqlTableMembers );

			String natCppMSSqlTableImplementation = attrCppMSSqlTableImplementation;
			editBuff.setOptionalCppMSSqlTableImplementation( natCppMSSqlTableImplementation );

			String natCppMySqlTableInclude = attrCppMySqlTableInclude;
			editBuff.setOptionalCppMySqlTableInclude( natCppMySqlTableInclude );

			String natCppMySqlTableMembers = attrCppMySqlTableMembers;
			editBuff.setOptionalCppMySqlTableMembers( natCppMySqlTableMembers );

			String natCppMySqlTableImplementation = attrCppMySqlTableImplementation;
			editBuff.setOptionalCppMySqlTableImplementation( natCppMySqlTableImplementation );

			String natCppOracleTableInclude = attrCppOracleTableInclude;
			editBuff.setOptionalCppOracleTableInclude( natCppOracleTableInclude );

			String natCppOracleTableMembers = attrCppOracleTableMembers;
			editBuff.setOptionalCppOracleTableMembers( natCppOracleTableMembers );

			String natCppOracleTableImplementation = attrCppOracleTableImplementation;
			editBuff.setOptionalCppOracleTableImplementation( natCppOracleTableImplementation );

			String natCppPgSqlTableInclude = attrCppPgSqlTableInclude;
			editBuff.setOptionalCppPgSqlTableInclude( natCppPgSqlTableInclude );

			String natCppPgSqlTableMembers = attrCppPgSqlTableMembers;
			editBuff.setOptionalCppPgSqlTableMembers( natCppPgSqlTableMembers );

			String natCppPgSqlTableImplementation = attrCppPgSqlTableImplementation;
			editBuff.setOptionalCppPgSqlTableImplementation( natCppPgSqlTableImplementation );

			String natCppRamTableInclude = attrCppRamTableInclude;
			editBuff.setOptionalCppRamTableInclude( natCppRamTableInclude );

			String natCppRamTableMembers = attrCppRamTableMembers;
			editBuff.setOptionalCppRamTableMembers( natCppRamTableMembers );

			String natCppRamTableImplementation = attrCppRamTableImplementation;
			editBuff.setOptionalCppRamTableImplementation( natCppRamTableImplementation );

			String natCppSaxLoaderInclude = attrCppSaxLoaderInclude;
			editBuff.setOptionalCppSaxLoaderInclude( natCppSaxLoaderInclude );

			String natCppSaxLoaderStartElement = attrCppSaxLoaderStartElement;
			editBuff.setOptionalCppSaxLoaderStartElement( natCppSaxLoaderStartElement );

			String natCppSaxLoaderEndElement = attrCppSaxLoaderEndElement;
			editBuff.setOptionalCppSaxLoaderEndElement( natCppSaxLoaderEndElement );

			String natCppXMsgTableInclude = attrCppXMsgTableInclude;
			editBuff.setOptionalCppXMsgTableInclude( natCppXMsgTableInclude );

			String natCppXMsgTableFormatters = attrCppXMsgTableFormatters;
			editBuff.setOptionalCppXMsgTableFormatters( natCppXMsgTableFormatters );

			String natCppXMsgRqstTableInclude = attrCppXMsgRqstTableInclude;
			editBuff.setOptionalCppXMsgRqstTableInclude( natCppXMsgRqstTableInclude );

			String natCppXMsgRspnTableInclude = attrCppXMsgRspnTableInclude;
			editBuff.setOptionalCppXMsgRspnTableInclude( natCppXMsgRspnTableInclude );

			String natCppXMsgClientTableInclude = attrCppXMsgClientTableInclude;
			editBuff.setOptionalCppXMsgClientTableInclude( natCppXMsgClientTableInclude );

			String natCppXMsgRqstTableBody = attrCppXMsgRqstTableBody;
			editBuff.setOptionalCppXMsgRqstTableBody( natCppXMsgRqstTableBody );

			String natCppXMsgRspnTableBody = attrCppXMsgRspnTableBody;
			editBuff.setOptionalCppXMsgRspnTableBody( natCppXMsgRspnTableBody );

			String natCppXMsgClientTableBody = attrCppXMsgClientTableBody;
			editBuff.setOptionalCppXMsgClientTableBody( natCppXMsgClientTableBody );

			String natHppObjMembers = attrHppObjMembers;
			editBuff.setOptionalHppObjMembers( natHppObjMembers );

			String natHppObjInterface = attrHppObjInterface;
			editBuff.setOptionalHppObjInterface( natHppObjInterface );

			String natHppObjInclude = attrHppObjInclude;
			editBuff.setOptionalHppObjInclude( natHppObjInclude );

			String natHppObjImplementation = attrHppObjImplementation;
			editBuff.setOptionalHppObjImplementation( natHppObjImplementation );

			String natHppEditObjMembers = attrHppEditObjMembers;
			editBuff.setOptionalHppEditObjMembers( natHppEditObjMembers );

			String natHppEditObjInterface = attrHppEditObjInterface;
			editBuff.setOptionalHppEditObjInterface( natHppEditObjInterface );

			String natHppEditObjInclude = attrHppEditObjInclude;
			editBuff.setOptionalHppEditObjInclude( natHppEditObjInclude );

			String natHppEditObjImplementation = attrHppEditObjImplementation;
			editBuff.setOptionalHppEditObjImplementation( natHppEditObjImplementation );

			String natHppTableInclude = attrHppTableInclude;
			editBuff.setOptionalHppTableInclude( natHppTableInclude );

			String natHppTableMembers = attrHppTableMembers;
			editBuff.setOptionalHppTableMembers( natHppTableMembers );

			String natHppTableInterface = attrHppTableInterface;
			editBuff.setOptionalHppTableInterface( natHppTableInterface );

			String natHppTableImplementation = attrHppTableImplementation;
			editBuff.setOptionalHppTableImplementation( natHppTableImplementation );

			String natHppTableObjInclude = attrHppTableObjInclude;
			editBuff.setOptionalHppTableObjInclude( natHppTableObjInclude );

			String natHppTableObjMembers = attrHppTableObjMembers;
			editBuff.setOptionalHppTableObjMembers( natHppTableObjMembers );

			String natHppTableObjInterface = attrHppTableObjInterface;
			editBuff.setOptionalHppTableObjInterface( natHppTableObjInterface );

			String natHppTableObjImplementation = attrHppTableObjImplementation;
			editBuff.setOptionalHppTableObjImplementation( natHppTableObjImplementation );

			String natHppDb2LUWTableInclude = attrHppDb2LUWTableInclude;
			editBuff.setOptionalHppDb2LUWTableInclude( natHppDb2LUWTableInclude );

			String natHppDb2LUWTableMembers = attrHppDb2LUWTableMembers;
			editBuff.setOptionalHppDb2LUWTableMembers( natHppDb2LUWTableMembers );

			String natHppDb2LUWTableImplementation = attrHppDb2LUWTableImplementation;
			editBuff.setOptionalHppDb2LUWTableImplementation( natHppDb2LUWTableImplementation );

			String natHppMSSqlTableInclude = attrHppMSSqlTableInclude;
			editBuff.setOptionalHppMSSqlTableInclude( natHppMSSqlTableInclude );

			String natHppMSSqlTableMembers = attrHppMSSqlTableMembers;
			editBuff.setOptionalHppMSSqlTableMembers( natHppMSSqlTableMembers );

			String natHppMSSqlTableImplementation = attrHppMSSqlTableImplementation;
			editBuff.setOptionalHppMSSqlTableImplementation( natHppMSSqlTableImplementation );

			String natHppMySqlTableInclude = attrHppMySqlTableInclude;
			editBuff.setOptionalHppMySqlTableInclude( natHppMySqlTableInclude );

			String natHppMySqlTableMembers = attrHppMySqlTableMembers;
			editBuff.setOptionalHppMySqlTableMembers( natHppMySqlTableMembers );

			String natHppMySqlTableImplementation = attrHppMySqlTableImplementation;
			editBuff.setOptionalHppMySqlTableImplementation( natHppMySqlTableImplementation );

			String natHppOracleTableInclude = attrHppOracleTableInclude;
			editBuff.setOptionalHppOracleTableInclude( natHppOracleTableInclude );

			String natHppOracleTableMembers = attrHppOracleTableMembers;
			editBuff.setOptionalHppOracleTableMembers( natHppOracleTableMembers );

			String natHppOracleTableImplementation = attrHppOracleTableImplementation;
			editBuff.setOptionalHppOracleTableImplementation( natHppOracleTableImplementation );

			String natHppPgSqlTableInclude = attrHppPgSqlTableInclude;
			editBuff.setOptionalHppPgSqlTableInclude( natHppPgSqlTableInclude );

			String natHppPgSqlTableMembers = attrHppPgSqlTableMembers;
			editBuff.setOptionalHppPgSqlTableMembers( natHppPgSqlTableMembers );

			String natHppPgSqlTableImplementation = attrHppPgSqlTableImplementation;
			editBuff.setOptionalHppPgSqlTableImplementation( natHppPgSqlTableImplementation );

			String natHppRamTableInclude = attrHppRamTableInclude;
			editBuff.setOptionalHppRamTableInclude( natHppRamTableInclude );

			String natHppRamTableMembers = attrHppRamTableMembers;
			editBuff.setOptionalHppRamTableMembers( natHppRamTableMembers );

			String natHppRamTableImplementation = attrHppRamTableImplementation;
			editBuff.setOptionalHppRamTableImplementation( natHppRamTableImplementation );

			String natHppSaxLoaderInclude = attrHppSaxLoaderInclude;
			editBuff.setOptionalHppSaxLoaderInclude( natHppSaxLoaderInclude );

			String natHppSaxLoaderStartElement = attrHppSaxLoaderStartElement;
			editBuff.setOptionalHppSaxLoaderStartElement( natHppSaxLoaderStartElement );

			String natHppSaxLoaderEndElement = attrHppSaxLoaderEndElement;
			editBuff.setOptionalHppSaxLoaderEndElement( natHppSaxLoaderEndElement );

			String natHppXMsgTableInclude = attrHppXMsgTableInclude;
			editBuff.setOptionalHppXMsgTableInclude( natHppXMsgTableInclude );

			String natHppXMsgTableFormatters = attrHppXMsgTableFormatters;
			editBuff.setOptionalHppXMsgTableFormatters( natHppXMsgTableFormatters );

			String natHppXMsgRqstTableInclude = attrHppXMsgRqstTableInclude;
			editBuff.setOptionalHppXMsgRqstTableInclude( natHppXMsgRqstTableInclude );

			String natHppXMsgRspnTableInclude = attrHppXMsgRspnTableInclude;
			editBuff.setOptionalHppXMsgRspnTableInclude( natHppXMsgRspnTableInclude );

			String natHppXMsgClientTableInclude = attrHppXMsgClientTableInclude;
			editBuff.setOptionalHppXMsgClientTableInclude( natHppXMsgClientTableInclude );

			String natHppXMsgRqstTableBody = attrHppXMsgRqstTableBody;
			editBuff.setOptionalHppXMsgRqstTableBody( natHppXMsgRqstTableBody );

			String natHppXMsgRspnTableBody = attrHppXMsgRspnTableBody;
			editBuff.setOptionalHppXMsgRspnTableBody( natHppXMsgRspnTableBody );

			String natHppXMsgClientTableBody = attrHppXMsgClientTableBody;
			editBuff.setOptionalHppXMsgClientTableBody( natHppXMsgClientTableBody );

			String natCsObjMembers = attrCsObjMembers;
			editBuff.setOptionalCsObjMembers( natCsObjMembers );

			String natCsObjInterface = attrCsObjInterface;
			editBuff.setOptionalCsObjInterface( natCsObjInterface );

			String natCsObjUsing = attrCsObjUsing;
			editBuff.setOptionalCsObjUsing( natCsObjUsing );

			String natCsObjImplementation = attrCsObjImplementation;
			editBuff.setOptionalCsObjImplementation( natCsObjImplementation );

			String natCsEditObjMembers = attrCsEditObjMembers;
			editBuff.setOptionalCsEditObjMembers( natCsEditObjMembers );

			String natCsEditObjInterface = attrCsEditObjInterface;
			editBuff.setOptionalCsEditObjInterface( natCsEditObjInterface );

			String natCsEditObjUsing = attrCsEditObjUsing;
			editBuff.setOptionalCsEditObjUsing( natCsEditObjUsing );

			String natCsEditObjImplementation = attrCsEditObjImplementation;
			editBuff.setOptionalCsEditObjImplementation( natCsEditObjImplementation );

			String natCsTableUsing = attrCsTableUsing;
			editBuff.setOptionalCsTableUsing( natCsTableUsing );

			String natCsTableMembers = attrCsTableMembers;
			editBuff.setOptionalCsTableMembers( natCsTableMembers );

			String natCsTableInterface = attrCsTableInterface;
			editBuff.setOptionalCsTableInterface( natCsTableInterface );

			String natCsTableImplementation = attrCsTableImplementation;
			editBuff.setOptionalCsTableImplementation( natCsTableImplementation );

			String natCsTableObjUsing = attrCsTableObjUsing;
			editBuff.setOptionalCsTableObjUsing( natCsTableObjUsing );

			String natCsTableObjMembers = attrCsTableObjMembers;
			editBuff.setOptionalCsTableObjMembers( natCsTableObjMembers );

			String natCsTableObjInterface = attrCsTableObjInterface;
			editBuff.setOptionalCsTableObjInterface( natCsTableObjInterface );

			String natCsTableObjImplementation = attrCsTableObjImplementation;
			editBuff.setOptionalCsTableObjImplementation( natCsTableObjImplementation );

			String natCsDb2LUWTableUsing = attrCsDb2LUWTableUsing;
			editBuff.setOptionalCsDb2LUWTableUsing( natCsDb2LUWTableUsing );

			String natCsDb2LUWTableMembers = attrCsDb2LUWTableMembers;
			editBuff.setOptionalCsDb2LUWTableMembers( natCsDb2LUWTableMembers );

			String natCsDb2LUWTableImplementation = attrCsDb2LUWTableImplementation;
			editBuff.setOptionalCsDb2LUWTableImplementation( natCsDb2LUWTableImplementation );

			String natCsMSSqlTableUsing = attrCsMSSqlTableUsing;
			editBuff.setOptionalCsMSSqlTableUsing( natCsMSSqlTableUsing );

			String natCsMSSqlTableMembers = attrCsMSSqlTableMembers;
			editBuff.setOptionalCsMSSqlTableMembers( natCsMSSqlTableMembers );

			String natCsMSSqlTableImplementation = attrCsMSSqlTableImplementation;
			editBuff.setOptionalCsMSSqlTableImplementation( natCsMSSqlTableImplementation );

			String natCsMySqlTableUsing = attrCsMySqlTableUsing;
			editBuff.setOptionalCsMySqlTableUsing( natCsMySqlTableUsing );

			String natCsMySqlTableMembers = attrCsMySqlTableMembers;
			editBuff.setOptionalCsMySqlTableMembers( natCsMySqlTableMembers );

			String natCsMySqlTableImplementation = attrCsMySqlTableImplementation;
			editBuff.setOptionalCsMySqlTableImplementation( natCsMySqlTableImplementation );

			String natCsOracleTableUsing = attrCsOracleTableUsing;
			editBuff.setOptionalCsOracleTableUsing( natCsOracleTableUsing );

			String natCsOracleTableMembers = attrCsOracleTableMembers;
			editBuff.setOptionalCsOracleTableMembers( natCsOracleTableMembers );

			String natCsOracleTableImplementation = attrCsOracleTableImplementation;
			editBuff.setOptionalCsOracleTableImplementation( natCsOracleTableImplementation );

			String natCsPgSqlTableUsing = attrCsPgSqlTableUsing;
			editBuff.setOptionalCsPgSqlTableUsing( natCsPgSqlTableUsing );

			String natCsPgSqlTableMembers = attrCsPgSqlTableMembers;
			editBuff.setOptionalCsPgSqlTableMembers( natCsPgSqlTableMembers );

			String natCsPgSqlTableImplementation = attrCsPgSqlTableImplementation;
			editBuff.setOptionalCsPgSqlTableImplementation( natCsPgSqlTableImplementation );

			String natCsRamTableUsing = attrCsRamTableUsing;
			editBuff.setOptionalCsRamTableUsing( natCsRamTableUsing );

			String natCsRamTableMembers = attrCsRamTableMembers;
			editBuff.setOptionalCsRamTableMembers( natCsRamTableMembers );

			String natCsRamTableImplementation = attrCsRamTableImplementation;
			editBuff.setOptionalCsRamTableImplementation( natCsRamTableImplementation );

			String natCsSaxLoaderUsing = attrCsSaxLoaderUsing;
			editBuff.setOptionalCsSaxLoaderUsing( natCsSaxLoaderUsing );

			String natCsSaxLoaderStartElement = attrCsSaxLoaderStartElement;
			editBuff.setOptionalCsSaxLoaderStartElement( natCsSaxLoaderStartElement );

			String natCsSaxLoaderEndElement = attrCsSaxLoaderEndElement;
			editBuff.setOptionalCsSaxLoaderEndElement( natCsSaxLoaderEndElement );

			String natCsXMsgTableUsing = attrCsXMsgTableUsing;
			editBuff.setOptionalCsXMsgTableUsing( natCsXMsgTableUsing );

			String natCsXMsgTableFormatters = attrCsXMsgTableFormatters;
			editBuff.setOptionalCsXMsgTableFormatters( natCsXMsgTableFormatters );

			String natCsXMsgRqstTableUsing = attrCsXMsgRqstTableUsing;
			editBuff.setOptionalCsXMsgRqstTableUsing( natCsXMsgRqstTableUsing );

			String natCsXMsgRspnTableUsing = attrCsXMsgRspnTableUsing;
			editBuff.setOptionalCsXMsgRspnTableUsing( natCsXMsgRspnTableUsing );

			String natCsXMsgClientTableUsing = attrCsXMsgClientTableUsing;
			editBuff.setOptionalCsXMsgClientTableUsing( natCsXMsgClientTableUsing );

			String natCsXMsgRqstTableBody = attrCsXMsgRqstTableBody;
			editBuff.setOptionalCsXMsgRqstTableBody( natCsXMsgRqstTableBody );

			String natCsXMsgRspnTableBody = attrCsXMsgRspnTableBody;
			editBuff.setOptionalCsXMsgRspnTableBody( natCsXMsgRspnTableBody );

			String natCsXMsgClientTableBody = attrCsXMsgClientTableBody;
			editBuff.setOptionalCsXMsgClientTableBody( natCsXMsgClientTableBody );

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
			else if( scopeObj instanceof ICFBamSchemaDefObj ) {
				refSchemaDef = (ICFBamSchemaDefObj) scopeObj;
				editBuff.setRequiredContainerSchemaDef( refSchemaDef );
				refTenant = (ICFBamTenantObj)editBuff.getRequiredOwnerTenant();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFBamSchemaDefObj" );
			}

			// Resolve and apply Owner reference

			if( refTenant == null ) {
				if( scopeObj instanceof ICFBamTenantObj ) {
					refTenant = (ICFBamTenantObj) scopeObj;
					editBuff.setRequiredOwnerTenant( refTenant );
				}
				else {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Owner<Tenant>" );
				}
			}

			// Lookup refDefSchema by qualified name
			if( ( attrDefSchema != null ) && ( attrDefSchema.length() > 0 ) ) {
				refDefSchema = (ICFBamSchemaDefObj)(editBuff.getNamedObject( schemaObj.getSchemaDefTableObj().getObjQualifyingClass(),
					attrDefSchema ) );
				if( refDefSchema == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve DefSchema reference qualified name \"" + attrDefSchema + "\" to table SchemaDef" );
				}
			}
			else {
				refDefSchema = null;
			}
			editBuff.setOptionalLookupDefSchema( refDefSchema );

			// Lookup refLookupIndex by qualified name
			if( ( attrLookupIndex != null ) && ( attrLookupIndex.length() > 0 ) ) {
				refLookupIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrLookupIndex ) );
				if( refLookupIndex == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve LookupIndex reference qualified name \"" + attrLookupIndex + "\" to table Index" );
				}
			}
			else {
				refLookupIndex = null;
			}
			editBuff.setOptionalLookupLookupIndex( refLookupIndex );

			// Lookup refAltIndex by qualified name
			if( ( attrAltIndex != null ) && ( attrAltIndex.length() > 0 ) ) {
				refAltIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrAltIndex ) );
				if( refAltIndex == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve AltIndex reference qualified name \"" + attrAltIndex + "\" to table Index" );
				}
			}
			else {
				refAltIndex = null;
			}
			editBuff.setOptionalLookupAltIndex( refAltIndex );

			// Lookup refQualTable by qualified name
			if( ( attrQualTable != null ) && ( attrQualTable.length() > 0 ) ) {
				refQualTable = (ICFBamTableObj)(editBuff.getNamedObject( schemaObj.getTableTableObj().getObjQualifyingClass(),
					attrQualTable ) );
				if( refQualTable == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve QualTable reference qualified name \"" + attrQualTable + "\" to table Table" );
				}
			}
			else {
				refQualTable = null;
			}
			editBuff.setOptionalLookupQualTable( refQualTable );

			// Lookup refPrimaryIndex by qualified name
			if( ( attrPrimaryIndex != null ) && ( attrPrimaryIndex.length() > 0 ) ) {
				refPrimaryIndex = (ICFBamIndexObj)(editBuff.getNamedObject( schemaObj.getIndexTableObj().getObjQualifyingClass(),
					attrPrimaryIndex ) );
				if( refPrimaryIndex == null ) {
					throw new CFLibNullArgumentException( getClass(),
						S_ProcName,
						0,
						"Resolve PrimaryIndex reference qualified name \"" + attrPrimaryIndex + "\" to table Index" );
				}
			}
			else {
				refPrimaryIndex = null;
			}
			editBuff.setOptionalLookupPrimaryIndex( refPrimaryIndex );

			CFBamSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getTableLoaderBehaviour();
			ICFBamTableEditObj editTable = null;
			ICFBamTableObj origTable = (ICFBamTableObj)schemaObj.getTableTableObj().readTableByUNameIdx( refSchemaDef.getRequiredTenantId(),
			refSchemaDef.getRequiredId(),
			editBuff.getRequiredName() );
			if( origTable == null ) {
				editTable = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editTable = (ICFBamTableEditObj)origTable.beginEdit();
						editTable.setRequiredName( editBuff.getRequiredName() );
						editTable.setOptionalDbName( editBuff.getOptionalDbName() );
						editTable.setOptionalShortName( editBuff.getOptionalShortName() );
						editTable.setOptionalLabel( editBuff.getOptionalLabel() );
						editTable.setOptionalShortDescription( editBuff.getOptionalShortDescription() );
						editTable.setOptionalDescription( editBuff.getOptionalDescription() );
						editTable.setRequiredPageData( editBuff.getRequiredPageData() );
						editTable.setRequiredTableClassCode( editBuff.getRequiredTableClassCode() );
						editTable.setRequiredIsInstantiable( editBuff.getRequiredIsInstantiable() );
						editTable.setRequiredHasHistory( editBuff.getRequiredHasHistory() );
						editTable.setRequiredHasAuditColumns( editBuff.getRequiredHasAuditColumns() );
						editTable.setRequiredLoaderBehaviour( editBuff.getRequiredLoaderBehaviour() );
						editTable.setRequiredSecScope( editBuff.getRequiredSecScope() );
						editTable.setOptionalJObjMembers( editBuff.getOptionalJObjMembers() );
						editTable.setOptionalJObjInterface( editBuff.getOptionalJObjInterface() );
						editTable.setOptionalJObjImport( editBuff.getOptionalJObjImport() );
						editTable.setOptionalJObjImplementation( editBuff.getOptionalJObjImplementation() );
						editTable.setOptionalJEditObjMembers( editBuff.getOptionalJEditObjMembers() );
						editTable.setOptionalJEditObjInterface( editBuff.getOptionalJEditObjInterface() );
						editTable.setOptionalJEditObjImport( editBuff.getOptionalJEditObjImport() );
						editTable.setOptionalJEditObjImplementation( editBuff.getOptionalJEditObjImplementation() );
						editTable.setOptionalJTableImport( editBuff.getOptionalJTableImport() );
						editTable.setOptionalJTableMembers( editBuff.getOptionalJTableMembers() );
						editTable.setOptionalJTableInterface( editBuff.getOptionalJTableInterface() );
						editTable.setOptionalJTableImplementation( editBuff.getOptionalJTableImplementation() );
						editTable.setOptionalJTableObjImport( editBuff.getOptionalJTableObjImport() );
						editTable.setOptionalJTableObjMembers( editBuff.getOptionalJTableObjMembers() );
						editTable.setOptionalJTableObjInterface( editBuff.getOptionalJTableObjInterface() );
						editTable.setOptionalJTableObjImplementation( editBuff.getOptionalJTableObjImplementation() );
						editTable.setOptionalJDb2LUWTableImport( editBuff.getOptionalJDb2LUWTableImport() );
						editTable.setOptionalJDb2LUWTableMembers( editBuff.getOptionalJDb2LUWTableMembers() );
						editTable.setOptionalJDb2LUWTableImplementation( editBuff.getOptionalJDb2LUWTableImplementation() );
						editTable.setOptionalJMSSqlTableImport( editBuff.getOptionalJMSSqlTableImport() );
						editTable.setOptionalJMSSqlTableMembers( editBuff.getOptionalJMSSqlTableMembers() );
						editTable.setOptionalJMSSqlTableImplementation( editBuff.getOptionalJMSSqlTableImplementation() );
						editTable.setOptionalJMySqlTableImport( editBuff.getOptionalJMySqlTableImport() );
						editTable.setOptionalJMySqlTableMembers( editBuff.getOptionalJMySqlTableMembers() );
						editTable.setOptionalJMySqlTableImplementation( editBuff.getOptionalJMySqlTableImplementation() );
						editTable.setOptionalJOracleTableImport( editBuff.getOptionalJOracleTableImport() );
						editTable.setOptionalJOracleTableMembers( editBuff.getOptionalJOracleTableMembers() );
						editTable.setOptionalJOracleTableImplementation( editBuff.getOptionalJOracleTableImplementation() );
						editTable.setOptionalJPgSqlTableImport( editBuff.getOptionalJPgSqlTableImport() );
						editTable.setOptionalJPgSqlTableMembers( editBuff.getOptionalJPgSqlTableMembers() );
						editTable.setOptionalJPgSqlTableImplementation( editBuff.getOptionalJPgSqlTableImplementation() );
						editTable.setOptionalJRamTableImport( editBuff.getOptionalJRamTableImport() );
						editTable.setOptionalJRamTableMembers( editBuff.getOptionalJRamTableMembers() );
						editTable.setOptionalJRamTableImplementation( editBuff.getOptionalJRamTableImplementation() );
						editTable.setOptionalJSaxLoaderImport( editBuff.getOptionalJSaxLoaderImport() );
						editTable.setOptionalJSaxLoaderStartElement( editBuff.getOptionalJSaxLoaderStartElement() );
						editTable.setOptionalJSaxLoaderEndElement( editBuff.getOptionalJSaxLoaderEndElement() );
						editTable.setOptionalJXMsgTableImport( editBuff.getOptionalJXMsgTableImport() );
						editTable.setOptionalJXMsgTableFormatters( editBuff.getOptionalJXMsgTableFormatters() );
						editTable.setOptionalJXMsgRqstTableImport( editBuff.getOptionalJXMsgRqstTableImport() );
						editTable.setOptionalJXMsgRspnTableImport( editBuff.getOptionalJXMsgRspnTableImport() );
						editTable.setOptionalJXMsgClientTableImport( editBuff.getOptionalJXMsgClientTableImport() );
						editTable.setOptionalJXMsgRqstTableBody( editBuff.getOptionalJXMsgRqstTableBody() );
						editTable.setOptionalJXMsgRspnTableBody( editBuff.getOptionalJXMsgRspnTableBody() );
						editTable.setOptionalJXMsgClientTableBody( editBuff.getOptionalJXMsgClientTableBody() );
						editTable.setOptionalCppObjMembers( editBuff.getOptionalCppObjMembers() );
						editTable.setOptionalCppObjInterface( editBuff.getOptionalCppObjInterface() );
						editTable.setOptionalCppObjInclude( editBuff.getOptionalCppObjInclude() );
						editTable.setOptionalCppObjImplementation( editBuff.getOptionalCppObjImplementation() );
						editTable.setOptionalCppEditObjMembers( editBuff.getOptionalCppEditObjMembers() );
						editTable.setOptionalCppEditObjInterface( editBuff.getOptionalCppEditObjInterface() );
						editTable.setOptionalCppEditObjInclude( editBuff.getOptionalCppEditObjInclude() );
						editTable.setOptionalCppEditObjImplementation( editBuff.getOptionalCppEditObjImplementation() );
						editTable.setOptionalCppTableInclude( editBuff.getOptionalCppTableInclude() );
						editTable.setOptionalCppTableMembers( editBuff.getOptionalCppTableMembers() );
						editTable.setOptionalCppTableInterface( editBuff.getOptionalCppTableInterface() );
						editTable.setOptionalCppTableImplementation( editBuff.getOptionalCppTableImplementation() );
						editTable.setOptionalCppTableObjInclude( editBuff.getOptionalCppTableObjInclude() );
						editTable.setOptionalCppTableObjMembers( editBuff.getOptionalCppTableObjMembers() );
						editTable.setOptionalCppTableObjInterface( editBuff.getOptionalCppTableObjInterface() );
						editTable.setOptionalCppTableObjImplementation( editBuff.getOptionalCppTableObjImplementation() );
						editTable.setOptionalCppDb2LUWTableInclude( editBuff.getOptionalCppDb2LUWTableInclude() );
						editTable.setOptionalCppDb2LUWTableMembers( editBuff.getOptionalCppDb2LUWTableMembers() );
						editTable.setOptionalCppDb2LUWTableImplementation( editBuff.getOptionalCppDb2LUWTableImplementation() );
						editTable.setOptionalCppMSSqlTableInclude( editBuff.getOptionalCppMSSqlTableInclude() );
						editTable.setOptionalCppMSSqlTableMembers( editBuff.getOptionalCppMSSqlTableMembers() );
						editTable.setOptionalCppMSSqlTableImplementation( editBuff.getOptionalCppMSSqlTableImplementation() );
						editTable.setOptionalCppMySqlTableInclude( editBuff.getOptionalCppMySqlTableInclude() );
						editTable.setOptionalCppMySqlTableMembers( editBuff.getOptionalCppMySqlTableMembers() );
						editTable.setOptionalCppMySqlTableImplementation( editBuff.getOptionalCppMySqlTableImplementation() );
						editTable.setOptionalCppOracleTableInclude( editBuff.getOptionalCppOracleTableInclude() );
						editTable.setOptionalCppOracleTableMembers( editBuff.getOptionalCppOracleTableMembers() );
						editTable.setOptionalCppOracleTableImplementation( editBuff.getOptionalCppOracleTableImplementation() );
						editTable.setOptionalCppPgSqlTableInclude( editBuff.getOptionalCppPgSqlTableInclude() );
						editTable.setOptionalCppPgSqlTableMembers( editBuff.getOptionalCppPgSqlTableMembers() );
						editTable.setOptionalCppPgSqlTableImplementation( editBuff.getOptionalCppPgSqlTableImplementation() );
						editTable.setOptionalCppRamTableInclude( editBuff.getOptionalCppRamTableInclude() );
						editTable.setOptionalCppRamTableMembers( editBuff.getOptionalCppRamTableMembers() );
						editTable.setOptionalCppRamTableImplementation( editBuff.getOptionalCppRamTableImplementation() );
						editTable.setOptionalCppSaxLoaderInclude( editBuff.getOptionalCppSaxLoaderInclude() );
						editTable.setOptionalCppSaxLoaderStartElement( editBuff.getOptionalCppSaxLoaderStartElement() );
						editTable.setOptionalCppSaxLoaderEndElement( editBuff.getOptionalCppSaxLoaderEndElement() );
						editTable.setOptionalCppXMsgTableInclude( editBuff.getOptionalCppXMsgTableInclude() );
						editTable.setOptionalCppXMsgTableFormatters( editBuff.getOptionalCppXMsgTableFormatters() );
						editTable.setOptionalCppXMsgRqstTableInclude( editBuff.getOptionalCppXMsgRqstTableInclude() );
						editTable.setOptionalCppXMsgRspnTableInclude( editBuff.getOptionalCppXMsgRspnTableInclude() );
						editTable.setOptionalCppXMsgClientTableInclude( editBuff.getOptionalCppXMsgClientTableInclude() );
						editTable.setOptionalCppXMsgRqstTableBody( editBuff.getOptionalCppXMsgRqstTableBody() );
						editTable.setOptionalCppXMsgRspnTableBody( editBuff.getOptionalCppXMsgRspnTableBody() );
						editTable.setOptionalCppXMsgClientTableBody( editBuff.getOptionalCppXMsgClientTableBody() );
						editTable.setOptionalHppObjMembers( editBuff.getOptionalHppObjMembers() );
						editTable.setOptionalHppObjInterface( editBuff.getOptionalHppObjInterface() );
						editTable.setOptionalHppObjInclude( editBuff.getOptionalHppObjInclude() );
						editTable.setOptionalHppObjImplementation( editBuff.getOptionalHppObjImplementation() );
						editTable.setOptionalHppEditObjMembers( editBuff.getOptionalHppEditObjMembers() );
						editTable.setOptionalHppEditObjInterface( editBuff.getOptionalHppEditObjInterface() );
						editTable.setOptionalHppEditObjInclude( editBuff.getOptionalHppEditObjInclude() );
						editTable.setOptionalHppEditObjImplementation( editBuff.getOptionalHppEditObjImplementation() );
						editTable.setOptionalHppTableInclude( editBuff.getOptionalHppTableInclude() );
						editTable.setOptionalHppTableMembers( editBuff.getOptionalHppTableMembers() );
						editTable.setOptionalHppTableInterface( editBuff.getOptionalHppTableInterface() );
						editTable.setOptionalHppTableImplementation( editBuff.getOptionalHppTableImplementation() );
						editTable.setOptionalHppTableObjInclude( editBuff.getOptionalHppTableObjInclude() );
						editTable.setOptionalHppTableObjMembers( editBuff.getOptionalHppTableObjMembers() );
						editTable.setOptionalHppTableObjInterface( editBuff.getOptionalHppTableObjInterface() );
						editTable.setOptionalHppTableObjImplementation( editBuff.getOptionalHppTableObjImplementation() );
						editTable.setOptionalHppDb2LUWTableInclude( editBuff.getOptionalHppDb2LUWTableInclude() );
						editTable.setOptionalHppDb2LUWTableMembers( editBuff.getOptionalHppDb2LUWTableMembers() );
						editTable.setOptionalHppDb2LUWTableImplementation( editBuff.getOptionalHppDb2LUWTableImplementation() );
						editTable.setOptionalHppMSSqlTableInclude( editBuff.getOptionalHppMSSqlTableInclude() );
						editTable.setOptionalHppMSSqlTableMembers( editBuff.getOptionalHppMSSqlTableMembers() );
						editTable.setOptionalHppMSSqlTableImplementation( editBuff.getOptionalHppMSSqlTableImplementation() );
						editTable.setOptionalHppMySqlTableInclude( editBuff.getOptionalHppMySqlTableInclude() );
						editTable.setOptionalHppMySqlTableMembers( editBuff.getOptionalHppMySqlTableMembers() );
						editTable.setOptionalHppMySqlTableImplementation( editBuff.getOptionalHppMySqlTableImplementation() );
						editTable.setOptionalHppOracleTableInclude( editBuff.getOptionalHppOracleTableInclude() );
						editTable.setOptionalHppOracleTableMembers( editBuff.getOptionalHppOracleTableMembers() );
						editTable.setOptionalHppOracleTableImplementation( editBuff.getOptionalHppOracleTableImplementation() );
						editTable.setOptionalHppPgSqlTableInclude( editBuff.getOptionalHppPgSqlTableInclude() );
						editTable.setOptionalHppPgSqlTableMembers( editBuff.getOptionalHppPgSqlTableMembers() );
						editTable.setOptionalHppPgSqlTableImplementation( editBuff.getOptionalHppPgSqlTableImplementation() );
						editTable.setOptionalHppRamTableInclude( editBuff.getOptionalHppRamTableInclude() );
						editTable.setOptionalHppRamTableMembers( editBuff.getOptionalHppRamTableMembers() );
						editTable.setOptionalHppRamTableImplementation( editBuff.getOptionalHppRamTableImplementation() );
						editTable.setOptionalHppSaxLoaderInclude( editBuff.getOptionalHppSaxLoaderInclude() );
						editTable.setOptionalHppSaxLoaderStartElement( editBuff.getOptionalHppSaxLoaderStartElement() );
						editTable.setOptionalHppSaxLoaderEndElement( editBuff.getOptionalHppSaxLoaderEndElement() );
						editTable.setOptionalHppXMsgTableInclude( editBuff.getOptionalHppXMsgTableInclude() );
						editTable.setOptionalHppXMsgTableFormatters( editBuff.getOptionalHppXMsgTableFormatters() );
						editTable.setOptionalHppXMsgRqstTableInclude( editBuff.getOptionalHppXMsgRqstTableInclude() );
						editTable.setOptionalHppXMsgRspnTableInclude( editBuff.getOptionalHppXMsgRspnTableInclude() );
						editTable.setOptionalHppXMsgClientTableInclude( editBuff.getOptionalHppXMsgClientTableInclude() );
						editTable.setOptionalHppXMsgRqstTableBody( editBuff.getOptionalHppXMsgRqstTableBody() );
						editTable.setOptionalHppXMsgRspnTableBody( editBuff.getOptionalHppXMsgRspnTableBody() );
						editTable.setOptionalHppXMsgClientTableBody( editBuff.getOptionalHppXMsgClientTableBody() );
						editTable.setOptionalCsObjMembers( editBuff.getOptionalCsObjMembers() );
						editTable.setOptionalCsObjInterface( editBuff.getOptionalCsObjInterface() );
						editTable.setOptionalCsObjUsing( editBuff.getOptionalCsObjUsing() );
						editTable.setOptionalCsObjImplementation( editBuff.getOptionalCsObjImplementation() );
						editTable.setOptionalCsEditObjMembers( editBuff.getOptionalCsEditObjMembers() );
						editTable.setOptionalCsEditObjInterface( editBuff.getOptionalCsEditObjInterface() );
						editTable.setOptionalCsEditObjUsing( editBuff.getOptionalCsEditObjUsing() );
						editTable.setOptionalCsEditObjImplementation( editBuff.getOptionalCsEditObjImplementation() );
						editTable.setOptionalCsTableUsing( editBuff.getOptionalCsTableUsing() );
						editTable.setOptionalCsTableMembers( editBuff.getOptionalCsTableMembers() );
						editTable.setOptionalCsTableInterface( editBuff.getOptionalCsTableInterface() );
						editTable.setOptionalCsTableImplementation( editBuff.getOptionalCsTableImplementation() );
						editTable.setOptionalCsTableObjUsing( editBuff.getOptionalCsTableObjUsing() );
						editTable.setOptionalCsTableObjMembers( editBuff.getOptionalCsTableObjMembers() );
						editTable.setOptionalCsTableObjInterface( editBuff.getOptionalCsTableObjInterface() );
						editTable.setOptionalCsTableObjImplementation( editBuff.getOptionalCsTableObjImplementation() );
						editTable.setOptionalCsDb2LUWTableUsing( editBuff.getOptionalCsDb2LUWTableUsing() );
						editTable.setOptionalCsDb2LUWTableMembers( editBuff.getOptionalCsDb2LUWTableMembers() );
						editTable.setOptionalCsDb2LUWTableImplementation( editBuff.getOptionalCsDb2LUWTableImplementation() );
						editTable.setOptionalCsMSSqlTableUsing( editBuff.getOptionalCsMSSqlTableUsing() );
						editTable.setOptionalCsMSSqlTableMembers( editBuff.getOptionalCsMSSqlTableMembers() );
						editTable.setOptionalCsMSSqlTableImplementation( editBuff.getOptionalCsMSSqlTableImplementation() );
						editTable.setOptionalCsMySqlTableUsing( editBuff.getOptionalCsMySqlTableUsing() );
						editTable.setOptionalCsMySqlTableMembers( editBuff.getOptionalCsMySqlTableMembers() );
						editTable.setOptionalCsMySqlTableImplementation( editBuff.getOptionalCsMySqlTableImplementation() );
						editTable.setOptionalCsOracleTableUsing( editBuff.getOptionalCsOracleTableUsing() );
						editTable.setOptionalCsOracleTableMembers( editBuff.getOptionalCsOracleTableMembers() );
						editTable.setOptionalCsOracleTableImplementation( editBuff.getOptionalCsOracleTableImplementation() );
						editTable.setOptionalCsPgSqlTableUsing( editBuff.getOptionalCsPgSqlTableUsing() );
						editTable.setOptionalCsPgSqlTableMembers( editBuff.getOptionalCsPgSqlTableMembers() );
						editTable.setOptionalCsPgSqlTableImplementation( editBuff.getOptionalCsPgSqlTableImplementation() );
						editTable.setOptionalCsRamTableUsing( editBuff.getOptionalCsRamTableUsing() );
						editTable.setOptionalCsRamTableMembers( editBuff.getOptionalCsRamTableMembers() );
						editTable.setOptionalCsRamTableImplementation( editBuff.getOptionalCsRamTableImplementation() );
						editTable.setOptionalCsSaxLoaderUsing( editBuff.getOptionalCsSaxLoaderUsing() );
						editTable.setOptionalCsSaxLoaderStartElement( editBuff.getOptionalCsSaxLoaderStartElement() );
						editTable.setOptionalCsSaxLoaderEndElement( editBuff.getOptionalCsSaxLoaderEndElement() );
						editTable.setOptionalCsXMsgTableUsing( editBuff.getOptionalCsXMsgTableUsing() );
						editTable.setOptionalCsXMsgTableFormatters( editBuff.getOptionalCsXMsgTableFormatters() );
						editTable.setOptionalCsXMsgRqstTableUsing( editBuff.getOptionalCsXMsgRqstTableUsing() );
						editTable.setOptionalCsXMsgRspnTableUsing( editBuff.getOptionalCsXMsgRspnTableUsing() );
						editTable.setOptionalCsXMsgClientTableUsing( editBuff.getOptionalCsXMsgClientTableUsing() );
						editTable.setOptionalCsXMsgRqstTableBody( editBuff.getOptionalCsXMsgRqstTableBody() );
						editTable.setOptionalCsXMsgRspnTableBody( editBuff.getOptionalCsXMsgRspnTableBody() );
						editTable.setOptionalCsXMsgClientTableBody( editBuff.getOptionalCsXMsgClientTableBody() );
						editTable.setOptionalLookupDefSchema( editBuff.getOptionalLookupDefSchema() );
						editTable.setOptionalLookupLookupIndex( editBuff.getOptionalLookupLookupIndex() );
						editTable.setOptionalLookupAltIndex( editBuff.getOptionalLookupAltIndex() );
						editTable.setOptionalLookupQualTable( editBuff.getOptionalLookupQualTable() );
						editTable.setOptionalLookupPrimaryIndex( editBuff.getOptionalLookupPrimaryIndex() );
						break;
					case Replace:
						editTable = (ICFBamTableEditObj)origTable.beginEdit();
						editTable.deleteInstance();
						editTable = null;
						origTable = null;
						editTable = editBuff;
						break;
				}
			}

			if( editTable != null ) {
				if( origTable != null ) {
					editTable.update();
				}
				else {
					origTable = (ICFBamTableObj)editTable.create();
				}
				editTable = null;
			}

			curContext.putNamedValue( "Object", origTable );
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
