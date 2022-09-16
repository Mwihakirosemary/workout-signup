package dev.lotus.workoutlog.api

import dev.lotus.workoutlog.models.LoginRequest
import dev.lotus.workoutlog.models.LoginResponse
import dev.lotus.workoutlog.models.RegisterRequests
import dev.lotus.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//interface ApiInterface {
////    import retrofit2.Call
////    import retrofit2.http.Body
////    import retrofit2.http.POST

    interface ApiInterface {
        @POST("/register")
        suspend fun registerUser(@Body registerRequests: RegisterRequests): Response<RegisterResponse>

        @POST("/login")
        suspend fun loin(@Body loginRequest: LoginRequest): Response<LoginResponse>
    }




