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
	public class CFLibUnsupportedClassException : CFLibArgumentException {

		protected Object obj = null;
		protected String objName = null;
		protected String expectedClasses = null;

		public CFLibUnsupportedClassException(
			String msg )
		: base(msg)
		{
		}

		public CFLibUnsupportedClassException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibUnsupportedClassException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibUnsupportedClassException(
			Type throwingType,
			String methName,
			String argObjName,
			Object argObj,
			String argExpectedClasses )
		: base(throwingType, methName,
                    argObjName
					+ ((argObj == null )
							?	" is null"
							: 	" is a " + argObj.GetType().Name
									+ ", not a supprted instance of " + argExpectedClasses ) )
		{
			obj = argObj;
			objName = argObjName;
			expectedClasses = argExpectedClasses;
		}

		public CFLibUnsupportedClassException(
			Type throwingType,
			String methName,
			String argObjName,
			Object argObj,
			String argExpectedClasses,
			Exception th )
		: base(throwingType, methName,
                argObjName
					+ ((argObj == null )
							?	" is null"
							: 	" is a " + argObj.GetType().Name
                                    + ", not a supprted instance of " + argExpectedClasses ),
				th )
		{
			obj = argObj;
			objName = argObjName;
			expectedClasses = argExpectedClasses;
		}

		public String getObjectName() {
			return( objName );
		}
		
		public String getExpectedClasses() {
			return( expectedClasses );
		}
		
		public Object getObject() {
			return( obj );
		}
	}
}
