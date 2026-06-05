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
	public class CFLibArgumentRangeException : CFLibArgumentException {

		protected Object objValue = null;
		protected Object objMin = null;
		protected Object objMax = null;

		public CFLibArgumentRangeException(
			String msg )
		: base(msg )
		{
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(throwingType, methName, argNo, argName, msg)
		{
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		: base(throwingType, methName, argNo, argName, msg, th)
		{
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt16(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt16(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt16(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt16(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt32(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt32(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt32(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt32(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt64(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt64(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt64(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt64(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatSingle(minValue )
					+ ".."
					+ CFLibXmlUtil.formatSingle(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatSingle(minValue )
					+ ".."
					+ CFLibXmlUtil.formatSingle(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatDouble(minValue )
					+ ".."
					+ CFLibXmlUtil.formatDouble(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatDouble(minValue )
					+ ".."
					+ CFLibXmlUtil.formatDouble(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
					"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String msg )
		: base(fieldName, msg)
		{
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			String msg )
		: base(fieldName, methName, msg)
		{
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		: base(fieldName, methName, msg, th)
		{
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(fieldName, methName, argNo, argName, msg)
		{
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		: base(fieldName, methName, argNo, argName, msg, th)
		{
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt16(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt16(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt16(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt16(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt32(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt32(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt32(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt32(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt64(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt64(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatInt64(minValue )
					+ ".."
					+ CFLibXmlUtil.formatInt64(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatSingle(minValue )
					+ ".."
					+ CFLibXmlUtil.formatSingle(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatSingle(minValue )
					+ ".."
					+ CFLibXmlUtil.formatSingle(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatDouble(minValue )
					+ ".."
					+ CFLibXmlUtil.formatDouble(maxValue ) )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble(argValue )
					+ " is out of the range " + CFLibXmlUtil.formatDouble(minValue )
					+ ".."
					+ CFLibXmlUtil.formatDouble(maxValue ),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public CFLibArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
					"value " + argValue.ToString()
					+ " is out of the range " + minValue.ToString()
					+ ".."
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMin = minValue;
			objMax = maxValue;
		}

		public Object getValue() {
			return( objValue );
		}
		
		public Object getMin() {
			return( objMin );
		}
		
		public Object getMax() {
			return( objMax );
		}
	}
}
