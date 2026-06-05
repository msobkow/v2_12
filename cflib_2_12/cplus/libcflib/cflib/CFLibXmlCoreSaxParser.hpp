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
#include <mpfr.h>
#include <time.h>

#include <array>
#include <cassert>
#include <cstddef>
#include <cstdint>
#include <chrono>
#include <ctime>
#include <list>
#include <string>
#include <tuple>
#include <vector>

#include <xercesc/framework/MemBufInputSource.hpp>
#include <xercesc/framework/XMLGrammarPool.hpp>
#include <xercesc/framework/XMLGrammarPoolImpl.hpp>
#include <xercesc/framework/XMLGrammarDescription.hpp>
#include <xercesc/parsers/SAXParser.hpp>
#include <xercesc/sax/Locator.hpp>
#include <xercesc/sax/SAXException.hpp>
#include <xercesc/sax/SAXParseException.hpp>
#include <xercesc/sax2/SAX2XMLReader.hpp>
#include <xercesc/sax2/XMLReaderFactory.hpp>
#include <xercesc/sax2/DefaultHandler.hpp>
#include <xercesc/util/Xerces_autoconf_config.hpp>
#include <xercesc/util/XMLString.hpp>
#include <xercesc/validators/common/Grammar.hpp>

#include <cflib/CFLib.hpp>
#include <cflib/ICFLibMessageLog.hpp>
#include <cflib/CFLibXmlUtil.hpp>
#include <cflib/CFLibXmlCoreContext.hpp>
#include <cflib/ICFLibXmlCoreContextFactory.hpp>
#include <cflib/CFLibXmlCoreParser.hpp>
#include <cflib/CFLibXmlCoreLineCountMemBufInputSource.hpp>

namespace cflib {

	class CFLibXmlCoreSaxParser	: public CFLibXmlCoreParser	{

	protected:
		xercesc::SAX2XMLReader* saxXmlReader;
		cflib::CFLibXmlCoreLineCountMemBufInputSource* memBufInputSource;

	public:
		const static std::string CLASS_NAME;
		const static std::string S_SaxXmlReaderMustBeInitialized;

		CFLibXmlCoreSaxParser();
		CFLibXmlCoreSaxParser( ICFLibMessageLog* jLogger );
		virtual ~CFLibXmlCoreSaxParser();

	protected:
		virtual void initParser();

	public:

		/**
		 *	Load the specified XSD file.
		 *
		 *	@param	xsdFileName - The file system name of the XSD file to be loaded
		 *
		 *	@returns The cached grammar instance resolved by loading the XSD file.
		 */
		xercesc::Grammar* loadGrammar( const std::string& xsdFileName );

		/**
		 *	Parse the specified URI
		 *
		 *	@param	uri - The URI for the document to parse.
		 */
		virtual void parse( const char* systemid );

		/**
		 *	Parse the specified string contents.
		 *	<p>
		 *	The string passed to this method is typically
		 *	a request or response XML document to be processed
		 *	by an appropriate parser and applied to a storage
		 *	server layer.
		 *
		 *	@param The name of the buffer to use in location information.
		 *	@param	str The string contents to be parsed.
		 */
		virtual void parseStringContents( const std::string& buffname, const std::string& str );

		/**
		 *	Parse the specified InputSource.
		 *	<p>
		 *	The InputSource passed to this method is typically
		 *	a piece of glue tying together some other objects output
		 *	as the input for a parse.
		 *
		 *	@param	src The InputSource contents to be parsed.
		 */
		virtual void parse( const xercesc::InputSource& src );
	};
}
