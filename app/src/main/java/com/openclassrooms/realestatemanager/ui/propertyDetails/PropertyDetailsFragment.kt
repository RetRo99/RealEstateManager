package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.adapter.PhotoAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_details.*
import javax.inject.Inject

class PropertyDetailsFragment : DaggerFragment(), PropertyDetailsView {

    private val args: PropertyDetailsFragmentArgs by navArgs()


    @Inject
    lateinit var presenter: PropertyDetailsPresenter

    private lateinit var adapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_details, container, false)
    }

    override fun showContent() {
        contentHolder.isVisible = true
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PhotoAdapter(false)
        presenter.onViewCreated(args.id)
    }

    override fun setPhotos(photos: List<String>) {
        rvHolder.visibility = View.VISIBLE
        rvPhotos.adapter = adapter
        adapter.setData(photos)
    }


    override fun setItem(property: UiPropertyDetail) {
        property.run {
            tvType.text = type
            tvAgentType.text = agentName
            tvSurface.text = surface.toString()
            tvNumberOfRooms.text = numberOfRooms.toString()
            tvPrice.text = price.toString()
            tvDescription.text = description
            tvAddress.text = address
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
