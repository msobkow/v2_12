/*
 *  MSS Code Factory CFBam 2.12 CFBamXmlLoader
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

package org.msscf.msscf.cfbamcust.CFBamXmlLoader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.apache.commons.codec.binary.Base64;
import org.xml.sax.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamXmlLoaderCafeSchemaObjImplementationHandler SAX Element Handler implementation
 */
public class CFBamXmlLoaderCafeSchemaObjImportHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXmlLoaderCafeSchemaObjImportHandler( CFBamXmlLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		final String S_ProcName = "startElement";

		assert qName.equals( "CafeSchemaObjImplementation" );

		CFLibXmlCoreContext curContext = getParser().getCurContext();
		if( ! CFBamXmlLoader.getProcessSchema( curContext ) ) {
			return;
		}

		CFLibXmlCoreContext parentContext = curContext.getPrevContext();
		ICFBamSchemaDefObj schemaDef;
		if( parentContext != null ) {
			schemaDef = (ICFBamSchemaDefObj)parentContext.getNamedValue( "Object" );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Scope must be an existing SchemaDef element" );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
		final String S_ProcName = "endElement";

		assert qName.equals( "CafeSchemaObjImplementation" );

		CFLibXmlCoreContext curContext = getParser().getCurContext();
		if( ! CFBamXmlLoader.getProcessSchema( curContext ) ) {
			return;
		}

		CFLibXmlCoreContext parentContext = curContext.getPrevContext();
		ICFBamSchemaDefObj schemaDef;
		if( parentContext != null ) {
			schemaDef = (ICFBamSchemaDefObj)parentContext.getNamedValue( "Object" );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Scope must be an existing SchemaDef element" );
		}

		String text = curContext.getElementText();

		ICFBamSchemaDefEditObj editSchemaDef = (ICFBamSchemaDefEditObj)schemaDef.beginEdit();
		editSchemaDef.setOptionalJSchemaObjImport( text );
		editSchemaDef.update();
		editSchemaDef = null;
	}
}
