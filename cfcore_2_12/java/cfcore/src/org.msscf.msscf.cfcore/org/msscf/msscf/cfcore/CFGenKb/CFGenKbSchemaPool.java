// Description: Java 11 implementation of a CFGenKb schema pool.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;

public class CFGenKbSchemaPool
{

	protected volatile static CFGenKbSchemaPool schemaPool = null;
	protected String jndiName = null;
	protected CFGenKbConfigurationFile configFile = null;
	protected LinkedList<ICFGenKbSchema> instances = new LinkedList<ICFGenKbSchema>();
	public CFGenKbSchemaPool() {
	}

	public static CFGenKbSchemaPool getSchemaPool() {
		return( schemaPool );
	}

	public static void setSchemaPool( CFGenKbSchemaPool pool ) {
		if( schemaPool == null ) {
			schemaPool = pool;
		}

	}

	public CFGenKbConfigurationFile getConfigurationFile() {
		return( configFile );
	}

	public void setConfigurationFile( CFGenKbConfigurationFile value ) {
		
		configFile = value;
	}


	/**
	 *	Retrieve an entry from the pool with a previously
	 *	established database connection.
	 */
	public synchronized ICFGenKbSchema getInstance() {
		ICFGenKbSchema retInst = null;
		if( instances != null ) {
			if( instances.isEmpty() ) {
				retInst = newInstance();
				retInst.setConfigurationFile( (CFGenKbConfigurationFile)getConfigurationFile() );
				retInst.setJndiName( getJndiName() );
				retInst.connect();
			}
			else {
				retInst = instances.removeFirst();
			}
		}
		else {
			retInst = null;
		}
		return( retInst );
	}

	/**
	 *	Return an entry to the pool.
	 */
	public synchronized void releaseInstance( ICFGenKbSchema inst ) {
		if( inst == null ) {
			return;
		}
		inst.rollback();
		if( instances != null ) {
			if( ! instances.contains( inst ) ) {
				instances.addFirst( inst );
			}
		}
	}

	/**
	 *	You need to overload the implementation of newInstance() to return
	 *	connected instances of your backing store.
	 */
	public ICFGenKbSchema newInstance() {
		ICFGenKbSchema retInst = new CFGenKbSchema();
		return( retInst );
	}

	/**
	 *	Overload disposeInstance().
	 */
	public void disposeInstance( ICFGenKbSchema inst ) {
		try {
			inst.disconnect( false );
		}
		catch( RuntimeException e ) {
		}
		if( instances != null ) {
			if( ! instances.contains( inst ) ) {
				instances.addFirst( inst );
			}
		}
	}

	public String getJndiName() {
		return( jndiName );
	}

	public void setJndiName( String value ) {
		jndiName = value;
		if( ( jndiName != null ) && ( jndiName.length() > 0 ) ) {
			configFile = null;
		}
	}

}
