
// Description: Java 11 Factory interface for GenFile.

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
