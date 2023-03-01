package com.jefferymoju.databasequizapp.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jefferymoju.databasequizapp.R
import com.jefferymoju.databasequizapp.database.QuizEntity
import com.jefferymoju.databasequizapp.databinding.ItemsRowBinding

// Item Adapter for the recycler view
class ItemAdapter(private val items: ArrayList<QuizEntity>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    //class for the itemadapter which the item row and its components is passed to
    class ViewHolder(binding: ItemsRowBinding): RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val rvName = binding.rvName
        val rvSubject = binding.rvSubject
        val rvScore = binding.rvScores
    }

    // oncreate fucntion to return the itemrow as the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val to get the item from the database
        val item = items[position]

        // pass the name from the database to the itemrow name
        holder.rvName.text = item.name
        // pass the subject from the database
        holder.rvSubject.text = item.subject
        // pass the score from the database
        holder.rvScore.text = item.score.toString()

        // for every secondth item set the color to color grey
        if (position % 2 == 0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.colorLightGrey))
        }else{
            // item should be color white
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}