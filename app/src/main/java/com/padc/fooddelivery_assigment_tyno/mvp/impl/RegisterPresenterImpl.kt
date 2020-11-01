package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.data.models.AuthenticationModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.AuthenticationModelImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.RegisterPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.RegisterView

class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {
    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl
    override fun onTapRegister(userName: String,email: String, password: String, phone: String) {
        mAuthenticationModel.register(userName,email,password, phone, onSuccess = {
            mView.navigateToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapLogin() {
        mView.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

}