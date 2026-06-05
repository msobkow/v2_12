// Description: Java 11 implementation of an in-memory RAM CFGenKb schema.

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

package org.msscf.msscf.cfcore.CFGenKbRam;

import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class CFGenKbRamSchema
	extends CFGenKbSchema
	implements ICFGenKbSchema
{
		protected short nextDefClassIdGenValue = 1;
		protected short nextRuleTypeIdGenValue = 1;
		protected short nextToolIdGenValue = 1;
		protected short nextToolSetIdGenValue = 1;
		protected long nextClusterIdGenValue = 1;
		protected long nextTenantIdGenValue = 1;


	public CFGenKbRamSchema() {
		super();
		tableCluster = new CFGenKbRamClusterTable( this );
		tableDefClass = new CFGenKbRamDefClassTable( this );
		tableGelBoilerplate = new CFGenKbRamGelBoilerplateTable( this );
		tableGelBuiltin = new CFGenKbRamGelBuiltinTable( this );
		tableGelCache = new CFGenKbRamGelCacheTable( this );
		tableGelCall = new CFGenKbRamGelCallTable( this );
		tableGelConstrain = new CFGenKbRamGelConstrainTable( this );
		tableGelCounter = new CFGenKbRamGelCounterTable( this );
		tableGelError = new CFGenKbRamGelErrorTable( this );
		tableGelExecutable = new CFGenKbRamGelExecutableTable( this );
		tableGelExpansion = new CFGenKbRamGelExpansionTable( this );
		tableGelInstruction = new CFGenKbRamGelInstructionTable( this );
		tableGelIterator = new CFGenKbRamGelIteratorTable( this );
		tableGelModifier = new CFGenKbRamGelModifierTable( this );
		tableGelPop = new CFGenKbRamGelPopTable( this );
		tableGelPrefixLine = new CFGenKbRamGelPrefixLineTable( this );
		tableGelReference = new CFGenKbRamGelReferenceTable( this );
		tableGelSequence = new CFGenKbRamGelSequenceTable( this );
		tableGelSpread = new CFGenKbRamGelSpreadTable( this );
		tableGelSwitch = new CFGenKbRamGelSwitchTable( this );
		tableGelSwitchLimb = new CFGenKbRamGelSwitchLimbTable( this );
		tableGenBind = new CFGenKbRamGenBindTable( this );
		tableGenFile = new CFGenKbRamGenFileTable( this );
		tableGenItem = new CFGenKbRamGenItemTable( this );
		tableGenIterator = new CFGenKbRamGenIteratorTable( this );
		tableGenReference = new CFGenKbRamGenReferenceTable( this );
		tableGenRule = new CFGenKbRamGenRuleTable( this );
		tableGenTrunc = new CFGenKbRamGenTruncTable( this );
		tableHostNode = new CFGenKbRamHostNodeTable( this );
		tableRuleCart = new CFGenKbRamRuleCartTable( this );
		tableRuleType = new CFGenKbRamRuleTypeTable( this );
		tableSecApp = new CFGenKbRamSecAppTable( this );
		tableSecDevice = new CFGenKbRamSecDeviceTable( this );
		tableSecForm = new CFGenKbRamSecFormTable( this );
		tableSecGroup = new CFGenKbRamSecGroupTable( this );
		tableSecGroupForm = new CFGenKbRamSecGroupFormTable( this );
		tableSecGrpInc = new CFGenKbRamSecGrpIncTable( this );
		tableSecGrpMemb = new CFGenKbRamSecGrpMembTable( this );
		tableSecSession = new CFGenKbRamSecSessionTable( this );
		tableSecUser = new CFGenKbRamSecUserTable( this );
		tableSysCluster = new CFGenKbRamSysClusterTable( this );
		tableTSecGroup = new CFGenKbRamTSecGroupTable( this );
		tableTSecGrpInc = new CFGenKbRamTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFGenKbRamTSecGrpMembTable( this );
		tableTenant = new CFGenKbRamTenantTable( this );
		tableTool = new CFGenKbRamToolTable( this );
		tableToolSet = new CFGenKbRamToolSetTable( this );
	}

	protected boolean sessConnected = false;

	public boolean isConnected() {
		return( sessConnected );
	}

	public boolean connect() {
		if( sessConnected ) {
			return( false );
		}
		else {
			sessConnected = true;
			tranOpen = false;
			return( true );
		}
	}

	public boolean connect( String username, String password ) {
		final String S_ProcName = "connect";
		if( ( username == null ) || ( username.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"username" );
		}
		if( password == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"password" );
		}
		if( ! username.equals( "system" ) ) {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Only 'system' is authorized to use a RAM database" );
		}
		if( sessConnected ) {
			return( false );
		}
		else {
			sessConnected = true;
			tranOpen = false;
			return( true );
		}
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		final String S_ProcName = "connect";
		if( ( loginId == null ) || ( loginId.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"loginId" );
		}
		if( password == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"password" );
		}
		if( clusterName == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				3,
				"clusterName" );
		}
		if( tenantName == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				4,
				"tenantName" );
		}
		if( ! loginId.equals( "system" ) ) {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Only 'system' is authorized to use a RAM database" );
		}
		if( ! clusterName.equals( "system" ) ) {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Only the 'system' Cluster is authorized to use a RAM database" );
		}
		if( ! tenantName.equals( "system" ) ) {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Only the 'system' Tenant is authorized to use a RAM database" );
		}
		if( sessConnected ) {
			return( false );
		}
		else {
			sessConnected = true;
			tranOpen = false;
			return( true );
		}
	}

	public void disconnect( boolean doCommit ) {
		tranOpen = false;
		sessConnected = false;
	}

	//	Transactions are not supported, so pretend there is always one open

	protected boolean tranOpen = false;

	public boolean isTransactionOpen() {
		return( tranOpen );
	}

	public boolean beginTransaction() {
		if( tranOpen ) {
			return( false );
		}
		tranOpen = true;
		return( true );
	}

	public void commit() {
		tranOpen = false;
	}

	public void rollback() {
		tranOpen = false;
	}

	public ICFGenKbSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	public short nextDefClassIdGen() {
		short next = nextDefClassIdGenValue++;
		return( next );
	}

	public short nextRuleTypeIdGen() {
		short next = nextRuleTypeIdGenValue++;
		return( next );
	}

	public short nextToolIdGen() {
		short next = nextToolIdGenValue++;
		return( next );
	}

	public short nextToolSetIdGen() {
		short next = nextToolSetIdGenValue++;
		return( next );
	}

	public long nextClusterIdGen() {
		long next = nextClusterIdGenValue++;
		return( next );
	}

	public long nextTenantIdGen() {
		long next = nextTenantIdGenValue++;
		return( next );
	}

	public UUID nextSecSessionIdGen() {
		UUID next = UUID.randomUUID();
		return( next );
	}

	public UUID nextSecUserIdGen() {
		UUID next = UUID.randomUUID();
		return( next );
	}

	public void releasePreparedStatements() {
	}
}
