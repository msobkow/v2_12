// Description: Java 11 edit object instance implementation for CFBam FloatCol.

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

public class CFBamFloatColEditObj
	extends CFBamFloatDefEditObj

	implements ICFBamFloatColEditObj
{
	protected ICFBamTableObj requiredContainerTable;

	public CFBamFloatColEditObj( ICFBamFloatColObj argOrig ) {
		super( argOrig );
		requiredContainerTable = null;
	}

	public String getClassCode() {
		return( CFBamFloatColObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "FloatCol" );
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
		ICFBamFloatColObj retobj = getSchema().getFloatColTableObj().realiseFloatCol( (ICFBamFloatColObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsFloatCol().getSchema()).getFloatColTableObj().forgetFloatCol( getOrigAsFloatCol(), forgetSubObjects );
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
		ICFBamFloatColObj retobj = ((ICFBamSchemaObj)getOrigAsFloatCol().getSchema()).getFloatColTableObj().createFloatCol( getOrigAsFloatCol() );
		if( retobj == getOrigAsFloatCol() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getFloatColTableObj().updateFloatCol( (ICFBamFloatColObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getFloatColTableObj().deleteFloatCol( getOrigAsFloatCol() );
		return( null );
	}

	public ICFBamFloatColTableObj getFloatColTable() {
		return( orig.getSchema().getFloatColTableObj() );
	}

	public ICFBamFloatColEditObj getEditAsFloatCol() {
		return( (ICFBamFloatColEditObj)this );
	}

	public ICFBamFloatColObj getOrigAsFloatCol() {
		return( (ICFBamFloatColObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsFloatCol().getSchema().getBackingStore()).getFactoryFloatCol().newBuff();
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

	public CFBamFloatColBuff getFloatColBuff() {
		return( (CFBamFloatColBuff)getBuff() );
	}

	public long getRequiredTableId() {
		return( getFloatColBuff().getRequiredTableId() );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
		final String S_ProcName = "CFBamFloatColEditObj.setRequiredContainerScope() ";
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
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsFloatCol().getSchema()).getTableTableObj().readTableByIdIdx( getPKey().getRequiredTenantId(),
					getFloatColBuff().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					getFloatColBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getFloatColBuff().setRequiredTableId( obj.getRequiredId() );
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	public void setRequiredContainerTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getFloatColBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getFloatColBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getFloatColBuff().setRequiredTableId( value.getRequiredId() );
			}
			requiredContainerTable = value;
			super.setRequiredContainerScope( value );
	}

	public void copyBuffToOrig() {
		CFBamFloatColBuff origBuff = getOrigAsFloatCol().getFloatColBuff();
		CFBamFloatColBuff myBuff = getFloatColBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamFloatColBuff origBuff = getOrigAsFloatCol().getFloatColBuff();
		CFBamFloatColBuff myBuff = getFloatColBuff();
		myBuff.set( origBuff );
	}
}
