package com.example.tococd.di

import android.content.Context
import com.example.tococd.data.local.preferences.DataStoreOperationsImpl
import com.example.tococd.domain.repository.DataStoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun providesDataStoreOperations(@ApplicationContext context: Context): DataStoreOperations =
        DataStoreOperationsImpl(context)
}