package com.openclassrooms.realestatemanager

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilsTestIntegration {

    @Test
    fun checkIfNetworkIsAvailable() {

        //make sure you have connection
        assertTrue(
                Utils.isInternetAvailable(InstrumentationRegistry.getInstrumentation().context)
        )
    }

}
