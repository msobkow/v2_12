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
	public class CFLibRuntimeException : Exception {

		Type throwType = null;
		String methodName = null;
		String msgDetail = null;

		public CFLibRuntimeException(
			String msg )
        : base( msg )
		{
		}

		public CFLibRuntimeException(
			Type throwingType,
			String methName,
			String msg )
        : base( throwingType.Namespace + "." + throwingType.Name
                    + (((methName != null ) && (methName.Length > 0 ))
							? "." + methName
							: "" )
						+ "() "
						+ (((msg != null ) && (msg.Length > 0 ) )
							? msg
							: "" ) )
		{
			throwType = throwingType;
			methodName = methName;
			msgDetail = msg;
		}

		public CFLibRuntimeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
        : base( throwingType.Namespace + "." + throwingType.Name
                        + (((methName != null ) && (methName.Length > 0 ))
							? "." + methName
							: "" )
						+ "() "
						+ (((msg != null ) && (msg.Length > 0 ) )
							? msg
							: "" ),
					th )
		{
			throwType = throwingType;
			methodName = methName;
			msgDetail = msg;
		}
		
		public Type getThrowingType() {
			return( throwType );
		}
		
		public String getMethodName() {
			return( methodName );
		}
		
		public String getMessageDetail() {
			return( msgDetail );
		}

		public CFLibRuntimeException(
			String fieldName,
			String msg )
        : base( msg )
		{
		}

		public CFLibRuntimeException(
			String fieldName,
			String methName,
			String msg)
        : base( fieldName
						+ (((methName != null ) && (methName.Length > 0 ))
							? "." + methName
							: "" )
						+ "() "
						+ (((msg != null ) && (msg.Length > 0 ) )
							? msg
							: "" ) )

        {
 			throwType = null;
			methodName = methName;
			msgDetail = msg;
		}

		public CFLibRuntimeException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
        : base( fieldName
                        + ( ( ( methName != null ) && ( methName.Length > 0 ))
							? "." + methName
							: "" )
						+ "() "
						+ ( ( ( msg != null ) && ( msg.Length > 0 ) )
							? msg
							: "" ),
					th )
        {
			throwType = null;
			methodName = methName;
			msgDetail = msg;
		}
	}
}
