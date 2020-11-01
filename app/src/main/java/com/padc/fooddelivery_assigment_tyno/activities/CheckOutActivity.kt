package com.padc.fooddelivery_assigment_tyno.activities

import android.app.ProgressDialog.show
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.adapters.CheckOutAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.impl.CheckOutPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.CheckOutPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.CheckOutView
import com.padc.fooddelivery_assigment_tyno.view.viewholders.CheckViewHolder
import kotlinx.android.synthetic.main.activity_check_out.*
import kotlinx.android.synthetic.main.bottom_sheet_checkout.view.*
import kotlinx.android.synthetic.main.rv_check_out.*
import kotlinx.android.synthetic.main.rv_restaurant_profile.*

class CheckOutActivity : AppCompatActivity() , CheckOutView {

    private lateinit var mPresneter : CheckOutPresenter
    private lateinit var mAdapter : CheckOutAdapter
    private lateinit var mOrderList : List<FoodVO>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        setUpPresenter()
        setUpRecyclerView()

        val id = intent.getStringExtra(DetailActivity.RESTAURANT_KEY).toString()
        btnCheckOut.setOnClickListener {
//            mPresneter.deleteOrderedFoodList(id)
            showBottomSheetDialog()
        }
        mPresneter.onUiReady(this,id)
    }

    companion object {
              const val RESTAURANT_ID = "RESTAURANT_ID"
              fun newIntent(context: Context,id: String) : Intent {
                  return Intent(context,CheckOutActivity::class.java).putExtra(RESTAURANT_ID,id)
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_checkout, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        view.btnTrackMyOrder.setOnClickListener {

            Toast.makeText(this, "Order Track Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
            exitActivity()

        }
        view.btnOrderSomethingElse.setOnClickListener {
            Toast.makeText(this, "Order Cancel Clicked", Toast.LENGTH_SHORT).show()
            dialog?.dismiss()
        }
        dialog.show()
    }

    private fun exitActivity() {
        this.finish()
    }

    private fun setUpRecyclerView() {

        rvOrder.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mAdapter = CheckOutAdapter()
        rvOrder.adapter = mAdapter
    }

    private fun setUpPresenter() {
       mPresneter = ViewModelProviders.of(this).get(CheckOutPresenterImpl::class.java)
        mPresneter.initPresenter(this)

    }

    override fun showOrderFoods(data: List<OrderListVO>, restaurant: RestaurantVO) {
        mAdapter.setNewData(data.toMutableList())

        var subTotal = 0
        data.forEach{
            subTotal += (it.price * it.quantity)
        }
        tvOrderSubtotalAmount.text = "$$subTotal"
        Glide.with(this)
            .load(restaurant.image)
            .into(ivRestaurantProfile)
        tvRestaurantNameProfile.text = restaurant.name
        tvRestaurantrateProfile.text = restaurant.rating.toString()
        tvREstaurantaddressProfile.text = restaurant.address
    }

    override fun showError(error: String) {
    }
}