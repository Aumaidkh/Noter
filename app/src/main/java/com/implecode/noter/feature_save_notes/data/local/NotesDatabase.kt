package com.implecode.noter.feature_save_notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

}