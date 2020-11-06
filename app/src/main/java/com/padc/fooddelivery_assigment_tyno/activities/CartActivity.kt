package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.adapters.CartAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.CartVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.fragments.BottomSheetCheckOutFragment
import com.padc.fooddelivery_assigment_tyno.mvp.impl.CartPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.CartPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.CartView
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.bottom_sheet_checkout.*
import kotlinx.android.synthetic.main.rv_restaurant_profile.*

class CartActivity : AppCompatActivity(), CartView {

    companion object {
        val RESTAURANT_KEY = "RESTAURANT_KEY"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, CartActivity::class.java)
            intent.putExtra(RESTAURANT_KEY, id)
            return intent
        }
    }

    private lateinit var mPresneter: CartPresenter
    private lateinit var mAdapter: CartAdapter
    private lateinit var mOrderList: List<FoodVO>
    private var id: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        id = intent.getStringExtra(RESTAURANT_KEY).toString()

        setUpPresenter()
        setUpRecyclerView()
        mPresneter.onUiReady(this, id)

        btnCheckOut.setOnClickListener {
            mPresneter.onTapCheckOut()
        }

        tvAddMoreFoods.setOnClickListener {
            mPresneter.onTapAddMoreFoods()
        }
    }


//    private fun showBottomSheetDialog() {
//        val view = layoutInflater.inflate(R.layout.bottom_sheet_checkout, null)
//        val dialog = BottomSheetDialog(this)
//        dialog.setContentView(view)
//
//        view.btnTrackMyOrder.setOnClickListener {
//
//            Toast.makeText(this, "Order Track Clicked", Toast.LENGTH_SHORT).show()
//            dialog?.dismiss()
//            exitActivity()
//
//        }
//        view.btnOrderSomethingElse.setOnClickListener {
//            Toast.makeText(this, "Order Cancel Clicked", Toast.LENGTH_SHORT).show()
//            dialog?.dismiss()
//        }
//        dialog.show()
//    }
//
//    private fun exitActivity() {
//        this.finish()
//    }

    private fun setUpRecyclerView() {

        rvOrder.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mAdapter = CartAdapter()
        rvOrder.adapter = mAdapter
    }

    private fun setUpPresenter() {
        mPresneter = ViewModelProviders.of(this).get(CartPresenterImpl::class.java)
        mPresneter.initPresenter(this)

    }

//    override fun showOrderFoods(data: List<OrderListVO>, restaurant: RestaurantVO) {
//        mAdapter.setNewData(data.toMutableList())
//
//        var subTotal = 0
//        data.forEach{
//            subTotal += (it.price * it.quantity)
//        }
//        tvOrderSubtotalAmount.text = "$$subTotal"
//        Glide.with(this)
//            .load(restaurant.image)
//            .into(ivRestaurantProfile)
//        tvRestaurantNameProfile.text = restaurant.name
//        tvRestaurantrateProfile.text = restaurant.rating.toString()
//        tvREstaurantaddressProfile.text = restaurant.address
//    }

    override fun showRestauratnInformation(resInfo: RestaurantVO) {
       Glide.with(this)
           .load(resInfo.image)
           .into(ivRestaurantProfile)
        tvRestaurantNameProfile.text = resInfo.name
        tvRestaurantrateProfile.text = resInfo.rating.toString()
        tvREstaurantaddressProfile.text = resInfo.address
    }

    override fun displayOrderCart(cart: List<CartVO>) {
        mAdapter.setNewData(cart)
        var subtotal = 0
        for(order in cart) {
            subtotal = subtotal + order.price
        }
        tvOrderSubtotalAmount.text = "$$subtotal"
    }

    override fun showBottomSheet() {
          val bottomSheetCheckOutFragment : BottomSheetCheckOutFragment = BottomSheetCheckOutFragment.newInstance()
        bottomSheetCheckOutFragment.show(supportFragmentManager, BottomSheetCheckOutFragment.CHECK_OUT_TAG)


    }

    override fun navigateToDetailActivity() {
        startActivity(DetailActivity.newIntent(this,id))
    }


    override fun showError(error: String) {
    }
}