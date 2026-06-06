// Description: Java 11 edit object instance implementation for CFGenKb GelCall.

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

public class CFGenKbGelCallEditObj
	extends CFGenKbGelInstructionEditObj

	implements ICFGenKbGelCallEditObj
{
	protected ICFGenKbGelSequenceObj optionalParentSeqInst;
	protected ICFGenKbGelInstructionObj optionalLookupCallInst;
	protected ICFGenKbGelCallObj optionalLookupPrevInst;
	protected ICFGenKbGelCallObj optionalLookupNextInst;

	public CFGenKbGelCallEditObj( ICFGenKbGelCallObj argOrig ) {
		super( argOrig );
		optionalParentSeqInst = null;
		optionalLookupCallInst = null;
		optionalLookupPrevInst = null;
		optionalLookupNextInst = null;
	}

	public String getClassCode() {
		return( CFGenKbGelCallObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelCall" );
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
		ICFGenKbGelCallObj retobj = getSchema().getGelCallTableObj().realiseGelCall( (ICFGenKbGelCallObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelCallTableObj().forgetGelCall( getOrigAsGelCall(), forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj create() {
		copyBuffToOrig();
		ICFGenKbGelCallObj retobj = ((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelCallTableObj().createGelCall( getOrigAsGelCall() );
		if( retobj == getOrigAsGelCall() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGelInstructionEditObj update() {
		getSchema().getGelCallTableObj().updateGelCall( (ICFGenKbGelCallObj)this );
		return( null );
	}

	public CFGenKbGelInstructionEditObj deleteInstance() {
		super.forget();
		getSchema().getGelCallTableObj().deleteGelCall( getOrigAsGelCall() );
		return( null );
	}

	public ICFGenKbGelCallTableObj getGelCallTable() {
		return( orig.getSchema().getGelCallTableObj() );
	}

	public ICFGenKbGelCallEditObj getEditAsGelCall() {
		return( (ICFGenKbGelCallEditObj)this );
	}

	public ICFGenKbGelCallObj getOrigAsGelCall() {
		return( (ICFGenKbGelCallObj)orig );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGelCall().getSchema().getBackingStore()).getFactoryGelCall().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
			optionalParentSeqInst = null;
			optionalLookupCallInst = null;
			optionalLookupPrevInst = null;
			optionalLookupNextInst = null;
		}
	}

	public CFGenKbGelCallBuff getGelCallBuff() {
		return( (CFGenKbGelCallBuff)getBuff() );
	}

	public Long getOptionalSeqInstTenantId() {
		return( getGelCallBuff().getOptionalSeqInstTenantId() );
	}

	public Long getOptionalSeqInstGelCacheId() {
		return( getGelCallBuff().getOptionalSeqInstGelCacheId() );
	}

	public Long getOptionalSeqInstId() {
		return( getGelCallBuff().getOptionalSeqInstId() );
	}

	public Long getOptionalCallInstTenantId() {
		return( getGelCallBuff().getOptionalCallInstTenantId() );
	}

	public Long getOptionalCallInstGelCacheId() {
		return( getGelCallBuff().getOptionalCallInstGelCacheId() );
	}

	public Long getOptionalCallInstId() {
		return( getGelCallBuff().getOptionalCallInstId() );
	}

	public Long getOptionalPrevInstTenantId() {
		return( getGelCallBuff().getOptionalPrevInstTenantId() );
	}

	public Long getOptionalPrevInstGelCacheId() {
		return( getGelCallBuff().getOptionalPrevInstGelCacheId() );
	}

	public Long getOptionalPrevInstGelInstId() {
		return( getGelCallBuff().getOptionalPrevInstGelInstId() );
	}

	public Long getOptionalNextInstTenantId() {
		return( getGelCallBuff().getOptionalNextInstTenantId() );
	}

	public Long getOptionalNextInstGelCacheId() {
		return( getGelCallBuff().getOptionalNextInstGelCacheId() );
	}

	public Long getOptionalNextInstGelInstId() {
		return( getGelCallBuff().getOptionalNextInstGelInstId() );
	}

	public ICFGenKbGelSequenceObj getOptionalParentSeqInst() {
		return( getOptionalParentSeqInst( false ) );
	}

	public ICFGenKbGelSequenceObj getOptionalParentSeqInst( boolean forceRead ) {
		if( forceRead || ( optionalParentSeqInst == null ) ) {
			boolean anyMissing = false;
			if( getGelCallBuff().getOptionalSeqInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalSeqInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalSeqInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelSequenceObj obj = ((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelSequenceTableObj().readGelSequenceByPIdx( getGelCallBuff().getOptionalSeqInstTenantId(),
					getGelCallBuff().getOptionalSeqInstGelCacheId(),
					getGelCallBuff().getOptionalSeqInstId() );
				optionalParentSeqInst = obj;
			}
		}
		return( optionalParentSeqInst );
	}

	public void setOptionalParentSeqInst( ICFGenKbGelSequenceObj value ) {
			if( buff == null ) {
				getGelCallBuff();
			}
			if( value != null ) {
				getGelCallBuff().setOptionalSeqInstTenantId( value.getRequiredTenantId() );
				getGelCallBuff().setOptionalSeqInstGelCacheId( value.getRequiredGelCacheId() );
				getGelCallBuff().setOptionalSeqInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelCallBuff().setOptionalSeqInstTenantId( null );
				getGelCallBuff().setOptionalSeqInstGelCacheId( null );
				getGelCallBuff().setOptionalSeqInstId( null );
			}
			optionalParentSeqInst = value;
	}

	public ICFGenKbGelInstructionObj getOptionalLookupCallInst() {
		return( getOptionalLookupCallInst( false ) );
	}

	public ICFGenKbGelInstructionObj getOptionalLookupCallInst( boolean forceRead ) {
		if( forceRead || ( optionalLookupCallInst == null ) ) {
			boolean anyMissing = false;
			if( getGelCallBuff().getOptionalCallInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalCallInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalCallInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelInstructionObj obj = ((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelInstructionTableObj().readGelInstructionByPIdx( getGelCallBuff().getOptionalCallInstTenantId(),
					getGelCallBuff().getOptionalCallInstGelCacheId(),
					getGelCallBuff().getOptionalCallInstId() );
				optionalLookupCallInst = obj;
			}
		}
		return( optionalLookupCallInst );
	}

	public void setOptionalLookupCallInst( ICFGenKbGelInstructionObj value ) {
			if( buff == null ) {
				getGelCallBuff();
			}
			if( value != null ) {
				getGelCallBuff().setOptionalCallInstTenantId( value.getRequiredTenantId() );
				getGelCallBuff().setOptionalCallInstGelCacheId( value.getRequiredGelCacheId() );
				getGelCallBuff().setOptionalCallInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelCallBuff().setOptionalCallInstTenantId( null );
				getGelCallBuff().setOptionalCallInstGelCacheId( null );
				getGelCallBuff().setOptionalCallInstId( null );
			}
			optionalLookupCallInst = value;
	}

	public ICFGenKbGelCallObj getOptionalLookupPrevInst() {
		return( getOptionalLookupPrevInst( false ) );
	}

	public ICFGenKbGelCallObj getOptionalLookupPrevInst( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrevInst == null ) ) {
			boolean anyMissing = false;
			if( getGelCallBuff().getOptionalPrevInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalPrevInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalPrevInstGelInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelCallObj obj = ((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelCallTableObj().readGelCallByPIdx( getGelCallBuff().getOptionalPrevInstTenantId(),
					getGelCallBuff().getOptionalPrevInstGelCacheId(),
					getGelCallBuff().getOptionalPrevInstGelInstId() );
				optionalLookupPrevInst = obj;
			}
		}
		return( optionalLookupPrevInst );
	}

	public void setOptionalLookupPrevInst( ICFGenKbGelCallObj value ) {
			if( buff == null ) {
				getGelCallBuff();
			}
			if( value != null ) {
				getGelCallBuff().setOptionalPrevInstTenantId( value.getRequiredTenantId() );
				getGelCallBuff().setOptionalPrevInstGelCacheId( value.getRequiredGelCacheId() );
				getGelCallBuff().setOptionalPrevInstGelInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelCallBuff().setOptionalPrevInstTenantId( null );
				getGelCallBuff().setOptionalPrevInstGelCacheId( null );
				getGelCallBuff().setOptionalPrevInstGelInstId( null );
			}
			optionalLookupPrevInst = value;
	}

	public ICFGenKbGelCallObj getOptionalLookupNextInst() {
		return( getOptionalLookupNextInst( false ) );
	}

	public ICFGenKbGelCallObj getOptionalLookupNextInst( boolean forceRead ) {
		if( forceRead || ( optionalLookupNextInst == null ) ) {
			boolean anyMissing = false;
			if( getGelCallBuff().getOptionalNextInstTenantId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalNextInstGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGelCallBuff().getOptionalNextInstGelInstId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelCallObj obj = ((ICFGenKbSchemaObj)getOrigAsGelCall().getSchema()).getGelCallTableObj().readGelCallByPIdx( getGelCallBuff().getOptionalNextInstTenantId(),
					getGelCallBuff().getOptionalNextInstGelCacheId(),
					getGelCallBuff().getOptionalNextInstGelInstId() );
				optionalLookupNextInst = obj;
			}
		}
		return( optionalLookupNextInst );
	}

	public void setOptionalLookupNextInst( ICFGenKbGelCallObj value ) {
			if( buff == null ) {
				getGelCallBuff();
			}
			if( value != null ) {
				getGelCallBuff().setOptionalNextInstTenantId( value.getRequiredTenantId() );
				getGelCallBuff().setOptionalNextInstGelCacheId( value.getRequiredGelCacheId() );
				getGelCallBuff().setOptionalNextInstGelInstId( value.getRequiredGelInstId() );
			}
			else {
				getGelCallBuff().setOptionalNextInstTenantId( null );
				getGelCallBuff().setOptionalNextInstGelCacheId( null );
				getGelCallBuff().setOptionalNextInstGelInstId( null );
			}
			optionalLookupNextInst = value;
	}

	public void copyBuffToOrig() {
		CFGenKbGelCallBuff origBuff = getOrigAsGelCall().getGelCallBuff();
		CFGenKbGelCallBuff myBuff = getGelCallBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGelCallBuff origBuff = getOrigAsGelCall().getGelCallBuff();
		CFGenKbGelCallBuff myBuff = getGelCallBuff();
		myBuff.set( origBuff );
	}
}
