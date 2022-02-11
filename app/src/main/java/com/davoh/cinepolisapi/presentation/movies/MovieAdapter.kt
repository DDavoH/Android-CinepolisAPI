package com.davoh.cinepolisapi.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.davoh.cinepolisapi.data.Movie
import com.davoh.cinepolisapi.databinding.ItemMovieBinding

class MovieAdapter : ListAdapter<Movie, RecyclerView.ViewHolder>(DiffCallback()) {
    private var listener: OnItemClickListener ?= null
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return (holder as ItemViewHolder).bind(getItem(position))
    }
    
    inner class ItemViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Movie){
            
            Glide.with(binding.root.context)
                .load(item.image)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(binding.poster)
            
            binding.movieTitle.text = item.name
            binding.movieSynopsis.text = item.synopsis
        }
    }
    
    class DiffCallback : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
    
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
    interface OnItemClickListener{
        fun onItemClick(item:Movie)
    }
    
    
}