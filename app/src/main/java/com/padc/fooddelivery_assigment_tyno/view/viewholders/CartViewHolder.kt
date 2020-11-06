package com.padc.fooddelivery_assigment_tyno.view.viewholders

import android.view.View
import com.padc.fooddelivery_assigment_tyno.data.vos.CartVO

import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import kotlinx.android.synthetic.main.rv_cart.view.*

class CartViewHolder(itemView: View) :
    BaseViewHolder<CartVO>(itemView) {

    init {
    }

    override fun bindData(data: CartVO) {
        mData = data
        data?.let {
             itemView.tvOrderedItemName.text = "${data.itemName} + ${data.amount}"
             itemView.tvOrderedItemPrice.text = "${data.price * data.amount}"


        }
    }
}