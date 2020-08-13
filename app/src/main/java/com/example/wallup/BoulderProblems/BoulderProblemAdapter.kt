package com.example.wallup.boulderproblems

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wallup.database.BoulderProblem
import com.example.wallup.databinding.ListItemBoulderProblemBinding

class BoulderProblemAdapter: ListAdapter<BoulderProblem, BoulderProblemAdapter.ViewHolder>(BoulderProblemDiffCallback()) {

    class ViewHolder private constructor(val binding: ListItemBoulderProblemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BoulderProblem) {
            binding.boulder = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBoulderProblemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class BoulderProblemDiffCallback: DiffUtil.ItemCallback<BoulderProblem>() {
    override fun areItemsTheSame(oldItem: BoulderProblem, newItem: BoulderProblem): Boolean {
        return oldItem.problemId == newItem.problemId
    }

    override fun areContentsTheSame(oldItem: BoulderProblem, newItem: BoulderProblem): Boolean {
        return oldItem == newItem
    }

}