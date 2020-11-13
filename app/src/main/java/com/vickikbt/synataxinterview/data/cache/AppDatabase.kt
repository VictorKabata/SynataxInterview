package com.vickikbt.synataxinterview.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vickikbt.synataxinterview.models.Posts

@Database(entities = [Posts::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun postsDao(): PostsDao

}