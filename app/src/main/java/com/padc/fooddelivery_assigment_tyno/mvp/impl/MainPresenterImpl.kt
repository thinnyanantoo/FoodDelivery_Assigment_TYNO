package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.BasePresentter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.MainPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.MainView

class MainPresenterImpl : MainPresenter,AbstractBasePresenter<MainView>(){
    private var mModel : FoodModel = FoodModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView.showViewType(mModel.getScreenLayoutFromRemoteConfig())
    }

}