/*
 *  MSS Code Factory CFLib 2.12
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

package org.msscf.msscf.cflib.CFLib;

public class CFLibFireOnInstanceOf {
	
    @SuppressWarnings("rawtypes")
	protected Class instOf = null;

    public CFLibFireOnInstanceOf() {
    	setInstanceOf( Object.class );
    }

    public CFLibFireOnInstanceOf( @SuppressWarnings("rawtypes") Class value ) {
    	setInstanceOf( value );
    }

    public void setInstanceOf( @SuppressWarnings("rawtypes") Class value ) {
    	final String S_ProcName = "setInstanceOf";
        if( value == null ) {
            throw new CFLibNullArgumentException( getClass(),
                S_ProcName,
                1,
                "value" );
        }
        instOf = value;
    }

    @SuppressWarnings("rawtypes")
	public Class getInstanceOf() {
        return( instOf );
    }

    public boolean isInstanceOf( ICFLibAnyObj obj ) {
    	if( obj == null ) {
    		return( false );
    	}

    	if( instOf == null ) {
    		return( false );
    	}

    	return( instOf.isInstance( obj ) );
    }

    public void onInstanceOf( ICFLibAnyObj obj ) {
        final String S_ProcName = "onInstanceOf";
        if( obj == null ) {
            return;
        }
        throw new CFLibNotImplementedYetException( getClass(),
        	S_ProcName );
    }

    public final void fireOnInstanceOf( ICFLibAnyObj obj ) {
    	if( obj == null ) {
    		return;
    	}
        if( isInstanceOf( obj ) ) {
            onInstanceOf( obj );
        }
    }
}
