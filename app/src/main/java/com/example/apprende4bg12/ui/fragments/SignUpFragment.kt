package com.example.apprende4bg12.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.apprende4bg12.R
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import com.example.apprende4bg12.databinding.FragmentSignUpBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerbtn.setOnClickListener{
            loginViewModel.signUp(
                binding.signupEmail.text.toString(),
                binding.signupRepeatPassword.text.toString(),
                binding.signupName.text.toString()
            )
        }
        binding.backLoginBtn.setOnClickListener{

            findNavController().navigate(R.id.SignupToLogin)
        }
        observeViewModels()
    }

    private fun observeViewModels(){
        loginViewModel.signUp.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(R.id.SignupToLogin)
            } else {
                Snackbar.make(binding.root,getString(R.string.signup_error), Snackbar.LENGTH_LONG).show()
            }

        })
    }

}