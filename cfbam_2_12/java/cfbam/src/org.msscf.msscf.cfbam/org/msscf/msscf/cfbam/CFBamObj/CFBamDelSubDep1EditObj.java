// Description: Java 11 edit object instance implementation for CFBam DelSubDep1.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamDelSubDep1EditObj
	extends CFBamDelDepEditObj

	implements ICFBamDelSubDep1EditObj
{
	protected ICFBamDelTopDepObj requiredContainerDelTopDep;

	public CFBamDelSubDep1EditObj( ICFBamDelSubDep1Obj argOrig ) {
		super( argOrig );
		requiredContainerDelTopDep = null;
	}

	public String getClassCode() {
		return( CFBamDelSubDep1Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "DelSubDep1" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerDelTopDep();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamDelTopDepObj scope = getRequiredContainerDelTopDep();
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
		ICFBamDelSubDep1Obj retobj = getSchema().getDelSubDep1TableObj().realiseDelSubDep1( (ICFBamDelSubDep1Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelSubDep1TableObj().forgetDelSubDep1( getOrigAsDelSubDep1(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamDelSubDep1Obj retobj = ((ICFBamSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelSubDep1TableObj().createDelSubDep1( getOrigAsDelSubDep1() );
		if( retobj == getOrigAsDelSubDep1() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getDelSubDep1TableObj().updateDelSubDep1( (ICFBamDelSubDep1Obj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getDelSubDep1TableObj().deleteDelSubDep1( getOrigAsDelSubDep1() );
		return( null );
	}

	public ICFBamDelSubDep1TableObj getDelSubDep1Table() {
		return( orig.getSchema().getDelSubDep1TableObj() );
	}

	public ICFBamDelSubDep1EditObj getEditAsDelSubDep1() {
		return( (ICFBamDelSubDep1EditObj)this );
	}

	public ICFBamDelSubDep1Obj getOrigAsDelSubDep1() {
		return( (ICFBamDelSubDep1Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsDelSubDep1().getSchema().getBackingStore()).getFactoryDelSubDep1().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerDelTopDep = null;
		}
	}

	public CFBamDelSubDep1Buff getDelSubDep1Buff() {
		return( (CFBamDelSubDep1Buff)getBuff() );
	}

	public long getRequiredDelTopDepTenantId() {
		return( getDelSubDep1Buff().getRequiredDelTopDepTenantId() );
	}

	public long getRequiredDelTopDepId() {
		return( getDelSubDep1Buff().getRequiredDelTopDepId() );
	}

	public String getRequiredName() {
		return( getDelSubDep1Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getDelSubDep1Buff().getRequiredName() != value ) {
			getDelSubDep1Buff().setRequiredName( value );
		}
	}

	public ICFBamDelTopDepObj getRequiredContainerDelTopDep() {
		return( getRequiredContainerDelTopDep( false ) );
	}

	public ICFBamDelTopDepObj getRequiredContainerDelTopDep( boolean forceRead ) {
		if( forceRead || ( requiredContainerDelTopDep == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamDelTopDepObj obj = ((ICFBamSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelTopDepTableObj().readDelTopDepByIdIdx( getDelSubDep1Buff().getRequiredDelTopDepTenantId(),
					getDelSubDep1Buff().getRequiredDelTopDepId() );
				requiredContainerDelTopDep = obj;
				if( obj != null ) {
					getDelSubDep1Buff().setRequiredDelTopDepTenantId( obj.getRequiredTenantId() );
					getDelSubDep1Buff().setRequiredDelTopDepId( obj.getRequiredId() );
					requiredContainerDelTopDep = obj;
				}
			}
		}
		return( requiredContainerDelTopDep );
	}

	public void setRequiredContainerDelTopDep( ICFBamDelTopDepObj value ) {
			if( buff == null ) {
				getDelSubDep1Buff();
			}
			if( value != null ) {
				getDelSubDep1Buff().setRequiredDelTopDepTenantId( value.getRequiredTenantId() );
				getDelSubDep1Buff().setRequiredDelTopDepId( value.getRequiredId() );
			}
			requiredContainerDelTopDep = value;
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep() {
		List<ICFBamDelSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamDelSubDep2Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<ICFBamDelSubDep2Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamDelSubDep1Buff origBuff = getOrigAsDelSubDep1().getDelSubDep1Buff();
		CFBamDelSubDep1Buff myBuff = getDelSubDep1Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamDelSubDep1Buff origBuff = getOrigAsDelSubDep1().getDelSubDep1Buff();
		CFBamDelSubDep1Buff myBuff = getDelSubDep1Buff();
		myBuff.set( origBuff );
	}
}
