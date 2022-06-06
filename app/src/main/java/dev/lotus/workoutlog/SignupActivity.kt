package dev.lotus.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
        lateinit var tilFirstname: TextInputLayout
        lateinit var tilSecond: TextInputLayout
        lateinit var tilEmal: TextInputLayout
        lateinit var tilPassword: TextInputLayout
        lateinit var tilConfirm: TextInputLayout
        lateinit var etFirstName: TextInputEditText
        lateinit var etLast: TextInputEditText
        lateinit var etEmal: TextInputEditText
        lateinit var etPassword: TextInputEditText
        lateinit var etConfirm: TextInputEditText
        lateinit var btnLogin2: Button
        lateinit var btnSignup: Button
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_signup)
            tilFirstname = findViewById(R.id.tilFirstname)
            tilSecond = findViewById(R.id.tilSecond)
            tilEmal = findViewById(R.id.tilEmal)
            tilPassword = findViewById(R.id.tilPassword)
            tilConfirm = findViewById(R.id.tilConfirm)
            etFirstName = findViewById(R.id.etFirstName)
            etLast = findViewById(R.id.etLast)
            etEmal = findViewById(R.id.etEmal)
            etPassword = findViewById(R.id.etPass)
            etConfirm = findViewById(R.id.etConfirm)
            btnLogin2 = findViewById(R.id.btnLogin2)
            btnSignup = findViewById(R.id.btnSignup)

            btnSignup.setOnClickListener {
                validateSignup()

            }
            btnLogin2.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
    fun validateSignup(){
        var first = etFirstName.text.toString()
        var second = etLast.text.toString()
        var email = etEmal.text.toString()
        var password = etPassword.text.toString()
        var confirm = etConfirm.text.toString()


        if (first.isBlank()){
            tilFirstname.error = getString(R.string.first_name)
        }

        if (second.isBlank()){
            tilSecond.error = getString(R.string.last_required)
        }

        if (email.isBlank()){
            tilEmal.error = getString(R.string.email_required)
        }

        if (password.isBlank()){
            tilPassword.error = getString(R.string.password_required)
        }

        if (confirm.isBlank()){
            tilConfirm.error = getString(R.string.confirm_required)
        }


    }
}