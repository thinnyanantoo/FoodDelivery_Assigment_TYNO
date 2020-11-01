package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.TouchDelegate
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import kotlinx.android.synthetic.main.rv_food_item_two.view.*

class FoodItemRecyclerViewHolderTwo(itemView : View,delegate: RestaurantDelegate) : BaseViewHolder<RestaurantVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapRestaurantItem(it)
            }
        }
    }
    override fun bindData(data: RestaurantVO) {
        mData = data
        itemView.tvNameInTwo.text = data.name
        itemView.tvRateInTwo.text = data.rating.toString()
        itemView.tvAddressInTwo.text = data.address.toString()

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivImageInTwo)
    }
}