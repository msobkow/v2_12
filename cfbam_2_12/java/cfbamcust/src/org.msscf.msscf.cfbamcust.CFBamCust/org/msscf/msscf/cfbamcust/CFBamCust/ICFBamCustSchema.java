// Description: Java 13 Cust JavaFX Schema Interface.

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

import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;

/**
 *	The ICFBamSwingSchema defines the interface for the shared schema
 *	object that is bound to a client.  The various implementations of
 *	facets cast the shared CFBamSchemaObj as required to access their
 *	data.
 *	<p>
 *	The formats of the configuration files don't change between applications,
 *	so only the CFBam-specified implementation is used.  It has all the
 *	attributes needed to set up client-server database connections (not that I
 *	code to that style any more.)
 */
public interface ICFBamCustSchema
extends ICFIntCustSchema
{
	CFBamCustFacetPane newBamFacetPane( ICFFormManager formManager );
	CFBamCustFacetPane newBamFacetPane( ICFFormManager formManager, ICFBamCustSchema argSchema );
}
