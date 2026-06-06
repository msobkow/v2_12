// Description: Java 11 base object instance implementation for CFBam Table.

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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public class CFBamTableObj
	extends CFBamScopeObj
	implements ICFBamTableObj
{
	public final static String CLASS_CODE = "TBLD";
	protected ICFBamSchemaDefObj requiredContainerSchemaDef;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamIndexObj optionalLookupLookupIndex;
	protected ICFBamIndexObj optionalLookupAltIndex;
	protected ICFBamTableObj optionalLookupQualTable;
	protected ICFBamIndexObj optionalLookupPrimaryIndex;

	public CFBamTableObj() {
		super();
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	public CFBamTableObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Table" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getRelationTableObj().readRelationByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getIndexTableObj().readIndexByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getValueTableObj().readValueByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getChainTableObj().readChainByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else if( container instanceof ICFBamSchemaDefObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public ICFBamScopeObj realise() {
		ICFBamTableObj retobj = ((ICFBamSchemaObj)schema).getTableTableObj().realiseTable(
			(ICFBamTableObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getTableTableObj().forgetTable( (ICFBamTableObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamTableObj retobj = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamTableObj retobj = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamTableTableObj getTableTable() {
		return( ((ICFBamSchemaObj)schema).getTableTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryTable().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableTable().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamTableBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamTableBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	public CFBamTableBuff getTableBuff() {
		return( (CFBamTableBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamTableObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamTableObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getTableTableObj().lockTable( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getTableTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamTableEditObj getEditAsTable() {
		return( (ICFBamTableEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredSchemaDefId() {
		return( getTableBuff().getRequiredSchemaDefId() );
	}

	public Long getOptionalDefSchemaTenantId() {
		return( getTableBuff().getOptionalDefSchemaTenantId() );
	}

	public Long getOptionalDefSchemaId() {
		return( getTableBuff().getOptionalDefSchemaId() );
	}

	public String getRequiredName() {
		return( getTableBuff().getRequiredName() );
	}

	public String getOptionalDbName() {
		return( getTableBuff().getOptionalDbName() );
	}

	public String getOptionalShortName() {
		return( getTableBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getTableBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getTableBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getTableBuff().getOptionalDescription() );
	}

	public boolean getRequiredPageData() {
		return( getTableBuff().getRequiredPageData() );
	}

	public Long getOptionalPrimaryIndexTenantId() {
		return( getTableBuff().getOptionalPrimaryIndexTenantId() );
	}

	public Long getOptionalPrimaryIndexId() {
		return( getTableBuff().getOptionalPrimaryIndexId() );
	}

	public String getRequiredTableClassCode() {
		return( getTableBuff().getRequiredTableClassCode() );
	}

	public Long getOptionalLookupIndexTenantId() {
		return( getTableBuff().getOptionalLookupIndexTenantId() );
	}

	public Long getOptionalLookupIndexId() {
		return( getTableBuff().getOptionalLookupIndexId() );
	}

	public Long getOptionalAltIndexTenantId() {
		return( getTableBuff().getOptionalAltIndexTenantId() );
	}

	public Long getOptionalAltIndexId() {
		return( getTableBuff().getOptionalAltIndexId() );
	}

	public Long getOptionalQualifyingTenantId() {
		return( getTableBuff().getOptionalQualifyingTenantId() );
	}

	public Long getOptionalQualifyingTableId() {
		return( getTableBuff().getOptionalQualifyingTableId() );
	}

	public boolean getRequiredIsInstantiable() {
		return( getTableBuff().getRequiredIsInstantiable() );
	}

	public boolean getRequiredHasHistory() {
		return( getTableBuff().getRequiredHasHistory() );
	}

	public boolean getRequiredHasAuditColumns() {
		return( getTableBuff().getRequiredHasAuditColumns() );
	}

	public ICFBamSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour() {
		return( getTableBuff().getRequiredLoaderBehaviour() );
	}

	public ICFBamSchema.SecScopeEnum getRequiredSecScope() {
		return( getTableBuff().getRequiredSecScope() );
	}

	public String getOptionalJObjMembers() {
		return( getTableBuff().getOptionalJObjMembers() );
	}

	public String getOptionalJObjInterface() {
		return( getTableBuff().getOptionalJObjInterface() );
	}

	public String getOptionalJObjImport() {
		return( getTableBuff().getOptionalJObjImport() );
	}

	public String getOptionalJObjImplementation() {
		return( getTableBuff().getOptionalJObjImplementation() );
	}

	public String getOptionalJEditObjMembers() {
		return( getTableBuff().getOptionalJEditObjMembers() );
	}

	public String getOptionalJEditObjInterface() {
		return( getTableBuff().getOptionalJEditObjInterface() );
	}

	public String getOptionalJEditObjImport() {
		return( getTableBuff().getOptionalJEditObjImport() );
	}

	public String getOptionalJEditObjImplementation() {
		return( getTableBuff().getOptionalJEditObjImplementation() );
	}

	public String getOptionalJTableImport() {
		return( getTableBuff().getOptionalJTableImport() );
	}

	public String getOptionalJTableMembers() {
		return( getTableBuff().getOptionalJTableMembers() );
	}

	public String getOptionalJTableInterface() {
		return( getTableBuff().getOptionalJTableInterface() );
	}

	public String getOptionalJTableImplementation() {
		return( getTableBuff().getOptionalJTableImplementation() );
	}

	public String getOptionalJTableObjImport() {
		return( getTableBuff().getOptionalJTableObjImport() );
	}

	public String getOptionalJTableObjMembers() {
		return( getTableBuff().getOptionalJTableObjMembers() );
	}

	public String getOptionalJTableObjInterface() {
		return( getTableBuff().getOptionalJTableObjInterface() );
	}

	public String getOptionalJTableObjImplementation() {
		return( getTableBuff().getOptionalJTableObjImplementation() );
	}

	public String getOptionalJDb2LUWTableImport() {
		return( getTableBuff().getOptionalJDb2LUWTableImport() );
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( getTableBuff().getOptionalJDb2LUWTableMembers() );
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalJDb2LUWTableImplementation() );
	}

	public String getOptionalJMSSqlTableImport() {
		return( getTableBuff().getOptionalJMSSqlTableImport() );
	}

	public String getOptionalJMSSqlTableMembers() {
		return( getTableBuff().getOptionalJMSSqlTableMembers() );
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( getTableBuff().getOptionalJMSSqlTableImplementation() );
	}

	public String getOptionalJMySqlTableImport() {
		return( getTableBuff().getOptionalJMySqlTableImport() );
	}

	public String getOptionalJMySqlTableMembers() {
		return( getTableBuff().getOptionalJMySqlTableMembers() );
	}

	public String getOptionalJMySqlTableImplementation() {
		return( getTableBuff().getOptionalJMySqlTableImplementation() );
	}

	public String getOptionalJOracleTableImport() {
		return( getTableBuff().getOptionalJOracleTableImport() );
	}

	public String getOptionalJOracleTableMembers() {
		return( getTableBuff().getOptionalJOracleTableMembers() );
	}

	public String getOptionalJOracleTableImplementation() {
		return( getTableBuff().getOptionalJOracleTableImplementation() );
	}

	public String getOptionalJPgSqlTableImport() {
		return( getTableBuff().getOptionalJPgSqlTableImport() );
	}

	public String getOptionalJPgSqlTableMembers() {
		return( getTableBuff().getOptionalJPgSqlTableMembers() );
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( getTableBuff().getOptionalJPgSqlTableImplementation() );
	}

	public String getOptionalJRamTableImport() {
		return( getTableBuff().getOptionalJRamTableImport() );
	}

	public String getOptionalJRamTableMembers() {
		return( getTableBuff().getOptionalJRamTableMembers() );
	}

	public String getOptionalJRamTableImplementation() {
		return( getTableBuff().getOptionalJRamTableImplementation() );
	}

	public String getOptionalJSaxLoaderImport() {
		return( getTableBuff().getOptionalJSaxLoaderImport() );
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( getTableBuff().getOptionalJSaxLoaderStartElement() );
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( getTableBuff().getOptionalJSaxLoaderEndElement() );
	}

	public String getOptionalJXMsgTableImport() {
		return( getTableBuff().getOptionalJXMsgTableImport() );
	}

	public String getOptionalJXMsgTableFormatters() {
		return( getTableBuff().getOptionalJXMsgTableFormatters() );
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( getTableBuff().getOptionalJXMsgRqstTableImport() );
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( getTableBuff().getOptionalJXMsgRspnTableImport() );
	}

	public String getOptionalJXMsgClientTableImport() {
		return( getTableBuff().getOptionalJXMsgClientTableImport() );
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( getTableBuff().getOptionalJXMsgRqstTableBody() );
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( getTableBuff().getOptionalJXMsgRspnTableBody() );
	}

	public String getOptionalJXMsgClientTableBody() {
		return( getTableBuff().getOptionalJXMsgClientTableBody() );
	}

	public String getOptionalCppObjMembers() {
		return( getTableBuff().getOptionalCppObjMembers() );
	}

	public String getOptionalCppObjInterface() {
		return( getTableBuff().getOptionalCppObjInterface() );
	}

	public String getOptionalCppObjInclude() {
		return( getTableBuff().getOptionalCppObjInclude() );
	}

	public String getOptionalCppObjImplementation() {
		return( getTableBuff().getOptionalCppObjImplementation() );
	}

	public String getOptionalCppEditObjMembers() {
		return( getTableBuff().getOptionalCppEditObjMembers() );
	}

	public String getOptionalCppEditObjInterface() {
		return( getTableBuff().getOptionalCppEditObjInterface() );
	}

	public String getOptionalCppEditObjInclude() {
		return( getTableBuff().getOptionalCppEditObjInclude() );
	}

	public String getOptionalCppEditObjImplementation() {
		return( getTableBuff().getOptionalCppEditObjImplementation() );
	}

	public String getOptionalCppTableInclude() {
		return( getTableBuff().getOptionalCppTableInclude() );
	}

	public String getOptionalCppTableMembers() {
		return( getTableBuff().getOptionalCppTableMembers() );
	}

	public String getOptionalCppTableInterface() {
		return( getTableBuff().getOptionalCppTableInterface() );
	}

	public String getOptionalCppTableImplementation() {
		return( getTableBuff().getOptionalCppTableImplementation() );
	}

	public String getOptionalCppTableObjInclude() {
		return( getTableBuff().getOptionalCppTableObjInclude() );
	}

	public String getOptionalCppTableObjMembers() {
		return( getTableBuff().getOptionalCppTableObjMembers() );
	}

	public String getOptionalCppTableObjInterface() {
		return( getTableBuff().getOptionalCppTableObjInterface() );
	}

	public String getOptionalCppTableObjImplementation() {
		return( getTableBuff().getOptionalCppTableObjImplementation() );
	}

	public String getOptionalCppDb2LUWTableInclude() {
		return( getTableBuff().getOptionalCppDb2LUWTableInclude() );
	}

	public String getOptionalCppDb2LUWTableMembers() {
		return( getTableBuff().getOptionalCppDb2LUWTableMembers() );
	}

	public String getOptionalCppDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalCppDb2LUWTableImplementation() );
	}

	public String getOptionalCppMSSqlTableInclude() {
		return( getTableBuff().getOptionalCppMSSqlTableInclude() );
	}

	public String getOptionalCppMSSqlTableMembers() {
		return( getTableBuff().getOptionalCppMSSqlTableMembers() );
	}

	public String getOptionalCppMSSqlTableImplementation() {
		return( getTableBuff().getOptionalCppMSSqlTableImplementation() );
	}

	public String getOptionalCppMySqlTableInclude() {
		return( getTableBuff().getOptionalCppMySqlTableInclude() );
	}

	public String getOptionalCppMySqlTableMembers() {
		return( getTableBuff().getOptionalCppMySqlTableMembers() );
	}

	public String getOptionalCppMySqlTableImplementation() {
		return( getTableBuff().getOptionalCppMySqlTableImplementation() );
	}

	public String getOptionalCppOracleTableInclude() {
		return( getTableBuff().getOptionalCppOracleTableInclude() );
	}

	public String getOptionalCppOracleTableMembers() {
		return( getTableBuff().getOptionalCppOracleTableMembers() );
	}

	public String getOptionalCppOracleTableImplementation() {
		return( getTableBuff().getOptionalCppOracleTableImplementation() );
	}

	public String getOptionalCppPgSqlTableInclude() {
		return( getTableBuff().getOptionalCppPgSqlTableInclude() );
	}

	public String getOptionalCppPgSqlTableMembers() {
		return( getTableBuff().getOptionalCppPgSqlTableMembers() );
	}

	public String getOptionalCppPgSqlTableImplementation() {
		return( getTableBuff().getOptionalCppPgSqlTableImplementation() );
	}

	public String getOptionalCppRamTableInclude() {
		return( getTableBuff().getOptionalCppRamTableInclude() );
	}

	public String getOptionalCppRamTableMembers() {
		return( getTableBuff().getOptionalCppRamTableMembers() );
	}

	public String getOptionalCppRamTableImplementation() {
		return( getTableBuff().getOptionalCppRamTableImplementation() );
	}

	public String getOptionalCppSaxLoaderInclude() {
		return( getTableBuff().getOptionalCppSaxLoaderInclude() );
	}

	public String getOptionalCppSaxLoaderStartElement() {
		return( getTableBuff().getOptionalCppSaxLoaderStartElement() );
	}

	public String getOptionalCppSaxLoaderEndElement() {
		return( getTableBuff().getOptionalCppSaxLoaderEndElement() );
	}

	public String getOptionalCppXMsgTableInclude() {
		return( getTableBuff().getOptionalCppXMsgTableInclude() );
	}

	public String getOptionalCppXMsgTableFormatters() {
		return( getTableBuff().getOptionalCppXMsgTableFormatters() );
	}

	public String getOptionalCppXMsgRqstTableInclude() {
		return( getTableBuff().getOptionalCppXMsgRqstTableInclude() );
	}

	public String getOptionalCppXMsgRspnTableInclude() {
		return( getTableBuff().getOptionalCppXMsgRspnTableInclude() );
	}

	public String getOptionalCppXMsgClientTableInclude() {
		return( getTableBuff().getOptionalCppXMsgClientTableInclude() );
	}

	public String getOptionalCppXMsgRqstTableBody() {
		return( getTableBuff().getOptionalCppXMsgRqstTableBody() );
	}

	public String getOptionalCppXMsgRspnTableBody() {
		return( getTableBuff().getOptionalCppXMsgRspnTableBody() );
	}

	public String getOptionalCppXMsgClientTableBody() {
		return( getTableBuff().getOptionalCppXMsgClientTableBody() );
	}

	public String getOptionalHppObjMembers() {
		return( getTableBuff().getOptionalHppObjMembers() );
	}

	public String getOptionalHppObjInterface() {
		return( getTableBuff().getOptionalHppObjInterface() );
	}

	public String getOptionalHppObjInclude() {
		return( getTableBuff().getOptionalHppObjInclude() );
	}

	public String getOptionalHppObjImplementation() {
		return( getTableBuff().getOptionalHppObjImplementation() );
	}

	public String getOptionalHppEditObjMembers() {
		return( getTableBuff().getOptionalHppEditObjMembers() );
	}

	public String getOptionalHppEditObjInterface() {
		return( getTableBuff().getOptionalHppEditObjInterface() );
	}

	public String getOptionalHppEditObjInclude() {
		return( getTableBuff().getOptionalHppEditObjInclude() );
	}

	public String getOptionalHppEditObjImplementation() {
		return( getTableBuff().getOptionalHppEditObjImplementation() );
	}

	public String getOptionalHppTableInclude() {
		return( getTableBuff().getOptionalHppTableInclude() );
	}

	public String getOptionalHppTableMembers() {
		return( getTableBuff().getOptionalHppTableMembers() );
	}

	public String getOptionalHppTableInterface() {
		return( getTableBuff().getOptionalHppTableInterface() );
	}

	public String getOptionalHppTableImplementation() {
		return( getTableBuff().getOptionalHppTableImplementation() );
	}

	public String getOptionalHppTableObjInclude() {
		return( getTableBuff().getOptionalHppTableObjInclude() );
	}

	public String getOptionalHppTableObjMembers() {
		return( getTableBuff().getOptionalHppTableObjMembers() );
	}

	public String getOptionalHppTableObjInterface() {
		return( getTableBuff().getOptionalHppTableObjInterface() );
	}

	public String getOptionalHppTableObjImplementation() {
		return( getTableBuff().getOptionalHppTableObjImplementation() );
	}

	public String getOptionalHppDb2LUWTableInclude() {
		return( getTableBuff().getOptionalHppDb2LUWTableInclude() );
	}

	public String getOptionalHppDb2LUWTableMembers() {
		return( getTableBuff().getOptionalHppDb2LUWTableMembers() );
	}

	public String getOptionalHppDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalHppDb2LUWTableImplementation() );
	}

	public String getOptionalHppMSSqlTableInclude() {
		return( getTableBuff().getOptionalHppMSSqlTableInclude() );
	}

	public String getOptionalHppMSSqlTableMembers() {
		return( getTableBuff().getOptionalHppMSSqlTableMembers() );
	}

	public String getOptionalHppMSSqlTableImplementation() {
		return( getTableBuff().getOptionalHppMSSqlTableImplementation() );
	}

	public String getOptionalHppMySqlTableInclude() {
		return( getTableBuff().getOptionalHppMySqlTableInclude() );
	}

	public String getOptionalHppMySqlTableMembers() {
		return( getTableBuff().getOptionalHppMySqlTableMembers() );
	}

	public String getOptionalHppMySqlTableImplementation() {
		return( getTableBuff().getOptionalHppMySqlTableImplementation() );
	}

	public String getOptionalHppOracleTableInclude() {
		return( getTableBuff().getOptionalHppOracleTableInclude() );
	}

	public String getOptionalHppOracleTableMembers() {
		return( getTableBuff().getOptionalHppOracleTableMembers() );
	}

	public String getOptionalHppOracleTableImplementation() {
		return( getTableBuff().getOptionalHppOracleTableImplementation() );
	}

	public String getOptionalHppPgSqlTableInclude() {
		return( getTableBuff().getOptionalHppPgSqlTableInclude() );
	}

	public String getOptionalHppPgSqlTableMembers() {
		return( getTableBuff().getOptionalHppPgSqlTableMembers() );
	}

	public String getOptionalHppPgSqlTableImplementation() {
		return( getTableBuff().getOptionalHppPgSqlTableImplementation() );
	}

	public String getOptionalHppRamTableInclude() {
		return( getTableBuff().getOptionalHppRamTableInclude() );
	}

	public String getOptionalHppRamTableMembers() {
		return( getTableBuff().getOptionalHppRamTableMembers() );
	}

	public String getOptionalHppRamTableImplementation() {
		return( getTableBuff().getOptionalHppRamTableImplementation() );
	}

	public String getOptionalHppSaxLoaderInclude() {
		return( getTableBuff().getOptionalHppSaxLoaderInclude() );
	}

	public String getOptionalHppSaxLoaderStartElement() {
		return( getTableBuff().getOptionalHppSaxLoaderStartElement() );
	}

	public String getOptionalHppSaxLoaderEndElement() {
		return( getTableBuff().getOptionalHppSaxLoaderEndElement() );
	}

	public String getOptionalHppXMsgTableInclude() {
		return( getTableBuff().getOptionalHppXMsgTableInclude() );
	}

	public String getOptionalHppXMsgTableFormatters() {
		return( getTableBuff().getOptionalHppXMsgTableFormatters() );
	}

	public String getOptionalHppXMsgRqstTableInclude() {
		return( getTableBuff().getOptionalHppXMsgRqstTableInclude() );
	}

	public String getOptionalHppXMsgRspnTableInclude() {
		return( getTableBuff().getOptionalHppXMsgRspnTableInclude() );
	}

	public String getOptionalHppXMsgClientTableInclude() {
		return( getTableBuff().getOptionalHppXMsgClientTableInclude() );
	}

	public String getOptionalHppXMsgRqstTableBody() {
		return( getTableBuff().getOptionalHppXMsgRqstTableBody() );
	}

	public String getOptionalHppXMsgRspnTableBody() {
		return( getTableBuff().getOptionalHppXMsgRspnTableBody() );
	}

	public String getOptionalHppXMsgClientTableBody() {
		return( getTableBuff().getOptionalHppXMsgClientTableBody() );
	}

	public String getOptionalCsObjMembers() {
		return( getTableBuff().getOptionalCsObjMembers() );
	}

	public String getOptionalCsObjInterface() {
		return( getTableBuff().getOptionalCsObjInterface() );
	}

	public String getOptionalCsObjUsing() {
		return( getTableBuff().getOptionalCsObjUsing() );
	}

	public String getOptionalCsObjImplementation() {
		return( getTableBuff().getOptionalCsObjImplementation() );
	}

	public String getOptionalCsEditObjMembers() {
		return( getTableBuff().getOptionalCsEditObjMembers() );
	}

	public String getOptionalCsEditObjInterface() {
		return( getTableBuff().getOptionalCsEditObjInterface() );
	}

	public String getOptionalCsEditObjUsing() {
		return( getTableBuff().getOptionalCsEditObjUsing() );
	}

	public String getOptionalCsEditObjImplementation() {
		return( getTableBuff().getOptionalCsEditObjImplementation() );
	}

	public String getOptionalCsTableUsing() {
		return( getTableBuff().getOptionalCsTableUsing() );
	}

	public String getOptionalCsTableMembers() {
		return( getTableBuff().getOptionalCsTableMembers() );
	}

	public String getOptionalCsTableInterface() {
		return( getTableBuff().getOptionalCsTableInterface() );
	}

	public String getOptionalCsTableImplementation() {
		return( getTableBuff().getOptionalCsTableImplementation() );
	}

	public String getOptionalCsTableObjUsing() {
		return( getTableBuff().getOptionalCsTableObjUsing() );
	}

	public String getOptionalCsTableObjMembers() {
		return( getTableBuff().getOptionalCsTableObjMembers() );
	}

	public String getOptionalCsTableObjInterface() {
		return( getTableBuff().getOptionalCsTableObjInterface() );
	}

	public String getOptionalCsTableObjImplementation() {
		return( getTableBuff().getOptionalCsTableObjImplementation() );
	}

	public String getOptionalCsDb2LUWTableUsing() {
		return( getTableBuff().getOptionalCsDb2LUWTableUsing() );
	}

	public String getOptionalCsDb2LUWTableMembers() {
		return( getTableBuff().getOptionalCsDb2LUWTableMembers() );
	}

	public String getOptionalCsDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalCsDb2LUWTableImplementation() );
	}

	public String getOptionalCsMSSqlTableUsing() {
		return( getTableBuff().getOptionalCsMSSqlTableUsing() );
	}

	public String getOptionalCsMSSqlTableMembers() {
		return( getTableBuff().getOptionalCsMSSqlTableMembers() );
	}

	public String getOptionalCsMSSqlTableImplementation() {
		return( getTableBuff().getOptionalCsMSSqlTableImplementation() );
	}

	public String getOptionalCsMySqlTableUsing() {
		return( getTableBuff().getOptionalCsMySqlTableUsing() );
	}

	public String getOptionalCsMySqlTableMembers() {
		return( getTableBuff().getOptionalCsMySqlTableMembers() );
	}

	public String getOptionalCsMySqlTableImplementation() {
		return( getTableBuff().getOptionalCsMySqlTableImplementation() );
	}

	public String getOptionalCsOracleTableUsing() {
		return( getTableBuff().getOptionalCsOracleTableUsing() );
	}

	public String getOptionalCsOracleTableMembers() {
		return( getTableBuff().getOptionalCsOracleTableMembers() );
	}

	public String getOptionalCsOracleTableImplementation() {
		return( getTableBuff().getOptionalCsOracleTableImplementation() );
	}

	public String getOptionalCsPgSqlTableUsing() {
		return( getTableBuff().getOptionalCsPgSqlTableUsing() );
	}

	public String getOptionalCsPgSqlTableMembers() {
		return( getTableBuff().getOptionalCsPgSqlTableMembers() );
	}

	public String getOptionalCsPgSqlTableImplementation() {
		return( getTableBuff().getOptionalCsPgSqlTableImplementation() );
	}

	public String getOptionalCsRamTableUsing() {
		return( getTableBuff().getOptionalCsRamTableUsing() );
	}

	public String getOptionalCsRamTableMembers() {
		return( getTableBuff().getOptionalCsRamTableMembers() );
	}

	public String getOptionalCsRamTableImplementation() {
		return( getTableBuff().getOptionalCsRamTableImplementation() );
	}

	public String getOptionalCsSaxLoaderUsing() {
		return( getTableBuff().getOptionalCsSaxLoaderUsing() );
	}

	public String getOptionalCsSaxLoaderStartElement() {
		return( getTableBuff().getOptionalCsSaxLoaderStartElement() );
	}

	public String getOptionalCsSaxLoaderEndElement() {
		return( getTableBuff().getOptionalCsSaxLoaderEndElement() );
	}

	public String getOptionalCsXMsgTableUsing() {
		return( getTableBuff().getOptionalCsXMsgTableUsing() );
	}

	public String getOptionalCsXMsgTableFormatters() {
		return( getTableBuff().getOptionalCsXMsgTableFormatters() );
	}

	public String getOptionalCsXMsgRqstTableUsing() {
		return( getTableBuff().getOptionalCsXMsgRqstTableUsing() );
	}

	public String getOptionalCsXMsgRspnTableUsing() {
		return( getTableBuff().getOptionalCsXMsgRspnTableUsing() );
	}

	public String getOptionalCsXMsgClientTableUsing() {
		return( getTableBuff().getOptionalCsXMsgClientTableUsing() );
	}

	public String getOptionalCsXMsgRqstTableBody() {
		return( getTableBuff().getOptionalCsXMsgRqstTableBody() );
	}

	public String getOptionalCsXMsgRspnTableBody() {
		return( getTableBuff().getOptionalCsXMsgRspnTableBody() );
	}

	public String getOptionalCsXMsgClientTableBody() {
		return( getTableBuff().getOptionalCsXMsgClientTableBody() );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( ( requiredContainerSchemaDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchemaDef = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getTableBuff().getRequiredSchemaDefId(), forceRead );
			}
		}
		return( requiredContainerSchemaDef );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getTableBuff().getOptionalDefSchemaTenantId(),
					getTableBuff().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation() {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByRelTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByRelTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex() {
		return( getOptionalLookupLookupIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead ) {
		if( ( optionalLookupLookupIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalLookupIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalLookupIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupLookupIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalLookupIndexTenantId(),
					getTableBuff().getOptionalLookupIndexId(), forceRead );
			}
		}
		return( optionalLookupLookupIndex );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex() {
		return( getOptionalLookupAltIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead ) {
		if( ( optionalLookupAltIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalAltIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalAltIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupAltIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalAltIndexTenantId(),
					getTableBuff().getOptionalAltIndexId(), forceRead );
			}
		}
		return( optionalLookupAltIndex );
	}

	public ICFBamTableObj getOptionalLookupQualTable() {
		return( getOptionalLookupQualTable( false ) );
	}

	public ICFBamTableObj getOptionalLookupQualTable( boolean forceRead ) {
		if( ( optionalLookupQualTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalQualifyingTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalQualifyingTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupQualTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getTableBuff().getOptionalQualifyingTenantId(),
					getTableBuff().getOptionalQualifyingTableId(), forceRead );
			}
		}
		return( optionalLookupQualTable );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex() {
		List<ICFBamIndexObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdxTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead ) {
		List<ICFBamIndexObj> retval;
		retval = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdxTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex() {
		return( getOptionalLookupPrimaryIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead ) {
		if( ( optionalLookupPrimaryIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalPrimaryIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalPrimaryIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrimaryIndex = ((ICFBamSchemaObj)schema).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalPrimaryIndexTenantId(),
					getTableBuff().getOptionalPrimaryIndexId(), forceRead );
			}
		}
		return( optionalLookupPrimaryIndex );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns() {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations() {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)schema).getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains() {
		List<ICFBamChainObj> retval;
		retval = ((ICFBamSchemaObj)schema).getChainTableObj().readChainByChainTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead ) {
		List<ICFBamChainObj> retval;
		retval = ((ICFBamSchemaObj)schema).getChainTableObj().readChainByChainTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep() {
		List<ICFBamDelTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep() {
		List<ICFBamClearTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearTopDepObj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen() {
		List<ICFBamId16GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead ) {
		List<ICFBamId16GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen() {
		List<ICFBamId32GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead ) {
		List<ICFBamId32GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen() {
		List<ICFBamId64GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead ) {
		List<ICFBamId64GenObj> retval;
		retval = ((ICFBamSchemaObj)schema).getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods() {
		List<ICFBamServerMethodObj> retval;
		retval = ((ICFBamSchemaObj)schema).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead ) {
		List<ICFBamServerMethodObj> retval;
		retval = ((ICFBamSchemaObj)schema).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOnlyOwnerRelations() {
		ICFBamTableObj tableDef;
		ICFBamRelationObj relationDef = null;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Owner ) {
				list.add(relationDef);
			}
		}

		ICFBamRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Owner ) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Container ) {
				list.add(relationDef);
			}
		}

		superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Container ) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		return( list );
	}

	public List<ICFBamRelationObj> getContainerOwnerRelations() {
		ICFBamTableObj tableDef;
		ICFBamRelationObj relationDef = null;
		ICFBamSchema.RelationTypeEnum relType;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( ( relType == ICFBamSchema.RelationTypeEnum.Owner )
			 || ( relType == ICFBamSchema.RelationTypeEnum.Parent )
			 || ( relType == ICFBamSchema.RelationTypeEnum.Container ) )
			{
				list.add(relationDef);
			}
		}

		ICFBamRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				relType = relationDef.getRequiredRelationType();
				if( ( relType == ICFBamSchema.RelationTypeEnum.Owner )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Parent )
				 || ( relType == ICFBamSchema.RelationTypeEnum.Container ) )
				{
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		return( list );
	}

	public ICFBamRelationObj getContainerRelation() {
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Container ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public ICFBamRelationObj getInheritedContainerRelation() {
		ICFBamRelationObj inheritedContainerRelation = null;
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations;
		ICFBamTableObj tableDef = this;
		while( ( inheritedContainerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Container ) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return( null );
	}

	public ICFBamRelationObj getOwnerRelation() {
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Owner ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public ICFBamRelationObj getInheritedOwnerRelation() {
		ICFBamTableObj tableDef = this;
		ICFBamRelationObj inheritedOwnerRelation = null;
		ICFBamRelationObj relationDef;
		Iterator<ICFBamRelationObj> childrenRelations;
		while( ( inheritedOwnerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Owner ) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return( null );
	}

	public List<ICFBamRelationObj> getOwnerLookupRelations() {
		ICFBamSchema.RelationTypeEnum relType;
		ICFBamRelationObj relationDef;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext())
		{
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( ( relType == ICFBamSchema.RelationTypeEnum.Parent )
			 || ( relType == ICFBamSchema.RelationTypeEnum.Container )
			 || ( relType == ICFBamSchema.RelationTypeEnum.Lookup )
			 || ( relType == ICFBamSchema.RelationTypeEnum.Owner ) )
			{
				list.add(relationDef);
			}
		}
		return( list );
	}

	public List<ICFBamRelationObj> getOwnerContainerNamedLookupChainRelations() {
		ICFBamSchema.RelationTypeEnum relType;
		ICFBamRelationObj relationDef;
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		List<ICFBamChainObj> componentChains = getOptionalComponentsChains();
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( relType == ICFBamSchema.RelationTypeEnum.Superclass ) {
				;
			}
			else if( ( relType == ICFBamSchema.RelationTypeEnum.Container )
				|| ( relType == ICFBamSchema.RelationTypeEnum.Owner ) )
			{
				list.add(relationDef);
			}
			else {
				if( ! relationDef.getRequiredIsXsdContainer() ) {
					ICFBamIndexObj toIndex = relationDef.getRequiredLookupToIndex();
					if( toIndex.getRequiredIsUnique() ) {
						boolean referencedByChain = false;
						Iterator<ICFBamChainObj> iterChain = componentChains.iterator();
						while( ( ! referencedByChain ) && iterChain.hasNext() ) {
							ICFBamChainObj chain = iterChain.next();
							if( chain.getRequiredLookupPrevRel() == relationDef ) {
								referencedByChain = true;
							}
							else if( chain.getRequiredLookupNextRel() == relationDef ) {
								referencedByChain = true;
							}
						}
						if( referencedByChain ) {
							list.add( relationDef );
						}
						else {
							ICFBamTableObj toTable = relationDef.getRequiredLookupToTable();
							ICFBamIndexObj lookupIndex = toTable.getOptionalLookupLookupIndex();
							while( ( lookupIndex == null ) && ( toTable != null ) ) {
								ICFBamRelationObj superRelation = toTable.getSuperClassRelation();
								if( superRelation != null ) {
									toTable = superRelation.getRequiredLookupToTable();
									if( toTable != null ) {
										lookupIndex = toTable.getOptionalLookupLookupIndex();
									}
								}
								else {
									toTable = null;
								}
							}
							if( lookupIndex != null ) {
								list.add( relationDef );
							}
						}
					}
				}
			}
		}
		return( list );
	}

	public List<ICFBamAtomObj> getChildrenAtoms() {
		List<ICFBamAtomObj> list = new LinkedList<ICFBamAtomObj>();
		Iterator<ICFBamValueObj> childrenColumns = getOptionalComponentsColumns().iterator();
		while (childrenColumns.hasNext())
		{
			ICFBamValueObj colDef = childrenColumns.next();
			if( colDef instanceof ICFBamAtomObj)
			{
				list.add( (ICFBamAtomObj)colDef);
			}
		}
		return( list );
	}

	public ICFBamRelationObj getSuperClassRelation() {
		Iterator<ICFBamRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext())
		{
			ICFBamRelationObj relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Superclass ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public List<ICFBamRelationObj> getSubClassRelations() {
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> reverseRelations = getOptionalChildrenReverseRelations().iterator();
		while (reverseRelations.hasNext())
		{
			ICFBamRelationObj reverseRelation = reverseRelations.next();
			if( reverseRelation.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Superclass ) {
				list.add(reverseRelation);
			}
		}
		return( list );
	}

	public ICFBamIndexObj getPrimaryKeyIndex() {
		ICFBamIndexObj primaryIndex = getOptionalLookupPrimaryIndex();
		return( primaryIndex );
	}

	public List<ICFBamRelationObj> getFactoryOwnerRelations() {
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		Iterator<ICFBamRelationObj> ownerRelations = getContainerOwnerRelations().iterator();
		while (ownerRelations.hasNext())
		{
			// throw new NotImplementedException();
			ICFBamRelationObj ownerRelation = ownerRelations.next();
			if( ownerRelation.getRequiredRelationType() == ICFBamSchema.RelationTypeEnum.Superclass ) {
				list.add(ownerRelation);
			}
		}
		return( list );
	}

	public List<ICFBamIndexObj> getInheritedIndexes() {
		List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
		ICFBamRelationObj superClassRelation = getSuperClassRelation();
		if( superClassRelation != null)
		{
			Iterator<ICFBamIndexObj> superClassInheritedIndexes
				= superClassRelation.getRequiredLookupToTable().getInheritedIndexes().iterator();
			while (superClassInheritedIndexes.hasNext())
			{
				list.add(superClassInheritedIndexes.next());
			}
			Iterator<ICFBamIndexObj> myIndexes = getChildrenIndexes().iterator();
			while( myIndexes.hasNext() )
			{
				list.add( myIndexes.next() );
			}
		}
		return( list );
	}

	public List<ICFBamIndexObj> getChildrenIndexes() {
		Iterator<ICFBamIndexObj> iter = getOptionalComponentsIndex().iterator();
		List<ICFBamIndexObj> list = new LinkedList<ICFBamIndexObj>();
		while( iter.hasNext() ) {
			list.add( iter.next() );
		}
		return( list );
	}

	public List<ICFBamRelationObj> getInheritedRelations() {
		List<ICFBamRelationObj> list = new LinkedList<ICFBamRelationObj>();
		ICFBamRelationObj superClassRelation = getSuperClassRelation();
		if( superClassRelation != null)
		{
			Iterator<ICFBamRelationObj> superClassInheritedRelations
				= superClassRelation.getRequiredLookupToTable().getInheritedRelations().iterator();
			while (superClassInheritedRelations.hasNext())
			{
				list.add(superClassInheritedRelations.next());
			}
			Iterator<ICFBamRelationObj> myRelations = getChildrenRelations().iterator();
			while (myRelations.hasNext())
			{
				list.add(myRelations.next());
			}
		}
		return( list );
	}

	public List<ICFBamRelationObj> getChildrenRelations() {
		List<ICFBamRelationObj> childrenRelations = new LinkedList<ICFBamRelationObj>();
		Collection<ICFBamRelationObj> cltn = getOptionalComponentsRelation();
		Iterator<ICFBamRelationObj> iter = cltn.iterator();
		while( iter.hasNext() ) {
			childrenRelations.add( iter.next() );
		}
		return( childrenRelations );
	}
}
