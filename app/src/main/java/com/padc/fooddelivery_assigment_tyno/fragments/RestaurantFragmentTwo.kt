package com.padc.fooddelivery_assigment_tyno.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.WindowDecorActionBar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.activities.DetailActivity
import com.padc.fooddelivery_assigment_tyno.adapters.FoodItemAdapterTwo
import com.padc.fooddelivery_assigment_tyno.adapters.RestaurantTwoAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.impl.RestaurantPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.RestaurantPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.RestaurantView
import kotlinx.android.synthetic.main.fragment_restaurant.*
import kotlinx.android.synthetic.main.fragment_restaurant_two2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantFragmentTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantFragmentTwo : Fragment(), RestaurantView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mFoodItemAdapter: FoodItemAdapterTwo
    private lateinit var mRestaurantAdapter: RestaurantTwoAdapter
    private lateinit var mPresenter: RestaurantPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_two2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter =
            ViewModelProviders.of(requireActivity()).get(RestaurantPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mFoodItemAdapter = FoodItemAdapterTwo(mPresenter)
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFoodItemTwo.layoutManager = linearLayoutManager
        rvFoodItemTwo.adapter = mFoodItemAdapter

        mRestaurantAdapter = RestaurantTwoAdapter(mPresenter)
        val linearLayoutManagerTwo =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvRestaurantTwo.layoutManager = linearLayoutManagerTwo
        rvRestaurantTwo.adapter = mRestaurantAdapter


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RestaurantFragmentTwo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantFragmentTwo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayRestaurantList(restaurantList: List<RestaurantVO>) {
        mRestaurantAdapter.setNewData(restaurantList)
        mFoodItemAdapter.setNewData(restaurantList)
    }

    override fun displayCategroyList(foodList: List<CategoryVO>) {
    }

    override fun navigateToDetialActivity(restaurantVO: RestaurantVO) {
        context?.let {
            startActivity(DetailActivity.newIntent(it, restaurantVO.id))
        }
    }

    override fun showError(error: String) {
    }
}