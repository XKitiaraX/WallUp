package com.example.wallup.BoulderProblems

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }
}