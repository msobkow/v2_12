// Description: Java 11 edit object instance implementation for CFBam SchemaDef.

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

public class CFBamSchemaDefEditObj
	extends CFBamScopeEditObj

	implements ICFBamSchemaDefEditObj
{
	protected ICFIntMinorVersionObj requiredContainerMinorVersion;
	protected ICFIntLicenseObj optionalLookupDefaultLicense;
	protected ICFSecTenantObj requiredOwnerCTenant;

	public CFBamSchemaDefEditObj( ICFBamSchemaDefObj argOrig ) {
		super( argOrig );
		requiredContainerMinorVersion = null;
		optionalLookupDefaultLicense = null;
		requiredOwnerCTenant = null;
	}

	public String getClassCode() {
		return( CFBamSchemaDefObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaDef" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntMinorVersionObj scope = getRequiredContainerMinorVersion();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntMinorVersionObj scope = getRequiredContainerMinorVersion();
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
			subObj = ((ICFBamSchemaObj)getSchema()).getTableTableObj().readTableByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getValueTableObj().readValueByUNameIdx( getRequiredTenantId(),
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
			else if( container instanceof ICFBamSubProjectObj ) {
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
		ICFBamSchemaDefObj retobj = getSchema().getSchemaDefTableObj().realiseSchemaDef( (ICFBamSchemaDefObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getSchemaDefTableObj().forgetSchemaDef( getOrigAsSchemaDef(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamSchemaDefObj retobj = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getSchemaDefTableObj().createSchemaDef( getOrigAsSchemaDef() );
		if( retobj == getOrigAsSchemaDef() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getSchemaDefTableObj().updateSchemaDef( (ICFBamSchemaDefObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getSchemaDefTableObj().deleteSchemaDef( getOrigAsSchemaDef() );
		return( null );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTable() {
		return( orig.getSchema().getSchemaDefTableObj() );
	}

	public ICFBamSchemaDefEditObj getEditAsSchemaDef() {
		return( (ICFBamSchemaDefEditObj)this );
	}

	public ICFBamSchemaDefObj getOrigAsSchemaDef() {
		return( (ICFBamSchemaDefObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsSchemaDef().getSchema().getBackingStore()).getFactorySchemaDef().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerMinorVersion = null;
			optionalLookupDefaultLicense = null;
			requiredOwnerCTenant = null;
		}
	}

	public CFBamSchemaDefBuff getSchemaDefBuff() {
		return( (CFBamSchemaDefBuff)getBuff() );
	}

	public long getRequiredMinorVersionId() {
		return( getSchemaDefBuff().getRequiredMinorVersionId() );
	}

	public String getRequiredName() {
		return( getSchemaDefBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getSchemaDefBuff().getRequiredName() != value ) {
			getSchemaDefBuff().setRequiredName( value );
		}
	}

	public String getOptionalDbName() {
		return( getSchemaDefBuff().getOptionalDbName() );
	}

	public void setOptionalDbName( String value ) {
		if( getSchemaDefBuff().getOptionalDbName() != value ) {
			getSchemaDefBuff().setOptionalDbName( value );
		}
	}

	public String getOptionalShortName() {
		return( getSchemaDefBuff().getOptionalShortName() );
	}

	public void setOptionalShortName( String value ) {
		if( getSchemaDefBuff().getOptionalShortName() != value ) {
			getSchemaDefBuff().setOptionalShortName( value );
		}
	}

	public String getOptionalLabel() {
		return( getSchemaDefBuff().getOptionalLabel() );
	}

	public void setOptionalLabel( String value ) {
		if( getSchemaDefBuff().getOptionalLabel() != value ) {
			getSchemaDefBuff().setOptionalLabel( value );
		}
	}

	public String getOptionalShortDescription() {
		return( getSchemaDefBuff().getOptionalShortDescription() );
	}

	public void setOptionalShortDescription( String value ) {
		if( getSchemaDefBuff().getOptionalShortDescription() != value ) {
			getSchemaDefBuff().setOptionalShortDescription( value );
		}
	}

	public String getOptionalDescription() {
		return( getSchemaDefBuff().getOptionalDescription() );
	}

	public void setOptionalDescription( String value ) {
		if( getSchemaDefBuff().getOptionalDescription() != value ) {
			getSchemaDefBuff().setOptionalDescription( value );
		}
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() );
	}

	public Long getOptionalDefaultLicenseId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseId() );
	}

	public String getRequiredCopyrightPeriod() {
		return( getSchemaDefBuff().getRequiredCopyrightPeriod() );
	}

	public void setRequiredCopyrightPeriod( String value ) {
		if( getSchemaDefBuff().getRequiredCopyrightPeriod() != value ) {
			getSchemaDefBuff().setRequiredCopyrightPeriod( value );
		}
	}

	public String getRequiredCopyrightHolder() {
		return( getSchemaDefBuff().getRequiredCopyrightHolder() );
	}

	public void setRequiredCopyrightHolder( String value ) {
		if( getSchemaDefBuff().getRequiredCopyrightHolder() != value ) {
			getSchemaDefBuff().setRequiredCopyrightHolder( value );
		}
	}

	public String getRequiredAuthorEMail() {
		return( getSchemaDefBuff().getRequiredAuthorEMail() );
	}

	public void setRequiredAuthorEMail( String value ) {
		if( getSchemaDefBuff().getRequiredAuthorEMail() != value ) {
			getSchemaDefBuff().setRequiredAuthorEMail( value );
		}
	}

	public String getRequiredProjectURL() {
		return( getSchemaDefBuff().getRequiredProjectURL() );
	}

	public void setRequiredProjectURL( String value ) {
		if( getSchemaDefBuff().getRequiredProjectURL() != value ) {
			getSchemaDefBuff().setRequiredProjectURL( value );
		}
	}

	public String getRequiredPublishURI() {
		return( getSchemaDefBuff().getRequiredPublishURI() );
	}

	public void setRequiredPublishURI( String value ) {
		if( getSchemaDefBuff().getRequiredPublishURI() != value ) {
			getSchemaDefBuff().setRequiredPublishURI( value );
		}
	}

	public String getOptionalJSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImport() );
	}

	public void setOptionalJSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjImport( value );
		}
	}

	public String getOptionalJSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalJSchemaObjInterface() );
	}

	public void setOptionalJSchemaObjInterface( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjInterface() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjInterface( value );
		}
	}

	public String getOptionalJSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSchemaObjMembers() );
	}

	public void setOptionalJSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjMembers( value );
		}
	}

	public String getOptionalJSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImplementation() );
	}

	public void setOptionalJSchemaObjImplementation( String value ) {
		if( getSchemaDefBuff().getOptionalJSchemaObjImplementation() != value ) {
			getSchemaDefBuff().setOptionalJSchemaObjImplementation( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() );
	}

	public void setOptionalJDb2LUWSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjMembers( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() );
	}

	public void setOptionalJDb2LUWSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjImpl( value );
		}
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() );
	}

	public void setOptionalJDb2LUWSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJDb2LUWSchemaObjImport( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() );
	}

	public void setOptionalJMSSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() );
	}

	public void setOptionalJMSSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() );
	}

	public void setOptionalJMSSqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJMSSqlSchemaObjImport( value );
		}
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() );
	}

	public void setOptionalJMySqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() );
	}

	public void setOptionalJMySqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() );
	}

	public void setOptionalJMySqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJMySqlSchemaObjImport( value );
		}
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() );
	}

	public void setOptionalJOracleSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjMembers( value );
		}
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() );
	}

	public void setOptionalJOracleSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjImpl( value );
		}
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() );
	}

	public void setOptionalJOracleSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJOracleSchemaObjImport( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() );
	}

	public void setOptionalJPgSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() );
	}

	public void setOptionalJPgSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() );
	}

	public void setOptionalJPgSqlSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJPgSqlSchemaObjImport( value );
		}
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() );
	}

	public void setOptionalJRamSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjMembers( value );
		}
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() );
	}

	public void setOptionalJRamSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjImpl( value );
		}
	}

	public String getOptionalJRamSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImport() );
	}

	public void setOptionalJRamSchemaObjImport( String value ) {
		if( getSchemaDefBuff().getOptionalJRamSchemaObjImport() != value ) {
			getSchemaDefBuff().setOptionalJRamSchemaObjImport( value );
		}
	}

	public String getOptionalJXMsgSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaImport() );
	}

	public void setOptionalJXMsgSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgSchemaImport( value );
		}
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() );
	}

	public void setOptionalJXMsgSchemaFormatters( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() != value ) {
			getSchemaDefBuff().setOptionalJXMsgSchemaFormatters( value );
		}
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() );
	}

	public void setOptionalJXMsgClientSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgClientSchemaImport( value );
		}
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() );
	}

	public void setOptionalJXMsgClientSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgClientSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() );
	}

	public void setOptionalJXMsgRqstSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() );
	}

	public void setOptionalJXMsgRqstSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaImport( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() );
	}

	public void setOptionalJXMsgRqstSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaWireParsers( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() );
	}

	public void setOptionalJXMsgRqstSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaXsdSpec( value );
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() );
	}

	public void setOptionalJXMsgRqstSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRqstSchemaXsdElementList( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() );
	}

	public void setOptionalJXMsgRspnSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaBody( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() );
	}

	public void setOptionalJXMsgRspnSchemaImport( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaImport( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() );
	}

	public void setOptionalJXMsgRspnSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaWireParsers( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() );
	}

	public void setOptionalJXMsgRspnSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaXsdElementList( value );
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() );
	}

	public void setOptionalJXMsgRspnSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalJXMsgRspnSchemaXsdSpec( value );
		}
	}

	public String getOptionalCppSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjInclude() );
	}

	public void setOptionalCppSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppSchemaObjInclude( value );
		}
	}

	public String getOptionalCppSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjInterface() );
	}

	public void setOptionalCppSchemaObjInterface( String value ) {
		if( getSchemaDefBuff().getOptionalCppSchemaObjInterface() != value ) {
			getSchemaDefBuff().setOptionalCppSchemaObjInterface( value );
		}
	}

	public String getOptionalCppSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjMembers() );
	}

	public void setOptionalCppSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppSchemaObjMembers( value );
		}
	}

	public String getOptionalCppSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjImplementation() );
	}

	public void setOptionalCppSchemaObjImplementation( String value ) {
		if( getSchemaDefBuff().getOptionalCppSchemaObjImplementation() != value ) {
			getSchemaDefBuff().setOptionalCppSchemaObjImplementation( value );
		}
	}

	public String getOptionalCppDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjMembers() );
	}

	public void setOptionalCppDb2LUWSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppDb2LUWSchemaObjMembers( value );
		}
	}

	public String getOptionalCppDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjImpl() );
	}

	public void setOptionalCppDb2LUWSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppDb2LUWSchemaObjImpl( value );
		}
	}

	public String getOptionalCppDb2LUWSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjInclude() );
	}

	public void setOptionalCppDb2LUWSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppDb2LUWSchemaObjInclude( value );
		}
	}

	public String getOptionalCppMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjMembers() );
	}

	public void setOptionalCppMSSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppMSSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCppMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjImpl() );
	}

	public void setOptionalCppMSSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppMSSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCppMSSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjInclude() );
	}

	public void setOptionalCppMSSqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppMSSqlSchemaObjInclude( value );
		}
	}

	public String getOptionalCppMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjMembers() );
	}

	public void setOptionalCppMySqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppMySqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppMySqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCppMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjImpl() );
	}

	public void setOptionalCppMySqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppMySqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppMySqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCppMySqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjInclude() );
	}

	public void setOptionalCppMySqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppMySqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppMySqlSchemaObjInclude( value );
		}
	}

	public String getOptionalCppOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjMembers() );
	}

	public void setOptionalCppOracleSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppOracleSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppOracleSchemaObjMembers( value );
		}
	}

	public String getOptionalCppOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjImpl() );
	}

	public void setOptionalCppOracleSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppOracleSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppOracleSchemaObjImpl( value );
		}
	}

	public String getOptionalCppOracleSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjInclude() );
	}

	public void setOptionalCppOracleSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppOracleSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppOracleSchemaObjInclude( value );
		}
	}

	public String getOptionalCppPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjMembers() );
	}

	public void setOptionalCppPgSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppPgSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCppPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjImpl() );
	}

	public void setOptionalCppPgSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppPgSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCppPgSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjInclude() );
	}

	public void setOptionalCppPgSqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppPgSqlSchemaObjInclude( value );
		}
	}

	public String getOptionalCppRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjMembers() );
	}

	public void setOptionalCppRamSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCppRamSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCppRamSchemaObjMembers( value );
		}
	}

	public String getOptionalCppRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjImpl() );
	}

	public void setOptionalCppRamSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCppRamSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCppRamSchemaObjImpl( value );
		}
	}

	public String getOptionalCppRamSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjInclude() );
	}

	public void setOptionalCppRamSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppRamSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalCppRamSchemaObjInclude( value );
		}
	}

	public String getOptionalCppXMsgSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgSchemaInclude() );
	}

	public void setOptionalCppXMsgSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgSchemaInclude( value );
		}
	}

	public String getOptionalCppXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalCppXMsgSchemaFormatters() );
	}

	public void setOptionalCppXMsgSchemaFormatters( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgSchemaFormatters() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgSchemaFormatters( value );
		}
	}

	public String getOptionalCppXMsgClientSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgClientSchemaInclude() );
	}

	public void setOptionalCppXMsgClientSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgClientSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgClientSchemaInclude( value );
		}
	}

	public String getOptionalCppXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgClientSchemaBody() );
	}

	public void setOptionalCppXMsgClientSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgClientSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgClientSchemaBody( value );
		}
	}

	public String getOptionalCppXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaBody() );
	}

	public void setOptionalCppXMsgRqstSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRqstSchemaBody( value );
		}
	}

	public String getOptionalCppXMsgRqstSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaInclude() );
	}

	public void setOptionalCppXMsgRqstSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRqstSchemaInclude( value );
		}
	}

	public String getOptionalCppXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaWireParsers() );
	}

	public void setOptionalCppXMsgRqstSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRqstSchemaWireParsers( value );
		}
	}

	public String getOptionalCppXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdSpec() );
	}

	public void setOptionalCppXMsgRqstSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRqstSchemaXsdSpec( value );
		}
	}

	public String getOptionalCppXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdElementList() );
	}

	public void setOptionalCppXMsgRqstSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRqstSchemaXsdElementList( value );
		}
	}

	public String getOptionalCppXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaBody() );
	}

	public void setOptionalCppXMsgRspnSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRspnSchemaBody( value );
		}
	}

	public String getOptionalCppXMsgRspnSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaInclude() );
	}

	public void setOptionalCppXMsgRspnSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRspnSchemaInclude( value );
		}
	}

	public String getOptionalCppXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaWireParsers() );
	}

	public void setOptionalCppXMsgRspnSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRspnSchemaWireParsers( value );
		}
	}

	public String getOptionalCppXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdElementList() );
	}

	public void setOptionalCppXMsgRspnSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRspnSchemaXsdElementList( value );
		}
	}

	public String getOptionalCppXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdSpec() );
	}

	public void setOptionalCppXMsgRspnSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalCppXMsgRspnSchemaXsdSpec( value );
		}
	}

	public String getOptionalHppSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjInclude() );
	}

	public void setOptionalHppSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppSchemaObjInclude( value );
		}
	}

	public String getOptionalHppSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjInterface() );
	}

	public void setOptionalHppSchemaObjInterface( String value ) {
		if( getSchemaDefBuff().getOptionalHppSchemaObjInterface() != value ) {
			getSchemaDefBuff().setOptionalHppSchemaObjInterface( value );
		}
	}

	public String getOptionalHppSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjMembers() );
	}

	public void setOptionalHppSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppSchemaObjMembers( value );
		}
	}

	public String getOptionalHppSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjImplementation() );
	}

	public void setOptionalHppSchemaObjImplementation( String value ) {
		if( getSchemaDefBuff().getOptionalHppSchemaObjImplementation() != value ) {
			getSchemaDefBuff().setOptionalHppSchemaObjImplementation( value );
		}
	}

	public String getOptionalHppDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjMembers() );
	}

	public void setOptionalHppDb2LUWSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppDb2LUWSchemaObjMembers( value );
		}
	}

	public String getOptionalHppDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjImpl() );
	}

	public void setOptionalHppDb2LUWSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppDb2LUWSchemaObjImpl( value );
		}
	}

	public String getOptionalHppDb2LUWSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjInclude() );
	}

	public void setOptionalHppDb2LUWSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppDb2LUWSchemaObjInclude( value );
		}
	}

	public String getOptionalHppMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjMembers() );
	}

	public void setOptionalHppMSSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppMSSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalHppMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjImpl() );
	}

	public void setOptionalHppMSSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppMSSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalHppMSSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjInclude() );
	}

	public void setOptionalHppMSSqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppMSSqlSchemaObjInclude( value );
		}
	}

	public String getOptionalHppMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjMembers() );
	}

	public void setOptionalHppMySqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppMySqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppMySqlSchemaObjMembers( value );
		}
	}

	public String getOptionalHppMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjImpl() );
	}

	public void setOptionalHppMySqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppMySqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppMySqlSchemaObjImpl( value );
		}
	}

	public String getOptionalHppMySqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjInclude() );
	}

	public void setOptionalHppMySqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppMySqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppMySqlSchemaObjInclude( value );
		}
	}

	public String getOptionalHppOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjMembers() );
	}

	public void setOptionalHppOracleSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppOracleSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppOracleSchemaObjMembers( value );
		}
	}

	public String getOptionalHppOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjImpl() );
	}

	public void setOptionalHppOracleSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppOracleSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppOracleSchemaObjImpl( value );
		}
	}

	public String getOptionalHppOracleSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjInclude() );
	}

	public void setOptionalHppOracleSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppOracleSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppOracleSchemaObjInclude( value );
		}
	}

	public String getOptionalHppPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjMembers() );
	}

	public void setOptionalHppPgSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppPgSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalHppPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjImpl() );
	}

	public void setOptionalHppPgSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppPgSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalHppPgSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjInclude() );
	}

	public void setOptionalHppPgSqlSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppPgSqlSchemaObjInclude( value );
		}
	}

	public String getOptionalHppRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjMembers() );
	}

	public void setOptionalHppRamSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalHppRamSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalHppRamSchemaObjMembers( value );
		}
	}

	public String getOptionalHppRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjImpl() );
	}

	public void setOptionalHppRamSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalHppRamSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalHppRamSchemaObjImpl( value );
		}
	}

	public String getOptionalHppRamSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjInclude() );
	}

	public void setOptionalHppRamSchemaObjInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppRamSchemaObjInclude() != value ) {
			getSchemaDefBuff().setOptionalHppRamSchemaObjInclude( value );
		}
	}

	public String getOptionalHppXMsgSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgSchemaInclude() );
	}

	public void setOptionalHppXMsgSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgSchemaInclude( value );
		}
	}

	public String getOptionalHppXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalHppXMsgSchemaFormatters() );
	}

	public void setOptionalHppXMsgSchemaFormatters( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgSchemaFormatters() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgSchemaFormatters( value );
		}
	}

	public String getOptionalHppXMsgClientSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgClientSchemaInclude() );
	}

	public void setOptionalHppXMsgClientSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgClientSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgClientSchemaInclude( value );
		}
	}

	public String getOptionalHppXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgClientSchemaBody() );
	}

	public void setOptionalHppXMsgClientSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgClientSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgClientSchemaBody( value );
		}
	}

	public String getOptionalHppXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaBody() );
	}

	public void setOptionalHppXMsgRqstSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRqstSchemaBody( value );
		}
	}

	public String getOptionalHppXMsgRqstSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaInclude() );
	}

	public void setOptionalHppXMsgRqstSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRqstSchemaInclude( value );
		}
	}

	public String getOptionalHppXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaWireParsers() );
	}

	public void setOptionalHppXMsgRqstSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRqstSchemaWireParsers( value );
		}
	}

	public String getOptionalHppXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdSpec() );
	}

	public void setOptionalHppXMsgRqstSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRqstSchemaXsdSpec( value );
		}
	}

	public String getOptionalHppXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdElementList() );
	}

	public void setOptionalHppXMsgRqstSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRqstSchemaXsdElementList( value );
		}
	}

	public String getOptionalHppXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaBody() );
	}

	public void setOptionalHppXMsgRspnSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRspnSchemaBody( value );
		}
	}

	public String getOptionalHppXMsgRspnSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaInclude() );
	}

	public void setOptionalHppXMsgRspnSchemaInclude( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaInclude() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRspnSchemaInclude( value );
		}
	}

	public String getOptionalHppXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaWireParsers() );
	}

	public void setOptionalHppXMsgRspnSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRspnSchemaWireParsers( value );
		}
	}

	public String getOptionalHppXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdElementList() );
	}

	public void setOptionalHppXMsgRspnSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRspnSchemaXsdElementList( value );
		}
	}

	public String getOptionalHppXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdSpec() );
	}

	public void setOptionalHppXMsgRspnSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalHppXMsgRspnSchemaXsdSpec( value );
		}
	}

	public String getOptionalCsSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjUsing() );
	}

	public void setOptionalCsSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsSchemaObjUsing( value );
		}
	}

	public String getOptionalCsSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjInterface() );
	}

	public void setOptionalCsSchemaObjInterface( String value ) {
		if( getSchemaDefBuff().getOptionalCsSchemaObjInterface() != value ) {
			getSchemaDefBuff().setOptionalCsSchemaObjInterface( value );
		}
	}

	public String getOptionalCsSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjMembers() );
	}

	public void setOptionalCsSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsSchemaObjMembers( value );
		}
	}

	public String getOptionalCsSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjImplementation() );
	}

	public void setOptionalCsSchemaObjImplementation( String value ) {
		if( getSchemaDefBuff().getOptionalCsSchemaObjImplementation() != value ) {
			getSchemaDefBuff().setOptionalCsSchemaObjImplementation( value );
		}
	}

	public String getOptionalCsDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjMembers() );
	}

	public void setOptionalCsDb2LUWSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsDb2LUWSchemaObjMembers( value );
		}
	}

	public String getOptionalCsDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjImpl() );
	}

	public void setOptionalCsDb2LUWSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsDb2LUWSchemaObjImpl( value );
		}
	}

	public String getOptionalCsDb2LUWSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjUsing() );
	}

	public void setOptionalCsDb2LUWSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsDb2LUWSchemaObjUsing( value );
		}
	}

	public String getOptionalCsMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjMembers() );
	}

	public void setOptionalCsMSSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsMSSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCsMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjImpl() );
	}

	public void setOptionalCsMSSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsMSSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCsMSSqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjUsing() );
	}

	public void setOptionalCsMSSqlSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsMSSqlSchemaObjUsing( value );
		}
	}

	public String getOptionalCsMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjMembers() );
	}

	public void setOptionalCsMySqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsMySqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsMySqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCsMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjImpl() );
	}

	public void setOptionalCsMySqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsMySqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsMySqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCsMySqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjUsing() );
	}

	public void setOptionalCsMySqlSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsMySqlSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsMySqlSchemaObjUsing( value );
		}
	}

	public String getOptionalCsOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjMembers() );
	}

	public void setOptionalCsOracleSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsOracleSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsOracleSchemaObjMembers( value );
		}
	}

	public String getOptionalCsOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjImpl() );
	}

	public void setOptionalCsOracleSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsOracleSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsOracleSchemaObjImpl( value );
		}
	}

	public String getOptionalCsOracleSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjUsing() );
	}

	public void setOptionalCsOracleSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsOracleSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsOracleSchemaObjUsing( value );
		}
	}

	public String getOptionalCsPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjMembers() );
	}

	public void setOptionalCsPgSqlSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsPgSqlSchemaObjMembers( value );
		}
	}

	public String getOptionalCsPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjImpl() );
	}

	public void setOptionalCsPgSqlSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsPgSqlSchemaObjImpl( value );
		}
	}

	public String getOptionalCsPgSqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjUsing() );
	}

	public void setOptionalCsPgSqlSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsPgSqlSchemaObjUsing( value );
		}
	}

	public String getOptionalCsRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjMembers() );
	}

	public void setOptionalCsRamSchemaObjMembers( String value ) {
		if( getSchemaDefBuff().getOptionalCsRamSchemaObjMembers() != value ) {
			getSchemaDefBuff().setOptionalCsRamSchemaObjMembers( value );
		}
	}

	public String getOptionalCsRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjImpl() );
	}

	public void setOptionalCsRamSchemaObjImpl( String value ) {
		if( getSchemaDefBuff().getOptionalCsRamSchemaObjImpl() != value ) {
			getSchemaDefBuff().setOptionalCsRamSchemaObjImpl( value );
		}
	}

	public String getOptionalCsRamSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjUsing() );
	}

	public void setOptionalCsRamSchemaObjUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsRamSchemaObjUsing() != value ) {
			getSchemaDefBuff().setOptionalCsRamSchemaObjUsing( value );
		}
	}

	public String getOptionalCsXMsgSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgSchemaUsing() );
	}

	public void setOptionalCsXMsgSchemaUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgSchemaUsing() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgSchemaUsing( value );
		}
	}

	public String getOptionalCsXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalCsXMsgSchemaFormatters() );
	}

	public void setOptionalCsXMsgSchemaFormatters( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgSchemaFormatters() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgSchemaFormatters( value );
		}
	}

	public String getOptionalCsXMsgClientSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgClientSchemaUsing() );
	}

	public void setOptionalCsXMsgClientSchemaUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgClientSchemaUsing() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgClientSchemaUsing( value );
		}
	}

	public String getOptionalCsXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgClientSchemaBody() );
	}

	public void setOptionalCsXMsgClientSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgClientSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgClientSchemaBody( value );
		}
	}

	public String getOptionalCsXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaBody() );
	}

	public void setOptionalCsXMsgRqstSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRqstSchemaBody( value );
		}
	}

	public String getOptionalCsXMsgRqstSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaUsing() );
	}

	public void setOptionalCsXMsgRqstSchemaUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaUsing() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRqstSchemaUsing( value );
		}
	}

	public String getOptionalCsXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaWireParsers() );
	}

	public void setOptionalCsXMsgRqstSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRqstSchemaWireParsers( value );
		}
	}

	public String getOptionalCsXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdSpec() );
	}

	public void setOptionalCsXMsgRqstSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRqstSchemaXsdSpec( value );
		}
	}

	public String getOptionalCsXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdElementList() );
	}

	public void setOptionalCsXMsgRqstSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRqstSchemaXsdElementList( value );
		}
	}

	public String getOptionalCsXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaBody() );
	}

	public void setOptionalCsXMsgRspnSchemaBody( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaBody() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRspnSchemaBody( value );
		}
	}

	public String getOptionalCsXMsgRspnSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaUsing() );
	}

	public void setOptionalCsXMsgRspnSchemaUsing( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaUsing() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRspnSchemaUsing( value );
		}
	}

	public String getOptionalCsXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaWireParsers() );
	}

	public void setOptionalCsXMsgRspnSchemaWireParsers( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaWireParsers() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRspnSchemaWireParsers( value );
		}
	}

	public String getOptionalCsXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdElementList() );
	}

	public void setOptionalCsXMsgRspnSchemaXsdElementList( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdElementList() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRspnSchemaXsdElementList( value );
		}
	}

	public String getOptionalCsXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdSpec() );
	}

	public void setOptionalCsXMsgRspnSchemaXsdSpec( String value ) {
		if( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdSpec() != value ) {
			getSchemaDefBuff().setOptionalCsXMsgRspnSchemaXsdSpec( value );
		}
	}

	public ICFIntMinorVersionObj getRequiredContainerMinorVersion() {
		return( getRequiredContainerMinorVersion( false ) );
	}

	public ICFIntMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead ) {
		if( forceRead || ( requiredContainerMinorVersion == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFIntMinorVersionObj obj = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getMinorVersionTableObj().readMinorVersionByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaDefBuff().getRequiredMinorVersionId() );
				requiredContainerMinorVersion = obj;
				if( obj != null ) {
					getSchemaDefBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getSchemaDefBuff().setRequiredMinorVersionId( obj.getRequiredId() );
					requiredContainerMinorVersion = obj;
				}
			}
		}
		return( requiredContainerMinorVersion );
	}

	public void setRequiredContainerMinorVersion( ICFIntMinorVersionObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setRequiredMinorVersionId( value.getRequiredId() );
			}
			requiredContainerMinorVersion = value;
	}

	public List<ICFBamTableObj> getOptionalComponentsTables() {
		List<ICFBamTableObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead ) {
		List<ICFBamTableObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes() {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFIntLicenseObj getOptionalLookupDefaultLicense() {
		return( getOptionalLookupDefaultLicense( false ) );
	}

	public ICFIntLicenseObj getOptionalLookupDefaultLicense( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefaultLicense == null ) ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaDefBuff().getOptionalDefaultLicenseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFIntLicenseObj obj = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getLicenseTableObj().readLicenseByIdIdx( getSchemaDefBuff().getOptionalDefaultLicenseTenantId(),
					getSchemaDefBuff().getOptionalDefaultLicenseId() );
				optionalLookupDefaultLicense = obj;
			}
		}
		return( optionalLookupDefaultLicense );
	}

	public void setOptionalLookupDefaultLicense( ICFIntLicenseObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getSchemaDefBuff().setOptionalDefaultLicenseTenantId( value.getRequiredTenantId() );
				getSchemaDefBuff().setOptionalDefaultLicenseId( value.getRequiredId() );
			}
			else {
				getSchemaDefBuff().setOptionalDefaultLicenseTenantId( null );
				getSchemaDefBuff().setOptionalDefaultLicenseId( null );
			}
			optionalLookupDefaultLicense = value;
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs() {
		List<ICFBamSchemaRefObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead ) {
		List<ICFBamSchemaRefObj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerCTenant() {
		return( getRequiredOwnerCTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerCTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFSecTenantObj obj = ((ICFBamSchemaObj)getOrigAsSchemaDef().getSchema()).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId() );
				requiredOwnerCTenant = obj;
			}
		}
		return( requiredOwnerCTenant );
	}

	public void setRequiredOwnerCTenant( ICFSecTenantObj value ) {
			if( buff == null ) {
				getSchemaDefBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredId() );
				getSchemaDefBuff().setRequiredTenantId( value.getRequiredId() );
			}
			requiredOwnerCTenant = value;
			super.setRequiredOwnerTenant( value );
	}

	public void copyBuffToOrig() {
		CFBamSchemaDefBuff origBuff = getOrigAsSchemaDef().getSchemaDefBuff();
		CFBamSchemaDefBuff myBuff = getSchemaDefBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamSchemaDefBuff origBuff = getOrigAsSchemaDef().getSchemaDefBuff();
		CFBamSchemaDefBuff myBuff = getSchemaDefBuff();
		myBuff.set( origBuff );
	}
}
