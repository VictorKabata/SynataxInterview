package com.vickikbt.synataxinterview.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.synataxinterview.models.Posts

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPosts(posts:Posts)

    @Query("SELECT * FROM post_table")
    suspend fun getAllPosts():List<Posts>

    @Query("SELECT COUNT(*) FROM post_table")
    suspend fun isPostCacheAvailable(): Int

}