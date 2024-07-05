package com.samuel.sisvita17.data.model.response

data class AnsiedadSemaforoResponse (
    val message:String,
    val data: ArrayList<ASData>,
    val status: Int
)
data class ASData(
    val ans_sem_id : Int,
    val semaforo: String
)