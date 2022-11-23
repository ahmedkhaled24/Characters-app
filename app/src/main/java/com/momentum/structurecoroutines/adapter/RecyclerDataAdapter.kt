package com.momentum.structurecoroutines.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.momentum.structurecoroutines.R
import com.momentum.structurecoroutines.models.RecyclerData
import com.squareup.picasso.Picasso

class RecyclerDataAdapter: RecyclerView.Adapter<RecyclerDataAdapter.RecyclerDataViewHolder>() {

    private var items : ArrayList<RecyclerData> = ArrayList()

    class RecyclerDataViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageID)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val desc: TextView = view.findViewById(R.id.tvDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerDataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.design_item, parent, false)
        return RecyclerDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerDataViewHolder, position: Int) {
        holder.title.text = items[position].name
        holder.desc.text = items[position].description
        Picasso.get().load(items[position].owner.avatar_url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setUpData(items: ArrayList<RecyclerData>) {
        this.items = items
//        notifyDataSetChanged()
    }
}