package com.padc.fooddelivery_assigment_tyno.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.delegates.CheckOutDelegate
import com.padc.fooddelivery_assigment_tyno.view.viewholders.CheckViewHolder

class CheckOutAdapter: BaseRecyclerAdapter<CheckViewHolder,OrderListVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_check_out, parent, false)
        return CheckViewHolder(view)
    }

}