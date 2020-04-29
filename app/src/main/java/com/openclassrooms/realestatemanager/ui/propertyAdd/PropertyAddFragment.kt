package com.openclassrooms.realestatemanager.ui.propertyAdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerFragment

class PropertyAddFragment : DaggerFragment(), PropertyAddView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_add, container, false)
    }

}
