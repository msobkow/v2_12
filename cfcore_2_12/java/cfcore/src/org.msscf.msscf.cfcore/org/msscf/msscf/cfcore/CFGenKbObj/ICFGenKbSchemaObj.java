// Description: Java 11 Schema Object interface for CFGenKb.

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

public interface ICFGenKbSchemaObj
{
	CFGenKbAuthorization getAuthorization();
	void setAuthorization( CFGenKbAuthorization value );

	ICFGenKbSchema getBackingStore();
	void setBackingStore( ICFGenKbSchema value );

	String getSchemaName();

	void setSecClusterName( String value );
	ICFGenKbClusterObj getSecCluster();
	void setSecCluster( ICFGenKbClusterObj value );

	void setSecTenantName( String value );
	ICFGenKbTenantObj getSecTenant();
	void setSecTenant( ICFGenKbTenantObj value );

	void setSecUserName( String value );
	ICFGenKbSecUserObj getSecUser();
	void setSecUser( ICFGenKbSecUserObj value );

	void setSecSessionId( UUID value );
	ICFGenKbSecSessionObj getSecSession();
	void setSecSession( ICFGenKbSecSessionObj value );

	boolean isConnected();
	boolean connect();
	boolean connect( String username, String password );
	boolean connect( String clusterName, String tenantName, String secUserName, String password );
	void disconnect( boolean doCommit );
	void logout();

	void minimizeMemory();

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	name to be used by the session.
	 */
	String getDbSchemaName();

	/**
	 *	PostgreSQL coerces database schema names to lowercase for consistency.
	 */
	String getLowerDbSchemaName();

	/**
	 *	When you set the database name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the cust client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	void setDbSchemaName( String argDbSchemaName );

	/**
	 *	If a transaction is already opened for the schema connection,
	 *	return false.  If a new transaction is successfully opened,
	 *	return true.  Otherwise throw a RuntimeException detailing
	 *	why a transaction could not be initiated.
	 *
	 *	This permits the database persistence implementations to
	 *	switch between participating in an existing transaction
	 *	or implementing an implicit atomic transaction that is
	 *	committed or rolled back before the method returns:
	 *
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
	 *
	 *	As the current web-form focused implementation will be managing
	 *	the transactions in the Servlet page response, I don't need to
	 *	implement the atomic transaction wrappers yet.
	 */
	boolean isTransactionOpen();
	boolean beginTransaction();
	void commit();
	void rollback();

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	void releasePreparedStatements();
	/**
	 *	Get the Cluster interface for the schema.
	 *
	 *	@return	The ICFGenKbClusterTableObj interface implementation for the schema.
	 */
	ICFGenKbClusterTableObj getClusterTableObj();

	/**
	 *	Get the DefClass interface for the schema.
	 *
	 *	@return	The ICFGenKbDefClassTableObj interface implementation for the schema.
	 */
	ICFGenKbDefClassTableObj getDefClassTableObj();

	/**
	 *	Get the GelBoilerplate interface for the schema.
	 *
	 *	@return	The ICFGenKbGelBoilerplateTableObj interface implementation for the schema.
	 */
	ICFGenKbGelBoilerplateTableObj getGelBoilerplateTableObj();

	/**
	 *	Get the GelBuiltin interface for the schema.
	 *
	 *	@return	The ICFGenKbGelBuiltinTableObj interface implementation for the schema.
	 */
	ICFGenKbGelBuiltinTableObj getGelBuiltinTableObj();

	/**
	 *	Get the GelCache interface for the schema.
	 *
	 *	@return	The ICFGenKbGelCacheTableObj interface implementation for the schema.
	 */
	ICFGenKbGelCacheTableObj getGelCacheTableObj();

	/**
	 *	Get the GelCall interface for the schema.
	 *
	 *	@return	The ICFGenKbGelCallTableObj interface implementation for the schema.
	 */
	ICFGenKbGelCallTableObj getGelCallTableObj();

	/**
	 *	Get the GelConstrain interface for the schema.
	 *
	 *	@return	The ICFGenKbGelConstrainTableObj interface implementation for the schema.
	 */
	ICFGenKbGelConstrainTableObj getGelConstrainTableObj();

	/**
	 *	Get the GelCounter interface for the schema.
	 *
	 *	@return	The ICFGenKbGelCounterTableObj interface implementation for the schema.
	 */
	ICFGenKbGelCounterTableObj getGelCounterTableObj();

	/**
	 *	Get the GelError interface for the schema.
	 *
	 *	@return	The ICFGenKbGelErrorTableObj interface implementation for the schema.
	 */
	ICFGenKbGelErrorTableObj getGelErrorTableObj();

