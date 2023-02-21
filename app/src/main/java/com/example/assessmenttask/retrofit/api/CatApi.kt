package com.example.assessmenttask.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatApi {

    private val baseUrlApi = "https://catfact.ninja/"

    val retrofit : CatInterface by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrlApi)
            .build().create(CatInterface::class.java)
    }
}