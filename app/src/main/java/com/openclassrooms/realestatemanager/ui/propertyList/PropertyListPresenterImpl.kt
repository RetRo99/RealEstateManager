package com.openclassrooms.realestatemanager.ui.propertyList

import android.util.Log
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
import com.openclassrooms.realestatemanager.utils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PropertyListPresenterImpl @Inject constructor(
    private val view: PropertyListView,
    private val propertyRepository: PropertyRepository,
    private val parentPresenter: MainViewPresenter

): PropertyListPresenter {

    private var propertiesDisposable: Disposable? = null

    override fun onViewCreated() {
        propertiesDisposable = propertyRepository.getProperties()
            .map {
                it.map {
                    UiProperty(it.id, it.type,
                        Utils.getEurCurrencyString(it.price), it.address.city, it.photos[0].photo)
                }
            }
            .subscribeBy(
                onNext = {
                    view.setData(it)
                },
                onError = {
                    Log.d("čič", "onError")
                    it.printStackTrace()
                }
            )

    }

    override fun onProperyClicked(id: Int){
        parentPresenter.onPropertyClicked(id)
    }


    override fun onDestroy(){
        propertiesDisposable?.dispose()
    }
}
