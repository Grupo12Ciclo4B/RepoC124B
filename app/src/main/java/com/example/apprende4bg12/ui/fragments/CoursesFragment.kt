package com.example.apprende4bg12.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprende4bg12.ui.adapters.CoursesAdapter
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.interfaces.OnCourseClickListener
import com.example.apprende4bg12.R
import com.example.apprende4bg12.data.viewmodels.HomeViewModel
import com.example.apprende4bg12.databinding.FragmentCoursesBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class CoursesFragment : Fragment() {

    private var _binding: FragmentCoursesBinding? = null
    private val binding: FragmentCoursesBinding get() = _binding!!
    private val args: CoursesFragmentArgs by navArgs()
    private lateinit var coursesAdapter: CoursesAdapter
    private lateinit var categories: MutableList<String>
    private val homeViewModel: HomeViewModel by sharedViewModel()


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCoursesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()



        if(args.search){
            homeViewModel.getCourses(null)
            binding.coursesFragmentSearch.visibility = View.VISIBLE
            binding.coursesFragmentTitle.text = getString(R.string.courses_fragment_title)
            binding.coursesFragmentTitleList.visibility = View.GONE
        }else{
            binding.coursesFragmentSearch.visibility = View.GONE
            binding.coursesFragmentTitleList.visibility = View.VISIBLE
            binding.coursesFragmentTitle.text = args.name
            homeViewModel.getCourses(args.name)
        }

        coursesAdapter = CoursesAdapter(mutableListOf())
        coursesAdapter.listener = object : OnCourseClickListener {
            override fun onClick(item: CoursesModel) {
                homeViewModel.selectedCourse(item)
                findNavController().navigate(R.id.action_coursesFragment_to_coursesDetailFragment)
            }
        }



        binding.coursesFragmentRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coursesAdapter
        }
        observeViewModels()
    }
    private fun observeViewModels() {
        homeViewModel.courses.observe(viewLifecycleOwner, Observer{
            coursesAdapter.changeDataSet(it)
        })
        homeViewModel.services.observe(viewLifecycleOwner, Observer{
            categories = mutableListOf(
                "Todos"
            )
                it.forEach{
                    categories.add(it.title)
                }
            binding.coursesFragmentSearchAutocomplete.setAdapter(
                ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, categories))
            binding.coursesFragmentSearchAutocomplete.setOnItemClickListener{ parent, view, position, id ->
                val category = categories[position]
                if(category != "Todos")
                    homeViewModel.getCourses(category)
                else
                    homeViewModel.getCourses(null)
            }
        })
    }
}
