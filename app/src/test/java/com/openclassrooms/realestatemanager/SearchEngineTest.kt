package com.openclassrooms.realestatemanager

import com.openclassrooms.realestatemanager.base.model.UiPropertyDetail
import com.openclassrooms.realestatemanager.repository.property.PropertyRepository
import com.openclassrooms.realestatemanager.ui.searchProperty.model.PropertySearchParams
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class SearchEngineTest {

    private lateinit var fakeRepository: PropertyRepository

    @Before
    fun setup() {
        fakeRepository = FakePropertyRepository()
    }

    @Test
    fun testEmptyParams() {
        val searchParams =
            PropertySearchParams("Apartment", "", "", listOf(), "", "", "", 1, "", "", false)
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(3))
        testObserver.assertValueCount(1)
    }


    @Test
    fun fromDate() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf(),
            "18/04/2020",
            "",
            "",
            1,
            "",
            "",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(2))
        testObserver.assertValueCount(1)
    }

    @Test
    fun toDate() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf(),
            "",
            "18/04/2020",
            "",
            1,
            "",
            "",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(2))
    }

    @Test
    fun cityParam() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf(),
            "",
            "",
            "Litija",
            1,
            "",
            "",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(2))
    }

    @Test
    fun photoLimitParam() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf(),
            "",
            "",
            "",
            3,
            "",
            "",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(1))
    }


    @Test
    fun priceParam() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf(),
            "",
            "",
            "",
            1,
            "401",
            "201",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(1))
    }

    @Test
    fun interestPointsTest() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf("Stores"),
            "",
            "",
            "",
            1,
            "",
            "",
            false
        )
        val searchParams2 = PropertySearchParams(
            "Apartment",
            "",
            "",
            listOf("Hobbies"),
            "",
            "",
            "",
            1,
            "",
            "",
            false
        )

        val testObserver = TestObserver<List<UiPropertyDetail>>()
        val testObserver2 = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)
        fakeRepository.getSearchProperties(searchParams2)
            .subscribe(testObserver2)

        val result = testObserver.values()[0]
        val result2 = testObserver2.values()[0]

        assertThat(result.size, `is`(1))
        assertThat(result2.size, `is`(3))
    }


    @Test
    fun sizeParam() {
        val searchParams = PropertySearchParams(
            "Apartment",
            "201",
            "400",
            listOf(),
            "",
            "",
            "",
            1,
            "",
            "",
            false
        )
        val testObserver = TestObserver<List<UiPropertyDetail>>()

        fakeRepository.getSearchProperties(searchParams)
            .subscribe(testObserver)

        val result = testObserver.values()[0]

        assertThat(result.size, `is`(1))
    }

    }



