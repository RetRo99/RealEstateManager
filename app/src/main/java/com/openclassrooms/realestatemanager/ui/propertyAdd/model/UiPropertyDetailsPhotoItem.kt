package com.openclassrooms.realestatemanager.ui.propertyAdd.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UiPropertyDetailsPhotoItem(val photo: String, val title: String)
