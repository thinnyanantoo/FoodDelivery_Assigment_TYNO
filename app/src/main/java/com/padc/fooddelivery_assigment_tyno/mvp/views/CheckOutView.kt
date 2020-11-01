package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

interface CheckOutView : BaseView {
   fun showOrderFoods(data : List<OrderListVO>, restaurant: RestaurantVO)
}