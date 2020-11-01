package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import com.padc.fooddelivery_assigment_tyno.mvp.views.RestaurantView

interface RestaurantPresenter : BasePresentter<RestaurantView> , RestaurantDelegate{
    fun onUiReady(owner : LifecycleOwner)
}