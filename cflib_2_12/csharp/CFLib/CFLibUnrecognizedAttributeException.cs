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
	public class CFLibUnrecognizedAttributeException : CFLibRuntimeException {

		protected String locationInfo = null;
		protected String attributeName = null;

		public CFLibUnrecognizedAttributeException(
			String msg )
		: base(msg)
		{
		}

		public CFLibUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String locInfo,
			String attrName )
		: base(throwingType,
                methName,
                (((locInfo != null ) && (locInfo.Length > 0 ))
						? locInfo + " "
						: "" )
					+ "Unrecognized attribute "
					+ (((attrName != null ) && (attrName.Length > 0 ))
							? "\"" + attrName + "\""
							: "null" ) )
		{
			locationInfo = locInfo;
			attributeName = attrName;
		}

		public CFLibUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String locInfo,
			String attrName,
			Exception th )
		: base(throwingType,
                methName,
                (((locInfo != null ) && (locInfo.Length > 0 ))
						? locInfo + " "
						: "" )
					+ "Unrecognized attribute "
					+ (((attrName != null ) && (attrName.Length > 0 ))
							? "\"" + attrName + "\""
							: "null" ),
				th )
		{
			locationInfo = locInfo;
			attributeName = attrName;
		}
		
		public String getLocationInfo() {
			return( locationInfo );
		}
		
		public void setLocationInfo( String value ) {
			locationInfo = value;
		}
		
		public String getAttributeName() {
			return( attributeName );
		}
		
		public void setAttributeName( String value ) {
			attributeName = value;
		}
	}
}
