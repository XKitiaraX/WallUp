package com.example.wallup.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProblemDatabaseDao {

    @Insert
    fun insert(problem: BoulderProblem)

    @Update
    fun update(problem: BoulderProblem)

    @Query("SELECT * FROM boulder_problems_details_table WHERE problemId = :key")
    fun get(key: Long): BoulderProblem

    @Query("DELETE FROM boulder_problems_details_table")
    fun clear()

    @Query("SELECT * FROM boulder_problems_details_table ORDER BY problemId DESC")
    fun getAllProblems(): LiveData<List<BoulderProblem>>

}