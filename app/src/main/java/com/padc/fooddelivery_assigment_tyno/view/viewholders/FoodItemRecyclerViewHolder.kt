package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import kotlinx.android.synthetic.main.rv_food_item.view.*
import kotlinx.android.synthetic.main.rv_recycler_restruant.view.*

class FoodItemRecyclerViewHolder(itemView: View) : BaseViewHolder<CategoryVO>(itemView)
{
    override fun bindData(data: CategoryVO) {
        itemView.tvNameInFoodItem.text = data.name

        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.ivFoodItem)
    }
}