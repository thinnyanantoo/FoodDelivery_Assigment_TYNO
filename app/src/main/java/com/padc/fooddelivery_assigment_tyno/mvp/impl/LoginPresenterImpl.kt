package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.data.models.AuthenticationModel
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.AuthenticationModelImpl
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.LoginPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {
    private val mModel : FoodModel = FoodModelImpl
    private val mAuthenticationModel : AuthenticationModel = AuthenticationModelImpl
    override fun onTapLogin(email: String, password: String) {
        mAuthenticationModel.login(email,password,onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mModel.setUpRemoteConfigWithDefaultValues()
        mModel.fetchRemoteConfigs()
    }

}