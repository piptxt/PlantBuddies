package com.mobedeve.plantbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvHellaur : TextView
    private lateinit var tvWrold : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUI()
    }

    private fun initializeUI() {
        tvHellaur = findViewById(R.id.hellaur)
        tvWrold = findViewById(R.id.wrold)
    }
}
//test