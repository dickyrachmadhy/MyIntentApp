package com.example.biznetcustomercare

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about_profile.*

class AboutProfileActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_AGENT = "extra_agent"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_profile)
        supportActionBar?.title = "Profile Agent"

        val AgentReceived = intent.getParcelableExtra<Agent>(EXTRA_AGENT)
        val imgReceived = AgentReceived?.photo
        AgentReceived?.photo?.let { img_profile_received.setImageResource(it) }


        val textName = AgentReceived?.nama
        tv_name_received.text = textName

        val textEmail = AgentReceived?.email
        tv_email_received.text = textEmail

        val textNoTlp = AgentReceived?.no_tlp
        btn_no_tlp_received.text = textNoTlp

        btn_no_tlp_received.setOnClickListener{
            val dialPhoneAgent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$textNoTlp"))
            startActivity(dialPhoneAgent)
        }

        btn_share_contact.setOnClickListener{
            Toast.makeText(this@AboutProfileActivity,"Anda Berhasil Share Contact \n\n${textName}"+"\n" +
                    "  ${textEmail}\n  ${textNoTlp}", Toast.LENGTH_SHORT)
                .show()
        }
    }

}