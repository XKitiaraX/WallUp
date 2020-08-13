package com.example.wallup.boulderproblems

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.wallup.database.BoulderProblem

@BindingAdapter("problemHoldColor")
fun ImageView.setProblemHoldColor(item: BoulderProblem) {
    setBackgroundColor(item.holdsColor)
}

@BindingAdapter("problemDate")
fun TextView.setProblemDate(item: BoulderProblem) {
    text = item.registerDate.toString()
}