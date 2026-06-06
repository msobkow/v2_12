
// Description: Java 11 Factory interface for Relation.

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamRelationFactory interface for Relation
 */
public interface ICFBamRelationFactory
{

	/**
	 *	Allocate a UNameIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a RelnTenantIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByRelnTenantIdxKey newRelnTenantIdxKey();

	/**
	 *	Allocate a RelTableIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByRelTableIdxKey newRelTableIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a FromKeyIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByFromKeyIdxKey newFromKeyIdxKey();

	/**
	 *	Allocate a ToTblIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByToTblIdxKey newToTblIdxKey();

	/**
	 *	Allocate a ToKeyIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByToKeyIdxKey newToKeyIdxKey();

	/**
	 *	Allocate a NarrowedIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationByNarrowedIdxKey newNarrowedIdxKey();

	/**
	 *	Allocate a Relation instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationBuff newBuff();

	/**
	 *	Allocate a Relation history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamRelationHBuff newHBuff();

}
