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

	class CFLibConsoleMessageLog : public virtual ICFLibMessageLog {
	
	private:
	
		/**
		 *	What is the current indent level for logging?
		 */
		int ndnt = 0;

	public:

		/**
		 *	Default constructor.
		 */
		CFLibConsoleMessageLog();

		/**
		 *	Destructor
		 */
		virtual ~CFLibConsoleMessageLog();

		/**
		 *	Get the current log indent level.
		 */
		virtual int getMessageLogIndent() const;

		/**
		 *	Indent the logging messages another level
		 */
		virtual void dedent();

		/**
		 *	Indent the logging messages another level
		 */
		virtual void indent();

		/**
		 *	Log a message to the console.
		 */
		virtual void message( const std::string& msg );

		/**
		 *	Open the specified file for logging.
		 *	<p>
		 *	Does nothing; console logs don't write to files.
		 */
		virtual void openLogFile( const std::string& fileName );

		/**
		 *	Close the log file.
		 *	<p>
		 *	Does nothing; console logs don't write to files.
		 */
		virtual void closeLogFile();
	};
}
