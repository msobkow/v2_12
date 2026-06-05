// Description: Java 11 edit object instance implementation for CFBam ClearSubDep2.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamClearSubDep2EditObj
	extends CFBamClearDepEditObj

	implements ICFBamClearSubDep2EditObj
{
	protected ICFBamClearSubDep1Obj requiredContainerClearSubDep1;

	public CFBamClearSubDep2EditObj( ICFBamClearSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerClearSubDep1 = null;
	}

	public String getClassCode() {
		return( CFBamClearSubDep2Obj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ClearSubDep2" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerClearSubDep1();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamClearSubDep1Obj scope = getRequiredContainerClearSubDep1();
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
		ICFBamClearSubDep2Obj retobj = getSchema().getClearSubDep2TableObj().realiseClearSubDep2( (ICFBamClearSubDep2Obj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep2TableObj().forgetClearSubDep2( getOrigAsClearSubDep2(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamClearSubDep2Obj retobj = ((ICFBamSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep2TableObj().createClearSubDep2( getOrigAsClearSubDep2() );
		if( retobj == getOrigAsClearSubDep2() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getClearSubDep2TableObj().updateClearSubDep2( (ICFBamClearSubDep2Obj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getClearSubDep2TableObj().deleteClearSubDep2( getOrigAsClearSubDep2() );
		return( null );
	}

	public ICFBamClearSubDep2TableObj getClearSubDep2Table() {
		return( orig.getSchema().getClearSubDep2TableObj() );
	}

	public ICFBamClearSubDep2EditObj getEditAsClearSubDep2() {
		return( (ICFBamClearSubDep2EditObj)this );
	}

	public ICFBamClearSubDep2Obj getOrigAsClearSubDep2() {
		return( (ICFBamClearSubDep2Obj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsClearSubDep2().getSchema().getBackingStore()).getFactoryClearSubDep2().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerClearSubDep1 = null;
		}
	}

	public CFBamClearSubDep2Buff getClearSubDep2Buff() {
		return( (CFBamClearSubDep2Buff)getBuff() );
	}

	public long getRequiredClearSubDep1TenantId() {
		return( getClearSubDep2Buff().getRequiredClearSubDep1TenantId() );
	}

	public long getRequiredClearSubDep1Id() {
		return( getClearSubDep2Buff().getRequiredClearSubDep1Id() );
	}

	public String getRequiredName() {
		return( getClearSubDep2Buff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getClearSubDep2Buff().getRequiredName() != value ) {
			getClearSubDep2Buff().setRequiredName( value );
		}
	}

	public ICFBamClearSubDep1Obj getRequiredContainerClearSubDep1() {
		return( getRequiredContainerClearSubDep1( false ) );
	}

	public ICFBamClearSubDep1Obj getRequiredContainerClearSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerClearSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamClearSubDep1Obj obj = ((ICFBamSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep1TableObj().readClearSubDep1ByIdIdx( getClearSubDep2Buff().getRequiredClearSubDep1TenantId(),
					getClearSubDep2Buff().getRequiredClearSubDep1Id() );
				requiredContainerClearSubDep1 = obj;
				if( obj != null ) {
					getClearSubDep2Buff().setRequiredClearSubDep1TenantId( obj.getRequiredTenantId() );
					getClearSubDep2Buff().setRequiredClearSubDep1Id( obj.getRequiredId() );
					requiredContainerClearSubDep1 = obj;
				}
			}
		}
		return( requiredContainerClearSubDep1 );
	}

	public void setRequiredContainerClearSubDep1( ICFBamClearSubDep1Obj value ) {
			if( buff == null ) {
				getClearSubDep2Buff();
			}
			if( value != null ) {
				getClearSubDep2Buff().setRequiredClearSubDep1TenantId( value.getRequiredTenantId() );
				getClearSubDep2Buff().setRequiredClearSubDep1Id( value.getRequiredId() );
			}
			requiredContainerClearSubDep1 = value;
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep() {
		List<ICFBamClearSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamClearSubDep3Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<ICFBamClearSubDep3Obj> retval;
		retval = ((ICFBamSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public void copyBuffToOrig() {
		CFBamClearSubDep2Buff origBuff = getOrigAsClearSubDep2().getClearSubDep2Buff();
		CFBamClearSubDep2Buff myBuff = getClearSubDep2Buff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamClearSubDep2Buff origBuff = getOrigAsClearSubDep2().getClearSubDep2Buff();
		CFBamClearSubDep2Buff myBuff = getClearSubDep2Buff();
		myBuff.set( origBuff );
	}
}
