package com.padc.fooddelivery_assigment_tyno.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "tbCategory")
class CategoryVO (
    @PrimaryKey
    @SerializedName("id") var id : String ="",

    @SerializedName("name")var name: String? = "",
    @SerializedName("image")var image : String ? = "")