package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import io.reactivex.Completable
import io.reactivex.Single

interface PropertyRepository{

    fun getProperties(): Single<List<UiPropertyDetail>>
    fun addProperty(property: UiPropertyDetail): Completable
    fun updateProperty(property: UiPropertyDetail): Completable
    fun getProperty(id: Int): Single<UiPropertyDetail>
}
