// Description: Java 11 edit object instance implementation for CFGenKb GenFile.

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

public class CFGenKbGenFileEditObj
	extends CFGenKbGenRuleEditObj

	implements ICFGenKbGenFileEditObj
{
	protected ICFGenKbGelExecutableObj optionalComponentsSrcBundleGel;
	protected ICFGenKbGelExecutableObj optionalComponentsBasePackageGel;
	protected ICFGenKbGelExecutableObj optionalComponentsModuleNameGel;
	protected ICFGenKbGelExecutableObj optionalComponentsSubPackageGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpClassGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpKeyNameGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpFileNameGel;

	public CFGenKbGenFileEditObj( ICFGenKbGenFileObj argOrig ) {
		super( argOrig );
	}

	public String getClassCode() {
		return( CFGenKbGenFileObj.CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GenFile" );
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
		ICFGenKbGenFileObj retobj = getSchema().getGenFileTableObj().realiseGenFile( (ICFGenKbGenFileObj)this );
		return( retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		// We forget the original because that's what's referenced by the cache
		((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGenFileTableObj().forgetGenFile( getOrigAsGenFile(), forgetSubObjects );
	}

	public ICFGenKbGenItemObj create() {
		copyBuffToOrig();
		ICFGenKbGenFileObj retobj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGenFileTableObj().createGenFile( getOrigAsGenFile() );
		if( retobj == getOrigAsGenFile() ) {
			copyOrigToBuff();
		}
		return( retobj );
	}

	public CFGenKbGenItemEditObj update() {
		getSchema().getGenFileTableObj().updateGenFile( (ICFGenKbGenFileObj)this );
		return( null );
	}

	public CFGenKbGenItemEditObj deleteInstance() {
		super.forget();
		getSchema().getGenFileTableObj().deleteGenFile( getOrigAsGenFile() );
		return( null );
	}

	public ICFGenKbGenFileTableObj getGenFileTable() {
		return( orig.getSchema().getGenFileTableObj() );
	}

	public ICFGenKbGenFileEditObj getEditAsGenFile() {
		return( (ICFGenKbGenFileEditObj)this );
	}

	public ICFGenKbGenFileObj getOrigAsGenFile() {
		return( (ICFGenKbGenFileObj)orig );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			buff = ((ICFGenKbSchema)getOrigAsGenFile().getSchema().getBackingStore()).getFactoryGenFile().newBuff();
			buff.set( orig.getBuff() );
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( buff != value ) {
			super.setBuff( value );
		}
	}

	public CFGenKbGenFileBuff getGenFileBuff() {
		return( (CFGenKbGenFileBuff)getBuff() );
	}

	public String getOptionalGenerateOnce() {
		return( getGenFileBuff().getOptionalGenerateOnce() );
	}

	public void setOptionalGenerateOnce( String value ) {
		if( getGenFileBuff().getOptionalGenerateOnce() != value ) {
			getGenFileBuff().setOptionalGenerateOnce( value );
		}
	}

	public String getOptionalSourceBundle() {
		return( getGenFileBuff().getOptionalSourceBundle() );
	}

	public void setOptionalSourceBundle( String value ) {
		if( getGenFileBuff().getOptionalSourceBundle() != value ) {
			getGenFileBuff().setOptionalSourceBundle( value );
		}
	}

	public Long getOptionalSourceBundleTenantId() {
		return( getGenFileBuff().getOptionalSourceBundleTenantId() );
	}

	public Long getOptionalSourceBundleGelCacheId() {
		return( getGenFileBuff().getOptionalSourceBundleGelCacheId() );
	}

	public Long getOptionalSourceBundleGelId() {
		return( getGenFileBuff().getOptionalSourceBundleGelId() );
	}

	public String getOptionalModuleName() {
		return( getGenFileBuff().getOptionalModuleName() );
	}

	public void setOptionalModuleName( String value ) {
		if( getGenFileBuff().getOptionalModuleName() != value ) {
			getGenFileBuff().setOptionalModuleName( value );
		}
	}

	public Long getOptionalModuleNameTenantId() {
		return( getGenFileBuff().getOptionalModuleNameTenantId() );
	}

	public Long getOptionalModuleNameGelCacheId() {
		return( getGenFileBuff().getOptionalModuleNameGelCacheId() );
	}

	public Long getOptionalModuleNameGelId() {
		return( getGenFileBuff().getOptionalModuleNameGelId() );
	}

	public String getOptionalBasePackageName() {
		return( getGenFileBuff().getOptionalBasePackageName() );
	}

	public void setOptionalBasePackageName( String value ) {
		if( getGenFileBuff().getOptionalBasePackageName() != value ) {
			getGenFileBuff().setOptionalBasePackageName( value );
		}
	}

	public Long getOptionalBasePackageTenantId() {
		return( getGenFileBuff().getOptionalBasePackageTenantId() );
	}

	public Long getOptionalBasePackageGelCacheId() {
		return( getGenFileBuff().getOptionalBasePackageGelCacheId() );
	}

	public Long getOptionalBasePackageGelId() {
		return( getGenFileBuff().getOptionalBasePackageGelId() );
	}

	public String getOptionalSubPackageName() {
		return( getGenFileBuff().getOptionalSubPackageName() );
	}

	public void setOptionalSubPackageName( String value ) {
		if( getGenFileBuff().getOptionalSubPackageName() != value ) {
			getGenFileBuff().setOptionalSubPackageName( value );
		}
	}

	public Long getOptionalSubPackageTenantId() {
		return( getGenFileBuff().getOptionalSubPackageTenantId() );
	}

	public Long getOptionalSubPackageGelCacheId() {
		return( getGenFileBuff().getOptionalSubPackageGelCacheId() );
	}

	public Long getOptionalSubPackageGelId() {
		return( getGenFileBuff().getOptionalSubPackageGelId() );
	}

	public String getOptionalExpansionClassName() {
		return( getGenFileBuff().getOptionalExpansionClassName() );
	}

	public void setOptionalExpansionClassName( String value ) {
		if( getGenFileBuff().getOptionalExpansionClassName() != value ) {
			getGenFileBuff().setOptionalExpansionClassName( value );
		}
	}

	public Long getOptionalExpansionClassNameTenantId() {
		return( getGenFileBuff().getOptionalExpansionClassNameTenantId() );
	}

	public Long getOptionalExpansionClassNameGelCacheId() {
		return( getGenFileBuff().getOptionalExpansionClassNameGelCacheId() );
	}

	public Long getOptionalExpansionClassNameGelId() {
		return( getGenFileBuff().getOptionalExpansionClassNameGelId() );
	}

	public String getOptionalExpansionKeyName() {
		return( getGenFileBuff().getOptionalExpansionKeyName() );
	}

	public void setOptionalExpansionKeyName( String value ) {
		if( getGenFileBuff().getOptionalExpansionKeyName() != value ) {
			getGenFileBuff().setOptionalExpansionKeyName( value );
		}
	}

	public Long getOptionalExpansionKeyNameTenantId() {
		return( getGenFileBuff().getOptionalExpansionKeyNameTenantId() );
	}

	public Long getOptionalExpansionKeyNameGelCacheId() {
		return( getGenFileBuff().getOptionalExpansionKeyNameGelCacheId() );
	}

	public Long getOptionalExpansionKeyNameGelId() {
		return( getGenFileBuff().getOptionalExpansionKeyNameGelId() );
	}

	public String getOptionalExpansionFileName() {
		return( getGenFileBuff().getOptionalExpansionFileName() );
	}

	public void setOptionalExpansionFileName( String value ) {
		if( getGenFileBuff().getOptionalExpansionFileName() != value ) {
			getGenFileBuff().setOptionalExpansionFileName( value );
		}
	}

	public Long getOptionalExpansionFileNameTenantId() {
		return( getGenFileBuff().getOptionalExpansionFileNameTenantId() );
	}

	public Long getOptionalExpansionFileNameGelCacheId() {
		return( getGenFileBuff().getOptionalExpansionFileNameGelCacheId() );
	}

	public Long getOptionalExpansionFileNameGelId() {
		return( getGenFileBuff().getOptionalExpansionFileNameGelId() );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSrcBundleGel() {
		return( getOptionalComponentsSrcBundleGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSrcBundleGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsSrcBundleGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalSourceBundleTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalSourceBundleGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalSourceBundleGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalSourceBundleTenantId(),
					getGenFileBuff().getOptionalSourceBundleGelCacheId(),
					getGenFileBuff().getOptionalSourceBundleGelId() );
				optionalComponentsSrcBundleGel = obj;
			}
		}
		return( optionalComponentsSrcBundleGel );
	}

	public void setOptionalComponentsSrcBundleGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalSourceBundleTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalSourceBundleGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalSourceBundleGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalSourceBundleTenantId( null );
				getGenFileBuff().setOptionalSourceBundleGelCacheId( null );
				getGenFileBuff().setOptionalSourceBundleGelId( null );
			}
			optionalComponentsSrcBundleGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBasePackageGel() {
		return( getOptionalComponentsBasePackageGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBasePackageGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsBasePackageGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalBasePackageTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalBasePackageGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalBasePackageGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalBasePackageTenantId(),
					getGenFileBuff().getOptionalBasePackageGelCacheId(),
					getGenFileBuff().getOptionalBasePackageGelId() );
				optionalComponentsBasePackageGel = obj;
			}
		}
		return( optionalComponentsBasePackageGel );
	}

	public void setOptionalComponentsBasePackageGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalBasePackageTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalBasePackageGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalBasePackageGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalBasePackageTenantId( null );
				getGenFileBuff().setOptionalBasePackageGelCacheId( null );
				getGenFileBuff().setOptionalBasePackageGelId( null );
			}
			optionalComponentsBasePackageGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsModuleNameGel() {
		return( getOptionalComponentsModuleNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsModuleNameGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsModuleNameGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalModuleNameTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalModuleNameGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalModuleNameGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalModuleNameTenantId(),
					getGenFileBuff().getOptionalModuleNameGelCacheId(),
					getGenFileBuff().getOptionalModuleNameGelId() );
				optionalComponentsModuleNameGel = obj;
			}
		}
		return( optionalComponentsModuleNameGel );
	}

	public void setOptionalComponentsModuleNameGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalModuleNameTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalModuleNameGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalModuleNameGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalModuleNameTenantId( null );
				getGenFileBuff().setOptionalModuleNameGelCacheId( null );
				getGenFileBuff().setOptionalModuleNameGelId( null );
			}
			optionalComponentsModuleNameGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSubPackageGel() {
		return( getOptionalComponentsSubPackageGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSubPackageGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsSubPackageGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalSubPackageTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalSubPackageGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalSubPackageGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalSubPackageTenantId(),
					getGenFileBuff().getOptionalSubPackageGelCacheId(),
					getGenFileBuff().getOptionalSubPackageGelId() );
				optionalComponentsSubPackageGel = obj;
			}
		}
		return( optionalComponentsSubPackageGel );
	}

	public void setOptionalComponentsSubPackageGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalSubPackageTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalSubPackageGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalSubPackageGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalSubPackageTenantId( null );
				getGenFileBuff().setOptionalSubPackageGelCacheId( null );
				getGenFileBuff().setOptionalSubPackageGelId( null );
			}
			optionalComponentsSubPackageGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpClassGel() {
		return( getOptionalComponentsExpClassGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpClassGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsExpClassGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalExpansionClassNameTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionClassNameGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionClassNameGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionClassNameTenantId(),
					getGenFileBuff().getOptionalExpansionClassNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionClassNameGelId() );
				optionalComponentsExpClassGel = obj;
			}
		}
		return( optionalComponentsExpClassGel );
	}

	public void setOptionalComponentsExpClassGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalExpansionClassNameTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalExpansionClassNameGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalExpansionClassNameGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalExpansionClassNameTenantId( null );
				getGenFileBuff().setOptionalExpansionClassNameGelCacheId( null );
				getGenFileBuff().setOptionalExpansionClassNameGelId( null );
			}
			optionalComponentsExpClassGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpKeyNameGel() {
		return( getOptionalComponentsExpKeyNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpKeyNameGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsExpKeyNameGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalExpansionKeyNameTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionKeyNameGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionKeyNameGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionKeyNameTenantId(),
					getGenFileBuff().getOptionalExpansionKeyNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionKeyNameGelId() );
				optionalComponentsExpKeyNameGel = obj;
			}
		}
		return( optionalComponentsExpKeyNameGel );
	}

	public void setOptionalComponentsExpKeyNameGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalExpansionKeyNameTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalExpansionKeyNameGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalExpansionKeyNameGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalExpansionKeyNameTenantId( null );
				getGenFileBuff().setOptionalExpansionKeyNameGelCacheId( null );
				getGenFileBuff().setOptionalExpansionKeyNameGelId( null );
			}
			optionalComponentsExpKeyNameGel = value;
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpFileNameGel() {
		return( getOptionalComponentsExpFileNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpFileNameGel( boolean forceRead ) {
		if( forceRead || ( optionalComponentsExpFileNameGel == null ) ) {
			boolean anyMissing = false;
			if( getGenFileBuff().getOptionalExpansionFileNameTenantId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionFileNameGelCacheId() == null ) {
				anyMissing = true;
			}
			if( getGenFileBuff().getOptionalExpansionFileNameGelId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ICFGenKbGelExecutableObj obj = ((ICFGenKbSchemaObj)getOrigAsGenFile().getSchema()).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionFileNameTenantId(),
					getGenFileBuff().getOptionalExpansionFileNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionFileNameGelId() );
				optionalComponentsExpFileNameGel = obj;
			}
		}
		return( optionalComponentsExpFileNameGel );
	}

	public void setOptionalComponentsExpFileNameGel( ICFGenKbGelExecutableObj value ) {
			if( buff == null ) {
				getGenFileBuff();
			}
			if( value != null ) {
				getGenFileBuff().setOptionalExpansionFileNameTenantId( value.getRequiredTenantId() );
				getGenFileBuff().setOptionalExpansionFileNameGelCacheId( value.getRequiredGelCacheId() );
				getGenFileBuff().setOptionalExpansionFileNameGelId( value.getRequiredGelInstId() );
			}
			else {
				getGenFileBuff().setOptionalExpansionFileNameTenantId( null );
				getGenFileBuff().setOptionalExpansionFileNameGelCacheId( null );
				getGenFileBuff().setOptionalExpansionFileNameGelId( null );
			}
			optionalComponentsExpFileNameGel = value;
	}

	public void copyBuffToOrig() {
		CFGenKbGenFileBuff origBuff = getOrigAsGenFile().getGenFileBuff();
		CFGenKbGenFileBuff myBuff = getGenFileBuff();
		origBuff.set( myBuff );
	}

	public void copyOrigToBuff() {
		CFGenKbGenFileBuff origBuff = getOrigAsGenFile().getGenFileBuff();
		CFGenKbGenFileBuff myBuff = getGenFileBuff();
		myBuff.set( origBuff );
	}
}
