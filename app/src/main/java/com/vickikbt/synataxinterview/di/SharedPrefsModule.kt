package com.vickikbt.synataxinterview.di

import android.app.Application
import com.vickikbt.synataxinterview.data.pref.TimePreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)

@Module
object SharedPrefsModule {

    @Provides
    fun providesTimePreference(application: Application): TimePreference {
        return TimePreference(application)
    }
}