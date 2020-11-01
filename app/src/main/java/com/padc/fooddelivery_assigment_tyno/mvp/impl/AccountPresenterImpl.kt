package com.padc.fooddelivery_assigment_tyno.mvp.impl

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.data.models.AuthenticationModel
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.AuthenticationModelImpl
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AbstractBasePresenter
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AccountPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.AccountView

class AccountPresenterImpl : AccountPresenter , AbstractBasePresenter<AccountView>(){
    private val mAuthModel : AuthenticationModel = AuthenticationModelImpl
    private val mModel : FoodModel = FoodModelImpl

    override fun onTapUpdateProfileUpload( bitmap: Bitmap) {
        mModel.updataPhoto(bitmap,
            onSuccess =  {
                mAuthModel.updateProfile(it,{},{})
            },
            onFaiure = {
                mView?.showError("Profile update error")
            })
    }

    override fun onTapEdit() {
        mView?.editUser()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mAuthModel?.userData(
            onSuccess = {
                mView?.displayUser(it)
            }, onFailure = {
                mView?.showError("Error in User data")
            }
        )
    }
}