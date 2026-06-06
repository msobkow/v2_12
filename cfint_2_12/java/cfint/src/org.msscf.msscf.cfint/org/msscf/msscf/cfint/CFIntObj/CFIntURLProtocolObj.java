// Description: Java 11 base object instance implementation for CFInt URLProtocol.

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

public class CFIntURLProtocolObj
	implements ICFIntURLProtocolObj
{
	public final static String CLASS_CODE = "UPRT";
	protected ICFSecSecUserObj createdBy = null;
	protected ICFSecSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ICFIntURLProtocolEditObj edit;
	protected ICFIntSchemaObj schema;
	protected CFIntURLProtocolPKey pKey;
	protected CFIntURLProtocolBuff buff;

	public CFIntURLProtocolObj() {
		isNew = true;
	}

	public CFIntURLProtocolObj( ICFIntSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFIntURLProtocolObj retobj = ((ICFIntSchemaObj)schema).getURLProtocolTableObj().realiseURLProtocol(
			(ICFIntURLProtocolObj)this );
		return( (ICFIntURLProtocolObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFIntSchemaObj)schema).getURLProtocolTableObj().forgetURLProtocol( (ICFIntURLProtocolObj)this, forgetSubObjects );
	}

	public ICFIntURLProtocolObj read() {
		ICFIntURLProtocolObj retobj = ((ICFIntSchemaObj)schema).getURLProtocolTableObj().readURLProtocolByIdIdx( getPKey().getRequiredURLProtocolId(), false );
		return( (ICFIntURLProtocolObj)retobj );
	}

	public ICFIntURLProtocolObj read( boolean forceRead ) {
		ICFIntURLProtocolObj retobj = ((ICFIntSchemaObj)schema).getURLProtocolTableObj().readURLProtocolByIdIdx( getPKey().getRequiredURLProtocolId(), forceRead );
		return( (ICFIntURLProtocolObj)retobj );
	}

	public ICFIntURLProtocolTableObj getURLProtocolTable() {
		return( ((ICFIntSchemaObj)schema).getURLProtocolTableObj() );
	}

	public ICFIntSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFIntSchemaObj value ) {
		schema = value;
	}

	public CFIntURLProtocolBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFIntSchema)schema.getBackingStore()).getFactoryURLProtocol().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFIntSchema)schema.getBackingStore()).getTableURLProtocol().readDerivedByIdIdx( ((ICFIntSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredURLProtocolId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFIntURLProtocolBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFIntURLProtocolBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFIntURLProtocolBuff" );
		}
		buff = value;
		copyBuffToPKey();
	}

	public CFIntURLProtocolBuff getURLProtocolBuff() {
		return( (CFIntURLProtocolBuff)getBuff() );
	}

	public CFIntURLProtocolPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFIntSchema)schema.getBackingStore()).getFactoryURLProtocol().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFIntURLProtocolPKey value ) {
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

	public ICFIntURLProtocolEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFIntURLProtocolObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFIntURLProtocolObj)this;
		}
		else {
			lockobj = ((ICFIntSchemaObj)schema).getURLProtocolTableObj().lockURLProtocol( getPKey() );
		}
		edit = ((ICFIntSchemaObj)schema).getURLProtocolTableObj().newEditInstance( lockobj );
		return( (ICFIntURLProtocolEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFIntURLProtocolEditObj getEdit() {
		return( edit );
	}

	public ICFIntURLProtocolEditObj getEditAsURLProtocol() {
		return( (ICFIntURLProtocolEditObj)edit );
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

	public int getRequiredURLProtocolId() {
		return( getPKey().getRequiredURLProtocolId() );
	}

	public String getRequiredName() {
		return( getURLProtocolBuff().getRequiredName() );
	}

	public String getRequiredDescription() {
		return( getURLProtocolBuff().getRequiredDescription() );
	}

	public boolean getRequiredIsSecure() {
		return( getURLProtocolBuff().getRequiredIsSecure() );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredURLProtocolId( getPKey().getRequiredURLProtocolId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredURLProtocolId( buff.getRequiredURLProtocolId() );
	}
}
