package com.padc.fooddelivery_assigment_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

@Dao
interface FoodDao {
    @Query("SELECT * FROM tbRestaurant where id = :id")
    @ColumnInfo
    fun getFoodList(id : String) : LiveData<List<RestaurantVO>>

    @Query("DELETE FROM tbRestaurant")
    @ColumnInfo
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @ColumnInfo
    fun insertAllFood(foodVO: List<RestaurantVO>)
}