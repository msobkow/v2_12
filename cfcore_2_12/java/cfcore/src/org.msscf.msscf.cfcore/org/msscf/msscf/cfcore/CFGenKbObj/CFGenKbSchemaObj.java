// Description: Java 11 Schema Object implementation for CFGenKb.

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
public class CFGenKbSchemaObj
	implements ICFGenKbSchemaObj
{
	public static String SCHEMA_NAME = "CFGenKb";
	public static String SCHEMA_DBNAME = "genkb212";
	protected CFGenKbAuthorization authorization = null;
	protected ICFGenKbSchema backingStore = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ICFGenKbClusterObj secCluster = null;
	protected long secClusterId = 0L;
	protected ICFGenKbTenantObj secTenant = null;
	protected long secTenantId = 0L;
	protected ICFGenKbSecUserObj secUser = null;
	protected UUID secSessionUserId = null;
	protected ICFGenKbSecSessionObj secSession = null;
	protected UUID secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();
	protected ICFGenKbClusterTableObj clusterTableObj;
	protected ICFGenKbDefClassTableObj defClassTableObj;
	protected ICFGenKbGelBoilerplateTableObj gelBoilerplateTableObj;
	protected ICFGenKbGelBuiltinTableObj gelBuiltinTableObj;
	protected ICFGenKbGelCacheTableObj gelCacheTableObj;
	protected ICFGenKbGelCallTableObj gelCallTableObj;
	protected ICFGenKbGelConstrainTableObj gelConstrainTableObj;
	protected ICFGenKbGelCounterTableObj gelCounterTableObj;
	protected ICFGenKbGelErrorTableObj gelErrorTableObj;
	protected ICFGenKbGelExecutableTableObj gelExecutableTableObj;
	protected ICFGenKbGelExpansionTableObj gelExpansionTableObj;
	protected ICFGenKbGelInstructionTableObj gelInstructionTableObj;
	protected ICFGenKbGelIteratorTableObj gelIteratorTableObj;
	protected ICFGenKbGelModifierTableObj gelModifierTableObj;
	protected ICFGenKbGelPopTableObj gelPopTableObj;
	protected ICFGenKbGelPrefixLineTableObj gelPrefixLineTableObj;
	protected ICFGenKbGelReferenceTableObj gelReferenceTableObj;
	protected ICFGenKbGelSequenceTableObj gelSequenceTableObj;
	protected ICFGenKbGelSpreadTableObj gelSpreadTableObj;
	protected ICFGenKbGelSwitchTableObj gelSwitchTableObj;
	protected ICFGenKbGelSwitchLimbTableObj gelSwitchLimbTableObj;
	protected ICFGenKbGenBindTableObj genBindTableObj;
	protected ICFGenKbGenFileTableObj genFileTableObj;
	protected ICFGenKbGenItemTableObj genItemTableObj;
	protected ICFGenKbGenIteratorTableObj genIteratorTableObj;
	protected ICFGenKbGenReferenceTableObj genReferenceTableObj;
	protected ICFGenKbGenRuleTableObj genRuleTableObj;
	protected ICFGenKbGenTruncTableObj genTruncTableObj;
	protected ICFGenKbHostNodeTableObj hostNodeTableObj;
	protected ICFGenKbRuleCartTableObj ruleCartTableObj;
	protected ICFGenKbRuleTypeTableObj ruleTypeTableObj;
	protected ICFGenKbSecAppTableObj secAppTableObj;
	protected ICFGenKbSecDeviceTableObj secDeviceTableObj;
	protected ICFGenKbSecFormTableObj secFormTableObj;
	protected ICFGenKbSecGroupTableObj secGroupTableObj;
	protected ICFGenKbSecGroupFormTableObj secGroupFormTableObj;
	protected ICFGenKbSecGrpIncTableObj secGrpIncTableObj;
	protected ICFGenKbSecGrpMembTableObj secGrpMembTableObj;
	protected ICFGenKbSecSessionTableObj secSessionTableObj;
	protected ICFGenKbSecUserTableObj secUserTableObj;
	protected ICFGenKbSysClusterTableObj sysClusterTableObj;
	protected ICFGenKbTSecGroupTableObj tSecGroupTableObj;
	protected ICFGenKbTSecGrpIncTableObj tSecGrpIncTableObj;
	protected ICFGenKbTSecGrpMembTableObj tSecGrpMembTableObj;
	protected ICFGenKbTenantTableObj tenantTableObj;
	protected ICFGenKbToolTableObj toolTableObj;
	protected ICFGenKbToolSetTableObj toolSetTableObj;

	public CFGenKbSchemaObj() {
		clusterTableObj = new CFGenKbClusterTableObj( this );
		defClassTableObj = new CFGenKbDefClassTableObj( this );
		gelBoilerplateTableObj = new CFGenKbGelBoilerplateTableObj( this );
		gelBuiltinTableObj = new CFGenKbGelBuiltinTableObj( this );
		gelCacheTableObj = new CFGenKbGelCacheTableObj( this );
		gelCallTableObj = new CFGenKbGelCallTableObj( this );
		gelConstrainTableObj = new CFGenKbGelConstrainTableObj( this );
		gelCounterTableObj = new CFGenKbGelCounterTableObj( this );
		gelErrorTableObj = new CFGenKbGelErrorTableObj( this );
		gelExecutableTableObj = new CFGenKbGelExecutableTableObj( this );
		gelExpansionTableObj = new CFGenKbGelExpansionTableObj( this );
		gelInstructionTableObj = new CFGenKbGelInstructionTableObj( this );
		gelIteratorTableObj = new CFGenKbGelIteratorTableObj( this );
		gelModifierTableObj = new CFGenKbGelModifierTableObj( this );
		gelPopTableObj = new CFGenKbGelPopTableObj( this );
		gelPrefixLineTableObj = new CFGenKbGelPrefixLineTableObj( this );
		gelReferenceTableObj = new CFGenKbGelReferenceTableObj( this );
		gelSequenceTableObj = new CFGenKbGelSequenceTableObj( this );
		gelSpreadTableObj = new CFGenKbGelSpreadTableObj( this );
		gelSwitchTableObj = new CFGenKbGelSwitchTableObj( this );
		gelSwitchLimbTableObj = new CFGenKbGelSwitchLimbTableObj( this );
		genBindTableObj = new CFGenKbGenBindTableObj( this );
		genFileTableObj = new CFGenKbGenFileTableObj( this );
		genItemTableObj = new CFGenKbGenItemTableObj( this );
		genIteratorTableObj = new CFGenKbGenIteratorTableObj( this );
		genReferenceTableObj = new CFGenKbGenReferenceTableObj( this );
		genRuleTableObj = new CFGenKbGenRuleTableObj( this );
		genTruncTableObj = new CFGenKbGenTruncTableObj( this );
		hostNodeTableObj = new CFGenKbHostNodeTableObj( this );
		ruleCartTableObj = new CFGenKbRuleCartTableObj( this );
		ruleTypeTableObj = new CFGenKbRuleTypeTableObj( this );
		secAppTableObj = new CFGenKbSecAppTableObj( this );
		secDeviceTableObj = new CFGenKbSecDeviceTableObj( this );
		secFormTableObj = new CFGenKbSecFormTableObj( this );
		secGroupTableObj = new CFGenKbSecGroupTableObj( this );
		secGroupFormTableObj = new CFGenKbSecGroupFormTableObj( this );
		secGrpIncTableObj = new CFGenKbSecGrpIncTableObj( this );
		secGrpMembTableObj = new CFGenKbSecGrpMembTableObj( this );
		secSessionTableObj = new CFGenKbSecSessionTableObj( this );
		secUserTableObj = new CFGenKbSecUserTableObj( this );
		sysClusterTableObj = new CFGenKbSysClusterTableObj( this );
		tSecGroupTableObj = new CFGenKbTSecGroupTableObj( this );
		tSecGrpIncTableObj = new CFGenKbTSecGrpIncTableObj( this );
		tSecGrpMembTableObj = new CFGenKbTSecGrpMembTableObj( this );
		tenantTableObj = new CFGenKbTenantTableObj( this );
		toolTableObj = new CFGenKbToolTableObj( this );
		toolSetTableObj = new CFGenKbToolSetTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ICFGenKbClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomNameIdx( secClusterName );
				if( ( secCluster == null ) && ( secClusterId > 0 ) ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ICFGenKbClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ICFGenKbTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null ) && ( secTenantId > 0 ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ICFGenKbTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public long getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ICFGenKbSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}

	public void setSecUser( ICFGenKbSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ICFGenKbSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ICFGenKbSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( UUID value ) {
		secSessionSessionId = value;
	}

	public UUID getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public UUID getSecSessionUserId() {
		return( secSessionUserId );
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

	/**
	 *	PostgreSQL coerces database schema names to lowercase for consistency.
	 */
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

		rollback();

		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}

		if( backingStore != null ) {
			backingStore.setDbSchemaName( argDbSchemaName );
		}

		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();

		releasePreparedStatements();
	}

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	public void releasePreparedStatements() {
	}
	public CFGenKbAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFGenKbAuthorization value ) {
		authorization = value;
	}

	public ICFGenKbSchema getBackingStore() {
		return( backingStore );
	}

	public void setBackingStore( ICFGenKbSchema value ) {
		backingStore = value;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public boolean isConnected() {
		if( backingStore == null ) {
			return( false );
		}
		else {
			return( backingStore.isConnected() );
		}
	}

	public boolean connect() {
		return( backingStore.connect() );
	}

	public boolean connect( String username, String password ) {
		return( backingStore.connect( username, password ) );
	}

	public boolean connect( String clusterName, String tenantName, String secUserName, String password ) {
		final String S_ProcName = "connect-full";
		if( ( clusterName == null ) || ( clusterName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"clusterName" );
		}
		if( ( tenantName == null ) || ( tenantName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"tenantName" );
		}
		if( ( secUserName == null ) || ( secUserName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				3,
				"secUserName" );
		}
		if( ( password == null ) || ( password.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				5,
				"password" );
		}
		if( ! backingStore.connect( secUserName, password, clusterName, tenantName ) ) {
			authorization = null;
			return( false );
		}
		if( authorization != null ) {
			// The login was established as an XMsg client, which automatically sets the Authorization
			// information based on the return message.  You only need to do the remaining SecSession
			// and authorization creation if you're using a direct client-server model instead of
			// an XMsg client-server model.
			setSecClusterName( clusterName );
			setSecTenantName( tenantName );
			setSecUserName( secUserName );
			return( true );
		}

		if( clusterName.equals( "system" )
		 && tenantName.equals( "system" )
		 && secUserName.equals( "system" ) )
		{
			if( secCluster == null ) {
				secCluster = getClusterTableObj().newInstance();
				ICFGenKbClusterEditObj editCluster = secCluster.getEdit();
				if( editCluster == null ) {
					editCluster = secCluster.beginEdit();
					editCluster.setRequiredDescription( "system" );
					editCluster.setRequiredFullDomName( "system" );
					secCluster = editCluster.create();
					editCluster = null;
				}
			}
			if( secTenant == null ) {
				secTenant = getTenantTableObj().newInstance();
				ICFGenKbTenantEditObj editTenant = secTenant.getEdit();
				if( editTenant == null ) {
					editTenant = secTenant.beginEdit();
					editTenant.setRequiredContainerCluster( secCluster);
					editTenant.setRequiredTenantName( "system" );
					secTenant = editTenant.create();
					editTenant = null;
				}
			}
			if( secUser == null ) {
				secUser = getSecUserTableObj().newInstance();
				ICFGenKbSecUserEditObj editSecUser = secUser.getEdit();
				if( editSecUser == null ) {
					editSecUser = secUser.beginEdit();
					editSecUser.setRequiredEMailAddress( "system" );
					editSecUser.setRequiredLoginId( "system" );
					secUser = editSecUser.create();
					editSecUser = null;
				}
			}
			setSecClusterName( clusterName );
			setSecTenantName( tenantName );
			setSecUserName( secUserName );
			secCluster = null;
			secTenant = null;
			secUser = null;
			secSession = null;
			ICFGenKbClusterObj cluster = getSecCluster();
			ICFGenKbTenantObj tenant = getSecTenant();
			ICFGenKbSecUserObj user = getSecUser();
			ICFGenKbSecSessionObj session;
			if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
				session = getSecSessionTableObj().newInstance();
				ICFGenKbSecSessionEditObj sessionEdit = session.beginEdit();
				sessionEdit.setRequiredContainerSecUser( user );
				sessionEdit.setRequiredStart( Calendar.getInstance() );
				sessionEdit.setOptionalFinish( null );
				session = sessionEdit.create();
				sessionEdit = null;
				setSecSession( session );
			}
			else {
				session = null;
			}
			if( ( cluster == null ) || ( tenant == null ) || ( user == null ) || ( session == null ) ) {
				disconnect( false );
				authorization = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Could not resolve cluster name, tenant name, user name, or session.  Login cancelled" );
			}
			if( authorization == null ) {
				authorization = new CFGenKbAuthorization();
			}
			authorization.setSecCluster( cluster );
			authorization.setSecTenant( tenant );
			authorization.setSecSession( session );
			return( true );
		}
		setSecClusterName( clusterName );
		setSecTenantName( tenantName );
		setSecUserName( secUserName );
		boolean transactionStarted = beginTransaction();
		secCluster = null;
		secTenant = null;
		secUser = null;
		secSession = null;
		ICFGenKbClusterObj cluster = getSecCluster();
		ICFGenKbTenantObj tenant = getSecTenant();
		ICFGenKbSecUserObj user = getSecUser();
		ICFGenKbSecSessionObj session;
		if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
			session = getSecSessionTableObj().newInstance();
			ICFGenKbSecSessionEditObj sessionEdit = session.beginEdit();
			sessionEdit.setRequiredContainerSecUser( user );
			sessionEdit.setRequiredStart( Calendar.getInstance() );
			sessionEdit.setOptionalFinish( null );
			session = sessionEdit.create();
			sessionEdit = null;
			setSecSession( session );
		}
		else {
			session = null;
		}
		if( transactionStarted ) {
			commit();
		}
		if( ( cluster == null ) || ( tenant == null ) || ( user == null ) || ( session == null ) ) {
			disconnect( false );
			authorization = null;
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Could not resolve cluster name, tenant name, user name, or session.  Login cancelled" );
		}
		if( authorization == null ) {
			authorization = new CFGenKbAuthorization();
		}
		authorization.setSecCluster( cluster );
		authorization.setSecTenant( tenant );
		authorization.setSecSession( session );
		return( true );
	}

	public void disconnect( boolean doCommit ) {
		backingStore.disconnect( doCommit );
	}

	public void logout() {
		if( authorization == null ) {
			if( isConnected() ) {
				disconnect( false );
			}
			return;
		}
		if( isConnected() ) {
			try {
				boolean transactionStarted = beginTransaction();
				if( ! transactionStarted ) {
					rollback();
					transactionStarted = beginTransaction();
					if( ! transactionStarted ) {
						setAuthorization( null );
						return;
					}
				}
				UUID secSessionId = authorization.getSecSessionId();
				if( secSessionId != null ) {
					ICFGenKbSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
					if( secSession != null ) {
						if( secSession.getOptionalFinish() == null ) {
							ICFGenKbSecSessionEditObj editSecSession = secSession.beginEdit();
							editSecSession.setOptionalFinish( Calendar.getInstance() );
							editSecSession.update();
							editSecSession = null;
						}
					}
				}
				commit();
			}
			finally {
				setAuthorization( null );
				try {
					disconnect( false );
				}
				catch( RuntimeException e ) {
				}
			}
		}
	}

	public void minimizeMemory() {
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( defClassTableObj != null ) {
			defClassTableObj.minimizeMemory();
		}
		if( gelBoilerplateTableObj != null ) {
			gelBoilerplateTableObj.minimizeMemory();
		}
		if( gelBuiltinTableObj != null ) {
			gelBuiltinTableObj.minimizeMemory();
		}
		if( gelCacheTableObj != null ) {
			gelCacheTableObj.minimizeMemory();
		}
		if( gelCallTableObj != null ) {
			gelCallTableObj.minimizeMemory();
		}
		if( gelConstrainTableObj != null ) {
			gelConstrainTableObj.minimizeMemory();
		}
		if( gelCounterTableObj != null ) {
			gelCounterTableObj.minimizeMemory();
		}
		if( gelErrorTableObj != null ) {
			gelErrorTableObj.minimizeMemory();
		}
		if( gelExecutableTableObj != null ) {
			gelExecutableTableObj.minimizeMemory();
		}
		if( gelExpansionTableObj != null ) {
			gelExpansionTableObj.minimizeMemory();
		}
		if( gelInstructionTableObj != null ) {
			gelInstructionTableObj.minimizeMemory();
		}
		if( gelIteratorTableObj != null ) {
			gelIteratorTableObj.minimizeMemory();
		}
		if( gelModifierTableObj != null ) {
			gelModifierTableObj.minimizeMemory();
		}
		if( gelPopTableObj != null ) {
			gelPopTableObj.minimizeMemory();
		}
		if( gelPrefixLineTableObj != null ) {
			gelPrefixLineTableObj.minimizeMemory();
		}
		if( gelReferenceTableObj != null ) {
			gelReferenceTableObj.minimizeMemory();
		}
		if( gelSequenceTableObj != null ) {
			gelSequenceTableObj.minimizeMemory();
		}
		if( gelSpreadTableObj != null ) {
			gelSpreadTableObj.minimizeMemory();
		}
		if( gelSwitchTableObj != null ) {
			gelSwitchTableObj.minimizeMemory();
		}
		if( gelSwitchLimbTableObj != null ) {
			gelSwitchLimbTableObj.minimizeMemory();
		}
		if( genBindTableObj != null ) {
			genBindTableObj.minimizeMemory();
		}
		if( genFileTableObj != null ) {
			genFileTableObj.minimizeMemory();
		}
		if( genItemTableObj != null ) {
			genItemTableObj.minimizeMemory();
		}
		if( genIteratorTableObj != null ) {
			genIteratorTableObj.minimizeMemory();
		}
		if( genReferenceTableObj != null ) {
			genReferenceTableObj.minimizeMemory();
		}
		if( genRuleTableObj != null ) {
			genRuleTableObj.minimizeMemory();
		}
		if( genTruncTableObj != null ) {
			genTruncTableObj.minimizeMemory();
		}
		if( hostNodeTableObj != null ) {
			hostNodeTableObj.minimizeMemory();
		}
		if( ruleCartTableObj != null ) {
			ruleCartTableObj.minimizeMemory();
		}
		if( ruleTypeTableObj != null ) {
			ruleTypeTableObj.minimizeMemory();
		}
		if( secAppTableObj != null ) {
			secAppTableObj.minimizeMemory();
		}
		if( secDeviceTableObj != null ) {
			secDeviceTableObj.minimizeMemory();
		}
		if( secFormTableObj != null ) {
			secFormTableObj.minimizeMemory();
		}
		if( secGroupTableObj != null ) {
			secGroupTableObj.minimizeMemory();
		}
		if( secGroupFormTableObj != null ) {
			secGroupFormTableObj.minimizeMemory();
		}
		if( secGrpIncTableObj != null ) {
			secGrpIncTableObj.minimizeMemory();
		}
		if( secGrpMembTableObj != null ) {
			secGrpMembTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tSecGroupTableObj != null ) {
			tSecGroupTableObj.minimizeMemory();
		}
		if( tSecGrpIncTableObj != null ) {
			tSecGrpIncTableObj.minimizeMemory();
		}
		if( tSecGrpMembTableObj != null ) {
			tSecGrpMembTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
		if( toolTableObj != null ) {
			toolTableObj.minimizeMemory();
		}
		if( toolSetTableObj != null ) {
			toolSetTableObj.minimizeMemory();
		}
	}

	public boolean isTransactionOpen() {
		boolean txnOpen = backingStore.isTransactionOpen();
		return( txnOpen );
	}

	public boolean beginTransaction() {
		boolean txnInitiated = backingStore.beginTransaction();
		return( txnInitiated );
	}

	public void commit() {
		backingStore.commit();
	}

	public void rollback() {
		backingStore.rollback();
	}
	public ICFGenKbClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public ICFGenKbDefClassTableObj getDefClassTableObj() {
		return( defClassTableObj );
	}

	public ICFGenKbGelBoilerplateTableObj getGelBoilerplateTableObj() {
		return( gelBoilerplateTableObj );
	}

	public ICFGenKbGelBuiltinTableObj getGelBuiltinTableObj() {
		return( gelBuiltinTableObj );
	}

	public ICFGenKbGelCacheTableObj getGelCacheTableObj() {
		return( gelCacheTableObj );
	}

	public ICFGenKbGelCallTableObj getGelCallTableObj() {
		return( gelCallTableObj );
	}

	public ICFGenKbGelConstrainTableObj getGelConstrainTableObj() {
		return( gelConstrainTableObj );
	}

	public ICFGenKbGelCounterTableObj getGelCounterTableObj() {
		return( gelCounterTableObj );
	}

	public ICFGenKbGelErrorTableObj getGelErrorTableObj() {
		return( gelErrorTableObj );
	}

	public ICFGenKbGelExecutableTableObj getGelExecutableTableObj() {
		return( gelExecutableTableObj );
	}

	public ICFGenKbGelExpansionTableObj getGelExpansionTableObj() {
		return( gelExpansionTableObj );
	}

	public ICFGenKbGelInstructionTableObj getGelInstructionTableObj() {
		return( gelInstructionTableObj );
	}

	public ICFGenKbGelIteratorTableObj getGelIteratorTableObj() {
		return( gelIteratorTableObj );
	}

	public ICFGenKbGelModifierTableObj getGelModifierTableObj() {
		return( gelModifierTableObj );
	}

	public ICFGenKbGelPopTableObj getGelPopTableObj() {
		return( gelPopTableObj );
	}

	public ICFGenKbGelPrefixLineTableObj getGelPrefixLineTableObj() {
		return( gelPrefixLineTableObj );
	}

	public ICFGenKbGelReferenceTableObj getGelReferenceTableObj() {
		return( gelReferenceTableObj );
	}

	public ICFGenKbGelSequenceTableObj getGelSequenceTableObj() {
		return( gelSequenceTableObj );
	}

	public ICFGenKbGelSpreadTableObj getGelSpreadTableObj() {
		return( gelSpreadTableObj );
	}

	public ICFGenKbGelSwitchTableObj getGelSwitchTableObj() {
		return( gelSwitchTableObj );
	}

	public ICFGenKbGelSwitchLimbTableObj getGelSwitchLimbTableObj() {
		return( gelSwitchLimbTableObj );
	}

	public ICFGenKbGenBindTableObj getGenBindTableObj() {
		return( genBindTableObj );
	}

	public ICFGenKbGenFileTableObj getGenFileTableObj() {
		return( genFileTableObj );
	}

	public ICFGenKbGenItemTableObj getGenItemTableObj() {
		return( genItemTableObj );
	}

	public ICFGenKbGenIteratorTableObj getGenIteratorTableObj() {
		return( genIteratorTableObj );
	}

	public ICFGenKbGenReferenceTableObj getGenReferenceTableObj() {
		return( genReferenceTableObj );
	}

	public ICFGenKbGenRuleTableObj getGenRuleTableObj() {
		return( genRuleTableObj );
	}

	public ICFGenKbGenTruncTableObj getGenTruncTableObj() {
		return( genTruncTableObj );
	}

	public ICFGenKbHostNodeTableObj getHostNodeTableObj() {
		return( hostNodeTableObj );
	}

	public ICFGenKbRuleCartTableObj getRuleCartTableObj() {
		return( ruleCartTableObj );
	}

	public ICFGenKbRuleTypeTableObj getRuleTypeTableObj() {
		return( ruleTypeTableObj );
	}

	public ICFGenKbSecAppTableObj getSecAppTableObj() {
		return( secAppTableObj );
	}

	public ICFGenKbSecDeviceTableObj getSecDeviceTableObj() {
		return( secDeviceTableObj );
	}

	public ICFGenKbSecFormTableObj getSecFormTableObj() {
		return( secFormTableObj );
	}

	public ICFGenKbSecGroupTableObj getSecGroupTableObj() {
		return( secGroupTableObj );
	}

	public ICFGenKbSecGroupFormTableObj getSecGroupFormTableObj() {
		return( secGroupFormTableObj );
	}

	public ICFGenKbSecGrpIncTableObj getSecGrpIncTableObj() {
		return( secGrpIncTableObj );
	}

	public ICFGenKbSecGrpMembTableObj getSecGrpMembTableObj() {
		return( secGrpMembTableObj );
	}

	public ICFGenKbSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public ICFGenKbSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public ICFGenKbSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public ICFGenKbTSecGroupTableObj getTSecGroupTableObj() {
		return( tSecGroupTableObj );
	}

	public ICFGenKbTSecGrpIncTableObj getTSecGrpIncTableObj() {
		return( tSecGrpIncTableObj );
	}

	public ICFGenKbTSecGrpMembTableObj getTSecGrpMembTableObj() {
		return( tSecGrpMembTableObj );
	}

	public ICFGenKbTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public ICFGenKbToolTableObj getToolTableObj() {
		return( toolTableObj );
	}

	public ICFGenKbToolSetTableObj getToolSetTableObj() {
		return( toolSetTableObj );
	}
}
