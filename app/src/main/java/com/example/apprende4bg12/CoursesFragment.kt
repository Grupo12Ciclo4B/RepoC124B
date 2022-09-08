package com.example.apprende4bg12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apprende4bg12.databinding.FragmentCoursesBinding


class CoursesFragment : Fragment() {

    private var _binding: FragmentCoursesBinding? = null
    private val binding: FragmentCoursesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        return binding.root
    }


}