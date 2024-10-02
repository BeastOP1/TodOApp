@file:Suppress("DUPLICATE_LABEL_IN_WHEN", "UNUSED_EXPRESSION")

package com.example.to_doapp.postOffice

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.to_doapp.screens.HomeScreen
import com.example.to_doapp.screens.LoginScreen
import com.example.to_doapp.screens.SignUP_Screen
import com.example.to_doapp.screens.TermsAndConditionScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White

    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->

            when(currentState.value){
                is Screen.SignUPScreen -> {
                    SignUP_Screen()
                }
                is Screen.TermsAndConditionScreen -> {
                    TermsAndConditionScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.HomeScreen -> {
                    HomeScreen()
                }


            }
            
        }
        
    }
}