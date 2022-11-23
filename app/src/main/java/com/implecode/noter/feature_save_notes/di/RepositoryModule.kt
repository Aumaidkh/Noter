package com.implecode.noter.feature_save_notes.di

import com.implecode.noter.feature_save_notes.data.local.NotesDatabase
import com.implecode.noter.feature_save_notes.data.repositories.NotesRepositoryImpl
import com.implecode.noter.feature_save_notes.domain.repositories.NotesRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Notes Repository
     * */
    fun providesNotesRepository(
        db: NotesDatabase
    ): NotesRepository {
        return NotesRepositoryImpl(
            dao = db.getNotesDao()
        )
    }

}