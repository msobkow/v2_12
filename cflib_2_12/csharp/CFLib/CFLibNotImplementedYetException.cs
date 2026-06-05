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
	public class CFLibNotImplementedYetException : CFLibArgumentException {

		public CFLibNotImplementedYetException(
			String msg )
		: base(msg)
		{
		}

		public CFLibNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibNotImplementedYetException(
			Type throwingType,
			String methName )
		: base(throwingType, methName, "Not implemented yet")
		{
		}

		public CFLibNotImplementedYetException(
			Type throwingType,
			String methName,
			Exception th )
		: base(throwingType, methName, "Not implemented yet", th )
		{
		}
	}
}
