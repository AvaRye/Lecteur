package com.example.lecteur

import com.example.lecteur.login.TraLogin
import com.example.lecteur.myList.TraList
import com.example.lecteur.myListDetail.TraDetail
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GetRequestInterface {
    //    @GET("{date}")
//    fun getCall(@Path("date") date: String): Call<Translation>
//
    @GET("login/cellphone")
    fun getLoginAsync(@Query("phone") phone: String, @Query("password") password: String): Deferred<TraLogin>

    @GET("user/playlist")
    fun getListAsync(@Query("uid") uid: String): Deferred<TraList>

    @GET("playlist/detail")
    fun getDetailAsync(@Query("id") id: String): Deferred<TraDetail>

    @GET("song/url")
    fun getSongUrlAsync(@Query("id") id: String) : Deferred<TraList>//undone
}