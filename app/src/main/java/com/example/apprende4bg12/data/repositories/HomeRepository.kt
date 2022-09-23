package com.example.apprende4bg12.data.repositories

import com.example.apprende4bg12.data.datasources.MemoryDataSource
import com.example.apprende4bg12.data.models.CompanyModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.models.ServiceModel

class HomeRepository(private val memoryDataSource: MemoryDataSource) {
    suspend fun getServices(): List<ServiceModel>{
        return memoryDataSource.getServices()
    }

    suspend fun getInfo(): CompanyModel {
        return memoryDataSource.getInfo()
    }
    suspend fun getCourses(category: String?): List<CoursesModel>{
        return  memoryDataSource.getCourses(category)
    }
}