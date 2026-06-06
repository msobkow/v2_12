// Description: Java 11 implementation of a CFGenKb schema.

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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.Tip.CFTipClientHandler;

public class CFGenKbSchema
	implements ICFGenKbSchema
{
	protected CFGenKbAuthorization authorization;
	protected ICFGenKbTablePerms tablePerms;
	protected CFGenKbConfigurationFile configuration;
	protected String jndiName;
	protected String schemaDbName = "GenKb212";
	protected String lowerDbSchemaName = schemaDbName.toLowerCase();

	static HashMap<String,AuditActionEnum> lookupAuditActionEnum = null;

	public static AuditActionEnum parseAuditActionEnum( String value ) {
		AuditActionEnum retval = parseAuditActionEnum( CFGenKbSchema.class.getName(), value );
		return( retval );
	}

	public static AuditActionEnum parseAuditActionEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseAuditActionEnum";
		if( lookupAuditActionEnum == null ) {
			HashMap<String,AuditActionEnum> newMap = new HashMap<String,AuditActionEnum>();
			newMap.put( "Create", AuditActionEnum.Create );
			newMap.put( "Update", AuditActionEnum.Update );
			newMap.put( "Delete", AuditActionEnum.Delete );
			lookupAuditActionEnum = newMap;
		}
		AuditActionEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Unrecognized enum tag " + value );
			}
		}
		return( retval );
	}

	static HashMap<Integer,AuditActionEnum> lookupOrdinalAuditActionEnum = null;

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Short value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( Integer value ) {
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToAuditActionEnum( CFGenKbSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static AuditActionEnum ordinalToAuditActionEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToAuditActionEnum";
		if( lookupOrdinalAuditActionEnum == null ) {
			HashMap<Integer,AuditActionEnum> newMap = new HashMap<Integer,AuditActionEnum>();
			newMap.put( Integer.valueOf( AuditActionEnum.Create.ordinal() ), AuditActionEnum.Create );
			newMap.put( Integer.valueOf( AuditActionEnum.Update.ordinal() ), AuditActionEnum.Update );
			newMap.put( Integer.valueOf( AuditActionEnum.Delete.ordinal() ), AuditActionEnum.Delete );
			lookupOrdinalAuditActionEnum = newMap;
		}
		AuditActionEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalAuditActionEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Unrecognized enum ordinal " + value.toString() );
			}
		}
		return( retval );
	}

	protected ICFGenKbClusterTable tableCluster;
	protected ICFGenKbDefClassTable tableDefClass;
	protected ICFGenKbGelBoilerplateTable tableGelBoilerplate;
	protected ICFGenKbGelBuiltinTable tableGelBuiltin;
	protected ICFGenKbGelCacheTable tableGelCache;
	protected ICFGenKbGelCallTable tableGelCall;
	protected ICFGenKbGelConstrainTable tableGelConstrain;
	protected ICFGenKbGelCounterTable tableGelCounter;
	protected ICFGenKbGelErrorTable tableGelError;
	protected ICFGenKbGelExecutableTable tableGelExecutable;
	protected ICFGenKbGelExpansionTable tableGelExpansion;
	protected ICFGenKbGelInstructionTable tableGelInstruction;
	protected ICFGenKbGelIteratorTable tableGelIterator;
	protected ICFGenKbGelModifierTable tableGelModifier;
	protected ICFGenKbGelPopTable tableGelPop;
	protected ICFGenKbGelPrefixLineTable tableGelPrefixLine;
	protected ICFGenKbGelReferenceTable tableGelReference;
	protected ICFGenKbGelSequenceTable tableGelSequence;
	protected ICFGenKbGelSpreadTable tableGelSpread;
	protected ICFGenKbGelSwitchTable tableGelSwitch;
	protected ICFGenKbGelSwitchLimbTable tableGelSwitchLimb;
	protected ICFGenKbGenBindTable tableGenBind;
	protected ICFGenKbGenFileTable tableGenFile;
	protected ICFGenKbGenItemTable tableGenItem;
	protected ICFGenKbGenIteratorTable tableGenIterator;
	protected ICFGenKbGenReferenceTable tableGenReference;
	protected ICFGenKbGenRuleTable tableGenRule;
	protected ICFGenKbGenTruncTable tableGenTrunc;
	protected ICFGenKbHostNodeTable tableHostNode;
	protected ICFGenKbRuleCartTable tableRuleCart;
	protected ICFGenKbRuleTypeTable tableRuleType;
	protected ICFGenKbSecAppTable tableSecApp;
	protected ICFGenKbSecDeviceTable tableSecDevice;
	protected ICFGenKbSecFormTable tableSecForm;
	protected ICFGenKbSecGroupTable tableSecGroup;
	protected ICFGenKbSecGroupFormTable tableSecGroupForm;
	protected ICFGenKbSecGrpIncTable tableSecGrpInc;
	protected ICFGenKbSecGrpMembTable tableSecGrpMemb;
	protected ICFGenKbSecSessionTable tableSecSession;
	protected ICFGenKbSecUserTable tableSecUser;
	protected ICFGenKbSysClusterTable tableSysCluster;
	protected ICFGenKbTSecGroupTable tableTSecGroup;
	protected ICFGenKbTSecGrpIncTable tableTSecGrpInc;
	protected ICFGenKbTSecGrpMembTable tableTSecGrpMemb;
	protected ICFGenKbTenantTable tableTenant;
	protected ICFGenKbToolTable tableTool;
	protected ICFGenKbToolSetTable tableToolSet;

	protected ICFGenKbClusterFactory factoryCluster;
	protected ICFGenKbDefClassFactory factoryDefClass;
	protected ICFGenKbGelBoilerplateFactory factoryGelBoilerplate;
	protected ICFGenKbGelBuiltinFactory factoryGelBuiltin;
	protected ICFGenKbGelCacheFactory factoryGelCache;
	protected ICFGenKbGelCallFactory factoryGelCall;
	protected ICFGenKbGelConstrainFactory factoryGelConstrain;
	protected ICFGenKbGelCounterFactory factoryGelCounter;
	protected ICFGenKbGelErrorFactory factoryGelError;
	protected ICFGenKbGelExecutableFactory factoryGelExecutable;
	protected ICFGenKbGelExpansionFactory factoryGelExpansion;
	protected ICFGenKbGelInstructionFactory factoryGelInstruction;
	protected ICFGenKbGelIteratorFactory factoryGelIterator;
	protected ICFGenKbGelModifierFactory factoryGelModifier;
	protected ICFGenKbGelPopFactory factoryGelPop;
	protected ICFGenKbGelPrefixLineFactory factoryGelPrefixLine;
	protected ICFGenKbGelReferenceFactory factoryGelReference;
	protected ICFGenKbGelSequenceFactory factoryGelSequence;
	protected ICFGenKbGelSpreadFactory factoryGelSpread;
	protected ICFGenKbGelSwitchFactory factoryGelSwitch;
	protected ICFGenKbGelSwitchLimbFactory factoryGelSwitchLimb;
	protected ICFGenKbGenBindFactory factoryGenBind;
	protected ICFGenKbGenFileFactory factoryGenFile;
	protected ICFGenKbGenItemFactory factoryGenItem;
	protected ICFGenKbGenIteratorFactory factoryGenIterator;
	protected ICFGenKbGenReferenceFactory factoryGenReference;
	protected ICFGenKbGenRuleFactory factoryGenRule;
	protected ICFGenKbGenTruncFactory factoryGenTrunc;
	protected ICFGenKbHostNodeFactory factoryHostNode;
	protected ICFGenKbRuleCartFactory factoryRuleCart;
	protected ICFGenKbRuleTypeFactory factoryRuleType;
	protected ICFGenKbSecAppFactory factorySecApp;
	protected ICFGenKbSecDeviceFactory factorySecDevice;
	protected ICFGenKbSecFormFactory factorySecForm;
	protected ICFGenKbSecGroupFactory factorySecGroup;
	protected ICFGenKbSecGroupFormFactory factorySecGroupForm;
	protected ICFGenKbSecGrpIncFactory factorySecGrpInc;
	protected ICFGenKbSecGrpMembFactory factorySecGrpMemb;
	protected ICFGenKbSecSessionFactory factorySecSession;
	protected ICFGenKbSecUserFactory factorySecUser;
	protected ICFGenKbSysClusterFactory factorySysCluster;
	protected ICFGenKbTSecGroupFactory factoryTSecGroup;
	protected ICFGenKbTSecGrpIncFactory factoryTSecGrpInc;
	protected ICFGenKbTSecGrpMembFactory factoryTSecGrpMemb;
	protected ICFGenKbTenantFactory factoryTenant;
	protected ICFGenKbToolFactory factoryTool;
	protected ICFGenKbToolSetFactory factoryToolSet;


	public CFGenKbSchema() {
		configuration = null;
		jndiName = null;

		tableCluster = null;
		tableDefClass = null;
		tableGelBoilerplate = null;
		tableGelBuiltin = null;
		tableGelCache = null;
		tableGelCall = null;
		tableGelConstrain = null;
		tableGelCounter = null;
		tableGelError = null;
		tableGelExecutable = null;
		tableGelExpansion = null;
		tableGelInstruction = null;
		tableGelIterator = null;
		tableGelModifier = null;
		tableGelPop = null;
		tableGelPrefixLine = null;
		tableGelReference = null;
		tableGelSequence = null;
		tableGelSpread = null;
		tableGelSwitch = null;
		tableGelSwitchLimb = null;
		tableGenBind = null;
		tableGenFile = null;
		tableGenItem = null;
		tableGenIterator = null;
		tableGenReference = null;
		tableGenRule = null;
		tableGenTrunc = null;
		tableHostNode = null;
		tableRuleCart = null;
		tableRuleType = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTenant = null;
		tableTool = null;
		tableToolSet = null;

		factoryCluster = new CFGenKbClusterDefaultFactory();
		factoryDefClass = new CFGenKbDefClassDefaultFactory();
		factoryGelBoilerplate = new CFGenKbGelBoilerplateDefaultFactory();
		factoryGelBuiltin = new CFGenKbGelBuiltinDefaultFactory();
		factoryGelCache = new CFGenKbGelCacheDefaultFactory();
		factoryGelCall = new CFGenKbGelCallDefaultFactory();
		factoryGelConstrain = new CFGenKbGelConstrainDefaultFactory();
		factoryGelCounter = new CFGenKbGelCounterDefaultFactory();
		factoryGelError = new CFGenKbGelErrorDefaultFactory();
		factoryGelExecutable = new CFGenKbGelExecutableDefaultFactory();
		factoryGelExpansion = new CFGenKbGelExpansionDefaultFactory();
		factoryGelInstruction = new CFGenKbGelInstructionDefaultFactory();
		factoryGelIterator = new CFGenKbGelIteratorDefaultFactory();
		factoryGelModifier = new CFGenKbGelModifierDefaultFactory();
		factoryGelPop = new CFGenKbGelPopDefaultFactory();
		factoryGelPrefixLine = new CFGenKbGelPrefixLineDefaultFactory();
		factoryGelReference = new CFGenKbGelReferenceDefaultFactory();
		factoryGelSequence = new CFGenKbGelSequenceDefaultFactory();
		factoryGelSpread = new CFGenKbGelSpreadDefaultFactory();
		factoryGelSwitch = new CFGenKbGelSwitchDefaultFactory();
		factoryGelSwitchLimb = new CFGenKbGelSwitchLimbDefaultFactory();
		factoryGenBind = new CFGenKbGenBindDefaultFactory();
		factoryGenFile = new CFGenKbGenFileDefaultFactory();
		factoryGenItem = new CFGenKbGenItemDefaultFactory();
		factoryGenIterator = new CFGenKbGenIteratorDefaultFactory();
		factoryGenReference = new CFGenKbGenReferenceDefaultFactory();
		factoryGenRule = new CFGenKbGenRuleDefaultFactory();
		factoryGenTrunc = new CFGenKbGenTruncDefaultFactory();
		factoryHostNode = new CFGenKbHostNodeDefaultFactory();
		factoryRuleCart = new CFGenKbRuleCartDefaultFactory();
		factoryRuleType = new CFGenKbRuleTypeDefaultFactory();
		factorySecApp = new CFGenKbSecAppDefaultFactory();
		factorySecDevice = new CFGenKbSecDeviceDefaultFactory();
		factorySecForm = new CFGenKbSecFormDefaultFactory();
		factorySecGroup = new CFGenKbSecGroupDefaultFactory();
		factorySecGroupForm = new CFGenKbSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFGenKbSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFGenKbSecGrpMembDefaultFactory();
		factorySecSession = new CFGenKbSecSessionDefaultFactory();
		factorySecUser = new CFGenKbSecUserDefaultFactory();
		factorySysCluster = new CFGenKbSysClusterDefaultFactory();
		factoryTSecGroup = new CFGenKbTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFGenKbTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFGenKbTSecGrpMembDefaultFactory();
		factoryTenant = new CFGenKbTenantDefaultFactory();
		factoryTool = new CFGenKbToolDefaultFactory();
		factoryToolSet = new CFGenKbToolSetDefaultFactory();	}

	public CFGenKbSchema( CFGenKbConfigurationFile conf ) {
		if( conf == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"CFGenKbSchema-constructor",
				1,
				"conf" );
		}
		configuration = conf;
		jndiName = null;

		tableCluster = null;
		tableDefClass = null;
		tableGelBoilerplate = null;
		tableGelBuiltin = null;
		tableGelCache = null;
		tableGelCall = null;
		tableGelConstrain = null;
		tableGelCounter = null;
		tableGelError = null;
		tableGelExecutable = null;
		tableGelExpansion = null;
		tableGelInstruction = null;
		tableGelIterator = null;
		tableGelModifier = null;
		tableGelPop = null;
		tableGelPrefixLine = null;
		tableGelReference = null;
		tableGelSequence = null;
		tableGelSpread = null;
		tableGelSwitch = null;
		tableGelSwitchLimb = null;
		tableGenBind = null;
		tableGenFile = null;
		tableGenItem = null;
		tableGenIterator = null;
		tableGenReference = null;
		tableGenRule = null;
		tableGenTrunc = null;
		tableHostNode = null;
		tableRuleCart = null;
		tableRuleType = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTenant = null;
		tableTool = null;
		tableToolSet = null;

		factoryCluster = new CFGenKbClusterDefaultFactory();
		factoryDefClass = new CFGenKbDefClassDefaultFactory();
		factoryGelBoilerplate = new CFGenKbGelBoilerplateDefaultFactory();
		factoryGelBuiltin = new CFGenKbGelBuiltinDefaultFactory();
		factoryGelCache = new CFGenKbGelCacheDefaultFactory();
		factoryGelCall = new CFGenKbGelCallDefaultFactory();
		factoryGelConstrain = new CFGenKbGelConstrainDefaultFactory();
		factoryGelCounter = new CFGenKbGelCounterDefaultFactory();
		factoryGelError = new CFGenKbGelErrorDefaultFactory();
		factoryGelExecutable = new CFGenKbGelExecutableDefaultFactory();
		factoryGelExpansion = new CFGenKbGelExpansionDefaultFactory();
		factoryGelInstruction = new CFGenKbGelInstructionDefaultFactory();
		factoryGelIterator = new CFGenKbGelIteratorDefaultFactory();
		factoryGelModifier = new CFGenKbGelModifierDefaultFactory();
		factoryGelPop = new CFGenKbGelPopDefaultFactory();
		factoryGelPrefixLine = new CFGenKbGelPrefixLineDefaultFactory();
		factoryGelReference = new CFGenKbGelReferenceDefaultFactory();
		factoryGelSequence = new CFGenKbGelSequenceDefaultFactory();
		factoryGelSpread = new CFGenKbGelSpreadDefaultFactory();
		factoryGelSwitch = new CFGenKbGelSwitchDefaultFactory();
		factoryGelSwitchLimb = new CFGenKbGelSwitchLimbDefaultFactory();
		factoryGenBind = new CFGenKbGenBindDefaultFactory();
		factoryGenFile = new CFGenKbGenFileDefaultFactory();
		factoryGenItem = new CFGenKbGenItemDefaultFactory();
		factoryGenIterator = new CFGenKbGenIteratorDefaultFactory();
		factoryGenReference = new CFGenKbGenReferenceDefaultFactory();
		factoryGenRule = new CFGenKbGenRuleDefaultFactory();
		factoryGenTrunc = new CFGenKbGenTruncDefaultFactory();
		factoryHostNode = new CFGenKbHostNodeDefaultFactory();
		factoryRuleCart = new CFGenKbRuleCartDefaultFactory();
		factoryRuleType = new CFGenKbRuleTypeDefaultFactory();
		factorySecApp = new CFGenKbSecAppDefaultFactory();
		factorySecDevice = new CFGenKbSecDeviceDefaultFactory();
		factorySecForm = new CFGenKbSecFormDefaultFactory();
		factorySecGroup = new CFGenKbSecGroupDefaultFactory();
		factorySecGroupForm = new CFGenKbSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFGenKbSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFGenKbSecGrpMembDefaultFactory();
		factorySecSession = new CFGenKbSecSessionDefaultFactory();
		factorySecUser = new CFGenKbSecUserDefaultFactory();
		factorySysCluster = new CFGenKbSysClusterDefaultFactory();
		factoryTSecGroup = new CFGenKbTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFGenKbTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFGenKbTSecGrpMembDefaultFactory();
		factoryTenant = new CFGenKbTenantDefaultFactory();
		factoryTool = new CFGenKbToolDefaultFactory();
		factoryToolSet = new CFGenKbToolSetDefaultFactory();	}

	public CFGenKbSchema( String argJndiName ) {
		if( ( argJndiName == null ) || ( argJndiName.length() <= 0 ) ) {
			throw new CFLibEmptyArgumentException( getClass(),
				"CFGenKbSchema-constructor",
				1,
				"argJndiName" );
		}
		configuration = null;
		jndiName = argJndiName;

		tableCluster = null;
		tableDefClass = null;
		tableGelBoilerplate = null;
		tableGelBuiltin = null;
		tableGelCache = null;
		tableGelCall = null;
		tableGelConstrain = null;
		tableGelCounter = null;
		tableGelError = null;
		tableGelExecutable = null;
		tableGelExpansion = null;
		tableGelInstruction = null;
		tableGelIterator = null;
		tableGelModifier = null;
		tableGelPop = null;
		tableGelPrefixLine = null;
		tableGelReference = null;
		tableGelSequence = null;
		tableGelSpread = null;
		tableGelSwitch = null;
		tableGelSwitchLimb = null;
		tableGenBind = null;
		tableGenFile = null;
		tableGenItem = null;
		tableGenIterator = null;
		tableGenReference = null;
		tableGenRule = null;
		tableGenTrunc = null;
		tableHostNode = null;
		tableRuleCart = null;
		tableRuleType = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTenant = null;
		tableTool = null;
		tableToolSet = null;

		factoryCluster = new CFGenKbClusterDefaultFactory();
		factoryDefClass = new CFGenKbDefClassDefaultFactory();
		factoryGelBoilerplate = new CFGenKbGelBoilerplateDefaultFactory();
		factoryGelBuiltin = new CFGenKbGelBuiltinDefaultFactory();
		factoryGelCache = new CFGenKbGelCacheDefaultFactory();
		factoryGelCall = new CFGenKbGelCallDefaultFactory();
		factoryGelConstrain = new CFGenKbGelConstrainDefaultFactory();
		factoryGelCounter = new CFGenKbGelCounterDefaultFactory();
		factoryGelError = new CFGenKbGelErrorDefaultFactory();
		factoryGelExecutable = new CFGenKbGelExecutableDefaultFactory();
		factoryGelExpansion = new CFGenKbGelExpansionDefaultFactory();
		factoryGelInstruction = new CFGenKbGelInstructionDefaultFactory();
		factoryGelIterator = new CFGenKbGelIteratorDefaultFactory();
		factoryGelModifier = new CFGenKbGelModifierDefaultFactory();
		factoryGelPop = new CFGenKbGelPopDefaultFactory();
		factoryGelPrefixLine = new CFGenKbGelPrefixLineDefaultFactory();
		factoryGelReference = new CFGenKbGelReferenceDefaultFactory();
		factoryGelSequence = new CFGenKbGelSequenceDefaultFactory();
		factoryGelSpread = new CFGenKbGelSpreadDefaultFactory();
		factoryGelSwitch = new CFGenKbGelSwitchDefaultFactory();
		factoryGelSwitchLimb = new CFGenKbGelSwitchLimbDefaultFactory();
		factoryGenBind = new CFGenKbGenBindDefaultFactory();
		factoryGenFile = new CFGenKbGenFileDefaultFactory();
		factoryGenItem = new CFGenKbGenItemDefaultFactory();
		factoryGenIterator = new CFGenKbGenIteratorDefaultFactory();
		factoryGenReference = new CFGenKbGenReferenceDefaultFactory();
		factoryGenRule = new CFGenKbGenRuleDefaultFactory();
		factoryGenTrunc = new CFGenKbGenTruncDefaultFactory();
		factoryHostNode = new CFGenKbHostNodeDefaultFactory();
		factoryRuleCart = new CFGenKbRuleCartDefaultFactory();
		factoryRuleType = new CFGenKbRuleTypeDefaultFactory();
		factorySecApp = new CFGenKbSecAppDefaultFactory();
		factorySecDevice = new CFGenKbSecDeviceDefaultFactory();
		factorySecForm = new CFGenKbSecFormDefaultFactory();
		factorySecGroup = new CFGenKbSecGroupDefaultFactory();
		factorySecGroupForm = new CFGenKbSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFGenKbSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFGenKbSecGrpMembDefaultFactory();
		factorySecSession = new CFGenKbSecSessionDefaultFactory();
		factorySecUser = new CFGenKbSecUserDefaultFactory();
		factorySysCluster = new CFGenKbSysClusterDefaultFactory();
		factoryTSecGroup = new CFGenKbTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFGenKbTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFGenKbTSecGrpMembDefaultFactory();
		factoryTenant = new CFGenKbTenantDefaultFactory();
		factoryTool = new CFGenKbToolDefaultFactory();
		factoryToolSet = new CFGenKbToolSetDefaultFactory();	}

	/**
	 *	The majority of cases do not have a CFTipClientHandler
	 *	associated with it's persistence implementation.
	 *	Only the XMsg client implementations overload this
	 *	to return the actual CFTipClientHandler associated
	 *	with the connection instance.
	 */
	public CFTipClientHandler getCFTipClientHandler() {
		return( null );
	}

	public String getServerURL() {
		return( null );
	}

	public void setServerURL( String value ) {
	}

	public CFGenKbConfigurationFile getConfigurationFile() {
		return( configuration );
	}

	public void setConfigurationFile( CFGenKbConfigurationFile value ) {
		if( value == null ) {
			configuration = null;
		}
		else {
			configuration = value;
			jndiName = null;
		}
	}

	public CFGenKbAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFGenKbAuthorization value ) {
		authorization = value;
	}

	public String getJndiName() {
		return( jndiName );
	}

	public void setJndiName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			jndiName = null;
		}
		else {
			configuration = null;
			jndiName = value;
		}
	}

	public boolean isConnected() {
		throw new CFLibMustOverrideException( getClass(), "isConnected" );
	}

	public boolean connect() {
		throw new CFLibMustOverrideException( getClass(), "connect" );
	}

	public boolean connect( String username, String password ) {
		throw new CFLibMustOverrideException( getClass(), "connect-userpw" );
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		throw new CFLibMustOverrideException( getClass(), "connect-full" );
	}

	public void disconnect( boolean doCommit ) {
		throw new CFLibMustOverrideException( getClass(), "disconnect" );
	}

	public void logout( CFGenKbAuthorization auth ) {
		throw new CFLibMustOverrideException( getClass(), "logout" );
	}

	public ICFGenKbSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	public short nextDefClassIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextDefClassIdGen" );
	}

	public short nextRuleTypeIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextRuleTypeIdGen" );
	}

	public short nextToolIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextToolIdGen" );
	}

	public short nextToolSetIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextToolSetIdGen" );
	}

	public long nextClusterIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextClusterIdGen" );
	}

	public long nextTenantIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextTenantIdGen" );
	}

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public ICFGenKbClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFGenKbClusterTable value ) {
		tableCluster = value;
	}

	public ICFGenKbClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFGenKbClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFGenKbDefClassTable getTableDefClass() {
		return( tableDefClass );
	}

	public void setTableDefClass( ICFGenKbDefClassTable value ) {
		tableDefClass = value;
	}

	public ICFGenKbDefClassFactory getFactoryDefClass() {
		return( factoryDefClass );
	}

	public void setFactoryDefClass( ICFGenKbDefClassFactory value ) {
		factoryDefClass = value;
	}

	public ICFGenKbGelBoilerplateTable getTableGelBoilerplate() {
		return( tableGelBoilerplate );
	}

	public void setTableGelBoilerplate( ICFGenKbGelBoilerplateTable value ) {
		tableGelBoilerplate = value;
	}

	public ICFGenKbGelBoilerplateFactory getFactoryGelBoilerplate() {
		return( factoryGelBoilerplate );
	}

	public void setFactoryGelBoilerplate( ICFGenKbGelBoilerplateFactory value ) {
		factoryGelBoilerplate = value;
	}

	public ICFGenKbGelBuiltinTable getTableGelBuiltin() {
		return( tableGelBuiltin );
	}

	public void setTableGelBuiltin( ICFGenKbGelBuiltinTable value ) {
		tableGelBuiltin = value;
	}

	public ICFGenKbGelBuiltinFactory getFactoryGelBuiltin() {
		return( factoryGelBuiltin );
	}

	public void setFactoryGelBuiltin( ICFGenKbGelBuiltinFactory value ) {
		factoryGelBuiltin = value;
	}

	public ICFGenKbGelCacheTable getTableGelCache() {
		return( tableGelCache );
	}

	public void setTableGelCache( ICFGenKbGelCacheTable value ) {
		tableGelCache = value;
	}

	public ICFGenKbGelCacheFactory getFactoryGelCache() {
		return( factoryGelCache );
	}

	public void setFactoryGelCache( ICFGenKbGelCacheFactory value ) {
		factoryGelCache = value;
	}

	public ICFGenKbGelCallTable getTableGelCall() {
		return( tableGelCall );
	}

	public void setTableGelCall( ICFGenKbGelCallTable value ) {
		tableGelCall = value;
	}

	public ICFGenKbGelCallFactory getFactoryGelCall() {
		return( factoryGelCall );
	}

	public void setFactoryGelCall( ICFGenKbGelCallFactory value ) {
		factoryGelCall = value;
	}

	public ICFGenKbGelConstrainTable getTableGelConstrain() {
		return( tableGelConstrain );
	}

	public void setTableGelConstrain( ICFGenKbGelConstrainTable value ) {
		tableGelConstrain = value;
	}

	public ICFGenKbGelConstrainFactory getFactoryGelConstrain() {
		return( factoryGelConstrain );
	}

	public void setFactoryGelConstrain( ICFGenKbGelConstrainFactory value ) {
		factoryGelConstrain = value;
	}

	public ICFGenKbGelCounterTable getTableGelCounter() {
		return( tableGelCounter );
	}

	public void setTableGelCounter( ICFGenKbGelCounterTable value ) {
		tableGelCounter = value;
	}

	public ICFGenKbGelCounterFactory getFactoryGelCounter() {
		return( factoryGelCounter );
	}

	public void setFactoryGelCounter( ICFGenKbGelCounterFactory value ) {
		factoryGelCounter = value;
	}

	public ICFGenKbGelErrorTable getTableGelError() {
		return( tableGelError );
	}

	public void setTableGelError( ICFGenKbGelErrorTable value ) {
		tableGelError = value;
	}

	public ICFGenKbGelErrorFactory getFactoryGelError() {
		return( factoryGelError );
	}

	public void setFactoryGelError( ICFGenKbGelErrorFactory value ) {
		factoryGelError = value;
	}

	public ICFGenKbGelExecutableTable getTableGelExecutable() {
		return( tableGelExecutable );
	}

	public void setTableGelExecutable( ICFGenKbGelExecutableTable value ) {
		tableGelExecutable = value;
	}

	public ICFGenKbGelExecutableFactory getFactoryGelExecutable() {
		return( factoryGelExecutable );
	}

	public void setFactoryGelExecutable( ICFGenKbGelExecutableFactory value ) {
		factoryGelExecutable = value;
	}

	public ICFGenKbGelExpansionTable getTableGelExpansion() {
		return( tableGelExpansion );
	}

	public void setTableGelExpansion( ICFGenKbGelExpansionTable value ) {
		tableGelExpansion = value;
	}

	public ICFGenKbGelExpansionFactory getFactoryGelExpansion() {
		return( factoryGelExpansion );
	}

	public void setFactoryGelExpansion( ICFGenKbGelExpansionFactory value ) {
		factoryGelExpansion = value;
	}

	public ICFGenKbGelInstructionTable getTableGelInstruction() {
		return( tableGelInstruction );
	}

	public void setTableGelInstruction( ICFGenKbGelInstructionTable value ) {
		tableGelInstruction = value;
	}

	public ICFGenKbGelInstructionFactory getFactoryGelInstruction() {
		return( factoryGelInstruction );
	}

	public void setFactoryGelInstruction( ICFGenKbGelInstructionFactory value ) {
		factoryGelInstruction = value;
	}

	public ICFGenKbGelIteratorTable getTableGelIterator() {
		return( tableGelIterator );
	}

	public void setTableGelIterator( ICFGenKbGelIteratorTable value ) {
		tableGelIterator = value;
	}

	public ICFGenKbGelIteratorFactory getFactoryGelIterator() {
		return( factoryGelIterator );
	}

	public void setFactoryGelIterator( ICFGenKbGelIteratorFactory value ) {
		factoryGelIterator = value;
	}

	public ICFGenKbGelModifierTable getTableGelModifier() {
		return( tableGelModifier );
	}

	public void setTableGelModifier( ICFGenKbGelModifierTable value ) {
		tableGelModifier = value;
	}

	public ICFGenKbGelModifierFactory getFactoryGelModifier() {
		return( factoryGelModifier );
	}

	public void setFactoryGelModifier( ICFGenKbGelModifierFactory value ) {
		factoryGelModifier = value;
	}

	public ICFGenKbGelPopTable getTableGelPop() {
		return( tableGelPop );
	}

	public void setTableGelPop( ICFGenKbGelPopTable value ) {
		tableGelPop = value;
	}

	public ICFGenKbGelPopFactory getFactoryGelPop() {
		return( factoryGelPop );
	}

	public void setFactoryGelPop( ICFGenKbGelPopFactory value ) {
		factoryGelPop = value;
	}

	public ICFGenKbGelPrefixLineTable getTableGelPrefixLine() {
		return( tableGelPrefixLine );
	}

	public void setTableGelPrefixLine( ICFGenKbGelPrefixLineTable value ) {
		tableGelPrefixLine = value;
	}

	public ICFGenKbGelPrefixLineFactory getFactoryGelPrefixLine() {
		return( factoryGelPrefixLine );
	}

	public void setFactoryGelPrefixLine( ICFGenKbGelPrefixLineFactory value ) {
		factoryGelPrefixLine = value;
	}

	public ICFGenKbGelReferenceTable getTableGelReference() {
		return( tableGelReference );
	}

	public void setTableGelReference( ICFGenKbGelReferenceTable value ) {
		tableGelReference = value;
	}

	public ICFGenKbGelReferenceFactory getFactoryGelReference() {
		return( factoryGelReference );
	}

	public void setFactoryGelReference( ICFGenKbGelReferenceFactory value ) {
		factoryGelReference = value;
	}

	public ICFGenKbGelSequenceTable getTableGelSequence() {
		return( tableGelSequence );
	}

	public void setTableGelSequence( ICFGenKbGelSequenceTable value ) {
		tableGelSequence = value;
	}

	public ICFGenKbGelSequenceFactory getFactoryGelSequence() {
		return( factoryGelSequence );
	}

	public void setFactoryGelSequence( ICFGenKbGelSequenceFactory value ) {
		factoryGelSequence = value;
	}

	public ICFGenKbGelSpreadTable getTableGelSpread() {
		return( tableGelSpread );
	}

	public void setTableGelSpread( ICFGenKbGelSpreadTable value ) {
		tableGelSpread = value;
	}

	public ICFGenKbGelSpreadFactory getFactoryGelSpread() {
		return( factoryGelSpread );
	}

	public void setFactoryGelSpread( ICFGenKbGelSpreadFactory value ) {
		factoryGelSpread = value;
	}

	public ICFGenKbGelSwitchTable getTableGelSwitch() {
		return( tableGelSwitch );
	}

	public void setTableGelSwitch( ICFGenKbGelSwitchTable value ) {
		tableGelSwitch = value;
	}

	public ICFGenKbGelSwitchFactory getFactoryGelSwitch() {
		return( factoryGelSwitch );
	}

	public void setFactoryGelSwitch( ICFGenKbGelSwitchFactory value ) {
		factoryGelSwitch = value;
	}

	public ICFGenKbGelSwitchLimbTable getTableGelSwitchLimb() {
		return( tableGelSwitchLimb );
	}

	public void setTableGelSwitchLimb( ICFGenKbGelSwitchLimbTable value ) {
		tableGelSwitchLimb = value;
	}

	public ICFGenKbGelSwitchLimbFactory getFactoryGelSwitchLimb() {
		return( factoryGelSwitchLimb );
	}

	public void setFactoryGelSwitchLimb( ICFGenKbGelSwitchLimbFactory value ) {
		factoryGelSwitchLimb = value;
	}

	public ICFGenKbGenBindTable getTableGenBind() {
		return( tableGenBind );
	}

	public void setTableGenBind( ICFGenKbGenBindTable value ) {
		tableGenBind = value;
	}

	public ICFGenKbGenBindFactory getFactoryGenBind() {
		return( factoryGenBind );
	}

	public void setFactoryGenBind( ICFGenKbGenBindFactory value ) {
		factoryGenBind = value;
	}

	public ICFGenKbGenFileTable getTableGenFile() {
		return( tableGenFile );
	}

	public void setTableGenFile( ICFGenKbGenFileTable value ) {
		tableGenFile = value;
	}

	public ICFGenKbGenFileFactory getFactoryGenFile() {
		return( factoryGenFile );
	}

	public void setFactoryGenFile( ICFGenKbGenFileFactory value ) {
		factoryGenFile = value;
	}

	public ICFGenKbGenItemTable getTableGenItem() {
		return( tableGenItem );
	}

	public void setTableGenItem( ICFGenKbGenItemTable value ) {
		tableGenItem = value;
	}

	public ICFGenKbGenItemFactory getFactoryGenItem() {
		return( factoryGenItem );
	}

	public void setFactoryGenItem( ICFGenKbGenItemFactory value ) {
		factoryGenItem = value;
	}

	public ICFGenKbGenIteratorTable getTableGenIterator() {
		return( tableGenIterator );
	}

	public void setTableGenIterator( ICFGenKbGenIteratorTable value ) {
		tableGenIterator = value;
	}

	public ICFGenKbGenIteratorFactory getFactoryGenIterator() {
		return( factoryGenIterator );
	}

	public void setFactoryGenIterator( ICFGenKbGenIteratorFactory value ) {
		factoryGenIterator = value;
	}

	public ICFGenKbGenReferenceTable getTableGenReference() {
		return( tableGenReference );
	}

	public void setTableGenReference( ICFGenKbGenReferenceTable value ) {
		tableGenReference = value;
	}

	public ICFGenKbGenReferenceFactory getFactoryGenReference() {
		return( factoryGenReference );
	}

	public void setFactoryGenReference( ICFGenKbGenReferenceFactory value ) {
		factoryGenReference = value;
	}

	public ICFGenKbGenRuleTable getTableGenRule() {
		return( tableGenRule );
	}

	public void setTableGenRule( ICFGenKbGenRuleTable value ) {
		tableGenRule = value;
	}

	public ICFGenKbGenRuleFactory getFactoryGenRule() {
		return( factoryGenRule );
	}

	public void setFactoryGenRule( ICFGenKbGenRuleFactory value ) {
		factoryGenRule = value;
	}

	public ICFGenKbGenTruncTable getTableGenTrunc() {
		return( tableGenTrunc );
	}

	public void setTableGenTrunc( ICFGenKbGenTruncTable value ) {
		tableGenTrunc = value;
	}

	public ICFGenKbGenTruncFactory getFactoryGenTrunc() {
		return( factoryGenTrunc );
	}

	public void setFactoryGenTrunc( ICFGenKbGenTruncFactory value ) {
		factoryGenTrunc = value;
	}

	public ICFGenKbHostNodeTable getTableHostNode() {
		return( tableHostNode );
	}

	public void setTableHostNode( ICFGenKbHostNodeTable value ) {
		tableHostNode = value;
	}

	public ICFGenKbHostNodeFactory getFactoryHostNode() {
		return( factoryHostNode );
	}

	public void setFactoryHostNode( ICFGenKbHostNodeFactory value ) {
		factoryHostNode = value;
	}

	public ICFGenKbRuleCartTable getTableRuleCart() {
		return( tableRuleCart );
	}

	public void setTableRuleCart( ICFGenKbRuleCartTable value ) {
		tableRuleCart = value;
	}

	public ICFGenKbRuleCartFactory getFactoryRuleCart() {
		return( factoryRuleCart );
	}

	public void setFactoryRuleCart( ICFGenKbRuleCartFactory value ) {
		factoryRuleCart = value;
	}

	public ICFGenKbRuleTypeTable getTableRuleType() {
		return( tableRuleType );
	}

	public void setTableRuleType( ICFGenKbRuleTypeTable value ) {
		tableRuleType = value;
	}

	public ICFGenKbRuleTypeFactory getFactoryRuleType() {
		return( factoryRuleType );
	}

	public void setFactoryRuleType( ICFGenKbRuleTypeFactory value ) {
		factoryRuleType = value;
	}

	public ICFGenKbSecAppTable getTableSecApp() {
		return( tableSecApp );
	}

	public void setTableSecApp( ICFGenKbSecAppTable value ) {
		tableSecApp = value;
	}

	public ICFGenKbSecAppFactory getFactorySecApp() {
		return( factorySecApp );
	}

	public void setFactorySecApp( ICFGenKbSecAppFactory value ) {
		factorySecApp = value;
	}

	public ICFGenKbSecDeviceTable getTableSecDevice() {
		return( tableSecDevice );
	}

	public void setTableSecDevice( ICFGenKbSecDeviceTable value ) {
		tableSecDevice = value;
	}

	public ICFGenKbSecDeviceFactory getFactorySecDevice() {
		return( factorySecDevice );
	}

	public void setFactorySecDevice( ICFGenKbSecDeviceFactory value ) {
		factorySecDevice = value;
	}

	public ICFGenKbSecFormTable getTableSecForm() {
		return( tableSecForm );
	}

	public void setTableSecForm( ICFGenKbSecFormTable value ) {
		tableSecForm = value;
	}

	public ICFGenKbSecFormFactory getFactorySecForm() {
		return( factorySecForm );
	}

	public void setFactorySecForm( ICFGenKbSecFormFactory value ) {
		factorySecForm = value;
	}

	public ICFGenKbSecGroupTable getTableSecGroup() {
		return( tableSecGroup );
	}

	public void setTableSecGroup( ICFGenKbSecGroupTable value ) {
		tableSecGroup = value;
	}

	public ICFGenKbSecGroupFactory getFactorySecGroup() {
		return( factorySecGroup );
	}

	public void setFactorySecGroup( ICFGenKbSecGroupFactory value ) {
		factorySecGroup = value;
	}

	public ICFGenKbSecGroupFormTable getTableSecGroupForm() {
		return( tableSecGroupForm );
	}

	public void setTableSecGroupForm( ICFGenKbSecGroupFormTable value ) {
		tableSecGroupForm = value;
	}

	public ICFGenKbSecGroupFormFactory getFactorySecGroupForm() {
		return( factorySecGroupForm );
	}

	public void setFactorySecGroupForm( ICFGenKbSecGroupFormFactory value ) {
		factorySecGroupForm = value;
	}

	public ICFGenKbSecGrpIncTable getTableSecGrpInc() {
		return( tableSecGrpInc );
	}

	public void setTableSecGrpInc( ICFGenKbSecGrpIncTable value ) {
		tableSecGrpInc = value;
	}

	public ICFGenKbSecGrpIncFactory getFactorySecGrpInc() {
		return( factorySecGrpInc );
	}

	public void setFactorySecGrpInc( ICFGenKbSecGrpIncFactory value ) {
		factorySecGrpInc = value;
	}

	public ICFGenKbSecGrpMembTable getTableSecGrpMemb() {
		return( tableSecGrpMemb );
	}

	public void setTableSecGrpMemb( ICFGenKbSecGrpMembTable value ) {
		tableSecGrpMemb = value;
	}

	public ICFGenKbSecGrpMembFactory getFactorySecGrpMemb() {
		return( factorySecGrpMemb );
	}

	public void setFactorySecGrpMemb( ICFGenKbSecGrpMembFactory value ) {
		factorySecGrpMemb = value;
	}

	public ICFGenKbSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFGenKbSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFGenKbSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFGenKbSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFGenKbSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFGenKbSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFGenKbSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFGenKbSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFGenKbSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFGenKbSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFGenKbSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFGenKbSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFGenKbTSecGroupTable getTableTSecGroup() {
		return( tableTSecGroup );
	}

	public void setTableTSecGroup( ICFGenKbTSecGroupTable value ) {
		tableTSecGroup = value;
	}

	public ICFGenKbTSecGroupFactory getFactoryTSecGroup() {
		return( factoryTSecGroup );
	}

	public void setFactoryTSecGroup( ICFGenKbTSecGroupFactory value ) {
		factoryTSecGroup = value;
	}

	public ICFGenKbTSecGrpIncTable getTableTSecGrpInc() {
		return( tableTSecGrpInc );
	}

	public void setTableTSecGrpInc( ICFGenKbTSecGrpIncTable value ) {
		tableTSecGrpInc = value;
	}

	public ICFGenKbTSecGrpIncFactory getFactoryTSecGrpInc() {
		return( factoryTSecGrpInc );
	}

	public void setFactoryTSecGrpInc( ICFGenKbTSecGrpIncFactory value ) {
		factoryTSecGrpInc = value;
	}

	public ICFGenKbTSecGrpMembTable getTableTSecGrpMemb() {
		return( tableTSecGrpMemb );
	}

	public void setTableTSecGrpMemb( ICFGenKbTSecGrpMembTable value ) {
		tableTSecGrpMemb = value;
	}

	public ICFGenKbTSecGrpMembFactory getFactoryTSecGrpMemb() {
		return( factoryTSecGrpMemb );
	}

	public void setFactoryTSecGrpMemb( ICFGenKbTSecGrpMembFactory value ) {
		factoryTSecGrpMemb = value;
	}

	public ICFGenKbTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFGenKbTenantTable value ) {
		tableTenant = value;
	}

	public ICFGenKbTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFGenKbTenantFactory value ) {
		factoryTenant = value;
	}

	public ICFGenKbToolTable getTableTool() {
		return( tableTool );
	}

	public void setTableTool( ICFGenKbToolTable value ) {
		tableTool = value;
	}

	public ICFGenKbToolFactory getFactoryTool() {
		return( factoryTool );
	}

	public void setFactoryTool( ICFGenKbToolFactory value ) {
		factoryTool = value;
	}

	public ICFGenKbToolSetTable getTableToolSet() {
		return( tableToolSet );
	}

	public void setTableToolSet( ICFGenKbToolSetTable value ) {
		tableToolSet = value;
	}

	public ICFGenKbToolSetFactory getFactoryToolSet() {
		return( factoryToolSet );
	}

	public void setFactoryToolSet( ICFGenKbToolSetFactory value ) {
		factoryToolSet = value;
	}

	public boolean isTransactionOpen() {
		throw new CFLibMustOverrideException( getClass(), "isTransactionOpen" );
	}

	public boolean beginTransaction() {
		throw new CFLibMustOverrideException( getClass(), "beginTransaction" );
	}

	public void commit() {
		throw new CFLibMustOverrideException( getClass(), "commit" );
	}

	public void rollback() {
		throw new CFLibMustOverrideException( getClass(), "rollback" );
	}

	public ICFGenKbTablePerms getTablePerms() {
		return( tablePerms );
	}

	public void setTablePerms( ICFGenKbTablePerms value ) {
		tablePerms = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	/**
	 *	Release any prepared statements bound to this database instance, such
	 *	that the value of schemaDbName has to be re-evaluated for all future
	 *	invocations.
	 */
	public void releasePreparedStatements() {
	}

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 */
	public String getDbSchemaName() {
		return( schemaDbName );
	}

	public String getLowerDbSchemaName() {
		return( lowerDbSchemaName );
	}

	/**
	 *	The database is expected to override this implementation and invoke the
	 *	<tt>super.setDbSchemaName( String argDbSchemaName )</tt> early
	 *	on in the implementation of the cust body.  You should let the exceptions
	 *	which can be thrown by this implementation pass unimpeded.
	 *	<pg>
	 *	When you set the database schema name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the cust client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	public void setDbSchemaName( String argDbSchemaName ) {
		final String S_ProcName = "setDbSchemaName";
		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}
		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();
	}
}
