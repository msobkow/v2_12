// Description: Java 11 edit object instance implementation for CFGenKb SecSession.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbSecSessionEditObj
	implements ICFGenKbSecSessionEditObj
{
	protected ICFGenKbSecSessionObj orig;
	protected CFGenKbSecSessionBuff buff;
	protected ICFGenKbSecUserObj requiredContainerSecUser;
	protected ICFGenKbSecUserObj requiredParentSecProxy;

	public CFGenKbSecSessionEditObj( ICFGenKbSecSessionObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbSecSessionBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	public String getClassCode() {
		return( CFGenKbSecSessionObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SecSession" );
	}

	public ICFLibAnyObj getScope() {
		ICFGenKbSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFGenKbSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	public String getObjName() {
		String objName;
		UUID val = getRequiredSecSessionId();
		objName = val.toString();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
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

	public ICFGenKbSecSessionObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbSecSessionObj retobj = getSchema().getSecSessionTableObj().realiseSecSession( (ICFGenKbSecSessionObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsSecSession().getSchema()).getSecSessionTableObj().forgetSecSession( getOrigAsSecSession(), forgetSubObjects );
	}

	public ICFGenKbSecSessionObj read() {
		ICFGenKbSecSessionObj retval = getOrigAsSecSession().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecSessionObj read( boolean forceRead ) {
		ICFGenKbSecSessionObj retval = getOrigAsSecSession().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbSecSessionObj create() {
		copyBuffToOrig();
		ICFGenKbSecSessionObj retobj = ((ICFGenKbSchemaObj)getOrigAsSecSession().getSchema()).getSecSessionTableObj().createSecSession( getOrigAsSecSession() );
		if( retobj == getOrigAsSecSession() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbSecSessionEditObj update() {
		getSchema().getSecSessionTableObj().updateSecSession( (ICFGenKbSecSessionObj)this );
		return( null );
	}

	public CFGenKbSecSessionEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getSecSessionTableObj().deleteSecSession( getOrigAsSecSession() );
		return( null );
	}

	public ICFGenKbSecSessionTableObj getSecSessionTable() {
		return( orig.getSchema().getSecSessionTableObj() );
	}

	public ICFGenKbSecSessionEditObj getEdit() {
		return( (ICFGenKbSecSessionEditObj)this );
	}

	public ICFGenKbSecSessionEditObj getEditAsSecSession() {
		return( (ICFGenKbSecSessionEditObj)this );
	}

	public ICFGenKbSecSessionEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbSecSessionObj getOrig() {
		return( orig );
	}

	public ICFGenKbSecSessionObj getOrigAsSecSession() {
		return( (ICFGenKbSecSessionObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbSecSessionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsSecSession().getSchema().getBackingStore()).getFactorySecSession().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecSessionBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredContainerSecUser = null;
			requiredParentSecProxy = null;
		}
	}

	public CFGenKbSecSessionBuff getSecSessionBuff() {
		return( (CFGenKbSecSessionBuff)getBuff() );
	}

	public CFGenKbSecSessionPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbSecSessionPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public UUID getRequiredSecSessionId() {
		return( getPKey().getRequiredSecSessionId() );
	}

	public UUID getRequiredSecUserId() {
		return( getSecSessionBuff().getRequiredSecUserId() );
	}

	public String getOptionalSecDevName() {
		return( getSecSessionBuff().getOptionalSecDevName() );
	}

	public void setOptionalSecDevName( String value ) {
		if( getSecSessionBuff().getOptionalSecDevName() != value ) {
			getSecSessionBuff().setOptionalSecDevName( value );
		}
	}

	public Calendar getRequiredStart() {
		return( getSecSessionBuff().getRequiredStart() );
	}

	public void setRequiredStart( Calendar value ) {
		if( getSecSessionBuff().getRequiredStart() != value ) {
			getSecSessionBuff().setRequiredStart( value );
		}
	}

	public Calendar getOptionalFinish() {
		return( getSecSessionBuff().getOptionalFinish() );
	}

	public void setOptionalFinish( Calendar value ) {
		if( getSecSessionBuff().getOptionalFinish() != value ) {
			getSecSessionBuff().setOptionalFinish( value );
		}
	}

	public UUID getOptionalSecProxyId() {
		return( getSecSessionBuff().getOptionalSecProxyId() );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( forceRead || ( requiredContainerSecUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbSecUserObj obj = ((ICFGenKbSchemaObj)getOrigAsSecSession().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionBuff().getRequiredSecUserId() );
				requiredContainerSecUser = obj;
				if( obj != null ) {
					getSecSessionBuff().setRequiredSecUserId( obj.getRequiredSecUserId() );
					requiredContainerSecUser = obj;
				}
			}
		}
		return( requiredContainerSecUser );
	}

	public void setRequiredContainerSecUser( ICFGenKbSecUserObj value ) {
			if( buff == null ) {
				getSecSessionBuff();
			}
			if( value != null ) {
				getSecSessionBuff().setRequiredSecUserId( value.getRequiredSecUserId() );
			}
			requiredContainerSecUser = value;
	}

	public ICFGenKbSecUserObj getRequiredParentSecProxy() {
		return( getRequiredParentSecProxy( false ) );
	}

	public ICFGenKbSecUserObj getRequiredParentSecProxy( boolean forceRead ) {
		if( forceRead || ( requiredParentSecProxy == null ) ) {
			boolean anyMissing = false;
			if( getSecSessionBuff().getOptionalSecProxyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbSecUserObj obj = ((ICFGenKbSchemaObj)getOrigAsSecSession().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionBuff().getOptionalSecProxyId() );
				requiredParentSecProxy = obj;
			}
		}
		return( requiredParentSecProxy );
	}

	public void setRequiredParentSecProxy( ICFGenKbSecUserObj value ) {
			if( buff == null ) {
				getSecSessionBuff();
			}
			if( value != null ) {
				getSecSessionBuff().setOptionalSecProxyId( value.getRequiredSecUserId() );
			}
			else {
				getSecSessionBuff().setOptionalSecProxyId( null );
			}
			requiredParentSecProxy = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredSecSessionId( getPKey().getRequiredSecSessionId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecSessionId( buff.getRequiredSecSessionId() );
	}

	public void copyBuffToOrig() {
		CFGenKbSecSessionBuff origBuff = getOrigAsSecSession().getSecSessionBuff();
		CFGenKbSecSessionBuff myBuff = getSecSessionBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbSecSessionBuff origBuff = getOrigAsSecSession().getSecSessionBuff();
		CFGenKbSecSessionBuff myBuff = getSecSessionBuff();
		myBuff.set( origBuff );
	}
}
