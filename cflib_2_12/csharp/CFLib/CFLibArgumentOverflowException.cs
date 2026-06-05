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
	public class CFLibArgumentOverflowException : CFLibArgumentException {

		protected Object objValue = null;
		protected Object objMax = null;

		public CFLibArgumentOverflowException(
			String msg )
		: base(msg )
		{
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg )
		: base(throwingType, methName, msg)
		{
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		: base(throwingType, methName, msg, th)
		{
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(throwingType, methName, argNo, argName, msg)
		{
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		:	base(throwingType, methName, argNo, argName, msg, th)
		{
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt16(maxValue ) )
		{
			objValue = (Int16)argValue;
			objMax = (Int16)maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt16(maxValue ),
				th )
		{
            objValue = (Int16)argValue;
            objMax = (Int16)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt32(maxValue ) )
		{
            objValue = (Int32)argValue;
            objMax = (Int32)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt32(maxValue ),
				th )
		{
            objValue = (Int32)argValue;
            objMax = (Int32)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt64(maxValue ) )
		{
            objValue = (Int64)argValue;
            objMax = (Int64)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt64(maxValue ),
				th )
		{
            objValue = (Int64)argValue;
            objMax = (Int64)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatSingle(maxValue ) )
		{
			objValue = (Single)argValue;
			objMax = (Single)maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatSingle(maxValue ),
				th )
		{
            objValue = (Single)argValue;
            objMax = (Single)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatDouble(maxValue ) )
		{
            objValue = (Double)argValue;
            objMax = (Double)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatDouble(maxValue ),
				th )
		{
            objValue = (Double)argValue;
            objMax = (Double)maxValue;
        }

        public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th )
		: base(throwingType, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String msg )
		: base(fieldName, msg)
		{
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			String msg )
		: base(fieldName, methName, msg)
		{
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		: base(fieldName, methName, msg, th)
		{
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg )
		: base(fieldName, methName, argNo, argName, msg)
		{
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String msg,
			Exception th )
		: base(fieldName, methName, argNo, argName, msg, th)
		{
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt16(maxValue ) )
		{
			objValue = (Int16)argValue;
			objMax = (Int16)maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt16( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt16(maxValue ),
				th )
		{
            objValue = (Int16)argValue;
            objMax = (Int16)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt32(maxValue ) )
		{
            objValue = (Int32)argValue;
            objMax = (Int32)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt32( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt32(maxValue ),
				th )
		{
            objValue = (Int32)argValue;
            objMax = (Int32)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt64(maxValue ) )
		{
            objValue = (Int64)argValue;
            objMax = (Int64)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatInt64( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatInt64(maxValue ),
				th )
		{
            objValue = (Int64)argValue;
            objMax = (Int64)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatSingle(maxValue ) )
		{
			objValue = (Single)argValue;
			objMax = (Single)maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatSingle( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatSingle(maxValue ),
				th )
		{
            objValue = (Single)argValue;
            objMax = (Single)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatDouble(maxValue ) )
		{
            objValue = (Double)argValue;
            objMax = (Double)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + CFLibXmlUtil.formatDouble( argValue )
					+ " must be no more than "
					+ CFLibXmlUtil.formatDouble(maxValue ),
				th )
		{
            objValue = (Double)argValue;
            objMax = (Double)maxValue;
        }

        public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString() )
		{
			objValue = argValue;
			objMax = maxValue;
		}

		public CFLibArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th )
		: base(fieldName, methName, argNo, argName,
				"value " + argValue.ToString()
					+ " must be no more than "
					+ maxValue.ToString(),
				th )
		{
			objValue = argValue;
			objMax = maxValue;
		}
		
		public Object getValue() {
			return( objValue );
		}
		
		public Object getMax() {
			return( objMax );
		}
	}
}
