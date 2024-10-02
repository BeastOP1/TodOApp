package com.example.to_doapp.data

sealed class SignUpUIEvent {

    data class FirstNameChanged(val firstName:String):SignUpUIEvent()
    data class LastNameChanged(val lastName:String):SignUpUIEvent()
    data class EmailNameChanged(val email:String):SignUpUIEvent()
    data class PasswordNameChanged(val password:String):SignUpUIEvent()
    data class PrivacyPolicyCheckBoxClicked(val status:Boolean): SignUpUIEvent()

    object RegisterButtonCLicked :SignUpUIEvent()
}
