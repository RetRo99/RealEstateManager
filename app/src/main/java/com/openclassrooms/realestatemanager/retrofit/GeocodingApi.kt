package com.openclassrooms.realestatemanager.retrofit

import com.openclassrooms.realestatemanager.retrofit.response.GeocodeResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("json?")
    fun getLocation(@Query("address") address: String): Single<GeocodeResult>


}
