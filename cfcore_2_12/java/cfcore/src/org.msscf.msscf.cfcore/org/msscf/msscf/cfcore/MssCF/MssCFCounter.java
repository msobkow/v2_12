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

public class MssCFCounter
{
	private String name;
	private int counter;

	/**
	 *	Construct an instance
	 */
	public MssCFCounter( String argName ) {
		final String S_ProcName = "MssCFCounter.constructor( argName ) ";
		if( ( argName == null ) || ( 0 == argName.length() ) ) {
			throw new RuntimeException( S_ProcName + "CFCounter.CFCounter() argName is null or empty" );
		}
		name = argName;
		counter = 0;
	}

	public String getName()
	{
		return( name );
	}

	public void setName( String value )
	{
		final String S_ProcName = "MssCFCounter.setName() ";
		if( ( value == null ) || ( 0 == value.length() ) ) {
			throw new RuntimeException( S_ProcName + "Set CFCounter.Name value is null or empty" );
		}
		name = value;
	}

	public int getCounter()
	{
		return( counter );
	}

	public void setCounter( int value )
	{
		final String S_ProcName = "MssCFCounter.setCounter() ";
		if( value < 0 ) {
			throw new RuntimeException( S_ProcName + "Set CFCounter.Counter value " + Integer.toString( value ) + " must be in range 0.." + Integer.toString(Integer.MAX_VALUE ) );
		}
	}

	public void increment() {
		if( counter < Integer.MAX_VALUE ) {
			counter = counter + 1;
		}
	}

	public void decrement() {
		if( counter > 0 ) {
			counter = counter - 1;
		}
	}
}
