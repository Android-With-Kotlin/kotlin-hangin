package com.m7amdelbana.hanginkotlin.view.auth

import android.os.Handler

class LoginInteractor {

    interface OnLoginFinishedListener {

        fun success()
        fun error()
    }

    fun login(email: String, password: String, listener: OnLoginFinishedListener) {

        // ------------------------------------
        // ------- Mock The API Calling -------
        // ------------------------------------

        Handler().postDelayed({
            when {
                email == "username@domain.com"
                        && password == "123456" -> listener.success()
                else -> listener.error()
            }
        }, 3000)
    }
}