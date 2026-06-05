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
	public class CFLibInvalidArgumentException : CFLibArgumentException {

		public CFLibInvalidArgumentException(
			String msg )
		: base(msg)
		{
		}

		public CFLibInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(throwingType, methName, argNo, argName, msg)
		{
		}

		public CFLibInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		: base(throwingType, methName, argNo, argName, msg, th)
		{
		}

		public CFLibInvalidArgumentException(
			String fieldName,
			String msg )
		: base(fieldName, msg)
		{
		}

		public CFLibInvalidArgumentException(
			String fieldName,
			String methName,
			String msg )
		: base(fieldName, methName, msg)
		{
		}

		public CFLibInvalidArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		: base(fieldName, methName, msg, th)
		{
		}

		public CFLibInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(fieldName, methName, argNo, argName, msg)
		{
		}

		public CFLibInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		: base(fieldName, methName, argNo, argName, msg, th)
		{
		}
	}
}
