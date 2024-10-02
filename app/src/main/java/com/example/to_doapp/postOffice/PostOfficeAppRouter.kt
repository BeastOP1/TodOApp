package com.example.to_doapp.postOffice

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{

    object SignUPScreen : Screen()
    object TermsAndConditionScreen : Screen()
    object LoginScreen : Screen()
    object HomeScreen : Screen()

}

object PostOfficeAppRouter {

    var currentScreen :MutableState<Screen> = mutableStateOf(Screen.SignUPScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }
}