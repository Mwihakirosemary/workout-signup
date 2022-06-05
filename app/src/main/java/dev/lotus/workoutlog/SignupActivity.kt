package dev.lotus.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
        lateinit var tilFirst: TextInputLayout
        lateinit var tilSecond: TextInputLayout
        lateinit var tilEmail: TextInputLayout
        lateinit var tilPassword: TextInputLayout
        lateinit var tilConfirm: TextInputLayout
        lateinit var etFirstName: TextInputEditText
        lateinit var etLast: TextInputEditText
        lateinit var etEmail: TextInputEditText
        lateinit var etPassword: TextInputEditText
        lateinit var etConfirm: TextInputEditText
        lateinit var btnLogin: Button
        lateinit var btnSignup: Button
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            tilFirst = findViewById(R.id.tilFirst)
            tilSecond = findViewById(R.id.tilSecond)
            tilEmail = findViewById(R.id.tilEmail)
            tilPassword = findViewById(R.id.tilPassword)
            tilConfirm = findViewById(R.id.tilConfirm)
            etFirstName = findViewById(R.id.etFirstName)
            etLast = findViewById(R.id.etLast)
            etEmail = findViewById(R.id.etEmail)
            etPassword = findViewById(R.id.etPassword)
            etConfirm = findViewById(R.id.etConfirm)
            btnLogin = findViewById(R.id.btnLogin)
            btnSignup = findViewById(R.id.btnSignup)

            btnSignup.setOnClickListener {
                validateSignup()

            }
            btnLogin.setOnClickListener {
                val intent = Intent(this,SignupActivity::class.java)
                startActivity(intent)
            }
        }
    fun validateSignup(){
        var first = etFirstName.text.toString()
        var second = etLast.text.toString()
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var confirm = etConfirm.text.toString()


        if (first.isBlank()){
            tilFirst.error = getString(R.string.first_name)
        }

        if (second.isBlank()){
            tilSecond.error = getString(R.string.last_required)
        }

        if (email.isBlank()){
            tilEmail.error = getString(R.string.email_required)
        }

        if (password.isBlank()){
            tilPassword.error = getString(R.string.password_required)
        }

        if (confirm.isBlank()){
            tilConfirm.error = getString(R.string.confirm_required)
        }


    }
}