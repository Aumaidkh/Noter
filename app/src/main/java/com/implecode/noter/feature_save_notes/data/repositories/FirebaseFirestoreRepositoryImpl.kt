package com.implecode.noter.feature_save_notes.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.implecode.noter.feature_save_notes.data.remote.NoteDto
import com.implecode.noter.feature_save_notes.domain.repositories.RemoteRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseFirestoreRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
): RemoteRepository {

    override suspend fun getNotes(userId: String): List<NoteDto> {
        return firestore.collection(userId).get().await().toObjects(NoteDto::class.java)
    }

    override suspend fun saveNotes(notes: List<NoteDto>) {

    }

}