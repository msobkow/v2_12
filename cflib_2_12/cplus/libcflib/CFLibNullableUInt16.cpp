/*
 *	MSS Code Factory CFLib 2.12
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *			http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

#include <cflib/CFLib.hpp>
#include <cflib/CFLibNullableUInt16.hpp>
#include <cflib/CFLibNullArgumentException.hpp>

namespace cflib {

const std::string CFLibNullableUInt16::CLASS_NAME( "CFLibNullableUInt16" );;

CFLibNullableUInt16::CFLibNullableUInt16() {
	value = 0;
}

CFLibNullableUInt16::CFLibNullableUInt16( const uint16_t arg ) {
	setNullFlag( false );
	value = arg;
}

CFLibNullableUInt16::~CFLibNullableUInt16() {
}

const uint16_t CFLibNullableUInt16::getValue() const {
	if( nullFlag ) {
		throw CFLibNullArgumentException( CLASS_NAME,
			S_GET_VALUE,
			0,
			S_VALUE );
	}
	return( value );
}

const uint16_t* CFLibNullableUInt16::getReference() const {
	if( nullFlag ) {
		return( NULL );
	}
	else {
		return( &value );
	}
}

void CFLibNullableUInt16::setValue( const uint16_t arg ) {
	setNullFlag( false );
	value = arg;
}

void CFLibNullableUInt16::setNull() {
	setNullFlag( true );
}

}
