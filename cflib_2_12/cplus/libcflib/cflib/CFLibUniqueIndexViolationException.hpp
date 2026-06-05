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

#include <cflib/CFLib.hpp>

namespace cflib {

	class CFLibUniqueIndexViolationException : public std::runtime_error {

	public:

		const static std::string S_UNIQUE_INDEX_VIOLATED;

		virtual ~CFLibUniqueIndexViolationException();

		CFLibUniqueIndexViolationException(
			const CFLibUniqueIndexViolationException& src );

		CFLibUniqueIndexViolationException(
			const std::string& msg );

		CFLibUniqueIndexViolationException(
			const std::string& throwingClassName,
			const std::string& methName,
			const std::string& msg );

		CFLibUniqueIndexViolationException(
			const std::string& throwingClassName,
			const std::string& methName,
			const std::string& argIndexName,
			ICFLibAnyObj* argIndexKey );
	};
}
