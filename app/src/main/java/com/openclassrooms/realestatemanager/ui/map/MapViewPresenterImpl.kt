package com.openclassrooms.realestatemanager.ui.map

import com.openclassrooms.realestatemanager.utils.Utils
import com.openclassrooms.realestatemanager.manager.location.LocationManager
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.map.model.UiMarkerModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class MapViewPresenterImpl @Inject constructor(
    private val view: MapView,
    private val locationManager: LocationManager,
    private val parentPresenter: MainViewPresenter,
    private val propertyRepository: PropertyRepository


    ) : MapViewPresenter {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewCreated() {
        view.getMapAsync()
        locationManager.updateLocation()
    }

    private fun displayOrShowNoResult(markerList: List<UiMarkerModel>) {
    }

    override fun onMapReady() {
        locationManager.location
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    view.moveToLocation(Utils.getLatLng(it))
                }
            ).addTo(compositeDisposable)
        propertyRepository.getProperties()
            .map {
                it.map {
                    UiMarkerModel(it.latLng,  it.id.toString())
                }
            }
            .subscribeBy(
                onNext = {
                    it.forEach {
                        view.addMarker(it)
                    }
                    view.setMarkerClickListener()
                }
            ).addTo(compositeDisposable)
    }


    override fun onMarkerClicked(id: Int) {
        parentPresenter.onMarkerClicked(id)
    }


    override fun onDestroy() {
        compositeDisposable.dispose()
    }

}
