package com.samuel.sisvita17.data.repository

import com.samuel.sisvita17.data.model.request.RegistrarEspecialistaRequest
import com.samuel.sisvita17.data.model.response.RegistrarUsuarioResponse
import com.samuel.sisvita17.data.model.response.TituloResponse
import com.samuel.sisvita17.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EspecialistaRepository {
    fun registrarEspecialista(nombre: String, apellidos: String,
                              correo: String, contrasena: String, ubigeo:Int
                              , titulo_id : Int
                              ,callback: (RegistrarUsuarioResponse?) -> Unit){
        val registrarEspecialistaRequest = RegistrarEspecialistaRequest(
            nombre=nombre, apellidos = apellidos,
            correo_electronico = correo, contrasena = contrasena , ubigeo = ubigeo,
            titulo_id = titulo_id
        )

        RetrofitClient.apiService.registrarEspecialista(registrarEspecialistaRequest).enqueue(
            object : Callback<RegistrarUsuarioResponse>{
                override fun onResponse(call: Call<RegistrarUsuarioResponse>, response: Response<RegistrarUsuarioResponse>) {
                    callback(response.body())
                }

                override fun onFailure(call: Call<RegistrarUsuarioResponse>, t:Throwable) {
                    callback(null)
                }
            })
    }
    fun getTitulos(callback: (TituloResponse?) -> Unit) {
        RetrofitClient.apiService.getTitulos().enqueue(object :
            Callback<TituloResponse> {
            override fun onResponse(
                call: Call<TituloResponse>,
                response: Response<TituloResponse>
            ) {
                callback(response.body())
            }

            override fun onFailure(call: Call<TituloResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}