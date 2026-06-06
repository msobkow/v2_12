
// Description: Java 11 Default Factory implementation for Relation.

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
	 *	CFBamRelationFactory implementation for Relation
	 */
public class CFBamRelationDefaultFactory
	implements ICFBamRelationFactory
{
	public CFBamRelationDefaultFactory() {
	}

	public CFBamRelationByUNameIdxKey newUNameIdxKey() {
		CFBamRelationByUNameIdxKey key =
			new CFBamRelationByUNameIdxKey();
		return( key );
	}

	public CFBamRelationByRelnTenantIdxKey newRelnTenantIdxKey() {
		CFBamRelationByRelnTenantIdxKey key =
			new CFBamRelationByRelnTenantIdxKey();
		return( key );
	}

	public CFBamRelationByRelTableIdxKey newRelTableIdxKey() {
		CFBamRelationByRelTableIdxKey key =
			new CFBamRelationByRelTableIdxKey();
		return( key );
	}

	public CFBamRelationByDefSchemaIdxKey newDefSchemaIdxKey() {
		CFBamRelationByDefSchemaIdxKey key =
			new CFBamRelationByDefSchemaIdxKey();
		return( key );
	}

	public CFBamRelationByFromKeyIdxKey newFromKeyIdxKey() {
		CFBamRelationByFromKeyIdxKey key =
			new CFBamRelationByFromKeyIdxKey();
		return( key );
	}

	public CFBamRelationByToTblIdxKey newToTblIdxKey() {
		CFBamRelationByToTblIdxKey key =
			new CFBamRelationByToTblIdxKey();
		return( key );
	}

	public CFBamRelationByToKeyIdxKey newToKeyIdxKey() {
		CFBamRelationByToKeyIdxKey key =
			new CFBamRelationByToKeyIdxKey();
		return( key );
	}

	public CFBamRelationByNarrowedIdxKey newNarrowedIdxKey() {
		CFBamRelationByNarrowedIdxKey key =
			new CFBamRelationByNarrowedIdxKey();
		return( key );
	}

	public CFBamRelationBuff newBuff() {
		CFBamRelationBuff buff =
			new CFBamRelationBuff();
		return( buff );
	}

	public CFBamRelationHBuff newHBuff() {
		CFBamRelationHBuff hbuff =
			new CFBamRelationHBuff();
		return( hbuff );
	}
}
