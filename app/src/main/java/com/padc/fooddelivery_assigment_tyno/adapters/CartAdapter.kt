package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.CartVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.view.viewholders.CartViewHolder

class CartAdapter: BaseRecyclerAdapter<CartViewHolder,CartVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_cart, parent, false)
        return CartViewHolder(view)
    }

}