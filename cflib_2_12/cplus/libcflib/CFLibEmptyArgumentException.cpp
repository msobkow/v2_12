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
#include <cflib/CFLibEmptyArgumentException.hpp>

namespace cflib {

	const std::string CFLibEmptyArgumentException::S_IS_NULL_OR_EMPTY( " is null or empty" );

	CFLibEmptyArgumentException::~CFLibEmptyArgumentException()
	{
	}

	CFLibEmptyArgumentException::CFLibEmptyArgumentException(
		const CFLibEmptyArgumentException& src )
	: std::invalid_argument( src )
	{
	}

	CFLibEmptyArgumentException::CFLibEmptyArgumentException(
		const std::string& msg )
	: std::invalid_argument( msg )
	{
	}

	CFLibEmptyArgumentException::CFLibEmptyArgumentException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::invalid_argument( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibEmptyArgumentException::CFLibEmptyArgumentException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName,
		const std::string& msg )
	: std::invalid_argument( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + CFLib::S_SPACE + msg )
	{
	}

	CFLibEmptyArgumentException::CFLibEmptyArgumentException(
		const std::string& throwingClassName,
		const std::string& methName,
		int argNo,
		const std::string& argName )
	: std::invalid_argument( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE_ARGUMENT + std::to_string( argNo ) + CFLib::S_SPACE + argName + S_IS_NULL_OR_EMPTY )
	{
	}
}
