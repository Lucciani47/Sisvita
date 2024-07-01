package com.samuel.sisvita17.data.repository

import com.samuel.sisvita17.data.model.request.LoginRequest
import com.samuel.sisvita17.data.model.response.LoginResponse
import com.samuel.sisvita17.data.model.request.RegistrarUsuarioRequest
import com.samuel.sisvita17.data.model.response.RegistrarUsuarioResponse
import com.samuel.sisvita17.data.model.response.UsuarioResponse
import com.samuel.sisvita17.network.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun login(correo: String, contrasena: String, callback: (LoginResponse?) -> Unit) {
        val loginRequest = LoginRequest(correo_electronico = correo, contrasena = contrasena)
        RetrofitClient.apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                callback(response.body())
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
    fun registrarUsuario(nombre: String, apellidos: String,
                  correo: String, contrasena: String, ubigeo:Int ,callback: (RegistrarUsuarioResponse?) -> Unit){
        val registrarUsuarioRequest = RegistrarUsuarioRequest(
            nombre=nombre, apellidos = apellidos,
            correo_electronico = correo, contrasena = contrasena , ubigeo = ubigeo
        )
        RetrofitClient.apiService.registrarUsuario(registrarUsuarioRequest).enqueue(object : Callback<RegistrarUsuarioResponse>{
            override fun onResponse(call: Call<RegistrarUsuarioResponse>, response: Response<RegistrarUsuarioResponse>) {
                callback(response.body())
            }

            override fun onFailure(call: Call<RegistrarUsuarioResponse>, t:Throwable) {
                callback(null)
            }
        })
    }

    fun getUsuario(id:Int, callback: (UsuarioResponse?) -> Unit){
        RetrofitClient.apiService.getUsuario(id).enqueue(object : Callback<UsuarioResponse>{
            override fun onResponse(call: Call<UsuarioResponse>, response: Response<UsuarioResponse>) {
                callback(response.body())
            }
            override fun onFailure(call: Call<UsuarioResponse>, t:Throwable) {
                callback(null)
            }
        })
    }


}
