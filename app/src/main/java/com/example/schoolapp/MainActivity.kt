package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schoolapp.entity.User

class MainActivity : AppCompatActivity() {

    val appDatabase: AppDatabase by lazy {
      AppDatabase.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}