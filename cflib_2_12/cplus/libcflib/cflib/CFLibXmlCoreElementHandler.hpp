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
#include <cflib/CFLibCollisionDetectedException.hpp>
#include <cflib/CFLibEmptyArgumentException.hpp>
#include <cflib/CFLibNullArgumentException.hpp>
#include <cflib/CFLibUnresolvedRelationException.hpp>
#include <cflib/CFLibUsageException.hpp>
#include <cflib/CFLibXmlCoreContext.hpp>
#include <cflib/CFLibXmlCoreParser.hpp>

namespace cflib {

	class CFLibXmlCoreElementHandler {

	private:
		CFLibXmlCoreParser* parser;
		std::map<std::string,CFLibXmlCoreElementHandler*> elementHandler;

	public:
		static const std::string CLASS_NAME;

		CFLibXmlCoreElementHandler( CFLibXmlCoreParser* coreParser );
		~CFLibXmlCoreElementHandler();

		virtual ICFLibMessageLog* getLog() const;
		virtual CFLibXmlCoreParser* getParser() const;

	protected:
		void setParser( CFLibXmlCoreParser* coreParser );

	public:
		void addElementHandler( const std::string& qName, CFLibXmlCoreElementHandler* handler );
		CFLibXmlCoreElementHandler* getElementHandler( const std::string& qName ) const;
		CFLibXmlCoreElementHandler* getElementHandler( const XMLCh* qName ) const;

		//	Element Event Handlers
		virtual void fatalError( const xercesc::SAXParseException& exception );

		/**
		 *	Receive notification of the beginning of an element.
		 *	<p>
		 *	@see org.xml.sax.ContentHandler
		 *
		 *	@param	uri	the Namespace URI, or the empty string if the
		 *				element has no Namespace URI or if Namespace
		 *				processing is not being performed
		 *	@param	localName	the local name (without prefix), or the
		 *						empty string if Namespace processing
		 *						is not being performed
		 *	@param	qName	the qualified name (with prefix), or the
		 *					empty string if qualified names are not available
		 *	@param	attrs	the attributes attached to the element.  If
		 *					there are no attributes, it shall be an empty
		 *					Attributes object.  The value of this object after
		 *					startElement returns is undefined.
		 *
		 *	@throws	org.xml.sax.SAXException any SAX exception, possibly
		 *			wrapping another exception
		 */
	    virtual void startElement(
	        const XMLCh* const uri,
	        const XMLCh* const localname,
	        const XMLCh* const qname,
	        const xercesc::Attributes& attrs ) = 0;

		/**
		 * Receive notification of the end of an element.
		 *
		 * <p>The SAX parser will invoke this method at the end of every
		 * element in the XML document; there will be a corresponding
		 * startElement() event for every endElement() event (even when the
		 * element is empty).</p>
		 *
		 * @param uri The URI of the associated namespace for this element
		 * @param localname The local part of the element name
		 * @param qname The QName of this element
		 * @exception SAXException Any SAX exception, possibly
		 *            wrapping another exception.
		 */
		virtual void endElement(
			const XMLCh* const uri,
			const XMLCh* const localname,
			const XMLCh* const qname ) = 0;
	};
}
