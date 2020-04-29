package com.openclassrooms.realestatemanager.ui

import android.os.Bundle
import com.openclassrooms.realestatemanager.R
import dagger.android.support.DaggerAppCompatActivity

// it referenced view in second activity
//had to transform quantity to string


class MainActivity : DaggerAppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}

