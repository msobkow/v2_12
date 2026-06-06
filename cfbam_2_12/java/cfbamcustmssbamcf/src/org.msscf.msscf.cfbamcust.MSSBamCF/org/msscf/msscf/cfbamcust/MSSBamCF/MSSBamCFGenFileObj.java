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

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenFileObj extends MssCFGenFileObj {

	public MSSBamCFGenFileObj() {
		super();
	}

	public MSSBamCFGenFileObj(MssCFEngine engine) {
		super( engine );
	}

	public String evaluateProjectDirName( MssCFGenContext genContext, ICFLibAnyObj genDef ) 	{
		final String S_ProcName = "MSSBamCFGenFileObj.evaluateProjectDirName() ";

		ICFLibAnyObj project;
		ICFLibAnyObj topproject;
		ICFLibAnyObj subproject;
		ICFLibAnyObj version;
		String projectDirName;
		ICFBamSchemaDefObj manufacturingSchema = ((MSSBamCFGenContext)genContext).getManufacturingSchema();
		ICFLibAnyObj anyObj = null;
		if( manufacturingSchema != null ) {
			anyObj = manufacturingSchema;
		}
		else {
			anyObj = (ICFLibAnyObj)genDef;
		}

	    project = MSSBamCFAnyObj.getProject(anyObj);
	    if (project == null) {
			topproject = null;
			subproject = null;
	        throw new RuntimeException(S_ProcName + "Could not get Project for generating GenFile( \""
	            + getRequiredLookupToolSet().getRequiredName()
	            + "\", \""
	            + ((getOptionalLookupScopeDef() != null)
	                ? getOptionalLookupScopeDef().getRequiredName()
	                : "")
	            + "\", \""
	            + getRequiredLookupGenDef().getRequiredName()
	            + "\", \""
	            + getRequiredName()
	            + "\" )");
	    }
		else {
			if( project instanceof ICFIntSubProjectObj ) {
				subproject = (ICFIntSubProjectObj)project;
				topproject = (ICFIntTopProjectObj)(subproject.getObjScope());
			}
			else if( project instanceof ICFIntTopProjectObj ) {
				topproject = (ICFIntTopProjectObj)project;
				subproject = null;
			}
			else {
				topproject = null;
				subproject = null;
			}
		}

		if( topproject == null ) {
	        throw new RuntimeException(S_ProcName + "Could not determine TopProject for generating GenFile( \""
	            + getRequiredLookupToolSet().getRequiredName()
	            + "\", \""
	            + ((getOptionalLookupScopeDef() != null)
	                ? getOptionalLookupScopeDef().getRequiredName()
	                : "")
	            + "\", \""
	            + getRequiredLookupGenDef().getRequiredName()
	            + "\", \""
	            + getRequiredName()
	            + "\" )");
		}

		if( subproject == null ) {
	        throw new RuntimeException(S_ProcName + "Could not determine SubProject for generating GenFile( \""
	            + getRequiredLookupToolSet().getRequiredName()
	            + "\", \""
	            + ((getOptionalLookupScopeDef() != null)
	                ? getOptionalLookupScopeDef().getRequiredName()
	                : "")
	            + "\", \""
	            + getRequiredLookupGenDef().getRequiredName()
	            + "\", \""
	            + getRequiredName()
	            + "\" )");
		}

	    version = MSSBamCFAnyObj.getVersionLeaf(anyObj);

		ICFIntMajorVersionObj majorVersion;
		ICFIntMinorVersionObj minorVersion;

		if( version instanceof ICFIntMajorVersionObj ) {
			majorVersion = (ICFIntMajorVersionObj)version;
			minorVersion = null;
		}
		else if( version instanceof ICFIntMinorVersionObj ) {
			minorVersion = (ICFIntMinorVersionObj)version;
			majorVersion = (ICFIntMajorVersionObj)(version.getObjScope());
		}
		else {
			minorVersion = null;
			majorVersion = null;
		}

		if( majorVersion == null ) {
	        throw new RuntimeException(S_ProcName + "Could not determine MajorVersion for generating GenFile( \""
	            + getRequiredLookupToolSet().getRequiredName()
	            + "\", \""
	            + ((getOptionalLookupScopeDef() != null)
	                ? getOptionalLookupScopeDef().getRequiredName()
	                : "")
	            + "\", \""
	            + getRequiredLookupGenDef().getRequiredName()
	            + "\", \""
	            + getRequiredName()
	            + "\" )");
		}

		if( minorVersion == null ) {
	        throw new RuntimeException(S_ProcName + "Could not determine MinorVersion for generating GenFile( \""
	            + getRequiredLookupToolSet().getRequiredName()
	            + "\", \""
	            + ((getOptionalLookupScopeDef() != null)
	                ? getOptionalLookupScopeDef().getRequiredName()
	                : "")
	            + "\", \""
	            + getRequiredLookupGenDef().getRequiredName()
	            + "\", \""
	            + getRequiredName()
	            + "\" )");
		}

		projectDirName = subproject.getObjName().toLowerCase() + "_" + majorVersion.getObjName() + "_" + minorVersion.getObjName();

	    return( projectDirName );
	}
}
