<div align="center">
    <img src="img/github_banner.png"/>
</div>

<h1 align="center"><a href="https://twitter.com/intent/tweet?text=Checkout%20ValidateTor%3A%20Android%20library%20for%20fast%20and%20simple%20string%20validation%F0%9F%98%8E%26via%3Dnisrulz%26hashtags%3DAndroidDev%2Candroid%2Clibrary%2COpenSource">
        <img src="https://img.shields.io/twitter/url/http/shields.io.svg?style=social"/>
    </a></h1>

<div align="center">
  <strong>Android library for fast and simple string validation.</strong>
</div>
<br/>
<div align="center">
    <!-- Bintray -->
    <a href="https://bintray.com/nisrulz/maven/validatetor/_latestVersion">
        <img src="https://api.bintray.com/packages/nisrulz/maven/validatetor/images/download.svg"/>
    </a>
    <!-- API -->
    <a href="https://android-arsenal.com/api?level=14">
        <img src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat"/>
    </a>
    <!-- GitHub stars -->
    <a href="https://github.com/nisrulz/validatetor">
        <img src="https://img.shields.io/github/stars/nisrulz/validatetor.svg?style=social&label=Star"/>
    </a>
    <!-- GitHub forks -->
    <a href="https://github.com/nisrulz/validatetor/fork">
        <img src="https://img.shields.io/github/forks/nisrulz/validatetor.svg?style=social&label=Fork"/>
    </a>
    <!-- GitHub watchers -->
    <a href="https://github.com/nisrulz/validatetor">
        <img src="https://img.shields.io/github/watchers/nisrulz/validatetor.svg?style=social&label=Watch"/>
    </a>
    <!-- Say Thanks! -->
    <a href="https://saythanks.io/to/nisrulz">
        <img src="https://img.shields.io/badge/Say%20Thanks-!-1EAEDB.svg"/>
    </a>
    <a href="https://www.paypal.me/nisrulz/5usd">
        <img src="https://img.shields.io/badge/$-donate-ff69b4.svg?maxAge=2592000&amp;style=flat">
    </a>
    <br/>
     <!-- GitHub followers -->
    <a href="https://github.com/nisrulz/validatetor">
        <img src="https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow%20@nisrulz"/>
    </a>
    <!-- Twitter Follow -->
    <a href="https://twitter.com/nisrulz">
        <img src="https://img.shields.io/twitter/follow/nisrulz.svg?style=social"/>
    </a>
</div>

<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://twitter.com/nisrulz">Nishant Srivastava</a> and
  <a href="https://github.com/nisrulz/validatetor/graphs/contributors">
    contributors
  </a>
</div>
<br/>
<br/>

