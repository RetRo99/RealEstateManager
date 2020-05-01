package com.openclassrooms.realestatemanager.ui.searchResult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragmentArgs
import com.openclassrooms.realestatemanager.ui.propertyList.adapter.PropertyAdapter
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_search_result.*
import javax.inject.Inject

class SearchResultFragment : DaggerFragment(),SearchResultView {

    private val args: SearchResultFragmentArgs by navArgs()


    @Inject
    lateinit var presenter:SearchResultPresenter

    private lateinit var adapter: PropertyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PropertyAdapter{
            presenter.onProperyClicked(it)
        }
        rvSearchResult.adapter = adapter

        presenter.onViewCreated(args.searchParams)
    }

    override fun setData(data: List<UiProperty>) {
        adapter.setData(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showToast(msg: Int) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}
