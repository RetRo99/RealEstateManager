package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.Address
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_add.*
import javax.inject.Inject

class PropertyAddFragment : DaggerFragment(), PropertyAddView {

    private val args: PropertyAddFragmentArgs by navArgs()

    @Inject
    lateinit var presenter: PropertyAddPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnAddProperty.setOnClickListener {
            clearErrors()
            checkIfFilled()
        }

        presenter.onViewCreated(args.id)


    }

    override fun setItem(property: UiPropertyDetail) {
        etAgentName.setText(property.agentName.toString())
        etSurface.setText(property.surface.toString())
        etRooms.setText(property.numberOfRooms.toString())
        etDescription.setText(property.description.toString())
        etNumber.setText(property.address.number.toString())
        etStreet.setText(property.address.street.toString())
        etPostCode.setText(property.address.postalCode.toString())
        etCity.setText(property.address.city.toString())
        etPrice.setText(property.price.toString())

        setInterestPoints(property.interestPoints)

    }

    private fun setInterestPoints(interestPoints: List<String>) {
        val checkBoxes = mutableListOf<CheckBox>()
        checkBoxes.add(rbSchool)
        checkBoxes.add(rbPark)
        checkBoxes.add(rbStores)
        checkBoxes.add(rbTransport)
        checkBoxes.add(rbDoctor)
        checkBoxes.add(rbHobbies)

        checkBoxes.forEach {
            it.isChecked = (it.text in interestPoints)
        }


    }

    private fun clearErrors() {
        layoutAgentName.isErrorEnabled = false


        layoutSurface.isErrorEnabled = false

        layoutRooms.isErrorEnabled = false

        layoutDescription.isErrorEnabled = false

        layoutNumber.isErrorEnabled = false

        layoutStreet.isErrorEnabled = false

        layoutPostCode.isErrorEnabled = false

        layoutPrice.isErrorEnabled = false

        layoutCity.isErrorEnabled = false
    }

    private fun checkIfFilled() {
        val errorMsg = getString(R.string.error_missing_info)
        when {
            etAgentName.text!!.isEmpty() -> {
                layoutAgentName.error = errorMsg

            }
            etSurface.text!!.isEmpty() -> {
                layoutSurface.error = errorMsg

            }
            etRooms.text!!.isEmpty() -> {
                layoutRooms.error = errorMsg

            }
            etDescription.text!!.isEmpty() -> {
                layoutDescription.error = errorMsg

            }
            etNumber.text!!.isEmpty() -> {
                layoutNumber.error = errorMsg

            }
            etStreet.text!!.isEmpty() -> {
                layoutStreet.error = errorMsg

            }
            etPostCode.text!!.isEmpty() -> {
                layoutPostCode.error = errorMsg

            }
            etCity.text!!.isEmpty() -> {
                layoutCity.error = errorMsg

            }
            etPrice.text!!.isEmpty() -> {
                layoutPrice.error = errorMsg

            }
            else -> {
                getPropertyFromUi()
            }
        }
    }

    private fun getPropertyFromUi() {

        getInterestPoints()

        val address = Address(
            etNumber.text.toString(),
            etStreet.text.toString(),
            etPostCode.text.toString().toInt(),
            etCity.text.toString()
        )
        val interestPoints = getInterestPoints()

        val type =
            resources.getStringArray(R.array.property_type_array)[spinnerType.selectedItemPosition]

        val property = UiPropertyDetail(
            type,
            etAgentName.text.toString(),
            etSurface.text.toString().toDouble(),
            etRooms.text.toString().toDouble(),
            etDescription.text.toString(),
            etPrice.text.toString().toDouble(),
            address,
            interestPoints
        )

        presenter.onAddProperty(property)
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
