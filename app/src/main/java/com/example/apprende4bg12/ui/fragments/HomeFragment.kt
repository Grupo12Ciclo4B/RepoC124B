package com.example.apprende4bg12.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apprende4bg12.interfaces.OnServiceClickListener
import com.example.apprende4bg12.R
import com.example.apprende4bg12.ui.adapters.ServiceAdapter
import com.example.apprende4bg12.data.models.ServiceModel
import com.example.apprende4bg12.data.viewmodels.HomeViewModel
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import com.example.apprende4bg12.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private val homeViewModel: HomeViewModel by sharedViewModel()
    private val loginViewModel: LoginViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        loginViewModel.currentUser()
        homeViewModel.getServices()
        serviceAdapter = ServiceAdapter(
            listOf(


            )
        )

        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceModel) {
                    val action = HomeFragmentDirections.actionHomeFragmentToCoursesFragment()
                    action.search = false
                    action.name = item.title
                    action.description = item.description
                    findNavController().navigate(action)

            }

        }

        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        observeViewModels()
    }
    private fun observeViewModels() {
        homeViewModel.services.observe(viewLifecycleOwner, Observer{
            serviceAdapter.changeDataSet(it)
        })
    }

}