// Description: Java 13 Cust JavaFX Schema.

/*
 *  MSS Code Factory CFBam 2.12 Cust
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

package org.msscf.msscf.cfbamcust.CFBamCust;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;
import org.msscf.msscf.cfbam.CFBamJavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/**
 *	The CFBamCustSchema defines the interface object that is
 *	provided by the cust interface for manipulating the CFBam
 *	facet in the user interface.
 */
public class CFBamCustSchema
extends CFBamJavaFXSchema
implements ICFBamCustSchema
{
	public CFBamCustSchema() {
		super();
	}

	public ICFBamSchemaObj getCFBamSchema() {
		return( (ICFBamSchemaObj)schema );
	}

	protected ICFSecJavaFXSchema javafxSchema = null;

	public ICFSecJavaFXSchema getJavaFXSchema() {
		if( javafxSchema == null ) {
			javafxSchema = this;
		}
		return( javafxSchema );
	}

	public void setJavaFXSchema( ICFSecJavaFXSchema value ) {
		final String S_ProcName = "setJavaFXSchema";
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		javafxSchema = value;
	}

	@Override public ICFSecJavaFXSecGroupFactory getSecGroupFactory() {
		if( factorySecGroup == null ) {
			factorySecGroup = new CFSecCustSecGroupFactory( this );
		}
		return( factorySecGroup );
	}

	@Override public ICFSecJavaFXTSecGroupFactory getTSecGroupFactory() {
		if( factoryTSecGroup == null ) {
			factoryTSecGroup = new CFSecCustTSecGroupFactory( this );
		}
		return( factoryTSecGroup );
	}

	protected volatile static CFSecCustFacetPane S_singletonSecFacetPane = null;

	public CFSecCustFacetPane getSingletonSecFacetPane( ICFFormManager formManager ) {
		CFSecCustFacetPane pane = getSingletonSecFacetPane( formManager, this );
		return( pane );
	}

	public CFSecCustFacetPane getSingletonSecFacetPane( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		if( S_singletonSecFacetPane == null ) {
			S_singletonSecFacetPane = newSecFacetPane( formManager, argSchema );
		}
		return( S_singletonSecFacetPane );
	}

	public CFSecCustFacetPane newSecFacetPane( ICFFormManager formManager ) {
		CFSecCustFacetPane pane = newSecFacetPane( formManager, this );
		return( pane );
	}

	public CFSecCustFacetPane newSecFacetPane( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		CFSecCustFacetPane pane = new CFSecCustFacetPane( formManager, argSchema );
		return( pane );
	}

	public CFBorderPane newManageClusterSecGroupForm( ICFFormManager formManager ) {
		CFBorderPane pane = new CFSecCustManageClusterSecGroupForm( formManager, this );
		return( pane );
	}

	public CFBorderPane newManageClusterSecGroupForm( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		CFBorderPane pane = new CFSecCustManageClusterSecGroupForm( formManager, argSchema );
		return( pane );
	}

	public CFBorderPane newManageClusterSecGroupPane( ICFFormManager formManager ) {
		CFBorderPane pane = new CFSecCustManageClusterSecGroupPane( formManager, this );
		return( pane );
	}

	public CFBorderPane newManageClusterSecGroupPane( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		CFBorderPane pane = new CFSecCustManageClusterSecGroupPane( formManager, argSchema );
		return( pane );
	}

	public CFBorderPane newManageTenantTSecGroupForm( ICFFormManager formManager ) {
		CFBorderPane pane = new CFSecCustManageTenantTSecGroupForm( formManager, this );
		return( pane );
	}

	public CFBorderPane newManageTenantTSecGroupForm( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		CFBorderPane pane = new CFSecCustManageTenantTSecGroupForm( formManager, argSchema );
		return( pane );
	}

	public CFBorderPane newManageTenantTSecGroupPane( ICFFormManager formManager ) {
		CFBorderPane pane = new CFSecCustManageTenantTSecGroupPane( formManager, this );
		return( pane );
	}

	public CFBorderPane newManageTenantTSecGroupPane( ICFFormManager formManager, ICFSecCustSchema argSchema ) {
		CFBorderPane pane = new CFSecCustManageTenantTSecGroupPane( formManager, argSchema );
		return( pane );
	}

	public CFBamCustFacetPane newBamFacetPane( ICFFormManager formManager ) {
		CFBamCustFacetPane pane = newBamFacetPane( formManager, this );
		return( pane );
	}

	public CFBamCustFacetPane newBamFacetPane( ICFFormManager formManager, ICFBamCustSchema argSchema ) {
		CFBamCustFacetPane pane = new CFBamCustFacetPane( formManager, argSchema );
		return( pane );
	}

	public ICFIntSchemaObj getCFIntSchema() {
		return( (ICFIntSchemaObj)schema );
	}

	public CFIntCustFacetPane newIntFacetPane( ICFFormManager formManager ) {
		CFIntCustFacetPane pane = newIntFacetPane( formManager, this );
		return( pane );
	}

	public CFIntCustFacetPane newIntFacetPane( ICFFormManager formManager, ICFIntCustSchema argSchema ) {
		CFIntCustFacetPane pane = new CFIntCustFacetPane( formManager, argSchema );
		return( pane );
	}
}
