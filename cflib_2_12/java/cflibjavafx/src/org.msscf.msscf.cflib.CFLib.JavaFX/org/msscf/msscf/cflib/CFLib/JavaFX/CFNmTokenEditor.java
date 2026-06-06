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

package org.msscf.msscf.cflib.CFLib.JavaFX;

import javafx.geometry.Pos;

import org.msscf.msscf.cflib.CFLib.*;

public class CFNmTokenEditor
extends CFTextField
{
	protected int maxLen = 1;

	protected String fieldName = "?";
	
	public String getFieldName() {
		return( fieldName );
	}
	
	public void setFieldName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			fieldName = "?";
		}
		else {
			fieldName = value;
		}
	}

	public CFNmTokenEditor() {
		super();
		setAlignment( Pos.CENTER_LEFT );
	}
	
	public int getMaxLen() {
		return( maxLen );
	}

	public void setMaxLen( int value ) {
		final String S_ProcName = "setMaxLen";
		if( maxLen < 1 ) {
			throw new CFLibArgumentUnderflowException( fieldName,
					S_ProcName,
					1,
					fieldName,
					value,
					1 );
		}
		maxLen = value;
		if( maxLen > 58 ) {
			setPrefWidth( 660 );
		}
		else if( maxLen > 0 ) {
			setPrefWidth( ( maxLen + 2 ) * 11 );
		}
	}
	
	public boolean hasValue() {
		boolean retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = false;
		}
		else {
			retval = true;
		}
		return( retval );
	}
	
	public boolean isEditValid() {
		String str = getText();
		if( str == null ) {
			return( true );
		}
		
		int len = str.length();
		if( len > maxLen ) {
			return( false );
		}
		else {
			return( true );
		}
	}
	
	public void setNmTokenValue( String value ) {
		if( value != null ) {
			setText( value );
		}
		else {
			setText( "" );
		}
	}

	public String getNmTokenValue() {
		final String S_ProcName = "getNmTokenValue";
		String text = getText();
		if( text == null ) {
			return( null );
		}
		else if( text.length() > maxLen ) {
			throw new CFLibArgumentOverflowException( fieldName,
					S_ProcName,
					0,
					"MaxLen",
					text.length(),
					maxLen );
		}
		else {
			return( text );
		}
	}
}
