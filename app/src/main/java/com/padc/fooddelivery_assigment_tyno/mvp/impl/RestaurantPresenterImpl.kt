package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.RestaurantPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.RestaurantView

class RestaurantPresenterImpl : RestaurantPresenter, AbstractBasePresenter<RestaurantView>() {
    var mModel : FoodModel = FoodModelImpl
    override fun onUiReady(owner: LifecycleOwner) {
        requestRestaurantList(owner)
        requestCategoryList(owner)
    }

    override fun onTapRestaurantItem(restaurantVO: RestaurantVO) {
        mView?.navigateToDetialActivity(restaurantVO)
    }

    private fun requestRestaurantList(lifecycleOwner: LifecycleOwner){
        mModel.getRestaurantList (
            onError = {
                mView?.showError(error("Error"))
            }).observe(lifecycleOwner, Observer {
            mView?.displayRestaurantList(it)
        })
    }

    private fun requestCategoryList(lifecycleOwner: LifecycleOwner){
      mModel.getCategoriesList(onError = {
          mView?.showError(error("Error"))
      }).observe(lifecycleOwner, Observer {
          mView?.displayCategroyList(it)
      })

    }
}