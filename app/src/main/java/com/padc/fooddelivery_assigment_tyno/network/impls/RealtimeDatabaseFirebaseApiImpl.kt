package com.padc.fooddelivery_assigment_tyno.network.impls

import android.graphics.Bitmap
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.padc.fooddelivery_assigment_tyno.adapters.RestaurantAdapter
import com.padc.fooddelivery_assigment_tyno.data.vos.CategoryVO
import com.padc.fooddelivery_assigment_tyno.data.vos.FoodVO
import com.padc.fooddelivery_assigment_tyno.data.vos.OrderListVO
import com.padc.fooddelivery_assigment_tyno.data.vos.RestaurantVO
import com.padc.fooddelivery_assigment_tyno.network.FirebaseApi
import io.reactivex.internal.util.NotificationLite.getValue
import java.io.ByteArrayOutputStream
import java.util.*

object RealtimeDatabaseFirebaseApiImpl : FirebaseApi {

    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference
    private val database: DatabaseReference = Firebase.database.reference
    override fun getRestaurants(
        id: String,
        onSuccess: (restaurants: List<RestaurantVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("restaurants").child(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val restaurantList = arrayListOf<RestaurantVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(
                        RestaurantVO::class.java
                    )?.let {
                        restaurantList.add(it)
                    }
                }
                onSuccess(restaurantList)
            }
        })
    }

    override fun getCategories(
        onSuccess: (categories: List<CategoryVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("categories").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val categoryList = arrayListOf<CategoryVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(
                        CategoryVO::class.java
                    )?.let {
                        categoryList.add(it)
                    }
                }
                onSuccess(categoryList)
            }
        })
    }

    override fun getPopularFood(onSuccess: (foodList: List<FoodVO>) -> Unit,onFailure: (String) -> Unit) {
        database.child("foods/id/popularity").equalTo("true").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val foodList = arrayListOf<FoodVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(
                        FoodVO::class.java
                    )?.let {
                        foodList.add(it)
                    }
                }
                onSuccess(foodList)
            }
        })
    }

    override fun getFoods(
        restaurantId: String,
        onSuccess: (foodList: List<FoodVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        database.child("restaurants/${restaurantId}/foods").addValueEventListener(object :
            ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var restaurant: RestaurantVO = RestaurantVO()
                val foodList = arrayListOf<FoodVO>()
                for (dataSnapShot: DataSnapshot in snapshot.children) {
                    dataSnapShot.let {
                        var foodVO = FoodVO()
                        foodVO.id = dataSnapShot.child("id").getValue(String::class.java).toString()
                        foodVO.name =
                            dataSnapShot.child("fname").getValue(String::class.java).toString()
                        foodVO.image =
                            dataSnapShot.child("fimage").getValue(String::class.java).toString()
                        foodVO.prize =
                            dataSnapShot.child("fprize").getValue(String::class.java).toString()
                        foodVO.ingredients =
                            dataSnapShot.child("ingredients").getValue(String::class.java)
                                .toString()
                        foodVO.popularity =
                            dataSnapShot.child("popularity").getValue(String::class.java)?.toBoolean()!!
                        foodList.add(foodVO)
                    }
                }
                onSuccess(foodList)
            }
        })
    }

    override fun uploadPhoto(
        image: Bitmap,
        onSuccess: (photo: String) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100,baos)
        val data = baos.toByteArray()

        val imageRef = RealtimeDatabaseFirebaseApiImpl.storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {
        }.addOnSuccessListener {
        }

        val urlTask = uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener {
            task ->
            val imageUrl = task.result?.toString()
            imageUrl?.let {
                onSuccess(it)
            }
        }
        onFailure
    }

    override fun addOrderedFoodIntoNetwork(id: Int, name: String, price: Int, qty: Int) {
        database.child("orderList").child(id.toString()).child(name).setValue(OrderListVO(name,price,qty))

    }

    override fun deleteOrderedFoodList(id: Int) {
        database.child("orderList").child(id.toString()).removeValue()

    }

    override fun getAllOrderedFoodDataById(
        onSuccess: (data: List<OrderListVO>) -> Unit,
        onFailure: (String) -> Unit,
        id: String
    ) {
        database.child("orderList").child(id.toString()).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
               onFailure
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val orderFoodList = arrayListOf<OrderListVO>()
            snapshot.children.forEach {
                dataSnapShot ->
                dataSnapShot.getValue(OrderListVO::class.java)?.let {
                    orderFoodList.add(it)
                }
            }
              onSuccess(orderFoodList)
            }
        })
    }
}