package com.jefferymoju.databasequizapp.activities

// data class for the questions
data class Questions (
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)