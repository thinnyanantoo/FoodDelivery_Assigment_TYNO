package com.padc.fooddelivery_assigment_tyno.persistence.db

import android.content.Context
import androidx.room.*
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.persistence.daos.CategoryDao
import com.padc.fooddelivery_assigment_tyno.persistence.daos.FoodDao
import com.padc.fooddelivery_assigment_tyno.persistence.daos.RestaurantDao
import com.padc.fooddelivery_assigment_tyno.persistence.typeConverters.FoodTypeConverter

@Database(entities = [RestaurantVO::class,CategoryVO::class],version = 1, exportSchema = false)
@TypeConverters(FoodTypeConverter::class)
abstract class RestaurantDB : RoomDatabase() {
    companion object {


    val DB_NAME = "RestaurantDB"
    var dbInstance: RestaurantDB? = null

    fun getDBInstance(context: Context): RestaurantDB {
        when (dbInstance) {
            null -> {
                dbInstance = Room.databaseBuilder(
                    context, RestaurantDB::class.java, DB_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
        val i = dbInstance
        return i!!
    }
}

    abstract fun RestaurantDao(): RestaurantDao
//    abstract fun FoodDao() : FoodDao
    abstract fun categoryDao() : CategoryDao
}