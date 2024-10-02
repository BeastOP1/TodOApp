package com.example.to_doapp.data

sealed class TaskUIEvent {
    data class TaskNameChanged (val taskName :String):TaskUIEvent()
    data class DescriptionChanged (val taskName :String):TaskUIEvent()
    object SubmitButtonClicked:TaskUIEvent()
    object CancelButtonClicked:TaskUIEvent()

}