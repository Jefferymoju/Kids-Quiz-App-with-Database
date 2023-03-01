package com.jefferymoju.databasequizapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// Inside the Dao we define the functions for querying the database
@Dao
interface QuizDao {

    // to store something in the database we use the insert keyword
    @Insert
    // and then use the suspend fun from the coroutine class as these tasks takes some amount of time
    // it has to be done on a background thread which is achievable by using coroutines
    suspend fun insert(quizEntity: QuizEntity)

    // select all entries from the table
    @Query("SELECT * FROM `quiz-table`")
    fun fetchAllQuiz():Flow<List<QuizEntity>>

}