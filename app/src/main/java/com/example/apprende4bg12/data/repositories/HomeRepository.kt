package com.example.apprende4bg12.data.repositories

import com.example.apprende4bg12.COMPANY_COLLECTION
import com.example.apprende4bg12.COURSES_COLLECTION
import com.example.apprende4bg12.DETAILS_COLLECTION
import com.example.apprende4bg12.SERVICE_COLLECTION
import com.example.apprende4bg12.dao.CoursesDao
import com.example.apprende4bg12.data.dao.ServiceDao
import com.example.apprende4bg12.data.datasources.MemoryDataSource
import com.example.apprende4bg12.data.models.CompanyModel
import com.example.apprende4bg12.data.models.CoursesDetailModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.models.ServiceModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class HomeRepository(private val memoryDataSource: MemoryDataSource,
     private val serviceDao: ServiceDao, private val coursesDao: CoursesDao,
     private val db: FirebaseFirestore, private val storage:FirebaseStorage, private val auth: FirebaseAuth) {


    suspend fun getServices(): List<ServiceModel>{

        //return memoryDataSource.getServices()
        //return serviceDao.getAll()
        val result = (db.collection(SERVICE_COLLECTION).get().await()).toObjects<ServiceModel>()
        return  result.map {
            val ref = storage.reference
            val imageRef = ref.child(it.icon)
            it.icon = imageRef.downloadUrl.await().toString()
            return@map it
        }

    }

    suspend fun getInfo(): CompanyModel {
       // return memoryDataSource.getInfo()
         val result = db.collection(COMPANY_COLLECTION).get().await()
         return result.first().toObject<CompanyModel>()
    }
    suspend fun getCourses(category: String?): List<CoursesModel> {
        //return  memoryDataSource.getCourses(category)
        // if(category == null) return coursesDao.getAll()
        //return coursesDao.getAllByDescription(category)
        val result: List<CoursesModel>

        if(category != null) {
            result = db.collection(COURSES_COLLECTION).whereEqualTo("description", category).get()
                .await().toObjects()
        } else {
            result = db.collection(COURSES_COLLECTION).get().await().toObjects()

        }

        return result.map {
            val ref = storage.reference
            val imageRef = ref.child(it.icon)
            it.icon = imageRef.downloadUrl.await().toString()
            return@map it
        }
    }

    suspend fun  getDetails(id:String):CoursesDetailModel? {
        return db.collection(DETAILS_COLLECTION).document(id).get().await().toObject()

    }
}