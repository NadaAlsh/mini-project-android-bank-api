package com.joincoded.bankapi.network

import android.media.Image
import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.data.response.Transaction
import com.joincoded.bankapi.utils.Constants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface BankApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.signinEndpoint)
    suspend fun signin(@Body user: User): Response<TokenResponse>

    @POST(Constants.transferEndpoint)
    suspend fun transfer(@Header(Constants.authorization) token: String?,
                          @Path("userName") userName: String,
                          @Body amountChange: AmountChange): Response<TokenResponse>


    @PUT(Constants.depositEndpoint)
    suspend fun deposit(@Header(Constants.authorization) token: String?,
                        @Body amountChange: AmountChange
    ): Response<Unit>

    @PUT(Constants.withdrawEndpoint)
    suspend fun withdraw(@Header(Constants.authorization) token: String?,
                         @Body amountChange: AmountChange
    ): Response<Unit>

    @PUT(Constants.updateProfileEndpoint)
    suspend fun updateProfile(@Header(Constants.authorization) token: String?,
                              @Part("username") username: RequestBody,
                              @Part("password") passowrd: RequestBody,
                              @Part image: MultipartBody.Part? ): Response<TokenResponse>

    @GET(Constants.transactionsEndpoint)
    suspend fun getTransactions(@Header(Constants.authorization) token: String?): Response<List<Transaction>>


}