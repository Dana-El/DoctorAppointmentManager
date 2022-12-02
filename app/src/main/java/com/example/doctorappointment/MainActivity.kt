package com.example.doctorappointment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
   public var dates = mutableMapOf<String, MutableList<TextView>>()
    lateinit var displayedDate :String
    public var currentMonth : String="test"
     var currentDay : String="test"
    fun receiveFeedback(feedback:String, currentDayy: String, currentMonthh:String){

         val  layout:LinearLayout = findViewById<LinearLayout>(R.id.linearScroll)
//
         val eventText :TextView= TextView(applicationContext)
        eventText.text = feedback
//        //addToView(eventText)
        eventText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100)
         layout?.addView(eventText)
        var key:String = currentDayy + currentMonthh
        println(key)
        if(dates[key]?.last() == null)
        dates[key] = emptyList<TextView>().toMutableList()
        dates[key]?.add(eventText)

        println(dates)
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calendarView :CalendarView = findViewById(R.id.calendarView)
        val selectedDate : TextView = findViewById(R.id.myDate)
        val addEvent :TextView = findViewById(R.id.addEvent)
        calendarView.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                displayedDate = (dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                selectedDate.setText(displayedDate)
                currentMonth = (month+1).toString()
                currentDay = dayOfMonth.toString()


               val  layout:LinearLayout = findViewById<LinearLayout>(R.id.linearScroll)
                layout.removeAllViews();
                var s :String = currentDay+currentMonth
                println(dates[s])

                dates[s]?.forEach{
                    i->layout.addView(i)
                }


            })



        addEvent.setOnClickListener {
            var dialog_var = EventDialog()
            dialog_var.show(supportFragmentManager,"Event Dialog")
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if( item.itemId == R.id.item1){
            var dialog_var = AllEventsDialog()
            dialog_var.show(supportFragmentManager,"All Events Dialog")
        }
        return super.onOptionsItemSelected(item)
    }

}