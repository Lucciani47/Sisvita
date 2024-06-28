package com.samuel.sisvita17.data.model

data class RegistrarUsuarioRequest(
    val nombre: String,
    val apellido_paterno: String,
    val apellido_materno: String,
    val correo_electronico: String,
    val contrasena: String,
    val ubigeo: Int
)
