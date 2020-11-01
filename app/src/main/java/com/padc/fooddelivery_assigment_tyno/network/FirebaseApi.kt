package com.padc.fooddelivery_assigment_tyno.network

import android.graphics.Bitmap
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

interface FirebaseApi {
    fun getRestaurants(id : String, onSuccess : (restaurants: List<RestaurantVO>) -> Unit, onFailure : (String) -> Unit)
    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit,onFailure: (String) -> Unit)
    fun getPopularFood(onSuccess: (foodList: List<FoodVO>) -> Unit,onFailure: (String) -> Unit)
    fun getFoods(restaurantId : String,onSuccess:(foodList: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
    fun uploadPhoto(image : Bitmap, onSuccess : (photo : String) -> Unit, onFailure: (String) -> Unit)
//    fun getOrderList(onSuccess: (orderList: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
//    fun getCartItemCount(onSucess : (carCount : Long) -> Unit, onFailure: (String) -> Unit)
//    fun getTotalPrice(onSuccess: (cardCount : Long)-> Unit, onFailure : (String) -> Unit)
//    fun deleteFoodItem(id: String)
     fun addOrderedFoodIntoNetwork(id: Int, name : String, price : Int, qty : Int)
    fun deleteOrderedFoodList(id : Int)
    fun getAllOrderedFoodDataById(
        onSuccess: (data : List<OrderListVO>) -> Unit,
        onFailure: (String) -> Unit,
        id: String
    )
}