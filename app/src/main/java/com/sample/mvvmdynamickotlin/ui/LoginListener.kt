package com.sample.mvvmdynamickotlin.ui

import androidx.lifecycle.LiveData

interface LoginListener{


    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onFailure(s: String)
}