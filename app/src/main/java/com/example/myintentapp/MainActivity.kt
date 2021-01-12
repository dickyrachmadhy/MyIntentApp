package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity.setOnClickListener {

            val moveIntent = Intent (this@MainActivity, MoveActivity::class.java)
            startActivity(moveIntent)

        }

        btn_move_activity_data.setOnClickListener  {
            val moveWithDataIntent = Intent (this@MainActivity, MoveWithDataActivity::class.java )
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicky Rachmadi")
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 27)
            startActivity(moveWithDataIntent)
        }

        btn_dial_number.setOnClickListener {
            val myPhoneNumber = "087775760360"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$myPhoneNumber"))
            startActivity(dialPhoneIntent)
        }

        btn_MyRecylerView.setOnClickListener {
            val moveIntentRecyclerView = Intent (this@MainActivity, MyRecyclerView::class.java)
            startActivity(moveIntentRecyclerView)
        }

        btn_move_activity_object.setOnClickListener {

            val person = Person(
                "Dicky Rachmadi",
                27,
                "dicky_rachmadi@biznetnetworks.com",
                "Jakarta"
            )

            val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObject::class.java)
            moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }

        btn_custom_view.setOnClickListener{
            val moveCustomView = Intent(this@MainActivity, ViewModelActivity::class.java)
            startActivity(moveCustomView)
        }

        supportActionBar?.title = "Menu Module Belajar"

    }


}
