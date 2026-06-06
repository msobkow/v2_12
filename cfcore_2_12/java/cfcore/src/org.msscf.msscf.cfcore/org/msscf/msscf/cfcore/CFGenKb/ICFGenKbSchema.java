// Description: Java 11 interface for a CFGenKb schema.

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
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.Tip.CFTipClientHandler;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbSchema
{
	public enum AuditActionEnum {
		Create,
		Update,
		Delete
	};

	CFTipClientHandler getCFTipClientHandler();

	String getServerURL();
	void setServerURL( String value );

	CFGenKbConfigurationFile getConfigurationFile();
	void setConfigurationFile( CFGenKbConfigurationFile value );

	String getJndiName();
	void setJndiName( String value );

	/**
	 *	Get the Authorization used by the schema.
	 *
	 *	@return	The Authorization used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFGenKbAuthorization getAuthorization();

	/**
	 *	Set the Authorization used by the schema.
	 *
	 *	@param	value	The Authorization to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setAuthorization( CFGenKbAuthorization value );

	/**
	 *	Is the schema connected to a persistent storage server?
	 *
	 *	@return	True if the schema is connected to persistent storage,
	 *		otherwise false.
	 */
	boolean isConnected();

	/**
	 *	Connect to the persistent storage server.
	 *
	 *	@return	True if a connection was established, otherwise false.
	 */
	boolean connect();

	/**
	 *	Connect to the persistent storage server using the specified
	 *	user name and password with the server and database specified
	 *	by the configuration file.  JNDI names are ignored by this method.
	 *
	 *	@return	True if a connection was established, otherwise false.
	 */
	boolean connect( String username, String password );

	/**
	 *	Extended login format for GUI login screens
	 */
	boolean connect( String loginId, String password, String clusterName, String tenantName );

	/**
	 *	Disconnect from the persistent storage server.
	 */
	void disconnect( boolean doCommit );

	/**
	 *	Log out of the server, releasing the authorization information.
	 */
	void logout( CFGenKbAuthorization auth );

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFGenKbSchema instance.
	 */
	ICFGenKbSchema newSchema();

	/**
	 *	Get the next DefClassIdGen identifier.
	 *
	 *	@return	The next DefClassIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextDefClassIdGen();

	/**
	 *	Get the next RuleTypeIdGen identifier.
	 *
	 *	@return	The next RuleTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextRuleTypeIdGen();

	/**
	 *	Get the next ToolIdGen identifier.
	 *
	 *	@return	The next ToolIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextToolIdGen();

	/**
	 *	Get the next ToolSetIdGen identifier.
	 *
	 *	@return	The next ToolSetIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextToolSetIdGen();

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	long nextClusterIdGen();

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	long nextTenantIdGen();

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	UUID nextSecSessionIdGen();

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	UUID nextSecUserIdGen();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbClusterTable getTableCluster();

	/**
	 *	Get the Cluster Factory interface for the schema.
	 *
	 *	@return	The Cluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbClusterFactory getFactoryCluster();

	/**
	 *	Get the DefClass Table interface for the schema.
	 *
	 *	@return	The DefClass Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbDefClassTable getTableDefClass();

	/**
	 *	Get the DefClass Factory interface for the schema.
	 *
	 *	@return	The DefClass Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbDefClassFactory getFactoryDefClass();

	/**
	 *	Get the GelBoilerplate Table interface for the schema.
	 *
	 *	@return	The GelBoilerplate Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelBoilerplateTable getTableGelBoilerplate();

	/**
	 *	Get the GelBoilerplate Factory interface for the schema.
	 *
	 *	@return	The GelBoilerplate Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelBoilerplateFactory getFactoryGelBoilerplate();

	/**
	 *	Get the GelBuiltin Table interface for the schema.
	 *
	 *	@return	The GelBuiltin Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelBuiltinTable getTableGelBuiltin();

	/**
	 *	Get the GelBuiltin Factory interface for the schema.
	 *
	 *	@return	The GelBuiltin Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelBuiltinFactory getFactoryGelBuiltin();

	/**
	 *	Get the GelCache Table interface for the schema.
	 *
	 *	@return	The GelCache Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCacheTable getTableGelCache();

	/**
	 *	Get the GelCache Factory interface for the schema.
	 *
	 *	@return	The GelCache Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCacheFactory getFactoryGelCache();

	/**
	 *	Get the GelCall Table interface for the schema.
	 *
	 *	@return	The GelCall Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCallTable getTableGelCall();

	/**
	 *	Get the GelCall Factory interface for the schema.
	 *
	 *	@return	The GelCall Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCallFactory getFactoryGelCall();

	/**
	 *	Get the GelConstrain Table interface for the schema.
	 *
	 *	@return	The GelConstrain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelConstrainTable getTableGelConstrain();

	/**
	 *	Get the GelConstrain Factory interface for the schema.
	 *
	 *	@return	The GelConstrain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelConstrainFactory getFactoryGelConstrain();

	/**
	 *	Get the GelCounter Table interface for the schema.
	 *
	 *	@return	The GelCounter Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCounterTable getTableGelCounter();

	/**
	 *	Get the GelCounter Factory interface for the schema.
	 *
	 *	@return	The GelCounter Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelCounterFactory getFactoryGelCounter();

	/**
	 *	Get the GelError Table interface for the schema.
	 *
	 *	@return	The GelError Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelErrorTable getTableGelError();

	/**
	 *	Get the GelError Factory interface for the schema.
	 *
	 *	@return	The GelError Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelErrorFactory getFactoryGelError();

	/**
	 *	Get the GelExecutable Table interface for the schema.
	 *
	 *	@return	The GelExecutable Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelExecutableTable getTableGelExecutable();

	/**
	 *	Get the GelExecutable Factory interface for the schema.
	 *
	 *	@return	The GelExecutable Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelExecutableFactory getFactoryGelExecutable();

	/**
	 *	Get the GelExpansion Table interface for the schema.
	 *
	 *	@return	The GelExpansion Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelExpansionTable getTableGelExpansion();

	/**
	 *	Get the GelExpansion Factory interface for the schema.
	 *
	 *	@return	The GelExpansion Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelExpansionFactory getFactoryGelExpansion();

	/**
	 *	Get the GelInstruction Table interface for the schema.
	 *
	 *	@return	The GelInstruction Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelInstructionTable getTableGelInstruction();

	/**
	 *	Get the GelInstruction Factory interface for the schema.
	 *
	 *	@return	The GelInstruction Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelInstructionFactory getFactoryGelInstruction();

	/**
	 *	Get the GelIterator Table interface for the schema.
	 *
	 *	@return	The GelIterator Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelIteratorTable getTableGelIterator();

	/**
	 *	Get the GelIterator Factory interface for the schema.
	 *
	 *	@return	The GelIterator Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelIteratorFactory getFactoryGelIterator();

	/**
	 *	Get the GelModifier Table interface for the schema.
	 *
	 *	@return	The GelModifier Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelModifierTable getTableGelModifier();

	/**
	 *	Get the GelModifier Factory interface for the schema.
	 *
	 *	@return	The GelModifier Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelModifierFactory getFactoryGelModifier();

	/**
	 *	Get the GelPop Table interface for the schema.
	 *
	 *	@return	The GelPop Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelPopTable getTableGelPop();

	/**
	 *	Get the GelPop Factory interface for the schema.
	 *
	 *	@return	The GelPop Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelPopFactory getFactoryGelPop();

	/**
	 *	Get the GelPrefixLine Table interface for the schema.
	 *
	 *	@return	The GelPrefixLine Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelPrefixLineTable getTableGelPrefixLine();

	/**
	 *	Get the GelPrefixLine Factory interface for the schema.
	 *
	 *	@return	The GelPrefixLine Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelPrefixLineFactory getFactoryGelPrefixLine();

	/**
	 *	Get the GelReference Table interface for the schema.
	 *
	 *	@return	The GelReference Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelReferenceTable getTableGelReference();

	/**
	 *	Get the GelReference Factory interface for the schema.
	 *
	 *	@return	The GelReference Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelReferenceFactory getFactoryGelReference();

	/**
	 *	Get the GelSequence Table interface for the schema.
	 *
	 *	@return	The GelSequence Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSequenceTable getTableGelSequence();

	/**
	 *	Get the GelSequence Factory interface for the schema.
	 *
	 *	@return	The GelSequence Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSequenceFactory getFactoryGelSequence();

	/**
	 *	Get the GelSpread Table interface for the schema.
	 *
	 *	@return	The GelSpread Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSpreadTable getTableGelSpread();

	/**
	 *	Get the GelSpread Factory interface for the schema.
	 *
	 *	@return	The GelSpread Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSpreadFactory getFactoryGelSpread();

	/**
	 *	Get the GelSwitch Table interface for the schema.
	 *
	 *	@return	The GelSwitch Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSwitchTable getTableGelSwitch();

	/**
	 *	Get the GelSwitch Factory interface for the schema.
	 *
	 *	@return	The GelSwitch Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSwitchFactory getFactoryGelSwitch();

	/**
	 *	Get the GelSwitchLimb Table interface for the schema.
	 *
	 *	@return	The GelSwitchLimb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSwitchLimbTable getTableGelSwitchLimb();

	/**
	 *	Get the GelSwitchLimb Factory interface for the schema.
	 *
	 *	@return	The GelSwitchLimb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGelSwitchLimbFactory getFactoryGelSwitchLimb();

	/**
	 *	Get the GenBind Table interface for the schema.
	 *
	 *	@return	The GenBind Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenBindTable getTableGenBind();

	/**
	 *	Get the GenBind Factory interface for the schema.
	 *
	 *	@return	The GenBind Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenBindFactory getFactoryGenBind();

	/**
	 *	Get the GenFile Table interface for the schema.
	 *
	 *	@return	The GenFile Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenFileTable getTableGenFile();

	/**
	 *	Get the GenFile Factory interface for the schema.
	 *
	 *	@return	The GenFile Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenFileFactory getFactoryGenFile();

	/**
	 *	Get the GenItem Table interface for the schema.
	 *
	 *	@return	The GenItem Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenItemTable getTableGenItem();

	/**
	 *	Get the GenItem Factory interface for the schema.
	 *
	 *	@return	The GenItem Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenItemFactory getFactoryGenItem();

	/**
	 *	Get the GenIterator Table interface for the schema.
	 *
	 *	@return	The GenIterator Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenIteratorTable getTableGenIterator();

	/**
	 *	Get the GenIterator Factory interface for the schema.
	 *
	 *	@return	The GenIterator Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenIteratorFactory getFactoryGenIterator();

	/**
	 *	Get the GenReference Table interface for the schema.
	 *
	 *	@return	The GenReference Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenReferenceTable getTableGenReference();

	/**
	 *	Get the GenReference Factory interface for the schema.
	 *
	 *	@return	The GenReference Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenReferenceFactory getFactoryGenReference();

	/**
	 *	Get the GenRule Table interface for the schema.
	 *
	 *	@return	The GenRule Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenRuleTable getTableGenRule();

	/**
	 *	Get the GenRule Factory interface for the schema.
	 *
	 *	@return	The GenRule Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenRuleFactory getFactoryGenRule();

	/**
	 *	Get the GenTrunc Table interface for the schema.
	 *
	 *	@return	The GenTrunc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenTruncTable getTableGenTrunc();

	/**
	 *	Get the GenTrunc Factory interface for the schema.
	 *
	 *	@return	The GenTrunc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbGenTruncFactory getFactoryGenTrunc();

	/**
	 *	Get the HostNode Table interface for the schema.
	 *
	 *	@return	The HostNode Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbHostNodeTable getTableHostNode();

	/**
	 *	Get the HostNode Factory interface for the schema.
	 *
	 *	@return	The HostNode Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbHostNodeFactory getFactoryHostNode();

	/**
	 *	Get the RuleCart Table interface for the schema.
	 *
	 *	@return	The RuleCart Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbRuleCartTable getTableRuleCart();

	/**
	 *	Get the RuleCart Factory interface for the schema.
	 *
	 *	@return	The RuleCart Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbRuleCartFactory getFactoryRuleCart();

	/**
	 *	Get the RuleType Table interface for the schema.
	 *
	 *	@return	The RuleType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbRuleTypeTable getTableRuleType();

	/**
	 *	Get the RuleType Factory interface for the schema.
	 *
	 *	@return	The RuleType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbRuleTypeFactory getFactoryRuleType();

	/**
	 *	Get the SecApp Table interface for the schema.
	 *
	 *	@return	The SecApp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecAppTable getTableSecApp();

	/**
	 *	Get the SecApp Factory interface for the schema.
	 *
	 *	@return	The SecApp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecAppFactory getFactorySecApp();

	/**
	 *	Get the SecDevice Table interface for the schema.
	 *
	 *	@return	The SecDevice Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecDeviceTable getTableSecDevice();

	/**
	 *	Get the SecDevice Factory interface for the schema.
	 *
	 *	@return	The SecDevice Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecDeviceFactory getFactorySecDevice();

	/**
	 *	Get the SecForm Table interface for the schema.
	 *
	 *	@return	The SecForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecFormTable getTableSecForm();

	/**
	 *	Get the SecForm Factory interface for the schema.
	 *
	 *	@return	The SecForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecFormFactory getFactorySecForm();

	/**
	 *	Get the SecGroup Table interface for the schema.
	 *
	 *	@return	The SecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGroupTable getTableSecGroup();

	/**
	 *	Get the SecGroup Factory interface for the schema.
	 *
	 *	@return	The SecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGroupFactory getFactorySecGroup();

	/**
	 *	Get the SecGroupForm Table interface for the schema.
	 *
	 *	@return	The SecGroupForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGroupFormTable getTableSecGroupForm();

	/**
	 *	Get the SecGroupForm Factory interface for the schema.
	 *
	 *	@return	The SecGroupForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGroupFormFactory getFactorySecGroupForm();

	/**
	 *	Get the SecGrpInc Table interface for the schema.
	 *
	 *	@return	The SecGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGrpIncTable getTableSecGrpInc();

	/**
	 *	Get the SecGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGrpIncFactory getFactorySecGrpInc();

	/**
	 *	Get the SecGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGrpMembTable getTableSecGrpMemb();

	/**
	 *	Get the SecGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecGrpMembFactory getFactorySecGrpMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSession Factory interface for the schema.
	 *
	 *	@return	The SecSession Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecSessionFactory getFactorySecSession();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecUserTable getTableSecUser();

	/**
	 *	Get the SecUser Factory interface for the schema.
	 *
	 *	@return	The SecUser Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSecUserFactory getFactorySecUser();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSysClusterTable getTableSysCluster();

	/**
	 *	Get the SysCluster Factory interface for the schema.
	 *
	 *	@return	The SysCluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbSysClusterFactory getFactorySysCluster();

	/**
	 *	Get the TSecGroup Table interface for the schema.
	 *
	 *	@return	The TSecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGroupTable getTableTSecGroup();

	/**
	 *	Get the TSecGroup Factory interface for the schema.
	 *
	 *	@return	The TSecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGroupFactory getFactoryTSecGroup();

	/**
	 *	Get the TSecGrpInc Table interface for the schema.
	 *
	 *	@return	The TSecGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGrpIncTable getTableTSecGrpInc();

	/**
	 *	Get the TSecGrpInc Factory interface for the schema.
	 *
	 *	@return	The TSecGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGrpIncFactory getFactoryTSecGrpInc();

	/**
	 *	Get the TSecGrpMemb Table interface for the schema.
	 *
	 *	@return	The TSecGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGrpMembTable getTableTSecGrpMemb();

	/**
	 *	Get the TSecGrpMemb Factory interface for the schema.
	 *
	 *	@return	The TSecGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTSecGrpMembFactory getFactoryTSecGrpMemb();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTenantTable getTableTenant();

	/**
	 *	Get the Tenant Factory interface for the schema.
	 *
	 *	@return	The Tenant Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTenantFactory getFactoryTenant();

	/**
	 *	Get the Tool Table interface for the schema.
	 *
	 *	@return	The Tool Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbToolTable getTableTool();

	/**
	 *	Get the Tool Factory interface for the schema.
	 *
	 *	@return	The Tool Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbToolFactory getFactoryTool();

	/**
	 *	Get the ToolSet Table interface for the schema.
	 *
	 *	@return	The ToolSet Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbToolSetTable getTableToolSet();

	/**
	 *	Get the ToolSet Factory interface for the schema.
	 *
	 *	@return	The ToolSet Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbToolSetFactory getFactoryToolSet();

	/**
	 *	If a transaction is already opened for the schema connection,
	 *	return false.  If a new transaction is successfully opened,
	 *	return true.  Otherwise throw a RuntimeException detailing
	 *	why a transaction could not be initiated.
	 *	<p>
	 *	This permits the database persistence implementations to
	 *	switch between participating in an existing transaction
	 *	or implementing an implicit atomic transaction that is
	 *	committed or rolled back before the method returns:
	 *	<p>
	 *		boolean txnInitiated = false;
	 *		try {
	 *			txnInitiated = schema.beginTransaction();
	 *			... business logic and presentation code ...
	 *			if( txnInitiated ) {
	 *				schema.commit();
	 *			}
	 *		}
	 *		catch( RuntimeException e ) {
	 *			if( txnInitiated ) {
	 *				try {
	 *					schema.rollback();
	 *				}
	 *				catch( RuntimeException e ) {
	 *				}
	 *			}
	 *			... report exception or throw exception with cause ...
	 *		}
	 *	<p>
	 *	As the current web-form focused implementation will be managing
	 *	the transactions in the Servlet page response, I don't need to
	 *	implement the atomic transaction wrappers yet.
	 */

	/**
	 *	The client-side implementations always return true for this method.
	 *
	 *	@return	True if there is currently a transaction open, otherwise false.
	 *		Client-side implementations always return true.
	 */
	boolean isTransactionOpen();

	/**
	 *	Begin a transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	boolean beginTransaction();

	/**
	 *	Commit the current open transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void commit();

	/**
	 *	Roll back the current open transaction.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void rollback();

	/**
	 *	Get the Table Permissions interface for the schema.
	 *
	 *	@return	The Table Permissions interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFGenKbTablePerms getTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setTablePerms( ICFGenKbTablePerms value );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@Exception CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	String getDbSchemaName();
	String getLowerDbSchemaName();

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
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setDbSchemaName( String argDbSchemaName );
}
