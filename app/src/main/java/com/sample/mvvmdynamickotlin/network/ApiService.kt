package com.sample.mvvmdynamickotlin.network

import com.sample.mvvmdynamickotlin.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun postLogin(@Field("email") email: String, @Field("password") password: String): Call<LoginResponse>
}