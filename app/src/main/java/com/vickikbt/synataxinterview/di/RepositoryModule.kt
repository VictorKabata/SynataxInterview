package com.vickikbt.synataxinterview.di

import com.vickikbt.synataxinterview.data.cache.AppDatabase
import com.vickikbt.synataxinterview.data.network.ApiService
import com.vickikbt.synataxinterview.data.pref.TimePreference
import com.vickikbt.synataxinterview.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object RepositoryModule {

    @Provides
    fun providesUserRepository(
        apiService: ApiService,
        appDatabase: AppDatabase,
        timePreference: TimePreference
    ): PostRepository {
        return PostRepository(apiService, appDatabase, timePreference)
    }
}