package com.openclassrooms.realestatemanager.database.converters

import androidx.room.TypeConverter
import com.openclassrooms.realestatemanager.base.model.Address
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class AddressConverter {
   private  val moshi: Moshi = Moshi.Builder()
        .build()
   private  val adapter: JsonAdapter<Address> = moshi.adapter(Address::class.java)

    @TypeConverter
    fun fromString(moshiString: String): Address {
        return adapter.fromJson(moshiString)!!
    }

    @TypeConverter
    fun toString(address: Address): String {
        return adapter.toJson(address)
    }


}
