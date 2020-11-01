package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.FoodItemRecyclerViewHolderTwo

class FoodItemAdapterTwo(private var mDelegate : RestaurantDelegate) : BaseRecyclerAdapter<FoodItemRecyclerViewHolderTwo,RestaurantVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodItemRecyclerViewHolderTwo {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_food_item_two, parent, false)
        return FoodItemRecyclerViewHolderTwo(view,mDelegate)
    }

}