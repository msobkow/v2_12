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
#include <cflib/CFLibCachedMessageLog.hpp>

namespace cflib {

	CFLibCachedMessageLog::~CFLibCachedMessageLog() {
	}

	CFLibCachedMessageLog::CFLibCachedMessageLog() {
		ndnt = 1;
	}

	void CFLibCachedMessageLog::clearCache() {
		static const std::string S_Empty( "" );
		cacheContents = S_Empty;
	}

	const std::string& CFLibCachedMessageLog::getCacheContents() const {
		return( cacheContents );
	}

	int CFLibCachedMessageLog::getMessageLogIndent() const {
		return( ndnt );
	}

	void CFLibCachedMessageLog::dedent() {
		if( ndnt > 1 ) {
			ndnt --;
		}
		else {
			ndnt = 1;
		}
	}

	void CFLibCachedMessageLog::indent() {
		ndnt ++;
	}

	void CFLibCachedMessageLog::message( const std::string& msg ) {
		int i;
		for( i = (( cacheContents.empty() ) ? 1 : 0 ); i < ndnt; i ++ ) {
			cacheContents.push_back( '\t' );
		}
		cacheContents.append( msg );
		if( cacheContents.back() != '\n' ) {
			cacheContents.push_back( '\n' );
		}
	}

	void CFLibCachedMessageLog::openLogFile( const std::string& fileName ) {
		// Do-nothing stub; cached message logs don't write to files
	}

	void CFLibCachedMessageLog::closeLogFile() {
		// Do-nothing stub; cached message logs don't write to files
	}
}
