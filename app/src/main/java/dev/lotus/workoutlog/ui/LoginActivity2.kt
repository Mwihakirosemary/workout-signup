package dev.lotus.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.lotus.workoutlog.databinding.ActivityLogin2Binding
import dev.lotus.workoutlog.models.LoginRequest
import dev.lotus.workoutlog.models.LoginResponse
import dev.lotus.workoutlog.api.ApiClient
import dev.lotus.workoutlog.api.ApiInterface
import dev.lotus.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityLogin2Binding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)




        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity2::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            validation()
        }


    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG)
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()

        })
    }


    fun validation(){
        var email = binding.etEmail.text.toString()
        var password = binding.etPass.text.toString()
        var error = false
        if(email.isBlank()){
            binding.tilEmail.error = "Email is required"
            error= true
        }
        if(password.isBlank()){
            binding.tilPassword.error = "Password is required"
            error= true
        }
        if(!error){
            var loginRequest=LoginRequest(email,password)
            binding.pbLogin.visibility = View.VISIBLE
            userViewModel.loginUser(loginRequest)
        }


    }

        fun saveLoginDetails(loginResponse: LoginResponse){
            var editor = sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
            editor.putString("USER_ID", loginResponse.userId)
            editor.putString("PROFILE_ID", loginResponse.profileId)
            editor.apply()

        }
    }


