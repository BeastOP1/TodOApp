package com.example.to_doapp

import android.app.Application
import com.google.firebase.FirebaseApp

class ToDoApp : Application() {



    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}