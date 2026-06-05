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

public class MssCFGenSwitchLimb
{
	protected String _KeyName;
	protected String _MacroName;

	public MssCFGenSwitchLimb(
		String				keyName,
		String				macroName )
	{
		final String S_ProcName = "MssCFGenSwitchLimb.MssCFGenSwitchLimb() ";
		if( ( keyName == null ) || ( keyName.length() == 0 ) )
		{
			throw new RuntimeException( S_ProcName + "keyName is null or empty" );
		}
		if( ( macroName == null ) || ( macroName.length() == 0 ) )
		{
			throw new RuntimeException( S_ProcName + "macroName is null or empty" );
		}
		_KeyName = keyName;
		_MacroName = macroName;
	}

	public int compareTo( Object obj )
	{
		final String S_ProcName = "MssCFGenSwitchLimb.compareTo() ";
		if( obj instanceof MssCFGenSwitchLimb ) {
			MssCFGenSwitchLimb	rhs = (MssCFGenSwitchLimb)obj;
			if( _KeyName == null ) {
				if( rhs._KeyName == null ) {
					return( 0 );
				}
				else {	
					return( -1 );
				}
			}
			else if( rhs._KeyName == null ) {
				return( 1 );
			}
			return( _KeyName.compareTo( rhs._KeyName ) );
		}
		else if (obj instanceof String)
		{
			String rhs = (String)obj;
			if (_KeyName == null)
			{
				if (rhs == null)
				{
					return (0);
				}
				else
				{
					return (-1);
				}
			}
			else if (rhs == null)
			{
				return (1);
			}
			return (_KeyName.compareTo(rhs));
		}
		else
		{
			throw new RuntimeException( S_ProcName + "obj must be an MssCFGenSwitchLimb or String");
		}
	}

	public String getKeyName(){
		if( _KeyName != null ) {
			return( _KeyName );
		}
		else {
			return( null );
		}		
	}

	public String getMacroName(){
		return( _MacroName );
	}
}
