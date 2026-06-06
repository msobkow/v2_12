
// Description: Java 11 MssCF Reference for SysCluster Relationship Cluster.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamMssCF;

import java.sql.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/**
 *	CFBamMssCFReferenceSysClusterCluster binds SysCluster.Cluster
 *	as an instance of MssCFGenReferenceObj.
 */
public class CFBamMssCFReferenceSysClusterCluster
	extends MssCFGenReferenceObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFReferenceSysClusterCluster() {
		super();
	}

	public CFBamMssCFReferenceSysClusterCluster( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"SysCluster",
			"Cluster",
			"Cluster" );
	}

	public ICFLibAnyObj dereference( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFReferenceSysClusterCluster.dereference() ";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"genContext.getGenDef()" );
		}

		ICFBamClusterObj obj;

		if( genDef instanceof ICFBamSysClusterObj ) {
			obj = (ICFBamClusterObj)((ICFBamSysClusterObj)genDef).getRequiredContainerCluster();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.getGenDef()",
				genDef,
				"ICFBamSysClusterObj" );
		}

		return( obj );
	}
}
