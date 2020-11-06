package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantRecyclerViewHolder

interface DetailView : BaseView {
    fun bindData(restaurantVO: RestaurantVO)
    fun displayPopularFoods(foods: List<FoodVO>)
    fun showFoodList(foods: List<FoodVO>)
    fun addItemCount()
    fun navigateGoToCart()


}
