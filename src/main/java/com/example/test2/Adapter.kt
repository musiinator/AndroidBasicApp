package com.example.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.databinding.ItemBinding

class Adapter(private val dataList: List<Movie>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val movie = dataList[position]
        viewHolder.binding.textView.text = movie.title
        viewHolder.binding.imageView.setImageResource(movie.image)
    }

    override fun getItemCount() = dataList.size

    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
    }
}