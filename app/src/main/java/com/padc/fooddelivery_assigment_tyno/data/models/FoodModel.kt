package com.padc.fooddelivery_assigment_tyno.data.models

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
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


    fun getRestaurantLisfromRestaurantId(id:String):LiveData<RestaurantVO>


    //Categories
    fun getCategoriesList(onError: (String) -> Unit): LiveData<List<CategoryVO>>

    fun getCategoriesFromFirebaseToDatabase(
        onSuccess: (List<CategoryVO>) -> Unit,
        onError: (String) -> Unit
    )

    //foodList
    fun getFoodList(id: String,onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit)

//   // popular
//    fun getPopular(onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit)

    //RemoteConfig
    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getScreenLayoutFromRemoteConfig() : String

    fun updataPhoto(image : Bitmap, onSuccess : (photo : String) -> Unit,onFaiure: (String) -> Unit)

//    fun getOrderList(onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit)
//
//    fun removeFoodItem(id : String)
//
//    fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)
//
//    fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)

    fun getOrderFoodListDataById(onSuccess: (orders : List<OrderListVO>) -> Unit,onFaiure: (message: String) -> Unit,id: String)
    fun addOrderFoodList(id : Int, name : String, price : Int, counter : Int)
    fun deleteOrderFoodList(id:Int)

}