	/**
	 *	Get the GelExecutable interface for the schema.
	 *
	 *	@return	The ICFGenKbGelExecutableTableObj interface implementation for the schema.
	 */
	ICFGenKbGelExecutableTableObj getGelExecutableTableObj();

	/**
	 *	Get the GelExpansion interface for the schema.
	 *
	 *	@return	The ICFGenKbGelExpansionTableObj interface implementation for the schema.
	 */
	ICFGenKbGelExpansionTableObj getGelExpansionTableObj();

	/**
	 *	Get the GelInstruction interface for the schema.
	 *
	 *	@return	The ICFGenKbGelInstructionTableObj interface implementation for the schema.
	 */
	ICFGenKbGelInstructionTableObj getGelInstructionTableObj();

	/**
	 *	Get the GelIterator interface for the schema.
	 *
	 *	@return	The ICFGenKbGelIteratorTableObj interface implementation for the schema.
	 */
	ICFGenKbGelIteratorTableObj getGelIteratorTableObj();

	/**
	 *	Get the GelModifier interface for the schema.
	 *
	 *	@return	The ICFGenKbGelModifierTableObj interface implementation for the schema.
	 */
	ICFGenKbGelModifierTableObj getGelModifierTableObj();

	/**
	 *	Get the GelPop interface for the schema.
	 *
	 *	@return	The ICFGenKbGelPopTableObj interface implementation for the schema.
	 */
	ICFGenKbGelPopTableObj getGelPopTableObj();

	/**
	 *	Get the GelPrefixLine interface for the schema.
	 *
	 *	@return	The ICFGenKbGelPrefixLineTableObj interface implementation for the schema.
	 */
	ICFGenKbGelPrefixLineTableObj getGelPrefixLineTableObj();

	/**
	 *	Get the GelReference interface for the schema.
	 *
	 *	@return	The ICFGenKbGelReferenceTableObj interface implementation for the schema.
	 */
	ICFGenKbGelReferenceTableObj getGelReferenceTableObj();

	/**
	 *	Get the GelSequence interface for the schema.
	 *
	 *	@return	The ICFGenKbGelSequenceTableObj interface implementation for the schema.
	 */
	ICFGenKbGelSequenceTableObj getGelSequenceTableObj();

	/**
	 *	Get the GelSpread interface for the schema.
	 *
	 *	@return	The ICFGenKbGelSpreadTableObj interface implementation for the schema.
	 */
	ICFGenKbGelSpreadTableObj getGelSpreadTableObj();

	/**
	 *	Get the GelSwitch interface for the schema.
	 *
	 *	@return	The ICFGenKbGelSwitchTableObj interface implementation for the schema.
	 */
	ICFGenKbGelSwitchTableObj getGelSwitchTableObj();

	/**
	 *	Get the GelSwitchLimb interface for the schema.
	 *
	 *	@return	The ICFGenKbGelSwitchLimbTableObj interface implementation for the schema.
	 */
	ICFGenKbGelSwitchLimbTableObj getGelSwitchLimbTableObj();

	/**
	 *	Get the GenBind interface for the schema.
	 *
	 *	@return	The ICFGenKbGenBindTableObj interface implementation for the schema.
	 */
	ICFGenKbGenBindTableObj getGenBindTableObj();

	/**
	 *	Get the GenFile interface for the schema.
	 *
	 *	@return	The ICFGenKbGenFileTableObj interface implementation for the schema.
	 */
	ICFGenKbGenFileTableObj getGenFileTableObj();

	/**
	 *	Get the GenItem interface for the schema.
	 *
	 *	@return	The ICFGenKbGenItemTableObj interface implementation for the schema.
	 */
	ICFGenKbGenItemTableObj getGenItemTableObj();

	/**
	 *	Get the GenIterator interface for the schema.
	 *
	 *	@return	The ICFGenKbGenIteratorTableObj interface implementation for the schema.
	 */
	ICFGenKbGenIteratorTableObj getGenIteratorTableObj();

	/**
	 *	Get the GenReference interface for the schema.
	 *
	 *	@return	The ICFGenKbGenReferenceTableObj interface implementation for the schema.
	 */
	ICFGenKbGenReferenceTableObj getGenReferenceTableObj();

	/**
	 *	Get the GenRule interface for the schema.
	 *
	 *	@return	The ICFGenKbGenRuleTableObj interface implementation for the schema.
	 */
	ICFGenKbGenRuleTableObj getGenRuleTableObj();

	/**
	 *	Get the GenTrunc interface for the schema.
	 *
	 *	@return	The ICFGenKbGenTruncTableObj interface implementation for the schema.
	 */
	ICFGenKbGenTruncTableObj getGenTruncTableObj();

