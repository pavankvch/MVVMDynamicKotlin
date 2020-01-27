package com.sample.mvvmdynamickotlin.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.mvvmdynamickotlin.network.ApiClient
import com.sample.mvvmdynamickotlin.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(email: String, password: String): LiveData<String> {


        val loginResponse = MutableLiveData<String>()


        ApiClient.create().postLogin(email, password).enqueue(object : Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    loginResponse.value = response.body()?.message
                } else {
                    loginResponse.value = response.message()
                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.value = t.message

            }
        })

        return loginResponse
    }
}