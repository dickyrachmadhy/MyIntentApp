package com.example.biznetcustomercare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_list_agent_cc.setOnClickListener{
        val moveIntentListAgentCustomerCare = Intent (this@MainActivity, ListAgentCustomerCare::class.java)
        startActivity(moveIntentListAgentCustomerCare)
        }
    }
}