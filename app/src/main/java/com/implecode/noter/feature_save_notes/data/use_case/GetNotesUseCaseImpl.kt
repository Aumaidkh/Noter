package com.implecode.noter.feature_save_notes.data.use_case

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import com.implecode.noter.feature_save_notes.domain.use_case.GetNotesUseCase
import com.implecode.noter.feature_save_notes.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNotesUseCaseImpl(
    private val localRepo: LocalNotesRepository
): GetNotesUseCase {

    override fun execute(): Flow<Resource<List<NoteEntity>>> {
        return flow {
            // 1. Emit loading state along with the data inside the database
            val savedNotes = localRepo.getAllNotes()
            emit(Resource.loading(savedNotes))
            // 2. Fetching Data from the fire store and emit error resource if there is any error
            // 3. Clearing the Database
            // 4. Re-Populating the database
            // 5. Emitting the success resource
            val updatedNotesList = localRepo.getAllNotes()
            emit(Resource.success(updatedNotesList))
        }
    }
}