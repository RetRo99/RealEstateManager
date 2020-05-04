package com.openclassrooms.realestatemanager

import com.openclassrooms.realestatemanager.base.model.Address
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.propertyAdd.model.UiPropertyDetailsPhotoItem
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class FakePropertyRepository : PropertyRepository {

    private val properties = listOf(

        UiPropertyDetail(
            "Apartment",
            "Rok Retar",
            "200",
            "5",
            "description",
            200.0,
            Address("", "", "", "Litija"),
            "20/04/2020",
            listOf("Doctor", "School", "Hobbies"),
            0,
            listOf(
                UiPropertyDetailsPhotoItem("photo 1", "title 1")
            ), 2.5, 2.5,
            false,
            "20/04/2020"
        ),
        UiPropertyDetail(
            "Apartment",
            "Rok Retar",
            "300",
            "5",
            "description",
            300.0,
            Address("", "", "", "Ljubljana"),
            "17/04/2020",
            listOf("Doctor", "School", "Hobbies"),
            0,
            listOf(
                UiPropertyDetailsPhotoItem("photo 1", "title 1"),
                UiPropertyDetailsPhotoItem("photo 2", "title 2")
            ), 2.5, 2.5,
            false,
            "17/04/2020"
        ),
        UiPropertyDetail(
            "Apartment",
            "Rok Retar",
            "400",
            "5",
            "description",
            400.0,
            Address("", "", "", "Litija"),
            "18/04/2020",
            listOf("Doctor", "School", "Hobbies", "Stores"),
            0,
            listOf(
                UiPropertyDetailsPhotoItem("photo 1", "title 1"),
                UiPropertyDetailsPhotoItem("photo 2", "title 2"),
                UiPropertyDetailsPhotoItem("photo 3", "title 3")
            ),
            2.5, 2.5,
            false,
            "18/04/2020"
        )
    )


    override fun getProperties(): Observable<List<UiPropertyDetail>> {
        return Observable.fromArray(properties)
    }

    override fun addProperty(property: UiPropertyDetail): Completable {
        return Completable.complete()
    }

    override fun updateProperty(property: UiPropertyDetail): Completable {
        return Completable.complete()
    }

    override fun getProperty(id: Int): Single<UiPropertyDetail> {
        return Single.just(
            UiPropertyDetail(
                "type",
                "agentName",
                "surface",
                "numberOfRooms",
                "description",
                2.0,
                Address("", "", "", ""), "", listOf()
            )
        )
    }

    override fun getSearchProperties(searchParams: PropertySearchParams): Observable<List<UiPropertyDetail>> {
        return Observable.fromArray(properties)
            .map {
                it.filter { propertyDetail ->
                    propertyDetail.matchesCriteria(searchParams)
                }
            }
    }
}
