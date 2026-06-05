/*
 *	MSS Code Factory CFCore 2.12
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

public class MssCFGenRuleObj
extends CFGenKbGenRuleObj
{
	public MssCFGenRuleObj() {
		super();
	}

	public MssCFGenRuleObj(MssCFEngine schema) {
		super( schema );
	}

	public String getBody( MssCFGenContext genContext ) {
		final String S_ProcName = "MssCFGenRuleObj.getBody() ";
		ICFGenKbGelInstructionObj bodyBin = CFGenKbGenRuleObj.getBodyBin( genContext.getGenEngine().getGelCompiler(), this);
		if( bodyBin == null ) {
			throw new RuntimeException( S_ProcName + "Could not resolve compiled Body GEL executable" );
		}
		String body = bodyBin.expand( genContext );
		return( body );
	}

	public String expandBody(MssCFGenContext genContext) {
		final String S_ProcName = "MssCFGenRuleObj.expandBody() ";

		String ret = null;

		if (genContext == null) {
			throw new RuntimeException( S_ProcName + "genContext is null");
		}

		if (getRequiredBody() == null) {
			throw new RuntimeException(S_ProcName
				+ "Rule " + getRequiredName()
				+ ", ScopeDef=" + ((getOptionalLookupScopeDef() == null) ? "null" : getOptionalLookupScopeDef().getRequiredName())
				+ ", GenDef=" + getRequiredLookupGenDef().getRequiredName()
				+ " has a null RequiredBody");
		}

		ret = getBody( genContext );

		return (ret);
	}
}
