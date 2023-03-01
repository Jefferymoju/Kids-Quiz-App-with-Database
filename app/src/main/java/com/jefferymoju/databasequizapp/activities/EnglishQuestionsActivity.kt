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

class EnglishQuestionsActivity : AppCompatActivity() {

    private var mCurrentPositionEnglish: Int = 1
    private var mQuestionsListEnglish:ArrayList<Questions>? = null
    private var mSelectedOptionsPositionEnglish: Int = 0
    private var mUserNameEnglish: String? = null
    private var mCorrectAnswerEnglish: Int = 0
    private var mSubject: String? = null

    private var progressEnglishBar:ProgressBar? = null
    private var tvEnglishProgress: TextView? = null
    private var tvQuestionsEnglish: TextView? = null

    private var optionEnglishOne: TextView? = null
    private var optionEnglishTwo: TextView? = null
    private var optionEnglishThree: TextView? = null
    private var optionEnglishFour: TextView? = null
    private var btnEnglishSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_questions)

        mUserNameEnglish = intent.getStringExtra(Constants.USER_NAME)
        mSubject = intent.getStringExtra(Constants.SUBJECT)

        progressEnglishBar = findViewById(R.id.progressBarEnglish)
        tvEnglishProgress = findViewById(R.id.tv_progress_english)
        tvQuestionsEnglish = findViewById(R.id.tv_english_question)

        optionEnglishOne = findViewById(R.id.tv_option_one_english)
        optionEnglishTwo = findViewById(R.id.tv_option_two_english)
        optionEnglishThree = findViewById(R.id.tv_option_three_english)
        optionEnglishFour = findViewById(R.id.tv_option_four_english)
        btnEnglishSubmit = findViewById(R.id.btn_submit_english)

        optionEnglishOne?.setOnClickListener {   optionEnglishOne?.let {
            // and set the selected option number id to 1
            selectedOptionViewEnglish(it, 1)
        }}
        optionEnglishTwo?.setOnClickListener {  optionEnglishTwo?.let {
            selectedOptionViewEnglish(it, 2)
        }}
        optionEnglishThree?.setOnClickListener { optionEnglishThree?.let {
            selectedOptionViewEnglish(it, 3)
        }}
        optionEnglishFour?.setOnClickListener { optionEnglishFour?.let {
            selectedOptionViewEnglish(it, 4)
        }}
        btnEnglishSubmit?.setOnClickListener {englishBtnSubmitOnClick()}

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        mQuestionsListEnglish = English.getEnglishQuestions()

        defaultOptionView()
        setEnglishQuestion()
    }

    private fun setEnglishQuestion(){
        //set the default view for each question set
        defaultOptionView()
        // set the current position to minus 1 because we first set it to 1
        val questions: Questions = mQuestionsListEnglish!![mCurrentPositionEnglish - 1]
        //set the progressbar to the current position
        progressEnglishBar?.progress = mCurrentPositionEnglish
        // set the textview for the progressbar
        tvEnglishProgress?.text = "$mCurrentPositionEnglish/${progressEnglishBar?.max}"
        //set the question
        tvQuestionsEnglish?.text = questions.question
        //setting the options
        optionEnglishOne?.text = questions.optionOne
        optionEnglishTwo?.text = questions.optionTwo
        optionEnglishThree?.text = questions.optionThree
        optionEnglishFour?.text = questions.optionFour

        // if the current position is the total list of questions size set button submit to finsih
        if(mCurrentPositionEnglish == mQuestionsListEnglish!!.size){
            btnEnglishSubmit?.text = resources.getString(R.string.finish)
            // else set the text to submit
        }else{
           btnEnglishSubmit?.text = resources.getString(R.string.submit)
        }

    }

    // function for the default option
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        optionEnglishOne?.let {
            options.add(0, it)
        }
        optionEnglishTwo?.let {
            options.add(1, it)
        }
        optionEnglishThree?.let {
            options.add(2, it)
        }
        optionEnglishFour?.let {
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
    fun selectedOptionViewEnglish(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()

        mSelectedOptionsPositionEnglish = selectedOptionNum
        tv.setTextColor(Color.parseColor("#4CAF50"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    // override fun for onclick event
    private fun englishBtnSubmitOnClick() {
                //check the selected option position
                if(mSelectedOptionsPositionEnglish == 0){
                    // increase the current position by 1
                    mCurrentPositionEnglish ++

                    when {
                        // when the current position of question is not the current question list size
                        mCurrentPositionEnglish <= mQuestionsListEnglish!!.size ->{
                            //set the next question
                            setEnglishQuestion()
                        }
                        else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserNameEnglish)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsListEnglish?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswerEnglish)
                            intent.putExtra(Constants.SUBJECT, mSubject)
                            startActivity(intent)
                        }

                    }
                }else{
                    val question = mQuestionsListEnglish?.get(mCurrentPositionEnglish - 1)

                    //  if the question correct answer is not the selected option position
                    if (question!!.correctAnswer != mSelectedOptionsPositionEnglish){
                        // set the answer view to the wrong option border drawable
                        answerView(mSelectedOptionsPositionEnglish, R.drawable.wong_option_border_bg)
                    }else{
                        // else increase the correct answer by 1
                        mCorrectAnswerEnglish ++
                    }
                    // if it is the correct one then set the drawable to the correct option border
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    // if the current position is the question list size
                    if (mCurrentPositionEnglish == mQuestionsListEnglish!!.size){
                        // change the text to finish
                        btnEnglishSubmit?.text = resources.getString(R.string.finish)
                    }else{
                        // else set the text to next question
                        btnEnglishSubmit?.text = resources.getString(R.string.next_question)
                    }

                    // set the selected option position to 0 for each new questions
                    mSelectedOptionsPositionEnglish = 0
                }
    }

    // function for answer view
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionEnglishOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionEnglishTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionEnglishThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionEnglishFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}
