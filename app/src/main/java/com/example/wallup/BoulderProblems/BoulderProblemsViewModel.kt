package com.example.wallup.boulderproblems

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.wallup.database.BoulderProblem
import com.example.wallup.database.ProblemDatabaseDao
import kotlinx.coroutines.*

class BoulderProblemsViewModel (dataSource: ProblemDatabaseDao, application: Application): ViewModel() {

    val database = dataSource

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val problems = database.getAllProblems()

    private suspend fun insert(problem: BoulderProblem) {
        withContext(Dispatchers.IO) {
            database.insert(problem)
        }
    }

    fun onInsert() {
        uiScope.launch {
            val problem = BoulderProblem()
            insert(problem)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}