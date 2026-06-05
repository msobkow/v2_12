/*
 *  MSS Code Factory CFLib 2.12
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

namespace CFLib
{
    public class CFLib {
        public static char[] S_Empty = { '\0' };
        private static String linkName = "CFLib";
        public static String LinkName
        {
            get
            {
                return (linkName);
            }
        }

        private static String linkVersion = "2.12.11194";
		public static String LinkVersion
        {
            get
            {
                return (linkVersion);
            }
        }

		private static ICFLibExceptionFactory defaultExceptionFactory = (ICFLibExceptionFactory)( new CFLibEnCaExceptionFactory() );
        public static ICFLibExceptionFactory DefaultExceptionFactory
        {
            get
            {
                return (defaultExceptionFactory);
            }

            set {
                if (value == null)
                {
                    throw defaultExceptionFactory.newNullArgumentException(typeof(CFLib),
					    "setExceptionFactory",
					    1,
					    "value",
					    null );
			    }
                defaultExceptionFactory = value;
		    }
        }
 
		public static TimeZoneInfo UTC_TIMEZONE = TimeZoneInfo.Utc;
 
		public static void beep() {
            /*
			Clip clip = null;
			// The audio is courtesy of a whole whack of articles from stackoverflow.com, each of which got me one line closer to working
			try {
				InputStream resource = typeof(CFLib).getResourceAsStream("/net/sourceforge/msscf/cflib/CFLib/sounds/alert.wav");
				if( resource != null ) {
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( new BufferedInputStream( resource ) );
					DataLine.Info info = new DataLine.Info( typeof(Clip), audioInputStream.getFormat() );
					clip = (Clip)AudioSystem.getLine( info );
					clip.open( audioInputStream );
					clip.start();
					clip.drain();
				}
			} catch (LineUnavailableException e) {
			} catch (UnsupportedAudioFileException e) {
			} catch (IOException e) {
			} catch (NullPointerException e) {
			} catch (IllegalArgumentException e) {
			}
            */
		}

		public static DateTime getUTCGregorianDateTime(
			int year,
			int month,
			int day,
			int hour,
			int minute,
			int second )
		{
            DateTime cal = new DateTime( year, month, day, hour, minute, second, DateTimeKind.Utc );
			return( cal );
		}
    }
}
