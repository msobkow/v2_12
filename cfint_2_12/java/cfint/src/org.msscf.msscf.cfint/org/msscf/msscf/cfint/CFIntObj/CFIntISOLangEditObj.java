// Description: Java 11 edit object instance implementation for CFInt ISOLang.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFIntISOLangEditObj
	implements ICFIntISOLangEditObj
{
	protected ICFSecISOLangObj orig;
	protected CFSecISOLangBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;

	public CFIntISOLangEditObj( ICFSecISOLangObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFSecISOLangBuff origBuff = orig.getBuff();
		buff.set( origBuff );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFSecISOLangBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFSecISOLangBuff buff = getBuff();
			updatedBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public void setCreatedBy( ICFSecSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getBuff().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setCreatedAt( Calendar value ) {
		getBuff().setCreatedAt( value );
	}

	public void setUpdatedBy( ICFSecSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getBuff().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	public void setUpdatedAt( Calendar value ) {
		getBuff().setUpdatedAt( value );
	}

	public String getClassCode() {
		return( CFIntISOLangObj.CLASS_CODE );
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

	public ICFSecISOLangObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFSecISOLangObj retobj = getSchema().getISOLangTableObj().realiseISOLang( (ICFIntISOLangObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFIntSchemaObj)getOrigAsISOLang().getSchema()).getISOLangTableObj().forgetISOLang( getOrigAsISOLang(), forgetSubObjects );
	}

	public ICFSecISOLangObj read() {
		ICFSecISOLangObj retval = getOrigAsISOLang().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFSecISOLangObj read( boolean forceRead ) {
		ICFSecISOLangObj retval = getOrigAsISOLang().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFSecISOLangObj create() {
		copyBuffToOrig();
		ICFSecISOLangObj retobj = ((ICFIntSchemaObj)getOrigAsISOLang().getSchema()).getISOLangTableObj().createISOLang( getOrigAsISOLang() );
		if( retobj == getOrigAsISOLang() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFSecISOLangEditObj update() {
		getSchema().getISOLangTableObj().updateISOLang( (ICFSecISOLangObj)this );
		return( null );
	}

	public CFSecISOLangEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getISOLangTableObj().deleteISOLang( getOrigAsISOLang() );
		return( null );
	}

	public ICFSecISOLangTableObj getISOLangTable() {
		return( orig.getSchema().getISOLangTableObj() );
	}

	public ICFSecISOLangEditObj getEdit() {
		return( (ICFSecISOLangEditObj)this );
	}

	public ICFSecISOLangEditObj getEditAsISOLang() {
		return( (ICFSecISOLangEditObj)this );
	}

	public ICFSecISOLangEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFSecISOLangObj getOrig() {
		return( orig );
	}

	public ICFSecISOLangObj getOrigAsISOLang() {
		return( (ICFSecISOLangObj)orig );
	}

	public ICFSecSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFSecISOLangBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFIntSchema)getOrigAsISOLang().getSchema().getBackingStore()).getFactoryISOLang().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFSecISOLangBuff value ) {
		if( buff != value ) {
			buff = value;
		}
	}

	public CFSecISOLangBuff getISOLangBuff() {
		return( (CFSecISOLangBuff)getBuff() );
	}

	public CFSecISOLangPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFSecISOLangPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public short getRequiredISOLangId() {
		return( getPKey().getRequiredISOLangId() );
	}

	public String getRequiredISO6392Code() {
		return( getISOLangBuff().getRequiredISO6392Code() );
	}

	public void setRequiredISO6392Code( String value ) {
		if( getISOLangBuff().getRequiredISO6392Code() != value ) {
			getISOLangBuff().setRequiredISO6392Code( value );
		}
	}

	public String getOptionalISO6391Code() {
		return( getISOLangBuff().getOptionalISO6391Code() );
	}

	public void setOptionalISO6391Code( String value ) {
		if( getISOLangBuff().getOptionalISO6391Code() != value ) {
			getISOLangBuff().setOptionalISO6391Code( value );
		}
	}

	public String getRequiredEnglishName() {
		return( getISOLangBuff().getRequiredEnglishName() );
	}

	public void setRequiredEnglishName( String value ) {
		if( getISOLangBuff().getRequiredEnglishName() != value ) {
			getISOLangBuff().setRequiredEnglishName( value );
		}
	}

	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry() {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFIntSchemaObj)getOrigAsISOLang().getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey().getRequiredISOLangId(),
			false );
		return( retval );
	}

	public List<ICFSecISOCtryLangObj> getOptionalChildrenCtry( boolean forceRead ) {
		List<ICFSecISOCtryLangObj> retval;
		retval = ((ICFIntSchemaObj)getOrigAsISOLang().getSchema()).getISOCtryLangTableObj().readISOCtryLangByLangIdx( getPKey().getRequiredISOLangId(),
			forceRead );
		return( retval );
	}

	public void copyPKeyToBuff() {
		buff.setRequiredISOLangId( getPKey().getRequiredISOLangId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredISOLangId( buff.getRequiredISOLangId() );
	}

	public void copyBuffToOrig() {
		CFSecISOLangBuff origBuff = getOrigAsISOLang().getISOLangBuff();
		CFSecISOLangBuff myBuff = getISOLangBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFSecISOLangBuff origBuff = getOrigAsISOLang().getISOLangBuff();
		CFSecISOLangBuff myBuff = getISOLangBuff();
		myBuff.set( origBuff );
	}
}
