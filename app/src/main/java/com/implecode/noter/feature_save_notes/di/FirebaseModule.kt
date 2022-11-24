package com.implecode.noter.feature_save_notes.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn
object FirebaseModule {

    /**
     * Firestore Instance
     * */
    @Provides
    @Singleton
    fun providesFirestoreInstance(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}