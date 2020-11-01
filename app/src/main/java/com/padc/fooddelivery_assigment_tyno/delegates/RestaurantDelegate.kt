package com.padc.fooddelivery_assigment_tyno.delegates

import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

interface RestaurantDelegate {
    fun onTapRestaurantItem(restaurantVO: RestaurantVO)
}