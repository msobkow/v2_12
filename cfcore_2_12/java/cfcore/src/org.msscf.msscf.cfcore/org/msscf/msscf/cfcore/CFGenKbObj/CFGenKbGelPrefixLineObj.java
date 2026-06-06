// Description: Java 11 base object instance implementation for CFGenKb GelPrefixLine.

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
import org.msscf.msscf.cfcore.MssCF.*;

public class CFGenKbGelPrefixLineObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelPrefixLineObj
{
	public final static String CLASS_CODE = "GPFX";
	protected ICFGenKbGelInstructionObj optionalLookupRemainder;

	public CFGenKbGelPrefixLineObj() {
		super();
		optionalLookupRemainder = null;
	}

	public CFGenKbGelPrefixLineObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupRemainder = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelPrefixLine" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredGelInstId();
		objName = Long.toString( val );
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

	public ICFGenKbGelInstructionObj realise() {
		ICFGenKbGelPrefixLineObj retobj = ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().realiseGelPrefixLine(
			(ICFGenKbGelPrefixLineObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().forgetGelPrefixLine( (ICFGenKbGelPrefixLineObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelPrefixLineObj retobj = ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().readGelPrefixLineByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelPrefixLineObj retobj = ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().readGelPrefixLineByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelPrefixLineTableObj getGelPrefixLineTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelPrefixLine().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelPrefixLine().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredGelCacheId(),
						getPKey().getRequiredGelInstId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelPrefixLineBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelPrefixLineBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
		optionalLookupRemainder = null;
	}

	public CFGenKbGelPrefixLineBuff getGelPrefixLineBuff() {
		return( (CFGenKbGelPrefixLineBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelPrefixLineObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelPrefixLineObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().lockGelPrefixLine( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelPrefixLineTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelPrefixLineEditObj getEditAsGelPrefixLine() {
		return( (ICFGenKbGelPrefixLineEditObj)edit );
	}

	public String getRequiredPrefixName() {
		return( getGelPrefixLineBuff().getRequiredPrefixName() );
	}

	public Long getOptionalRemainderTenantId() {
		return( getGelPrefixLineBuff().getOptionalRemainderTenantId() );
	}

	public long getRequiredRemainderGelCacheId() {
		return( getGelPrefixLineBuff().getRequiredRemainderGelCacheId() );
	}

	public Long getOptionalRemainderInstId() {
		return( getGelPrefixLineBuff().getOptionalRemainderInstId() );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder() {
		return( getOptionalLookupRemainder( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupRemainder( boolean forceRead ) {
		if( ( optionalLookupRemainder == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGelPrefixLineBuff().getOptionalRemainderTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelPrefixLineBuff().getOptionalRemainderInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupRemainder = ((ICFGenKbSchemaObj)schema).getGelInstructionTableObj().readGelInstructionByPIdx( getGelPrefixLineBuff().getOptionalRemainderTenantId(),
					getGelPrefixLineBuff().getRequiredRemainderGelCacheId(),
					getGelPrefixLineBuff().getOptionalRemainderInstId(), forceRead );
			}
		}
		return( optionalLookupRemainder );
	}

	public String expand( MssCFGenContext genContext ) {
		final String S_ProcName = "CFGenKbGelPrefixLineObj.expand() ";

		String prefixName = getRequiredPrefixName();
		if( ( prefixName == null ) || ( prefixName.length() == 0 ) ) {
			throw new RuntimeException( S_ProcName + "Required PrefixName was not specified" );
		}

		String prefixStrValue;
		ICFGenKbGenItemObj prefixItem = genContext.getGenEngine().findContextItem(genContext, prefixName );
		if( prefixItem == null ) {
			throw new RuntimeException( S_ProcName + "Could not resolve prefix \"" + prefixName + "\", $" + getRequiredSourceText() + "$ is invalid" );
		}

		if( prefixItem instanceof MssCFGenFileObj ) {
			prefixStrValue = ((MssCFGenFileObj)prefixItem).expandBody( genContext );
		}
		else if( prefixItem instanceof MssCFGenRuleObj ) {
			prefixStrValue = ((MssCFGenRuleObj)prefixItem).expandBody( genContext );
		}
		else if (prefixItem instanceof MssCFGenTruncObj)
		{
			prefixStrValue = ((MssCFGenTruncObj)prefixItem).expandBody( genContext );
		}
		else if (prefixItem instanceof MssCFGenBindObj)
		{
			prefixStrValue = ((MssCFGenBindObj)prefixItem).expandBody( genContext );
		}
		else if( prefixItem instanceof MssCFGenReferenceObj ) {
			throw new RuntimeException(S_ProcName + "Cannot expand reference " + prefixItem.getRequiredName() + " directly");
		}
		else if( prefixItem instanceof MssCFGenIteratorObj ) {
			prefixStrValue = ((MssCFGenIteratorObj)prefixItem).expandBody( genContext );
		}
		else {
			throw new RuntimeException( S_ProcName +  "Unsupported generation item class" );
		}

		if( prefixStrValue == null ) {
			prefixStrValue = "$" + prefixName + "$";
		}

		ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
		if( remainder == null ) {
			throw new RuntimeException( S_ProcName + "Remainder of macro was not properly compiled" );
		}

		String body = remainder.expand( genContext );
		if (body == null) {
			body = "$" + remainder.getRequiredSourceText() + "$";
		}

		String retval = prefixStrValue + body.replace("\n", "\n" + prefixStrValue );

		return( retval );
	}
}
