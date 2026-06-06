// Description: Java 11 edit object instance implementation for CFGenKb GenReference.

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

public class CFGenKbGenReferenceEditObj
	extends CFGenKbGenItemEditObj

	implements ICFGenKbGenReferenceEditObj
{

	public CFGenKbGenReferenceEditObj( ICFGenKbGenReferenceObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFGenKbGenReferenceObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GenReference" );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbGenReferenceObj retobj = getSchema().getGenReferenceTableObj().realiseGenReference( (ICFGenKbGenReferenceObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGenReference().getSchema()).getGenReferenceTableObj().forgetGenReference( getOrigAsGenReference(), forgetSubObjects );
	}

	public ICFGenKbGenItemObj create() {
		copyBuffToOrig();
		ICFGenKbGenReferenceObj retobj = ((ICFGenKbSchemaObj)getOrigAsGenReference().getSchema()).getGenReferenceTableObj().createGenReference( getOrigAsGenReference() );
		if( retobj == getOrigAsGenReference() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGenItemEditObj update() {
		getSchema().getGenReferenceTableObj().updateGenReference( (ICFGenKbGenReferenceObj)this );
		return( null );
	}

	public CFGenKbGenItemEditObj deleteInstance() {
		super.forget();
		getSchema().getGenReferenceTableObj().deleteGenReference( getOrigAsGenReference() );
		return( null );
	}

	public ICFGenKbGenReferenceTableObj getGenReferenceTable() {
		return( orig.getSchema().getGenReferenceTableObj() );
	}

	public ICFGenKbGenReferenceEditObj getEditAsGenReference() {
		return( (ICFGenKbGenReferenceEditObj)this );
	}

	public ICFGenKbGenReferenceObj getOrigAsGenReference() {
		return( (ICFGenKbGenReferenceObj)orig );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGenReference().getSchema().getBackingStore()).getFactoryGenReference().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFGenKbGenReferenceBuff getGenReferenceBuff() {
		return( (CFGenKbGenReferenceBuff)getBuff() );
	}

	public void copyBuffToOrig() {
		CFGenKbGenReferenceBuff origBuff = getOrigAsGenReference().getGenReferenceBuff();
		CFGenKbGenReferenceBuff myBuff = getGenReferenceBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGenReferenceBuff origBuff = getOrigAsGenReference().getGenReferenceBuff();
		CFGenKbGenReferenceBuff myBuff = getGenReferenceBuff();
		myBuff.set( origBuff );
	}
}
