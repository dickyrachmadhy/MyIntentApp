package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_recycler_view.*

class MyRecyclerView : AppCompatActivity() {
    private var list: ArrayList<Logos> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_recycler_view)
        supportActionBar?.title = "My Recycler View"

        rv_logos.setHasFixedSize(true)

        list.addAll(LogosData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rv_logos.layoutManager = LinearLayoutManager(this)
        val listLogosAdapter = ListLogosAdapter(list)
        rv_logos.adapter = listLogosAdapter
    }

    private fun showRecyclerGrid(){
        rv_logos.layoutManager = GridLayoutManager(this, 2)
        val GridLogosAdapter = GridLogosAdapter (list)
        rv_logos.adapter = GridLogosAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_grid -> {
                showRecyclerGrid()
            }

            R.id.action_CardView -> {

            }
        }
    }
}