package com.vickikbt.synataxinterview.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class Posts(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)