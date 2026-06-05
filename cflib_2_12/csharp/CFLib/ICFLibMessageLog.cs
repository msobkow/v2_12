/*
 *  MSS Code Factory CFLib 2.11
 *
 *	Copyright (c) 2019 Mark Stephen Sobkow
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *		http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

using System;
using System.Globalization;
using System.IO;

namespace CFLib
{
	public interface ICFLibMessageLog {

		/**
		 *	Get an PrintStream that wraps this log
		 */
		StreamWriter getPrintStream();
		
		/**
		 *	Get the current log indent level.
		 */
		int getMessageLogIndent();
		
		/**
		 *	Increase the log indentation.
		 */
		void indent();
		
		/**
		 *	Decrease the log indentation.
		 */
		void dedent();
		
		/**
		 *	Log an application message.
		 */
		void message( String msg );
		
		/**
		 *	Open the specified file for logging
		 *
		 *	@param	fileName	The name of the file to open as a log.
		 */
		void openLogFile( String fileName );
		
		/**
		 *	Close the log file.
		 */
		void closeLogFile();
		
		/**
		 *	Get any backlogged text.
		 */
		String getBacklog();
	}
}
