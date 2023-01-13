package uz.gita.composemobilebanking.model.remote.respone

import com.google.gson.annotations.SerializedName

data class SignInVerifyResponse(
    @SerializedName("access-token")
    val accessToken: String,
    @SerializedName("refresh-token")
    val refreshToken: String
)
