package com.example.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.views.IntroView
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter


class IntroPresenterImpl : IntroPresenter, AbstractBasePresenter<IntroView>() {
    override fun onTapGettingStarted() {
       mView?.navigateToLoginScreen()
    }

     fun onUiReady(owner: LifecycleOwner) {}
}

