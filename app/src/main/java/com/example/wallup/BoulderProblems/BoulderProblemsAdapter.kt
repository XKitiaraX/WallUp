package com.example.wallup.BoulderProblems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallup.R
import kotlinx.android.synthetic.main.list_item_boulder_problem.view.*

class BoulderProblemsAdapter: RecyclerView.Adapter<BoulderProblemsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val damImg: TextView = itemView.findViewById(R.id.list_item_boulder_problem_img)
        val damDate: TextView = itemView.findViewById(R.id.list_item_boulder_problem_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_boulder_problem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}