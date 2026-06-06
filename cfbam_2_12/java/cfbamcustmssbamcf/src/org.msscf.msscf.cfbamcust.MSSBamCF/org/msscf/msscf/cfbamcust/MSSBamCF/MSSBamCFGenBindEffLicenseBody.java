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

import java.util.List;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfcore.CFGenKbObj.ICFGenKbGelExecutableObj;
import org.msscf.msscf.cfcore.CFGenKbObj.ICFGenKbGelInstructionObj;
import org.msscf.msscf.cfbam.CFBamObj.*;

public class MSSBamCFGenBindEffLicenseBody
	extends MssCFGenBindObj
{
	private static final long serialVersionUID = 1L;

	public MSSBamCFGenBindEffLicenseBody() {
		super();
	}

	public MSSBamCFGenBindEffLicenseBody(
		MSSBamCFEngine argSchema,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName)
	{
		super( argSchema, toolset, scopeDefClassName, genDefClassName, itemName);
	}

	public Object getValueObject( MssCFGenContext genContext ) {
		final String S_ProcName = "MSSBamCFGenBindEffLicenseBody.getValueObject() ";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext.getGenDef()" );
		}

		String embeddedText;
		if( genDef instanceof ICFBamLicenseObj ) {
			embeddedText = ((ICFBamLicenseObj)genDef).getOptionalEmbeddedText();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamLicenseObj" );
		}

		String ret;
		if( ( embeddedText == null ) || ( embeddedText.length() <= 0 ) ) {
			ret = "";
		}
		else {
//			ICFGenKbGelInstructionObj bin = genContext.getGenEngine().getGelCompiler().compileExecutable( genContext.getGenFile(), embeddedText );
//			ret = bin.expand( genContext );
			ret = embeddedText;
		}

		return( ret );
	}

	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "MSSBamCFGenBindEffLicenseBody.expandBody() ";

		if( genContext == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext" );
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"expandBody",
				1,
				"genContext.getGenDef()" );
		}

		String embeddedText;

		if( genDef instanceof ICFBamLicenseObj ) {
			embeddedText = ((ICFBamLicenseObj)genDef).getOptionalEmbeddedText();
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"expandBody",
				"genContext.getGenDef()",
				genDef,
				"ICFBamLicenseObj" );
		}

		String ret;
		if( ( embeddedText == null ) || ( embeddedText.length() <= 0 ) ) {
			ret = "";
		}
		else {
//			ICFGenKbGelInstructionObj bin = genContext.getGenEngine().getGelCompiler().compileExecutable( genContext.getGenFile(), embeddedText );
//			ret = bin.expand( genContext );
			ret = embeddedText;
		}

		return( ret );
	}
}
