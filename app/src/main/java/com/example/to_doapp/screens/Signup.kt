package com.example.to_doapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.to_doapp.component.DividerText
import com.example.to_doapp.component.HeadingTextComponent
import com.example.to_doapp.component.MyButton
import com.example.to_doapp.component.MyCheckBox
import com.example.to_doapp.component.MyClickAbleLoginText
import com.example.to_doapp.component.MyPasswordTextFiled
import com.example.to_doapp.component.MyTextFiled
import com.example.to_doapp.component.NormalTextComponent
import com.example.to_doapp.data.SignUpViewModel
import com.example.to_doapp.data.SignUpUIEvent
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen

@Composable
fun SignUP_Screen(signUpViewModel: SignUpViewModel = viewModel()) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {


            Column(modifier = Modifier.fillMaxSize()) {


                NormalTextComponent(value = "Hey there,")
                HeadingTextComponent(value = "Create an Account")
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFiled(
                    imageVector = Icons.Filled.Person,
                    labelValue = "First Name",
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.firstNameError
                )

                MyTextFiled(
                    imageVector = Icons.Filled.Person2,
                    labelValue = "Last Name",
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.lastNameError
                )


                MyTextFiled(
                    imageVector = Icons.Filled.Mail,
                    labelValue = "Email",
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.EmailNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.emailError
                )


                MyPasswordTextFiled(
                    imageVector = Icons.Filled.Lock,
                    labelValue = "Password",
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUIEvent.PasswordNameChanged(it))
                    },
                    errorStatus = signUpViewModel.registrationUIState.value.passwordError
                )


                MyCheckBox(
                    value = "By continuing you accept our Privacy Policy and Term of Use",
                    onTextSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionScreen)
                    },
                    onCheckedChanged = {
                        signUpViewModel.onEvent(SignUpUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    })


                Spacer(modifier = Modifier.height(80.dp))

                MyButton(value = "Register", onButtonClicked = {
                    signUpViewModel.onEvent(SignUpUIEvent.RegisterButtonCLicked)
                    Log.d("hello", " Sign Up button is pressed")
                }, isEnabled = signUpViewModel.allValidationPasses.value)

                DividerText(value = "OR")
                Spacer(modifier = Modifier.height(80.dp))

                MyClickAbleLoginText(tryingToLogin = true, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if (signUpViewModel.signUPINProgress.value) {

            CircularProgressIndicator(progress = 1f, modifier = Modifier, color = Color.Magenta)


        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun SignUpScreen_PreView() {


    SignUP_Screen()
}