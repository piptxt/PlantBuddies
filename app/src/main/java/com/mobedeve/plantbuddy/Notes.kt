package com.mobedeve.plantbuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobedeve.plantbuddy.databinding.ActivityMainBinding
import com.mobedeve.plantbuddy.databinding.ActivityNotesBinding

class Notes : AppCompatActivity() {
    // Preliminary Variables
    private lateinit var data: ArrayList<NotesNoteModel>         // Holds the data for the app
    private lateinit var myAdapter: NotesAdapter               // Holds the adapter for the RecyclerView
    private lateinit var viewBinding: ActivityNotesBinding   // Holds the views of the ActivityMainBinding

    companion object {
        const val TAG : String = "Notes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }
}