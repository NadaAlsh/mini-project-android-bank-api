package com.joincoded.bankapi.network

import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.Credentials
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface BankApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.signinEndpoint)
    suspend fun signin(@Body credentials: Credentials): Response<TokenResponse>

    @POST(Constants.transferEndpoint)
    suspend fun transfer(@Body amountChange: AmountChange): Response<TokenResponse>
@FormUrlEncoded
    @POST(Constants.authentication)
    fun login(
        @Field("Username") username: String,
        @Field("Password") password: String,

        ): Any

    @PUT(Constants.depositEndpoint)
    suspend fun deposit(
        @Header(Constants.authorization) token: String?,
        @Body amountChange: AmountChange
    ): Response<Unit>

    @PUT(Constants.updateEndpoint)
    suspend fun updateUser(@Body user: User)
}


