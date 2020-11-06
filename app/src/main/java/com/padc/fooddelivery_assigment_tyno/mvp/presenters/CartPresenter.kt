package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.CartView

interface CartPresenter : BasePresentter<CartView> {
    fun onUiReady(owner: LifecycleOwner, id: String)
    fun onTapCheckOut()
    fun onTapAddMoreFoods()

}