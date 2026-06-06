
// Description: Java 11 Factory interface for GenFile.

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
import org.msscf.msscf.cfcore.CFGenKb.*;

/*
 *	CFGenKbGenFileFactory interface for GenFile
 */
public interface ICFGenKbGenFileFactory
{

	/**
	 *	Allocate a XSrcBundle key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXSrcBundleKey newXSrcBundleKey();

	/**
	 *	Allocate a XModName key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXModNameKey newXModNameKey();

	/**
	 *	Allocate a XBasePkg key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXBasePkgKey newXBasePkgKey();

	/**
	 *	Allocate a XSubPkg key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXSubPkgKey newXSubPkgKey();

	/**
	 *	Allocate a XExpClsName key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXExpClsNameKey newXExpClsNameKey();

	/**
	 *	Allocate a XExpKeyName key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXExpKeyNameKey newXExpKeyNameKey();

	/**
	 *	Allocate a XExpFileName key over GenFile instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileByXExpFileNameKey newXExpFileNameKey();

	/**
	 *	Allocate a GenFile instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbGenFileBuff newBuff();

}
