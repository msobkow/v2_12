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
	public class CFLibUnresolvedRelationException : CFLibArgumentException {

		protected String relnType = null;
		protected String relnName = null;
		protected String relnTarget = null;
		protected Object pkey = null;

		public CFLibUnresolvedRelationException(
			String msg )
		: base(msg)
		{
		}

		public CFLibUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey )
		: base(throwingType, methName,
                relationType + " relation " + relationName
					+ ((argKey != null ) ? " key " + argKey.ToString() : "" )
					+ " referencing " + targetName
					+ " could not be resolved" )
		{
			relnType = relationType;
			relnName = relationName;
			relnTarget = targetName;
			pkey = argKey;
		}

		public CFLibUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey,
			Exception th )
		: base(throwingType, methName,
                    relationType + " relation " + relationName
						+ ((argKey != null ) ? " key " + argKey.ToString() : "" )
						+ " referencing " + targetName
						+ " could not be resolved",
					th )
		{
			relnType = relationType;
			relnName = relationName;
			relnTarget = targetName;
			pkey = argKey;
		}

		public String getRelationType() {
			return( relnType );
		}
		
		public String getRelationName() {
			return( relnName );
		}
		
		public Object getPrimaryKey() {
			return( pkey );
		}
	}
}
