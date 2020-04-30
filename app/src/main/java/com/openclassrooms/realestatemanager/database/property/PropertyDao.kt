package com.openclassrooms.realestatemanager.database.property

import androidx.room.*
import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface PropertyDao {


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun addProperty(property: UiPropertyDetail): Completable

        @Query("SELECT * FROM ${UiPropertyDetail.TABLE_NAME}")
        fun getProperties(): Observable<List<UiPropertyDetail>>

        @Update
        fun updateProperty(property: UiPropertyDetail): Completable

        @Query("SELECT * FROM ${UiPropertyDetail.TABLE_NAME} WHERE id=:id")
        fun getProperty(id: Int): Single<UiPropertyDetail>

}
