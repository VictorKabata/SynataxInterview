package com.vickikbt.synataxinterview.di

import android.app.Application
import androidx.room.Room
import com.vickikbt.synataxinterview.data.cache.AppDatabase
import com.vickikbt.synataxinterview.data.cache.PostsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "syntax.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesPostDAO(appDatabase: AppDatabase): PostsDao {
        return appDatabase.postsDao()
    }
}
