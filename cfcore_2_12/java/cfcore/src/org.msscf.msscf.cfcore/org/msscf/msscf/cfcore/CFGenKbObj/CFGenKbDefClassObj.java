// Description: Java 11 base object instance implementation for CFGenKb DefClass.

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

public class CFGenKbDefClassObj
	implements ICFGenKbDefClassObj
{
	public final static String CLASS_CODE = "DCL";
	protected boolean isNew;
	protected ICFGenKbDefClassEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbDefClassPKey pKey;
	protected CFGenKbDefClassBuff buff;
	protected ICFGenKbDefClassObj optionalParentBaseDefClass;

	public CFGenKbDefClassObj() {
		isNew = true;
		optionalParentBaseDefClass = null;
	}

	public CFGenKbDefClassObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		optionalParentBaseDefClass = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbDefClassObj retobj = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().realiseDefClass(
			(ICFGenKbDefClassObj)this );
		return( (ICFGenKbDefClassObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getDefClassTableObj().forgetDefClass( (ICFGenKbDefClassObj)this, forgetSubObjects );
	}

	public ICFGenKbDefClassObj read() {
		ICFGenKbDefClassObj retobj = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().readDefClassByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFGenKbDefClassObj)retobj );
	}

	public ICFGenKbDefClassObj read( boolean forceRead ) {
		ICFGenKbDefClassObj retobj = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().readDefClassByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFGenKbDefClassObj)retobj );
	}

	public ICFGenKbDefClassTableObj getDefClassTable() {
		return( ((ICFGenKbSchemaObj)schema).getDefClassTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbDefClassBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableDefClass().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbDefClassBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbDefClassBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbDefClassBuff" );
		}
		buff = value;
		copyBuffToPKey();
		optionalParentBaseDefClass = null;
	}

	public CFGenKbDefClassBuff getDefClassBuff() {
		return( (CFGenKbDefClassBuff)getBuff() );
	}

	public CFGenKbDefClassPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryDefClass().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbDefClassPKey value ) {
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

	public ICFGenKbDefClassEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbDefClassObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbDefClassObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().lockDefClass( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().newEditInstance( lockobj );
		return( (ICFGenKbDefClassEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbDefClassEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbDefClassEditObj getEditAsDefClass() {
		return( (ICFGenKbDefClassEditObj)edit );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getDefClassBuff().getRequiredName() );
	}

	public Short getOptionalBaseId() {
		return( getDefClassBuff().getOptionalBaseId() );
	}

	public ICFGenKbDefClassObj getOptionalParentBaseDefClass() {
		return( getOptionalParentBaseDefClass( false ) );
	}

	public ICFGenKbDefClassObj getOptionalParentBaseDefClass( boolean forceRead ) {
		if( ( optionalParentBaseDefClass == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getDefClassBuff().getOptionalBaseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalParentBaseDefClass = ((ICFGenKbSchemaObj)schema).getDefClassTableObj().readDefClassByIdIdx( getDefClassBuff().getOptionalBaseId(), forceRead );
			}
		}
		return( optionalParentBaseDefClass );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
