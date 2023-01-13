package uz.gita.composemobilebanking.model.remote.api

import uz.gita.composemobilebanking.model.remote.request.SignInRequest
import uz.gita.composemobilebanking.model.remote.request.SignInVerifyRequest
import uz.gita.composemobilebanking.model.remote.request.SignUpRequest
import uz.gita.composemobilebanking.model.remote.request.SignUpVerifyRequest
import uz.gita.composemobilebanking.model.remote.respone.SignInResponse
import uz.gita.composemobilebanking.model.remote.respone.SignInVerifyResponse
import uz.gita.composemobilebanking.model.remote.respone.SignUpResponse
import uz.gita.composemobilebanking.model.remote.respone.SignUpVerifyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/sign-in")
    suspend fun signIn(
        @Body data: SignInRequest
    ): Response<SignInResponse>

    @POST("auth/sign-up")
    suspend fun signUp(
        @Body data: SignUpRequest
    ): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    suspend fun signUpVerify(
        @Body data: SignUpVerifyRequest
    ): Response<SignUpVerifyResponse>

    @POST("auth/sign-in/verify")
    suspend fun signInVerify(
        @Body data: SignInVerifyRequest
    ): Response<SignInVerifyResponse>

}