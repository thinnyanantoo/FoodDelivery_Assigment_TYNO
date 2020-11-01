package com.padc.fooddelivery_assigment_tyno.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
data class FoodVO (
    @SerializedName("id")var id : String = "",
    @SerializedName("ingredients")var ingredients : String = "" ,
    @SerializedName("fprize")var prize : String= "",
    @SerializedName("fimage")var image : String="",
    @SerializedName("fname")var name : String = "",
    @SerializedName("popularity")var popularity : Boolean = true,
    @SerializedName("item_count")var itemCount : Long = 0,
    @SerializedName("total_Amount")var totalAmount : Long = 0
    ) {
}