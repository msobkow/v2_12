// Description: Java 11 base object instance implementation for CFGenKb GelSpread.

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

public class CFGenKbGelSpreadObj
	extends CFGenKbGelInstructionObj
	implements ICFGenKbGelSpreadObj
{
	public final static String CLASS_CODE = "GSPR";

	public CFGenKbGelSpreadObj() {
		super();
	}

	public CFGenKbGelSpreadObj( ICFGenKbSchemaObj argSchema ) {
		super( argSchema );
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "GelSpread" );
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
		ICFGenKbGelSpreadObj retobj = ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().realiseGelSpread(
			(ICFGenKbGelSpreadObj)this );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().forgetGelSpread( (ICFGenKbGelSpreadObj)this, forgetSubObjects );
	}

	public ICFGenKbGelInstructionObj read() {
		ICFGenKbGelSpreadObj retobj = ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().readGelSpreadByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), false );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelInstructionObj read( boolean forceRead ) {
		ICFGenKbGelSpreadObj retobj = ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().readGelSpreadByPIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredGelCacheId(),
			getPKey().getRequiredGelInstId(), forceRead );
		return( (ICFGenKbGelInstructionObj)retobj );
	}

	public ICFGenKbGelSpreadTableObj getGelSpreadTable() {
		return( ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj() );
	}

	public CFGenKbGelInstructionBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getFactoryGelSpread().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFGenKbSchema)schema.getBackingStore()).getTableGelSpread().readDerivedByPIdx( ((ICFGenKbSchemaObj)schema).getAuthorization(),
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
		if( ! ( ( value == null ) || ( value instanceof CFGenKbGelSpreadBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFGenKbGelSpreadBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerGelCache = null;
		optionalLookupChainInst = null;
	}

	public CFGenKbGelSpreadBuff getGelSpreadBuff() {
		return( (CFGenKbGelSpreadBuff)getBuff() );
	}

	public ICFGenKbGelInstructionEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFGenKbGelSpreadObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFGenKbGelSpreadObj)this;
		}
		else {
			lockobj = ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().lockGelSpread( getPKey() );
		}
		edit = ((ICFGenKbSchemaObj)schema).getGelSpreadTableObj().newEditInstance( lockobj );
		return( (ICFGenKbGelInstructionEditObj)edit );
	}

	public ICFGenKbGelSpreadEditObj getEditAsGelSpread() {
		return( (ICFGenKbGelSpreadEditObj)edit );
	}

	public String getRequiredIteratorName() {
		return( getGelSpreadBuff().getRequiredIteratorName() );
	}

	public String getOptionalExpandBetween() {
		return( getGelSpreadBuff().getOptionalExpandBetween() );
	}

	public String getOptionalExpandBefore() {
		return( getGelSpreadBuff().getOptionalExpandBefore() );
	}

	public String getOptionalExpandFirst() {
		return( getGelSpreadBuff().getOptionalExpandFirst() );
	}

	public String getRequiredExpandEach() {
		return( getGelSpreadBuff().getRequiredExpandEach() );
	}

	public String getOptionalExpandLast() {
		return( getGelSpreadBuff().getOptionalExpandLast() );
	}

	public String getOptionalExpandLone() {
		return( getGelSpreadBuff().getOptionalExpandLone() );
	}

	public String getOptionalExpandEmpty() {
		return( getGelSpreadBuff().getOptionalExpandEmpty() );
	}

	public String getOptionalExpandAfter() {
		return( getGelSpreadBuff().getOptionalExpandAfter() );
	}

	public String expand( MssCFGenContext genContext ) {
		String					itemExpansion = null;
		ICFLibAnyObj			detailDef = null;
		MssCFGenContext			detailContext = null;
		int						idx;
		int						numItems = 0;
		int						totalItems = 0;
		List<ICFLibAnyObj>		detailList;

		ICFGenKbGenItemObj		itemBetween = null;
		ICFGenKbGenItemObj		itemBefore = null;
		ICFGenKbGenItemObj		itemAfter = null;
		ICFGenKbGenItemObj		itemEmpty = null;

		ICFGenKbGenItemObj		itemRule = null;

		String					failedBetween = null;
		String					failedBefore = null;
		String					failedFirst = null;
		String					failedEach = null;
		String					failedLast = null;
		String					failedAfter = null;
		String					failedLone = null;
		String					failedEmpty = null;

		String					expansion = null;
		MssCFGenContext			subContext = null;

		final String S_ProcName = "CFGenKbGelSpreadObj.expand() ";

		String				iteratorName = getRequiredIteratorName();
		String				bodyBetween = getOptionalExpandBetween();
		String				bodyBefore = getOptionalExpandBefore();
		String				bodyFirst = getOptionalExpandFirst();
		String				bodyEach = getRequiredExpandEach();
		String				bodyLast = getOptionalExpandLast();
		String				bodyAfter = getOptionalExpandAfter();
		String				bodyLone = getOptionalExpandLone();
		String				bodyEmpty = getOptionalExpandEmpty();

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

		subContext = genEngine.getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
			genContext,
			detailClassName,
			null );
		subContext.setPrevContext( genContext );

		if( bodyBetween != null ) {
			failedBetween = "$" + bodyBetween + "$";
			itemBetween = genEngine.findContextItem( genContext, bodyBetween );
			if( itemBetween == null ) {
				genEngine.getLog().message( "Could not find expansion item for iterator \""
					+ iteratorName
					+ "\" "
					+ MssCFGelCompiler._SPREAD_BETWEEN
					+ " \""
					+ bodyBetween
					+ "\"" );
			}
		}

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

		detailList = iterator.getDetailList( genContext );
		if( detailList == null ) {
			genEngine.getLog().message( "Could not get "
				+ iteratorName
				+ " detail object iteration.  \""
				+ "$" + getRequiredSourceText() + "$"
				+ "\" is invalid" );
			return( null );
		}

		expansion = "";

		totalItems = detailList.size();

		if( totalItems <= 0 ) {
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
		else {

			numItems = totalItems;
			while( numItems > 0 ) {

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

				if( numItems == 1 ) {

					detailDef = detailList.get(0);
					detailContext = genEngine.getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
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

					detailDef = detailList.get(0);
					detailContext = genEngine.getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
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

					for( idx = 1; idx < numItems - 1; idx ++ ) {

						detailDef = detailList.get( idx );
						detailContext = genEngine.getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
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

					detailDef = detailList.get( numItems - 1 );
					detailContext = genEngine.getGenContextFactory().newGenContext( genContext.getGeneratingBuild(),
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


				numItems --;

				if( numItems > 0 ) {
					if( bodyBetween != null ) {
						if( itemBetween != null ) {
							itemExpansion = genContext.expandItemBody( itemBetween );
							if( itemExpansion != null ) {
								expansion = expansion + itemExpansion;
							}
							else {
								expansion = expansion + failedBetween;
							}
						}
						else {
							expansion = expansion + failedBetween;
						}
					}
				}
			}
		}

		return( expansion );
	}
}
