package com.example.myapplication.retrofit_destinasi

import com.example.myapplication.model.DestinasiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndPoint {

    @GET("destination/")
    fun getData(): Call<DestinasiModel>

}