// Description: Java 11 edit object instance implementation for CFBam Table.

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

public class CFBamTableEditObj
	extends CFBamScopeEditObj

	implements ICFBamTableEditObj
{
	protected ICFBamSchemaDefObj requiredContainerSchemaDef;
	protected ICFBamSchemaDefObj optionalLookupDefSchema;
	protected ICFBamIndexObj optionalLookupLookupIndex;
	protected ICFBamIndexObj optionalLookupAltIndex;
	protected ICFBamTableObj optionalLookupQualTable;
	protected ICFBamIndexObj optionalLookupPrimaryIndex;

	public CFBamTableEditObj( ICFBamTableObj argOrig ) {
		super( argOrig );
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	public String getClassCode() {
		return( CFBamTableObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamTableObj retobj = getSchema().getTableTableObj().realiseTable( (ICFBamTableObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsTable().getSchema()).getTableTableObj().forgetTable( getOrigAsTable(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamTableObj retobj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getTableTableObj().createTable( getOrigAsTable() );
		if( retobj == getOrigAsTable() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getTableTableObj().updateTable( (ICFBamTableObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getTableTableObj().deleteTable( getOrigAsTable() );
		return( null );
	}

	public ICFBamTableTableObj getTableTable() {
		return( orig.getSchema().getTableTableObj() );
	}

	public ICFBamTableEditObj getEditAsTable() {
		return( (ICFBamTableEditObj)this );
	}

	public ICFBamTableObj getOrigAsTable() {
		return( (ICFBamTableObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsTable().getSchema().getBackingStore()).getFactoryTable().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerSchemaDef = null;
			optionalLookupDefSchema = null;
			optionalLookupLookupIndex = null;
			optionalLookupAltIndex = null;
			optionalLookupQualTable = null;
			optionalLookupPrimaryIndex = null;
		}
	}

	public CFBamTableBuff getTableBuff() {
		return( (CFBamTableBuff)getBuff() );
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

	public void setRequiredName( String value ) {
		if( getTableBuff().getRequiredName() != value ) {
			getTableBuff().setRequiredName( value );
		}
	}

	public String getOptionalDbName() {
		return( getTableBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getTableBuff().getOptionalDbName() != value ) {
			getTableBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalShortName() {
		return( getTableBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getTableBuff().getOptionalShortName() != value ) {
			getTableBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getTableBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getTableBuff().getOptionalLabel() != value ) {
			getTableBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getTableBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getTableBuff().getOptionalShortDescription() != value ) {
			getTableBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getTableBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getTableBuff().getOptionalDescription() != value ) {
			getTableBuff().setOptionalDescription( value );
		}
	}

	public boolean getRequiredPageData() {
		return( getTableBuff().getRequiredPageData() );
	}

	public void setRequiredPageData( boolean value ) {
		if( getTableBuff().getRequiredPageData() != value ) {
			getTableBuff().setRequiredPageData( value );
		}
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

	public void setRequiredTableClassCode( String value ) {
		if( getTableBuff().getRequiredTableClassCode() != value ) {
			getTableBuff().setRequiredTableClassCode( value );
		}
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

	public void setRequiredIsInstantiable( boolean value ) {
		if( getTableBuff().getRequiredIsInstantiable() != value ) {
			getTableBuff().setRequiredIsInstantiable( value );
		}
	}

	public boolean getRequiredHasHistory() {
		return( getTableBuff().getRequiredHasHistory() );
	}

	public void setRequiredHasHistory( boolean value ) {
		if( getTableBuff().getRequiredHasHistory() != value ) {
			getTableBuff().setRequiredHasHistory( value );
		}
	}

	public boolean getRequiredHasAuditColumns() {
		return( getTableBuff().getRequiredHasAuditColumns() );
	}

	public void setRequiredHasAuditColumns( boolean value ) {
		if( getTableBuff().getRequiredHasAuditColumns() != value ) {
			getTableBuff().setRequiredHasAuditColumns( value );
		}
	}

	public ICFBamSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour() {
		return( getTableBuff().getRequiredLoaderBehaviour() );
	}

	public void setRequiredLoaderBehaviour( ICFBamSchema.LoaderBehaviourEnum value ) {
		if( getTableBuff().getRequiredLoaderBehaviour() != value ) {
			getTableBuff().setRequiredLoaderBehaviour( value );
		}
	}

	public ICFBamSchema.SecScopeEnum getRequiredSecScope() {
		return( getTableBuff().getRequiredSecScope() );
	}

	public void setRequiredSecScope( ICFBamSchema.SecScopeEnum value ) {
		if( getTableBuff().getRequiredSecScope() != value ) {
			getTableBuff().setRequiredSecScope( value );
		}
	}

	public String getOptionalJObjMembers() {
		return( getTableBuff().getOptionalJObjMembers() );
	}

	public void setOptionalJObjMembers( String value ) {
		if( getTableBuff().getOptionalJObjMembers() != value ) {
			getTableBuff().setOptionalJObjMembers( value );
		}
	}

	public String getOptionalJObjInterface() {
		return( getTableBuff().getOptionalJObjInterface() );
	}

	public void setOptionalJObjInterface( String value ) {
		if( getTableBuff().getOptionalJObjInterface() != value ) {
			getTableBuff().setOptionalJObjInterface( value );
		}
	}

	public String getOptionalJObjImport() {
		return( getTableBuff().getOptionalJObjImport() );
	}

	public void setOptionalJObjImport( String value ) {
		if( getTableBuff().getOptionalJObjImport() != value ) {
			getTableBuff().setOptionalJObjImport( value );
		}
	}

	public String getOptionalJObjImplementation() {
		return( getTableBuff().getOptionalJObjImplementation() );
	}

	public void setOptionalJObjImplementation( String value ) {
		if( getTableBuff().getOptionalJObjImplementation() != value ) {
			getTableBuff().setOptionalJObjImplementation( value );
		}
	}

	public String getOptionalJEditObjMembers() {
		return( getTableBuff().getOptionalJEditObjMembers() );
	}

	public void setOptionalJEditObjMembers( String value ) {
		if( getTableBuff().getOptionalJEditObjMembers() != value ) {
			getTableBuff().setOptionalJEditObjMembers( value );
		}
	}

	public String getOptionalJEditObjInterface() {
		return( getTableBuff().getOptionalJEditObjInterface() );
	}

	public void setOptionalJEditObjInterface( String value ) {
		if( getTableBuff().getOptionalJEditObjInterface() != value ) {
			getTableBuff().setOptionalJEditObjInterface( value );
		}
	}

	public String getOptionalJEditObjImport() {
		return( getTableBuff().getOptionalJEditObjImport() );
	}

	public void setOptionalJEditObjImport( String value ) {
		if( getTableBuff().getOptionalJEditObjImport() != value ) {
			getTableBuff().setOptionalJEditObjImport( value );
		}
	}

	public String getOptionalJEditObjImplementation() {
		return( getTableBuff().getOptionalJEditObjImplementation() );
	}

	public void setOptionalJEditObjImplementation( String value ) {
		if( getTableBuff().getOptionalJEditObjImplementation() != value ) {
			getTableBuff().setOptionalJEditObjImplementation( value );
		}
	}

	public String getOptionalJTableImport() {
		return( getTableBuff().getOptionalJTableImport() );
	}

	public void setOptionalJTableImport( String value ) {
		if( getTableBuff().getOptionalJTableImport() != value ) {
			getTableBuff().setOptionalJTableImport( value );
		}
	}

	public String getOptionalJTableMembers() {
		return( getTableBuff().getOptionalJTableMembers() );
	}

	public void setOptionalJTableMembers( String value ) {
		if( getTableBuff().getOptionalJTableMembers() != value ) {
			getTableBuff().setOptionalJTableMembers( value );
		}
	}

	public String getOptionalJTableInterface() {
		return( getTableBuff().getOptionalJTableInterface() );
	}

	public void setOptionalJTableInterface( String value ) {
		if( getTableBuff().getOptionalJTableInterface() != value ) {
			getTableBuff().setOptionalJTableInterface( value );
		}
	}

	public String getOptionalJTableImplementation() {
		return( getTableBuff().getOptionalJTableImplementation() );
	}

	public void setOptionalJTableImplementation( String value ) {
		if( getTableBuff().getOptionalJTableImplementation() != value ) {
			getTableBuff().setOptionalJTableImplementation( value );
		}
	}

	public String getOptionalJTableObjImport() {
		return( getTableBuff().getOptionalJTableObjImport() );
	}

	public void setOptionalJTableObjImport( String value ) {
		if( getTableBuff().getOptionalJTableObjImport() != value ) {
			getTableBuff().setOptionalJTableObjImport( value );
		}
	}

	public String getOptionalJTableObjMembers() {
		return( getTableBuff().getOptionalJTableObjMembers() );
	}

	public void setOptionalJTableObjMembers( String value ) {
		if( getTableBuff().getOptionalJTableObjMembers() != value ) {
			getTableBuff().setOptionalJTableObjMembers( value );
		}
	}

	public String getOptionalJTableObjInterface() {
		return( getTableBuff().getOptionalJTableObjInterface() );
	}

	public void setOptionalJTableObjInterface( String value ) {
		if( getTableBuff().getOptionalJTableObjInterface() != value ) {
			getTableBuff().setOptionalJTableObjInterface( value );
		}
	}

	public String getOptionalJTableObjImplementation() {
		return( getTableBuff().getOptionalJTableObjImplementation() );
	}

	public void setOptionalJTableObjImplementation( String value ) {
		if( getTableBuff().getOptionalJTableObjImplementation() != value ) {
			getTableBuff().setOptionalJTableObjImplementation( value );
		}
	}

	public String getOptionalJDb2LUWTableImport() {
		return( getTableBuff().getOptionalJDb2LUWTableImport() );
	}

	public void setOptionalJDb2LUWTableImport( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableImport() != value ) {
			getTableBuff().setOptionalJDb2LUWTableImport( value );
		}
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( getTableBuff().getOptionalJDb2LUWTableMembers() );
	}

	public void setOptionalJDb2LUWTableMembers( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableMembers() != value ) {
			getTableBuff().setOptionalJDb2LUWTableMembers( value );
		}
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalJDb2LUWTableImplementation() );
	}

	public void setOptionalJDb2LUWTableImplementation( String value ) {
		if( getTableBuff().getOptionalJDb2LUWTableImplementation() != value ) {
			getTableBuff().setOptionalJDb2LUWTableImplementation( value );
		}
	}

	public String getOptionalJMSSqlTableImport() {
		return( getTableBuff().getOptionalJMSSqlTableImport() );
	}

	public void setOptionalJMSSqlTableImport( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableImport() != value ) {
			getTableBuff().setOptionalJMSSqlTableImport( value );
		}
	}

	public String getOptionalJMSSqlTableMembers() {
		return( getTableBuff().getOptionalJMSSqlTableMembers() );
	}

	public void setOptionalJMSSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableMembers() != value ) {
			getTableBuff().setOptionalJMSSqlTableMembers( value );
		}
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( getTableBuff().getOptionalJMSSqlTableImplementation() );
	}

	public void setOptionalJMSSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJMSSqlTableImplementation() != value ) {
			getTableBuff().setOptionalJMSSqlTableImplementation( value );
		}
	}

	public String getOptionalJMySqlTableImport() {
		return( getTableBuff().getOptionalJMySqlTableImport() );
	}

	public void setOptionalJMySqlTableImport( String value ) {
		if( getTableBuff().getOptionalJMySqlTableImport() != value ) {
			getTableBuff().setOptionalJMySqlTableImport( value );
		}
	}

	public String getOptionalJMySqlTableMembers() {
		return( getTableBuff().getOptionalJMySqlTableMembers() );
	}

	public void setOptionalJMySqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJMySqlTableMembers() != value ) {
			getTableBuff().setOptionalJMySqlTableMembers( value );
		}
	}

	public String getOptionalJMySqlTableImplementation() {
		return( getTableBuff().getOptionalJMySqlTableImplementation() );
	}

	public void setOptionalJMySqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJMySqlTableImplementation() != value ) {
			getTableBuff().setOptionalJMySqlTableImplementation( value );
		}
	}

	public String getOptionalJOracleTableImport() {
		return( getTableBuff().getOptionalJOracleTableImport() );
	}

	public void setOptionalJOracleTableImport( String value ) {
		if( getTableBuff().getOptionalJOracleTableImport() != value ) {
			getTableBuff().setOptionalJOracleTableImport( value );
		}
	}

	public String getOptionalJOracleTableMembers() {
		return( getTableBuff().getOptionalJOracleTableMembers() );
	}

	public void setOptionalJOracleTableMembers( String value ) {
		if( getTableBuff().getOptionalJOracleTableMembers() != value ) {
			getTableBuff().setOptionalJOracleTableMembers( value );
		}
	}

	public String getOptionalJOracleTableImplementation() {
		return( getTableBuff().getOptionalJOracleTableImplementation() );
	}

	public void setOptionalJOracleTableImplementation( String value ) {
		if( getTableBuff().getOptionalJOracleTableImplementation() != value ) {
			getTableBuff().setOptionalJOracleTableImplementation( value );
		}
	}

	public String getOptionalJPgSqlTableImport() {
		return( getTableBuff().getOptionalJPgSqlTableImport() );
	}

	public void setOptionalJPgSqlTableImport( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableImport() != value ) {
			getTableBuff().setOptionalJPgSqlTableImport( value );
		}
	}

	public String getOptionalJPgSqlTableMembers() {
		return( getTableBuff().getOptionalJPgSqlTableMembers() );
	}

	public void setOptionalJPgSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableMembers() != value ) {
			getTableBuff().setOptionalJPgSqlTableMembers( value );
		}
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( getTableBuff().getOptionalJPgSqlTableImplementation() );
	}

	public void setOptionalJPgSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalJPgSqlTableImplementation() != value ) {
			getTableBuff().setOptionalJPgSqlTableImplementation( value );
		}
	}

	public String getOptionalJRamTableImport() {
		return( getTableBuff().getOptionalJRamTableImport() );
	}

	public void setOptionalJRamTableImport( String value ) {
		if( getTableBuff().getOptionalJRamTableImport() != value ) {
			getTableBuff().setOptionalJRamTableImport( value );
		}
	}

	public String getOptionalJRamTableMembers() {
		return( getTableBuff().getOptionalJRamTableMembers() );
	}

	public void setOptionalJRamTableMembers( String value ) {
		if( getTableBuff().getOptionalJRamTableMembers() != value ) {
			getTableBuff().setOptionalJRamTableMembers( value );
		}
	}

	public String getOptionalJRamTableImplementation() {
		return( getTableBuff().getOptionalJRamTableImplementation() );
	}

	public void setOptionalJRamTableImplementation( String value ) {
		if( getTableBuff().getOptionalJRamTableImplementation() != value ) {
			getTableBuff().setOptionalJRamTableImplementation( value );
		}
	}

	public String getOptionalJSaxLoaderImport() {
		return( getTableBuff().getOptionalJSaxLoaderImport() );
	}

	public void setOptionalJSaxLoaderImport( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderImport() != value ) {
			getTableBuff().setOptionalJSaxLoaderImport( value );
		}
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( getTableBuff().getOptionalJSaxLoaderStartElement() );
	}

	public void setOptionalJSaxLoaderStartElement( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderStartElement() != value ) {
			getTableBuff().setOptionalJSaxLoaderStartElement( value );
		}
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( getTableBuff().getOptionalJSaxLoaderEndElement() );
	}

	public void setOptionalJSaxLoaderEndElement( String value ) {
		if( getTableBuff().getOptionalJSaxLoaderEndElement() != value ) {
			getTableBuff().setOptionalJSaxLoaderEndElement( value );
		}
	}

	public String getOptionalJXMsgTableImport() {
		return( getTableBuff().getOptionalJXMsgTableImport() );
	}

	public void setOptionalJXMsgTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgTableImport() != value ) {
			getTableBuff().setOptionalJXMsgTableImport( value );
		}
	}

	public String getOptionalJXMsgTableFormatters() {
		return( getTableBuff().getOptionalJXMsgTableFormatters() );
	}

	public void setOptionalJXMsgTableFormatters( String value ) {
		if( getTableBuff().getOptionalJXMsgTableFormatters() != value ) {
			getTableBuff().setOptionalJXMsgTableFormatters( value );
		}
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( getTableBuff().getOptionalJXMsgRqstTableImport() );
	}

	public void setOptionalJXMsgRqstTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgRqstTableImport() != value ) {
			getTableBuff().setOptionalJXMsgRqstTableImport( value );
		}
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( getTableBuff().getOptionalJXMsgRspnTableImport() );
	}

	public void setOptionalJXMsgRspnTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgRspnTableImport() != value ) {
			getTableBuff().setOptionalJXMsgRspnTableImport( value );
		}
	}

	public String getOptionalJXMsgClientTableImport() {
		return( getTableBuff().getOptionalJXMsgClientTableImport() );
	}

	public void setOptionalJXMsgClientTableImport( String value ) {
		if( getTableBuff().getOptionalJXMsgClientTableImport() != value ) {
			getTableBuff().setOptionalJXMsgClientTableImport( value );
		}
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( getTableBuff().getOptionalJXMsgRqstTableBody() );
	}

	public void setOptionalJXMsgRqstTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgRqstTableBody() != value ) {
			getTableBuff().setOptionalJXMsgRqstTableBody( value );
		}
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( getTableBuff().getOptionalJXMsgRspnTableBody() );
	}

	public void setOptionalJXMsgRspnTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgRspnTableBody() != value ) {
			getTableBuff().setOptionalJXMsgRspnTableBody( value );
		}
	}

	public String getOptionalJXMsgClientTableBody() {
		return( getTableBuff().getOptionalJXMsgClientTableBody() );
	}

	public void setOptionalJXMsgClientTableBody( String value ) {
		if( getTableBuff().getOptionalJXMsgClientTableBody() != value ) {
			getTableBuff().setOptionalJXMsgClientTableBody( value );
		}
	}

	public String getOptionalCppObjMembers() {
		return( getTableBuff().getOptionalCppObjMembers() );
	}

	public void setOptionalCppObjMembers( String value ) {
		if( getTableBuff().getOptionalCppObjMembers() != value ) {
			getTableBuff().setOptionalCppObjMembers( value );
		}
	}

	public String getOptionalCppObjInterface() {
		return( getTableBuff().getOptionalCppObjInterface() );
	}

	public void setOptionalCppObjInterface( String value ) {
		if( getTableBuff().getOptionalCppObjInterface() != value ) {
			getTableBuff().setOptionalCppObjInterface( value );
		}
	}

	public String getOptionalCppObjInclude() {
		return( getTableBuff().getOptionalCppObjInclude() );
	}

	public void setOptionalCppObjInclude( String value ) {
		if( getTableBuff().getOptionalCppObjInclude() != value ) {
			getTableBuff().setOptionalCppObjInclude( value );
		}
	}

	public String getOptionalCppObjImplementation() {
		return( getTableBuff().getOptionalCppObjImplementation() );
	}

	public void setOptionalCppObjImplementation( String value ) {
		if( getTableBuff().getOptionalCppObjImplementation() != value ) {
			getTableBuff().setOptionalCppObjImplementation( value );
		}
	}

	public String getOptionalCppEditObjMembers() {
		return( getTableBuff().getOptionalCppEditObjMembers() );
	}

	public void setOptionalCppEditObjMembers( String value ) {
		if( getTableBuff().getOptionalCppEditObjMembers() != value ) {
			getTableBuff().setOptionalCppEditObjMembers( value );
		}
	}

	public String getOptionalCppEditObjInterface() {
		return( getTableBuff().getOptionalCppEditObjInterface() );
	}

	public void setOptionalCppEditObjInterface( String value ) {
		if( getTableBuff().getOptionalCppEditObjInterface() != value ) {
			getTableBuff().setOptionalCppEditObjInterface( value );
		}
	}

	public String getOptionalCppEditObjInclude() {
		return( getTableBuff().getOptionalCppEditObjInclude() );
	}

	public void setOptionalCppEditObjInclude( String value ) {
		if( getTableBuff().getOptionalCppEditObjInclude() != value ) {
			getTableBuff().setOptionalCppEditObjInclude( value );
		}
	}

	public String getOptionalCppEditObjImplementation() {
		return( getTableBuff().getOptionalCppEditObjImplementation() );
	}

	public void setOptionalCppEditObjImplementation( String value ) {
		if( getTableBuff().getOptionalCppEditObjImplementation() != value ) {
			getTableBuff().setOptionalCppEditObjImplementation( value );
		}
	}

	public String getOptionalCppTableInclude() {
		return( getTableBuff().getOptionalCppTableInclude() );
	}

	public void setOptionalCppTableInclude( String value ) {
		if( getTableBuff().getOptionalCppTableInclude() != value ) {
			getTableBuff().setOptionalCppTableInclude( value );
		}
	}

	public String getOptionalCppTableMembers() {
		return( getTableBuff().getOptionalCppTableMembers() );
	}

	public void setOptionalCppTableMembers( String value ) {
		if( getTableBuff().getOptionalCppTableMembers() != value ) {
			getTableBuff().setOptionalCppTableMembers( value );
		}
	}

	public String getOptionalCppTableInterface() {
		return( getTableBuff().getOptionalCppTableInterface() );
	}

	public void setOptionalCppTableInterface( String value ) {
		if( getTableBuff().getOptionalCppTableInterface() != value ) {
			getTableBuff().setOptionalCppTableInterface( value );
		}
	}

	public String getOptionalCppTableImplementation() {
		return( getTableBuff().getOptionalCppTableImplementation() );
	}

	public void setOptionalCppTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppTableImplementation() != value ) {
			getTableBuff().setOptionalCppTableImplementation( value );
		}
	}

	public String getOptionalCppTableObjInclude() {
		return( getTableBuff().getOptionalCppTableObjInclude() );
	}

	public void setOptionalCppTableObjInclude( String value ) {
		if( getTableBuff().getOptionalCppTableObjInclude() != value ) {
			getTableBuff().setOptionalCppTableObjInclude( value );
		}
	}

	public String getOptionalCppTableObjMembers() {
		return( getTableBuff().getOptionalCppTableObjMembers() );
	}

	public void setOptionalCppTableObjMembers( String value ) {
		if( getTableBuff().getOptionalCppTableObjMembers() != value ) {
			getTableBuff().setOptionalCppTableObjMembers( value );
		}
	}

	public String getOptionalCppTableObjInterface() {
		return( getTableBuff().getOptionalCppTableObjInterface() );
	}

	public void setOptionalCppTableObjInterface( String value ) {
		if( getTableBuff().getOptionalCppTableObjInterface() != value ) {
			getTableBuff().setOptionalCppTableObjInterface( value );
		}
	}

	public String getOptionalCppTableObjImplementation() {
		return( getTableBuff().getOptionalCppTableObjImplementation() );
	}

	public void setOptionalCppTableObjImplementation( String value ) {
		if( getTableBuff().getOptionalCppTableObjImplementation() != value ) {
			getTableBuff().setOptionalCppTableObjImplementation( value );
		}
	}

	public String getOptionalCppDb2LUWTableInclude() {
		return( getTableBuff().getOptionalCppDb2LUWTableInclude() );
	}

	public void setOptionalCppDb2LUWTableInclude( String value ) {
		if( getTableBuff().getOptionalCppDb2LUWTableInclude() != value ) {
			getTableBuff().setOptionalCppDb2LUWTableInclude( value );
		}
	}

	public String getOptionalCppDb2LUWTableMembers() {
		return( getTableBuff().getOptionalCppDb2LUWTableMembers() );
	}

	public void setOptionalCppDb2LUWTableMembers( String value ) {
		if( getTableBuff().getOptionalCppDb2LUWTableMembers() != value ) {
			getTableBuff().setOptionalCppDb2LUWTableMembers( value );
		}
	}

	public String getOptionalCppDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalCppDb2LUWTableImplementation() );
	}

	public void setOptionalCppDb2LUWTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppDb2LUWTableImplementation() != value ) {
			getTableBuff().setOptionalCppDb2LUWTableImplementation( value );
		}
	}

	public String getOptionalCppMSSqlTableInclude() {
		return( getTableBuff().getOptionalCppMSSqlTableInclude() );
	}

	public void setOptionalCppMSSqlTableInclude( String value ) {
		if( getTableBuff().getOptionalCppMSSqlTableInclude() != value ) {
			getTableBuff().setOptionalCppMSSqlTableInclude( value );
		}
	}

	public String getOptionalCppMSSqlTableMembers() {
		return( getTableBuff().getOptionalCppMSSqlTableMembers() );
	}

	public void setOptionalCppMSSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCppMSSqlTableMembers() != value ) {
			getTableBuff().setOptionalCppMSSqlTableMembers( value );
		}
	}

	public String getOptionalCppMSSqlTableImplementation() {
		return( getTableBuff().getOptionalCppMSSqlTableImplementation() );
	}

	public void setOptionalCppMSSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppMSSqlTableImplementation() != value ) {
			getTableBuff().setOptionalCppMSSqlTableImplementation( value );
		}
	}

	public String getOptionalCppMySqlTableInclude() {
		return( getTableBuff().getOptionalCppMySqlTableInclude() );
	}

	public void setOptionalCppMySqlTableInclude( String value ) {
		if( getTableBuff().getOptionalCppMySqlTableInclude() != value ) {
			getTableBuff().setOptionalCppMySqlTableInclude( value );
		}
	}

	public String getOptionalCppMySqlTableMembers() {
		return( getTableBuff().getOptionalCppMySqlTableMembers() );
	}

	public void setOptionalCppMySqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCppMySqlTableMembers() != value ) {
			getTableBuff().setOptionalCppMySqlTableMembers( value );
		}
	}

	public String getOptionalCppMySqlTableImplementation() {
		return( getTableBuff().getOptionalCppMySqlTableImplementation() );
	}

	public void setOptionalCppMySqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppMySqlTableImplementation() != value ) {
			getTableBuff().setOptionalCppMySqlTableImplementation( value );
		}
	}

	public String getOptionalCppOracleTableInclude() {
		return( getTableBuff().getOptionalCppOracleTableInclude() );
	}

	public void setOptionalCppOracleTableInclude( String value ) {
		if( getTableBuff().getOptionalCppOracleTableInclude() != value ) {
			getTableBuff().setOptionalCppOracleTableInclude( value );
		}
	}

	public String getOptionalCppOracleTableMembers() {
		return( getTableBuff().getOptionalCppOracleTableMembers() );
	}

	public void setOptionalCppOracleTableMembers( String value ) {
		if( getTableBuff().getOptionalCppOracleTableMembers() != value ) {
			getTableBuff().setOptionalCppOracleTableMembers( value );
		}
	}

	public String getOptionalCppOracleTableImplementation() {
		return( getTableBuff().getOptionalCppOracleTableImplementation() );
	}

	public void setOptionalCppOracleTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppOracleTableImplementation() != value ) {
			getTableBuff().setOptionalCppOracleTableImplementation( value );
		}
	}

	public String getOptionalCppPgSqlTableInclude() {
		return( getTableBuff().getOptionalCppPgSqlTableInclude() );
	}

	public void setOptionalCppPgSqlTableInclude( String value ) {
		if( getTableBuff().getOptionalCppPgSqlTableInclude() != value ) {
			getTableBuff().setOptionalCppPgSqlTableInclude( value );
		}
	}

	public String getOptionalCppPgSqlTableMembers() {
		return( getTableBuff().getOptionalCppPgSqlTableMembers() );
	}

	public void setOptionalCppPgSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCppPgSqlTableMembers() != value ) {
			getTableBuff().setOptionalCppPgSqlTableMembers( value );
		}
	}

	public String getOptionalCppPgSqlTableImplementation() {
		return( getTableBuff().getOptionalCppPgSqlTableImplementation() );
	}

	public void setOptionalCppPgSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppPgSqlTableImplementation() != value ) {
			getTableBuff().setOptionalCppPgSqlTableImplementation( value );
		}
	}

	public String getOptionalCppRamTableInclude() {
		return( getTableBuff().getOptionalCppRamTableInclude() );
	}

	public void setOptionalCppRamTableInclude( String value ) {
		if( getTableBuff().getOptionalCppRamTableInclude() != value ) {
			getTableBuff().setOptionalCppRamTableInclude( value );
		}
	}

	public String getOptionalCppRamTableMembers() {
		return( getTableBuff().getOptionalCppRamTableMembers() );
	}

	public void setOptionalCppRamTableMembers( String value ) {
		if( getTableBuff().getOptionalCppRamTableMembers() != value ) {
			getTableBuff().setOptionalCppRamTableMembers( value );
		}
	}

	public String getOptionalCppRamTableImplementation() {
		return( getTableBuff().getOptionalCppRamTableImplementation() );
	}

	public void setOptionalCppRamTableImplementation( String value ) {
		if( getTableBuff().getOptionalCppRamTableImplementation() != value ) {
			getTableBuff().setOptionalCppRamTableImplementation( value );
		}
	}

	public String getOptionalCppSaxLoaderInclude() {
		return( getTableBuff().getOptionalCppSaxLoaderInclude() );
	}

	public void setOptionalCppSaxLoaderInclude( String value ) {
		if( getTableBuff().getOptionalCppSaxLoaderInclude() != value ) {
			getTableBuff().setOptionalCppSaxLoaderInclude( value );
		}
	}

	public String getOptionalCppSaxLoaderStartElement() {
		return( getTableBuff().getOptionalCppSaxLoaderStartElement() );
	}

	public void setOptionalCppSaxLoaderStartElement( String value ) {
		if( getTableBuff().getOptionalCppSaxLoaderStartElement() != value ) {
			getTableBuff().setOptionalCppSaxLoaderStartElement( value );
		}
	}

	public String getOptionalCppSaxLoaderEndElement() {
		return( getTableBuff().getOptionalCppSaxLoaderEndElement() );
	}

	public void setOptionalCppSaxLoaderEndElement( String value ) {
		if( getTableBuff().getOptionalCppSaxLoaderEndElement() != value ) {
			getTableBuff().setOptionalCppSaxLoaderEndElement( value );
		}
	}

	public String getOptionalCppXMsgTableInclude() {
		return( getTableBuff().getOptionalCppXMsgTableInclude() );
	}

	public void setOptionalCppXMsgTableInclude( String value ) {
		if( getTableBuff().getOptionalCppXMsgTableInclude() != value ) {
			getTableBuff().setOptionalCppXMsgTableInclude( value );
		}
	}

	public String getOptionalCppXMsgTableFormatters() {
		return( getTableBuff().getOptionalCppXMsgTableFormatters() );
	}

	public void setOptionalCppXMsgTableFormatters( String value ) {
		if( getTableBuff().getOptionalCppXMsgTableFormatters() != value ) {
			getTableBuff().setOptionalCppXMsgTableFormatters( value );
		}
	}

	public String getOptionalCppXMsgRqstTableInclude() {
		return( getTableBuff().getOptionalCppXMsgRqstTableInclude() );
	}

	public void setOptionalCppXMsgRqstTableInclude( String value ) {
		if( getTableBuff().getOptionalCppXMsgRqstTableInclude() != value ) {
			getTableBuff().setOptionalCppXMsgRqstTableInclude( value );
		}
	}

	public String getOptionalCppXMsgRspnTableInclude() {
		return( getTableBuff().getOptionalCppXMsgRspnTableInclude() );
	}

	public void setOptionalCppXMsgRspnTableInclude( String value ) {
		if( getTableBuff().getOptionalCppXMsgRspnTableInclude() != value ) {
			getTableBuff().setOptionalCppXMsgRspnTableInclude( value );
		}
	}

	public String getOptionalCppXMsgClientTableInclude() {
		return( getTableBuff().getOptionalCppXMsgClientTableInclude() );
	}

	public void setOptionalCppXMsgClientTableInclude( String value ) {
		if( getTableBuff().getOptionalCppXMsgClientTableInclude() != value ) {
			getTableBuff().setOptionalCppXMsgClientTableInclude( value );
		}
	}

	public String getOptionalCppXMsgRqstTableBody() {
		return( getTableBuff().getOptionalCppXMsgRqstTableBody() );
	}

	public void setOptionalCppXMsgRqstTableBody( String value ) {
		if( getTableBuff().getOptionalCppXMsgRqstTableBody() != value ) {
			getTableBuff().setOptionalCppXMsgRqstTableBody( value );
		}
	}

	public String getOptionalCppXMsgRspnTableBody() {
		return( getTableBuff().getOptionalCppXMsgRspnTableBody() );
	}

	public void setOptionalCppXMsgRspnTableBody( String value ) {
		if( getTableBuff().getOptionalCppXMsgRspnTableBody() != value ) {
			getTableBuff().setOptionalCppXMsgRspnTableBody( value );
		}
	}

	public String getOptionalCppXMsgClientTableBody() {
		return( getTableBuff().getOptionalCppXMsgClientTableBody() );
	}

	public void setOptionalCppXMsgClientTableBody( String value ) {
		if( getTableBuff().getOptionalCppXMsgClientTableBody() != value ) {
			getTableBuff().setOptionalCppXMsgClientTableBody( value );
		}
	}

	public String getOptionalHppObjMembers() {
		return( getTableBuff().getOptionalHppObjMembers() );
	}

	public void setOptionalHppObjMembers( String value ) {
		if( getTableBuff().getOptionalHppObjMembers() != value ) {
			getTableBuff().setOptionalHppObjMembers( value );
		}
	}

	public String getOptionalHppObjInterface() {
		return( getTableBuff().getOptionalHppObjInterface() );
	}

	public void setOptionalHppObjInterface( String value ) {
		if( getTableBuff().getOptionalHppObjInterface() != value ) {
			getTableBuff().setOptionalHppObjInterface( value );
		}
	}

	public String getOptionalHppObjInclude() {
		return( getTableBuff().getOptionalHppObjInclude() );
	}

	public void setOptionalHppObjInclude( String value ) {
		if( getTableBuff().getOptionalHppObjInclude() != value ) {
			getTableBuff().setOptionalHppObjInclude( value );
		}
	}

	public String getOptionalHppObjImplementation() {
		return( getTableBuff().getOptionalHppObjImplementation() );
	}

	public void setOptionalHppObjImplementation( String value ) {
		if( getTableBuff().getOptionalHppObjImplementation() != value ) {
			getTableBuff().setOptionalHppObjImplementation( value );
		}
	}

	public String getOptionalHppEditObjMembers() {
		return( getTableBuff().getOptionalHppEditObjMembers() );
	}

	public void setOptionalHppEditObjMembers( String value ) {
		if( getTableBuff().getOptionalHppEditObjMembers() != value ) {
			getTableBuff().setOptionalHppEditObjMembers( value );
		}
	}

	public String getOptionalHppEditObjInterface() {
		return( getTableBuff().getOptionalHppEditObjInterface() );
	}

	public void setOptionalHppEditObjInterface( String value ) {
		if( getTableBuff().getOptionalHppEditObjInterface() != value ) {
			getTableBuff().setOptionalHppEditObjInterface( value );
		}
	}

	public String getOptionalHppEditObjInclude() {
		return( getTableBuff().getOptionalHppEditObjInclude() );
	}

	public void setOptionalHppEditObjInclude( String value ) {
		if( getTableBuff().getOptionalHppEditObjInclude() != value ) {
			getTableBuff().setOptionalHppEditObjInclude( value );
		}
	}

	public String getOptionalHppEditObjImplementation() {
		return( getTableBuff().getOptionalHppEditObjImplementation() );
	}

	public void setOptionalHppEditObjImplementation( String value ) {
		if( getTableBuff().getOptionalHppEditObjImplementation() != value ) {
			getTableBuff().setOptionalHppEditObjImplementation( value );
		}
	}

	public String getOptionalHppTableInclude() {
		return( getTableBuff().getOptionalHppTableInclude() );
	}

	public void setOptionalHppTableInclude( String value ) {
		if( getTableBuff().getOptionalHppTableInclude() != value ) {
			getTableBuff().setOptionalHppTableInclude( value );
		}
	}

	public String getOptionalHppTableMembers() {
		return( getTableBuff().getOptionalHppTableMembers() );
	}

	public void setOptionalHppTableMembers( String value ) {
		if( getTableBuff().getOptionalHppTableMembers() != value ) {
			getTableBuff().setOptionalHppTableMembers( value );
		}
	}

	public String getOptionalHppTableInterface() {
		return( getTableBuff().getOptionalHppTableInterface() );
	}

	public void setOptionalHppTableInterface( String value ) {
		if( getTableBuff().getOptionalHppTableInterface() != value ) {
			getTableBuff().setOptionalHppTableInterface( value );
		}
	}

	public String getOptionalHppTableImplementation() {
		return( getTableBuff().getOptionalHppTableImplementation() );
	}

	public void setOptionalHppTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppTableImplementation() != value ) {
			getTableBuff().setOptionalHppTableImplementation( value );
		}
	}

	public String getOptionalHppTableObjInclude() {
		return( getTableBuff().getOptionalHppTableObjInclude() );
	}

	public void setOptionalHppTableObjInclude( String value ) {
		if( getTableBuff().getOptionalHppTableObjInclude() != value ) {
			getTableBuff().setOptionalHppTableObjInclude( value );
		}
	}

	public String getOptionalHppTableObjMembers() {
		return( getTableBuff().getOptionalHppTableObjMembers() );
	}

	public void setOptionalHppTableObjMembers( String value ) {
		if( getTableBuff().getOptionalHppTableObjMembers() != value ) {
			getTableBuff().setOptionalHppTableObjMembers( value );
		}
	}

	public String getOptionalHppTableObjInterface() {
		return( getTableBuff().getOptionalHppTableObjInterface() );
	}

	public void setOptionalHppTableObjInterface( String value ) {
		if( getTableBuff().getOptionalHppTableObjInterface() != value ) {
			getTableBuff().setOptionalHppTableObjInterface( value );
		}
	}

	public String getOptionalHppTableObjImplementation() {
		return( getTableBuff().getOptionalHppTableObjImplementation() );
	}

	public void setOptionalHppTableObjImplementation( String value ) {
		if( getTableBuff().getOptionalHppTableObjImplementation() != value ) {
			getTableBuff().setOptionalHppTableObjImplementation( value );
		}
	}

	public String getOptionalHppDb2LUWTableInclude() {
		return( getTableBuff().getOptionalHppDb2LUWTableInclude() );
	}

	public void setOptionalHppDb2LUWTableInclude( String value ) {
		if( getTableBuff().getOptionalHppDb2LUWTableInclude() != value ) {
			getTableBuff().setOptionalHppDb2LUWTableInclude( value );
		}
	}

	public String getOptionalHppDb2LUWTableMembers() {
		return( getTableBuff().getOptionalHppDb2LUWTableMembers() );
	}

	public void setOptionalHppDb2LUWTableMembers( String value ) {
		if( getTableBuff().getOptionalHppDb2LUWTableMembers() != value ) {
			getTableBuff().setOptionalHppDb2LUWTableMembers( value );
		}
	}

	public String getOptionalHppDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalHppDb2LUWTableImplementation() );
	}

	public void setOptionalHppDb2LUWTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppDb2LUWTableImplementation() != value ) {
			getTableBuff().setOptionalHppDb2LUWTableImplementation( value );
		}
	}

	public String getOptionalHppMSSqlTableInclude() {
		return( getTableBuff().getOptionalHppMSSqlTableInclude() );
	}

	public void setOptionalHppMSSqlTableInclude( String value ) {
		if( getTableBuff().getOptionalHppMSSqlTableInclude() != value ) {
			getTableBuff().setOptionalHppMSSqlTableInclude( value );
		}
	}

	public String getOptionalHppMSSqlTableMembers() {
		return( getTableBuff().getOptionalHppMSSqlTableMembers() );
	}

	public void setOptionalHppMSSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalHppMSSqlTableMembers() != value ) {
			getTableBuff().setOptionalHppMSSqlTableMembers( value );
		}
	}

	public String getOptionalHppMSSqlTableImplementation() {
		return( getTableBuff().getOptionalHppMSSqlTableImplementation() );
	}

	public void setOptionalHppMSSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppMSSqlTableImplementation() != value ) {
			getTableBuff().setOptionalHppMSSqlTableImplementation( value );
		}
	}

	public String getOptionalHppMySqlTableInclude() {
		return( getTableBuff().getOptionalHppMySqlTableInclude() );
	}

	public void setOptionalHppMySqlTableInclude( String value ) {
		if( getTableBuff().getOptionalHppMySqlTableInclude() != value ) {
			getTableBuff().setOptionalHppMySqlTableInclude( value );
		}
	}

	public String getOptionalHppMySqlTableMembers() {
		return( getTableBuff().getOptionalHppMySqlTableMembers() );
	}

	public void setOptionalHppMySqlTableMembers( String value ) {
		if( getTableBuff().getOptionalHppMySqlTableMembers() != value ) {
			getTableBuff().setOptionalHppMySqlTableMembers( value );
		}
	}

	public String getOptionalHppMySqlTableImplementation() {
		return( getTableBuff().getOptionalHppMySqlTableImplementation() );
	}

	public void setOptionalHppMySqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppMySqlTableImplementation() != value ) {
			getTableBuff().setOptionalHppMySqlTableImplementation( value );
		}
	}

	public String getOptionalHppOracleTableInclude() {
		return( getTableBuff().getOptionalHppOracleTableInclude() );
	}

	public void setOptionalHppOracleTableInclude( String value ) {
		if( getTableBuff().getOptionalHppOracleTableInclude() != value ) {
			getTableBuff().setOptionalHppOracleTableInclude( value );
		}
	}

	public String getOptionalHppOracleTableMembers() {
		return( getTableBuff().getOptionalHppOracleTableMembers() );
	}

	public void setOptionalHppOracleTableMembers( String value ) {
		if( getTableBuff().getOptionalHppOracleTableMembers() != value ) {
			getTableBuff().setOptionalHppOracleTableMembers( value );
		}
	}

	public String getOptionalHppOracleTableImplementation() {
		return( getTableBuff().getOptionalHppOracleTableImplementation() );
	}

	public void setOptionalHppOracleTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppOracleTableImplementation() != value ) {
			getTableBuff().setOptionalHppOracleTableImplementation( value );
		}
	}

	public String getOptionalHppPgSqlTableInclude() {
		return( getTableBuff().getOptionalHppPgSqlTableInclude() );
	}

	public void setOptionalHppPgSqlTableInclude( String value ) {
		if( getTableBuff().getOptionalHppPgSqlTableInclude() != value ) {
			getTableBuff().setOptionalHppPgSqlTableInclude( value );
		}
	}

	public String getOptionalHppPgSqlTableMembers() {
		return( getTableBuff().getOptionalHppPgSqlTableMembers() );
	}

	public void setOptionalHppPgSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalHppPgSqlTableMembers() != value ) {
			getTableBuff().setOptionalHppPgSqlTableMembers( value );
		}
	}

	public String getOptionalHppPgSqlTableImplementation() {
		return( getTableBuff().getOptionalHppPgSqlTableImplementation() );
	}

	public void setOptionalHppPgSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppPgSqlTableImplementation() != value ) {
			getTableBuff().setOptionalHppPgSqlTableImplementation( value );
		}
	}

	public String getOptionalHppRamTableInclude() {
		return( getTableBuff().getOptionalHppRamTableInclude() );
	}

	public void setOptionalHppRamTableInclude( String value ) {
		if( getTableBuff().getOptionalHppRamTableInclude() != value ) {
			getTableBuff().setOptionalHppRamTableInclude( value );
		}
	}

	public String getOptionalHppRamTableMembers() {
		return( getTableBuff().getOptionalHppRamTableMembers() );
	}

	public void setOptionalHppRamTableMembers( String value ) {
		if( getTableBuff().getOptionalHppRamTableMembers() != value ) {
			getTableBuff().setOptionalHppRamTableMembers( value );
		}
	}

	public String getOptionalHppRamTableImplementation() {
		return( getTableBuff().getOptionalHppRamTableImplementation() );
	}

	public void setOptionalHppRamTableImplementation( String value ) {
		if( getTableBuff().getOptionalHppRamTableImplementation() != value ) {
			getTableBuff().setOptionalHppRamTableImplementation( value );
		}
	}

	public String getOptionalHppSaxLoaderInclude() {
		return( getTableBuff().getOptionalHppSaxLoaderInclude() );
	}

	public void setOptionalHppSaxLoaderInclude( String value ) {
		if( getTableBuff().getOptionalHppSaxLoaderInclude() != value ) {
			getTableBuff().setOptionalHppSaxLoaderInclude( value );
		}
	}

	public String getOptionalHppSaxLoaderStartElement() {
		return( getTableBuff().getOptionalHppSaxLoaderStartElement() );
	}

	public void setOptionalHppSaxLoaderStartElement( String value ) {
		if( getTableBuff().getOptionalHppSaxLoaderStartElement() != value ) {
			getTableBuff().setOptionalHppSaxLoaderStartElement( value );
		}
	}

	public String getOptionalHppSaxLoaderEndElement() {
		return( getTableBuff().getOptionalHppSaxLoaderEndElement() );
	}

	public void setOptionalHppSaxLoaderEndElement( String value ) {
		if( getTableBuff().getOptionalHppSaxLoaderEndElement() != value ) {
			getTableBuff().setOptionalHppSaxLoaderEndElement( value );
		}
	}

	public String getOptionalHppXMsgTableInclude() {
		return( getTableBuff().getOptionalHppXMsgTableInclude() );
	}

	public void setOptionalHppXMsgTableInclude( String value ) {
		if( getTableBuff().getOptionalHppXMsgTableInclude() != value ) {
			getTableBuff().setOptionalHppXMsgTableInclude( value );
		}
	}

	public String getOptionalHppXMsgTableFormatters() {
		return( getTableBuff().getOptionalHppXMsgTableFormatters() );
	}

	public void setOptionalHppXMsgTableFormatters( String value ) {
		if( getTableBuff().getOptionalHppXMsgTableFormatters() != value ) {
			getTableBuff().setOptionalHppXMsgTableFormatters( value );
		}
	}

	public String getOptionalHppXMsgRqstTableInclude() {
		return( getTableBuff().getOptionalHppXMsgRqstTableInclude() );
	}

	public void setOptionalHppXMsgRqstTableInclude( String value ) {
		if( getTableBuff().getOptionalHppXMsgRqstTableInclude() != value ) {
			getTableBuff().setOptionalHppXMsgRqstTableInclude( value );
		}
	}

	public String getOptionalHppXMsgRspnTableInclude() {
		return( getTableBuff().getOptionalHppXMsgRspnTableInclude() );
	}

	public void setOptionalHppXMsgRspnTableInclude( String value ) {
		if( getTableBuff().getOptionalHppXMsgRspnTableInclude() != value ) {
			getTableBuff().setOptionalHppXMsgRspnTableInclude( value );
		}
	}

	public String getOptionalHppXMsgClientTableInclude() {
		return( getTableBuff().getOptionalHppXMsgClientTableInclude() );
	}

	public void setOptionalHppXMsgClientTableInclude( String value ) {
		if( getTableBuff().getOptionalHppXMsgClientTableInclude() != value ) {
			getTableBuff().setOptionalHppXMsgClientTableInclude( value );
		}
	}

	public String getOptionalHppXMsgRqstTableBody() {
		return( getTableBuff().getOptionalHppXMsgRqstTableBody() );
	}

	public void setOptionalHppXMsgRqstTableBody( String value ) {
		if( getTableBuff().getOptionalHppXMsgRqstTableBody() != value ) {
			getTableBuff().setOptionalHppXMsgRqstTableBody( value );
		}
	}

	public String getOptionalHppXMsgRspnTableBody() {
		return( getTableBuff().getOptionalHppXMsgRspnTableBody() );
	}

	public void setOptionalHppXMsgRspnTableBody( String value ) {
		if( getTableBuff().getOptionalHppXMsgRspnTableBody() != value ) {
			getTableBuff().setOptionalHppXMsgRspnTableBody( value );
		}
	}

	public String getOptionalHppXMsgClientTableBody() {
		return( getTableBuff().getOptionalHppXMsgClientTableBody() );
	}

	public void setOptionalHppXMsgClientTableBody( String value ) {
		if( getTableBuff().getOptionalHppXMsgClientTableBody() != value ) {
			getTableBuff().setOptionalHppXMsgClientTableBody( value );
		}
	}

	public String getOptionalCsObjMembers() {
		return( getTableBuff().getOptionalCsObjMembers() );
	}

	public void setOptionalCsObjMembers( String value ) {
		if( getTableBuff().getOptionalCsObjMembers() != value ) {
			getTableBuff().setOptionalCsObjMembers( value );
		}
	}

	public String getOptionalCsObjInterface() {
		return( getTableBuff().getOptionalCsObjInterface() );
	}

	public void setOptionalCsObjInterface( String value ) {
		if( getTableBuff().getOptionalCsObjInterface() != value ) {
			getTableBuff().setOptionalCsObjInterface( value );
		}
	}

	public String getOptionalCsObjUsing() {
		return( getTableBuff().getOptionalCsObjUsing() );
	}

	public void setOptionalCsObjUsing( String value ) {
		if( getTableBuff().getOptionalCsObjUsing() != value ) {
			getTableBuff().setOptionalCsObjUsing( value );
		}
	}

	public String getOptionalCsObjImplementation() {
		return( getTableBuff().getOptionalCsObjImplementation() );
	}

	public void setOptionalCsObjImplementation( String value ) {
		if( getTableBuff().getOptionalCsObjImplementation() != value ) {
			getTableBuff().setOptionalCsObjImplementation( value );
		}
	}

	public String getOptionalCsEditObjMembers() {
		return( getTableBuff().getOptionalCsEditObjMembers() );
	}

	public void setOptionalCsEditObjMembers( String value ) {
		if( getTableBuff().getOptionalCsEditObjMembers() != value ) {
			getTableBuff().setOptionalCsEditObjMembers( value );
		}
	}

	public String getOptionalCsEditObjInterface() {
		return( getTableBuff().getOptionalCsEditObjInterface() );
	}

	public void setOptionalCsEditObjInterface( String value ) {
		if( getTableBuff().getOptionalCsEditObjInterface() != value ) {
			getTableBuff().setOptionalCsEditObjInterface( value );
		}
	}

	public String getOptionalCsEditObjUsing() {
		return( getTableBuff().getOptionalCsEditObjUsing() );
	}

	public void setOptionalCsEditObjUsing( String value ) {
		if( getTableBuff().getOptionalCsEditObjUsing() != value ) {
			getTableBuff().setOptionalCsEditObjUsing( value );
		}
	}

	public String getOptionalCsEditObjImplementation() {
		return( getTableBuff().getOptionalCsEditObjImplementation() );
	}

	public void setOptionalCsEditObjImplementation( String value ) {
		if( getTableBuff().getOptionalCsEditObjImplementation() != value ) {
			getTableBuff().setOptionalCsEditObjImplementation( value );
		}
	}

	public String getOptionalCsTableUsing() {
		return( getTableBuff().getOptionalCsTableUsing() );
	}

	public void setOptionalCsTableUsing( String value ) {
		if( getTableBuff().getOptionalCsTableUsing() != value ) {
			getTableBuff().setOptionalCsTableUsing( value );
		}
	}

	public String getOptionalCsTableMembers() {
		return( getTableBuff().getOptionalCsTableMembers() );
	}

	public void setOptionalCsTableMembers( String value ) {
		if( getTableBuff().getOptionalCsTableMembers() != value ) {
			getTableBuff().setOptionalCsTableMembers( value );
		}
	}

	public String getOptionalCsTableInterface() {
		return( getTableBuff().getOptionalCsTableInterface() );
	}

	public void setOptionalCsTableInterface( String value ) {
		if( getTableBuff().getOptionalCsTableInterface() != value ) {
			getTableBuff().setOptionalCsTableInterface( value );
		}
	}

	public String getOptionalCsTableImplementation() {
		return( getTableBuff().getOptionalCsTableImplementation() );
	}

	public void setOptionalCsTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsTableImplementation() != value ) {
			getTableBuff().setOptionalCsTableImplementation( value );
		}
	}

	public String getOptionalCsTableObjUsing() {
		return( getTableBuff().getOptionalCsTableObjUsing() );
	}

	public void setOptionalCsTableObjUsing( String value ) {
		if( getTableBuff().getOptionalCsTableObjUsing() != value ) {
			getTableBuff().setOptionalCsTableObjUsing( value );
		}
	}

	public String getOptionalCsTableObjMembers() {
		return( getTableBuff().getOptionalCsTableObjMembers() );
	}

	public void setOptionalCsTableObjMembers( String value ) {
		if( getTableBuff().getOptionalCsTableObjMembers() != value ) {
			getTableBuff().setOptionalCsTableObjMembers( value );
		}
	}

	public String getOptionalCsTableObjInterface() {
		return( getTableBuff().getOptionalCsTableObjInterface() );
	}

	public void setOptionalCsTableObjInterface( String value ) {
		if( getTableBuff().getOptionalCsTableObjInterface() != value ) {
			getTableBuff().setOptionalCsTableObjInterface( value );
		}
	}

	public String getOptionalCsTableObjImplementation() {
		return( getTableBuff().getOptionalCsTableObjImplementation() );
	}

	public void setOptionalCsTableObjImplementation( String value ) {
		if( getTableBuff().getOptionalCsTableObjImplementation() != value ) {
			getTableBuff().setOptionalCsTableObjImplementation( value );
		}
	}

	public String getOptionalCsDb2LUWTableUsing() {
		return( getTableBuff().getOptionalCsDb2LUWTableUsing() );
	}

	public void setOptionalCsDb2LUWTableUsing( String value ) {
		if( getTableBuff().getOptionalCsDb2LUWTableUsing() != value ) {
			getTableBuff().setOptionalCsDb2LUWTableUsing( value );
		}
	}

	public String getOptionalCsDb2LUWTableMembers() {
		return( getTableBuff().getOptionalCsDb2LUWTableMembers() );
	}

	public void setOptionalCsDb2LUWTableMembers( String value ) {
		if( getTableBuff().getOptionalCsDb2LUWTableMembers() != value ) {
			getTableBuff().setOptionalCsDb2LUWTableMembers( value );
		}
	}

	public String getOptionalCsDb2LUWTableImplementation() {
		return( getTableBuff().getOptionalCsDb2LUWTableImplementation() );
	}

	public void setOptionalCsDb2LUWTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsDb2LUWTableImplementation() != value ) {
			getTableBuff().setOptionalCsDb2LUWTableImplementation( value );
		}
	}

	public String getOptionalCsMSSqlTableUsing() {
		return( getTableBuff().getOptionalCsMSSqlTableUsing() );
	}

	public void setOptionalCsMSSqlTableUsing( String value ) {
		if( getTableBuff().getOptionalCsMSSqlTableUsing() != value ) {
			getTableBuff().setOptionalCsMSSqlTableUsing( value );
		}
	}

	public String getOptionalCsMSSqlTableMembers() {
		return( getTableBuff().getOptionalCsMSSqlTableMembers() );
	}

	public void setOptionalCsMSSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCsMSSqlTableMembers() != value ) {
			getTableBuff().setOptionalCsMSSqlTableMembers( value );
		}
	}

	public String getOptionalCsMSSqlTableImplementation() {
		return( getTableBuff().getOptionalCsMSSqlTableImplementation() );
	}

	public void setOptionalCsMSSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsMSSqlTableImplementation() != value ) {
			getTableBuff().setOptionalCsMSSqlTableImplementation( value );
		}
	}

	public String getOptionalCsMySqlTableUsing() {
		return( getTableBuff().getOptionalCsMySqlTableUsing() );
	}

	public void setOptionalCsMySqlTableUsing( String value ) {
		if( getTableBuff().getOptionalCsMySqlTableUsing() != value ) {
			getTableBuff().setOptionalCsMySqlTableUsing( value );
		}
	}

	public String getOptionalCsMySqlTableMembers() {
		return( getTableBuff().getOptionalCsMySqlTableMembers() );
	}

	public void setOptionalCsMySqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCsMySqlTableMembers() != value ) {
			getTableBuff().setOptionalCsMySqlTableMembers( value );
		}
	}

	public String getOptionalCsMySqlTableImplementation() {
		return( getTableBuff().getOptionalCsMySqlTableImplementation() );
	}

	public void setOptionalCsMySqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsMySqlTableImplementation() != value ) {
			getTableBuff().setOptionalCsMySqlTableImplementation( value );
		}
	}

	public String getOptionalCsOracleTableUsing() {
		return( getTableBuff().getOptionalCsOracleTableUsing() );
	}

	public void setOptionalCsOracleTableUsing( String value ) {
		if( getTableBuff().getOptionalCsOracleTableUsing() != value ) {
			getTableBuff().setOptionalCsOracleTableUsing( value );
		}
	}

	public String getOptionalCsOracleTableMembers() {
		return( getTableBuff().getOptionalCsOracleTableMembers() );
	}

	public void setOptionalCsOracleTableMembers( String value ) {
		if( getTableBuff().getOptionalCsOracleTableMembers() != value ) {
			getTableBuff().setOptionalCsOracleTableMembers( value );
		}
	}

	public String getOptionalCsOracleTableImplementation() {
		return( getTableBuff().getOptionalCsOracleTableImplementation() );
	}

	public void setOptionalCsOracleTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsOracleTableImplementation() != value ) {
			getTableBuff().setOptionalCsOracleTableImplementation( value );
		}
	}

	public String getOptionalCsPgSqlTableUsing() {
		return( getTableBuff().getOptionalCsPgSqlTableUsing() );
	}

	public void setOptionalCsPgSqlTableUsing( String value ) {
		if( getTableBuff().getOptionalCsPgSqlTableUsing() != value ) {
			getTableBuff().setOptionalCsPgSqlTableUsing( value );
		}
	}

	public String getOptionalCsPgSqlTableMembers() {
		return( getTableBuff().getOptionalCsPgSqlTableMembers() );
	}

	public void setOptionalCsPgSqlTableMembers( String value ) {
		if( getTableBuff().getOptionalCsPgSqlTableMembers() != value ) {
			getTableBuff().setOptionalCsPgSqlTableMembers( value );
		}
	}

	public String getOptionalCsPgSqlTableImplementation() {
		return( getTableBuff().getOptionalCsPgSqlTableImplementation() );
	}

	public void setOptionalCsPgSqlTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsPgSqlTableImplementation() != value ) {
			getTableBuff().setOptionalCsPgSqlTableImplementation( value );
		}
	}

	public String getOptionalCsRamTableUsing() {
		return( getTableBuff().getOptionalCsRamTableUsing() );
	}

	public void setOptionalCsRamTableUsing( String value ) {
		if( getTableBuff().getOptionalCsRamTableUsing() != value ) {
			getTableBuff().setOptionalCsRamTableUsing( value );
		}
	}

	public String getOptionalCsRamTableMembers() {
		return( getTableBuff().getOptionalCsRamTableMembers() );
	}

	public void setOptionalCsRamTableMembers( String value ) {
		if( getTableBuff().getOptionalCsRamTableMembers() != value ) {
			getTableBuff().setOptionalCsRamTableMembers( value );
		}
	}

	public String getOptionalCsRamTableImplementation() {
		return( getTableBuff().getOptionalCsRamTableImplementation() );
	}

	public void setOptionalCsRamTableImplementation( String value ) {
		if( getTableBuff().getOptionalCsRamTableImplementation() != value ) {
			getTableBuff().setOptionalCsRamTableImplementation( value );
		}
	}

	public String getOptionalCsSaxLoaderUsing() {
		return( getTableBuff().getOptionalCsSaxLoaderUsing() );
	}

	public void setOptionalCsSaxLoaderUsing( String value ) {
		if( getTableBuff().getOptionalCsSaxLoaderUsing() != value ) {
			getTableBuff().setOptionalCsSaxLoaderUsing( value );
		}
	}

	public String getOptionalCsSaxLoaderStartElement() {
		return( getTableBuff().getOptionalCsSaxLoaderStartElement() );
	}

	public void setOptionalCsSaxLoaderStartElement( String value ) {
		if( getTableBuff().getOptionalCsSaxLoaderStartElement() != value ) {
			getTableBuff().setOptionalCsSaxLoaderStartElement( value );
		}
	}

	public String getOptionalCsSaxLoaderEndElement() {
		return( getTableBuff().getOptionalCsSaxLoaderEndElement() );
	}

	public void setOptionalCsSaxLoaderEndElement( String value ) {
		if( getTableBuff().getOptionalCsSaxLoaderEndElement() != value ) {
			getTableBuff().setOptionalCsSaxLoaderEndElement( value );
		}
	}

	public String getOptionalCsXMsgTableUsing() {
		return( getTableBuff().getOptionalCsXMsgTableUsing() );
	}

	public void setOptionalCsXMsgTableUsing( String value ) {
		if( getTableBuff().getOptionalCsXMsgTableUsing() != value ) {
			getTableBuff().setOptionalCsXMsgTableUsing( value );
		}
	}

	public String getOptionalCsXMsgTableFormatters() {
		return( getTableBuff().getOptionalCsXMsgTableFormatters() );
	}

	public void setOptionalCsXMsgTableFormatters( String value ) {
		if( getTableBuff().getOptionalCsXMsgTableFormatters() != value ) {
			getTableBuff().setOptionalCsXMsgTableFormatters( value );
		}
	}

	public String getOptionalCsXMsgRqstTableUsing() {
		return( getTableBuff().getOptionalCsXMsgRqstTableUsing() );
	}

	public void setOptionalCsXMsgRqstTableUsing( String value ) {
		if( getTableBuff().getOptionalCsXMsgRqstTableUsing() != value ) {
			getTableBuff().setOptionalCsXMsgRqstTableUsing( value );
		}
	}

	public String getOptionalCsXMsgRspnTableUsing() {
		return( getTableBuff().getOptionalCsXMsgRspnTableUsing() );
	}

	public void setOptionalCsXMsgRspnTableUsing( String value ) {
		if( getTableBuff().getOptionalCsXMsgRspnTableUsing() != value ) {
			getTableBuff().setOptionalCsXMsgRspnTableUsing( value );
		}
	}

	public String getOptionalCsXMsgClientTableUsing() {
		return( getTableBuff().getOptionalCsXMsgClientTableUsing() );
	}

	public void setOptionalCsXMsgClientTableUsing( String value ) {
		if( getTableBuff().getOptionalCsXMsgClientTableUsing() != value ) {
			getTableBuff().setOptionalCsXMsgClientTableUsing( value );
		}
	}

	public String getOptionalCsXMsgRqstTableBody() {
		return( getTableBuff().getOptionalCsXMsgRqstTableBody() );
	}

	public void setOptionalCsXMsgRqstTableBody( String value ) {
		if( getTableBuff().getOptionalCsXMsgRqstTableBody() != value ) {
			getTableBuff().setOptionalCsXMsgRqstTableBody( value );
		}
	}

	public String getOptionalCsXMsgRspnTableBody() {
		return( getTableBuff().getOptionalCsXMsgRspnTableBody() );
	}

	public void setOptionalCsXMsgRspnTableBody( String value ) {
		if( getTableBuff().getOptionalCsXMsgRspnTableBody() != value ) {
			getTableBuff().setOptionalCsXMsgRspnTableBody( value );
		}
	}

	public String getOptionalCsXMsgClientTableBody() {
		return( getTableBuff().getOptionalCsXMsgClientTableBody() );
	}

	public void setOptionalCsXMsgClientTableBody( String value ) {
		if( getTableBuff().getOptionalCsXMsgClientTableBody() != value ) {
			getTableBuff().setOptionalCsXMsgClientTableBody( value );
		}
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchemaDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getTableBuff().getRequiredSchemaDefId() );
				requiredContainerSchemaDef = obj;
				if( obj != null ) {
					getTableBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTableBuff().setRequiredSchemaDefId( obj.getRequiredId() );
					requiredContainerSchemaDef = obj;
				}
			}
		}
		return( requiredContainerSchemaDef );
	}

	public void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTableBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTableBuff().setRequiredSchemaDefId( value.getRequiredId() );
			}
			requiredContainerSchemaDef = value;
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	public ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalDefSchemaTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getTableBuff().getOptionalDefSchemaTenantId(),
					getTableBuff().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	public void setOptionalLookupDefSchema( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalDefSchemaTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalDefSchemaId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalDefSchemaTenantId( null );
				getTableBuff().setOptionalDefSchemaId( null );
			}
			optionalLookupDefSchema = value;
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation() {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getRelationTableObj().readRelationByRelTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getRelationTableObj().readRelationByRelTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex() {
		return( getOptionalLookupLookupIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupLookupIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalLookupIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalLookupIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalLookupIndexTenantId(),
					getTableBuff().getOptionalLookupIndexId() );
				optionalLookupLookupIndex = obj;
			}
		}
		return( optionalLookupLookupIndex );
	}

	public void setOptionalLookupLookupIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalLookupIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalLookupIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalLookupIndexTenantId( null );
				getTableBuff().setOptionalLookupIndexId( null );
			}
			optionalLookupLookupIndex = value;
	}

	public ICFBamIndexObj getOptionalLookupAltIndex() {
		return( getOptionalLookupAltIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupAltIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalAltIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalAltIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalAltIndexTenantId(),
					getTableBuff().getOptionalAltIndexId() );
				optionalLookupAltIndex = obj;
			}
		}
		return( optionalLookupAltIndex );
	}

	public void setOptionalLookupAltIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalAltIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalAltIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalAltIndexTenantId( null );
				getTableBuff().setOptionalAltIndexId( null );
			}
			optionalLookupAltIndex = value;
	}

	public ICFBamTableObj getOptionalLookupQualTable() {
		return( getOptionalLookupQualTable( false ) );
	}

	public ICFBamTableObj getOptionalLookupQualTable( boolean forceRead ) {
		if( forceRead || ( optionalLookupQualTable == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalQualifyingTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalQualifyingTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getTableTableObj().readTableByIdIdx( getTableBuff().getOptionalQualifyingTenantId(),
					getTableBuff().getOptionalQualifyingTableId() );
				optionalLookupQualTable = obj;
			}
		}
		return( optionalLookupQualTable );
	}

	public void setOptionalLookupQualTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalQualifyingTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalQualifyingTableId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalQualifyingTenantId( null );
				getTableBuff().setOptionalQualifyingTableId( null );
			}
			optionalLookupQualTable = value;
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex() {
		List<ICFBamIndexObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getIndexTableObj().readIndexByIdxTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead ) {
		List<ICFBamIndexObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getIndexTableObj().readIndexByIdxTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex() {
		return( getOptionalLookupPrimaryIndex( false ) );
	}

	public ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrimaryIndex == null ) ) {
			boolean anyMissing = false;
			if( getTableBuff().getOptionalPrimaryIndexTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableBuff().getOptionalPrimaryIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamIndexObj obj = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getIndexTableObj().readIndexByIdIdx( getTableBuff().getOptionalPrimaryIndexTenantId(),
					getTableBuff().getOptionalPrimaryIndexId() );
				optionalLookupPrimaryIndex = obj;
			}
		}
		return( optionalLookupPrimaryIndex );
	}

	public void setOptionalLookupPrimaryIndex( ICFBamIndexObj value ) {
			if( buff == null ) {
				getTableBuff();
			}
			if( value != null ) {
				getTableBuff().setOptionalPrimaryIndexTenantId( value.getRequiredTenantId() );
				getTableBuff().setOptionalPrimaryIndexId( value.getRequiredId() );
			}
			else {
				getTableBuff().setOptionalPrimaryIndexTenantId( null );
				getTableBuff().setOptionalPrimaryIndexId( null );
			}
			optionalLookupPrimaryIndex = value;
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns() {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations() {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead ) {
		List<ICFBamRelationObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getRelationTableObj().readRelationByToTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains() {
		List<ICFBamChainObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getChainTableObj().readChainByChainTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead ) {
		List<ICFBamChainObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getChainTableObj().readChainByChainTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep() {
		List<ICFBamDelTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep() {
		List<ICFBamClearTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearTopDepObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen() {
		List<ICFBamId16GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead ) {
		List<ICFBamId16GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId16GenTableObj().readId16GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen() {
		List<ICFBamId32GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead ) {
		List<ICFBamId32GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId32GenTableObj().readId32GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen() {
		List<ICFBamId64GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead ) {
		List<ICFBamId64GenObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getId64GenTableObj().readId64GenByDispIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods() {
		List<ICFBamServerMethodObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead ) {
		List<ICFBamServerMethodObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsTable().getSchema()).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamTableBuff origBuff = getOrigAsTable().getTableBuff();
		CFBamTableBuff myBuff = getTableBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTableBuff origBuff = getOrigAsTable().getTableBuff();
		CFBamTableBuff myBuff = getTableBuff();
		myBuff.set( origBuff );
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
