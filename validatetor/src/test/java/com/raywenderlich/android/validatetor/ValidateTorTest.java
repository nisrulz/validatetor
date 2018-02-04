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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ValidateTorTest {

  private ValidateTor validateTor;


  @Before
  public void setUp() throws Exception {
    validateTor = new ValidateTor();
  }

  @After
  public void tearDown() throws Exception {
    validateTor = null;
  }

  @Test
  public void containsSubstring_shouldReturnsTrue_whenSeedIsPresentInsideString_ignoreCase() throws
      Exception {
    assertEquals(true, validateTor.containsSubstring("abcdEfgHiJK", "def"));
    assertEquals(true, validateTor.containsSubstring("abcdEfgHiJK", "DEFG"));
    assertEquals(true, validateTor.containsSubstring("abcdEfgHiJK", "f"));
    assertEquals(true, validateTor.containsSubstring("abcdEfgHiJK", "F"));
    assertEquals(true, validateTor.containsSubstring("abcdEfgHiJK", "E"));
  }

  @Test
  public void containsSubstring_shouldReturnsFalse_whenSeedIsNotPresentInsideString_ignoreCase()
      throws
      Exception {
    assertEquals(false, validateTor.containsSubstring("abcdEfgHiJK", "acd"));
  }

  @Test
  public void isAlpha_shouldReturnTrue_whenStringContainsOnlyAlphaCharacters() throws Exception {
    assertEquals(true, validateTor.isAlpha("abcdEfgHiJK"));
    assertEquals(true, validateTor.isAlpha("abcd"));
    assertEquals(true, validateTor.isAlpha("A"));
    assertEquals(true, validateTor.isAlpha("Ab"));
    assertEquals(true, validateTor.isAlpha("bC"));
  }


  @Test
  public void
  isAlpha_shouldReturnFalse_whenStringContainsAnyOtherCharacterOtherThanAlphaCharacters()
      throws
      Exception {
    assertEquals(false, validateTor.isAlpha("1"));
    assertEquals(false, validateTor.isAlpha("&"));
    assertEquals(false, validateTor.isAlpha("abc123"));
    assertEquals(false, validateTor.isAlpha("123abc"));
    assertEquals(false, validateTor.isAlpha(" ")); // space character
    assertEquals(false, validateTor.isAlpha("  ")); //tab character
  }

  @Test
  public void isAlphanumeric_shouldReturnTrue_whenStringContainsOnlyAlphaAndNumericCharacters()
      throws
      Exception {
    assertEquals(true, validateTor.isAlphanumeric("abcd123"));
    assertEquals(true, validateTor.isAlphanumeric("12452abcd"));
    assertEquals(true, validateTor.isAlphanumeric("abcdEfgHiJK"));
  }

  @Test
  public void
  isAlphanumeric_shouldReturnFalse_whenStringContainsSpecialCharacterOtherThanAlphaNumericCharacters()
      throws Exception {

    assertEquals(false, validateTor.isAlphanumeric("#"));
    assertEquals(false, validateTor.isAlphanumeric("%"));
    assertEquals(false, validateTor.isAlphanumeric("\r"));
    assertEquals(false, validateTor.isAlphanumeric("123("));
    assertEquals(false, validateTor.isAlphanumeric("123(abc"));
    assertEquals(false, validateTor.isAlphanumeric(" ")); // space character
    assertEquals(false, validateTor.isAlphanumeric("  ")); //tab character
  }

  @Test
  public void isBoolean_shouldReturnTrue_whenStringIsTrue() throws Exception {
    assertEquals(true, validateTor.isBoolean("true"));
    assertEquals(true, validateTor.isBoolean("True"));
    assertEquals(true, validateTor.isBoolean("TRUE"));
    assertEquals(true, validateTor.isBoolean("TrUe"));

    assertEquals(true, validateTor.isBoolean("false"));
    assertEquals(true, validateTor.isBoolean("False"));
    assertEquals(true, validateTor.isBoolean("FALSE"));
    assertEquals(true, validateTor.isBoolean("fAlSe"));
  }

  @Test
  public void isBoolean_shouldReturnFalse_whenStringIsFalse() throws Exception {
    assertEquals(false, validateTor.isBoolean("fals1"));
    assertEquals(false, validateTor.isBoolean("1False"));
    assertEquals(false, validateTor.isBoolean("Trye1"));
    assertEquals(false, validateTor.isBoolean("True1"));
  }

  @Test
  public void isIPAddress_shouldReturnTrue_whenStringIsValidIP() throws Exception {
    assertEquals(true, validateTor.isIPAddress("10.255.255.254"));
    assertEquals(true, validateTor.isIPAddress("192.168.0.0"));
    assertEquals(true, validateTor.isIPAddress("0:0:0:0:0:0:0:1"));
    assertEquals(true, validateTor.isIPAddress("0.0.0.1"));
  }

  @Test
  public void isEmail_shouldReturnTrue_whenStringIsValidEmailAddress() throws Exception {
    assertEquals(true, validateTor.isEmail("a&d@somedomain.com"));
    assertEquals(true, validateTor.isEmail("a*d@somedomain.com"));
    assertEquals(true, validateTor.isEmail("a/d@somedomain.com"));
  }

  @Test
  public void isEmail_shouldReturnTrue_whenStringIsInvalidEmailAddress() throws Exception {
    assertEquals(false, validateTor.isEmail(".abc@somedomain.com"));
    assertEquals(false, validateTor.isEmail("bc.@somedomain.com"));
    assertEquals(false, validateTor.isEmail("a>b@somedomain.com"));
  }

  @Test
  public void isPhoneNumber_shouldReturnTrue_whenStringIsValidPhoneNumber() throws Exception {
    assertEquals(true, validateTor.isPhoneNumber("800-555-5555"));
    assertEquals(true, validateTor.isPhoneNumber("333-444-5555"));
    assertEquals(true, validateTor.isPhoneNumber("212-666-1234"));

  }

  @Test
  public void isPhoneNumber_shouldReturnFalse_whenStringIsInvalidPhoneNumber() throws Exception {
    assertEquals(false, validateTor.isPhoneNumber("000-000-0000"));
    assertEquals(false, validateTor.isPhoneNumber("123-456-7890"));
    assertEquals(false, validateTor.isPhoneNumber("2126661234"));

  }

  @Test
  public void isDecimal_shouldReturnTrue_whenStringIsDecimal() throws Exception {
    assertEquals(true, validateTor.isDecimal("1.000"));
    assertEquals(true, validateTor.isDecimal("0012.0"));
    assertEquals(true, validateTor.isDecimal("123.000"));
    assertEquals(true, validateTor.isDecimal(".003"));
  }

  @Test
  public void isAtleastLength_shouldReturnTrue_whenStringIsOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(true, validateTor.isAtleastLength("abc", 2));
    assertEquals(true, validateTor.isAtleastLength("abc", 3));
    assertEquals(true, validateTor.isAtleastLength("abcdef", 5));
  }


  @Test
  public void isAtleastLength_shouldReturnFalse_whenStringIsNotOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(false, validateTor.isAtleastLength("abc", 4));
    assertEquals(false, validateTor.isAtleastLength("abc", 5));
  }

  @Test
  public void isAtMostLength_shouldReturnTrue_whenStringIsOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(true, validateTor.isAtMostLength("abc", 5));
    assertEquals(true, validateTor.isAtMostLength("abc", 3));
    assertEquals(true, validateTor.isAtMostLength("abcdef", 10));
  }


  @Test
  public void isAtMostLength_shouldReturnFalse_whenStringIsNotOfAtleastSpecifiedLength() throws
      Exception {
    assertEquals(false, validateTor.isAtMostLength("abc", 2));
    assertEquals(false, validateTor.isAtMostLength("abc", 1));
  }


  @Test
  public void isLowercase_shouldReturnTrue_whenStringIsLowercase() throws Exception {
    assertEquals(true, validateTor.isLowercase("abc"));
  }

  @Test
  public void isLowercase_shouldReturnFalse_whenStringIsNotLowercase() throws Exception {
    assertEquals(false, validateTor.isLowercase("aBC"));
    assertEquals(false, validateTor.isLowercase("ABC"));
    assertEquals(false, validateTor.isLowercase("AbC"));
  }


  @Test
  public void isUppercase_shouldReturnTrue_whenStringIsUppercase() throws Exception {
    assertEquals(true, validateTor.isUppercase("ABC"));
  }

  @Test
  public void isUppercase_shouldReturnFalse_whenStringIsNotUppercase() throws Exception {
    assertEquals(false, validateTor.isUppercase("aBC"));
    assertEquals(false, validateTor.isUppercase("abc"));
    assertEquals(false, validateTor.isUppercase("AbC"));
  }

  @Test
  public void isValidMD5_shouldReturnTrue_whenStringIsValidMD5() throws Exception {
    assertEquals(true, validateTor.isValidMD5("5d41402abc4b2a76b9719d911017c592"));
  }

  @Test
  public void isValidMD5_shouldReturnFalse_whenStringIsInvalidMD5() throws Exception {
    assertEquals(false, validateTor.isValidMD5("5d41402abc4b2a76b9719d911017"));
  }

  @Test
  public void isNumeric_shouldReturnTrue_whenStringIsNumeric() throws Exception {
    assertEquals(true, validateTor.isNumeric("1234"));
  }

  @Test
  public void isNumeric_shouldReturnFalse_whenStringIsNotNumeric() throws Exception {
    assertEquals(false, validateTor.isUppercase("123a"));
    assertEquals(false, validateTor.isUppercase("abc123"));
  }

  @Test
  public void isInt_shouldReturnTrue_whenStringIsInteger() throws Exception {
    assertEquals(true, validateTor.isInteger("123"));
  }


  @Test
  public void isInt_shouldReturnFalse_whenStringIsNotInteger() throws Exception {
    assertEquals(false, validateTor.isInteger("a12"));
    assertEquals(false, validateTor.isInteger("abc"));
  }

  @Test
  public void isIn_shouldReturnTrue_whenStringIsInTheArray() throws Exception {
    assertEquals(true, validateTor.isIn("a1", new String[]{"a1", "a2", "a3", "a4"}));
  }

  @Test
  public void isIn_shouldReturnFalse_whenStringIsNotInTheArray() throws Exception {
    assertEquals(false, validateTor.isIn("a1", new String[]{"a2", "a3", "a4"}));
  }

  @Test
  public void isHexadecimal_shouldReturnTrue_whenStringIsHexadecimal() throws Exception {
    assertEquals(true, validateTor.isHexadecimal("3FA7"));
  }

  @Test
  public void isHexadecimal_shouldReturnFalse_whenStringIsNotHexadecimal() throws Exception {
    assertEquals(false, validateTor.isHexadecimal("GFA7"));
  }

  @Test
  public void isPinCode_shouldReturnTrue_whenStringIsValidPinCode() throws Exception {
    assertEquals(true, validateTor.isPinCode("282001"));
  }

  @Test
  public void isPinCode_shouldReturnFalse_whenStringIsInvalidPinCode() throws Exception {
    assertEquals(false, validateTor.isPinCode("28200"));
    assertEquals(false, validateTor.isPinCode("a28200"));
    assertEquals(false, validateTor.isPinCode("123"));
  }

  @Test
  public void hasAtleastOneDigit_shouldReturnTrue_whenStringHasAtleastOneDigit() throws Exception {
    assertEquals(true, validateTor.hasAtleastOneDigit("abcde1"));
    assertEquals(true, validateTor.hasAtleastOneDigit("a1b2c3"));
    assertEquals(true, validateTor.hasAtleastOneDigit("123"));
  }

  @Test
  public void hasAtleastOneDigit_shouldReturnFalse_whenStringDoesnotHaveAtleastOneDigit() throws
      Exception {
    assertEquals(false, validateTor.hasAtleastOneDigit("abcde"));
    assertEquals(false, validateTor.hasAtleastOneDigit("aaaa"));
    assertEquals(false, validateTor.hasAtleastOneDigit("#$%^&"));
  }

  @Test
  public void hasAtleastOneLetter_shouldReturnTrue_whenStringHasAtleastOneLetter() throws
      Exception {
    assertEquals(true, validateTor.hasAtleastOneLetter("abcde1"));
    assertEquals(true, validateTor.hasAtleastOneLetter("a1b2c3"));
    assertEquals(true, validateTor.hasAtleastOneLetter("123abc"));
    assertEquals(true, validateTor.hasAtleastOneLetter("abcdef"));
    assertEquals(true, validateTor.hasAtleastOneLetter("ABC"));
    assertEquals(true, validateTor.hasAtleastOneLetter("AB123"));
    assertEquals(true, validateTor.hasAtleastOneLetter("aBcD123#"));
  }

  @Test
  public void hasAtleastOneLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneLetter() throws
      Exception {
    assertEquals(false, validateTor.hasAtleastOneLetter("123456"));
    assertEquals(false, validateTor.hasAtleastOneLetter("11#$"));
    assertEquals(false, validateTor.hasAtleastOneLetter("#$%^&"));
  }

  @Test
  public void
  hasAtleastOneLowercaseLetter_shouldReturnTrue_whenStringHasAtleastOneLowercaseLetter() throws
      Exception {
    assertEquals(true, validateTor.hasAtleastOneLowercaseCharacter("abcde1"));
    assertEquals(true, validateTor.hasAtleastOneLowercaseCharacter("a1b2c3"));
    assertEquals(true, validateTor.hasAtleastOneLowercaseCharacter("123abc"));
    assertEquals(true, validateTor.hasAtleastOneLowercaseCharacter("abcdef"));
    assertEquals(true, validateTor.hasAtleastOneLowercaseCharacter("aBcD123#"));
  }

  @Test
  public void
  hasAtleastOneLowercaseLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneLowercaseLetter()
      throws
      Exception {
    assertEquals(false, validateTor.hasAtleastOneLowercaseCharacter("123456"));
    assertEquals(false, validateTor.hasAtleastOneLowercaseCharacter("11#$"));
    assertEquals(false, validateTor.hasAtleastOneLowercaseCharacter("#$%^&"));
    assertEquals(false, validateTor.hasAtleastOneLowercaseCharacter("ABC"));
    assertEquals(false, validateTor.hasAtleastOneLowercaseCharacter("ABC123"));
  }

  @Test
  public void
  hasAtleastOneUppercaseLetter_shouldReturnTrue_whenStringHasAtleastOneUppercaseLetter() throws
      Exception {
    assertEquals(true, validateTor.hasAtleastOneUppercaseCharacter("ABC123"));
    assertEquals(true, validateTor.hasAtleastOneUppercaseCharacter("A1B2C3"));
    assertEquals(true, validateTor.hasAtleastOneUppercaseCharacter("123ABC"));
    assertEquals(true, validateTor.hasAtleastOneUppercaseCharacter("ABC"));
    assertEquals(true, validateTor.hasAtleastOneUppercaseCharacter("aBcD123#"));
  }

  @Test
  public void
  hasAtleastOneUpperLetter_shouldReturnFalse_whenStringDoesnotHasAtleastOneUppercaseLetter()
      throws
      Exception {
    assertEquals(false, validateTor.hasAtleastOneUppercaseCharacter("123456"));
    assertEquals(false, validateTor.hasAtleastOneUppercaseCharacter("11#$"));
    assertEquals(false, validateTor.hasAtleastOneUppercaseCharacter("#$%^&"));
    assertEquals(false, validateTor.hasAtleastOneUppercaseCharacter("abc"));
    assertEquals(false, validateTor.hasAtleastOneUppercaseCharacter("abcde1"));
  }


  @Test
  public void
  hasAtleastOneSpecialCharacter_shouldReturnTrue_whenStringHasAtleastOneSpecialCharacter() throws
      Exception {
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("ABC123#"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("$A1B2C3"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("123@ABC"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("!ABC"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter(".aBcD123#"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("11#$"));
    assertEquals(true, validateTor.hasAtleastOneSpecialCharacter("#$%^&"));
  }

  @Test
  public void
  hasAtleastOneSpecialCharacter_shouldReturnFalse_whenStringDoesnotHasAtleastOneSpecialCharacter()
      throws
      Exception {
    assertEquals(false, validateTor.hasAtleastOneSpecialCharacter("123456"));
    assertEquals(false, validateTor.hasAtleastOneSpecialCharacter("abc"));
    assertEquals(false, validateTor.hasAtleastOneSpecialCharacter("ABC"));
    assertEquals(false, validateTor.hasAtleastOneSpecialCharacter("ABCdef123"));
    assertEquals(false, validateTor.hasAtleastOneSpecialCharacter("abcde1"));
  }
}