// Description: Java 11 edit object instance implementation for CFGenKb GelIterator.

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

public class CFGenKbGelIteratorEditObj
	extends CFGenKbGelInstructionEditObj

	implements ICFGenKbGelIteratorEditObj
{

	public CFGenKbGelIteratorEditObj( ICFGenKbGelIteratorObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFGenKbGelIteratorObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelIterator" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredGelInstId();
		objName = Long.toString( val );
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

	public ICFGenKbGelInstructionObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGelIteratorObj retobj = getSchema().getGelIteratorTableObj().realiseGelIterator( (ICFGenKbGelIteratorObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelIterator().getSchema()).getGelIteratorTableObj().forgetGelIterator( getOrigAsGelIterator(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelIteratorObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelIterator().getSchema()).getGelIteratorTableObj().createGelIterator( getOrigAsGelIterator() );
		if( retobj == getOrigAsGelIterator() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelIteratorTableObj().updateGelIterator( (ICFGenKbGelIteratorObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		super.forget();
		getSchema().getGelIteratorTableObj().deleteGelIterator( getOrigAsGelIterator() );
		return( null );
	}

	public ICFGenKbGelIteratorTableObj getGelIteratorTable() {
		return( orig.getSchema().getGelIteratorTableObj() );
	}

	public ICFGenKbGelIteratorEditObj getEditAsGelIterator() {
		return( (ICFGenKbGelIteratorEditObj)this );
	}

	public ICFGenKbGelIteratorObj getOrigAsGelIterator() {
		return( (ICFGenKbGelIteratorObj)orig );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelIterator().getSchema().getBackingStore()).getFactoryGelIterator().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFGenKbGelIteratorBuff getGelIteratorBuff() {
		return( (CFGenKbGelIteratorBuff)getBuff() );
	}

	public String getRequiredIteratorName() {
		return( getGelIteratorBuff().getRequiredIteratorName() );
	}

	public void setRequiredIteratorName( String value ) {
		if( getGelIteratorBuff().getRequiredIteratorName() != value ) {
			getGelIteratorBuff().setRequiredIteratorName( value );
		}
	}

	public String getOptionalExpandBefore() {
		return( getGelIteratorBuff().getOptionalExpandBefore() );
	}

	public void setOptionalExpandBefore( String value ) {
		if( getGelIteratorBuff().getOptionalExpandBefore() != value ) {
			getGelIteratorBuff().setOptionalExpandBefore( value );
		}
	}

	public String getOptionalExpandFirst() {
		return( getGelIteratorBuff().getOptionalExpandFirst() );
	}

	public void setOptionalExpandFirst( String value ) {
		if( getGelIteratorBuff().getOptionalExpandFirst() != value ) {
			getGelIteratorBuff().setOptionalExpandFirst( value );
		}
	}

	public String getRequiredExpandEach() {
		return( getGelIteratorBuff().getRequiredExpandEach() );
	}

	public void setRequiredExpandEach( String value ) {
		if( getGelIteratorBuff().getRequiredExpandEach() != value ) {
			getGelIteratorBuff().setRequiredExpandEach( value );
		}
	}

	public String getOptionalExpandLast() {
		return( getGelIteratorBuff().getOptionalExpandLast() );
	}

	public void setOptionalExpandLast( String value ) {
		if( getGelIteratorBuff().getOptionalExpandLast() != value ) {
			getGelIteratorBuff().setOptionalExpandLast( value );
		}
	}

	public String getOptionalExpandLone() {
		return( getGelIteratorBuff().getOptionalExpandLone() );
	}

	public void setOptionalExpandLone( String value ) {
		if( getGelIteratorBuff().getOptionalExpandLone() != value ) {
			getGelIteratorBuff().setOptionalExpandLone( value );
		}
	}

	public String getOptionalExpandEmpty() {
		return( getGelIteratorBuff().getOptionalExpandEmpty() );
	}

	public void setOptionalExpandEmpty( String value ) {
		if( getGelIteratorBuff().getOptionalExpandEmpty() != value ) {
			getGelIteratorBuff().setOptionalExpandEmpty( value );
		}
	}

	public String getOptionalExpandAfter() {
		return( getGelIteratorBuff().getOptionalExpandAfter() );
	}

	public void setOptionalExpandAfter( String value ) {
		if( getGelIteratorBuff().getOptionalExpandAfter() != value ) {
			getGelIteratorBuff().setOptionalExpandAfter( value );
		}
	}

	public void copyBuffToOrig() {
		CFGenKbGelIteratorBuff origBuff = getOrigAsGelIterator().getGelIteratorBuff();
		CFGenKbGelIteratorBuff myBuff = getGelIteratorBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelIteratorBuff origBuff = getOrigAsGelIterator().getGelIteratorBuff();
		CFGenKbGelIteratorBuff myBuff = getGelIteratorBuff();
		myBuff.set( origBuff );
	}
}
