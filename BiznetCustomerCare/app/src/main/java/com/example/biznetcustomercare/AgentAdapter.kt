package com.example.biznetcustomercare

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.security.AccessControlContext

class AgentAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var agents = arrayListOf<Agent>()
    override fun getCount(): Int { return agents.size}
    override fun getItem(i: Int): Any {return agents[i]}
    override fun getItemId(i: Int): Long { return i.toLong()}

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_agent, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val agent = getItem(position) as Agent
        viewHolder.bind(agent)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.tv_item_name)
        private val txtEmail: TextView = view.findViewById(R.id.tv_email)
        private val txtNoTelp: TextView = view.findViewById(R.id.tv_no_tlp)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)

        internal fun bind(agent: Agent) {
            txtName.text = agent.nama
            txtEmail.text = agent.email
            txtNoTelp.text = agent.no_tlp
            Log.d("TAG", "$agent")
            try {
                imgPhoto.setImageResource(agent.photo)
            }catch (ex: Exception){
                Log.d("TAG", "$ex")
            }

        }
    }
}

