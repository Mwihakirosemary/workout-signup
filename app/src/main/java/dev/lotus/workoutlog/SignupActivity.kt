package dev.lotus.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
        lateinit var btnLogin: Button
        lateinit var btnSignup: Button
        lateinit var tilFirst: TextInputLayout
        lateinit var tilSecond: TextInputLayout
        lateinit var tilEmail: TextInputLayout
        lateinit var tilPassword: TextInputLayout
        lateinit var tilConfirm: TextInputLayout
        lateinit var etFirstName: TextInputEditText
        lateinit var etLast: TextInputEditText
        lateinit var etConfirm: TextInputEditText
        lateinit var etEmail: TextInputEditText
        lateinit var etPassword: TextInputEditText
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            btnLogin = findViewById(R.id.btnLogin)
            btnSignup = findViewById(R.id.btnSignup)
            tilFirst = findViewById(R.id.tilFirst)
            tilSecond = findViewById(R.id.tilSecond)
            tilEmail = findViewById(R.id.tilEmail)
            tilPassword = findViewById(R.id.tilEml)
            tilConfirm = findViewById(R.id.tilConfirm)
            etFirstName = findViewById(R.id.etFirstName)
            etLast = findViewById(R.id.etLast)
            etConfirm = findViewById(R.id.etConfirm)
            etEmail = findViewById(R.id.etEmail)
            etPassword = findViewById(R.id.etEmail)

            btnSignup.setOnClickListener {
                validateSignup()

            }
            btnLogin.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
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