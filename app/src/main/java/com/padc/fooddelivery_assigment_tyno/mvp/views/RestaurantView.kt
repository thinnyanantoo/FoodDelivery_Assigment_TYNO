package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

interface RestaurantView : BaseView {

    fun displayRestaurantList(restaurantList : List<RestaurantVO>)
    fun displayCategroyList(foodList : List<CategoryVO>)
    fun navigateToDetialActivity(restaurantVO: RestaurantVO)
}