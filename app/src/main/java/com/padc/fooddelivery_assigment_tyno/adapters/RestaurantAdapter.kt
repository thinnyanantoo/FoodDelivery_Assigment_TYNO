package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantRecyclerViewHolder

class RestaurantAdapter(private var delegate : RestaurantDelegate) : BaseRecyclerAdapter<RestaurantRecyclerViewHolder,RestaurantVO>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_recycler_restruant, parent, false)
        return RestaurantRecyclerViewHolder(view,delegate)
    }
}