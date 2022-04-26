package com.example.mynotesapp.helper

import android.database.Cursor
import com.example.mynotesapp.db.DatabaseContract
import com.example.mynotesapp.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(noteCursor: Cursor): ArrayList<Note> {
        val noteList = ArrayList<Note>()

        noteCursor.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColoums._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColoums.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColoums.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColoums.DATE))
                noteList.add(Note(id, title, description, date))
            }
        }
        return noteList
    }
}