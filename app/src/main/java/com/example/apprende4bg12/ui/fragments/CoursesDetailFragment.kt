package com.example.apprende4bg12.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.apprende4bg12.R
import com.example.apprende4bg12.data.viewmodels.HomeViewModel
import com.example.apprende4bg12.databinding.FragmentCoursesDetailBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CoursesDetailFragment : Fragment() {

    private var _binding: FragmentCoursesDetailBinding? = null
    private val binding: FragmentCoursesDetailBinding get() = _binding!!
    private val homeViewModel: HomeViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCoursesDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        observeViewModels()
        binding.backToHomeBottom.setOnClickListener() {

            findNavController().navigate(R.id.courseDetailToHome)
            Snackbar.make(binding.root,getString(R.string.register_course), Snackbar.LENGTH_SHORT ).show()
        }
    }



    private fun observeViewModels() {
        homeViewModel.course.observe(viewLifecycleOwner, Observer{
            binding.courseDetailFragmentName.text = it.title
            binding.courseDetailFragmentDetail.text = it.about
            binding.courseDetailFragmentType.text = it.description
            binding.courseDetailFragmentRating.rating = it.star.toFloat()
            binding.courseDetailFragmentRatingNum.text = it.star.toString()
            binding.courseDetailFragmentImage.setImageResource(it.icon.toInt())

        })
    }

}