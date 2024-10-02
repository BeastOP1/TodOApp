package com.example.to_doapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.to_doapp.component.HeadingTextComponent
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen
import com.example.to_doapp.postOffice.SystemBackButtonHandler

@Composable
fun TermsAndConditionScreen(modifier: Modifier = Modifier) {


    Surface( modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)
    ) {

        HeadingTextComponent(value = "Term Of Use")
        SystemBackButtonHandler {
            PostOfficeAppRouter.navigateTo(Screen.SignUPScreen)
        }
    }
}