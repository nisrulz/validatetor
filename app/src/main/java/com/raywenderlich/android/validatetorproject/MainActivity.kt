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
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setUpUiWidgets()
  }

  private fun setUpUiWidgets() {
    btn_validate.setOnClickListener {
      validateEmailField(edt_email)
      validatePasswordField(edt_password)
      validateCreditCardField(edt_creditcard)
    }
  }

  private fun validateCreditCardField(editText: EditText) {
    val str = editText.text.toString()
    // TODO: Validate credit card number field, not implemented
  }

  private fun validatePasswordField(editText: EditText) {
    val str = editText.text.toString()
    // TODO: Validate password field, not implemented
  }

  private fun validateEmailField(editText: EditText) {
    val str = editText.text.toString()
    // TODO: Validate email field, not implemented
  }
}
