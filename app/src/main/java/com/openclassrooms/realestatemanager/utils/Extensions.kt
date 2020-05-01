package com.openclassrooms.realestatemanager.utils

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
