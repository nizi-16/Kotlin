package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker = findViewById(R.id.btnDatePicker) as Button
        btnDatePicker.setOnClickListener{view->
            clickDatePicker(view)
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view:View){
        val myCalendar= Calendar.getInstance()
        val year= myCalendar.get(Calendar.YEAR)
        val month= myCalendar.get(Calendar.MONTH)
        val day= myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
            view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this,
                    "The chosen year is $selectedyear,the month is $selectedmonth and the day is $selecteddayOfMonth",
                    Toast.LENGTH_LONG).show()
            val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            val tvSelectedDate=findViewById(R.id.tvSelectedDate) as TextView
            tvSelectedDate.setText(selectedDate)
            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val selectedDateInMinutes=theDate!!.time/60000
            val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes=currentDate!!.time/60000
            val differenceInMinutes=currentDateInMinutes-selectedDateInMinutes
            val tvSelectedDateInMinutes=findViewById(R.id.tvSelectedDateInMinutes) as TextView
            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
        },year,month,day).show()
    }
}