package com.mobedeve.plantbuddy.ui.reminder

interface TaskItemClickListener {
    //fun onTaskItemClick(taskItem: TaskItem)
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)

}