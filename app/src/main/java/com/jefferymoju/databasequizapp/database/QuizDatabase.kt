package com.jefferymoju.databasequizapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [QuizEntity::class], version = 1)
abstract class QuizDatabase:RoomDatabase() {

    // connect the database to our Dao
    abstract fun quizDao():QuizDao

    companion object{

        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getInstance(context: Context):QuizDatabase{
            synchronized(this){
                //create a local variable so kotlin can smartcast
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        QuizDatabase::class.java,
                        "quiz-database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}