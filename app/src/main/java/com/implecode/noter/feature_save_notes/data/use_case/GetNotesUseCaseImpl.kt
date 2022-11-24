package com.implecode.noter.feature_save_notes.data.use_case

import com.implecode.noter.feature_save_notes.data.local.NoteEntity
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import com.implecode.noter.feature_save_notes.domain.repositories.RemoteRepository
import com.implecode.noter.feature_save_notes.domain.use_case.GetNotesUseCase
import com.implecode.noter.feature_save_notes.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(
    private val localRepo: LocalNotesRepository,
    private val remoteRepository: RemoteRepository
) : GetNotesUseCase {

    override fun execute(userId: String): Flow<Resource<List<NoteEntity>>> {
        return flow {
            // 1. Emit loading state along with the data inside the database
            val savedNotes = localRepo.getAllNotes()
            emit(Resource.loading(savedNotes))
            // 2. Fetching Data from the fire store and emit error resource if there is any error
            // 3. Clearing the Database

            // 5. Emitting the success resource
            val notes = remoteRepository.getNotes(userId = userId).map {
                NoteEntity(
                    timestamp = it.timestamp!!,
                    title = it.title?:"",
                    desc = it.description ?: "",
                    category = it.category!!,
                    isPinned = it.is_pinned?:false,
                    isSynced = true
                )
            }
            // 4. Re-Populating the database
            localRepo.insertNotes(notes)
            val updatedNotesList = localRepo.getAllNotes()
            emit(Resource.success(updatedNotesList))
        }
    }
}