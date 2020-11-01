package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.activities.DetailActivity
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.PopularChoiceRecyclerViewHolder
import com.padc.fooddelivery_assigment_tyno.view.viewholders.RestaurantRecyclerViewHolder

class PopularChoiceAdapter(private val mDelegate : DetailDelegate) : BaseRecyclerAdapter<PopularChoiceRecyclerViewHolder,FoodVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_popular_choice, parent, false)
        return PopularChoiceRecyclerViewHolder(view,mDelegate)
    }
}