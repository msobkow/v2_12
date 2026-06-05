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
 *		http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

#include <ctype.h>
#include <cassert>
#include <cstddef>
#include <cstdint>
#include <string>

#include <xercesc/sax/SAXException.hpp>
#include <xercesc/sax/SAXParseException.hpp>
#include <xercesc/util/PlatformUtils.hpp>
#include <xercesc/util/XMLException.hpp>
#include <xercesc/util/XMLString.hpp>
#include <xercesc/framework/MemBufInputSource.hpp>

#include <cflib/CFLibXmlCoreLineCountBinInputStream.hpp>

namespace cflib {
	class CFLibXmlCoreLineCountMemBufInputSource : public xercesc::MemBufInputSource {
		protected:
			CFLibXmlCoreParser* coreParser;

		public:
			CFLibXmlCoreLineCountMemBufInputSource( CFLibXmlCoreParser* parser,
				const XMLByte* const srcDocBytes,
				const XMLSize_t byteCount,
				const XMLCh * const bufId,
				const bool adoptBuffer = false,
				xercesc::MemoryManager * const manager = xercesc::XMLPlatformUtils::fgMemoryManager );
			CFLibXmlCoreLineCountMemBufInputSource( CFLibXmlCoreParser* parser,
				const XMLByte* const srcDocBytes,
				const XMLSize_t byteCount,
				const char * const bufId,
				const bool adoptBuffer = false,
				xercesc::MemoryManager * const manager = xercesc::XMLPlatformUtils::fgMemoryManager );
			virtual ~CFLibXmlCoreLineCountMemBufInputSource();
			virtual xercesc::BinInputStream * makeStream() const;
	};
}
