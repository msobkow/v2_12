// Description: Java 11 base object instance implementation for CFGenKb GenIterator.

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

public class CFGenKbGenIteratorObj
	extends CFGenKbGenItemObj
	implements ICFGenKbGenIteratorObj
{
	public final static String CLASS_CODE = "ITR";

	public CFGenKbGenIteratorObj() {
		super();
	}

	public CFGenKbGenIteratorObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GenIterator" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
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

	public ICFGenKbGenItemObj realise() {
		ICFGenKbGenIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().realiseGenIterator(
			(ICFGenKbGenIteratorObj)this );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().forgetGenIterator( (ICFGenKbGenIteratorObj)this, forgetSubObjects );
	}

	public ICFGenKbGenItemObj read() {
		ICFGenKbGenIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().readGenIteratorByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), false );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenItemObj read( boolean forceRead ) {
		ICFGenKbGenIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().readGenIteratorByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), forceRead );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenIteratorTableObj getGenIteratorTable() {
		return( ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj() );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenIterator().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenIterator().readDerivedByItemIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredCartridgeId(),
						getPKey().getRequiredItemId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGenIteratorBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGenIteratorBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public CFGenKbGenIteratorBuff getGenIteratorBuff() {
		return( (CFGenKbGenIteratorBuff)getBuff() );
	}

	public ICFGenKbGenItemEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGenIteratorObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGenIteratorObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().lockGenIterator( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGenIteratorTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGenItemEditObj)edit );
	}

	public ICFGenKbGenIteratorEditObj getEditAsGenIterator() {
		return( (ICFGenKbGenIteratorEditObj)edit );
	}
}
