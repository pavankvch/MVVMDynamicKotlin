package com.sample.mvvmdynamickotlin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        private val okHttpInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(okHttpInterceptor)
            .build()

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}