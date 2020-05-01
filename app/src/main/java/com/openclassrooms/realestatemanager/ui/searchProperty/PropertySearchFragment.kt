package com.openclassrooms.realestatemanager.ui.searchProperty

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_search.*
import kotlinx.android.synthetic.main.fragment_property_search.rbDoctor
import kotlinx.android.synthetic.main.fragment_property_search.rbHobbies
import kotlinx.android.synthetic.main.fragment_property_search.rbPark
import kotlinx.android.synthetic.main.fragment_property_search.rbSchool
import kotlinx.android.synthetic.main.fragment_property_search.rbStores
import kotlinx.android.synthetic.main.fragment_property_search.rbTransport
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class PropertySearchFragment : DaggerFragment(), PropertySearchView {

    @Inject
    lateinit var presenter: PropertySearchPresenter

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

        btnSearch.setOnClickListener {
            presenter.onSearchClicked()
        }

    }

    override fun getSearchParams(): PropertySearchParams {
        val type =
            resources.getStringArray(R.array.property_type_array)[typeSpinner.selectedItemPosition]
        val interestPoints = getInterestPoints()

        return PropertySearchParams(
            type,
            etSurfaceMin.text.toString(),
            etSurfaceMax.text.toString(),
            interestPoints,
            etMinDate.text.toString(),
            etMaxDate.text.toString(),
            etCity.text.toString(),
            spinnerPhotos.selectedItemPosition + 1,
            etPriceMax.text.toString(),
            etPriceMin.text.toString(),
            rbIncludeSold.isChecked

        )
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

    private fun getInterestPoints(): List<String> {
        val checkBoxes = mutableListOf<CheckBox>()
        checkBoxes.add(rbSchool)
        checkBoxes.add(rbPark)
        checkBoxes.add(rbStores)
        checkBoxes.add(rbTransport)
        checkBoxes.add(rbDoctor)
        checkBoxes.add(rbHobbies)

        return checkBoxes.filter {
            it.isChecked
        }.map {
            it.text.toString()
        }
    }

}
