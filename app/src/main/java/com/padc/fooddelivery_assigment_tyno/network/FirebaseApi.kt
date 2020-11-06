package com.padc.fooddelivery_assigment_tyno.network

import android.graphics.Bitmap
import com.padc.fooddelivery_assigment_tyno.data.vos.*

interface FirebaseApi {
    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit,onFailure: (String) -> Unit)
    fun getRestaurants(onSuccess : (restaurants: List<RestaurantVO>) -> Unit, onFailure : (String) -> Unit)
    fun getPopularFood(id: String,onSuccess: (foodList: List<FoodVO>) -> Unit,onFailure: (String) -> Unit)
    fun getFoods(restaurantId : String,onSuccess:(foodList: List<FoodVO>) -> Unit, onFailure: (String) -> Unit)
    fun uploadPhoto(image : Bitmap, onSuccess : (photo : String) -> Unit, onFailure: (String) -> Unit)
    fun addToCart(foodId : String, name : String, price : Int, qty : Int)
    fun getCartItem(onSuccess : (List<CartVO>) -> Unit, onFailure: (String) -> Unit)
    fun clearCart()
}