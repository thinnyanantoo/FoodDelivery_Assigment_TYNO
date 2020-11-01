package com.padc.fooddelivery_assigment_tyno.network.auth

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.padc.fooddelivery_assigment_tyno.data.vos.UserVO

object FirebaseAuthManager : AuthManager {
    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please Check Internet Connection")
            }
        }
    }


    override fun register(
        userName: String,
        email: String,
        password: String,
        phone: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(
                        userName
                    ).build()
                )
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please Check Internet Connection")
            }
        }
    }

    override fun userData(onSuccess: (userVO: UserVO) -> Unit, onFailure: (String) -> Unit) {
            var userVO: UserVO = UserVO()
            userVO?.name = mFirebaseAuth.currentUser?.displayName.toString()
            userVO?.email = mFirebaseAuth.currentUser?.email.toString()
            userVO?.photo = mFirebaseAuth.currentUser?.photoUrl.toString()
            onSuccess(userVO)

            onFailure("Empty UserData")

    }

    override fun updateProfile(photo: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mFirebaseAuth.currentUser?.updateProfile(UserProfileChangeRequest.Builder().setPhotoUri(Uri.parse(photo)).build())?.addOnCompleteListener {
            task ->  if(task.isSuccessful){
            onSuccess()
        } else {
            onFailure("Update failed")
        }
        }

    }


}