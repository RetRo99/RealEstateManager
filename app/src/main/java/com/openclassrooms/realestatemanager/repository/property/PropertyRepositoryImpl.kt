package com.openclassrooms.realestatemanager.repository.property

import android.util.Log
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.database.property.PropertyDao
import com.openclassrooms.realestatemanager.retrofit.GeocodingApi
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyDao: PropertyDao,
    private val api: GeocodingApi
) : PropertyRepository {

    override fun getProperty(id: Int): Single<UiPropertyDetail> {
        return propertyDao.getProperty(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun updateProperty(property: UiPropertyDetail): Completable {
        return propertyDao.updateProperty(property)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getProperties(): Observable<List<UiPropertyDetail>> {
        return propertyDao.getProperties()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addProperty(property: UiPropertyDetail): Completable {
        return api.getLocation(property.address)
            .map {
                val location = it.results[0].geometry.location
                property.copy(lat = location.lat, lng = location.lng)
            }
            .flatMapCompletable {
                propertyDao.addProperty(it)

            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}
