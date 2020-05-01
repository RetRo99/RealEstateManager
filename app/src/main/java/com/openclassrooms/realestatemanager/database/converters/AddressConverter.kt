package com.openclassrooms.realestatemanager.database.converters

import androidx.room.TypeConverter
import com.openclassrooms.realestatemanager.base.model.Address
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class AddressConverter {

    @TypeConverter
    fun fromString(moshiString: String): Address {
         val moshi: Moshi = Moshi.Builder()
             .build()
         val adapter: JsonAdapter<Address> = moshi.adapter(Address::class.java)
        return adapter.fromJson(moshiString)!!
    }

    @TypeConverter
    fun toString(address: Address): String {
         val moshi: Moshi = Moshi.Builder().build()
         val adapter: JsonAdapter<Address> = moshi.adapter(Address::class.java)
        return adapter.toJson(address)
    }


}
