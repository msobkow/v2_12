#pragma once
/*
 *	MSS Code Factory CFLib 2.12
 *
 *	Copyright ( c ) 2018-2019 Mark Stephen Sobkow
 *
 *	Licensed under the Apache License, Version 2.0 ( the "License");
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

#include <memory.h>

#include <cflib/CFLib.hpp>

namespace std {

	template< class EltClass > class TCFLibOwningVector : public std::vector< EltClass > {

	public:

		/**
		 *	Default constructor.
		 */
		TCFLibOwningVector<EltClass>()
		: std::vector<EltClass>()
		{
		}

		/**
		 *	Copy constructor.  Note that elements MUST implement ICFLibCloneableObj.
		 */
		TCFLibOwningVector<EltClass>( const TCFLibOwningVector<EltClass>& src )
		: std::vector<EltClass>()
		{
			auto iter = src.begin();
			auto endit = src.end();
			while( iter != endit ) {
				if( *iter != NULL ) {
					std::vector<EltClass>::push_back( dynamic_cast<EltClass>( (*iter)->clone() ) );
				}
				else {
					std::vector<EltClass>::push_back( *iter );
				}
				iter ++;
			}
		}

		/**
		 *	Copy constructor.  Note that elements MUST implement ICFLibCloneableObj.
		 */
		TCFLibOwningVector<EltClass>( const std::vector<EltClass>& src )
		: std::vector<EltClass>()
		{
			auto iter = src.begin();
			auto endit = src.end();
			while( iter != endit ) {
				if( *iter != NULL ) {
					std::vector<EltClass>::push_back( dynamic_cast<EltClass>( (*iter)->clone() ) );
				}
				else {
					std::vector<EltClass>::push_back( *iter );
				}
				iter ++;
			}
		}

		/**
		 *	The destructor has to release the elements, but because the
		 *	underlying STL template does not implement a virtual destructor,
		 *	you have to rely on the application code being specific about
		 * 	the kind of vectors it is dealing with, and pass them around
		 *	as full objects and object references, rather than trying to delete
		 *	pointers to instances.
		 */
		~TCFLibOwningVector<EltClass>() {
			EltClass elt = NULL;
			auto iter = std::vector<EltClass>::begin();
			while( iter != std::vector<EltClass>::end() ) {
				elt = *iter;
				if( elt != NULL ) {
					*iter = NULL;
					try {
						delete elt;
						elt = NULL;
					}
					catch( std::runtime_error e ) {
					}
				}
				iter ++;
			}
			// Now the std::vector destructor runs, deleting the vector array itself,
			// whose elements are all NULL pointers now
		}

	};
}
