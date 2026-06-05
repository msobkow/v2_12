
// Description: Java 11 XML SAX Element Handler for SecDevice

/*
 *	org.msscf.msscf.CFInt
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
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfint.CFIntSaxLoader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/*
 *	CFIntSaxLoaderSecDeviceParse XML SAX Element Handler implementation
 *	for SecDevice.
 */
public class CFIntSaxLoaderSecDevice
	extends CFLibXmlCoreElementHandler
{
	public CFIntSaxLoaderSecDevice( CFIntSaxLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		try {
			// Common XML Attributes
			String	attrId = null;
			// SecDevice Attributes
			String	attrPubKey = null;
			// SecDevice References
			ICFIntSecUserObj refSecUser = null;
			// Attribute Extraction
			String	attrLocalName;
			int		numAttrs;
			int		idxAttr;
			final String S_ProcName = "startElement";
			final String S_LocalName = "LocalName";

			assert qName.equals( "SecDevice" );

			CFIntSaxLoader saxLoader = (CFIntSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			ICFIntSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			ICFIntSecDeviceEditObj editBuff = (ICFIntSecDeviceEditObj)schemaObj.getSecDeviceTableObj().newInstance().beginEdit();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PubKey" ) ) {
					if( attrPubKey != null ) {
						throw new CFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPubKey = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw new CFLibUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values

			// Save named attributes to context
			CFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "PubKey", attrPubKey );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natPubKey = attrPubKey;
			editBuff.setOptionalPubKey( natPubKey );

			// Get the scope/container object

			CFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			// Resolve and apply required Container reference

			if( scopeObj == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"scopeObj" );
			}
			else if( scopeObj instanceof ICFIntSecUserObj ) {
				refSecUser = (ICFIntSecUserObj) scopeObj;
				editBuff.setRequiredContainerSecUser( refSecUser );
			}
			else {
				throw new CFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"ICFIntSecUserObj" );
			}

			CFIntSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecDeviceLoaderBehaviour();
			ICFIntSecDeviceEditObj editSecDevice = null;
			ICFIntSecDeviceObj origSecDevice = (ICFIntSecDeviceObj)schemaObj.getSecDeviceTableObj().readSecDeviceByNameIdx( refSecUser.getRequiredSecUserId(),
			editBuff.getRequiredDevName() );
			if( origSecDevice == null ) {
				editSecDevice = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecDevice = (ICFIntSecDeviceEditObj)origSecDevice.beginEdit();
						editSecDevice.setOptionalPubKey( editBuff.getOptionalPubKey() );
						break;
					case Replace:
						editSecDevice = (ICFIntSecDeviceEditObj)origSecDevice.beginEdit();
						editSecDevice.deleteInstance();
						editSecDevice = null;
						origSecDevice = null;
						editSecDevice = editBuff;
						break;
				}
			}

			if( editSecDevice != null ) {
				if( origSecDevice != null ) {
					editSecDevice.update();
				}
				else {
					origSecDevice = (ICFIntSecDeviceObj)editSecDevice.create();
				}
				editSecDevice = null;
			}

			curContext.putNamedValue( "Object", origSecDevice );
		}
		catch( RuntimeException e ) {
			throw new RuntimeException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
		catch( Error e ) {
			throw new Error( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
