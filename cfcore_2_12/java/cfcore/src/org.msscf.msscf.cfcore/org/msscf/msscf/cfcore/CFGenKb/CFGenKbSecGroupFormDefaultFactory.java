
// Description: Java 11 Default Factory implementation for SecGroupForm.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFGenKbSecGroupFormFactory implementation for SecGroupForm
	 */
public class CFGenKbSecGroupFormDefaultFactory
	implements ICFGenKbSecGroupFormFactory
{
	public CFGenKbSecGroupFormDefaultFactory() {
	}

	public CFGenKbSecGroupFormPKey newPKey() {
		CFGenKbSecGroupFormPKey pkey =
			new CFGenKbSecGroupFormPKey();
		return( pkey );
	}

	public CFGenKbSecGroupFormByClusterIdxKey newClusterIdxKey() {
		CFGenKbSecGroupFormByClusterIdxKey key =
			new CFGenKbSecGroupFormByClusterIdxKey();
		return( key );
	}

	public CFGenKbSecGroupFormByGroupIdxKey newGroupIdxKey() {
		CFGenKbSecGroupFormByGroupIdxKey key =
			new CFGenKbSecGroupFormByGroupIdxKey();
		return( key );
	}

	public CFGenKbSecGroupFormByAppIdxKey newAppIdxKey() {
		CFGenKbSecGroupFormByAppIdxKey key =
			new CFGenKbSecGroupFormByAppIdxKey();
		return( key );
	}

	public CFGenKbSecGroupFormByFormIdxKey newFormIdxKey() {
		CFGenKbSecGroupFormByFormIdxKey key =
			new CFGenKbSecGroupFormByFormIdxKey();
		return( key );
	}

	public CFGenKbSecGroupFormByUFormIdxKey newUFormIdxKey() {
		CFGenKbSecGroupFormByUFormIdxKey key =
			new CFGenKbSecGroupFormByUFormIdxKey();
		return( key );
	}

	public CFGenKbSecGroupFormBuff newBuff() {
		CFGenKbSecGroupFormBuff buff =
			new CFGenKbSecGroupFormBuff();
		return( buff );
	}
}
