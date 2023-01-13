package uz.gita.composemobilebanking.model.remote.request

data class SignInRequest(
    val phone: String,
    val password: String
)
