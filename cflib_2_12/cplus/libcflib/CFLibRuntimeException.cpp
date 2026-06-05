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
#include <cflib/CFLibRuntimeException.hpp>

namespace cflib {

	CFLibRuntimeException::~CFLibRuntimeException()
	{
	}

	CFLibRuntimeException::CFLibRuntimeException(
		const CFLibRuntimeException& src )
	: std::runtime_error( src )
	{
	}

	CFLibRuntimeException::CFLibRuntimeException()
	: std::runtime_error( CFLib::S_EMPTY)
	{
	}

	CFLibRuntimeException::CFLibRuntimeException(
		const std::string& msg )
	: std::runtime_error( msg )
	{
	}

	CFLibRuntimeException::CFLibRuntimeException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& msg )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + msg )
	{
	}

	CFLibRuntimeException::CFLibRuntimeException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibRuntimeException::CFLibRuntimeException(
		const std::string& fieldName,
		const std::string& msg )
	: std::runtime_error( fieldName + CFLib::S_SPACE + msg )
	{
	}
}
