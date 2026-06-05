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
#include <cflib/CFLibNullableFloat.hpp>
#include <cflib/CFLibNullArgumentException.hpp>

namespace cflib {

const std::string CFLibNullableFloat::CLASS_NAME( "CFLibNullableFloat" );;

CFLibNullableFloat::CFLibNullableFloat() {
	value = 0;
}

CFLibNullableFloat::CFLibNullableFloat( const float arg ) {
	setNullFlag( false );
	value = arg;
}

CFLibNullableFloat::~CFLibNullableFloat() {
}

const float CFLibNullableFloat::getValue() const {
	if( nullFlag ) {
		throw CFLibNullArgumentException( CLASS_NAME,
			S_GET_VALUE,
			0,
			S_VALUE );
	}
	return( value );
}

const float* CFLibNullableFloat::getReference() const {
	if( nullFlag ) {
		return( NULL );
	}
	else {
		return( &value );
	}
}

void CFLibNullableFloat::setValue( const float arg ) {
	setNullFlag( false );
	value = arg;
}

void CFLibNullableFloat::setNull() {
	setNullFlag( true );
}

}
