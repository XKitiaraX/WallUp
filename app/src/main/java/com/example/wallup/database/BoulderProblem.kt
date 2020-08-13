package com.example.wallup.database

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boulder_problems_details_table")
data class BoulderProblem (
    @PrimaryKey(autoGenerate = true)
    var problemId: Long = 0L,

    @ColumnInfo(name = "problem_difficult")
    val problemDifficult: Int = -1,

    @ColumnInfo(name = "holds_color")
    val holdsColor: Int = Color.GRAY,

    @ColumnInfo(name = "register_date")
    val registerDate: Long = System.currentTimeMillis()
)