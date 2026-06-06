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

import java.text.*;

import javafx.geometry.Pos;

import org.msscf.msscf.cflib.CFLib.*;

public class CFInt16Editor
extends CFFormattedTextField
{
	protected static Format defaultFormat = null;
	protected short minValue = (short)-32768;
	protected short maxValue = (short)32767;

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
	
	public static Format getDefaultFormat() {
		if( defaultFormat == null ) {
			defaultFormat = new DecimalFormat( "####0;-####0" );
		}
		return( defaultFormat );
	}
	
	public CFInt16Editor() {
		setAlignment( Pos.CENTER_RIGHT );
		setMinWidth( 70 );
		setPrefWidth( 70 );
		setMaxWidth( 70 );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
	}

	public short getMinValue() {
		return( minValue );
	}
	
	public void setMinValue( short value ) {
		minValue = value;
	}
	
	public short getMaxValue() {
		return( maxValue );
	}
	
	public void setMaxValue( short value ) {
		maxValue = value;
	}
	
	public void setInt16Value( Short value ) {
		if( value == null ) {
			setText( "" );
		}
		else {
			String text = getDefaultFormat().format( value );
			setText( text );
		}
	}
	
	public Short getInt16Value() {
		final String S_ProcName = "getInt16Value";
		Short retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = null;
		}
		else {
			Short v = Short.valueOf( text );
			if( v == null ) {
				throw new CFLibInvalidArgumentException( fieldName,
						S_ProcName,
						0,
						"text",
						text );
			}
			if( v.compareTo( minValue ) < 0 ) {
				throw new CFLibArgumentUnderflowException( fieldName,
						S_ProcName,
						1,
						fieldName,
						v,
						minValue );
			}
			if( v.compareTo( maxValue ) > 0 ) {
				throw new CFLibArgumentOverflowException( fieldName,
						S_ProcName,
						1,
						fieldName,
						v,
						maxValue );
			}
			retval = v;
		}
		return( retval );
	}
}
