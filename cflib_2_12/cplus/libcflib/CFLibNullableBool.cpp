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
#include <cflib/CFLibNullableBool.hpp>
#include <cflib/CFLibNullArgumentException.hpp>

namespace cflib {

const std::string CFLibNullableBool::CLASS_NAME( "CFLibNullableBool" );;

CFLibNullableBool::CFLibNullableBool() {
	value = 0;
}

CFLibNullableBool::CFLibNullableBool( const bool arg ) {
	setNullFlag( false );
	value = arg;
}

CFLibNullableBool::~CFLibNullableBool() {
}

const bool CFLibNullableBool::getValue() const {
	if( nullFlag ) {
		throw CFLibNullArgumentException( CLASS_NAME,
			S_GET_VALUE,
			0,
			S_VALUE );
	}
	return( value );
}

const bool* CFLibNullableBool::getReference() const {
	if( nullFlag ) {
		return( NULL );
	}
	else {
		return( &value );
	}
}

void CFLibNullableBool::setValue( const bool arg ) {
	setNullFlag( false );
	value = arg;
}

void CFLibNullableBool::setNull() {
	setNullFlag( true );
}

}
