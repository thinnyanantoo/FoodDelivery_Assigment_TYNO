package com.padc.fooddelivery_assigment_tyno.network.auth

import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO

interface AuthManager {
    fun login(email: String, password : String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(userName : String,emial: String,password : String,phone : String, onSuccess : () -> Unit, onFailure: (String) -> Unit)
    fun userData(onSuccess: (userVO : UserVO) -> Unit, onFailure: (String) -> Unit)
    fun updateProfile( photo : String, onSuccess: () -> Unit,onFailure: (String) -> Unit)
}