// Description: Java 11 edit object instance implementation for CFGenKb DefClass.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbDefClassEditObj
	implements ICFGenKbDefClassEditObj
{
	protected ICFGenKbDefClassObj orig;
	protected CFGenKbDefClassBuff buff;
	protected ICFGenKbDefClassObj optionalParentBaseDefClass;

	public CFGenKbDefClassEditObj( ICFGenKbDefClassObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbDefClassBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		optionalParentBaseDefClass = null;
	}

	public String getClassCode() {
		return( CFGenKbDefClassObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DefClass" );
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

	public ICFGenKbDefClassObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbDefClassObj retobj = getSchema().getDefClassTableObj().realiseDefClass( (ICFGenKbDefClassObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsDefClass().getSchema()).getDefClassTableObj().forgetDefClass( getOrigAsDefClass(), forgetSubObjects );
	}

	public ICFGenKbDefClassObj read() {
		ICFGenKbDefClassObj retval = getOrigAsDefClass().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbDefClassObj read( boolean forceRead ) {
		ICFGenKbDefClassObj retval = getOrigAsDefClass().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbDefClassObj create() {
		copyBuffToOrig();
		ICFGenKbDefClassObj retobj = ((ICFGenKbSchemaObj)getOrigAsDefClass().getSchema()).getDefClassTableObj().createDefClass( getOrigAsDefClass() );
		if( retobj == getOrigAsDefClass() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbDefClassEditObj update() {
		getSchema().getDefClassTableObj().updateDefClass( (ICFGenKbDefClassObj)this );
		return( null );
	}

	public CFGenKbDefClassEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getDefClassTableObj().deleteDefClass( getOrigAsDefClass() );
		return( null );
	}

	public ICFGenKbDefClassTableObj getDefClassTable() {
		return( orig.getSchema().getDefClassTableObj() );
	}

	public ICFGenKbDefClassEditObj getEdit() {
		return( (ICFGenKbDefClassEditObj)this );
	}

	public ICFGenKbDefClassEditObj getEditAsDefClass() {
		return( (ICFGenKbDefClassEditObj)this );
	}

	public ICFGenKbDefClassEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbDefClassObj getOrig() {
		return( orig );
	}

	public ICFGenKbDefClassObj getOrigAsDefClass() {
		return( (ICFGenKbDefClassObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbDefClassBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsDefClass().getSchema().getBackingStore()).getFactoryDefClass().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbDefClassBuff value ) {
		if( buff != value ) {
			buff = value;
			optionalParentBaseDefClass = null;
		}
	}

	public CFGenKbDefClassBuff getDefClassBuff() {
		return( (CFGenKbDefClassBuff)getBuff() );
	}

	public CFGenKbDefClassPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbDefClassPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getDefClassBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDefClassBuff().getRequiredName() != value ) {
			getDefClassBuff().setRequiredName( value );
		}
	}

	public Short getOptionalBaseId() {
		return( getDefClassBuff().getOptionalBaseId() );
	}

	public ICFGenKbDefClassObj getOptionalParentBaseDefClass() {
		return( getOptionalParentBaseDefClass( false ) );
	}

	public ICFGenKbDefClassObj getOptionalParentBaseDefClass( boolean forceRead ) {
		if( forceRead || ( optionalParentBaseDefClass == null ) ) {
			boolean anyMissing = false;
			if( getDefClassBuff().getOptionalBaseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbDefClassObj obj = ((ICFGenKbSchemaObj)getOrigAsDefClass().getSchema()).getDefClassTableObj().readDefClassByIdIdx( getDefClassBuff().getOptionalBaseId() );
				optionalParentBaseDefClass = obj;
			}
		}
		return( optionalParentBaseDefClass );
	}

	public void setOptionalParentBaseDefClass( ICFGenKbDefClassObj value ) {
			if( buff == null ) {
				getDefClassBuff();
			}
			if( value != null ) {
				getDefClassBuff().setOptionalBaseId( value.getRequiredId() );
			}
			else {
				getDefClassBuff().setOptionalBaseId( null );
			}
			optionalParentBaseDefClass = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbDefClassBuff origBuff = getOrigAsDefClass().getDefClassBuff();
		CFGenKbDefClassBuff myBuff = getDefClassBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbDefClassBuff origBuff = getOrigAsDefClass().getDefClassBuff();
		CFGenKbDefClassBuff myBuff = getDefClassBuff();
		myBuff.set( origBuff );
	}
}
