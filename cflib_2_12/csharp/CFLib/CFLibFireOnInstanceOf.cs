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
	public class CFLibFireOnInstanceOf {
		
		protected Type instOf = null;

		public CFLibFireOnInstanceOf() {
			setInstanceOf( typeof(Object) );
		}

		public CFLibFireOnInstanceOf( Type value ) {
			setInstanceOf( value );
		}

		public void setInstanceOf( Type value ) {
			String S_ProcName = "setInstanceOf";
			if( value == null ) {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibFireOnInstanceOf),
					S_ProcName,
					1,
					"value" );
			}
			instOf = value;
		}

		public Type getInstanceOf() {
			return( instOf );
		}

		public Boolean isInstanceOf( ICFLibAnyObj obj ) {
			if( obj == null ) {
				return( false );
			}

			if( instOf == null ) {
				return( false );
			}

            return (instOf.IsAssignableFrom( obj.GetType() ));
		}

		public void onInstanceOf( ICFLibAnyObj obj ) {
			String S_ProcName = "onInstanceOf";
			if( obj == null ) {
				return;
			}
			throw CFLib.DefaultExceptionFactory.newNotImplementedYetException(typeof(CFLibFireOnInstanceOf),
				S_ProcName );
		}

		public void fireOnInstanceOf( ICFLibAnyObj obj ) {
			if( obj == null ) {
				return;
			}
			if( isInstanceOf( obj ) ) {
				onInstanceOf( obj );
			}
		}
	}
}
