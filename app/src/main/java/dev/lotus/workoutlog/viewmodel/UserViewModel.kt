package dev.lotus.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.lotus.workoutlog.models.LoginRequest
import dev.lotus.workoutlog.models.LoginResponse
import dev.lotus.workoutlog.models.RegisterRequests
import dev.lotus.workoutlog.models.RegisterResponse
import dev.lotus.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository = UserRepository()
    var loginResponseLiveData = MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String?>()

    var registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()


    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response = userRepository.login(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue((response.body()))
            }
            else{
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequests: RegisterRequests){
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequests)
            if (response.isSuccessful){
                registerResponseLiveData.postValue((response.body()))
            }
            else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }
}