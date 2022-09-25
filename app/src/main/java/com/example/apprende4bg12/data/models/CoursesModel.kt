package com.example.apprende4bg12.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor

@Entity(tableName = "courses")
data class CoursesModel (
    @PrimaryKey
    val id: String,
    val icon: String,
    val title: String,
    val description: String,
    val star: Double,
    val about: String

)


