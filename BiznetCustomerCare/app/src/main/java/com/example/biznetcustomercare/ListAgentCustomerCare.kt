package com.example.biznetcustomercare

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper.prepare
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_agent_customer_care.*
import kotlinx.android.synthetic.main.activity_main.*

class ListAgentCustomerCare : AppCompatActivity() {
    private var list: ArrayList<Agent> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_agent_customer_care)

        rv_list.setHasFixedSize(true)

        supportActionBar?.title = "List Agent Customer Care"

        list.addAll(AgentData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList(){
        rv_list.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)
        rv_list.adapter = listAgentAdapter

        listAgentAdapter.onItemClickCallback(object : ListAgentAdapter.OnItemClickCallback {
            override fun onItemClickCallback(data: Agent) {
                val moveIntentProfileActivity = Intent (this@ListAgentCustomerCare, AboutProfileActivity::class.java)
                moveIntentProfileActivity.putExtra(AboutProfileActivity.EXTRA_AGENT, data)

                Toast.makeText(this@ListAgentCustomerCare, "Kamu memilih " + data.nama, Toast.LENGTH_SHORT)
                    .show()

                startActivity(moveIntentProfileActivity)
            }
        })
    }

}

