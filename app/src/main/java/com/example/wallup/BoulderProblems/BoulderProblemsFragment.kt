package com.example.wallup.BoulderProblems

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.wallup.R
import com.example.wallup.databinding.FragmentBoulderProblemsBinding

class BoulderProblemsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBoulderProblemsBinding>(
            inflater, R.layout.fragment_boulder_problems, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.problems_filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}