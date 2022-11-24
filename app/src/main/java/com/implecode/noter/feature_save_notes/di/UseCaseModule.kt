package com.implecode.noter.feature_save_notes.di

import com.implecode.noter.feature_save_notes.data.use_case.GetNotesUseCaseImpl
import com.implecode.noter.feature_save_notes.domain.repositories.LocalNotesRepository
import com.implecode.noter.feature_save_notes.domain.repositories.RemoteRepository
import com.implecode.noter.feature_save_notes.domain.use_case.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    /**
     * Getting Notes Use Case
     * */
    @Singleton
    @Provides
    fun providesGetNotesUseCase(
        localNotesRepository: LocalNotesRepository,
        remoteRepository: RemoteRepository
    ): GetNotesUseCase {
        return GetNotesUseCaseImpl(
            localNotesRepository,
            remoteRepository
        )
    }
}