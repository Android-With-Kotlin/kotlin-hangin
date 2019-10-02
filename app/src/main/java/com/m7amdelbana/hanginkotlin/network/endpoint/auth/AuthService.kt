package com.m7amdelbana.hanginkotlin.network.endpoint.auth

import com.m7amdelbana.hanginkotlin.network.api.API.USERS_REGISTER
import com.m7amdelbana.hanginkotlin.network.model.SignForm
import com.m7amdelbana.hanginkotlin.network.model.Token
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST(USERS_REGISTER)
    fun register(@Body signForm: SignForm): Single<Token>
}