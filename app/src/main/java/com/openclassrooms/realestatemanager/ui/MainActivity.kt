package com.openclassrooms.realestatemanager.ui

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerAppCompatActivity

// it referenced view in second activity
//had to transform quantity to string


class MainActivity : DaggerAppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isTablet = resources.getBoolean(R.bool.isTablet)

        val isLandscape = resources.configuration.orientation  == Configuration.ORIENTATION_LANDSCAPE


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

    }

}

