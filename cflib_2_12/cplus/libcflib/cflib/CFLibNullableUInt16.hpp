#pragma once

/*
 *  MSS Code Factory CFLib 2.12
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */

#include <cstdint>
#include <string>
#include <cflib/CFLibNullable.hpp>

namespace cflib {

	class CFLibNullableUInt16 : public CFLibNullable {

	public:
		static const std::string CLASS_NAME;

	protected:

		uint16_t	value;

	public:
		CFLibNullableUInt16();
		CFLibNullableUInt16( const uint16_t arg );
		~CFLibNullableUInt16();

		const uint16_t getValue() const;
		const uint16_t* getReference() const;
		void setValue( const uint16_t arg );
		void setNull();
	};
}
