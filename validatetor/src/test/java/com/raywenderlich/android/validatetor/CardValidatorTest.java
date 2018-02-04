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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CardValidatorTest {
  private final String cardNumber;
  private final boolean expectedIsValid;
  private final String expectedCardIssuer;
  private final String expectedErrorInfo;
  private CardInformation cardInformation;
  private CardValidator cardValidator;


  public CardValidatorTest(final String cardNumber, final boolean expectedIsValid,
                           final String expectedCardIssuer, String expectedErrorInfo) {
    this.cardNumber = cardNumber;
    this.expectedIsValid = expectedIsValid;
    this.expectedCardIssuer = expectedCardIssuer;
    this.expectedErrorInfo = expectedErrorInfo;
  }

  @Parameters(name = "{index}: testCreditCard({0}) = {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"4929804463622139", true, "Visa", "NA"},
        {"4929804463622138", false, "Visa", "Number did not pass the Luhn Algo Test!"},
        {"6762765696545485", true, "Maestro", "NA"},
        {"5212132012291762", false, "Mastercard", "Number did not pass the Luhn Algo Test!"},
        {"6210948000000029", true, "China Union Pay", "NA"},
        {"61294wuriyq98797", false, "Unknown", "Number should be composed of only digits!"},
        {"00007129847197591315", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
        {"8971247", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
        {"1241241294184701240124", false, "Unknown", "Card number should be of length > 12 and < 19 digits!"},
    });
  }

  @Before
  public void setup() throws Exception {

    cardValidator = new CardValidator();
    cardInformation = cardValidator.getCardInformation(cardNumber);
  }

  @Test
  public void checkIfCardIsValid() {
    assertEquals(cardInformation.isValid(), expectedIsValid);
  }

  @Test
  public void checkIfCardIssuerIsCorrect() {
    assertEquals(cardInformation.getCardIssuer(), expectedCardIssuer);
  }


  @Test
  public void checkIfErrorInfoIsCorrect() {
    assertEquals(cardInformation.getError(), expectedErrorInfo);
  }


  @Test
  public void checkIfNumberIsSetInCardInformationObject() {
    assertEquals(cardInformation.getCardNumber(), cardNumber);
  }

}