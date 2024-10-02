package com.example.to_doapp.data


data class RegistrationUIState(
    var firstName:String = "",
    var lastName:String = "",
    var email:String = "",
    var password:String = "",
    var privacyPolicyCheckedBox: Boolean = false,


    var  firstNameError: Boolean = false,
    var  lastNameError: Boolean = false,
    var  emailError: Boolean = false,
    var  passwordError: Boolean = false,
    var privacyPolicyError : Boolean = false,
)
