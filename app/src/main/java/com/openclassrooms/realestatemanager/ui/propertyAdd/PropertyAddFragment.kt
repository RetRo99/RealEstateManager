package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.adapter.UriAdapter
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_add.*
import javax.inject.Inject


class PropertyAddFragment : DaggerFragment(), PropertyAddView {

    private val args: PropertyAddFragmentArgs by navArgs()

    @Inject
    lateinit var presenter: PropertyAddPresenter

    private lateinit var adapter: UriAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddProperty.setOnClickListener {
            presenter.onAddPropertyClicked()
        }

        btnAddPhoto.setOnClickListener {
            presenter.onAddPhotoClicked()
        }

        adapter = UriAdapter {
            presenter.onRemovePhotoClicked(it)
        }
        rvPhotos.adapter = adapter

        presenter.onViewCreated(args.id)

    }

    override fun setPhotos(photos: List<String>) {
        adapter.setData(photos)
    }

    override fun showToast(msg: Int) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun showImageDialog() {

        val setup = PickSetup()
            .setTitle("Pick Your image")


        PickImageDialog.build(setup)
            .setOnPickResult {
                presenter.onImagePicked(it)
            }
            .show(parentFragmentManager)
    }

    override fun setItem(property: UiPropertyDetail) {

        property.run {
            etAgentName.setText(agentName)
            etSurface.setText(surface.toString())
            etRooms.setText(numberOfRooms.toString())
            etDescription.setText(description)
            etNumber.setText(address.substringBefore(" "))
            etStreet.setText(address.substringAfter(" ").substringBefore(","))
            etPostCode.setText(address.substringAfter(",").substringBefore(" "))
            etCity.setText(address.substringAfterLast(" "))
            etPrice.setText(price.toString())
            setInterestPoints(interestPoints)
        }


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

    override fun clearErrors() {
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

    override fun checkIfFilled() {
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

        val address = "${etNumber.text} ${etStreet.text},\n${etStreet.text} ${etCity.text}"
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

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
