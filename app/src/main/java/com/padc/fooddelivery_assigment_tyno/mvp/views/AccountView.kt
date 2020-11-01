package com.padc.fooddelivery_assigment_tyno.mvp.views

import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO

interface AccountView : BaseView {
    fun displayUser(userVO : UserVO)
    fun editUser()
}