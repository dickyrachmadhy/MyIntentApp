package com.example.myintentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridLogosAdapter(val listLogos: ArrayList<Logos>) : RecyclerView.Adapter<GridLogosAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view : View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_logos, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position:  Int) {
        //holder.imgPhoto.setImageResource

        Glide.with(holder.itemView.context)
            .load(listLogos[position].photo)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPhoto)
    }

    override fun getItemCount(): Int {
        return listLogos.size
    }

    inner class GridViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_logos)
    }

}