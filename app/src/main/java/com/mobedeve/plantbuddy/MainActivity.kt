package com.mobedeve.plantbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
   private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val registerClicked = findViewById<Button>(R.id.registerbut)
        registerClicked.setOnClickListener{
            setContentView(R.layout.login)
            val loginClicked = findViewById<Button>(R.id.signinbut)
            loginClicked.setOnClickListener{
                setContentView(R.layout.activity_main)
                bottomNavigationView = findViewById(R.id.bottom_navigator)
                bottomNavigationView.selectedItemId = R.id.notes

                bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.reminder -> {
                            startActivity(Intent(this@MainActivity, Reminder::class.java)) //change to this@Notes eventually
                            overridePendingTransition(0, 0)
                            true
                        }
                        R.id.notes -> {startActivity(Intent(this@MainActivity, Notes::class.java)) //change to this@Notes eventually
                        overridePendingTransition(0, 0)
                            true
                        }
                        R.id.gardenprofile -> {
                            startActivity(Intent(this@MainActivity, GardenProfile::class.java)) //change to this@Notes eventually
                            overridePendingTransition(0, 0)
                            true
                        }
                        else -> false
                    }
                }
            }
        }






//        setContentView(R.layout.activity_main)
//        bottomNavigationView = findViewById(R.id.bottom_navigator)
//        bottomNavigationView.selectedItemId = R.id.notes
//
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.reminder -> {
//                    startActivity(Intent(this@MainActivity, Reminder::class.java)) //change to this@Notes eventually
//                    overridePendingTransition(0, 0)
//                    true
//                }
//                R.id.notes -> true
//                R.id.gardenprofile -> {
//                    startActivity(Intent(this@MainActivity, GardenProfile::class.java)) //change to this@Notes eventually
//                    overridePendingTransition(0, 0)
//                    true
//                }
//                else -> false
//            }
//        }
    }


}
