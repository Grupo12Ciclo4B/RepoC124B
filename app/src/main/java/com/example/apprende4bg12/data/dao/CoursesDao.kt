package com.example.apprende4bg12.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apprende4bg12.data.models.CoursesModel

@Dao
interface CoursesDao {

    @Query("SELECT * FROM courses")
    suspend fun getAll(): List<CoursesModel>

    @Query("SELECT * FROM courses WHERE description = :description")
    suspend fun getAllByDescription(description: String): List<CoursesModel>

    @Query("SELECT COUNT(*) FROM courses")
    suspend fun count(): Int

    @Insert
    suspend fun insertAll(service: List<CoursesModel>)
}