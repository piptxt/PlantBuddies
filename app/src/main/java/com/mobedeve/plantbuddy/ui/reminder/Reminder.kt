package com.mobedeve.plantbuddy.ui.reminder

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobedeve.plantbuddy.R
import com.mobedeve.plantbuddy.databinding.FragmentReminderBinding

class Reminder : Fragment(), TaskItemClickListener{

    private var _binding: FragmentReminderBinding? = null
    private lateinit var taskViewModel: TaskViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reminderViewModel =
            ViewModelProvider(this).get(ReminderViewModel::class.java)

        _binding = FragmentReminderBinding.inflate(inflater, container, false)
        val root: View = binding.root
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)


        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(childFragmentManager, "newTaskTag")
        }

//      setRecyclerView()

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setRecyclerView()
    {
        val mainActivity = this@Reminder
        taskViewModel.taskItems.observe(viewLifecycleOwner){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem)
    {
        NewTaskSheet(taskItem).show(childFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItem)
    {
        taskViewModel.setCompleted(taskItem)
    }
}