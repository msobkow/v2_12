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
#include <cflib/CFLibNullableInt32.hpp>
#include <cflib/CFLibNullArgumentException.hpp>

namespace cflib {

const std::string CFLibNullableInt32::CLASS_NAME( "CFLibNullableInt32" );;

CFLibNullableInt32::CFLibNullableInt32() {
	value = 0;
}

CFLibNullableInt32::CFLibNullableInt32( const int32_t arg ) {
	setNullFlag( false );
	value = arg;
}

CFLibNullableInt32::~CFLibNullableInt32() {
}

const int32_t CFLibNullableInt32::getValue() const {
	if( nullFlag ) {
		throw CFLibNullArgumentException( CLASS_NAME,
			S_GET_VALUE,
			0,
			S_VALUE );
	}
	return( value );
}

const int32_t* CFLibNullableInt32::getReference() const {
	if( nullFlag ) {
		return( NULL );
	}
	else {
		return( &value );
	}
}

void CFLibNullableInt32::setValue( const int32_t arg ) {
	setNullFlag( false );
	value = arg;
}

void CFLibNullableInt32::setNull() {
	setNullFlag( true );
}

}
