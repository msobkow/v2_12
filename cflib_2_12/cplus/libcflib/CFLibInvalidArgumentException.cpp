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
#include <cflib/CFLibInvalidArgumentException.hpp>

namespace cflib {

	CFLibInvalidArgumentException::~CFLibInvalidArgumentException()
	{
	}

	CFLibInvalidArgumentException::CFLibInvalidArgumentException(
		const CFLibInvalidArgumentException& src )
	: std::invalid_argument( src )
	{
	}

	CFLibInvalidArgumentException::CFLibInvalidArgumentException(
		const std::string& msg )
	: std::invalid_argument( msg )
	{
	}

	CFLibInvalidArgumentException::CFLibInvalidArgumentException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::invalid_argument( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibInvalidArgumentException::CFLibInvalidArgumentException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& msg )
	: std::invalid_argument( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + msg )
	{
	}

	CFLibInvalidArgumentException::CFLibInvalidArgumentException(
		const std::string& fieldName,
		const std::string& msg )
	: std::invalid_argument( fieldName + CFLib::S_SPACE + msg )
	{
	}
}

