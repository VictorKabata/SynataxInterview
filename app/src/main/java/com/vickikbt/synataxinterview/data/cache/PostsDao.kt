package com.vickikbt.synataxinterview.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.synataxinterview.models.Post

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPosts(posts:List<Post>)

    @Query("SELECT * FROM post_table")
    suspend fun getAllPosts():List<Post>

    @Query("SELECT COUNT(*) FROM post_table")
    suspend fun isPostCacheAvailable(): Int

}