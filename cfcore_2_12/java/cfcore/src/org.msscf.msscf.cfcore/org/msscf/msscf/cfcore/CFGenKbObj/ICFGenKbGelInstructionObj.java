// Description: Java 11 Object interface for CFGenKb GelInstruction.

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
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public interface ICFGenKbGelInstructionObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a GelInstruction.
	 *
	 *	@return	CFGenKbGelInstructionObj instance which should be subsequently referenced.
	 */
	ICFGenKbGelInstructionObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();
	void forget( boolean forgetSubObjects );

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbGelInstructionObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbGelInstructionObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbGelInstructionObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbGelInstructionObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this GelInstruction instance.
	 *
	 *	@return	The newly locked ICFGenKbGelInstructionEditObj edition of this instance.
	 */
	ICFGenKbGelInstructionEditObj beginEdit();

	/**
	 *	End this edition of this GelInstruction instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this GelInstruction instance.
	 *
	 *	@return	The ICFGenKbGelInstructionEditObj edition of this instance.
	 */
	ICFGenKbGelInstructionEditObj getEdit();

	/**
	 *	Get the current edition of this GelInstruction instance as a ICFGenKbGelInstructionEditObj.
	 *
	 *	@return	The ICFGenKbGelInstructionEditObj edition of this instance.
	 */
	ICFGenKbGelInstructionEditObj getEditAsGelInstruction();

	/**
	 *	Get the ICFGenKbGelInstructionTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelInstructionTableObj table cache which manages this instance.
	 */
	ICFGenKbGelInstructionTableObj getGelInstructionTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbGelInstructionBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelInstructionBuff instance which currently backs this object.
	 */
	CFGenKbGelInstructionBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbGelInstructionBuff value );

	/**
	 *	Get the CFGenKbGelInstructionBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelInstructionBuff instance which currently backs this object.
	 */
	CFGenKbGelInstructionBuff getGelInstructionBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbGelInstructionPKey primary key for this instance.
	 */
	CFGenKbGelInstructionPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbGelInstructionPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbGelInstructionPKey value );

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required long attribute TenantId.
	 *
	 *	@return	The required long attribute TenantId.
	 */
	long getRequiredTenantId();

	/**
	 *	Get the required long attribute GelCacheId.
	 *
	 *	@return	The required long attribute GelCacheId.
	 */
	long getRequiredGelCacheId();

	/**
	 *	Get the required long attribute GelInstId.
	 *
	 *	@return	The required long attribute GelInstId.
	 */
	long getRequiredGelInstId();

	/**
	 *	Get the optional Long attribute ChainInstTenantId.
	 *
	 *	@return	The optional Long attribute ChainInstTenantId.
	 */
	Long getOptionalChainInstTenantId();

	/**
	 *	Get the optional Long attribute ChainInstGelCacheId.
	 *
	 *	@return	The optional Long attribute ChainInstGelCacheId.
	 */
	Long getOptionalChainInstGelCacheId();

	/**
	 *	Get the optional Long attribute ChainInstGelInstId.
	 *
	 *	@return	The optional Long attribute ChainInstGelInstId.
	 */
	Long getOptionalChainInstGelInstId();

	/**
	 *	Get the required String attribute SourceText.
	 *
	 *	@return	The required String attribute SourceText.
	 */
	String getRequiredSourceText();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFGenKbTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFGenKbTenantObj instance referenced by the Tenant key.
	 */
	ICFGenKbTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required ICFGenKbGelCacheObj instance referenced by the GelCache key.
	 *
	 *	@return	The required ICFGenKbGelCacheObj instance referenced by the GelCache key.
	 */
	ICFGenKbGelCacheObj getRequiredContainerGelCache();

	/**
	 *	Get the required ICFGenKbGelCacheObj instance referenced by the GelCache key.
	 *
	 *	@return	The required ICFGenKbGelCacheObj instance referenced by the GelCache key.
	 */
	ICFGenKbGelCacheObj getRequiredContainerGelCache( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the ChainInst key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the ChainInst key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupChainInst();

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the ChainInst key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the ChainInst key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupChainInst( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

	public void linkChainInstruction( ICFGenKbGelInstructionObj calledInstruction );
	public void addCalledInstruction( ICFGenKbGelCacheObj gelCache, ICFGenKbGelInstructionObj calledInstruction );
	public String expand( MssCFGenContext genContext );
}
