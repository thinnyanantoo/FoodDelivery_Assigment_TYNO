package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import com.padc.fooddelivery_assigment_tyno.mvp.views.BaseView
import kotlinx.android.synthetic.main.rv_burgers_in_popular.*
import kotlinx.android.synthetic.main.rv_burgers_in_popular.view.*
import kotlinx.android.synthetic.main.rv_food_item.*
import kotlinx.android.synthetic.main.rv_food_item.view.*

class BurgersInPopularChoiceViewHolder(itemView : View,delegate : DetailDelegate): BaseViewHolder<FoodVO>(itemView) {
    override fun bindData(data: FoodVO) {
        itemView.foodName.text = data.name
        itemView.foodDescription.text = data.ingredients
        itemView.foodPrize.text = data.prize
    }


}