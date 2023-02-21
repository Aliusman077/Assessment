package com.example.assessmenttask.retrofit.api

import com.example.assessmenttask.retrofit.model.Cat
import retrofit2.Call
import retrofit2.http.GET

interface CatInterface {
    @GET("fact")
    fun getCatFact(): Call<Cat>
}