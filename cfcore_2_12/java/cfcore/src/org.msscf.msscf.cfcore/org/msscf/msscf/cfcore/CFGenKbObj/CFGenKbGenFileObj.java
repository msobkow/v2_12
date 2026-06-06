// Description: Java 11 base object instance implementation for CFGenKb GenFile.

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
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGelCompiler;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public class CFGenKbGenFileObj
	extends CFGenKbGenRuleObj
	implements ICFGenKbGenFileObj
{
	public final static String CLASS_CODE = "FIL";
	protected ICFGenKbGelExecutableObj optionalComponentsSrcBundleGel;
	protected ICFGenKbGelExecutableObj optionalComponentsBasePackageGel;
	protected ICFGenKbGelExecutableObj optionalComponentsModuleNameGel;
	protected ICFGenKbGelExecutableObj optionalComponentsSubPackageGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpClassGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpKeyNameGel;
	protected ICFGenKbGelExecutableObj optionalComponentsExpFileNameGel;

	public CFGenKbGenFileObj() {
		super();
	}

	public CFGenKbGenFileObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
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
		ICFGenKbGenFileObj retobj = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().realiseGenFile(
			(ICFGenKbGenFileObj)this );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGenFileTableObj().forgetGenFile( (ICFGenKbGenFileObj)this, forgetSubObjects );
	}

	public ICFGenKbGenItemObj read() {
		ICFGenKbGenFileObj retobj = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().readGenFileByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), false );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenItemObj read( boolean forceRead ) {
		ICFGenKbGenFileObj retobj = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().readGenFileByItemIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredCartridgeId(),
			getPKey().getRequiredItemId(), forceRead );
		return( (ICFGenKbGenItemObj)retobj );
	}

	public ICFGenKbGenFileTableObj getGenFileTable() {
		return( ((ICFGenKbSchemaObj)schema).getGenFileTableObj() );
	}

	public CFGenKbGenItemBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGenFile().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGenFile().readDerivedByItemIdIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredCartridgeId(),
						getPKey().getRequiredItemId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGenItemBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGenFileBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGenFileBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerCartridge = null;
		requiredLookupRuleType = null;
		requiredLookupToolSet = null;
		optionalLookupScopeDef = null;
		requiredLookupGenDef = null;
		optionalLookupProbe = null;
	}

	public CFGenKbGenFileBuff getGenFileBuff() {
		return( (CFGenKbGenFileBuff)getBuff() );
	}

	public ICFGenKbGenItemEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGenFileObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGenFileObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().lockGenFile( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGenFileTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGenItemEditObj)edit );
	}

	public ICFGenKbGenFileEditObj getEditAsGenFile() {
		return( (ICFGenKbGenFileEditObj)edit );
	}

	public String getOptionalGenerateOnce() {
		return( getGenFileBuff().getOptionalGenerateOnce() );
	}

	public String getOptionalSourceBundle() {
		return( getGenFileBuff().getOptionalSourceBundle() );
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
		if( ( optionalComponentsSrcBundleGel == null ) || forceRead ) {
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
				optionalComponentsSrcBundleGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalSourceBundleTenantId(),
					getGenFileBuff().getOptionalSourceBundleGelCacheId(),
					getGenFileBuff().getOptionalSourceBundleGelId(), forceRead );
			}
		}
		return( optionalComponentsSrcBundleGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBasePackageGel() {
		return( getOptionalComponentsBasePackageGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsBasePackageGel( boolean forceRead ) {
		if( ( optionalComponentsBasePackageGel == null ) || forceRead ) {
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
				optionalComponentsBasePackageGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalBasePackageTenantId(),
					getGenFileBuff().getOptionalBasePackageGelCacheId(),
					getGenFileBuff().getOptionalBasePackageGelId(), forceRead );
			}
		}
		return( optionalComponentsBasePackageGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsModuleNameGel() {
		return( getOptionalComponentsModuleNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsModuleNameGel( boolean forceRead ) {
		if( ( optionalComponentsModuleNameGel == null ) || forceRead ) {
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
				optionalComponentsModuleNameGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalModuleNameTenantId(),
					getGenFileBuff().getOptionalModuleNameGelCacheId(),
					getGenFileBuff().getOptionalModuleNameGelId(), forceRead );
			}
		}
		return( optionalComponentsModuleNameGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSubPackageGel() {
		return( getOptionalComponentsSubPackageGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsSubPackageGel( boolean forceRead ) {
		if( ( optionalComponentsSubPackageGel == null ) || forceRead ) {
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
				optionalComponentsSubPackageGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalSubPackageTenantId(),
					getGenFileBuff().getOptionalSubPackageGelCacheId(),
					getGenFileBuff().getOptionalSubPackageGelId(), forceRead );
			}
		}
		return( optionalComponentsSubPackageGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpClassGel() {
		return( getOptionalComponentsExpClassGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpClassGel( boolean forceRead ) {
		if( ( optionalComponentsExpClassGel == null ) || forceRead ) {
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
				optionalComponentsExpClassGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionClassNameTenantId(),
					getGenFileBuff().getOptionalExpansionClassNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionClassNameGelId(), forceRead );
			}
		}
		return( optionalComponentsExpClassGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpKeyNameGel() {
		return( getOptionalComponentsExpKeyNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpKeyNameGel( boolean forceRead ) {
		if( ( optionalComponentsExpKeyNameGel == null ) || forceRead ) {
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
				optionalComponentsExpKeyNameGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionKeyNameTenantId(),
					getGenFileBuff().getOptionalExpansionKeyNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionKeyNameGelId(), forceRead );
			}
		}
		return( optionalComponentsExpKeyNameGel );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpFileNameGel() {
		return( getOptionalComponentsExpFileNameGel( false ) );
	}

	public ICFGenKbGelExecutableObj getOptionalComponentsExpFileNameGel( boolean forceRead ) {
		if( ( optionalComponentsExpFileNameGel == null ) || forceRead ) {
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
				optionalComponentsExpFileNameGel = ((ICFGenKbSchemaObj)schema).getGelExecutableTableObj().readGelExecutableByPIdx( getGenFileBuff().getOptionalExpansionFileNameTenantId(),
					getGenFileBuff().getOptionalExpansionFileNameGelCacheId(),
					getGenFileBuff().getOptionalExpansionFileNameGelId(), forceRead );
			}
		}
		return( optionalComponentsExpFileNameGel );
	}

	public static ICFGenKbGelExecutableObj getSrcBundleBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getSrcBundleBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsSrcBundleGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::SrcBundle";
			String source = genFile.getOptionalSourceBundle();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile SrcBundle GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsSrcBundleGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsSrcBundleGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getBasePackageBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getBasePackageBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsBasePackageGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::BasePackage";
			String source = genFile.getOptionalBasePackageName();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile BasePackageName GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsBasePackageGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsBasePackageGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getModuleNameBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_Empty = "";
		final String S_ProcName = "CFGenKbGenFileObj.getModuleNameBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsModuleNameGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::ModuleName";
			String source = genFile.getOptionalModuleName();
			if( source == null ) {
				source = S_Empty;
			}

			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile ModuleName GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsModuleNameGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsModuleNameGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getSubPackageBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getSubPackageBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsSubPackageGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::SubPackage";
			String source = genFile.getOptionalSubPackageName();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile SubPackage GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsSubPackageGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsSubPackageGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getExpClassBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getExpClassBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsExpClassGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::ExpClass";
			String source = genFile.getOptionalExpansionClassName();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile ExpClass GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsExpClassGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsExpClassGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getExpKeyNameBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getExpKeyNameBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsExpKeyNameGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::ExpKeyName";
			String source = genFile.getOptionalExpansionKeyName();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile ExpKeyName GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsExpKeyNameGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsExpKeyNameGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}

	public static ICFGenKbGelExecutableObj getExpFileNameBin( MssCFGelCompiler gelCompiler, ICFGenKbGenFileObj genFile ) {
		final String S_ProcName = "CFGenKbGenFileObj.getExpFileNameBin() ";
		ICFGenKbGelExecutableObj bin = genFile.getOptionalComponentsExpFileNameGel();
		if( bin == null ) {
			String execName = genFile.getRequiredLookupToolSet().getRequiredName()
				+ "::" + genFile.getRequiredLookupRuleType().getRequiredName()
				+ "::" + (( genFile.getOptionalLookupScopeDef() == null ) ? "Object" : genFile.getOptionalLookupScopeDef().getRequiredName() )
				+ "::" + genFile.getRequiredLookupGenDef().getRequiredName()
				+ "::" + genFile.getRequiredName()
				+ "::ExpansionFileName";
			String source = genFile.getOptionalExpansionFileName();
			bin = gelCompiler.compileExecutable( execName, source );
			if( bin == null ) {
				throw new RuntimeException( S_ProcName + "Could not compile ExpFileName GEL executable from source \"" + source + "\"" );
			}

			ICFGenKbGenFileEditObj editFile = genFile.getEditAsGenFile();
			if( editFile != null ) {
				editFile.setOptionalComponentsExpFileNameGel( bin );
			}
			else {
				editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
				editFile.setOptionalComponentsExpFileNameGel( bin );
				editFile.update();
				editFile = null;
			}
		}
		return( bin );
	}
}
