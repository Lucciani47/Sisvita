package com.samuel.sisvita17.data.model.response

data class NivelAnsiedadResponse (
    val message: String,
    val status: Int,
    val data: ArrayList<NivelAnsiedadData>
)
data class NivelAnsiedadData(
    val ansiedad_id : Int,
    val nivel : String,
    val ans_sem_id :Int
)