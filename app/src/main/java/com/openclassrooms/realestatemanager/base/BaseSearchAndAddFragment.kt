package com.openclassrooms.realestatemanager.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_map_view.*

abstract class BaseSearchAndAddFragment : DaggerFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_search_add, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_search) {
            autoSearch.visibility = View.VISIBLE
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
