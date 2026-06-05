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
#include <cflib/CFLibArgumentRangeException.hpp>

namespace cflib {

	const std::string CFLibArgumentRangeException::S_IS_OUT_OF_THE_RANGE( " is out of the range " );
	const std::string CFLibArgumentRangeException::S_VALUE_OUT_OF_RANGE( "value is out of range" );

	CFLibArgumentRangeException::~CFLibArgumentRangeException() {
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const CFLibArgumentRangeException& src )
	: std::range_error( src )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& msg )
	: std::range_error( msg )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& msg )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + msg )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int16_t argValue,
		int16_t minValue,
		int16_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue ) + CFLib::S_DOT_DOT + std::to_string( maxValue ) )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int32_t argValue,
		int32_t minValue,
		int32_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		int64_t argValue,
		int64_t minValue,
		int64_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint16_t argValue,
		uint16_t minValue,
		uint16_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint32_t argValue,
		uint32_t minValue,
		uint32_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		uint64_t argValue,
		uint64_t minValue,
		uint64_t maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		float argValue,
		float minValue,
		float maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		double argValue,
		double minValue,
		double maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + std::to_string( argValue ) + S_IS_OUT_OF_THE_RANGE + std::to_string( minValue )+ CFLib::S_DOT_DOT + std::to_string( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::chrono::system_clock::time_point& argValue,
		const std::chrono::system_clock::time_point& minValue,
		const std::chrono::system_clock::time_point& maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + CFLibXmlUtil::formatTimestamp( argValue ) + S_IS_OUT_OF_THE_RANGE + CFLibXmlUtil::formatTimestamp( minValue ) + CFLib::S_DOT_DOT + CFLibXmlUtil::formatTimestamp( maxValue )  )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& argValue,
		const std::string& minValue,
		const std::string& maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + argValue + S_IS_OUT_OF_THE_RANGE + minValue + CFLib::S_DOT_DOT + maxValue )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		mpfr_srcptr argValue,
		mpfr_srcptr minValue,
		mpfr_srcptr maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + CFLibXmlUtil::formatMPFR( argValue ) + S_IS_OUT_OF_THE_RANGE + CFLibXmlUtil::formatMPFR( minValue ) + CFLib::S_DOT_DOT + CFLibXmlUtil::formatMPFR( maxValue ) )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const CFLibGenericBigDecimal& argValue,
		const CFLibGenericBigDecimal& minValue,
		const CFLibGenericBigDecimal& maxValue )
	: std::range_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + CFLib::S_VALUE_SPACE + argValue.toString() + S_IS_OUT_OF_THE_RANGE + minValue.toString() )
	{
	}

	CFLibArgumentRangeException::CFLibArgumentRangeException(
		const std::string& fieldName,
		const std::string& msg )
	: std::range_error( fieldName + CFLib::S_SPACE + msg )
	{
	}
}
