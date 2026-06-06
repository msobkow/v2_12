// Description: Java 11 base object instance implementation for CFGenKb GelSequence.

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
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public class CFGenKbGelSequenceObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelSequenceObj
{
	public final static String CLASS_CODE = "GSEQ";
	protected ICFGenKbGelCallObj optionalLookupFirstInst;
	protected ICFGenKbGelCallObj optionalLookupLastInst;

	public CFGenKbGelSequenceObj() {
		super();
		optionalLookupFirstInst = null;
		optionalLookupLastInst = null;
	}

	public CFGenKbGelSequenceObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupFirstInst = null;
		optionalLookupLastInst = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelSequence" );
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
		ICFGenKbGelSequenceObj retobj = ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().realiseGelSequence(
			(ICFGenKbGelSequenceObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().forgetGelSequence( (ICFGenKbGelSequenceObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelSequenceObj retobj = ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().readGelSequenceByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelSequenceObj retobj = ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().readGelSequenceByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelSequenceTableObj getGelSequenceTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSequence().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSequence().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelSequenceBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelSequenceBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
		optionalLookupFirstInst = null;
		optionalLookupLastInst = null;
	}

	public CFGenKbGelSequenceBuff getGelSequenceBuff() {
		return( (CFGenKbGelSequenceBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelSequenceObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelSequenceObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().lockGelSequence( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelSequenceTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelSequenceEditObj getEditAsGelSequence() {
		return( (ICFGenKbGelSequenceEditObj)edit );
	}

	public Long getOptionalFirstInstTenantId() {
		return( getGelSequenceBuff().getOptionalFirstInstTenantId() );
	}

	public Long getOptionalFirstInstGelCacheId() {
		return( getGelSequenceBuff().getOptionalFirstInstGelCacheId() );
	}

	public Long getOptionalFirstInstId() {
		return( getGelSequenceBuff().getOptionalFirstInstId() );
	}

	public Long getOptionalLastInstTenantId() {
		return( getGelSequenceBuff().getOptionalLastInstTenantId() );
	}

	public Long getOptionalLastInstGelCacheId() {
		return( getGelSequenceBuff().getOptionalLastInstGelCacheId() );
	}

	public Long getOptionalLastInstId() {
		return( getGelSequenceBuff().getOptionalLastInstId() );
	}

	public List<ICFGenKbGelCallObj> getOptionalChildrenCalls() {
		List<ICFGenKbGelCallObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getGelCallTableObj().readGelCallBySeqIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			false );
		return( retval );
	}

	public List<ICFGenKbGelCallObj> getOptionalChildrenCalls( boolean forceRead ) {
		List<ICFGenKbGelCallObj> retval;
		retval = ((ICFGenKbSchemaObj)schema).getGelCallTableObj().readGelCallBySeqIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredGelCacheId(),
					getPKey().getRequiredGelInstId(),
			forceRead );
		return( retval );
	}

	public ICFGenKbGelCallObj getOptionalLookupFirstInst() {
		return( getOptionalLookupFirstInst( false ) );
	}

	public ICFGenKbGelCallObj getOptionalLookupFirstInst( boolean forceRead ) {
		if( ( optionalLookupFirstInst == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGelSequenceBuff().getOptionalFirstInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelSequenceBuff().getOptionalFirstInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelSequenceBuff().getOptionalFirstInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupFirstInst = ((ICFGenKbSchemaObj)schema).getGelCallTableObj().readGelCallByPIdx( getGelSequenceBuff().getOptionalFirstInstTenantId(),
					getGelSequenceBuff().getOptionalFirstInstGelCacheId(),
					getGelSequenceBuff().getOptionalFirstInstId(), forceRead );
			}
		}
		return( optionalLookupFirstInst );
	}

	public ICFGenKbGelCallObj getOptionalLookupLastInst() {
		return( getOptionalLookupLastInst( false ) );
	}

	public ICFGenKbGelCallObj getOptionalLookupLastInst( boolean forceRead ) {
		if( ( optionalLookupLastInst == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getGelSequenceBuff().getOptionalLastInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelSequenceBuff().getOptionalLastInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelSequenceBuff().getOptionalLastInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupLastInst = ((ICFGenKbSchemaObj)schema).getGelCallTableObj().readGelCallByPIdx( getGelSequenceBuff().getOptionalLastInstTenantId(),
					getGelSequenceBuff().getOptionalLastInstGelCacheId(),
					getGelSequenceBuff().getOptionalLastInstId(), forceRead );
			}
		}
		return( optionalLookupLastInst );
	}

	public void addCalledInstruction( ICFGenKbGelCacheObj gelCache, ICFGenKbGelInstructionObj calledInstruction ) {
		ICFGenKbGelCallObj newCallObj = schema.getGelCallTableObj().newInstance();
		ICFGenKbGelCallEditObj editNewCall = (ICFGenKbGelCallEditObj)( newCallObj.beginEdit() );
		editNewCall.setRequiredOwnerTenant( getRequiredOwnerTenant() );
		editNewCall.setRequiredContainerGelCache( getRequiredContainerGelCache() );
		editNewCall.setOptionalParentSeqInst( this );
		editNewCall.setOptionalLookupCallInst( calledInstruction );
		editNewCall.setOptionalLookupNextInst( null );
		ICFGenKbGelCallObj lastObj = getOptionalLookupLastInst();
		editNewCall.setOptionalLookupPrevInst( lastObj );
		newCallObj = (ICFGenKbGelCallObj)( editNewCall.create() );
		editNewCall = null;
		ICFGenKbGelSequenceEditObj editMe = (ICFGenKbGelSequenceEditObj)beginEdit();
		if( lastObj != null ) {
			ICFGenKbGelCallEditObj editLast = (ICFGenKbGelCallEditObj)( lastObj.beginEdit() );
			editLast.setOptionalLookupNextInst( newCallObj );
			editLast.update();
			editLast = null;
		}
		else {
			editMe.setOptionalLookupFirstInst( newCallObj );
		}
		editMe.setOptionalLookupLastInst( newCallObj );
		editMe.update();
		editMe = null;
	}

	public String expand( MssCFGenContext genContext ) {
		final String S_ProcName = "expand";
		final String S_GenContext = "genContext";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(), S_ProcName, 1, S_GenContext );
		}

		StringBuffer expansion = new StringBuffer();
		String subExpansion;

		// Preload the instructions to avoid a read storm
		genContext.getGenEngine().getGelCallTableObj().readGelCallBySeqIdx( getRequiredTenantId(), getRequiredGelCacheId(), getRequiredGelInstId() );

		ICFGenKbGelInstructionObj nextCalled;
		ICFGenKbGelCallObj nextCall = getOptionalLookupFirstInst();
		while( nextCall != null ) {
			nextCalled = nextCall.getOptionalLookupCallInst();
			if( nextCalled != null ) {
				subExpansion = nextCalled.expand( genContext );
				if( subExpansion == null ) {
					subExpansion = "$" + nextCalled.getRequiredSourceText() + "$";
				}
				expansion.append( subExpansion );
			}
			nextCall = nextCall.getOptionalLookupNextInst();
		}

		return( expansion.toString() );
	}
}
