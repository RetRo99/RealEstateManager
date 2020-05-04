package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.Address
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.adapter.PhotoAdapter
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import com.openclassrooms.realestatemanager.utils.Utils
import com.openclassrooms.realestatemanager.utils.hideKeyboard
import com.openclassrooms.realestatemanager.utils.showKeyboard
import com.vansuita.pickimage.bean.PickResult
import com.vansuita.pickimage.bundle.PickSetup
import com.vansuita.pickimage.dialog.PickImageDialog
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_add.*
import javax.inject.Inject


class PropertyAddFragment : DaggerFragment(), PropertyAddView {

    private val args: PropertyAddFragmentArgs by navArgs()

    @Inject
    lateinit var presenter: PropertyAddPresenter

    private lateinit var adapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_add, container, false)
    }

    override fun showContent() {
        editHolder.isVisible = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddProperty.setOnClickListener {
            presenter.onAddPropertyClicked()
        }

        btnAddPhoto.setOnClickListener {
            presenter.onAddPhotoClicked()
        }

        adapter = PhotoAdapter(actionDelete = {
            presenter.onRemovePhotoClicked(it)
        })
        rvPhotos.adapter = adapter

        presenter.onViewCreated(args.id)

    }

    override fun setPhotos(photos: MutableList<UiPropertyDetailsPhotoItem>) {
        adapter.setData(photos)
    }

    override fun showToast(msg: Int) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun showImageDialog() {

        val setup = PickSetup()
            .setTitle(getString(R.string.dialog_photo))

        PickImageDialog.build(setup)
            .setOnPickResult {
                showImageTitleDialog(it)
            }
            .show(parentFragmentManager)
    }

    private fun showImageTitleDialog(result: PickResult) {

        val etPhotoTitle = EditText(requireContext()).apply {
            hint = "Enter Photo Title"
            maxLines = 1
        }
        val dialogLayout = FrameLayout(requireContext()).apply {
            setPaddingRelative(45, 15, 45, 0)
            addView(etPhotoTitle)
        }

        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setPositiveButton(getString(R.string.dialog_done), null)
            .setOnDismissListener {
                etPhotoTitle.hideKeyboard()
            }
            .setCancelable(false)
            .setView(dialogLayout)
            .create()

        dialog.setOnShowListener {
            etPhotoTitle.showKeyboard()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                if (etPhotoTitle.text.isBlank()) {
                    showToast(R.string.no_photo_title)
                } else {
                    presenter.onImagePicked(result, etPhotoTitle.text.toString())
                    dialog.dismiss()
                }
            }
        }
        dialog.show()

    }

    override fun setItem(property: UiPropertyDetail) {

        property.run {
            etAgentName.setText(agentName)
            etSurface.setText(surface)
            etRooms.setText(numberOfRooms)
            etDescription.setText(description)
            etNumber.setText(address.number)
            etStreet.setText(address.street)
            etPostCode.setText(address.postalCode)
            etCity.setText(address.city)
            etPrice.setText(price.toString())
            setInterestPoints(interestPoints)
        }

        btnAddProperty.setText(R.string.update_property)


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

    override fun validateData() {
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
            adapter.itemCount == 0 -> showToast(R.string.error_no_photo)
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
            etPostCode.text.toString(),
            etCity.text.toString()
        )
        val interestPoints = getInterestPoints()

        val type =
            resources.getStringArray(R.array.property_type_array)[spinnerType.selectedItemPosition]

        val property = UiPropertyDetail(
            type,
            etAgentName.text.toString(),
            etSurface.text.toString(),
            etRooms.text.toString(),
            etDescription.text.toString(),
            etPrice.text.toString().toDouble(),
            address,
            Utils.todayDate,
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
