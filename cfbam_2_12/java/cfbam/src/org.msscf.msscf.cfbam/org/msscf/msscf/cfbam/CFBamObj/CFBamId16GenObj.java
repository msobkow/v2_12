// Description: Java 11 base object instance implementation for CFBam Id16Gen.

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

public class CFBamId16GenObj
	extends CFBamInt16TypeObj
	implements ICFBamId16GenObj
{
	public final static String CLASS_CODE = "IG16";
	protected ICFBamTableObj optionalLookupDispenser;

	public CFBamId16GenObj() {
		super();
		optionalLookupDispenser = null;
	}

	public CFBamId16GenObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupDispenser = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Id16Gen" );
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

	public ICFBamValueObj realise() {
		ICFBamId16GenObj retobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().realiseId16Gen(
			(ICFBamId16GenObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getId16GenTableObj().forgetId16Gen( (ICFBamId16GenObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamId16GenObj retobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().readId16GenByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamId16GenObj retobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().readId16GenByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamId16GenObj retobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().moveUpId16Gen( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamId16GenObj retobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().moveDownId16Gen( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamId16GenTableObj getId16GenTable() {
		return( ((ICFBamSchemaObj)schema).getId16GenTableObj() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryId16Gen().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableId16Gen().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamId16GenBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamId16GenBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredContainerSchemaDef = null;
		optionalLookupDispenser = null;
	}

	public CFBamId16GenBuff getId16GenBuff() {
		return( (CFBamId16GenBuff)getBuff() );
	}

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamId16GenObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamId16GenObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getId16GenTableObj().lockId16Gen( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getId16GenTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public ICFBamId16GenEditObj getEditAsId16Gen() {
		return( (ICFBamId16GenEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamValueBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamValueBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public Long getOptionalDispenserTenantId() {
		return( getId16GenBuff().getOptionalDispenserTenantId() );
	}

	public Long getOptionalDispenserId() {
		return( getId16GenBuff().getOptionalDispenserId() );
	}

	public short getRequiredSlice() {
		return( getId16GenBuff().getRequiredSlice() );
	}

	public short getRequiredBlockSize() {
		return( getId16GenBuff().getRequiredBlockSize() );
	}

	public ICFBamTableObj getOptionalLookupDispenser() {
		return( getOptionalLookupDispenser( false ) );
	}

	public ICFBamTableObj getOptionalLookupDispenser( boolean forceRead ) {
		if( ( optionalLookupDispenser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getId16GenBuff().getOptionalDispenserTenantId() == null ) {
				anyMissing = true;
			}
			if( getId16GenBuff().getOptionalDispenserId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDispenser = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getId16GenBuff().getOptionalDispenserTenantId(),
					getId16GenBuff().getOptionalDispenserId(), forceRead );
			}
		}
		return( optionalLookupDispenser );
	}
}
