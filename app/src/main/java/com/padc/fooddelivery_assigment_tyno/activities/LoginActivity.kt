package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.fragments.RestaurantFragment
import com.padc.fooddelivery_assigment_tyno.mvp.impl.LoginPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.LoginPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : BaseActivity() , LoginView {

    companion object {
        fun newIntent(context : Context): Intent {
            return Intent(context,LoginActivity::class.java)
        }
    }

    private lateinit var mPresenter : LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById((R.id.toolbar)))

        setUpPresenter()
        setUpActionListeners()
        mPresenter.onUiReady(this)
    }


    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpActionListeners(){
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(etEmail.text.toString(),etPassword.text.toString())
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }


    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }


}