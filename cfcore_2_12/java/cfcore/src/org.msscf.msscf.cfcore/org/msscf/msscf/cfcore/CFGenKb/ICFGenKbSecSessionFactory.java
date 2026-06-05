
// Description: Java 11 Factory interface for SecSession.

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
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbSecSessionFactory interface for SecSession
 */
public interface ICFGenKbSecSessionFactory
{

	/**
	 *	Allocate a primary key for SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionPKey newPKey();

	/**
	 *	Allocate a SecUserIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionBySecUserIdxKey newSecUserIdxKey();

	/**
	 *	Allocate a SecDevIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionBySecDevIdxKey newSecDevIdxKey();

	/**
	 *	Allocate a StartIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionByStartIdxKey newStartIdxKey();

	/**
	 *	Allocate a FinishIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionByFinishIdxKey newFinishIdxKey();

	/**
	 *	Allocate a SecProxyIdx key over SecSession instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionBySecProxyIdxKey newSecProxyIdxKey();

	/**
	 *	Allocate a SecSession instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbSecSessionBuff newBuff();

}
