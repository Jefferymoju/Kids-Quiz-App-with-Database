package com.jefferymoju.databasequizapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.others.Constants
import com.jefferymoju.databasequizapp.others.English
import com.jefferymoju.databasequizapp.others.Maths

class MathsQuestionsActivity : AppCompatActivity(){

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Questions>? = null
    private var mSelectedOptionsPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswer: Int = 0
    private var mSubject: String? = null

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestions: TextView? = null

    private var optionMathsOne: TextView? = null
    private var optionMathsTwo: TextView? = null
    private var optionMathsThree: TextView? = null
    private var optionMathsFour: TextView? = null
    private var btnMathsSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mSubject = intent.getStringExtra(Constants.SUBJECT)

        progressBar = findViewById(R.id.progressBarMaths)
        tvProgress = findViewById(R.id.tv_progress_maths)
        tvQuestions = findViewById(R.id.tv_english_maths)

        optionMathsOne = findViewById(R.id.tv_option_one_maths)
        optionMathsTwo = findViewById(R.id.tv_option_two_maths)
        optionMathsThree = findViewById(R.id.tv_option_three_maths)
        optionMathsFour = findViewById(R.id.tv_option_four_maths)
        btnMathsSubmit = findViewById(R.id.btn_submit_maths)

        optionMathsOne?.setOnClickListener { optionMathsOne?.let {
            // and set the selected option number id to 1
            selectedOptionView(it, 1)
        }}
        optionMathsTwo?.setOnClickListener { optionMathsTwo?.let {
            selectedOptionView(it, 2)
        }}
        optionMathsThree?.setOnClickListener {     optionMathsThree?.let {
            selectedOptionView(it, 3)
        }}
        optionMathsFour?.setOnClickListener {  optionMathsFour?.let {
            selectedOptionView(it, 4)
        }}
        btnMathsSubmit?.setOnClickListener { btnMathsSubmitOnClick() }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        mQuestionsList = Maths.getQuestions()

        defaultOptionView()
        setQuestion()
    }

    private fun setQuestion(){
        //set the default view for each question set
        defaultOptionView()
        // set the current position to minus 1 because we first set it to 1
        val questions: Questions = mQuestionsList!![mCurrentPosition - 1]
        //set the progressbar to the current position
        progressBar?.progress = mCurrentPosition
        // set the textview for the progressbar
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        //set the question
        tvQuestions?.text = questions.question
        //setting the options
        optionMathsOne?.text = questions.optionOne
        optionMathsTwo?.text = questions.optionTwo
        optionMathsThree?.text = questions.optionThree
        optionMathsFour?.text = questions.optionFour

        // if the current position is the total list of questions size set button submit to finsih
        if(mCurrentPosition == mQuestionsList!!.size){
            btnMathsSubmit?.text = resources.getString(R.string.finish)
            // else set the text to submit
        }else{
            btnMathsSubmit?.text = resources.getString(R.string.submit)
        }

    }

    // function for the default option
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        optionMathsOne?.let {
            options.add(0, it)
        }
        optionMathsTwo?.let {
            options.add(1, it)
        }
        optionMathsThree?.let {
            options.add(2, it)
        }
        optionMathsFour?.let {
            options.add(3, it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#3F51B5"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    // function to set selected option view
    fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()

        mSelectedOptionsPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#4CAF50"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    // override fun for onclick event
    private fun btnMathsSubmitOnClick() {


            // when it is the btn submit

                //check the selected option position
                if(mSelectedOptionsPosition == 0){
                    // increase the current position by 1
                    mCurrentPosition ++

                    when {
                        // when the current position of question is not the current question list size
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            //set the next question
                            setQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                            intent.putExtra(Constants.SUBJECT, mSubject)
                            startActivity(intent)
                        }

                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    //  if the question correct answer is not the selected option position
                    if (question!!.correctAnswer != mSelectedOptionsPosition){
                        // set the answer view to the wrong option border drawable
                        answerView(mSelectedOptionsPosition, R.drawable.wong_option_border_bg)
                    }else{
                        // else increase the correct answer by 1
                        mCorrectAnswer ++
                    }
                    // if it is the correct one then set the drawable to the correct option border
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    // if the current position is the question list size
                    if (mCurrentPosition == mQuestionsList!!.size){
                        // change the text to finish
                        btnMathsSubmit?.text = resources.getString(R.string.finish)
                    }else{
                        // else set the text to next question
                        btnMathsSubmit?.text = resources.getString(R.string.next_question)
                    }

                    // set the selected option position to 0 for each new questions
                    mSelectedOptionsPosition = 0
                }

    }

    // function for answer view
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionMathsOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionMathsTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionMathsThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
               optionMathsFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}