package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View

import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import kotlinx.android.synthetic.main.rv_check_out.view.*



class CheckViewHolder(itemView: View) :
    BaseViewHolder<OrderListVO>(itemView) {

    init {
    }

    override fun bindData(data: OrderListVO) {
        mData = data
        data?.let {
             itemView.tvOrderedItemName.text = "${data.name} + ${data.quantity}"
             itemView.tvOrderedItemPrice.text = "${data.price * data.quantity}"


        }
    }
}