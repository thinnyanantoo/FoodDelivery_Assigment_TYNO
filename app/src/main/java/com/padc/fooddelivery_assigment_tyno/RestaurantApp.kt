package com.padc.fooddelivery_assigment_tyno

import android.app.Application
import androidx.work.*
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.worker.GetRestaurantWorker
import java.util.concurrent.TimeUnit

class RestaurantApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FoodModelImpl.initDatabase(applicationContext)

        getRestaurantOneTime()
        getRestaurantPeriodically()
        getRestaurantWhileInDozeMode()
    }

    private fun getRestaurantOneTime() {
        val getEventsWorkRequest = OneTimeWorkRequest.Builder(GetRestaurantWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getRestaurantPeriodically() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsPeroidicallyWorkRequest = PeriodicWorkRequest
            .Builder(GetRestaurantWorker::class.java, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsPeroidicallyWorkRequest)
    }

    private fun getRestaurantWhileInDozeMode() {
        val constraints = Constraints
            .Builder()
            .setRequiresDeviceIdle(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val getEventsWhileInDozeModeWorkRequest = PeriodicWorkRequest
            .Builder(GetRestaurantWorker::class.java, 1, TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWhileInDozeModeWorkRequest)
    }

}