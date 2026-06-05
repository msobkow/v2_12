// Description: Java 11 edit object instance implementation for CFBam TimestampType.

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

public class CFBamTimestampTypeEditObj
	extends CFBamTimestampDefEditObj

	implements ICFBamTimestampTypeEditObj
{
	protected ICFBamSchemaDefObj requiredContainerSchemaDef;

	public CFBamTimestampTypeEditObj( ICFBamTimestampTypeObj argOrig ) {
		super( argOrig );
		requiredContainerSchemaDef = null;
	}

	public String getClassCode() {
		return( CFBamTimestampTypeObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "TimestampType" );
	}

	public ICFLibAnyObj getScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFBamSchemaDefObj scope = getRequiredContainerSchemaDef();
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
		ICFBamTimestampTypeObj retobj = getSchema().getTimestampTypeTableObj().realiseTimestampType( (ICFBamTimestampTypeObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFBamSchemaObj)getOrigAsTimestampType().getSchema()).getTimestampTypeTableObj().forgetTimestampType( getOrigAsTimestampType(), forgetSubObjects );
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
		ICFBamTimestampTypeObj retobj = ((ICFBamSchemaObj)getOrigAsTimestampType().getSchema()).getTimestampTypeTableObj().createTimestampType( getOrigAsTimestampType() );
		if( retobj == getOrigAsTimestampType() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFBamValueEditObj update() {
		getSchema().getTimestampTypeTableObj().updateTimestampType( (ICFBamTimestampTypeObj)this );
		return( null );
	}

	public CFBamValueEditObj deleteInstance() {
		super.forget();
		getSchema().getTimestampTypeTableObj().deleteTimestampType( getOrigAsTimestampType() );
		return( null );
	}

	public ICFBamTimestampTypeTableObj getTimestampTypeTable() {
		return( orig.getSchema().getTimestampTypeTableObj() );
	}

	public ICFBamTimestampTypeEditObj getEditAsTimestampType() {
		return( (ICFBamTimestampTypeEditObj)this );
	}

	public ICFBamTimestampTypeObj getOrigAsTimestampType() {
		return( (ICFBamTimestampTypeObj)orig );
	}

	public CFBamValueBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFBamSchema)getOrigAsTimestampType().getSchema().getBackingStore()).getFactoryTimestampType().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFBamValueBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			requiredContainerSchemaDef = null;
		}
	}

	public CFBamTimestampTypeBuff getTimestampTypeBuff() {
		return( (CFBamTimestampTypeBuff)getBuff() );
	}

	public long getRequiredSchemaDefId() {
		return( getTimestampTypeBuff().getRequiredSchemaDefId() );
	}

	public void setRequiredContainerScope( ICFBamScopeObj value ) {
		final String S_ProcName = "CFBamTimestampTypeEditObj.setRequiredContainerScope() ";
		if( value == null ) {
			setRequiredContainerSchemaDef( null );
		}
		else if( ! ( value instanceof ICFBamSchemaDefObj ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setRequiredContainerScope",
				"value",
				value,
				"ICFBamSchemaDefObj" );
		}
		else {
			setRequiredContainerSchemaDef( (ICFBamSchemaDefObj)value );
		}
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	public ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchemaDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFBamSchemaDefObj obj = ((ICFBamSchemaObj)getOrigAsTimestampType().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
					getTimestampTypeBuff().getRequiredSchemaDefId() );
				requiredContainerSchemaDef = obj;
				if( obj != null ) {
					getTimestampTypeBuff().setRequiredTenantId( obj.getRequiredTenantId() );
					getTimestampTypeBuff().setRequiredSchemaDefId( obj.getRequiredId() );
					requiredContainerSchemaDef = obj;
				}
			}
		}
		return( requiredContainerSchemaDef );
	}

	public void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value ) {
			if( buff == null ) {
				getTimestampTypeBuff();
			}
			if( value != null ) {
				getPKey().setRequiredTenantId( value.getRequiredTenantId() );
				getTimestampTypeBuff().setRequiredTenantId( value.getRequiredTenantId() );
				getTimestampTypeBuff().setRequiredSchemaDefId( value.getRequiredId() );
			}
			requiredContainerSchemaDef = value;
			super.setRequiredContainerScope( value );
	}

	public void copyBuffToOrig() {
		CFBamTimestampTypeBuff origBuff = getOrigAsTimestampType().getTimestampTypeBuff();
		CFBamTimestampTypeBuff myBuff = getTimestampTypeBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFBamTimestampTypeBuff origBuff = getOrigAsTimestampType().getTimestampTypeBuff();
		CFBamTimestampTypeBuff myBuff = getTimestampTypeBuff();
		myBuff.set( origBuff );
	}
}
