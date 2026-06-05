// Description: Java 11 Schema Object implementation for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;
public class CFIntSchemaObj
	implements ICFIntSchemaObj
{
	public static String SCHEMA_NAME = "CFInt";
	public static String SCHEMA_DBNAME = "cfinet212";
	protected CFSecAuthorization authorization = null;
	protected ICFSecSchema backingStore = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ICFSecClusterObj secCluster = null;
	protected long secClusterId = 0L;
	protected ICFSecTenantObj secTenant = null;
	protected long secTenantId = 0L;
	protected ICFSecSecUserObj secUser = null;
	protected UUID secSessionUserId = null;
	protected ICFSecSecSessionObj secSession = null;
	protected UUID secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();
	protected ICFIntClusterTableObj clusterTableObj;
	protected ICFIntHostNodeTableObj hostNodeTableObj;
	protected ICFIntISOCcyTableObj iSOCcyTableObj;
	protected ICFIntISOCtryTableObj iSOCtryTableObj;
	protected ICFIntISOCtryCcyTableObj iSOCtryCcyTableObj;
	protected ICFIntISOCtryLangTableObj iSOCtryLangTableObj;
	protected ICFIntISOLangTableObj iSOLangTableObj;
	protected ICFIntISOTZoneTableObj iSOTZoneTableObj;
	protected ICFIntLicenseTableObj licenseTableObj;
	protected ICFIntMajorVersionTableObj majorVersionTableObj;
	protected ICFIntMimeTypeTableObj mimeTypeTableObj;
	protected ICFIntMinorVersionTableObj minorVersionTableObj;
	protected ICFIntSecAppTableObj secAppTableObj;
	protected ICFIntSecDeviceTableObj secDeviceTableObj;
	protected ICFIntSecFormTableObj secFormTableObj;
	protected ICFIntSecGroupTableObj secGroupTableObj;
	protected ICFIntSecGroupFormTableObj secGroupFormTableObj;
	protected ICFIntSecGrpIncTableObj secGrpIncTableObj;
	protected ICFIntSecGrpMembTableObj secGrpMembTableObj;
	protected ICFIntSecSessionTableObj secSessionTableObj;
	protected ICFIntSecUserTableObj secUserTableObj;
	protected ICFIntServiceTableObj serviceTableObj;
	protected ICFIntServiceTypeTableObj serviceTypeTableObj;
	protected ICFIntSubProjectTableObj subProjectTableObj;
	protected ICFIntSysClusterTableObj sysClusterTableObj;
	protected ICFIntTSecGroupTableObj tSecGroupTableObj;
	protected ICFIntTSecGrpIncTableObj tSecGrpIncTableObj;
	protected ICFIntTSecGrpMembTableObj tSecGrpMembTableObj;
	protected ICFIntTenantTableObj tenantTableObj;
	protected ICFIntTldTableObj tldTableObj;
	protected ICFIntTopDomainTableObj topDomainTableObj;
	protected ICFIntTopProjectTableObj topProjectTableObj;
	protected ICFIntURLProtocolTableObj uRLProtocolTableObj;

	public CFIntSchemaObj() {
		clusterTableObj = new CFIntClusterTableObj( this );
		hostNodeTableObj = new CFIntHostNodeTableObj( this );
		iSOCcyTableObj = new CFIntISOCcyTableObj( this );
		iSOCtryTableObj = new CFIntISOCtryTableObj( this );
		iSOCtryCcyTableObj = new CFIntISOCtryCcyTableObj( this );
		iSOCtryLangTableObj = new CFIntISOCtryLangTableObj( this );
		iSOLangTableObj = new CFIntISOLangTableObj( this );
		iSOTZoneTableObj = new CFIntISOTZoneTableObj( this );
		licenseTableObj = new CFIntLicenseTableObj( this );
		majorVersionTableObj = new CFIntMajorVersionTableObj( this );
		mimeTypeTableObj = new CFIntMimeTypeTableObj( this );
		minorVersionTableObj = new CFIntMinorVersionTableObj( this );
		secAppTableObj = new CFIntSecAppTableObj( this );
		secDeviceTableObj = new CFIntSecDeviceTableObj( this );
		secFormTableObj = new CFIntSecFormTableObj( this );
		secGroupTableObj = new CFIntSecGroupTableObj( this );
		secGroupFormTableObj = new CFIntSecGroupFormTableObj( this );
		secGrpIncTableObj = new CFIntSecGrpIncTableObj( this );
		secGrpMembTableObj = new CFIntSecGrpMembTableObj( this );
		secSessionTableObj = new CFIntSecSessionTableObj( this );
		secUserTableObj = new CFIntSecUserTableObj( this );
		serviceTableObj = new CFIntServiceTableObj( this );
		serviceTypeTableObj = new CFIntServiceTypeTableObj( this );
		subProjectTableObj = new CFIntSubProjectTableObj( this );
		sysClusterTableObj = new CFIntSysClusterTableObj( this );
		tSecGroupTableObj = new CFIntTSecGroupTableObj( this );
		tSecGrpIncTableObj = new CFIntTSecGrpIncTableObj( this );
		tSecGrpMembTableObj = new CFIntTSecGrpMembTableObj( this );
		tenantTableObj = new CFIntTenantTableObj( this );
		tldTableObj = new CFIntTldTableObj( this );
		topDomainTableObj = new CFIntTopDomainTableObj( this );
		topProjectTableObj = new CFIntTopProjectTableObj( this );
		uRLProtocolTableObj = new CFIntURLProtocolTableObj( this );
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

	public ICFSecClusterObj getSecCluster() {
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

	public void setSecCluster( ICFSecClusterObj value ) {
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

	public ICFSecTenantObj getSecTenant() {
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

	public void setSecTenant( ICFSecTenantObj value ) {
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

	public ICFSecSecUserObj getSecUser() {
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

	public void setSecUser( ICFSecSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ICFSecSecSessionObj getSecSession() {
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

	public void setSecSession( ICFSecSecSessionObj value ) {
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

	public String fileImport( String fileName, String fileContent ) {
		String logContent = backingStore.fileImport( getAuthorization(), fileName, fileContent );
		return( logContent );
	}

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	public void releasePreparedStatements() {
	}
	public CFSecAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFSecAuthorization value ) {
		authorization = value;
	}

	public ICFSecSchema getBackingStore() {
		return( backingStore );
	}

	public void setBackingStore( ICFSecSchema value ) {
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
				ICFSecClusterEditObj editCluster = secCluster.getEdit();
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
				ICFSecTenantEditObj editTenant = secTenant.getEdit();
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
				ICFSecSecUserEditObj editSecUser = secUser.getEdit();
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
			ICFSecClusterObj cluster = getSecCluster();
			ICFSecTenantObj tenant = getSecTenant();
			ICFSecSecUserObj user = getSecUser();
			ICFSecSecSessionObj session;
			if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
				session = getSecSessionTableObj().newInstance();
				ICFSecSecSessionEditObj sessionEdit = session.beginEdit();
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
				authorization = new CFSecAuthorization();
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
		ICFSecClusterObj cluster = getSecCluster();
		ICFSecTenantObj tenant = getSecTenant();
		ICFSecSecUserObj user = getSecUser();
		ICFSecSecSessionObj session;
		if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
			session = getSecSessionTableObj().newInstance();
			ICFSecSecSessionEditObj sessionEdit = session.beginEdit();
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
			authorization = new CFSecAuthorization();
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
					ICFSecSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
					if( secSession != null ) {
						if( secSession.getOptionalFinish() == null ) {
							ICFSecSecSessionEditObj editSecSession = secSession.beginEdit();
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
		if( hostNodeTableObj != null ) {
			hostNodeTableObj.minimizeMemory();
		}
		if( iSOCcyTableObj != null ) {
			iSOCcyTableObj.minimizeMemory();
		}
		if( iSOCtryTableObj != null ) {
			iSOCtryTableObj.minimizeMemory();
		}
		if( iSOCtryCcyTableObj != null ) {
			iSOCtryCcyTableObj.minimizeMemory();
		}
		if( iSOCtryLangTableObj != null ) {
			iSOCtryLangTableObj.minimizeMemory();
		}
		if( iSOLangTableObj != null ) {
			iSOLangTableObj.minimizeMemory();
		}
		if( iSOTZoneTableObj != null ) {
			iSOTZoneTableObj.minimizeMemory();
		}
		if( licenseTableObj != null ) {
			licenseTableObj.minimizeMemory();
		}
		if( majorVersionTableObj != null ) {
			majorVersionTableObj.minimizeMemory();
		}
		if( mimeTypeTableObj != null ) {
			mimeTypeTableObj.minimizeMemory();
		}
		if( minorVersionTableObj != null ) {
			minorVersionTableObj.minimizeMemory();
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
		if( serviceTableObj != null ) {
			serviceTableObj.minimizeMemory();
		}
		if( serviceTypeTableObj != null ) {
			serviceTypeTableObj.minimizeMemory();
		}
		if( subProjectTableObj != null ) {
			subProjectTableObj.minimizeMemory();
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
		if( tldTableObj != null ) {
			tldTableObj.minimizeMemory();
		}
		if( topDomainTableObj != null ) {
			topDomainTableObj.minimizeMemory();
		}
		if( topProjectTableObj != null ) {
			topProjectTableObj.minimizeMemory();
		}
		if( uRLProtocolTableObj != null ) {
			uRLProtocolTableObj.minimizeMemory();
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
	public ICFIntClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public ICFIntHostNodeTableObj getHostNodeTableObj() {
		return( hostNodeTableObj );
	}

	public ICFIntISOCcyTableObj getISOCcyTableObj() {
		return( iSOCcyTableObj );
	}

	public ICFIntISOCtryTableObj getISOCtryTableObj() {
		return( iSOCtryTableObj );
	}

	public ICFIntISOCtryCcyTableObj getISOCtryCcyTableObj() {
		return( iSOCtryCcyTableObj );
	}

	public ICFIntISOCtryLangTableObj getISOCtryLangTableObj() {
		return( iSOCtryLangTableObj );
	}

	public ICFIntISOLangTableObj getISOLangTableObj() {
		return( iSOLangTableObj );
	}

	public ICFIntISOTZoneTableObj getISOTZoneTableObj() {
		return( iSOTZoneTableObj );
	}

	public ICFIntLicenseTableObj getLicenseTableObj() {
		return( licenseTableObj );
	}

	public ICFIntMajorVersionTableObj getMajorVersionTableObj() {
		return( majorVersionTableObj );
	}

	public ICFIntMimeTypeTableObj getMimeTypeTableObj() {
		return( mimeTypeTableObj );
	}

	public ICFIntMinorVersionTableObj getMinorVersionTableObj() {
		return( minorVersionTableObj );
	}

	public ICFIntSecAppTableObj getSecAppTableObj() {
		return( secAppTableObj );
	}

	public ICFIntSecDeviceTableObj getSecDeviceTableObj() {
		return( secDeviceTableObj );
	}

	public ICFIntSecFormTableObj getSecFormTableObj() {
		return( secFormTableObj );
	}

	public ICFIntSecGroupTableObj getSecGroupTableObj() {
		return( secGroupTableObj );
	}

	public ICFIntSecGroupFormTableObj getSecGroupFormTableObj() {
		return( secGroupFormTableObj );
	}

	public ICFIntSecGrpIncTableObj getSecGrpIncTableObj() {
		return( secGrpIncTableObj );
	}

	public ICFIntSecGrpMembTableObj getSecGrpMembTableObj() {
		return( secGrpMembTableObj );
	}

	public ICFIntSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public ICFIntSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public ICFIntServiceTableObj getServiceTableObj() {
		return( serviceTableObj );
	}

	public ICFIntServiceTypeTableObj getServiceTypeTableObj() {
		return( serviceTypeTableObj );
	}

	public ICFIntSubProjectTableObj getSubProjectTableObj() {
		return( subProjectTableObj );
	}

	public ICFIntSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public ICFIntTSecGroupTableObj getTSecGroupTableObj() {
		return( tSecGroupTableObj );
	}

	public ICFIntTSecGrpIncTableObj getTSecGrpIncTableObj() {
		return( tSecGrpIncTableObj );
	}

	public ICFIntTSecGrpMembTableObj getTSecGrpMembTableObj() {
		return( tSecGrpMembTableObj );
	}

	public ICFIntTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public ICFIntTldTableObj getTldTableObj() {
		return( tldTableObj );
	}

	public ICFIntTopDomainTableObj getTopDomainTableObj() {
		return( topDomainTableObj );
	}

	public ICFIntTopProjectTableObj getTopProjectTableObj() {
		return( topProjectTableObj );
	}

	public ICFIntURLProtocolTableObj getURLProtocolTableObj() {
		return( uRLProtocolTableObj );
	}
}
