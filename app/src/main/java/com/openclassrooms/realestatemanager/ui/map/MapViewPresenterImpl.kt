package com.openclassrooms.realestatemanager.ui.map

import com.openclassrooms.realestatemanager.Utils
import com.openclassrooms.realestatemanager.manager.location.LocationManager
import com.openclassrooms.realestatemanager.ui.MainViewPresenter
import com.openclassrooms.realestatemanager.ui.map.model.UiMarkerModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class MapViewPresenterImpl @Inject constructor(
    private val view: MapView,
    private val locationManager: LocationManager,
    private val parentPresenter: MainViewPresenter

) : MapViewPresenter {

    private var locationDisposable: Disposable? = null

    override fun onViewCreated() {
        view.getMapAsync()
        locationManager.updateLocation()
    }

    private fun displayOrShowNoResult(markerList: List<UiMarkerModel>) {
    }

    override fun onMapReady() {
        locationDisposable = locationManager.location
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    view.moveToLocation(Utils.getLatLng(it))
                }
            )
    }


    override fun onMarkerClicked(id: Int) {
        parentPresenter.onMarkerClicked(id)
    }


    override fun onDestroy() {
        locationDisposable?.dispose()
    }

}
