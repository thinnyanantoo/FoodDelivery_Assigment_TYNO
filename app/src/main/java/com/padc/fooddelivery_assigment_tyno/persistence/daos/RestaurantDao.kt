package com.padc.fooddelivery_assigment_tyno.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM tbRestaurant")
    @ColumnInfo
    fun getAllRestaurantList(): LiveData<List<RestaurantVO>>

    @Query("DELETE FROM tbRestaurant")
    @ColumnInfo
    fun deleteAll()

    @Query("SELECT * FROM tbRestaurant WHERE id=:restaurantID")
    @ColumnInfo
    fun  getRestaurantItembyRestaurantID(restaurantID: String) : LiveData<RestaurantVO>

    @Query("SELECT * FROM tbRestaurant WHERE id=:restaurantID")
    @ColumnInfo
    fun getFoodListByRestaurantId(restaurantID: String): LiveData<List<RestaurantVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @ColumnInfo
    fun insertAllRestaurant(restaurantVO:  List<RestaurantVO>)

}