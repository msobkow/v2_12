// Description: Java 11 base object instance implementation for CFGenKb GelExpansion.

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

public class CFGenKbGelExpansionObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelExpansionObj
{
	public final static String CLASS_CODE = "GEXP";

	public CFGenKbGelExpansionObj() {
		super();
	}

	public CFGenKbGelExpansionObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelExpansion" );
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
		ICFGenKbGelExpansionObj retobj = ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().realiseGelExpansion(
			(ICFGenKbGelExpansionObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().forgetGelExpansion( (ICFGenKbGelExpansionObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelExpansionObj retobj = ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().readGelExpansionByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelExpansionObj retobj = ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().readGelExpansionByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelExpansionTableObj getGelExpansionTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelExpansion().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelExpansion().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelExpansionBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelExpansionBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelExpansionBuff getGelExpansionBuff() {
		return( (CFGenKbGelExpansionBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelExpansionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelExpansionObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().lockGelExpansion( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelExpansionTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelExpansionEditObj getEditAsGelExpansion() {
		return( (ICFGenKbGelExpansionEditObj)edit );
	}

	public String getRequiredMacroName() {
		return( getGelExpansionBuff().getRequiredMacroName() );
	}

	public String expand( MssCFGenContext genContext ) {
		String retval;
		final String S_ProcName = "CFGenKbGelExpansion.expand() ";
		ICFGenKbGenItemObj genItem = genContext.getGenEngine().findContextItem(genContext, getRequiredMacroName() );
		if( genItem != null ) {
			if( genItem instanceof MssCFGenFileObj ) {
				retval = ((MssCFGenFileObj)genItem).expandBody( genContext );
			}
			else if( genItem instanceof MssCFGenRuleObj ) {
				retval = ((MssCFGenRuleObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenTruncObj)
			{
				retval = ((MssCFGenTruncObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenBindObj)
			{
				retval = ((MssCFGenBindObj)genItem).expandBody( genContext );
			}
			else if( genItem instanceof MssCFGenReferenceObj ) {
				throw new RuntimeException(S_ProcName + "Cannot expand reference " + genItem.getRequiredName() + " directly");
			}
			else if( genItem instanceof MssCFGenIteratorObj ) {
				retval = ((MssCFGenIteratorObj)genItem).expandBody( genContext );
			}
			else {
				throw new RuntimeException( S_ProcName +  "Unsupported generation item class" );
			}
		}
		else {
			retval = "$" + getRequiredMacroName() + "$";
		}
		return( retval );
	}
}
