package com.example.doctorappointment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import android.widget.*

class EventDialog :DialogFragment(R.layout.dialog_event){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cancelBT :Button= view.findViewById(R.id.cancelBT)
        val addBT :Button = view.findViewById(R.id.addBT)
        val eventText :EditText = view.findViewById(R.id.eventET)
        cancelBT.setOnClickListener {
            dismiss()
        }
        addBT.setOnClickListener {
            val m1:MainActivity = getActivity() as MainActivity
            m1.receiveFeedback(eventText.text.toString(), m1.currentDay, m1.currentMonth)
            dismiss()
        }

    }
}