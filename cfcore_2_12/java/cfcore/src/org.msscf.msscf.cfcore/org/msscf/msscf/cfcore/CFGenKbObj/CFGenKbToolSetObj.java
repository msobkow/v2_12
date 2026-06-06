// Description: Java 11 base object instance implementation for CFGenKb ToolSet.

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

public class CFGenKbToolSetObj
	implements ICFGenKbToolSetObj
{
	public final static String CLASS_CODE = "TLS";
	protected boolean isNew;
	protected ICFGenKbToolSetEditObj edit;
	protected ICFGenKbSchemaObj schema;
	protected CFGenKbToolSetPKey pKey;
	protected CFGenKbToolSetBuff buff;
	protected ICFGenKbToolObj requiredLookupTool0;
	protected ICFGenKbToolObj optionalLookupTool1;
	protected ICFGenKbToolObj optionalLookupTool2;
	protected ICFGenKbToolObj optionalLookupTool3;
	protected ICFGenKbToolObj optionalLookupTool4;
	protected ICFGenKbToolObj optionalLookupTool5;
	protected ICFGenKbToolObj optionalLookupTool6;
	protected ICFGenKbToolObj optionalLookupTool7;

	public CFGenKbToolSetObj() {
		isNew = true;
		requiredLookupTool0 = null;
		optionalLookupTool1 = null;
		optionalLookupTool2 = null;
		optionalLookupTool3 = null;
		optionalLookupTool4 = null;
		optionalLookupTool5 = null;
		optionalLookupTool6 = null;
		optionalLookupTool7 = null;
	}

	public CFGenKbToolSetObj( ICFGenKbSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredLookupTool0 = null;
		optionalLookupTool1 = null;
		optionalLookupTool2 = null;
		optionalLookupTool3 = null;
		optionalLookupTool4 = null;
		optionalLookupTool5 = null;
		optionalLookupTool6 = null;
		optionalLookupTool7 = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "ToolSet" );
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

	public ICFGenKbToolSetObj realise() {
		ICFGenKbToolSetObj retobj = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().realiseToolSet(
			(ICFGenKbToolSetObj)this );
		return( (ICFGenKbToolSetObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getToolSetTableObj().forgetToolSet( (ICFGenKbToolSetObj)this, forgetSubObjects );
	}

	public ICFGenKbToolSetObj read() {
		ICFGenKbToolSetObj retobj = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().readToolSetByIdIdx( getPKey().getRequiredId(), false );
		return( (ICFGenKbToolSetObj)retobj );
	}

	public ICFGenKbToolSetObj read( boolean forceRead ) {
		ICFGenKbToolSetObj retobj = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().readToolSetByIdIdx( getPKey().getRequiredId(), forceRead );
		return( (ICFGenKbToolSetObj)retobj );
	}

	public ICFGenKbToolSetTableObj getToolSetTable() {
		return( ((ICFGenKbSchemaObj)schema).getToolSetTableObj() );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFGenKbSchemaObj value ) {
		schema = value;
	}

	public CFGenKbToolSetBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryToolSet().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableToolSet().readDerivedByIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbToolSetBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbToolSetBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbToolSetBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredLookupTool0 = null;
		optionalLookupTool1 = null;
		optionalLookupTool2 = null;
		optionalLookupTool3 = null;
		optionalLookupTool4 = null;
		optionalLookupTool5 = null;
		optionalLookupTool6 = null;
		optionalLookupTool7 = null;
	}

	public CFGenKbToolSetBuff getToolSetBuff() {
		return( (CFGenKbToolSetBuff)getBuff() );
	}

	public CFGenKbToolSetPKey getPKey() {
		if( pKey == null ) {
			pKey = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryToolSet().newPKey();
		}
		return( pKey );
	}

	public void setPKey( CFGenKbToolSetPKey value ) {
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

	public ICFGenKbToolSetEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbToolSetObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbToolSetObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().lockToolSet( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getToolSetTableObj().newEditInstance( lockobj );
		return( (ICFGenKbToolSetEditObj)edit );
	}

	public void endEdit() {
		edit = null;
	}

	public ICFGenKbToolSetEditObj getEdit() {
		return( edit );
	}

	public ICFGenKbToolSetEditObj getEditAsToolSet() {
		return( (ICFGenKbToolSetEditObj)edit );
	}

	public short getRequiredId() {
		return( getPKey().getRequiredId() );
	}

	public String getRequiredName() {
		return( getToolSetBuff().getRequiredName() );
	}

	public String getOptionalDescr() {
		return( getToolSetBuff().getOptionalDescr() );
	}

	public String getOptionalRevisionString() {
		return( getToolSetBuff().getOptionalRevisionString() );
	}

	public boolean getRequiredIsSupported() {
		return( getToolSetBuff().getRequiredIsSupported() );
	}

	public boolean getRequiredGenerate() {
		return( getToolSetBuff().getRequiredGenerate() );
	}

	public short getRequiredToolId0() {
		return( getToolSetBuff().getRequiredToolId0() );
	}

	public Short getOptionalToolId1() {
		return( getToolSetBuff().getOptionalToolId1() );
	}

	public Short getOptionalToolId2() {
		return( getToolSetBuff().getOptionalToolId2() );
	}

	public Short getOptionalToolId3() {
		return( getToolSetBuff().getOptionalToolId3() );
	}

	public Short getOptionalToolId4() {
		return( getToolSetBuff().getOptionalToolId4() );
	}

	public Short getOptionalToolId5() {
		return( getToolSetBuff().getOptionalToolId5() );
	}

	public Short getOptionalToolId6() {
		return( getToolSetBuff().getOptionalToolId6() );
	}

	public Short getOptionalToolId7() {
		return( getToolSetBuff().getOptionalToolId7() );
	}

	public ICFGenKbToolObj getRequiredLookupTool0() {
		return( getRequiredLookupTool0( false ) );
	}

	public ICFGenKbToolObj getRequiredLookupTool0( boolean forceRead ) {
		if( ( requiredLookupTool0 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupTool0 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getRequiredToolId0(), forceRead );
			}
		}
		return( requiredLookupTool0 );
	}

	public ICFGenKbToolObj getOptionalLookupTool1() {
		return( getOptionalLookupTool1( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool1( boolean forceRead ) {
		if( ( optionalLookupTool1 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId1() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool1 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId1(), forceRead );
			}
		}
		return( optionalLookupTool1 );
	}

	public ICFGenKbToolObj getOptionalLookupTool2() {
		return( getOptionalLookupTool2( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool2( boolean forceRead ) {
		if( ( optionalLookupTool2 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId2() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool2 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId2(), forceRead );
			}
		}
		return( optionalLookupTool2 );
	}

	public ICFGenKbToolObj getOptionalLookupTool3() {
		return( getOptionalLookupTool3( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool3( boolean forceRead ) {
		if( ( optionalLookupTool3 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId3() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool3 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId3(), forceRead );
			}
		}
		return( optionalLookupTool3 );
	}

	public ICFGenKbToolObj getOptionalLookupTool4() {
		return( getOptionalLookupTool4( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool4( boolean forceRead ) {
		if( ( optionalLookupTool4 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId4() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool4 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId4(), forceRead );
			}
		}
		return( optionalLookupTool4 );
	}

	public ICFGenKbToolObj getOptionalLookupTool5() {
		return( getOptionalLookupTool5( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool5( boolean forceRead ) {
		if( ( optionalLookupTool5 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId5() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool5 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId5(), forceRead );
			}
		}
		return( optionalLookupTool5 );
	}

	public ICFGenKbToolObj getOptionalLookupTool6() {
		return( getOptionalLookupTool6( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool6( boolean forceRead ) {
		if( ( optionalLookupTool6 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId6() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool6 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId6(), forceRead );
			}
		}
		return( optionalLookupTool6 );
	}

	public ICFGenKbToolObj getOptionalLookupTool7() {
		return( getOptionalLookupTool7( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool7( boolean forceRead ) {
		if( ( optionalLookupTool7 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId7() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupTool7 = ((ICFGenKbSchemaObj)schema).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId7(), forceRead );
			}
		}
		return( optionalLookupTool7 );
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
