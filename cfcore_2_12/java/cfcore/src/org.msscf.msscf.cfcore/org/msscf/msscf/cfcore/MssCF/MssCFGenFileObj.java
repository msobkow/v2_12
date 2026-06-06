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

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGenFileObj
extends CFGenKbGenFileObj
{
	public String evaluateProjectDirName( MssCFGenContext genContext, ICFLibAnyObj genDef ) {
		return( "overload_me_please" );
	}

	public MssCFGenFileObj() {
		super();
	}

	public MssCFGenFileObj(MssCFEngine engine) {
		super( engine );
	}

	public String getBody( MssCFGenContext genContext ) {
		final String S_ProcName = "MssCFGenFileObj.getBody() ";
		ICFGenKbGelInstructionObj bodyBin = CFGenKbGenFileObj.getBodyBin( genContext.getGenEngine().getGelCompiler(), this);
		if( bodyBin == null ) {
			throw new RuntimeException( S_ProcName + "Could not resolve compiled Body GEL executable" );
		}
		String body = bodyBin.expand( genContext );
		return( body );
	}

	public String getSrcBundle( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj sourceBundleBin = CFGenKbGenFileObj.getSrcBundleBin(genContext.getGenEngine().getGelCompiler(), this);
		String sourceBundle = sourceBundleBin.expand( genContext );
		return( sourceBundle );
	}

	public String getModuleName( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj moduleNameBin = CFGenKbGenFileObj.getModuleNameBin(genContext.getGenEngine().getGelCompiler(), this);
		String moduleName = moduleNameBin.expand( genContext );
		return( moduleName );
	}

	public String getBasePackage( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj basePackageBin = CFGenKbGenFileObj.getBasePackageBin(genContext.getGenEngine().getGelCompiler(), this);
		String basePackage = basePackageBin.expand( genContext );
		return( basePackage );
	}

	public String getSubPackage( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj subPackageBin = CFGenKbGenFileObj.getSubPackageBin(genContext.getGenEngine().getGelCompiler(), this);
		String subPackage = subPackageBin.expand( genContext );
		return( subPackage );
	}

	public String getExpansionClassName( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj expansionClassNameBin = CFGenKbGenFileObj.getExpClassBin(genContext.getGenEngine().getGelCompiler(), this);
		String expansionClassName = expansionClassNameBin.expand( genContext );
		return( expansionClassName );
	}

	public String getExpansionKeyName( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj expansionKeyNameBin = CFGenKbGenFileObj.getExpKeyNameBin(genContext.getGenEngine().getGelCompiler(), this);
		String expansionKeyName = expansionKeyNameBin.expand( genContext );
		return( expansionKeyName );
	}

	public String getExpansionFileName( MssCFGenContext genContext ) {
		ICFGenKbGelInstructionObj expansionFileNameBin = CFGenKbGenFileObj.getExpFileNameBin(genContext.getGenEngine().getGelCompiler(), this);
		String expansionFileName = expansionFileNameBin.expand( genContext );
		return( expansionFileName );
	}

	public String expandBody(MssCFGenContext genContext)
	{
		Boolean needFile = false;
		final String S_ProcName = "MssCFGenFile.expandBody() ";
		final String S_Empty = "";
		final String S_True = "true";
		final String S_False = "false";
		final String S_Yes = "yes";
		final String S_No = "no";

		String generateOnce = getOptionalGenerateOnce();

		String moduleName = getModuleName( genContext );
		if( moduleName == null ) {
			moduleName = S_Empty;
		}

		String rootGenDir = genContext.getRootGenDir();

		String sourceBundle = getSrcBundle( genContext );

		String basePackage = getBasePackage( genContext );
		if (basePackage == null) {
			throw new RuntimeException(S_ProcName + "Could not get base-package name for generating GenFile( \""
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

		String subPackage = getSubPackage( genContext );
		if ((subPackage != null) && (subPackage.length() == 0)) {
			subPackage = null;
		}

		String fileClass = getExpansionClassName( genContext );
		if ((fileClass == null) || (fileClass.length() == 0)) {
			throw new RuntimeException(S_ProcName + "Could not get class name for generating GenFile( \""
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

		String fileKey = getExpansionKeyName( genContext );
		if ((fileKey == null) || (fileKey.length() == 0)) {
			System.out.append(S_ProcName + "Could not get key for generating GenFile( \""
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
			return (null);
		}

		String buildString = genContext.getGeneratingBuild();

		ICFLibAnyObj genDef = genContext.getGenDef();
		if (genDef == null) {
			throw new RuntimeException(S_ProcName + "genContext.GenDef returned null");
		}

		String projectDirName = evaluateProjectDirName( genContext, genDef );
		if (projectDirName == null) {
			throw new RuntimeException(S_ProcName + "Could not get project directory name");
		}

		String dirSep = File.separator;

		String baseWorkDir;
		if ((sourceBundle != null) && (sourceBundle.length() > 0)) {
			baseWorkDir = projectDirName + dirSep + sourceBundle;
		}
		else {
			baseWorkDir = projectDirName;
		}

		String baseGenDir;
		if( rootGenDir.endsWith( dirSep ) || rootGenDir.endsWith("/") || rootGenDir.endsWith("\\") ) {
			baseGenDir = rootGenDir + baseWorkDir;
		}
		else {
			baseGenDir = rootGenDir + dirSep + baseWorkDir;
		}

		String srcFileDir;
		String fullPackage;
		if ((basePackage != null) && (basePackage.length() != 0)) {
			if (subPackage != null) {
				fullPackage = basePackage + "." + subPackage;
				if( moduleName.length() > 0 ) {
					srcFileDir = basePackage + dirSep + moduleName + dirSep + subPackage.replace( '.', dirSep.charAt(0) );
				}
				else {
					srcFileDir = basePackage + dirSep + subPackage.replace( '.', dirSep.charAt(0) );
				}
			}
			else {
				fullPackage = basePackage;
				if( moduleName.length() > 0 ) {
					srcFileDir = moduleName + dirSep + basePackage;
				}
				else {
					srcFileDir = basePackage;
				}
			}
		}
		else {
			if (subPackage != null) {
				fullPackage = subPackage;
				if( moduleName.length() > 0 ) {
					srcFileDir = moduleName + dirSep + subPackage.replace( '.', dirSep.charAt(0) );
				}
				else {
					srcFileDir = subPackage.replace( '.', dirSep.charAt(0) );
				}
			}
			else {
				fullPackage = "";
				srcFileDir = "";
			}
		}

		String srcFileName = getExpansionFileName( genContext );
		if ((srcFileName == null) || (srcFileName.length() == 0)) {
			System.out.append(S_ProcName + "Could not get the file name for generating " + fileKey + " support\n");
			return (null);
		}

		needFile = true;
		if (!needFile) {
			return ("");
		}

		// Make sure we have a valid compile before opening the file at all
		ICFGenKbGelInstructionObj bodyBin = CFGenKbGenFileObj.getBodyBin( genContext.getGenEngine().getGelCompiler(), this);

		try {
			genContext.openSourceFile(this,
				fileClass,
				sourceBundle,
				moduleName,
				fullPackage,
				baseGenDir,
				baseWorkDir,
				srcFileDir,
				srcFileName,
				generateOnce );
		}
		catch (Exception e) {
			System.out.append(S_ProcName + "Could not open " + fileKey + " file for generation: " + e.getMessage() + "\n" );
			CFLib.beep();
			return (null);
		}

		String fileContents = null;
		String ret = baseGenDir + dirSep + srcFileName;
		try {
			fileContents = bodyBin.expand( genContext );
			if( srcFileName.endsWith( ".bat" ) ) {
				fileContents = fileContents.replace( "\n", "\r\n" );
				fileContents = fileContents.replace( "\r\r", "\r" );
			}
		}
		catch (Exception e) {
			ret = null;
			String msg = e.getMessage();
			if( msg != null ) {
				System.out.append(S_ProcName
						+ e.getClass().getSimpleName()
						+ " exception generating "
						+ fileKey
						+ " file \""
						+ baseGenDir + dirSep + srcFileName
						+ "\" -- " + msg + " -- Stack trace follows\n" );
			}
			else {
				System.out.append(S_ProcName
						+ e.getClass().getSimpleName()
						+ " exception generating "
						+ fileKey
						+ " file \""
						+ baseGenDir + dirSep + srcFileName
						+ "\" -- Stack trace follows\n" );

			}
			CFLib.beep();
	    	e.printStackTrace( /*_Log.getPrintStream()*/ );
		}

		//	If there were no problems expanding, write the contents of the file

		if (fileContents !=  null) {
			try {
				genContext.write(fileContents);
			}
			catch (Exception e) {
				ret = null;
				System.out.append(S_ProcName + "Error writing to " + fileKey + " file \""
					+ baseGenDir + dirSep + srcFileName
					+ "\" -- " + e.getMessage() + "\n" );
				CFLib.beep();
			}
		}

		try {
			genContext.closeSourceFile();
		}
		catch (Exception e) {
			ret = null;
			System.out.append(S_ProcName + "Error closing " + fileKey + " file \""
				+ baseGenDir + dirSep + srcFileName
				+ "\" -- " + e.getMessage() + "\n" );
			CFLib.beep();
		}

		return (ret);
	}
}
