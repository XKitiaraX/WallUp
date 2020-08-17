package com.example.wallup.boulderproblems

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.wallup.R
import com.example.wallup.database.ProblemDatabase
import com.example.wallup.databinding.FragmentBoulderProblemsBinding
import dev.sasikanth.colorsheet.ColorSheet

class BoulderProblemsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // binding and inflate
        val binding: FragmentBoulderProblemsBinding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_boulder_problems, container, false)

        val application = requireNotNull(this.activity).application

        // ViewModel Factory
        val dataSource = ProblemDatabase.getInstance(application).problemDatabaseDao
        val viewModelFactory = BoulderProblemsViewModelFactory(dataSource, application)

        // ViewModel
        val boulderProblemsViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(BoulderProblemsViewModel::class.java)

        // ViewModel with data binding
        binding.boulderProblemsViewModel = boulderProblemsViewModel

        // binding recicler view adapter
        val adapter = BoulderProblemAdapter()
        binding.veryEasyRView.adapter = adapter
//        binding.easyRView.adapter = adapter
//        binding.mediumRView.adapter = adapter
//        binding.hardRView.adapter = adapter
//        binding.veryHardRView.adapter = adapter

        boulderProblemsViewModel.problems.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        // lifecycle for observe LiveData
        binding.setLifecycleOwner(this)

        // Floating Action Button
        binding.floatingActionButton.setOnClickListener {
            Log.i("Insert", "Fun setOnClickListener")
//            boulderProblemsViewModel.onInsert()
            val colors = intArrayOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.BLACK, Color.BLUE, Color.CYAN)
            var selectedColor : Int
            ColorSheet().colorPicker(
                colors = colors,
                listener = { color ->
                    selectedColor = color
                    Toast.makeText(it.context, selectedColor.toString(), Toast.LENGTH_LONG).show()
                }).show(childFragmentManager)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.problems_filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}