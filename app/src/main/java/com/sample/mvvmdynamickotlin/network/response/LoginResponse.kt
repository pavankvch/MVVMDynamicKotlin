package com.sample.mvvmdynamickotlin.network.response

import com.sample.mvvmdynamickotlin.model.User

data class LoginResponse( val isSuccessful : Boolean?,
                          val message: String?,
                          val user: User?)
