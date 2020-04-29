package com.openclassrooms.realestatemanager

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.text.DateFormat
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

        val formattedDate = SimpleDateFormat("dd/mm/yyyy").format(Date())

        assertThat(Utils.todayDate, `is`(formattedDate))

    }
}
