/*
 *  MSS Code Factory CFBam 2.12 CFBamXmlLoader
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

package org.msscf.msscf.cfbamcust.CFBamXmlLoader;

import org.msscf.msscf.cflib.CFLib.*;
import org.xml.sax.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamXmlLoaderCPlusMethodBodyHandler SAX Element Handler implementation
 */
public class CFBamXmlLoaderCPlusMethodBodyHandler
	extends CFLibXmlCoreElementHandler
{
	public CFBamXmlLoaderCPlusMethodBodyHandler( CFBamXmlLoader saxLoader ) {
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

		assert qName.equals( "CPlusMethodBody" );

		CFLibXmlCoreContext curContext = getParser().getCurContext();
		if( ! CFBamXmlLoader.getProcessSchema( curContext ) ) {
			return;
		}

		CFLibXmlCoreContext parentContext = curContext.getPrevContext();
		ICFBamServerMethodObj serverMethod;
		if( parentContext != null ) {
			serverMethod = (ICFBamServerMethodObj)parentContext.getNamedValue( "Object" );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Scope must be an existing ServerMethod element" );
		}

		curContext.putNamedValue( "Object", serverMethod );
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
		final String S_ProcName = "endElement";

		CFLibXmlCoreContext curContext = getParser().getCurContext();
		if( ! CFBamXmlLoader.getProcessSchema( curContext ) ) {
			return;
		}

		ICFBamServerMethodObj serverMethod = (ICFBamServerMethodObj)curContext.getNamedValue( "Object" );

		String text = curContext.getElementText();

		ICFBamServerMethodEditObj editServerMethod = (ICFBamServerMethodEditObj)serverMethod.beginEdit();
		editServerMethod.setRequiredCppMethodBody( text );
		editServerMethod.update();
		editServerMethod = null;
	}
}
