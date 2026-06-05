// Description: Java 11 Table Object interface for CFGenKb.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbGenReferenceTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GenReference instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGenReferenceObj newInstance();

	/**
	 *	Instantiate a new GenReference edition of the specified GenReference instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGenReferenceEditObj newEditInstance( ICFGenKbGenReferenceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenReferenceObj realiseGenReference( ICFGenKbGenReferenceObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGenReference( ICFGenKbGenReferenceObj Obj );
	void forgetGenReference( ICFGenKbGenReferenceObj Obj, boolean forgetSubObjects );
	void forgetGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	void forgetGenReferenceByTenantIdx( long TenantId );

	void forgetGenReferenceByCartIdx( long TenantId,
		long CartridgeId );

	void forgetGenReferenceByRuleTypeIdx( short RuleTypeId );

	void forgetGenReferenceByToolSetIdx( short ToolSetId );

	void forgetGenReferenceByScopeIdx( Short ScopeDefId );

	void forgetGenReferenceByGenDefIdx( short GenDefId );

	void forgetGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	void forgetGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	void forgetGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGenReferenceObj createGenReference( ICFGenKbGenReferenceObj Obj );

	/**
	 *	Read a GenReference-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenReference-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenReferenceObj readGenReference( CFGenKbGenItemPKey pkey );

	/**
	 *	Read a GenReference-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GenReference-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGenReferenceObj readGenReference( CFGenKbGenItemPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenReferenceObj lockGenReference( CFGenKbGenItemPKey pkey );

	/**
	 *	Return a sorted list of all the GenReference-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenReferenceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readAllGenReference();

	/**
	 *	Return a sorted map of all the GenReference-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGenReferenceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readAllGenReference( boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenReferenceObj readGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenReferenceObj readGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate CartIdx key.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate CartIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByCartIdx( long TenantId,
		long CartridgeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate RuleTypeIdx key.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate RuleTypeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByRuleTypeIdx( short RuleTypeId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByToolSetIdx( short ToolSetId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate ToolSetIdx key.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ToolSetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByToolSetIdx( short ToolSetId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByScopeIdx( Short ScopeDefId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByScopeIdx( Short ScopeDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByGenDefIdx( short GenDefId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate GenDefIdx key.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate GenDefIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByGenDefIdx( short GenDefId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj cached instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenReferenceObj readGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Get the CFGenKbGenItemObj instance for the unique AltIdx key.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGenItemObj refreshed instance for the unique AltIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGenReferenceObj readGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate GelExecIdx key.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate GelExecIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGenItemObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );

	/**
	 *	Get the map of CFGenKbGenReferenceObj instances sorted by their primary keys for the duplicate ProbeIdx key.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGenReferenceObj cached instances sorted by their primary keys for the duplicate ProbeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGenReferenceObj> readGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGenReferenceObj updateGenReference( ICFGenKbGenReferenceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGenReference( ICFGenKbGenReferenceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argItemId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByItemIdIdx( long TenantId,
		long CartridgeId,
		long ItemId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argCartridgeId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByCartIdx( long TenantId,
		long CartridgeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRuleTypeId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByRuleTypeIdx( short RuleTypeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByToolSetIdx( short ToolSetId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByScopeIdx( Short ScopeDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByGenDefIdx( short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argToolSetId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argScopeDefId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGenDefId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByAltIdx( String Name,
		short ToolSetId,
		Short ScopeDefId,
		short GenDefId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argGelExecutableTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableGelCacheId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argGelExecutableId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByGelExecIdx( Long GelExecutableTenantId,
		Long GelExecutableGelCacheId,
		Long GelExecutableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argProbeTenantId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeCartridgeId	The GenReference key attribute of the instance generating the id.
	 *
	 *	@param	argProbeGenItemId	The GenReference key attribute of the instance generating the id.
	 */
	void deleteGenReferenceByProbeIdx( Long ProbeTenantId,
		Long ProbeCartridgeId,
		Long ProbeGenItemId );
}
