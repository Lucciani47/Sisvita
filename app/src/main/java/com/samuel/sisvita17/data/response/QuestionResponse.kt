package com.samuel.sisvita17.data.response

data class QuestionResponse(
    val idPregunta: Int,
    val idTipoTest: Int,
    val enunciado: String,
    val imagen: String,
    val invertida: Boolean,
)
