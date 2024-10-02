package com.example.to_doapp.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.to_doapp.data.rules.Validator
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignUpViewModel:ViewModel() {


    private val TAG = SignUpViewModel::class.simpleName

    var registrationUIState = mutableStateOf(RegistrationUIState())
    var allValidationPasses =  mutableStateOf(false)
    var signUPINProgress = mutableStateOf(false)
    fun onEvent(event: SignUpUIEvent){

        validateDataWithRules()
            when(event){
                is SignUpUIEvent.FirstNameChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        firstName = event.firstName
                    )
                    printState()
                }

                is SignUpUIEvent.LastNameChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        lastName = event.lastName
                    )
                    printState()
                }
                is SignUpUIEvent.EmailNameChanged -> {
                    registrationUIState.value = registrationUIState.value.copy(
                        email = event.email
                    )
                    printState()

                }

                is SignUpUIEvent.PasswordNameChanged -> {

                    registrationUIState.value = registrationUIState.value.copy(
                        password = event.password
                    )
                    printState()

                }
                is SignUpUIEvent.RegisterButtonCLicked -> {
                    signUp()
                }

                is SignUpUIEvent.PrivacyPolicyCheckBoxClicked ->{

                    registrationUIState.value = registrationUIState.value.copy(
                        privacyPolicyCheckedBox = event.status
                    )
//                    printState()
                }
            }


    }

    private fun signUp(){
        Log.d(TAG,"Inside_SignUp")

        printState()
        createUserInFirebase(
            email = registrationUIState.value.email,
            password =registrationUIState.value.password
        )

    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(
            fName = registrationUIState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = registrationUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = registrationUIState.value.password
        )
        val privacyPolicyResult = Validator.validatePrivacyPolicy(
            statusValue = registrationUIState.value.privacyPolicyCheckedBox
        )
        Log.d(TAG,"Inside_validateDataWithRules")
        Log.d(TAG,"fNameResult = $fNameResult")
        Log.d(TAG,"lName= $lNameResult")
        Log.d(TAG,"emailResult= $emailResult")
        Log.d(TAG,"passwordResult= $passwordResult")
        Log.d(TAG,"PrivacyPolicyResult = $privacyPolicyResult")

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status,

        )
        allValidationPasses.value = (fNameResult.status && lNameResult.status &&
                emailResult.status && passwordResult.status && privacyPolicyResult.status)

    }

    private fun printState(){
        Log.d(TAG,"Inside_printState")
        Log.d(TAG,registrationUIState.value.toString())
    }

    private fun createUserInFirebase(email:String, password:String){

        signUPINProgress.value = true
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                Log.d(TAG,"Inside_OnCompleteListener")

                Log.d(TAG," isSuccessful = ${it.isSuccessful}")
                signUPINProgress.value = false
                if (it.isSuccessful) {
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d(TAG,"Inside_OnFailureListener")
                Log.d(TAG,"Exception = ${it.message}")
                Log.d(TAG,"Exception = ${it.localizedMessage}")
            }
    }
    fun logout(){
        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()
        val authStateListener = AuthStateListener{

            if(it.currentUser == null){
                Log.d(TAG,"inside sign out Success")
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)

            }else{
                Log.d(TAG,"Inside sign out is not complete")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }

}