package com.implecode.noter.feature_save_notes.di

import android.content.Context
import androidx.room.Room
import com.implecode.noter.feature_save_notes.data.local.NotesDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Database Instance
     * */
    fun providesNotesDatabase(
        @ApplicationContext context: Context
    ): NotesDatabase {
        return Room.databaseBuilder(
            context,
            NotesDatabase::class.java,
            "NotesDatabase"
        ).build()
    }




}