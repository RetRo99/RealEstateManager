package com.openclassrooms.realestatemanager.repository.property

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.database.property.PropertyDao
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    private val propertyDao: PropertyDao
) : PropertyRepository {

    override fun getProperty(id: String): Single<UiPropertyDetail> {
        return propertyDao.getProperty(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun updateProperty(property: UiPropertyDetail) {

    }

    override fun getProperties(): Single<List<UiPropertyDetail>> {
        return propertyDao.getProperties()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addProperty(property: UiPropertyDetail): Completable {
        return propertyDao.addProperty(property)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}
