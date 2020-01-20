package com.sample.mvvmdynamickotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sample.mvvmdynamickotlin.R
import com.sample.mvvmdynamickotlin.databinding.ActivityLoginBinding
import com.sample.mvvmdynamickotlin.utils.showToast
import com.sample.mvvmdynamickotlin.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), LoginListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.loginListener =this
        init()
    }

    fun init() {

    }

    override fun onStarted() {
        showToast("Login Started")
    }

    override fun onSuccess() {
        showToast("Login Successful")
    }

    override fun onFailure() {
        showToast("Login Failed")
    }
}