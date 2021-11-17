package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import android.widget.Toast




class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val city = intent.extras!!.getString("City")
        val date = intent.extras!!.getString("Date")
        val hotel = intent.extras!!.getString("Hotel")
        val countPeople = intent.extras!!.getString("Count People")

        enterCity.text = city
        enterDate.text = date
        enterHotel.text = hotel
        enterCountPeople.text = countPeople
    }

    fun save(view: View){

        val enterBtn = Intent(this, ThirdActivity::class.java)
        val text = "Підтведіть, чи все правильно?"
        val toast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        if(enterTrue.isChecked == true){
            startActivity(enterBtn)
        }else{
            toast.show()
        }
    }
}