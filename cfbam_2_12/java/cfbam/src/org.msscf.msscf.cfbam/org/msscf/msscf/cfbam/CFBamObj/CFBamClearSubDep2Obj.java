// Description: Java 11 base object instance implementation for CFBam ClearSubDep2.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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

public class CFBamClearSubDep2Obj
	extends CFBamClearDepObj
	implements ICFBamClearSubDep2Obj
{
	public final static String CLASS_CODE = "CLR2";
	protected ICFBamClearSubDep1Obj requiredContainerClearSubDep1;

	public CFBamClearSubDep2Obj() {
		super();
		requiredContainerClearSubDep1 = null;
	}

	public CFBamClearSubDep2Obj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerClearSubDep1 = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerClearSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerClearSubDep1();
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
		ICFBamClearSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().realiseClearSubDep2(
			(ICFBamClearSubDep2Obj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getClearSubDep2TableObj().forgetClearSubDep2( (ICFBamClearSubDep2Obj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamClearSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().readClearSubDep2ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamClearSubDep2Obj retobj = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().readClearSubDep2ByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamClearSubDep2TableObj getClearSubDep2Table() {
		return( ((ICFBamSchemaObj)schema).getClearSubDep2TableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearSubDep2().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearSubDep2().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamClearSubDep2Buff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamClearSubDep2Buff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerClearSubDep1 = null;
	}

	public CFBamClearSubDep2Buff getClearSubDep2Buff() {
		return( (CFBamClearSubDep2Buff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamClearSubDep2Obj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamClearSubDep2Obj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().lockClearSubDep2( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getClearSubDep2TableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamClearSubDep2EditObj getEditAsClearSubDep2() {
		return( (ICFBamClearSubDep2EditObj)edit );
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

	public long getRequiredClearSubDep1TenantId() {
		return( getClearSubDep2Buff().getRequiredClearSubDep1TenantId() );
	}

	public long getRequiredClearSubDep1Id() {
		return( getClearSubDep2Buff().getRequiredClearSubDep1Id() );
	}

	public String getRequiredName() {
		return( getClearSubDep2Buff().getRequiredName() );
	}

	public ICFBamClearSubDep1Obj getRequiredContainerClearSubDep1() {
		return( getRequiredContainerClearSubDep1( false ) );
	}

	public ICFBamClearSubDep1Obj getRequiredContainerClearSubDep1( boolean forceRead ) {
		if( ( requiredContainerClearSubDep1 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerClearSubDep1 = ((ICFBamSchemaObj)schema).getClearSubDep1TableObj().readClearSubDep1ByIdIdx( getClearSubDep2Buff().getRequiredClearSubDep1TenantId(),
					getClearSubDep2Buff().getRequiredClearSubDep1Id(), forceRead );
			}
		}
		return( requiredContainerClearSubDep1 );
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep() {
		List<ICFBamClearSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}
}
