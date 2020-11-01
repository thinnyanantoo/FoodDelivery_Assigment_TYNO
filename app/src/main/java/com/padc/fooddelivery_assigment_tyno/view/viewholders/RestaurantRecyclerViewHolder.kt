package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import kotlinx.android.synthetic.main.rv_recycler_restruant.view.*

class RestaurantRecyclerViewHolder(itemView : View,delegate : RestaurantDelegate) : BaseViewHolder<RestaurantVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapRestaurantItem(it)
            }
        }
    }

    override fun bindData(data: RestaurantVO) {
        mData = data
        itemView.tvNameInRestaurant.text = data.name
        itemView.tvRateInRestaurant.text = data.rating.toString()
        itemView.tvAddress.text = data.address


        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivImageInRestaurant)
    }

}