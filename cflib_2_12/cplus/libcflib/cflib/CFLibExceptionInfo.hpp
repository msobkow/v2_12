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

	class CFLibExceptionInfo {

	protected:
		std::string strSourceFileName;
		size_t sourceFileLine;
		std::string strExceptionClassName;
		std::string strCause;
		std::string strClassFieldName;
		std::string strMethodName;
		size_t argOffset;
		std::string strArgName;
		std::string strArgValueString;
		std::string minValueString;
		std::string maxValueString;
		std::string strMessageText;

	public:

		virtual ~CFLibExceptionInfo();

		CFLibExceptionInfo();

		CFLibExceptionInfo(
			const CFLibExceptionInfo& src );

		CFLibExceptionInfo(
			const std::string& argSourceFileName,
			size_t argSourceFileLine,
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argMethodName,
			size_t argOffset,
			const std::string& argName,
			const std::string& argValueString,
			const std::string& argMinValueString,
			const std::string& argMaxValueString,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argMethodName,
			size_t argOffset,
			const std::string& argName,
			const std::string& argValueString,
			const std::string& argMinValueString,
			const std::string& argMaxValueString,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argName,
			const std::string& argValueString,
			const std::string& argMinValueString,
			const std::string& argMaxValueString,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argName,
			const std::string& argValueString,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argName,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& strExceptionClassName,
			const std::string& argStrCause,
			const std::string& argClassFieldName,
			const std::string& argMessageText );

		CFLibExceptionInfo(
			const std::string& argMessageText );

	};
}
