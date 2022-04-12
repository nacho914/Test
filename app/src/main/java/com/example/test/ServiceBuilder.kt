package com.example.test

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val BASEURL = "https://raw.githubusercontent.com"

    private val retrogitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
    private val retrofitClient = retrogitBuilder.build()
    private val movieApi = retrofitClient.create(OrderAPI::class.java)

    fun buildService(): OrderAPI?{
        return movieApi
    }


}