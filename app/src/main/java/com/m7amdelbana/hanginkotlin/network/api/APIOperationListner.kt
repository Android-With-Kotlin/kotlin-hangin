package com.m7amdelbana.hanginkotlin.network.api

interface APIOperationListener {

    fun onSuccess(requestId: Int, response: Any)
    fun onError(requestId: Int, error: APIError)
}

