package com.m7amdelbana.hanginkotlin.network.endpoint.auth

import com.m7amdelbana.hanginkotlin.network.api.APIOperationListener
import com.m7amdelbana.hanginkotlin.network.model.SignForm
import com.m7amdelbana.hanginkotlin.network.model.Token

object AuthRepository {

    var authExecutor: AuthExecutor? = null

    fun register(requestId: Int, signForm: SignForm, listener: APIOperationListener) {
        authExecutor = AuthExecutor()
        authExecutor!!.register(requestId, signForm, listener)
    }
}