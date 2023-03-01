package com.jefferymoju.databasequizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.database.QuizApp
import com.jefferymoju.databasequizapp.database.QuizDao
import com.jefferymoju.databasequizapp.database.QuizEntity
import com.jefferymoju.databasequizapp.databinding.ActivityScoresBinding
import com.jefferymoju.databasequizapp.others.ItemAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScoresActivity : AppCompatActivity() {

    private var binding: ActivityScoresBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoresBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        setActionBar()

        // call the fetchData by first assigning the quizapp to the quizdao and thn
        val quizDao = (application as QuizApp).db.quizDao()
        // use it to call the fetchdata function
        fetchData(quizDao)
    }

    // fun to fetch the data that was set
    fun fetchData(quizDao: QuizDao){
        // since it has to run in the background we use the lifecycle
        lifecycleScope.launch {
            // launch the lifecycllescope using the quizDao and call the fetchAllQuiz from the quizEntity
            quizDao.fetchAllQuiz().collect{
                // then collect an arrayList tp setUp the data with it and the quiz Dao
                val list = ArrayList(it)
                setUpListOfData(list, quizDao)
            }
        }
    }

    // function to set up the data list from the database
    private fun setUpListOfData(quizList:ArrayList<QuizEntity>,
    quizDao: QuizDao){
        // if quiz list is not empty
        if (quizList.isNotEmpty()){
            //set the itemadapter to itemadapter(quizlist)
            val itemAdapter = ItemAdapter(quizList)
            // set the layout of the recyclerview to a linearlayout
            binding?.rvScoresList?.layoutManager = LinearLayoutManager(this)
            // then assign the itemAdapter to the recyclerView
            binding?.rvScoresList?.adapter = itemAdapter
            // Make the recycler view visible
            binding?.rvScoresList?.visibility = View.VISIBLE
            // and set the no scores available to gone
            binding?.tvNoScoresAvailable?.visibility = View.GONE
        }else{
            // else it should be the opposite
            binding?.rvScoresList?.visibility = View.GONE
            binding?.tvNoScoresAvailable?.visibility = View.VISIBLE
        }
    }

    // function to set the action bar
    private fun setActionBar(){
        //get the toolbar from the xml with viewbinding and store in val toolBarScore
        val toolBarScore = binding?.toolbarCreateBoardActivity
        //set te actionbar as toolBarScore
        setSupportActionBar(toolBarScore)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title = resources.getString(R.string.scoresDb)

        }
        toolBarScore?.setNavigationOnClickListener { onBackPressed() }
    }
}