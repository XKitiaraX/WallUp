package com.example.wallup.boulderproblems

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.wallup.database.BoulderProblem
import java.text.SimpleDateFormat

@BindingAdapter("problemHoldColor")
fun ImageView.setProblemHoldColor(item: BoulderProblem) {
    setBackgroundColor(item.holdsColor)
}

@BindingAdapter("problemDate")
fun TextView.setProblemDate(item: BoulderProblem) {
    val dateFormated = SimpleDateFormat("dd/MM/yy").format(item.registerDate)
    text = dateFormated
    // TODO Cambiar formato guiri para la versión en inglés
}