package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.rv_burgers_in_popular.view.*
import kotlinx.android.synthetic.main.rv_food_item.view.*
import kotlinx.android.synthetic.main.rv_popular_choice.view.*

class PopularChoiceRecyclerViewHolder(itemView: View, delegate: DetailDelegate) :
    BaseViewHolder<FoodVO>(itemView) {
    override fun bindData(data: FoodVO) {
        mData = data
        itemView.tvNameDetailItem.text = data.name
        itemView.tvPriceDetailIem.text = data.prize
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivImageDetailItem)
    }

    init {
        itemView.ivCart.setOnClickListener {
            mData?.let {
                delegate.onTapAddCart(
                    it)
            }
        }
    }
}