package com.implecode.noter.feature_save_notes.di

import com.implecode.noter.feature_save_notes.data.local.NotesDatabase
import com.implecode.noter.feature_save_notes.data.repositories.LocalNotesRepositoryImpl
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Notes Repository
     * */
    fun providesLocalNotesRepository(
        db: NotesDatabase
    ): LocalNotesRepository {
        return LocalNotesRepositoryImpl(
            dao = db.getNotesDao()
        )
    }

}