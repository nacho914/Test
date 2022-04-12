package com.example.test

import com.example.test.Order__1
import com.google.gson.annotations.Expose
import java.io.Serializable

class Order : Serializable {
    var order: List<Order__1>? = null

    companion object {
        private const val serialVersionUID = 8361882918909769658L
    }
}

class Order__1 : Serializable {
    var type: String? = null
    var size: String? = null
    var toppings: List<String>? = null
    var sauce: List<String>? = null

    companion object {
        private const val serialVersionUID = 6311995843371735276L
    }
}