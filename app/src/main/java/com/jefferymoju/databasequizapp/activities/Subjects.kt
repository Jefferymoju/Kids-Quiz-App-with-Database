package com.jefferymoju.databasequizapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.others.Constants

class Subjects : AppCompatActivity() {

    private var btnCrs: Button? = null
    private var btnEnglish: Button? = null
    private var btnMaths: Button? = null
    private var mUsername: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        btnCrs = findViewById(R.id.btn_crs)
        btnEnglish = findViewById(R.id.btn_english)
        btnMaths = findViewById(R.id.btn_maths)
        mUsername = intent.getStringExtra(Constants.USER_NAME)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

       btnCrs!!.setOnClickListener {
           val intent = Intent(this, CrsQuestionsActivity::class.java)
           intent.putExtra(Constants.SUBJECT, btnCrs!!.text.toString())
           intent.putExtra(Constants.USER_NAME,mUsername)
           startActivity(intent)
       }

        btnEnglish!!.setOnClickListener {
            val intent = Intent(this, EnglishQuestionsActivity::class.java)
            intent.putExtra(Constants.SUBJECT, btnEnglish!!.text.toString())
            intent.putExtra(Constants.USER_NAME,mUsername)

            startActivity(intent)
        }

        btnMaths!!.setOnClickListener {
            val intent = Intent(this, MathsQuestionsActivity::class.java)
            intent.putExtra(Constants.SUBJECT, btnMaths!!.text.toString())
            intent.putExtra(Constants.USER_NAME,mUsername)
            startActivity(intent)
        }


    }

}