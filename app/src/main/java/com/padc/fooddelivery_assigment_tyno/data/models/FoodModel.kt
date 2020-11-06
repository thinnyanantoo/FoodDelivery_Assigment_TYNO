package com.padc.fooddelivery_assigment_tyno.data.models

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.padc.fooddelivery_assigment_tyno.data.vos.*
import com.padc.fooddelivery_assigment_tyno.network.FirebaseApi
import com.padc.fooddelivery_assigment_tyno.network.remoteConfig.FirebaseRemoteConfigManager

interface FoodModel {

    var mFirebaseApi: FirebaseApi
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    //restaurant
    fun getRestaurantFormFirebaseToDatabase(
        id:String,
        onSuccess: (List<RestaurantVO>) -> Unit,
        onError: (String) -> Unit
    )

    fun getRestaurantList(onError: (String) -> Unit): LiveData<List<RestaurantVO>>


    fun getRestaurantById(id:String) : LiveData<RestaurantVO>


    //Categories
    fun getCategoriesList(onError: (String) -> Unit): LiveData<List<CategoryVO>>

    fun getCategoriesFromFirebaseToDatabase(
        onSuccess: (List<CategoryVO>) -> Unit,
        onError: (String) -> Unit
    )

   // foodList
    fun getFoodList(id: String,onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit)

   // popular
    fun getPopular(id: String,onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit)

    //RemoteConfig
    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getScreenLayoutFromRemoteConfig() : String

    fun updataPhoto(image : Bitmap, onSuccess : (photo : String) -> Unit,onFaiure: (String) -> Unit)


    fun addToCart(foodId : String, name : String, price : Int, qty: Int)

    fun getCartItems(onSuccess: (List<CartVO>) -> Unit, onFaiure: (String) -> Unit)
    fun clearCart()

}
