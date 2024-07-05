package com.samuel.sisvita17.data.model.response

data class VigilanciaResponse(
    val data: ArrayList<VigilanciaData>,
    val message: String,
    val status: Int
)

data class VigilanciaData(
    val ansiedad_id: Int?,
    val apellidos: String,
    val diagnostico_id: Int?,
    val estado: String,
    val usuario_id:Int,
    var fecha_fin: String,
    val nivel: String,
    val nombre: String,
    val prueba_id: Int,
    val puntuacion: Int,
    val res_user_id: Int,
    val titulo: String,
    //val test_nivel: String,
    //val diag_ansiedad_nivel: String?,
    //val semaforo_nivel: String
)
