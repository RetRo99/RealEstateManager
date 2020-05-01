package com.openclassrooms.realestatemanager.utils

import android.content.Context
import android.location.Location
import android.net.ConnectivityManager
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.gms.maps.model.LatLng
import com.openclassrooms.realestatemanager.base.Constants.GOOGLE_KEY
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.net.URLEncoder.encode
import java.text.DateFormat
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

}
