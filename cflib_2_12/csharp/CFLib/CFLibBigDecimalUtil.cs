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
using System.Numerics;
using System.Text;

namespace CFLib
{
	public class CFLibBigDecimalUtil {

		public static int MAX_DIGITS = 31;
		public static int MAX_PRECISION = 30;
		
		static String S_Hashes = "###############################";
		static String S_Zeroes = "0000000000000000000000000000000";
		static String S_Nines =  "9999999999999999999999999999999";

		public static String getNumberFormat( String fieldOrClassName, int argDigits, int argPrecis ) {
			String S_ProcName = "getNumberFormat";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}

			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

			int integerDigits = argDigits - argPrecis;
			
			String usePrefixHash = S_Hashes.Substring( 0, integerDigits - 1 );
			
			String useSuffix;
			if( argPrecis > 0 ) {
				useSuffix = "." + S_Zeroes.Substring( 0, argPrecis );
			}
			else {
				useSuffix = "";
			}
			
			String numberFormat = "N" + argDigits + "." + argPrecis;
			
			return( numberFormat );
		}

		public static BigDecimal getAbsoluteMinValue( String fieldOrClassName, int argDigits, int argPrecis ) {
			String S_ProcName = "getAbsoluteMinValue";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}

			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

			int integerDigits = argDigits - argPrecis;

			String strval;
			if( argPrecis == 0 ) {
				strval = "-" + S_Nines.Substring( 0, integerDigits );
			}
			else {
				strval = "-" + S_Nines.Substring( 0, integerDigits ) + "." + S_Nines.Substring( 0, argPrecis );
			}

            BigInteger mantissa = BigInteger.Parse(strval, NumberStyles.Number);
            BigDecimal absoluteMinValue = new BigDecimal(mantissa, argPrecis);

