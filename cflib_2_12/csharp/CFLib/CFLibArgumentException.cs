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
	public class CFLibArgumentException : CFLibRuntimeException {

		protected int argumentNum = 0;
		protected String argumentName = null;

		public CFLibArgumentException(
			String msg )
        : base( msg )
		{
		}

		public CFLibArgumentException(
			Type throwingType,
			String methName,
			String msg )
        : base( throwingType, methName, msg )
		{
		}

		public CFLibArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
        : base(throwingType, methName, msg, th)
        {
		}

		public CFLibArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg )
        : base(throwingType, methName,
					" Argument " + argNo + " (" + argName + ") "
					+ msg )
		{
			argumentNum = argNo;
			argumentName = argName;
		}

		public CFLibArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
        : base(throwingType, methName,
                    " Argument " + argNo + " (" + argName + ") "
                    + msg,
                th)
        {
			argumentNum = argNo;
			argumentName = argName;
		}

		public CFLibArgumentException(
			String fieldName,
			String msg )
        : base(fieldName, msg )
		{
		}

		public CFLibArgumentException(
			String fieldName,
			String methName,
			String msg )
        : base(fieldName, methName, msg )
		{
		}

		public CFLibArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
        : base(fieldName, methName, msg, th )
		{
		}

		public CFLibArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg )
        : base(fieldName, methName,
					" Argument " + argNo + " (" + argName + ") "
					+ msg )
		{
			argumentNum = argNo;
			argumentName = argName;
		}

		public CFLibArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
        : base(fieldName, methName,
					" Argument " + argNo + " (" + argName + ") "
					+ msg,
                th )
		{
			argumentNum = argNo;
			argumentName = argName;
		}
		
		public int getArgumentNum() {
			return( argumentNum );
		}
		
		public String getArgumentName() {
			return( argumentName );
		}
	}
}
