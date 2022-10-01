package com.example.apprende4bg12.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import com.example.apprende4bg12.databinding.FragmentLogoutBinding
import com.example.apprende4bg12.ui.activities.LoginActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LogoutFragment : Fragment() {

    private var _binding: FragmentLogoutBinding? = null
    private val binding: FragmentLogoutBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLogoutBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.logoutBottom.setOnClickListener{
            loginViewModel.logOut()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        loginViewModel.user.observe(viewLifecycleOwner, Observer{
            if (it == null) {
                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }


        })
    }


}