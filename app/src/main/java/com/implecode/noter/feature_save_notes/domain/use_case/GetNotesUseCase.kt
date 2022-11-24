package com.implecode.noter.feature_save_notes.domain.use_case

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import com.implecode.noter.feature_save_notes.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetNotesUseCase {

    fun execute(): Flow<Resource<List<NoteEntity>>>
}