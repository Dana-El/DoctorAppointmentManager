package com.example.doctorappointment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import android.widget.*


class AllEventsDialog :DialogFragment(R.layout.dialog_all_events){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.button)
        val m1:MainActivity = getActivity() as MainActivity
        var date= m1.dates
        date.forEach {
                entry -> for (i in date[entry.key]!!){
                 val  layout:LinearLayout = view.findViewById<LinearLayout>(R.id.eventslayout)
//
            val eventText :TextView= TextView(m1.applicationContext)
            eventText.text = i.text
//        //addToView(eventText)
            eventText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100)
            layout?.addView(eventText)
                }

        }

        cancelbt.setOnClickListener {
            dismiss()
        }
        super.onViewCreated(view, savedInstanceState)
    }



}