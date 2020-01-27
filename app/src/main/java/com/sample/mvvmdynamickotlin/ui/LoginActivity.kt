package com.sample.mvvmdynamickotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sample.mvvmdynamickotlin.R
import com.sample.mvvmdynamickotlin.databinding.ActivityLoginBinding
import com.sample.mvvmdynamickotlin.utils.hide
import com.sample.mvvmdynamickotlin.utils.show
import com.sample.mvvmdynamickotlin.utils.showToast
import com.sample.mvvmdynamickotlin.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.loginListener = this
        init()
    }

    fun init() {

    }

    override fun onStarted() {
        progressBar.show()
        showToast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {

        loginResponse.observe(this, Observer {
            progressBar.hide()
            showToast(it)
        })
    }

    override fun onFailure(s: String) {
        progressBar.hide()
        showToast(s)
    }
}