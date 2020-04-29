package com.openclassrooms.realestatemanager.widget

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.widget.doOnTextChanged
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.hideKeyboard
import com.openclassrooms.realestatemanager.showKeyboard
import kotlinx.android.synthetic.main.view_search_widget.view.*

class SearchWidget(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    init {
        View.inflate(context, R.layout.view_search_widget, this)
        search_close_btn.setOnClickListener {
            search_edittext.text = SpannableStringBuilder("")
            visibility = View.INVISIBLE
        }
    }

    fun doOnTextChanged(
        action: (
            text: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) -> Unit
    ) {
        search_edittext.doOnTextChanged(action)

    }

    override fun setVisibility(visibility: Int) {
        search_holder.visibility = visibility
        if (visibility == View.VISIBLE) {
            isClickable = true
            isFocusable = true
            search_edittext.showKeyboard()
        } else {
            isClickable = false
            isFocusable = false
            hideKeyboard()
        }
    }

}