	/**
	 *	Get the HostNode interface for the schema.
	 *
	 *	@return	The ICFGenKbHostNodeTableObj interface implementation for the schema.
	 */
	ICFGenKbHostNodeTableObj getHostNodeTableObj();

	/**
	 *	Get the RuleCart interface for the schema.
	 *
	 *	@return	The ICFGenKbRuleCartTableObj interface implementation for the schema.
	 */
	ICFGenKbRuleCartTableObj getRuleCartTableObj();

	/**
	 *	Get the RuleType interface for the schema.
	 *
	 *	@return	The ICFGenKbRuleTypeTableObj interface implementation for the schema.
	 */
	ICFGenKbRuleTypeTableObj getRuleTypeTableObj();

	/**
	 *	Get the SecApp interface for the schema.
	 *
	 *	@return	The ICFGenKbSecAppTableObj interface implementation for the schema.
	 */
	ICFGenKbSecAppTableObj getSecAppTableObj();

	/**
	 *	Get the SecDevice interface for the schema.
	 *
	 *	@return	The ICFGenKbSecDeviceTableObj interface implementation for the schema.
	 */
	ICFGenKbSecDeviceTableObj getSecDeviceTableObj();

	/**
	 *	Get the SecForm interface for the schema.
	 *
	 *	@return	The ICFGenKbSecFormTableObj interface implementation for the schema.
	 */
	ICFGenKbSecFormTableObj getSecFormTableObj();

	/**
	 *	Get the SecGroup interface for the schema.
	 *
	 *	@return	The ICFGenKbSecGroupTableObj interface implementation for the schema.
	 */
	ICFGenKbSecGroupTableObj getSecGroupTableObj();

	/**
	 *	Get the SecGroupForm interface for the schema.
	 *
	 *	@return	The ICFGenKbSecGroupFormTableObj interface implementation for the schema.
	 */
	ICFGenKbSecGroupFormTableObj getSecGroupFormTableObj();

	/**
	 *	Get the SecGrpInc interface for the schema.
	 *
	 *	@return	The ICFGenKbSecGrpIncTableObj interface implementation for the schema.
	 */
	ICFGenKbSecGrpIncTableObj getSecGrpIncTableObj();

	/**
	 *	Get the SecGrpMemb interface for the schema.
	 *
	 *	@return	The ICFGenKbSecGrpMembTableObj interface implementation for the schema.
	 */
	ICFGenKbSecGrpMembTableObj getSecGrpMembTableObj();

	/**
	 *	Get the SecSession interface for the schema.
	 *
	 *	@return	The ICFGenKbSecSessionTableObj interface implementation for the schema.
	 */
	ICFGenKbSecSessionTableObj getSecSessionTableObj();

	/**
	 *	Get the SecUser interface for the schema.
	 *
	 *	@return	The ICFGenKbSecUserTableObj interface implementation for the schema.
	 */
	ICFGenKbSecUserTableObj getSecUserTableObj();

	/**
	 *	Get the SysCluster interface for the schema.
	 *
	 *	@return	The ICFGenKbSysClusterTableObj interface implementation for the schema.
	 */
	ICFGenKbSysClusterTableObj getSysClusterTableObj();

	/**
	 *	Get the TSecGroup interface for the schema.
	 *
	 *	@return	The ICFGenKbTSecGroupTableObj interface implementation for the schema.
	 */
	ICFGenKbTSecGroupTableObj getTSecGroupTableObj();

	/**
	 *	Get the TSecGrpInc interface for the schema.
	 *
	 *	@return	The ICFGenKbTSecGrpIncTableObj interface implementation for the schema.
	 */
	ICFGenKbTSecGrpIncTableObj getTSecGrpIncTableObj();

	/**
	 *	Get the TSecGrpMemb interface for the schema.
	 *
	 *	@return	The ICFGenKbTSecGrpMembTableObj interface implementation for the schema.
	 */
	ICFGenKbTSecGrpMembTableObj getTSecGrpMembTableObj();

	/**
	 *	Get the Tenant interface for the schema.
	 *
	 *	@return	The ICFGenKbTenantTableObj interface implementation for the schema.
	 */
	ICFGenKbTenantTableObj getTenantTableObj();

	/**
	 *	Get the Tool interface for the schema.
	 *
	 *	@return	The ICFGenKbToolTableObj interface implementation for the schema.
	 */
	ICFGenKbToolTableObj getToolTableObj();

	/**
	 *	Get the ToolSet interface for the schema.
	 *
	 *	@return	The ICFGenKbToolSetTableObj interface implementation for the schema.
	 */
	ICFGenKbToolSetTableObj getToolSetTableObj();
}
