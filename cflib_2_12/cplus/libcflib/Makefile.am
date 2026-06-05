SUBDIRS=cflib

MAJOR_VERSION = 2

MINOR_VERSION = 12

BUILD_NUMBER = 11137

RELEASE = $(MAJOR_VERSION).$(MINOR_VERSION).$(BUILD_NUMBER)

SUB_RELEASE = $(MAJOR_VERSION).$(MINOR_VERSION)

MAIN_RELEASE = $(MAJOR_VERSION)

DEPDIR = debug

LT_OBJDIR = .libs

lib_LTLIBRARIES=libcflib.la

BIN=$(prefix)/bin/msobkow/$(MAJOR_VERSION).0.$(MINOR)_VERSION

bindir=$(prefix)/bin/msobkow/$(MAJOR_VERSION).0.$(MINOR_VERSION)

libcflib_ladir=$(prefix)/include/msobkow/$(MAJOR_VERSION).0.$(MINOR_VERSION)/cflib

libcflib_CXXFLAGS = -I. -I$(prefix)/include/msobkow/$(MAJOR_VERSION).0.$(MINOR_VERSION) -I$(prefix)/include/msobkow/$(MAJOR_VERSION).0.$(MINOR_VERSION)

libcflib_la_SOURCES = CFLibXmlCoreLineCountBinInputStream.cpp CFLibXmlCoreLineCountMemBufInputSource.cpp CFLibArgumentException.cpp CFLibArgumentOverflowException.cpp CFLibArgumentRangeException.cpp CFLibArgumentUnderflowException.cpp CFLibGenericBigDecimal.cpp TCFLibBigDecimal.cpp TCFLibOwningVector.cpp TCFLibOwningList.cpp CFLibCollisionDetectedException.cpp CFLib.cpp ICFLibPublic.cpp CFLibDbException.cpp CFLibDbUtil.cpp CFLibDependentsDetectedException.cpp CFLibEmptyArgumentException.cpp CFLibInvalidArgumentException.cpp CFLibMathException.cpp CFLibConsoleMessageLog.cpp CFLibCachedMessageLog.cpp CFLibMustOverrideException.cpp CFLibNotImplementedYetException.cpp CFLibNotSupportedException.cpp CFLibNullArgumentException.cpp CFLibPrimaryKeyNotNewException.cpp CFLibRuntimeException.cpp CFLibStaleCacheDetectedException.cpp CFLibSubroutineException.cpp CFLibUniqueIndexViolationException.cpp CFLibUnrecognizedAttributeException.cpp CFLibUnresolvedRelationException.cpp CFLibUnsupportedClassException.cpp CFLibUsageException.cpp CFLibXmlCore.cpp CFLibXmlCoreContext.cpp CFLibXmlCoreElementHandler.cpp CFLibXmlCoreIso8859Encoder.cpp CFLibXmlCoreParser.cpp CFLibXmlCoreSaxParser.cpp CFLibXmlUtil.cpp ICFLibCloneableObj.cpp ICFLibObj.cpp ICFLibAnyObj.cpp ICFLibMessageLog.cpp ICFLibXmlCoreContextFactory.cpp CFLibNullable.cpp CFLibNullableBool.cpp CFLibNullableInt16.cpp CFLibNullableInt32.cpp CFLibNullableInt64.cpp CFLibNullableUInt16.cpp CFLibNullableUInt32.cpp CFLibNullableUInt64.cpp CFLibNullableFloat.cpp CFLibNullableDouble.cpp

libcflib_la_LDFLAGS = -version-info $(MAJOR_VERSION):$(MINOR_VERSION) -lmpfr -lxerces-c -luuid

libcflib_la_HEADERS = cflib/CFLibXmlCoreLineCountBinInputStream.hpp cflib/CFLibXmlCoreLineCountMemBufInputSource.hpp cflib/CFLibXmlCore.hpp cflib/CFLibXmlCoreContext.hpp cflib/CFLibXmlCoreElementHandler.hpp cflib/CFLibXmlCoreIso8859Encoder.hpp cflib/CFLibXmlCoreParser.hpp cflib/CFLibXmlCoreSaxParser.hpp cflib/CFLibArgumentException.hpp cflib/CFLibArgumentOverflowException.hpp cflib/CFLibArgumentRangeException.hpp cflib/CFLibArgumentUnderflowException.hpp cflib/CFLibCollisionDetectedException.hpp cflib/CFLibMathException.hpp cflib/CFLibDbException.hpp cflib/CFLibDbUtil.hpp cflib/CFLibDependentsDetectedException.hpp cflib/CFLibEmptyArgumentException.hpp cflib/CFLib.hpp cflib/ICFLibPublic.hpp cflib/CFLibInvalidArgumentException.hpp cflib/CFLibConsoleMessageLog.hpp cflib/CFLibCachedMessageLog.hpp cflib/CFLibMustOverrideException.hpp cflib/CFLibNotImplementedYetException.hpp cflib/CFLibNotSupportedException.hpp cflib/CFLibNullArgumentException.hpp cflib/CFLibPrimaryKeyNotNewException.hpp cflib/CFLibRuntimeException.hpp cflib/CFLibStaleCacheDetectedException.hpp cflib/CFLibSubroutineException.hpp cflib/CFLibUniqueIndexViolationException.hpp cflib/CFLibUnrecognizedAttributeException.hpp cflib/CFLibUnresolvedRelationException.hpp cflib/CFLibUnsupportedClassException.hpp cflib/CFLibUsageException.hpp cflib/CFLibXmlUtil.hpp cflib/ICFLibCloneableObj.hpp cflib/ICFLibObj.hpp cflib/ICFLibAnyObj.hpp cflib/ICFLibMessageLog.hpp cflib/ICFLibXmlCoreContextFactory.hpp cflib/CFLibNullable.hpp cflib/CFLibNullableBool.hpp cflib/CFLibNullableInt16.hpp cflib/CFLibNullableInt32.hpp cflib/CFLibNullableInt64.hpp cflib/CFLibNullableUInt16.hpp cflib/CFLibNullableUInt32.hpp cflib/CFLibNullableUInt64.hpp cflib/CFLibNullableFloat.hpp cflib/CFLibNullableDouble.hpp cflib/CFLibGenericBigDecimal.hpp cflib/TCFLibBigDecimal.hpp cflib/TCFLibOwningVector.hpp cflib/TCFLibOwningList.hpp

libcflibxsd_ladir=$(prefix)/share/msobkow/$(MAJOR_VERSION).0.$(MINOR_VERSION)/xsd

libcflibxsd_la_HEADERS=xsd/cftip-envelope.xsd xsd/cftip-serverinfo.xsd

ACLOCAL_AMFLAGS = -Im4

