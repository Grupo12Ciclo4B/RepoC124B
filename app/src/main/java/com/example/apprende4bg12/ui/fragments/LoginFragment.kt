package com.example.apprende4bg12.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.apprende4bg12.ui.activities.HomeActivity
import com.example.apprende4bg12.R
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import com.example.apprende4bg12.databinding.FragmentLoginBinding
import com.example.apprende4bg12.isValidEmail
import com.example.apprende4bg12.isValidPassword
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.loginbtn.setOnClickListener{
            if (!binding.loginEmail.text.toString().isValidEmail()){
                binding.loginEmailLayout.error = getString(R.string.Email_error)
            }else{
                binding.loginEmailLayout.error = null
            }

            if (!binding.loginPassword.text.toString().isValidPassword()){
                binding.loginPasswordLayout.error = getString(R.string.Password_error)
            }else{
                binding.loginPasswordLayout.error = null
            }

            if(binding.loginEmail.text.toString().isValidEmail() && binding.loginPassword.text.toString().isValidPassword()){

                loginViewModel.login(binding.loginEmail.text.toString(), binding.loginPassword.text.toString())
//                val intent = Intent(requireContext(), HomeActivity::class.java)
//                startActivity(intent)
//                requireActivity().finish()
            }
        }

        binding.signupbtn.setOnClickListener{

            findNavController().navigate(R.id.LoginToSignup)

        }

        binding.ForgotPassword.setOnClickListener{
            findNavController().navigate(R.id.LoginToRestarPassword)
        }
        observeViewModels()
    }

    private fun observeViewModels() {
        loginViewModel.login.observe(this, Observer {
            if (it) {
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Snackbar.make(binding.root,getString(R.string.invalid_credentials), Snackbar.LENGTH_LONG ).show()

            }
        })
    }

}