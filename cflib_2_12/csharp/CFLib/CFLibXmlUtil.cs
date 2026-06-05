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
using System.Text;
using System.Xml;

namespace CFLib
{
	public class CFLibXmlUtil {
		protected static string S_emptyString = "";
		
		/**
		 *	Formatting for XML attribute content strings.
		**/

		public static DateTime? parseDate(string value ) {
            string S_ProcName = "parseDate";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( value.Length != 10 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DD, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DD, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseDate(string fieldName, string value ) {
            string S_ProcName = "parseDate";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( value.Length != 10 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DD, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DD, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseTime(string value ) {
            string S_ProcName = "parseTime";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}
			
			if( value.Length != 8 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be HH:MI:SS, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& ( value[2] == ':' )
					&& char.IsDigit( value[3] )
					&& char.IsDigit( value[4] )
					&& ( value[5] == ':' )
					&& char.IsDigit( value[6] )
					&& char.IsDigit( value[7] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be HH:MI:SS, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseTime(string fieldName, string value ) {
            string S_ProcName = "parseTime";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}
			
			if( value.Length != 8 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be HH:MI:SS, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& ( value[2] == ':' )
					&& char.IsDigit( value[3] )
					&& char.IsDigit( value[4] )
					&& ( value[5] == ':' )
					&& char.IsDigit( value[6] )
					&& char.IsDigit( value[7] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be HH:MI:SS, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseTimestamp(string value ) {
            string S_ProcName ="parseTimestamp";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( value.Length != 19 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SS, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] )
					&& ( value[10] == 'T' )
					&& char.IsDigit( value[11] )
					&& char.IsDigit( value[12] )
					&& ( value[13] == ':' )
					&& char.IsDigit( value[14] )
					&& char.IsDigit( value[15] )
					&& ( value[16] == ':' )
					&& char.IsDigit( value[17] )
					&& char.IsDigit( value[18] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SS, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseTimestamp(string fieldName, string value ) {
            string S_ProcName ="parseTimestamp";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( value.Length != 19 ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SS, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] )
					&& ( value[10] == 'T' )
					&& char.IsDigit( value[11] )
					&& char.IsDigit( value[12] )
					&& ( value[13] == ':' )
					&& char.IsDigit( value[14] )
					&& char.IsDigit( value[15] )
					&& ( value[16] == ':' )
					&& char.IsDigit( value[17] )
					&& char.IsDigit( value[18] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SS, \"" + value + "\" is invalid");
			}

            DateTime retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);

            return ( retval );
		}

		public static DateTime? parseTZDate(string value ) {
            string S_ProcName = "parseTZDate";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( ( value.Length != 11 ) && ( value.Length != 16 ) ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}

			DateTime? retval = null;
			
			if( value[ 10 ] == 'Z' ) {
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 10 ] == '-' )
				&& (char.IsDigit( value[ 11 ] ) )
				&& (char.IsDigit( value[ 12 ] ) )
				&& ( value[ 13 ] == ':' )
				&& (char.IsDigit( value[ 14 ] ) )
				&& (char.IsDigit( value[ 15 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 10 ] == '+' )
				&& (char.IsDigit( value[ 11 ] ) )
				&& (char.IsDigit( value[ 12 ] ) )
				&& ( value[ 13 ] == ':' )
				&& (char.IsDigit( value[ 14 ] ) )
				&& (char.IsDigit( value[ 15 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}

			return( retval );
		}

		public static DateTime? parseTZDate(string fieldName, string value ) {
            string S_ProcName = "parseTZDate";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( ( value.Length != 11 ) && ( value.Length != 16 ) ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}

			DateTime? retval = null;
			
			if( value[ 10 ] == 'Z' ) {
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 10 ] == '-' )
				&& (char.IsDigit( value[ 11 ] ) )
				&& (char.IsDigit( value[ 12 ] ) )
				&& ( value[ 13 ] == ':' )
				&& (char.IsDigit( value[ 14 ] ) )
				&& (char.IsDigit( value[ 15 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 10 ] == '+' )
				&& (char.IsDigit( value[ 11 ] ) )
				&& (char.IsDigit( value[ 12 ] ) )
				&& ( value[ 13 ] == ':' )
				&& (char.IsDigit( value[ 14 ] ) )
				&& (char.IsDigit( value[ 15 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDZ or YYYY-MM-DD+HO:MO, \"" + value + "\" is invalid");
			}

			return( retval );
		}

		public static DateTime? parseTZTime(string value ) {
            string S_ProcName = "parseTZTime";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}
			
			if( ( value.Length != 9 ) && ( value.Length != 14 ) ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& ( value[2] == ':' )
					&& char.IsDigit( value[3] )
					&& char.IsDigit( value[4] )
					&& ( value[5] == ':' )
					&& char.IsDigit( value[6] )
					&& char.IsDigit( value[7] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}

			DateTime? retval = null;

			if( value[ 8 ] == 'Z' ) {
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 8 ] == '-' )
				&& (char.IsDigit( value[ 9 ] ) )
				&& (char.IsDigit( value[ 10 ] ) )
				&& ( value[ 11 ] == ':' )
				&& (char.IsDigit( value[ 12 ] ) )
				&& (char.IsDigit( value[ 13 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 8 ] == '+' )
					&& (char.IsDigit( value[ 9 ] ) )
					&& (char.IsDigit( value[ 10 ] ) )
					&& ( value[ 11 ] == ':' )
					&& (char.IsDigit( value[ 12 ] ) )
					&& (char.IsDigit( value[ 13 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			return( retval );
		}

		public static DateTime? parseTZTime(string fieldName, string value ) {
            string S_ProcName = "parseTZTime";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}
			
			if( ( value.Length != 9 ) && ( value.Length != 14 ) ) {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& ( value[2] == ':' )
					&& char.IsDigit( value[3] )
					&& char.IsDigit( value[4] )
					&& ( value[5] == ':' )
					&& char.IsDigit( value[6] )
					&& char.IsDigit( value[7] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}

			DateTime? retval = null;

			if( value[ 8 ] == 'Z' ) {
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 8 ] == '-' )
				&& (char.IsDigit( value[ 9 ] ) )
				&& (char.IsDigit( value[ 10 ] ) )
				&& ( value[ 11 ] == ':' )
				&& (char.IsDigit( value[ 12 ] ) )
				&& (char.IsDigit( value[ 13 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 8 ] == '+' )
					&& (char.IsDigit( value[ 9 ] ) )
					&& (char.IsDigit( value[ 10 ] ) )
					&& ( value[ 11 ] == ':' )
					&& (char.IsDigit( value[ 12 ] ) )
					&& (char.IsDigit( value[ 13 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( fieldName,
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be HH:MI:SSZ or HH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			return( retval );
		}

		public static DateTime? parseTZTimestamp(string value ) {
            string S_ProcName = "parseTZTimestamp";
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( ( value.Length != 20 ) && ( value.Length != 25 ) ){
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] )
					&& ( value[10] == 'T' )
					&& char.IsDigit( value[11] )
					&& char.IsDigit( value[12] )
					&& ( value[13] == ':' )
					&& char.IsDigit( value[14] )
					&& char.IsDigit( value[15] )
					&& ( value[16] == ':' )
					&& char.IsDigit( value[17] )
					&& char.IsDigit( value[18] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			DateTime? retval = null;

			if( value[ 19 ] == 'Z' ) {
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 19 ] == '-' )
				&& (char.IsDigit( value[ 20 ] ) )
				&& (char.IsDigit( value[ 21 ] ) )
				&& ( value[ 22 ] == ':' )
				&& (char.IsDigit( value[ 23 ] ) )
				&& (char.IsDigit( value[ 24 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 19 ] == '+' )
					&& (char.IsDigit( value[ 20 ] ) )
					&& (char.IsDigit( value[ 21 ] ) )
					&& ( value[ 22 ] == ':' )
					&& (char.IsDigit( value[ 23 ] ) )
					&& (char.IsDigit( value[ 24 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}

			return( retval );
		}

		public static DateTime? parseTZTimestamp(string fieldName, string value ) {
            string S_ProcName = "parseTZTimestamp";
			if( ( fieldName == null ) || ( fieldName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"fieldName" );
			}
			if( ( value == null ) || ( value.Length == 0 ) ) {
				return( null );
			}

			if( ( value.Length != 20 ) && ( value.Length != 25 ) ){
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			if( ! (char.IsDigit( value[0] )
					&& char.IsDigit( value[1] )
					&& char.IsDigit( value[2] )
					&& char.IsDigit( value[3] )
					&& ( value[4] == '-' )
					&& char.IsDigit( value[5] )
					&& char.IsDigit( value[6] )
					&& ( value[7] == '-' )
					&& char.IsDigit( value[8] )
					&& char.IsDigit( value[9] )
					&& ( value[10] == 'T' )
					&& char.IsDigit( value[11] )
					&& char.IsDigit( value[12] )
					&& ( value[13] == ':' )
					&& char.IsDigit( value[14] )
					&& char.IsDigit( value[15] )
					&& ( value[16] == ':' )
					&& char.IsDigit( value[17] )
					&& char.IsDigit( value[18] ) ) )
			{
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}
			
			DateTime? retval = null;

			if( value[ 19 ] == 'Z' ) {
				int year = Convert.ToInt32( value.Substring( 0, 4 ) );
				int month = Convert.ToInt32( value.Substring( 5, 2 ) );
				int day = Convert.ToInt32( value.Substring( 8, 2 ) );
				int hour = Convert.ToInt32( value.Substring( 11, 2 ) );
				int minute = Convert.ToInt32( value.Substring( 14, 2 ) );
				int second = Convert.ToInt32( value.Substring( 17, 2 ) );
                retval = new DateTime(year, month - 1, day, hour, minute, second, DateTimeKind.Utc);
            }
            else if( ( value[ 19 ] == '-' )
				&& (char.IsDigit( value[ 20 ] ) )
				&& (char.IsDigit( value[ 21 ] ) )
				&& ( value[ 22 ] == ':' )
				&& (char.IsDigit( value[ 23 ] ) )
				&& (char.IsDigit( value[ 24 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else if( ( value[ 19 ] == '+' )
					&& (char.IsDigit( value[ 20 ] ) )
					&& (char.IsDigit( value[ 21 ] ) )
					&& ( value[ 22 ] == ':' )
					&& (char.IsDigit( value[ 23 ] ) )
					&& (char.IsDigit( value[ 24 ] ) ) )
			{
                retval = XmlConvert.ToDateTime(value, XmlDateTimeSerializationMode.Utc);
            }
            else {
				throw CFLib.DefaultExceptionFactory.newInvalidArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					2,
					"value",
					"Invalid value format, must be YYYY-MM-DDTHH:MI:SSZ or YYYY-MM-DDTHH:MI:SS+HO:MO, \"" + value + "\" is invalid");
			}

			return( retval );
		}

		public static string formatBoolean(bool val ) {
            string retval;
			if( val ) {
				retval = "true";
			}
			else {
				retval = "false";
			}
			return( retval );
		}

		public static string formatBlob( byte[] val ) {
            string S_ProcName = "formatBlob";
			if( val == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"val" );
			}
            string retval = System.Convert.ToBase64String(val);
			return( retval );
		}
		
		public static string formatInt16(short val ) {
            string retval = val.ToString("D");
			return( retval );
		}

		public static string formatInt32(int val ) {
            string retval = val.ToString("D");
            return ( retval );
		}

		public static string formatInt64(long val ) {
            string retval = val.ToString("D");
            return ( retval );
		}

		public static string formatUInt16(ushort val ) {
            string retval = val.ToString("D");
            return ( retval );
		}

		public static string formatUInt32(uint val ) {
            string retval = val.ToString("D");
            return ( retval );
		}

		public static string formatUInt64(ulong val ) {
            string retval = val.ToString("D");
            return ( retval );
		}

		public static string formatSingle(float val ) {
            string retval = val.ToString("D#################################################################################################################################0.##################################################################################################################################");
			return( retval );
		}

		public static string formatDouble(double val ) {
            string retval = val.ToString("D#########################################################################################################################################################################################################################################################################################################################################0.##########################################################################################################################################################################################################################################################################################################################################");
			return( retval );
		}

		public static string formatNumber( BigDecimal val ) {
            string retval = val.ToString();
			return( retval );
		}

		public static string formatXmlString(string str ) {
            string S_ProcName = "formatXmlString";
			if( str == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"str" );
			}
			StringBuilder buff = new StringBuilder();
			char ch;
			int idx;
			int len = str.Length;
			for( idx = 0; idx < len; idx ++ ) {
				ch = str[idx];
				switch( ch ) {
					case '\n':
						buff.Append( "&#10;");
						break;
					case '\r':
						buff.Append( "&#13;" );
						break;
					case ' ':
					case '\t':
					case '@':
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'g':
					case 'h':
					case 'i':
					case 'j':
					case 'k':
					case 'l':
					case 'm':
					case 'n':
					case 'o':
					case 'p':
					case 'q':
					case 'r':
					case 's':
					case 't':
					case 'u':
					case 'v':
					case 'w':
					case 'x':
					case 'y':
					case 'z':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
					case '~':
					case '!':
					case '#':
					case '$':
					case '%':
					case '^':
					case '*':
					case '(':
					case ')':
					case '-':
					case '_':
					case '+':
					case '=':
					case '{':
					case '}':
					case '[':
					case ']':
					case ':':
					case ';':
					case ',':
					case '.':
					case '?':
					case '/':
					case '\\':
					case '|':
						buff.Append( ch );
						break;
					case '\'':
						buff.Append( "&apos;" );
						break;
					case '"':
						buff.Append( "&quot;" );
						break;
					case '&':
						buff.Append( "&amp;" );
						break;
					case '<':
						buff.Append( "&lt;" );
						break;
					case '>':
						buff.Append( "&gt;" );
						break;
					default:
						int charCode = (int)ch;
                        string seq = "&#" + CFLibXmlUtil.formatInt32( charCode ) + ";";
						buff.Append( seq );
						break;
				}
			}
            string retval = buff.ToString();
			return( retval );
		}

		public static string formatXmlStringWhitespacePreserve(string str ) {
            string S_ProcName = "formatXmlStringWhitespacePreserve";
			if( str == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"str" );
			}
			StringBuilder buff = new StringBuilder();
			char ch;
			int idx;
			int len = str.Length;
			for( idx = 0; idx < len; idx ++ ) {
				ch = str[idx];
				switch( ch ) {
					case '\n':
					case '\r':
					case ' ':
					case '\t':
					case '@':
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'g':
					case 'h':
					case 'i':
					case 'j':
					case 'k':
					case 'l':
					case 'm':
					case 'n':
					case 'o':
					case 'p':
					case 'q':
					case 'r':
					case 's':
					case 't':
					case 'u':
					case 'v':
					case 'w':
					case 'x':
					case 'y':
					case 'z':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
					case '~':
					case '!':
					case '#':
					case '$':
					case '%':
					case '^':
					case '*':
					case '(':
					case ')':
					case '-':
					case '_':
					case '+':
					case '=':
					case '{':
					case '}':
					case '[':
					case ']':
					case ':':
					case ';':
					case ',':
					case '.':
					case '?':
					case '/':
					case '\\':
					case '|':
						buff.Append( ch );
						break;
					case '\'':
						buff.Append( "&apos;" );
						break;
					case '"':
						buff.Append( "&quot;" );
						break;
					case '&':
						buff.Append( "&amp;" );
						break;
					case '<':
						buff.Append( "&lt;" );
						break;
					case '>':
						buff.Append( "&gt;" );
						break;
					default:
						int charCode = (int)ch;
                        string seq = "&#" + CFLibXmlUtil.formatInt32( charCode ) + ";";
						buff.Append( seq );
						break;
				}
			}
            string retval = buff.ToString();
			return( retval );
		}

		public static string formatDate( DateTime cal ) {
            string S_ProcName = "formatDate";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
					S_ProcName,
					1,
					"cal" );
			}
			StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:0000}", cal.Year));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", cal.Month + 1));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", cal.Day));
            string retval = buff.ToString();
			return( retval );
		}

		public static string formatTime( DateTime cal ) {
            string S_ProcName = "formatTime";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"cal" );
			}
            StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:00}", cal.Hour));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", cal.Minute));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", cal.Second));
            string retval = buff.ToString();
            return (retval);
		}

		public static string formatTimestamp( DateTime cal ) {
            string S_ProcName = "formatTimestamp";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName, 
						1,
						"cal" );
			}
            StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:0000}", cal.Year));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", cal.Month + 1));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", cal.Day));
            buff.Append('T');
            buff.Append(String.Format("{0:00}", cal.Hour));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", cal.Minute));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", cal.Second));
            string retval = buff.ToString();
            return (retval);
		}

		public static string formatTZDate( DateTime cal ) {
            string S_ProcName = "formatTZDate";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"cal" );
			}
            DateTime utcCal = cal.ToUniversalTime();
            StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:0000}", utcCal.Year));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", utcCal.Month + 1));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", utcCal.Day));
			buff.Append( 'Z' );
            string retval = buff.ToString();
			return( retval );
		}

		public static string formatTZTime( DateTime cal ) {
            string S_ProcName = "formatTZTime";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"cal" );
			}
            DateTime utcCal = cal.ToUniversalTime();
            StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:00}", utcCal.Hour));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", utcCal.Minute));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", utcCal.Second));
            buff.Append("Z");
            string retval = buff.ToString();
            return (retval);
        }

        public static string formatTZTimestamp( DateTime cal ) {
            string S_ProcName = "formatTZTimestamp";
			if( cal == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"cal" );
			}
            DateTime utcCal = cal.ToUniversalTime();
            StringBuilder buff = new StringBuilder();
            buff.Append(String.Format("{0:0000}", utcCal.Year));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", utcCal.Month + 1));
            buff.Append('-');
            buff.Append(String.Format("{0:00}", utcCal.Day));
            buff.Append('T');
            buff.Append(String.Format("{0:00}", utcCal.Hour));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", utcCal.Minute));
            buff.Append(':');
            buff.Append(String.Format("{0:00}", utcCal.Second));
            buff.Append('Z');
            String retval = buff.ToString();
            return (retval);
        }

        public static string formatUuid( Guid val ) {
            string S_ProcName = "formatUuid";
			if( val == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"val" );
			}
            string retval = val.ToString();
			return( retval );
		}

		/**
		 *	Formatting for Required XML attributes.
		**/
		
		public static string formatRequiredBoolean(string separator, string attrName, bool val ) {
            string S_ProcName = "formatRequiredBoolean";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatBoolean( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredBlob(string separator, string attrName, byte[] val ) {
            string S_ProcName = "formatRequiredBlob";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatBlob( val ) + "\"";
			return( retval );
		}
		
		public static string formatRequiredInt16(string separator, string attrName, short val ) {
            string S_ProcName = "formatRequiredInt16";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt16( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredInt32(string separator, string attrName, int val ) {
            string S_ProcName = "formatRequiredInt32";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt32( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredInt64(string separator, string attrName, long val ) {
            string S_ProcName = "formatRequiredInt64";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatInt64( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredUInt16(string separator, string attrName, ushort val ) {
            string S_ProcName = "formatRequiredUInt16";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt16( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredUInt32(string separator, string attrName, uint val ) {
            string S_ProcName = "formatRequiredUInt32";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt32( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredUInt64(string separator, string attrName, ulong val ) {
            string S_ProcName = "formatRequiredUInt64";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUInt64( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredSingle(string separator, string attrName, float val ) {
            string S_ProcName = "formatRequiredSingle";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatSingle( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredDouble(string separator, string attrName, double val ) {
            string S_ProcName = "formatRequiredDouble";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatDouble( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredNumber(string separator, string attrName, BigDecimal val ) {
            string S_ProcName = "formatRequiredNumber";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatNumber( val ) + "\"";
			return( retval );
		}

		public static string formatRequiredXmlString(string separator, string attrName, string str ) {
            string S_ProcName = "formatRequiredXmlString";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatXmlString( str ) + "\"";
			return( retval );
		}

		public static string formatRequiredDate(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredDate";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatDate( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredTime(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredTime";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTime( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredTimestamp(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredTimestamp";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTimestamp( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredTZDate(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredTZDate";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZDate( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredTZTime(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredTZTime";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZTime( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredTZTimestamp(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatRequiredTZTimestamp";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatTZTimestamp( cal ) + "\"";
			return( retval );
		}

		public static string formatRequiredUuid(string separator, string attrName, Guid val ) {
            string S_ProcName = "formatRequiredUuid";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval = (( separator != null ) ? separator : S_emptyString ) + attrName + "=\"" + formatUuid( val ) + "\"";
			return( retval );
		}

		/**
		 *	Formatting for Optional XML attributes.
		**/
		
		public static string formatOptionalBoolean(string separator, string attrName, bool? val ) {
            string S_ProcName = "formatOptionalBoolean";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
            if( val.HasValue ) {
				retval = formatRequiredBoolean( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalBlob(string separator, string attrName, byte[] val = null) {
            string S_ProcName = "formatOptionalBlob";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
            if( val == null ) {
                retval = formatRequiredBlob( separator, attrName, val );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}
		
		public static string formatOptionalInt16(string separator, string attrName, short? val ) {
            string S_ProcName = "formatOptionalInt16";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredInt16( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalInt32(string separator, string attrName, int? val ) {
            string S_ProcName = "formatOptionalInt32";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredInt32( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalInt64(string separator, string attrName, long? val ) {
            string S_ProcName = "formatOptionalInt64";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredInt64( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalUInt16(string separator, string attrName, ushort? val ) {
            string S_ProcName = "formatOptionalUInt16";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredUInt16( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalUInt32(string separator, string attrName, uint? val ) {
            string S_ProcName = "formatOptionalUInt32";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredUInt32( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalUInt64(string separator, string attrName, ulong? val ) {
            string S_ProcName = "formatOptionalUInt64";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredUInt64( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalSingle(string separator, string attrName, float? val ) {
            string S_ProcName = "formatOptionalSingle";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredSingle( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalDouble(string separator, string attrName, double? val ) {
            string S_ProcName = "formatOptionalDouble";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredDouble( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalNumber(string separator, string attrName, BigDecimal? val ) {
            string S_ProcName = "formatOptionalNumber";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val.HasValue ) {
				retval = formatRequiredNumber( separator, attrName, val.Value );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalXmlString(string separator, string attrName, string str ) {
            string S_ProcName = "formatOptionalXmlString";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( str == null ) {
				retval = formatRequiredXmlString( separator, attrName, str );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalDate(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalDate";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredDate( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalTime(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalTime";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredTime( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalTimestamp(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalTimestamp";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredTimestamp( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalTZDate(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalTZDate";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredTZDate( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalTZTime(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalTZTime";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredTZTime( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalTZTimestamp(string separator, string attrName, DateTime cal ) {
            string S_ProcName = "formatOptionalTZTimestamp";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( cal != null ) {
				retval = formatRequiredTZTimestamp( separator, attrName, cal );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}

		public static string formatOptionalUuid(string separator, string attrName, Guid val ) {
            string S_ProcName = "formatOptionalUuid";
			if( ( attrName == null ) || ( attrName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibXmlUtil),
						S_ProcName,
						1,
						"attrName" );
			}
            string retval;
			if( val != null ) {
				retval = formatRequiredUuid( separator, attrName, val );
			}
			else {
				retval = S_emptyString;
			}
			return( retval );
		}
	}
}
