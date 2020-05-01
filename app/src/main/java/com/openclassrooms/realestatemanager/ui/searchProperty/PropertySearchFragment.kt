package com.openclassrooms.realestatemanager.ui.searchProperty

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_search.*
import java.text.SimpleDateFormat
import java.util.*

class PropertySearchFragment : DaggerFragment(), PropertySearchView {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etMinDate.setOnClickListener { view ->
            showDatePickerDialog {
                updateCalendarEditText(it, view)
            }
        }

        etMaxDate.setOnClickListener { view ->
            showDatePickerDialog {
                updateCalendarEditText(it, view)
            }
        }

        etDateSold.setOnClickListener { view ->
            showDatePickerDialog {
                updateCalendarEditText(it, view)
            }
        }

    }



    private fun updateCalendarEditText(calendar: Calendar, view: View) {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        (view as EditText).setText(sdf.format(calendar.time))
    }



    private fun showDatePickerDialog(onDateSetAction: (Calendar) -> Unit) {
        val calendar = Calendar.getInstance()

        val listener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.apply {
                set(Calendar.YEAR, year)
                set(Calendar.MONTH, monthOfYear)
                set(Calendar.DAY_OF_MONTH, dayOfMonth)

            }
            onDateSetAction(calendar)
        }

        DatePickerDialog(
            requireContext(), listener, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()

    }

}
