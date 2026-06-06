// Description: Java 11 JavaFX Schema Interface for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.security.KeyStore;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;

/**
 *	The ICFSecJavaFXSchema defines the factory interface for the
 *	for the various panes and components used to construct a GUI interface
 *	using the JavaFX framework.
 */
public interface ICFSecJavaFXSchema
{
	CFSecClientConfigurationFile getClientConfigurationFile();
	void setClientConfigurationFile( CFSecClientConfigurationFile value );

	KeyStore getKeyStore();
	void setKeyStore( KeyStore value );

	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj argSchema );

	String getClusterName();
	void setClusterName( String argClusterName );
	ICFSecClusterObj getClusterObj();

	String getTenantName();
	void setTenantName( String argTenantName );
	ICFSecTenantObj getTenantObj();

	String getSecUserName();
	void setSecUserName( String argSecUserName );
	ICFSecSecUserObj getSecUserObj();

	ICFSecSecSessionObj getSecSessionObj();

	public ICFSecJavaFXClusterFactory getClusterFactory();

	public ICFSecJavaFXHostNodeFactory getHostNodeFactory();

	public ICFSecJavaFXISOCcyFactory getISOCcyFactory();

	public ICFSecJavaFXISOCtryFactory getISOCtryFactory();

	public ICFSecJavaFXISOCtryCcyFactory getISOCtryCcyFactory();

	public ICFSecJavaFXISOCtryLangFactory getISOCtryLangFactory();

	public ICFSecJavaFXISOLangFactory getISOLangFactory();

	public ICFSecJavaFXISOTZoneFactory getISOTZoneFactory();

	public ICFSecJavaFXSecAppFactory getSecAppFactory();

	public ICFSecJavaFXSecDeviceFactory getSecDeviceFactory();

	public ICFSecJavaFXSecFormFactory getSecFormFactory();

	public ICFSecJavaFXSecGroupFactory getSecGroupFactory();

	public ICFSecJavaFXSecGroupFormFactory getSecGroupFormFactory();

	public ICFSecJavaFXSecGrpIncFactory getSecGrpIncFactory();

	public ICFSecJavaFXSecGrpMembFactory getSecGrpMembFactory();

	public ICFSecJavaFXSecSessionFactory getSecSessionFactory();

	public ICFSecJavaFXSecUserFactory getSecUserFactory();

	public ICFSecJavaFXServiceFactory getServiceFactory();

	public ICFSecJavaFXServiceTypeFactory getServiceTypeFactory();

	public ICFSecJavaFXSysClusterFactory getSysClusterFactory();

	public ICFSecJavaFXTSecGroupFactory getTSecGroupFactory();

	public ICFSecJavaFXTSecGrpIncFactory getTSecGrpIncFactory();

	public ICFSecJavaFXTSecGrpMembFactory getTSecGrpMembFactory();

	public ICFSecJavaFXTenantFactory getTenantFactory();
}
