
// Description: Java 11 Default Factory implementation for GelIterator.

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
	 *	CFGenKbGelIteratorFactory implementation for GelIterator
	 */
public class CFGenKbGelIteratorDefaultFactory
	implements ICFGenKbGelIteratorFactory
{
	public CFGenKbGelIteratorDefaultFactory() {
	}

	public CFGenKbGelIteratorByBeforeIdxKey newBeforeIdxKey() {
		CFGenKbGelIteratorByBeforeIdxKey key =
			new CFGenKbGelIteratorByBeforeIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorByFirstIdxKey newFirstIdxKey() {
		CFGenKbGelIteratorByFirstIdxKey key =
			new CFGenKbGelIteratorByFirstIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorByEachIdxKey newEachIdxKey() {
		CFGenKbGelIteratorByEachIdxKey key =
			new CFGenKbGelIteratorByEachIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorByLastIdxKey newLastIdxKey() {
		CFGenKbGelIteratorByLastIdxKey key =
			new CFGenKbGelIteratorByLastIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorByLoneIdxKey newLoneIdxKey() {
		CFGenKbGelIteratorByLoneIdxKey key =
			new CFGenKbGelIteratorByLoneIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorByEmptyIdxKey newEmptyIdxKey() {
		CFGenKbGelIteratorByEmptyIdxKey key =
			new CFGenKbGelIteratorByEmptyIdxKey();
		return( key );
	}

	public CFGenKbGelIteratorBuff newBuff() {
		CFGenKbGelIteratorBuff buff =
			new CFGenKbGelIteratorBuff();
		return( buff );
	}
}
