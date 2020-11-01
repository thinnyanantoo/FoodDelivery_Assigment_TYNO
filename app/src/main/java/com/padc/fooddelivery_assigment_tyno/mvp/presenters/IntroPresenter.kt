package com.example.fooddeliveryapp.mvp.presenters

import com.example.fooddeliveryapp.mvp.views.IntroView
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.BasePresentter


interface IntroPresenter : BasePresentter<IntroView> {
    fun onTapGettingStarted()
}