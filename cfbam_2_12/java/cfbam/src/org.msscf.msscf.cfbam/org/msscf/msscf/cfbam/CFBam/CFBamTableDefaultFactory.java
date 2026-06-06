
// Description: Java 11 Default Factory implementation for Table.

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
	 *	CFBamTableFactory implementation for Table
	 */
public class CFBamTableDefaultFactory
	implements ICFBamTableFactory
{
	public CFBamTableDefaultFactory() {
	}

	public CFBamTableBySchemaDefIdxKey newSchemaDefIdxKey() {
		CFBamTableBySchemaDefIdxKey key =
			new CFBamTableBySchemaDefIdxKey();
		return( key );
	}

	public CFBamTableByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamTableByDefSchemaIdxKey key =
			new CFBamTableByDefSchemaIdxKey();
		return( key );
	}

	public CFBamTableByUNameIdxKey newUNameIdxKey() {
		CFBamTableByUNameIdxKey key =
			new CFBamTableByUNameIdxKey();
		return( key );
	}

	public CFBamTableBySchemaCdIdxKey newSchemaCdIdxKey() {
		CFBamTableBySchemaCdIdxKey key =
			new CFBamTableBySchemaCdIdxKey();
		return( key );
	}

	public CFBamTableByPrimaryIndexIdxKey newPrimaryIndexIdxKey() {
		CFBamTableByPrimaryIndexIdxKey key =
			new CFBamTableByPrimaryIndexIdxKey();
		return( key );
	}

	public CFBamTableByLookupIndexIdxKey newLookupIndexIdxKey() {
		CFBamTableByLookupIndexIdxKey key =
			new CFBamTableByLookupIndexIdxKey();
		return( key );
	}

	public CFBamTableByAltIndexIdxKey newAltIndexIdxKey() {
		CFBamTableByAltIndexIdxKey key =
			new CFBamTableByAltIndexIdxKey();
		return( key );
	}

	public CFBamTableByQualTableIdxKey newQualTableIdxKey() {
		CFBamTableByQualTableIdxKey key =
			new CFBamTableByQualTableIdxKey();
		return( key );
	}

	public CFBamTableBuff newBuff() {
		CFBamTableBuff buff =
			new CFBamTableBuff();
		return( buff );
	}

	public CFBamTableHBuff newHBuff() {
		CFBamTableHBuff hbuff =
			new CFBamTableHBuff();
		return( hbuff );
	}
}
