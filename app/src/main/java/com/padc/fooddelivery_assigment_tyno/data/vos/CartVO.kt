package com.padc.fooddelivery_assigment_tyno.data.vos

import com.google.firebase.database.PropertyName

class CartVO (
    @get:PropertyName("id") @set:PropertyName("id") var id : String = "",
    @get:PropertyName("cart_name") @set:PropertyName("cart_name") var itemName : String = "",
    var price : Int = 0,
    var amount : Int = 0
    )