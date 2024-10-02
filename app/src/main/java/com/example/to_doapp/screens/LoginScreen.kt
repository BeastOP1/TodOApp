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
import com.example.to_doapp.component.MyClickAbleLoginText
import com.example.to_doapp.component.MyPasswordTextFiled
import com.example.to_doapp.component.MyTextFiled
import com.example.to_doapp.component.NormalTextComponent
import com.example.to_doapp.data.LogInUIEvent
import com.example.to_doapp.data.LogInViewModel
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen
import com.example.to_doapp.postOffice.SystemBackButtonHandler
@Composable
fun LoginScreen(logInViewModel: LogInViewModel = viewModel() ){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp),

            ) {

            Column(modifier = Modifier.fillMaxSize()){

                NormalTextComponent(value = "Login In")
                HeadingTextComponent(value = "Welcome Back")
                Spacer(modifier = Modifier.height(20.dp))


                MyTextFiled(imageVector = Icons.Filled.Mail, labelValue ="Enter Email",
                    onTextSelected = {
                        logInViewModel.onEvent(LogInUIEvent.EmailChanged(it)) },
                    errorStatus = logInViewModel.loginUIState.value.emailError)


                MyPasswordTextFiled(imageVector = Icons.Filled.Lock, labelValue = "Enter Password",
                    onTextSelected = {
                        logInViewModel.onEvent(LogInUIEvent.PasswordChanged(it)) },
                    errorStatus = logInViewModel.loginUIState.value.passwordError)



                Spacer(modifier = Modifier.height(40.dp))


                MyButton(value = "Log In",
                    onButtonClicked = {
                        logInViewModel.onEvent(LogInUIEvent.LoginButtonClicked)
                        Log.d("hello", " Login button is pressed") },

                    isEnabled = logInViewModel.allValidationPassed.value )


                Spacer(modifier = Modifier.height(80.dp))

                DividerText(value = "OR")

                Spacer(modifier = Modifier.height(80.dp))
                MyClickAbleLoginText (tryingToLogin = false, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.SignUPScreen)
                })

            }
        }


        if(logInViewModel.loginInProgress.value){
            CircularProgressIndicator(progress = 1f)
        }

    }
    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUPScreen)
    }

}


@Preview(showSystemUi = true)
@Composable
 fun LoginScreenPreview() {
     LoginScreen()


 }