package com.openclassrooms.realestatemanager.utils

import android.content.Context
import android.location.Location
import android.net.ConnectivityManager
import com.google.android.gms.maps.model.LatLng
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.text.DateFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


/**
 * Created by Philippe on 21/02/2018.
 */
object Utils {
    /**
     * Conversion d'un prix d'un bien immobilier (Dollars vers Euros)
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     * @param dollars
     * @return
     */
    fun convertDollarToEuro(dollars: Int): Int {
        return (dollars * 0.812).roundToInt()
    }

    /**
     * @param dollars
     * @return
     */
    fun convertEuroToDollar(eur: Int): Int {
        return (eur * 1.08).roundToInt()
    }

    /**
     * Conversion de la date d'aujourd'hui en un format plus approprié
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     * @return
     */
    val todayDate: String
        get() {
            val dateFormat: DateFormat = SimpleDateFormat("dd/MM/yyyy")
            return dateFormat.format(Date())
        }

    /**
     * Vérification de la connexion réseau
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     * @param context
     * @return
     */
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun getLatLng(location:Location): LatLng {
        return LatLng(location.latitude, location.longitude)
    }

    fun isFirstDateAfterSecond(first:String, second:String):Boolean{
        val firstDate = LocalDate.parse(first, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        val secondDate = LocalDate.parse(second, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        return firstDate.isAfter(secondDate)
    }

    fun getEurCurrencyString(price:Double, convertFromDollars: Boolean = false):String{
        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        format.currency = Currency.getInstance("EUR")
        if(convertFromDollars) {
            return  format.format(convertEuroToDollar(price.toInt()))
        }
        return format.format(price)

    }

}
