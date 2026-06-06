
// Description: Java 11 Default Factory implementation for EnumTag.

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
	 *	CFBamEnumTagFactory implementation for EnumTag
	 */
public class CFBamEnumTagDefaultFactory
	implements ICFBamEnumTagFactory
{
	public CFBamEnumTagDefaultFactory() {
	}

	public CFBamEnumTagPKey newPKey() {
		CFBamEnumTagPKey pkey =
			new CFBamEnumTagPKey();
		return( pkey );
	}

	public CFBamEnumTagHPKey newHPKey() {
		CFBamEnumTagHPKey hpkey =
			new CFBamEnumTagHPKey();
		return( hpkey );
	}

	public CFBamEnumTagByEnumTagTenantIdxKey newEnumTagTenantIdxKey() {
		CFBamEnumTagByEnumTagTenantIdxKey key =
			new CFBamEnumTagByEnumTagTenantIdxKey();
		return( key );
	}

	public CFBamEnumTagByEnumIdxKey newEnumIdxKey() {
		CFBamEnumTagByEnumIdxKey key =
			new CFBamEnumTagByEnumIdxKey();
		return( key );
	}

	public CFBamEnumTagByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamEnumTagByDefSchemaIdxKey key =
			new CFBamEnumTagByDefSchemaIdxKey();
		return( key );
	}

	public CFBamEnumTagByEnumNameIdxKey newEnumNameIdxKey() {
		CFBamEnumTagByEnumNameIdxKey key =
			new CFBamEnumTagByEnumNameIdxKey();
		return( key );
	}

	public CFBamEnumTagByPrevIdxKey newPrevIdxKey() {
		CFBamEnumTagByPrevIdxKey key =
			new CFBamEnumTagByPrevIdxKey();
		return( key );
	}

	public CFBamEnumTagByNextIdxKey newNextIdxKey() {
		CFBamEnumTagByNextIdxKey key =
			new CFBamEnumTagByNextIdxKey();
		return( key );
	}

	public CFBamEnumTagBuff newBuff() {
		CFBamEnumTagBuff buff =
			new CFBamEnumTagBuff();
		return( buff );
	}

	public CFBamEnumTagHBuff newHBuff() {
		CFBamEnumTagHBuff hbuff =
			new CFBamEnumTagHBuff();
		return( hbuff );
	}
}
