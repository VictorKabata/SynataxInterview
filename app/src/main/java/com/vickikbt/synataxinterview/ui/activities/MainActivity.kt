package com.vickikbt.synataxinterview.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.vickikbt.synataxinterview.R
import com.vickikbt.synataxinterview.databinding.ActivityMainBinding
import com.vickikbt.synataxinterview.ui.adapters.MainRecyclerViewAdapter
import com.vickikbt.synataxinterview.ui.viewmodels.PostsViewModel
import com.vickikbt.synataxinterview.util.StateListener
import com.vickikbt.synataxinterview.util.hide
import com.vickikbt.synataxinterview.util.show
import com.vickikbt.synataxinterview.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), StateListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<PostsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel.stateListener = this

        initUI()

    }

    private fun initUI() {
        viewModel.getAllPosts.observe(this, Observer { posts ->
            binding.recyclerviewMain.adapter = MainRecyclerViewAdapter(posts)
            binding.progressBarMain.hide()
        })
    }

    override fun onLoading() {
        binding.progressBarMain.show()
    }

    override fun onSuccess(message: String) {
        binding.progressBarMain.hide()
    }

    override fun onFailure(message: String) {
        binding.progressBarMain.hide()
        toast(message)
    }
}