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

#include <ctype.h>
#include <uuid/uuid.h>
#include <time.h>
#include <memory.h>

#include <array>
#include <cassert>
#include <cstddef>
#include <cstdint>
#include <chrono>
#include <ctime>
#include <list>
#include <string>
#include <tuple>
#include <vector>
#include <stdexcept>

#include <cflib/ICFLibAnyObj.hpp>
#include <cflib/ICFLibMessageLog.hpp>

#include <cflib/CFLibGenericBigDecimal.hpp>

#include <cflib/CFLibNullable.hpp>
#include <cflib/CFLibNullableBool.hpp>
#include <cflib/CFLibNullableInt16.hpp>
#include <cflib/CFLibNullableInt32.hpp>
#include <cflib/CFLibNullableInt64.hpp>
#include <cflib/CFLibNullableUInt16.hpp>
#include <cflib/CFLibNullableUInt32.hpp>
#include <cflib/CFLibNullableUInt64.hpp>
#include <cflib/CFLibNullableFloat.hpp>
#include <cflib/CFLibNullableDouble.hpp>

#ifdef _WINDOWS
extern "C" char * strtok_r(char *str, const char *delim, char **saveptr);
#endif

namespace cflib {

	typedef unsigned char BYTE;

	class CFLib {
	public:

		const static std::string CLASS_NAME;
		const static std::string S_EMPTY;
		const static std::string S_TRUE;
		const static std::string S_FALSE;
		const static std::string S_DOUBLE_COLON;
		const static std::string S_DOT;
		const static std::string S_DOT_DOT;
		const static std::string S_SPACE;
		const static std::string S_PAREN_SPACE;
		const static std::string S_PAREN_SPACE_ARGUMENT;
		const static std::string S_VALUE_SPACE;
		const static std::string S_NO_MESSAGE_PROVIDED;
		const static std::string S_SUBROUTINE;
		const static std::string S_RETURNED;
		const static std::string S_COMMASPACE;
		const static std::string LinkName;
		const static std::string LinkVersion;
		const static std::string S_MsgInitMustBeCalledFirst;

	protected:

		static bool initialized;

	public:
		CFLib();
		virtual ~CFLib();

		static bool isInitialized();
		static void init();
		static void release();

		static std::string base64_encode(BYTE const* buf, unsigned int bufLen);
		static std::vector<BYTE>* base64_decode(const std::string& encoded_string);

		static void beep();

		/* Look for tag=someValue within filename.  When found, return someValue
		 * in the provided value parameter up to valueSize in length.  If someValue
		 * is enclosed in quotes, remove them. */
		static char* getValue( const char* filename, const char* tag, char* value, std::string::size_type valueSize );

		static uuid_t* uuidFromString( const char* value );
		static uuid_t* uuidClone( const uuid_t& src );
		static uuid_t* uuidClone( const uuid_t* src );

		static std::chrono::system_clock::time_point* getUTCGregorianCalendar(
			int year,
			int month,
			int day,
			int hour,
			int minute,
			int second );
		static std::chrono::system_clock::time_point* getUTCTimestamp();

		const std::string* getLinkName();
	
		const std::string* getLinkVersion();

		static size_t hash( const uuid_t& value );
		static size_t hash( const uuid_t* value );

		static size_t hash( const std::string* value );

		static size_t hash( const std::string& value );

		static size_t hash( const std::chrono::system_clock::time_point& value );

		static size_t hash( const std::vector<BYTE>& value );

		static bool startsWith( const std::string& str, const std::string& match );
		static void createDirectory( const std::string& fullDirPath );
	};
}
