package com.samuel.sisvita17.data.model.request

data class TestRequest (
    val preguntas: ArrayList<TestRequestPregunta>,
    val usuario_id: Int,
    val fecha_fin: String,
)

data class TestRequestPregunta(
    val pregunta_id: Int,
    val opcion_id: Int
)