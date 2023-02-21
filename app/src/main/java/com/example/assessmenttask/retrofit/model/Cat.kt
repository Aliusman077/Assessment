package com.example.assessmenttask.retrofit.model

import com.google.gson.annotations.SerializedName


data class Cat (

  @SerializedName("fact"   ) var fact   : String? = null,
  @SerializedName("length" ) var length : Int?    = null

)