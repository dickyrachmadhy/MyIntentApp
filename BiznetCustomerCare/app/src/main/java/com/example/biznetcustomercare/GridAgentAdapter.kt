package com.example.biznetcustomercare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GridAgentAdapter (val listAgent: List<Agent>) : RecyclerView.Adapter<GridAgentAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): GridViewHolder {
        val view : View = LayoutInflater.from(ViewGroup.context).inflate(R.layout.item_list_agent,ViewGroup,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listAgent[position].photo)
            .into(holder.imgPhoto)

    }

    override fun getItemCount(): Int {
        return listAgent.size
    }

    inner class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}