package com.vickikbt.synataxinterview.data.network

import com.vickikbt.synataxinterview.models.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun fetchAllPosts():List<Post>
}