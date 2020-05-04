package com.openclassrooms.realestatemanager.ui.loanFragment

interface LoanFragmentPresenter {
    fun onViewCreated()
    fun onDataChanged(years: Int, interest: Double, amount: Double)
}
