package com.example.apprende4bg12.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apprende4bg12.data.models.ServiceModel


@Dao
interface ServiceDao {

    @Query("SELECT * FROM services")
    suspend fun getAll(): List<ServiceModel>

    @Query("SELECT COUNT(*) FROM services")
    suspend fun count(): Int

    @Insert
    suspend fun insertAll(service: List<ServiceModel>)
}