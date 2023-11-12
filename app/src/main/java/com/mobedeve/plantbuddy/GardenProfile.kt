package com.mobedeve.plantbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class GardenProfile : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var tvUsername : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden_profile)

        tvUsername = findViewById(R.id.tvUsername)
        tvUsername.text = intent.getStringExtra("username")

        bottomNavigationView = findViewById(R.id.bottom_navigator)
        bottomNavigationView.selectedItemId = R.id.gardenprofile

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.reminder -> {
                startActivity(Intent(this@GardenProfile, Reminder::class.java))
                overridePendingTransition(0, 0)
                true
            }
                R.id.notes -> {
                    startActivity(Intent(this@GardenProfile, Notes::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.gardenprofile -> true
                else -> false
            }
        }
    }
}