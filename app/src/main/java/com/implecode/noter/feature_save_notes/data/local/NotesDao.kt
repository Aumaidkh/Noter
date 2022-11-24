package com.implecode.noter.feature_save_notes.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    /**
     * 1. Insert or Update a Note
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    /**
     * 2. Delete a Note
     * */
    @Delete
    suspend fun deleteNote(note: NoteEntity)

    /**
     * 3. Fetch All Notes
     * */
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<NoteEntity>

    /**
     * 4. Insert Notes In Bulk*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>)

}