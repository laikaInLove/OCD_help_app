package com.example.tococd.di

import android.content.Context
import com.example.tococd.data.local.preferences.DataStoreOperationsImpl
import com.example.tococd.domain.repository.DataStoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PreferencesModule {

    @Provides
    @ViewModelScoped
    fun providesDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations =
        DataStoreOperationsImpl(context)
}