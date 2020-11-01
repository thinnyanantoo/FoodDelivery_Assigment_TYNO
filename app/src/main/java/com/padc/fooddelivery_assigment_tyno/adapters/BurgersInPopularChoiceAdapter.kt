package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.BurgersInPopularChoiceViewHolder
import com.padc.fooddelivery_assigment_tyno.view.viewholders.FoodItemRecyclerViewHolderTwo

class BurgersInPopularChoiceAdapter(private var mDelegate : DetailDelegate) : BaseRecyclerAdapter<BurgersInPopularChoiceViewHolder,FoodVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BurgersInPopularChoiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_burgers_in_popular, parent, false)
        return BurgersInPopularChoiceViewHolder(view,mDelegate)
    }

}