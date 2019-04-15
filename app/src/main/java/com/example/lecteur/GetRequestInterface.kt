package com.example.lecteur

import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.sql.CommonDataSource

interface GetRequestInterface {
    //    @GET("{date}")
//    fun getCall(@Path("date") date: String): Call<Translation>
//
    @GET("login/cellphone")
    fun getCallAsync(@Query("phone") phone: String, @Query("password") password: String): Deferred<Translation>
}