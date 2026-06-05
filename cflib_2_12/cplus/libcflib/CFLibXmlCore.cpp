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

#include <cflib/CFLibXmlCore.hpp>
#include <cflib/CFLibXmlCoreParser.hpp>

namespace cflib {

	const std::string CFLibXmlCore::CLASS_NAME( "CFLibXmlCore" );

	volatile bool CFLibXmlCore::initialized = false;

	CFLibXmlCore::CFLibXmlCore() {
	}

	CFLibXmlCore::~CFLibXmlCore() {
	}

	bool CFLibXmlCore::isInitialized() {
		return( initialized );
	}

	void CFLibXmlCore::init() {
		static const std::string S_ProcName( "init" );
		if( initialized ) {
			return;
		}
		try {
			if( ! CFLib::isInitialized() ) {
				throw CFLibUsageException( CLASS_NAME,
					S_ProcName,
					CFLib::S_MsgInitMustBeCalledFirst );
			}
			xercesc::XMLPlatformUtils::Initialize();
			initialized = true;
			CFLibXmlCoreParser::init();
		}
		catch( const xercesc::XMLException& ) {
			try {
				CFLibXmlCoreParser::release();
			}
			catch( ... ) {
			}
			initialized = false;
		}
	}

	void CFLibXmlCore::release() {
		if( ! initialized ) {
			return;
		}
		try {
			CFLibXmlCoreParser::release();
		}
		catch( ... ) {
		}
		try {
			xercesc::XMLPlatformUtils::Terminate();
			initialized = false;
		}
		catch( const xercesc::XMLException& ) {
			initialized = false;
		}
	}
}
