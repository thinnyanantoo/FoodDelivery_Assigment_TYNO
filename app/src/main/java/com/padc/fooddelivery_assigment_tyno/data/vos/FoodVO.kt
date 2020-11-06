package com.padc.fooddelivery_assigment_tyno.data.vos

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName
import com.google.gson.annotations.SerializedName
import io.grpc.InternalChannelz.id

@IgnoreExtraProperties
data class FoodVO (
    @get:PropertyName("id") @set:PropertyName("id") var id : String = "",
    @get:PropertyName("ingredients")@set:PropertyName("ingredients")var ingredients : String = "",
    @get:PropertyName("fprize") @set:PropertyName("fprize")var prize : String= "",
    @get:PropertyName("fimage") @set:PropertyName("fimage")var image : String="",
    @get:PropertyName("fname") @set:PropertyName("fname")var name : String = "",
    @get:PropertyName("popularity") @set:PropertyName("popularity")var popularity : Boolean = true,
    @SerializedName("item_count")var itemCount : Long = 0,
    @SerializedName("total_Amount")var totalAmount : Long = 0
    ) {
}