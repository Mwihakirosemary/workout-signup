package dev.lotus.workoutlog.repository

import dev.lotus.workoutlog.api.ApiClient
import dev.lotus.workoutlog.api.ApiInterface
import dev.lotus.workoutlog.models.LoginRequest
import dev.lotus.workoutlog.models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun login(loginRequest: LoginRequest)
    = withContext(Dispatchers.IO){
        val response = apiClient.loin(loginRequest)
        return@withContext response
    }
}