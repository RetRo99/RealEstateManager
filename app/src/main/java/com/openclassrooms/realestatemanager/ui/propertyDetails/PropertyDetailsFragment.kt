package com.openclassrooms.realestatemanager.ui.propertyDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PropertyDetailsFragment : DaggerFragment(), PropertyDetailsView {

    private val args: PropertyDetailsFragmentArgs by navArgs()


    @Inject
    lateinit var presenter: PropertyDetailsPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated(args.id)
    }

}