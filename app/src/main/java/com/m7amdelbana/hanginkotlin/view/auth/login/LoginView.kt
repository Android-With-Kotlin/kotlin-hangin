package com.m7amdelbana.hanginkotlin.view.auth.login

interface LoginView {

    fun showProgress()
    fun hideProgress()
    fun emailError()
    fun passwordError()
    fun validCredentials()
    fun invalidCredentials()
}