package com.m7amdelbana.hanginkotlin.view.auth.login

class LoginPresenter(var loginView: LoginView?, val loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {

    fun validateCredentials(email: String, password: String) {
        when {
            email.isEmpty() -> loginView!!.emailError()
            password.isEmpty() -> loginView!!.passwordError()
            else -> {
                loginView!!.showProgress()
                loginInteractor.login(email, password, this)
            }
        }
    }

    fun onDestroy() {
        loginView = null
    }

    override fun error() {
        if (loginView != null) {
            loginView!!.hideProgress()
            loginView!!.invalidCredentials()
        }
    }

    override fun success() {
        if (loginView != null) {
            loginView!!.hideProgress()
            loginView!!.validCredentials()
        }
    }
}