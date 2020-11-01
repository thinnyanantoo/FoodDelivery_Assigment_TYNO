package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.RestaurantDelegate
import kotlinx.android.synthetic.main.rv_recycler_restaurant_two.view.*

class RestaurantTwoViewHolder(itemView : View,val delegate : RestaurantDelegate) : BaseViewHolder<RestaurantVO>(itemView){
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapRestaurantItem(it)
            }
        }
    }
    override fun bindData(data: RestaurantVO) {
        mData = data
        itemView.tvREstaurantTwoAddress.text = data.address
        itemView.tvRestaurantTwoName.text = data.name
        itemView.tvRestaurantTwoRate.text = data.rating.toString()

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivRestaurantTwo)

    }
}