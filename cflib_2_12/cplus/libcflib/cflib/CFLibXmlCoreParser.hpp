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

#include <xercesc/validators/common/Grammar.hpp>
#include <xercesc/framework/XMLGrammarPool.hpp>
#include <xercesc/framework/XMLGrammarPoolImpl.hpp>
#include <xercesc/framework/XMLGrammarDescription.hpp>
#include <xercesc/sax/Locator.hpp>
#include <xercesc/sax2/SAX2XMLReader.hpp>
#include <xercesc/sax2/XMLReaderFactory.hpp>
#include <xercesc/sax2/DefaultHandler.hpp>
#include <xercesc/util/Xerces_autoconf_config.hpp>
#include <xercesc/util/XMLString.hpp>

#include <cflib/CFLib.hpp>
#include <cflib/ICFLibMessageLog.hpp>
#include <cflib/CFLibXmlUtil.hpp>
#include <cflib/CFLibXmlCoreContext.hpp>
#include <cflib/ICFLibXmlCoreContextFactory.hpp>

namespace cflib {

	class CFLibXmlCoreParser
	: public xercesc::DefaultHandler,
	  public ICFLibXmlCoreContextFactory
	{

	public:
		static const bool DEFAULT_XINCLUDE;
		static const bool DEFAULT_SECURE_PROCESSING;

	private:
		ICFLibMessageLog* log;
		CFLibXmlCoreElementHandler* rootElementHandler;
		std::vector<CFLibXmlCoreContext*>* contextStack;
		ICFLibXmlCoreContextFactory* xmlCoreContextFactory;
		static xercesc::XMLGrammarPoolImpl* grammarPool;
		xercesc::Locator* docLocator;

	public:

		const static std::string CLASS_NAME;

		static bool isInitialized();
		static void init();
		static void release();

		CFLibXmlCoreParser();
		CFLibXmlCoreParser( ICFLibMessageLog* jlog );
		virtual ~CFLibXmlCoreParser();

		static xercesc::XMLGrammarPool* getGrammarPool();
	
		static xercesc::Grammar* addToGrammarPool( const std::string& name, xercesc::Grammar* grammar );

		virtual const xercesc::Locator* getDocumentLocator() const;
		virtual void setDocumentLocator( xercesc::Locator* newLocator );

		virtual ICFLibMessageLog* getLog() const;
		virtual void setLog( ICFLibMessageLog* jlog );

		CFLibXmlCoreElementHandler* getRootElementHandler();

	protected:
		void setRootElementHandler( CFLibXmlCoreElementHandler* handler );

	public:
		std::string getLocationInfo();

		CFLibXmlCoreContext* getCurContext();

		ICFLibXmlCoreContextFactory* getXmlCoreContextFactory();

		void setXmlCoreContextFactory( ICFLibXmlCoreContextFactory* factory );

		virtual CFLibXmlCoreContext* newXmlCoreContext(
			CFLibXmlCoreContext* src,
	        const XMLCh* const qName,
			CFLibXmlCoreElementHandler* handler ) const;

		virtual CFLibXmlCoreContext* newXmlCoreContext(
			CFLibXmlCoreParser* coreParser,
			ICFLibMessageLog* jlog,
			CFLibXmlCoreElementHandler* handler ) const;
	
		virtual void clearElementText();
		virtual std::string getElementText();

	protected:
		std::string formatMessage( const xercesc::SAXParseException& ex );

	public:
		virtual void warning( const xercesc::SAXParseException& ex );
		virtual void error( const xercesc::SAXParseException& ex );
		virtual void fatalError( const xercesc::SAXParseException& ex );

		std::string getFormattedNearLocation();

	    virtual void startElement(
	        const XMLCh* const uri,
	        const XMLCh* const localname,
	        const XMLCh* const qname,
	        const xercesc::Attributes& attrs );

	    virtual void endElement (
			const XMLCh* const uri,
			const XMLCh* const localname,
			const XMLCh* const qname );

    	virtual void characters (
			const XMLCh* const chars,
			const XMLSize_t length );

	protected:
		std::string* appendLocatorInformation( std::string* buff );

		virtual void initParser();
	};
}
