package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.mvp.views.CheckOutView

interface CheckOutPresenter : BasePresentter<CheckOutView> {
   fun deleteOrderedFoodList(id: Int)
    fun onUiReady(owner : LifecycleOwner,id: String)}