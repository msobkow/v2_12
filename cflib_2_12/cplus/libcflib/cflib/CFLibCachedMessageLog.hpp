#pragma once

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

#include <uuid/uuid.h>
#include <mpfr.h>

#include <array>
#include <cassert>
#include <cstddef>
#include <chrono>
#include <ctime>
#include <iostream>
#include <list>
#include <string>

#include <cflib/ICFLibMessageLog.hpp>

namespace cflib {

	class CFLibCachedMessageLog : public virtual ICFLibMessageLog {
	
	private:
		std::string cacheContents;
		int ndnt = 1;

	public:

		/**
		 *	Default constructor.
		 */
		CFLibCachedMessageLog();

		/**
		 *	Destructor
		 */
		virtual ~CFLibCachedMessageLog();

		/**
		 *	Clear the cache.
		 *	<p>
		 *	Messages are appended to the cache buffer , not logged
		 *	to a file.  After collecting messages with a cache log,
		 *	you can use getCacheContents() to retrieve the messages
		 *	that have been added to the cache buffer since the last
		 *	time clearCache() was invoked..
		 */
		virtual void clearCache();

		/**
		 *	Retrieve the contents of the cache.
		 *	Each message logged is newline-terminated as if it were to
		 *	be immediately written to the log.
		 */
		virtual const std::string& getCacheContents() const;

		/**
		 *	Get the current log indent level.
		 */
		virtual int getMessageLogIndent() const;

		/**
		 *	Decrease the indent of the logged messages another level.
		 *	<p>
		 *	The cached message log enforces a minimum indent of 1.
		 */
		virtual void dedent();

		/**
		 *	Indent the logging messages another level.
		 */
		virtual void indent();

		/**
		 *	Log a message to the cache.
		 *	<p>
		 *	If msg is not newline-terminated, one will be added before
		 *	appending it to the cache buffer.  No timestamp information
		 *	is inserted.
		 */
		virtual void message( const std::string& msg );

		/**
		 *	Open the specified file for logging.
		 *	<p>
		 *	This dummy function does nothing with the file name.
		 *	Cached message logs don't write directly to files.
		 */
		virtual void openLogFile( const std::string& fileName );

		/**
		 *	Close the log file.
		 *	<p>
		 *	Does absolutely nothing.  Cached message logs don't write
		 *	directlty to files.
		 */
		virtual void closeLogFile();
	};
}
