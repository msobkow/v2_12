// Description: Java 11 edit object instance implementation for CFGenKb ToolSet.

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

public class CFGenKbToolSetEditObj
	implements ICFGenKbToolSetEditObj
{
	protected ICFGenKbToolSetObj orig;
	protected CFGenKbToolSetBuff buff;
	protected ICFGenKbToolObj requiredLookupTool0;
	protected ICFGenKbToolObj optionalLookupTool1;
	protected ICFGenKbToolObj optionalLookupTool2;
	protected ICFGenKbToolObj optionalLookupTool3;
	protected ICFGenKbToolObj optionalLookupTool4;
	protected ICFGenKbToolObj optionalLookupTool5;
	protected ICFGenKbToolObj optionalLookupTool6;
	protected ICFGenKbToolObj optionalLookupTool7;

	public CFGenKbToolSetEditObj( ICFGenKbToolSetObj argOrig ) {
		orig = argOrig;
		getBuff();
		CFGenKbToolSetBuff origBuff = orig.getBuff();
		buff.set( origBuff );
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
		return( CFGenKbToolSetObj.CLASS_CODE );
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
		// We realise this so that it's buffer will get copied to orig during realization
		ICFGenKbToolSetObj retobj = getSchema().getToolSetTableObj().realiseToolSet( (ICFGenKbToolSetObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolSetTableObj().forgetToolSet( getOrigAsToolSet(), forgetSubObjects );
	}

	public ICFGenKbToolSetObj read() {
		ICFGenKbToolSetObj retval = getOrigAsToolSet().read();
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbToolSetObj read( boolean forceRead ) {
		ICFGenKbToolSetObj retval = getOrigAsToolSet().read( forceRead );
		if( retval != orig ) {
			throw new CFLibUsageException( getClass(),
				"read",
				"retval != orig" );
		}
		copyOrigToBuff();
		return( retval );
	}

	public ICFGenKbToolSetObj create() {
		copyBuffToOrig();
		ICFGenKbToolSetObj retobj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolSetTableObj().createToolSet( getOrigAsToolSet() );
		if( retobj == getOrigAsToolSet() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbToolSetEditObj update() {
		getSchema().getToolSetTableObj().updateToolSet( (ICFGenKbToolSetObj)this );
		return( null );
	}

	public CFGenKbToolSetEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new CFLibUsageException( getClass(), "delete", "Cannot delete a new instance" );
		}
		getSchema().getToolSetTableObj().deleteToolSet( getOrigAsToolSet() );
		return( null );
	}

	public ICFGenKbToolSetTableObj getToolSetTable() {
		return( orig.getSchema().getToolSetTableObj() );
	}

	public ICFGenKbToolSetEditObj getEdit() {
		return( (ICFGenKbToolSetEditObj)this );
	}

	public ICFGenKbToolSetEditObj getEditAsToolSet() {
		return( (ICFGenKbToolSetEditObj)this );
	}

	public ICFGenKbToolSetEditObj beginEdit() {
		throw new CFLibUsageException( getClass(), "beginEdit", "Cannot edit an edition" );
	}

	public void endEdit() {
		orig.endEdit();
	}

	public ICFGenKbToolSetObj getOrig() {
		return( orig );
	}

	public ICFGenKbToolSetObj getOrigAsToolSet() {
		return( (ICFGenKbToolSetObj)orig );
	}

	public ICFGenKbSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	public CFGenKbToolSetBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsToolSet().getSchema().getBackingStore()).getFactoryToolSet().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbToolSetBuff value ) {
		if( buff != value ) {
			buff = value;
			requiredLookupTool0 = null;
			optionalLookupTool1 = null;
			optionalLookupTool2 = null;
			optionalLookupTool3 = null;
			optionalLookupTool4 = null;
			optionalLookupTool5 = null;
			optionalLookupTool6 = null;
			optionalLookupTool7 = null;
		}
	}

	public CFGenKbToolSetBuff getToolSetBuff() {
		return( (CFGenKbToolSetBuff)getBuff() );
	}

	public CFGenKbToolSetPKey getPKey() {
		return( orig.getPKey() );
	}

	public void setPKey( CFGenKbToolSetPKey value ) {
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
		return( getToolSetBuff().getRequiredName() );
	}

	public void setRequiredName( String value ) {
		if( getToolSetBuff().getRequiredName() != value ) {
			getToolSetBuff().setRequiredName( value );
		}
	}

	public String getOptionalDescr() {
		return( getToolSetBuff().getOptionalDescr() );
	}

	public void setOptionalDescr( String value ) {
		if( getToolSetBuff().getOptionalDescr() != value ) {
			getToolSetBuff().setOptionalDescr( value );
		}
	}

	public String getOptionalRevisionString() {
		return( getToolSetBuff().getOptionalRevisionString() );
	}

	public void setOptionalRevisionString( String value ) {
		if( getToolSetBuff().getOptionalRevisionString() != value ) {
			getToolSetBuff().setOptionalRevisionString( value );
		}
	}

	public boolean getRequiredIsSupported() {
		return( getToolSetBuff().getRequiredIsSupported() );
	}

	public void setRequiredIsSupported( boolean value ) {
		if( getToolSetBuff().getRequiredIsSupported() != value ) {
			getToolSetBuff().setRequiredIsSupported( value );
		}
	}

	public boolean getRequiredGenerate() {
		return( getToolSetBuff().getRequiredGenerate() );
	}

	public void setRequiredGenerate( boolean value ) {
		if( getToolSetBuff().getRequiredGenerate() != value ) {
			getToolSetBuff().setRequiredGenerate( value );
		}
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
		if( forceRead || ( requiredLookupTool0 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getRequiredToolId0() );
				requiredLookupTool0 = obj;
			}
		}
		return( requiredLookupTool0 );
	}

	public void setRequiredLookupTool0( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setRequiredToolId0( value.getRequiredId() );
			}
			else {
			}
			requiredLookupTool0 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool1() {
		return( getOptionalLookupTool1( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool1( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool1 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId1() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId1() );
				optionalLookupTool1 = obj;
			}
		}
		return( optionalLookupTool1 );
	}

	public void setOptionalLookupTool1( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId1( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId1( null );
			}
			optionalLookupTool1 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool2() {
		return( getOptionalLookupTool2( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool2( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool2 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId2() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId2() );
				optionalLookupTool2 = obj;
			}
		}
		return( optionalLookupTool2 );
	}

	public void setOptionalLookupTool2( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId2( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId2( null );
			}
			optionalLookupTool2 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool3() {
		return( getOptionalLookupTool3( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool3( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool3 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId3() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId3() );
				optionalLookupTool3 = obj;
			}
		}
		return( optionalLookupTool3 );
	}

	public void setOptionalLookupTool3( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId3( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId3( null );
			}
			optionalLookupTool3 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool4() {
		return( getOptionalLookupTool4( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool4( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool4 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId4() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId4() );
				optionalLookupTool4 = obj;
			}
		}
		return( optionalLookupTool4 );
	}

	public void setOptionalLookupTool4( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId4( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId4( null );
			}
			optionalLookupTool4 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool5() {
		return( getOptionalLookupTool5( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool5( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool5 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId5() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId5() );
				optionalLookupTool5 = obj;
			}
		}
		return( optionalLookupTool5 );
	}

	public void setOptionalLookupTool5( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId5( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId5( null );
			}
			optionalLookupTool5 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool6() {
		return( getOptionalLookupTool6( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool6( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool6 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId6() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId6() );
				optionalLookupTool6 = obj;
			}
		}
		return( optionalLookupTool6 );
	}

	public void setOptionalLookupTool6( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId6( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId6( null );
			}
			optionalLookupTool6 = value;
	}

	public ICFGenKbToolObj getOptionalLookupTool7() {
		return( getOptionalLookupTool7( false ) );
	}

	public ICFGenKbToolObj getOptionalLookupTool7( boolean forceRead ) {
		if( forceRead || ( optionalLookupTool7 == null ) ) {
			boolean anyMissing = false;
			if( getToolSetBuff().getOptionalToolId7() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbToolObj obj = ((ICFGenKbSchemaObj)getOrigAsToolSet().getSchema()).getToolTableObj().readToolByIdIdx( getToolSetBuff().getOptionalToolId7() );
				optionalLookupTool7 = obj;
			}
		}
		return( optionalLookupTool7 );
	}

	public void setOptionalLookupTool7( ICFGenKbToolObj value ) {
			if( buff == null ) {
				getToolSetBuff();
			}
			if( value != null ) {
				getToolSetBuff().setOptionalToolId7( value.getRequiredId() );
			}
			else {
				getToolSetBuff().setOptionalToolId7( null );
			}
			optionalLookupTool7 = value;
	}

	public void copyPKeyToBuff() {
		buff.setRequiredId( getPKey().getRequiredId() );
	}

	public void copyBuffToPKey() {
		getPKey().setRequiredId( buff.getRequiredId() );
	}

	public void copyBuffToOrig() {
		CFGenKbToolSetBuff origBuff = getOrigAsToolSet().getToolSetBuff();
		CFGenKbToolSetBuff myBuff = getToolSetBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbToolSetBuff origBuff = getOrigAsToolSet().getToolSetBuff();
		CFGenKbToolSetBuff myBuff = getToolSetBuff();
		myBuff.set( origBuff );
	}
}
