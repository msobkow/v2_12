// Description: Java 11 Object interface for CFGenKb ToolSet.

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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbToolSetObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a ToolSet.
	 *
	 *	@return	CFGenKbToolSetObj instance which should be subsequently referenced.
	 */
	ICFGenKbToolSetObj realise();

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
	 *	@return	ICFGenKbToolSetObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbToolSetObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbToolSetObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbToolSetObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this ToolSet instance.
	 *
	 *	@return	The newly locked ICFGenKbToolSetEditObj edition of this instance.
	 */
	ICFGenKbToolSetEditObj beginEdit();

	/**
	 *	End this edition of this ToolSet instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this ToolSet instance.
	 *
	 *	@return	The ICFGenKbToolSetEditObj edition of this instance.
	 */
	ICFGenKbToolSetEditObj getEdit();

	/**
	 *	Get the current edition of this ToolSet instance as a ICFGenKbToolSetEditObj.
	 *
	 *	@return	The ICFGenKbToolSetEditObj edition of this instance.
	 */
	ICFGenKbToolSetEditObj getEditAsToolSet();

	/**
	 *	Get the ICFGenKbToolSetTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbToolSetTableObj table cache which manages this instance.
	 */
	ICFGenKbToolSetTableObj getToolSetTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbToolSetBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbToolSetBuff instance which currently backs this object.
	 */
	CFGenKbToolSetBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbToolSetBuff value );

	/**
	 *	Get the CFGenKbToolSetBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbToolSetBuff instance which currently backs this object.
	 */
	CFGenKbToolSetBuff getToolSetBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbToolSetPKey primary key for this instance.
	 */
	CFGenKbToolSetPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbToolSetPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbToolSetPKey value );

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
	 *	Get the required short attribute Id.
	 *
	 *	@return	The required short attribute Id.
	 */
	short getRequiredId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute Descr.
	 *
	 *	@return	The optional String attribute Descr.
	 */
	String getOptionalDescr();

	/**
	 *	Get the optional String attribute RevisionString.
	 *
	 *	@return	The optional String attribute RevisionString.
	 */
	String getOptionalRevisionString();

	/**
	 *	Get the required boolean attribute IsSupported.
	 *
	 *	@return	The required boolean attribute IsSupported.
	 */
	boolean getRequiredIsSupported();

	/**
	 *	Get the required boolean attribute Generate.
	 *
	 *	@return	The required boolean attribute Generate.
	 */
	boolean getRequiredGenerate();

	/**
	 *	Get the required short attribute ToolId0.
	 *
	 *	@return	The required short attribute ToolId0.
	 */
	short getRequiredToolId0();

	/**
	 *	Get the optional Short attribute ToolId1.
	 *
	 *	@return	The optional Short attribute ToolId1.
	 */
	Short getOptionalToolId1();

	/**
	 *	Get the optional Short attribute ToolId2.
	 *
	 *	@return	The optional Short attribute ToolId2.
	 */
	Short getOptionalToolId2();

	/**
	 *	Get the optional Short attribute ToolId3.
	 *
	 *	@return	The optional Short attribute ToolId3.
	 */
	Short getOptionalToolId3();

	/**
	 *	Get the optional Short attribute ToolId4.
	 *
	 *	@return	The optional Short attribute ToolId4.
	 */
	Short getOptionalToolId4();

	/**
	 *	Get the optional Short attribute ToolId5.
	 *
	 *	@return	The optional Short attribute ToolId5.
	 */
	Short getOptionalToolId5();

	/**
	 *	Get the optional Short attribute ToolId6.
	 *
	 *	@return	The optional Short attribute ToolId6.
	 */
	Short getOptionalToolId6();

	/**
	 *	Get the optional Short attribute ToolId7.
	 *
	 *	@return	The optional Short attribute ToolId7.
	 */
	Short getOptionalToolId7();

	/**
	 *	Get the required ICFGenKbToolObj instance referenced by the Tool0 key.
	 *
	 *	@return	The required ICFGenKbToolObj instance referenced by the Tool0 key.
	 */
	ICFGenKbToolObj getRequiredLookupTool0();

	/**
	 *	Get the required ICFGenKbToolObj instance referenced by the Tool0 key.
	 *
	 *	@return	The required ICFGenKbToolObj instance referenced by the Tool0 key.
	 */
	ICFGenKbToolObj getRequiredLookupTool0( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool1 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool1 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool1();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool1 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool1 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool1( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool2 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool2 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool2();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool2 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool2 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool2( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool3 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool3 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool3();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool3 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool3 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool3( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool4 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool4 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool4();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool4 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool4 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool4( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool5 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool5 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool5();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool5 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool5 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool5( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool6 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool6 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool6();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool6 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool6 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool6( boolean forceRead );

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool7 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool7 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool7();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Tool7 key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Tool7 key.
	 */
	ICFGenKbToolObj getOptionalLookupTool7( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
