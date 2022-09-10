package dev.lotus.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.lotus.workoutlog.databinding.ActivitySignup2Binding
import dev.lotus.workoutlog.models.RegisterRequests
import dev.lotus.workoutlog.models.RegisterResponse
import dev.lotus.workoutlog.api.ApiClient
import dev.lotus.workoutlog.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import com.kirigo.workoutlog.databinding.ActivitySignUpBinding

class SignupActivity2 : AppCompatActivity() {
    lateinit var binding:ActivitySignup2Binding


    //    tvLogin2.setOnClickListener {
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.tvLogin2.setOnClickListener {
//            val intent = Intent(this, LoginActivity2::class.java)
//            startActivity(intent)
//        }
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignup.setOnClickListener {
            validity()
        }
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
//            val registerRequest= RegisterResponse(firstName, lastName, email,phoneNumber,sPassword)
//            makeRegistrationRequest(registerRequest)
        }
        else{
            binding.tilConfirm.error="Password Invalid"

        }


    }

    fun makeRegistrationRequest(registerRequest: RegisterRequests){
        var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        var request =apiClient.registerUser(registerRequest)

        request.enqueue(object: Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    var message = response.body()?.message
                    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
                    //intent to login
                } else {
                    val error = response.errorBody()?.string()
                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })






    }
}