package uz.gita.composemobilebanking.model.remote.request

import com.google.gson.annotations.SerializedName

data class SignUpVerifyRequest(
    @SerializedName("token") val token: String,
    @SerializedName("code") val code: String
)
