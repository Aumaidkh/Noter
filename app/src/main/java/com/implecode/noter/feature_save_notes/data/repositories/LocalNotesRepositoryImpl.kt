package com.implecode.noter.feature_save_notes.data.repositories

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import com.implecode.noter.feature_save_notes.data.local.NotesDao
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import javax.inject.Inject

class LocalNotesRepositoryImpl @Inject constructor(
    private val dao: NotesDao
) : LocalNotesRepository {

    override suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    override suspend fun insertNotes(notes: List<NoteEntity>) {
        dao.insertNotes(notes)
    }

    override suspend fun deleteNote(note: NoteEntity) {
        dao.deleteNote(note)
    }

    override suspend fun getAllNotes(): List<NoteEntity> {
        return dao.getAllNotes()
    }


}