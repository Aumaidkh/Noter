package com.implecode.noter.feature_save_notes.di

import com.google.firebase.firestore.FirebaseFirestore
import com.implecode.noter.feature_save_notes.data.local.NotesDatabase
import com.implecode.noter.feature_save_notes.data.repositories.FirebaseFirestoreRepositoryImpl
import com.implecode.noter.feature_save_notes.data.repositories.LocalNotesRepositoryImpl
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import com.implecode.noter.feature_save_notes.domain.repositories.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Notes Repository
     * */
    @Singleton
    @Provides
    fun providesLocalNotesRepository(
        db: NotesDatabase
    ): LocalNotesRepository {
        return LocalNotesRepositoryImpl(
            dao = db.getNotesDao()
        )
    }

    /**
     * Remote Repository*/
    @Singleton
    @Provides
    fun providesRemoteRepository(
        firestore: FirebaseFirestore
    ): RemoteRepository {
        return FirebaseFirestoreRepositoryImpl(
            firestore = firestore
        )
    }

}