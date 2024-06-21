package com.samuel.sisvita17.services

import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.samuel.sisvita17.data.model.User
import com.samuel.sisvita17.data.request.LoginRequest
import com.samuel.sisvita17.data.response.LoginResponse
import com.samuel.sisvita17.network.ApiClient
import com.samuel.sisvita17.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
/*
interface LoginService {
    @POST("usuarios/")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}*/

fun getJwt(username: String, password: String, navController: NavController) {
    val apiService = ApiClient.getRetrofitInstance().create(ApiService::class.java)
    val call = apiService.users

    call.enqueue(object : Callback<List<User>> {
        override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    var loginSuccess = false

                    users?.let {
                        for (user in it) {
                            if (user.username == username && user.password == password) {
                                loginSuccess = true
                                break
                            }
                        }
                    }

                    if (loginSuccess) {
                        navController.navigate("menu")
                        /*Toast.makeText("Main Activity", "Logeado satisfactoriamente", Toast.LENGTH_SHORT).show()*/
                        /*when (userRole) {
                            "alumno" -> {
                                val intent = Intent(this@MainActivity, InicioUser::class.java)
                                startActivity(intent)
                            }
                            "especialista" -> {
                                val intent = Intent(this@MainActivity, InicioEspecialista::class.java)
                                startActivity(intent)
                            }
                            else -> {
                                Toast.makeText(this@MainActivity, "Rol de usuario desconocido", Toast.LENGTH_SHORT).show()
                            }
                        }*/
                    } /*else {
                        Toast.makeText(this@MainActivity, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show()
                    }*/
                } /*else {
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }*/
            }

        override fun onFailure(call: Call<List<User>>, t: Throwable) {
            TODO("Not yet implemented")
        }

        /*override fun onFailure(call: Call<List<User>>, t: Throwable) {
            Toast.makeText(this@MainActivity, "Request failed: ${t.message}", Toast.LENGTH_SHORT).show()
        }*/
        }
    )
}