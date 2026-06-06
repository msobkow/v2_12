// Description: Java 11 Instance Edit Object interface for CFGenKb ToolSet.

/*
 *	org.msscf.msscf.CFCore
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbToolSetEditObj
	extends ICFGenKbToolSetObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFGenKbToolSetObj.
	 */
	ICFGenKbToolSetObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbToolSetObj.
	 */
	ICFGenKbToolSetObj getOrigAsToolSet();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFGenKbToolSetObj create();

	/*
	 *	Update the instance.
	 */
	CFGenKbToolSetEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFGenKbToolSetEditObj deleteInstance();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the optional String attribute Descr.
	 *
	 *	@return	The String value of the attribute Descr.
	 */
	String getOptionalDescr();

	/**
	 *	Set the optional String attribute Descr.
	 *
	 *	@param	value	the String value of the attribute Descr.
	 */
	void setOptionalDescr( String value );

	/**
	 *	Get the optional String attribute RevisionString.
	 *
	 *	@return	The String value of the attribute RevisionString.
	 */
	String getOptionalRevisionString();

	/**
	 *	Set the optional String attribute RevisionString.
	 *
	 *	@param	value	the String value of the attribute RevisionString.
	 */
	void setOptionalRevisionString( String value );

	/**
	 *	Get the required boolean attribute IsSupported.
	 *
	 *	@return	The boolean value of the attribute IsSupported.
	 */
	boolean getRequiredIsSupported();

	/**
	 *	Set the required boolean attribute IsSupported.
	 *
	 *	@param	value	the boolean value of the attribute IsSupported.
	 */
	void setRequiredIsSupported( boolean value );

	/**
	 *	Get the required boolean attribute Generate.
	 *
	 *	@return	The boolean value of the attribute Generate.
	 */
	boolean getRequiredGenerate();

	/**
	 *	Set the required boolean attribute Generate.
	 *
	 *	@param	value	the boolean value of the attribute Generate.
	 */
	void setRequiredGenerate( boolean value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool0 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool0 key.
	 */
	ICFGenKbToolObj getRequiredLookupTool0();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool0 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool0 key.
	 */
	void setRequiredLookupTool0( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool1 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool1 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool1();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool1 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool1 key.
	 */
	void setOptionalLookupTool1( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool2 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool2 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool2();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool2 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool2 key.
	 */
	void setOptionalLookupTool2( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool3 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool3 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool3();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool3 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool3 key.
	 */
	void setOptionalLookupTool3( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool4 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool4 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool4();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool4 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool4 key.
	 */
	void setOptionalLookupTool4( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool5 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool5 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool5();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool5 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool5 key.
	 */
	void setOptionalLookupTool5( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool6 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool6 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool6();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool6 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool6 key.
	 */
	void setOptionalLookupTool6( ICFGenKbToolObj value );

	/**
	 *	Get the ICFGenKbToolObj instance referenced by the Tool7 key.
	 *
	 *	@return	The ICFGenKbToolObj instance referenced by the Tool7 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool7();

	/**
	 *	Set the ICFGenKbToolObj instance referenced by the Tool7 key.
	 *
	 *	@param	value	the ICFGenKbToolObj instance to be referenced by the Tool7 key.
	 */
	void setOptionalLookupTool7( ICFGenKbToolObj value );
}
