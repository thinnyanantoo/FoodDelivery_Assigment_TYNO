package com.padc.fooddelivery_assigment_tyno.delegates

import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.BasePresentter
import com.padc.fooddelivery_assigment_tyno.mvp.views.DetailView

interface DetailDelegate : BasePresentter<DetailView>{
    fun onTapAddCart(foods : FoodVO)
}
