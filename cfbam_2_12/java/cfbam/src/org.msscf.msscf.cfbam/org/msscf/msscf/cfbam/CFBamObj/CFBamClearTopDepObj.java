// Description: Java 11 base object instance implementation for CFBam ClearTopDep.

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

public class CFBamClearTopDepObj
	extends CFBamClearDepObj
	implements ICFBamClearTopDepObj
{
	public final static String CLASS_CODE = "CLRT";
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamClearTopDepObj optionalLookupPrev;
	protected ICFBamClearTopDepObj optionalLookupNext;

	public CFBamClearTopDepObj() {
		super();
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamClearTopDepObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearTopDep" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamTableObj scope = getRequiredContainerTable();
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
		ICFBamClearTopDepObj retobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().realiseClearTopDep(
			(ICFBamClearTopDepObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getClearTopDepTableObj().forgetClearTopDep( (ICFBamClearTopDepObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamClearTopDepObj retobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamClearTopDepObj retobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamClearTopDepObj moveUp() {
		ICFBamClearTopDepObj retobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().moveUpClearTopDep( this );
		return( (ICFBamClearTopDepObj)retobj );
	}

	public ICFBamClearTopDepObj moveDown() {
		ICFBamClearTopDepObj retobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().moveDownClearTopDep( this );
		return( (ICFBamClearTopDepObj)retobj );
	}

	public ICFBamClearTopDepTableObj getClearTopDepTable() {
		return( ((ICFBamSchemaObj)schema).getClearTopDepTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryClearTopDep().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableClearTopDep().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamClearTopDepBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamClearTopDepBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public CFBamClearTopDepBuff getClearTopDepBuff() {
		return( (CFBamClearTopDepBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamClearTopDepObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamClearTopDepObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().lockClearTopDep( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamClearTopDepEditObj getEditAsClearTopDep() {
		return( (ICFBamClearTopDepEditObj)edit );
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

	public long getRequiredTableTenantId() {
		return( getClearTopDepBuff().getRequiredTableTenantId() );
	}

	public long getRequiredTableId() {
		return( getClearTopDepBuff().getRequiredTableId() );
	}

	public String getRequiredName() {
		return( getClearTopDepBuff().getRequiredName() );
	}

	public Long getOptionalPrevTenantId() {
		return( getClearTopDepBuff().getOptionalPrevTenantId() );
	}

	public Long getOptionalPrevId() {
		return( getClearTopDepBuff().getOptionalPrevId() );
	}

	public Long getOptionalNextTenantId() {
		return( getClearTopDepBuff().getOptionalNextTenantId() );
	}

	public Long getOptionalNextId() {
		return( getClearTopDepBuff().getOptionalNextId() );
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getClearTopDepBuff().getRequiredTableTenantId(),
					getClearTopDepBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}

	public List<ICFBamClearSubDep1Obj> getOptionalComponentsClearDep() {
		List<ICFBamClearSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearSubDep1Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearSubDep1Obj> retval;
		retval = ((ICFBamSchemaObj)schema).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFBamClearTopDepObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	public ICFBamClearTopDepObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getClearTopDepBuff().getOptionalPrevTenantId() == null ) {
				anyMissing = true;
			}
			if( getClearTopDepBuff().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepBuff().getOptionalPrevTenantId(),
					getClearTopDepBuff().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	public ICFBamClearTopDepObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	public ICFBamClearTopDepObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getClearTopDepBuff().getOptionalNextTenantId() == null ) {
				anyMissing = true;
			}
			if( getClearTopDepBuff().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((ICFBamSchemaObj)schema).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepBuff().getOptionalNextTenantId(),
					getClearTopDepBuff().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}
}
