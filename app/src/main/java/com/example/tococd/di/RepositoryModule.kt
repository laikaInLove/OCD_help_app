package com.example.tococd.di

import com.example.tococd.data.repository.PsychologistRepositoryImpl
import com.example.tococd.domain.repository.PsychologistRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun providesPsychologistRepository(psychologistRepositoryImpl: PsychologistRepositoryImpl): PsychologistRepository
}