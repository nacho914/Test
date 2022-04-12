package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startRequest()

    }

    fun startRequest(){
        ServiceBuilder.buildService()?.getOrders()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError {
                Log.d("nana", "ERROR")
            }
            ?.doOnNext {
                var finalPrice=0
                val list = it.order

                list?.let {

                    for (order in list) {

                        when (order.size){
                            "small"->{
                                finalPrice+=4
                            }
                            "medium"->{
                                finalPrice+=8
                            }
                            "large"-> {
                                finalPrice+=15
                            }
                        }
                    }
                }
                Log.d("nana","Order Price $finalPrice")
                finalPrice=0
            }?.subscribe()
    }


}