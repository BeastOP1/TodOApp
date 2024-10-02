package com.example.to_doapp.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.to_doapp.data.rules.Validator
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen
import com.google.firebase.auth.FirebaseAuth

class LogInViewModel:ViewModel() {

    private val TAG = LogInViewModel::class.simpleName

    var loginUIState = mutableStateOf(LogInUIState())
    var allValidationPassed = mutableStateOf(false)
    var loginInProgress = mutableStateOf(false)

    fun onEvent(event:LogInUIEvent){

        when(event){
            is LogInUIEvent.EmailChanged ->{

                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
            is LogInUIEvent.PasswordChanged ->{

                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }
            is LogInUIEvent.LoginButtonClicked ->{

                logIn()
            }
        }
        validateLoginUIDataWithRules()
    }


    private fun validateLoginUIDataWithRules(){
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )
        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
                    )

        allValidationPassed.value =emailResult.status && passwordResult.status
    }

    private fun logIn() {
        val email = loginUIState.value.email
        val password = loginUIState.value.password

        loginInProgress.value = true
        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                Log.d(TAG,"inside login success")
                Log.d(TAG,"${it.isSuccessful}")

                loginInProgress.value = false
                if(it.isSuccessful){
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }

            }
            .addOnFailureListener{

                loginInProgress.value = false

                Log.d(TAG,"inside login failure")
                Log.d(TAG,"${it.message}")
            }


    }

}