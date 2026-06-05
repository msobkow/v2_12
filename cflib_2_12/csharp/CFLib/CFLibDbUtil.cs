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
using System.Text;

namespace CFLib
{
	public class CFLibDbUtil {

        public static TimeZoneInfo tzInfoUTC = TimeZoneInfo.Utc;
        public static DateTime dateTimeUTC = DateTime.UtcNow;
        public static TimeSpan tsUtcOffsetUTC = tzInfoUTC.GetUtcOffset(dateTimeUTC);
        public static TimeZoneInfo tzInfoLocal = TimeZoneInfo.Local;
        public static DateTime dateTimeLocal = DateTime.Now;
        public static TimeSpan tsUtcOffsetLocal = tzInfoLocal.GetUtcOffset( dateTimeLocal );
        public static TimeSpan tsUtcOffsetDb = tsUtcOffsetLocal;
        public static TimeZoneInfo tzInfoDb = null;

		public static TimeSpan getDbServerTZOffset() {
			return( tsUtcOffsetDb );
		}
		
		public static void setDbServerTZOffset( TimeSpan value ) {
			tsUtcOffsetDb = value;
			tzInfoDb = null;
		}

		public static TimeZoneInfo getDbServerTimeZoneInfo() {
			if( tzInfoDb == null ) {
                int secondsOnly = tsUtcOffsetDb.Seconds;
                int minutesOnly = tsUtcOffsetDb.Minutes;
				int absMinutes = ( minutesOnly < 0 ) ? ( 0 - minutesOnly ) : minutesOnly;
				int minutes = absMinutes % 60;
				int hours = absMinutes / 60;
				StringBuilder buff = new StringBuilder();
				if( minutesOnly < 0 ) {
					buff.Append( "GMT-" );
				}
				else {
					buff.Append( "GMT+" );
				}
                buff.Append(String.Format( "{0:00}", hours ));
                buff.Append(String.Format("{0:00}", minutes));
                tzInfoDb = TimeZoneInfo.FindSystemTimeZoneById(buff.ToString());
			}
			return( tzInfoDb );
		}
		
		public static void setDbServerTimeZoneInfo( TimeZoneInfo tz ) {
			if( tz == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibDbUtil),
					"setDbServerTimeZoneInfo",
					1,
					"tz" );
			}
			tzInfoDb = tz;
            tsUtcOffsetDb = tzInfoDb.GetUtcOffset(dateTimeLocal);
		}

		public static DateTimeOffset? getDbServerDateTimeOffset( DateTime value ) {
			if( value == null ) {
				return( null );
			}
            DateTimeOffset retval = new DateTimeOffset(value, tsUtcOffsetDb);
			return( retval );
		}

		public static DateTimeOffset? getUTCDateTimeOffset( DateTime value ) {
			if( value == null ) {
				return( null );
			}
            DateTimeOffset retval = new DateTimeOffset(value, tsUtcOffsetUTC);
			return( retval );
		}
	}
}
