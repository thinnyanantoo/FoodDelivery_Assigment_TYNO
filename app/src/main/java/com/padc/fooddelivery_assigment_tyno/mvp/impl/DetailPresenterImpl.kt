package com.padc.fooddelivery_assigment_tyno.mvp.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.DetailPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

        private var mModel: FoodModel = FoodModelImpl
        override fun onUiReady(id: String, owner: LifecycleOwner) {
            bindRestaurantItem(id, lifecycleOwner = owner)
            requestFoodList(id,owner)
        }

    override fun onTapAddFood(name: String, price: Int, counter: Int) {
        mView?.addOrderFood()?.let {
            mModel.addOrderFoodList(it.id.toInt(),name,price,counter)
        }
    }


    fun bindRestaurantItem(id: String, lifecycleOwner: LifecycleOwner) {
        mModel.getRestaurantLisfromRestaurantId(id)
            .observe(lifecycleOwner, Observer {
                it?.let { data ->
                    mView.bindData(data)
                }
            })
    }

    fun requestFoodList(id: String, lifecycleOwner: LifecycleOwner) {
        mModel.getFoodList(id, onSuccess = {
            mView.showFoodList(it)
        }, onFaiure = {
            mView.showError("Error")
        })
    }

}