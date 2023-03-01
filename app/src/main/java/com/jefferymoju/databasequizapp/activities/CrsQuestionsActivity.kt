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
import com.jefferymoju.databasequizapp.others.Crs
// set View.Onclicklistener to get the override onclick function
class CrsQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    // var for the current question position
    private var mCurrentPosition : Int = 1
    // var to get the questions
    private var mQuestionsList: ArrayList<Questions>? = null
    //var to know the current selected options
    private var mSelectedOptionsPosition: Int = 0
    // var to get the username
    private var mUserName : String? = null
    // var to store the number of correct answers
    private var mCorrectAnswer : Int = 0

    private var mSubject : String? = null

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestions: TextView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crs_questions)

        // get the username we passed to the constant with the intent in our main_activity
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mSubject = intent.getStringExtra(Constants.SUBJECT)

        //getting our var with the id
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestions = findViewById(R.id.tv_question)

        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        // set onclick for each onclick view
        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //get the questions from the crs constants
        mQuestionsList = Crs.getQuestions()

        defaultOptionView()
        setQuestion()
    }

    // function to set question
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
        optionOne?.text = questions.optionOne
        optionTwo?.text = questions.optionTwo
        optionThree?.text = questions.optionThree
        optionFour?.text = questions.optionFour

        // if the current position is the total list of questions size set button submit to finsih
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = resources.getString(R.string.finish)
            // else set the text to submit
        }else{
            btnSubmit?.text = resources.getString(R.string.submit)
        }

    }

    // function for the default option
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0, it)
        }
        optionTwo?.let {
            options.add(1, it)
        }
        optionThree?.let {
            options.add(2, it)
        }
        optionFour?.let {
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
    override fun onClick(view: View?) {
       when(view?.id){
           // when optionOne is clicked
           R.id.tv_option_one ->{
               //let option One have the selected option view
               optionOne?.let {
                   // and set the selected option number id to 1
                   selectedOptionView(it, 1)
               }
           }
           R.id.tv_option_two ->{
               optionTwo?.let {
                   selectedOptionView(it, 2)
               }
           }
           R.id.tv_option_three ->{
               optionThree?.let {
                   selectedOptionView(it, 3)
               }
           }
           R.id.tv_option_four ->{
               optionFour?.let {
                   selectedOptionView(it, 4)
               }
           }

           // when it is the btn submit
           R.id.btn_submit ->{
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
                       btnSubmit?.text = resources.getString(R.string.finish)
                   }else{
                       // else set the text to next question
                       btnSubmit?.text = resources.getString(R.string.next_question)
                   }

                   // set the selected option position to 0 for each new questions
                   mSelectedOptionsPosition = 0
               }
           }
       }
    }

    // function for answer view
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}