package com.samuel.sisvita17.utils

import com.samuel.sisvita17.data.model.response.Usuario

object UserManager {
    private var usuario: Usuario? = null
    private var rol: String?= null
    private var activo: Boolean?= false

    fun setUser(user: Usuario, rol:String, activo:Boolean) {
        this.usuario = user
        this.rol = rol
        this.activo = activo
    }

    fun getUser(): Usuario? {
        return usuario
    }

    fun getRol(): String? {
        return rol
    }

    fun getActivo(): Boolean? {
        return activo
    }
    fun clearUser() {
        usuario = null
        rol = null
        activo = false
    }
}

