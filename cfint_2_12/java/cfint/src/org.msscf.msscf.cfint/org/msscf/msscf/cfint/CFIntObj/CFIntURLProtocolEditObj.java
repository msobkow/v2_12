// Description: Java 11 edit object instance implementation for CFInt URLProtocol.

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

public class CFIntURLProtocolEditObj
	implements ICFIntURLProtocolEditObj
{
	protected ICFIntURLProtocolObj orig;
	protected CFIntURLProtocolBuff buff;
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;

	public CFIntURLProtocolEditObj( ICFIntURLProtocolObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFIntURLProtocolBuff origBuff = orig.getBuff();
		buff.set( origBuff );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFIntURLProtocolBuff buff = getBuff();
			createdBy = ((ICFIntSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFIntURLProtocolBuff buff = getBuff();
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
		return( CFIntURLProtocolObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "URLProtocol" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
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

	public ICFIntURLProtocolObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFIntURLProtocolObj retobj = getSchema().getURLProtocolTableObj().realiseURLProtocol( (ICFIntURLProtocolObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFIntSchemaObj)getOrigAsURLProtocol().getSchema()).getURLProtocolTableObj().forgetURLProtocol( getOrigAsURLProtocol(), forgetSubObjects );
	}

	public ICFIntURLProtocolObj read() {
		ICFIntURLProtocolObj retval = getOrigAsURLProtocol().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntURLProtocolObj read( boolean forceRead ) {
		ICFIntURLProtocolObj retval = getOrigAsURLProtocol().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFIntURLProtocolObj create() {
		copyBuffToOrig();
		ICFIntURLProtocolObj retobj = ((ICFIntSchemaObj)getOrigAsURLProtocol().getSchema()).getURLProtocolTableObj().createURLProtocol( getOrigAsURLProtocol() );
		if( retobj == getOrigAsURLProtocol() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFIntURLProtocolEditObj update() {
		getSchema().getURLProtocolTableObj().updateURLProtocol( (ICFIntURLProtocolObj)this );
		return( null );
	}

	public CFIntURLProtocolEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getURLProtocolTableObj().deleteURLProtocol( getOrigAsURLProtocol() );
		return( null );
	}

	public ICFIntURLProtocolTableObj getURLProtocolTable() {
		return( orig.getSchema().getURLProtocolTableObj() );
	}

	public ICFIntURLProtocolEditObj getEdit() {
		return( (ICFIntURLProtocolEditObj)this );
	}

	public ICFIntURLProtocolEditObj getEditAsURLProtocol() {
		return( (ICFIntURLProtocolEditObj)this );
	}

	public ICFIntURLProtocolEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFIntURLProtocolObj getOrig() {
		return( orig );
	}

	public ICFIntURLProtocolObj getOrigAsURLProtocol() {
		return( (ICFIntURLProtocolObj)orig );
	}

	public ICFIntSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFIntURLProtocolBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFIntSchema)getOrigAsURLProtocol().getSchema().getBackingStore()).getFactoryURLProtocol().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFIntURLProtocolBuff value ) {
		if( buff != value ) {
			buff = value;
		}
	}

	public CFIntURLProtocolBuff getURLProtocolBuff() {
		return( (CFIntURLProtocolBuff)getBuff() );
	}

	public CFIntURLProtocolPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFIntURLProtocolPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public int getRequiredURLProtocolId() {
		return( getPKey().getRequiredURLProtocolId() );
	}

	public String getRequiredName() {
		return( getURLProtocolBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getURLProtocolBuff().getRequiredName() != value ) {
			getURLProtocolBuff().setRequiredName( value );
		}
	}

	public String getRequiredDescription() {
		return( getURLProtocolBuff().getRequiredDescription() );
	}

	public void setRequiredDescription( String value ) {
		if( getURLProtocolBuff().getRequiredDescription() != value ) {
			getURLProtocolBuff().setRequiredDescription( value );
		}
	}

	public boolean getRequiredIsSecure() {
		return( getURLProtocolBuff().getRequiredIsSecure() );
	}

	public void setRequiredIsSecure( boolean value ) {
		if( getURLProtocolBuff().getRequiredIsSecure() != value ) {
			getURLProtocolBuff().setRequiredIsSecure( value );
		}
	}

	public void copyPKeyToBuff() {
		buff.setRequiredURLProtocolId( getPKey().getRequiredURLProtocolId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredURLProtocolId( buff.getRequiredURLProtocolId() );
	}

	public void copyBuffToOrig() {
		CFIntURLProtocolBuff origBuff = getOrigAsURLProtocol().getURLProtocolBuff();
		CFIntURLProtocolBuff myBuff = getURLProtocolBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFIntURLProtocolBuff origBuff = getOrigAsURLProtocol().getURLProtocolBuff();
		CFIntURLProtocolBuff myBuff = getURLProtocolBuff();
		myBuff.set( origBuff );
	}
}
