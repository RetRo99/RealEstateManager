package com.openclassrooms.realestatemanager.ui.searchResult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragmentArgs
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchResultFragment : DaggerFragment(),SearchResultView {

    private val args: SearchResultFragmentArgs by navArgs()


    @Inject
    lateinit var presenter:SearchResultPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated(args.searchParams)
    }

}
