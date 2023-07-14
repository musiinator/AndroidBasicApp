package com.example.test2

import Gallery
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test2.databinding.ImageItemBinding

class AdapterGallery(private val dataList: List<Gallery>, val enlargeItem: (String, String) -> Unit) : RecyclerView.Adapter<AdapterGallery.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterGallery.ViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: AdapterGallery.ViewHolder, position: Int) {
        val gallery = dataList[position]
        Glide.with(holder.binding.imageViewGallery.context)
            .load(gallery.image)
            .into(holder.binding.imageViewGallery)
        holder.binding.textViewGallery.text = gallery.title



        holder.itemView.setOnClickListener(){
            enlargeItem(gallery.title, gallery.image)
        }
    }

    inner class ViewHolder(val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root){
        val image : ImageView
        init {
            image = binding.imageViewGallery
        }
    }

}