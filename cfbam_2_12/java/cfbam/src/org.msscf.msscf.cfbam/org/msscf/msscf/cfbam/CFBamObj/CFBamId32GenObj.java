// Description: Java 11 base object instance implementation for CFBam Id32Gen.

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

public class CFBamId32GenObj
	extends CFBamInt32TypeObj
	implements ICFBamId32GenObj
{
	public final static String CLASS_CODE = "IG32";
	protected ICFBamTableObj optionalLookupDispenser;

	public CFBamId32GenObj() {
		super();
		optionalLookupDispenser = null;
	}

	public CFBamId32GenObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupDispenser = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Id32Gen" );
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
		ICFBamId32GenObj retobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().realiseId32Gen(
			(ICFBamId32GenObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getId32GenTableObj().forgetId32Gen( (ICFBamId32GenObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamId32GenObj retobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().readId32GenByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamId32GenObj retobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().readId32GenByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamId32GenObj retobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().moveUpId32Gen( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamId32GenObj retobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().moveDownId32Gen( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamId32GenTableObj getId32GenTable() {
		return( ((ICFBamSchemaObj)schema).getId32GenTableObj() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryId32Gen().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableId32Gen().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamId32GenBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamId32GenBuff" );
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

	public CFBamId32GenBuff getId32GenBuff() {
		return( (CFBamId32GenBuff)getBuff() );
	}

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamId32GenObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamId32GenObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getId32GenTableObj().lockId32Gen( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getId32GenTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public ICFBamId32GenEditObj getEditAsId32Gen() {
		return( (ICFBamId32GenEditObj)edit );
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
		return( getId32GenBuff().getOptionalDispenserTenantId() );
	}

	public Long getOptionalDispenserId() {
		return( getId32GenBuff().getOptionalDispenserId() );
	}

	public short getRequiredSlice() {
		return( getId32GenBuff().getRequiredSlice() );
	}

	public int getRequiredBlockSize() {
		return( getId32GenBuff().getRequiredBlockSize() );
	}

	public ICFBamTableObj getOptionalLookupDispenser() {
		return( getOptionalLookupDispenser( false ) );
	}

	public ICFBamTableObj getOptionalLookupDispenser( boolean forceRead ) {
		if( ( optionalLookupDispenser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getId32GenBuff().getOptionalDispenserTenantId() == null ) {
				anyMissing = true;
			}
			if( getId32GenBuff().getOptionalDispenserId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDispenser = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getId32GenBuff().getOptionalDispenserTenantId(),
					getId32GenBuff().getOptionalDispenserId(), forceRead );
			}
		}
		return( optionalLookupDispenser );
	}
}
