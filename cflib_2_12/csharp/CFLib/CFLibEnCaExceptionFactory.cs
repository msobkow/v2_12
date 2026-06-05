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
	public class CFLibEnCaExceptionFactory : ICFLibExceptionFactory {

		public CFLibEnCaExceptionFactory() {
		}

		public CFLibRuntimeException newRuntimeException(
			String msg )
		{
			CFLibRuntimeException ret = new CFLibRuntimeException( msg );
			return( ret );
		}

		public CFLibRuntimeException newRuntimeException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibRuntimeException ret = new CFLibRuntimeException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibRuntimeException newRuntimeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibRuntimeException ret = new CFLibRuntimeException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibUsageException newUsageException(
			String msg )
		{
			CFLibUsageException ret = new CFLibUsageException( msg );
			return( ret );
		}

		public CFLibUsageException newUsageException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibUsageException ret = new CFLibUsageException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibUsageException newUsageException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibUsageException ret = new CFLibUsageException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibEmptyArgumentException newEmptyArgumentException(
			String msg )
		{
			CFLibEmptyArgumentException ret = new CFLibEmptyArgumentException( msg );
			return( ret );
		}

		public CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibEmptyArgumentException ret = new CFLibEmptyArgumentException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibEmptyArgumentException ret = new CFLibEmptyArgumentException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName )
		{
			CFLibEmptyArgumentException ret = new CFLibEmptyArgumentException(
				throwingType,
				methName,
				argNo,
				argName );
			return( ret );
		}

		public CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Exception th )
		{
			CFLibEmptyArgumentException ret = new CFLibEmptyArgumentException(
				throwingType,
				methName,
				argNo,
				argName,
				th );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String msg )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException( msg );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				throwingType,
				methName,
				argNo,
				argName );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Exception th )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				throwingType,
				methName,
				argNo,
				argName,
				th );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String msg )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException( fieldName, msg );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			String msg )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				fieldName,
				methName,
				msg );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				fieldName,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				fieldName,
				methName,
				argNo,
				argName );
			return( ret );
		}

		public CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Exception th )
		{
			CFLibNullArgumentException ret = new CFLibNullArgumentException(
				fieldName,
				methName,
				argNo,
				argName,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String msg )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException( msg );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String msg )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException( fieldName, msg );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			String msg )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue,
            Exception th)
        {
            CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th )
		{
			CFLibArgumentRangeException ret = new CFLibArgumentRangeException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String msg )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException( msg );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Object argValue )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				throwingType,
				methName,
				argNo,
				argName,
				"Value "
					+ ( ( argValue == null )
							? "null"
							: argValue.ToString() )
					+ " is invalid" );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Object argValue,
			Exception th )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				throwingType,
				methName,
				argNo,
				argName,
				"Value "
					+ ( ( argValue == null )
							? "null"
							: argValue.ToString() )
					+ " is invalid - "
					+ th.Message,
				th );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String msg )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException( fieldName, msg );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			String msg )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				fieldName,
				methName,
				msg );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				fieldName,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Object argValue )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				fieldName,
				methName,
				argNo,
				argName,
				"Value "
					+ ( ( argValue == null )
							? "null"
							: argValue.ToString() )
					+ " is invalid" );
			return( ret );
		}

		public CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Object argValue,
			Exception th )
		{
			CFLibInvalidArgumentException ret = new CFLibInvalidArgumentException(
				fieldName,
				methName,
				argNo,
				argName,
				"Value "
					+ ( ( argValue == null )
							? "null"
							: argValue.ToString() )
					+ " is invalid - "
					+ th.Message,
				th );
			return( ret );
		}

		public CFLibMustOverrideException newMustOverrideException(
			String msg )
		{
			CFLibMustOverrideException ret = new CFLibMustOverrideException( msg );
			return( ret );
		}

		public CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			String msg)
		{
			CFLibMustOverrideException ret = new CFLibMustOverrideException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibMustOverrideException ret = new CFLibMustOverrideException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName )
		{
			CFLibMustOverrideException ret = new CFLibMustOverrideException(
				throwingType,
				methName );
			return( ret );
		}

		public CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			Exception th )
		{
			CFLibMustOverrideException ret = new CFLibMustOverrideException(
				throwingType,
				methName,
				th );
			return( ret );
		}

		public CFLibNotImplementedYetException newNotImplementedYetException(
			String msg )
		{
			CFLibNotImplementedYetException ret = new CFLibNotImplementedYetException( msg );
			return( ret );
		}

		public CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibNotImplementedYetException ret = new CFLibNotImplementedYetException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibNotImplementedYetException ret = new CFLibNotImplementedYetException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName )
		{
			CFLibNotImplementedYetException ret = new CFLibNotImplementedYetException(
				throwingType,
				methName );
			return( ret );
		}

		public CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			Exception th )
		{
			CFLibNotImplementedYetException ret = new CFLibNotImplementedYetException(
				throwingType,
				methName,
				th );
			return( ret );
		}

		public CFLibNotSupportedException newNotSupportedException(
			String msg )
		{
			CFLibNotSupportedException ret = new CFLibNotSupportedException( msg );
			return( ret );
		}

		public CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibNotSupportedException ret = new CFLibNotSupportedException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibNotSupportedException ret = new CFLibNotSupportedException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName )
		{
			CFLibNotSupportedException ret = new CFLibNotSupportedException(
				throwingType,
				methName );
			return( ret );
		}

		public CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			Exception th )
		{
			CFLibNotSupportedException ret = new CFLibNotSupportedException(
				throwingType,
				methName,
				th );
			return( ret );
		}

		public CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
			String msg )
		{
			CFLibPrimaryKeyNotNewException ret = new CFLibPrimaryKeyNotNewException( msg );
			return( ret );
		}

		public CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
				Type throwingType,
				String methName,
				String msg )
		{
			CFLibPrimaryKeyNotNewException ret = new CFLibPrimaryKeyNotNewException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
				Type throwingType,
				String methName,
				String msg,
				Exception th )
		{
			CFLibPrimaryKeyNotNewException ret = new CFLibPrimaryKeyNotNewException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
				Type throwingType,
				String methName,
				Object argKey )
		{
			CFLibPrimaryKeyNotNewException ret = new CFLibPrimaryKeyNotNewException(
				throwingType,
				methName,
				argKey );
			return( ret );
		}

		public CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
				Type throwingType,
				String methName,
				Object argKey,
				Exception th )
		{
			CFLibPrimaryKeyNotNewException ret = new CFLibPrimaryKeyNotNewException(
				throwingType,
				methName,
				argKey,
				th );
			return( ret );
		}

		public CFLibUnresolvedRelationException newUnresolvedRelationException(
			String msg )
		{
			CFLibUnresolvedRelationException ret = new CFLibUnresolvedRelationException( msg );
			return( ret );
		}

		public CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibUnresolvedRelationException ret = new CFLibUnresolvedRelationException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibUnresolvedRelationException ret = new CFLibUnresolvedRelationException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey )
		{
			CFLibUnresolvedRelationException ret = new CFLibUnresolvedRelationException(
				throwingType,
				methName,
				relationType,
				relationName,
				targetName,
				argKey );
			return( ret );
		}

		public CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey,
			Exception th )
		{
			CFLibUnresolvedRelationException ret = new CFLibUnresolvedRelationException(
				throwingType,
				methName,
				relationType,
				relationName,
				targetName,
				argKey,
				th );
			return( ret );
		}

		public CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			String msg )
		{
			CFLibStaleCacheDetectedException ret = new CFLibStaleCacheDetectedException( msg );
			return( ret );
		}

		public CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibStaleCacheDetectedException ret = new CFLibStaleCacheDetectedException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibStaleCacheDetectedException ret = new CFLibStaleCacheDetectedException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey )
		{
			CFLibStaleCacheDetectedException ret = new CFLibStaleCacheDetectedException(
				throwingType,
				methName,
				msgCause,
				targetTable,
				argKey );
			return( ret );
		}

		public CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey,
			Exception th )
		{
			CFLibStaleCacheDetectedException ret = new CFLibStaleCacheDetectedException(
				throwingType,
				methName,
				msgCause,
				targetTable,
				argKey,
				th );
			return( ret );
		}

		public CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			String msg )
		{
			CFLibUniqueIndexViolationException ret = new CFLibUniqueIndexViolationException( msg );
			return( ret );
		}

		public CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibUniqueIndexViolationException ret = new CFLibUniqueIndexViolationException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibUniqueIndexViolationException ret = new CFLibUniqueIndexViolationException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey )
		{
			CFLibUniqueIndexViolationException ret = new CFLibUniqueIndexViolationException(
				throwingType,
				methName,
				argIndexName,
				argKey );
			return( ret );
		}

		public CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey,
			Exception th )
		{
			CFLibUniqueIndexViolationException ret = new CFLibUniqueIndexViolationException(
				throwingType,
				methName,
				argIndexName,
				argKey,
				th );
			return( ret );
		}

		public CFLibCollisionDetectedException newCollisionDetectedException(
			String msg )
		{
			CFLibCollisionDetectedException ret = new CFLibCollisionDetectedException( msg );
			return( ret );
		}

		public CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibCollisionDetectedException ret = new CFLibCollisionDetectedException(
				throwingType,
				methName,
				msg );
			return( ret );
		}
		
		public CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibCollisionDetectedException ret = new CFLibCollisionDetectedException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			Object argKey )
		{
			CFLibCollisionDetectedException ret = new CFLibCollisionDetectedException(
				throwingType,
				methName,
				argKey );
			return( ret );
		}
		
		public CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			Object argKey,
			Exception th )
		{
			CFLibCollisionDetectedException ret = new CFLibCollisionDetectedException(
				throwingType,
				methName,
				argKey,
				th );
			return( ret );
		}

		public CFLibDependentsDetectedException newDependentsDetectedException(
			String msg )
		{
			CFLibDependentsDetectedException ret = new CFLibDependentsDetectedException( msg );
			return( ret );
		}

		public CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibDependentsDetectedException ret = new CFLibDependentsDetectedException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibDependentsDetectedException ret = new CFLibDependentsDetectedException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey )
		{
			CFLibDependentsDetectedException ret = new CFLibDependentsDetectedException(
				throwingType,
				methName,
				relationType,
				relationName,
				targetName,
				argKey );
			return( ret );
		}

		public CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey,
			Exception th )
		{
			CFLibDependentsDetectedException ret = new CFLibDependentsDetectedException(
				throwingType,
				methName,
				relationType,
				relationName,
				targetName,
				argKey,
				th );
			return( ret );
		}

		public CFLibUnsupportedClassException newUnsupportedClassException(
			String msg )
		{
			CFLibUnsupportedClassException ret = new CFLibUnsupportedClassException( msg );
			return( ret );
		}

		public CFLibUnsupportedClassException newUnsupportedClassException(
				Type throwingType,
				String methName,
				String msg )
		{
			CFLibUnsupportedClassException ret = new CFLibUnsupportedClassException(
					throwingType,
					methName,
					msg );
			return( ret );
		}

		public CFLibUnsupportedClassException newUnsupportedClassException(
				Type throwingType,
				String methName,
				String msg,
				Exception th )
		{
			CFLibUnsupportedClassException ret = new CFLibUnsupportedClassException(
					throwingType,
					methName,
					msg,
					th );
			return( ret );
		}

		public CFLibUnsupportedClassException newUnsupportedClassException(
				Type throwingType,
				String methName,
				String argObjName,
				Object argObj,
				String argExpectedClasses )
		{
			CFLibUnsupportedClassException ret = new CFLibUnsupportedClassException(
					throwingType,
					methName,
					argObjName,
					argObj,
					argExpectedClasses );
			return( ret );
		}

		public CFLibUnsupportedClassException newUnsupportedClassException(
				Type throwingType,
				String methName,
				String argObjName,
				Object argObj,
				String argExpectedClasses,
				Exception th )
		{
			CFLibUnsupportedClassException ret = new CFLibUnsupportedClassException(
					throwingType,
					methName,
					argObjName,
					argObj,
					argExpectedClasses,
					th );
			return( ret );
		}

		public CFLibDbException newDbException(
			String msg )
		{
			CFLibDbException ret = new CFLibDbException( msg );
			return( ret );
		}

		public CFLibDbException newDbException(
				Type throwingType,
				String methName,
				String msg )
		{
			CFLibDbException ret = new CFLibDbException(
					throwingType,
					methName,
					msg );
			return( ret );
		}

		public CFLibDbException newDbException(
				Type throwingType,
				String methName,
				Exception dbException )
		{
			CFLibDbException ret = new CFLibDbException(
					throwingType,
					methName,
					dbException );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String msg )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException( msg );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String msg )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException( fieldName, msg );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			String msg )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue,
            Exception th)
        {
            CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                maxValue,
                th);
            return (ret);
        }

        public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue );
			return( ret );
		}

		public CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th )
		{
			CFLibArgumentOverflowException ret = new CFLibArgumentOverflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				maxValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String msg )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException( msg );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			String msg )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                throwingType,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				throwingType,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String msg )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException( fieldName, msg );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			String msg )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				msg );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			String msg,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            Exception th)
        {
            CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
                fieldName,
                methName,
                argNo,
                argName,
                argValue,
                minValue,
                th);
            return (ret);
        }

        public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue );
			return( ret );
		}

		public CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			Exception th )
		{
			CFLibArgumentUnderflowException ret = new CFLibArgumentUnderflowException(
				fieldName,
				methName,
				argNo,
				argName,
				argValue,
				minValue,
				th );
			return( ret );
		}

		public CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
			String msg )
		{
			CFLibUnrecognizedAttributeException ret = new CFLibUnrecognizedAttributeException( msg );
			return( ret );
		}

		public CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
				Type throwingType,
				String methName,
				String msg )
		{
			CFLibUnrecognizedAttributeException ret = new CFLibUnrecognizedAttributeException(
				throwingType,
				methName,
				msg );
			return( ret );
		}

		public CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
				Type throwingType,
				String methName,
				String msg,
				Exception th )
		{
			CFLibUnrecognizedAttributeException ret = new CFLibUnrecognizedAttributeException(
				throwingType,
				methName,
				msg,
				th );
			return( ret );
		}

		public CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
				Type throwingType,
				String methName,
				String locInfo,
				String attrName )
		{
			CFLibUnrecognizedAttributeException ret = new CFLibUnrecognizedAttributeException(
				throwingType,
				methName,
				locInfo,
				attrName );
			return( ret );
		}

		public CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
				Type throwingType,
				String methName,
				String locInfo,
				String attrName,
				Exception th )
		{
			CFLibUnrecognizedAttributeException ret = new CFLibUnrecognizedAttributeException(
				throwingType,
				methName,
				locInfo,
				attrName,
				th );
			return( ret );
		}
	}
}
