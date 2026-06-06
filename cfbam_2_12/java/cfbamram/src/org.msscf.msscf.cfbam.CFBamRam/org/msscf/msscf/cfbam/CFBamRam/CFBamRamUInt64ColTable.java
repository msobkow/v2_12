
// Description: Java 11 in-memory RAM DbIO implementation for UInt64Col.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamRam;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamRamUInt64ColTable in-memory RAM DbIO implementation
 *	for UInt64Col.
 */
public class CFBamRamUInt64ColTable
	implements ICFBamUInt64ColTable
{
	private ICFBamSchema schema;
	private Map< CFBamValuePKey,
				CFBamUInt64ColBuff > dictByPKey
		= new HashMap< CFBamValuePKey,
				CFBamUInt64ColBuff >();
	private Map< CFBamUInt64ColByTableIdxKey,
				Map< CFBamValuePKey,
					CFBamUInt64ColBuff >> dictByTableIdx
		= new HashMap< CFBamUInt64ColByTableIdxKey,
				Map< CFBamValuePKey,
					CFBamUInt64ColBuff >>();

	public CFBamRamUInt64ColTable( ICFBamSchema argSchema ) {
		schema = argSchema;
	}

	public void createUInt64Col( CFSecAuthorization Authorization,
		CFBamUInt64ColBuff Buff )
	{
		final String S_ProcName = "createUInt64Col";
		CFBamValueBuff tail = null;
		if( Buff.getClassCode().equals( "U64C" ) ) {
			CFBamValueBuff[] siblings = schema.getTableValue().readDerivedByScopeIdx( Authorization,
				Buff.getRequiredTenantId(),
				Buff.getRequiredTableId() );
			for( int idx = 0; ( tail == null ) && ( idx < siblings.length ); idx ++ ) {
				if( ( siblings[idx].getOptionalNextTenantId() == null )
					&& ( siblings[idx].getOptionalNextId() == null ) )
				{
					tail = siblings[idx];
				}
			}
			if( tail != null ) {
				Buff.setOptionalPrevTenantId( tail.getRequiredTenantId() );
				Buff.setOptionalPrevId( tail.getRequiredId() );
			}
			else {
				Buff.setOptionalPrevTenantId( null );
				Buff.setOptionalPrevId( null );
			}
		}
		schema.getTableUInt64Def().createUInt64Def( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setClassCode( Buff.getClassCode() );
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt64ColByTableIdxKey keyTableIdx = schema.getFactoryUInt64Col().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		// Validate unique indexes

		if( dictByPKey.containsKey( pkey ) ) {
			throw new CFLibPrimaryKeyNotNewException( getClass(), S_ProcName, pkey );
		}

		// Validate foreign keys

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableUInt64Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Superclass",
						"SuperClass",
						"UInt64Def",
						null );
				}
			}
		}

		{
			boolean allNull = true;
			allNull = false;
			allNull = false;
			if( ! allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						S_ProcName,
						"Container",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Proceed with adding the new record

		dictByPKey.put( pkey, Buff );

		Map< CFBamValuePKey, CFBamUInt64ColBuff > subdictTableIdx;
		if( dictByTableIdx.containsKey( keyTableIdx ) ) {
			subdictTableIdx = dictByTableIdx.get( keyTableIdx );
		}
		else {
			subdictTableIdx = new HashMap< CFBamValuePKey, CFBamUInt64ColBuff >();
			dictByTableIdx.put( keyTableIdx, subdictTableIdx );
		}
		subdictTableIdx.put( pkey, Buff );

		if( tail != null ) {
			String tailClassCode = tail.getClassCode();
			if( tailClassCode.equals( "VALU" ) ) {
				CFBamValueBuff tailEdit = schema.getFactoryValue().newBuff();
				tailEdit.set( (CFBamValueBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableValue().updateValue( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ATOM" ) ) {
				CFBamAtomBuff tailEdit = schema.getFactoryAtom().newBuff();
				tailEdit.set( (CFBamAtomBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableAtom().updateAtom( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBD" ) ) {
				CFBamBlobDefBuff tailEdit = schema.getFactoryBlobDef().newBuff();
				tailEdit.set( (CFBamBlobDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobDef().updateBlobDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBT" ) ) {
				CFBamBlobTypeBuff tailEdit = schema.getFactoryBlobType().newBuff();
				tailEdit.set( (CFBamBlobTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobType().updateBlobType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BLBC" ) ) {
				CFBamBlobColBuff tailEdit = schema.getFactoryBlobCol().newBuff();
				tailEdit.set( (CFBamBlobColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBlobCol().updateBlobCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLD" ) ) {
				CFBamBoolDefBuff tailEdit = schema.getFactoryBoolDef().newBuff();
				tailEdit.set( (CFBamBoolDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolDef().updateBoolDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLT" ) ) {
				CFBamBoolTypeBuff tailEdit = schema.getFactoryBoolType().newBuff();
				tailEdit.set( (CFBamBoolTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolType().updateBoolType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "BOLC" ) ) {
				CFBamBoolColBuff tailEdit = schema.getFactoryBoolCol().newBuff();
				tailEdit.set( (CFBamBoolColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableBoolCol().updateBoolCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATD" ) ) {
				CFBamDateDefBuff tailEdit = schema.getFactoryDateDef().newBuff();
				tailEdit.set( (CFBamDateDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateDef().updateDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATT" ) ) {
				CFBamDateTypeBuff tailEdit = schema.getFactoryDateType().newBuff();
				tailEdit.set( (CFBamDateTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateType().updateDateType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DATC" ) ) {
				CFBamDateColBuff tailEdit = schema.getFactoryDateCol().newBuff();
				tailEdit.set( (CFBamDateColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDateCol().updateDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLD" ) ) {
				CFBamDoubleDefBuff tailEdit = schema.getFactoryDoubleDef().newBuff();
				tailEdit.set( (CFBamDoubleDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleDef().updateDoubleDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLT" ) ) {
				CFBamDoubleTypeBuff tailEdit = schema.getFactoryDoubleType().newBuff();
				tailEdit.set( (CFBamDoubleTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleType().updateDoubleType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DBLC" ) ) {
				CFBamDoubleColBuff tailEdit = schema.getFactoryDoubleCol().newBuff();
				tailEdit.set( (CFBamDoubleColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableDoubleCol().updateDoubleCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTD" ) ) {
				CFBamFloatDefBuff tailEdit = schema.getFactoryFloatDef().newBuff();
				tailEdit.set( (CFBamFloatDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatDef().updateFloatDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTT" ) ) {
				CFBamFloatTypeBuff tailEdit = schema.getFactoryFloatType().newBuff();
				tailEdit.set( (CFBamFloatTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatType().updateFloatType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "FLTC" ) ) {
				CFBamFloatColBuff tailEdit = schema.getFactoryFloatCol().newBuff();
				tailEdit.set( (CFBamFloatColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableFloatCol().updateFloatCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16D" ) ) {
				CFBamInt16DefBuff tailEdit = schema.getFactoryInt16Def().newBuff();
				tailEdit.set( (CFBamInt16DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Def().updateInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16T" ) ) {
				CFBamInt16TypeBuff tailEdit = schema.getFactoryInt16Type().newBuff();
				tailEdit.set( (CFBamInt16TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Type().updateInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG16" ) ) {
				CFBamId16GenBuff tailEdit = schema.getFactoryId16Gen().newBuff();
				tailEdit.set( (CFBamId16GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId16Gen().updateId16Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ENMD" ) ) {
				CFBamEnumDefBuff tailEdit = schema.getFactoryEnumDef().newBuff();
				tailEdit.set( (CFBamEnumDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableEnumDef().updateEnumDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ENMT" ) ) {
				CFBamEnumTypeBuff tailEdit = schema.getFactoryEnumType().newBuff();
				tailEdit.set( (CFBamEnumTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableEnumType().updateEnumType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I16C" ) ) {
				CFBamInt16ColBuff tailEdit = schema.getFactoryInt16Col().newBuff();
				tailEdit.set( (CFBamInt16ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt16Col().updateInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32D" ) ) {
				CFBamInt32DefBuff tailEdit = schema.getFactoryInt32Def().newBuff();
				tailEdit.set( (CFBamInt32DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Def().updateInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32T" ) ) {
				CFBamInt32TypeBuff tailEdit = schema.getFactoryInt32Type().newBuff();
				tailEdit.set( (CFBamInt32TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Type().updateInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG32" ) ) {
				CFBamId32GenBuff tailEdit = schema.getFactoryId32Gen().newBuff();
				tailEdit.set( (CFBamId32GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId32Gen().updateId32Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I32C" ) ) {
				CFBamInt32ColBuff tailEdit = schema.getFactoryInt32Col().newBuff();
				tailEdit.set( (CFBamInt32ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt32Col().updateInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64D" ) ) {
				CFBamInt64DefBuff tailEdit = schema.getFactoryInt64Def().newBuff();
				tailEdit.set( (CFBamInt64DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Def().updateInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64T" ) ) {
				CFBamInt64TypeBuff tailEdit = schema.getFactoryInt64Type().newBuff();
				tailEdit.set( (CFBamInt64TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Type().updateInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IG64" ) ) {
				CFBamId64GenBuff tailEdit = schema.getFactoryId64Gen().newBuff();
				tailEdit.set( (CFBamId64GenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableId64Gen().updateId64Gen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "I64C" ) ) {
				CFBamInt64ColBuff tailEdit = schema.getFactoryInt64Col().newBuff();
				tailEdit.set( (CFBamInt64ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableInt64Col().updateInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKD" ) ) {
				CFBamNmTokenDefBuff tailEdit = schema.getFactoryNmTokenDef().newBuff();
				tailEdit.set( (CFBamNmTokenDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKT" ) ) {
				CFBamNmTokenTypeBuff tailEdit = schema.getFactoryNmTokenType().newBuff();
				tailEdit.set( (CFBamNmTokenTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenType().updateNmTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTKC" ) ) {
				CFBamNmTokenColBuff tailEdit = schema.getFactoryNmTokenCol().newBuff();
				tailEdit.set( (CFBamNmTokenColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTSD" ) ) {
				CFBamNmTokensDefBuff tailEdit = schema.getFactoryNmTokensDef().newBuff();
				tailEdit.set( (CFBamNmTokensDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTST" ) ) {
				CFBamNmTokensTypeBuff tailEdit = schema.getFactoryNmTokensType().newBuff();
				tailEdit.set( (CFBamNmTokensTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensType().updateNmTokensType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NTSC" ) ) {
				CFBamNmTokensColBuff tailEdit = schema.getFactoryNmTokensCol().newBuff();
				tailEdit.set( (CFBamNmTokensColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMD" ) ) {
				CFBamNumberDefBuff tailEdit = schema.getFactoryNumberDef().newBuff();
				tailEdit.set( (CFBamNumberDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberDef().updateNumberDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMT" ) ) {
				CFBamNumberTypeBuff tailEdit = schema.getFactoryNumberType().newBuff();
				tailEdit.set( (CFBamNumberTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberType().updateNumberType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "NUMC" ) ) {
				CFBamNumberColBuff tailEdit = schema.getFactoryNumberCol().newBuff();
				tailEdit.set( (CFBamNumberColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableNumberCol().updateNumberCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRD" ) ) {
				CFBamStringDefBuff tailEdit = schema.getFactoryStringDef().newBuff();
				tailEdit.set( (CFBamStringDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringDef().updateStringDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRT" ) ) {
				CFBamStringTypeBuff tailEdit = schema.getFactoryStringType().newBuff();
				tailEdit.set( (CFBamStringTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringType().updateStringType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "STRC" ) ) {
				CFBamStringColBuff tailEdit = schema.getFactoryStringCol().newBuff();
				tailEdit.set( (CFBamStringColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableStringCol().updateStringCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZD" ) ) {
				CFBamTZDateDefBuff tailEdit = schema.getFactoryTZDateDef().newBuff();
				tailEdit.set( (CFBamTZDateDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateDef().updateTZDateDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZT" ) ) {
				CFBamTZDateTypeBuff tailEdit = schema.getFactoryTZDateType().newBuff();
				tailEdit.set( (CFBamTZDateTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateType().updateTZDateType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "DAZC" ) ) {
				CFBamTZDateColBuff tailEdit = schema.getFactoryTZDateCol().newBuff();
				tailEdit.set( (CFBamTZDateColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZDateCol().updateTZDateCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZD" ) ) {
				CFBamTZTimeDefBuff tailEdit = schema.getFactoryTZTimeDef().newBuff();
				tailEdit.set( (CFBamTZTimeDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZT" ) ) {
				CFBamTZTimeTypeBuff tailEdit = schema.getFactoryTZTimeType().newBuff();
				tailEdit.set( (CFBamTZTimeTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeType().updateTZTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TMZC" ) ) {
				CFBamTZTimeColBuff tailEdit = schema.getFactoryTZTimeCol().newBuff();
				tailEdit.set( (CFBamTZTimeColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTD" ) ) {
				CFBamTZTimestampDefBuff tailEdit = schema.getFactoryTZTimestampDef().newBuff();
				tailEdit.set( (CFBamTZTimestampDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTT" ) ) {
				CFBamTZTimestampTypeBuff tailEdit = schema.getFactoryTZTimestampType().newBuff();
				tailEdit.set( (CFBamTZTimestampTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "ZSTC" ) ) {
				CFBamTZTimestampColBuff tailEdit = schema.getFactoryTZTimestampCol().newBuff();
				tailEdit.set( (CFBamTZTimestampColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTD" ) ) {
				CFBamTextDefBuff tailEdit = schema.getFactoryTextDef().newBuff();
				tailEdit.set( (CFBamTextDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextDef().updateTextDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTT" ) ) {
				CFBamTextTypeBuff tailEdit = schema.getFactoryTextType().newBuff();
				tailEdit.set( (CFBamTextTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextType().updateTextType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TXTC" ) ) {
				CFBamTextColBuff tailEdit = schema.getFactoryTextCol().newBuff();
				tailEdit.set( (CFBamTextColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTextCol().updateTextCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMD" ) ) {
				CFBamTimeDefBuff tailEdit = schema.getFactoryTimeDef().newBuff();
				tailEdit.set( (CFBamTimeDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeDef().updateTimeDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMT" ) ) {
				CFBamTimeTypeBuff tailEdit = schema.getFactoryTimeType().newBuff();
				tailEdit.set( (CFBamTimeTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeType().updateTimeType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TIMC" ) ) {
				CFBamTimeColBuff tailEdit = schema.getFactoryTimeCol().newBuff();
				tailEdit.set( (CFBamTimeColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimeCol().updateTimeCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPD" ) ) {
				CFBamTimestampDefBuff tailEdit = schema.getFactoryTimestampDef().newBuff();
				tailEdit.set( (CFBamTimestampDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampDef().updateTimestampDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPT" ) ) {
				CFBamTimestampTypeBuff tailEdit = schema.getFactoryTimestampType().newBuff();
				tailEdit.set( (CFBamTimestampTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampType().updateTimestampType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TSPC" ) ) {
				CFBamTimestampColBuff tailEdit = schema.getFactoryTimestampCol().newBuff();
				tailEdit.set( (CFBamTimestampColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTimestampCol().updateTimestampCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKND" ) ) {
				CFBamTokenDefBuff tailEdit = schema.getFactoryTokenDef().newBuff();
				tailEdit.set( (CFBamTokenDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenDef().updateTokenDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKNT" ) ) {
				CFBamTokenTypeBuff tailEdit = schema.getFactoryTokenType().newBuff();
				tailEdit.set( (CFBamTokenTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenType().updateTokenType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TKNC" ) ) {
				CFBamTokenColBuff tailEdit = schema.getFactoryTokenCol().newBuff();
				tailEdit.set( (CFBamTokenColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTokenCol().updateTokenCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16D" ) ) {
				CFBamUInt16DefBuff tailEdit = schema.getFactoryUInt16Def().newBuff();
				tailEdit.set( (CFBamUInt16DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Def().updateUInt16Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16T" ) ) {
				CFBamUInt16TypeBuff tailEdit = schema.getFactoryUInt16Type().newBuff();
				tailEdit.set( (CFBamUInt16TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Type().updateUInt16Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U16C" ) ) {
				CFBamUInt16ColBuff tailEdit = schema.getFactoryUInt16Col().newBuff();
				tailEdit.set( (CFBamUInt16ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt16Col().updateUInt16Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32D" ) ) {
				CFBamUInt32DefBuff tailEdit = schema.getFactoryUInt32Def().newBuff();
				tailEdit.set( (CFBamUInt32DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Def().updateUInt32Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32T" ) ) {
				CFBamUInt32TypeBuff tailEdit = schema.getFactoryUInt32Type().newBuff();
				tailEdit.set( (CFBamUInt32TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Type().updateUInt32Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U32C" ) ) {
				CFBamUInt32ColBuff tailEdit = schema.getFactoryUInt32Col().newBuff();
				tailEdit.set( (CFBamUInt32ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt32Col().updateUInt32Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64D" ) ) {
				CFBamUInt64DefBuff tailEdit = schema.getFactoryUInt64Def().newBuff();
				tailEdit.set( (CFBamUInt64DefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Def().updateUInt64Def( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64T" ) ) {
				CFBamUInt64TypeBuff tailEdit = schema.getFactoryUInt64Type().newBuff();
				tailEdit.set( (CFBamUInt64TypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Type().updateUInt64Type( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "U64C" ) ) {
				CFBamUInt64ColBuff tailEdit = schema.getFactoryUInt64Col().newBuff();
				tailEdit.set( (CFBamUInt64ColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUInt64Col().updateUInt64Col( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDD" ) ) {
				CFBamUuidDefBuff tailEdit = schema.getFactoryUuidDef().newBuff();
				tailEdit.set( (CFBamUuidDefBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidDef().updateUuidDef( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDT" ) ) {
				CFBamUuidTypeBuff tailEdit = schema.getFactoryUuidType().newBuff();
				tailEdit.set( (CFBamUuidTypeBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidType().updateUuidType( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "IGUU" ) ) {
				CFBamUuidGenBuff tailEdit = schema.getFactoryUuidGen().newBuff();
				tailEdit.set( (CFBamUuidGenBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidGen().updateUuidGen( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "UIDC" ) ) {
				CFBamUuidColBuff tailEdit = schema.getFactoryUuidCol().newBuff();
				tailEdit.set( (CFBamUuidColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableUuidCol().updateUuidCol( Authorization, tailEdit );
			}
			else if( tailClassCode.equals( "TBLC" ) ) {
				CFBamTableColBuff tailEdit = schema.getFactoryTableCol().newBuff();
				tailEdit.set( (CFBamTableColBuff)tail );
				tailEdit.setOptionalNextTenantId( Buff.getRequiredTenantId() );
				tailEdit.setOptionalNextId( Buff.getRequiredId() );
				schema.getTableTableCol().updateTableCol( Authorization, tailEdit );
			}
			else {
				throw new CFLibUsageException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode " + tailClassCode );
			}
		}
	}

	public CFBamUInt64ColBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readDerived";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt64ColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64ColBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readDerived";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( PKey.getRequiredTenantId() );
		key.setRequiredId( PKey.getRequiredId() );
		CFBamUInt64ColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64ColBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "CFBamRamUInt64Col.readAllDerived";
		CFBamUInt64ColBuff[] retList = new CFBamUInt64ColBuff[ dictByPKey.values().size() ];
		Iterator< CFBamUInt64ColBuff > iter = dictByPKey.values().iterator();
		int idx = 0;
		while( iter.hasNext() ) {
			retList[ idx++ ] = iter.next();
		}
		return( retList );
	}

	public CFBamUInt64ColBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByUNameIdx";
		CFBamValueBuff buff = schema.getTableValue().readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( buff == null ) {
			return( null );
		}
		else if( buff instanceof CFBamUInt64ColBuff ) {
			return( (CFBamUInt64ColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByValTentIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByValTentIdx( Authorization,
			TenantId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByScopeIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByDefSchemaIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByPrevIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByNextIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContPrevIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByContNextIdx";
		CFBamValueBuff buffList[] = schema.getTableValue().readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		if( buffList == null ) {
			return( null );
		}
		else {
			CFBamValueBuff buff;
			ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
			for( int idx = 0; idx < buffList.length; idx ++ ) {
				buff = buffList[idx];
				if( ( buff != null ) && ( buff instanceof CFBamUInt64ColBuff ) ) {
					filteredList.add( (CFBamUInt64ColBuff)buff );
				}
			}
			return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
		}
	}

	public CFBamUInt64ColBuff[] readDerivedByTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readDerivedByTableIdx";
		CFBamUInt64ColByTableIdxKey key = schema.getFactoryUInt64Col().newTableIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredTableId( TableId );

		CFBamUInt64ColBuff[] recArray;
		if( dictByTableIdx.containsKey( key ) ) {
			Map< CFBamValuePKey, CFBamUInt64ColBuff > subdictTableIdx
				= dictByTableIdx.get( key );
			recArray = new CFBamUInt64ColBuff[ subdictTableIdx.size() ];
			Iterator< CFBamUInt64ColBuff > iter = subdictTableIdx.values().iterator();
			int idx = 0;
			while( iter.hasNext() ) {
				recArray[ idx++ ] = iter.next();
			}
		}
		else {
			Map< CFBamValuePKey, CFBamUInt64ColBuff > subdictTableIdx
				= new HashMap< CFBamValuePKey, CFBamUInt64ColBuff >();
			dictByTableIdx.put( key, subdictTableIdx );
			recArray = new CFBamUInt64ColBuff[0];
		}
		return( recArray );
	}

	public CFBamUInt64ColBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readDerivedByIdIdx() ";
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredId( Id );

		CFBamUInt64ColBuff buff;
		if( dictByPKey.containsKey( key ) ) {
			buff = dictByPKey.get( key );
		}
		else {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64ColBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readBuff";
		CFBamUInt64ColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U64C" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64ColBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		CFBamUInt64ColBuff buff = readDerived( Authorization, PKey );
		if( ( buff != null ) && ( ! buff.getClassCode().equals( "U64C" ) ) ) {
			buff = null;
		}
		return( buff );
	}

	public CFBamUInt64ColBuff[] readAllBuff( CFSecAuthorization Authorization )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readAllBuff";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readAllDerived( Authorization );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "U64C" ) ) {
				filteredList.add( buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByIdIdx() ";
		CFBamUInt64ColBuff buff = readDerivedByIdIdx( Authorization,
			TenantId,
			Id );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUInt64ColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64ColBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByUNameIdx() ";
		CFBamUInt64ColBuff buff = readDerivedByUNameIdx( Authorization,
			TenantId,
			ScopeId,
			Name );
		if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
			return( (CFBamUInt64ColBuff)buff );
		}
		else {
			return( null );
		}
	}

	public CFBamUInt64ColBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByValTentIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByValTentIdx( Authorization,
			TenantId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByScopeIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByScopeIdx( Authorization,
			TenantId,
			ScopeId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByDefSchemaIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByDefSchemaIdx( Authorization,
			DefSchemaTenantId,
			DefSchemaId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByPrevIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByPrevIdx( Authorization,
			PrevTenantId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByNextIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByNextIdx( Authorization,
			NextTenantId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContPrevIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByContPrevIdx( Authorization,
			TenantId,
			ScopeId,
			PrevId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "CFBamRamValue.readBuffByContNextIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByContNextIdx( Authorization,
			TenantId,
			ScopeId,
			NextId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "VALU" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	public CFBamUInt64ColBuff[] readBuffByTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId )
	{
		final String S_ProcName = "CFBamRamUInt64Col.readBuffByTableIdx() ";
		CFBamUInt64ColBuff buff;
		ArrayList<CFBamUInt64ColBuff> filteredList = new ArrayList<CFBamUInt64ColBuff>();
		CFBamUInt64ColBuff[] buffList = readDerivedByTableIdx( Authorization,
			TenantId,
			TableId );
		for( int idx = 0; idx < buffList.length; idx ++ ) {
			buff = buffList[idx];
			if( ( buff != null ) && buff.getClassCode().equals( "U64C" ) ) {
				filteredList.add( (CFBamUInt64ColBuff)buff );
			}
		}
		return( filteredList.toArray( new CFBamUInt64ColBuff[0] ) );
	}

	/**
	 *	Read a page array of the specific UInt64Col buffer instances identified by the duplicate key TableIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The UInt64Col key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFBamUInt64ColBuff[] pageBuffByTableIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TableId,
		Long priorTenantId,
		Long priorId )
	{
		final String S_ProcName = "pageBuffByTableIdx";
		throw new CFLibNotImplementedYetException( getClass(), S_ProcName );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt64ColBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffUp";

		CFBamValueBuff grandprev = null;
		CFBamValueBuff prev = null;
		CFBamValueBuff cur = null;
		CFBamValueBuff next = null;

		cur = schema.getTableValue().readDerivedByIdIdx(Authorization, TenantId, Id);
		if( cur == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object" );
		}

		if( ( cur.getOptionalPrevTenantId() == null )
			&& ( cur.getOptionalPrevId() == null ) )
		{
			return( (CFBamUInt64ColBuff)cur );
		}

		prev = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevTenantId(), cur.getOptionalPrevId() );
		if( prev == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object.prev" );
		}

		if( ( prev.getOptionalPrevTenantId() != null )
			&& ( prev.getOptionalPrevId() != null ) )
		{
			grandprev = schema.getTableValue().readDerivedByIdIdx(Authorization, prev.getOptionalPrevTenantId(), prev.getOptionalPrevId() );
			if( grandprev == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.prev.prev" );
			}
		}

		if( ( cur.getOptionalNextTenantId() != null )
			&& ( cur.getOptionalNextId() != null ) )
		{
			next = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextTenantId(), cur.getOptionalNextId() );
			if( next == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.next" );
			}
		}

		String classCode = prev.getClassCode();
		CFBamValueBuff newInstance;
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editPrev = newInstance;
		editPrev.set( prev );

		classCode = cur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editCur = newInstance;
		editCur.set( cur );

		CFBamValueBuff editGrandprev = null;
		if( grandprev != null ) {
			classCode = grandprev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editGrandprev = newInstance;
			editGrandprev.set( grandprev );
		}

		CFBamValueBuff editNext = null;
		if( next != null ) {
			classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editNext = newInstance;
			editNext.set( next );
		}

		if( editGrandprev != null ) {
			editGrandprev.setOptionalNextTenantId( cur.getRequiredTenantId() );
			editGrandprev.setOptionalNextId( cur.getRequiredId() );
			editCur.setOptionalPrevTenantId( grandprev.getRequiredTenantId() );
			editCur.setOptionalPrevId( grandprev.getRequiredId() );
		}
		else {
			editCur.setOptionalPrevTenantId( null );
			editCur.setOptionalPrevId( null );
		}

			editPrev.setOptionalPrevTenantId( cur.getRequiredTenantId() );
			editPrev.setOptionalPrevId( cur.getRequiredId() );

			editCur.setOptionalNextTenantId( prev.getRequiredTenantId() );
			editCur.setOptionalNextId( prev.getRequiredId() );

		if( next != null ) {
			editPrev.setOptionalNextTenantId( next.getRequiredTenantId() );
			editPrev.setOptionalNextId( next.getRequiredId() );
			editNext.setOptionalPrevTenantId( prev.getRequiredTenantId() );
			editNext.setOptionalPrevId( prev.getRequiredId() );
		}
		else {
			editPrev.setOptionalNextTenantId( null );
			editPrev.setOptionalNextId( null );
		}

		if( editGrandprev != null ) {
			classCode = editGrandprev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editGrandprev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editGrandprev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editGrandprev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editGrandprev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editGrandprev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editGrandprev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editGrandprev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editGrandprev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editGrandprev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editGrandprev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editGrandprev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editGrandprev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editGrandprev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editGrandprev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editGrandprev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editGrandprev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editGrandprev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editGrandprev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editGrandprev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editGrandprev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editGrandprev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editGrandprev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editGrandprev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editGrandprev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		classCode = editPrev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		classCode = editCur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editCur );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editCur );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editCur );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editCur );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editCur );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editCur );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editCur );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editCur );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editCur );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editCur );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editCur );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editCur );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editCur );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editCur );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editCur );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editCur );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editCur );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editCur );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editCur );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editCur );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editCur );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editCur );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editCur );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editCur );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editCur );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editCur );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editCur );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editCur );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editCur );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editCur );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editCur );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editCur );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editCur );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editCur );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editCur );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editCur );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editCur );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editCur );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editCur );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editCur );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editCur );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editCur );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editCur );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editCur );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editCur );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editCur );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editCur );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editCur );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editCur );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editCur );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editCur );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editCur );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editCur );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editCur );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editCur );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editCur );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editCur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		if( editNext != null ) {
			classCode = editNext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		return( (CFBamUInt64ColBuff)editCur );
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamUInt64ColBuff moveBuffDown( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffDown";

		CFBamValueBuff prev = null;
		CFBamValueBuff cur = null;
		CFBamValueBuff next = null;
		CFBamValueBuff grandnext = null;

		cur = schema.getTableValue().readDerivedByIdIdx(Authorization, TenantId, Id);
		if( cur == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object" );
		}

		if( ( cur.getOptionalNextTenantId() == null )
			&& ( cur.getOptionalNextId() == null ) )
		{
			return( (CFBamUInt64ColBuff)cur );
		}

		next = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalNextTenantId(), cur.getOptionalNextId() );
		if( next == null ) {
			throw new CFLibCollisionDetectedException( getClass(),
				S_ProcName,
				"Could not locate object.next" );
		}

		if( ( next.getOptionalNextTenantId() != null )
			&& ( next.getOptionalNextId() != null ) )
		{
			grandnext = schema.getTableValue().readDerivedByIdIdx(Authorization, next.getOptionalNextTenantId(), next.getOptionalNextId() );
			if( grandnext == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.next.next" );
			}
		}

		if( ( cur.getOptionalPrevTenantId() != null )
			&& ( cur.getOptionalPrevId() != null ) )
		{
			prev = schema.getTableValue().readDerivedByIdIdx(Authorization, cur.getOptionalPrevTenantId(), cur.getOptionalPrevId() );
			if( prev == null ) {
				throw new CFLibCollisionDetectedException( getClass(),
					S_ProcName,
					"Could not locate object.prev" );
			}
		}

		String classCode = cur.getClassCode();
		CFBamValueBuff newInstance;
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editCur = newInstance;
		editCur.set( cur );

		classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		CFBamValueBuff editNext = newInstance;
		editNext.set( next );

		CFBamValueBuff editGrandnext = null;
		if( grandnext != null ) {
			classCode = grandnext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editGrandnext = newInstance;
			editGrandnext.set( grandnext );
		}

		CFBamValueBuff editPrev = null;
		if( prev != null ) {
			classCode = prev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				newInstance = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				newInstance = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				newInstance = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				newInstance = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				newInstance = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				newInstance = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				newInstance = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				newInstance = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				newInstance = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				newInstance = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				newInstance = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				newInstance = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				newInstance = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				newInstance = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				newInstance = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				newInstance = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				newInstance = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				newInstance = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				newInstance = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				newInstance = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				newInstance = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				newInstance = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				newInstance = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				newInstance = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				newInstance = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				newInstance = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				newInstance = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				newInstance = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				newInstance = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				newInstance = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				newInstance = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				newInstance = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				newInstance = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				newInstance = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				newInstance = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				newInstance = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				newInstance = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				newInstance = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				newInstance = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				newInstance = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				newInstance = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				newInstance = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				newInstance = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				newInstance = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				newInstance = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				newInstance = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				newInstance = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				newInstance = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				newInstance = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				newInstance = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				newInstance = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				newInstance = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				newInstance = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				newInstance = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				newInstance = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				newInstance = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				newInstance = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				newInstance = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				newInstance = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				newInstance = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				newInstance = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				newInstance = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				newInstance = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				newInstance = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				newInstance = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				newInstance = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				newInstance = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				newInstance = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				newInstance = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				newInstance = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				newInstance = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				newInstance = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				newInstance = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				newInstance = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				newInstance = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				newInstance = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				newInstance = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				newInstance = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editPrev = newInstance;
			editPrev.set( prev );
		}

		if( prev != null ) {
			editPrev.setOptionalNextTenantId( next.getRequiredTenantId() );
			editPrev.setOptionalNextId( next.getRequiredId() );
			editNext.setOptionalPrevTenantId( prev.getRequiredTenantId() );
			editNext.setOptionalPrevId( prev.getRequiredId() );
		}
		else {
			editNext.setOptionalPrevTenantId( null );
			editNext.setOptionalPrevId( null );
		}

			editCur.setOptionalPrevTenantId( next.getRequiredTenantId() );
			editCur.setOptionalPrevId( next.getRequiredId() );

			editNext.setOptionalNextTenantId( cur.getRequiredTenantId() );
			editNext.setOptionalNextId( cur.getRequiredId() );

		if( editGrandnext != null ) {
			editCur.setOptionalNextTenantId( grandnext.getRequiredTenantId() );
			editCur.setOptionalNextId( grandnext.getRequiredId() );
			editGrandnext.setOptionalPrevTenantId( cur.getRequiredTenantId() );
			editGrandnext.setOptionalPrevId( cur.getRequiredId() );
		}
		else {
			editCur.setOptionalNextTenantId( null );
			editCur.setOptionalNextId( null );
		}

		if( editPrev != null ) {
			classCode = editPrev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		classCode = editCur.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editCur );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editCur );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editCur );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editCur );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editCur );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editCur );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editCur );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editCur );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editCur );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editCur );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editCur );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editCur );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editCur );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editCur );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editCur );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editCur );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editCur );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editCur );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editCur );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editCur );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editCur );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editCur );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editCur );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editCur );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editCur );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editCur );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editCur );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editCur );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editCur );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editCur );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editCur );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editCur );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editCur );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editCur );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editCur );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editCur );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editCur );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editCur );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editCur );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editCur );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editCur );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editCur );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editCur );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editCur );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editCur );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editCur );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editCur );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editCur );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editCur );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editCur );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editCur );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editCur );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editCur );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editCur );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editCur );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editCur );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editCur );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editCur );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editCur );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editCur );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editCur );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editCur );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editCur );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editCur );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editCur );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editCur );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editCur );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editCur );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		classCode = editNext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}

		if( editGrandnext != null ) {
			classCode = editGrandnext.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editGrandnext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editGrandnext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editGrandnext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editGrandnext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editGrandnext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editGrandnext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editGrandnext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editGrandnext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editGrandnext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editGrandnext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editGrandnext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editGrandnext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editGrandnext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editGrandnext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editGrandnext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editGrandnext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editGrandnext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editGrandnext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editGrandnext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editGrandnext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editGrandnext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editGrandnext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editGrandnext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editGrandnext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		return( (CFBamUInt64ColBuff)editCur );
	}

	public void updateUInt64Col( CFSecAuthorization Authorization,
		CFBamUInt64ColBuff Buff )
	{
		schema.getTableUInt64Def().updateUInt64Def( Authorization,
			Buff );
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt64ColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			throw new CFLibStaleCacheDetectedException( getClass(),
				"updateUInt64Col",
				"Existing record not found",
				"UInt64Col",
				pkey );
		}
		CFBamUInt64ColByTableIdxKey existingKeyTableIdx = schema.getFactoryUInt64Col().newTableIdxKey();
		existingKeyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		existingKeyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		CFBamUInt64ColByTableIdxKey newKeyTableIdx = schema.getFactoryUInt64Col().newTableIdxKey();
		newKeyTableIdx.setRequiredTenantId( Buff.getRequiredTenantId() );
		newKeyTableIdx.setRequiredTableId( Buff.getRequiredTableId() );

		// Check unique indexes

		// Validate foreign keys

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableUInt64Def().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateUInt64Col",
						"Superclass",
						"SuperClass",
						"UInt64Def",
						null );
				}
			}
		}

		{
			boolean allNull = true;

			if( allNull ) {
				if( null == schema.getTableTable().readDerivedByIdIdx( Authorization,
						Buff.getRequiredTenantId(),
						Buff.getRequiredTableId() ) )
				{
					throw new CFLibUnresolvedRelationException( getClass(),
						"updateUInt64Col",
						"Container",
						"Table",
						"Table",
						null );
				}
			}
		}

		// Update is valid

		Map< CFBamValuePKey, CFBamUInt64ColBuff > subdict;

		dictByPKey.remove( pkey );
		dictByPKey.put( pkey, Buff );

		subdict = dictByTableIdx.get( existingKeyTableIdx );
		if( subdict != null ) {
			subdict.remove( pkey );
		}
		if( dictByTableIdx.containsKey( newKeyTableIdx ) ) {
			subdict = dictByTableIdx.get( newKeyTableIdx );
		}
		else {
			subdict = new HashMap< CFBamValuePKey, CFBamUInt64ColBuff >();
			dictByTableIdx.put( newKeyTableIdx, subdict );
		}
		subdict.put( pkey, Buff );

	}

	public void deleteUInt64Col( CFSecAuthorization Authorization,
		CFBamUInt64ColBuff Buff )
	{
		final String S_ProcName = "CFBamRamUInt64ColTable.deleteUInt64Col() ";
		String classCode;
		CFBamValuePKey pkey = schema.getFactoryValue().newPKey();
		pkey.setRequiredTenantId( Buff.getRequiredTenantId() );
		pkey.setRequiredId( Buff.getRequiredId() );
		CFBamUInt64ColBuff existing = dictByPKey.get( pkey );
		if( existing == null ) {
			return;
		}
		if( existing.getRequiredRevision() != Buff.getRequiredRevision() )
		{
			throw new CFLibCollisionDetectedException( getClass(),
				"deleteUInt64Col",
				pkey );
		}
		long varTenantId = existing.getRequiredTenantId();
		long varTableId = existing.getRequiredTableId();
		CFBamTableBuff container = schema.getTableTable().readDerivedByIdIdx( Authorization,
			varTenantId,
			varTableId );
		if( container == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"container" );
		}

		Long prevTenantId = existing.getOptionalPrevTenantId();
		Long prevId = existing.getOptionalPrevId();
		Long nextTenantId = existing.getOptionalNextTenantId();
		Long nextId = existing.getOptionalNextId();

		CFBamValueBuff prev = null;
		if( ( prevTenantId != null )
			&& ( prevId != null ) )
		{
			prev = schema.getTableValue().readDerivedByIdIdx( Authorization,
				prevTenantId,
				prevId );
			if( prev == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"prev" );
			}
			CFBamValueBuff editPrev;
			classCode = prev.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				editPrev = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				editPrev = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				editPrev = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				editPrev = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				editPrev = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				editPrev = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				editPrev = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				editPrev = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				editPrev = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				editPrev = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				editPrev = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				editPrev = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				editPrev = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				editPrev = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				editPrev = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				editPrev = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				editPrev = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				editPrev = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				editPrev = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				editPrev = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				editPrev = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				editPrev = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				editPrev = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				editPrev = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				editPrev = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				editPrev = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				editPrev = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				editPrev = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				editPrev = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				editPrev = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				editPrev = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				editPrev = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				editPrev = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				editPrev = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				editPrev = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				editPrev = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				editPrev = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				editPrev = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				editPrev = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				editPrev = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				editPrev = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				editPrev = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				editPrev = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				editPrev = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				editPrev = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				editPrev = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				editPrev = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				editPrev = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				editPrev = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				editPrev = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				editPrev = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				editPrev = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				editPrev = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				editPrev = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				editPrev = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				editPrev = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				editPrev = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				editPrev = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				editPrev = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				editPrev = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				editPrev = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				editPrev = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				editPrev = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				editPrev = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				editPrev = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				editPrev = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				editPrev = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				editPrev = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				editPrev = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				editPrev = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				editPrev = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				editPrev = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				editPrev = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				editPrev = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				editPrev = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				editPrev = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				editPrev = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				editPrev = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editPrev.set( prev );
			editPrev.setOptionalNextTenantId( nextTenantId );
			editPrev.setOptionalNextId( nextId );
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editPrev );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editPrev );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editPrev );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editPrev );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editPrev );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editPrev );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editPrev );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editPrev );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editPrev );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editPrev );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editPrev );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editPrev );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editPrev );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editPrev );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editPrev );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editPrev );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editPrev );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editPrev );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editPrev );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editPrev );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editPrev );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editPrev );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editPrev );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editPrev );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editPrev );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editPrev );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editPrev );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editPrev );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editPrev );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editPrev );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editPrev );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editPrev );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editPrev );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editPrev );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editPrev );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editPrev );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editPrev );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editPrev );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editPrev );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editPrev );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editPrev );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editPrev );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editPrev );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editPrev );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editPrev );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editPrev );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editPrev );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editPrev );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editPrev );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editPrev );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editPrev );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editPrev );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editPrev );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editPrev );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editPrev );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editPrev );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editPrev );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editPrev );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editPrev );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editPrev );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		CFBamValueBuff next = null;
		if( ( nextTenantId != null )
			&& ( nextId != null ) )
		{
			next = schema.getTableValue().readDerivedByIdIdx( Authorization,
				nextTenantId,
				nextId );
			if( next == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"next" );
			}
			CFBamValueBuff editNext;
			classCode = next.getClassCode();
			if( classCode.equals( "VALU" ) ) {
				editNext = schema.getFactoryValue().newBuff();
			}
			else if( classCode.equals( "ATOM" ) ) {
				editNext = schema.getFactoryAtom().newBuff();
			}
			else if( classCode.equals( "BLBD" ) ) {
				editNext = schema.getFactoryBlobDef().newBuff();
			}
			else if( classCode.equals( "BLBT" ) ) {
				editNext = schema.getFactoryBlobType().newBuff();
			}
			else if( classCode.equals( "BLBC" ) ) {
				editNext = schema.getFactoryBlobCol().newBuff();
			}
			else if( classCode.equals( "BOLD" ) ) {
				editNext = schema.getFactoryBoolDef().newBuff();
			}
			else if( classCode.equals( "BOLT" ) ) {
				editNext = schema.getFactoryBoolType().newBuff();
			}
			else if( classCode.equals( "BOLC" ) ) {
				editNext = schema.getFactoryBoolCol().newBuff();
			}
			else if( classCode.equals( "DATD" ) ) {
				editNext = schema.getFactoryDateDef().newBuff();
			}
			else if( classCode.equals( "DATT" ) ) {
				editNext = schema.getFactoryDateType().newBuff();
			}
			else if( classCode.equals( "DATC" ) ) {
				editNext = schema.getFactoryDateCol().newBuff();
			}
			else if( classCode.equals( "DBLD" ) ) {
				editNext = schema.getFactoryDoubleDef().newBuff();
			}
			else if( classCode.equals( "DBLT" ) ) {
				editNext = schema.getFactoryDoubleType().newBuff();
			}
			else if( classCode.equals( "DBLC" ) ) {
				editNext = schema.getFactoryDoubleCol().newBuff();
			}
			else if( classCode.equals( "FLTD" ) ) {
				editNext = schema.getFactoryFloatDef().newBuff();
			}
			else if( classCode.equals( "FLTT" ) ) {
				editNext = schema.getFactoryFloatType().newBuff();
			}
			else if( classCode.equals( "FLTC" ) ) {
				editNext = schema.getFactoryFloatCol().newBuff();
			}
			else if( classCode.equals( "I16D" ) ) {
				editNext = schema.getFactoryInt16Def().newBuff();
			}
			else if( classCode.equals( "I16T" ) ) {
				editNext = schema.getFactoryInt16Type().newBuff();
			}
			else if( classCode.equals( "IG16" ) ) {
				editNext = schema.getFactoryId16Gen().newBuff();
			}
			else if( classCode.equals( "ENMD" ) ) {
				editNext = schema.getFactoryEnumDef().newBuff();
			}
			else if( classCode.equals( "ENMT" ) ) {
				editNext = schema.getFactoryEnumType().newBuff();
			}
			else if( classCode.equals( "I16C" ) ) {
				editNext = schema.getFactoryInt16Col().newBuff();
			}
			else if( classCode.equals( "I32D" ) ) {
				editNext = schema.getFactoryInt32Def().newBuff();
			}
			else if( classCode.equals( "I32T" ) ) {
				editNext = schema.getFactoryInt32Type().newBuff();
			}
			else if( classCode.equals( "IG32" ) ) {
				editNext = schema.getFactoryId32Gen().newBuff();
			}
			else if( classCode.equals( "I32C" ) ) {
				editNext = schema.getFactoryInt32Col().newBuff();
			}
			else if( classCode.equals( "I64D" ) ) {
				editNext = schema.getFactoryInt64Def().newBuff();
			}
			else if( classCode.equals( "I64T" ) ) {
				editNext = schema.getFactoryInt64Type().newBuff();
			}
			else if( classCode.equals( "IG64" ) ) {
				editNext = schema.getFactoryId64Gen().newBuff();
			}
			else if( classCode.equals( "I64C" ) ) {
				editNext = schema.getFactoryInt64Col().newBuff();
			}
			else if( classCode.equals( "NTKD" ) ) {
				editNext = schema.getFactoryNmTokenDef().newBuff();
			}
			else if( classCode.equals( "NTKT" ) ) {
				editNext = schema.getFactoryNmTokenType().newBuff();
			}
			else if( classCode.equals( "NTKC" ) ) {
				editNext = schema.getFactoryNmTokenCol().newBuff();
			}
			else if( classCode.equals( "NTSD" ) ) {
				editNext = schema.getFactoryNmTokensDef().newBuff();
			}
			else if( classCode.equals( "NTST" ) ) {
				editNext = schema.getFactoryNmTokensType().newBuff();
			}
			else if( classCode.equals( "NTSC" ) ) {
				editNext = schema.getFactoryNmTokensCol().newBuff();
			}
			else if( classCode.equals( "NUMD" ) ) {
				editNext = schema.getFactoryNumberDef().newBuff();
			}
			else if( classCode.equals( "NUMT" ) ) {
				editNext = schema.getFactoryNumberType().newBuff();
			}
			else if( classCode.equals( "NUMC" ) ) {
				editNext = schema.getFactoryNumberCol().newBuff();
			}
			else if( classCode.equals( "STRD" ) ) {
				editNext = schema.getFactoryStringDef().newBuff();
			}
			else if( classCode.equals( "STRT" ) ) {
				editNext = schema.getFactoryStringType().newBuff();
			}
			else if( classCode.equals( "STRC" ) ) {
				editNext = schema.getFactoryStringCol().newBuff();
			}
			else if( classCode.equals( "DAZD" ) ) {
				editNext = schema.getFactoryTZDateDef().newBuff();
			}
			else if( classCode.equals( "DAZT" ) ) {
				editNext = schema.getFactoryTZDateType().newBuff();
			}
			else if( classCode.equals( "DAZC" ) ) {
				editNext = schema.getFactoryTZDateCol().newBuff();
			}
			else if( classCode.equals( "TMZD" ) ) {
				editNext = schema.getFactoryTZTimeDef().newBuff();
			}
			else if( classCode.equals( "TMZT" ) ) {
				editNext = schema.getFactoryTZTimeType().newBuff();
			}
			else if( classCode.equals( "TMZC" ) ) {
				editNext = schema.getFactoryTZTimeCol().newBuff();
			}
			else if( classCode.equals( "ZSTD" ) ) {
				editNext = schema.getFactoryTZTimestampDef().newBuff();
			}
			else if( classCode.equals( "ZSTT" ) ) {
				editNext = schema.getFactoryTZTimestampType().newBuff();
			}
			else if( classCode.equals( "ZSTC" ) ) {
				editNext = schema.getFactoryTZTimestampCol().newBuff();
			}
			else if( classCode.equals( "TXTD" ) ) {
				editNext = schema.getFactoryTextDef().newBuff();
			}
			else if( classCode.equals( "TXTT" ) ) {
				editNext = schema.getFactoryTextType().newBuff();
			}
			else if( classCode.equals( "TXTC" ) ) {
				editNext = schema.getFactoryTextCol().newBuff();
			}
			else if( classCode.equals( "TIMD" ) ) {
				editNext = schema.getFactoryTimeDef().newBuff();
			}
			else if( classCode.equals( "TIMT" ) ) {
				editNext = schema.getFactoryTimeType().newBuff();
			}
			else if( classCode.equals( "TIMC" ) ) {
				editNext = schema.getFactoryTimeCol().newBuff();
			}
			else if( classCode.equals( "TSPD" ) ) {
				editNext = schema.getFactoryTimestampDef().newBuff();
			}
			else if( classCode.equals( "TSPT" ) ) {
				editNext = schema.getFactoryTimestampType().newBuff();
			}
			else if( classCode.equals( "TSPC" ) ) {
				editNext = schema.getFactoryTimestampCol().newBuff();
			}
			else if( classCode.equals( "TKND" ) ) {
				editNext = schema.getFactoryTokenDef().newBuff();
			}
			else if( classCode.equals( "TKNT" ) ) {
				editNext = schema.getFactoryTokenType().newBuff();
			}
			else if( classCode.equals( "TKNC" ) ) {
				editNext = schema.getFactoryTokenCol().newBuff();
			}
			else if( classCode.equals( "U16D" ) ) {
				editNext = schema.getFactoryUInt16Def().newBuff();
			}
			else if( classCode.equals( "U16T" ) ) {
				editNext = schema.getFactoryUInt16Type().newBuff();
			}
			else if( classCode.equals( "U16C" ) ) {
				editNext = schema.getFactoryUInt16Col().newBuff();
			}
			else if( classCode.equals( "U32D" ) ) {
				editNext = schema.getFactoryUInt32Def().newBuff();
			}
			else if( classCode.equals( "U32T" ) ) {
				editNext = schema.getFactoryUInt32Type().newBuff();
			}
			else if( classCode.equals( "U32C" ) ) {
				editNext = schema.getFactoryUInt32Col().newBuff();
			}
			else if( classCode.equals( "U64D" ) ) {
				editNext = schema.getFactoryUInt64Def().newBuff();
			}
			else if( classCode.equals( "U64T" ) ) {
				editNext = schema.getFactoryUInt64Type().newBuff();
			}
			else if( classCode.equals( "U64C" ) ) {
				editNext = schema.getFactoryUInt64Col().newBuff();
			}
			else if( classCode.equals( "UIDD" ) ) {
				editNext = schema.getFactoryUuidDef().newBuff();
			}
			else if( classCode.equals( "UIDT" ) ) {
				editNext = schema.getFactoryUuidType().newBuff();
			}
			else if( classCode.equals( "IGUU" ) ) {
				editNext = schema.getFactoryUuidGen().newBuff();
			}
			else if( classCode.equals( "UIDC" ) ) {
				editNext = schema.getFactoryUuidCol().newBuff();
			}
			else if( classCode.equals( "TBLC" ) ) {
				editNext = schema.getFactoryTableCol().newBuff();
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
			editNext.set( next );
			editNext.setOptionalPrevTenantId( prevTenantId );
			editNext.setOptionalPrevId( prevId );
			if( classCode.equals( "VALU" ) ) {
				schema.getTableValue().updateValue( Authorization, editNext );
			}
			else if( classCode.equals( "ATOM" ) ) {
				schema.getTableAtom().updateAtom( Authorization, (CFBamAtomBuff)editNext );
			}
			else if( classCode.equals( "BLBD" ) ) {
				schema.getTableBlobDef().updateBlobDef( Authorization, (CFBamBlobDefBuff)editNext );
			}
			else if( classCode.equals( "BLBT" ) ) {
				schema.getTableBlobType().updateBlobType( Authorization, (CFBamBlobTypeBuff)editNext );
			}
			else if( classCode.equals( "BLBC" ) ) {
				schema.getTableBlobCol().updateBlobCol( Authorization, (CFBamBlobColBuff)editNext );
			}
			else if( classCode.equals( "BOLD" ) ) {
				schema.getTableBoolDef().updateBoolDef( Authorization, (CFBamBoolDefBuff)editNext );
			}
			else if( classCode.equals( "BOLT" ) ) {
				schema.getTableBoolType().updateBoolType( Authorization, (CFBamBoolTypeBuff)editNext );
			}
			else if( classCode.equals( "BOLC" ) ) {
				schema.getTableBoolCol().updateBoolCol( Authorization, (CFBamBoolColBuff)editNext );
			}
			else if( classCode.equals( "DATD" ) ) {
				schema.getTableDateDef().updateDateDef( Authorization, (CFBamDateDefBuff)editNext );
			}
			else if( classCode.equals( "DATT" ) ) {
				schema.getTableDateType().updateDateType( Authorization, (CFBamDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DATC" ) ) {
				schema.getTableDateCol().updateDateCol( Authorization, (CFBamDateColBuff)editNext );
			}
			else if( classCode.equals( "DBLD" ) ) {
				schema.getTableDoubleDef().updateDoubleDef( Authorization, (CFBamDoubleDefBuff)editNext );
			}
			else if( classCode.equals( "DBLT" ) ) {
				schema.getTableDoubleType().updateDoubleType( Authorization, (CFBamDoubleTypeBuff)editNext );
			}
			else if( classCode.equals( "DBLC" ) ) {
				schema.getTableDoubleCol().updateDoubleCol( Authorization, (CFBamDoubleColBuff)editNext );
			}
			else if( classCode.equals( "FLTD" ) ) {
				schema.getTableFloatDef().updateFloatDef( Authorization, (CFBamFloatDefBuff)editNext );
			}
			else if( classCode.equals( "FLTT" ) ) {
				schema.getTableFloatType().updateFloatType( Authorization, (CFBamFloatTypeBuff)editNext );
			}
			else if( classCode.equals( "FLTC" ) ) {
				schema.getTableFloatCol().updateFloatCol( Authorization, (CFBamFloatColBuff)editNext );
			}
			else if( classCode.equals( "I16D" ) ) {
				schema.getTableInt16Def().updateInt16Def( Authorization, (CFBamInt16DefBuff)editNext );
			}
			else if( classCode.equals( "I16T" ) ) {
				schema.getTableInt16Type().updateInt16Type( Authorization, (CFBamInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "IG16" ) ) {
				schema.getTableId16Gen().updateId16Gen( Authorization, (CFBamId16GenBuff)editNext );
			}
			else if( classCode.equals( "ENMD" ) ) {
				schema.getTableEnumDef().updateEnumDef( Authorization, (CFBamEnumDefBuff)editNext );
			}
			else if( classCode.equals( "ENMT" ) ) {
				schema.getTableEnumType().updateEnumType( Authorization, (CFBamEnumTypeBuff)editNext );
			}
			else if( classCode.equals( "I16C" ) ) {
				schema.getTableInt16Col().updateInt16Col( Authorization, (CFBamInt16ColBuff)editNext );
			}
			else if( classCode.equals( "I32D" ) ) {
				schema.getTableInt32Def().updateInt32Def( Authorization, (CFBamInt32DefBuff)editNext );
			}
			else if( classCode.equals( "I32T" ) ) {
				schema.getTableInt32Type().updateInt32Type( Authorization, (CFBamInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "IG32" ) ) {
				schema.getTableId32Gen().updateId32Gen( Authorization, (CFBamId32GenBuff)editNext );
			}
			else if( classCode.equals( "I32C" ) ) {
				schema.getTableInt32Col().updateInt32Col( Authorization, (CFBamInt32ColBuff)editNext );
			}
			else if( classCode.equals( "I64D" ) ) {
				schema.getTableInt64Def().updateInt64Def( Authorization, (CFBamInt64DefBuff)editNext );
			}
			else if( classCode.equals( "I64T" ) ) {
				schema.getTableInt64Type().updateInt64Type( Authorization, (CFBamInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "IG64" ) ) {
				schema.getTableId64Gen().updateId64Gen( Authorization, (CFBamId64GenBuff)editNext );
			}
			else if( classCode.equals( "I64C" ) ) {
				schema.getTableInt64Col().updateInt64Col( Authorization, (CFBamInt64ColBuff)editNext );
			}
			else if( classCode.equals( "NTKD" ) ) {
				schema.getTableNmTokenDef().updateNmTokenDef( Authorization, (CFBamNmTokenDefBuff)editNext );
			}
			else if( classCode.equals( "NTKT" ) ) {
				schema.getTableNmTokenType().updateNmTokenType( Authorization, (CFBamNmTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "NTKC" ) ) {
				schema.getTableNmTokenCol().updateNmTokenCol( Authorization, (CFBamNmTokenColBuff)editNext );
			}
			else if( classCode.equals( "NTSD" ) ) {
				schema.getTableNmTokensDef().updateNmTokensDef( Authorization, (CFBamNmTokensDefBuff)editNext );
			}
			else if( classCode.equals( "NTST" ) ) {
				schema.getTableNmTokensType().updateNmTokensType( Authorization, (CFBamNmTokensTypeBuff)editNext );
			}
			else if( classCode.equals( "NTSC" ) ) {
				schema.getTableNmTokensCol().updateNmTokensCol( Authorization, (CFBamNmTokensColBuff)editNext );
			}
			else if( classCode.equals( "NUMD" ) ) {
				schema.getTableNumberDef().updateNumberDef( Authorization, (CFBamNumberDefBuff)editNext );
			}
			else if( classCode.equals( "NUMT" ) ) {
				schema.getTableNumberType().updateNumberType( Authorization, (CFBamNumberTypeBuff)editNext );
			}
			else if( classCode.equals( "NUMC" ) ) {
				schema.getTableNumberCol().updateNumberCol( Authorization, (CFBamNumberColBuff)editNext );
			}
			else if( classCode.equals( "STRD" ) ) {
				schema.getTableStringDef().updateStringDef( Authorization, (CFBamStringDefBuff)editNext );
			}
			else if( classCode.equals( "STRT" ) ) {
				schema.getTableStringType().updateStringType( Authorization, (CFBamStringTypeBuff)editNext );
			}
			else if( classCode.equals( "STRC" ) ) {
				schema.getTableStringCol().updateStringCol( Authorization, (CFBamStringColBuff)editNext );
			}
			else if( classCode.equals( "DAZD" ) ) {
				schema.getTableTZDateDef().updateTZDateDef( Authorization, (CFBamTZDateDefBuff)editNext );
			}
			else if( classCode.equals( "DAZT" ) ) {
				schema.getTableTZDateType().updateTZDateType( Authorization, (CFBamTZDateTypeBuff)editNext );
			}
			else if( classCode.equals( "DAZC" ) ) {
				schema.getTableTZDateCol().updateTZDateCol( Authorization, (CFBamTZDateColBuff)editNext );
			}
			else if( classCode.equals( "TMZD" ) ) {
				schema.getTableTZTimeDef().updateTZTimeDef( Authorization, (CFBamTZTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TMZT" ) ) {
				schema.getTableTZTimeType().updateTZTimeType( Authorization, (CFBamTZTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TMZC" ) ) {
				schema.getTableTZTimeCol().updateTZTimeCol( Authorization, (CFBamTZTimeColBuff)editNext );
			}
			else if( classCode.equals( "ZSTD" ) ) {
				schema.getTableTZTimestampDef().updateTZTimestampDef( Authorization, (CFBamTZTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "ZSTT" ) ) {
				schema.getTableTZTimestampType().updateTZTimestampType( Authorization, (CFBamTZTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "ZSTC" ) ) {
				schema.getTableTZTimestampCol().updateTZTimestampCol( Authorization, (CFBamTZTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TXTD" ) ) {
				schema.getTableTextDef().updateTextDef( Authorization, (CFBamTextDefBuff)editNext );
			}
			else if( classCode.equals( "TXTT" ) ) {
				schema.getTableTextType().updateTextType( Authorization, (CFBamTextTypeBuff)editNext );
			}
			else if( classCode.equals( "TXTC" ) ) {
				schema.getTableTextCol().updateTextCol( Authorization, (CFBamTextColBuff)editNext );
			}
			else if( classCode.equals( "TIMD" ) ) {
				schema.getTableTimeDef().updateTimeDef( Authorization, (CFBamTimeDefBuff)editNext );
			}
			else if( classCode.equals( "TIMT" ) ) {
				schema.getTableTimeType().updateTimeType( Authorization, (CFBamTimeTypeBuff)editNext );
			}
			else if( classCode.equals( "TIMC" ) ) {
				schema.getTableTimeCol().updateTimeCol( Authorization, (CFBamTimeColBuff)editNext );
			}
			else if( classCode.equals( "TSPD" ) ) {
				schema.getTableTimestampDef().updateTimestampDef( Authorization, (CFBamTimestampDefBuff)editNext );
			}
			else if( classCode.equals( "TSPT" ) ) {
				schema.getTableTimestampType().updateTimestampType( Authorization, (CFBamTimestampTypeBuff)editNext );
			}
			else if( classCode.equals( "TSPC" ) ) {
				schema.getTableTimestampCol().updateTimestampCol( Authorization, (CFBamTimestampColBuff)editNext );
			}
			else if( classCode.equals( "TKND" ) ) {
				schema.getTableTokenDef().updateTokenDef( Authorization, (CFBamTokenDefBuff)editNext );
			}
			else if( classCode.equals( "TKNT" ) ) {
				schema.getTableTokenType().updateTokenType( Authorization, (CFBamTokenTypeBuff)editNext );
			}
			else if( classCode.equals( "TKNC" ) ) {
				schema.getTableTokenCol().updateTokenCol( Authorization, (CFBamTokenColBuff)editNext );
			}
			else if( classCode.equals( "U16D" ) ) {
				schema.getTableUInt16Def().updateUInt16Def( Authorization, (CFBamUInt16DefBuff)editNext );
			}
			else if( classCode.equals( "U16T" ) ) {
				schema.getTableUInt16Type().updateUInt16Type( Authorization, (CFBamUInt16TypeBuff)editNext );
			}
			else if( classCode.equals( "U16C" ) ) {
				schema.getTableUInt16Col().updateUInt16Col( Authorization, (CFBamUInt16ColBuff)editNext );
			}
			else if( classCode.equals( "U32D" ) ) {
				schema.getTableUInt32Def().updateUInt32Def( Authorization, (CFBamUInt32DefBuff)editNext );
			}
			else if( classCode.equals( "U32T" ) ) {
				schema.getTableUInt32Type().updateUInt32Type( Authorization, (CFBamUInt32TypeBuff)editNext );
			}
			else if( classCode.equals( "U32C" ) ) {
				schema.getTableUInt32Col().updateUInt32Col( Authorization, (CFBamUInt32ColBuff)editNext );
			}
			else if( classCode.equals( "U64D" ) ) {
				schema.getTableUInt64Def().updateUInt64Def( Authorization, (CFBamUInt64DefBuff)editNext );
			}
			else if( classCode.equals( "U64T" ) ) {
				schema.getTableUInt64Type().updateUInt64Type( Authorization, (CFBamUInt64TypeBuff)editNext );
			}
			else if( classCode.equals( "U64C" ) ) {
				schema.getTableUInt64Col().updateUInt64Col( Authorization, (CFBamUInt64ColBuff)editNext );
			}
			else if( classCode.equals( "UIDD" ) ) {
				schema.getTableUuidDef().updateUuidDef( Authorization, (CFBamUuidDefBuff)editNext );
			}
			else if( classCode.equals( "UIDT" ) ) {
				schema.getTableUuidType().updateUuidType( Authorization, (CFBamUuidTypeBuff)editNext );
			}
			else if( classCode.equals( "IGUU" ) ) {
				schema.getTableUuidGen().updateUuidGen( Authorization, (CFBamUuidGenBuff)editNext );
			}
			else if( classCode.equals( "UIDC" ) ) {
				schema.getTableUuidCol().updateUuidCol( Authorization, (CFBamUuidColBuff)editNext );
			}
			else if( classCode.equals( "TBLC" ) ) {
				schema.getTableTableCol().updateTableCol( Authorization, (CFBamTableColBuff)editNext );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"Unrecognized ClassCode \"" + classCode + "\"" );
			}
		}

		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingTableCols[] = schema.getTableTableCol().readDerivedByDataIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		if( arrCheckReferencingTableCols.length > 0 ) {
			schema.getTableTableCol().deleteTableColByDataIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		}
		// Short circuit self-referential code to prevent stack overflows
		Object arrCheckReferencingIndexCols[] = schema.getTableIndexCol().readDerivedByColIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		if( arrCheckReferencingIndexCols.length > 0 ) {
			schema.getTableIndexCol().deleteIndexColByColIdx( Authorization,
						existing.getRequiredTenantId(),
						existing.getRequiredId() );
		}
		CFBamUInt64ColByTableIdxKey keyTableIdx = schema.getFactoryUInt64Col().newTableIdxKey();
		keyTableIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		// Validate reverse foreign keys

		// Delete is valid
		Map< CFBamValuePKey, CFBamUInt64ColBuff > subdict;

		dictByPKey.remove( pkey );

		subdict = dictByTableIdx.get( keyTableIdx );
		subdict.remove( pkey );

		schema.getTableUInt64Def().deleteUInt64Def( Authorization,
			Buff );
	}
	public void deleteUInt64ColByTableIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTableId )
	{
		CFBamUInt64ColByTableIdxKey key = schema.getFactoryUInt64Col().newTableIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredTableId( argTableId );
		deleteUInt64ColByTableIdx( Authorization, key );
	}

	public void deleteUInt64ColByTableIdx( CFSecAuthorization Authorization,
		CFBamUInt64ColByTableIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		CFBamValuePKey key = schema.getFactoryValue().newPKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredId( argId );
		deleteUInt64ColByIdIdx( Authorization, key );
	}

	public void deleteUInt64ColByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		CFBamUInt64ColBuff cur;
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		CFBamValueByUNameIdxKey key = schema.getFactoryValue().newUNameIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setRequiredName( argName );
		deleteUInt64ColByUNameIdx( Authorization, key );
	}

	public void deleteUInt64ColByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		CFBamValueByValTentIdxKey key = schema.getFactoryValue().newValTentIdxKey();
		key.setRequiredTenantId( argTenantId );
		deleteUInt64ColByValTentIdx( Authorization, key );
	}

	public void deleteUInt64ColByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		CFBamValueByScopeIdxKey key = schema.getFactoryValue().newScopeIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		deleteUInt64ColByScopeIdx( Authorization, key );
	}

	public void deleteUInt64ColByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		CFBamValueByDefSchemaIdxKey key = schema.getFactoryValue().newDefSchemaIdxKey();
		key.setOptionalDefSchemaTenantId( argDefSchemaTenantId );
		key.setOptionalDefSchemaId( argDefSchemaId );
		deleteUInt64ColByDefSchemaIdx( Authorization, key );
	}

	public void deleteUInt64ColByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalDefSchemaTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalDefSchemaId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		CFBamValueByPrevIdxKey key = schema.getFactoryValue().newPrevIdxKey();
		key.setOptionalPrevTenantId( argPrevTenantId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt64ColByPrevIdx( Authorization, key );
	}

	public void deleteUInt64ColByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalPrevTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		CFBamValueByNextIdxKey key = schema.getFactoryValue().newNextIdxKey();
		key.setOptionalNextTenantId( argNextTenantId );
		key.setOptionalNextId( argNextId );
		deleteUInt64ColByNextIdx( Authorization, key );
	}

	public void deleteUInt64ColByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		if( argKey.getOptionalNextTenantId() != null ) {
			anyNotNull = true;
		}
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		CFBamValueByContPrevIdxKey key = schema.getFactoryValue().newContPrevIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalPrevId( argPrevId );
		deleteUInt64ColByContPrevIdx( Authorization, key );
	}

	public void deleteUInt64ColByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalPrevId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void deleteUInt64ColByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		CFBamValueByContNextIdxKey key = schema.getFactoryValue().newContNextIdxKey();
		key.setRequiredTenantId( argTenantId );
		key.setRequiredScopeId( argScopeId );
		key.setOptionalNextId( argNextId );
		deleteUInt64ColByContNextIdx( Authorization, key );
	}

	public void deleteUInt64ColByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		CFBamUInt64ColBuff cur;
		boolean anyNotNull = false;
		anyNotNull = true;
		anyNotNull = true;
		if( argKey.getOptionalNextId() != null ) {
			anyNotNull = true;
		}
		if( ! anyNotNull ) {
			return;
		}
		LinkedList<CFBamUInt64ColBuff> matchSet = new LinkedList<CFBamUInt64ColBuff>();
		Iterator<CFBamUInt64ColBuff> values = dictByPKey.values().iterator();
		while( values.hasNext() ) {
			cur = values.next();
			if( argKey.equals( cur ) ) {
				matchSet.add( cur );
			}
		}
		Iterator<CFBamUInt64ColBuff> iterMatch = matchSet.iterator();
		while( iterMatch.hasNext() ) {
			cur = iterMatch.next();
			cur = schema.getTableUInt64Col().readDerivedByIdIdx( Authorization,
				cur.getRequiredTenantId(),
				cur.getRequiredId() );
			deleteUInt64Col( Authorization, cur );
		}
	}

	public void releasePreparedStatements() {
	}
}
