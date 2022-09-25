package com.example.apprende4bg12.data.repositories

import com.example.apprende4bg12.dao.CoursesDao
import com.example.apprende4bg12.data.dao.ServiceDao
import com.example.apprende4bg12.data.datasources.MemoryDataSource
import com.example.apprende4bg12.data.models.CompanyModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.models.ServiceModel

class HomeRepository(private val memoryDataSource: MemoryDataSource,
     private val serviceDao: ServiceDao, private val coursesDao: CoursesDao) {


    suspend fun getServices(): List<ServiceModel>{

        //return memoryDataSource.getServices()
        return serviceDao.getAll()
    }

    suspend fun getInfo(): CompanyModel {
        return memoryDataSource.getInfo()
    }
    suspend fun getCourses(category: String?): List<CoursesModel>{
        //return  memoryDataSource.getCourses(category)
        if(category == null) return coursesDao.getAll()
        return coursesDao.getAllByDescription(category)
    }
}