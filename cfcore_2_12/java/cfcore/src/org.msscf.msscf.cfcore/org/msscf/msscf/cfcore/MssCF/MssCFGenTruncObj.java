/*
 *	MSS Code Factory CFCore 2.12
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

package org.msscf.msscf.cfcore.MssCF;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.security.cert.*;
import java.text.*;
import java.util.*;

import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGenTruncObj
extends CFGenKbGenTruncObj
{
	public MssCFGenTruncObj() {
		super();
	}

	public MssCFGenTruncObj(MssCFEngine schema) {
		super( schema );
	}

	public String getBody( MssCFGenContext genContext ) {
		final String S_ProcName = "MssCFGenTruncObj.getBody() ";
		ICFGenKbGelInstructionObj bodyBin = CFGenKbGenTruncObj.getBodyBin( genContext.getGenEngine().getGelCompiler(), this);
		if( bodyBin == null ) {
			throw new RuntimeException( S_ProcName + "Could not resolve compiled Body GEL executable" );
		}
		String body = bodyBin.expand( genContext );
		return( body );
	}

	public String expandBody(MssCFGenContext genContext) {
		final String S_ProcName = "MssCFGenTruncObj.expandBody() ";

		String ret = null;
		if (genContext == null) {
			throw new RuntimeException(S_ProcName + "genContext is null");
		}

		ICFGenKbGelInstructionObj bodyBin = CFGenKbGenTruncObj.getBodyBin( genContext.getGenEngine().getGelCompiler(), this);
		ret = bodyBin.expand( genContext );

		if( ret != null ) {
			if( ret.length() > getRequiredTruncateAt() ) {
				ret = ret.substring( 0, getRequiredTruncateAt() );
			}
		}

		return (ret);
	}
}
