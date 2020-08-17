package com.example.wallup.boulderproblems

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.wallup.database.BoulderProblem
import com.example.wallup.database.ProblemDatabaseDao
import kotlinx.coroutines.*

class BoulderProblemsViewModel (dataSource: ProblemDatabaseDao, application: Application): ViewModel() {

    val database = dataSource

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val problems = database.getAllProblems()

    private var _veRViewVis = MutableLiveData<Boolean>(false)
    val veRViewVis: LiveData<Boolean>
        get() = _veRViewVis

    private var _eRViewVis = MutableLiveData<Boolean>(false)
    val eRViewVis: LiveData<Boolean>
        get() = _eRViewVis

    private var _mRViewVis = MutableLiveData<Boolean>(false)
    val mRViewVis: LiveData<Boolean>
        get() = _mRViewVis

    private var _hRViewVis = MutableLiveData<Boolean>(false)
    val hRViewVis: LiveData<Boolean>
        get() = _hRViewVis

    private var _vhRViewVis = MutableLiveData<Boolean>(false)
    val vhRViewVis: LiveData<Boolean>
        get() = _vhRViewVis

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

    fun changeVERViewVisibility(visivility: LiveData<Boolean>) {
        when (visivility) {
            veRViewVis -> _veRViewVis.value = !visivility.value!!
            eRViewVis -> _eRViewVis.value = !visivility.value!!
            mRViewVis -> _mRViewVis.value = !visivility.value!!
            hRViewVis -> _hRViewVis.value = !visivility.value!!
            vhRViewVis -> _vhRViewVis.value = !visivility.value!!
        }
    }

//    fun changeRViewVisibility(recyclerView: RecyclerView) {
//        if (recyclerView.visibility == View.GONE) {
//            recyclerView.visibility = View.VISIBLE
//        } else {
//            recyclerView.visibility = View.GONE
//        }
//    }
}