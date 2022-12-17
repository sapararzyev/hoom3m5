package com.example.hoom3m5.activity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hoom3m5.ImageModel
import com.example.hoom3m5.databinding.ItemImgBinding

class ImageAdapter(private val list: MutableList<ImageModel>) :
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onbind(list[position])
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("NotifyDataSetChanged")
    fun getNewElemens(list: MutableList<ImageModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemImgBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onbind(item: ImageModel) {
            binding.imageView.load(item.largeImageURL)
        }
    }


}