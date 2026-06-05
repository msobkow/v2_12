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

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGenIteratorObj
extends CFGenKbGenIteratorObj
{
	protected ICFGenKbDefClassObj detailClass = null;
	public ICFGenKbDefClassObj getDetailClass() {
		return (detailClass);
	}

	public void setDetailClass( ICFGenKbDefClassObj value ) {
		final String S_ProcName = "MssCFGenIteratorObj.setDetailClass() ";
		if (value == null)
		{
			throw new RuntimeException(S_ProcName + "CFGenIteratorObj.DetailClass.Set() argument is null");
		}
		detailClass = value;
	}

	protected ICFGenKbDefClassObj requiredLookupDetailDef = null;
	public ICFGenKbDefClassObj getRequiredLookupDetailDef() {
		return (requiredLookupDetailDef);
	}

	public void setRequiredLookupDetailDef( ICFGenKbDefClassObj value ) {
		requiredLookupDetailDef = value;
	}

	public MssCFGenIteratorObj() {
		super();
	}

	public MssCFGenIteratorObj(MssCFEngine schema) {
		super( schema );
	}

	public MssCFGenIteratorObj(
		MssCFEngine engine,
		String toolset,
		String scopeDefClassName,
		String genDefClassName,
		String itemName,
		String detailClassName )
	{
		super( engine );

		requiredLookupToolSet = schema.getToolSetTableObj().readToolSetByNameIdx(toolset);
		CFGenKbGenItemBuff genItemRec = getGenItemBuff();

		genItemRec.setRequiredToolSetId( requiredLookupToolSet.getRequiredId() );

		if (scopeDefClassName != null && scopeDefClassName.length() > 0) {
			if (scopeDefClassName.equals("*")) {
				scopeDefClassName = "Object";
			}
			else {
				scopeDefClassName = engine.fixGenDefName( scopeDefClassName );
			}
			optionalLookupScopeDef = schema.getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
			genItemRec.setOptionalScopeDefId( optionalLookupScopeDef.getRequiredId() );
		}
		else {
			optionalLookupScopeDef = null;
			genItemRec.setOptionalScopeDefId( null );
		}

		genDefClassName = engine.fixGenDefName( genDefClassName );
		requiredLookupGenDef = schema.getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		genItemRec.setRequiredGenDefId( requiredLookupGenDef.getRequiredId() );

		genItemRec.setRequiredName( itemName );

		requiredLookupDetailDef = schema.getDefClassTableObj().readDefClassByNameIdx( detailClassName );
	}

	/**
	 *	Get an enumeration of the members of the detail set/list
	 *
	 *	@return	Enumeration
	 */
	public ListIterator<ICFLibAnyObj> enumerateDetails(MssCFGenContext genContext) {
		final String S_ProcName = "MssCFGenIteratorObj.enumerateDetails() ";
		throw new RuntimeException( S_ProcName + "Override not implemented yet");
	}

	/**
	 *	Iterators should NOT be expanded like other items.
	 *
	 *	@return	String
	 */
	public String expandBody( MssCFGenContext genContext ) {
		final String S_ProcName = "MssCFGenIteratorObj.expandBody() ";
		throw new RuntimeException( S_ProcName + "MssCFGenIterator instances can not be expanded directly" );
	}	

	/**
	 *	Expanding an iterator using Each syntax requires a rule to be applied for each element
	 *	of the iteration.
	 *
	 *	@param		genContext		The CFGenContext of the iteration
	 *	@param		body				The String defining the body to expand for each element.
	 *
	 *	@return	String
	 */
	public String expandEach( MssCFGenContext genContext, String body )
	{
		String subExpansion = null;
		MssCFGenContext subContext = null;
		String subClassName = null;
		ICFLibAnyObj elt = null;
		Iterator<ICFLibAnyObj>	e;
		List<ICFLibAnyObj> v = null;
		String ret = "";
		final String S_ProcName = "CFGenIteratorObj.expandEach() ";

		if( genContext == null ) {
			throw new RuntimeException( S_ProcName + "genContext is null" );
		}

		if( ( body == null ) || ( 0 == body.length()) ) {
			throw new RuntimeException( S_ProcName + "body is null" );
		}

		//	getDetailList() is used to ensure that the element list is of the proper detail type

		v = getDetailList( genContext );
		if( v == null ) {
			throw new RuntimeException( S_ProcName + "getDetailList() returned a null vector" );
		}

		//	Get the attributes of the generation context for creating sub-contexts

		subClassName = getDetailClass().getRequiredName();

		ICFGenKbGenItemObj genItem;
		e = v.iterator();
		while( e.hasNext() ) {
			elt = e.next();
			if( elt instanceof ICFGenKbGenItemObj ) {
				genItem = (ICFGenKbGenItemObj)elt;
				subContext = genContext.getGenEngine().getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
					genContext,
					subClassName,
					elt );
				subExpansion = subContext.expandItemBody( genItem );
				if( subExpansion != null ) {
					ret = ret + subExpansion;
				}
			}
			else {
				throw new RuntimeException( S_ProcName + "Expected element to be an ICFGenKbGenItemObj, not a " + elt.getClass().getSimpleName() );
			}
		}

		//	Return the final expansion string

		return( ret );
	}	

	/**
	 *	Get a vector of the enumerated details so that the expansion engine knows how many details there are.
	 *	Ideally the elements of the enumerateDetails() enumeration would check to ensure that the elements
	 *	are instances of _DetailClass.  Unfortunately the <tt>instanceof</tt> operator only works with a
	 *	constant Class, not a dynamic Class instance.
	 *
	 *	@param		genContext		CFGenContext
	 *
	 *	@return	Vector
	 */
	public List<ICFLibAnyObj> getDetailList( MssCFGenContext genContext ){
		ICFLibAnyObj elt;
		List<ICFLibAnyObj> ret = null;
		ListIterator<ICFLibAnyObj> e;
		final String S_ProcName = "CFGenIteratorObj.getDetailList() ";

		if( genContext == null ) {
			throw new RuntimeException( S_ProcName + "genContext is null" );
		}

		e = enumerateDetails( genContext );
		ret = new ArrayList<ICFLibAnyObj>();

		while( e.hasNext() ) {
			elt = e.next();
			ret.add( elt );
		}

		return( ret );
	}
}
