package com.padc.fooddelivery_assigment_tyno.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.activities.CartActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.bottom_sheet_checkout.*
import okhttp3.internal.notifyAll

class BottomSheetCheckOutFragment : BottomSheetDialogFragment(){


    companion object {
        const val CHECK_OUT_TAG = "CHECK_OUT_TAG"

        fun newInstance() : BottomSheetCheckOutFragment {
            return BottomSheetCheckOutFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_checkout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnTrackMyOrder.setOnClickListener {
            this.dialog?.dismiss()
        }
        btnOrderSomethingElse.setOnClickListener {
            this.dialog?.dismiss()
        }
    }


}