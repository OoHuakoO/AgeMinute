package com.example.ageminute

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener{view ->
            clickDatePicker(view)

        }

    }
    fun clickDatePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
     val dpf =   DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                view, selectedyear, selectedmonth, selecteddayOfMonth ->
            Toast.makeText(this,"The Chosen year is $selectedyear ,the month" +
                    "is $selectedmonth and the day is $selecteddayOfMonth",Toast.LENGTH_LONG).show()
                val selectedDate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
                tvSelectedDate.setText(selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)
                val selectedDateInMinute = theDate!!.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinute = currentDate!!.time / 60000
                val differenceInMinute = currentDateInMinute - selectedDateInMinute
                tvSelectedDateInminute.setText(differenceInMinute.toString())
        },year,month,day)
        dpf.datePicker.setMaxDate(Date().time -86400000)
        dpf.show()


    }
}