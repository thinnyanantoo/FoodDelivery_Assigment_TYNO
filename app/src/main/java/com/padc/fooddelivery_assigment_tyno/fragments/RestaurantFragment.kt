package com.padc.fooddelivery_assigment_tyno.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.activities.DetailActivity
import com.padc.fooddelivery_assigment_tyno.adapters.FoodItemAdapter
import com.padc.fooddelivery_assigment_tyno.adapters.RestaurantAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.mvp.impl.RestaurantPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.RestaurantPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.RestaurantView
import kotlinx.android.synthetic.main.fragment_restaurant.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantFragment : Fragment(), RestaurantView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mFoodItemAdapter: FoodItemAdapter
    private lateinit var mRestaurantAdapter: RestaurantAdapter

    private lateinit var mPresenter: RestaurantPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun newFragment(): RestaurantFragment {
        return RestaurantFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }


    private fun setUpRecycler() {
        mFoodItemAdapter = FoodItemAdapter()
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFoodItem.layoutManager = linearLayoutManager
        rvFoodItem.adapter = mFoodItemAdapter

        mRestaurantAdapter = RestaurantAdapter(mPresenter)
        val linearLayoutManagerRestaurant =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvRestaurantItem.layoutManager = linearLayoutManagerRestaurant
        rvRestaurantItem.adapter = mRestaurantAdapter

    }

    private fun setUpPresenter() {
        mPresenter =
            ViewModelProviders.of(requireActivity()).get(RestaurantPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    companion object {

        fun newInstance() = RestaurantFragment.apply { }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RestaurantFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RestaurantFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayRestaurantList(restaurantList: List<RestaurantVO>) {
        mRestaurantAdapter.setNewData(restaurantList)
    }

    override fun displayCategroyList(foodList: List<CategoryVO>) {
        mFoodItemAdapter.setNewData(foodList)
    }

    override fun navigateToDetialActivity(restaurantVO: RestaurantVO) {
        context?.let {
            startActivity(DetailActivity.newIntent(it,restaurantVO.id))
        }
    }

    override fun showError(error: String) {
    }
}