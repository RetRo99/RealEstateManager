package com.openclassrooms.realestatemanager.database.converters

import androidx.room.TypeConverter
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class PhotoConverter {
    private val moshi: Moshi = Moshi.Builder().build()
    private val listType =
        Types.newParameterizedType(List::class.java, UiPropertyDetailsPhotoItem::class.java)
    private val adapter: JsonAdapter<List<UiPropertyDetailsPhotoItem>> = moshi.adapter(listType)

    @TypeConverter
    fun fromString(moshiString: String): List<UiPropertyDetailsPhotoItem> {
        val adapter: JsonAdapter<List<UiPropertyDetailsPhotoItem>> = moshi.adapter(listType)
        return adapter.fromJson(moshiString)!!
    }

    @TypeConverter
    fun toString(photos: List<UiPropertyDetailsPhotoItem>): String {
        return adapter.toJson(photos)
    }


}
