package com.vickikbt.synataxinterview.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vickikbt.synataxinterview.repositories.PostRepository
import com.vickikbt.synataxinterview.util.StateListener

class PostsViewModel @ViewModelInject constructor(private val postRepository: PostRepository) :
    ViewModel() {

    var stateListener: StateListener? = null

    val getAllPosts = liveData {
        stateListener?.onLoading()

        try {
            val posts = postRepository.getAllPosts()
            posts.let { posts ->
                stateListener?.onSuccess("Data Fetched!")
                emit(posts)
            }
        } catch (e: Exception) {
            stateListener?.onFailure(e.message.toString())
        }
    }

}