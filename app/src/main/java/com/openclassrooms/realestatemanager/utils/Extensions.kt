package com.openclassrooms.realestatemanager.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.openclassrooms.realestatemanager.base.Constants
import java.net.URLEncoder

fun ImageView.loadMap(lat: Double, lng: Double) {
    val urlLocation = URLEncoder.encode("$lat,$lng", "UTF-8")
    Glide.with(this)
        .load("https://maps.googleapis.com/maps/api/staticmap?center=$urlLocation&zoom=13&size=700x500&markers=color:red%7label:C%7C$urlLocation&maptype=roadmap&key=${Constants.GOOGLE_KEY}")
        .into(this)


}

fun View.showKeyboard() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)

}

