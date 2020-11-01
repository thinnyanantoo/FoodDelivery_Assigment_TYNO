package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.BaseViewHolder
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantRecyclerViewHolder
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantTwoViewHolder

class RestaurantTwoAdapter(private var mDelegate : RestaurantDelegate) : BaseRecyclerAdapter<RestaurantTwoViewHolder,RestaurantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantTwoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_recycler_restaurant_two, parent, false)
        return RestaurantTwoViewHolder(view,mDelegate)
    }
}