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
#include <cflib/CFLibXmlUtil.hpp>
#include <cflib/CFLibArgumentUnderflowException.hpp>

namespace cflib {

	const std::string CFLibArgumentUnderflowException::S_MUST_BE_AT_LEAST( " must be at least " );

	CFLibArgumentUnderflowException::~CFLibArgumentUnderflowException() {
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const CFLibArgumentUnderflowException& src )
	: std::underflow_error( src )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& msg )
	: std::underflow_error( msg )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& msg )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + msg )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int16_t argValue,
		int16_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int32_t argValue,
		int32_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int64_t argValue,
		int64_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint16_t argValue,
		uint16_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint32_t argValue,
		uint32_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint64_t argValue,
		uint64_t minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		float argValue,
		float minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		double argValue,
		double minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_MUST_BE_AT_LEAST + std::to_string( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::chrono::system_clock::time_point& argValue,
		const std::chrono::system_clock::time_point& minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + CFLibXmlUtil::formatTimestamp( argValue ) + S_MUST_BE_AT_LEAST + CFLibXmlUtil::formatTimestamp( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& argValue,
		const std::string& minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + argValue + S_MUST_BE_AT_LEAST + minValue )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		mpfr_srcptr argValue,
		mpfr_srcptr minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + CFLibXmlUtil::formatMPFR( argValue ) + S_MUST_BE_AT_LEAST + CFLibXmlUtil::formatMPFR( minValue ) )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const CFLibGenericBigDecimal& argValue,
		const CFLibGenericBigDecimal& minValue )
	: std::underflow_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + argValue.toString() + S_MUST_BE_AT_LEAST + minValue.toString() )
	{
	}

	CFLibArgumentUnderflowException::CFLibArgumentUnderflowException(
		const std::string& fieldName,
		const std::string& msg )
	: std::underflow_error( fieldName + CFLib::S_SPACE + msg )
	{
	}
}
