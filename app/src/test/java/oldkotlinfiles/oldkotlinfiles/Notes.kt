package oldkotlinfiles.oldkotlinfiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
<<<<<<< HEAD:app/src/test/java/oldkotlinfiles/oldkotlinfiles/Notes.kt
import com.mobedeve.plantbuddy.R
=======
>>>>>>> parent of 96be571 (Merge pull request #2 from piptxt/log_activities):app/src/main/java/com/mobedeve/plantbuddy/Notes.kt

class Notes : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        bottomNavigationView = findViewById(R.id.bottom_navigator)
        bottomNavigationView.selectedItemId = R.id.gardenprofile

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.reminder -> {
                    startActivity(Intent(this@Notes, Reminder::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.notes -> true
                R.id.gardenprofile -> {
                    startActivity(Intent(this@Notes, GardenProfile::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }
    }
}