// Description: Java 11 base object instance implementation for CFGenKb GenRule.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGelCompiler;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public class CFGenKbGenRuleObj
	extends CFGenKbGenItemObj
	implements ICFGenKbGenRuleObj
{
	public final static String CLASS_CODE = "RUL";
	protected ICFGenKbGelExecutableObj optionalComponentsBodyGel;

	public CFGenKbGenRuleObj() {
		super();
	}

	public CFGenKbGenRuleObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GenRule" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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

	public ICFGenKbGenItemObj realise() {
		ICFGenKbGenRuleObj retobj = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().realiseGenRule(
			(ICFGenKbGenRuleObj)this );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGenRuleTableObj().forgetGenRule( (ICFGenKbGenRuleObj)this, forgetSubObjects );
	}

	public ICFGenKbGenItemObj read() {
		ICFGenKbGenRuleObj retobj = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().readGenRuleByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), false );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenItemObj read( boolean forceRead ) {
		ICFGenKbGenRuleObj retobj = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().readGenRuleByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), forceRead );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenRuleTableObj getGenRuleTable() {
		return( ((ICFGenKbSchemaObj)schema).getGenRuleTableObj() );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenRule().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenRule().readDerivedByItemIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredCartridgeId(),
						getPKey().getRequiredItemId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGenRuleBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGenRuleBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public CFGenKbGenRuleBuff getGenRuleBuff() {
		return( (CFGenKbGenRuleBuff)getBuff() );
	}

	public ICFGenKbGenItemEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGenRuleObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGenRuleObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().lockGenRule( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGenRuleTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGenItemEditObj)edit );
	}

	public ICFGenKbGenRuleEditObj getEditAsGenRule() {
		return( (ICFGenKbGenRuleEditObj)edit );
	}

	public String getRequiredDefinedNear() {
		return( getGenRuleBuff().getRequiredDefinedNear() );
	}

	public String getRequiredBody() {
		return( getGenRuleBuff().getRequiredBody() );
	}

	public Long getOptionalBodyTenantId() {
		return( getGenRuleBuff().getOptionalBodyTenantId() );
	}

	public Long getOptionalBodyGelCacheId() {
		return( getGenRuleBuff().getOptionalBodyGelCacheId() );
	}

	public Long getOptionalBodyGelId() {
		return( getGenRuleBuff().getOptionalBodyGelId() );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBodyGel() {
		return( getOptionalComponentsBodyGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBodyGel( boolean forceRead ) {
		if( ( optionalComponentsBodyGel == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGenRuleBuff().getOptionalBodyTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenRuleBuff().getOptionalBodyGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenRuleBuff().getOptionalBodyGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalComponentsBodyGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenRuleBuff().getOptionalBodyTenantId(),
					getGenRuleBuff().getOptionalBodyGelCacheId(),
					getGenRuleBuff().getOptionalBodyGelId(), forceRead );
			}
		}
		return( optionalComponentsBodyGel );
	}

	public static ICFGenKbGelExecutableObj getBodyBin( MssCFGelCompiler gelCompiler, ICFGenKbGenRuleObj genRule ) {
		final String S_ProcName = "CFGenKbGenRuleObj.getBodyBin() ";
		ICFGenKbGelExecutableObj bin = genRule.getOptionalComponentsBodyGel();
		if( bin == null ) {
			String execName = genRule.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genRule.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genRule.getOptionalLookupScopeDef() == null ) ? "Object" : genRule.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genRule.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genRule.getRequiredName()
				+ "::Body";
			String source = genRule.getRequiredBody();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile Body GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenRuleEditObj editRule = genRule.getEditAsGenRule();
			if( editRule != null ) {
				editRule.setOptionalComponentsBodyGel( bin );
			}
			else {
				editRule = (ICFGenKbGenRuleEditObj)genRule.beginEdit();
				editRule.setOptionalComponentsBodyGel( bin );
				editRule.update();
				editRule = null;
			}
		}
		return( bin );
	}
}
