package com.padc.fooddelivery_assigment_tyno.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.example.fooddeliveryapp.mvp.presenters.impls.IntroPresenterImpl
import com.example.fooddeliveryapp.mvp.views.IntroView
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.mvp.impl.LoginPresenterImpl
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseActivity() , IntroView {

    private lateinit var mPresenter: IntroPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        setUpPresenter()
        setUpActionListeners()
    }
    private fun setUpActionListeners() {
        btn_get_started.setOnClickListener{
            mPresenter.onTapGettingStarted()
            this.finish()
        }
    }
    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(IntroPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }
}