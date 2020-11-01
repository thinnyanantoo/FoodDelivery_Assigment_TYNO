package com.padc.fooddelivery_assigment_tyno.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.ImageHeaderParserUtils
import com.padc.fooddelivery_assigment_tyno.R
import com.padc.fooddelivery_assigment_tyno.data.models.AuthenticationModel
import com.padc.fooddelivery_assigment_tyno.data.models.impls.AuthenticationModelImpl
import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO
import com.padc.fooddelivery_assigment_tyno.mvp.impl.AccountPresenterImpl
import com.padc.fooddelivery_assigment_tyno.mvp.presenters.AccountPresenter
import com.padc.fooddelivery_assigment_tyno.mvp.views.AccountView
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import java.io.IOException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() , AccountView {

    private val mAuthModel : AuthenticationModel = AuthenticationModelImpl

    private lateinit var mPresenter : AccountPresenter
    private var mbitmap: Bitmap? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpListener()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(AccountPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListener(){
        btnEdit.setOnClickListener {
            mPresenter.onTapEdit()
        }
        btnSave.setOnClickListener {
            mbitmap?.let { mPresenter.onTapUpdateProfileUpload(it) }
        }
    }

    companion object {
        const val PICK_IMAGE_REQUEST = 1111
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data
            try {

                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source? =
                            context?.contentResolver?.let { it1 ->
                                ImageDecoder.createSource(
                                    it1,
                                    it
                                )
                            }
                        val bitmap = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                        mbitmap = bitmap
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver,filePath)
                        mbitmap = bitmap
                        ivProfile.setImageBitmap(mbitmap)
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    override fun displayUser(userVO: UserVO) {
        etNameProfile.setText(userVO.name)
        etEmailProfile.setText(userVO.email)
        Glide.with(ivProfile.context)
            .load(userVO.photo)
            .placeholder(R.drawable.ic_launcher_background)
            .into(ivProfile)
    }

    override fun editUser() {
        openGallery()
    }

    override fun showError(error: String) {
    }

    fun openGallery(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }
}