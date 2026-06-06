/*
 *  MSS Code Factory CFBam 2.12 MSSBamCF
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

package org.msscf.msscf.cfbamcust.MSSBamCF;

import java.util.*;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenIterateTableRefs
	extends MssCFGenIteratorObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenIterateTableRefs() {
		super();
	}

	public MSSBamCFGenIterateTableRefs(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName, "TableRefs");
	}

	public ListIterator<ICFLibAnyObj> enumerateDetails( MssCFGenContext genContext)
	{
		ICFLibAnyObj genDef;
		final String S_ProcName = "enumerateDetails";

		if (genContext == null) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext" );
		}

		genDef = genContext.getGenDef();
		if (genDef == null) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				0,
				"genContext.GenDef" );
		}

		if (!(genDef instanceof ICFBamTableObj)) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.GenDef",
				genDef,
				"ICFBamTableObj" );
		}

		ICFBamTableObj tableObj = (ICFBamTableObj)genDef;
		String tableName = tableObj.getRequiredName();
		ICFBamSchemaDefObj schemaDefObj = (ICFBamSchemaDefObj)tableObj.getRequiredContainerSchemaDef();
		Iterator<ICFBamSchemaRefObj> schemaRefIterator = schemaDefObj.getOptionalComponentsSchemaRefs().iterator();
		ICFBamSchemaRefObj schemaRefObj;
		ICFBamSchemaDefObj referencedSchemaObj;
		ICFLibAnyObj namedObj;
		LinkedList<ICFLibAnyObj> toBeIterated = new LinkedList<ICFLibAnyObj>();
		while( schemaRefIterator.hasNext() ) {
			schemaRefObj = schemaRefIterator.next();
			referencedSchemaObj = schemaRefObj.getOptionalLookupRefSchema();
			if( referencedSchemaObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"schemaRefObj.referencedSchemaObj" );
			}
			namedObj = referencedSchemaObj.getNamedObject( tableName );
			if( namedObj != null ) {
				if( namedObj instanceof ICFBamTableObj ) {
					toBeIterated.add( namedObj );
				}
			}
		}

		return( toBeIterated.listIterator());
	}
}
