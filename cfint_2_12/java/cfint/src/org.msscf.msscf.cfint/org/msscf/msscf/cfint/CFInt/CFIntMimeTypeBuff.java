// Description: Java 11 implementation of a MimeType buffer object.

/*
 *	org.msscf.msscf.CFInt
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public class CFIntMimeTypeBuff
{
	public final static String CLASS_CODE = "MIME";
	public final static String S_INIT_CREATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_CREATEDBY = UUID.fromString( S_INIT_CREATEDBY );
	public final static String S_INIT_UPDATEDBY = "654dbba0-eda7-11e1-aff1-0800200c9a66";
	public final static UUID INIT_UPDATEDBY = UUID.fromString( S_INIT_UPDATEDBY );
	public static final int MIMETYPEID_INIT_VALUE = 0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String FILETYPES_INIT_VALUE = new String( "" );
	public static final int MIMETYPEID_MIN_VALUE = 0;
	protected UUID createdByUserId = CFIntMimeTypeBuff.INIT_CREATEDBY;
	protected Calendar createdAt = Calendar.getInstance();
	protected UUID updatedByUserId = CFIntMimeTypeBuff.INIT_UPDATEDBY;
	protected Calendar updatedAt = Calendar.getInstance();
	protected int requiredMimeTypeId;
	protected String requiredName;
	protected String optionalFileTypes;
	protected int requiredRevision;
	public CFIntMimeTypeBuff() {
		requiredMimeTypeId = CFIntMimeTypeBuff.MIMETYPEID_INIT_VALUE;
		requiredName = new String( CFIntMimeTypeBuff.NAME_INIT_VALUE );
		optionalFileTypes = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public UUID getCreatedByUserId() {
		return( createdByUserId );
	}

	public void setCreatedByUserId( UUID value ) {
		createdByUserId = value;
	}

	public Calendar getCreatedAt() {
		return( createdAt );
	}

	public void setCreatedAt( Calendar value ) {
		createdAt = value;
	}

	public UUID getUpdatedByUserId() {
		return( updatedByUserId );
	}

	public void setUpdatedByUserId( UUID value ) {
		updatedByUserId = value;
	}

	public Calendar getUpdatedAt() {
		return( updatedAt );
	}

	public void setUpdatedAt( Calendar value ) {
		updatedAt = value;
	}
	public int getRequiredMimeTypeId() {
		return( requiredMimeTypeId );
	}

	public void setRequiredMimeTypeId( int value ) {
		if( value < CFIntMimeTypeBuff.MIMETYPEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredMimeTypeId",
				1,
				"value",
				value,
				CFIntMimeTypeBuff.MIMETYPEID_MIN_VALUE );
		}
		requiredMimeTypeId = value;
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		requiredName = value;
	}

	public String getOptionalFileTypes() {
		return( optionalFileTypes );
	}

	public void setOptionalFileTypes( String value ) {
		if( value == null ) {
			optionalFileTypes = null;
		}
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalFileTypes",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		else {
			optionalFileTypes = value;
		}
	}

	public int getRequiredRevision() {
		return( requiredRevision );
	}

	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFIntMimeTypeBuff ) {
			CFIntMimeTypeBuff rhs = (CFIntMimeTypeBuff)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredMimeTypeId() != rhs.getRequiredMimeTypeId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					if( ! getOptionalFileTypes().equals( rhs.getOptionalFileTypes() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFIntMimeTypePKey ) {
			CFIntMimeTypePKey rhs = (CFIntMimeTypePKey)obj;
			if( getRequiredMimeTypeId() != rhs.getRequiredMimeTypeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntMimeTypeHBuff ) {
			CFIntMimeTypeHBuff rhs = (CFIntMimeTypeHBuff)obj;
			if( getRequiredMimeTypeId() != rhs.getRequiredMimeTypeId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					if( ! getOptionalFileTypes().equals( rhs.getOptionalFileTypes() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFIntMimeTypeHPKey ) {
			CFIntMimeTypeHPKey rhs = (CFIntMimeTypeHPKey)obj;
			if( getRequiredMimeTypeId() != rhs.getRequiredMimeTypeId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFIntMimeTypeByUNameIdxKey ) {
			CFIntMimeTypeByUNameIdxKey rhs = (CFIntMimeTypeByUNameIdxKey)obj;
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredMimeTypeId();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalFileTypes() != null ) {
			hashCode = hashCode + getOptionalFileTypes().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFIntMimeTypeBuff ) {
			CFIntMimeTypeBuff rhs = (CFIntMimeTypeBuff)obj;
			int retval = 0;
			{
				int cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredMimeTypeId() < rhs.getRequiredMimeTypeId() ) {
				return( -1 );
			}
			else if( getRequiredMimeTypeId() > rhs.getRequiredMimeTypeId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					int cmp = getOptionalFileTypes().compareTo( rhs.getOptionalFileTypes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntMimeTypePKey ) {
			CFIntMimeTypePKey rhs = (CFIntMimeTypePKey)obj;
			if( getRequiredMimeTypeId() < rhs.getRequiredMimeTypeId() ) {
				return( -1 );
			}
			else if( getRequiredMimeTypeId() > rhs.getRequiredMimeTypeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntMimeTypeHPKey ) {
			CFIntMimeTypeHPKey rhs = (CFIntMimeTypeHPKey)obj;
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			if( getRequiredMimeTypeId() < rhs.getRequiredMimeTypeId() ) {
				return( -1 );
			}
			else if( getRequiredMimeTypeId() > rhs.getRequiredMimeTypeId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFIntMimeTypeHBuff ) {
			CFIntMimeTypeHBuff rhs = (CFIntMimeTypeHBuff)obj;
			int retval = 0;
			if( getRequiredMimeTypeId() < rhs.getRequiredMimeTypeId() ) {
				return( -1 );
			}
			else if( getRequiredMimeTypeId() > rhs.getRequiredMimeTypeId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalFileTypes() != null ) {
				if( rhs.getOptionalFileTypes() != null ) {
					int cmp = getOptionalFileTypes().compareTo( rhs.getOptionalFileTypes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFileTypes() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFIntMimeTypeByUNameIdxKey ) {
			CFIntMimeTypeByUNameIdxKey rhs = (CFIntMimeTypeByUNameIdxKey)obj;

			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	public void set( CFIntMimeTypeBuff src ) {
		setMimeTypeBuff( src );
	}

	public void setMimeTypeBuff( CFIntMimeTypeBuff src ) {
		setRequiredMimeTypeId( src.getRequiredMimeTypeId() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredName( src.getRequiredName() );
		setOptionalFileTypes( src.getOptionalFileTypes() );
		setRequiredRevision( src.getRequiredRevision() );
	}

	public void set( CFIntMimeTypeHBuff src ) {
		setMimeTypeBuff( src );
	}

	public void setMimeTypeBuff( CFIntMimeTypeHBuff src ) {
		setRequiredMimeTypeId( src.getRequiredMimeTypeId() );
		setRequiredName( src.getRequiredName() );
		setOptionalFileTypes( src.getOptionalFileTypes() );
	}
}
