// Description: Java 11 Instance Edit Object interface for CFGenKb GelCall.

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

public interface ICFGenKbGelCallEditObj
	extends ICFGenKbGelCallObj,
		ICFGenKbGelInstructionEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFGenKbGelCallObj.
	 */
	ICFGenKbGelCallObj getOrigAsGelCall();

	/**
	 *	Get the ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 *
	 *	@return	The ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 */
	ICFGenKbGelSequenceObj getOptionalParentSeqInst();

	/**
	 *	Set the ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 *
	 *	@param	value	the ICFGenKbGelSequenceObj instance to be referenced by the SeqInst key.
	 */
	void setOptionalParentSeqInst( ICFGenKbGelSequenceObj value );

	/**
	 *	Get the ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 *
	 *	@return	The ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupCallInst();

	/**
	 *	Set the ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 *
	 *	@param	value	the ICFGenKbGelInstructionObj instance to be referenced by the CallInst key.
	 */
	void setOptionalLookupCallInst( ICFGenKbGelInstructionObj value );

	/**
	 *	Get the ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 *
	 *	@return	The ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupPrevInst();

	/**
	 *	Set the ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 *
	 *	@param	value	the ICFGenKbGelCallObj instance to be referenced by the PrevInst key.
	 */
	void setOptionalLookupPrevInst( ICFGenKbGelCallObj value );

	/**
	 *	Get the ICFGenKbGelCallObj instance referenced by the NextInst key.
	 *
	 *	@return	The ICFGenKbGelCallObj instance referenced by the NextInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupNextInst();

	/**
	 *	Set the ICFGenKbGelCallObj instance referenced by the NextInst key.
	 *
	 *	@param	value	the ICFGenKbGelCallObj instance to be referenced by the NextInst key.
	 */
	void setOptionalLookupNextInst( ICFGenKbGelCallObj value );
}
