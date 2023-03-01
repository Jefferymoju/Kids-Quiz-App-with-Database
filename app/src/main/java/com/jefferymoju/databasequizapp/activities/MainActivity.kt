package com.jefferymoju.databasequizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.others.Constants

class MainActivity : AppCompatActivity() {

    private var btnStart: Button? = null
    private var etName: AppCompatEditText? = null
    private var tvScoreDataBase: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //get the view by the id
        btnStart = findViewById(R.id.btn_start)
        etName = findViewById(R.id.et_name)
        tvScoreDataBase = findViewById(R.id.tvScoresDataBase)


        // set onclick listener for the button start
        btnStart!!.setOnClickListener {
            // calling the start function when the onclick is called
            start()
        }

        tvScoreDataBase!!.setOnClickListener{
            startActivity(Intent(this,ScoresActivity::class.java))
        }
    }

    //function to start the activity
    private fun start(){
        // check if the text input is empty
        if (etName?.text?.isEmpty() == true){
            // if it is empty run the toast code
            Toast.makeText(
                this,
                "Please enter your name",
                Toast.LENGTH_LONG
            ).show()
            //else move to the next activity
        }else{
            val intent = Intent(this, Subjects::class.java)
            // put the name entered in the text input into constants.user_name
            intent.putExtra(Constants.USER_NAME, etName?.text.toString())
            //start the activity with the intent
            startActivity(intent)
            finish()
        }
    }
}