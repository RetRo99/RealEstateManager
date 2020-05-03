package com.openclassrooms.realestatemanager.ui.photoFragment

import androidx.fragment.app.Fragment
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddPresenterImpl
import com.openclassrooms.realestatemanager.ui.propertyAdd.PropertyAddView
import dagger.Binds
import dagger.Module

@Module
interface PhotoFragmentModule {

    @Binds
    fun bindView(fragment: PhotoFragment): PhotoFragmentView

    @Binds
    fun bindPresenter(presenterImpl: PhotoFragmentPresenterImpl): PhotoFragmentPresenter

    @Binds
    fun bindFragment(fragment: PhotoFragment): Fragment
}
