package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface PropertyRepository{

    fun getProperties(): Observable<List<UiPropertyDetail>>
    fun addProperty(property: UiPropertyDetail): Completable
    fun updateProperty(property: UiPropertyDetail): Completable
    fun getProperty(id: Int): Single<UiPropertyDetail>
    fun getSearchProperties(searchParams: PropertySearchParams): Observable<List<UiPropertyDetail>>
}
