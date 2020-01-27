package com.sample.mvvmdynamickotlin.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.sample.mvvmdynamickotlin.repositories.UserRepository
import com.sample.mvvmdynamickotlin.ui.LoginListener

class LoginViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var loginListener: LoginListener? = null

    fun onLoginButtonClick(view: View) {

        loginListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginListener?.onFailure("Login Failed")
            return
        }

        val loginResponse=UserRepository().userLogin(email!!, password!!)

        loginListener?.onSuccess(loginResponse)
    }
}