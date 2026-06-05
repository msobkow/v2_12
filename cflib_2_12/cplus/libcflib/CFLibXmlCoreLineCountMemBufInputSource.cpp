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

#include <cflib/CFLibXmlCoreLineCountBinInputStream.hpp>
#include <cflib/CFLibXmlCoreLineCountMemBufInputSource.hpp>
#include <cflib/CFLibXmlCoreParser.hpp>

namespace cflib {

	CFLibXmlCoreLineCountMemBufInputSource::CFLibXmlCoreLineCountMemBufInputSource( CFLibXmlCoreParser* parser,
		const XMLByte* const srcDocBytes,
		const XMLSize_t byteCount,
		const XMLCh * const bufId,
		const bool adoptBuffer,
		xercesc::MemoryManager * const manager )
	: xercesc::MemBufInputSource( srcDocBytes, byteCount, bufId, false, manager )
	{
		coreParser = parser;
	}

	CFLibXmlCoreLineCountMemBufInputSource::CFLibXmlCoreLineCountMemBufInputSource( CFLibXmlCoreParser* parser,
		const XMLByte* const srcDocBytes,
		const XMLSize_t byteCount,
		const char * const bufId,
		const bool adoptBuffer,
		xercesc::MemoryManager * const manager )
	: xercesc::MemBufInputSource( srcDocBytes, byteCount, bufId, false, manager )
	{
		coreParser = parser;
	}

	CFLibXmlCoreLineCountMemBufInputSource::~CFLibXmlCoreLineCountMemBufInputSource() {
		if( coreParser != NULL ) {
			coreParser->setDocumentLocator( NULL );
			coreParser = NULL;
		}
	}

	xercesc::BinInputStream * CFLibXmlCoreLineCountMemBufInputSource::makeStream() const {
		xercesc::BinInputStream* baseImpl = xercesc::MemBufInputSource::makeStream();
		CFLibXmlCoreLineCountBinInputStream* retStream = new CFLibXmlCoreLineCountBinInputStream( coreParser, baseImpl );
		retStream->setSystemId( getSystemId() );
		retStream->setPublicId( getPublicId() );
		return( retStream );
	};
}
