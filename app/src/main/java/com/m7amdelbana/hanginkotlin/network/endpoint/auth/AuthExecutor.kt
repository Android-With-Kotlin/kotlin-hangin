package com.m7amdelbana.hanginkotlin.network.endpoint.auth

import com.m7amdelbana.hanginkotlin.network.api.APIObserver
import com.m7amdelbana.hanginkotlin.network.api.ApiClient
import com.m7amdelbana.hanginkotlin.network.api.APIOperationListener
import com.m7amdelbana.hanginkotlin.network.model.SignForm
import com.m7amdelbana.hanginkotlin.network.model.Token
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthExecutor {

    fun register(requestId: Int, signForm: SignForm, listener: APIOperationListener) {
        val authService = ApiClient.client!!.create(
            AuthService::class.java
        )
        val observable = authService.register(signForm)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(APIObserver.getObserver(requestId, listener))
    }
}
