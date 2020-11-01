package com.padc.fooddelivery_assigment_tyno.data.models.impls

import com.padc.fooddelivery_assigment_tyno.data.models.AuthenticationModel
import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO
import com.padc.fooddelivery_assigment_tyno.network.auth.AuthManager
import com.padc.fooddelivery_assigment_tyno.network.auth.FirebaseAuthManager

object AuthenticationModelImpl : AuthenticationModel {
    override var mAuthManager: AuthManager = FirebaseAuthManager

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password,onSuccess, onFailure)
    }

    override fun register(
        userName: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.register(userName,email,password,phone,onSuccess,onFailure)
    }

    override fun updateProfile(photo: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.updateProfile(photo,onSuccess,onFailure)
    }

    override fun userData(onSuccess: (userVO: UserVO) -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.userData(onSuccess,onFailure)
    }
}