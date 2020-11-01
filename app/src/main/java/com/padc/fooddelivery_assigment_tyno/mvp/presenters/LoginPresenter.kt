package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.LoginView

interface LoginPresenter : BasePresentter<LoginView> {
    fun onUiReady(owner : LifecycleOwner)
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}