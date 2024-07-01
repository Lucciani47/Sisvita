package com.samuel.sisvita17.data.model.request

data class RegistrarUsuarioRequest(
    val nombre: String,
    val apellidos: String,
    val correo_electronico: String,
    val contrasena: String,
    val ubigeo: Int
)
