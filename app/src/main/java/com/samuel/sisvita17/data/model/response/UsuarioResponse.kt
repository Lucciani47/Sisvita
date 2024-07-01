package com.samuel.sisvita17.data.model.response

data class UsuarioResponse(
    val data: Usuario,
    val message : String,
    val status: Int,
)
data class Usuario(
    val usuario_id: Int,
    val nombre: String,
    val fecha_registro: String,
    val correo_electronico :String,
    val apellidos : String,
    //val apellido_materno : String,
)
