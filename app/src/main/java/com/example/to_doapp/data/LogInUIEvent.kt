package com.example.to_doapp.data

 sealed class LogInUIEvent {


     data class EmailChanged(val email:String):LogInUIEvent()
     data class PasswordChanged(val password:String):LogInUIEvent()

     object LoginButtonClicked:LogInUIEvent()
 }