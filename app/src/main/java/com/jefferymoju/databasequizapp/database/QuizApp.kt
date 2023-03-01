package com.jefferymoju.databasequizapp.database

import android.app.Application

class QuizApp:Application() {
    val db by lazy{
        QuizDatabase.getInstance(this)
    }
}