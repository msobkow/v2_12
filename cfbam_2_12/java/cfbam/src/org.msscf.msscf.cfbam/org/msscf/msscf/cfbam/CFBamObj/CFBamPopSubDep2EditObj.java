// Description: Java 11 edit object instance implementation for CFBam PopSubDep2.

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

public class CFBamPopSubDep2EditObj
	extends CFBamPopDepEditObj

	implements ICFBamPopSubDep2EditObj
{
	protected ICFBamPopSubDep1Obj requiredContainerPopSubDep1;

	public CFBamPopSubDep2EditObj( ICFBamPopSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerPopSubDep1 = null;
	}

	public String getClassCode() {
		return( CFBamPopSubDep2Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "PopSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamPopSubDep1Obj scope = getRequiredContainerPopSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamPopSubDep1Obj scope = getRequiredContainerPopSubDep1();
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

	public ICFBamScopeObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFBamPopSubDep2Obj retobj = getSchema().getPopSubDep2TableObj().realisePopSubDep2( (ICFBamPopSubDep2Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsPopSubDep2().getSchema()).getPopSubDep2TableObj().forgetPopSubDep2( getOrigAsPopSubDep2(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamPopSubDep2Obj retobj = ((ICFBamSchemaObj)getOrigAsPopSubDep2().getSchema()).getPopSubDep2TableObj().createPopSubDep2( getOrigAsPopSubDep2() );
		if( retobj == getOrigAsPopSubDep2() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getPopSubDep2TableObj().updatePopSubDep2( (ICFBamPopSubDep2Obj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getPopSubDep2TableObj().deletePopSubDep2( getOrigAsPopSubDep2() );
		return( null );
	}

	public ICFBamPopSubDep2TableObj getPopSubDep2Table() {
		return( orig.getSchema().getPopSubDep2TableObj() );
	}

	public ICFBamPopSubDep2EditObj getEditAsPopSubDep2() {
		return( (ICFBamPopSubDep2EditObj)this );
	}

	public ICFBamPopSubDep2Obj getOrigAsPopSubDep2() {
		return( (ICFBamPopSubDep2Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsPopSubDep2().getSchema().getBackingStore()).getFactoryPopSubDep2().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerPopSubDep1 = null;
		}
	}

	public CFBamPopSubDep2Buff getPopSubDep2Buff() {
		return( (CFBamPopSubDep2Buff)getBuff() );
	}

	public long getRequiredPopSubDep1TenantId() {
		return( getPopSubDep2Buff().getRequiredPopSubDep1TenantId() );
	}

	public long getRequiredPopSubDep1Id() {
		return( getPopSubDep2Buff().getRequiredPopSubDep1Id() );
	}

	public String getRequiredName() {
		return( getPopSubDep2Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getPopSubDep2Buff().getRequiredName() != value ) {
			getPopSubDep2Buff().setRequiredName( value );
		}
	}

	public ICFBamPopSubDep1Obj getRequiredContainerPopSubDep1() {
		return( getRequiredContainerPopSubDep1( false ) );
	}

	public ICFBamPopSubDep1Obj getRequiredContainerPopSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerPopSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamPopSubDep1Obj obj = ((ICFBamSchemaObj)getOrigAsPopSubDep2().getSchema()).getPopSubDep1TableObj().readPopSubDep1ByIdIdx( getPopSubDep2Buff().getRequiredPopSubDep1TenantId(),
					getPopSubDep2Buff().getRequiredPopSubDep1Id() );
				requiredContainerPopSubDep1 = obj;
				if( obj != null ) {
					getPopSubDep2Buff().setRequiredPopSubDep1TenantId( obj.getRequiredTenantId() );
					getPopSubDep2Buff().setRequiredPopSubDep1Id( obj.getRequiredId() );
					requiredContainerPopSubDep1 = obj;
				}
			}
		}
		return( requiredContainerPopSubDep1 );
	}

	public void setRequiredContainerPopSubDep1( ICFBamPopSubDep1Obj value ) {
			if( buff == null ) {
				getPopSubDep2Buff();
			}
			if( value != null ) {
				getPopSubDep2Buff().setRequiredPopSubDep1TenantId( value.getRequiredTenantId() );
				getPopSubDep2Buff().setRequiredPopSubDep1Id( value.getRequiredId() );
			}
			requiredContainerPopSubDep1 = value;
	}

	public List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep() {
		List<ICFBamPopSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsPopSubDep2().getSchema()).getPopSubDep3TableObj().readPopSubDep3ByPopSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<ICFBamPopSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsPopSubDep2().getSchema()).getPopSubDep3TableObj().readPopSubDep3ByPopSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamPopSubDep2Buff origBuff = getOrigAsPopSubDep2().getPopSubDep2Buff();
		CFBamPopSubDep2Buff myBuff = getPopSubDep2Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamPopSubDep2Buff origBuff = getOrigAsPopSubDep2().getPopSubDep2Buff();
		CFBamPopSubDep2Buff myBuff = getPopSubDep2Buff();
		myBuff.set( origBuff );
	}
}
