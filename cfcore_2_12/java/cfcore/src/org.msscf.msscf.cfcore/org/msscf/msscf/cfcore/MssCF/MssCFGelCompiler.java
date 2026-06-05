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
import org.msscf.msscf.cfcore.CFGenKbObj.*;
import org.msscf.msscf.cfcore.CFGenKb.CFGenKbGelInstructionPKey;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public class MssCFGelCompiler
{
	protected MssCFEngine				genEngine = null;
	protected ICFGenKbGelCacheObj		myGelCache = null;
	protected boolean					compileError = false;
	protected ICFLibMessageLog			log = null;
	protected CFLibCachedMessageLog		msglog = new CFLibCachedMessageLog();

	public MssCFEngine getGenEngine() {
		return( genEngine );
	}

	public void setGenEngine( MssCFEngine value ) {
		genEngine = value;
	}

	public ICFGenKbGelCacheObj getMyGelCache() {
		if( myGelCache == null ) {
			myGelCache = genEngine.getGelCache();
		}
		return( myGelCache );
	}

	public ICFLibMessageLog getLog() {
		if( log == null ) {
			if( genEngine != null ) {
				log = genEngine.getLog();
				assert log != null : "genEngine.getLog() returned null";
			}
		}
		return( log );
	}

	public void setLog( ICFLibMessageLog newlog ) {
		log = newlog;
	}

	public ICFLibMessageLog getCompileLog() {
		return( msglog );
	}

	public boolean hasCompileError() {
		return( compileError );
	}

	public String getErrorText() {
		return( msglog.getCacheContents() );
	}

	protected void setCompileError() {
		compileError = true;
	}

	protected void clearCompileError() {
		compileError = false;
	}

	public String getGenGenerateOnce( MssCFGenContext genContext ) {
		String retval = genContext.getGenGenerateOnce();
		return( retval );
	}

	public String getGenModuleName( MssCFGenContext genContext ) {
		String retval = genContext.getGenModuleName();
		return( retval );
	}

	public String getGenBasePackageName( MssCFGenContext genContext ) {
		String retval = genContext.getGenBasePackageName();
		return( retval );
	}

	public String getGenSubPackageName( MssCFGenContext genContext ) {
		String retval = genContext.getGenSubPackageName();
		return( retval );
	}

	/**
	 *	Construct an instance.  Only invoked to create binding entries.
	 */
	public MssCFGelCompiler( MssCFEngine engine )	{
		setGenEngine( engine );
	}


	/**
	 *	Compile an expansion body into a GEL executable.
	 *	<p>
	 *	This top level public interface invokes the compileMacro()
	 *	method to compile the elements of the Executable.
	 */
	public ICFGenKbGelExecutableObj compileExecutable( String keyExecutableName, String body ) {
		return( compileExecutable( keyExecutableName, body, null ) );
	}

	public ICFGenKbGelExecutableObj compileExecutable( String keyExecutableName, String body, ICFGenKbGenItemObj optGenItem ) {
		final String S_ProcName = "compileExecutable";
		final String S_KeyExecutableName = "keyExecutableName";
		final String S_Dot = ".";
		final String S_Caught = "() Caught ";
		final String S_Space = " ";
		final String S_Newline = "\n";

		if( ( keyExecutableName == null ) || ( keyExecutableName.length() <= 0 ) ) {
			throw new CFLibEmptyArgumentException( getClass(), S_ProcName, 1, S_KeyExecutableName );
		}

		// Establish value of myGelCache
		getMyGelCache();

		msglog.clearCache();
		clearCompileError();

		// Probe for an existing executable, returning it if found
		ICFGenKbGelExecutableObj foundExec = myGelCache.lookupExecutable( keyExecutableName );
		if( foundExec != null ) {
			return( foundExec );
		}

		// Establish the encompassing GelExecutable that is the result of our compiling efforts
		ICFGenKbGelExecutableObj executableObj = genEngine.getGelExecutableTableObj().newInstance();
		ICFGenKbGelExecutableEditObj executableEdit = (ICFGenKbGelExecutableEditObj)executableObj.beginEdit();
		executableEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		executableEdit.setRequiredContainerGelCache( myGelCache );
		executableEdit.setRequiredSourceText( body );
		executableObj = (ICFGenKbGelExecutableObj)executableEdit.create();
		executableEdit = null;

		boolean anyErrors = false;

		ICFGenKbGelInstructionObj instruction;
		if( ( body == null ) || ( body.length() <= 0 ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinEmpty( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)( builtinObj.beginEdit() );
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( "" );
			builtinObj = (ICFGenKbGelBuiltinObj)( builtinEdit.create() );
			try {
				executableObj.addCalledInstruction( myGelCache, builtinObj );
			}
			catch( Exception e ) {
				System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
			}
		}
		else {
			StringBuffer boilerplate = new StringBuffer();
			StringBuffer macro = new StringBuffer();
			String normalizedMacro;

			char ch;
			int cur;
			boolean macroStarted = false;
			boolean haveBackslash = false;
			int end = body.length();

			for( cur = 0; cur < end; cur ++ ) {

				ch = body.charAt( cur );

				if( macroStarted ) {
					if( haveBackslash ) {

						haveBackslash = false;

						switch( ch ) {
							case '\\':
								macro.append( "\\" );
								break;

							case '$':
								macro.append( "$" );
								break;

							default:
								macro.append( "\\" );
								macro.append( ch );
								break;
						}
					}
					else {
						switch( ch ) {
							case '\\':
								haveBackslash = true;
								break;

							case '$':
								// Reached the end of a macro -- need to compile it
								macroStarted = false;

								// Only clear the compile error flag, not the compile log
								clearCompileError();

								if( macro.length() <= 0 ) {
									// Two dollar signs in a row means to embed a single dollar sign
									ICFGenKbGelBoilerplateObj boilerplateObj = genEngine.getGelBoilerplateTableObj().newInstance();
									ICFGenKbGelBoilerplateEditObj boilerplateEdit = (ICFGenKbGelBoilerplateEditObj)( boilerplateObj.beginEdit() );
									boilerplateEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
									boilerplateEdit.setRequiredContainerGelCache( myGelCache );
									boilerplateEdit.setRequiredSourceText( "$" );
									try {
										boilerplateObj = (ICFGenKbGelBoilerplateObj)( boilerplateEdit.create() );
									}
									catch( Exception e ) {
										boilerplateEdit.endEdit();
										boilerplateObj = null;
									}
									boilerplateEdit = null;
									try {
										executableObj.addCalledInstruction( myGelCache, boilerplateObj );
									}
									catch( Exception e ) {
										System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
									}
								}
								else {
									normalizedMacro = normalizeMacro( macro.toString() );
									if( normalizedMacro.length() > 0 ) {
										ICFGenKbGelInstructionObj compiledMacro = null;
										compiledMacro = compileMacro( normalizedMacro );
										if( compiledMacro == null ) {
											setCompileError();
											ICFGenKbGelErrorObj errorObj = genEngine.getGelErrorTableObj().newInstance();
											ICFGenKbGelErrorEditObj errorEdit = (ICFGenKbGelErrorEditObj)( errorObj.beginEdit() );
											errorEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
											errorEdit.setRequiredContainerGelCache( myGelCache );
											StringBuffer errorExpansion = new StringBuffer( "$" );
											errorExpansion.append( normalizedMacro );
											errorExpansion.append( "$" );
											errorEdit.setRequiredSourceText( errorExpansion.toString() );
											try {
												errorObj = (ICFGenKbGelErrorObj)( errorEdit.create() );
												errorEdit = null;
												errorObj = (ICFGenKbGelErrorObj)( myGelCache.rememberMacro( normalizedMacro, errorObj ) );
											}
											catch( Exception e ) {
												errorObj = null;
												errorEdit.endEdit();
												errorEdit = null;
											}
											try {
												executableObj.addCalledInstruction( myGelCache, errorObj );
											}
											catch( Exception e ) {
												System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
											}
											StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
											msg.append( S_Dot );
											msg.append( S_ProcName );
											msg.append( " compileMacro() returned null, indicating a failed compile of $" );
											msg.append( normalizedMacro );
											msg.append( "$\n" );
											getCompileLog().message( msg.toString() );
										}
										else {
											try {
												executableObj.addCalledInstruction( myGelCache, compiledMacro );
											}
											catch( Exception e ) {
												System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
											}
										}
									}
									else {
										// Empty normalized macro bodies are illegal
										setCompileError();

										ICFGenKbGelErrorObj errorObj = genEngine.getGelErrorTableObj().newInstance();
										ICFGenKbGelErrorEditObj errorEdit = (ICFGenKbGelErrorEditObj)( errorObj.beginEdit() );
										errorEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
										errorEdit.setRequiredContainerGelCache( myGelCache );
										StringBuffer srctext = new StringBuffer( "$" );
										srctext.append( macro );
										srctext.append( '$' );
										errorEdit.setRequiredSourceText( srctext.toString() );
										try {
											errorObj = (ICFGenKbGelErrorObj)( errorEdit.create() );
										}
										catch( Exception e ) {
											errorEdit.endEdit();
											errorObj = null;
										}
										errorEdit = null;
										try {
											executableObj.addCalledInstruction( myGelCache, errorObj );
										}
										catch( Exception e ) {
											System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
										}

										StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
										msg.append( S_Dot );
										msg.append( S_ProcName );
										msg.append( " Normalized macro is empty and invalid, nothing to compile\n" );
										getCompileLog().message( msg.toString() );
									}
									if( hasCompileError() ) {
										anyErrors = true;
									}
									clearCompileError();
								}
								break;

							default:
								macro.append( ch );
								break;
						}
					}
				}
				else {
					if( haveBackslash ) {

						haveBackslash = false;

						switch( ch ) {
							case '\\':
								boilerplate.append( "\\" );
								break;

							case '$':
								boilerplate.append( "$" );
								break;

							default:
								boilerplate.append( "\\" );
								boilerplate.append( ch );
								break;
						}
					}
					else {
						switch( ch ) {
							case '\\':
								haveBackslash = true;
								break;

							case '$':
								if( boilerplate.length() > 0 ) {
									ICFGenKbGelBoilerplateObj boilerplateObj = genEngine.getGelBoilerplateTableObj().newInstance();
									ICFGenKbGelBoilerplateEditObj boilerplateEdit = (ICFGenKbGelBoilerplateEditObj)( boilerplateObj.beginEdit() );
									boilerplateEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
									boilerplateEdit.setRequiredContainerGelCache( myGelCache );
									boilerplateEdit.setRequiredSourceText( boilerplate.toString() );
									try {
										boilerplateObj = (ICFGenKbGelBoilerplateObj)( boilerplateEdit.create() );
									}
									catch( Exception e ) {
										boilerplateEdit.endEdit();
										boilerplateObj = null;
									}
									boilerplateEdit = null;
									try {
										executableObj.addCalledInstruction( myGelCache, boilerplateObj );
									}
									catch( Exception e ) {
										System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
									}
								}
								boilerplate.setLength( 0 );
								macro.setLength( 0 );
								macroStarted = true;
								break;

							default:
								boilerplate.append( ch );
								break;
						}
					}
				}
			}

		//	If we had a trailing macro, append it

			if( macroStarted ) {
				setCompileError();

				ICFGenKbGelErrorObj errorObj = genEngine.getGelErrorTableObj().newInstance();
				ICFGenKbGelErrorEditObj errorEdit = (ICFGenKbGelErrorEditObj)( errorObj.beginEdit() );
				errorEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
				errorEdit.setRequiredContainerGelCache( myGelCache );
				StringBuffer myText = new StringBuffer( "$" );
				myText.append( macro );
				errorEdit.setRequiredSourceText( myText.toString() );
				try {
					errorObj = (ICFGenKbGelErrorObj)( errorEdit.create() );
				}
				catch( Exception e ) {
					errorEdit.endEdit();
					errorObj = null;
				}
				errorEdit = null;
				try {
					executableObj.addCalledInstruction( myGelCache, errorObj );
				}
				catch( Exception e ) {
					System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
				}

				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( S_Dot );
				msg.append( S_ProcName );
				msg.append( "() Unterminated macro detected -- Source is invalid " );
				msg.append( body );
				msg.append( S_Newline );
				getCompileLog().message( msg.toString() );
			}

		//	If we had a trailing backslash, append it

			if( haveBackslash ) {
				boilerplate.append( "\\" );
			}

		//	Don't forget any trailing boilerplate

			if( boilerplate.length() > 0 ) {
				ICFGenKbGelBoilerplateObj boilerplateObj = genEngine.getGelBoilerplateTableObj().newInstance();
				ICFGenKbGelBoilerplateEditObj boilerplateEdit = (ICFGenKbGelBoilerplateEditObj)( boilerplateObj.beginEdit() );
				boilerplateEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
				boilerplateEdit.setRequiredContainerGelCache( myGelCache );
				boilerplateEdit.setRequiredSourceText( boilerplate.toString() );
				try {
					boilerplateObj = (ICFGenKbGelBoilerplateObj)( boilerplateEdit.create() );
				}
				catch( Exception e ) {
					boilerplateEdit.endEdit();
					boilerplateObj = null;
				}
				boilerplateEdit = null;
				try {
					executableObj.addCalledInstruction( myGelCache, boilerplateObj );
				}
				catch( Exception e ) {
					System.out.println( "MAJOR ERROR: Could not executableObj.addCalledInstruction(), threw undefined exception" );
				}
			}

			if( anyErrors || hasCompileError() ) {
				setCompileError();
				anyErrors = true;
				if( msglog.getCacheContents().length() <= 0 ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( S_Dot );
					msg.append( S_ProcName );
					msg.append( "() GEL compile FAILED\n" );
					getCompileLog().message( msg.toString() );
				}
			}
		}

		String errorText = msglog.getCacheContents();
		if( anyErrors || ( errorText.length() > 0 ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( "." );
			msg.append( S_ProcName );
			msg.append( "() Could not compile GEL executable " + keyExecutableName );
			if( optGenItem != null ) {
				String definedNear;
				if( optGenItem instanceof ICFGenKbGenRuleObj ) {
					definedNear = ((ICFGenKbGenRuleObj)optGenItem).getRequiredDefinedNear();
				}
				else if( optGenItem instanceof ICFGenKbGenTruncObj ) {
					definedNear = ((ICFGenKbGenTruncObj)optGenItem).getRequiredDefinedNear();
				}
				else if( optGenItem instanceof ICFGenKbGenFileObj ) {
					definedNear = ((ICFGenKbGenFileObj)optGenItem).getRequiredDefinedNear();
				}
				else {
					definedNear = "";
				}
				if( definedNear.length() > 0 ) {
					msg.append( " defined" );
					msg.append( definedNear );
				}
			}
			msg.append( " - " );
			msg.append( errorText );
			getLog().message( msg.toString() );
		}

		foundExec = myGelCache.rememberExecutable( keyExecutableName, executableObj );
		return( foundExec );
	}

	/**
	 *	Sometimes you just want an empty expansion
	 */
	public final static String	_EMPTY = "empty";
	public final static String	_EMPTY_STRING = "";

	/**
	 *	Built-in stripLeadingZeroes strips all zeroes from
	 *	a string.
	 */
	public final static String	_STRIPLEADINGZEROES = "stripLeadingZeroes";

	/**
	 *	The macro language supports iteration of definition details.
	 */
	public final static String	_ITERATE = "iterate";
	public final static String	_ITERATOR_BEFORE = "before";
	public final static String	_ITERATOR_FIRST = "first";
	public final static String	_ITERATOR_EACH = "each";
	public final static String	_ITERATOR_LAST = "last";
	public final static String	_ITERATOR_AFTER = "after";
	public final static String	_ITERATOR_LONE = "lone";
	public final static String	_ITERATOR_EMPTY = "empty";

	/**
	 *	The macro language supports spreading of iterators.
	 */
	public final static String	_SPREAD = "spread";
	public final static String	_SPREAD_BETWEEN = "between";

	/**
	 *	The macro language supports temporary unwinding of the
	 *	expansion context stack.
	 */
	public final String	_POP = "pop";
	public final String	_POPTO = "popto";
	public final String _POPTOP = "poptop";
	public final String _POPONEFROMTOP = "poponefromtop";

	/**
	 *	References let the macro language "call" an expansion
	 *	from a completely different context.  See notes 12-MAY-1998.
	 */
	public final static String	_REFERENCE = "reference";

	/**
	 *	The macro language supports branching through a switch directive.
	 *	The syntax is:
	 *
	 *		switch ValMacro Key1 Macro1, Key2 Macro2, default MacroDefault
	 *
	 *	There are two special keys as well:
	 *
	 *		nil
	 *		empty
	 *
	 *	The ValMacro is invoked to get a String result.  Failure of the macro
	 *	could produce a null value (special key `nil'), or this could mean
	 *	that the definition has no value to respond with.  The macro could
	 *	also return an empty string, which can't be typed in using macro
	 *	syntax.  If neither nil nor empty is returned, the KeyN strings are
	 *	compared in order.  Finally the MacroDefault is invoked.  At worst,
	 *	a null is returned by the evaluation.
	 */
	public final static String	_SWITCH = "switch";
	public final static String	_SWITCH_NIL = "nil";
	public final static String	_SWITCH_EMPTY = "empty";
	public final static String	_SWITCH_DEFAULT = "default";

	/**
	 *	Simple case coercion can be performed on the results of macros.
	 */
	public final static String	_COERCE_UPPER = "upper";
	public final static String	_COERCE_LOWER = "lower";
	public final static String	_COERCE_LEADLOWER = "leadlower";
	public final static String	_COERCE_MIXED = "mixed";

	/**
	 *  Line prefixing is used to embed license information.
	 */
	public final static String _PREFIX_LINE = "prefixline";

	/**
	 *	Counters are a bit limited, but useful for positional parameter bindings.
	 *	Remember that new counters are initialized to 0, not 1.
	 *
	 *	Syntax is:
	 *
	 *		counter <name> new
	 *		counter <name> increment
	 *		counter <name> decrement
	 *		counter <name> value
	 */
	public final static String	_COUNTER = "counter";
	public final static String	_COUNTER_OP_NEW = "new";
	public final static String	_COUNTER_OP_INCR = "increment";
	public final static String	_COUNTER_OP_DECR = "decrement";
	public final static String	_COUNTER_OP_VALUE = "value";

	/**
	 *	You can include information about the generator itself in the code produced.
	 */
	public final static String	_BUILTIN_GENERATORNAME = "GeneratorName";
	public final static String	_BUILTIN_GENERATORVERSION = "GeneratorVersion";
	public final static String	_BUILTIN_GENDATE = "GenDate";
	public final static String	_BUILTIN_GENTIME = "GenTime";
	public final static String	_BUILTIN_GENTIMESTAMP = "GenTimestamp";
	public final static String	_BUILTIN_GENSERIALIZABLEUID = "GenSerializableUID";

	/**
	 *	Built-in macros are used to access information directly from the generation
	 *	context and the MssCFGenFileObj definition used to open the current generation
	 *	file.
	 *	<p>
	 *	GenFileFullName expands to the fully pathed name of the currently open file.
	 *	<p>
	 *	GenFileName expands to the name of the file without any directory specs,
	 *	including any file-type suffixes.
	 *	<p>
	 *	GenFileBaseName expands to the name of the file without any directory specs,
	 *	and without the file-type suffix.
	 *	<p>
	 *	GenPackage expands to the name of the package being generated.
	 *	<p>
	 *	GenPackageDir expands to the subdirectory part of the package
	 *	converted to a directory (with forward slashes.)  The generation
	 *	root directory is <i>not</i> included.
	 *	<p>
	 *	GenPackageFullDir expands to include the generation root directory as
	 *	well as the package directory.  No processing is done on the root
	 *	directory, so on DOS-derived file systems there may be backslashes included.
	 */
	public final static String _BUILTIN_GENERATINGBUILD = "GeneratingBuild";
	public final static String _BUILTIN_GENERATINGCLASS = "GeneratingClass";
	public final static String _BUILTIN_GENFILEFULLNAME = "GenFileFullName";
	public final static String _BUILTIN_GENFILEBASENAME = "GenFileBaseName";
	public final static String _BUILTIN_GENFILENAME = "GenFileName";
	public final static String _BUILTIN_GENFILEGENERATEONCE = "GenFileGenerateOnce";
	public final static String _BUILTIN_GENFILEMODULENAME = "GenFileModuleName";
	public final static String _BUILTIN_GENSUBPACKAGE = "GenSubPackage";
	public final static String _BUILTIN_SOURCEBUNDLE = "SourceBundle";
	public final static String _BUILTIN_SOURCEPACKAGE = "SourcePackage";

	/**
	 *  constrainMax and constrainMin are of the form:
	 *  
	 *	  constrainMax MaxValue MacroName
	 *	  constrainMin MinValue MacroName
	 *
	 *  Each expands MacroName, and converts the result to Long.
	 *  
	 *  MaxValue and MinValue can be numeric values or MacroNames.
	 *  If they are numeric values, they're converted to Long
	 *  If they are macro names, the macro is expanded and the result is converted to Long.
	 *  
	 *  Once all values are converted, inclusive comparisons are
	 *  made, and the resulting maximum or minimum value is converted
	 *  to a string and resturned as the result of the expansion.
	 *  
	 *  This means you can do range constraints like:
	 *  
	 *	  <GenRule GenDef="StringDef" Name="FieldSize"
	 *		  >$constrainMin 4 MaxLen constrainMax 100 MaxLen$</GenRule>
	 */
	public final static String _CONSTRAIN_MAX = "constrainMax";
	public final static String _CONSTRAIN_MIN = "constrainMin";


	protected class MssCFBuiltinEmpty
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinEmpty( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( "" );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = "";
			return retval;
		}
	}

	protected class MssCFBuiltinGeneratingClass
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGeneratingClass( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENERATINGCLASS );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			MssCFGenContext genFileContext = genContext.getGenFileContext();
			if( genFileContext != null ) {
				retval = genFileContext.getGenDef().getClass().getSimpleName();
			}
			else {
				retval = null;
			}
			return retval;
		}
	}

	protected class MssCFBuiltinGeneratingBuild
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGeneratingBuild( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENERATINGBUILD );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGeneratingBuild();
			return retval;
		}
	}

	protected class MssCFBuiltinGenFileBaseName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenFileBaseName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENFILEBASENAME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenFileBaseName();
			return retval;
		}
	}

	protected class MssCFBuiltinGenFileGenerateOnce
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenFileGenerateOnce( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENFILEGENERATEONCE );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenFileGenerateOnce();
			return retval;
		}
	}

	protected class MssCFBuiltinGenFileModuleName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenFileModuleName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENFILEMODULENAME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenFileModuleName();
			return retval;
		}
	}

	protected class MssCFBuiltinGenFileName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenFileName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENFILENAME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenFileName();
			return retval;
		}
	}

	protected class MssCFBuiltinGenFileFullName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenFileFullName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENFILEFULLNAME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenFileFullName();
			return retval;
		}
	}

	protected class MssCFBuiltinGenSubPackageName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenSubPackageName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENSUBPACKAGE );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenSubPackageName();
			return retval;
		}
	}

	protected class MssCFBuiltinSourceBundle
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinSourceBundle( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_SOURCEBUNDLE );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getSourceBundle();
			return retval;
		}
	}

	protected class MssCFBuiltinSourcePackage
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinSourcePackage( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_SOURCEPACKAGE );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getSourcePackage();
			return retval;
		}
	}

	protected class MssCFBuiltinGeneratorName
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGeneratorName( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENERATORNAME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGeneratorName();
			return retval;
		}
	}

	protected class MssCFBuiltinGeneratorVersion
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGeneratorVersion( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENERATORVERSION );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGeneratorVersion();
			return retval;
		}
	}

	protected class MssCFBuiltinGenDate
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenDate( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENDATE );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenDate();
			return retval;
		}
	}

	protected class MssCFBuiltinGenTime
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenTime( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENTIME );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenTime();
			return retval;
		}
	}

	protected class MssCFBuiltinGenTimestamp
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenTimestamp( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENTIMESTAMP );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenTimestamp();
			return retval;
		}
	}

	protected class MssCFBuiltinGenSerializableUID
	extends CFGenKbGelBuiltinObj
	{
		public MssCFBuiltinGenSerializableUID( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
			getBuff().setRequiredSourceText( _BUILTIN_GENSERIALIZABLEUID );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval = genContext.getGenSerializableUID();
			return retval;
		}
	}

	protected class MssCFConstrainMax
	extends CFGenKbGelConstrainObj
	{
		public MssCFConstrainMax( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFConstrainMax.expand() ";
			long actualConstraint;
			Long hardConstraint = getOptionalHardConstraint();
			if( hardConstraint != null ) {
				actualConstraint = hardConstraint.longValue();
			}
			else {
				String constrainingName = getOptionalConstrainingName();
				if( ( constrainingName == null ) || ( constrainingName.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Neither a HardConstraint nor a ConstrainingName were specified" );
				}

				String constraintStrValue;
				ICFGenKbGenItemObj constraintItem = genContext.getGenEngine().findContextItem(genContext, constrainingName );
				if( constraintItem != null ) {
					if( constraintItem instanceof MssCFGenFileObj ) {
						constraintStrValue = ((MssCFGenFileObj)constraintItem).expandBody( genContext );
					}
					else if( constraintItem instanceof MssCFGenRuleObj ) {
						constraintStrValue = ((MssCFGenRuleObj)constraintItem).expandBody( genContext );
					}
					else if (constraintItem instanceof MssCFGenTruncObj)
					{
						constraintStrValue = ((MssCFGenTruncObj)constraintItem).expandBody( genContext );
					}
					else if (constraintItem instanceof MssCFGenBindObj)
					{
						constraintStrValue = ((MssCFGenBindObj)constraintItem).expandBody( genContext );
					}
					else if( constraintItem instanceof MssCFGenReferenceObj ) {
						throw new RuntimeException(S_ProcName + "Cannot expand reference " + constraintItem.getRequiredName() + " directly");
					}
					else if( constraintItem instanceof MssCFGenIteratorObj ) {
						constraintStrValue = ((MssCFGenIteratorObj)constraintItem).expandBody( genContext );
					}
					else {
						throw new RuntimeException( S_ProcName +  "Unsupported generation item class" );
					}

					boolean isDigitString = true;
					int limitLen = constraintStrValue.length();
					for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
					{
						char c = constraintStrValue.charAt(idxLimit);
						if ((c != '0')
						 && (c != '1')
						 && (c != '2')
						 && (c != '3')
						 && (c != '4')
						 && (c != '5')
						 && (c != '6')
						 && (c != '7')
						 && (c != '8')
						 && (c != '9')
						 && (c != '+')
						 && (c != '-'))
						{
							isDigitString = false;
						}
					}

					if( ! isDigitString ) {
						throw new RuntimeException( S_ProcName + "Expansion of Constraining value produced a non-numeric result, \"" + constraintStrValue + "\" is not a numeric string" );
					}

					actualConstraint = Long.parseLong( constraintStrValue );
				}
				else {
					return( "$" + getRequiredSourceText() + "$" );
				}
			}

			ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
			if( remainder == null ) {
				throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled to produce a constrained value" );
			}

			String constrainedStrValue = remainder.expand( genContext );
			if( ( constrainedStrValue == null ) || ( constrainedStrValue.length() == 0 ) ) {
				throw new RuntimeException( S_ProcName + "Expansion of constrained value produced a null or empty result, not a numeric string" );
			}

			boolean isDigitString = true;
			int limitLen = constrainedStrValue.length();
			for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
			{
				char c = constrainedStrValue.charAt(idxLimit);
				if ((c != '0')
				 && (c != '1')
				 && (c != '2')
				 && (c != '3')
				 && (c != '4')
				 && (c != '5')
				 && (c != '6')
				 && (c != '7')
				 && (c != '8')
				 && (c != '9')
				 && (c != '+')
				 && (c != '-'))
				{
					isDigitString = false;
				}
			}

			if( ! isDigitString ) {
				throw new RuntimeException( S_ProcName + "Expansion of Constrained value produced a non-numeric result, \"" + constrainedStrValue + "\" is not a numeric string" );
			}

			long constrainedValue = Long.parseLong( constrainedStrValue );

			long effectiveValue;
			if( constrainedValue > actualConstraint ) {
				effectiveValue = actualConstraint;
			}
			else {
				effectiveValue = constrainedValue;
			}

			String retval = Long.toString( effectiveValue );

			return( retval );
		}
	}

	protected class MssCFConstrainMin
	extends CFGenKbGelConstrainObj
	{
		public MssCFConstrainMin( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFConstrainMin.expand() ";
			long actualConstraint;
			Long hardConstraint = getOptionalHardConstraint();
			if( hardConstraint != null ) {
				actualConstraint = hardConstraint.longValue();
			}
			else {
				String constrainingName = getOptionalConstrainingName();
				if( ( constrainingName == null ) || ( constrainingName.length() == 0 ) ) {
					throw new RuntimeException( S_ProcName + "Neither a HardConstraint nor a ConstrainingName were specified" );
				}

				String constraintStrValue;
				ICFGenKbGenItemObj constraintItem = genContext.getGenEngine().findContextItem(genContext, constrainingName );
				if( constraintItem != null ) {
					if( constraintItem instanceof MssCFGenFileObj ) {
						constraintStrValue = ((MssCFGenFileObj)constraintItem).expandBody( genContext );
					}
					else if( constraintItem instanceof MssCFGenRuleObj ) {
						constraintStrValue = ((MssCFGenRuleObj)constraintItem).expandBody( genContext );
					}
					else if (constraintItem instanceof MssCFGenTruncObj)
					{
						constraintStrValue = ((MssCFGenTruncObj)constraintItem).expandBody( genContext );
					}
					else if (constraintItem instanceof MssCFGenBindObj)
					{
						constraintStrValue = ((MssCFGenBindObj)constraintItem).expandBody( genContext );
					}
					else if( constraintItem instanceof MssCFGenReferenceObj ) {
						throw new RuntimeException(S_ProcName + "Cannot expand reference " + constraintItem.getRequiredName() + " directly");
					}
					else if( constraintItem instanceof MssCFGenIteratorObj ) {
						constraintStrValue = ((MssCFGenIteratorObj)constraintItem).expandBody( genContext );
					}
					else {
						throw new RuntimeException( S_ProcName +  "Unsupported generation item class" );
					}

					boolean isDigitString = true;
					int limitLen = constraintStrValue.length();
					for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
					{
						char c = constraintStrValue.charAt(idxLimit);
						if ((c != '0')
						 && (c != '1')
						 && (c != '2')
						 && (c != '3')
						 && (c != '4')
						 && (c != '5')
						 && (c != '6')
						 && (c != '7')
						 && (c != '8')
						 && (c != '9')
						 && (c != '+')
						 && (c != '-'))
						{
							isDigitString = false;
						}
					}

					if( ! isDigitString ) {
						throw new RuntimeException( S_ProcName + "Expansion of Constraining value produced a non-numeric result, \"" + constraintStrValue + "\" is not a numeric string" );
					}

					actualConstraint = Long.parseLong( constraintStrValue );
				}
				else {
					return( "$" + getRequiredSourceText() + "$" );
				}
			}

			ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
			if( remainder == null ) {
				throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled to produce a constrained value" );
			}

			String constrainedStrValue = remainder.expand( genContext );
			if( ( constrainedStrValue == null ) || ( constrainedStrValue.length() == 0 ) ) {
				throw new RuntimeException( S_ProcName + "Expansion of constrained value produced a null or empty result, not a numeric string" );
			}

			boolean isDigitString = true;
			int limitLen = constrainedStrValue.length();
			for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
			{
				char c = constrainedStrValue.charAt(idxLimit);
				if ((c != '0')
				 && (c != '1')
				 && (c != '2')
				 && (c != '3')
				 && (c != '4')
				 && (c != '5')
				 && (c != '6')
				 && (c != '7')
				 && (c != '8')
				 && (c != '9')
				 && (c != '+')
				 && (c != '-'))
				{
					isDigitString = false;
				}
			}

			if( ! isDigitString ) {
				throw new RuntimeException( S_ProcName + "Expansion of Constrained value produced a non-numeric result, \"" + constrainedStrValue + "\" is not a numeric string" );
			}

			long constrainedValue = Long.parseLong( constrainedStrValue );

			long effectiveValue;
			if( constrainedValue < actualConstraint ) {
				effectiveValue = actualConstraint;
			}
			else {
				effectiveValue = constrainedValue;
			}

			String retval = Long.toString( effectiveValue );

			return( retval );
		}
	}

	protected class MssCFCounterNew
	extends CFGenKbGelCounterObj
	{
		public MssCFCounterNew( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			genContext.addCounter( getRequiredCounterName() );
			return( "" );
		}
	}

	protected class MssCFCounterIncrement
	extends CFGenKbGelCounterObj
	{
		public MssCFCounterIncrement( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			MssCFCounter counter = genContext.getCounter( getRequiredCounterName() );
			if( counter == null ) {
				throw new RuntimeException( "MssCFCounterIncrement.expand() Counter \"" + getRequiredCounterName() + "\" does not exist in the genContext" );
			}
			counter.increment();
			return( "" );
		}
	}

	protected class MssCFCounterDecrement
	extends CFGenKbGelCounterObj
	{
		public MssCFCounterDecrement( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			MssCFCounter counter = genContext.getCounter( getRequiredCounterName() );
			if( counter == null ) {
				throw new RuntimeException( "MssCFCounterDecrement.expand() Counter \"" + getRequiredCounterName() + "\" does not exist in the genContext" );
			}
			counter.decrement();
			return( "" );
		}
	}

	protected class MssCFCounterValue
	extends CFGenKbGelCounterObj
	{
		public MssCFCounterValue( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			MssCFCounter counter = genContext.getCounter( getRequiredCounterName() );
			if( counter == null ) {
				throw new RuntimeException( "MssCFCounterValue.expand() Counter \"" + getRequiredCounterName() + "\" does not exist in the genContext" );
			}
			int value = counter.getCounter();
			String retval = Integer.toString( value );
			return( retval );
		}
	}

	protected class MssCFModifierStripLeadingZeroes
	extends CFGenKbGelModifierObj
	{
		public MssCFModifierStripLeadingZeroes( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			String raw;
			if( getOptionalLookupRemainder() != null ) {
				raw = getOptionalLookupRemainder().expand( genContext );
			}
			else {
				throw new CFLibRuntimeException( getClass(), "expand", "Modifiers must have a remainder to evaluate" );
			}
			if( raw != null ) {
				int start = 0;
				int len = raw.length() - 1;
				while( ( start < len ) && ( raw.charAt( start ) == '0' ) ) {
					start ++;
				}
				retval = raw.substring( start );
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected class MssCFModifierCoerceUpper
	extends CFGenKbGelModifierObj
	{
		public MssCFModifierCoerceUpper( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			String raw;
			if( getOptionalLookupRemainder() != null ) {
				raw = getOptionalLookupRemainder().expand( genContext );
			}
			else {
				throw new CFLibRuntimeException( getClass(), "expand", "Modifiers must have a remainder to evaluate" );
			}
			if( raw != null ) {
				retval = raw.toUpperCase();
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected class MssCFModifierCoerceLower
	extends CFGenKbGelModifierObj
	{
		public MssCFModifierCoerceLower( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			String raw;
			if( getOptionalLookupRemainder() != null ) {
				raw = getOptionalLookupRemainder().expand( genContext );
			}
			else {
				throw new CFLibRuntimeException( getClass(), "expand", "Modifiers must have a remainder to evaluate" );
			}
			if( raw != null ) {
				retval = raw.toLowerCase();
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected class MssCFModifierCoerceMixed
	extends CFGenKbGelModifierObj
	{
		public MssCFModifierCoerceMixed( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			String raw;
			if( getOptionalLookupRemainder() != null ) {
				raw = getOptionalLookupRemainder().expand( genContext );
			}
			else {
				throw new CFLibRuntimeException( getClass(), "expand", "Modifiers must have a remainder to evaluate" );
			}
			if( raw != null ) {
				retval = raw;  // coerceMixed effectively does nothing.
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected class MssCFModifierCoerceLeadLower
	extends CFGenKbGelModifierObj
	{
		public MssCFModifierCoerceLeadLower( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			String retval;
			String raw;
			if( getOptionalLookupRemainder() != null ) {
				raw = getOptionalLookupRemainder().expand( genContext );
			}
			else {
				throw new CFLibRuntimeException( getClass(), "expand", "Modifiers must have a remainder to evaluate" );
			}
			if( raw != null ) {
				char ch = raw.charAt( 0 );
				if( Character.isLetter( ch ) ) {
					if( raw.length() > 1 ) {
						retval = Character.toLowerCase(ch) + raw.substring( 1 );
					}
					else {
						retval = String.valueOf( Character.toLowerCase(ch) );
					}
				}
				else {
					retval = raw;
				}
			}
			else {
				retval = null;
			}
			return( retval );
		}
	}

	protected class MssCFPop
	extends CFGenKbGelPopObj
	{
		public MssCFPop( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFPop.expand() ";
			MssCFEngine genEngine = genContext.getGenEngine();

			String goalTypeName = this.getRequiredGoalTypeName();
			int numToPop = Integer.parseInt( goalTypeName );
			MssCFGenContext goalContext = genContext;
			while( ( numToPop > 0 ) && ( goalContext != null ) ) {
				goalContext = goalContext.getPrevContext();
				numToPop --;
			}

			if( goalContext == null ) {
				genEngine.getLog().message( S_ProcName + "Already at the top of the context stack. \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" could not be expanded" );
				return( null );
			}

			ICFLibAnyObj refDef = goalContext.getGenDef();
			if( refDef == null ) {
				genEngine.getLog().message( S_ProcName + "GenDef of popped context is null! \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" could not be expanded" );
				return( null );
			}

			MssCFGenContext refContext = goalContext.buildRefContext( goalContext.getGeneratingBuild(), refDef );
			if (refContext == null) {
				throw new RuntimeException(S_ProcName + "buildRefContext() failed");
			}
			refContext.setPrevContext(genContext);

			ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
			if( remainder == null ) {
				throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled for execution" );
			}

			String ret = remainder.expand( refContext );

			return( ret );
		}
	}

	protected class MssCFPopTo
	extends CFGenKbGelPopObj
	{
		public MssCFPopTo( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFPopTo.expand() ";
			MssCFEngine genEngine = genContext.getGenEngine();
			String goalTypeName = this.getRequiredGoalTypeName();
			ICFGenKbDefClassObj goalType = genEngine.getDefClassTableObj().readDefClassByNameIdx(goalTypeName);
			if( goalType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find goal class \"" + goalTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" is invalid" );
				return( null );
			}

			ICFGenKbDefClassObj	objectDefType = genEngine.getDefClassTableObj().readDefClassByNameIdx( "Object" );
			if( objectDefType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find object type \"Object\". \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" is invalid" );
				return( null );
			}

			MssCFGenContext goalContext = genContext;

			String searchTypeName = goalContext.getRequiredLookupGenDef().getRequiredName();
			ICFGenKbDefClassObj searchType = genEngine.getDefClassTableObj().readDefClassByNameIdx(searchTypeName);
			if( searchType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find search class \"" + searchTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" is invalid" );
				return( null );
			}

			ICFLibAnyObj refDef = null;

			if( ( goalType == null )
			 || ( goalType == objectDefType )
			 || ( goalType.getRequiredName().equals( "Object" ) )
			 || ( goalType.getRequiredName().equals( "*" ) ) )
			{
				refDef = goalContext.getGenDef();
				if( refDef != null ) {
					refDef = refDef.getObjScope();
				}
				goalContext = null;
			}
			else {
				while( searchType != null
					&& searchType != goalType
					&& goalContext != null )
				{
					if( searchType != objectDefType ) {
						searchType = searchType.getOptionalParentBaseDefClass();
					}
					else {
						searchType = null;
					}
					if( searchType == null ) {
						if( goalContext.prevContext != goalContext ) {
							goalContext = goalContext.prevContext;
							if( goalContext != null ) {
								searchTypeName = goalContext.getRequiredLookupGenDef().getRequiredName();
								searchType = genEngine.getDefClassTableObj().readDefClassByNameIdx(searchTypeName);
								if( searchType == null ) {
									genEngine.getLog().message( S_ProcName + "Could not find search class \"" + searchTypeName + "\". \""
										+ "$" + getRequiredSourceText() + "$"
										+ "\" is invalid" );
									return( null );
								}
							}
							refDef = goalContext.getGenDef();
						}
						else {
							goalContext = null;
							refDef = null;
						}
					}
				}
			}

			if( goalContext == null ) {
				if( refDef == null ) {
					return( "" );
				}
			}
			else {
				refDef = goalContext.getGenDef();
			}

			String ret;

			if( refDef != null ) {
				MssCFGenContext refContext = genContext.buildRefContext( genContext.getGeneratingBuild(), refDef );
				if (refContext == null) {
					throw new RuntimeException(S_ProcName + "buildRefContext() failed");
				}

				refContext.setPrevContext(genContext);

				ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
				if( remainder == null ) {
					throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled for execution" );
				}

				ret = remainder.expand( refContext );
			}
			else {
				ret = "";
			}

			return( ret );
		}
	}

	protected class MssCFPopTop
	extends CFGenKbGelPopObj
	{
		public MssCFPopTop( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFPopTop.expand() ";
			MssCFEngine genEngine = genContext.getGenEngine();
			String goalTypeName = this.getRequiredGoalTypeName();
			ICFGenKbDefClassObj goalType = genEngine.getDefClassTableObj().readDefClassByNameIdx(goalTypeName);
			if( goalType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find goal class \"" + goalTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" is invalid" );
				return( null );
			}

			ICFGenKbDefClassObj	objectDefType = genEngine.getDefClassTableObj().readDefClassByNameIdx( "Object" );
			if( objectDefType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find object type \"Object\". \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" is invalid" );
				return( null );
			}

			MssCFGenContext goalContext = genContext;
			MssCFGenContext topContext = null;
			String searchTypeName;
			ICFGenKbDefClassObj searchType;

			while ( goalContext != null) {
				searchTypeName = goalContext.getRequiredLookupGenDef().getRequiredName();
				searchType = genEngine.getDefClassTableObj().readDefClassByNameIdx(searchTypeName);
				if( searchType == null ) {
					genEngine.getLog().message( S_ProcName + "Could not find search class \"" + searchTypeName + "\". \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" is invalid" );
					return( null );
				}

				while ( (searchType != null ) && ( searchType != goalType )) {
					if( searchType != objectDefType ) {
						searchType = searchType.getOptionalParentBaseDefClass();
					}
					else {
						searchType = null;
					}
				}

				if (searchType != null) {
					// The goal context definition derives from the target type
					topContext = goalContext;
				}

				if (goalContext.prevContext != goalContext) {
					goalContext = goalContext.prevContext;
				}
				else {
					goalContext = null;
				}
			}

			if (topContext == null) {
				genEngine.getLog().message( S_ProcName + "Could not find top context with a definition derived from \"" + goalTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" could not be expanded");
				return (null);
			}

			ICFLibAnyObj refDef = topContext.getGenDef();
			if( refDef == null ) {
				genEngine.getLog().message( S_ProcName + "GenDef of popped context is null! \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" could not be expanded" );
				return( null );
			}

			MssCFGenContext refContext = topContext.buildRefContext( topContext.getGeneratingBuild(), refDef);
			if (refContext == null) {
				throw new RuntimeException(S_ProcName + "buildRefContext() failed");
			}
			refContext.setPrevContext(genContext);

			ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
			if( remainder == null ) {
				throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled for execution" );
			}

			String ret = remainder.expand( refContext );

			return (ret);
		}
	}

	protected class MssCFPopOneFromTop
	extends CFGenKbGelPopObj
	{
		public MssCFPopOneFromTop( ICFGenKbSchemaObj argSchema ) {
			super( argSchema );
		}

		public String expand( MssCFGenContext genContext ) {
			final String S_ProcName = "MssCFPopOneFromTop.expand() ";
			MssCFEngine genEngine = genContext.getGenEngine();
			String goalTypeName = this.getRequiredGoalTypeName();
			ICFGenKbDefClassObj goalType = genEngine.getDefClassTableObj().readDefClassByNameIdx(goalTypeName);
			if( goalType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find goal class \"" + goalTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" is invalid" );
				return( null );
			}

			ICFGenKbDefClassObj	objectDefType = genEngine.getDefClassTableObj().readDefClassByNameIdx( "Object" );
			if( objectDefType == null ) {
				genEngine.getLog().message( S_ProcName + "Could not find object type \"Object\". \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" is invalid" );
				return( null );
			}

			MssCFGenContext topContext = null;
			MssCFGenContext oneFromTopContext = null;
			MssCFGenContext goalContext = genContext;
			String searchTypeName;
			ICFGenKbDefClassObj searchType;

			while (goalContext != null) {
				searchTypeName = goalContext.getRequiredLookupGenDef().getRequiredName();
				searchType = genEngine.getDefClassTableObj().readDefClassByNameIdx(searchTypeName);
				if( searchType == null ) {
					genEngine.getLog().message( S_ProcName + "Could not find search class \"" + searchTypeName + "\". \""
						+ "$" + getRequiredSourceText() + "$"
						+ "\" is invalid" );
					return( null );
				}

				while ( searchType != null && searchType != goalType ) {
					if( searchType != objectDefType ) {
						searchType = searchType.getOptionalParentBaseDefClass();
					}
					else {
						searchType = null;
					}
				}

				if (searchType != null) {
					// The goal context definition derives from the target type
					oneFromTopContext = topContext;
					topContext = goalContext;
				}

				if (goalContext.getPrevContext() != goalContext) {
					goalContext = goalContext.getPrevContext();
				}
				else {
					goalContext = null;
				}
			}

			if (oneFromTopContext == null) {
				genEngine.getLog().message( S_ProcName + "Could not find one from top context with a definition derived from \"" + goalTypeName + "\". \""
					+ "$" + getRequiredSourceText() + "$"
					+ "\" could not be expanded");
				return (null);
			}

			ICFLibAnyObj refDef = topContext.getGenDef();

			MssCFGenContext refContext = topContext.buildRefContext( topContext.getGeneratingBuild(), refDef);
			if (refContext == null) {
				throw new RuntimeException(S_ProcName + "buildRefContext() failed");
			}
			refContext.setPrevContext(genContext);

			ICFGenKbGelInstructionObj remainder = getOptionalLookupRemainder();
			if( remainder == null ) {
				throw new RuntimeException( S_ProcName + "Remainder of macro was not compiled for execution" );
			}

			String ret = remainder.expand( refContext );

			return (ret);
		}
	}

	protected String normalizeMacro( String rawMacro ) {
		if( rawMacro == null ) {
			return( null );
		}

		StringBuffer normalized = new StringBuffer();
		int len = rawMacro.length();
		int idx = 0;

		// Skip any leading whitespace
		char ch = rawMacro.charAt( idx );
		while( ( ch == ' ' ) || ( ch == '\t' ) || ( ch == '\n' ) || ( ch == '\r' ) || ( ch == '\f' ) ) {
			idx ++;
			ch = rawMacro.charAt( idx );
		}

		// We have not emitted any whitespace yet; we skipped it
		boolean emittedSpace = false;
		while( idx < len ) {
			ch = rawMacro.charAt( idx );
			if( ( ch == ' ' )
			 || ( ch == '\t' )
			 || ( ch == '\n' )
			 || ( ch == '\r' )
			 || ( ch == '\f' ) )
			{
				if( ! emittedSpace ) {
					normalized.append( ' ' );
					emittedSpace = true;
				}
			}
			else if( ( ch == '(' ) || ( ch == ')' ) ) {
				if( ! emittedSpace ) {
					normalized.append( ' ' );
				}
				normalized.append( ch );
				if( ch == '(' ) {
					normalized.append( ' ' );
					emittedSpace = true;
				}
				else {
					emittedSpace = false;
				}
			}
			else {
				emittedSpace = false;
				normalized.append( ch );
			}
			idx ++;
		}
		// Trim any trailing space
		String retval;
		if( ( normalized.length() > 0 ) && emittedSpace ) {
			retval = normalized.toString().substring( 0, normalized.length() - 1 );
		}
		else {
			retval = normalized.toString();
		}
		return( retval );
	}

	/**
	 *	When macros are found we need to interpret them.  The
	 *	main body text boilerplate vs. macro expansion is handled
	 *	by expand().  This method deals with interpreting the
	 *	macros themselves.
	 *
	 *	@param		body		String
	 *	@return	String		The result of expanding the body.
	 */
	protected ICFGenKbGelInstructionObj compileMacro( String macro )
	{
		char				ch;
		int					start;
		int					lenMacro;
		String				remainingMacro;
		String				subExpansion;
		ICFGenKbGelInstructionObj ret = null;
		ICFGenKbGenItemObj	genItem = null;

		final String S_ProcName = "compileMacro() ";

		if( ( macro == null ) || ( macro.length() <= 0 ) ) {
			return( null );
		}

		lenMacro = macro.length();

	//	Look up the macro in the GEL cache, and if it exists, just return the shared instance

		ret = myGelCache.lookupMacro( macro );
		if( ret != null ) {
			return( ret );
		}

	//	If the macro starts with "iterate ", return an evaluation
	//	 of the iteration.

		else if( macro.startsWith( _ITERATE ) ) {
			ret = compileIteration( macro );
		}

	//	If the macro starts with "spread ", return an evaluation
	//	 of the spread.

		else if( macro.startsWith( _SPREAD ) ) {
			ret = compileSpread( macro );
		}

	//	If the macro starts with "switch ", return an evaluation
	//	 of the switch.

		else if( macro.startsWith( _SWITCH ) ) {
			ret = compileSwitch( macro );
		}

	//  If the macro is a constraint, return an evaluation of
	//  the constraint.

		else if( macro.startsWith( _CONSTRAIN_MAX ) ) {
			ret = compileConstrainMax( macro );
		}
		else if( macro.startsWith( _CONSTRAIN_MIN ) ) {
			ret = compileConstrainMin( macro );
		}

	//	If the macro starts with a coercion, return a coercion of
	//	the evaluation of the rest of the macro

		else if( macro.startsWith( _STRIPLEADINGZEROES ) ) {
			start = _STRIPLEADINGZEROES.length();
			while ( ( start < lenMacro )
				&&	(	(( ch = macro.charAt(start)) == ' ')
						|| ch == '\t'
						|| ch == '\r'
						|| ch == '\n'
						|| ch == '\f' ) ) 
			{
				start = start + 1;
			}
			remainingMacro = macro.substring(start);

			ICFGenKbGelModifierObj modifierObj = new MssCFModifierStripLeadingZeroes( genEngine ); 
			ICFGenKbGelModifierEditObj modifierEdit = (ICFGenKbGelModifierEditObj)modifierObj.beginEdit();
			modifierEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			modifierEdit.setRequiredContainerGelCache( myGelCache );
			modifierEdit.setRequiredSourceText( macro );
			modifierObj = (ICFGenKbGelModifierObj)modifierEdit.create();
			modifierEdit = null;

			ICFGenKbGelInstructionObj remainderInstruction = compileMacro( remainingMacro );
			if( remainderInstruction == null ) {
				ret = null;
				setCompileError();
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Modifiers must always be followed by macro specifications whose results are to be modified\n" );
				getCompileLog().message( msg.toString() );
			}
			else {
				modifierEdit = (ICFGenKbGelModifierEditObj)( modifierObj.beginEdit() );
				modifierEdit.setOptionalLookupRemainder( remainderInstruction );
				try {
					modifierEdit.update();
					modifierEdit = null;
					ret = modifierObj;
				}
				catch( Exception e ) {
					modifierEdit.endEdit();
					modifierEdit = null;
					ret = null;
				}
			}
		}

		else if( macro.startsWith( _COERCE_UPPER ) ) {
			start = _COERCE_UPPER.length();
			while ( ( start < lenMacro )
				&&	(	(( ch = macro.charAt(start)) == ' ')
						|| ch == '\t'
						|| ch == '\r'
						|| ch == '\n'
						|| ch == '\f' ) ) 
			{
				start = start + 1;
			}
			remainingMacro = macro.substring(start);

			ICFGenKbGelModifierObj modifierObj = new MssCFModifierCoerceUpper( genEngine ); 
			ICFGenKbGelModifierEditObj modifierEdit = (ICFGenKbGelModifierEditObj)modifierObj.beginEdit();
			modifierEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			modifierEdit.setRequiredContainerGelCache( myGelCache );
			modifierEdit.setRequiredSourceText( macro );
			modifierObj = (ICFGenKbGelModifierObj)modifierEdit.create();
			modifierEdit = null;

			ICFGenKbGelInstructionObj remainderInstruction = compileMacro( remainingMacro );
			if( remainderInstruction == null ) {
				ret = null;
				setCompileError();
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Modifiers must always be followed by macro specifications whose results are to be modified\n" );
				getCompileLog().message( msg.toString() );
			}
			else {
				modifierEdit = (ICFGenKbGelModifierEditObj)( modifierObj.beginEdit() );
				modifierEdit.setOptionalLookupRemainder( remainderInstruction );
				try {
					modifierEdit.update();
					modifierEdit = null;
					ret = modifierObj;
				}
				catch( Exception e ) {
					modifierEdit.endEdit();
					modifierEdit = null;
					ret = null;
				}
			}
		}
		else if( macro.startsWith( _COERCE_LOWER ) ) {
			start = _COERCE_LOWER.length();
			while ( ( start < lenMacro )
				&&	(	(( ch = macro.charAt(start)) == ' ')
						|| ch == '\t'
						|| ch == '\r'
						|| ch == '\n'
						|| ch == '\f' ) ) 
			{
				start = start + 1;
			}
			remainingMacro = macro.substring(start);

			ICFGenKbGelModifierObj modifierObj = new MssCFModifierCoerceLower( genEngine ); 
			ICFGenKbGelModifierEditObj modifierEdit = (ICFGenKbGelModifierEditObj)modifierObj.beginEdit();
			modifierEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			modifierEdit.setRequiredContainerGelCache( myGelCache );
			modifierEdit.setRequiredSourceText( macro );
			modifierObj = (ICFGenKbGelModifierObj)modifierEdit.create();
			modifierEdit = null;

			ICFGenKbGelInstructionObj remainderInstruction = compileMacro( remainingMacro );
			if( remainderInstruction == null ) {
				ret = null;
				setCompileError();
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Modifiers must always be followed by macro specifications whose results are to be modified\n" );
				getCompileLog().message( msg.toString() );
			}
			else {
				modifierEdit = (ICFGenKbGelModifierEditObj)( modifierObj.beginEdit() );
				modifierEdit.setOptionalLookupRemainder( remainderInstruction );
				try {
					modifierEdit.update();
					modifierEdit = null;
					ret = modifierObj;
				}
				catch( Exception e ) {
					modifierEdit.endEdit();
					modifierEdit = null;
					ret = null;
				}
			}
		}
		else if( macro.startsWith( _COERCE_MIXED ) ) {
			start = _COERCE_MIXED.length();
			while ( ( start < lenMacro )
				&&	(	(( ch = macro.charAt(start)) == ' ')
						|| ch == '\t'
						|| ch == '\r'
						|| ch == '\n'
						|| ch == '\f' ) ) 
			{
				start = start + 1;
			}
			remainingMacro = macro.substring(start);

			ICFGenKbGelModifierObj modifierObj = new MssCFModifierCoerceMixed( genEngine ); 
			ICFGenKbGelModifierEditObj modifierEdit = (ICFGenKbGelModifierEditObj)modifierObj.beginEdit();
			modifierEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			modifierEdit.setRequiredContainerGelCache( myGelCache );
			modifierEdit.setRequiredSourceText( macro );
			modifierObj = (ICFGenKbGelModifierObj)modifierEdit.create();
			modifierEdit = null;

			ICFGenKbGelInstructionObj remainderInstruction = compileMacro( remainingMacro );
			if( remainderInstruction == null ) {
				ret = null;
				setCompileError();
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Modifiers must always be followed by macro specifications whose results are to be modified\n" );
				getCompileLog().message( msg.toString() );
			}
			else {
				modifierEdit = (ICFGenKbGelModifierEditObj)( modifierObj.beginEdit() );
				modifierEdit.setOptionalLookupRemainder( remainderInstruction );
				try {
					modifierEdit.update();
					modifierEdit = null;
					ret = modifierObj;
				}
				catch( Exception e ) {
					modifierEdit.endEdit();
					modifierEdit = null;
					ret = null;
				}
			}
		}
		else if( macro.startsWith( _COERCE_LEADLOWER ) ) {
			start = _COERCE_LEADLOWER.length();
			while ( ( start < lenMacro )
				&&	(	(( ch = macro.charAt(start)) == ' ')
						|| ch == '\t'
						|| ch == '\r'
						|| ch == '\n'
						|| ch == '\f' ) ) 
			{
				start = start + 1;
			}
			remainingMacro = macro.substring(start);

			ICFGenKbGelModifierObj modifierObj = new MssCFModifierCoerceLeadLower( genEngine ); 
			ICFGenKbGelModifierEditObj modifierEdit = (ICFGenKbGelModifierEditObj)modifierObj.beginEdit();
			modifierEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			modifierEdit.setRequiredContainerGelCache( myGelCache );
			modifierEdit.setRequiredSourceText( macro );
			modifierObj = (ICFGenKbGelModifierObj)modifierEdit.create();
			modifierEdit = null;

			ICFGenKbGelInstructionObj remainderInstruction = compileMacro( remainingMacro );
			if( remainderInstruction == null ) {
				ret = null;
				setCompileError();
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Modifiers must always be followed by macro specifications whose results are to be modified\n" );
				getCompileLog().message( msg.toString() );
			}
			else {
				modifierEdit = (ICFGenKbGelModifierEditObj)( modifierObj.beginEdit() );
				modifierEdit.setOptionalLookupRemainder( remainderInstruction );
				try {
					modifierEdit.update();
					modifierEdit = null;
					ret = modifierObj;
				}
				catch( Exception e ) {
					modifierEdit.endEdit();
					modifierEdit = null;
					ret = null;
				}
			}
		}

		//	If the macro starts with a prefixline directive, return a coercion of
		//	the evaluation of the rest of the macro

		else if (macro.startsWith(_PREFIX_LINE)) {
			ret = compilePrefixLine( macro );
		}

	//	If the macro starts with a popto directive the body
	//	of the macro is to be compiled by temporarily
	//	unwinding the context stack until the generation
	//	definition is an instance of the parameter class.
	//	If no such definition is found, a warning is logged
	//	and the macro is considered to be in error.

		else if (macro.startsWith(_POPONEFROMTOP)) {
			ret = compilePopOneFromTop( macro );
		}

		else if (macro.startsWith(_POPTOP)) {
			ret = compilePopTop( macro );
		}

		else if (macro.startsWith(_POPTO)) {
			ret = compilePopTo( macro );
		}

		else if( macro.startsWith( _POP ) ) {
			ret = compilePop( macro );
		}

	//	If the macro starts with a reference directive the body
	//	of the macro is compiled by calling the bound reference
	//	method using the current context.  The definition item
	//	returned will be the leaf of an artificially generated
	//	context stack that traces the scope of the referenced item
	//	up to the package which owns the item.

		else if( macro.startsWith( _REFERENCE ) ) {
			ret = compileReference( macro );
		}

	//	Counters are up next

		else if( macro.startsWith( _COUNTER ) ) {
			ret = compileCounter( macro );
		}

	//	Next are some built-in macros that deal with the current context
	//	and current file.

		else if( macro.equals( _EMPTY ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinEmpty( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENERATINGBUILD ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGeneratingBuild( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENERATINGCLASS ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGeneratingClass( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENFILEBASENAME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenFileBaseName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENFILENAME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenFileName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENFILEGENERATEONCE ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenFileGenerateOnce( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENFILEMODULENAME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenFileModuleName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENFILEFULLNAME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenFileFullName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENSUBPACKAGE ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenSubPackageName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_SOURCEBUNDLE ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinSourceBundle( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_SOURCEPACKAGE ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinSourcePackage( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}

	//	More built-ins get information about the generation itself

		else if( macro.equals( _BUILTIN_GENERATORNAME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGeneratorName( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENERATORVERSION ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGeneratorVersion( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENDATE ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenDate( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENTIME ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenTime( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENTIMESTAMP ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenTimestamp( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}
		else if( macro.equals( _BUILTIN_GENSERIALIZABLEUID ) ) {
			ICFGenKbGelBuiltinObj builtinObj = new MssCFBuiltinGenSerializableUID( genEngine ); 
			ICFGenKbGelBuiltinEditObj builtinEdit = (ICFGenKbGelBuiltinEditObj)builtinObj.beginEdit();
			builtinEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			builtinEdit.setRequiredContainerGelCache( myGelCache );
			builtinEdit.setRequiredSourceText( macro );
			builtinObj = (ICFGenKbGelBuiltinObj)builtinEdit.create();
			builtinEdit = null;
			ret = builtinObj;
		}

	//	Otherwise assume we just have the name of a normal macro
	//	and need to expand it's body

		else {
			ICFGenKbGelExpansionObj expansionObj = genEngine.getGelExpansionTableObj().newInstance(); 
			ICFGenKbGelExpansionEditObj expansionEdit = (ICFGenKbGelExpansionEditObj)expansionObj.beginEdit();
			expansionEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			expansionEdit.setRequiredContainerGelCache( myGelCache );
			if( macro.length() > 127 )  {
				expansionEdit.setRequiredMacroName( macro.substring( 0, 127 ) );
			}
			else {
				expansionEdit.setRequiredMacroName( macro );
			}
			expansionEdit.setRequiredSourceText( macro );
			expansionObj = (ICFGenKbGelExpansionObj)expansionEdit.create();
			expansionEdit = null;
			ret = expansionObj;
		}

		if( ret != null ) {
			ret = myGelCache.rememberMacro( macro, ret );
		}

		return( ret );
	}

	/**
	 *	Macros that start with "iterate " are special macros
	 *	used to iterate through a list of detail items.  This
	 *	method parses those macros.  If it is successful, it
	 *	invokes expandIteration() to interpret the iterator.
	 *
	 *	@param		body		String
	 *	@return	String		The result of expanding the body.
	 */
	protected ICFGenKbGelInstructionObj compileIteration( String macro )
	{
		int					start;
		int					lparen;
		int					lenMacro = 0;
		char				ch;
		Boolean				gotIType = false;
		Boolean				gotRParen = false;
		String				strItemType = null;
		String	  			itype = null;
		String			  	itemname = null;
		StringBuffer		iteratorName = new StringBuffer();
		ICFGenKbGelInstructionObj ret = null;
		ICFGenKbGenItemObj	genItem = null;
		MssCFGenIteratorObj	iterator = null;

		String				bodyBefore = null;
		String				bodyFirst = null;
		String				bodyEach = null;
		String				bodyLast = null;
		String				bodyAfter = null;
		String				bodyLone = null;
		String				bodyEmpty = null;

		final String S_ProcName = "MssCFGelCompiler.compileIteration() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _ITERATE ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _ITERATE );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "iterate"

		start = _ITERATE.length();

	//  Skip whitespace

		if( macro.charAt( start ) == ' ' ) {
			start ++;
		}

	//	Extract the iterator name

		while( ( macro.charAt( start ) != '(' ) && ( macro.charAt( start ) != ' ') && ( start < lenMacro ) ) {
			iteratorName.append( macro.charAt( start ) );
			start ++;
		}

		if( iteratorName.length() <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Iteration macro must specify iterator name. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Skip past space and lparen

		if( macro.charAt( start ) == ' ' ) {
			start ++;
		}

		if( ( start >= lenMacro ) || ( macro.charAt( start ) != '(' ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Iteration macro must specify iteration parameters. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the start past the opening '('

		start ++;

	//	Parse the iteration limbs, which take the form "itype itemname"
	//	separated by commas and terminated by a closing ')'

		itype = "";
		itemname = "";

		while( ! gotRParen ) {

			if( start >= lenMacro ) {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Malformed iterator invocation. \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

			// Skip leading whitespace

			ch = macro.charAt( start );
			if( ch ==  ' ' ) {
				start ++;
				continue;
			}

			// Check for the terminating RParen

			if( ch == ')' ) {
				start ++;
				gotRParen = true;
				continue;
			}

			// Reset the item type

			gotIType = false;
			itype = "";

			// Scan the itype

			while( true ) {

				if( start >= lenMacro ) {
					break;
				}

				ch = macro.charAt( start );
				if( ch == ' ' ) {
					if( itype.length() > 0 ) {
						gotIType = true;
					}
					break;
				}
				else if( ch == ',' || ch == ')' ) {
					if( itype.length() > 0 ) {
						gotIType = true;
					}
					break;
				}
				else {
					itype = itype + ch;
					start ++;
				}
			}

			// We must have an iterator type

			if( ! gotIType ) {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Missing iterator type argument. \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

			// Skip intervening whitespace

			while( start < lenMacro ) {
				ch = macro.charAt( start );
				if( ch == ' ' ) {
					start ++;
				}
				else {
					break;
				}
			}

			// Reset the itemname

			itemname = "";

			// Scan the itemname

			while( start < lenMacro ) {

				if( start >= lenMacro ) {
					break;
				}

				ch = macro.charAt( start );

				if( ch == ' ' ) {
					break;
				}

				if( ch == ',' || ch == ')' ) {
					break;
				}

				itemname = itemname + ch;
				start ++;
			}

	//		Check for recognized iterators

			strItemType = itype;

			if( strItemType.equals( _ITERATOR_EACH ) ) {
				if( bodyEach == null ) {
					bodyEach = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_EMPTY ) ) {
				if( bodyEmpty == null ) {
					bodyEmpty = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_LAST ) ) {
				if( bodyLast == null ) {
					bodyLast = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_FIRST ) ) {
				if( bodyFirst == null ) {
					bodyFirst = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_BEFORE ) ) {
				if( bodyBefore == null ) {
					bodyBefore = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_AFTER ) ) {
				if( bodyAfter == null ) {
					bodyAfter = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_LONE ) ) {
				if( bodyLone == null ) {
					bodyLone = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Iterator type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Unrecognized iterator type \"" );
				msg.append( strItemType );
				msg.append( "\". \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

	//		Break the loop if we've reached the end of the macro

			if( start >= lenMacro ) {
				continue;
			}

	//		If our next character is a ',' its a separator to be skipped

			ch = macro.charAt( start );
			if( ch == ',' ) {
				start ++;
				continue;
			}

	//		If our next character is a ')', we should be done

			if( ch == ')' ) {
				gotRParen = true;
				start ++;
				continue;
			}
		}

		if( ! gotRParen ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Iterator invocation is missing a terminating ')'. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	At a minimum we must have an "each" limb

		if( ( bodyEach == null ) || ( 0 == bodyEach.length() ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Iterator must specify an \"" );
			msg.append( _ITERATOR_EACH );
			msg.append( "\" limb. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	The body macros we got for expansion and the number of items in the iteration
	//	determine exactly what we do for any given case.

		ICFGenKbGelIteratorObj iteratorObj = genEngine.getGelIteratorTableObj().newInstance(); 
		ICFGenKbGelIteratorEditObj iteratorEdit = (ICFGenKbGelIteratorEditObj)iteratorObj.beginEdit();
		iteratorEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		iteratorEdit.setRequiredContainerGelCache( myGelCache );
		iteratorEdit.setRequiredSourceText( macro );
		iteratorEdit.setRequiredIteratorName( iteratorName.toString() );
		iteratorEdit.setOptionalExpandBefore( bodyBefore );
		iteratorEdit.setOptionalExpandFirst( bodyFirst );
		iteratorEdit.setRequiredExpandEach( bodyEach );
		iteratorEdit.setOptionalExpandLast( bodyLast );
		iteratorEdit.setOptionalExpandAfter( bodyAfter );
		iteratorEdit.setOptionalExpandLone( bodyLone );
		iteratorEdit.setOptionalExpandEmpty( bodyEmpty );
		iteratorObj = (ICFGenKbGelIteratorObj)iteratorEdit.create();
		iteratorEdit = null;
		ret = iteratorObj;

		return( ret );
	}

	/**
	 *	Macros that start with "spread " are special macros
	 *	used to spread an iteration of detail items.  This
	 *	method parses those macros.  If it is successful, it
	 *	invokes expandIteration() to interpret the iterator.
	 *
	 *	@param		body		String
	 *	@return	String		The result of expanding the body.
	 */
	protected ICFGenKbGelInstructionObj compileSpread( String macro )
	{
		int					start;
		int					lparen;
		int					lenMacro = 0;
		char				ch;
		Boolean				gotIType = false;
		Boolean				gotRParen = false;
		String				strItemType = null;
		String	  			itype = null;
		String			  	itemname = null;
		StringBuffer		iteratorName = new StringBuffer();
		ICFGenKbGelInstructionObj ret = null;
		ICFGenKbGenItemObj	genItem = null;
		MssCFGenIteratorObj	iterator = null;

		String				bodyBetween = null;
		String				bodyBefore = null;
		String				bodyFirst = null;
		String				bodyEach = null;
		String				bodyLast = null;
		String				bodyAfter = null;
		String				bodyLone = null;
		String				bodyEmpty = null;

		final String S_ProcName = "MssCFGelCompiler.compileSpread() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _SPREAD ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _SPREAD );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "spread"

		start = _SPREAD.length();

	//  Skip whitespace

		if( macro.charAt( start ) == ' ' ) {
			start ++;
		}

	//	Extract the iterator name

		while( ( macro.charAt( start ) != '(' ) && ( macro.charAt( start ) != ' ') && ( start < lenMacro ) ) {
			iteratorName.append( macro.charAt( start ) );
			start ++;
		}

		if( iteratorName.length() <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Spread macro must specify iterator name. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Skip past space and lparen

		if( macro.charAt( start ) == ' ' ) {
			start ++;
		}

		if( ( start >= lenMacro ) || ( macro.charAt( start ) != '(' ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Spread macro must specify spread parameters. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the start past the opening '('

		start ++;

	//	Parse the iteration limbs, which take the form "itype itemname"
	//	separated by commas and terminated by a closing ')'

		itype = "";
		itemname = "";

		while( ! gotRParen ) {

			if( start >= lenMacro ) {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Malformed spread invocation. \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

			// Skip leading whitespace

			ch = macro.charAt( start );
			if( ch ==  ' ' ) {
				start ++;
				continue;
			}

			// Check for the terminating RParen

			if( ch == ')' ) {
				start ++;
				gotRParen = true;
				continue;
			}

			// Reset the item type

			gotIType = false;
			itype = "";

			// Scan the itype

			while( true ) {

				if( start >= lenMacro ) {
					break;
				}

				ch = macro.charAt( start );
				if( ch == ' ' ) {
					if( itype.length() > 0 ) {
						gotIType = true;
					}
					break;
				}
				else if( ch == ',' || ch == ')' ) {
					if( itype.length() > 0 ) {
						gotIType = true;
					}
					break;
				}
				else {
					itype = itype + ch;
					start ++;
				}
			}

			// We must have an iterator type

			if( ! gotIType ) {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Missing spread type argument. \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

			// Skip intervening whitespace

			while( start < lenMacro ) {
				ch = macro.charAt( start );
				if( ch == ' ' ) {
					start ++;
				}
				else {
					break;
				}
			}

			// Reset the itemname

			itemname = "";

			// Scan the itemname

			while( start < lenMacro ) {

				if( start >= lenMacro ) {
					break;
				}

				ch = macro.charAt( start );

				if( ch == ' ' ) {
					break;
				}

				if( ch == ',' || ch == ')' ) {
					break;
				}

				itemname = itemname + ch;
				start ++;
			}

	//		Check for recognized spreads

			strItemType = itype;

			if( strItemType.equals( _SPREAD_BETWEEN ) ) {
				if( bodyBetween == null ) {
					bodyBetween = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_EACH ) ) {
				if( bodyEach == null ) {
					bodyEach = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_EMPTY ) ) {
				if( bodyEmpty == null ) {
					bodyEmpty = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_LAST ) ) {
				if( bodyLast == null ) {
					bodyLast = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_FIRST ) ) {
				if( bodyFirst == null ) {
					bodyFirst = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_BEFORE ) ) {
				if( bodyBefore == null ) {
					bodyBefore = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_AFTER ) ) {
				if( bodyAfter == null ) {
					bodyAfter = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else if( strItemType.equals( _ITERATOR_LONE ) ) {
				if( bodyLone == null ) {
					bodyLone = itemname;
				}
				else {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Spread type \"" );
					msg.append( strItemType );
					msg.append( "\" is already defined. \"" );
					msg.append( macro );
					msg.append( "\" is invalid" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}
			else {
				StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
				msg.append( '.' );
				msg.append( S_ProcName );
				msg.append( "() Unrecognized spread type \"" );
				msg.append( strItemType );
				msg.append( "\". \"" );
				msg.append( macro );
				msg.append( "\" is invalid" );
				setCompileError();
				getCompileLog().message( msg.toString() );
				return( null );
			}

	//		Break the loop if we've reached the end of the macro

			if( start >= lenMacro ) {
				continue;
			}

	//		If our next character is a ',' its a separator to be skipped

			ch = macro.charAt( start );
			if( ch == ',' ) {
				start ++;
				continue;
			}

	//		If our next character is a ')', we should be done

			if( ch == ')' ) {
				gotRParen = true;
				start ++;
				continue;
			}
		}

		if( ! gotRParen ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Spread invocation is missing a terminating ')'. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	At a minimum we must have an "each" limb

		if( ( bodyEach == null ) || ( 0 == bodyEach.length() ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Spread must specify an \"" );
			msg.append( _ITERATOR_EACH );
			msg.append( "\" limb. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	The body macros we got for expansion and the number of items in the iteration
	//	determine exactly what we do for any given case.

		ICFGenKbGelSpreadObj spreadObj = genEngine.getGelSpreadTableObj().newInstance(); 
		ICFGenKbGelSpreadEditObj spreadEdit = (ICFGenKbGelSpreadEditObj)spreadObj.beginEdit();
		spreadEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		spreadEdit.setRequiredContainerGelCache( myGelCache );
		spreadEdit.setRequiredSourceText( macro );
		spreadEdit.setRequiredIteratorName( iteratorName.toString() );
		spreadEdit.setOptionalExpandBetween( bodyBetween );
		spreadEdit.setOptionalExpandBefore( bodyBefore );
		spreadEdit.setOptionalExpandFirst( bodyFirst );
		spreadEdit.setRequiredExpandEach( bodyEach );
		spreadEdit.setOptionalExpandLast( bodyLast );
		spreadEdit.setOptionalExpandAfter( bodyAfter );
		spreadEdit.setOptionalExpandLone( bodyLone );
		spreadEdit.setOptionalExpandEmpty( bodyEmpty );
		spreadObj = (ICFGenKbGelSpreadObj)spreadEdit.create();
		spreadEdit = null;
		ret = spreadObj;

		return( ret );
	}


	/**
	 *	Macros that start with "counter " are special directives
	 *	which manipulate index counters.
	 *	<p>
	 *	Counters are a bit limited, but useful for positional parameter bindings.
	 *	Remember that new counters are initialized to 0, not 1.
	 *	<p>
	 *	Syntax is:
	 *	<UL>
	 *		<LI>counter name new</LI>
	 *		<LI>counter name increment</LI>
	 *		<LI>counter name decrement</LI>
	 *		<LI>counter name value</LI>
	 *	</UL>
	 *
	 *	@param		macro		String
	 *	@return	String		The result of expanding the macro.
	 */
	protected ICFGenKbGelInstructionObj compileCounter( String macro )
	{
		int					start;
		int					lenMacro = 0;
		char				ch;
		String				counterName = null;
		String				counterOp = null;
		String				counterOpName = null;
		ICFGenKbGelInstructionObj ret = null;
		final String S_ProcName = "MssCFGelCompiler.compileCounter() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _COUNTER ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _COUNTER );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "counter"

		start = _COUNTER.length();

	//  Skip whitespace

		if( macro.charAt( start ) == ' ' ) {
			start ++;
		}

	//	Everything to the next whitespace is part of the counter name

		counterName = "";
		while( ( start < lenMacro ) && ( ( ch = macro.charAt( start ) ) != ' ' ) ) {
			counterName = counterName + ch;
			start ++;
		}

		if( counterName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed counter directive must specify a counterName. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Skip any intervening whitespace

		if( start < lenMacro ) {
			ch = macro.charAt( start );
			while( ( start < lenMacro ) && (( ch = macro.charAt( start ) ) == ' ' ) ) {
				start ++;
			}
		}

	//	Next is the counter operation: new, increment, decrement, or value

		counterOp = "";
		while( start < lenMacro && ( ch = macro.charAt( start ) ) != ' ' ) {
			counterOp = counterOp + ch;
			start ++;
		}

		if( counterOp.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed counter directive must specify a counterOp. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	The macro should be fully consumed

		if( start < lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed counter directive cannot be followed by additional macro expansions. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Locate the appropriate counter and compile the operation.  All return emtpy strings
	//	except for value.

		counterOpName = counterOp;

		if( _COUNTER_OP_NEW.equals( counterOpName ) ) {
			ICFGenKbGelCounterObj counterObj = new MssCFCounterNew( genEngine );
			ICFGenKbGelCounterEditObj counterEdit = (ICFGenKbGelCounterEditObj)counterObj.beginEdit();
			counterEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			counterEdit.setRequiredContainerGelCache( myGelCache );
			counterEdit.setRequiredCounterName( counterName );
			counterEdit.setRequiredSourceText( macro );
			counterObj = (ICFGenKbGelCounterObj)counterEdit.create();
			counterEdit = null;
			ret = counterObj;
		}
		else if( _COUNTER_OP_INCR.equals( counterOpName ) ) {
			ICFGenKbGelCounterObj counterObj = new MssCFCounterIncrement( genEngine );
			ICFGenKbGelCounterEditObj counterEdit = (ICFGenKbGelCounterEditObj)counterObj.beginEdit();
			counterEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			counterEdit.setRequiredContainerGelCache( myGelCache );
			counterEdit.setRequiredCounterName( counterName );
			counterEdit.setRequiredSourceText( macro );
			counterObj = (ICFGenKbGelCounterObj)counterEdit.create();
			counterEdit = null;
			ret = counterObj;
		}
		else if( _COUNTER_OP_DECR.equals( counterOpName ) ) {
			ICFGenKbGelCounterObj counterObj = new MssCFCounterDecrement( genEngine );
			ICFGenKbGelCounterEditObj counterEdit = (ICFGenKbGelCounterEditObj)counterObj.beginEdit();
			counterEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			counterEdit.setRequiredContainerGelCache( myGelCache );
			counterEdit.setRequiredSourceText( macro );
			counterEdit.setRequiredCounterName( counterName );
			counterObj = (ICFGenKbGelCounterObj)counterEdit.create();
			counterEdit = null;
			ret = counterObj;
		}
		else if( _COUNTER_OP_VALUE.equals( counterOpName ) ) {
			ICFGenKbGelCounterObj counterObj = new MssCFCounterValue( genEngine );
			ICFGenKbGelCounterEditObj counterEdit = (ICFGenKbGelCounterEditObj)counterObj.beginEdit();
			counterEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
			counterEdit.setRequiredContainerGelCache( myGelCache );
			counterEdit.setRequiredSourceText( macro );
			counterEdit.setRequiredCounterName( counterName );
			counterObj = (ICFGenKbGelCounterObj)counterEdit.create();
			counterEdit = null;
			ret = counterObj;
		}
		else {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed counter operation \"" );
			msg.append( counterOpName );
			msg.append( "\" must be one of new, increment, decrement, or value. \"" );
			msg.append( macro );
			msg.append( "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		return( ret );
	}

	protected ICFGenKbGelInstructionObj compileConstrainMax( String macro )
	{
		int start;
		int lenMacro = 0;
		char ch;
		String constrainLimit = null;
		String constrainedValue = null;
		final String S_ProcName = "MssCFGelCompiler.compileConstrainMax() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _CONSTRAIN_MAX ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _CONSTRAIN_MAX );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "constrainMax"

		start = _CONSTRAIN_MAX.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the constraint limit

		constrainLimit = "";
		while( start < lenMacro && ( ch = macro.charAt( start ) ) != ' ' ) {
			constrainLimit = constrainLimit + ch;
			start++;
		}

		if (constrainLimit.length() <= 0) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed constrainMax directive must specify a constrainLimit. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

		String remainingMacro = macro.substring( start );

		ICFGenKbGelConstrainObj constrainObj = new MssCFConstrainMax( genEngine );
		ICFGenKbGelConstrainEditObj constrainEdit = (ICFGenKbGelConstrainEditObj)constrainObj.beginEdit();
		constrainEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		constrainEdit.setRequiredContainerGelCache( myGelCache );
		constrainEdit.setRequiredSourceText( macro );
		constrainObj = (ICFGenKbGelConstrainObj)constrainEdit.create();
		constrainEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro );
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		boolean isDigitString = true;
		int limitLen = constrainLimit.length();
		for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
		{
			char c = constrainLimit.charAt(idxLimit);
			if ((c != '0')
			 && (c != '1')
			 && (c != '2')
			 && (c != '3')
			 && (c != '4')
			 && (c != '5')
			 && (c != '6')
			 && (c != '7')
			 && (c != '8')
			 && (c != '9')
			 && (c != '+')
			 && (c != '-'))
			{
				isDigitString = false;
			}
		}

		constrainEdit = (ICFGenKbGelConstrainEditObj)constrainObj.beginEdit();
		constrainEdit.setOptionalLookupRemainder( remainder );
		if( isDigitString ) {
			constrainEdit.setOptionalHardConstraint( Long.parseLong( constrainLimit ) );
		}
		else {
			constrainEdit.setOptionalConstrainingName( constrainLimit );
		}
		constrainEdit.update();
		constrainEdit = null;

		return( constrainObj );
	}

	protected ICFGenKbGelInstructionObj compileConstrainMin( String macro )
	{
		int start;
		int lenMacro = 0;
		char ch;
		String constrainLimit = null;
		String constrainedValue = null;
		final String S_ProcName = "MssCFGelCompiler.compileConstrainMin() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _CONSTRAIN_MIN ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _CONSTRAIN_MIN );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "constrainMin"

		start = _CONSTRAIN_MIN.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the constraint limit

		constrainLimit = "";
		while( start < lenMacro && ( ch = macro.charAt( start ) ) != ' ' ) {
			constrainLimit = constrainLimit + ch;
			start++;
		}

		if (constrainLimit.length() <= 0) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed constrainMin directive must specify a constrainLimit. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

		String remainingMacro = macro.substring( start );

		ICFGenKbGelConstrainObj constrainObj = new MssCFConstrainMin( genEngine );
		ICFGenKbGelConstrainEditObj constrainEdit = (ICFGenKbGelConstrainEditObj)constrainObj.beginEdit();
		constrainEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		constrainEdit.setRequiredContainerGelCache( myGelCache );
		constrainEdit.setRequiredSourceText( macro );
		constrainObj = (ICFGenKbGelConstrainObj)constrainEdit.create();
		constrainEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro );
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		boolean isDigitString = true;
		int limitLen = constrainLimit.length();
		for (int idxLimit = 0; isDigitString && (idxLimit < limitLen); idxLimit++)
		{
			char c = constrainLimit.charAt(idxLimit);
			if ((c != '0')
			 && (c != '1')
			 && (c != '2')
			 && (c != '3')
			 && (c != '4')
			 && (c != '5')
			 && (c != '6')
			 && (c != '7')
			 && (c != '8')
			 && (c != '9')
			 && (c != '+')
			 && (c != '-'))
			{
				isDigitString = false;
			}
		}

		constrainEdit = (ICFGenKbGelConstrainEditObj)constrainObj.beginEdit();
		constrainEdit.setOptionalLookupRemainder( remainder );
		if( isDigitString ) {
			constrainEdit.setOptionalHardConstraint( Long.parseLong( constrainLimit ) );
		}
		else {
			constrainEdit.setOptionalConstrainingName( constrainLimit );
		}
		constrainEdit.update();
		constrainEdit = null;

		return( constrainObj );
	}


	/**
	 *	Macros that start with "pop " are special directives
	 *	which temporarily unwind the expansion context n levels.
	 *
	 *	@param		macro		String
	 *	@return	String		The result of expanding the macro.
	 */
	protected ICFGenKbGelInstructionObj compilePop( String macro )
	{
		int					start;
		int					lenMacro = 0;
		char				ch;
		String				goalTypeName = null;
		String				remainingMacro = null;
		ICFGenKbGelInstructionObj ret = null;
		final String S_ProcName = "MssCFGelCompiler.compilePop() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _POP ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _POP );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "pop"

		start = _POP.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the goal class name

		goalTypeName = "";
		if( start < lenMacro ) {
			while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
				goalTypeName = goalTypeName + ch;
				start ++;
			}
		}

		if( goalTypeName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed pop directive must specify number of contexts to pop. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start) ) == ' ' ) ) {
			start = start + 1;
		}

	//	Whatever remains of the macro will be passed on to the goal context

		if( start >= lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed pop directive must provide a macro body to be expanded. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		remainingMacro = macro.substring( start );

		ICFGenKbGelPopObj popObj = new MssCFPop( genEngine ); 
		ICFGenKbGelPopEditObj popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		popEdit.setRequiredContainerGelCache( myGelCache );
		popEdit.setRequiredGoalTypeName( goalTypeName );
		popEdit.setRequiredSourceText( macro );
		popObj = (ICFGenKbGelPopObj)popEdit.create();
		popEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro);
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setOptionalLookupRemainder( remainder );
		popEdit.update();
		popEdit = null;

		ret = popObj;

		return( ret );
	}

	/**
	 *	Macros that start with "popto " are special directives
	 *	which temporarily unwind the expansion context until
	 *	the generation definition is an instance of the
	 *	parameter class.  If no such definition is found in
	 *	the stack, a warning is logged and the macro is
	 *	considered to be in error.
	 *
	 *	@param		macro		String
	 *	@return	String		The result of expanding the macro.
	 */
	protected ICFGenKbGelInstructionObj compilePopTo( String macro )
	{
		int					start;
		int					lenMacro = 0;
		char				ch;
		String				goalTypeName = null;
		String				remainingMacro = null;
		ICFGenKbGelInstructionObj ret = null;
		final String S_ProcName = "MssCFGelCompiler.compilePopTo() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _POPTO ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _POPTO );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "popto"

		start = _POPTO.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the goal class name

		goalTypeName = "";
		if( start < lenMacro ) {
			while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
				goalTypeName = goalTypeName + ch;
				start ++;
			}
		}

		if( goalTypeName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed popto directive must specify goalTypeName. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		goalTypeName = getGenEngine().fixGenDefName( goalTypeName );

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start) ) == ' ' ) ) {
			start = start + 1;
		}

	//	Whatever remains of the macro will be passed on to the goal context

		if( start >= lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed popto directive must provide a macro body to be expanded. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		remainingMacro = macro.substring( start );

		ICFGenKbGelPopObj popObj = new MssCFPopTo( genEngine ); 
		ICFGenKbGelPopEditObj popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		popEdit.setRequiredContainerGelCache( myGelCache );
		popEdit.setRequiredGoalTypeName( goalTypeName );
		popEdit.setRequiredSourceText( macro );
		popObj = (ICFGenKbGelPopObj)popEdit.create();
		popEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro);
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setOptionalLookupRemainder( remainder );
		popEdit.update();
		popEdit = null;

		ret = popObj;

		return( ret );
	}

	protected ICFGenKbGelInstructionObj compilePopTop( String macro )
	{
		int					start;
		int					lenMacro = 0;
		char				ch;
		String				goalTypeName = null;
		String				remainingMacro = null;
		ICFGenKbGelInstructionObj ret = null;
		final String S_ProcName = "MssCFGelCompiler.compilePopTop() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _POPTOP ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _POPTOP );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "poptop"

		start = _POPTOP.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the goal class name

		goalTypeName = "";
		if( start < lenMacro ) {
			while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
				goalTypeName = goalTypeName + ch;
				start ++;
			}
		}

		if( goalTypeName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed poptop directive must specify goalTypeName. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		goalTypeName = getGenEngine().fixGenDefName( goalTypeName );

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start) ) == ' ' ) ) {
			start = start + 1;
		}

	//	Whatever remains of the macro will be passed on to the goal context

		if( start >= lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed poptop directive must provide a macro body to be expanded. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		remainingMacro = macro.substring( start );

		ICFGenKbGelPopObj popObj = new MssCFPopTop( genEngine ); 
		ICFGenKbGelPopEditObj popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		popEdit.setRequiredContainerGelCache( myGelCache );
		popEdit.setRequiredGoalTypeName( goalTypeName );
		popEdit.setRequiredSourceText( macro );
		popObj = (ICFGenKbGelPopObj)popEdit.create();
		popEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro);
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setOptionalLookupRemainder( remainder );
		popEdit.update();
		popEdit = null;

		ret = popObj;

		return( ret );
	}

	protected ICFGenKbGelInstructionObj compilePopOneFromTop( String macro )
	{
		int					start;
		int					lenMacro = 0;
		char				ch;
		String				goalTypeName = null;
		String				remainingMacro = null;
		ICFGenKbGelInstructionObj ret = null;
		final String S_ProcName = "MssCFGelCompiler.compilePopOneFromTop() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _POPONEFROMTOP ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _POPONEFROMTOP );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "poponefromtop"

		start = _POPONEFROMTOP.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the goal class name

		goalTypeName = "";
		if( start < lenMacro ) {
			while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
				goalTypeName = goalTypeName + ch;
				start ++;
			}
		}

		if( goalTypeName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed poponefromtop directive must specify goalTypeName. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		goalTypeName = getGenEngine().fixGenDefName( goalTypeName );

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start) ) == ' ' ) ) {
			start = start + 1;
		}

	//	Whatever remains of the macro will be passed on to the goal context

		if( start >= lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed poponefromtop directive must provide a macro body to be expanded. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		remainingMacro = macro.substring( start );

		ICFGenKbGelPopObj popObj = new MssCFPopOneFromTop( genEngine ); 
		ICFGenKbGelPopEditObj popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		popEdit.setRequiredContainerGelCache( myGelCache );
		popEdit.setRequiredGoalTypeName( goalTypeName );
		popEdit.setRequiredSourceText( macro );
		popObj = (ICFGenKbGelPopObj)popEdit.create();
		popEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro);
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		popEdit = (ICFGenKbGelPopEditObj)popObj.beginEdit();
		popEdit.setOptionalLookupRemainder( remainder );
		popEdit.update();
		popEdit = null;

		ret = popObj;

		return( ret );
	}



	/**
	 *	Macros that start with "reference " are special directives
	 *	which create a temporary call stack for expanding item
	 *	returned by the reference .
	 *
	 *	@param	macro		String
	 *	@return	String		The result of expanding the macro.
	 */
	protected ICFGenKbGelInstructionObj compileReference( String macro )
	{
		int						start;
		int						lenMacro = 0;
		char					ch;
		String					refName = null;
		String					remainingMacro = null;
		ICFGenKbGelInstructionObj ret = null;

		final String S_ProcName = "MssCFGelCompiler.compileReference() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _REFERENCE ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _REFERENCE );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "reference"

		start = _REFERENCE.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the name of the
	//	reference method to be invoked.

		refName = "";
		while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
			refName = refName + ch;
			start ++;
		}

		if( refName.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed reference directive must specify a refName. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Whatever remains of the macro will be passed on to the injected expansion stack

		if( start >= lenMacro ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed reference directive must provide a macro body to be expanded. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		remainingMacro = macro.substring( start );

		ICFGenKbGelReferenceObj referenceObj = genEngine.getGelReferenceTableObj().newInstance(); 
		ICFGenKbGelReferenceEditObj referenceEdit = (ICFGenKbGelReferenceEditObj)referenceObj.beginEdit();
		referenceEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		referenceEdit.setRequiredContainerGelCache( myGelCache );
		referenceEdit.setRequiredReferenceName( refName );
		referenceEdit.setRequiredSourceText( macro );
		referenceObj = (ICFGenKbGelReferenceObj)referenceEdit.create();
		referenceEdit = null;

		ICFGenKbGelInstructionObj remainder = compileMacro( remainingMacro);
		if( remainder == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		referenceEdit = (ICFGenKbGelReferenceEditObj)referenceObj.beginEdit();
		referenceEdit.setOptionalLookupRemainder( remainder );
		referenceEdit.update();
		referenceEdit = null;

		ret = referenceObj;

		return( ret );
	}

	/**
	 *	The macro language supports a prefixline directive.
	 *	The syntax is:
	 *
	 *		prefixline PrefixMacro BodyMacro
	 */
	protected ICFGenKbGelInstructionObj compilePrefixLine( String macro )
	{
		int start;
		int lenMacro = 0;
		char ch;

		String prefix = null;
		String prefixMacro = null;
		String body = null;
		String bodyMacro = null;
		ICFGenKbGelInstructionObj ret = null;

		final String S_ProcName = "MssCFGelCompiler.compilePrefixLine() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _PREFIX_LINE ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _PREFIX_LINE );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "prefixline"

		start = _PREFIX_LINE.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the valueMacro name

		prefixMacro = "";
		while( start < lenMacro && ( ch = macro.charAt( start )) != ' ' ) {
			prefixMacro = prefixMacro + ch;
			start ++;
		}

		if( prefixMacro.length() <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed prefixline directive must specify a prefixMacro. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

		// Everything to the next whitespace or $ is bodyMacro name

		bodyMacro = macro.substring( start );
		if( ( bodyMacro == null ) || ( bodyMacro.length() == 0) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed prefixline directive must specify a remainder to expand. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		ICFGenKbGelPrefixLineObj prefixLineObj = genEngine.getGelPrefixLineTableObj().newInstance(); 
		ICFGenKbGelPrefixLineEditObj prefixLineEdit = (ICFGenKbGelPrefixLineEditObj)prefixLineObj.beginEdit();
		prefixLineEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		prefixLineEdit.setRequiredContainerGelCache( myGelCache );
		prefixLineEdit.setRequiredSourceText( macro );
		prefixLineEdit.setRequiredPrefixName( prefixMacro );
		prefixLineObj = (ICFGenKbGelPrefixLineObj)prefixLineEdit.create();
		prefixLineEdit = null;

		ICFGenKbGelInstructionObj gelBody = compileMacro( bodyMacro);
		if( gelBody == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Remainder of macro did not compile to an instruction. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return (null);
		}

		prefixLineEdit = (ICFGenKbGelPrefixLineEditObj)prefixLineObj.beginEdit();
		prefixLineEdit.setOptionalLookupRemainder( gelBody );
		prefixLineEdit.update();
		prefixLineEdit = null;

		return( prefixLineObj );
	}


	/**
	 *	The macro language supports branching through a switch directive.
	 *	The syntax is:
	 *
	 *		switch ValMacro Key1 Macro1, Key2 Macro2, default MacroDefault
	 *
	 *	There are two special keys as well:
	 *
	 *		nil
	 *		empty
	 *
	 *	The ValMacro is invoked to get a String result.  Failure of the macro
	 *	could produce a null value (special key `nil"), or this could mean
	 *	that the definition has no value to respond with.  The macro could
	 *	also return an empty string, which can"t be typed in using macro
	 *	syntax.  If neither nil nor empty is returned, the KeyN strings are
	 *	compared in order.  Finally the MacroDefault is invoked.  At worst,
	 *	a null is returned by the evaluation.
	 *
	 *	@param	body		String
	 *	@return	String		The result of expanding the body.
	 */
	protected ICFGenKbGelInstructionObj compileSwitch( String macro )
	{
		int								start;
		int								lenMacro = 0;
		char							ch;
		String							value = null;
		String							valueMacro = null;
		String							keyValue = null;
		String							keyMacro = null;
		String							nilMacro = null;
		String							emptyMacro = null;
		String							defaultMacro = null;
		ICFGenKbGelInstructionObj 	ret = null;

		final String S_ProcName = "MssCFGelCompiler.compileSwitch() ";
		final String S_MsgEmptyNotAllowedForMacro = "Empty value not allowed for macro";

	//	Validate parameters

		lenMacro = ( macro != null ) ? macro.length() : 0;
		if( lenMacro <= 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() " );
			msg.append( S_MsgEmptyNotAllowedForMacro );
			msg.append( " \"" );
			msg.append( (( macro != null ) ? macro : "" ) + "\" is invalid" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		if( ! macro.startsWith( _SWITCH ) ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Method should only be invoked for " );
			msg.append( _SWITCH );
			msg.append( " macros." );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

	//	Set the cursor past "switch"

		start = _SWITCH.length();

	//	Skip any intervening whitespace

		while ( ( start < lenMacro ) &&	( ( ch = macro.charAt(start)) == ' ' ) ) {
			start = start + 1;
		}

	//	Everything to the next whitespace is part of the valueMacro name

		valueMacro = "";
		while( ( start < lenMacro ) && ( ch = macro.charAt( start )) != ' ' ) {
			valueMacro = valueMacro + ch;
			start ++;
		}

		if( valueMacro.length() == 0 ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed switch directive must specify a valueMacro. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		ICFGenKbGelSwitchObj switchObj = genEngine.getGelSwitchTableObj().newInstance(); 
		ICFGenKbGelSwitchEditObj switchEdit = (ICFGenKbGelSwitchEditObj)switchObj.beginEdit();
		switchEdit.setRequiredOwnerTenant( myGelCache.getRequiredOwnerTenant() );
		switchEdit.setRequiredContainerGelCache( myGelCache );
		switchEdit.setRequiredSourceText( macro );
		switchEdit.setRequiredValueExpansion( valueMacro );
		switchEdit.setRequiredDefaultExpansion( "PlaceHolder" );
		switchObj = (ICFGenKbGelSwitchObj)switchEdit.create();
		switchEdit = null;

	//	LOOP until done parsing switch limbs

		keyValue = "";
		keyMacro = "";

		while( start < lenMacro ) {

	//		Skip whitespace

			while ( ( start < lenMacro ) && ( ( ch = macro.charAt(start)) == ' ' ) ) {
				start = start + 1;
			}

	//		Check for trailing whitespace

			if( start >= lenMacro ) {
				break;
			}

	//		Reset keyValue and keyMacro

			keyValue = "";
			keyMacro = "";

	//		Next word is the keyValue

			while( ( start < lenMacro ) && ( ch = macro.charAt( start )) != ' ' ) {
				keyValue = keyValue + ch;
				start ++;
				if( start >= lenMacro ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Malformed switch directive must specify a keyValue for each case limb. \"" );
					msg.append( macro );
					msg.append( "\" is invalid\n" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}

	//		Skip whitespace

			while( ( ch = macro.charAt( start )) == ' ' ) {
				start ++;
				if( start >= lenMacro ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Malformed switch directive must specify a keyMacro for each case limb key \"" );
					msg.append( keyValue );
					msg.append( "\". \"" );
					msg.append( macro );
					msg.append( "\" is invalid\n" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
			}

	//		Next word is the keyMacro

			keyMacro = "";
			while( start < lenMacro && ( ch = macro.charAt( start ) ) != ' ' ) {
				keyMacro = keyMacro + ch;
				start ++;
			}

	//		Check for the special case-limb keys nil, empty, and default

			if( _SWITCH_NIL.equals( keyValue ) ) {
				if( nilMacro != null ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Malformed switch directive specifies more than one \"" );
					msg.append( _SWITCH_NIL );
					msg.append( "\" limb. \"" );
					msg.append( macro );
					msg.append( "\" is invalid\n" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}

				nilMacro = keyMacro;

				switchEdit = (ICFGenKbGelSwitchEditObj)switchObj.beginEdit();
				switchEdit.setOptionalNilExpansion( nilMacro );
				switchEdit.update();
				switchEdit = null;
			}
			else if( _SWITCH_EMPTY.equals( keyValue ) ) {
				if( emptyMacro != null ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Malformed switch directive specifies more than one \"" );
					msg.append( _SWITCH_EMPTY );
					msg.append( "\" limb. \"" );
					msg.append( macro );
					msg.append( "\" is invalid\n" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
				emptyMacro = keyMacro;

				switchEdit = (ICFGenKbGelSwitchEditObj)switchObj.beginEdit();
				switchEdit.setOptionalEmptyExpansion( emptyMacro );
				switchEdit.update();
				switchEdit = null;
			}
			else if( _SWITCH_DEFAULT.equals( keyValue ) ) {
				if( defaultMacro != null ) {
					StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
					msg.append( '.' );
					msg.append( S_ProcName );
					msg.append( "() Malformed switch directive specifies more than one \"" );
					msg.append( _SWITCH_DEFAULT );
					msg.append( "\" limb. \"" );
					msg.append( macro );
					msg.append( "\" is invalid\n" );
					setCompileError();
					getCompileLog().message( msg.toString() );
					return( null );
				}
				defaultMacro = keyMacro;

				switchEdit = (ICFGenKbGelSwitchEditObj)switchObj.beginEdit();
				switchEdit.setRequiredDefaultExpansion( defaultMacro );
				switchEdit.update();
				switchEdit = null;
			}
			else {
				ICFGenKbGelSwitchLimbObj switchLimbObj = genEngine.getGelSwitchLimbTableObj().newInstance(); 
				ICFGenKbGelSwitchLimbEditObj switchLimbEdit = (ICFGenKbGelSwitchLimbEditObj)switchLimbObj.beginEdit();
				switchLimbEdit.setRequiredParentSwitch( switchObj );
				switchLimbEdit.getBuff().setRequiredLimbName( keyValue );
				switchLimbEdit.setRequiredLimbExpansion( keyMacro );
				switchLimbObj = (ICFGenKbGelSwitchLimbObj)switchLimbEdit.create();
				switchLimbEdit = null;
			}
		}

	//	The default limb is mandatory

		if( defaultMacro == null ) {
			StringBuffer msg = new StringBuffer( getClass().getSimpleName() );
			msg.append( '.' );
			msg.append( S_ProcName );
			msg.append( "() Malformed switch directive specifies must specify a \"" );
			msg.append( _SWITCH_DEFAULT );
			msg.append( "\" limb. \"" );
			msg.append( macro );
			msg.append( "\" is invalid\n" );
			setCompileError();
			getCompileLog().message( msg.toString() );
			return( null );
		}

		return( switchObj );
	}
}
