// Description: Java 11 base object instance implementation for CFBam TokenCol.

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

public class CFBamTokenColObj
	extends CFBamTokenDefObj
	implements ICFBamTokenColObj
{
	public final static String CLASS_CODE = "TKNC";
	protected ICFBamTableObj requiredContainerTable;

	public CFBamTokenColObj() {
		super();
		requiredContainerTable = null;
	}

	public CFBamTokenColObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TokenCol" );
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

	public ICFBamValueObj realise() {
		ICFBamTokenColObj retobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().realiseTokenCol(
			(ICFBamTokenColObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getTokenColTableObj().forgetTokenCol( (ICFBamTokenColObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamTokenColObj retobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().readTokenColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamTokenColObj retobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().readTokenColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamTokenColObj retobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().moveUpTokenCol( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamTokenColObj retobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().moveDownTokenCol( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamTokenColTableObj getTokenColTable() {
		return( ((ICFBamSchemaObj)schema).getTokenColTableObj() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryTokenCol().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableTokenCol().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamTokenColBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamTokenColBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredContainerTable = null;
	}

	public CFBamTokenColBuff getTokenColBuff() {
		return( (CFBamTokenColBuff)getBuff() );
	}

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamTokenColObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamTokenColObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getTokenColTableObj().lockTokenCol( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getTokenColTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public ICFBamTokenColEditObj getEditAsTokenCol() {
		return( (ICFBamTokenColEditObj)edit );
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

	public long getRequiredTableId() {
		return( getTokenColBuff().getRequiredTableId() );
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getTokenColBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}
}
