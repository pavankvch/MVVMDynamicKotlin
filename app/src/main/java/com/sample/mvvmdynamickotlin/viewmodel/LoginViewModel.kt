package com.sample.mvvmdynamickotlin.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.sample.mvvmdynamickotlin.ui.LoginListener

class LoginViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var loginListener: LoginListener? = null

    fun onLoginButtonClick(view: View) {

        loginListener?.onStarted()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            loginListener?.onFailure()
            return
        }

        loginListener?.onSuccess()
    }
}