package com.example.apprende4bg12

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apprende4bg12.dao.CoursesDao
import com.example.apprende4bg12.data.models.ServiceModel
import com.example.apprende4bg12.data.models.CoursesModel
import com.example.apprende4bg12.data.dao.ServiceDao


@Database(entities = [CoursesModel::class, ServiceModel::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun serviceDao(): ServiceDao
    abstract fun coursesDao(): CoursesDao
}