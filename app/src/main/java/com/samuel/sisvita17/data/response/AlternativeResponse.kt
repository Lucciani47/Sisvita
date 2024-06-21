package com.samuel.sisvita17.data.response

data class AlternativeResponse(
    val idAlternativa: Int,
    val idTipoTest: Int,
    val descripcion: String,
    val puntaje: Int,
    val puntajeInvertido: Int
)
