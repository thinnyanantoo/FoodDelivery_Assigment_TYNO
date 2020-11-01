package com.padc.fooddelivery_assigment_tyno.persistence.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO

class FoodTypeConverter {
    @TypeConverter
    fun toString(dataList : FoodVO) : String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr : String): FoodVO {
        val dataListType = object : TypeToken<FoodVO>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}