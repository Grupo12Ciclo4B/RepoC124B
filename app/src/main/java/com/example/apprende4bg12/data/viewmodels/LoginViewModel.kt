package com.example.apprende4bg12.data.viewmodels

import android.graphics.Bitmap
import android.media.Image
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprende4bg12.data.models.UserModel
import com.example.apprende4bg12.data.repositories.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    private var _signUp: MutableLiveData<Boolean> = MutableLiveData()
    val signUp: LiveData<Boolean> get() = _signUp


    private var _login: MutableLiveData<Boolean> = MutableLiveData()
    val login: LiveData<Boolean> get() = _login

    private var _user: MutableLiveData<UserModel?> = MutableLiveData()
    val user: LiveData<UserModel?> get() = _user

    private var _logout: MutableLiveData<Boolean> = MutableLiveData()
    val logout: LiveData<Boolean> get() = _logout

    fun login(email: String, password: String){

            viewModelScope.launch {
                try {
                repo.login(email, password)
                _login.postValue(true)
                }catch (e: Exception) {
                    _login.postValue(false)
                }
            }
    }

    fun signUp(email: String, password: String, name: String){
        viewModelScope.launch {
            try {
                repo.signUp(email, password, name)
                _signUp.postValue(true)
            }catch (e: Exception) {
                _signUp.postValue(false)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                repo.logout()
                _user.postValue(null)
            }catch (e: Exception) {
            }
        }
    }
    fun currentUser() {
        viewModelScope.launch {
            _user.postValue(repo.getCurrentUser())
        }
    }

    fun uploadImage(image: Bitmap){
        viewModelScope.launch {
            _user.postValue(repo.uploadImage(image))
        }
    }
}