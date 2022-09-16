package dev.lotus.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.lotus.workoutlog.databinding.ActivitySignup2Binding
import dev.lotus.workoutlog.models.RegisterRequests
import dev.lotus.workoutlog.models.RegisterResponse
import dev.lotus.workoutlog.api.ApiClient
import dev.lotus.workoutlog.api.ApiInterface
import dev.lotus.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity2 : AppCompatActivity() {
    lateinit var binding:ActivitySignup2Binding
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignup.setOnClickListener {
            validity()
        }

        binding.btnLogin2.setOnClickListener {
            val intent = Intent(this, LoginActivity2::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse->
            Toast.makeText(baseContext, registerResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity2::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
    fun validity(){
        var firstName= binding.etFirstName.text.toString()
        var lastName = binding.etLast.text.toString()
        var email= binding.etEmal.text.toString()
        var phoneNumber = binding.etPhone.toString()
        var sPassword= binding.etPass .text.toString()
        var confirm= binding.etConfirm .text.toString()

        var error =false

        if (firstName.isBlank()){
            binding.tilFirstname.error= "First Name is required"
            error=true
        }

        if (lastName.isBlank()){
            error=true
            binding.tilSecond.error ="Last name is required"
        }

        if (email.isBlank()) {
            binding.tilPassword.error = "Email is required"
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhone.error = "PhoneNumber is required"
        }
        if (sPassword.isBlank()) {
            binding.tilPassword.error = "Password is required"
        }
        if (!confirm.equals(sPassword)){
            error=true
            binding.tilConfirm.error =" Password doesn't match";

        }
        if (!error) {
            val registerRequest= RegisterRequests(firstName, lastName, email,phoneNumber,sPassword)
            userViewModel.registerUser(registerRequest)
        }
    }
}
