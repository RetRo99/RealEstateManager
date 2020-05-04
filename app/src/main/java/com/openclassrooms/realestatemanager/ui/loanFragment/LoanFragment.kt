package com.openclassrooms.realestatemanager.ui.loanFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.openclassrooms.realestatemanager.R
import com.pouriahemati.thousandseparatorsedittext.NumberTextWatcher
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_loan.*
import java.text.DecimalFormat
import javax.inject.Inject

class LoanFragment : DaggerFragment(), LoanFragmentView {

    @Inject
    lateinit var presenter: LoanFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()
    }

    override fun setupListener() {
        tvYearsTotal.text = resources.getQuantityString(R.plurals.interest_rate_years, 1, 1)


        etLoanInterest.doOnTextChanged { text, _, _, _ ->
            if (text.toString().isNotEmpty() && etTotalAmount.text.toString().isNotEmpty()) {
                presenter.onDataChanged(
                    yearSlider.progress,
                    text.toString().toDouble(),
                    etTotalAmount.text.toString().toDouble()
                )
            }

            etTotalAmount.doOnTextChanged { text, start, count, after ->
                if (text.toString().isNotBlank() && etLoanInterest.text.toString().isNotBlank()) {
                    presenter.onDataChanged(
                        yearSlider.progress,
                        etLoanInterest.text.toString().toDouble(),
                        text.toString().toDouble()
                    )
                }
            }


            yearSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    if (etLoanInterest.text.toString().isBlank() || etTotalAmount.text.toString().isBlank()) {
                        showToast(R.string.interest_no_data)
                    } else {
                        val years =
                            resources.getQuantityString(R.plurals.interest_rate_years, i, i)
                        tvYearsTotal.text = years

                        presenter.onDataChanged(
                            i,
                            etLoanInterest.text.toString().toDouble(),
                            etTotalAmount.text.toString().toDouble()
                        )
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                }
            })
        }
    }


    override fun setAmounts(amounts: Pair<String, String>) {
        tvTotal.text = amounts.first
        tvPerMonth.text = amounts.second
    }

    override fun showToast(msg: Int) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }
}
