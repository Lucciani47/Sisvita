package com.samuel.sisvita17.network

import com.samuel.sisvita17.data.model.request.LoginRequest
import com.samuel.sisvita17.data.model.request.RegistrarDiagnosticoRequest
import com.samuel.sisvita17.data.model.response.LoginResponse
import com.samuel.sisvita17.data.model.request.RegistrarEspecialistaRequest
import com.samuel.sisvita17.data.model.request.RegistrarUsuarioRequest
import com.samuel.sisvita17.data.model.response.RegistrarUsuarioResponse
import com.samuel.sisvita17.data.model.response.TestAllResponse
import com.samuel.sisvita17.data.model.response.TestListResponse
import com.samuel.sisvita17.data.model.request.TestRequest
import com.samuel.sisvita17.data.model.response.AnsiedadSemaforoResponse
import com.samuel.sisvita17.data.model.response.EvaluarTestDataResponse
import com.samuel.sisvita17.data.model.response.NivelAnsiedadResponse
import com.samuel.sisvita17.data.model.response.RegistrarDiagnosticoResponse
import com.samuel.sisvita17.data.model.response.TestResponse
import com.samuel.sisvita17.data.model.response.TituloResponse
import com.samuel.sisvita17.data.model.response.TratamientosResponse
import com.samuel.sisvita17.data.model.response.UsuarioResponse
import com.samuel.sisvita17.data.model.response.VigilanciaResponse
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
    @POST("pruebas/responder")
    fun setRespuestaTest(@Body testRequest: TestRequest): Call<TestResponse>
    @POST("diagnostico")
    fun setDiagnostico(@Body registrarDiagnosticoRequest: RegistrarDiagnosticoRequest): Call<RegistrarDiagnosticoResponse>
    @GET("titulo")
    fun getTitulos(): Call<TituloResponse>
    @GET("pruebas")
    fun getTests(): Call<TestListResponse>
    @GET("pruebas/vigilancia")
    fun getVigilancia(): Call<VigilanciaResponse>
    @GET("pruebas/vigilancia/{res_user_id}")
    fun getVigilanciabyId(@Path("res_user_id") res_user_id:Int): Call<EvaluarTestDataResponse>
    @GET("pruebas/all/{prueba_id}")
    fun getTestById(@Path("prueba_id") prueba_id: Int): Call<TestAllResponse>
    @GET("usuarios/{usuario_id}")
    fun getUsuario(@Path("usuario_id") usuario_id:Int): Call<UsuarioResponse>
    @GET("ansiedad")
    fun getNivelAnsiedad():Call<NivelAnsiedadResponse>
    @GET("ansiedad-semaforo")
    fun getAnsiedadSemaforo(): Call<AnsiedadSemaforoResponse>
    @GET("tratamientos")
    fun getTratamientos():Call<TratamientosResponse>
}
