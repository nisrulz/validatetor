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

/**
 * The type Card information.
 */
public class CardInformation {

  private String cardIssuer;

  private boolean isValid;

  private String error;

  private String cardNumber;

  /**
   * Instantiates a new Card information.
   *
   * @param cardNumber the card number
   */
  public CardInformation(final String cardNumber) {
    this.cardNumber = cardNumber;
  }

  /**
   * Gets card issuer.
   *
   * @return the card issuer
   */
  public String getCardIssuer() {
    return cardIssuer;
  }

  /**
   * Sets card issuer.
   *
   * @param cardIssuer the card issuer
   */
  public void setCardIssuer(final String cardIssuer) {
    this.cardIssuer = cardIssuer;
  }

  /**
   * Is valid boolean.
   *
   * @return the boolean
   */
  public boolean isValid() {
    return isValid;
  }

  /**
   * Sets valid.
   *
   * @param valid the valid
   */
  public void setValid(final boolean valid) {
    isValid = valid;
  }

  /**
   * Gets error.
   *
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * Sets error.
   *
   * @param error the error
   */
  public void setError(final String error) {
    this.error = error;
  }

  /**
   * Gets card number.
   *
   * @return the card number
   */
  public String getCardNumber() {
    return cardNumber;
  }

  /**
   * Sets card number.
   *
   * @param cardNumber the card number
   */
  public void setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
  }


  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Card Issuer = ").append(cardIssuer).append("\n");
    stringBuilder.append("Card Number = ").append(cardNumber).append("\n");
    stringBuilder.append("Is Valid = ").append(isValid).append("\n");

    if (!isValid) {
      stringBuilder.append("Error Info = ").append(error).append("\n");
    }

    return stringBuilder.toString();
  }
}
