package com.padc.fooddelivery_assigment_tyno.worker

import android.content.Context
import androidx.work.WorkerParameters

class GetRestaurantWorker(context: Context, worderParams: WorkerParameters) :
    BaseWorker(context, worderParams) {
    override fun doWork(): Result {

        var result = Result.failure()
        var id: String = ""

        mRestaurantModel.getRestaurantFormFirebaseToDatabase(
            id,
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        mRestaurantModel.getCategoriesFromFirebaseToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

//        mRestaurantModel.getFoodFromFirebaseToDatabase(
//            id,
//            onSuccess = {
//                result = Result.success()
//            },
//            onError = {
//                result = Result.failure()
//            }
//        )
        return result
    }
}
