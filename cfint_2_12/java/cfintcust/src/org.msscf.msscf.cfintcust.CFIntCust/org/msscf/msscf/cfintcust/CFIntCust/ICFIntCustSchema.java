// Description: Java 13 Cust JavaFX Schema Interface.

/*
 *	CF Int Cust JavaFX Implementation
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

package org.msscf.msscf.cfintcust.CFIntCust;

import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;

/**
 *	The ICFIntSwingSchema defines the interface for the shared schema
 *	object that is bound to a client.  The various implementations of
 *	facets cast the shared CFIntSchemaObj as required to access their
 *	data.
 *	<p>
 *	The formats of the configuration files don't change between applications,
 *	so only the CFInt-specified implementation is used.  It has all the
 *	attributes needed to set up client-server database connections (not that I
 *	code to that style any more.)
 */
public interface ICFIntCustSchema
extends ICFSecCustSchema
{
	CFIntCustFacetPane newIntFacetPane( ICFFormManager formManager );
	CFIntCustFacetPane newIntFacetPane( ICFFormManager formManager, ICFIntCustSchema argSchema );
}
