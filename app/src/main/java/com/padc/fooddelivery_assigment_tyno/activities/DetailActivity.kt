package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.adapters.BurgersInPopularChoiceAdapter
import com.padc.fooddelivery_assigment_tyno.adapters.PopularChoiceAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.impl.DetailPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.DetailPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.DetailView
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), DetailView {

    companion object {
        val RESTAURANT_KEY = "RESTAURANT_KEY"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(RESTAURANT_KEY, id)
            return intent
        }
    }

    private lateinit var mAdapter: PopularChoiceAdapter
    private lateinit var mBurgerAdapter: BurgersInPopularChoiceAdapter
    private lateinit var mPresenter: DetailPresenter
    var itemCount =0
    private var id = ""
    private var detailData : RestaurantVO = RestaurantVO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpPresenter()
        setUpRecycler()
        id = intent.getStringExtra(RESTAURANT_KEY).toString()
        mPresenter.onUiReady(id, this)
        btnCart.setOnClickListener {
            startActivity(CartActivity.newIntent(this,detailData.id))
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mAdapter = PopularChoiceAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPopularChoice.layoutManager = linearLayoutManager
        rvPopularChoice.adapter = mAdapter

        mBurgerAdapter = BurgersInPopularChoiceAdapter(mPresenter)
        val linerLayoutManagerTwo = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvBurgersInPopular.layoutManager = linerLayoutManagerTwo
        rvBurgersInPopular.adapter = mBurgerAdapter
    }


    override fun bindData(restaurantVO: RestaurantVO) {
        detailData = restaurantVO
      restaurantVO.image?.let {
          Glide.with(this)
              .load(restaurantVO.image)
              .into(ivRestaurantImageInDetail)
      }
        tvImageNameInDetail.text = restaurantVO.name
        tvImageRateInDetail.text = restaurantVO.rating.toString()
        tvAddressInDetail.text = restaurantVO.address

    }

    override fun displayPopularFoods(foods: List<FoodVO>) {
        mBurgerAdapter.setNewData(foods)
    }

    override fun showFoodList(foods: List<FoodVO>) {
        mAdapter.setNewData(foods)
    }

    override fun addItemCount() {
        itemCount++
        btnCart.visibility = View.VISIBLE
        btnCart.text = "${itemCount} items in cart"
    }

    override fun navigateGoToCart() {
        startActivity(CartActivity.newIntent(this,id = id))
    }

}