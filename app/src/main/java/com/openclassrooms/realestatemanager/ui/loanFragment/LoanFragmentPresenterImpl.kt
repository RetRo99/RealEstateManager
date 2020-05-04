package com.openclassrooms.realestatemanager.ui.loanFragment

import com.openclassrooms.realestatemanager.utils.Utils
import javax.inject.Inject
import kotlin.math.pow

class LoanFragmentPresenterImpl @Inject constructor(
    private val view: LoanFragmentView

):LoanFragmentPresenter {

    override fun onViewCreated() {
       view.setupListener()
    }

    override fun onDataChanged(years: Int, interest: Double, amount: Double) {
        val totalAmount = amount * (1 + interest / 100.toDouble()).pow(years)
        val totalMonth = years * 12
        val perMonth = totalAmount/totalMonth
        view.setAmounts(Pair(Utils.getEurCurrencyString(totalAmount), Utils.getEurCurrencyString(perMonth)))
    }
}
