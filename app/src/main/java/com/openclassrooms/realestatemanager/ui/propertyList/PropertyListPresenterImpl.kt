package com.openclassrooms.realestatemanager.ui.propertyList

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.propertyList.model.UiProperty
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.map {
                    UiProperty(it.id, it.type, it.price.toString(), it.address)
                }
            }
            .subscribeBy(
                onSuccess = {
                    view.setData(it)
                }
            )

    }

    override fun onProperyClicked(id:String){
        parentPresenter.onPropertyClicked(id)
    }


    override fun onDestroy(){
        propertiesDisposable?.dispose()
    }
}
