// Description: Java 11 base object instance implementation for CFInt ISOTZone.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntISOTZoneObj
	implements ICFIntISOTZoneObj
{
	public final static String CLASS_CODE = "ITZN";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecISOTZoneEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecISOTZonePKey pKey;
	protected CFSecISOTZoneBuff buff;

	public CFIntISOTZoneObj() {
		isNew = true;
	}

	public CFIntISOTZoneObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ISOTZone" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredTZName();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
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
				if( container instanceof ICFIntClusterObj ) {
					break;
				}
				else if( container instanceof ICFIntTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
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
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public String getObjFullName() {
		String fullName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFSecISOTZoneObj realise() {
		ICFSecISOTZoneObj retobj = ((ICFIntSchemaObj)schema).getISOTZoneTableObj().realiseISOTZone(
			(ICFSecISOTZoneObj)this );
		return( (ICFSecISOTZoneObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getISOTZoneTableObj().forgetISOTZone( (ICFSecISOTZoneObj)this, forgetSubObjects );
	}

	public ICFSecISOTZoneObj read() {
		ICFSecISOTZoneObj retobj = ((ICFIntSchemaObj)schema).getISOTZoneTableObj().readISOTZoneByIdIdx( getPKey().getRequiredISOTZoneId(), false );
		return( (ICFSecISOTZoneObj)retobj );
	}

	public ICFSecISOTZoneObj read( boolean forceRead ) {
		ICFSecISOTZoneObj retobj = ((ICFIntSchemaObj)schema).getISOTZoneTableObj().readISOTZoneByIdIdx( getPKey().getRequiredISOTZoneId(), forceRead );
		return( (ICFSecISOTZoneObj)retobj );
	}

	public ICFSecISOTZoneTableObj getISOTZoneTable() {
		return( ((ICFIntSchemaObj)schema).getISOTZoneTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecISOTZoneBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableISOTZone().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredISOTZoneId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecISOTZoneBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecISOTZoneBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecISOTZoneBuff" );
		}
		buff = value;
		copyBuffToPKey();
	}

	public CFSecISOTZoneBuff getISOTZoneBuff() {
		return( (CFSecISOTZoneBuff)getBuff() );
	}

	public CFSecISOTZonePKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryISOTZone().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecISOTZonePKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToBuff();
		}
	}

	public boolean getIsNew() {
		return( isNew );
	}

	public void setIsNew( boolean value ) {
		isNew = value;
	}

	public ICFSecISOTZoneEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecISOTZoneObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecISOTZoneObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getISOTZoneTableObj().lockISOTZone( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getISOTZoneTableObj().newEditInstance( lockobj );
		return( (ICFSecISOTZoneEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecISOTZoneEditObj getEdit() {
		return( edit );
	}

	public ICFSecISOTZoneEditObj getEditAsISOTZone() {
		return( (ICFSecISOTZoneEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecISOTZoneBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecISOTZoneBuff buff = getBuff();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public short getRequiredISOTZoneId() {
		return( getPKey().getRequiredISOTZoneId() );
	}

	public String getRequiredIso8601() {
		return( getISOTZoneBuff().getRequiredIso8601() );
	}

	public String getRequiredTZName() {
		return( getISOTZoneBuff().getRequiredTZName() );
	}

	public short getRequiredTZHourOffset() {
		return( getISOTZoneBuff().getRequiredTZHourOffset() );
	}

	public short getRequiredTZMinOffset() {
		return( getISOTZoneBuff().getRequiredTZMinOffset() );
	}

	public String getRequiredDescription() {
		return( getISOTZoneBuff().getRequiredDescription() );
	}

	public boolean getRequiredVisible() {
		return( getISOTZoneBuff().getRequiredVisible() );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredISOTZoneId( getPKey().getRequiredISOTZoneId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredISOTZoneId( buff.getRequiredISOTZoneId() );
	}
}
