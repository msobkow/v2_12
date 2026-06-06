// Description: Java 11 base object instance implementation for CFGenKb GelSwitch.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbGelSwitchObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelSwitchObj
{
	public final static String CLASS_CODE = "GSWT";

	public CFGenKbGelSwitchObj() {
		super();
	}

	public CFGenKbGelSwitchObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelSwitch" );
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
		ICFGenKbGelSwitchObj retobj = ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().realiseGelSwitch(
			(ICFGenKbGelSwitchObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().forgetGelSwitch( (ICFGenKbGelSwitchObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelSwitchObj retobj = ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().readGelSwitchByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelSwitchObj retobj = ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().readGelSwitchByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelSwitchTableObj getGelSwitchTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSwitch().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSwitch().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelSwitchBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelSwitchBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelSwitchBuff getGelSwitchBuff() {
		return( (CFGenKbGelSwitchBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelSwitchObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelSwitchObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().lockGelSwitch( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelSwitchTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelSwitchEditObj getEditAsGelSwitch() {
		return( (ICFGenKbGelSwitchEditObj)edit );
	}

	public String getRequiredValueExpansion() {
		return( getGelSwitchBuff().getRequiredValueExpansion() );
	}

	public String getOptionalNilExpansion() {
		return( getGelSwitchBuff().getOptionalNilExpansion() );
	}

	public String getOptionalEmptyExpansion() {
		return( getGelSwitchBuff().getOptionalEmptyExpansion() );
	}

	public String getRequiredDefaultExpansion() {
		return( getGelSwitchBuff().getRequiredDefaultExpansion() );
	}

	public List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb() {
		List<ICFGenKbGelSwitchLimbObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getGelSwitchLimbTableObj().readGelSwitchLimbBySwitchIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			false );
		return( retval );
	}

	public List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb( boolean forceRead ) {
		List<ICFGenKbGelSwitchLimbObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getGelSwitchLimbTableObj().readGelSwitchLimbBySwitchIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			forceRead );
		return( retval );
	}

	public String expand( MssCFGenContext genContext ) {
		final String S_ProcName = "CFGenKbGelSwitchObj.expand() ";

		String valueExpansion = getRequiredValueExpansion();
		if( ( valueExpansion == null ) || ( valueExpansion.length() == 0 ) ) {
			throw new RuntimeException( S_ProcName + "ValueExpansion was not properly set" );
		}

		ICFGenKbGenItemObj valueItem = genContext.getGenEngine().findContextItem(genContext, valueExpansion );
		if( valueItem == null ) {
			throw new RuntimeException( S_ProcName + "Could not resolve Value expansion \"" + valueExpansion + "\"" );
		}

		String valueStrValue;
		if( valueItem instanceof MssCFGenFileObj ) {
			valueStrValue = ((MssCFGenFileObj)valueItem).expandBody( genContext );
		}
		else if( valueItem instanceof MssCFGenRuleObj ) {
			valueStrValue = ((MssCFGenRuleObj)valueItem).expandBody( genContext );
		}
		else if (valueItem instanceof MssCFGenTruncObj) {
			valueStrValue = ((MssCFGenTruncObj)valueItem).expandBody( genContext );
		}
		else if (valueItem instanceof MssCFGenBindObj) {
			valueStrValue = ((MssCFGenBindObj)valueItem).expandBody( genContext );
		}
		else if( valueItem instanceof MssCFGenReferenceObj ) {
			throw new RuntimeException(S_ProcName + "Cannot expand reference " + valueItem.getRequiredName() + " directly");
		}
		else if( valueItem instanceof MssCFGenIteratorObj ) {
			valueStrValue = ((MssCFGenIteratorObj)valueItem).expandBody( genContext );
		}
		else {
			throw new RuntimeException( S_ProcName +  "Unsupported generation item class" );
		}

		//	If null was returned, invoke either the nil or default macro
		//	and return the result

		String retval;
		if( valueStrValue == null ) {

			String effectiveExpansion = getOptionalNilExpansion();
			if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
				effectiveExpansion = getRequiredDefaultExpansion();
				if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Neither NilExpansion nor DefaultExpansion were compiled properly" );
				}
			}

			ICFGenKbGenItemObj genItem = genContext.getGenEngine().findContextItem(genContext, effectiveExpansion );
			if( genItem == null ) {
				throw new RuntimeException( S_ProcName + "Could not resolve expansion \"" + effectiveExpansion + "\"" );
			}

			if( genItem instanceof MssCFGenFileObj ) {
				retval = ((MssCFGenFileObj)genItem).expandBody( genContext );
			}
			else if( genItem instanceof MssCFGenRuleObj ) {
				retval = ((MssCFGenRuleObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenTruncObj) {
				retval = ((MssCFGenTruncObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenBindObj) {
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
		else if( valueStrValue.length() == 0 ) {

			String effectiveExpansion = getOptionalEmptyExpansion();
			if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
				effectiveExpansion = getRequiredDefaultExpansion();
				if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Neither EmptyExpansion nor DefaultExpansion were compiled properly" );
				}
			}

			ICFGenKbGenItemObj genItem = genContext.getGenEngine().findContextItem(genContext, effectiveExpansion );
			if( genItem == null ) {
				throw new RuntimeException( S_ProcName + "Could not resolve expansion \"" + effectiveExpansion + "\"" );
			}

			if( genItem instanceof MssCFGenFileObj ) {
				retval = ((MssCFGenFileObj)genItem).expandBody( genContext );
			}
			else if( genItem instanceof MssCFGenRuleObj ) {
				retval = ((MssCFGenRuleObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenTruncObj) {
				retval = ((MssCFGenTruncObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenBindObj) {
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
			String effectiveExpansion;
			ICFGenKbGelSwitchLimbObj switchLimb = genContext.getGenEngine().getGelSwitchLimbTableObj().readGelSwitchLimbByPIdx( getRequiredTenantId(), getRequiredGelCacheId(), getRequiredGelInstId(), valueStrValue );
			if( switchLimb != null ) {
				effectiveExpansion = switchLimb.getRequiredLimbExpansion();
				if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Switch limb for " + valueStrValue + " nas a null or empty LimbExpansion" );
				}
			}
			else {
				effectiveExpansion = getRequiredDefaultExpansion();
				if( ( effectiveExpansion == null ) || ( effectiveExpansion.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Switch nas a null or empty DefaultExpansion" );
				}
			}

			ICFGenKbGenItemObj genItem = genContext.getGenEngine().findContextItem(genContext, effectiveExpansion );
			if( genItem == null ) {
				throw new RuntimeException( S_ProcName + "Could not resolve expansion \"" + effectiveExpansion + "\"" );
			}

			if( genItem instanceof MssCFGenFileObj ) {
				retval = ((MssCFGenFileObj)genItem).expandBody( genContext );
			}
			else if( genItem instanceof MssCFGenRuleObj ) {
				retval = ((MssCFGenRuleObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenTruncObj) {
				retval = ((MssCFGenTruncObj)genItem).expandBody( genContext );
			}
			else if (genItem instanceof MssCFGenBindObj) {
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

		if( retval == null ) {
			retval = "$" + getRequiredSourceText() + "$";
		}

		return( retval );
	}
}
