package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.adapters.ViewPagerTwoAdapter
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.fragment_intro_one.*

class IntroActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context : Context) : Intent {
            return Intent(context,IntroActivity::class.java)
        }
    }
    private lateinit var viewPagerTwoAdapter : ViewPagerTwoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)


        viewPagerTwoAdapter = ViewPagerTwoAdapter(this)
        introViewPager.adapter = viewPagerTwoAdapter
        TabLayoutMediator(tabLayout,introViewPager){tab,position->{
        }}.attach()

        btnCreateAccount.setOnClickListener {
           startActivity(RegisterActivity.newIntent(this))
        }

        tvLogin.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }

    }
}