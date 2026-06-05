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
	public class CFLibUniqueIndexViolationException : CFLibArgumentException {

		protected String indexName = null;
		protected Object indexKey = null;

		public CFLibUniqueIndexViolationException(
			String msg )
		: base(msg)
		{
		}

		public CFLibUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey )
		: base(throwingType, methName,
				"Detected violation of unique index " + argIndexName
					+ ((argKey != null )
							? " for key " + argKey.ToString()
							: "" ) )
		{
			indexName = argIndexName;
			indexKey = argKey;
		}

		public CFLibUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey,
			Exception th )
		: base(throwingType, methName,
					"Detected violation of unique index " + argIndexName
						+ ((argKey != null )
								? " for key " + argKey.ToString()
								: "" ),
					th )
		{
			indexName = argIndexName;
			indexKey = argKey;
		}
		
		public String getIndexName() {
			return( indexName );
		}
		
		public Object getIndexKey() {
			return( indexKey );
		}
	}
}
