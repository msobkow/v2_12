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
#include <xercesc/util/BinInputStream.hpp>
#include <xercesc/sax/DocumentHandler.hpp>
#include <xercesc/sax/Locator.hpp>
#include <xercesc/framework/MemoryManager.hpp>

namespace cflib {

	class CFLibXmlCoreParser;

	class CFLibXmlCoreLineCountBinInputStream : public virtual xercesc::BinInputStream, public virtual xercesc::Locator {
		protected:
			CFLibXmlCoreParser* coreParser;
			xercesc::BinInputStream* chainedInput;
			XMLFilePos myLineNumber;
			XMLFilePos myColNumber;
			XMLCh * publicId;
			XMLCh * systemId;

		public:
			CFLibXmlCoreLineCountBinInputStream( CFLibXmlCoreParser* parser, xercesc::BinInputStream* chain );
			virtual ~CFLibXmlCoreLineCountBinInputStream();
			virtual CFLibXmlCoreParser* getParser();
			virtual const XMLCh * getPublicId() const;
			virtual void setPublicId( const XMLCh* value );
			virtual void setPublicId( const std::string& value );
			virtual const XMLCh * getSystemId() const;
			virtual void setSystemId( const XMLCh* value );
			virtual void setSystemId( const std::string& value );
			virtual XMLFileLoc getLineNumber() const;
			virtual XMLFileLoc getColumnNumber() const;
			virtual XMLFilePos curPos() const;
			virtual const XMLCh* getContentType() const;
			virtual const XMLCh* getEncoding() const;
			virtual XMLSize_t readBytes( XMLByte *const toFill, const XMLSize_t maxToRead );
	};
}
