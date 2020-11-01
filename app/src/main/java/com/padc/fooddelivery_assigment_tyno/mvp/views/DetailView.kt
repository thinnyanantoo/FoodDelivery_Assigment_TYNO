package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantRecyclerViewHolder

interface DetailView : BaseView {
    fun showFoodList(FoodList: List<FoodVO>)
    fun bindData(restaurantVO: RestaurantVO)
     fun addOrderFood() : RestaurantVO

}