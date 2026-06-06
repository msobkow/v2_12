
// Description: Java 11 Factory interface for ToolSet.

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
 *	CFGenKbToolSetFactory interface for ToolSet
 */
public interface ICFGenKbToolSetFactory
{

	/**
	 *	Allocate a primary key for ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetPKey newPKey();

	/**
	 *	Allocate a NameIdx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByNameIdxKey newNameIdxKey();

	/**
	 *	Allocate a Tool0Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool0IdxKey newTool0IdxKey();

	/**
	 *	Allocate a Tool1Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool1IdxKey newTool1IdxKey();

	/**
	 *	Allocate a Tool2Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool2IdxKey newTool2IdxKey();

	/**
	 *	Allocate a Tool3Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool3IdxKey newTool3IdxKey();

	/**
	 *	Allocate a Tool4Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool4IdxKey newTool4IdxKey();

	/**
	 *	Allocate a Tool5Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool5IdxKey newTool5IdxKey();

	/**
	 *	Allocate a Tool6Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool6IdxKey newTool6IdxKey();

	/**
	 *	Allocate a Tool7Idx key over ToolSet instances.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetByTool7IdxKey newTool7IdxKey();

	/**
	 *	Allocate a ToolSet instance buffer.
	 *
	 *	@return	The new instance.
	 */
	CFGenKbToolSetBuff newBuff();

}
