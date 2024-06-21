package com.samuel.sisvita17.services

import android.util.Log
import com.samuel.sisvita17.data.response.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.POST

/*
interface ApiService {
    @POST("auth/public-access")
    suspend fun getResponse(): Response<ApiResponse>
}
fun getResponse() {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = getRetrofit().create(ApiService::class.java).getResponse()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body()?.let { Log.i("MainActivity", it.message) }
                } else {
                    Log.e("MainActivity", "Error: ${response.errorBody()?.string()}")
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.e("MainActivity", "Exception: ${e.message}")
            }
        }
    }
}*/