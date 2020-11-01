package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import com.padc.fooddelivery_assigment_tyno.mvp.views.DetailView

interface DetailPresenter : BasePresentter<DetailView>, DetailDelegate{
    fun onUiReady(id : String, owner: LifecycleOwner)
}