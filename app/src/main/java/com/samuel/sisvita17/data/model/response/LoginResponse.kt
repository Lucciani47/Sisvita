package com.samuel.sisvita17.data.model.response

data class LoginResponse(
    val message: String,
    val status: Int,
    val rol : String,
    val data: Usuario
)