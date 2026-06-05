/*
 *  MSS Code Factory CFLib 2.11
 *
 *	Copyright (c) 2019 Mark Stephen Sobkow
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

using System;
using System.Globalization;

namespace CFLib
{
	public interface ICFLibXmlCoreContextFactory {

		/**
		 *	Get the application processing logger.
		 *
		 *	@return	The application processing Log4J Logger.
		 */
		ICFLibMessageLog getLog();

		/**
		 *	Copy an XML Core Context.
		 *
		 *	@param	src	The context to copy.
		 *	@param	qName	The QName of the element about to be processed.
		 *	@param	handler	The XmlCoreElementHandler which will be used for processing.
		 */
		CFLibXmlCoreContext newXmlCoreContext(
			CFLibXmlCoreContext src,
			String qName,
			CFLibXmlCoreElementHandler handler );

		/**
		 *	Construct a "root" XML Core Context instance.
		 *
		 *	@param	coreParser	The parser which owns this instance.
		 *	@param	log	ICFLibMessageLog to use, if null, use parser's logger.
		 *	@param	handler	The XmlCoreElementHandler which will be processing the doc root.
		 */
		CFLibXmlCoreContext newXmlCoreContext(
			CFLibXmlCoreParser coreParser,
			ICFLibMessageLog jLogger,
			CFLibXmlCoreElementHandler elementHandler );
	}
}
