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
#include <cflib/CFLibArgumentException.hpp>
#include <cflib/CFLibNotImplementedYetException.hpp>

namespace cflib {

	const std::string CFLibNotImplementedYetException::S_NOT_IMPLEMENTED_YET( "Not implemented yet" );

	CFLibNotImplementedYetException::~CFLibNotImplementedYetException()
	{
	}

	CFLibNotImplementedYetException::CFLibNotImplementedYetException()
	: std::logic_error( S_NOT_IMPLEMENTED_YET )
	{
	}

	CFLibNotImplementedYetException::CFLibNotImplementedYetException(
		const CFLibNotImplementedYetException& src )
	: std::logic_error( src )
	{
	}

	CFLibNotImplementedYetException::CFLibNotImplementedYetException(
		const std::string& msg )
	: std::logic_error( msg )
	{
	}

	CFLibNotImplementedYetException::CFLibNotImplementedYetException(
		const std::string& throwingClassName,
		const std::string& methName )
	: std::logic_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + CFLib::S_SPACE + S_NOT_IMPLEMENTED_YET )
	{
	}

	CFLibNotImplementedYetException::CFLibNotImplementedYetException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::logic_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + CFLib::S_PAREN_SPACE + msg )
	{
	}
}
