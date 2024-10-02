package com.example.to_doapp.data.rules

object Validator {

    fun validateFirstName(fName:String):ValidationResult{
    return ValidationResult(
        (!fName.isNullOrEmpty() && fName.length>=5)
    )
    }


    fun validateLastName(lName:String):ValidationResult{

        return  ValidationResult(
            (!lName.isNullOrEmpty() && lName.length>4)
        )
    }

    fun validateEmail(email:String):ValidationResult{
        return ValidationResult(
        (!email.isNullOrEmpty() && email.length>6))
    }

    fun validatePassword(password:String):ValidationResult{
        return  ValidationResult(
            (!password.isNullOrEmpty() && password.length>=5)
        )
    }
    fun validatePrivacyPolicy(statusValue: Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }

}
data class ValidationResult (
    val status: Boolean = false
)