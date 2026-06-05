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
#include <cflib/CFLibXmlCoreParser.hpp>

namespace cflib {

	CFLibXmlCoreLineCountBinInputStream::CFLibXmlCoreLineCountBinInputStream( CFLibXmlCoreParser* parser, xercesc::BinInputStream* chain ) {
		coreParser = parser;
		chainedInput = chain;
		publicId = NULL;
		systemId = NULL;
		myLineNumber = 0;
		myColNumber = 0;
		if( coreParser != NULL ) {
			coreParser->setDocumentLocator( this );
		}
	}

	CFLibXmlCoreLineCountBinInputStream::~CFLibXmlCoreLineCountBinInputStream() {
		if( coreParser != NULL ) {
			coreParser->setDocumentLocator( NULL );
			coreParser = NULL;
		}
		if( chainedInput != NULL ) {
			delete chainedInput;
			chainedInput = NULL;
		}
		if( publicId != NULL ) {
			xercesc::XMLString::release( &publicId );
			publicId = NULL;
		}
		if( systemId != NULL ) {
			xercesc::XMLString::release( &systemId );
			systemId = NULL;
		}
		myLineNumber = 0;
		myColNumber = 0;
	}

	CFLibXmlCoreParser* CFLibXmlCoreLineCountBinInputStream::getParser() {
		return( coreParser );
	}

	const XMLCh * CFLibXmlCoreLineCountBinInputStream::getPublicId() const {
		return( publicId );
	}

	const XMLCh * CFLibXmlCoreLineCountBinInputStream::getSystemId() const {
		return( systemId );
	}

	void CFLibXmlCoreLineCountBinInputStream::setPublicId( const XMLCh* value ) {
		if( value != publicId ) {
			if( publicId != NULL ) {
				xercesc::XMLString::release( &publicId );
				publicId = NULL;
			}
			if( value != NULL ) {
				publicId = xercesc::XMLString::replicate( value );
			}
		}
	}

	void CFLibXmlCoreLineCountBinInputStream::setPublicId( const std::string& value ) {
		XMLCh* transcoded = xercesc::XMLString::transcode( value.c_str() );
		setPublicId( transcoded );
		xercesc::XMLString::release( &transcoded );
	}

	void CFLibXmlCoreLineCountBinInputStream::setSystemId( const XMLCh* value ) {
		if( value != systemId ) {
			if( systemId != NULL ) {
				xercesc::XMLString::release( &systemId );
				systemId = NULL;
			}
			if( value != NULL ) {
				systemId = xercesc::XMLString::replicate( value );
			}
		}
	}

	void CFLibXmlCoreLineCountBinInputStream::setSystemId( const std::string& value ) {
		XMLCh* transcoded = xercesc::XMLString::transcode( value.c_str() );
		setSystemId( transcoded );
		xercesc::XMLString::release( &transcoded );
	}

	XMLFileLoc CFLibXmlCoreLineCountBinInputStream::getLineNumber() const {
		return( myLineNumber );
	}

	XMLFileLoc CFLibXmlCoreLineCountBinInputStream::getColumnNumber() const {
		return( myColNumber );
	}

	XMLFilePos CFLibXmlCoreLineCountBinInputStream::curPos() const {
		return( chainedInput->curPos() );
	}

	const XMLCh* CFLibXmlCoreLineCountBinInputStream::getContentType() const {
		return( chainedInput->getContentType() );
	}

	const XMLCh* CFLibXmlCoreLineCountBinInputStream::getEncoding() const {
		return( chainedInput->getEncoding() );
	}

	XMLSize_t CFLibXmlCoreLineCountBinInputStream::readBytes( XMLByte *const toFill, const XMLSize_t maxToRead ) {
		XMLSize_t actuallyRead = chainedInput->readBytes( toFill, maxToRead );
		if( actuallyRead > 0 ) {
			for( XMLSize_t i = 0; i < actuallyRead; i++ ) {
				if( toFill[i] == '\n' ) {
					myLineNumber ++;
					myColNumber = 0;
				}
				else {
					myColNumber ++;
				}
			}
		}
		return( actuallyRead );
	}
}
