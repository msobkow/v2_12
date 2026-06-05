// Description: Java 11 Schema Object interface for CFInt.

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

public interface ICFIntSchemaObj
	extends ICFSecSchemaObj
{
	/**
	 *	Get the License interface for the schema.
	 *
	 *	@return	The ICFIntLicenseTableObj interface implementation for the schema.
	 */
	ICFIntLicenseTableObj getLicenseTableObj();

	/**
	 *	Get the MajorVersion interface for the schema.
	 *
	 *	@return	The ICFIntMajorVersionTableObj interface implementation for the schema.
	 */
	ICFIntMajorVersionTableObj getMajorVersionTableObj();

	/**
	 *	Get the MimeType interface for the schema.
	 *
	 *	@return	The ICFIntMimeTypeTableObj interface implementation for the schema.
	 */
	ICFIntMimeTypeTableObj getMimeTypeTableObj();

	/**
	 *	Get the MinorVersion interface for the schema.
	 *
	 *	@return	The ICFIntMinorVersionTableObj interface implementation for the schema.
	 */
	ICFIntMinorVersionTableObj getMinorVersionTableObj();

	/**
	 *	Get the SubProject interface for the schema.
	 *
	 *	@return	The ICFIntSubProjectTableObj interface implementation for the schema.
	 */
	ICFIntSubProjectTableObj getSubProjectTableObj();

	/**
	 *	Get the Tld interface for the schema.
	 *
	 *	@return	The ICFIntTldTableObj interface implementation for the schema.
	 */
	ICFIntTldTableObj getTldTableObj();

	/**
	 *	Get the TopDomain interface for the schema.
	 *
	 *	@return	The ICFIntTopDomainTableObj interface implementation for the schema.
	 */
	ICFIntTopDomainTableObj getTopDomainTableObj();

	/**
	 *	Get the TopProject interface for the schema.
	 *
	 *	@return	The ICFIntTopProjectTableObj interface implementation for the schema.
	 */
	ICFIntTopProjectTableObj getTopProjectTableObj();

	/**
	 *	Get the URLProtocol interface for the schema.
	 *
	 *	@return	The ICFIntURLProtocolTableObj interface implementation for the schema.
	 */
	ICFIntURLProtocolTableObj getURLProtocolTableObj();
}
