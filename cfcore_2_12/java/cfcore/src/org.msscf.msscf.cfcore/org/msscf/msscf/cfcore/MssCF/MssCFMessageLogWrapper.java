/*
 *	MSS Code Factory CFCore 2.12
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

package org.msscf.msscf.cfcore.MssCF;

import java.io.*;
import java.util.*;

import org.msscf.msscf.cflib.CFLib.ICFLibMessageLog;

/**
 *	Implement the OmfMessageLogInterface over a Log4J Logger.
 */
public class MssCFMessageLogWrapper
implements ICFLibMessageLog {

	private StringBuffer backlog = new StringBuffer();

	/**
	 *	Handle for the current file output stream.
	 */
	private PrintStream	logFile = null;

	/**
	 *	What is the current indent level for logging?
	 */
	private int		   	indent = 0;

	/**
	 *	Default constructor.
	 */
	public MssCFMessageLogWrapper() {
		indent = 0;
	}

	/**
	 *	Get the current log indent level.
	 */
	public int getMessageLogIndent() {
		return( indent );
	}

	/**
	 *	Indent the logging messages another level
	 */
	public synchronized void dedent() {
		if( indent > 0 ) {
			indent --;
		}
		else {
			indent = 0;
		}
	}

	/**
	 *	Indent the logging messages another level
	 */
	public synchronized void indent() {
		indent ++;
	}

	/**
	 *	Get an PrintStream that wraps this log
	 */
	public PrintStream getPrintStream() {
		return( logFile );
	}

	/**
	 *	Log a message
	 *
	 *	@param		msg		String
	 */
	public synchronized void message( String msg ) {

		if( msg == null ) {
			return;
		}

		StringBuffer buff = new StringBuffer();

		Calendar cal = Calendar.getInstance();
		String stamp = String.format( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL ", cal );
		buff.append( stamp );

		int			i;
		for( i = 0; i < indent; i ++ ) {
			buff.append( "\t" );
		}
		buff.append( msg );
		if( ! msg.endsWith( "\n" ) ) {
			buff.append( "\n" );
		}

		boolean wroteSomewhere = false;

		if( backlog != null ) {
			backlog.append( buff.toString() );
		}

		if( logFile != null ) {
			if( backlog != null ) {
				if( backlog.length() > 0 ) {
					logFile.append( backlog.toString() );
				}
				backlog = null;
			}
			logFile.append( buff.toString() );
			logFile.flush();
		}

		if( ! wroteSomewhere ) {
			System.out.append( buff.toString() );
			System.out.flush();
		}
	}

	public String getBacklog() {
		String retval;
		if( backlog != null ) {
			retval = backlog.toString();
		}
		else {
			retval = null;
		}
		return( retval );
	}
//	OLD API's that need to go away

	/**
	 *	Open the specified file for logging
	 *
	 *	@param	fileName	The name of the file to open as a log.
	 */
	public void openLogFile( String fileName )
		throws FileNotFoundException
	{
		assert ( fileName != null ) && ( fileName.length() > 0 ) : "File name must be specified";
		assert logFile == null : "Log file is already open";
		logFile = new PrintStream( fileName );
	}

	/**
	 *	Close the log file.
	 */
	public void closeLogFile() {
		if( logFile != null ) {
			PrintStream old = logFile;
			logFile = null;

			old.flush();
			old.close();
		}
	}
}
