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

import java.util.*;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public abstract class MssCFEngine
extends CFGenKbSchemaObj
{
	public final static String		LinkName = "MssCFEngine";
	public final static String		LinkVersion = "2.12.11194";

	public final static String		GeneratorName = "MssCFEngine";
	public final static String		GeneratorVersion = LinkVersion;

	protected static boolean		debugMode = false;

	protected ICFGenKbGelCacheObj	gelCache = null;

	public ICFGenKbGelCacheObj getGelCache() {
		if( gelCache == null ) {
			ICFGenKbGelCacheObj cacheObj = (ICFGenKbGelCacheObj)( getGelCacheTableObj().newInstance() );
			ICFGenKbGelCacheEditObj cacheEdit = (ICFGenKbGelCacheEditObj)( cacheObj.beginEdit() );
			ICFGenKbTenantObj mySecTenant = getSecTenant();
			cacheEdit.setRequiredOwnerTenant( mySecTenant );
			gelCache = (ICFGenKbGelCacheObj)( cacheEdit.create() );
			cacheEdit = null;
		}
		return( gelCache );
	}

	public void setGelCache( ICFGenKbGelCacheObj value ) {
		if( gelCache != value ) {
			gelCache = value;
		}
	}

	public static boolean getDebugMode() {
		return( debugMode );
	}

	public static void enableDebugMode() {
		debugMode = true;
	}

	public static void disableDebugMode() {
		debugMode = false;
	}

	ICFGenKbTenantObj internalTenant = null;

	public abstract String fixGenDefName( String rawName );
	public abstract void bootstrapDefClasses();
	public abstract void bootstrapFirst();
	public abstract void bootstrapBindings();
	public abstract void bootstrapIterators();
	public abstract void bootstrapReferences();

	protected MssCFGelCompiler gelCompiler = null;

	public MssCFGelCompiler getGelCompiler() {
		if( gelCompiler == null ) {
			gelCompiler = new MssCFGelCompiler( this );
		}
		return( gelCompiler );
	}

	/**
	 *	Normally you'll want to overload this.
	 */
	public String getAnyClassName() {
		return( "Object" );
	}

	public ICFGenKbDefClassObj bootstrapDefClass( String name, ICFGenKbDefClassObj baseDefClass ) {
		ICFGenKbDefClassTableObj tblDefClass = getDefClassTableObj();
		ICFGenKbDefClassObj defClass = tblDefClass.readDefClassByNameIdx( name );
		if( defClass == null ) {
			defClass = tblDefClass.newInstance();
			ICFGenKbDefClassEditObj editDefClass = defClass.beginEdit();
			editDefClass.setRequiredName( name );
			editDefClass.setOptionalParentBaseDefClass( baseDefClass );
			defClass = editDefClass.create();
			editDefClass = null;
		}
		return( defClass );
	}

	/**
	 *	Get the display name for the engine.
	 *	<p>
	 *	Overload this with proper tool name.
	 */
	public String getGeneratorName()
	{
		return( GeneratorName );
	}

	public void libInitTools()
	{
		defineTool( "any" );
	}

	public void libInitToolSets()
	{
		defineToolSet( "any" );
	}


	protected TreeMap<CFGenKbDefClassPKey, TreeMap<CFGenKbDefClassPKey,Boolean>> derivationMap = null;


	public void libInitDerivationMap()
	{
		if( derivationMap != null ) {
			return;
		}

		derivationMap = new TreeMap<CFGenKbDefClassPKey, TreeMap<CFGenKbDefClassPKey,Boolean>>();

		ICFGenKbDefClassObj defClass;
		ICFGenKbDefClassObj inhClass;
		Boolean boolTrue = Boolean.valueOf( true );
		TreeMap<CFGenKbDefClassPKey,Boolean> subMap;
		Iterator<ICFGenKbDefClassObj> defClassIter = getDefClassTableObj().readAllDefClass().iterator();
		while( defClassIter.hasNext() ) {
			defClass = defClassIter.next();
			subMap = new TreeMap<CFGenKbDefClassPKey,Boolean>();
			derivationMap.put( defClass.getPKey(), subMap );
			inhClass = defClass;
			while( inhClass != null ) {
				subMap.put( inhClass.getPKey(), boolTrue );
				inhClass = inhClass.getOptionalParentBaseDefClass();
			}
		}
	}


	public boolean derivesFrom( ICFGenKbDefClassObj obj, ICFGenKbDefClassObj target )
	{
		// AnyObj is always inherited
		if( target == null ) {
			return( true );
		}

		TreeMap<CFGenKbDefClassPKey, Boolean> subMap = derivationMap.get( obj.getPKey() );
		if( subMap == null ) {
			throw new CFLibRuntimeException( getClass(), "derivesFrom", "Could not find subMap for DefClass" + obj.getRequiredName() );
		}

		Boolean entry = subMap.get( target.getPKey() );
		if( entry != null ) {
			return( true );
		}
		else {
			return( false );
		}
	}

	protected TreeMap<CFGenKbToolSetPKey, TreeMap<String,ICFGenKbGenItemObj>> toolSetRuleMap = null;


	public void initToolSetRuleMap() {
		if( toolSetRuleMap != null ) {
			return;
		}

		libInitDerivationMap();

		log.message( "Initializing tool set rule map" );

		toolSetRuleMap = new TreeMap<CFGenKbToolSetPKey, TreeMap<String, ICFGenKbGenItemObj>>();

		ICFGenKbToolSetObj toolSet;
		Iterator<ICFGenKbToolSetObj> toolSetIter = getToolSetTableObj().readAllToolSet().iterator();
		while( toolSetIter.hasNext() ) {
			toolSet = toolSetIter.next();
			initRuleMap( toolSet );
		}

		log.message( "Tool set rule map initialized" );
	}


	private class SortByProbeOrder implements Comparator {
		MssCFEngine engine;

		public SortByProbeOrder( MssCFEngine ref) {
			engine = ref;
		}

		public int compare(Object arg0, Object arg1) {
			ICFGenKbGenItemObj lhs = (ICFGenKbGenItemObj)arg0;
			ICFGenKbGenItemObj rhs = (ICFGenKbGenItemObj)arg1;
			ICFGenKbDefClassObj lhsScope = lhs.getOptionalLookupScopeDef();
			ICFGenKbDefClassObj rhsScope = rhs.getOptionalLookupScopeDef();
			ICFGenKbDefClassObj lhsGenDef;
			ICFGenKbDefClassObj rhsGenDef;
			if( lhsScope == rhsScope ) {
				lhsGenDef = lhs.getRequiredLookupGenDef();
				rhsGenDef = rhs.getRequiredLookupGenDef();
				if( lhsGenDef == rhsGenDef ) {
					return( 0 );
				}
				else if( engine.derivesFrom( lhsGenDef, rhsGenDef ) ) {
					return( -1 );
				}
				else if( engine.derivesFrom( rhsGenDef, lhsGenDef ) ) {
					return( 1 );
				}
				else {
					return( 0 );
				}
			}
			else if( lhsScope == null ) {
				return( -1 );
			}
			else if( rhsScope == null ) {
				return( 1 );
			}
			else {
				if( engine.derivesFrom( lhsScope, rhsScope ) ) {
					return( -1 );
				}
				else if( engine.derivesFrom( rhsScope, lhsScope ) ) {
					return( 1 );
				}
				else {
					lhsGenDef = lhs.getRequiredLookupGenDef();
					rhsGenDef = rhs.getRequiredLookupGenDef();
					if( lhsGenDef == rhsGenDef ) {
						return( 0 );
					}
					else if( engine.derivesFrom( lhsGenDef, rhsGenDef ) ) {
						return( -1 );
					}
					else if( engine.derivesFrom( rhsGenDef, lhsGenDef ) ) {
						return( 1 );
					}
					else {
						return( 0 );
					}
				}
			}
		}
	}


	private void initRuleMap( ICFGenKbToolSetObj toolSet ) {
		TreeMap<String,ICFGenKbGenItemObj> subMap = toolSetRuleMap.get( toolSet.getPKey() );
		if( subMap != null ) {
			return;
		}

		log.message( "Initializing rule map for tool set " + toolSet.getRequiredName() );

		// Build a list of the rules in the set grouped by name
		TreeMap<String,Collection<ICFGenKbGenItemObj>> rulesByName = new TreeMap<String,Collection<ICFGenKbGenItemObj>>();
		Collection<ICFGenKbGenItemObj> cltn;
		Iterator<ICFGenKbGenItemObj> genItemIter = getGenItemTableObj().readGenItemByToolSetIdx( toolSet.getRequiredId() ).iterator();
		ICFGenKbGenItemObj genItem;
		while( genItemIter.hasNext() ) {
			genItem = genItemIter.next();
			cltn = rulesByName.get( genItem.getRequiredName() );
			if( cltn == null ) {
				cltn = new ArrayList<ICFGenKbGenItemObj>();
				rulesByName.put( genItem.getRequiredName(), cltn );
			}
			cltn.add( genItem );
		}

		// Instantiate a subMap by name to hold the head entries of the sorted lists below
		subMap = new TreeMap<String,ICFGenKbGenItemObj>();

		// For each name, build an array of the entries and sort based on probe sequence
		// Iterate through the probe-sequenced array and establish the linkages
		// Add the head of the linkage list to the subMap
		ICFGenKbGenItemObj[] genItemArray;
		int idx;
		ICFGenKbGenItemObj probeNext;
		ICFGenKbGenItemEditObj edit;
		@SuppressWarnings("unchecked")
		Comparator<ICFGenKbGenItemObj> sortByProbeOrder = new SortByProbeOrder( this );
		Iterator<Collection<ICFGenKbGenItemObj>> cltnIter = rulesByName.values().iterator();
		while( cltnIter.hasNext() ) {
			cltn = cltnIter.next();
			genItemArray = new ICFGenKbGenItemObj[ cltn.size() ];
			genItemIter = cltn.iterator();
			idx = 0;
			while( genItemIter.hasNext() ) {
				genItemArray[idx++] = genItemIter.next();
			}
			Arrays.sort( genItemArray, sortByProbeOrder );

			int len = genItemArray.length - 1;
			for( idx = 0; idx < len; idx ++ ) {
				genItem = genItemArray[ idx ];
				probeNext = genItemArray[ idx + 1];
				edit = genItem.beginEdit();
				edit.setOptionalLookupProbe( probeNext );
				edit.update();
				edit = null;
			}

			genItem = genItemArray[0];
			subMap.put( genItem.getRequiredName(), genItem );
		}

		// Register the subMap with the tool set's rule map
		toolSetRuleMap.put( toolSet.getPKey(), subMap );
	}



	public void init( String generatingBuild, ICFGenKbSchemaObj argCFGenKbSchema, ICFGenKbTenantObj argInternalTenant, String strRootGenDir )
	{
		genkbSchema = argCFGenKbSchema;
		setBackingStore( genkbSchema.getBackingStore() );
		internalTenant = argInternalTenant;
		rootGenDir = strRootGenDir;

	//	Construct the initial contents of the knowledge base,
	//	including the tools, toolsets, and definition class names.

		bootstrapDefClasses();
		libInitRuleTypes();
		libInitTools();
		libInitToolSets();
		genContext = null;

	//	Bootstrap the engine internals first

		bootstrapFirst();
		bootstrapBindings();
		bootstrapIterators();
		bootstrapReferences();
	}

	public ICFGenKbDefClassTableObj getDefClassTableObj() {
		if( defClassTableObj == null ) {
			defClassTableObj = new MssCFDefClassTableObj( (MssCFEngine)this );
		}
		return( defClassTableObj );
	}

	public ICFGenKbGenBindTableObj getGenBindTableObj() {
		if( genBindTableObj == null ) {
			genBindTableObj = new MssCFGenBindTableObj( (MssCFEngine)this );
		}
		return( genBindTableObj );
	}

	public ICFGenKbGenFileTableObj getGenFileTableObj() {
		if( genFileTableObj == null ) {
			genFileTableObj = new MssCFGenFileTableObj( (MssCFEngine)this );
		}
		return( genFileTableObj );
	}

	public ICFGenKbGenItemTableObj getGenItemTableObj() {
		if( genItemTableObj == null ) {
			genItemTableObj = new MssCFGenItemTableObj( (MssCFEngine)this );
		}
		return( genItemTableObj );
	}

	public ICFGenKbGenIteratorTableObj getGenIteratorTableObj() {
		if( genIteratorTableObj == null ) {
			genIteratorTableObj = new MssCFGenIteratorTableObj( (MssCFEngine)this );
		}
		return( genIteratorTableObj );
	}

	public ICFGenKbGenReferenceTableObj getGenReferenceTableObj() {
		if( genReferenceTableObj == null ) {
			genReferenceTableObj = new MssCFGenReferenceTableObj( (MssCFEngine)this );
		}
		return( genReferenceTableObj );
	}

	public ICFGenKbGenRuleTableObj getGenRuleTableObj() {
		if( genRuleTableObj == null ) {
			genRuleTableObj = new MssCFGenRuleTableObj( (MssCFEngine)this );
		}
		return( genRuleTableObj );
	}

	public ICFGenKbGenTruncTableObj getGenTruncTableObj() {
		if( genTruncTableObj == null ) {
			genTruncTableObj = new MssCFGenTruncTableObj( (MssCFEngine)this );
		}
		return( genTruncTableObj );
	}

	public ICFGenKbRuleCartTableObj getRuleCartTableObj() {
		if( ruleCartTableObj == null ) {
			ruleCartTableObj = new MssCFRuleCartTableObj( (MssCFEngine)this );
		}
		return( ruleCartTableObj );
	}

	public ICFGenKbRuleTypeTableObj getRuleTypeTableObj() {
		if( ruleTypeTableObj == null ) {
			ruleTypeTableObj = new MssCFRuleTypeTableObj( (MssCFEngine)this );
		}
		return( ruleTypeTableObj );
	}

	public ICFGenKbToolTableObj getToolTableObj() {
		if( toolTableObj == null ) {
			toolTableObj = new MssCFToolTableObj( (MssCFEngine)this );
		}
		return( toolTableObj );
	}

	public ICFGenKbToolSetTableObj getToolSetTableObj() {
		if( toolSetTableObj == null ) {
			toolSetTableObj = new MssCFToolSetTableObj( (MssCFEngine)this );
		}
		return( toolSetTableObj );
	}

	public Calendar GenTimestamp = Calendar.getInstance();
	public String			GenTimestampString = null;

	public static long				GenNextSerializableUID = 0L;

	protected ICFLibMessageLog log = null;
	public ICFLibMessageLog getLog() {
		return( log );
	}

	public void setLog( ICFLibMessageLog value ) {
		log = value;
	}

	private MssCFGenContext	genContext = null;
	public MssCFGenContext getGenContext() {
		return( genContext );
	}

	public void setGenContext( MssCFGenContext value ) {
		genContext = value;
	}

	protected String rootGenDir = null;
	public String getRootGenDir() {
		return( rootGenDir );
	}

	protected ICFGenKbSchemaObj genkbSchema = null;

	public ICFGenKbSchemaObj getCFGenKbSchema() {
		return (genkbSchema);
	}

	public MssCFEngine() {
		super();
		defClassTableObj = null;
		genBindTableObj = null;
		genFileTableObj = null;
		genItemTableObj = null;
		genIteratorTableObj = null;
		genReferenceTableObj = null;
		genRuleTableObj = null;
		genTruncTableObj = null;
		ruleCartTableObj = null;
		ruleTypeTableObj = null;
		toolTableObj = null;
		toolSetTableObj = null;
	}

	protected MssCFGenContextFactory genContextFactory = null;

	public MssCFGenContextFactory getGenContextFactory() {
		if( genContextFactory == null )
		{
			genContextFactory = new MssCFGenContextFactory();
		}
		return( genContextFactory );
	}

	public void setGenContextFactory( MssCFGenContextFactory value ) {
		genContextFactory = value;
	}

	protected String targetRuleName = null;

	public String getTargetRuleName() {
		return( targetRuleName );
	}

	public void setTargetRuleName( String value ) {
		targetRuleName = value;
	}

	private ICFGenKbRuleCartObj internalRuleCart = null;

	public ICFGenKbRuleCartObj getInternalRuleCart() {
		if (internalRuleCart == null)
		{
			internalRuleCart = getRuleCartTableObj().newInstance();
			ICFGenKbRuleCartEditObj editRuleCart = internalRuleCart.beginEdit();
			editRuleCart.setRequiredContainerTenant( internalTenant );
			editRuleCart.setRequiredName( "Internal" );
			internalRuleCart = editRuleCart.create();
			editRuleCart = null;
		}
		return (internalRuleCart);
	}

	public ICFGenKbGenFileObj defineFile(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		String	generateOnce,
		String	sourceBundle,
		String	moduleName,
		String	basePackageName,
		String	subPackageName,
		String	expansionClassName,
		String	expansionKeyName,
		String	expansionFileName )
	{
		final String S_ProcName = "MssCFEngine.defineFile() ";
		if( definedNear == null ) {
			throw new CFLibNullArgumentException( getClass(), "defineFile", 1, "definedNear" );
		}
		ICFGenKbRuleCartObj ruleCart = getInternalRuleCart();
		ICFGenKbGenFileObj genFile = getGenFileTableObj().newInstance();
		ICFGenKbGenFileEditObj editFile = (ICFGenKbGenFileEditObj)genFile.beginEdit();
		editFile.setRequiredLookupToolSet( getToolSetTableObj().readToolSetByNameIdx(toolsetName) );
		editFile.setRequiredDefinedNear( definedNear );
		if ((scopeDefClassName != null) && (scopeDefClassName.length() > 0))
		{
			if (scopeDefClassName.equals("*"))
			{
				scopeDefClassName = getAnyClassName();
			}
			else {
				scopeDefClassName = fixGenDefName( scopeDefClassName );
			}
			ICFGenKbDefClassObj scopeDef = getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
			if( scopeDef == null )
			{
				throw new RuntimeException( S_ProcName + "Could not resolve ScopeDef " + scopeDefClassName );
			}
			editFile.setOptionalLookupScopeDef( scopeDef );
		}
		else
		{
			editFile.setOptionalLookupScopeDef( null );
		}
		editFile.setRequiredContainerCartridge( ruleCart );
		editFile.setRequiredLookupRuleType( getRuleTypeTableObj().readRuleTypeByNameIdx("File") );

		genDefClassName = fixGenDefName( genDefClassName );
		ICFGenKbDefClassObj genDef = getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		if( genDef == null )
		{
			throw new RuntimeException( S_ProcName + "Could not resolve GenDef " + genDefClassName );
		}
		editFile.setRequiredLookupGenDef( genDef );
		editFile.setRequiredName( itemName );
		editFile.setRequiredBody( expansionBody );
		editFile.setOptionalGenerateOnce( generateOnce );
		editFile.setOptionalSourceBundle( sourceBundle );
		editFile.setOptionalModuleName( moduleName );
		editFile.setOptionalBasePackageName( basePackageName );
		editFile.setOptionalSubPackageName( subPackageName );
		editFile.setOptionalExpansionClassName( expansionClassName );
		editFile.setOptionalExpansionKeyName( expansionKeyName );
		editFile.setOptionalExpansionFileName( expansionFileName );
		ICFGenKbGenFileObj created = (ICFGenKbGenFileObj)editFile.create();
		editFile = null;

		MssCFGelCompiler compiler = getGelCompiler();
		CFGenKbGenFileObj.getBodyBin( compiler, created );
		CFGenKbGenFileObj.getSrcBundleBin( compiler, created );
		CFGenKbGenFileObj.getModuleNameBin( compiler, created );
		CFGenKbGenFileObj.getBasePackageBin( compiler, created );
		CFGenKbGenFileObj.getSubPackageBin( compiler, created );
		CFGenKbGenFileObj.getExpClassBin( compiler, created );
		CFGenKbGenFileObj.getExpKeyNameBin( compiler, created );
		CFGenKbGenFileObj.getExpFileNameBin( compiler, created );

		return (created);
	}


	public ICFGenKbGenRuleObj defineRule(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody )
	{
		final String S_ProcName = "defineRule";
		if( definedNear == null ) {
			throw new CFLibNullArgumentException( getClass(), S_ProcName, 1, "definedNear" );
		}
		if( toolsetName == null ) {
			throw new CFLibNullArgumentException( getClass(), S_ProcName, 2, "toolsetName" );
		}
		if( ( genDefClassName == null ) || ( genDefClassName.length() <= 0 ) )  {
			throw new CFLibEmptyArgumentException( getClass(), S_ProcName, 4, "genDefClassName" );
		}
		if( ( itemName == null ) || ( itemName.length() <= 0 ) ) {
			throw new CFLibEmptyArgumentException( getClass(), S_ProcName, 5, "itemName" );
		}
		if( expansionBody == null ) {
			throw new CFLibNullArgumentException( getClass(), S_ProcName, 6, "expansionBody" );
		}

		ICFGenKbRuleCartObj ruleCart = getInternalRuleCart();
		assert ruleCart != null : "ruleCart is null!";
		ICFGenKbGenRuleObj genRule = getGenRuleTableObj().newInstance();
		ICFGenKbGenRuleEditObj editRule = (ICFGenKbGenRuleEditObj)genRule.beginEdit();
		editRule.setRequiredDefinedNear( definedNear );
		ICFGenKbToolSetObj toolset = getToolSetTableObj().readToolSetByNameIdx( toolsetName );
		assert toolset != null : "Could not resolve toolset " + toolsetName;
		editRule.setRequiredLookupToolSet( toolset );
		if ((scopeDefClassName != null) && (scopeDefClassName.length() > 0)) {
			if (scopeDefClassName.equals("*")) {
				scopeDefClassName = getAnyClassName();
			}
			else {
				scopeDefClassName = fixGenDefName( scopeDefClassName );
			}
			ICFGenKbDefClassObj scopeDef = getDefClassTableObj().readDefClassByNameIdx( scopeDefClassName );
			if( scopeDef == null ) {
				throw new CFLibRuntimeException( getClass(), S_ProcName, "Could not resolve ScopeDef " + scopeDefClassName );
			}
			editRule.setOptionalLookupScopeDef( scopeDef );
		}
		else {
			editRule.setOptionalLookupScopeDef( null );
		}
		editRule.setRequiredContainerCartridge( ruleCart );
		ICFGenKbRuleTypeObj ruleType = getRuleTypeTableObj().readRuleTypeByNameIdx( "Rule" );
		assert ruleType != null : "ruleType \"Rule\" could not be resolved";
		editRule.setRequiredLookupRuleType( ruleType );
		genDefClassName = fixGenDefName( genDefClassName );
		assert genDefClassName != null && genDefClassName.length() > 0 : "fixed genDefClassName is null or empty";
		ICFGenKbDefClassObj genDef = getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		if( genDef == null ) {
			throw new CFLibRuntimeException( getClass(), S_ProcName, "Could not resolve GenDef " + genDefClassName );
		}
		editRule.setRequiredLookupGenDef( genDef );
		editRule.setRequiredName( itemName );
		editRule.setRequiredBody( expansionBody );
		ICFGenKbGenRuleObj created = (ICFGenKbGenRuleObj)editRule.create();
		editRule = null;

		MssCFGelCompiler compiler = getGelCompiler();

		CFGenKbGenRuleObj.getBodyBin( compiler, created );

		return ( created );
	}


	public ICFGenKbGenTruncObj defineTrunc(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		int		truncAt  )
	{
		final String S_ProcName = "MssCFEngine.defineTrunc() ";
		if( definedNear == null ) {
			throw new CFLibNullArgumentException( getClass().getSimpleName(), "defineTrunc", 1, "definedNear" );
		}
		ICFGenKbRuleCartObj ruleCart = getInternalRuleCart();
		ICFGenKbGenTruncObj genTrunc = getGenTruncTableObj().newInstance();
		ICFGenKbGenTruncEditObj editTrunc = (ICFGenKbGenTruncEditObj)genTrunc.beginEdit();
		editTrunc.setRequiredDefinedNear( definedNear );
		editTrunc.setRequiredLookupToolSet( getToolSetTableObj().readToolSetByNameIdx(toolsetName) );
		if ((scopeDefClassName != null) && (scopeDefClassName.length() > 0))
		{
			if (scopeDefClassName.equals("*"))
			{
				scopeDefClassName = getAnyClassName();
			}
			else {
				scopeDefClassName = fixGenDefName( scopeDefClassName );
			}
			ICFGenKbDefClassObj scopeDef = getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
			if( scopeDef == null )
			{
				throw new RuntimeException( S_ProcName + "Could not resolve ScopeDef " + scopeDefClassName );
			}
			editTrunc.setOptionalLookupScopeDef( scopeDef );
		}
		else
		{
			editTrunc.setOptionalLookupScopeDef( null );
		}
		editTrunc.setRequiredContainerCartridge( ruleCart );
		editTrunc.setRequiredLookupRuleType(
			getRuleTypeTableObj().readRuleTypeByNameIdx("Trunc") );
		genDefClassName = fixGenDefName( genDefClassName );
		ICFGenKbDefClassObj genDef = getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
		if( genDef == null )
		{
			throw new RuntimeException( S_ProcName + "Could not resolve GenDef " + genDefClassName );
		}
		editTrunc.setRequiredLookupGenDef( genDef );
		editTrunc.setRequiredName( itemName );
		editTrunc.setRequiredBody( expansionBody );
		editTrunc.setRequiredTruncateAt( truncAt );
		ICFGenKbGenTruncObj created = (ICFGenKbGenTruncObj)editTrunc.create();
		editTrunc = null;

		MssCFGelCompiler compiler = getGelCompiler();
		CFGenKbGenTruncObj.getBodyBin( compiler, created );

		return (created);
	}


	/**
	 *	Find an expansion item in the engine based on the generation context
	 *	and an item name.
	 *	<p>
	 *	Finding the proper expansion item can be CPU intensive as I have
	 *	not tuned it by implementing any form of hashing or BTree keys.
	 *	When I have time...
	 *	<p>
	 *	Generally, the approach is to start with the classes of the scope
	 *	and generation definitions of the current context as the search
	 *	keys.  The initial toolset is that of the context.
	 *	<p>
	 *	We gradually search using the superclasses of the generation object,
	 *	the superclasses of the scope object, and by reducing the detail
	 *	level of the toolset.  If no match is found, $itemName$ is
	 *	eventually returned.
	 *
	 *	@param		genContext		MssCFGenContext
	 *	@param		itemName		String
	 *	@return	String				Either the string returned by
	 *								expanding the match item or $itemName$
	 */
	public ICFGenKbGenItemObj findContextItem(
		MssCFGenContext	genContext,
		String			itemName )
	{
//		ICFGenKbGenItemObj	matchItem;
//		int					lastSeparator;
//		String				priorNames;
//		String				toolNames = null;
//		String			 	eliminatingToolName = null;

		final String S_ProcName = "MssCFEngine.findContextItem() ";

		//	Validate parameters

		if( ( itemName == null ) || ( 0 == itemName.length() ) ) {
			throw new RuntimeException(S_ProcName + "itemName is null or empty");
		}

		ICFLibAnyObj genDef = genContext.getGenDef();
		if( genDef == null ) {
			return( null );
		}

		MssCFDefClassObj genClass = (MssCFDefClassObj)(getDefClassTableObj().readDefClassByNameIdx(
			genDef.getGenDefName() ));
		if( genClass.getRequiredName().equals( "Object" ) ) {
			genClass = null;
		}

		ICFLibAnyObj scopeDef = genContext.getScopeDef();
		MssCFDefClassObj scopeClass;
		if( scopeDef != null ) {
			scopeClass = (MssCFDefClassObj)(getDefClassTableObj().readDefClassByNameIdx(
				scopeDef.getGenDefName() ));
			if( scopeClass.getRequiredName().equals( "Object" ) ) {
				scopeClass = null;
			}
		}
		else {
			scopeClass = null;
		}

		TreeMap<String,ICFGenKbGenItemObj> subMap = this.toolSetRuleMap.get( genContext.getRequiredLookupToolSet().getPKey() );
		ICFGenKbGenItemObj genItem = subMap.get( itemName );
		MssCFDefClassObj genItemClass;
		MssCFDefClassObj genItemScope;
		while( genItem != null ) {
			genItemClass = (MssCFDefClassObj)genItem.getRequiredLookupGenDef();
			if( genItemClass.getRequiredName().equals( "Object" ) ) {
				genItemClass = null;
			}

			genItemScope = (MssCFDefClassObj)genItem.getOptionalLookupScopeDef();
			if( ( genItemScope != null ) && genItemScope.getRequiredName().equals( "Object" ) ) {
				genItemScope = null;
			}

			if( derivesFrom( scopeClass, genItemScope ) ) {
				if( derivesFrom( genClass, genItemClass ) ) {
					return( genItem );
				}
				else {
					genItem = genItem.getOptionalLookupProbe();
				}
			}
			else {
				genItem = genItem.getOptionalLookupProbe();
			}
		}

		// The exact probe didn't work, so try pruning the toolset until there is no more to prune

		String toolsetName = genContext.getRequiredLookupToolSet().getRequiredName();
		int lastPlus = toolsetName.lastIndexOf( '+' );

		String inheritsFromName;
		String inheritsFromFirst;
		ICFGenKbToolSetObj toolset;

		while( lastPlus >= 0 ) {

			inheritsFromName = toolsetName.substring( 0, lastPlus );
			inheritsFromFirst = toolsetName.substring( lastPlus + 1 );

			// First we probe the rules for the tool that is being trimmed from the search

			toolset = getToolSetTableObj().readToolSetByNameIdx( inheritsFromFirst );
			subMap = this.toolSetRuleMap.get( toolset.getPKey() );
			genItem = subMap.get( itemName );
			while( genItem != null ) {
				genItemClass = (MssCFDefClassObj)genItem.getRequiredLookupGenDef();
				if( genItemClass.getRequiredName().equals( "Object" ) ) {
					genItemClass = null;
				}

				genItemScope = (MssCFDefClassObj)genItem.getOptionalLookupScopeDef();
				if( ( genItemScope != null ) && genItemScope.getRequiredName().equals( "Object" ) ) {
					genItemScope = null;
				}

				if( derivesFrom( scopeClass, genItemScope ) ) {
					if( derivesFrom( genClass, genItemClass ) ) {
						return( genItem );
					}
					else {
						genItem = genItem.getOptionalLookupProbe();
					}
				}
				else {
					genItem = genItem.getOptionalLookupProbe();
				}
			}

			// Next we probe the rules for the remaining toolset after trimming a tool

			toolset = getToolSetTableObj().readToolSetByNameIdx( inheritsFromName );
			subMap = this.toolSetRuleMap.get( toolset.getPKey() );
			genItem = subMap.get( itemName );
			while( genItem != null ) {
				genItemClass = (MssCFDefClassObj)genItem.getRequiredLookupGenDef();
				if( genItemClass.getRequiredName().equals( "Object" ) ) {
					genItemClass = null;
				}

				genItemScope = (MssCFDefClassObj)genItem.getOptionalLookupScopeDef();
				if( ( genItemScope != null ) && genItemScope.getRequiredName().equals( "Object" ) ) {
					genItemScope = null;
				}

				if( derivesFrom( scopeClass, genItemScope ) ) {
					if( derivesFrom( genClass, genItemClass ) ) {
						return( genItem );
					}
					else {
						genItem = genItem.getOptionalLookupProbe();
					}
				}
				else {
					genItem = genItem.getOptionalLookupProbe();
				}
			}

			// If we still didn't find a match, we try to prune another toolset
			toolsetName = inheritsFromName;
			lastPlus = toolsetName.lastIndexOf( '+' );
		}

		// Finally we probe the "any" rules

		toolset = getToolSetTableObj().readToolSetByNameIdx( "any" );
		subMap = this.toolSetRuleMap.get( toolset.getPKey() );
		genItem = subMap.get( itemName );
		while( genItem != null ) {
			genItemClass = (MssCFDefClassObj)genItem.getRequiredLookupGenDef();
			if( genItemClass.getRequiredName().equals( "Object" ) ) {
				genItemClass = null;
			}

			genItemScope = (MssCFDefClassObj)genItem.getOptionalLookupScopeDef();
			if( ( genItemScope != null ) && genItemScope.getRequiredName().equals( "Object" ) ) {
				genItemScope = null;
			}

			if( derivesFrom( scopeClass, genItemScope ) ) {
				if( derivesFrom( genClass, genItemClass ) ) {
					return( genItem );
				}
				else {
					genItem = genItem.getOptionalLookupProbe();
				}
			}
			else {
				genItem = genItem.getOptionalLookupProbe();
			}
		}

		return( null );
	}


	/**
	 *	Generate all source code for the definition.
	 *
	 *	@param		buildString		String	The string that identifies the build being produced
	 *	@param		rootGenDir		String		The root generation directory
	 *	@param		anyDef			ICFLibAnyObj	The definition to generate code for.
	 *	@param		toolsDesired	List<String>	The tools to generate code for
	 */
	public void generate(
		String					buildString,
		String					rootGenDir,
		ICFLibAnyObj			anyDef,
		List<String>			toolsDesired,
		String					initialRuleName )
	{
		final String S_ProcName = "MssCFEngine.generate() ";

		int						idx;
		int						num;
		String					toolsetName = null;
		ICFGenKbGenItemObj		matchItem = null;
		MssCFGenContext			genContext = null;
		String					generated = null;

		MssCFToolSetObj			toolset = null;
		MssCFDefClassObj		genDefClass = null;
		String					genDefClassName = null;

		//	Validate

		if( ( rootGenDir == null ) || ( rootGenDir.length() == 0 ) ) {
			throw new RuntimeException( S_ProcName + "rootGenDir is null or empty" );
		}

		if( anyDef == null ) {
			throw new RuntimeException(S_ProcName + "anyDef is null");
		}

		initToolSetRuleMap();

		//	Initialize

		GenNextSerializableUID = 0L;
		GenTimestamp = Calendar.getInstance();
		GenTimestampString = GenTimestamp.toString();

		//	LOOP each supported toolset

		Iterator<String> iterToolsDesired = toolsDesired.iterator();
		while( iterToolsDesired.hasNext() ) {

		//		Try to find an item for expanding the item.  This is the
		//		only case where the search does NOT broaden the scope of
		//		it's search until a match is found.  Such scoping is
		//		instead implemented by the expansion of the top level
		//		items which can then rely on scope broadening to complete
		//		their expansion.

			toolsetName = iterToolsDesired.next();

			toolset = null;
			genDefClass = null;
			genDefClassName = null;
			matchItem = null;

		//		Resolve the toolset

			toolset = (MssCFToolSetObj)getToolSetTableObj().readToolSetByNameIdx(toolsetName);
			if (toolset == null) {
				throw new RuntimeException(S_ProcName + "Could not resolve toolset \"" + toolsetName + "\"");
			}

		//		Resolve the generation class

			genDefClassName = anyDef.getGenDefName();
			genDefClass = (MssCFDefClassObj)getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
			if (genDefClass == null) {
				throw new RuntimeException(S_ProcName + "Could not resolve gen DefClass \"" + genDefClassName + "\"");
			}

		//	  Probe knowledge base

			Short scopeDefId = null;
			matchItem = getGenItemTableObj().readGenItemByAltIdx(initialRuleName,
				 toolset.getRequiredId(),
				 scopeDefId,
				 genDefClass.getRequiredId());
			if (matchItem == null) {
				continue;
			}

		//		If we found an item, create a generation context for
		//		expanding the body of the item based on the definition
		//		being generated.

			genContext = getGenContextFactory().newGenContext( buildString,
				this,
				rootGenDir,
				toolsetName,
				null,
				anyDef.getGenDefName(),
				rootGenDir,
				anyDef,
				null );

		//		Generate the expansion of the item.  If the expansion
		//		returns a single-line string, we log it.

			if( matchItem instanceof MssCFGenFileObj ) {
				generated = ((MssCFGenFileObj)matchItem).expandBody( genContext );
			}
			else if (matchItem instanceof MssCFGenTruncObj) {
				generated = ((MssCFGenTruncObj)matchItem).expandBody( genContext );
			}
			else if (matchItem instanceof MssCFGenBindObj) {
				generated = ((MssCFGenBindObj)matchItem).expandBody( genContext );
			}
			else if (matchItem instanceof MssCFGenIteratorObj) {
				generated = ((MssCFGenIteratorObj)matchItem).expandBody( genContext );
			}
			else if (matchItem instanceof MssCFGenReferenceObj) {
				generated = ""; // ((CFGenReferenceObj)matchItem).expandBody( genContext );
			}
			else if (matchItem instanceof MssCFGenRuleObj) {
				generated = ((MssCFGenRuleObj)matchItem).expandBody( genContext );
			}
			else {
				throw new RuntimeException( S_ProcName + "Unsupported knowledge class " 
					+ matchItem.getClass().getSimpleName() );
			}
		}
	}

	/**
	 *	Get the version string for the engine.
	 */
	public String getGeneratorVersion() {
		return( GeneratorVersion );
	}



	public long getNextGenSerializableUID() {
		if( GenNextSerializableUID <= 0L ) {
			getGenTimestampString();
		}
		long uid = GenNextSerializableUID++;
		return( uid );
	}

	public String getNextGenSerializableUIDString() {
		long uid = getNextGenSerializableUID();
		String str = Long.toString(uid);
		return( str );
	}

	public String getGenTimestampString() {

		if( GenTimestamp == null ) {
			GenTimestamp = Calendar.getInstance();
			GenTimestampString = null;
			GenNextSerializableUID = // YYYYMMDDHHMI00001
				  (GenTimestamp.get(Calendar.YEAR) * 10000000000000L)
				+ ((GenTimestamp.get(Calendar.MONTH) + 1) * 100000000000L)
				+ (GenTimestamp.get(Calendar.DAY_OF_MONTH) * 1000000000L)
				+ (GenTimestamp.get(Calendar.HOUR) * 10000000L)
				+ (GenTimestamp.get(Calendar.MINUTE) * 100000L)
				+ 1L;
		}

		if( GenTimestampString == null ) {
			GenTimestampString = GenTimestamp.toString();
		}

		return( GenTimestampString );
	}

	public String getLinkName() {
		return( LinkName );
	}

	public String getLinkVersion() {
		return( LinkVersion );
	}

	/**
	 *	Initialize the rule type, toolset, scope class, genclass, and item name
	 *	of a generation item.
	 */
	protected void initGenItem(
		CFGenKbGenItemEditObj	genItem,
		MssCFRuleTypeObj   		ruleType,
		String					toolsetName,
		String					scopeDefClassName,
		String					genDefClassName,
		String					itemName )
	{
		final String			S_ProcName = "MssCFEngine.initGenItem() ";

		MssCFToolSetObj			toolset = null;
		MssCFDefClassObj		defclassScope = null;
		MssCFDefClassObj		defclassGenDef = null;

		toolset = (MssCFToolSetObj)getToolSetTableObj().readToolSetByNameIdx(toolsetName);
		if (toolset == null) {
			throw new RuntimeException(S_ProcName + "Could not resolve toolset \"" + toolsetName + "\"");
		}

		if( ( scopeDefClassName != null ) && ( 0 < scopeDefClassName.length() ) ) {
			if (scopeDefClassName.equals("*")) {
				defclassScope = (MssCFDefClassObj)getDefClassTableObj().readDefClassByNameIdx(getAnyClassName());
				if (defclassScope == null) {
					throw new RuntimeException(S_ProcName + "Could not resolve scope DefClass \"" + getAnyClassName() + "\"");
				}
			}
			else {
				scopeDefClassName = fixGenDefName( scopeDefClassName );
				defclassScope = (MssCFDefClassObj)getDefClassTableObj().readDefClassByNameIdx(scopeDefClassName);
				if (defclassScope == null) {
					throw new RuntimeException(S_ProcName + "Could not resolve scope DefClass \"" + scopeDefClassName + "\"");
				}
			}
		}

		if( genDefClassName.equals( "*" ) ) {
			defclassGenDef = (MssCFDefClassObj)getDefClassTableObj().readDefClassByNameIdx(getAnyClassName());
			if (defclassGenDef == null) {
				throw new RuntimeException(S_ProcName + "Could not resolve gen DefClass \"" + getAnyClassName() + "\"");
			}
		}
		else {
			genDefClassName = fixGenDefName( genDefClassName );
			defclassScope = (MssCFDefClassObj)getDefClassTableObj().readDefClassByNameIdx(genDefClassName);
			if (defclassScope == null) {
				throw new RuntimeException(S_ProcName + "Could not resolve gen DefClass \"" + genDefClassName + "\"");
			}
		}

		genItem.setRequiredLookupRuleType( ruleType );
		genItem.setRequiredLookupToolSet( toolset );
		genItem.setOptionalLookupScopeDef( defclassScope );
		genItem.setRequiredLookupGenDef( defclassGenDef );
		genItem.setRequiredName( itemName );
	}

	public ICFGenKbToolObj defineTool( String toolName )
	{
		ICFGenKbToolObj tool;
		tool = getToolTableObj().readToolByNameIdx(toolName);
		if( tool == null ) {
			ICFGenKbToolEditObj editTool;
			tool = getToolTableObj().newInstance();
			editTool = tool.beginEdit();
			editTool.setRequiredName( toolName );
			tool = editTool.create();
			editTool = null;
		}
		return( tool );
	}

	public ICFGenKbToolSetObj defineToolSet( String toolSetName )
	{
		// TODO Lots of work to be done here
		ICFGenKbToolSetObj toolSet;
		toolSet = getToolSetTableObj().readToolSetByNameIdx(toolSetName);
		if( toolSet == null ) {
			ICFGenKbToolSetEditObj editToolSet;
			toolSet = getToolSetTableObj().newInstance();
			editToolSet = toolSet.beginEdit();
			editToolSet.setRequiredName( toolSetName );
            //editToolSet.setOptionalDescr( descr );
            //editToolSet.setOptionalRevisionString( revisionString );

            String remainder;
            String toolname;
            int idxPlus = toolSetName.indexOf('+');
            if (idxPlus > 0) {
                toolname = toolSetName.substring(0, idxPlus);
                remainder = toolSetName.substring(idxPlus + 1);
            }
            else {
                toolname = toolSetName;
                remainder = "";
            }
            editToolSet.setRequiredLookupTool0( defineTool(toolname) );

            if (remainder.length() > 0) {
                idxPlus = remainder.indexOf('+');
                if (idxPlus > 0) {
                    toolname = remainder.substring(0, idxPlus);
                    remainder = remainder.substring(idxPlus + 1);
                }
                else {
                    toolname = remainder;
                    remainder = "";
                }
                editToolSet.setOptionalLookupTool1( defineTool(toolname) );

                if (remainder.length() > 0) {
                    idxPlus = remainder.indexOf('+');
                    if (idxPlus > 0) {
                        toolname = remainder.substring(0, idxPlus);
                        remainder = remainder.substring(idxPlus + 1);
                    }
                    else {
                        toolname = remainder;
                        remainder = "";
                    }
                    editToolSet.setOptionalLookupTool2( defineTool(toolname) );

                    if (remainder.length() > 0) {
                        idxPlus = remainder.indexOf('+');
                        if (idxPlus > 0) {
                            toolname = remainder.substring(0, idxPlus);
                            remainder = remainder.substring(idxPlus + 1);
                        }
                        else {
                            toolname = remainder;
                            remainder = "";
                        }
                        editToolSet.setOptionalLookupTool3( defineTool(toolname) );

                        if (remainder.length() > 0) {
                            idxPlus = remainder.indexOf('+');
                            if (idxPlus > 0) {
                                toolname = remainder.substring(0, idxPlus);
                                remainder = remainder.substring(idxPlus + 1);
                            }
                            else {
                                toolname = remainder;
                                remainder = "";
                            }
                            editToolSet.setOptionalLookupTool4( defineTool(toolname) );

                            if (remainder.length() > 0) {
                                idxPlus = remainder.indexOf('+');
                                if (idxPlus > 0) {
                                    toolname = remainder.substring(0, idxPlus);
                                    remainder = remainder.substring(idxPlus + 1);
                                }
                                else {
                                    toolname = remainder;
                                    remainder = "";
                                }
                                editToolSet.setOptionalLookupTool5( defineTool(toolname) );

                                if (remainder.length() > 0) {
                                    idxPlus = remainder.indexOf('+');
                                    if (idxPlus > 0) {
                                        toolname = remainder.substring(0, idxPlus);
                                        remainder = remainder.substring(idxPlus + 1);
                                    }
                                    else {
                                        toolname = remainder;
                                        remainder = "";
                                    }
                                    editToolSet.setOptionalLookupTool6( defineTool(toolname) );

                                    if (remainder.length() > 0) {
                                        idxPlus = remainder.indexOf('+');
                                        if (idxPlus > 0) {
                                            toolname = remainder.substring(0, idxPlus);
                                            remainder = remainder.substring(idxPlus + 1);
                                        }
                                        else {
                                            toolname = remainder;
                                            remainder = "";
                                        }
                                        editToolSet.setOptionalLookupTool7( defineTool(toolname) );
                                    }
                                }
                            }
                        }
                    }
                }
            }
            toolSet = editToolSet.create();
            editToolSet = null;
		}
        return( toolSet );
	}

	private void libInitRuleTypes()
	{
		ICFGenKbRuleTypeObj ruleTypeBind = getRuleTypeTableObj().newInstance();
		ICFGenKbRuleTypeEditObj editRuleType = ruleTypeBind.beginEdit();
		editRuleType.setRequiredName( "Bind" );
		ruleTypeBind = editRuleType.create();
		editRuleType = null;

		ICFGenKbRuleTypeObj ruleTypeIterator = getRuleTypeTableObj().newInstance();
		editRuleType = ruleTypeIterator.beginEdit();
		editRuleType.setRequiredName( "Iterator" );
		ruleTypeIterator = editRuleType.create();
		editRuleType = null;

		ICFGenKbRuleTypeObj ruleTypeReference = getRuleTypeTableObj().newInstance();
		editRuleType = ruleTypeReference.beginEdit();
		editRuleType.setRequiredName( "Reference" );
		ruleTypeReference = editRuleType.create();
		editRuleType = null;

		ICFGenKbRuleTypeObj ruleTypeRule = getRuleTypeTableObj().newInstance();
		editRuleType = ruleTypeRule.beginEdit();
		editRuleType.setRequiredName( "Rule" );
		ruleTypeRule = editRuleType.create();
		editRuleType = null;

		ICFGenKbRuleTypeObj ruleTypeFile = getRuleTypeTableObj().newInstance();
		editRuleType = ruleTypeFile.beginEdit();
		editRuleType.setRequiredName( "File" );
		ruleTypeFile = editRuleType.create();
		editRuleType = null;

		ICFGenKbRuleTypeObj ruleTypeTrunc = getRuleTypeTableObj().newInstance();
		editRuleType = ruleTypeTrunc.beginEdit();
		editRuleType.setRequiredName( "Trunc" );
		ruleTypeTrunc = editRuleType.create();
		editRuleType = null;
	}

	public void logMessage( String msg ) {
		if( msg == null ) {
			return;
		}
		System.out.append( msg + "\n" );
	}

	public void logMessage( String msg, Exception e ) {
		if( e == null ) {
			logMessage( msg );
			return;
		}

		if( msg == null ) {
			return;
		}

		String buff = msg + ": " + e.getMessage() + "\n";
		System.out.append( buff );
	}
}
