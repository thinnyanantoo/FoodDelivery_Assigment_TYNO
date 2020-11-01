package com.padc.fooddelivery_assigment_tyno.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl

abstract class BaseWorker(context: Context, workerParams : WorkerParameters) :
Worker(context , workerParams){
    val mRestaurantModel : FoodModel = FoodModelImpl
}