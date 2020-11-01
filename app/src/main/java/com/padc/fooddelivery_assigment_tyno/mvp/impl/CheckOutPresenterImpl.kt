package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.CheckOutPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.CheckOutView

class CheckOutPresenterImpl : CheckOutPresenter, AbstractBasePresenter<CheckOutView>() {
    private val mModel : FoodModel = FoodModelImpl
    override fun deleteOrderedFoodList(id: Int) {
        mModel.deleteOrderFoodList(id)
    }

    override fun onUiReady(owner: LifecycleOwner,id:String) {
         requestData(owner,id)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner, id:String){
        mModel.getOrderFoodListDataById(onSuccess = {order ->
            mModel.getRestaurantLisfromRestaurantId(id.toString())
                .observe(lifecycleOwner, Observer {
                    it?.let { data ->
                        mView.showOrderFoods(order,data)
                    }
                })
        },onFaiure = {
            mView?.showError("error in request data")
        },id = id)
        }
    }
