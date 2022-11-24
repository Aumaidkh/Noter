package com.implecode.noter.feature_save_notes.domain.repositories

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import kotlinx.coroutines.flow.Flow

interface LocalNotesRepository {

    /**
     * Inserting a note*/
    suspend fun insertNote(note: NoteEntity)

    /**
     * Deleting a note*/
    suspend fun deleteNote(note: NoteEntity)

    /**
     * Fetching all notes
     * */
    suspend fun getAllNotes(): List<NoteEntity>

}