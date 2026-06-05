// Description: Java 11 edit object instance implementation for CFBam ServerListFunc.

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

public class CFBamServerListFuncEditObj
	extends CFBamServerMethodEditObj

	implements ICFBamServerListFuncEditObj
{
	protected ICFBamTableObj optionalLookupRetTable;

	public CFBamServerListFuncEditObj( ICFBamServerListFuncObj argOrig ) {
		super( argOrig );
		optionalLookupRetTable = null;
	}

	public String getClassCode() {
		return( CFBamServerListFuncObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ServerListFunc" );
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
		ICFBamServerListFuncObj retobj = getSchema().getServerListFuncTableObj().realiseServerListFunc( (ICFBamServerListFuncObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsServerListFunc().getSchema()).getServerListFuncTableObj().forgetServerListFunc( getOrigAsServerListFunc(), forgetSubObjects );
	}

	public ICFBamScopeObj create() {
		copyBuffToOrig();
		ICFBamServerListFuncObj retobj = ((ICFBamSchemaObj)getOrigAsServerListFunc().getSchema()).getServerListFuncTableObj().createServerListFunc( getOrigAsServerListFunc() );
		if( retobj == getOrigAsServerListFunc() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamScopeEditObj update() {
		getSchema().getServerListFuncTableObj().updateServerListFunc( (ICFBamServerListFuncObj)this );
		return( null );
	}

	public CFBamScopeEditObj deleteInstance() {
		super.forget();
		getSchema().getServerListFuncTableObj().deleteServerListFunc( getOrigAsServerListFunc() );
		return( null );
	}

	public ICFBamServerListFuncTableObj getServerListFuncTable() {
		return( orig.getSchema().getServerListFuncTableObj() );
	}

	public ICFBamServerListFuncEditObj getEditAsServerListFunc() {
		return( (ICFBamServerListFuncEditObj)this );
	}

	public ICFBamServerListFuncObj getOrigAsServerListFunc() {
		return( (ICFBamServerListFuncObj)orig );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsServerListFunc().getSchema().getBackingStore()).getFactoryServerListFunc().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalLookupRetTable = null;
		}
	}

	public CFBamServerListFuncBuff getServerListFuncBuff() {
		return( (CFBamServerListFuncBuff)getBuff() );
	}

	public Long getOptionalRetTenantId() {
		return( getServerListFuncBuff().getOptionalRetTenantId() );
	}

	public Long getOptionalRetTableId() {
		return( getServerListFuncBuff().getOptionalRetTableId() );
	}

	public ICFBamTableObj getOptionalLookupRetTable() {
		return( getOptionalLookupRetTable( false ) );
	}

	public ICFBamTableObj getOptionalLookupRetTable( boolean forceRead ) {
		if( forceRead || ( optionalLookupRetTable == null ) ) {
			boolean anyMissing = false;
			if( getServerListFuncBuff().getOptionalRetTenantId() == null ) {
				anyMissing = true;
			}
			if( getServerListFuncBuff().getOptionalRetTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFBamTableObj obj = ((ICFBamSchemaObj)getOrigAsServerListFunc().getSchema()).getTableTableObj().readTableByIdIdx( getServerListFuncBuff().getOptionalRetTenantId(),
					getServerListFuncBuff().getOptionalRetTableId() );
				optionalLookupRetTable = obj;
			}
		}
		return( optionalLookupRetTable );
	}

	public void setOptionalLookupRetTable( ICFBamTableObj value ) {
			if( buff == null ) {
				getServerListFuncBuff();
			}
			if( value != null ) {
				getServerListFuncBuff().setOptionalRetTenantId( value.getRequiredTenantId() );
				getServerListFuncBuff().setOptionalRetTableId( value.getRequiredId() );
			}
			else {
				getServerListFuncBuff().setOptionalRetTenantId( null );
				getServerListFuncBuff().setOptionalRetTableId( null );
			}
			optionalLookupRetTable = value;
	}

	public void copyBuffToOrig() {
		CFBamServerListFuncBuff origBuff = getOrigAsServerListFunc().getServerListFuncBuff();
		CFBamServerListFuncBuff myBuff = getServerListFuncBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamServerListFuncBuff origBuff = getOrigAsServerListFunc().getServerListFuncBuff();
		CFBamServerListFuncBuff myBuff = getServerListFuncBuff();
		myBuff.set( origBuff );
	}
}
