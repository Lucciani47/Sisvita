package com.samuel.sisvita17.data.model.response

data class TestResponse(
    val message: String,
    val status: Int,
    val puntuacion: Int,
    val semaforo: String
)