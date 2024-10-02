package com.example.to_doapp.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.to_doapp.component.HeadingTextComponent
import com.example.to_doapp.component.MyButton
import com.example.to_doapp.component.MyTextFiled
import com.example.to_doapp.data.TaskModelView
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add_Task( onSubmitClicked :() -> Unit, onCancelClicked : ()-> Unit) {

    AlertDialog(onDismissRequest = { onCancelClicked() },
        properties = DialogProperties(
        dismissOnClickOutside = false,
        usePlatformDefaultWidth = false)
    ) {
        Card(modifier = Modifier.fillMaxWidth()
            .height(400.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Transparent)
        ) {
            Column (modifier = Modifier.fillMaxSize()
                , verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
            {

                HeadingTextComponent(value = " New Task ")
                Spacer(modifier = Modifier.height(40.dp))

                MyTextFiled(imageVector = Icons.Filled.Task, labelValue = "Task Name", onTextSelected ={

                } , errorStatus = true)

                MyTextFiled(imageVector = Icons.Filled.TaskAlt, labelValue = "Task Description", onTextSelected ={ } ,errorStatus = true)
                Spacer(modifier = Modifier.height(20.dp))

                MyButton(value = "Submit", onButtonClicked = {
                    onSubmitClicked()

                })
                Spacer(modifier = Modifier.height(8.dp))
                MyButton(value = "Cancel", onButtonClicked = {
                    onCancelClicked()

                })


            }

        }

    }




}
@Preview(showSystemUi = true)
@Composable
fun Add_TaskPreView(modifier: Modifier = Modifier) {
    Add_Task(onCancelClicked = { }, onSubmitClicked = {})
}

