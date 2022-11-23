package com.implecode.noter.feature_save_notes.data.repositories

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import com.implecode.noter.feature_save_notes.data.local.NotesDao
import com.implecode.noter.feature_save_notes.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val dao: NotesDao
) : NotesRepository {

    override suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: NoteEntity) {
        dao.deleteNote(note)
    }

    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return dao.getAllNotes()
    }


}