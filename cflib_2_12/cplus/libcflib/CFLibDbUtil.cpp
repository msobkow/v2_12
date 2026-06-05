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

#include <cflib/CFLib.hpp>
#include <cflib/CFLibDbUtil.hpp>

namespace cflib {

	time_t CFLibDbUtil::dbServerTZOffsetSeconds = -1;

	CFLibDbUtil::CFLibDbUtil() {
	}

	time_t CFLibDbUtil::getDbServerTZOffsetSeconds() {
		// MSS TODO WORKING Need to determine current system time zone and its offset, and
		// initialize dbServerTZOffsetSeconds with that value.
		if( dbServerTZOffsetSeconds == -1 ) {
			dbServerTZOffsetSeconds = 0;
		}
		return( dbServerTZOffsetSeconds );
	}
	
	void CFLibDbUtil::setDbServerTZOffsetSeconds( time_t value ) {
		dbServerTZOffsetSeconds = value;
	}

	std::chrono::system_clock::time_point* CFLibDbUtil::getDbServerTimeFromUTCTime( const std::chrono::system_clock::time_point* value ) {
		if( value == NULL ) {
			return( NULL );
		}

		std::time_t time = std::chrono::system_clock::to_time_t( *value );
		// MSS TODO WORKING Need to convert UTC time to current system time
		// time += CFLib::getUTCTimezoneOffset();
		std::tm utc = *std::localtime( &time );
#if ! defined(_WINDOWS)
		utc.tm_gmtoff = getDbServerTZOffsetSeconds();
		utc.tm_zone = NULL;
#endif
		time_t timeConverted = mktime( &utc );

		std::chrono::duration<long,std::ratio<1>> *dur = new std::chrono::duration<long,std::ratio<1>>( timeConverted );
		std::chrono::system_clock::time_point* retval = new std::chrono::system_clock::time_point( *dur );

		return( retval );
	}

	std::chrono::system_clock::time_point* CFLibDbUtil::getUTCTimeFromDBServerTime( const std::chrono::system_clock::time_point* value ) {
		if( value == NULL ) {
			return( NULL );
		}

		std::time_t time = std::chrono::system_clock::to_time_t( *value );
		time += getDbServerTZOffsetSeconds();
		std::tm dbtime = *std::localtime( &time );
		// MSS TODO WORKING Need to calculate tm_gmtoff from current system settings under WSL Ubuntu
		// dbtime.tm_gmtoff = CFLib::getUTCTimezoneOffset();
#if ! defined(_WINDOWS)
		dbtime.tm_zone = NULL;
#endif
		time_t timeConverted = mktime( &dbtime );

		std::chrono::duration<long,std::ratio<1>> *dur = new std::chrono::duration<long,std::ratio<1>>( timeConverted );
		std::chrono::system_clock::time_point* retval = new std::chrono::system_clock::time_point( *dur );

		return( retval );
	}
}
