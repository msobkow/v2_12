/*
 *  MSS Code Factory CFLib 2.12
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

#include <iostream>
#include <iomanip>
#include <sstream>

#include <cflib/CFLib.hpp>
#include <cflib/ICFLibMessageLog.hpp>
#include <cflib/CFLibConsoleMessageLog.hpp>

namespace cflib {

	CFLibConsoleMessageLog::~CFLibConsoleMessageLog() {
	}

	/**
	 *	Default constructor.
	 */
	CFLibConsoleMessageLog::CFLibConsoleMessageLog() {
		ndnt = 0;
	}

	/**
	 *	Get the current log indent level.
	 */
	int CFLibConsoleMessageLog::getMessageLogIndent() const {
		return( ndnt );
	}

	/**
	 *	Indent the logging messages another level
	 */
	void CFLibConsoleMessageLog::dedent() {
		if( ndnt > 0 ) {
			ndnt --;
		}
		else {
			ndnt = 0;
		}
	}

	/**
	 *	Indent the logging messages another level
	 */
	void CFLibConsoleMessageLog::indent() {
		ndnt ++;
	}

	void CFLibConsoleMessageLog::message( const std::string& msg ) {

		const static std::string S_TAB( "\t" );
		const static std::string S_NEWLINE( "\n" );

		std::string buff;

		time_t systime;
		time( &systime );
		struct tm* tms = gmtime( &systime );
		char fmt[32] = { 0 };
		snprintf( &fmt[0], 32, "%04ld-%02ld-%02ld %02ld:%02ld:%02ld ",
			(long)( tms->tm_year + 1900 ), (long)( tms->tm_mon + 1 ), (long)( tms->tm_mday ),
			(long)(tms->tm_hour), (long)(tms->tm_min), (long)(tms->tm_sec) );
		buff.append( fmt );

		int i;
		for( i = 0; i < ndnt; i ++ ) {
			buff.append( S_TAB );
		}
		buff.append( msg );
		std::string::size_type msglen = msg.length();
		if( msglen > 0 ) {
			if( msg[ msglen - 1 ] != S_NEWLINE[ 0 ] ) {
				buff.append( S_NEWLINE );
			}
		}

		std::cout << buff;
	}

	void CFLibConsoleMessageLog::openLogFile( const std::string& fileName ) {
		// Stub function.  Console wrappers don't write to files.
	}

	void CFLibConsoleMessageLog::closeLogFile() {
		// Stub function.  Console wrappers don't write to files.
	}
}
