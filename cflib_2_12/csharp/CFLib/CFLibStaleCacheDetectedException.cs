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
	public class CFLibStaleCacheDetectedException : CFLibArgumentException {

		protected String staleCause = null;
		protected String targetName = null;
		protected Object pkey = null;

		public CFLibStaleCacheDetectedException(
			String msg )
		: base(msg)
		{
		}
		
		public CFLibStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey )
		: base(throwingType, methName,
				"Stale cache detected due to " + msgCause
					+ (((targetTable != null ) && (targetTable.Length > 0 ) )
							? " by " + targetTable
							: "" )
					+ ((argKey != null )
							? " key " + argKey.ToString()
							: "" ) )
		{
			staleCause = msgCause;
			targetName = targetTable;
			pkey = argKey;
		}

		public CFLibStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey,
			Exception th )
		: base(throwingType, methName,
					"Stale cache detected due to " + msgCause
						+ (((targetTable != null ) && (targetTable.Length > 0 ) )
								? " by " + targetTable
								: "" )
						+ ((argKey != null )
								? " key " + argKey.ToString()
								: "" ),
					th )
		{
			staleCause = msgCause;
			targetName = targetTable;
			pkey = argKey;
		}

		public String getStaleCause() {
			return( staleCause );
		}
		
		public String getTargetName() {
			return( targetName );
		}
		
		public Object getPrimaryKey() {
			return( pkey );
		}
	}
}
