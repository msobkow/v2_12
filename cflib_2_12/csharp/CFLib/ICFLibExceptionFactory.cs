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
	public interface ICFLibExceptionFactory {

		CFLibRuntimeException newRuntimeException( String msg );

		CFLibRuntimeException newRuntimeException(
			Type throwingType,
			String methName,
			String msg );

		CFLibRuntimeException newRuntimeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibUsageException newUsageException( String msg );

		CFLibUsageException newUsageException(
			Type throwingType,
			String methName,
			String msg );

		CFLibUsageException newUsageException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibEmptyArgumentException newEmptyArgumentException( String msg );

		CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			String msg );

		CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName );

		CFLibEmptyArgumentException newEmptyArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Exception th );

		CFLibNullArgumentException newNullArgumentException( String msg );

		CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			String msg );

		CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName );

		CFLibNullArgumentException newNullArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Exception th );

		CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String msg );

		CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			String msg );

		CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th );

		CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName );

		CFLibNullArgumentException newNullArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Exception th );

		CFLibInvalidArgumentException newInvalidArgumentException( String msg );

		CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg );

		CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );
		
		CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Object argValue );

		CFLibInvalidArgumentException newInvalidArgumentException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			Object argValue,
			Exception th );

		CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String msg );

		CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			String msg );

		CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			String msg,
			Exception th );
		
		CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Object argValue );

		CFLibInvalidArgumentException newInvalidArgumentException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			Object argValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException( String msg );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			String msg );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th );

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String msg );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			String msg );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			short maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			int maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			long maxValue,
			Exception th );

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort minValue,
            ushort maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint minValue,
            uint maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue);

        CFLibArgumentRangeException newArgumentRangeException(
            String fieldName,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong minValue,
            ulong maxValue,
            Exception th);

        CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			float maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			double maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			DateTime maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			String maxValue,
			Exception th );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue );

		CFLibArgumentRangeException newArgumentRangeException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			BigDecimal maxValue,
			Exception th );

		CFLibMustOverrideException newMustOverrideException( String msg );

		CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			String msg );

		CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName );

		CFLibMustOverrideException newMustOverrideException(
			Type throwingType,
			String methName,
			Exception th );

		CFLibNotImplementedYetException newNotImplementedYetException( String msg );

		CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg );

		CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName );

		CFLibNotImplementedYetException newNotImplementedYetException(
			Type throwingType,
			String methName,
			Exception th );

		CFLibNotSupportedException newNotSupportedException( String msg );

		CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			String msg );

		CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName );

		CFLibNotSupportedException newNotSupportedException(
			Type throwingType,
			String methName,
			Exception th );

		CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException( String msg );
		
		CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
			Type throwingType,
			String methName,
			String msg );

		CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
			Type throwingType,
			String methName,
			Object argKey );

		CFLibPrimaryKeyNotNewException newPrimaryKeyNotNewException(
			Type throwingType,
			String methName,
			Object argKey,
			Exception th );

		CFLibDependentsDetectedException newDependentsDetectedException( String msg );

		CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String msg );

		CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey );

		CFLibDependentsDetectedException newDependentsDetectedException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey,
			Exception th );

		CFLibUnresolvedRelationException newUnresolvedRelationException( String msg );

		CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg );

		CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey );

		CFLibUnresolvedRelationException newUnresolvedRelationException(
			Type throwingType,
			String methName,
			String relationType,
			String relationName,
			String targetName,
			Object argKey,
			Exception th );

		CFLibStaleCacheDetectedException newStaleCacheDetectedException( String msg );

		CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg );

		CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey );

		CFLibStaleCacheDetectedException newStaleCacheDetectedException(
			Type throwingType,
			String methName,
			String msgCause,
			String targetTable,
			Object argKey,
			Exception th );

		CFLibUniqueIndexViolationException newUniqueIndexViolationException( String msg );

		CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg );

		CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey );

		CFLibUniqueIndexViolationException newUniqueIndexViolationException(
			Type throwingType,
			String methName,
			String argIndexName,
			Object argKey,
			Exception th );

		CFLibCollisionDetectedException newCollisionDetectedException( String msg );

		CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			String msg );
		
		CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			Object argKey );
		
		CFLibCollisionDetectedException newCollisionDetectedException(
			Type throwingType,
			String methName,
			Object argKey,
			Exception th );

		CFLibUnsupportedClassException newUnsupportedClassException( String msg );

		CFLibUnsupportedClassException newUnsupportedClassException(
			Type throwingType,
			String methName,
			String msg );

		CFLibUnsupportedClassException newUnsupportedClassException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibUnsupportedClassException newUnsupportedClassException(
			Type throwingType,
			String methName,
			String argObjName,
			Object argObj,
			String argExpectedClasses );

		CFLibUnsupportedClassException newUnsupportedClassException(
			Type throwingType,
			String methName,
			String argObjName,
			Object argObj,
			String argExpectedClasses,
			Exception th );

		CFLibDbException newDbException( String msg );

		CFLibDbException newDbException(
			Type throwingType,
			String methName,
			String msg );

		CFLibDbException newDbException(
			Type throwingType,
			String methName,
			Exception dbException );

		CFLibArgumentOverflowException newArgumentOverflowException( String msg );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th );

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue);

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ushort argValue,
            ushort maxValue,
            Exception th);

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue);

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            uint argValue,
            uint maxValue,
            Exception th);

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue);

        CFLibArgumentOverflowException newArgumentOverflowException(
            Type throwingType,
            String methName,
            int argNo,
            String argName,
            ulong argValue,
            ulong maxValue,
            Exception th);

        CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String msg );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			String msg );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String maxValue,
			Exception th );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue );

		CFLibArgumentOverflowException newArgumentOverflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal maxValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException( String msg );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			String msg );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			Type throwingType,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String msg );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			String msg );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			String msg,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			short argValue,
			short minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			int argValue,
			int minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			long argValue,
			long minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			float argValue,
			float minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			double argValue,
			double minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime maxValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			DateTime argValue,
			DateTime minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			String argValue,
			String minValue,
			Exception th );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue );

		CFLibArgumentUnderflowException newArgumentUnderflowException(
			String fieldName,
			String methName,
			int argNo,
			String argName,
			BigDecimal argValue,
			BigDecimal minValue,
			Exception th );

		CFLibUnrecognizedAttributeException newUnrecognizedAttributeException( String msg );

		CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String msg );

		CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String msg,
			Exception th );

		CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String locInfo,
			String attrName );

		CFLibUnrecognizedAttributeException newUnrecognizedAttributeException(
			Type throwingType,
			String methName,
			String locInfo,
			String attrName,
			Exception th );
	}
}