# Including in your project
ValidateTor is available in Jcenter, so getting it as simple as adding it as a dependency
```gradle
implementation 'com.github.nisrulz:validatetor:{latest version}'
```
where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/validatetor/images/download.svg) ](https://bintray.com/nisrulz/maven/validatetor/_latestVersion)

# Usage

1. Init ValidateTor

    > **_Java_**
    ```java
    ValidateTor validateTor = new ValidateTor();
    ```
    > **_Kotlin_**
    ```kotlin
    var validateTor = ValidateTor();
    ```
1. Validate string against the type of validation method from ValidateTor

    ```java
    // i.e To validate a password string
    EditText edt_password = findViewById(R.id.edt_password);
    String str = edt_password.getText().toString();

    // Check if password field is empty
    if (validateTor.isEmpty(str)) {
      edt_password.setError("Field is empty!");
    }

    // Check password string to be of minimum length of 8 characters and should have
    // atleast 1 digit, 1 upppercase letter and 1 special character
    if (validateTor.isAtleastLength(str, 8)
        && validateTor.hasAtleastOneDigit(str)
        && validateTor.hasAtleastOneUppercaseCharacter(str)
        && validateTor.hasAtleastOneSpecialCharacter(str)) {

        // Valid Password

    } else {
       // Invalid Password, handle in ui
        edt_password.setError("Password needs to be of minimum length of 8 characters and should have " +
          "atleast 1 digit, 1 upppercase letter and 1 special character ");
    }
    ```

    ... other possible validations are as below:

    |Method Name                                    |Description                                                                              |Return Type
    |-----------------------------------------------|-----------------------------------------------------------------------------------------|-------------
    |`containsSubstring(String str, String seed)`   |Check if the string contains the seed                                                    | boolean
    |`isAlpha(String str)`                          |Check if the string contains only letters                                                | boolean
    |`isAlphanumeric(String str)`                   |Check if the string contains only letters and numbers                                    | boolean
    |`isBoolean(String str)`                        |Check if a string is a boolean                                                           | boolean
    |`isIPAddress(String str)`                      |Check if the string is a ip address                                                      | boolean
    |`isEmail(String str)`                          |Check if the string is a email address                                                   | boolean
    |`isPhoneNumber(String str)`                    |Check if the string is a US phone number                                                 | boolean
    |`isEmpty(String str)`                          |Check if the string has a length of zero                                                 | boolean
    |`isBase64(String str)`                         |Check if a string is base64 encoded                                                      | boolean
    |`isDecimal(String str)`                        |Check if the string represents a decimal number, such as 0.1, .3, 1.1, 1.00003, 4.0, etc | boolean
    |`isAtleastLength(String str, int len)`         |Check if the string is of atleast the specified length                                   | boolean
    |`isAtMostLength(String str, int len)`          |Check if the string is of atmost the specified length                                    | boolean
    |`isLowercase(String str)`                      |Check if the string is all lowercase                                                     | boolean
    |`isUppercase(String str)`                      |Check if the string is all uppercase                                                     | boolean
    |`isValidMD5(String str)`                       |Check if the string is a valid MD5 hash                                                  | boolean
    |`isNumeric(String str)`                        |Check if the string contains only numbers                                                | boolean
    |`isMACAddress(String str)`                     |Check if the string is a MAC address                                                     | boolean
    |`isJSON(String str)`                           |Check if the string is valid JSON                                                        | boolean
    |`isInteger(String str)`                        |Check if the string is an integer                                                        | boolean
    |`isIn(String str, String[] values)`            |Check if the string is present in an array of allowed values                             | boolean
    |`isHexadecimal(String str)`                    |Check if the string is a hexadecimal number                                              | boolean
    |`isPinCode(String str)`                        |Check if the string is a pincode                                                         | boolean
    |`isHexColor(String str)`                       |Check if the string is a hexadecimal color                                               | boolean
    |`hasAtleastOneDigit(String str)`               |Check if the string has atleast one digit                                                | boolean
    |`hasAtleastOneLetter(String str)`              |Check if the string has atleast one letter                                               | boolean
    |`hasAtleastOneLowercaseCharacter(String str)`  |Check if the string has atleast one lowercase character                                  | boolean
    |`hasAtleastOneUppercaseCharacter(String str)`  |Check if the string has atleast one uppercase character                                  | boolean
    |`hasAtleastOneSpecialCharacter(String str)`    |Check if the string has atleast one special character                                    | boolean
    |`validateCreditCard(String str)`               |Check if the string is a valid credit card number                                        | boolean
    |`getCreditCardInfo(String str)`                |Get CreditCard information from string                                                   | CardInformation


# Extending ValidateTor

If you wish to extend ValidateTor, use the `RegexMatcher` class. Create your own regex matchers by passing in a valid regex string to `validate()` or `find()`

|Method Name                                 |Description                               |Return Type
|--------------------------------------------|------------------------------------------|-------------
|`validate(String dataStr, String regex)`    |Validate string against a regex           | boolean
|`validate(String dataStr, Pattern pattern)` |Validate string against a pattern         | boolean
|`find(String dataStr, String regex)`        |Find in string against a regex            | boolean
|`find(String dataStr, Pattern pattern)`     |Find in string against a pattern          | boolean



## License
Licensed under the Apache License, Version 2.0, [click here for the full license](/LICENSE.txt).

## Author & support
This project was created by [Nishant Srivastava](https://github.com/nisrulz/nisrulz.github.io#nishant-srivastava) but hopefully developed and maintained by many others. See the [the list of contributors here](https://github.com/nisrulz/validatetor/graphs/contributors).

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal:
>  + [PayPal](https://www.paypal.me/nisrulz/5usd)

>
> I love using my work and I'm available for contract work. Freelancing helps to maintain and keep [my open source projects](https://github.com/nisrulz/) up to date!

<img src="http://forthebadge.com/images/badges/built-for-android.svg" />