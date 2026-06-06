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

import java.util.ArrayList;
import java.util.Iterator;

import org.msscf.msscf.cflib.CFLib.*;

/**
 *	The internal PathDirInfo entries are used to track members of the
 *	model and rule paths.
 */
class MSSBamCFPathDirInfo {

/**
 *	Jar files specify a package of "jar".  In this case the package
 *	names are implicit in the jar structure.
 */
public final static String		PACKAGE_JAR = "jar";

/**
 *	Has the target been validated?
 */
boolean							Validated;

/**
 *	Is the target valid?
 */
boolean							Valid;

/**
 *	Is the target expected to be a directory or a jar?
 */
boolean							IsJarFile;

/**
 *	The name of the directory to be searched.
 */
String							PathName;

/**
 *	The package prefix to be applied to names in the directory.
 *	<p>
 *	A package name of "jar" means the path name refers to a jar
 *	file instead of a system directory.  The jar files should
 *	have their full path/package included.
 */
String							PackageName;

/**
 *	You must specify the path name and package when creating the instance.
 */
public MSSBamCFPathDirInfo(
	String				pathName,
	String				packageName )
{
	final String S_ProcName = "PathDirInfo.PathDirInfo() ";

	if( ( pathName == null ) || ( pathName.length() == 0 ) ) {
    	throw new RuntimeException( S_ProcName + "Argument 1 pathName is null or empty");
    }

	Validated = false;
    Valid = false;

	PathName = new String( pathName );

    if( ( packageName == null ) || packageName.equals( PACKAGE_JAR ) ) {
    	PackageName = PACKAGE_JAR;
        IsJarFile = true;
    }
    else {
		PackageName = new String( packageName );
    	IsJarFile = false;
    }
}

/**
 *	Get the path name
 */
public String getPathName()
{
	return( PathName );
}

/**
 *	Get the package prefix.  If the path is a jar null is returned.
 */
public String getPackageName()
{
	return( PackageName );
}

/**
 *	Is the path to a jar file?
 */
public boolean isJarFile()
{
	return( IsJarFile );
}

/**
 *	Try to validate the path information, loading reference
 *	information as we go.
 */
public boolean validate(
	ICFLibMessageLog	log,
    boolean					reload )
{
	if( Validated && ( ! reload ) ) {
    	return( Valid );
    }

   	Valid = false;
	Validated = false;

    return( Valid );
}

}
