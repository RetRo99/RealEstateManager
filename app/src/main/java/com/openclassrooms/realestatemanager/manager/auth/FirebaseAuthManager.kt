package com.openclassrooms.realestatemanager.manager.auth

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Maybe

class FirebaseAuthManager(
    private val auth: FirebaseAuth
) {


    fun isUserLogged(): Boolean {
        return auth.currentUser != null
    }

    fun logoutUser() {
        auth.signOut()
    }

}
