package com.openclassrooms.realestatemanager

import com.openclassrooms.realestatemanager.utils.Utils
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class UtilsTest {

    @Test
    fun testEurToDollar() {

        val euros = 15
        val valueOfEurInDollar = 1.08
        val dollars = 15 * valueOfEurInDollar

        assertThat(Utils.convertEuroToDollar(euros), `is`(dollars.roundToInt()))

    }

    @Test
    fun testStringDate() {

        val formattedDate = SimpleDateFormat("dd/MM/yyyy").format(Date())

        assertThat(Utils.todayDate, `is`(formattedDate))

    }

    @Test
    fun testIsFirstDateBeforeSecond(){
        val result = Utils.isFirstDateAfterSecond("17/04/2020", "18/04/2020")
        assertThat(result, `is`(false))

    }

    @Test
    fun isFirstDateBeforeSecond(){
        val result = Utils.isFirstDateAfterSecond("18/04/2020", "15/04/2020")
        assertThat(result, `is`(true))

    }
}
