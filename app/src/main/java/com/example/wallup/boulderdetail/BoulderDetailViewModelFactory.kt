package com.example.wallup.boulderdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallup.database.ProblemDatabaseDao

class BoulderDetailViewModelFactory(
    private val dataSource: ProblemDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BoulderDetailViewModel::class.java)) {
            return BoulderDetailViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}