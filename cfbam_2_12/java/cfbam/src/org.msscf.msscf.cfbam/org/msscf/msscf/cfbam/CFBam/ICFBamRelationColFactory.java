
// Description: Java 11 Factory interface for RelationCol.

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
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

/*
 *	CFBamRelationColFactory interface for RelationCol
 */
public interface ICFBamRelationColFactory
{

	/**
	 *	Allocate a primary key for RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColPKey newPKey();

	/**
	 *	Allocate a primary history key for RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColHPKey newHPKey();

	/**
	 *	Allocate a UNameIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a RelColTenantIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByRelColTenantIdxKey newRelColTenantIdxKey();

	/**
	 *	Allocate a RelationIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByRelationIdxKey newRelationIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a FromColIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByFromColIdxKey newFromColIdxKey();

	/**
	 *	Allocate a ToColIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByToColIdxKey newToColIdxKey();

	/**
	 *	Allocate a PrevIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByPrevIdxKey newPrevIdxKey();

	/**
	 *	Allocate a NextIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByNextIdxKey newNextIdxKey();

	/**
	 *	Allocate a RelPrevIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByRelPrevIdxKey newRelPrevIdxKey();

	/**
	 *	Allocate a RelNextIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColByRelNextIdxKey newRelNextIdxKey();

	/**
	 *	Allocate a RelationCol instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColBuff newBuff();

	/**
	 *	Allocate a RelationCol history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationColHBuff newHBuff();

}
