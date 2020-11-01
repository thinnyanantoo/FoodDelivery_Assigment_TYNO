package com.padc.fooddelivery_assigment_tyno.delegates

import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO

interface CheckOutDelegate {
    fun onTapRemoveCart(foodVO : FoodVO)
}