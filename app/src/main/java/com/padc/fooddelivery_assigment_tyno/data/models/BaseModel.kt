package com.padc.fooddelivery_assigment_tyno.data.models

import android.content.Context
import com.padc.fooddelivery_assigment_tyno.network.FirebaseApi
import com.padc.fooddelivery_assigment_tyno.persistence.db.RestaurantDB

abstract class BaseModel {
    protected lateinit var mTheDB : RestaurantDB

    init {

    }
    fun initDatabase(context : Context){
        mTheDB = RestaurantDB.getDBInstance(context)
    }

}