package com.openclassrooms.realestatemanager.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.LocationPermissionActivity
import com.openclassrooms.realestatemanager.ui.map.MapFragmentDirections
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

// it referenced view in second activity
//had to transform quantity to string


class MainActivity : LocationPermissionActivity(), NavigationView.OnNavigationItemSelectedListener,
    MainView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isTablet = resources.getBoolean(R.bool.isTablet)

        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

        setSupportActionBar(toolbar)


        when {
            isTablet || isLandscape -> {
                // todo handle landscape
                Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_main)
            }
            else -> {
                Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_main)
            }
        }

        setSupportActionBar(toolbar)
        setupNavigation()
    }

    private fun setupNavigation() {
        val appBarConfiguration = AppBarConfiguration.Builder(
            setOf(
                R.id.navigation_map,
                R.id.navigation_list
            )
        ).setDrawerLayout(drawer_layout).build()

        toolbar.setupWithNavController(getNavController(), appBarConfiguration)

        navigationView.setNavigationItemSelectedListener(this)

        NavigationUI.setupWithNavController(bottomNavigationView, getNavController())
    }

    override fun fromMapToDetails(id: String) {
       getNavController().navigate(MapFragmentDirections.actionToDetails(id))
    }

    override fun fromListToDetails(id: String) {
        getNavController().navigate(PropertyListFragmentDirections.actionToDetails(id))
    }

    override fun requestLocation() {
        // TODO not implemented
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
