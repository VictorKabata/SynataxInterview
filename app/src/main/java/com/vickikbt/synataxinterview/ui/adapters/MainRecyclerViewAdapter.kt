package com.vickikbt.synataxinterview.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vickikbt.synataxinterview.R
import com.vickikbt.synataxinterview.databinding.MainRecyclerviewItemBinding
import com.vickikbt.synataxinterview.models.Post

class MainRecyclerViewAdapter constructor(private val postsList: List<Post>) :
    RecyclerView.Adapter<MainRecyclerViewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MainRecyclerviewItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.main_recyclerview_item, parent, false)

        return MainRecyclerViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainRecyclerViewViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun getItemCount() = postsList.size
}

class MainRecyclerViewViewHolder(private val binding: MainRecyclerviewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.textViewTitle.text = post.title
        binding.textViewBody.text = post.body
    }

}