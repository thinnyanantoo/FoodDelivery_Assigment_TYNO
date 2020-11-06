package com.padc.fooddelivery_assigment_tyno.mvp.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.CartPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.CartView
import okhttp3.internal.applyConnectionSpec

class CartPresenterImpl : CartPresenter, AbstractBasePresenter<CartView>() {
    private val mModel: FoodModel = FoodModelImpl
    override fun onUiReady(owner: LifecycleOwner, id: String) {
        requestData(owner, id)
    }

    private fun requestData(lifecycleOwner: LifecycleOwner, id: String) {
        mModel.getRestaurantById(id).observe(lifecycleOwner, Observer {
            it?.let {
                mView?.showRestauratnInformation(it)
            }
        }
        )

        mModel.getCartItems(onSuccess = {
            mView?.displayOrderCart(it)
        }, onFaiure = {
            mView?.showError(it)

        })
    }

    override fun onTapAddMoreFoods() {
        mView?.navigateToDetailActivity()
    }

    override fun onTapCheckOut() {
        mView?.showBottomSheet()
        mModel.clearCart()
    }


}
