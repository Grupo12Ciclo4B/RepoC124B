package com.example.apprende4bg12.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor

@Entity(tableName = "services")
data class ServiceModel (
    @PrimaryKey
    var id: String,
    val icon: String,
    val title: String,
    val description: String,
    )

