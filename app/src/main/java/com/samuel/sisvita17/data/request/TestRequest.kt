package com.samuel.sisvita17.data.request

import java.sql.Date

data class TestRequest(
    val idTipoTest: Int,
    val idPaciente: Int,
    val resultado: Int,
    val interpretacion: String,
    val fecha: Date
)
