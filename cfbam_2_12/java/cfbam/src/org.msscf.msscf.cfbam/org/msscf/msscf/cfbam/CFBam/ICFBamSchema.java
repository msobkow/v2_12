// Description: Java 11 interface for a CFBam schema.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.Tip.CFTipClientHandler;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFBamSchema
extends ICFSecSchema,
	ICFIntSchema
{
	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};

	public enum RelationTypeEnum {
		Unknown,
		Lookup,
		Superclass,
		Container,
		Components,
		Owner,
		Parent,
		Children
	};

	public enum SecScopeEnum {
		None,
		System,
		Cluster,
		Tenant
	};

	CFSecConfigurationFile getConfigurationFile();
	void setConfigurationFile( CFSecConfigurationFile value );

	String getJndiName();
	void setJndiName( String value );

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
	void logout( CFSecAuthorization auth );

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	String fileImport( CFSecAuthorization auth, String fileName, String fileContent );

	/**
	 *	Allocate a new schema instance.
	 *
	 *	@return	A new ICFSecSchema instance.
	 */
	ICFSecSchema newSchema();

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextISOCtryIdGen();

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextISOCcyIdGen();

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextISOLangIdGen();

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	short nextISOTZoneIdGen();

	/**
	 *	Get the next ServiceTypeIdGen identifier.
	 *
	 *	@return	The next ServiceTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	int nextServiceTypeIdGen();

	/**
	 *	Get the next MimeTypeIdGen identifier.
	 *
	 *	@return	The next MimeTypeIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	int nextMimeTypeIdGen();

	/**
	 *	Get the next URLProtocolIdGen identifier.
	 *
	 *	@return	The next URLProtocolIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	int nextURLProtocolIdGen();

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
	 *	Get the Atom Table interface for the schema.
	 *
	 *	@return	The Atom Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAtomTable getTableAtom();

	/**
	 *	Get the Atom Factory interface for the schema.
	 *
	 *	@return	The Atom Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamAtomFactory getFactoryAtom();

	/**
	 *	Get the BlobCol Table interface for the schema.
	 *
	 *	@return	The BlobCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobColTable getTableBlobCol();

	/**
	 *	Get the BlobCol Factory interface for the schema.
	 *
	 *	@return	The BlobCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobColFactory getFactoryBlobCol();

	/**
	 *	Get the BlobDef Table interface for the schema.
	 *
	 *	@return	The BlobDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobDefTable getTableBlobDef();

	/**
	 *	Get the BlobDef Factory interface for the schema.
	 *
	 *	@return	The BlobDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobDefFactory getFactoryBlobDef();

	/**
	 *	Get the BlobType Table interface for the schema.
	 *
	 *	@return	The BlobType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobTypeTable getTableBlobType();

	/**
	 *	Get the BlobType Factory interface for the schema.
	 *
	 *	@return	The BlobType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBlobTypeFactory getFactoryBlobType();

	/**
	 *	Get the BoolCol Table interface for the schema.
	 *
	 *	@return	The BoolCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolColTable getTableBoolCol();

	/**
	 *	Get the BoolCol Factory interface for the schema.
	 *
	 *	@return	The BoolCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolColFactory getFactoryBoolCol();

	/**
	 *	Get the BoolDef Table interface for the schema.
	 *
	 *	@return	The BoolDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolDefTable getTableBoolDef();

	/**
	 *	Get the BoolDef Factory interface for the schema.
	 *
	 *	@return	The BoolDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolDefFactory getFactoryBoolDef();

	/**
	 *	Get the BoolType Table interface for the schema.
	 *
	 *	@return	The BoolType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolTypeTable getTableBoolType();

	/**
	 *	Get the BoolType Factory interface for the schema.
	 *
	 *	@return	The BoolType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamBoolTypeFactory getFactoryBoolType();

	/**
	 *	Get the Chain Table interface for the schema.
	 *
	 *	@return	The Chain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamChainTable getTableChain();

	/**
	 *	Get the Chain Factory interface for the schema.
	 *
	 *	@return	The Chain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamChainFactory getFactoryChain();

	/**
	 *	Get the ClearDep Table interface for the schema.
	 *
	 *	@return	The ClearDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearDepTable getTableClearDep();

	/**
	 *	Get the ClearDep Factory interface for the schema.
	 *
	 *	@return	The ClearDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearDepFactory getFactoryClearDep();

	/**
	 *	Get the ClearSubDep1 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep1Table getTableClearSubDep1();

	/**
	 *	Get the ClearSubDep1 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep1Factory getFactoryClearSubDep1();

	/**
	 *	Get the ClearSubDep2 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep2Table getTableClearSubDep2();

	/**
	 *	Get the ClearSubDep2 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep2Factory getFactoryClearSubDep2();

	/**
	 *	Get the ClearSubDep3 Table interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep3Table getTableClearSubDep3();

	/**
	 *	Get the ClearSubDep3 Factory interface for the schema.
	 *
	 *	@return	The ClearSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearSubDep3Factory getFactoryClearSubDep3();

	/**
	 *	Get the ClearTopDep Table interface for the schema.
	 *
	 *	@return	The ClearTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearTopDepTable getTableClearTopDep();

	/**
	 *	Get the ClearTopDep Factory interface for the schema.
	 *
	 *	@return	The ClearTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamClearTopDepFactory getFactoryClearTopDep();

	/**
	 *	Get the Cluster Table interface for the schema.
	 *
	 *	@return	The Cluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecClusterTable getTableCluster();

	/**
	 *	Get the Cluster Factory interface for the schema.
	 *
	 *	@return	The Cluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecClusterFactory getFactoryCluster();

	/**
	 *	Get the DateCol Table interface for the schema.
	 *
	 *	@return	The DateCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateColTable getTableDateCol();

	/**
	 *	Get the DateCol Factory interface for the schema.
	 *
	 *	@return	The DateCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateColFactory getFactoryDateCol();

	/**
	 *	Get the DateDef Table interface for the schema.
	 *
	 *	@return	The DateDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateDefTable getTableDateDef();

	/**
	 *	Get the DateDef Factory interface for the schema.
	 *
	 *	@return	The DateDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateDefFactory getFactoryDateDef();

	/**
	 *	Get the DateType Table interface for the schema.
	 *
	 *	@return	The DateType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateTypeTable getTableDateType();

	/**
	 *	Get the DateType Factory interface for the schema.
	 *
	 *	@return	The DateType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDateTypeFactory getFactoryDateType();

	/**
	 *	Get the DelDep Table interface for the schema.
	 *
	 *	@return	The DelDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelDepTable getTableDelDep();

	/**
	 *	Get the DelDep Factory interface for the schema.
	 *
	 *	@return	The DelDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelDepFactory getFactoryDelDep();

	/**
	 *	Get the DelSubDep1 Table interface for the schema.
	 *
	 *	@return	The DelSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep1Table getTableDelSubDep1();

	/**
	 *	Get the DelSubDep1 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep1Factory getFactoryDelSubDep1();

	/**
	 *	Get the DelSubDep2 Table interface for the schema.
	 *
	 *	@return	The DelSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep2Table getTableDelSubDep2();

	/**
	 *	Get the DelSubDep2 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep2Factory getFactoryDelSubDep2();

	/**
	 *	Get the DelSubDep3 Table interface for the schema.
	 *
	 *	@return	The DelSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep3Table getTableDelSubDep3();

	/**
	 *	Get the DelSubDep3 Factory interface for the schema.
	 *
	 *	@return	The DelSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelSubDep3Factory getFactoryDelSubDep3();

	/**
	 *	Get the DelTopDep Table interface for the schema.
	 *
	 *	@return	The DelTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelTopDepTable getTableDelTopDep();

	/**
	 *	Get the DelTopDep Factory interface for the schema.
	 *
	 *	@return	The DelTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDelTopDepFactory getFactoryDelTopDep();

	/**
	 *	Get the DoubleCol Table interface for the schema.
	 *
	 *	@return	The DoubleCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleColTable getTableDoubleCol();

	/**
	 *	Get the DoubleCol Factory interface for the schema.
	 *
	 *	@return	The DoubleCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleColFactory getFactoryDoubleCol();

	/**
	 *	Get the DoubleDef Table interface for the schema.
	 *
	 *	@return	The DoubleDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleDefTable getTableDoubleDef();

	/**
	 *	Get the DoubleDef Factory interface for the schema.
	 *
	 *	@return	The DoubleDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleDefFactory getFactoryDoubleDef();

	/**
	 *	Get the DoubleType Table interface for the schema.
	 *
	 *	@return	The DoubleType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleTypeTable getTableDoubleType();

	/**
	 *	Get the DoubleType Factory interface for the schema.
	 *
	 *	@return	The DoubleType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamDoubleTypeFactory getFactoryDoubleType();

	/**
	 *	Get the EnumDef Table interface for the schema.
	 *
	 *	@return	The EnumDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumDefTable getTableEnumDef();

	/**
	 *	Get the EnumDef Factory interface for the schema.
	 *
	 *	@return	The EnumDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumDefFactory getFactoryEnumDef();

	/**
	 *	Get the EnumTag Table interface for the schema.
	 *
	 *	@return	The EnumTag Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTagTable getTableEnumTag();

	/**
	 *	Get the EnumTag Factory interface for the schema.
	 *
	 *	@return	The EnumTag Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTagFactory getFactoryEnumTag();

	/**
	 *	Get the EnumType Table interface for the schema.
	 *
	 *	@return	The EnumType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTypeTable getTableEnumType();

	/**
	 *	Get the EnumType Factory interface for the schema.
	 *
	 *	@return	The EnumType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamEnumTypeFactory getFactoryEnumType();

	/**
	 *	Get the FloatCol Table interface for the schema.
	 *
	 *	@return	The FloatCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatColTable getTableFloatCol();

	/**
	 *	Get the FloatCol Factory interface for the schema.
	 *
	 *	@return	The FloatCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatColFactory getFactoryFloatCol();

	/**
	 *	Get the FloatDef Table interface for the schema.
	 *
	 *	@return	The FloatDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatDefTable getTableFloatDef();

	/**
	 *	Get the FloatDef Factory interface for the schema.
	 *
	 *	@return	The FloatDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatDefFactory getFactoryFloatDef();

	/**
	 *	Get the FloatType Table interface for the schema.
	 *
	 *	@return	The FloatType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatTypeTable getTableFloatType();

	/**
	 *	Get the FloatType Factory interface for the schema.
	 *
	 *	@return	The FloatType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamFloatTypeFactory getFactoryFloatType();

	/**
	 *	Get the HostNode Table interface for the schema.
	 *
	 *	@return	The HostNode Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNodeTable getTableHostNode();

	/**
	 *	Get the HostNode Factory interface for the schema.
	 *
	 *	@return	The HostNode Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecHostNodeFactory getFactoryHostNode();

	/**
	 *	Get the ISOCcy Table interface for the schema.
	 *
	 *	@return	The ISOCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcyTable getTableISOCcy();

	/**
	 *	Get the ISOCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCcy Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCcyFactory getFactoryISOCcy();

	/**
	 *	Get the ISOCtry Table interface for the schema.
	 *
	 *	@return	The ISOCtry Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryTable getTableISOCtry();

	/**
	 *	Get the ISOCtry Factory interface for the schema.
	 *
	 *	@return	The ISOCtry Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryFactory getFactoryISOCtry();

	/**
	 *	Get the ISOCtryCcy Table interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryCcyTable getTableISOCtryCcy();

	/**
	 *	Get the ISOCtryCcy Factory interface for the schema.
	 *
	 *	@return	The ISOCtryCcy Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryCcyFactory getFactoryISOCtryCcy();

	/**
	 *	Get the ISOCtryLang Table interface for the schema.
	 *
	 *	@return	The ISOCtryLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLangTable getTableISOCtryLang();

	/**
	 *	Get the ISOCtryLang Factory interface for the schema.
	 *
	 *	@return	The ISOCtryLang Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOCtryLangFactory getFactoryISOCtryLang();

	/**
	 *	Get the ISOLang Table interface for the schema.
	 *
	 *	@return	The ISOLang Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOLangTable getTableISOLang();

	/**
	 *	Get the ISOLang Factory interface for the schema.
	 *
	 *	@return	The ISOLang Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOLangFactory getFactoryISOLang();

	/**
	 *	Get the ISOTZone Table interface for the schema.
	 *
	 *	@return	The ISOTZone Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZoneTable getTableISOTZone();

	/**
	 *	Get the ISOTZone Factory interface for the schema.
	 *
	 *	@return	The ISOTZone Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecISOTZoneFactory getFactoryISOTZone();

	/**
	 *	Get the Id16Gen Table interface for the schema.
	 *
	 *	@return	The Id16Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId16GenTable getTableId16Gen();

	/**
	 *	Get the Id16Gen Factory interface for the schema.
	 *
	 *	@return	The Id16Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId16GenFactory getFactoryId16Gen();

	/**
	 *	Get the Id32Gen Table interface for the schema.
	 *
	 *	@return	The Id32Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId32GenTable getTableId32Gen();

	/**
	 *	Get the Id32Gen Factory interface for the schema.
	 *
	 *	@return	The Id32Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId32GenFactory getFactoryId32Gen();

	/**
	 *	Get the Id64Gen Table interface for the schema.
	 *
	 *	@return	The Id64Gen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId64GenTable getTableId64Gen();

	/**
	 *	Get the Id64Gen Factory interface for the schema.
	 *
	 *	@return	The Id64Gen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamId64GenFactory getFactoryId64Gen();

	/**
	 *	Get the Index Table interface for the schema.
	 *
	 *	@return	The Index Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexTable getTableIndex();

	/**
	 *	Get the Index Factory interface for the schema.
	 *
	 *	@return	The Index Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexFactory getFactoryIndex();

	/**
	 *	Get the IndexCol Table interface for the schema.
	 *
	 *	@return	The IndexCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexColTable getTableIndexCol();

	/**
	 *	Get the IndexCol Factory interface for the schema.
	 *
	 *	@return	The IndexCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamIndexColFactory getFactoryIndexCol();

	/**
	 *	Get the Int16Col Table interface for the schema.
	 *
	 *	@return	The Int16Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16ColTable getTableInt16Col();

	/**
	 *	Get the Int16Col Factory interface for the schema.
	 *
	 *	@return	The Int16Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16ColFactory getFactoryInt16Col();

	/**
	 *	Get the Int16Def Table interface for the schema.
	 *
	 *	@return	The Int16Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16DefTable getTableInt16Def();

	/**
	 *	Get the Int16Def Factory interface for the schema.
	 *
	 *	@return	The Int16Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16DefFactory getFactoryInt16Def();

	/**
	 *	Get the Int16Type Table interface for the schema.
	 *
	 *	@return	The Int16Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16TypeTable getTableInt16Type();

	/**
	 *	Get the Int16Type Factory interface for the schema.
	 *
	 *	@return	The Int16Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt16TypeFactory getFactoryInt16Type();

	/**
	 *	Get the Int32Col Table interface for the schema.
	 *
	 *	@return	The Int32Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32ColTable getTableInt32Col();

	/**
	 *	Get the Int32Col Factory interface for the schema.
	 *
	 *	@return	The Int32Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32ColFactory getFactoryInt32Col();

	/**
	 *	Get the Int32Def Table interface for the schema.
	 *
	 *	@return	The Int32Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32DefTable getTableInt32Def();

	/**
	 *	Get the Int32Def Factory interface for the schema.
	 *
	 *	@return	The Int32Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32DefFactory getFactoryInt32Def();

	/**
	 *	Get the Int32Type Table interface for the schema.
	 *
	 *	@return	The Int32Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32TypeTable getTableInt32Type();

	/**
	 *	Get the Int32Type Factory interface for the schema.
	 *
	 *	@return	The Int32Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt32TypeFactory getFactoryInt32Type();

	/**
	 *	Get the Int64Col Table interface for the schema.
	 *
	 *	@return	The Int64Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64ColTable getTableInt64Col();

	/**
	 *	Get the Int64Col Factory interface for the schema.
	 *
	 *	@return	The Int64Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64ColFactory getFactoryInt64Col();

	/**
	 *	Get the Int64Def Table interface for the schema.
	 *
	 *	@return	The Int64Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64DefTable getTableInt64Def();

	/**
	 *	Get the Int64Def Factory interface for the schema.
	 *
	 *	@return	The Int64Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64DefFactory getFactoryInt64Def();

	/**
	 *	Get the Int64Type Table interface for the schema.
	 *
	 *	@return	The Int64Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64TypeTable getTableInt64Type();

	/**
	 *	Get the Int64Type Factory interface for the schema.
	 *
	 *	@return	The Int64Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamInt64TypeFactory getFactoryInt64Type();

	/**
	 *	Get the License Table interface for the schema.
	 *
	 *	@return	The License Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntLicenseTable getTableLicense();

	/**
	 *	Get the License Factory interface for the schema.
	 *
	 *	@return	The License Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntLicenseFactory getFactoryLicense();

	/**
	 *	Get the MajorVersion Table interface for the schema.
	 *
	 *	@return	The MajorVersion Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMajorVersionTable getTableMajorVersion();

	/**
	 *	Get the MajorVersion Factory interface for the schema.
	 *
	 *	@return	The MajorVersion Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMajorVersionFactory getFactoryMajorVersion();

	/**
	 *	Get the MimeType Table interface for the schema.
	 *
	 *	@return	The MimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMimeTypeTable getTableMimeType();

	/**
	 *	Get the MimeType Factory interface for the schema.
	 *
	 *	@return	The MimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMimeTypeFactory getFactoryMimeType();

	/**
	 *	Get the MinorVersion Table interface for the schema.
	 *
	 *	@return	The MinorVersion Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMinorVersionTable getTableMinorVersion();

	/**
	 *	Get the MinorVersion Factory interface for the schema.
	 *
	 *	@return	The MinorVersion Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntMinorVersionFactory getFactoryMinorVersion();

	/**
	 *	Get the NmTokenCol Table interface for the schema.
	 *
	 *	@return	The NmTokenCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenColTable getTableNmTokenCol();

	/**
	 *	Get the NmTokenCol Factory interface for the schema.
	 *
	 *	@return	The NmTokenCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenColFactory getFactoryNmTokenCol();

	/**
	 *	Get the NmTokenDef Table interface for the schema.
	 *
	 *	@return	The NmTokenDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenDefTable getTableNmTokenDef();

	/**
	 *	Get the NmTokenDef Factory interface for the schema.
	 *
	 *	@return	The NmTokenDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenDefFactory getFactoryNmTokenDef();

	/**
	 *	Get the NmTokenType Table interface for the schema.
	 *
	 *	@return	The NmTokenType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenTypeTable getTableNmTokenType();

	/**
	 *	Get the NmTokenType Factory interface for the schema.
	 *
	 *	@return	The NmTokenType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokenTypeFactory getFactoryNmTokenType();

	/**
	 *	Get the NmTokensCol Table interface for the schema.
	 *
	 *	@return	The NmTokensCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensColTable getTableNmTokensCol();

	/**
	 *	Get the NmTokensCol Factory interface for the schema.
	 *
	 *	@return	The NmTokensCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensColFactory getFactoryNmTokensCol();

	/**
	 *	Get the NmTokensDef Table interface for the schema.
	 *
	 *	@return	The NmTokensDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensDefTable getTableNmTokensDef();

	/**
	 *	Get the NmTokensDef Factory interface for the schema.
	 *
	 *	@return	The NmTokensDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensDefFactory getFactoryNmTokensDef();

	/**
	 *	Get the NmTokensType Table interface for the schema.
	 *
	 *	@return	The NmTokensType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensTypeTable getTableNmTokensType();

	/**
	 *	Get the NmTokensType Factory interface for the schema.
	 *
	 *	@return	The NmTokensType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNmTokensTypeFactory getFactoryNmTokensType();

	/**
	 *	Get the NumberCol Table interface for the schema.
	 *
	 *	@return	The NumberCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberColTable getTableNumberCol();

	/**
	 *	Get the NumberCol Factory interface for the schema.
	 *
	 *	@return	The NumberCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberColFactory getFactoryNumberCol();

	/**
	 *	Get the NumberDef Table interface for the schema.
	 *
	 *	@return	The NumberDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberDefTable getTableNumberDef();

	/**
	 *	Get the NumberDef Factory interface for the schema.
	 *
	 *	@return	The NumberDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberDefFactory getFactoryNumberDef();

	/**
	 *	Get the NumberType Table interface for the schema.
	 *
	 *	@return	The NumberType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberTypeTable getTableNumberType();

	/**
	 *	Get the NumberType Factory interface for the schema.
	 *
	 *	@return	The NumberType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamNumberTypeFactory getFactoryNumberType();

	/**
	 *	Get the Param Table interface for the schema.
	 *
	 *	@return	The Param Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamParamTable getTableParam();

	/**
	 *	Get the Param Factory interface for the schema.
	 *
	 *	@return	The Param Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamParamFactory getFactoryParam();

	/**
	 *	Get the PopDep Table interface for the schema.
	 *
	 *	@return	The PopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopDepTable getTablePopDep();

	/**
	 *	Get the PopDep Factory interface for the schema.
	 *
	 *	@return	The PopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopDepFactory getFactoryPopDep();

	/**
	 *	Get the PopSubDep1 Table interface for the schema.
	 *
	 *	@return	The PopSubDep1 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep1Table getTablePopSubDep1();

	/**
	 *	Get the PopSubDep1 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep1 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep1Factory getFactoryPopSubDep1();

	/**
	 *	Get the PopSubDep2 Table interface for the schema.
	 *
	 *	@return	The PopSubDep2 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep2Table getTablePopSubDep2();

	/**
	 *	Get the PopSubDep2 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep2 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep2Factory getFactoryPopSubDep2();

	/**
	 *	Get the PopSubDep3 Table interface for the schema.
	 *
	 *	@return	The PopSubDep3 Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep3Table getTablePopSubDep3();

	/**
	 *	Get the PopSubDep3 Factory interface for the schema.
	 *
	 *	@return	The PopSubDep3 Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopSubDep3Factory getFactoryPopSubDep3();

	/**
	 *	Get the PopTopDep Table interface for the schema.
	 *
	 *	@return	The PopTopDep Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopTopDepTable getTablePopTopDep();

	/**
	 *	Get the PopTopDep Factory interface for the schema.
	 *
	 *	@return	The PopTopDep Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamPopTopDepFactory getFactoryPopTopDep();

	/**
	 *	Get the Relation Table interface for the schema.
	 *
	 *	@return	The Relation Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationTable getTableRelation();

	/**
	 *	Get the Relation Factory interface for the schema.
	 *
	 *	@return	The Relation Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationFactory getFactoryRelation();

	/**
	 *	Get the RelationCol Table interface for the schema.
	 *
	 *	@return	The RelationCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationColTable getTableRelationCol();

	/**
	 *	Get the RelationCol Factory interface for the schema.
	 *
	 *	@return	The RelationCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamRelationColFactory getFactoryRelationCol();

	/**
	 *	Get the SchemaDef Table interface for the schema.
	 *
	 *	@return	The SchemaDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaDefTable getTableSchemaDef();

	/**
	 *	Get the SchemaDef Factory interface for the schema.
	 *
	 *	@return	The SchemaDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaDefFactory getFactorySchemaDef();

	/**
	 *	Get the SchemaRef Table interface for the schema.
	 *
	 *	@return	The SchemaRef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaRefTable getTableSchemaRef();

	/**
	 *	Get the SchemaRef Factory interface for the schema.
	 *
	 *	@return	The SchemaRef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamSchemaRefFactory getFactorySchemaRef();

	/**
	 *	Get the Scope Table interface for the schema.
	 *
	 *	@return	The Scope Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamScopeTable getTableScope();

	/**
	 *	Get the Scope Factory interface for the schema.
	 *
	 *	@return	The Scope Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamScopeFactory getFactoryScope();

	/**
	 *	Get the SecApp Table interface for the schema.
	 *
	 *	@return	The SecApp Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecAppTable getTableSecApp();

	/**
	 *	Get the SecApp Factory interface for the schema.
	 *
	 *	@return	The SecApp Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecAppFactory getFactorySecApp();

	/**
	 *	Get the SecDevice Table interface for the schema.
	 *
	 *	@return	The SecDevice Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDeviceTable getTableSecDevice();

	/**
	 *	Get the SecDevice Factory interface for the schema.
	 *
	 *	@return	The SecDevice Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecDeviceFactory getFactorySecDevice();

	/**
	 *	Get the SecForm Table interface for the schema.
	 *
	 *	@return	The SecForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecFormTable getTableSecForm();

	/**
	 *	Get the SecForm Factory interface for the schema.
	 *
	 *	@return	The SecForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecFormFactory getFactorySecForm();

	/**
	 *	Get the SecGroup Table interface for the schema.
	 *
	 *	@return	The SecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroupTable getTableSecGroup();

	/**
	 *	Get the SecGroup Factory interface for the schema.
	 *
	 *	@return	The SecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroupFactory getFactorySecGroup();

	/**
	 *	Get the SecGroupForm Table interface for the schema.
	 *
	 *	@return	The SecGroupForm Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroupFormTable getTableSecGroupForm();

	/**
	 *	Get the SecGroupForm Factory interface for the schema.
	 *
	 *	@return	The SecGroupForm Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGroupFormFactory getFactorySecGroupForm();

	/**
	 *	Get the SecGrpInc Table interface for the schema.
	 *
	 *	@return	The SecGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpIncTable getTableSecGrpInc();

	/**
	 *	Get the SecGrpInc Factory interface for the schema.
	 *
	 *	@return	The SecGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpIncFactory getFactorySecGrpInc();

	/**
	 *	Get the SecGrpMemb Table interface for the schema.
	 *
	 *	@return	The SecGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMembTable getTableSecGrpMemb();

	/**
	 *	Get the SecGrpMemb Factory interface for the schema.
	 *
	 *	@return	The SecGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecGrpMembFactory getFactorySecGrpMemb();

	/**
	 *	Get the SecSession Table interface for the schema.
	 *
	 *	@return	The SecSession Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSessionTable getTableSecSession();

	/**
	 *	Get the SecSession Factory interface for the schema.
	 *
	 *	@return	The SecSession Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecSessionFactory getFactorySecSession();

	/**
	 *	Get the SecUser Table interface for the schema.
	 *
	 *	@return	The SecUser Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUserTable getTableSecUser();

	/**
	 *	Get the SecUser Factory interface for the schema.
	 *
	 *	@return	The SecUser Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSecUserFactory getFactorySecUser();

	/**
	 *	Get the ServerListFunc Table interface for the schema.
	 *
	 *	@return	The ServerListFunc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerListFuncTable getTableServerListFunc();

	/**
	 *	Get the ServerListFunc Factory interface for the schema.
	 *
	 *	@return	The ServerListFunc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerListFuncFactory getFactoryServerListFunc();

	/**
	 *	Get the ServerMethod Table interface for the schema.
	 *
	 *	@return	The ServerMethod Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerMethodTable getTableServerMethod();

	/**
	 *	Get the ServerMethod Factory interface for the schema.
	 *
	 *	@return	The ServerMethod Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerMethodFactory getFactoryServerMethod();

	/**
	 *	Get the ServerObjFunc Table interface for the schema.
	 *
	 *	@return	The ServerObjFunc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerObjFuncTable getTableServerObjFunc();

	/**
	 *	Get the ServerObjFunc Factory interface for the schema.
	 *
	 *	@return	The ServerObjFunc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerObjFuncFactory getFactoryServerObjFunc();

	/**
	 *	Get the ServerProc Table interface for the schema.
	 *
	 *	@return	The ServerProc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerProcTable getTableServerProc();

	/**
	 *	Get the ServerProc Factory interface for the schema.
	 *
	 *	@return	The ServerProc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamServerProcFactory getFactoryServerProc();

	/**
	 *	Get the Service Table interface for the schema.
	 *
	 *	@return	The Service Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecServiceTable getTableService();

	/**
	 *	Get the Service Factory interface for the schema.
	 *
	 *	@return	The Service Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecServiceFactory getFactoryService();

	/**
	 *	Get the ServiceType Table interface for the schema.
	 *
	 *	@return	The ServiceType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecServiceTypeTable getTableServiceType();

	/**
	 *	Get the ServiceType Factory interface for the schema.
	 *
	 *	@return	The ServiceType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecServiceTypeFactory getFactoryServiceType();

	/**
	 *	Get the StringCol Table interface for the schema.
	 *
	 *	@return	The StringCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringColTable getTableStringCol();

	/**
	 *	Get the StringCol Factory interface for the schema.
	 *
	 *	@return	The StringCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringColFactory getFactoryStringCol();

	/**
	 *	Get the StringDef Table interface for the schema.
	 *
	 *	@return	The StringDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringDefTable getTableStringDef();

	/**
	 *	Get the StringDef Factory interface for the schema.
	 *
	 *	@return	The StringDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringDefFactory getFactoryStringDef();

	/**
	 *	Get the StringType Table interface for the schema.
	 *
	 *	@return	The StringType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringTypeTable getTableStringType();

	/**
	 *	Get the StringType Factory interface for the schema.
	 *
	 *	@return	The StringType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamStringTypeFactory getFactoryStringType();

	/**
	 *	Get the SubProject Table interface for the schema.
	 *
	 *	@return	The SubProject Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntSubProjectTable getTableSubProject();

	/**
	 *	Get the SubProject Factory interface for the schema.
	 *
	 *	@return	The SubProject Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntSubProjectFactory getFactorySubProject();

	/**
	 *	Get the SysCluster Table interface for the schema.
	 *
	 *	@return	The SysCluster Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSysClusterTable getTableSysCluster();

	/**
	 *	Get the SysCluster Factory interface for the schema.
	 *
	 *	@return	The SysCluster Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecSysClusterFactory getFactorySysCluster();

	/**
	 *	Get the TSecGroup Table interface for the schema.
	 *
	 *	@return	The TSecGroup Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroupTable getTableTSecGroup();

	/**
	 *	Get the TSecGroup Factory interface for the schema.
	 *
	 *	@return	The TSecGroup Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGroupFactory getFactoryTSecGroup();

	/**
	 *	Get the TSecGrpInc Table interface for the schema.
	 *
	 *	@return	The TSecGrpInc Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpIncTable getTableTSecGrpInc();

	/**
	 *	Get the TSecGrpInc Factory interface for the schema.
	 *
	 *	@return	The TSecGrpInc Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpIncFactory getFactoryTSecGrpInc();

	/**
	 *	Get the TSecGrpMemb Table interface for the schema.
	 *
	 *	@return	The TSecGrpMemb Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMembTable getTableTSecGrpMemb();

	/**
	 *	Get the TSecGrpMemb Factory interface for the schema.
	 *
	 *	@return	The TSecGrpMemb Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTSecGrpMembFactory getFactoryTSecGrpMemb();

	/**
	 *	Get the TZDateCol Table interface for the schema.
	 *
	 *	@return	The TZDateCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateColTable getTableTZDateCol();

	/**
	 *	Get the TZDateCol Factory interface for the schema.
	 *
	 *	@return	The TZDateCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateColFactory getFactoryTZDateCol();

	/**
	 *	Get the TZDateDef Table interface for the schema.
	 *
	 *	@return	The TZDateDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateDefTable getTableTZDateDef();

	/**
	 *	Get the TZDateDef Factory interface for the schema.
	 *
	 *	@return	The TZDateDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateDefFactory getFactoryTZDateDef();

	/**
	 *	Get the TZDateType Table interface for the schema.
	 *
	 *	@return	The TZDateType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateTypeTable getTableTZDateType();

	/**
	 *	Get the TZDateType Factory interface for the schema.
	 *
	 *	@return	The TZDateType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZDateTypeFactory getFactoryTZDateType();

	/**
	 *	Get the TZTimeCol Table interface for the schema.
	 *
	 *	@return	The TZTimeCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeColTable getTableTZTimeCol();

	/**
	 *	Get the TZTimeCol Factory interface for the schema.
	 *
	 *	@return	The TZTimeCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeColFactory getFactoryTZTimeCol();

	/**
	 *	Get the TZTimeDef Table interface for the schema.
	 *
	 *	@return	The TZTimeDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeDefTable getTableTZTimeDef();

	/**
	 *	Get the TZTimeDef Factory interface for the schema.
	 *
	 *	@return	The TZTimeDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeDefFactory getFactoryTZTimeDef();

	/**
	 *	Get the TZTimeType Table interface for the schema.
	 *
	 *	@return	The TZTimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeTypeTable getTableTZTimeType();

	/**
	 *	Get the TZTimeType Factory interface for the schema.
	 *
	 *	@return	The TZTimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimeTypeFactory getFactoryTZTimeType();

	/**
	 *	Get the TZTimestampCol Table interface for the schema.
	 *
	 *	@return	The TZTimestampCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampColTable getTableTZTimestampCol();

	/**
	 *	Get the TZTimestampCol Factory interface for the schema.
	 *
	 *	@return	The TZTimestampCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampColFactory getFactoryTZTimestampCol();

	/**
	 *	Get the TZTimestampDef Table interface for the schema.
	 *
	 *	@return	The TZTimestampDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampDefTable getTableTZTimestampDef();

	/**
	 *	Get the TZTimestampDef Factory interface for the schema.
	 *
	 *	@return	The TZTimestampDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampDefFactory getFactoryTZTimestampDef();

	/**
	 *	Get the TZTimestampType Table interface for the schema.
	 *
	 *	@return	The TZTimestampType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampTypeTable getTableTZTimestampType();

	/**
	 *	Get the TZTimestampType Factory interface for the schema.
	 *
	 *	@return	The TZTimestampType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTZTimestampTypeFactory getFactoryTZTimestampType();

	/**
	 *	Get the Table Table interface for the schema.
	 *
	 *	@return	The Table Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableTable getTableTable();

	/**
	 *	Get the Table Factory interface for the schema.
	 *
	 *	@return	The Table Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableFactory getFactoryTable();

	/**
	 *	Get the TableCol Table interface for the schema.
	 *
	 *	@return	The TableCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableColTable getTableTableCol();

	/**
	 *	Get the TableCol Factory interface for the schema.
	 *
	 *	@return	The TableCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTableColFactory getFactoryTableCol();

	/**
	 *	Get the Tenant Table interface for the schema.
	 *
	 *	@return	The Tenant Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTenantTable getTableTenant();

	/**
	 *	Get the Tenant Factory interface for the schema.
	 *
	 *	@return	The Tenant Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFSecTenantFactory getFactoryTenant();

	/**
	 *	Get the TextCol Table interface for the schema.
	 *
	 *	@return	The TextCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextColTable getTableTextCol();

	/**
	 *	Get the TextCol Factory interface for the schema.
	 *
	 *	@return	The TextCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextColFactory getFactoryTextCol();

	/**
	 *	Get the TextDef Table interface for the schema.
	 *
	 *	@return	The TextDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextDefTable getTableTextDef();

	/**
	 *	Get the TextDef Factory interface for the schema.
	 *
	 *	@return	The TextDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextDefFactory getFactoryTextDef();

	/**
	 *	Get the TextType Table interface for the schema.
	 *
	 *	@return	The TextType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextTypeTable getTableTextType();

	/**
	 *	Get the TextType Factory interface for the schema.
	 *
	 *	@return	The TextType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTextTypeFactory getFactoryTextType();

	/**
	 *	Get the TimeCol Table interface for the schema.
	 *
	 *	@return	The TimeCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeColTable getTableTimeCol();

	/**
	 *	Get the TimeCol Factory interface for the schema.
	 *
	 *	@return	The TimeCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeColFactory getFactoryTimeCol();

	/**
	 *	Get the TimeDef Table interface for the schema.
	 *
	 *	@return	The TimeDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeDefTable getTableTimeDef();

	/**
	 *	Get the TimeDef Factory interface for the schema.
	 *
	 *	@return	The TimeDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeDefFactory getFactoryTimeDef();

	/**
	 *	Get the TimeType Table interface for the schema.
	 *
	 *	@return	The TimeType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeTypeTable getTableTimeType();

	/**
	 *	Get the TimeType Factory interface for the schema.
	 *
	 *	@return	The TimeType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimeTypeFactory getFactoryTimeType();

	/**
	 *	Get the TimestampCol Table interface for the schema.
	 *
	 *	@return	The TimestampCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampColTable getTableTimestampCol();

	/**
	 *	Get the TimestampCol Factory interface for the schema.
	 *
	 *	@return	The TimestampCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampColFactory getFactoryTimestampCol();

	/**
	 *	Get the TimestampDef Table interface for the schema.
	 *
	 *	@return	The TimestampDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampDefTable getTableTimestampDef();

	/**
	 *	Get the TimestampDef Factory interface for the schema.
	 *
	 *	@return	The TimestampDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampDefFactory getFactoryTimestampDef();

	/**
	 *	Get the TimestampType Table interface for the schema.
	 *
	 *	@return	The TimestampType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampTypeTable getTableTimestampType();

	/**
	 *	Get the TimestampType Factory interface for the schema.
	 *
	 *	@return	The TimestampType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTimestampTypeFactory getFactoryTimestampType();

	/**
	 *	Get the Tld Table interface for the schema.
	 *
	 *	@return	The Tld Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTldTable getTableTld();

	/**
	 *	Get the Tld Factory interface for the schema.
	 *
	 *	@return	The Tld Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTldFactory getFactoryTld();

	/**
	 *	Get the TokenCol Table interface for the schema.
	 *
	 *	@return	The TokenCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenColTable getTableTokenCol();

	/**
	 *	Get the TokenCol Factory interface for the schema.
	 *
	 *	@return	The TokenCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenColFactory getFactoryTokenCol();

	/**
	 *	Get the TokenDef Table interface for the schema.
	 *
	 *	@return	The TokenDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenDefTable getTableTokenDef();

	/**
	 *	Get the TokenDef Factory interface for the schema.
	 *
	 *	@return	The TokenDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenDefFactory getFactoryTokenDef();

	/**
	 *	Get the TokenType Table interface for the schema.
	 *
	 *	@return	The TokenType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenTypeTable getTableTokenType();

	/**
	 *	Get the TokenType Factory interface for the schema.
	 *
	 *	@return	The TokenType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamTokenTypeFactory getFactoryTokenType();

	/**
	 *	Get the TopDomain Table interface for the schema.
	 *
	 *	@return	The TopDomain Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTopDomainTable getTableTopDomain();

	/**
	 *	Get the TopDomain Factory interface for the schema.
	 *
	 *	@return	The TopDomain Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTopDomainFactory getFactoryTopDomain();

	/**
	 *	Get the TopProject Table interface for the schema.
	 *
	 *	@return	The TopProject Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTopProjectTable getTableTopProject();

	/**
	 *	Get the TopProject Factory interface for the schema.
	 *
	 *	@return	The TopProject Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntTopProjectFactory getFactoryTopProject();

	/**
	 *	Get the UInt16Col Table interface for the schema.
	 *
	 *	@return	The UInt16Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16ColTable getTableUInt16Col();

	/**
	 *	Get the UInt16Col Factory interface for the schema.
	 *
	 *	@return	The UInt16Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16ColFactory getFactoryUInt16Col();

	/**
	 *	Get the UInt16Def Table interface for the schema.
	 *
	 *	@return	The UInt16Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16DefTable getTableUInt16Def();

	/**
	 *	Get the UInt16Def Factory interface for the schema.
	 *
	 *	@return	The UInt16Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16DefFactory getFactoryUInt16Def();

	/**
	 *	Get the UInt16Type Table interface for the schema.
	 *
	 *	@return	The UInt16Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16TypeTable getTableUInt16Type();

	/**
	 *	Get the UInt16Type Factory interface for the schema.
	 *
	 *	@return	The UInt16Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt16TypeFactory getFactoryUInt16Type();

	/**
	 *	Get the UInt32Col Table interface for the schema.
	 *
	 *	@return	The UInt32Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32ColTable getTableUInt32Col();

	/**
	 *	Get the UInt32Col Factory interface for the schema.
	 *
	 *	@return	The UInt32Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32ColFactory getFactoryUInt32Col();

	/**
	 *	Get the UInt32Def Table interface for the schema.
	 *
	 *	@return	The UInt32Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32DefTable getTableUInt32Def();

	/**
	 *	Get the UInt32Def Factory interface for the schema.
	 *
	 *	@return	The UInt32Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32DefFactory getFactoryUInt32Def();

	/**
	 *	Get the UInt32Type Table interface for the schema.
	 *
	 *	@return	The UInt32Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32TypeTable getTableUInt32Type();

	/**
	 *	Get the UInt32Type Factory interface for the schema.
	 *
	 *	@return	The UInt32Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt32TypeFactory getFactoryUInt32Type();

	/**
	 *	Get the UInt64Col Table interface for the schema.
	 *
	 *	@return	The UInt64Col Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64ColTable getTableUInt64Col();

	/**
	 *	Get the UInt64Col Factory interface for the schema.
	 *
	 *	@return	The UInt64Col Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64ColFactory getFactoryUInt64Col();

	/**
	 *	Get the UInt64Def Table interface for the schema.
	 *
	 *	@return	The UInt64Def Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64DefTable getTableUInt64Def();

	/**
	 *	Get the UInt64Def Factory interface for the schema.
	 *
	 *	@return	The UInt64Def Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64DefFactory getFactoryUInt64Def();

	/**
	 *	Get the UInt64Type Table interface for the schema.
	 *
	 *	@return	The UInt64Type Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64TypeTable getTableUInt64Type();

	/**
	 *	Get the UInt64Type Factory interface for the schema.
	 *
	 *	@return	The UInt64Type Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUInt64TypeFactory getFactoryUInt64Type();

	/**
	 *	Get the URLProtocol Table interface for the schema.
	 *
	 *	@return	The URLProtocol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntURLProtocolTable getTableURLProtocol();

	/**
	 *	Get the URLProtocol Factory interface for the schema.
	 *
	 *	@return	The URLProtocol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFIntURLProtocolFactory getFactoryURLProtocol();

	/**
	 *	Get the UuidCol Table interface for the schema.
	 *
	 *	@return	The UuidCol Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidColTable getTableUuidCol();

	/**
	 *	Get the UuidCol Factory interface for the schema.
	 *
	 *	@return	The UuidCol Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidColFactory getFactoryUuidCol();

	/**
	 *	Get the UuidDef Table interface for the schema.
	 *
	 *	@return	The UuidDef Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidDefTable getTableUuidDef();

	/**
	 *	Get the UuidDef Factory interface for the schema.
	 *
	 *	@return	The UuidDef Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidDefFactory getFactoryUuidDef();

	/**
	 *	Get the UuidGen Table interface for the schema.
	 *
	 *	@return	The UuidGen Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidGenTable getTableUuidGen();

	/**
	 *	Get the UuidGen Factory interface for the schema.
	 *
	 *	@return	The UuidGen Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidGenFactory getFactoryUuidGen();

	/**
	 *	Get the UuidType Table interface for the schema.
	 *
	 *	@return	The UuidType Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidTypeTable getTableUuidType();

	/**
	 *	Get the UuidType Factory interface for the schema.
	 *
	 *	@return	The UuidType Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamUuidTypeFactory getFactoryUuidType();

	/**
	 *	Get the Value Table interface for the schema.
	 *
	 *	@return	The Value Table interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamValueTable getTableValue();

	/**
	 *	Get the Value Factory interface for the schema.
	 *
	 *	@return	The Value Factory interface for the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	ICFBamValueFactory getFactoryValue();

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
	ICFSecTablePerms getTablePerms();

	/**
	 *	Set the Table Permissions interface for the schema.
	 *
	 *	@param	value	The Table Permissions interface to be used by the schema.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void setTablePerms( ICFSecTablePerms value );

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
