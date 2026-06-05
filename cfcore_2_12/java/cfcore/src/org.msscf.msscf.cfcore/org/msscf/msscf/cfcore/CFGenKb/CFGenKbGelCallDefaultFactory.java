
// Description: Java 11 Default Factory implementation for GelCall.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

	/*
	 *	CFGenKbGelCallFactory implementation for GelCall
	 */
public class CFGenKbGelCallDefaultFactory
	implements ICFGenKbGelCallFactory
{
	public CFGenKbGelCallDefaultFactory() {
	}

	public CFGenKbGelCallByCacheIdxKey newCacheIdxKey() {
		CFGenKbGelCallByCacheIdxKey key =
			new CFGenKbGelCallByCacheIdxKey();
		return( key );
	}

	public CFGenKbGelCallBySeqIdxKey newSeqIdxKey() {
		CFGenKbGelCallBySeqIdxKey key =
			new CFGenKbGelCallBySeqIdxKey();
		return( key );
	}

	public CFGenKbGelCallByCallInstIdxKey newCallInstIdxKey() {
		CFGenKbGelCallByCallInstIdxKey key =
			new CFGenKbGelCallByCallInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallByPrevInstIdxKey newPrevInstIdxKey() {
		CFGenKbGelCallByPrevInstIdxKey key =
			new CFGenKbGelCallByPrevInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallByNextInstIdxKey newNextInstIdxKey() {
		CFGenKbGelCallByNextInstIdxKey key =
			new CFGenKbGelCallByNextInstIdxKey();
		return( key );
	}

	public CFGenKbGelCallBuff newBuff() {
		CFGenKbGelCallBuff buff =
			new CFGenKbGelCallBuff();
		return( buff );
	}
}
