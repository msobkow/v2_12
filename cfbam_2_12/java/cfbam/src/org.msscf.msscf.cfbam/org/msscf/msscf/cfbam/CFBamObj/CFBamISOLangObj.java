// Description: Java 11 base object instance implementation for CFBam ISOLang.

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

public class CFBamISOLangObj
	implements ICFBamISOLangObj
{
	public final static String CLASS_CODE = "ISLN";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFSecISOLangEditObj edit;
	protected ICFSecSchemaObj schema;
	protected CFSecISOLangPKey pKey;
	protected CFSecISOLangBuff buff;

	public CFBamISOLangObj() {
		isNew = true;
	}

	public CFBamISOLangObj( ICFSecSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ISOLang" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredISO6392Code();
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

	public ICFSecISOLangObj realise() {
		ICFSecISOLangObj retobj = ((ICFBamSchemaObj)schema).getISOLangTableObj().realiseISOLang(
			(ICFSecISOLangObj)this );
		return( (ICFSecISOLangObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getISOLangTableObj().forgetISOLang( (ICFSecISOLangObj)this, forgetSubObjects );
	}

	public ICFSecISOLangObj read() {
		ICFSecISOLangObj retobj = ((ICFBamSchemaObj)schema).getISOLangTableObj().readISOLangByIdIdx( getPKey().getRequiredISOLangId(), false );
		return( (ICFSecISOLangObj)retobj );
	}

	public ICFSecISOLangObj read( boolean forceRead ) {
		ICFSecISOLangObj retobj = ((ICFBamSchemaObj)schema).getISOLangTableObj().readISOLangByIdIdx( getPKey().getRequiredISOLangId(), forceRead );
		return( (ICFSecISOLangObj)retobj );
	}

	public ICFSecISOLangTableObj getISOLangTable() {
		return( ((ICFBamSchemaObj)schema).getISOLangTableObj() );
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj value ) {
		schema = value;
	}

	public CFSecISOLangBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOLang().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableISOLang().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredISOLangId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFSecISOLangBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFSecISOLangBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFSecISOLangBuff" );
		}
		buff = value;
		copyBuffToPKey();
	}

	public CFSecISOLangBuff getISOLangBuff() {
		return( (CFSecISOLangBuff)getBuff() );
	}

	public CFSecISOLangPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFBamSchema)schema.getBackingStore()).getFactoryISOLang().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFSecISOLangPKey value ) {
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

	public ICFSecISOLangEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFSecISOLangObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFSecISOLangObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getISOLangTableObj().lockISOLang( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getISOLangTableObj().newEditInstance( lockobj );
		return( (ICFSecISOLangEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFSecISOLangEditObj getEdit() {
		return( edit );
	}

	public ICFSecISOLangEditObj getEditAsISOLang() {
		return( (ICFSecISOLangEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecISOLangBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecISOLangBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public short getRequiredISOLangId() {
		return( getPKey().getRequiredISOLangId() );
	}

	public String getRequiredISO6392Code() {
		return( getISOLangBuff().getRequiredISO6392Code() );
	}

	public String getOptionalISO6391Code() {
		return( getISOLangBuff().getOptionalISO6391Code() );
	}

	public String getRequiredEnglishName() {
		return( getISOLangBuff().getRequiredEnglishName() );
	}

	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry() {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFBamSchemaObj)schema).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey().getRequiredISOLangId(),
			false );
		return( retval );
	}

	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry( boolean forceRead ) {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFBamSchemaObj)schema).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey().getRequiredISOLangId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredISOLangId( getPKey().getRequiredISOLangId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredISOLangId( buff.getRequiredISOLangId() );
	}
}
