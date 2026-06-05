
// Description: Java 11 MssCF Iterator for Cluster Relationship SecApp.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamMssCF;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.rmi.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

/**
 *	CFBamMssCFIterateClusterSecApp binds Cluster.SecApp
 *	as an instance of MssCFGenIteratorObj.
 */
public class CFBamMssCFIterateClusterSecApp
	extends MssCFGenIteratorObj
{
	private static final long serialVersionUID = 1L;

	public CFBamMssCFIterateClusterSecApp() {
		super();
	}

	public CFBamMssCFIterateClusterSecApp( MssCFEngine argEngine ) {
		super( argEngine,
			"any",
			null,
			"Cluster",
			"SecApp",
			"SecApp" );
	}

	public ListIterator<ICFLibAnyObj> enumerateDetails( MssCFGenContext genContext ) {
		final String S_ProcName = "CFBamMssCFIterateClusterSecApp.enumerateDetails() ";

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

		List<ICFLibAnyObj> list = new LinkedList<ICFLibAnyObj>();

		if( genDef instanceof ICFBamClusterObj ) {
			Iterator<ICFSecSecAppObj> elements = ((ICFBamClusterObj)genDef).getOptionalComponentsSecApp().iterator();
			while( elements.hasNext() ) {
				list.add( elements.next() );
			}
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"genContext.getGenDef()",
				genDef,
				"ICFBamClusterObj" );
		}

		return( list.listIterator() );
	}}
