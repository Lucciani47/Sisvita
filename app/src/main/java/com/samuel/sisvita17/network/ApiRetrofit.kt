package com.samuel.sisvita17.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
fun getRetrofit(): Retrofit {
    val client = OkHttpClient.Builder().build()
    return Retrofit.Builder()
        .baseUrl("hhttps://backend-zlo2.onrender.com/api/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}
*/