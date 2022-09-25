package com.example.apprende4bg12.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apprende4bg12.databinding.FragmentProfileBinding
import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.apprende4bg12.CAMERA_PERMISSION
import com.example.apprende4bg12.R
import com.example.apprende4bg12.TAKE_PICTURE
import com.example.apprende4bg12.checkPermission
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()


        binding.profileFragmentImage.setOnClickListener{
            if(this.checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION )){
                openCamera()
            }
        }

        binding.profileFragmentSettingsBotton.setOnClickListener{
            Snackbar.make(binding.root,getString(R.string.settings), Snackbar.LENGTH_SHORT ).show()
        }
        binding.profileFragmentLocationBotton.setOnClickListener{

            findNavController().navigate(R.id.profileToLocation)

        }
        observeViewModels()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openCamera()
        } else {
            Snackbar.make(binding.root, "Permiso no fue concedido", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TAKE_PICTURE){
            if (data!=null && data.extras != null) {
                val extras = data.extras!!
                val image = extras["data"] as Bitmap?
                binding.profileFragmentImage.setImageBitmap(image)
            }
        }
    }
    private fun observeViewModels() {
        loginViewModel.user.observe(viewLifecycleOwner, Observer{
            binding.profileFragmentName.text = it.name
            binding.profileFragmentEmail.text = it.email
            if(it.image != null){
                Glide.with(binding.root).load(it.image).centerCrop().into(binding.profileFragmentImage)
            }
        })
    }

    private fun openCamera() {

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try{
            startActivityForResult(intent, TAKE_PICTURE)
        }catch (e: ActivityNotFoundException){}
    }
}