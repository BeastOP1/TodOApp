package com.example.to_doapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DashboardCustomize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.to_doapp.component.AppToolBar
import com.example.to_doapp.component.MyFab
import com.example.to_doapp.component.TaskComponent
import com.example.to_doapp.data.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel= viewModel()) {



    var isShow by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            AppToolBar(toolbarTitle = "Task App") {
                signUpViewModel.logout()

            }

        },
        floatingActionButton = {
            MyFab(
                    onFabClicked = {
                        isShow = true
                        if(isShow){
                            Add_Task(onSubmitClicked = { isShow = false },) {
                                isShow = false
                            }
                        }
                        else{
                            isShow = false
                        }
            })
        }
        
    ) { PaddingValues ->

        Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(PaddingValues),
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item {

                Spacer(modifier = Modifier.height(10.dp))
                Row( horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Top, modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(40.dp)) {

                    Icon(imageVector = Icons.Filled.CalendarToday, contentDescription ="calender" )
                    Icon(imageVector = Icons.Filled.AddTask, contentDescription ="calender" )
                    Icon(imageVector = Icons.Filled.Close, contentDescription ="calender" )
                    Icon(imageVector = Icons.Filled.DashboardCustomize, contentDescription ="calender" )
                }
            }
            items(
                1
            ){

                TaskComponent()


            }



        }
    }
    }

}
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreView() {


    HomeScreen()
}