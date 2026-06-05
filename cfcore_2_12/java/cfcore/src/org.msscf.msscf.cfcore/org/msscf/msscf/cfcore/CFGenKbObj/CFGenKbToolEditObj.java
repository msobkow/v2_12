// Description: Java 11 edit object instance implementation for CFGenKb Tool.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public class CFGenKbToolEditObj
	implements ICFGenKbToolEditObj
{
	protected ICFGenKbToolObj orig;
	protected CFGenKbToolBuff buff;
	protected ICFGenKbToolObj optionalLookupReplaces;

	public CFGenKbToolEditObj( ICFGenKbToolObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbToolBuff origBuff = orig.getBuff();
		buff.set( origBuff );
		optionalLookupReplaces = null;
	}

	public String getClassCode() {
		return( CFGenKbToolObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "Tool" );
	}

	public ICFLibAnyObj getScope() {
		return( null );
	}

	public ICFLibAnyObj getObjScope() {
		return( null );
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

	public ICFLibAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		ICFLibAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		ICFLibAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
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

	public String getObjFullName() {
		String fullName = getObjName();
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
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	public ICFGenKbToolObj realise() {
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbToolObj retobj = getSchema().getToolTableObj().realiseTool( (ICFGenKbToolObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsTool().getSchema()).getToolTableObj().forgetTool( getOrigAsTool(), forgetSubObjects );
	}

	public ICFGenKbToolObj read() {
		ICFGenKbToolObj retval = getOrigAsTool().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbToolObj read( boolean forceRead ) {
		ICFGenKbToolObj retval = getOrigAsTool().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbToolObj create() {
		copyBuffToOrig();
		ICFGenKbToolObj retobj = ((ICFGenKbSchemaObj)getOrigAsTool().getSchema()).getToolTableObj().createTool( getOrigAsTool() );
		if( retobj == getOrigAsTool() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbToolEditObj update() {
		getSchema().getToolTableObj().updateTool( (ICFGenKbToolObj)this );
		return( null );
	}

	public CFGenKbToolEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getToolTableObj().deleteTool( getOrigAsTool() );
		return( null );
	}

	public ICFGenKbToolTableObj getToolTable() {
		return( orig.getSchema().getToolTableObj() );
	}

	public ICFGenKbToolEditObj getEdit() {
		return( (ICFGenKbToolEditObj)this );
	}

	public ICFGenKbToolEditObj getEditAsTool() {
		return( (ICFGenKbToolEditObj)this );
	}

	public ICFGenKbToolEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbToolObj getOrig() {
		return( orig );
	}

	public ICFGenKbToolObj getOrigAsTool() {
		return( (ICFGenKbToolObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbToolBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsTool().getSchema().getBackingStore()).getFactoryTool().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbToolBuff value ) {
		if( buff != value ) {
			buff = value;
			optionalLookupReplaces = null;
		}
	}

	public CFGenKbToolBuff getToolBuff() {
		return( (CFGenKbToolBuff)getBuff() );
	}

	public CFGenKbToolPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbToolPKey value ) {
		orig.setPKey( value );
		copyPKeyToBuff();
	}

	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getToolBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getToolBuff().getRequiredName() != value ) {
			getToolBuff().setRequiredName( value );
		}
	}

	public Short getOptionalReplacesId() {
		return( getToolBuff().getOptionalReplacesId() );
	}

	public boolean getRequiredIsSupported() {
		return( getToolBuff().getRequiredIsSupported() );
	}

	public void setRequiredIsSupported( boolean value ) {
		if( getToolBuff().getRequiredIsSupported() != value ) {
			getToolBuff().setRequiredIsSupported( value );
		}
	}

	public ICFGenKbToolObj getOptionalLookupReplaces() {
		return( getOptionalLookupReplaces( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupReplaces( boolean forceRead ) {
		if( forceRead || ( optionalLookupReplaces == null ) ) {
			boolean anyMissing = false;
			if( getToolBuff().getOptionalReplacesId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsTool().getSchema()).getToolTableObj().readToolByIdIdx( getToolBuff().getOptionalReplacesId() );
				optionalLookupReplaces = obj;
			}
		}
		return( optionalLookupReplaces );
	}

	public void setOptionalLookupReplaces( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolBuff();
			}
			if( value != null ) {
				getToolBuff().setOptionalReplacesId( value.getRequiredId() );
			}
			else {
				getToolBuff().setOptionalReplacesId( null );
			}
			optionalLookupReplaces = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbToolBuff origBuff = getOrigAsTool().getToolBuff();
		CFGenKbToolBuff myBuff = getToolBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbToolBuff origBuff = getOrigAsTool().getToolBuff();
		CFGenKbToolBuff myBuff = getToolBuff();
		myBuff.set( origBuff );
	}
}
