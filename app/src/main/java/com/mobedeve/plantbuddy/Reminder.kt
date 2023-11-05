package com.mobedeve.plantbuddy


import android.content.Intent
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.mobedeve.plantbuddy.databinding.ActivityReminderBinding


class Reminder : AppCompatActivity(), TaskItemClickListener
{
    private lateinit var binding: ActivityReminderBinding
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_reminder)
        binding = ActivityReminderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
        bottomNavigationView = findViewById(R.id.bottom_navigator)
        bottomNavigationView.selectedItemId = R.id.reminder
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.reminder -> true
                R.id.notes -> {
                    startActivity(Intent(this@Reminder, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.gardenprofile -> {
                    startActivity(Intent(this@Reminder, GardenProfile::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                else -> false
            }
        }

//        val navView: BottomNavigationView = binding.bottomNavigator
//
//        val navController = findNavController(R.id.reminder)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.notes, R.id.gardenprofile
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//
//
//

    }

//    private fun replaceFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.notes, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
    private fun setRecyclerView()
    {
        val mainActivity = this
        taskViewModel.taskItems.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem)
    {
        NewTaskSheet(taskItem).show(supportFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItem)
    {
        taskViewModel.setCompleted(taskItem)
    }
}