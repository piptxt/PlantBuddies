package com.mobedeve.plantbuddy

import android.content.Context
import androidx.core.content.ContextCompat
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskItem(
    var name: String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDate: LocalDate?,
    var id: UUID = UUID.randomUUID()
)
{
    fun isCompleted() = completedDate != null
    fun imageResource(): Int = if(isCompleted()) R.drawable.checked_24 else R.drawable.unchecked_24
    fun imageColor(context: Context): Int = if(isCompleted()) yellow(context) else silverfox(context)

    private fun yellow(context: Context) = ContextCompat.getColor(context, R.color.cuteyellow)
    private fun silverfox(context: Context) = ContextCompat.getColor(context, R.color.silverfox)
}