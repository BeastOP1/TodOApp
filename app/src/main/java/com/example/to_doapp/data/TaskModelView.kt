package com.example.to_doapp.data

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.to_doapp.postOffice.PostOfficeAppRouter
import com.example.to_doapp.postOffice.Screen

class TaskModelView :ViewModel() {
    private val TAG = TaskModelView::class.simpleName

    fun onEvent(event:TaskUIEvent){
        when(event){
            is TaskUIEvent.TaskNameChanged ->{


            }
            is TaskUIEvent.DescriptionChanged -> {

            }
            is TaskUIEvent.SubmitButtonClicked ->{

            }
            is TaskUIEvent.CancelButtonClicked ->{

                navigate()


            }



        }

    }
     fun navigate(){
        PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
        Log.d( TAG,"Navigate Successfully")

    }


}