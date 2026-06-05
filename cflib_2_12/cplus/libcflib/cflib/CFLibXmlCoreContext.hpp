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
#include <map>
#include <string>
#include <tuple>
#include <vector>

#include <xercesc/sax2/SAX2XMLReader.hpp>
#include <xercesc/sax2/XMLReaderFactory.hpp>
#include <xercesc/sax2/DefaultHandler.hpp>
#include <xercesc/util/XMLString.hpp>

#include <cflib/CFLib.hpp>
#include <cflib/ICFLibAnyObj.hpp>
#include <cflib/ICFLibMessageLog.hpp>
#include <cflib/CFLibNullArgumentException.hpp>
#include <cflib/CFLibUnresolvedRelationException.hpp>
#include <cflib/CFLibUsageException.hpp>

namespace cflib {

	class CFLibXmlCoreParser;
	class CFLibXmlCoreElementHandler;

	class CFLibXmlCoreContext {

	private:

		CFLibXmlCoreContext* prevContext;
		std::string elementText;
		CFLibXmlCoreElementHandler* elementHandler;
		ICFLibMessageLog* log;
		CFLibXmlCoreParser* parser;
		std::string* elementQName;
		std::map<std::string,std::string> tagMap;
		ICFLibAnyObj* obj;

	public:
		const static std::string CLASS_NAME;

		CFLibXmlCoreContext(
			CFLibXmlCoreContext* src,
	        const XMLCh* const qName,
			CFLibXmlCoreElementHandler* handler );

		CFLibXmlCoreContext(
			CFLibXmlCoreParser* coreParser,
			ICFLibMessageLog* jlog,
			CFLibXmlCoreElementHandler* handler );

		virtual ~CFLibXmlCoreContext();

		CFLibXmlCoreContext* getPrevContext() const;

		bool hasNamedTag( const std::string& key ) const;
		const std::string& getNamedTag( const std::string& key ) const;
		void putNamedTag( const std::string& key, const std::string& tag );

		ICFLibAnyObj* getObj() const;
		void setObj( ICFLibAnyObj* value );

		CFLibXmlCoreParser* getParser();

	protected:
		void setParser( CFLibXmlCoreParser* coreParser );

	public:
		ICFLibMessageLog* getLog() const;
		void setLog( ICFLibMessageLog* jlog );

		void clearElementText();
		std::string getElementText() const;
		void appendElementText( const XMLCh* chars, std::string::size_type length );
	
		CFLibXmlCoreElementHandler* getElementHandler() const;

	protected:
		void setElementHandler( CFLibXmlCoreElementHandler* handler );

	public:
		void setQNameElementHandler( const XMLCh* const qName, CFLibXmlCoreElementHandler* handler );
	};
}
