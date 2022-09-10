package dev.lotus.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lotus.workoutlog.R

class SplashActivity2 : AppCompatActivity() {
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        val accessToken = sharedPrefs.getString("ACCESS_TOKEN","")
        if (accessToken!!.isNotBlank()){
            startActivity(Intent(this, HomeActivity::class.java))
        }
        else{
            startActivity(Intent(this, LoginActivity2::class.java))
        }
        finish()

    }
}