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

#include <xercesc/sax2/SAX2XMLReader.hpp>
#include <xercesc/sax2/XMLReaderFactory.hpp>
#include <xercesc/sax2/DefaultHandler.hpp>
#include <xercesc/util/XMLString.hpp>

#include <cflib/CFLib.hpp>
#include <cflib/ICFLibAnyObj.hpp>
#include <cflib/ICFLibMessageLog.hpp>

namespace cflib {

	class CFLibXmlCoreContext;
	class CFLibXmlCoreElementHandler;
	class CFLibXmlCoreParser;

	class ICFLibXmlCoreContextFactory {

	public:
		ICFLibXmlCoreContextFactory() {
		}

		virtual ~ICFLibXmlCoreContextFactory() {
		}

		virtual ICFLibMessageLog* getLog() const = 0;

		virtual CFLibXmlCoreContext* newXmlCoreContext(
			CFLibXmlCoreContext* parent,
			const XMLCh* qName,
			CFLibXmlCoreElementHandler* handler ) const = 0;

		virtual CFLibXmlCoreContext* newXmlCoreContext(
			CFLibXmlCoreParser* coreParser,
			ICFLibMessageLog* jLogger,
			CFLibXmlCoreElementHandler* handler ) const = 0;
	};
}
