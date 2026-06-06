// Description: Java 11 edit object instance implementation for CFBam Int32Col.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamInt32ColEditObj
	extends CFBamInt32DefEditObj

	implements ICFBamInt32ColEditObj
{
	protected ICFBamTableObj requiredContainerTable;

	public CFBamInt32ColEditObj( ICFBamInt32ColObj argOrig ) {
		super( argOrig );
		requiredContainerTable = null;
	}

	public String getClassCode() {
		return( CFBamInt32ColObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Int32Col" );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamInt32ColObj retobj = getSchema().getInt32ColTableObj().realiseInt32Col( (ICFBamInt32ColObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsInt32Col().getSchema()).getInt32ColTableObj().forgetInt32Col( getOrigAsInt32Col(), forgetSubObjects );
	}

	public ICFBamValueObj moveUp() {
		throw new CFLibUsageException( getClass(),
			"moveUp",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj moveDown() {
		throw new CFLibUsageException( getClass(),
			"moveDown",
			"You cannot move an edited object in the chain" );
	}

	public ICFBamValueObj create() {
		copyBuffToOrig();
		ICFBamInt32ColObj retobj = ((ICFBamSchemaObj)getOrigAsInt32Col().getSchema()).getInt32ColTableObj().createInt32Col( getOrigAsInt32Col() );
		if( retobj == getOrigAsInt32Col() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getInt32ColTableObj().updateInt32Col( (ICFBamInt32ColObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getInt32ColTableObj().deleteInt32Col( getOrigAsInt32Col() );
		return( null );
	}

	public ICFBamInt32ColTableObj getInt32ColTable() {
		return( orig.getSchema().getInt32ColTableObj() );
	}

	public ICFBamInt32ColEditObj getEditAsInt32Col() {
		return( (ICFBamInt32ColEditObj)this );
	}

	public ICFBamInt32ColObj getOrigAsInt32Col() {
		return( (ICFBamInt32ColObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsInt32Col().getSchema().getBackingStore()).getFactoryInt32Col().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerTable = null;
		}
	}

	public CFBamInt32ColBuff getInt32ColBuff() {
		return( (CFBamInt32ColBuff)getBuff() );
	}

	public long getRequiredTableId() {
		return( getInt32ColBuff().getRequiredTableId() );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
		final String S_ProcName = "CFBamInt32ColEditObj.setRequiredContainerScope() ";
		if( value == null ) {
			setRequiredContainerTable( null );
		}
		else if( ! ( value instanceof ICFBamTableObj ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRequiredContainerScope",
				"value",
				value,
				"ICFBamTableObj" );
		}
		else {
			setRequiredContainerTable( (ICFBamTableObj)value );
		}
	}

	public ICFBamTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	public ICFBamTableObj getRequiredContainerTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsInt32Col().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getInt32ColBuff().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					getInt32ColBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getInt32ColBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	public void setRequiredContainerTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getInt32ColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getInt32ColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getInt32ColBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerTable = value;
			super.setRequiredContainerScope( value );
	}

	public void copyBuffToOrig() {
		CFBamInt32ColBuff origBuff = getOrigAsInt32Col().getInt32ColBuff();
		CFBamInt32ColBuff myBuff = getInt32ColBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamInt32ColBuff origBuff = getOrigAsInt32Col().getInt32ColBuff();
		CFBamInt32ColBuff myBuff = getInt32ColBuff();
		myBuff.set( origBuff );
	}
}
