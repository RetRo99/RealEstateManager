package com.openclassrooms.realestatemanager.ui.propertyList

import android.os.Bundle
import android.view.*
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.BaseToolbarFragment
import com.openclassrooms.realestatemanager.ui.propertyList.adapter.PropertyAdapter
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import kotlinx.android.synthetic.main.fragment_property_list.*
import javax.inject.Inject

class PropertyListFragment : BaseToolbarFragment(), PropertyListView {

    @Inject
    lateinit var presenter: PropertyListPresenter

    private lateinit var adapter: PropertyAdapter

    override fun provideMenuRes(): Int = R.menu.top_search_add


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_property_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PropertyAdapter{
            presenter.onProperyClicked(it)
        }

        rvPropertyList.adapter = adapter

        presenter.onViewCreated()
    }

    override fun setData(data: List<UiProperty>) {
        adapter.setData(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
