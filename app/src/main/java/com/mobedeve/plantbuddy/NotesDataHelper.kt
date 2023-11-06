package com.mobedeve.plantbuddy

class NotesDataHelper {

    companion object {
        /*
        *   Use this method to generate the data expected at start of the app. Remember, a companion
        *   object in Kotlin is like declaring an item to be static in Java.
        * */
        fun generateData() : ArrayList<NotesNoteModel> {
            val data = ArrayList<NotesNoteModel>()

            data.add(NotesNoteModel("Watering the Plants", "some body"))
            data.add(NotesNoteModel("Planting Seeds", "some body"))
            data.add(NotesNoteModel("Take care of weeds", "some body"))

            return data
        }
    }
}