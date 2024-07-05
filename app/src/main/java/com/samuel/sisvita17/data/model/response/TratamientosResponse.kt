package com.samuel.sisvita17.data.model.response

data class TratamientosResponse(
    val message: String,
    val status: Int,
    val data: ArrayList<TratamientosData>
)
data class TratamientosData(
    val tratamiento_id : Int,
    val tratamiento_nombre:String
)

