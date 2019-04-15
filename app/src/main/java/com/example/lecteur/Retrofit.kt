package com.example.lecteur

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class Retrofit {
    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("http://localhost:3000/")
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var request: GetRequestInterface = retrofit.create<GetRequestInterface>(GetRequestInterface::class.java)
}