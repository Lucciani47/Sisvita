package com.samuel.sisvita17.network

import com.samuel.sisvita17.data.model.LoginRequest
import com.samuel.sisvita17.data.model.LoginResponse
import com.samuel.sisvita17.data.model.RegistrarEspecialistaRequest
import com.samuel.sisvita17.data.model.RegistrarUsuarioRequest
import com.samuel.sisvita17.data.model.RegistrarUsuarioResponse
import com.samuel.sisvita17.data.model.TestAllResponse
import com.samuel.sisvita17.data.model.TestListResponse
import com.samuel.sisvita17.data.model.TestRequest
import com.samuel.sisvita17.data.model.TestResponse
import com.samuel.sisvita17.data.model.TituloResponse
import com.samuel.sisvita17.data.model.UsuarioResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("usuarios/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
    @POST("usuarios")
    fun registrarUsuario(@Body registrarUsuarioRequest: RegistrarUsuarioRequest): Call<RegistrarUsuarioResponse>
    @POST("especialistas")
    fun registrarEspecialista(@Body registrarEspecialistaRequest: RegistrarEspecialistaRequest): Call<RegistrarUsuarioResponse>
    @GET("PruebaEvaluacion")
    fun getTests(): Call<TestListResponse>
    @GET("titulo")
    fun getTitulos(): Call<TituloResponse>
    @GET("test/all/{testId}")
    fun getTestById(@Path("testId") testId: Int): Call<TestAllResponse>
    @GET("usuarios/{usuario_id}")
    fun getUsuario(@Path("usuario_id") usuario_id:Int): Call<UsuarioResponse>
    @POST("test/responder")
    fun setRespuestaTest(@Body testRequest: TestRequest): Call<TestResponse>
}