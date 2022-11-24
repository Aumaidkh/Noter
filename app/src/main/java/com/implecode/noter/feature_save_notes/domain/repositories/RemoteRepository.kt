package com.implecode.noter.feature_save_notes.domain.repositories

import com.implecode.noter.feature_save_notes.data.remote.NoteDto

interface RemoteRepository {

    suspend fun getNotes(userId: String): List<NoteDto>

    suspend fun saveNotes(notes: List<NoteDto>)


}