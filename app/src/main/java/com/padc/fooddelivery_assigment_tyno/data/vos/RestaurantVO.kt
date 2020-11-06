package com.padc.fooddelivery_assigment_tyno.data.vos

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import com.padc.fooddelivery_assigment_tyno.persistence.typeConverters.FoodTypeConverter

@IgnoreExtraProperties
@Entity(tableName = "tbRestaurant")
@SuppressWarnings
@TypeConverters(FoodTypeConverter::class)
data class RestaurantVO(
    @SerializedName("address") var address: String? = " ",
    @SerializedName("delivery_type")var deliveryType : String? = " ",
    @SerializedName("food_type")var foodType : String? = "",
    @SerializedName("foods")var foods : ArrayList<FoodVO> = arrayListOf(),

    @PrimaryKey
    @SerializedName("id") var id : String = "",

    @SerializedName("image")var image : String? = "",
    @SerializedName("long_time")var longTime :String? = "",
    @SerializedName("name")var name : String = "",
    @SerializedName("phnone_number")var phoneNumber : String? = "",
    @SerializedName("rating")var rating : Float= 0f
)

