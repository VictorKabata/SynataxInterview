package com.vickikbt.synataxinterview.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vickikbt.synataxinterview.models.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun postsDao(): PostsDao

}