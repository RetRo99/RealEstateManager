package com.openclassrooms.realestatemanager.ui.loanFragment

import androidx.annotation.StringRes

interface LoanFragmentView {
    fun setupListener()
    fun setAmounts(amounts: Pair<String, String>)
    fun showToast(@StringRes msg: Int)
}
