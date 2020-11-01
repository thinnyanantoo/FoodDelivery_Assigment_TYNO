package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.rv_popular_choice.*

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
    private var detailData : RestaurantVO = RestaurantVO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpPresenter()
        setUpRecycler()

        mPresenter.onUiReady(intent.getStringExtra(RESTAURANT_KEY).toString(), this)
        tvImageNameInDetail.setOnClickListener {
            startActivity(CheckOutActivity.newIntent(this,detailData.id))
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

    override fun showFoodList(FoodList: List<FoodVO>) {
        mAdapter.setNewData(FoodList)
        mBurgerAdapter.setNewData(FoodList)
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

    override fun addOrderFood(): RestaurantVO {
        Toast.makeText(this,"food Added",Toast.LENGTH_SHORT).show()
        return detailData
    }
}