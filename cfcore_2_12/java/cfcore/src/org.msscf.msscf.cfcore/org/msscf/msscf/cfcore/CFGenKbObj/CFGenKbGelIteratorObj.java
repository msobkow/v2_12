// Description: Java 11 base object instance implementation for CFGenKb GelIterator.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.*;

public class CFGenKbGelIteratorObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelIteratorObj
{
	public final static String CLASS_CODE = "GITR";

	public CFGenKbGelIteratorObj() {
		super();
	}

	public CFGenKbGelIteratorObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelIterator" );
	}

	public ICFLibAnyObj getScope() {
		return( super.getScope() );
	}

	public ICFLibAnyObj getObjScope() {
		return( super.getObjScope() );
	}

	public String getObjName() {
		String objName;
		long val = getRequiredGelInstId();
		objName = Long.toString( val );
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFGenKbClusterObj ) {
					break;
				}
				else if( container instanceof ICFGenKbTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFGenKbClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFGenKbTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public ICFGenKbGelInstructionObj realise() {
		ICFGenKbGelIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().realiseGelIterator(
			(ICFGenKbGelIteratorObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().forgetGelIterator( (ICFGenKbGelIteratorObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().readGelIteratorByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelIteratorObj retobj = ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().readGelIteratorByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelIteratorTableObj getGelIteratorTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelIterator().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelIterator().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredGelCacheId(),
						getPKey().getRequiredGelInstId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFGenKbGelInstructionBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelIteratorBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelIteratorBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelIteratorBuff getGelIteratorBuff() {
		return( (CFGenKbGelIteratorBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelIteratorObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelIteratorObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().lockGelIterator( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelIteratorTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelIteratorEditObj getEditAsGelIterator() {
		return( (ICFGenKbGelIteratorEditObj)edit );
	}

	public String getRequiredIteratorName() {
		return( getGelIteratorBuff().getRequiredIteratorName() );
	}

	public String getOptionalExpandBefore() {
		return( getGelIteratorBuff().getOptionalExpandBefore() );
	}

	public String getOptionalExpandFirst() {
		return( getGelIteratorBuff().getOptionalExpandFirst() );
	}

	public String getRequiredExpandEach() {
		return( getGelIteratorBuff().getRequiredExpandEach() );
	}

	public String getOptionalExpandLast() {
		return( getGelIteratorBuff().getOptionalExpandLast() );
	}

	public String getOptionalExpandLone() {
		return( getGelIteratorBuff().getOptionalExpandLone() );
	}

	public String getOptionalExpandEmpty() {
		return( getGelIteratorBuff().getOptionalExpandEmpty() );
	}

	public String getOptionalExpandAfter() {
		return( getGelIteratorBuff().getOptionalExpandAfter() );
	}

	public String expand( MssCFGenContext genContext ) {
		String						itemExpansion = null;
		ICFLibAnyObj				detailDef = null;
		MssCFGenContext				detailContext = null;
		int							idx;
		int							numItems = 0;
		List<ICFLibAnyObj>		detailList;

		ICFGenKbGenItemObj		itemBefore = null;
		ICFGenKbGenItemObj		itemAfter = null;
		ICFGenKbGenItemObj		itemEmpty = null;

		ICFGenKbGenItemObj		itemRule = null;

		String					failedBefore = null;
		String					failedFirst = null;
		String					failedEach = null;
		String					failedLast = null;
		String					failedAfter = null;
		String					failedLone = null;
		String					failedEmpty = null;

		String					expansion = null;
		MssCFGenContext			subContext = null;

		final String S_ProcName = "CFGenKbGelIteratorObj.expand() ";

		String				iteratorName = getRequiredIteratorName();
		String				bodyBefore = getOptionalExpandBefore();
		String				bodyFirst = getOptionalExpandFirst();
		String				bodyEach = getRequiredExpandEach();
		String				bodyLast = getOptionalExpandLast();
		String				bodyAfter = getOptionalExpandAfter();
		String				bodyLone = getOptionalExpandLone();
		String				bodyEmpty = getOptionalExpandEmpty();

		String generatingBuild = genContext.getGeneratingBuild();
		MssCFEngine genEngine = genContext.getGenEngine();

		ICFGenKbGenItemObj genItem = genEngine.findContextItem(genContext, iteratorName );
		if( genItem == null ) {
			genEngine.getLog().message( "Could not find iterator \""
				+ iteratorName
				+ "\" attempting to expand \""
				+ "$" + getRequiredSourceText() + "$\"" );
			return( null );
		}

		if( ! ( genItem instanceof MssCFGenIteratorObj ) ) {
			genEngine.getLog().message( "Context item \""
				+ iteratorName
				+ "\" must be a MssCFGenIteratorObj, not a "
				+ genItem.getClass().getPackage().getName() + "." + genItem.getClass().getSimpleName()
				+ ".  \""
				+ "$" + getRequiredSourceText() + "$"
				+ "\" is invalid" );
			return( null );
		}

		MssCFGenIteratorObj	iterator = (MssCFGenIteratorObj)genItem;

		String detailClassName;
		if (iterator.getDetailClass() != null) {
			detailClassName = iterator.getDetailClass().getRequiredName();
		}
		else {
			detailClassName = genEngine.getAnyClassName();
		}

		iteratorName = iterator.getRequiredName();

		if( ( iteratorName == null ) || ( 0 == iteratorName.length() ) ) {
			throw new RuntimeException( S_ProcName +  "Iterator is not properly named" );
		}

		if( ( detailClassName == null ) || ( 0 == detailClassName.length() ) ) {
			throw new RuntimeException( S_ProcName +  "Iterator must specify a detail class name" );
		}

	//	Create a sub-context for locating the iterators

		subContext = genEngine.getGenContextFactory().newGenContext( generatingBuild,
			genContext,
			detailClassName,
			null );
		subContext.setPrevContext( genContext );

		if( bodyBefore != null ) {
			failedBefore = "$" + bodyBefore + "$";
			itemBefore = genEngine.findContextItem( genContext, bodyBefore );
			if( itemBefore == null ) {
				genEngine.getLog().message( "Could not find expansion item for iterator \""
					+ iteratorName
					+ "\" "
					+ MssCFGelCompiler._ITERATOR_BEFORE
					+ " \""
					+ bodyBefore
					+ "\"" );
			}
		}

		if( bodyAfter != null ) {
			failedAfter = "$" + bodyAfter + "$";
			itemAfter = genEngine.findContextItem( genContext, bodyAfter );
			if( itemAfter == null ) {
				genEngine.getLog().message( "Could not find expansion item for iterator \""
					+ iteratorName
					+ "\" "
					+ MssCFGelCompiler._ITERATOR_AFTER
					+ " \""
					+ bodyAfter
					+ "\"" );
			}
		}

		if( bodyEmpty != null ) {
			failedEmpty = "$" + bodyEmpty + "$";
			if( ! bodyEmpty.equals( MssCFGelCompiler._ITERATOR_EMPTY ) ) {
				itemEmpty = genEngine.findContextItem( genContext, bodyEmpty );
				if( itemEmpty == null ) {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_EMPTY
						+ " \""
						+ bodyEmpty
						+ "\"" );
				}
			}
		}

		if( bodyFirst != null ) {
			failedFirst = "$" + bodyFirst + "$";
		}

		if( bodyEach != null ) {
			failedEach = "$" + bodyEach + "$";
		}

		if( bodyLast != null ) {
			failedLast = "$" + bodyLast + "$";
		}

		if( bodyLone != null ) {
			failedLone = "$" + bodyLone + "$";
		}

	//	compile the iteration.  If we got a null iteration back, something
	//	went wrong and we treat the expansion as being in error.

		detailList = iterator.getDetailList( genContext );
		if( detailList == null ) {
			genEngine.getLog().message( "Could not get "
				+ iteratorName
				+ " detail object iteration.  \""
				+ "$" + getRequiredSourceText() + "$"
				+ "\" is invalid" );
			return( null );
		}

	//	Prepare to perform the expansions

		expansion = "";

	//	If a BEFORE item is provided, we always expand it using the CURRENT
	//	context, not a sub-context.

		if( bodyBefore != null ) {
			if( itemBefore != null ) {
				itemExpansion = genContext.expandItemBody( itemBefore );
				if( itemExpansion != null ) {
					expansion = expansion + itemExpansion;
				}
				else {
					expansion = expansion + failedBefore;
				}
			}
			else {
				expansion = expansion + failedBefore;
			}
		}

	//	How we perform the expansion depends on what iterator limbs
	//	have been specified and on the number of items to process.

		numItems = detailList.size();

		//	If the detail set is empty, expand EMPTY if it's provided

		if( numItems == 0 ) {
			if( bodyEmpty != null ) {
				if( itemEmpty != null ) {
					itemExpansion = genContext.expandItemBody( itemEmpty );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedEmpty;
					}
				}
				else if( ! bodyEmpty.equals( MssCFGelCompiler._ITERATOR_EMPTY ) ) {
					expansion = expansion + failedEmpty;
				}
			}
			else {
				genEngine.getLog().message( "Expansion of iterator \"" + iteratorName + "\" returned an empty set" );
			}
		}

	//	If the detail set has one item, preferentially expand one of
	//	LONE, LAST, FIRST, or EACH limb

		else if( numItems == 1 ) {

			detailDef = detailList.get(0);
			detailContext = genEngine.getGenContextFactory().newGenContext( generatingBuild,
				genContext,
				detailDef.getGenDefName(),
				detailDef );
			detailContext.setPrevContext( genContext );

			if( bodyLone != null ) {
				itemRule = genEngine.findContextItem( detailContext, bodyLone );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedLone;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_LONE
						+ " \""
						+ bodyLone
						+ "\"" );
					expansion = expansion + failedLone;
				}
			}
			else if( bodyFirst != null ) {
				itemRule = genEngine.findContextItem( detailContext, bodyFirst );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedFirst;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_FIRST
						+ " \""
						+ bodyFirst
						+ "\"" );
					expansion = expansion + failedFirst;
				}
			}
			else if( bodyLast != null ) {
				itemRule = genEngine.findContextItem( detailContext, bodyLast );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedLast;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_LAST
						+ " \""
						+ bodyLast
						+ "\"" );
					expansion = expansion + failedLast;
				}
			}
			else {
				itemRule = genEngine.findContextItem( detailContext, bodyEach );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedEach;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_EACH
						+ " \""
						+ bodyEach
						+ "\"" );
					expansion = expansion + failedEach;
				}
			}
		}
		else {

	//	If the detail set has n items:

	//		The first item is expanded by FIRST or EACH

			detailDef = detailList.get(0);
			detailContext = genEngine.getGenContextFactory().newGenContext( generatingBuild,
				genContext,
				detailDef.getGenDefName(),
				detailDef );
			detailContext.setPrevContext( genContext );

			if( bodyFirst != null ) {
				itemRule = genEngine.findContextItem( detailContext, bodyFirst );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedFirst;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_FIRST
						+ " \""
						+ bodyFirst
						+ "\"" );
					expansion = expansion + failedFirst;
				}
			}
			else {
				itemRule = genEngine.findContextItem( detailContext, bodyEach );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedEach;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_EACH
						+ " \""
						+ bodyEach
						+ "\"" );
					expansion = expansion + failedEach;
				}
			}

	//		The middle items are always expanded by EACH

			for( idx = 1; idx < numItems - 1; idx ++ ) {

				detailDef = detailList.get( idx );
				detailContext = genEngine.getGenContextFactory().newGenContext( generatingBuild,
					genContext,
					detailDef.getGenDefName(),
					detailDef );
				detailContext.setPrevContext( genContext );

				itemRule = genEngine.findContextItem( detailContext, bodyEach );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedEach;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_EACH
						+ " \""
						+ bodyEach
						+ "\"" );
					expansion = expansion + failedEach;
				}
			}

	//		The last item is expanded by LAST or EACH

			detailDef = detailList.get( numItems - 1 );
			detailContext = genEngine.getGenContextFactory().newGenContext( generatingBuild,
				genContext,
				detailDef.getGenDefName(),
				detailDef );
			detailContext.setPrevContext( genContext );

			if( bodyLast != null ) {
				itemRule = genEngine.findContextItem( detailContext, bodyLast );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedLast;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_LAST
						+ " \""
						+ bodyLast
						+ "\"" );
					expansion = expansion + failedLast;
				}
			}
			else {
				itemRule = genEngine.findContextItem( detailContext, bodyEach );
				if( itemRule != null ) {
					itemExpansion = detailContext.expandItemBody( itemRule );
					if( itemExpansion != null ) {
						expansion = expansion + itemExpansion;
					}
					else {
						expansion = expansion + failedEach;
					}
				}
				else {
					genEngine.getLog().message( "Could not find expansion item for iterator \""
						+ iteratorName
						+ "\" "
						+ MssCFGelCompiler._ITERATOR_EACH
						+ " \""
						+ bodyEach
						+ "\"" );
					expansion = expansion + failedEach;
				}
			}
		}

	//	If an AFTER item is provided, we always expand it using the CURRENT
	//	context, not a sub-context.

		if( bodyAfter != null ) {
			if( itemAfter != null ) {
				itemExpansion = genContext.expandItemBody( itemAfter );
				if( itemExpansion != null ) {
					expansion = expansion + itemExpansion;
				}
				else {
					expansion = expansion + failedAfter;
				}
			}
			else {
				expansion = expansion + failedAfter;
			}
		}

	//	Return the cumulative results of the expansion

		return( expansion );
	}
}
