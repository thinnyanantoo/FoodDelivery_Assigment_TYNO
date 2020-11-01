package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.fragments.AccountFragment
import com.padc.fooddelivery_assigment_tyno.fragments.OffersFragment
import com.padc.fooddelivery_assigment_tyno.fragments.RestaurantFragment
import com.padc.fooddelivery_assigment_tyno.fragments.RestaurantFragmentTwo
import com.padc.fooddelivery_assigment_tyno.mvp.impl.MainPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.MainPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private var restaurantFragment = 0

    private lateinit var mPresenter: MainPresenter

    override fun showViewType(type: String) {
        when (type) {
            0.toString() -> {
                restaurantFragment = supportFragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, RestaurantFragment.newInstance("A", "B"))
                    .commit()
            }
            1.toString() -> {
                restaurantFragment = supportFragmentManager.beginTransaction()
                    .replace(R.id.frameContainer, RestaurantFragmentTwo.newInstance("A", "B"))
                    .commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setUpPresenter()

        if (savedInstanceState == null) {
           restaurantFragment
        }

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.item_bottom_navigation_home -> {
                        restaurantFragment
                        return true
                    }
                    R.id.item_bottom_navigation_offers -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainer, OffersFragment.newInstance("A", "B"))
                            .commit()
                        return true
                    }
                    R.id.item_bottom_navigation_accounts -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameContainer, AccountFragment.newInstance("A", "B"))
                            .commit()
                        return true
                    }
                }
               return false
            }
        })
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}