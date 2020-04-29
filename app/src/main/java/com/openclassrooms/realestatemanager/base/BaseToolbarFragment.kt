package com.openclassrooms.realestatemanager.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import dagger.android.support.DaggerFragment

abstract class BaseToolbarFragment : DaggerFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

  abstract fun provideMenuRes() : Int


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(provideMenuRes(), menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}
