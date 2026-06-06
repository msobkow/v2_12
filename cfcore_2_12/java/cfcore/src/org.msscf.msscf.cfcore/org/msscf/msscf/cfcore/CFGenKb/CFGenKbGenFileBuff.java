// Description: Java 11 implementation of a GenFile buffer object.

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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFGenKbGenFileBuff
	extends CFGenKbGenRuleBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "FIL";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long CARTRIDGEID_INIT_VALUE = 0L;
	public static final long ITEMID_INIT_VALUE = 0L;
	public static final String GENERATEONCE_INIT_VALUE = new String( "" );
	public static final String SOURCEBUNDLE_INIT_VALUE = new String( "" );
	public static final long SOURCEBUNDLETENANTID_INIT_VALUE = 0L;
	public static final long SOURCEBUNDLEGELCACHEID_INIT_VALUE = 0L;
	public static final long SOURCEBUNDLEGELID_INIT_VALUE = 0L;
	public static final String MODULENAME_INIT_VALUE = new String( "" );
	public static final long MODULENAMETENANTID_INIT_VALUE = 0L;
	public static final long MODULENAMEGELCACHEID_INIT_VALUE = 0L;
	public static final long MODULENAMEGELID_INIT_VALUE = 0L;
	public static final String BASEPACKAGENAME_INIT_VALUE = new String( "" );
	public static final long BASEPACKAGETENANTID_INIT_VALUE = 0L;
	public static final long BASEPACKAGEGELCACHEID_INIT_VALUE = 0L;
	public static final long BASEPACKAGEGELID_INIT_VALUE = 0L;
	public static final String SUBPACKAGENAME_INIT_VALUE = new String( "" );
	public static final long SUBPACKAGETENANTID_INIT_VALUE = 0L;
	public static final long SUBPACKAGEGELCACHEID_INIT_VALUE = 0L;
	public static final long SUBPACKAGEGELID_INIT_VALUE = 0L;
	public static final String EXPANSIONCLASSNAME_INIT_VALUE = new String( "" );
	public static final long EXPANSIONCLASSNAMETENANTID_INIT_VALUE = 0L;
	public static final long EXPANSIONCLASSNAMEGELCACHEID_INIT_VALUE = 0L;
	public static final long EXPANSIONCLASSNAMEGELID_INIT_VALUE = 0L;
	public static final String EXPANSIONKEYNAME_INIT_VALUE = new String( "" );
	public static final long EXPANSIONKEYNAMETENANTID_INIT_VALUE = 0L;
	public static final long EXPANSIONKEYNAMEGELCACHEID_INIT_VALUE = 0L;
	public static final long EXPANSIONKEYNAMEGELID_INIT_VALUE = 0L;
	public static final String EXPANSIONFILENAME_INIT_VALUE = new String( "" );
	public static final long EXPANSIONFILENAMETENANTID_INIT_VALUE = 0L;
	public static final long EXPANSIONFILENAMEGELCACHEID_INIT_VALUE = 0L;
	public static final long EXPANSIONFILENAMEGELID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long CARTRIDGEID_MIN_VALUE = 0L;
	public static final long ITEMID_MIN_VALUE = 0L;
	public static final long SOURCEBUNDLETENANTID_MIN_VALUE = 0L;
	public static final long SOURCEBUNDLEGELCACHEID_MIN_VALUE = 0L;
	public static final long SOURCEBUNDLEGELID_MIN_VALUE = 0L;
	public static final long MODULENAMETENANTID_MIN_VALUE = 0L;
	public static final long MODULENAMEGELCACHEID_MIN_VALUE = 0L;
	public static final long MODULENAMEGELID_MIN_VALUE = 0L;
	public static final long BASEPACKAGETENANTID_MIN_VALUE = 0L;
	public static final long BASEPACKAGEGELCACHEID_MIN_VALUE = 0L;
	public static final long BASEPACKAGEGELID_MIN_VALUE = 0L;
	public static final long SUBPACKAGETENANTID_MIN_VALUE = 0L;
	public static final long SUBPACKAGEGELCACHEID_MIN_VALUE = 0L;
	public static final long SUBPACKAGEGELID_MIN_VALUE = 0L;
	public static final long EXPANSIONCLASSNAMETENANTID_MIN_VALUE = 0L;
	public static final long EXPANSIONCLASSNAMEGELCACHEID_MIN_VALUE = 0L;
	public static final long EXPANSIONCLASSNAMEGELID_MIN_VALUE = 0L;
	public static final long EXPANSIONKEYNAMETENANTID_MIN_VALUE = 0L;
	public static final long EXPANSIONKEYNAMEGELCACHEID_MIN_VALUE = 0L;
	public static final long EXPANSIONKEYNAMEGELID_MIN_VALUE = 0L;
	public static final long EXPANSIONFILENAMETENANTID_MIN_VALUE = 0L;
	public static final long EXPANSIONFILENAMEGELCACHEID_MIN_VALUE = 0L;
	public static final long EXPANSIONFILENAMEGELID_MIN_VALUE = 0L;
	public static final long ITEMID_MAX_VALUE = 2147483647L;
	protected String optionalGenerateOnce;
	protected String optionalSourceBundle;
	protected Long optionalSourceBundleTenantId;
	protected Long optionalSourceBundleGelCacheId;
	protected Long optionalSourceBundleGelId;
	protected String optionalModuleName;
	protected Long optionalModuleNameTenantId;
	protected Long optionalModuleNameGelCacheId;
	protected Long optionalModuleNameGelId;
	protected String optionalBasePackageName;
	protected Long optionalBasePackageTenantId;
	protected Long optionalBasePackageGelCacheId;
	protected Long optionalBasePackageGelId;
	protected String optionalSubPackageName;
	protected Long optionalSubPackageTenantId;
	protected Long optionalSubPackageGelCacheId;
	protected Long optionalSubPackageGelId;
	protected String optionalExpansionClassName;
	protected Long optionalExpansionClassNameTenantId;
	protected Long optionalExpansionClassNameGelCacheId;
	protected Long optionalExpansionClassNameGelId;
	protected String optionalExpansionKeyName;
	protected Long optionalExpansionKeyNameTenantId;
	protected Long optionalExpansionKeyNameGelCacheId;
	protected Long optionalExpansionKeyNameGelId;
	protected String optionalExpansionFileName;
	protected Long optionalExpansionFileNameTenantId;
	protected Long optionalExpansionFileNameGelCacheId;
	protected Long optionalExpansionFileNameGelId;
	public CFGenKbGenFileBuff() {
		super();
		optionalGenerateOnce = null;
		optionalSourceBundle = null;
		optionalSourceBundleTenantId = null;
		optionalSourceBundleGelCacheId = null;
		optionalSourceBundleGelId = null;
		optionalModuleName = null;
		optionalModuleNameTenantId = null;
		optionalModuleNameGelCacheId = null;
		optionalModuleNameGelId = null;
		optionalBasePackageName = null;
		optionalBasePackageTenantId = null;
		optionalBasePackageGelCacheId = null;
		optionalBasePackageGelId = null;
		optionalSubPackageName = null;
		optionalSubPackageTenantId = null;
		optionalSubPackageGelCacheId = null;
		optionalSubPackageGelId = null;
		optionalExpansionClassName = null;
		optionalExpansionClassNameTenantId = null;
		optionalExpansionClassNameGelCacheId = null;
		optionalExpansionClassNameGelId = null;
		optionalExpansionKeyName = null;
		optionalExpansionKeyNameTenantId = null;
		optionalExpansionKeyNameGelCacheId = null;
		optionalExpansionKeyNameGelId = null;
		optionalExpansionFileName = null;
		optionalExpansionFileNameTenantId = null;
		optionalExpansionFileNameGelCacheId = null;
		optionalExpansionFileNameGelId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getOptionalGenerateOnce() {
		return( optionalGenerateOnce );
	}

	public void setOptionalGenerateOnce( String value ) {
		if( value == null ) {
			optionalGenerateOnce = null;
		}
		else if( value.length() > 8 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalGenerateOnce",
				1,
				"value.length()",
				value.length(),
				8 );
		}
		else {
			optionalGenerateOnce = value;
		}
	}

	public String getOptionalSourceBundle() {
		return( optionalSourceBundle );
	}

	public void setOptionalSourceBundle( String value ) {
		if( value == null ) {
			optionalSourceBundle = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalSourceBundle",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalSourceBundle = value;
		}
	}

	public Long getOptionalSourceBundleTenantId() {
		return( optionalSourceBundleTenantId );
	}

	public void setOptionalSourceBundleTenantId( Long value ) {
		if( value == null ) {
			optionalSourceBundleTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLETENANTID_MIN_VALUE );
		}
		else {
			optionalSourceBundleTenantId = value;
		}
	}

	public Long getOptionalSourceBundleGelCacheId() {
		return( optionalSourceBundleGelCacheId );
	}

	public void setOptionalSourceBundleGelCacheId( Long value ) {
		if( value == null ) {
			optionalSourceBundleGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalSourceBundleGelCacheId = value;
		}
	}

	public Long getOptionalSourceBundleGelId() {
		return( optionalSourceBundleGelId );
	}

	public void setOptionalSourceBundleGelId( Long value ) {
		if( value == null ) {
			optionalSourceBundleGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.SOURCEBUNDLEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSourceBundleGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SOURCEBUNDLEGELID_MIN_VALUE );
		}
		else {
			optionalSourceBundleGelId = value;
		}
	}

	public String getOptionalModuleName() {
		return( optionalModuleName );
	}

	public void setOptionalModuleName( String value ) {
		if( value == null ) {
			optionalModuleName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalModuleName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalModuleName = value;
		}
	}

	public Long getOptionalModuleNameTenantId() {
		return( optionalModuleNameTenantId );
	}

	public void setOptionalModuleNameTenantId( Long value ) {
		if( value == null ) {
			optionalModuleNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMETENANTID_MIN_VALUE );
		}
		else {
			optionalModuleNameTenantId = value;
		}
	}

	public Long getOptionalModuleNameGelCacheId() {
		return( optionalModuleNameGelCacheId );
	}

	public void setOptionalModuleNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalModuleNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalModuleNameGelCacheId = value;
		}
	}

	public Long getOptionalModuleNameGelId() {
		return( optionalModuleNameGelId );
	}

	public void setOptionalModuleNameGelId( Long value ) {
		if( value == null ) {
			optionalModuleNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.MODULENAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalModuleNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.MODULENAMEGELID_MIN_VALUE );
		}
		else {
			optionalModuleNameGelId = value;
		}
	}

	public String getOptionalBasePackageName() {
		return( optionalBasePackageName );
	}

	public void setOptionalBasePackageName( String value ) {
		if( value == null ) {
			optionalBasePackageName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalBasePackageName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalBasePackageName = value;
		}
	}

	public Long getOptionalBasePackageTenantId() {
		return( optionalBasePackageTenantId );
	}

	public void setOptionalBasePackageTenantId( Long value ) {
		if( value == null ) {
			optionalBasePackageTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.BASEPACKAGETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBasePackageTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.BASEPACKAGETENANTID_MIN_VALUE );
		}
		else {
			optionalBasePackageTenantId = value;
		}
	}

	public Long getOptionalBasePackageGelCacheId() {
		return( optionalBasePackageGelCacheId );
	}

	public void setOptionalBasePackageGelCacheId( Long value ) {
		if( value == null ) {
			optionalBasePackageGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.BASEPACKAGEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBasePackageGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.BASEPACKAGEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalBasePackageGelCacheId = value;
		}
	}

	public Long getOptionalBasePackageGelId() {
		return( optionalBasePackageGelId );
	}

	public void setOptionalBasePackageGelId( Long value ) {
		if( value == null ) {
			optionalBasePackageGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.BASEPACKAGEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalBasePackageGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.BASEPACKAGEGELID_MIN_VALUE );
		}
		else {
			optionalBasePackageGelId = value;
		}
	}

	public String getOptionalSubPackageName() {
		return( optionalSubPackageName );
	}

	public void setOptionalSubPackageName( String value ) {
		if( value == null ) {
			optionalSubPackageName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalSubPackageName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalSubPackageName = value;
		}
	}

	public Long getOptionalSubPackageTenantId() {
		return( optionalSubPackageTenantId );
	}

	public void setOptionalSubPackageTenantId( Long value ) {
		if( value == null ) {
			optionalSubPackageTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGETENANTID_MIN_VALUE );
		}
		else {
			optionalSubPackageTenantId = value;
		}
	}

	public Long getOptionalSubPackageGelCacheId() {
		return( optionalSubPackageGelCacheId );
	}

	public void setOptionalSubPackageGelCacheId( Long value ) {
		if( value == null ) {
			optionalSubPackageGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalSubPackageGelCacheId = value;
		}
	}

	public Long getOptionalSubPackageGelId() {
		return( optionalSubPackageGelId );
	}

	public void setOptionalSubPackageGelId( Long value ) {
		if( value == null ) {
			optionalSubPackageGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.SUBPACKAGEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalSubPackageGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.SUBPACKAGEGELID_MIN_VALUE );
		}
		else {
			optionalSubPackageGelId = value;
		}
	}

	public String getOptionalExpansionClassName() {
		return( optionalExpansionClassName );
	}

	public void setOptionalExpansionClassName( String value ) {
		if( value == null ) {
			optionalExpansionClassName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpansionClassName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalExpansionClassName = value;
		}
	}

	public Long getOptionalExpansionClassNameTenantId() {
		return( optionalExpansionClassNameTenantId );
	}

	public void setOptionalExpansionClassNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameTenantId = value;
		}
	}

	public Long getOptionalExpansionClassNameGelCacheId() {
		return( optionalExpansionClassNameGelCacheId );
	}

	public void setOptionalExpansionClassNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionClassNameGelId() {
		return( optionalExpansionClassNameGelId );
	}

	public void setOptionalExpansionClassNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionClassNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionClassNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONCLASSNAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionClassNameGelId = value;
		}
	}

	public String getOptionalExpansionKeyName() {
		return( optionalExpansionKeyName );
	}

	public void setOptionalExpansionKeyName( String value ) {
		if( value == null ) {
			optionalExpansionKeyName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpansionKeyName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalExpansionKeyName = value;
		}
	}

	public Long getOptionalExpansionKeyNameTenantId() {
		return( optionalExpansionKeyNameTenantId );
	}

	public void setOptionalExpansionKeyNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameTenantId = value;
		}
	}

	public Long getOptionalExpansionKeyNameGelCacheId() {
		return( optionalExpansionKeyNameGelCacheId );
	}

	public void setOptionalExpansionKeyNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionKeyNameGelId() {
		return( optionalExpansionKeyNameGelId );
	}

	public void setOptionalExpansionKeyNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionKeyNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionKeyNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONKEYNAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionKeyNameGelId = value;
		}
	}

	public String getOptionalExpansionFileName() {
		return( optionalExpansionFileName );
	}

	public void setOptionalExpansionFileName( String value ) {
		if( value == null ) {
			optionalExpansionFileName = null;
		}
		else if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalExpansionFileName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		else {
			optionalExpansionFileName = value;
		}
	}

	public Long getOptionalExpansionFileNameTenantId() {
		return( optionalExpansionFileNameTenantId );
	}

	public void setOptionalExpansionFileNameTenantId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameTenantId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameTenantId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMETENANTID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameTenantId = value;
		}
	}

	public Long getOptionalExpansionFileNameGelCacheId() {
		return( optionalExpansionFileNameGelCacheId );
	}

	public void setOptionalExpansionFileNameGelCacheId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameGelCacheId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMEGELCACHEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameGelCacheId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMEGELCACHEID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameGelCacheId = value;
		}
	}

	public Long getOptionalExpansionFileNameGelId() {
		return( optionalExpansionFileNameGelId );
	}

	public void setOptionalExpansionFileNameGelId( Long value ) {
		if( value == null ) {
			optionalExpansionFileNameGelId = null;
		}
		else if( value < CFGenKbGenFileBuff.EXPANSIONFILENAMEGELID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalExpansionFileNameGelId",
				1,
				"value",
				value,
				CFGenKbGenFileBuff.EXPANSIONFILENAMEGELID_MIN_VALUE );
		}
		else {
			optionalExpansionFileNameGelId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredCartridgeId() != rhs.getRequiredCartridgeId() ) {
				return( false );
			}
			if( getRequiredItemId() != rhs.getRequiredItemId() ) {
				return( false );
			}
			if( getOptionalGenerateOnce() != null ) {
				if( rhs.getOptionalGenerateOnce() != null ) {
					if( ! getOptionalGenerateOnce().equals( rhs.getOptionalGenerateOnce() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalGenerateOnce() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundle() != null ) {
				if( rhs.getOptionalSourceBundle() != null ) {
					if( ! getOptionalSourceBundle().equals( rhs.getOptionalSourceBundle() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundle() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleTenantId() != null ) {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					if( ! getOptionalSourceBundleTenantId().equals( rhs.getOptionalSourceBundleTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					if( ! getOptionalSourceBundleGelCacheId().equals( rhs.getOptionalSourceBundleGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					if( ! getOptionalSourceBundleGelId().equals( rhs.getOptionalSourceBundleGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleName() != null ) {
				if( rhs.getOptionalModuleName() != null ) {
					if( ! getOptionalModuleName().equals( rhs.getOptionalModuleName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleName() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameTenantId() != null ) {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					if( ! getOptionalModuleNameTenantId().equals( rhs.getOptionalModuleNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					if( ! getOptionalModuleNameGelCacheId().equals( rhs.getOptionalModuleNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					if( ! getOptionalModuleNameGelId().equals( rhs.getOptionalModuleNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageName() != null ) {
				if( rhs.getOptionalBasePackageName() != null ) {
					if( ! getOptionalBasePackageName().equals( rhs.getOptionalBasePackageName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageName() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageTenantId() != null ) {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					if( ! getOptionalBasePackageTenantId().equals( rhs.getOptionalBasePackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageGelCacheId() != null ) {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					if( ! getOptionalBasePackageGelCacheId().equals( rhs.getOptionalBasePackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageGelId() != null ) {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					if( ! getOptionalBasePackageGelId().equals( rhs.getOptionalBasePackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageName() != null ) {
				if( rhs.getOptionalSubPackageName() != null ) {
					if( ! getOptionalSubPackageName().equals( rhs.getOptionalSubPackageName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageName() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageTenantId() != null ) {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					if( ! getOptionalSubPackageTenantId().equals( rhs.getOptionalSubPackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					if( ! getOptionalSubPackageGelCacheId().equals( rhs.getOptionalSubPackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					if( ! getOptionalSubPackageGelId().equals( rhs.getOptionalSubPackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassName() != null ) {
				if( rhs.getOptionalExpansionClassName() != null ) {
					if( ! getOptionalExpansionClassName().equals( rhs.getOptionalExpansionClassName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassName() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameTenantId() != null ) {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					if( ! getOptionalExpansionClassNameTenantId().equals( rhs.getOptionalExpansionClassNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					if( ! getOptionalExpansionClassNameGelCacheId().equals( rhs.getOptionalExpansionClassNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					if( ! getOptionalExpansionClassNameGelId().equals( rhs.getOptionalExpansionClassNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyName() != null ) {
				if( rhs.getOptionalExpansionKeyName() != null ) {
					if( ! getOptionalExpansionKeyName().equals( rhs.getOptionalExpansionKeyName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyName() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					if( ! getOptionalExpansionKeyNameTenantId().equals( rhs.getOptionalExpansionKeyNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					if( ! getOptionalExpansionKeyNameGelCacheId().equals( rhs.getOptionalExpansionKeyNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					if( ! getOptionalExpansionKeyNameGelId().equals( rhs.getOptionalExpansionKeyNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileName() != null ) {
				if( rhs.getOptionalExpansionFileName() != null ) {
					if( ! getOptionalExpansionFileName().equals( rhs.getOptionalExpansionFileName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileName() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameTenantId() != null ) {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					if( ! getOptionalExpansionFileNameTenantId().equals( rhs.getOptionalExpansionFileNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					if( ! getOptionalExpansionFileNameGelCacheId().equals( rhs.getOptionalExpansionFileNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					if( ! getOptionalExpansionFileNameGelId().equals( rhs.getOptionalExpansionFileNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenItemPKey ) {
			CFGenKbGenItemPKey rhs = (CFGenKbGenItemPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredCartridgeId() != rhs.getRequiredCartridgeId() ) {
				return( false );
			}
			if( getRequiredItemId() != rhs.getRequiredItemId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXSrcBundleKey ) {
			CFGenKbGenFileByXSrcBundleKey rhs = (CFGenKbGenFileByXSrcBundleKey)obj;
			if( getOptionalSourceBundleTenantId() != null ) {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					if( ! getOptionalSourceBundleTenantId().equals( rhs.getOptionalSourceBundleTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					if( ! getOptionalSourceBundleGelCacheId().equals( rhs.getOptionalSourceBundleGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					if( ! getOptionalSourceBundleGelId().equals( rhs.getOptionalSourceBundleGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXModNameKey ) {
			CFGenKbGenFileByXModNameKey rhs = (CFGenKbGenFileByXModNameKey)obj;
			if( getOptionalModuleNameTenantId() != null ) {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					if( ! getOptionalModuleNameTenantId().equals( rhs.getOptionalModuleNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					if( ! getOptionalModuleNameGelCacheId().equals( rhs.getOptionalModuleNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					if( ! getOptionalModuleNameGelId().equals( rhs.getOptionalModuleNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXBasePkgKey ) {
			CFGenKbGenFileByXBasePkgKey rhs = (CFGenKbGenFileByXBasePkgKey)obj;
			if( getOptionalBasePackageTenantId() != null ) {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					if( ! getOptionalBasePackageTenantId().equals( rhs.getOptionalBasePackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageGelCacheId() != null ) {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					if( ! getOptionalBasePackageGelCacheId().equals( rhs.getOptionalBasePackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalBasePackageGelId() != null ) {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					if( ! getOptionalBasePackageGelId().equals( rhs.getOptionalBasePackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXSubPkgKey ) {
			CFGenKbGenFileByXSubPkgKey rhs = (CFGenKbGenFileByXSubPkgKey)obj;
			if( getOptionalSubPackageTenantId() != null ) {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					if( ! getOptionalSubPackageTenantId().equals( rhs.getOptionalSubPackageTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					if( ! getOptionalSubPackageGelCacheId().equals( rhs.getOptionalSubPackageGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					if( ! getOptionalSubPackageGelId().equals( rhs.getOptionalSubPackageGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXExpClsNameKey ) {
			CFGenKbGenFileByXExpClsNameKey rhs = (CFGenKbGenFileByXExpClsNameKey)obj;
			if( getOptionalExpansionClassNameTenantId() != null ) {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					if( ! getOptionalExpansionClassNameTenantId().equals( rhs.getOptionalExpansionClassNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					if( ! getOptionalExpansionClassNameGelCacheId().equals( rhs.getOptionalExpansionClassNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					if( ! getOptionalExpansionClassNameGelId().equals( rhs.getOptionalExpansionClassNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXExpKeyNameKey ) {
			CFGenKbGenFileByXExpKeyNameKey rhs = (CFGenKbGenFileByXExpKeyNameKey)obj;
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					if( ! getOptionalExpansionKeyNameTenantId().equals( rhs.getOptionalExpansionKeyNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					if( ! getOptionalExpansionKeyNameGelCacheId().equals( rhs.getOptionalExpansionKeyNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					if( ! getOptionalExpansionKeyNameGelId().equals( rhs.getOptionalExpansionKeyNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFGenKbGenFileByXExpFileNameKey ) {
			CFGenKbGenFileByXExpFileNameKey rhs = (CFGenKbGenFileByXExpFileNameKey)obj;
			if( getOptionalExpansionFileNameTenantId() != null ) {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					if( ! getOptionalExpansionFileNameTenantId().equals( rhs.getOptionalExpansionFileNameTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					if( ! getOptionalExpansionFileNameGelCacheId().equals( rhs.getOptionalExpansionFileNameGelCacheId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( false );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					if( ! getOptionalExpansionFileNameGelId().equals( rhs.getOptionalExpansionFileNameGelId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		if( getOptionalGenerateOnce() != null ) {
			hashCode = hashCode + getOptionalGenerateOnce().hashCode();
		}
		if( getOptionalSourceBundle() != null ) {
			hashCode = hashCode + getOptionalSourceBundle().hashCode();
		}
		if( getOptionalSourceBundleTenantId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleTenantId().hashCode();
		}
		if( getOptionalSourceBundleGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleGelCacheId().hashCode();
		}
		if( getOptionalSourceBundleGelId() != null ) {
			hashCode = hashCode + getOptionalSourceBundleGelId().hashCode();
		}
		if( getOptionalModuleName() != null ) {
			hashCode = hashCode + getOptionalModuleName().hashCode();
		}
		if( getOptionalModuleNameTenantId() != null ) {
			hashCode = hashCode + getOptionalModuleNameTenantId().hashCode();
		}
		if( getOptionalModuleNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalModuleNameGelCacheId().hashCode();
		}
		if( getOptionalModuleNameGelId() != null ) {
			hashCode = hashCode + getOptionalModuleNameGelId().hashCode();
		}
		if( getOptionalBasePackageName() != null ) {
			hashCode = hashCode + getOptionalBasePackageName().hashCode();
		}
		if( getOptionalBasePackageTenantId() != null ) {
			hashCode = hashCode + getOptionalBasePackageTenantId().hashCode();
		}
		if( getOptionalBasePackageGelCacheId() != null ) {
			hashCode = hashCode + getOptionalBasePackageGelCacheId().hashCode();
		}
		if( getOptionalBasePackageGelId() != null ) {
			hashCode = hashCode + getOptionalBasePackageGelId().hashCode();
		}
		if( getOptionalSubPackageName() != null ) {
			hashCode = hashCode + getOptionalSubPackageName().hashCode();
		}
		if( getOptionalSubPackageTenantId() != null ) {
			hashCode = hashCode + getOptionalSubPackageTenantId().hashCode();
		}
		if( getOptionalSubPackageGelCacheId() != null ) {
			hashCode = hashCode + getOptionalSubPackageGelCacheId().hashCode();
		}
		if( getOptionalSubPackageGelId() != null ) {
			hashCode = hashCode + getOptionalSubPackageGelId().hashCode();
		}
		if( getOptionalExpansionClassName() != null ) {
			hashCode = hashCode + getOptionalExpansionClassName().hashCode();
		}
		if( getOptionalExpansionClassNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameTenantId().hashCode();
		}
		if( getOptionalExpansionClassNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionClassNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionClassNameGelId().hashCode();
		}
		if( getOptionalExpansionKeyName() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyName().hashCode();
		}
		if( getOptionalExpansionKeyNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameTenantId().hashCode();
		}
		if( getOptionalExpansionKeyNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionKeyNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionKeyNameGelId().hashCode();
		}
		if( getOptionalExpansionFileName() != null ) {
			hashCode = hashCode + getOptionalExpansionFileName().hashCode();
		}
		if( getOptionalExpansionFileNameTenantId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameTenantId().hashCode();
		}
		if( getOptionalExpansionFileNameGelCacheId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameGelCacheId().hashCode();
		}
		if( getOptionalExpansionFileNameGelId() != null ) {
			hashCode = hashCode + getOptionalExpansionFileNameGelId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFGenKbGenFileBuff ) {
			CFGenKbGenFileBuff rhs = (CFGenKbGenFileBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getOptionalGenerateOnce() != null ) {
				if( rhs.getOptionalGenerateOnce() != null ) {
					int cmp = getOptionalGenerateOnce().compareTo( rhs.getOptionalGenerateOnce() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalGenerateOnce() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundle() != null ) {
				if( rhs.getOptionalSourceBundle() != null ) {
					int cmp = getOptionalSourceBundle().compareTo( rhs.getOptionalSourceBundle() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundle() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleTenantId() != null ) {
				Long lhsSourceBundleTenantId = getOptionalSourceBundleTenantId();
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					Long rhsSourceBundleTenantId = rhs.getOptionalSourceBundleTenantId();
					int cmp = lhsSourceBundleTenantId.compareTo( rhsSourceBundleTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				Long lhsSourceBundleGelCacheId = getOptionalSourceBundleGelCacheId();
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					Long rhsSourceBundleGelCacheId = rhs.getOptionalSourceBundleGelCacheId();
					int cmp = lhsSourceBundleGelCacheId.compareTo( rhsSourceBundleGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				Long lhsSourceBundleGelId = getOptionalSourceBundleGelId();
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					Long rhsSourceBundleGelId = rhs.getOptionalSourceBundleGelId();
					int cmp = lhsSourceBundleGelId.compareTo( rhsSourceBundleGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleName() != null ) {
				if( rhs.getOptionalModuleName() != null ) {
					int cmp = getOptionalModuleName().compareTo( rhs.getOptionalModuleName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameTenantId() != null ) {
				Long lhsModuleNameTenantId = getOptionalModuleNameTenantId();
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					Long rhsModuleNameTenantId = rhs.getOptionalModuleNameTenantId();
					int cmp = lhsModuleNameTenantId.compareTo( rhsModuleNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				Long lhsModuleNameGelCacheId = getOptionalModuleNameGelCacheId();
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					Long rhsModuleNameGelCacheId = rhs.getOptionalModuleNameGelCacheId();
					int cmp = lhsModuleNameGelCacheId.compareTo( rhsModuleNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				Long lhsModuleNameGelId = getOptionalModuleNameGelId();
				if( rhs.getOptionalModuleNameGelId() != null ) {
					Long rhsModuleNameGelId = rhs.getOptionalModuleNameGelId();
					int cmp = lhsModuleNameGelId.compareTo( rhsModuleNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageName() != null ) {
				if( rhs.getOptionalBasePackageName() != null ) {
					int cmp = getOptionalBasePackageName().compareTo( rhs.getOptionalBasePackageName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageTenantId() != null ) {
				Long lhsBasePackageTenantId = getOptionalBasePackageTenantId();
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					Long rhsBasePackageTenantId = rhs.getOptionalBasePackageTenantId();
					int cmp = lhsBasePackageTenantId.compareTo( rhsBasePackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageGelCacheId() != null ) {
				Long lhsBasePackageGelCacheId = getOptionalBasePackageGelCacheId();
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					Long rhsBasePackageGelCacheId = rhs.getOptionalBasePackageGelCacheId();
					int cmp = lhsBasePackageGelCacheId.compareTo( rhsBasePackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageGelId() != null ) {
				Long lhsBasePackageGelId = getOptionalBasePackageGelId();
				if( rhs.getOptionalBasePackageGelId() != null ) {
					Long rhsBasePackageGelId = rhs.getOptionalBasePackageGelId();
					int cmp = lhsBasePackageGelId.compareTo( rhsBasePackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageName() != null ) {
				if( rhs.getOptionalSubPackageName() != null ) {
					int cmp = getOptionalSubPackageName().compareTo( rhs.getOptionalSubPackageName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageTenantId() != null ) {
				Long lhsSubPackageTenantId = getOptionalSubPackageTenantId();
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					Long rhsSubPackageTenantId = rhs.getOptionalSubPackageTenantId();
					int cmp = lhsSubPackageTenantId.compareTo( rhsSubPackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				Long lhsSubPackageGelCacheId = getOptionalSubPackageGelCacheId();
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					Long rhsSubPackageGelCacheId = rhs.getOptionalSubPackageGelCacheId();
					int cmp = lhsSubPackageGelCacheId.compareTo( rhsSubPackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				Long lhsSubPackageGelId = getOptionalSubPackageGelId();
				if( rhs.getOptionalSubPackageGelId() != null ) {
					Long rhsSubPackageGelId = rhs.getOptionalSubPackageGelId();
					int cmp = lhsSubPackageGelId.compareTo( rhsSubPackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassName() != null ) {
				if( rhs.getOptionalExpansionClassName() != null ) {
					int cmp = getOptionalExpansionClassName().compareTo( rhs.getOptionalExpansionClassName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameTenantId() != null ) {
				Long lhsExpansionClassNameTenantId = getOptionalExpansionClassNameTenantId();
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					Long rhsExpansionClassNameTenantId = rhs.getOptionalExpansionClassNameTenantId();
					int cmp = lhsExpansionClassNameTenantId.compareTo( rhsExpansionClassNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				Long lhsExpansionClassNameGelCacheId = getOptionalExpansionClassNameGelCacheId();
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					Long rhsExpansionClassNameGelCacheId = rhs.getOptionalExpansionClassNameGelCacheId();
					int cmp = lhsExpansionClassNameGelCacheId.compareTo( rhsExpansionClassNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				Long lhsExpansionClassNameGelId = getOptionalExpansionClassNameGelId();
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					Long rhsExpansionClassNameGelId = rhs.getOptionalExpansionClassNameGelId();
					int cmp = lhsExpansionClassNameGelId.compareTo( rhsExpansionClassNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyName() != null ) {
				if( rhs.getOptionalExpansionKeyName() != null ) {
					int cmp = getOptionalExpansionKeyName().compareTo( rhs.getOptionalExpansionKeyName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameTenantId() != null ) {
				Long lhsExpansionKeyNameTenantId = getOptionalExpansionKeyNameTenantId();
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					Long rhsExpansionKeyNameTenantId = rhs.getOptionalExpansionKeyNameTenantId();
					int cmp = lhsExpansionKeyNameTenantId.compareTo( rhsExpansionKeyNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				Long lhsExpansionKeyNameGelCacheId = getOptionalExpansionKeyNameGelCacheId();
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					Long rhsExpansionKeyNameGelCacheId = rhs.getOptionalExpansionKeyNameGelCacheId();
					int cmp = lhsExpansionKeyNameGelCacheId.compareTo( rhsExpansionKeyNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				Long lhsExpansionKeyNameGelId = getOptionalExpansionKeyNameGelId();
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					Long rhsExpansionKeyNameGelId = rhs.getOptionalExpansionKeyNameGelId();
					int cmp = lhsExpansionKeyNameGelId.compareTo( rhsExpansionKeyNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileName() != null ) {
				if( rhs.getOptionalExpansionFileName() != null ) {
					int cmp = getOptionalExpansionFileName().compareTo( rhs.getOptionalExpansionFileName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameTenantId() != null ) {
				Long lhsExpansionFileNameTenantId = getOptionalExpansionFileNameTenantId();
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					Long rhsExpansionFileNameTenantId = rhs.getOptionalExpansionFileNameTenantId();
					int cmp = lhsExpansionFileNameTenantId.compareTo( rhsExpansionFileNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				Long lhsExpansionFileNameGelCacheId = getOptionalExpansionFileNameGelCacheId();
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					Long rhsExpansionFileNameGelCacheId = rhs.getOptionalExpansionFileNameGelCacheId();
					int cmp = lhsExpansionFileNameGelCacheId.compareTo( rhsExpansionFileNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				Long lhsExpansionFileNameGelId = getOptionalExpansionFileNameGelId();
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					Long rhsExpansionFileNameGelId = rhs.getOptionalExpansionFileNameGelId();
					int cmp = lhsExpansionFileNameGelId.compareTo( rhsExpansionFileNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenItemPKey ) {
			CFGenKbGenItemPKey rhs = (CFGenKbGenItemPKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredCartridgeId() < rhs.getRequiredCartridgeId() ) {
				return( -1 );
			}
			else if( getRequiredCartridgeId() > rhs.getRequiredCartridgeId() ) {
				return( 1 );
			}
			if( getRequiredItemId() < rhs.getRequiredItemId() ) {
				return( -1 );
			}
			else if( getRequiredItemId() > rhs.getRequiredItemId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXSrcBundleKey ) {
			CFGenKbGenFileByXSrcBundleKey rhs = (CFGenKbGenFileByXSrcBundleKey)obj;

			if( getOptionalSourceBundleTenantId() != null ) {
				Long lhsSourceBundleTenantId = getOptionalSourceBundleTenantId();
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					Long rhsSourceBundleTenantId = rhs.getOptionalSourceBundleTenantId();
					int cmp = lhsSourceBundleTenantId.compareTo( rhsSourceBundleTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelCacheId() != null ) {
				Long lhsSourceBundleGelCacheId = getOptionalSourceBundleGelCacheId();
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					Long rhsSourceBundleGelCacheId = rhs.getOptionalSourceBundleGelCacheId();
					int cmp = lhsSourceBundleGelCacheId.compareTo( rhsSourceBundleGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSourceBundleGelId() != null ) {
				Long lhsSourceBundleGelId = getOptionalSourceBundleGelId();
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					Long rhsSourceBundleGelId = rhs.getOptionalSourceBundleGelId();
					int cmp = lhsSourceBundleGelId.compareTo( rhsSourceBundleGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSourceBundleGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXModNameKey ) {
			CFGenKbGenFileByXModNameKey rhs = (CFGenKbGenFileByXModNameKey)obj;

			if( getOptionalModuleNameTenantId() != null ) {
				Long lhsModuleNameTenantId = getOptionalModuleNameTenantId();
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					Long rhsModuleNameTenantId = rhs.getOptionalModuleNameTenantId();
					int cmp = lhsModuleNameTenantId.compareTo( rhsModuleNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelCacheId() != null ) {
				Long lhsModuleNameGelCacheId = getOptionalModuleNameGelCacheId();
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					Long rhsModuleNameGelCacheId = rhs.getOptionalModuleNameGelCacheId();
					int cmp = lhsModuleNameGelCacheId.compareTo( rhsModuleNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalModuleNameGelId() != null ) {
				Long lhsModuleNameGelId = getOptionalModuleNameGelId();
				if( rhs.getOptionalModuleNameGelId() != null ) {
					Long rhsModuleNameGelId = rhs.getOptionalModuleNameGelId();
					int cmp = lhsModuleNameGelId.compareTo( rhsModuleNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalModuleNameGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXBasePkgKey ) {
			CFGenKbGenFileByXBasePkgKey rhs = (CFGenKbGenFileByXBasePkgKey)obj;

			if( getOptionalBasePackageTenantId() != null ) {
				Long lhsBasePackageTenantId = getOptionalBasePackageTenantId();
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					Long rhsBasePackageTenantId = rhs.getOptionalBasePackageTenantId();
					int cmp = lhsBasePackageTenantId.compareTo( rhsBasePackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageGelCacheId() != null ) {
				Long lhsBasePackageGelCacheId = getOptionalBasePackageGelCacheId();
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					Long rhsBasePackageGelCacheId = rhs.getOptionalBasePackageGelCacheId();
					int cmp = lhsBasePackageGelCacheId.compareTo( rhsBasePackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalBasePackageGelId() != null ) {
				Long lhsBasePackageGelId = getOptionalBasePackageGelId();
				if( rhs.getOptionalBasePackageGelId() != null ) {
					Long rhsBasePackageGelId = rhs.getOptionalBasePackageGelId();
					int cmp = lhsBasePackageGelId.compareTo( rhsBasePackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalBasePackageGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXSubPkgKey ) {
			CFGenKbGenFileByXSubPkgKey rhs = (CFGenKbGenFileByXSubPkgKey)obj;

			if( getOptionalSubPackageTenantId() != null ) {
				Long lhsSubPackageTenantId = getOptionalSubPackageTenantId();
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					Long rhsSubPackageTenantId = rhs.getOptionalSubPackageTenantId();
					int cmp = lhsSubPackageTenantId.compareTo( rhsSubPackageTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelCacheId() != null ) {
				Long lhsSubPackageGelCacheId = getOptionalSubPackageGelCacheId();
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					Long rhsSubPackageGelCacheId = rhs.getOptionalSubPackageGelCacheId();
					int cmp = lhsSubPackageGelCacheId.compareTo( rhsSubPackageGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSubPackageGelId() != null ) {
				Long lhsSubPackageGelId = getOptionalSubPackageGelId();
				if( rhs.getOptionalSubPackageGelId() != null ) {
					Long rhsSubPackageGelId = rhs.getOptionalSubPackageGelId();
					int cmp = lhsSubPackageGelId.compareTo( rhsSubPackageGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSubPackageGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpClsNameKey ) {
			CFGenKbGenFileByXExpClsNameKey rhs = (CFGenKbGenFileByXExpClsNameKey)obj;

			if( getOptionalExpansionClassNameTenantId() != null ) {
				Long lhsExpansionClassNameTenantId = getOptionalExpansionClassNameTenantId();
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					Long rhsExpansionClassNameTenantId = rhs.getOptionalExpansionClassNameTenantId();
					int cmp = lhsExpansionClassNameTenantId.compareTo( rhsExpansionClassNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelCacheId() != null ) {
				Long lhsExpansionClassNameGelCacheId = getOptionalExpansionClassNameGelCacheId();
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					Long rhsExpansionClassNameGelCacheId = rhs.getOptionalExpansionClassNameGelCacheId();
					int cmp = lhsExpansionClassNameGelCacheId.compareTo( rhsExpansionClassNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionClassNameGelId() != null ) {
				Long lhsExpansionClassNameGelId = getOptionalExpansionClassNameGelId();
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					Long rhsExpansionClassNameGelId = rhs.getOptionalExpansionClassNameGelId();
					int cmp = lhsExpansionClassNameGelId.compareTo( rhsExpansionClassNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionClassNameGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpKeyNameKey ) {
			CFGenKbGenFileByXExpKeyNameKey rhs = (CFGenKbGenFileByXExpKeyNameKey)obj;

			if( getOptionalExpansionKeyNameTenantId() != null ) {
				Long lhsExpansionKeyNameTenantId = getOptionalExpansionKeyNameTenantId();
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					Long rhsExpansionKeyNameTenantId = rhs.getOptionalExpansionKeyNameTenantId();
					int cmp = lhsExpansionKeyNameTenantId.compareTo( rhsExpansionKeyNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelCacheId() != null ) {
				Long lhsExpansionKeyNameGelCacheId = getOptionalExpansionKeyNameGelCacheId();
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					Long rhsExpansionKeyNameGelCacheId = rhs.getOptionalExpansionKeyNameGelCacheId();
					int cmp = lhsExpansionKeyNameGelCacheId.compareTo( rhsExpansionKeyNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionKeyNameGelId() != null ) {
				Long lhsExpansionKeyNameGelId = getOptionalExpansionKeyNameGelId();
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					Long rhsExpansionKeyNameGelId = rhs.getOptionalExpansionKeyNameGelId();
					int cmp = lhsExpansionKeyNameGelId.compareTo( rhsExpansionKeyNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionKeyNameGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFGenKbGenFileByXExpFileNameKey ) {
			CFGenKbGenFileByXExpFileNameKey rhs = (CFGenKbGenFileByXExpFileNameKey)obj;

			if( getOptionalExpansionFileNameTenantId() != null ) {
				Long lhsExpansionFileNameTenantId = getOptionalExpansionFileNameTenantId();
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					Long rhsExpansionFileNameTenantId = rhs.getOptionalExpansionFileNameTenantId();
					int cmp = lhsExpansionFileNameTenantId.compareTo( rhsExpansionFileNameTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelCacheId() != null ) {
				Long lhsExpansionFileNameGelCacheId = getOptionalExpansionFileNameGelCacheId();
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					Long rhsExpansionFileNameGelCacheId = rhs.getOptionalExpansionFileNameGelCacheId();
					int cmp = lhsExpansionFileNameGelCacheId.compareTo( rhsExpansionFileNameGelCacheId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelCacheId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalExpansionFileNameGelId() != null ) {
				Long lhsExpansionFileNameGelId = getOptionalExpansionFileNameGelId();
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					Long rhsExpansionFileNameGelId = rhs.getOptionalExpansionFileNameGelId();
					int cmp = lhsExpansionFileNameGelId.compareTo( rhsExpansionFileNameGelId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalExpansionFileNameGelId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFGenKbGenItemBuff src ) {
		if( src instanceof CFGenKbGenFileBuff ) {
			setGenFileBuff( (CFGenKbGenFileBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFGenKbGenFileBuff" );
		}
	}

	public void setGenFileBuff( CFGenKbGenFileBuff src ) {
		super.setGenRuleBuff( src );
		setOptionalGenerateOnce( src.getOptionalGenerateOnce() );
		setOptionalSourceBundle( src.getOptionalSourceBundle() );
		setOptionalSourceBundleTenantId( src.getOptionalSourceBundleTenantId() );
		setOptionalSourceBundleGelCacheId( src.getOptionalSourceBundleGelCacheId() );
		setOptionalSourceBundleGelId( src.getOptionalSourceBundleGelId() );
		setOptionalModuleName( src.getOptionalModuleName() );
		setOptionalModuleNameTenantId( src.getOptionalModuleNameTenantId() );
		setOptionalModuleNameGelCacheId( src.getOptionalModuleNameGelCacheId() );
		setOptionalModuleNameGelId( src.getOptionalModuleNameGelId() );
		setOptionalBasePackageName( src.getOptionalBasePackageName() );
		setOptionalBasePackageTenantId( src.getOptionalBasePackageTenantId() );
		setOptionalBasePackageGelCacheId( src.getOptionalBasePackageGelCacheId() );
		setOptionalBasePackageGelId( src.getOptionalBasePackageGelId() );
		setOptionalSubPackageName( src.getOptionalSubPackageName() );
		setOptionalSubPackageTenantId( src.getOptionalSubPackageTenantId() );
		setOptionalSubPackageGelCacheId( src.getOptionalSubPackageGelCacheId() );
		setOptionalSubPackageGelId( src.getOptionalSubPackageGelId() );
		setOptionalExpansionClassName( src.getOptionalExpansionClassName() );
		setOptionalExpansionClassNameTenantId( src.getOptionalExpansionClassNameTenantId() );
		setOptionalExpansionClassNameGelCacheId( src.getOptionalExpansionClassNameGelCacheId() );
		setOptionalExpansionClassNameGelId( src.getOptionalExpansionClassNameGelId() );
		setOptionalExpansionKeyName( src.getOptionalExpansionKeyName() );
		setOptionalExpansionKeyNameTenantId( src.getOptionalExpansionKeyNameTenantId() );
		setOptionalExpansionKeyNameGelCacheId( src.getOptionalExpansionKeyNameGelCacheId() );
		setOptionalExpansionKeyNameGelId( src.getOptionalExpansionKeyNameGelId() );
		setOptionalExpansionFileName( src.getOptionalExpansionFileName() );
		setOptionalExpansionFileNameTenantId( src.getOptionalExpansionFileNameTenantId() );
		setOptionalExpansionFileNameGelCacheId( src.getOptionalExpansionFileNameGelCacheId() );
		setOptionalExpansionFileNameGelId( src.getOptionalExpansionFileNameGelId() );
	}
}
