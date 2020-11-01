package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.RegisterView

interface RegisterPresenter : BasePresentter<RegisterView> {
    fun onUiReady(owner : LifecycleOwner)
    fun onTapRegister(userName : String,email : String, password : String,phone : String)
    fun onTapLogin()
}