package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.BaseToolbarFragment
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.propertyAdd.adapter.UriAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_property_details.*
import javax.inject.Inject

class PropertyDetailsFragment : BaseToolbarFragment(), PropertyDetailsView {

    private val args: PropertyDetailsFragmentArgs by navArgs()


    @Inject
    lateinit var presenter: PropertyDetailsPresenter

    private lateinit var adapter : UriAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_details, container, false)
    }

    override fun provideMenuRes(): Int = R.menu.top_edit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UriAdapter(false)
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
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
