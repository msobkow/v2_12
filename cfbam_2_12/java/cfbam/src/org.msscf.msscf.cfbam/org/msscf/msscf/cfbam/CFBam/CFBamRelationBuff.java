// Description: Java 11 implementation of a Relation buffer object.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamRelationBuff
	extends CFBamScopeBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "RELD";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long TABLEID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_INIT_VALUE = 0L;
	public static final long DEFSCHEMAID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final ICFBamSchema.RelationTypeEnum RELATIONTYPE_INIT_VALUE = CFBamSchema.ordinalToRelationTypeEnum( 0 );
	public static final long FROMINDEXID_INIT_VALUE = 0L;
	public static final long TOTABLEID_INIT_VALUE = 0L;
	public static final long TOINDEXID_INIT_VALUE = 0L;
	public final static boolean ISREQUIRED_INIT_VALUE = false;
	public final static boolean ALLOWADDENDUM_INIT_VALUE = false;
	public final static boolean ISXSDCONTAINER_INIT_VALUE = false;
	public final static boolean ISLATERESOLVER_INIT_VALUE = false;
	public static final long NARROWEDTENANTID_INIT_VALUE = 0L;
	public static final long NARROWEDID_INIT_VALUE = 0L;
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long TABLEID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_MIN_VALUE = 0L;
	public static final long DEFSCHEMAID_MIN_VALUE = 0L;
	public static final ICFBamSchema.RelationTypeEnum RELATIONTYPE_MIN_VALUE = ICFBamSchema.RelationTypeEnum.Unknown;
	public static final long FROMINDEXID_MIN_VALUE = 0L;
	public static final long TOTABLEID_MIN_VALUE = 0L;
	public static final long TOINDEXID_MIN_VALUE = 0L;
	public static final long NARROWEDTENANTID_MIN_VALUE = 0L;
	public static final long NARROWEDID_MIN_VALUE = 0L;
	public static final ICFBamSchema.RelationTypeEnum RELATIONTYPE_MAX_VALUE = ICFBamSchema.RelationTypeEnum.Children;
	protected long requiredTableId;
	protected Long optionalDefSchemaTenantId;
	protected Long optionalDefSchemaId;
	protected String requiredName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected ICFBamSchema.RelationTypeEnum requiredRelationType;
	protected String optionalDbName;
	protected String optionalSuffix;
	protected long requiredFromIndexId;
	protected long requiredToTableId;
	protected long requiredToIndexId;
	protected boolean requiredIsRequired;
	protected boolean requiredAllowAddendum;
	protected boolean requiredIsXsdContainer;
	protected boolean requiredIsLateResolver;
	protected Long optionalNarrowedTenantId;
	protected Long optionalNarrowedId;
	public CFBamRelationBuff() {
		super();
		requiredTableId = CFBamRelationBuff.TABLEID_INIT_VALUE;
		optionalDefSchemaTenantId = null;
		optionalDefSchemaId = null;
		requiredName = new String( CFBamRelationBuff.NAME_INIT_VALUE );
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredRelationType = CFBamRelationBuff.RELATIONTYPE_INIT_VALUE;
		optionalDbName = null;
		optionalSuffix = null;
		requiredFromIndexId = CFBamRelationBuff.FROMINDEXID_INIT_VALUE;
		requiredToTableId = CFBamRelationBuff.TOTABLEID_INIT_VALUE;
		requiredToIndexId = CFBamRelationBuff.TOINDEXID_INIT_VALUE;
		requiredIsRequired = CFBamRelationBuff.ISREQUIRED_INIT_VALUE;
		requiredAllowAddendum = CFBamRelationBuff.ALLOWADDENDUM_INIT_VALUE;
		requiredIsXsdContainer = CFBamRelationBuff.ISXSDCONTAINER_INIT_VALUE;
		requiredIsLateResolver = CFBamRelationBuff.ISLATERESOLVER_INIT_VALUE;
		optionalNarrowedTenantId = null;
		optionalNarrowedId = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredTableId() {
		return( requiredTableId );
	}

	public void setRequiredTableId( long value ) {
		if( value < CFBamRelationBuff.TABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredTableId",
				1,
				"value",
				value,
				CFBamRelationBuff.TABLEID_MIN_VALUE );
		}
		requiredTableId = value;
	}

	public Long getOptionalDefSchemaTenantId() {
		return( optionalDefSchemaTenantId );
	}

	public void setOptionalDefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalDefSchemaTenantId = null;
		}
		else if( value < CFBamRelationBuff.DEFSCHEMATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaTenantId",
				1,
				"value",
				value,
				CFBamRelationBuff.DEFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalDefSchemaTenantId = value;
		}
	}

	public Long getOptionalDefSchemaId() {
		return( optionalDefSchemaId );
	}

	public void setOptionalDefSchemaId( Long value ) {
		if( value == null ) {
			optionalDefSchemaId = null;
		}
		else if( value < CFBamRelationBuff.DEFSCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaId",
				1,
				"value",
				value,
				CFBamRelationBuff.DEFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalDefSchemaId = value;
		}
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public String getOptionalShortName() {
		return( optionalShortName );
	}

	public void setOptionalShortName( String value ) {
		if( value == null ) {
			optionalShortName = null;
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalShortName = value;
		}
	}

	public String getOptionalLabel() {
		return( optionalLabel );
	}

	public void setOptionalLabel( String value ) {
		if( value == null ) {
			optionalLabel = null;
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		else {
			optionalLabel = value;
		}
	}

	public String getOptionalShortDescription() {
		return( optionalShortDescription );
	}

	public void setOptionalShortDescription( String value ) {
		if( value == null ) {
			optionalShortDescription = null;
		}
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		else {
			optionalShortDescription = value;
		}
	}

	public String getOptionalDescription() {
		return( optionalDescription );
	}

	public void setOptionalDescription( String value ) {
		if( value == null ) {
			optionalDescription = null;
		}
		else if( value.length() > 1023 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		else {
			optionalDescription = value;
		}
	}

	public ICFBamSchema.RelationTypeEnum getRequiredRelationType() {
		return( requiredRelationType );
	}

	public void setRequiredRelationType( ICFBamSchema.RelationTypeEnum value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredRelationType",
				1,
				"value" );
		}
		requiredRelationType = value;
	}

	public String getOptionalDbName() {
		return( optionalDbName );
	}

	public void setOptionalDbName( String value ) {
		if( value == null ) {
			optionalDbName = null;
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		else {
			optionalDbName = value;
		}
	}

	public String getOptionalSuffix() {
		return( optionalSuffix );
	}

	public void setOptionalSuffix( String value ) {
		if( value == null ) {
			optionalSuffix = null;
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalSuffix",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalSuffix = value;
		}
	}

	public long getRequiredFromIndexId() {
		return( requiredFromIndexId );
	}

	public void setRequiredFromIndexId( long value ) {
		if( value < CFBamRelationBuff.FROMINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredFromIndexId",
				1,
				"value",
				value,
				CFBamRelationBuff.FROMINDEXID_MIN_VALUE );
		}
		requiredFromIndexId = value;
	}

	public long getRequiredToTableId() {
		return( requiredToTableId );
	}

	public void setRequiredToTableId( long value ) {
		if( value < CFBamRelationBuff.TOTABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToTableId",
				1,
				"value",
				value,
				CFBamRelationBuff.TOTABLEID_MIN_VALUE );
		}
		requiredToTableId = value;
	}

	public long getRequiredToIndexId() {
		return( requiredToIndexId );
	}

	public void setRequiredToIndexId( long value ) {
		if( value < CFBamRelationBuff.TOINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredToIndexId",
				1,
				"value",
				value,
				CFBamRelationBuff.TOINDEXID_MIN_VALUE );
		}
		requiredToIndexId = value;
	}

	public boolean getRequiredIsRequired() {
		return( requiredIsRequired );
	}

	public void setRequiredIsRequired( boolean value ) {
		requiredIsRequired = value;
	}

	public boolean getRequiredAllowAddendum() {
		return( requiredAllowAddendum );
	}

	public void setRequiredAllowAddendum( boolean value ) {
		requiredAllowAddendum = value;
	}

	public boolean getRequiredIsXsdContainer() {
		return( requiredIsXsdContainer );
	}

	public void setRequiredIsXsdContainer( boolean value ) {
		requiredIsXsdContainer = value;
	}

	public boolean getRequiredIsLateResolver() {
		return( requiredIsLateResolver );
	}

	public void setRequiredIsLateResolver( boolean value ) {
		requiredIsLateResolver = value;
	}

	public Long getOptionalNarrowedTenantId() {
		return( optionalNarrowedTenantId );
	}

	public void setOptionalNarrowedTenantId( Long value ) {
		if( value == null ) {
			optionalNarrowedTenantId = null;
		}
		else if( value < CFBamRelationBuff.NARROWEDTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNarrowedTenantId",
				1,
				"value",
				value,
				CFBamRelationBuff.NARROWEDTENANTID_MIN_VALUE );
		}
		else {
			optionalNarrowedTenantId = value;
		}
	}

	public Long getOptionalNarrowedId() {
		return( optionalNarrowedId );
	}

	public void setOptionalNarrowedId( Long value ) {
		if( value == null ) {
			optionalNarrowedId = null;
		}
		else if( value < CFBamRelationBuff.NARROWEDID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalNarrowedId",
				1,
				"value",
				value,
				CFBamRelationBuff.NARROWEDID_MIN_VALUE );
		}
		else {
			optionalNarrowedId = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != rhs.getRequiredFromIndexId() ) {
				return( false );
			}
			if( getRequiredToTableId() != rhs.getRequiredToTableId() ) {
				return( false );
			}
			if( getRequiredToIndexId() != rhs.getRequiredToIndexId() ) {
				return( false );
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getOptionalNarrowedTenantId() != null ) {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					if( ! getOptionalNarrowedTenantId().equals( rhs.getOptionalNarrowedTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationHBuff ) {
			CFBamRelationHBuff rhs = (CFBamRelationHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( ! getRequiredRelationType().equals( rhs.getRequiredRelationType() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredFromIndexId() != rhs.getRequiredFromIndexId() ) {
				return( false );
			}
			if( getRequiredToTableId() != rhs.getRequiredToTableId() ) {
				return( false );
			}
			if( getRequiredToIndexId() != rhs.getRequiredToIndexId() ) {
				return( false );
			}
			if( getRequiredIsRequired() != rhs.getRequiredIsRequired() ) {
				return( false );
			}
			if( getRequiredAllowAddendum() != rhs.getRequiredAllowAddendum() ) {
				return( false );
			}
			if( getRequiredIsXsdContainer() != rhs.getRequiredIsXsdContainer() ) {
				return( false );
			}
			if( getRequiredIsLateResolver() != rhs.getRequiredIsLateResolver() ) {
				return( false );
			}
			if( getOptionalNarrowedTenantId() != null ) {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					if( ! getOptionalNarrowedTenantId().equals( rhs.getOptionalNarrowedTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByUNameIdxKey ) {
			CFBamRelationByUNameIdxKey rhs = (CFBamRelationByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByRelnTenantIdxKey ) {
			CFBamRelationByRelnTenantIdxKey rhs = (CFBamRelationByRelnTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByRelTableIdxKey ) {
			CFBamRelationByRelTableIdxKey rhs = (CFBamRelationByRelTableIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredTableId() != rhs.getRequiredTableId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByDefSchemaIdxKey ) {
			CFBamRelationByDefSchemaIdxKey rhs = (CFBamRelationByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByFromKeyIdxKey ) {
			CFBamRelationByFromKeyIdxKey rhs = (CFBamRelationByFromKeyIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredFromIndexId() != rhs.getRequiredFromIndexId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByToTblIdxKey ) {
			CFBamRelationByToTblIdxKey rhs = (CFBamRelationByToTblIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredToTableId() != rhs.getRequiredToTableId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByToKeyIdxKey ) {
			CFBamRelationByToKeyIdxKey rhs = (CFBamRelationByToKeyIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredToIndexId() != rhs.getRequiredToIndexId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamRelationByNarrowedIdxKey ) {
			CFBamRelationByNarrowedIdxKey rhs = (CFBamRelationByNarrowedIdxKey)obj;
			if( getOptionalNarrowedTenantId() != null ) {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					if( ! getOptionalNarrowedTenantId().equals( rhs.getOptionalNarrowedTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				if( rhs.getOptionalNarrowedId() != null ) {
					if( ! getOptionalNarrowedId().equals( rhs.getOptionalNarrowedId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredTableId() );
		if( getOptionalDefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaTenantId().hashCode();
		}
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredRelationType().ordinal();
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalSuffix() != null ) {
			hashCode = hashCode + getOptionalSuffix().hashCode();
		}
		hashCode = hashCode + (int)( getRequiredFromIndexId() );
		hashCode = hashCode + (int)( getRequiredToTableId() );
		hashCode = hashCode + (int)( getRequiredToIndexId() );
		if( getRequiredIsRequired() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredAllowAddendum() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsXsdContainer() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredIsLateResolver() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalNarrowedTenantId() != null ) {
			hashCode = hashCode + getOptionalNarrowedTenantId().hashCode();
		}
		if( getOptionalNarrowedId() != null ) {
			hashCode = hashCode + getOptionalNarrowedId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamRelationBuff ) {
			CFBamRelationBuff rhs = (CFBamRelationBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					int cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredFromIndexId() < rhs.getRequiredFromIndexId() ) {
				return( -1 );
			}
			else if( getRequiredFromIndexId() > rhs.getRequiredFromIndexId() ) {
				return( 1 );
			}
			if( getRequiredToTableId() < rhs.getRequiredToTableId() ) {
				return( -1 );
			}
			else if( getRequiredToTableId() > rhs.getRequiredToTableId() ) {
				return( 1 );
			}
			if( getRequiredToIndexId() < rhs.getRequiredToIndexId() ) {
				return( -1 );
			}
			else if( getRequiredToIndexId() > rhs.getRequiredToIndexId() ) {
				return( 1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedTenantId() != null ) {
				Long lhsNarrowedTenantId = getOptionalNarrowedTenantId();
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					Long rhsNarrowedTenantId = rhs.getOptionalNarrowedTenantId();
					int cmp = lhsNarrowedTenantId.compareTo( rhsNarrowedTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				Long lhsNarrowedId = getOptionalNarrowedId();
				if( rhs.getOptionalNarrowedId() != null ) {
					Long rhsNarrowedId = rhs.getOptionalNarrowedId();
					int cmp = lhsNarrowedId.compareTo( rhsNarrowedId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamRelationHBuff ) {
			CFBamRelationHBuff rhs = (CFBamRelationHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredRelationType().compareTo( rhs.getRequiredRelationType() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					int cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if( getRequiredFromIndexId() < rhs.getRequiredFromIndexId() ) {
				return( -1 );
			}
			else if( getRequiredFromIndexId() > rhs.getRequiredFromIndexId() ) {
				return( 1 );
			}
			if( getRequiredToTableId() < rhs.getRequiredToTableId() ) {
				return( -1 );
			}
			else if( getRequiredToTableId() > rhs.getRequiredToTableId() ) {
				return( 1 );
			}
			if( getRequiredToIndexId() < rhs.getRequiredToIndexId() ) {
				return( -1 );
			}
			else if( getRequiredToIndexId() > rhs.getRequiredToIndexId() ) {
				return( 1 );
			}
			if( getRequiredIsRequired() ) {
				if( ! rhs.getRequiredIsRequired() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsRequired() ) {
					return( -1 );
				}
			}
			if( getRequiredAllowAddendum() ) {
				if( ! rhs.getRequiredAllowAddendum() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredAllowAddendum() ) {
					return( -1 );
				}
			}
			if( getRequiredIsXsdContainer() ) {
				if( ! rhs.getRequiredIsXsdContainer() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsXsdContainer() ) {
					return( -1 );
				}
			}
			if( getRequiredIsLateResolver() ) {
				if( ! rhs.getRequiredIsLateResolver() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsLateResolver() ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedTenantId() != null ) {
				Long lhsNarrowedTenantId = getOptionalNarrowedTenantId();
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					Long rhsNarrowedTenantId = rhs.getOptionalNarrowedTenantId();
					int cmp = lhsNarrowedTenantId.compareTo( rhsNarrowedTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				Long lhsNarrowedId = getOptionalNarrowedId();
				if( rhs.getOptionalNarrowedId() != null ) {
					Long rhsNarrowedId = rhs.getOptionalNarrowedId();
					int cmp = lhsNarrowedId.compareTo( rhsNarrowedId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamRelationByUNameIdxKey ) {
			CFBamRelationByUNameIdxKey rhs = (CFBamRelationByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByRelnTenantIdxKey ) {
			CFBamRelationByRelnTenantIdxKey rhs = (CFBamRelationByRelnTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByRelTableIdxKey ) {
			CFBamRelationByRelTableIdxKey rhs = (CFBamRelationByRelTableIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredTableId() < rhs.getRequiredTableId() ) {
				return( -1 );
			}
			else if( getRequiredTableId() > rhs.getRequiredTableId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByDefSchemaIdxKey ) {
			CFBamRelationByDefSchemaIdxKey rhs = (CFBamRelationByDefSchemaIdxKey)obj;

			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByFromKeyIdxKey ) {
			CFBamRelationByFromKeyIdxKey rhs = (CFBamRelationByFromKeyIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredFromIndexId() < rhs.getRequiredFromIndexId() ) {
				return( -1 );
			}
			else if( getRequiredFromIndexId() > rhs.getRequiredFromIndexId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByToTblIdxKey ) {
			CFBamRelationByToTblIdxKey rhs = (CFBamRelationByToTblIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredToTableId() < rhs.getRequiredToTableId() ) {
				return( -1 );
			}
			else if( getRequiredToTableId() > rhs.getRequiredToTableId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByToKeyIdxKey ) {
			CFBamRelationByToKeyIdxKey rhs = (CFBamRelationByToKeyIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredToIndexId() < rhs.getRequiredToIndexId() ) {
				return( -1 );
			}
			else if( getRequiredToIndexId() > rhs.getRequiredToIndexId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamRelationByNarrowedIdxKey ) {
			CFBamRelationByNarrowedIdxKey rhs = (CFBamRelationByNarrowedIdxKey)obj;

			if( getOptionalNarrowedTenantId() != null ) {
				Long lhsNarrowedTenantId = getOptionalNarrowedTenantId();
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					Long rhsNarrowedTenantId = rhs.getOptionalNarrowedTenantId();
					int cmp = lhsNarrowedTenantId.compareTo( rhsNarrowedTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNarrowedId() != null ) {
				Long lhsNarrowedId = getOptionalNarrowedId();
				if( rhs.getOptionalNarrowedId() != null ) {
					Long rhsNarrowedId = rhs.getOptionalNarrowedId();
					int cmp = lhsNarrowedId.compareTo( rhsNarrowedId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNarrowedId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamRelationBuff ) {
			setRelationBuff( (CFBamRelationBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamRelationBuff" );
		}
	}

	public void setRelationBuff( CFBamRelationBuff src ) {
		super.setScopeBuff( src );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredRelationType( src.getRequiredRelationType() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalSuffix( src.getOptionalSuffix() );
		setRequiredFromIndexId( src.getRequiredFromIndexId() );
		setRequiredToTableId( src.getRequiredToTableId() );
		setRequiredToIndexId( src.getRequiredToIndexId() );
		setRequiredIsRequired( src.getRequiredIsRequired() );
		setRequiredAllowAddendum( src.getRequiredAllowAddendum() );
		setRequiredIsXsdContainer( src.getRequiredIsXsdContainer() );
		setRequiredIsLateResolver( src.getRequiredIsLateResolver() );
		setOptionalNarrowedTenantId( src.getOptionalNarrowedTenantId() );
		setOptionalNarrowedId( src.getOptionalNarrowedId() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamRelationHBuff ) {
			setRelationBuff( (CFBamRelationHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamRelationHBuff" );
		}
	}

	public void setRelationBuff( CFBamRelationHBuff src ) {
		super.setScopeBuff( src );
		setRequiredTableId( src.getRequiredTableId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredRelationType( src.getRequiredRelationType() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalSuffix( src.getOptionalSuffix() );
		setRequiredFromIndexId( src.getRequiredFromIndexId() );
		setRequiredToTableId( src.getRequiredToTableId() );
		setRequiredToIndexId( src.getRequiredToIndexId() );
		setRequiredIsRequired( src.getRequiredIsRequired() );
		setRequiredAllowAddendum( src.getRequiredAllowAddendum() );
		setRequiredIsXsdContainer( src.getRequiredIsXsdContainer() );
		setRequiredIsLateResolver( src.getRequiredIsLateResolver() );
		setOptionalNarrowedTenantId( src.getOptionalNarrowedTenantId() );
		setOptionalNarrowedId( src.getOptionalNarrowedId() );
	}
}
