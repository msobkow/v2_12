// Description: Java 11 base object instance implementation for CFBam TableCol.

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

public class CFBamTableColObj
	extends CFBamValueObj
	implements ICFBamTableColObj
{
	public final static String CLASS_CODE = "TBLC";
	protected ICFBamTableObj requiredContainerTable;
	protected ICFBamValueObj requiredParentDataType;

	public CFBamTableColObj() {
		super();
		requiredContainerTable = null;
		requiredParentDataType = null;
	}

	public CFBamTableColObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
		requiredParentDataType = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TableCol" );
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
		ICFBamTableColObj retobj = ((ICFBamSchemaObj)schema).getTableColTableObj().realiseTableCol(
			(ICFBamTableColObj)this );
		return( (ICFBamValueObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getTableColTableObj().forgetTableCol( (ICFBamTableColObj)this, forgetSubObjects );
	}

	public ICFBamValueObj read() {
		ICFBamTableColObj retobj = ((ICFBamSchemaObj)schema).getTableColTableObj().readTableColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj read( boolean forceRead ) {
		ICFBamTableColObj retobj = ((ICFBamSchemaObj)schema).getTableColTableObj().readTableColByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveUp() {
		ICFBamTableColObj retobj = ((ICFBamSchemaObj)schema).getTableColTableObj().moveUpTableCol( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamValueObj moveDown() {
		ICFBamTableColObj retobj = ((ICFBamSchemaObj)schema).getTableColTableObj().moveDownTableCol( this );
		return( (ICFBamValueObj)retobj );
	}

	public ICFBamTableColTableObj getTableColTable() {
		return( ((ICFBamSchemaObj)schema).getTableColTableObj() );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryTableCol().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableTableCol().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFBamTableColBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamTableColBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredContainerTable = null;
		requiredParentDataType = null;
	}

	public CFBamTableColBuff getTableColBuff() {
		return( (CFBamTableColBuff)getBuff() );
	}

	public ICFBamValueEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamTableColObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamTableColObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getTableColTableObj().lockTableCol( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getTableColTableObj().newEditInstance( lockobj );
		return( (ICFBamValueEditObj)edit );
	}

	public ICFBamTableColEditObj getEditAsTableCol() {
		return( (ICFBamTableColEditObj)edit );
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
		return( getTableColBuff().getRequiredTableId() );
	}

	public String getOptionalDbName() {
		return( getTableColBuff().getOptionalDbName() );
	}

	public Long getOptionalDataTenantId() {
		return( getTableColBuff().getOptionalDataTenantId() );
	}

	public Long getOptionalDataId() {
		return( getTableColBuff().getOptionalDataId() );
	}

	public String getOptionalXmlElementName() {
		return( getTableColBuff().getOptionalXmlElementName() );
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((ICFBamSchemaObj)schema).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getTableColBuff().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}

	public ICFBamValueObj getRequiredParentDataType() {
		return( getRequiredParentDataType( false ) );
	}

	public ICFBamValueObj getRequiredParentDataType( boolean forceRead ) {
		if( ( requiredParentDataType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableColBuff().getOptionalDataTenantId() == null ) {
				anyMissing = true;
			}
			if( getTableColBuff().getOptionalDataId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredParentDataType = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByIdIdx( getTableColBuff().getOptionalDataTenantId(),
					getTableColBuff().getOptionalDataId(), forceRead );
			}
		}
		return( requiredParentDataType );
	}
}
