package com.openclassrooms.realestatemanager.ui

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavGraph
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.base.LocationPermissionActivity
import com.openclassrooms.realestatemanager.ui.blankFragment.BlankFragment
import com.openclassrooms.realestatemanager.ui.blankFragment.BlankFragmentDirections
import com.openclassrooms.realestatemanager.ui.map.MapFragmentDirections
import com.openclassrooms.realestatemanager.ui.propertyDetails.PropertyDetailsFragmentDirections
import com.openclassrooms.realestatemanager.ui.propertyList.PropertyListFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


// it referenced view in second activity
//had to transform quantity to string

class MainActivity : LocationPermissionActivity(), NavigationView.OnNavigationItemSelectedListener,
    MainView {

    @Inject
    lateinit var presenter: MainViewPresenter

    private var isLandscapeLayout: Boolean = false

    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        isLandscapeLayout =
            resources.getBoolean(R.bool.isTablet) || resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE



        when {
            isLandscapeLayout -> {
                Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_main_landscape)
                setupLandScapeNavigationListener()

            }
            else -> {
                Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
                setContentView(R.layout.activity_main)
                setupPortraitNavigationListener()
            }
        }



        setSupportActionBar(toolbar)
        setupNavigation()
    }

    private fun setupPortraitNavigationListener() {
        getNavController().addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.visibility = when (destination.id) {
                R.id.navigation_map,
                R.id.navigation_list -> View.VISIBLE
                else -> View.GONE
            }
        }
    }

    private fun setupLandScapeNavigationListener() {
        getNavController().addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.propertyDetailsFragment -> {
                    menu?.let {
                        it.clear()
                        menuInflater.inflate(R.menu.top_search_add_edit, menu)
                    }
                }
                else -> {
                    menu?.let {
                        it.clear()
                        menuInflater.inflate(R.menu.top_search_add, menu)

                    }
                }
            }
        }
    }

    private fun setupNavigation() {
        val navGraph: NavGraph = getNavController().navInflater.inflate(R.navigation.nav_graph)
        val appBarConfiguration: AppBarConfiguration

        if (!isLandscapeLayout) {
            navGraph.startDestination = R.id.navigation_list


            appBarConfiguration = AppBarConfiguration.Builder(
                setOf(
                    R.id.navigation_map,
                    R.id.navigation_list
                )
            ).setDrawerLayout(drawer_layout).build()
            toolbar.setupWithNavController(getNavController(), appBarConfiguration)

        } else {
            appBarConfiguration = AppBarConfiguration.Builder(
                setOf(
                    R.id.navigation_map,
                    R.id.navigation_list,
                    R.id.propertyDetailsFragment,
                    R.id.navigation_add,
                    R.id.navigation_search,
                    R.id.blankFragment
                )
            ).setDrawerLayout(drawer_layout).build()
            navGraph.startDestination = R.id.blankFragment
        }

        getNavController().graph = navGraph

        if (getCurrentDestinationId() == R.id.navigation_list) getNavController().navigateUp()
        if (getCurrentDestinationId() == R.id.blankFragment) getNavController().navigateUp()

        toolbar.setupWithNavController(getNavController(), appBarConfiguration)

        navigationView.setNavigationItemSelectedListener(this)

        NavigationUI.setupWithNavController(bottomNavigationView, getNavController())


    }

    override fun fromMapToDetails(id: Int) {
        currentId = id
        getNavController().navigate(MapFragmentDirections.actionToDetails(id))
    }

    override fun fromListToDetails(id: Int) {
        if (getCurrentDestinationId() != R.id.propertyDetailsFragment) {
            currentId = id
            getNavController().navigate(PropertyListFragmentDirections.actionToDetails(id))
        } else if (currentId != id) {
            currentId = id
            getNavController().navigateUp()
            getNavController().navigate(PropertyListFragmentDirections.actionToDetails(id))

        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun navigateBack() {
        getNavController().navigateUp()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_edit -> handleEdit()
        }
        return item.onNavDestinationSelected(getNavController()) || super.onOptionsItemSelected(item)
    }

    private fun handleEdit() {
        when (getCurrentDestinationId()) {
            R.id.propertyDetailsFragment -> {
                getNavController().navigate(PropertyDetailsFragmentDirections.actionToEdit(currentId))
            }
        }

    }

    private fun getCurrentDestinationId(): Int? {
        return getNavController().currentDestination?.id
    }

    companion object {
        var currentId: Int = 0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_search_add, menu)
        this.menu = menu
        return true
    }
}

