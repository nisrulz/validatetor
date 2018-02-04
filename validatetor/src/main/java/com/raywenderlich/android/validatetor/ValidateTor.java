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

import android.graphics.Color;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;

/**
 * The type Validate tor.
 */
public class ValidateTor {

  /**
   * The Regex matcher.
   */
  private final RegexMatcher regexMatcher;

  /**
   * The Card validator.
   */
  private final CardValidator cardValidator;

  /**
   * Instantiates a new Validate tor.
   */
  public ValidateTor() {
    this.regexMatcher = new RegexMatcher();
    this.cardValidator = new CardValidator();
  }

  /**
   * check if the string contains the seed.
   *
   * @param str  the str
   * @param seed the seed
   * @return the boolean
   */
  public boolean containsSubstring(String str, String seed) {
    return Pattern.compile(Pattern.quote(seed), Pattern.CASE_INSENSITIVE).matcher(str).find();
  }


  /**
   * check if the string contains only letters.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isAlpha(String str) {
    return regexMatcher.validate(str, RegexPresetPattern.ALPHA);
  }

  /**
   * check if the string contains only letters and numbers.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isAlphanumeric(String str) {
    return regexMatcher.validate(str, RegexPresetPattern.ALPHANUMERIC);
  }


  /**
   * check if a string is a boolean.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isBoolean(String str) {
    return str.toLowerCase().equals("true") || str.toLowerCase().equals("false");
  }

  /**
   * check if the string is a ip address.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isIPAddress(String str) {
    return regexMatcher.validate(str, RegexPresetPattern.IP_ADDRESS);
  }

  /**
   * check if the string is a email address
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isEmail(String str) {
    return regexMatcher.validate(str, RegexPresetPattern.EMAIL);
  }

  /**
   * check if the string is a US phone number
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isPhoneNumber(String str) {
    return regexMatcher.validate(str, RegexPresetPattern.PHONE);
  }

  /**
   * check if the string has a length of zero.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isEmpty(String str) {
    return str == null || TextUtils.isEmpty(str);
  }

  /**
   * check if a string is base64 encoded.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isBase64(String str) {
    try {
      android.util.Base64.decode(str, android.util.Base64.DEFAULT);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }


  /**
   * check if the string represents a decimal number, such as 0.1, .3, 1.1, 1.00003, 4.0, etc.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isDecimal(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.DECIMAL_NUMBER);
  }


  /**
   * check if the string is of atleast the specified length.
   *
   * @param str the str
   * @param len the len
   * @return the boolean
   */
  public boolean isAtleastLength(String str, int len) {

    return str.length() >= len;
  }

  /**
   * check if the string is of atmost the specified length.
   *
   * @param str the str
   * @param len the len
   * @return the boolean
   */
  public boolean isAtMostLength(String str, int len) {

    return str.length() <= len;
  }


  /**
   * check if the string is all lowercase.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isLowercase(String str) {
    return str.equals(str.toLowerCase());
  }

  /**
   * check if the string is all uppercase.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isUppercase(String str) {
    return str.equals(str.toUpperCase());
  }


  /**
   * check if the string is a valid MD5 hash.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isValidMD5(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.MD5);
  }

  /**
   * check if the string contains only numbers.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isNumeric(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.NUMERIC);
  }

  /**
   * check if the string is a MAC address
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isMACAddress(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.MAC_ADDRESS);
  }

  /**
   * check if the string is valid JSON.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isJSON(String str) {
    try {
      // check against JSONObject
      new JSONObject(str);
    } catch (JSONException ex) {
      // check against JSONArray
      try {
        new JSONArray(str);
      } catch (JSONException ex1) {
        return false;
      }
      return false;
    }
    return true;
  }

  /**
   * check if the string is an integer.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isInteger(String str) {

    if (str == null) {
      return false;
    }
    int length = str.length();
    if (length == 0) {
      return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
      if (length == 1) {
        return false;
      }
      i = 1;
    }
    for (; i < length; i++) {
      char c = str.charAt(i);
      if (c < '0' || c > '9') {
        return false;
      }
    }
    return true;
  }


  /**
   * check if the string is present in an array of allowed values.
   *
   * @param str    the str
   * @param values the values
   * @return the boolean
   */
  public boolean isIn(String str, String[] values) {
    for (String val : values) {
      if (val.equals(str)) {
        return true;
      }
    }
    return false;
  }


  /**
   * check if the string is a hexadecimal number.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isHexadecimal(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.HEXADECIMAL);
  }

  /**
   * check if the string is a pincode.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isPinCode(String str) {

    return regexMatcher.validate(str, RegexPresetPattern.PINCODE);
  }


  /**
   * check if the string is a hexadecimal color.
   *
   * @param str the str
   * @return the boolean
   */
  public boolean isHexColor(String str) {
    try {
      Color.parseColor(str);
      return true;
    } catch (IllegalArgumentException iae) {
      return false;
    }
  }


  /**
   * check if the string has atleast one digit
   *
   * @param str the str
   * @return the boolean
   */
  public boolean hasAtleastOneDigit(String str) {
    return regexMatcher.find(str, RegexPresetPattern.ATLEAST_ONE_DIGIT);
  }

  /**
   * check if the string has atleast one letter
   *
   * @param str the str
   * @return the boolean
   */
  public boolean hasAtleastOneLetter(String str) {
    return regexMatcher.find(str, RegexPresetPattern.ATLEAST_ONE_LETTER);
  }


  /**
   * check if the string has atleast one lowercase character
   *
   * @param str the str
   * @return the boolean
   */
  public boolean hasAtleastOneLowercaseCharacter(String str) {
    return regexMatcher.find(str, RegexPresetPattern.ATLEAST_ONE_LOWERCASE_CHARACTER);
  }


  /**
   * check if the string has atleast one uppercase character
   *
   * @param str the str
   * @return the boolean
   */
  public boolean hasAtleastOneUppercaseCharacter(String str) {
    return regexMatcher.find(str, RegexPresetPattern.ATLEAST_ONE_UPPERCASE_CHARACTER);
  }


  /**
   * check if the string has atleast one special character
   *
   * @param str the str
   * @return the boolean
   */
  public boolean hasAtleastOneSpecialCharacter(String str) {
    return regexMatcher.find(str, RegexPresetPattern.ATLEAST_ONE_SPECIAL_CHARACTER);
  }

  /**
   * check if the string is a valid credit card number
   *
   * @param str the str
   * @return the boolean
   */
  public boolean validateCreditCard(String str) {
    return cardValidator.validateCreditCardNumber(str);
  }

  /**
   * Get CreditCard information from string
   *
   * @param str the str
   * @return the credit card info
   */
  public CardInformation getCreditCardInfo(String str) {
    return cardValidator.getCardInformation(str);
  }


}
