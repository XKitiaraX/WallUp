package com.example.wallup.boulderproblems

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wallup.R
import com.example.wallup.database.ProblemDatabase
import com.example.wallup.databinding.FragmentBoulderProblemsBinding

class BoulderProblemsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // binding and inflate
        val binding = DataBindingUtil.inflate<FragmentBoulderProblemsBinding>(
            inflater, R.layout.fragment_boulder_problems, container, false)
        val application = requireNotNull(this.activity).application

        // ViewModel Factory
        val dataSource = ProblemDatabase.getInstance(application).problemDatabaseDao
        val viewModelFactory = BoulderProblemsViewModelFactory(dataSource, application)

        // ViewModel
        val boulderProblemsViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(BoulderProblemsViewModel::class.java)

        // ViewModel with data binding
        binding.boulderProblemsViewModel = boulderProblemsViewModel

        // lifecycle for observe LiveData
        binding.setLifecycleOwner(this)

        // binding recicler view adapter
        val adapter = BoulderProblemAdapter()
        binding.veryEasyRView.adapter = adapter
        binding.easyRView.adapter = adapter
        binding.mediumRView.adapter = adapter
        binding.hardRView.adapter = adapter
        binding.veryHardRView.adapter = adapter

        boulderProblemsViewModel.problems.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        // Floating Action Button
        binding.floatingActionButton.setOnClickListener {
            boulderProblemsViewModel.onInsert()
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.problems_filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}