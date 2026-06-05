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

#include <ctype.h>
#include <uuid/uuid.h>
#include <time.h>
#include <memory.h>

#include <array>
#include <cassert>
#include <cstddef>
#include <cstdint>
#include <chrono>
#include <ctime>
#include <list>
#include <map>
#include <string>
#include <tuple>
#include <vector>
#include <stdexcept>

#include <cflib/ICFLibCloneableObj.hpp>
#include <cflib/ICFLibObj.hpp>
#include <cflib/ICFLibAnyObj.hpp>
#include <cflib/ICFLibMessageLog.hpp>
#include <cflib/ICFLibXmlCoreContextFactory.hpp>

#include <cflib/CFLib.hpp>

#include <cflib/CFLibDbUtil.hpp>
#include <cflib/CFLibConsoleMessageLog.hpp>
#include <cflib/CFLibCachedMessageLog.hpp>
#include <cflib/CFLibGenericBigDecimal.hpp>
#include <cflib/TCFLibBigDecimal.hpp>
#include <cflib/TCFLibOwningVector.hpp>
#include <cflib/TCFLibOwningList.hpp>

#include <cflib/CFLibNullable.hpp>
#include <cflib/CFLibNullableBool.hpp>
#include <cflib/CFLibNullableInt16.hpp>
#include <cflib/CFLibNullableInt32.hpp>
#include <cflib/CFLibNullableInt64.hpp>
#include <cflib/CFLibNullableUInt16.hpp>
#include <cflib/CFLibNullableUInt32.hpp>
#include <cflib/CFLibNullableUInt64.hpp>
#include <cflib/CFLibNullableFloat.hpp>
#include <cflib/CFLibNullableDouble.hpp>

#include <cflib/CFLibRuntimeException.hpp>
#include <cflib/CFLibArgumentException.hpp>
#include <cflib/CFLibArgumentOverflowException.hpp>
#include <cflib/CFLibArgumentRangeException.hpp>
#include <cflib/CFLibArgumentUnderflowException.hpp>
#include <cflib/CFLibCollisionDetectedException.hpp>
#include <cflib/CFLibDbException.hpp>
#include <cflib/CFLibDependentsDetectedException.hpp>
#include <cflib/CFLibEmptyArgumentException.hpp>
#include <cflib/CFLibInvalidArgumentException.hpp>
#include <cflib/CFLibMathException.hpp>
#include <cflib/CFLibMustOverrideException.hpp>
#include <cflib/CFLibNotImplementedYetException.hpp>
#include <cflib/CFLibNotSupportedException.hpp>
#include <cflib/CFLibNullArgumentException.hpp>
#include <cflib/CFLibPrimaryKeyNotNewException.hpp>
#include <cflib/CFLibStaleCacheDetectedException.hpp>
#include <cflib/CFLibSubroutineException.hpp>
#include <cflib/CFLibUniqueIndexViolationException.hpp>
#include <cflib/CFLibUnrecognizedAttributeException.hpp>
#include <cflib/CFLibUnresolvedRelationException.hpp>
#include <cflib/CFLibUnsupportedClassException.hpp>
#include <cflib/CFLibUsageException.hpp>

#include <cflib/CFLibXmlCoreLineCountBinInputStream.hpp>
#include <cflib/CFLibXmlCoreLineCountMemBufInputSource.hpp>
#include <cflib/CFLibXmlCore.hpp>
#include <cflib/CFLibXmlCoreContext.hpp>
#include <cflib/CFLibXmlCoreElementHandler.hpp>
#include <cflib/CFLibXmlCoreIso8859Encoder.hpp>
#include <cflib/CFLibXmlCoreParser.hpp>
#include <cflib/CFLibXmlCoreSaxParser.hpp>
#include <cflib/CFLibXmlUtil.hpp>

