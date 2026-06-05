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
#include <cflib/CFLibUnsupportedClassException.hpp>

namespace cflib {

	const std::string CFLibUnsupportedClassException::S_UNSUPPORTED_CLASS( " is unnsupported class " );
	const std::string CFLibUnsupportedClassException::S_EXPECTED( ", expected " );

	CFLibUnsupportedClassException::~CFLibUnsupportedClassException()
	{
	}

	CFLibUnsupportedClassException::CFLibUnsupportedClassException(
		const CFLibUnsupportedClassException& src )
	: std::runtime_error( src )
	{
	}

	CFLibUnsupportedClassException::CFLibUnsupportedClassException(
		const std::string& msg )
	: std::runtime_error( msg )
	{
	}

	CFLibUnsupportedClassException::CFLibUnsupportedClassException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibUnsupportedClassException::CFLibUnsupportedClassException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& argObjName,
		ICFLibAnyObj* argObj,
		const std::string& argExpectedClasses )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + argObjName + S_UNSUPPORTED_CLASS + (( argObj != NULL ) ? argObj->getClassName() : CFLib::S_EMPTY ) + S_EXPECTED + argExpectedClasses )
	{
	}
}

