package com.vickikbt.synataxinterview.repositories

import com.vickikbt.synataxinterview.data.cache.AppDatabase
import com.vickikbt.synataxinterview.data.network.ApiService
import com.vickikbt.synataxinterview.data.pref.TimePreference
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
    private val timePreference: TimePreference
) {


}