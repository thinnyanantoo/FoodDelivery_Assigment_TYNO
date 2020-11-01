package com.padc.fooddelivery_assigment_tyno.mvp.presenters

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO
import com.padc.fooddelivery_assigment_tyno.mvp.views.AccountView

interface AccountPresenter : BasePresentter<AccountView> {
    fun onTapUpdateProfileUpload(bitmap: Bitmap)
    fun onTapEdit()
    fun onUiReady(lifecycleOwner: LifecycleOwner)

}