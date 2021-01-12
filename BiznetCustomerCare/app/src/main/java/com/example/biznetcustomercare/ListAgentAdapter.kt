package com.example.biznetcustomercare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAgentAdapter(val listAgentCustomerCare: ArrayList<Agent>) : RecyclerView.Adapter<ListAgentAdapter.ListViewHolder>(){

    private var onItemClickCallback: OnItemClickCallback? = null

    fun onItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClickCallback(data:Agent)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_agent, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val agent:Agent = listAgentCustomerCare[position]

        Glide.with(holder.itemView.context)
            .load(agent.photo)
            .apply(RequestOptions().override(50,50))
            .into(holder.imgPhoto)

        holder.tvName.text = agent.nama
        holder.tvEmail.text = agent.email
        holder.tvNotlp.text = agent.no_tlp

        holder.itemView.setOnClickListener{
            onItemClickCallback?.onItemClickCallback(agent)
        }
    }

    override fun getItemCount(): Int {
        return listAgentCustomerCare.size
    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        var tvNotlp: TextView = itemView.findViewById(R.id.tv_no_tlp)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }


}