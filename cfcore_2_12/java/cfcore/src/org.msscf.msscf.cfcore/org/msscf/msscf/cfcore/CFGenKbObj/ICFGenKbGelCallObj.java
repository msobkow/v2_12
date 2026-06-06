// Description: Java 11 Object interface for CFGenKb GelCall.

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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public interface ICFGenKbGelCallObj
	extends ICFGenKbGelInstructionObj
{
	/**
	 *	Get the current edition of this GelCall instance as a ICFGenKbGelCallEditObj.
	 *
	 *	@return	The ICFGenKbGelCallEditObj edition of this instance.
	 */
	ICFGenKbGelCallEditObj getEditAsGelCall();

	/**
	 *	Get the ICFGenKbGelCallTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelCallTableObj table cache which manages this instance.
	 */
	ICFGenKbGelCallTableObj getGelCallTable();

	/**
	 *	Get the CFGenKbGelCallBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelCallBuff instance which currently backs this object.
	 */
	CFGenKbGelCallBuff getGelCallBuff();

	/**
	 *	Get the optional Long attribute SeqInstTenantId.
	 *
	 *	@return	The optional Long attribute SeqInstTenantId.
	 */
	Long getOptionalSeqInstTenantId();

	/**
	 *	Get the optional Long attribute SeqInstGelCacheId.
	 *
	 *	@return	The optional Long attribute SeqInstGelCacheId.
	 */
	Long getOptionalSeqInstGelCacheId();

	/**
	 *	Get the optional Long attribute SeqInstId.
	 *
	 *	@return	The optional Long attribute SeqInstId.
	 */
	Long getOptionalSeqInstId();

	/**
	 *	Get the optional Long attribute CallInstTenantId.
	 *
	 *	@return	The optional Long attribute CallInstTenantId.
	 */
	Long getOptionalCallInstTenantId();

	/**
	 *	Get the optional Long attribute CallInstGelCacheId.
	 *
	 *	@return	The optional Long attribute CallInstGelCacheId.
	 */
	Long getOptionalCallInstGelCacheId();

	/**
	 *	Get the optional Long attribute CallInstId.
	 *
	 *	@return	The optional Long attribute CallInstId.
	 */
	Long getOptionalCallInstId();

	/**
	 *	Get the optional Long attribute PrevInstTenantId.
	 *
	 *	@return	The optional Long attribute PrevInstTenantId.
	 */
	Long getOptionalPrevInstTenantId();

	/**
	 *	Get the optional Long attribute PrevInstGelCacheId.
	 *
	 *	@return	The optional Long attribute PrevInstGelCacheId.
	 */
	Long getOptionalPrevInstGelCacheId();

	/**
	 *	Get the optional Long attribute PrevInstGelInstId.
	 *
	 *	@return	The optional Long attribute PrevInstGelInstId.
	 */
	Long getOptionalPrevInstGelInstId();

	/**
	 *	Get the optional Long attribute NextInstTenantId.
	 *
	 *	@return	The optional Long attribute NextInstTenantId.
	 */
	Long getOptionalNextInstTenantId();

	/**
	 *	Get the optional Long attribute NextInstGelCacheId.
	 *
	 *	@return	The optional Long attribute NextInstGelCacheId.
	 */
	Long getOptionalNextInstGelCacheId();

	/**
	 *	Get the optional Long attribute NextInstGelInstId.
	 *
	 *	@return	The optional Long attribute NextInstGelInstId.
	 */
	Long getOptionalNextInstGelInstId();

	/**
	 *	Get the optional ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 *
	 *	@return	The optional ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 */
	ICFGenKbGelSequenceObj getOptionalParentSeqInst();

	/**
	 *	Get the optional ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 *
	 *	@return	The optional ICFGenKbGelSequenceObj instance referenced by the SeqInst key.
	 */
	ICFGenKbGelSequenceObj getOptionalParentSeqInst( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupCallInst();

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the CallInst key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupCallInst( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 *
	 *	@return	The optional ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupPrevInst();

	/**
	 *	Get the optional ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 *
	 *	@return	The optional ICFGenKbGelCallObj instance referenced by the PrevInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupPrevInst( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGelCallObj instance referenced by the NextInst key.
	 *
	 *	@return	The optional ICFGenKbGelCallObj instance referenced by the NextInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupNextInst();

	/**
	 *	Get the optional ICFGenKbGelCallObj instance referenced by the NextInst key.
	 *
	 *	@return	The optional ICFGenKbGelCallObj instance referenced by the NextInst key.
	 */
	ICFGenKbGelCallObj getOptionalLookupNextInst( boolean forceRead );

}
