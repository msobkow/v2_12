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

import java.util.Iterator;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfbam.CFBam.CFBamChainPKey;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenBindColumnInPrimaryIndex
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenBindColumnInPrimaryIndex() {
		super();
	}

	public MSSBamCFGenBindColumnInPrimaryIndex(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName);
	}

	public String expandBody( MssCFGenContext genContext ) {
		ICFLibAnyObj genDef;
		final String S_ProcName = "expandBody";

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

		ICFBamTableObj scopeTable = null;

		if (genDef instanceof ICFBamTableColObj) {
			ICFBamTableColObj tableCol = (ICFBamTableColObj)genDef;
			scopeTable = tableCol.getRequiredContainerTable();
		}
		else if (genDef instanceof ICFBamAtomObj) {
			ICFBamScopeObj container = ((ICFBamAtomObj)genDef).getRequiredContainerScope();
			if( container instanceof ICFBamTableObj ) {
				scopeTable = (ICFBamTableObj)container;
			}
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.GenDef",
				genDef,
				"ICFBamAtomDefObj, ICFBamTableColObj" );
		}

		if (scopeTable != null) {
			ICFBamIndexObj primaryIndex = MSSBamCFTableObj.getPrimaryKeyIndex( scopeTable );
			if (primaryIndex != null) {
				Iterator<ICFBamIndexColObj> indexColumns = primaryIndex.getOptionalComponentsColumns().iterator();
				ICFBamIndexColObj indexCol;
				while (indexColumns.hasNext()) {
					indexCol = indexColumns.next();
					if (indexCol != null) {
						if (genDef == indexCol.getRequiredLookupColumn() ) {
							return ("yes");
						}
					}
				}
			}
		}

		return ("no");
	}
}
