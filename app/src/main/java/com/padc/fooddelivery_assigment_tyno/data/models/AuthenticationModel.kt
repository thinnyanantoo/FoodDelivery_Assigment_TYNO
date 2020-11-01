package com.padc.fooddelivery_assigment_tyno.data.models

import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO
import com.padc.fooddelivery_assigment_tyno.network.auth.AuthManager

interface AuthenticationModel {
    var mAuthManager: AuthManager
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        userName: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun userData(
        onSuccess: (userVO : UserVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun updateProfile(
        photo : String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )
}