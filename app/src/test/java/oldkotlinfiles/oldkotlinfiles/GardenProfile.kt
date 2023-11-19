package oldkotlinfiles.oldkotlinfiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobedeve.plantbuddy.R

class GardenProfile : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.l)
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