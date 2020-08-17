package com.example.wallup.boulderdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.wallup.R
import com.example.wallup.database.ProblemDatabase
import com.example.wallup.databinding.FragmentBoulderDetailBinding


class BoulderDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentBoulderDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_boulder_detail, container, false)

        // ViewModel Factory
        val application = requireNotNull(this.activity).application
        val dataSource = ProblemDatabase.getInstance(application).problemDatabaseDao
        val viewModelFactory = BoulderDetailViewModelFactory(dataSource, application)

        // ViewModel
        val boulderDetailViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(BoulderDetailViewModel::class.java)

        // ViewModel with data binding
        binding.boulderDetailViewModel = boulderDetailViewModel

        // lifecycle for observe LiveData
        binding.setLifecycleOwner(this)

        return binding.root
    }
}