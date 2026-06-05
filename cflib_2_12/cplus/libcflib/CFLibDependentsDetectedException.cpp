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
#include <cflib/CFLibDependentsDetectedException.hpp>

namespace cflib {

	const std::string CFLibDependentsDetectedException::S_RELATION( " relation " );
	const std::string CFLibDependentsDetectedException::S_DEPENDENTS_DETECTED_FOR_KEY( " dependents detected for primary key " );

	CFLibDependentsDetectedException::~CFLibDependentsDetectedException()
	{
	}

	CFLibDependentsDetectedException::CFLibDependentsDetectedException(
		const CFLibDependentsDetectedException& src )
	: std::runtime_error( src )
	{
	}

	CFLibDependentsDetectedException::CFLibDependentsDetectedException(
		const std::string& msg )
	: std::runtime_error( msg )
	{ 
	}

	CFLibDependentsDetectedException::CFLibDependentsDetectedException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& msg )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + msg )
	{
	}

	CFLibDependentsDetectedException::CFLibDependentsDetectedException(
		const std::string& throwingClassName,
		const std::string& methName,
		const std::string& relationType,
		const std::string& relationName,
		ICFLibAnyObj* argKey )
	: std::runtime_error( throwingClassName + CFLib::S_DOUBLE_COLON + methName + CFLib::S_PAREN_SPACE + S_RELATION + relationName + S_DEPENDENTS_DETECTED_FOR_KEY + (( argKey != NULL ) ? argKey->toString() : CFLib::S_EMPTY ) )
	{
	}
}
