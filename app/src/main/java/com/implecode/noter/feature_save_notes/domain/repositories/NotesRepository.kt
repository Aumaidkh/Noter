package com.implecode.noter.feature_save_notes.domain.repositories

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    /**
     * Inserting a note*/
    suspend fun insertNote(note: NoteEntity)

    /**
     * Insert notes in bulk
     * */
    suspend fun insertNotes(notes: List<NoteEntity>)

    /**
     * Deleting a note*/
    suspend fun deleteNote(note: NoteEntity)

    /**
     * Fetching all notes
     * */
    fun getAllNotes(): List<NoteEntity>

}