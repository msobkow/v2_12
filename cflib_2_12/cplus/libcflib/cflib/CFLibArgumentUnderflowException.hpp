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

#include <cflib/CFLibGenericBigDecimal.hpp>

namespace cflib {

	class CFLibArgumentUnderflowException : public std::underflow_error {

	public:

		static const std::string S_MUST_BE_AT_LEAST;

		virtual ~CFLibArgumentUnderflowException();

		CFLibArgumentUnderflowException(
			const CFLibArgumentUnderflowException& src );

		CFLibArgumentUnderflowException(
			const std::string& msg );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			const std::string& msg );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			const std::string& msg );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			int16_t argValue,
			int16_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			int32_t argValue,
			int32_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			int64_t argValue,
			int64_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			uint16_t argValue,
			uint16_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			uint32_t argValue,
			uint32_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			uint64_t argValue,
			uint64_t minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			float argValue,
			float minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			double argValue,
			double minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			const std::chrono::system_clock::time_point& argValue,
			const std::chrono::system_clock::time_point& minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			const std::string& argValue,
			const std::string& minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			mpfr_srcptr argValue,
			mpfr_srcptr minValue );

		CFLibArgumentUnderflowException(
			const std::string& throwingClassName,
			const std::string& methName,
			int argNo,
			const std::string& argName,
			const CFLibGenericBigDecimal& argValue,
			const CFLibGenericBigDecimal& minValue );

		CFLibArgumentUnderflowException(
			const std::string& fieldName,
			const std::string& msg );
	};
}
