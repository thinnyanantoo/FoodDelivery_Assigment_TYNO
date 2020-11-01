package com.padc.fooddelivery_assigment_tyno.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.mvp.impl.RegisterPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.RegisterPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile_actvity.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class RegisterActivity : BaseActivity(), RegisterView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private lateinit var mPresenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(findViewById((R.id.toolbar)))

        setUpPresenter()
        setUpActionListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpActionListeners() {
        btnSignUp.setOnClickListener {
            mPresenter.onTapRegister(
                etUserName.text.toString(),
                etEmailUP.text.toString(),
                etPasswordUP.text.toString(),
                etPhone.text.toString()
            )
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }
}