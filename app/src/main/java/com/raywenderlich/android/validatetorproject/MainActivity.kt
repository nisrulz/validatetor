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

package com.raywenderlich.android.validatetorproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.validatetor.ValidateTor

class MainActivity : AppCompatActivity() {

  private lateinit var validateTor: ValidateTor
  private lateinit var btn_validate: Button
  private lateinit var edt_email: EditText
  private lateinit var edt_creditcard: EditText
  private lateinit var edt_password: EditText
  private lateinit var edt_json: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setUpUiWidgets()

    validateTor = ValidateTor()
  }

  private fun setUpUiWidgets() {
    btn_validate = findViewById(R.id.btn_validate)
    edt_email = findViewById(R.id.edt_email)
    edt_creditcard = findViewById(R.id.edt_creditcard)
    edt_password = findViewById(R.id.edt_password)
    edt_json = findViewById(R.id.edt_json)

    btn_validate.setOnClickListener {
      validateEmailField(edt_email)
      validatePasswordField(edt_password)
      validateCreditCardField(edt_creditcard)
      validateJsonField(edt_json)
    }
  }

  private fun validateCreditCardField(editText: EditText) {
    val str = editText.text.toString()

    if (validateTor.isEmpty(str)) {
      editText.error = "Field is empty!"
    }

    if (!validateTor.validateCreditCard(str)) {
      editText.error = "Invalid Credit Card number!"
    } else {
      showToast("Valid Credit Card Number!")
    }
  }

  private fun validatePasswordField(editText: EditText) {
    val str = editText.text.toString()

    validateTor.apply{
      if (isEmpty(str)) {
        editText.error = "Field is empty!"
      }

      if (isAtleastLength(str, 8)
              && hasAtleastOneDigit(str)
              && hasAtleastOneUppercaseCharacter(str)
              && hasAtleastOneSpecialCharacter(str)) {
         showToast("Valid Password!")
      } else {
        editText.error = "Password needs to be of minimum length of 8 characters and should " +
                "have " + "atleast 1 digit, 1 upppercase letter and 1 special character "
      }
     }


  }

  private fun validateEmailField(editText: EditText) {
    val str = editText.text.toString()

    if (validateTor.isEmpty(str)) {
      editText.error = "Field is empty!"
    }

    if (!validateTor.isEmail(str)) {
      editText.error = "Invalid Email entered!"
    } else {
      showToast("Valid Email!")
    }
  }

  private fun validateJsonField(editText: EditText) {
    val str = editText.text.toString()

    if (validateTor.isEmpty(str)) {
      editText.error = "Field is empty!"
    }

    if (!validateTor.isJSON(str)) {
      editText.error = "Invalid Json entered!"
    } else {
      showToast("Valid Json!")
    }
  }

  private fun showToast(txt:String){
    Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
  }
}
