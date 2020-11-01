package com.padc.fooddelivery_assigment_tyno.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.padc.fooddelivery_assigment_tyno.R
import kotlinx.android.synthetic.main.bottom_sheet_checkout.*

class BottomSheetCheckOutFragment (): BottomSheetDialogFragment(){

    private var fragmentView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.bottom_sheet_checkout, container, false)
        return fragmentView
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