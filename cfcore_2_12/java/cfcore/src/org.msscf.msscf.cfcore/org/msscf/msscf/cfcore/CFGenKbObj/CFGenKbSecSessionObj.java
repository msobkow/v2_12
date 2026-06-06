// Description: Java 11 base object instance implementation for CFGenKb SecSession.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbSecSessionObj
	implements ICFGenKbSecSessionObj
{
	public final static String CLASS_CODE = "SESS";
	protected boolean isNew;
	protected ICFGenKbSecSessionEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbSecSessionPKey pKey;
	protected CFGenKbSecSessionBuff buff;
	protected ICFGenKbSecUserObj requiredContainerSecUser;
	protected ICFGenKbSecUserObj requiredParentSecProxy;

	public CFGenKbSecSessionObj() {
		isNew = true;
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	public CFGenKbSecSessionObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbSecSessionObj retobj = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().realiseSecSession(
			(ICFGenKbSecSessionObj)this );
		return( (ICFGenKbSecSessionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getSecSessionTableObj().forgetSecSession( (ICFGenKbSecSessionObj)this, forgetSubObjects );
	}

	public ICFGenKbSecSessionObj read() {
		ICFGenKbSecSessionObj retobj = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionByIdIdx( getPKey().getRequiredSecSessionId(), false );
		return( (ICFGenKbSecSessionObj)retobj );
	}

	public ICFGenKbSecSessionObj read( boolean forceRead ) {
		ICFGenKbSecSessionObj retobj = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().readSecSessionByIdIdx( getPKey().getRequiredSecSessionId(), forceRead );
		return( (ICFGenKbSecSessionObj)retobj );
	}

	public ICFGenKbSecSessionTableObj getSecSessionTable() {
		return( ((ICFGenKbSchemaObj)schema).getSecSessionTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbSecSessionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecSession().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableSecSession().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredSecSessionId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbSecSessionBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbSecSessionBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbSecSessionBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	public CFGenKbSecSessionBuff getSecSessionBuff() {
		return( (CFGenKbSecSessionBuff)getBuff() );
	}

	public CFGenKbSecSessionPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactorySecSession().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbSecSessionPKey value ) {
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

	public ICFGenKbSecSessionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbSecSessionObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbSecSessionObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().lockSecSession( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getSecSessionTableObj().newEditInstance( lockobj );
		return( (ICFGenKbSecSessionEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbSecSessionEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbSecSessionEditObj getEditAsSecSession() {
		return( (ICFGenKbSecSessionEditObj)edit );
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

	public Calendar getRequiredStart() {
		return( getSecSessionBuff().getRequiredStart() );
	}

	public Calendar getOptionalFinish() {
		return( getSecSessionBuff().getOptionalFinish() );
	}

	public UUID getOptionalSecProxyId() {
		return( getSecSessionBuff().getOptionalSecProxyId() );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	public ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( ( requiredContainerSecUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSecUser = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getSecSessionBuff().getRequiredSecUserId(), forceRead );
			}
		}
		return( requiredContainerSecUser );
	}

	public ICFGenKbSecUserObj getRequiredParentSecProxy() {
		return( getRequiredParentSecProxy( false ) );
	}

	public ICFGenKbSecUserObj getRequiredParentSecProxy( boolean forceRead ) {
		if( ( requiredParentSecProxy == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSecSessionBuff().getOptionalSecProxyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredParentSecProxy = ((ICFGenKbSchemaObj)schema).getSecUserTableObj().readSecUserByIdIdx( getSecSessionBuff().getOptionalSecProxyId(), forceRead );
			}
		}
		return( requiredParentSecProxy );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredSecSessionId( getPKey().getRequiredSecSessionId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredSecSessionId( buff.getRequiredSecSessionId() );
	}
}
