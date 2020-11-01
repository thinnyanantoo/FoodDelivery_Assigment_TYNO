package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.ViewModel
import com.padc.fooddelivery_assigment_tyno.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresentter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T) {
        mView = view
    }
}