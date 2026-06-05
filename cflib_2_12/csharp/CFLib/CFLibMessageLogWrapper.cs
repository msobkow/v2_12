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
using System.Diagnostics;
using System.Globalization;
using System.IO;
using System.Text;

namespace CFLib
{
    public class CFLibMessageLogWrapper : ICFLibMessageLog {
    
        private StringBuilder backlog = new StringBuilder();
        public String Backlog
        {
            get
            {
                if (backlog == null)
                {
                    return (null);
                }
                else
                {
                    return (backlog.ToString());
                }
            }
        }

        public String getBacklog()
        {
            if( backlog == null )
            {
                return (null);
            }
            else
            {
                return (backlog.ToString());
            }
        }

        /**
		 *	Handle for the current file output stream.
		 */
        private StreamWriter logFile = null;

        /**
		 *	What is the current indent level for logging?
		 */
        private int messageLogIndent { get; set; } = 0;
        public int MessageLogIndent
        {
            get
            {
                return( messageLogIndent );
            }
        }
		
        public int getMessageLogIndent()
        {
            return (messageLogIndent);
        }

		/**
		 *	Default constructor.
		 */
		public CFLibMessageLogWrapper() {
		}
		
		/**
		 *	Indent the logging messages another level
		 */
		public void dedent() {
			if( messageLogIndent > 0 ) {
				messageLogIndent --;
			}
			else {
				messageLogIndent = 0;
			}
		}
		
		/**
		 *	Indent the logging messages another level
		 */
		public void indent() {
			messageLogIndent ++;
		}

		/**
		 *	Get an PrintStream that wraps this log
		 */
		public StreamWriter getPrintStream() {
			return( logFile );
		}
		
		/**
		 *	Log a message
		 *
		 *	@param		msg		String
		 */
		public void message( String msg ) {

			if( msg == null ) {
				return;
			}

            StringBuilder buff = new StringBuilder();

			DateTime cal = DateTime.Now;
			String stamp = String.Format( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL ", cal );
			buff.Append( stamp );

			int			i;
			for( i = 0; i < messageLogIndent; i ++ ) {
				buff.Append( "\t" );
			}
			buff.Append( msg );
			if( ! msg.EndsWith( "\n" ) ) {
				buff.Append( "\n" );
			}

			Boolean wroteSomewhere = false;

			if( backlog != null ) {
				backlog.Append( buff );
			}

			if( logFile != null ) {
				if( backlog != null ) {
					if( backlog.Length > 0 ) {
						logFile.Write( backlog.ToString() );
					}
					backlog = null;
				}
				logFile.Write( buff.ToString() );
				logFile.Flush();
			}

			if( ! wroteSomewhere ) {
                Console.Write( buff.ToString() );
			}
		}

		/**
		 *	Open the specified file for logging
		 *
		 *	@param	fileName	The name of the file to open as a log.
		 */
		public void openLogFile( String fileName )
		{
			Debug.Assert( ( fileName != null ) && ( fileName.Length > 0 ) );
			Debug.Assert( logFile == null );
			logFile = File.CreateText( fileName );
		}
		
		/**
		 *	Close the log file.
		 */
		public void closeLogFile() {
			if( logFile != null ) {
				StreamWriter old = logFile;
				logFile = null;
				
				old.Flush();
				old.Close();
			}
		}
	}
}
