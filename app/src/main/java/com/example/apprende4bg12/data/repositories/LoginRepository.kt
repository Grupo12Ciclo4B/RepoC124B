package com.example.apprende4bg12.data.repositories

import com.example.apprende4bg12.data.datasources.MemoryDataSource
import com.example.apprende4bg12.data.models.UserModel
import kotlinx.coroutines.delay

class LoginRepository(private val memoryDataSource: MemoryDataSource) {
    suspend fun login(email: String, password: String){
        delay(2000)
        if(email != "s@sd.co" || password != "asdasdasd"){
            throw Exception("credenciales inválidas")
        }
    }
    suspend fun logout() {

    }
    suspend fun getCurrentUser(): UserModel{
        return memoryDataSource.getCurrentUser()
    }
}