package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.view.*
import java.lang.String.format
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.time.days

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dateTv.setOnClickListener{
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                dateTv.text = ""+ mDay +"/"+ (mMonth + 1) +"/" + mYear
            }, year, month, day)
            dpd.datePicker.minDate = Calendar.getInstance().timeInMillis
            dpd.show()

        }


        val cityName = arrayOf("Миколаїв", "Одеса", "Київ", "Херсон")
        val arrayAdapterCity = ArrayAdapter(this, android.R.layout.simple_spinner_item, cityName)

        spinner_city.adapter = arrayAdapterCity

        spinner_city.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                cityResult.text = cityName[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val nameHotel = arrayOf("Ukraina", "Ararara", "Tukituki", "Salam")
        val arrayAdapterHotel = ArrayAdapter(this, android.R.layout.simple_spinner_item, nameHotel)

        spinner_name_hotel.adapter = arrayAdapterHotel

        spinner_name_hotel.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                hotelResult.text = nameHotel[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val countPeople = arrayOf("1", "2", "3", "4", "5")
        val arrayAdapterPeople = ArrayAdapter(this, android.R.layout.simple_spinner_item, countPeople)

        spinner_people_count.adapter = arrayAdapterPeople

        spinner_people_count.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                countPeopleResult.text = countPeople[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
    fun enterOll(view: View){
        val enterBtn = Intent(this, SecondActivity::class.java)

        val enterCity = cityResult.text.toString()
        val enterDate = dateTv.text.toString()
        val enterHotel = hotelResult.text.toString()
        val enterCountPeople = countPeopleResult.text.toString()

        enterBtn.putExtra("City", enterCity)
        enterBtn.putExtra("Date", enterDate)
        enterBtn.putExtra("Hotel", enterHotel)
        enterBtn.putExtra("Count People", enterCountPeople)


        startActivity(enterBtn)
    }

}

private operator fun LocalDateTime.compareTo(validate: TextView?): Int {
    TODO("Not yet implemented")
}
