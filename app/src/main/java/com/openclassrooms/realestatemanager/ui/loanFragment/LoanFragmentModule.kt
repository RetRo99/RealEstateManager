package com.openclassrooms.realestatemanager.ui.loanFragment

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module

@Module
interface LoanFragmentModule {
    @Binds
    fun bindView(fragment: LoanFragment): LoanFragmentView

    @Binds
    fun bindPresenter(presenterImpl: LoanFragmentPresenterImpl): LoanFragmentPresenter

    @Binds
    fun bindFragment(fragment: LoanFragment): Fragment
}
