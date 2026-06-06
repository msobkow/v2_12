// Description: Java 11 CFInt Table Permissions Interface.

/*
 *	org.msscf.msscf.CFInt
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

public interface ICFIntTablePerms
extends ICFSecTablePerms
{
	/**
	 *	Is the session allowed to create License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateLicense( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadLicense( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateLicense( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete License instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteLicense( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMajorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMajorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMajorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MajorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMajorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMimeType( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMimeType( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMimeType( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMimeType( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateMinorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadMinorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateMinorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete MinorVersion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteMinorVersion( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSubProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSubProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSubProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SubProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSubProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTld( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTld( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTld( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tld instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTld( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopDomain( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopDomain( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopDomain( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopDomain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopDomain( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTopProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTopProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTopProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TopProject instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTopProject( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to create URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateURLProtocol( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to read URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadURLProtocol( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to update URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateURLProtocol( CFSecAuthorization Authorization );

	/**
	 *	Is the session allowed to delete URLProtocol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteURLProtocol( CFSecAuthorization Authorization );
}
