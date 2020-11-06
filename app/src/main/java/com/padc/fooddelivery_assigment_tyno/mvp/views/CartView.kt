package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.CartVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

interface CartView : BaseView {
   fun showRestauratnInformation(resInfo : RestaurantVO)
   fun displayOrderCart(cart : List<CartVO>)
   fun showBottomSheet()
   fun navigateToDetailActivity()

}