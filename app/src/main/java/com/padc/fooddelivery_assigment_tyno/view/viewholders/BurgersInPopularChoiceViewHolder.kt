package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.data.models.FoodModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.FoodModelImpl
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.delegates.DetailDelegate
import com.padc.fooddelivery_assigment_tyno.mvp.views.BaseView
import kotlinx.android.synthetic.main.rv_burgers_in_popular.*
import kotlinx.android.synthetic.main.rv_burgers_in_popular.view.*
import kotlinx.android.synthetic.main.rv_food_item.*
import kotlinx.android.synthetic.main.rv_food_item.view.*
import kotlinx.android.synthetic.main.rv_popular_choice.view.*

class BurgersInPopularChoiceViewHolder(itemView : View,delegate : DetailDelegate): BaseViewHolder<FoodVO>(itemView) {
    private var mModel : FoodModel = FoodModelImpl
    override fun bindData(data: FoodVO) {
        mData = data
        itemView.foodName.text = data.name
        itemView.foodDescription.text = data.ingredients
        itemView.foodPrize.text = data.prize
    }

    init {
        itemView.shoppinCartInPopular.setOnClickListener {
            mData?.let {
                delegate.onTapAddCart(
                    it)
            }
        }
    }


}