package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.MainView

interface MainPresenter : BasePresentter<MainView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)

}