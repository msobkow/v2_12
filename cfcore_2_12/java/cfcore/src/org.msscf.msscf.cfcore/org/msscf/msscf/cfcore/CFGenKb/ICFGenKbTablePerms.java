// Description: Java 11 CFGenKb Table Permissions Interface.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKb;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbTablePerms
{
	/**
	 *	Is the session allowed to create Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Cluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create DefClass instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDefClass( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read DefClass instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDefClass( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update DefClass instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDefClass( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DefClass instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDefClass( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelBoilerplate instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelBoilerplate( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelBoilerplate instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelBoilerplate( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelBoilerplate instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelBoilerplate( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelBoilerplate instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelBoilerplate( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelBuiltin instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelBuiltin( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelBuiltin instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelBuiltin( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelBuiltin instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelBuiltin( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelBuiltin instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelBuiltin( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelCache instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelCache( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelCache instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelCache( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelCache instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelCache( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelCache instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelCache( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelCall instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelCall( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelCall instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelCall( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelCall instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelCall( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelCall instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelCall( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelConstrain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelConstrain( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelConstrain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelConstrain( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelConstrain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelConstrain( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelConstrain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelConstrain( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelCounter instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelCounter( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelCounter instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelCounter( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelCounter instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelCounter( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelCounter instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelCounter( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelError instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelError( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelError instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelError( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelError instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelError( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelError instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelError( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelExecutable instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelExecutable( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelExecutable instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelExecutable( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelExecutable instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelExecutable( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelExecutable instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelExecutable( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelExpansion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelExpansion( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelExpansion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelExpansion( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelExpansion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelExpansion( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelExpansion instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelExpansion( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelInstruction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelInstruction( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelInstruction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelInstruction( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelInstruction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelInstruction( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelInstruction instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelInstruction( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelModifier instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelModifier( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelModifier instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelModifier( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelModifier instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelModifier( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelModifier instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelModifier( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelPop instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelPop( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelPop instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelPop( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelPop instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelPop( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelPop instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelPop( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelPrefixLine instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelPrefixLine( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelPrefixLine instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelPrefixLine( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelPrefixLine instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelPrefixLine( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelPrefixLine instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelPrefixLine( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelSequence instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelSequence( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelSequence instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelSequence( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelSequence instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelSequence( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelSequence instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelSequence( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelSpread instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelSpread( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelSpread instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelSpread( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelSpread instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelSpread( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelSpread instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelSpread( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelSwitch instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelSwitch( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelSwitch instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelSwitch( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelSwitch instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelSwitch( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelSwitch instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelSwitch( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GelSwitchLimb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGelSwitchLimb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GelSwitchLimb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGelSwitchLimb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GelSwitchLimb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGelSwitchLimb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GelSwitchLimb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGelSwitchLimb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenBind instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenBind( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenBind instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenBind( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenBind instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenBind( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenBind instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenBind( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenFile instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenFile( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenFile instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenFile( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenFile instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenFile( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenFile instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenFile( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenItem instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenItem( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenItem instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenItem( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenItem instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenItem( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenItem instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenItem( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenIterator instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenIterator( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenReference instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenReference( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenRule instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenRule( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenRule instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenRule( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenRule instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenRule( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenRule instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenRule( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create GenTrunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateGenTrunc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read GenTrunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadGenTrunc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update GenTrunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateGenTrunc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete GenTrunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteGenTrunc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateHostNode( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadHostNode( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateHostNode( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete HostNode instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteHostNode( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create RuleCart instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRuleCart( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read RuleCart instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRuleCart( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update RuleCart instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRuleCart( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RuleCart instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRuleCart( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create RuleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRuleType( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read RuleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRuleType( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update RuleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRuleType( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RuleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRuleType( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecApp( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecApp( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecApp( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecApp instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecApp( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecDevice( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecDevice( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecDevice( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecDevice instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecDevice( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGroupForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGroupForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGroupForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGroupForm instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGroupForm( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecSession( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecSession( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecSession( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecSession instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecSession( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSecUser( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSecUser( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSecUser( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SecUser instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSecUser( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSysCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSysCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSysCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SysCluster instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSysCluster( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGroup instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGroup( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGrpInc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGrpInc( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create TSecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read TSecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update TSecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TSecGrpMemb instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTSecGrpMemb( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTenant( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTenant( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTenant( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tenant instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTenant( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tool instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTool( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tool instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTool( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tool instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTool( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tool instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTool( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to create ToolSet instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateToolSet( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to read ToolSet instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadToolSet( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to update ToolSet instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateToolSet( CFGenKbAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ToolSet instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteToolSet( CFGenKbAuthorization Authorization );
}
