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

#include <array>
#include <cassert>
#include <cstddef>
#include <chrono>
#include <ctime>
#include <list>
#include <string>

namespace cflib {

	class CFLibRuntimeException : public std::runtime_error {

	public:

		virtual ~CFLibRuntimeException();

		CFLibRuntimeException(
			const CFLibRuntimeException& src );

		CFLibRuntimeException();

		CFLibRuntimeException(
			const std::string& msg );

		CFLibRuntimeException(
			const std::string& throwingClassName,
			const std::string& methName,
			const std::string& msg );

		CFLibRuntimeException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			const std::string& msg );

		CFLibRuntimeException(
			const std::string& fieldName,
			const std::string& msg );
	};
}
