package com.jefferymoju.databasequizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.database.QuizApp
import com.jefferymoju.databasequizapp.database.QuizDao
import com.jefferymoju.databasequizapp.database.QuizEntity
import com.jefferymoju.databasequizapp.others.Constants
import kotlinx.coroutines.launch

class ResultActivity : AppCompatActivity() {
    private var btnFinishResult: Button? = null
    private var score: Int? = null
    private var subject: String? = null
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val quizDao = (application as QuizApp).db.quizDao()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btnFinishResult = findViewById(R.id.btnFinishResult)

        val tvName:TextView = findViewById(R.id.tvName)
        val tvScore: TextView = findViewById(R.id.tvScore)
        val tvSubject: TextView = findViewById(R.id.tvSubject)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvSubject.text = intent.getStringExtra(Constants.SUBJECT)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        score = correctAnswers

        tvScore.text = "Your score is $correctAnswers out of $totalQuestions"

        name = tvName.text.toString()
        subject = tvSubject.text.toString()

        btnFinishResult?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            addRecord(quizDao)
        }

    }
    fun addRecord(quizDao: QuizDao){

        val score = score
            lifecycleScope.launch {
                score?.let {
                    subject?.let { it1 ->
                        name?.let { it2 ->
                            QuizEntity(name = it2,
                                subject = it1, score = it
                            )
                        }
                    }
                }?.let { quizDao.insert(it) }
            }


    }
}