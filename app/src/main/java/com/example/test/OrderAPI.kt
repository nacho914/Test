package com.example.test
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface OrderAPI {

    @GET("/pgiani/KotlinTask/main/order.json")
    fun getOrders(): Observable<Order>

}
