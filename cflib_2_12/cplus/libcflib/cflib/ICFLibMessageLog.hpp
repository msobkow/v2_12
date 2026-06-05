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
#include <list>
#include <string>

#include <cflib/CFLibRuntimeException.hpp>
#include <cflib/CFLibArgumentException.hpp>

namespace cflib {

	/**
	 *	MessageLog implementations support indented application messaging.
	 *	A given log implementation might also implement the ErrorLog interface,
	 *	allowing it to display an interleaved mix of application and error
	 *	messages.
	 *	<p>
	 *	All methods of the interface are expected to be synchronized.
	 */
	class ICFLibMessageLog {
	
	public:

		ICFLibMessageLog();
		virtual ~ICFLibMessageLog();

		/**
		 *	Get the current log indent level.
		 */
		virtual int getMessageLogIndent() const = 0;

		/**
		 *	Increase the log indentation.
		 */
		virtual void indent() = 0;

		/**
		 *	Decrease the log indentation.
		 */
		virtual void dedent() = 0;

		/**
		 *	Log an application message.
		 */
		virtual void message( const std::string& msg ) = 0;

		/**
		 *	Open the specified file for logging
		 *
		 *	@param	fileName	The name of the file to open as a log.
		 */
		virtual void openLogFile( const std::string& fileName ) = 0;

		/**
		 *	Close the log file.
		 */
		virtual void closeLogFile() = 0;
	};
}
