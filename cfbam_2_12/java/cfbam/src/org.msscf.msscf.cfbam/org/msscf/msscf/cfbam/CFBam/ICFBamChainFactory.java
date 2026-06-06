
// Description: Java 11 Factory interface for Chain.

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamChainFactory interface for Chain
 */
public interface ICFBamChainFactory
{

	/**
	 *	Allocate a primary key for Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainPKey newPKey();

	/**
	 *	Allocate a primary history key for Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainHPKey newHPKey();

	/**
	 *	Allocate a TenantIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByTenantIdxKey newTenantIdxKey();

	/**
	 *	Allocate a ChainTableIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByChainTableIdxKey newChainTableIdxKey();

	/**
	 *	Allocate a DefSchemaIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByDefSchemaIdxKey newDefSchemaIdxKey();

	/**
	 *	Allocate a UNameIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a PrevRelIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByPrevRelIdxKey newPrevRelIdxKey();

	/**
	 *	Allocate a NextRelIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainByNextRelIdxKey newNextRelIdxKey();

	/**
	 *	Allocate a Chain instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainBuff newBuff();

	/**
	 *	Allocate a Chain history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFBamChainHBuff newHBuff();

}
