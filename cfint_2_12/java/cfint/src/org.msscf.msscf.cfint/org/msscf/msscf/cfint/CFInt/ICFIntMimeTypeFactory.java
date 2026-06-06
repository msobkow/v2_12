
// Description: Java 11 Factory interface for MimeType.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

/*
 *	CFIntMimeTypeFactory interface for MimeType
 */
public interface ICFIntMimeTypeFactory
{

	/**
	 *	Allocate a primary key for MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntMimeTypePKey newPKey();

	/**
	 *	Allocate a primary history key for MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntMimeTypeHPKey newHPKey();

	/**
	 *	Allocate a UNameIdx key over MimeType instances.
	 *
	 *	@return	The new instance.
	 */
	CFIntMimeTypeByUNameIdxKey newUNameIdxKey();

	/**
	 *	Allocate a MimeType instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFIntMimeTypeBuff newBuff();

	/**
	 *	Allocate a MimeType history instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFIntMimeTypeHBuff newHBuff();

}
