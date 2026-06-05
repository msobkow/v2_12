// Description: Java 13 Cust JavaFX Schema Interface.

/*
 *	CF Sec Cust JavaFX Implementation
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
 */

package org.msscf.msscf.cfseccust.CFSecCust;

import java.security.KeyStore;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfsec.CFSecObj.*;

/**
 *	The ICFSecSwingSchema defines the interface for the shared schema
 *	object that is bound to a client.  The various implementations of
 *	facets cast the shared CFSecSchemaObj as required to access their
 *	data.
 *	<p>
 *	The formats of the configuration files don't change between applications,
 *	so only the CFSec-specified implementation is used.  It has all the
 *	attributes needed to set up client-server database connections (not that I
 *	code to that style any more.)
 */
public interface ICFSecCustSchema
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

	ICFSecJavaFXSchema getJavaFXSchema();
	void setJavaFXSchema( ICFSecJavaFXSchema value );

	CFSecCustFacetPane getSingletonSecFacetPane( ICFFormManager formManager );
	CFSecCustFacetPane getSingletonSecFacetPane( ICFFormManager formManager, ICFSecCustSchema argSchema );
	CFSecCustFacetPane newSecFacetPane( ICFFormManager formManager );
	CFSecCustFacetPane newSecFacetPane( ICFFormManager formManager, ICFSecCustSchema argSchema );
	CFBorderPane newManageClusterSecGroupPane( ICFFormManager formManager );
	CFBorderPane newManageClusterSecGroupPane( ICFFormManager formManager, ICFSecCustSchema argSchema );
	CFBorderPane newManageClusterSecGroupForm( ICFFormManager formManager );
	CFBorderPane newManageClusterSecGroupForm( ICFFormManager formManager, ICFSecCustSchema argSchema );
	CFBorderPane newManageTenantTSecGroupPane( ICFFormManager formManager );
	CFBorderPane newManageTenantTSecGroupPane( ICFFormManager formManager, ICFSecCustSchema argSchema );
	CFBorderPane newManageTenantTSecGroupForm( ICFFormManager formManager );
	CFBorderPane newManageTenantTSecGroupForm( ICFFormManager formManager, ICFSecCustSchema argSchema );
}
