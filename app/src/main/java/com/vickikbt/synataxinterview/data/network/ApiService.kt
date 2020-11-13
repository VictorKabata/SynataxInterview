package com.vickikbt.synataxinterview.data.network

import com.vickikbt.synataxinterview.models.Posts
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts():List<Posts>
}