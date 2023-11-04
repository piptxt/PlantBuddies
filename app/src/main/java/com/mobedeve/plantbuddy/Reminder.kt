package com.mobedeve.plantbuddy


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        setContentView(R.layout.activity_reminder)
        binding = ActivityReminderBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
//        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.reminder -> true
//                R.id.notes -> {
//                    startActivity(Intent(this@Reminder, MainActivity::class.java))
//                    overridePendingTransition(0, 0)
//                    true
//                }
//                R.id.gardenprofile -> {
//                    startActivity(Intent(this@Reminder, GardenProfile::class.java))
//                    overridePendingTransition(0, 0)
//                    true
//                }
//                else -> false
//            }
//        }

    }

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