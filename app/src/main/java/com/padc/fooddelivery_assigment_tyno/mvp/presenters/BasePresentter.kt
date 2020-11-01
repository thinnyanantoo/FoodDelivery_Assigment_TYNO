package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.BaseView

interface BasePresentter<V : BaseView> {
    fun initPresenter(view : V)
}