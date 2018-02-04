/*
 * Modifications Copyright (c) 2018 Razeware LLC
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.raywenderlich.android.validatetor;

import java.util.regex.Pattern;

/**
 * The type Regex preset pattern.
 */
class RegexPresetPattern {

  /**
   * The constant ATLEAST_ONE_DIGIT.
   */
  final static Pattern ATLEAST_ONE_DIGIT = Pattern.compile("[0-9]");
  /**
   * The constant ATLEAST_ONE_UPPERCASE_CHARACTER.
   */
  final static Pattern ATLEAST_ONE_UPPERCASE_CHARACTER = Pattern.compile("[A-Z]");
  /**
   * The constant ATLEAST_ONE_LOWERCASE_CHARACTER.
   */
  final static Pattern ATLEAST_ONE_LOWERCASE_CHARACTER = Pattern.compile("[a-z]");
  /**
   * The constant ATLEAST_ONE_LETTER.
   */
  final static Pattern ATLEAST_ONE_LETTER = Pattern.compile("[a-zA-Z]");
  /**
   * The constant ATLEAST_ONE_SPECIAL_CHARACTER.
   */
  final static Pattern ATLEAST_ONE_SPECIAL_CHARACTER = Pattern.compile("[^a-zA-Z0-9\\s]");
  /**
   * The constant PINCODE.
   */
  final static Pattern PINCODE = Pattern.compile("^[0-9]{6}$");
  /**
   * The constant ALPHANUMERIC.
   */
  final static Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9_]+$");
  /**
   * The constant NUMERIC.
   */
  final static Pattern NUMERIC = Pattern.compile("^[0-9]+");
  /**
   * The constant ALPHA.
   */
  final static Pattern ALPHA = Pattern.compile("[a-zA-Z]+");
  /**
   * The constant DECIMAL_NUMBER.
   */
  final static Pattern DECIMAL_NUMBER = Pattern.compile("^[0-9]*\\.?[0-9]*$");
  /**
   * The constant MAC_ADDRESS.
   */
  final static Pattern MAC_ADDRESS = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
  /**
   * The constant HEXADECIMAL.
   */
  final static Pattern HEXADECIMAL = Pattern.compile("\\p{XDigit}+");

  final static Pattern MD5 = Pattern.compile("[a-fA-F0-9]{32}");

  /**
   * Matches all IPV6 and IPV4 addresses. Doesn't limit IPV4 to just values of 255. Doesn't
   * allow IPV6 compression.
   */
  final static Pattern IP_ADDRESS = Pattern.compile("([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|(\\d{1,3}\\.){3}\\d{1,3}");

  /**
   * According to RFC 2821 (see http://tools.ietf.org/html/2821) and
   * RFC 2822 (see http://tools.ietf.org/html/2822), the local-part of an email addresses
   * may use any of these ASCII characters:
   * 1. Uppercase and lowercare letters
   * 2. The digits 0 through 9
   * 3. The characters, !#$%&'*+-/=?^_`{|}~
   * 4. The character "." provided that it is not the first or last character in the local-part.
   */
  final static Pattern EMAIL = Pattern.compile("^((([!#$%&'*+\\-/=?^_`{|}~\\w])|" +
      "([!#$%&'*+\\-/=?^_`{|}~\\w][!#$%&'*+\\-/=?^_`{|}~\\w]*[!#$%&'*+\\-/=?^_`{|}~\\w]))[@]\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)$");

  /**
   * Matches a hyphen separated US phone number, of the form ANN-NNN-NNNN, where A is between 2
   * and 9 and N is between 0 and 9.
   */
  final static Pattern PHONE = Pattern.compile("^[2-9]\\d{2}-\\d{3}-\\d{4}$");
}
