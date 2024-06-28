package com.samuel.sisvita17.data.model

data class TituloResponse(
    val message: String,
    val status: Int,
    val data: ArrayList<TituloData>
)
data class TituloData(
    val titulo_id: Int,
    val titulo_name: String
)