            return ( absoluteMinValue );
		}

		public static BigDecimal getAbsoluteMaxValue( String fieldOrClassName, int argDigits, int argPrecis ) {
			String S_ProcName = "getAbsoluteMaxValue";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}

			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

			int integerDigits = argDigits - argPrecis;

			String strval;
			if( argPrecis == 0 ) {
				strval = S_Nines.Substring( 0, integerDigits );
			}
			else {
				strval = S_Nines.Substring( 0, integerDigits ) + "." + S_Nines.Substring( 0, argPrecis );
			}

            BigInteger mantissa = BigInteger.Parse(strval, NumberStyles.Number);
            BigDecimal absoluteMaxValue = new BigDecimal(mantissa, argPrecis);

            return (absoluteMaxValue);
        }

        public static BigDecimal coerce( String fieldOrClassName, int argDigits, int argPrecis, BigDecimal value ) {
			String S_ProcName = "coerce";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}
			
            if( value == null ) {
                throw CFLib.DefaultExceptionFactory.newNullArgumentException(typeof(CFLibBigDecimalUtil),
                    S_ProcName,
                    4,
                    "value" );
            }

			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

            BigDecimal minValue = getAbsoluteMinValue(fieldOrClassName, argDigits, argPrecis);
            BigDecimal maxValue = getAbsoluteMaxValue(fieldOrClassName, argDigits, argPrecis);

            if (value.CompareTo(minValue) < 0)
            {
                throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException(fieldOrClassName,
                    S_ProcName,
                    4,
                    "value",
                    value,
                    minValue);
            }
 
            if (value.CompareTo(maxValue) > 0)
            {
                throw CFLib.DefaultExceptionFactory.newArgumentOverflowException(fieldOrClassName,
                    S_ProcName,
                    4,
                    "value",
                    value,
                    maxValue);
            }

            BigDecimal coercedValue = value.Truncate(argPrecis);
			
			return( coercedValue );
		}

		public static BigDecimal? parse( String fieldOrClassName, int argDigits, int argPrecis, String value ) {
			String S_ProcName = "parse";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}

			if( ( value == null ) || ( value.Length <= 0 ) ) {
				return( null );
			}
			
			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

            StringBuilder buff = new StringBuilder();
            if (value.Length > 0)
            {
                int startDigits;
                int lenDigits;
                int decimalPoint;
                int startFrac;
                int lenFrac;
                int idx;
                idx = ((value[0] == '-') || (value[0] == '+')) ? 1 : 0;
                for (; (idx < value.Length) && (value[idx] == '0'); idx++) ;
                if (idx < value.Length)
                {
                    if (Char.IsDigit(value[idx]))
                    {
                        startDigits = idx;
                    }
                    else if (value[idx] == '.')
                    {
                        startDigits = ((value[0] == '-') || (value[0] == '+')) ? 1 : 0;
                        lenDigits = 0;
                    }
                    else
                    {
                        if ((idx == 0)
                                || ((idx == 1) &&
                                    ((value[0] == '-') || (value[0] == '+'))))
                        {
                            throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                S_ProcName,
                                0,
                                "value has no decimal digits",
                                value);
                        }
                        if (idx == 0)
                        {
                            startDigits = 0;
                        }
                        else
                        {
                            startDigits = idx - 1;
                        }
                    }
                    for (; (idx < value.Length) && Char.IsDigit(value[idx]); idx++) ;
                    lenDigits = idx - startDigits;
                    if (idx < value.Length)
                    {
                        if (value[idx] != '.')
                        {
                            throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                S_ProcName,
                                0,
                                "value has no decimal after the decimal digits",
                                value);
                        }
                        else
                        {
                            decimalPoint = idx;
                            idx++;
                            startFrac = idx;
                            for (; (idx < value.Length && Char.IsDigit(value[idx])); idx++) ;
                            if (idx < value.Length)
                            {
                                throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                    S_ProcName,
                                    0,
                                    "value has garbage after the fractional digits",
                                    value);
                            }
                            lenFrac = idx - startFrac;
                        }
                    }
                    else
                    {
                        startFrac = startDigits;
                        lenFrac = 0;
                    }
                }
                else
                {
                    if ((value[0] == '-') || (value[0] == '+'))
                    {
                        throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                            S_ProcName,
                            0,
                            "value is just a sign character",
                            value);
                    }
                    else
                    {
                        throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                            S_ProcName,
                            0,
                            "value is not valid",
                            value);
                    }
                }
                if (value[0] == '-' )
                {
                    buff.Append('-');
                }
                buff.Append(value.Substring(startDigits, lenDigits));
                if( lenDigits == 0 )
                {
                    buff.Append('0');
                }
                if (argPrecis > 0)
                {
                    if (lenFrac > argPrecis)
                    {
                        lenFrac = argPrecis;
                    }
                    buff.Append(value.Substring(startFrac, lenFrac));
                    while (lenFrac < argPrecis)
                    {
                        buff.Append('0');
                        lenFrac++;
                    }
                }
                BigInteger mantissa = BigInteger.Parse( buff.ToString(), NumberStyles.Number );
                BigDecimal retval = new BigDecimal( mantissa, argPrecis);

                BigDecimal minValue = getAbsoluteMinValue(fieldOrClassName, argDigits, argPrecis);
                BigDecimal maxValue = getAbsoluteMaxValue(fieldOrClassName, argDigits, argPrecis);

                if (retval.CompareTo(minValue) < 0)
                {
                    throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException(fieldOrClassName,
                        S_ProcName,
                        4,
                        "value",
                        retval,
                        minValue);
                }

                if (retval.CompareTo(maxValue) > 0)
                {
                    throw CFLib.DefaultExceptionFactory.newArgumentOverflowException(fieldOrClassName,
                        S_ProcName,
                        4,
                        "value",
                        retval,
                        maxValue);
                }

                return (retval);
            }
            else
            {
                return (null);
            }
		}

		public static String format( String fieldOrClassName, int argDigits, int argPrecis, BigDecimal value ) {
			String S_ProcName = "format";

			if( ( fieldOrClassName == null ) || ( fieldOrClassName.Length <= 0 ) ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( typeof(CFLibBigDecimalUtil),
					S_ProcName,
					1,
					"fieldOrClassName" );
			}

			if( value == null ) {
				throw CFLib.DefaultExceptionFactory.newNullArgumentException( fieldOrClassName,
					S_ProcName,
					4,
					"value" );
			}
			
			if( argDigits < 1 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					1 );
			}
			else if( argDigits > MAX_DIGITS ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					2,
					"argDigits",
					argDigits,
					MAX_DIGITS );
			}

			if( argPrecis < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					0 );
			}
			else if( argPrecis > MAX_PRECISION ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					MAX_PRECISION );
			}

			if( argPrecis >= argDigits ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					3,
					"argPrecis",
					argPrecis,
					argDigits - 1 );
			}

			BigDecimal minValue = getAbsoluteMinValue( fieldOrClassName, argDigits, argPrecis );
			if( value.CompareTo( minValue ) < 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentUnderflowException( fieldOrClassName,
					S_ProcName,
					4,
					"value",
					value,
					minValue );
			}
			
			BigDecimal maxValue = getAbsoluteMaxValue( fieldOrClassName, argDigits, argPrecis );
			if( value.CompareTo( maxValue ) > 0 ) {
				throw CFLib.DefaultExceptionFactory.newArgumentOverflowException( fieldOrClassName,
					S_ProcName,
					4,
					"value",
					value,
					maxValue );
			}

            StringBuilder buff = new StringBuilder();
            String retval;
            String withLeadingZeroesString = value.ToString();
            if (withLeadingZeroesString.Length > 0) {
                int startDigits;
                int lenDigits;
                int decimalPoint;
                int startFrac;
                int lenFrac;
                int idx;
                idx = ((withLeadingZeroesString[0] == '-') || (withLeadingZeroesString[0] == '+')) ? 1 : 0;
                for (; (idx < withLeadingZeroesString.Length) && (withLeadingZeroesString[idx] == '0'); idx++) ;
                if (idx < withLeadingZeroesString.Length)
                {
                    if (Char.IsDigit(withLeadingZeroesString[idx]))
                    {
                        startDigits = idx;
                    }
                    else if (withLeadingZeroesString[idx] == '.')
                    {
                        startDigits = ((withLeadingZeroesString[0] == '-') || (withLeadingZeroesString[0] == '+')) ? 1 : 0;
                        lenDigits = 0;
                    }
                    else {
                        if ((idx == 0)
                                || ((idx == 1) &&
                                    ((withLeadingZeroesString[0] == '-') || (withLeadingZeroesString[0] == '+'))))
                        {
                            throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                S_ProcName,
                                0,
                                "withLeadingZeroesString has no decimal digits",
                                withLeadingZeroesString);
                        }
                        if (idx == 0)
                        {
                            startDigits = 0;
                        }
                        else
                        {
                            startDigits = idx - 1;
                        }
                    }
                    for (; (idx < withLeadingZeroesString.Length) && Char.IsDigit(withLeadingZeroesString[idx]); idx++) ;
                    lenDigits = idx - startDigits;
                    if (idx < withLeadingZeroesString.Length)
                    {
                        if (withLeadingZeroesString[idx] != '.')
                        {
                            throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                S_ProcName,
                                0,
                                "withLeadingZeroesString has no decimal after the decimal digits",
                                withLeadingZeroesString);
                        }
                        else
                        {
                            decimalPoint = idx;
                            idx++;
                            startFrac = idx;
                            for (; (idx < withLeadingZeroesString.Length && Char.IsDigit(withLeadingZeroesString[idx])); idx++) ;
                            if (idx < withLeadingZeroesString.Length)
                            {
                                throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                                    S_ProcName,
                                    0,
                                    "withLeadingZeroesString has garbage after the fractional digits",
                                    withLeadingZeroesString);
                            }
                            lenFrac = idx - startFrac;
                        }
                    }
                    else
                    {
                        startFrac = startDigits;
                        lenFrac = 0;
                    }
                }
                else
                {
                    if ((withLeadingZeroesString[0] == '-') || (withLeadingZeroesString[0] == '+')) {
                        throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                            S_ProcName,
                            0,
                            "withLeadingZeroesString is just a sign character",
                            withLeadingZeroesString);
                    }
                    else {
                        throw CFLib.DefaultExceptionFactory.newInvalidArgumentException(typeof(CFLibBigDecimalUtil),
                            S_ProcName,
                            0,
                            "withLeadingZeroesString is not valid",
                            withLeadingZeroesString);
                    }
                }
                switch (withLeadingZeroesString[0]) {
                    case '-':
                        buff.Append('-');
                        buff.Append(withLeadingZeroesString.Substring(startDigits, lenDigits));
                        break;
                    case '+':
                        buff.Append(withLeadingZeroesString.Substring(startDigits, lenDigits));
                        break;
                    default:
                        buff.Append(withLeadingZeroesString.Substring(startDigits, lenDigits));
                        break;
                }
                if (argPrecis > 0)
                {
                    if (lenFrac > argPrecis)
                    {
                        lenFrac = argPrecis;
                    }
                    buff.Append('.');
                    buff.Append(withLeadingZeroesString.Substring(startFrac, lenFrac));
                    while (lenFrac < argPrecis)
                    {
                        buff.Append('0');
                        lenFrac++;
                    }
                }
            }
            retval = buff.ToString();
            return (retval);
		}
	}
}
