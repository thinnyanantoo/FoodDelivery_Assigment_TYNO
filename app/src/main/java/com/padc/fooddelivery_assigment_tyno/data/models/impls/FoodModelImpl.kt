package com.padc.fooddelivery_assigment_tyno.data.models.impls

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.padc.fooddelivery_assigment_tyno.data.models.BaseModel
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.network.FirebaseApi
import com.padc.fooddelivery_assigment_tyno.network.impls.RealtimeDatabaseFirebaseApiImpl
import com.padc.fooddelivery_assigment_tyno.network.remoteConfig.FirebaseRemoteConfigManager

object FoodModelImpl : FoodModel , BaseModel(){

    override var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager = FirebaseRemoteConfigManager
    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl


    /**Category List**/
    override fun getCategoriesList(onError: (String) -> Unit): LiveData<List<CategoryVO>> {
        return mTheDB.categoryDao().getAllCategoriesList()
    }


    override fun getCategoriesFromFirebaseToDatabase(
        onSuccess: (List<CategoryVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        mFirebaseApi.getCategories(
            onSuccess = {
            mTheDB.categoryDao().insertAllCategory(it)
        }, onFailure = {
            onError
        })
    }

  /**Food List**/
    override fun getFoodList(
        id: String,
        onSuccess: (List<FoodVO>) -> Unit,
        onFaiure: (String) -> Unit
    ) {
       mFirebaseApi.getFoods(id,onSuccess,onFaiure)
    }

//    override fun getPopular(onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit) {
//        mFirebaseApi.getPopularFood(onSuccess,onFaiure)
//    }

    /**RestaurantList**/
    override fun getRestaurantFormFirebaseToDatabase(
        id : String,
        onSuccess: (List<RestaurantVO>) -> Unit,
        onError: (String) -> Unit
    ) {
         mFirebaseApi.getRestaurants(id,onSuccess = {
             mTheDB.RestaurantDao().insertAllRestaurant(it)
         },onFailure = {
             onError
         })
    }

    override fun getRestaurantList(onError: (String) -> Unit): LiveData<List<RestaurantVO>> {
        return mTheDB.RestaurantDao().getAllRestaurantList()
    }

    override fun getRestaurantLisfromRestaurantId(id: String): LiveData<RestaurantVO> {
        return mTheDB.RestaurantDao().getRestaurantItembyRestaurantID(id)
    }



    /**RemoteConfig**/
    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getScreenLayoutFromRemoteConfig(): String {
        return mFirebaseRemoteConfigManager.getScreenLayout()
    }

    /**Photo**/
    override fun updataPhoto(
        image: Bitmap,
        onSuccess: (photo: String) -> Unit,
        onFaiure: (String) -> Unit
    ) {
        mFirebaseApi.uploadPhoto(image,onSuccess,onFaiure)
    }

    override fun getOrderFoodListDataById(
        onSuccess: (orders: List<OrderListVO>) -> Unit,
        onFaiure: (message: String) -> Unit,
        id: String
    ) {
        mFirebaseApi.getAllOrderedFoodDataById(onSuccess,onFaiure,id)
    }

    override fun addOrderFoodList(id: Int, name: String, price: Int, counter: Int) {
        mFirebaseApi.addOrderedFoodIntoNetwork(id,name,price,counter)
    }

    override fun deleteOrderFoodList(id: Int) {
        mFirebaseApi.deleteOrderedFoodList(id)
    }

//    override fun removeFoodItem(id: String) {
//        mFirebaseApi.deleteFoodItem(id)
//    }
//
//    override fun getOrderList(onSuccess: (List<FoodVO>) -> Unit, onFaiure: (String) -> Unit) {
//        mFirebaseApi.getOrderList(onSuccess,onFaiure)
//    }
//
//    override fun getCartItemCount(
//        onSuccess: (cartCount: Long) -> Unit,
//        onFialure: (String) -> Unit
//    ) {
//        mFirebaseApi.getCartItemCount(onSuccess,onFialure)
//    }
//
//    override fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit) {
//        mFirebaseApi.getTotalPrice(onSuccess,onFialure)
//    }

}