
// Description: Java 11 Default Factory implementation for UInt64Col.

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
	 *	CFBamUInt64ColFactory implementation for UInt64Col
	 */
public class CFBamUInt64ColDefaultFactory
	implements ICFBamUInt64ColFactory
{
	public CFBamUInt64ColDefaultFactory() {
	}

	public CFBamUInt64ColByTableIdxKey newTableIdxKey() {
		CFBamUInt64ColByTableIdxKey key =
			new CFBamUInt64ColByTableIdxKey();
		return( key );
	}

	public CFBamUInt64ColBuff newBuff() {
		CFBamUInt64ColBuff buff =
			new CFBamUInt64ColBuff();
		return( buff );
	}

	public CFBamUInt64ColHBuff newHBuff() {
		CFBamUInt64ColHBuff hbuff =
			new CFBamUInt64ColHBuff();
		return( hbuff );
	}
}
