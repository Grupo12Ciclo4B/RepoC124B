package com.example.apprende4bg12.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apprende4bg12.data.models.CompanyModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.models.ServiceModel
import com.example.apprende4bg12.data.repositories.HomeRepository
import com.example.apprende4bg12.di.viewModelModule
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: HomeRepository):ViewModel() {
    private var _services: MutableLiveData<List<ServiceModel>> = MutableLiveData()
    val services: LiveData<List<ServiceModel>> get() = _services

    private var _company: MutableLiveData<CompanyModel> = MutableLiveData()
    val company: LiveData<CompanyModel> get() = _company

    private var _courses: MutableLiveData<List<CoursesModel>> = MutableLiveData()
    val courses: LiveData<List<CoursesModel>> get() = _courses

    private var _course: MutableLiveData<CoursesModel> = MutableLiveData()
    val course: LiveData<CoursesModel> get() = _course

    fun getServices() {
        viewModelScope.launch {
            _services.postValue(repo.getServices())
        }
    }

    fun getInfo() {
        viewModelScope.launch {
            _company.postValue(repo.getInfo())
        }
    }

    fun getCourses(category: String?){
        viewModelScope.launch {
            _courses.postValue(repo.getCourses(category))
        }
    }

    fun selectedCourse(item: CoursesModel){
        _course.postValue(item)
    }
}