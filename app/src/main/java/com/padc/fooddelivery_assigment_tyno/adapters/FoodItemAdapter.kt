package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.view.viewholders.FoodItemRecyclerViewHolder

class FoodItemAdapter : BaseRecyclerAdapter<FoodItemRecyclerViewHolder,CategoryVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_food_item, parent, false)
        return FoodItemRecyclerViewHolder(view)
    }
}