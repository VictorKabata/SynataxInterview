package com.vickikbt.synataxinterview.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vickikbt.synataxinterview.data.cache.AppDatabase
import com.vickikbt.synataxinterview.data.network.ApiService
import com.vickikbt.synataxinterview.data.pref.TimePreference
import com.vickikbt.synataxinterview.models.Post
import com.vickikbt.synataxinterview.util.Constants
import com.vickikbt.synataxinterview.util.Coroutines
import com.vickikbt.synataxinterview.util.TimeKeeper
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase,
    private val timePreference: TimePreference
) {

    private val postsMutableLiveData = MutableLiveData<List<Post>>()

    init {
        postsMutableLiveData.observeForever { posts ->
            saveAllPosts(posts)
        }
    }

    suspend fun getAllPosts(): List<Post> {
        val isPostCacheAvailable = appDatabase.postsDao().isPostCacheAvailable() > 0
        val lastSyncTime = timePreference.getLastSyncTime
        val isTimeSurpassed = TimeKeeper.isTimeWithinInterval(
            Constants.TimeInterval,
            System.currentTimeMillis(),
            lastSyncTime
        )

        if (isPostCacheAvailable && !isTimeSurpassed) {
            Log.e("VickiKbt", "Post Repository: Cache Available")
            return appDatabase.postsDao().getAllPosts()
        }

        Log.e("VickiKbt", "Post Repository: Cache Is Not Available")

        val postResponse = apiService.fetchAllPosts()
        postsMutableLiveData.postValue(postResponse)
        timePreference.saveSyncTime(System.currentTimeMillis())

        return postResponse
    }

    private fun saveAllPosts(posts: List<Post>) {
        Coroutines.io {
            appDatabase.postsDao().saveAllPosts(posts)
        }
    }

}