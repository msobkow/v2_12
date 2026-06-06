// Description: Java 11 base object instance implementation for CFGenKb Tool.

/*
 *	org.msscf.msscf.CFCore
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

public class CFGenKbToolObj
	implements ICFGenKbToolObj
{
	public final static String CLASS_CODE = "TOL";
	protected boolean isNew;
	protected ICFGenKbToolEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbToolPKey pKey;
	protected CFGenKbToolBuff buff;
	protected ICFGenKbToolObj optionalLookupReplaces;

	public CFGenKbToolObj() {
		isNew = true;
		optionalLookupReplaces = null;
	}

	public CFGenKbToolObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		optionalLookupReplaces = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbToolObj retobj = ((ICFGenKbSchemaObj)schema).getToolTableObj().realiseTool(
			(ICFGenKbToolObj)this );
		return( (ICFGenKbToolObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getToolTableObj().forgetTool( (ICFGenKbToolObj)this, forgetSubObjects );
	}

	public ICFGenKbToolObj read() {
		ICFGenKbToolObj retobj = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFGenKbToolObj)retobj );
	}

	public ICFGenKbToolObj read( boolean forceRead ) {
		ICFGenKbToolObj retobj = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFGenKbToolObj)retobj );
	}

	public ICFGenKbToolTableObj getToolTable() {
		return( ((ICFGenKbSchemaObj)schema).getToolTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbToolBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTool().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableTool().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbToolBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbToolBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbToolBuff" );
		}
		buff = value;
		copyBuffToPKey();
		optionalLookupReplaces = null;
	}

	public CFGenKbToolBuff getToolBuff() {
		return( (CFGenKbToolBuff)getBuff() );
	}

	public CFGenKbToolPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryTool().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbToolPKey value ) {
		if( pKey != value ) {
			pKey = value;
			copyPKeyToBuff();
		}
	}

	public boolean getIsNew() {
		return( isNew );
	}

	public void setIsNew( boolean value ) {
		isNew = value;
	}

	public ICFGenKbToolEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbToolObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbToolObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getToolTableObj().lockTool( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getToolTableObj().newEditInstance( lockobj );
		return( (ICFGenKbToolEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbToolEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbToolEditObj getEditAsTool() {
		return( (ICFGenKbToolEditObj)edit );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getToolBuff().getRequiredName() );
	}

	public Short getOptionalReplacesId() {
		return( getToolBuff().getOptionalReplacesId() );
	}

	public boolean getRequiredIsSupported() {
		return( getToolBuff().getRequiredIsSupported() );
	}

	public ICFGenKbToolObj getOptionalLookupReplaces() {
		return( getOptionalLookupReplaces( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupReplaces( boolean forceRead ) {
		if( ( optionalLookupReplaces == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolBuff().getOptionalReplacesId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupReplaces = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolBuff().getOptionalReplacesId(), forceRead );
			}
		}
		return( optionalLookupReplaces );
	}

	public void copyPKeyToBuff() {
		if( buff != null ) {
			buff.setRequiredId( getPKey().getRequiredId() );
		}
		if( edit != null ) {
			edit.copyPKeyToBuff();
		}
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}
}
