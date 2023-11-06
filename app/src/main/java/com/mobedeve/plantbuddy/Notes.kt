package com.mobedeve.plantbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mobedeve.plantbuddy.databinding.ActivityNotesBinding

class Notes : AppCompatActivity() {
    // Preliminary Variables
//    private lateinit var data: ArrayList<NotesNoteModel>         // Holds the data for the app
//    private lateinit var myAdapter: NotesAdapter               // Holds the adapter for the RecyclerView
//    private lateinit var viewBinding: ActivityNotesBinding   // Holds the views of the ActivityMainBinding

    companion object {
        const val TAG : String = "NotesActivty"
    }

//    private val viewNoteLauncher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
//        if (result.resultCode == RESULT_OK) {
//            val modifiedTitle = result.data?.getStringExtra(NotesViewNoteActivity.titleKey)
//            val modifiedBody = result.data?.getStringExtra(NotesViewNoteActivity.bodyKey)
//            val position = result.data?.getIntExtra(NotesViewNoteActivity.positionKey, -1)
//
//            if (position != null && position != -1) {
//                // Update the data ArrayList
//                data[position].title = modifiedTitle ?: ""
//                data[position].body = modifiedBody ?: ""
//
//                // Notify the adapter of the change -> TO DO
//                TODO("fix error that occurs")
////                myAdapter.notifyItemChanged(position)
//
//                Log.d(TAG,"notifyItemChanged finished execution")
//            }
//        }
//        Log.d(TAG,"viewNoteLauncher function finished execution")
//    }

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

//        TODO("binding parts")
//        this.viewBinding = ActivityNotesBinding.inflate(layoutInflater)
//        setContentView(this.viewBinding.root)
//
//        // This loads the note data into the data attribute.
//        this.data = NotesDataHelper.generateData()
//
//        /*
//        *   TODO: Provide the logic for setting up the RecyclerView.
//        * */
//        this.myAdapter = NotesAdapter(data, viewNoteLauncher)
//        this.viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
//        this.viewBinding.recyclerView.adapter = myAdapter
//
//        Log.d(TAG,"NotesActivity onCreate finished execution")
    }
}