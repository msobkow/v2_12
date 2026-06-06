
// Description: Java 11 Default Factory implementation for SecGroupForm.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSec;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFSecSecGroupFormFactory implementation for SecGroupForm
	 */
public class CFSecSecGroupFormDefaultFactory
	implements ICFSecSecGroupFormFactory
{
	public CFSecSecGroupFormDefaultFactory() {
	}

	public CFSecSecGroupFormPKey newPKey() {
		CFSecSecGroupFormPKey pkey =
			new CFSecSecGroupFormPKey();
		return( pkey );
	}

	public CFSecSecGroupFormHPKey newHPKey() {
		CFSecSecGroupFormHPKey hpkey =
			new CFSecSecGroupFormHPKey();
		return( hpkey );
	}

	public CFSecSecGroupFormByClusterIdxKey newClusterIdxKey() {
		CFSecSecGroupFormByClusterIdxKey key =
			new CFSecSecGroupFormByClusterIdxKey();
		return( key );
	}

	public CFSecSecGroupFormByGroupIdxKey newGroupIdxKey() {
		CFSecSecGroupFormByGroupIdxKey key =
			new CFSecSecGroupFormByGroupIdxKey();
		return( key );
	}

	public CFSecSecGroupFormByAppIdxKey newAppIdxKey() {
		CFSecSecGroupFormByAppIdxKey key =
			new CFSecSecGroupFormByAppIdxKey();
		return( key );
	}

	public CFSecSecGroupFormByFormIdxKey newFormIdxKey() {
		CFSecSecGroupFormByFormIdxKey key =
			new CFSecSecGroupFormByFormIdxKey();
		return( key );
	}

	public CFSecSecGroupFormByUFormIdxKey newUFormIdxKey() {
		CFSecSecGroupFormByUFormIdxKey key =
			new CFSecSecGroupFormByUFormIdxKey();
		return( key );
	}

	public CFSecSecGroupFormBuff newBuff() {
		CFSecSecGroupFormBuff buff =
			new CFSecSecGroupFormBuff();
		return( buff );
	}

	public CFSecSecGroupFormHBuff newHBuff() {
		CFSecSecGroupFormHBuff hbuff =
			new CFSecSecGroupFormHBuff();
		return( hbuff );
	}
}
